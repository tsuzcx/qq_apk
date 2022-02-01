package com.google.android.exoplayer2.drm;

import android.annotation.TargetApi;
import android.media.NotProvisionedException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.Pair;
import com.google.android.exoplayer2.C;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@TargetApi(18)
class DefaultDrmSession<T extends ExoMediaCrypto>
  implements DrmSession<T>
{
  private static final int MAX_LICENSE_DURATION_TO_RENEW = 60;
  private static final int MSG_KEYS = 1;
  private static final int MSG_PROVISION = 0;
  private static final String TAG = "DefaultDrmSession";
  final MediaDrmCallback callback;
  private final Handler eventHandler;
  private final DefaultDrmSessionManager.EventListener eventListener;
  private final byte[] initData;
  private final int initialDrmRequestRetryCount;
  private DrmSession.DrmSessionException lastException;
  private T mediaCrypto;
  private final ExoMediaDrm<T> mediaDrm;
  private final String mimeType;
  private final int mode;
  private byte[] offlineLicenseKeySetId;
  private int openCount;
  private final HashMap<String, String> optionalKeyRequestParameters;
  private DefaultDrmSession<T>.PostRequestHandler postRequestHandler;
  final DefaultDrmSession<T>.PostResponseHandler postResponseHandler;
  private final DefaultDrmSession.ProvisioningManager<T> provisioningManager;
  private HandlerThread requestHandlerThread;
  private byte[] sessionId;
  private int state;
  final UUID uuid;
  
  public DefaultDrmSession(UUID paramUUID, ExoMediaDrm<T> paramExoMediaDrm, DefaultDrmSession.ProvisioningManager<T> paramProvisioningManager, byte[] paramArrayOfByte1, String paramString, int paramInt1, byte[] paramArrayOfByte2, HashMap<String, String> paramHashMap, MediaDrmCallback paramMediaDrmCallback, Looper paramLooper, Handler paramHandler, DefaultDrmSessionManager.EventListener paramEventListener, int paramInt2)
  {
    this.uuid = paramUUID;
    this.provisioningManager = paramProvisioningManager;
    this.mediaDrm = paramExoMediaDrm;
    this.mode = paramInt1;
    this.offlineLicenseKeySetId = paramArrayOfByte2;
    this.optionalKeyRequestParameters = paramHashMap;
    this.callback = paramMediaDrmCallback;
    this.initialDrmRequestRetryCount = paramInt2;
    this.eventHandler = paramHandler;
    this.eventListener = paramEventListener;
    this.state = 2;
    this.postResponseHandler = new DefaultDrmSession.PostResponseHandler(this, paramLooper);
    this.requestHandlerThread = new HandlerThread("DrmRequestHandler");
    this.requestHandlerThread.start();
    this.postRequestHandler = new DefaultDrmSession.PostRequestHandler(this, this.requestHandlerThread.getLooper());
    if (paramArrayOfByte2 == null)
    {
      this.initData = paramArrayOfByte1;
      this.mimeType = paramString;
      return;
    }
    this.initData = null;
    this.mimeType = null;
  }
  
  private void doLicense(boolean paramBoolean)
  {
    switch (this.mode)
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if (this.offlineLicenseKeySetId == null)
            {
              postKeyRequest(1, paramBoolean);
              return;
            }
          } while ((this.state != 4) && (!restoreKeys()));
          long l = getLicenseDurationRemainingSec();
          if ((this.mode == 0) && (l <= 60L))
          {
            Log.d("DefaultDrmSession", "Offline license has expired or will expire soon. Remaining seconds: " + l);
            postKeyRequest(2, paramBoolean);
            return;
          }
          if (l <= 0L)
          {
            onError(new KeysExpiredException());
            return;
          }
          this.state = 4;
        } while ((this.eventHandler == null) || (this.eventListener == null));
        this.eventHandler.post(new DefaultDrmSession.1(this));
        return;
        if (this.offlineLicenseKeySetId == null)
        {
          postKeyRequest(2, paramBoolean);
          return;
        }
      } while (!restoreKeys());
      postKeyRequest(2, paramBoolean);
      return;
    } while (!restoreKeys());
    postKeyRequest(3, paramBoolean);
  }
  
  private long getLicenseDurationRemainingSec()
  {
    if (!C.WIDEVINE_UUID.equals(this.uuid)) {
      return 9223372036854775807L;
    }
    Pair localPair = WidevineUtil.getLicenseDurationRemainingSec(this);
    return Math.min(((Long)localPair.first).longValue(), ((Long)localPair.second).longValue());
  }
  
  private boolean isOpen()
  {
    return (this.state == 3) || (this.state == 4);
  }
  
  private void onError(Exception paramException)
  {
    this.lastException = new DrmSession.DrmSessionException(paramException);
    if ((this.eventHandler != null) && (this.eventListener != null)) {
      this.eventHandler.post(new DefaultDrmSession.4(this, paramException));
    }
    if (this.state != 4) {
      this.state = 1;
    }
  }
  
  private void onKeyResponse(Object paramObject)
  {
    if (!isOpen()) {}
    do
    {
      for (;;)
      {
        return;
        if ((paramObject instanceof Exception))
        {
          onKeysError((Exception)paramObject);
          return;
        }
        try
        {
          byte[] arrayOfByte = (byte[])paramObject;
          paramObject = arrayOfByte;
          if (C.CLEARKEY_UUID.equals(this.uuid)) {
            paramObject = ClearKeyUtil.adjustResponseData(arrayOfByte);
          }
          if (this.mode == 3)
          {
            this.mediaDrm.provideKeyResponse(this.offlineLicenseKeySetId, paramObject);
            if ((this.eventHandler == null) || (this.eventListener == null)) {
              continue;
            }
            this.eventHandler.post(new DefaultDrmSession.2(this));
          }
        }
        catch (Exception paramObject)
        {
          onKeysError(paramObject);
          return;
        }
      }
      paramObject = this.mediaDrm.provideKeyResponse(this.sessionId, paramObject);
      if (((this.mode == 2) || ((this.mode == 0) && (this.offlineLicenseKeySetId != null))) && (paramObject != null) && (paramObject.length != 0)) {
        this.offlineLicenseKeySetId = paramObject;
      }
      this.state = 4;
    } while ((this.eventHandler == null) || (this.eventListener == null));
    this.eventHandler.post(new DefaultDrmSession.3(this));
  }
  
  private void onKeysError(Exception paramException)
  {
    if ((paramException instanceof NotProvisionedException))
    {
      this.provisioningManager.provisionRequired(this);
      return;
    }
    onError(paramException);
  }
  
  private void onKeysExpired()
  {
    if (this.state == 4)
    {
      this.state = 3;
      onError(new KeysExpiredException());
    }
  }
  
  private void onProvisionResponse(Object paramObject)
  {
    if ((this.state != 2) && (!isOpen())) {
      return;
    }
    if ((paramObject instanceof Exception))
    {
      this.provisioningManager.onProvisionError((Exception)paramObject);
      return;
    }
    try
    {
      this.mediaDrm.provideProvisionResponse((byte[])paramObject);
      this.provisioningManager.onProvisionCompleted();
      return;
    }
    catch (Exception paramObject)
    {
      this.provisioningManager.onProvisionError(paramObject);
    }
  }
  
  private boolean openInternal(boolean paramBoolean)
  {
    if (isOpen()) {
      return true;
    }
    try
    {
      this.sessionId = this.mediaDrm.openSession();
      this.mediaCrypto = this.mediaDrm.createMediaCrypto(this.sessionId);
      this.state = 3;
      return true;
    }
    catch (NotProvisionedException localNotProvisionedException)
    {
      if (paramBoolean) {
        this.provisioningManager.provisionRequired(this);
      }
      for (;;)
      {
        return false;
        onError(localNotProvisionedException);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        onError(localException);
      }
    }
  }
  
  private void postKeyRequest(int paramInt, boolean paramBoolean)
  {
    Object localObject;
    if (paramInt == 3) {
      localObject = this.offlineLicenseKeySetId;
    }
    label99:
    for (;;)
    {
      try
      {
        localObject = this.mediaDrm.getKeyRequest((byte[])localObject, this.initData, this.mimeType, paramInt, this.optionalKeyRequestParameters);
        if (!C.CLEARKEY_UUID.equals(this.uuid)) {
          break label99;
        }
        localObject = new ExoMediaDrm.DefaultKeyRequest(ClearKeyUtil.adjustRequestData(((ExoMediaDrm.KeyRequest)localObject).getData()), ((ExoMediaDrm.KeyRequest)localObject).getDefaultUrl());
        this.postRequestHandler.obtainMessage(1, localObject, paramBoolean).sendToTarget();
        return;
      }
      catch (Exception localException)
      {
        onKeysError(localException);
        return;
      }
      localObject = this.sessionId;
    }
  }
  
  private boolean restoreKeys()
  {
    try
    {
      this.mediaDrm.restoreKeys(this.sessionId, this.offlineLicenseKeySetId);
      return true;
    }
    catch (Exception localException)
    {
      Log.e("DefaultDrmSession", "Error trying to restore Widevine keys.", localException);
      onError(localException);
    }
    return false;
  }
  
  public void acquire()
  {
    int i = this.openCount + 1;
    this.openCount = i;
    if ((i != 1) || (this.state == 1)) {}
    while (!openInternal(true)) {
      return;
    }
    doLicense(true);
  }
  
  public final DrmSession.DrmSessionException getError()
  {
    if (this.state == 1) {
      return this.lastException;
    }
    return null;
  }
  
  public final T getMediaCrypto()
  {
    return this.mediaCrypto;
  }
  
  public byte[] getOfflineLicenseKeySetId()
  {
    return this.offlineLicenseKeySetId;
  }
  
  public final int getState()
  {
    return this.state;
  }
  
  public boolean hasInitData(byte[] paramArrayOfByte)
  {
    return Arrays.equals(this.initData, paramArrayOfByte);
  }
  
  public boolean hasSessionId(byte[] paramArrayOfByte)
  {
    return Arrays.equals(this.sessionId, paramArrayOfByte);
  }
  
  public void onMediaDrmEvent(int paramInt)
  {
    if (!isOpen()) {
      return;
    }
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      this.state = 3;
      this.provisioningManager.provisionRequired(this);
      return;
    case 2: 
      doLicense(false);
      return;
    }
    onKeysExpired();
  }
  
  public void onProvisionCompleted()
  {
    if (openInternal(false)) {
      doLicense(true);
    }
  }
  
  public void onProvisionError(Exception paramException)
  {
    onError(paramException);
  }
  
  public void provision()
  {
    ExoMediaDrm.ProvisionRequest localProvisionRequest = this.mediaDrm.getProvisionRequest();
    this.postRequestHandler.obtainMessage(0, localProvisionRequest, true).sendToTarget();
  }
  
  public Map<String, String> queryKeyStatus()
  {
    if (this.sessionId == null) {
      return null;
    }
    return this.mediaDrm.queryKeyStatus(this.sessionId);
  }
  
  public boolean release()
  {
    boolean bool = false;
    int i = this.openCount - 1;
    this.openCount = i;
    if (i == 0)
    {
      this.state = 0;
      this.postResponseHandler.removeCallbacksAndMessages(null);
      this.postRequestHandler.removeCallbacksAndMessages(null);
      this.postRequestHandler = null;
      this.requestHandlerThread.quit();
      this.requestHandlerThread = null;
      this.mediaCrypto = null;
      this.lastException = null;
      if (this.sessionId != null)
      {
        this.mediaDrm.closeSession(this.sessionId);
        this.sessionId = null;
      }
      bool = true;
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.google.android.exoplayer2.drm.DefaultDrmSession
 * JD-Core Version:    0.7.0.1
 */