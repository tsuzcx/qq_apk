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
    Assertions.checkArgument(C.COMMON_PSSH_UUID.equals(paramUUID) ^ true, "Use C.CLEARKEY_UUID instead");
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
  }
  
  private static DrmInitData.SchemeData getSchemeData(DrmInitData paramDrmInitData, UUID paramUUID, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList(paramDrmInitData.schemeDataCount);
    int i = 0;
    int j;
    for (;;)
    {
      j = paramDrmInitData.schemeDataCount;
      int k = 1;
      if (i >= j) {
        break;
      }
      DrmInitData.SchemeData localSchemeData = paramDrmInitData.get(i);
      j = k;
      if (!localSchemeData.matches(paramUUID)) {
        if ((C.CLEARKEY_UUID.equals(paramUUID)) && (localSchemeData.matches(C.COMMON_PSSH_UUID))) {
          j = k;
        } else {
          j = 0;
        }
      }
      if ((j != 0) && ((localSchemeData.data != null) || (paramBoolean))) {
        localArrayList.add(localSchemeData);
      }
      i += 1;
    }
    if (localArrayList.isEmpty()) {
      return null;
    }
    if (C.WIDEVINE_UUID.equals(paramUUID))
    {
      i = 0;
      while (i < localArrayList.size())
      {
        paramDrmInitData = (DrmInitData.SchemeData)localArrayList.get(i);
        if (paramDrmInitData.hasData()) {
          j = PsshAtomUtil.parseVersion(paramDrmInitData.data);
        } else {
          j = -1;
        }
        if ((Util.SDK_INT < 23) && (j == 0)) {
          return paramDrmInitData;
        }
        if ((Util.SDK_INT >= 23) && (j == 1)) {
          return paramDrmInitData;
        }
        i += 1;
      }
    }
    return (DrmInitData.SchemeData)localArrayList.get(0);
  }
  
  private static byte[] getSchemeInitData(DrmInitData.SchemeData paramSchemeData, UUID paramUUID)
  {
    byte[] arrayOfByte = paramSchemeData.data;
    paramSchemeData = arrayOfByte;
    if (Util.SDK_INT < 21)
    {
      paramSchemeData = PsshAtomUtil.parseSchemeSpecificData(arrayOfByte, paramUUID);
      if (paramSchemeData == null) {
        return arrayOfByte;
      }
    }
    return paramSchemeData;
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
    if (!TextUtils.isEmpty(paramString))
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("PRCustomData", paramString);
      paramString = localHashMap;
    }
    else
    {
      paramString = null;
    }
    return newFrameworkInstance(C.PLAYREADY_UUID, paramMediaDrmCallback, paramString, paramHandler, paramEventListener);
  }
  
  public static DefaultDrmSessionManager<FrameworkMediaCrypto> newWidevineInstance(MediaDrmCallback paramMediaDrmCallback, HashMap<String, String> paramHashMap, Handler paramHandler, DefaultDrmSessionManager.EventListener paramEventListener)
  {
    return newFrameworkInstance(C.WIDEVINE_UUID, paramMediaDrmCallback, paramHashMap, paramHandler, paramEventListener);
  }
  
  public DrmSession<T> acquireSession(Looper paramLooper, DrmInitData paramDrmInitData)
  {
    Object localObject1 = this.playbackLooper;
    boolean bool;
    if ((localObject1 != null) && (localObject1 != paramLooper)) {
      bool = false;
    } else {
      bool = true;
    }
    Assertions.checkState(bool);
    if (this.sessions.isEmpty())
    {
      this.playbackLooper = paramLooper;
      if (this.mediaDrmHandler == null) {
        this.mediaDrmHandler = new DefaultDrmSessionManager.MediaDrmHandler(this, paramLooper);
      }
    }
    localObject1 = this.offlineLicenseKeySetId;
    Object localObject3 = null;
    Object localObject2;
    if (localObject1 == null)
    {
      paramDrmInitData = getSchemeData(paramDrmInitData, this.uuid, false);
      if (paramDrmInitData == null)
      {
        paramLooper = new DefaultDrmSessionManager.MissingSchemeDataException(this.uuid, null);
        paramDrmInitData = this.eventHandler;
        if ((paramDrmInitData != null) && (this.eventListener != null)) {
          paramDrmInitData.post(new DefaultDrmSessionManager.1(this, paramLooper));
        }
        return new ErrorStateDrmSession(new DrmSession.DrmSessionException(paramLooper));
      }
      localObject1 = getSchemeInitData(paramDrmInitData, this.uuid);
      localObject2 = getSchemeMimeType(paramDrmInitData, this.uuid);
    }
    else
    {
      localObject1 = null;
      localObject2 = localObject1;
    }
    if (!this.multiSession)
    {
      if (this.sessions.isEmpty()) {
        paramDrmInitData = localObject3;
      } else {
        paramDrmInitData = (DefaultDrmSession)this.sessions.get(0);
      }
    }
    else
    {
      Iterator localIterator = this.sessions.iterator();
      do
      {
        paramDrmInitData = localObject3;
        if (!localIterator.hasNext()) {
          break;
        }
        paramDrmInitData = (DefaultDrmSession)localIterator.next();
      } while (!paramDrmInitData.hasInitData((byte[])localObject1));
    }
    if (paramDrmInitData == null)
    {
      paramDrmInitData = new DefaultDrmSession(this.uuid, this.mediaDrm, this, (byte[])localObject1, (String)localObject2, this.mode, this.offlineLicenseKeySetId, this.optionalKeyRequestParameters, this.callback, paramLooper, this.eventHandler, this.eventListener, this.initialDrmRequestRetryCount);
      this.sessions.add(paramDrmInitData);
    }
    paramDrmInitData.acquire();
    return paramDrmInitData;
  }
  
  public boolean canAcquireSession(@NonNull DrmInitData paramDrmInitData)
  {
    Object localObject = this.offlineLicenseKeySetId;
    boolean bool = true;
    if (localObject != null) {
      return true;
    }
    if (getSchemeData(paramDrmInitData, this.uuid, true) == null) {
      if ((paramDrmInitData.schemeDataCount == 1) && (paramDrmInitData.get(0).matches(C.COMMON_PSSH_UUID)))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("DrmInitData only contains common PSSH SchemeData. Assuming support for: ");
        ((StringBuilder)localObject).append(this.uuid);
        Log.w("DefaultDrmSessionMgr", ((StringBuilder)localObject).toString());
      }
      else
      {
        return false;
      }
    }
    paramDrmInitData = paramDrmInitData.schemeType;
    if (paramDrmInitData != null)
    {
      if ("cenc".equals(paramDrmInitData)) {
        return true;
      }
      if ((!"cbc1".equals(paramDrmInitData)) && (!"cbcs".equals(paramDrmInitData)) && (!"cens".equals(paramDrmInitData))) {
        return true;
      }
      if (Util.SDK_INT >= 24) {
        return true;
      }
      bool = false;
    }
    return bool;
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
    if ((paramDrmSession instanceof ErrorStateDrmSession)) {
      return;
    }
    paramDrmSession = (DefaultDrmSession)paramDrmSession;
    if (paramDrmSession.release())
    {
      this.sessions.remove(paramDrmSession);
      if ((this.provisioningSessions.size() > 1) && (this.provisioningSessions.get(0) == paramDrmSession)) {
        ((DefaultDrmSession)this.provisioningSessions.get(1)).provision();
      }
      this.provisioningSessions.remove(paramDrmSession);
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.drm.DefaultDrmSessionManager
 * JD-Core Version:    0.7.0.1
 */