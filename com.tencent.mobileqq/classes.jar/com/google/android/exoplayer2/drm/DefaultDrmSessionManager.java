package com.google.android.exoplayer2.drm;

import android.annotation.TargetApi;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.extractor.mp4.PsshAtomUtil;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

@TargetApi(18)
public class DefaultDrmSessionManager<T extends ExoMediaCrypto>
  implements DefaultDrmSession.ProvisioningManager<T>, DrmSessionManager<T>
{
  private static final String CENC_SCHEME_MIME_TYPE = "cenc";
  public static final int INITIAL_DRM_REQUEST_RETRY_COUNT = 3;
  public static final int MODE_DOWNLOAD = 2;
  public static final int MODE_PLAYBACK = 0;
  public static final int MODE_QUERY = 1;
  public static final int MODE_RELEASE = 3;
  public static final String PLAYREADY_CUSTOM_DATA_KEY = "PRCustomData";
  private static final String TAG = "DefaultDrmSessionMgr";
  private final MediaDrmCallback callback;
  private final Handler eventHandler;
  private final DefaultDrmSessionManager.EventListener eventListener;
  private final int initialDrmRequestRetryCount;
  private final ExoMediaDrm<T> mediaDrm;
  volatile DefaultDrmSessionManager<T>.MediaDrmHandler mediaDrmHandler;
  private int mode;
  private final boolean multiSession;
  private byte[] offlineLicenseKeySetId;
  private final HashMap<String, String> optionalKeyRequestParameters;
  private Looper playbackLooper;
  private final List<DefaultDrmSession<T>> provisioningSessions;
  private final List<DefaultDrmSession<T>> sessions;
  private final UUID uuid;
  
  public DefaultDrmSessionManager(UUID paramUUID, ExoMediaDrm<T> paramExoMediaDrm, MediaDrmCallback paramMediaDrmCallback, HashMap<String, String> paramHashMap, Handler paramHandler, DefaultDrmSessionManager.EventListener paramEventListener)
  {
    this(paramUUID, paramExoMediaDrm, paramMediaDrmCallback, paramHashMap, paramHandler, paramEventListener, false, 3);
  }
  
  public DefaultDrmSessionManager(UUID paramUUID, ExoMediaDrm<T> paramExoMediaDrm, MediaDrmCallback paramMediaDrmCallback, HashMap<String, String> paramHashMap, Handler paramHandler, DefaultDrmSessionManager.EventListener paramEventListener, boolean paramBoolean)
  {
    this(paramUUID, paramExoMediaDrm, paramMediaDrmCallback, paramHashMap, paramHandler, paramEventListener, paramBoolean, 3);
  }
  
  public DefaultDrmSessionManager(UUID paramUUID, ExoMediaDrm<T> paramExoMediaDrm, MediaDrmCallback paramMediaDrmCallback, HashMap<String, String> paramHashMap, Handler paramHandler, DefaultDrmSessionManager.EventListener paramEventListener, boolean paramBoolean, int paramInt)
  {
    Assertions.checkNotNull(paramUUID);
    Assertions.checkNotNull(paramExoMediaDrm);
    if (!C.COMMON_PSSH_UUID.equals(paramUUID)) {}
    for (boolean bool = true;; bool = false)
    {
      Assertions.checkArgument(bool, "Use C.CLEARKEY_UUID instead");
      this.uuid = paramUUID;
      this.mediaDrm = paramExoMediaDrm;
      this.callback = paramMediaDrmCallback;
      this.optionalKeyRequestParameters = paramHashMap;
      this.eventHandler = paramHandler;
      this.eventListener = paramEventListener;
      this.multiSession = paramBoolean;
      this.initialDrmRequestRetryCount = paramInt;
      this.mode = 0;
      this.sessions = new ArrayList();
      this.provisioningSessions = new ArrayList();
      if (paramBoolean) {
        paramExoMediaDrm.setPropertyString("sessionSharing", "enable");
      }
      paramExoMediaDrm.setOnEventListener(new DefaultDrmSessionManager.MediaDrmEventListener(this, null));
      return;
    }
  }
  
  private static DrmInitData.SchemeData getSchemeData(DrmInitData paramDrmInitData, UUID paramUUID, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList(paramDrmInitData.schemeDataCount);
    int i = 0;
    int j;
    if (i < paramDrmInitData.schemeDataCount)
    {
      DrmInitData.SchemeData localSchemeData = paramDrmInitData.get(i);
      if ((localSchemeData.matches(paramUUID)) || ((C.CLEARKEY_UUID.equals(paramUUID)) && (localSchemeData.matches(C.COMMON_PSSH_UUID)))) {}
      for (j = 1;; j = 0)
      {
        if ((j != 0) && ((localSchemeData.data != null) || (paramBoolean))) {
          localArrayList.add(localSchemeData);
        }
        i += 1;
        break;
      }
    }
    if (localArrayList.isEmpty())
    {
      paramDrmInitData = null;
      return paramDrmInitData;
    }
    if (C.WIDEVINE_UUID.equals(paramUUID))
    {
      i = 0;
      label129:
      if (i < localArrayList.size())
      {
        paramUUID = (DrmInitData.SchemeData)localArrayList.get(i);
        if (paramUUID.hasData()) {}
        for (j = PsshAtomUtil.parseVersion(paramUUID.data);; j = -1)
        {
          if (Util.SDK_INT < 23)
          {
            paramDrmInitData = paramUUID;
            if (j == 0) {
              break;
            }
          }
          if (Util.SDK_INT >= 23)
          {
            paramDrmInitData = paramUUID;
            if (j == 1) {
              break;
            }
          }
          i += 1;
          break label129;
        }
      }
    }
    return (DrmInitData.SchemeData)localArrayList.get(0);
  }
  
  private static byte[] getSchemeInitData(DrmInitData.SchemeData paramSchemeData, UUID paramUUID)
  {
    paramSchemeData = paramSchemeData.data;
    if (Util.SDK_INT < 21)
    {
      paramUUID = PsshAtomUtil.parseSchemeSpecificData(paramSchemeData, paramUUID);
      if (paramUUID != null) {}
    }
    else
    {
      return paramSchemeData;
    }
    return paramUUID;
  }
  
  private static String getSchemeMimeType(DrmInitData.SchemeData paramSchemeData, UUID paramUUID)
  {
    String str = paramSchemeData.mimeType;
    paramSchemeData = str;
    if (Util.SDK_INT < 26)
    {
      paramSchemeData = str;
      if (C.CLEARKEY_UUID.equals(paramUUID)) {
        if (!"video/mp4".equals(str))
        {
          paramSchemeData = str;
          if (!"audio/mp4".equals(str)) {}
        }
        else
        {
          paramSchemeData = "cenc";
        }
      }
    }
    return paramSchemeData;
  }
  
  public static DefaultDrmSessionManager<FrameworkMediaCrypto> newFrameworkInstance(UUID paramUUID, MediaDrmCallback paramMediaDrmCallback, HashMap<String, String> paramHashMap, Handler paramHandler, DefaultDrmSessionManager.EventListener paramEventListener)
  {
    return new DefaultDrmSessionManager(paramUUID, FrameworkMediaDrm.newInstance(paramUUID), paramMediaDrmCallback, paramHashMap, paramHandler, paramEventListener, false, 3);
  }
  
  public static DefaultDrmSessionManager<FrameworkMediaCrypto> newPlayReadyInstance(MediaDrmCallback paramMediaDrmCallback, String paramString, Handler paramHandler, DefaultDrmSessionManager.EventListener paramEventListener)
  {
    HashMap localHashMap;
    if (!TextUtils.isEmpty(paramString))
    {
      localHashMap = new HashMap();
      localHashMap.put("PRCustomData", paramString);
    }
    for (paramString = localHashMap;; paramString = null) {
      return newFrameworkInstance(C.PLAYREADY_UUID, paramMediaDrmCallback, paramString, paramHandler, paramEventListener);
    }
  }
  
  public static DefaultDrmSessionManager<FrameworkMediaCrypto> newWidevineInstance(MediaDrmCallback paramMediaDrmCallback, HashMap<String, String> paramHashMap, Handler paramHandler, DefaultDrmSessionManager.EventListener paramEventListener)
  {
    return newFrameworkInstance(C.WIDEVINE_UUID, paramMediaDrmCallback, paramHashMap, paramHandler, paramEventListener);
  }
  
  public DrmSession<T> acquireSession(Looper paramLooper, DrmInitData paramDrmInitData)
  {
    if ((this.playbackLooper == null) || (this.playbackLooper == paramLooper)) {}
    for (boolean bool = true;; bool = false)
    {
      Assertions.checkState(bool);
      if (this.sessions.isEmpty())
      {
        this.playbackLooper = paramLooper;
        if (this.mediaDrmHandler == null) {
          this.mediaDrmHandler = new DefaultDrmSessionManager.MediaDrmHandler(this, paramLooper);
        }
      }
      arrayOfByte = null;
      str = null;
      if (this.offlineLicenseKeySetId != null) {
        break label170;
      }
      paramDrmInitData = getSchemeData(paramDrmInitData, this.uuid, false);
      if (paramDrmInitData != null) {
        break;
      }
      paramLooper = new DefaultDrmSessionManager.MissingSchemeDataException(this.uuid, null);
      if ((this.eventHandler != null) && (this.eventListener != null)) {
        this.eventHandler.post(new DefaultDrmSessionManager.1(this, paramLooper));
      }
      return new ErrorStateDrmSession(new DrmSession.DrmSessionException(paramLooper));
    }
    byte[] arrayOfByte = getSchemeInitData(paramDrmInitData, this.uuid);
    String str = getSchemeMimeType(paramDrmInitData, this.uuid);
    label170:
    if (!this.multiSession) {
      if (this.sessions.isEmpty()) {
        paramDrmInitData = null;
      }
    }
    for (;;)
    {
      Object localObject = paramDrmInitData;
      if (paramDrmInitData == null)
      {
        localObject = new DefaultDrmSession(this.uuid, this.mediaDrm, this, arrayOfByte, str, this.mode, this.offlineLicenseKeySetId, this.optionalKeyRequestParameters, this.callback, paramLooper, this.eventHandler, this.eventListener, this.initialDrmRequestRetryCount);
        this.sessions.add(localObject);
      }
      ((DefaultDrmSession)localObject).acquire();
      return localObject;
      paramDrmInitData = (DefaultDrmSession)this.sessions.get(0);
      continue;
      localObject = this.sessions.iterator();
      for (;;)
      {
        if (((Iterator)localObject).hasNext())
        {
          paramDrmInitData = (DefaultDrmSession)((Iterator)localObject).next();
          if (paramDrmInitData.hasInitData(arrayOfByte)) {
            break;
          }
        }
      }
      paramDrmInitData = null;
    }
  }
  
  public boolean canAcquireSession(@NonNull DrmInitData paramDrmInitData)
  {
    if (this.offlineLicenseKeySetId != null) {}
    do
    {
      return true;
      if (getSchemeData(paramDrmInitData, this.uuid, true) == null)
      {
        if ((paramDrmInitData.schemeDataCount != 1) || (!paramDrmInitData.get(0).matches(C.COMMON_PSSH_UUID))) {
          break;
        }
        Log.w("DefaultDrmSessionMgr", "DrmInitData only contains common PSSH SchemeData. Assuming support for: " + this.uuid);
      }
      paramDrmInitData = paramDrmInitData.schemeType;
    } while ((paramDrmInitData == null) || ("cenc".equals(paramDrmInitData)) || ((!"cbc1".equals(paramDrmInitData)) && (!"cbcs".equals(paramDrmInitData)) && (!"cens".equals(paramDrmInitData))) || (Util.SDK_INT >= 24));
    return false;
    return false;
  }
  
  public final byte[] getPropertyByteArray(String paramString)
  {
    return this.mediaDrm.getPropertyByteArray(paramString);
  }
  
  public final String getPropertyString(String paramString)
  {
    return this.mediaDrm.getPropertyString(paramString);
  }
  
  public void onProvisionCompleted()
  {
    Iterator localIterator = this.provisioningSessions.iterator();
    while (localIterator.hasNext()) {
      ((DefaultDrmSession)localIterator.next()).onProvisionCompleted();
    }
    this.provisioningSessions.clear();
  }
  
  public void onProvisionError(Exception paramException)
  {
    Iterator localIterator = this.provisioningSessions.iterator();
    while (localIterator.hasNext()) {
      ((DefaultDrmSession)localIterator.next()).onProvisionError(paramException);
    }
    this.provisioningSessions.clear();
  }
  
  public void provisionRequired(DefaultDrmSession<T> paramDefaultDrmSession)
  {
    this.provisioningSessions.add(paramDefaultDrmSession);
    if (this.provisioningSessions.size() == 1) {
      paramDefaultDrmSession.provision();
    }
  }
  
  public void releaseSession(DrmSession<T> paramDrmSession)
  {
    if ((paramDrmSession instanceof ErrorStateDrmSession)) {}
    do
    {
      return;
      paramDrmSession = (DefaultDrmSession)paramDrmSession;
    } while (!paramDrmSession.release());
    this.sessions.remove(paramDrmSession);
    if ((this.provisioningSessions.size() > 1) && (this.provisioningSessions.get(0) == paramDrmSession)) {
      ((DefaultDrmSession)this.provisioningSessions.get(1)).provision();
    }
    this.provisioningSessions.remove(paramDrmSession);
  }
  
  public void setMode(int paramInt, byte[] paramArrayOfByte)
  {
    Assertions.checkState(this.sessions.isEmpty());
    if ((paramInt == 1) || (paramInt == 3)) {
      Assertions.checkNotNull(paramArrayOfByte);
    }
    this.mode = paramInt;
    this.offlineLicenseKeySetId = paramArrayOfByte;
  }
  
  public final void setPropertyByteArray(String paramString, byte[] paramArrayOfByte)
  {
    this.mediaDrm.setPropertyByteArray(paramString, paramArrayOfByte);
  }
  
  public final void setPropertyString(String paramString1, String paramString2)
  {
    this.mediaDrm.setPropertyString(paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.drm.DefaultDrmSessionManager
 * JD-Core Version:    0.7.0.1
 */