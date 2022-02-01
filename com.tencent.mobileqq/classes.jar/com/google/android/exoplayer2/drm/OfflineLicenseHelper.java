package com.google.android.exoplayer2.drm;

import android.os.ConditionVariable;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Pair;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.upstream.HttpDataSource.Factory;
import com.google.android.exoplayer2.util.Assertions;
import java.util.HashMap;
import java.util.UUID;

public final class OfflineLicenseHelper<T extends ExoMediaCrypto>
{
  private final ConditionVariable conditionVariable;
  private final DefaultDrmSessionManager<T> drmSessionManager;
  private final HandlerThread handlerThread = new HandlerThread("OfflineLicenseHelper");
  
  public OfflineLicenseHelper(UUID paramUUID, ExoMediaDrm<T> paramExoMediaDrm, MediaDrmCallback paramMediaDrmCallback, HashMap<String, String> paramHashMap)
  {
    this.handlerThread.start();
    this.conditionVariable = new ConditionVariable();
    OfflineLicenseHelper.1 local1 = new OfflineLicenseHelper.1(this);
    this.drmSessionManager = new DefaultDrmSessionManager(paramUUID, paramExoMediaDrm, paramMediaDrmCallback, paramHashMap, new Handler(this.handlerThread.getLooper()), local1);
  }
  
  private byte[] blockingKeyRequest(int paramInt, byte[] paramArrayOfByte, DrmInitData paramDrmInitData)
  {
    paramArrayOfByte = openBlockingKeyRequest(paramInt, paramArrayOfByte, paramDrmInitData);
    paramDrmInitData = paramArrayOfByte.getError();
    byte[] arrayOfByte = paramArrayOfByte.getOfflineLicenseKeySetId();
    this.drmSessionManager.releaseSession(paramArrayOfByte);
    if (paramDrmInitData == null) {
      return arrayOfByte;
    }
    throw paramDrmInitData;
  }
  
  public static OfflineLicenseHelper<FrameworkMediaCrypto> newWidevineInstance(String paramString, HttpDataSource.Factory paramFactory)
  {
    return newWidevineInstance(paramString, false, paramFactory, null);
  }
  
  public static OfflineLicenseHelper<FrameworkMediaCrypto> newWidevineInstance(String paramString, boolean paramBoolean, HttpDataSource.Factory paramFactory)
  {
    return newWidevineInstance(paramString, paramBoolean, paramFactory, null);
  }
  
  public static OfflineLicenseHelper<FrameworkMediaCrypto> newWidevineInstance(String paramString, boolean paramBoolean, HttpDataSource.Factory paramFactory, HashMap<String, String> paramHashMap)
  {
    return new OfflineLicenseHelper(C.WIDEVINE_UUID, FrameworkMediaDrm.newInstance(C.WIDEVINE_UUID), new HttpMediaDrmCallback(paramString, paramBoolean, paramFactory), paramHashMap);
  }
  
  private DrmSession<T> openBlockingKeyRequest(int paramInt, byte[] paramArrayOfByte, DrmInitData paramDrmInitData)
  {
    this.drmSessionManager.setMode(paramInt, paramArrayOfByte);
    this.conditionVariable.close();
    paramArrayOfByte = this.drmSessionManager.acquireSession(this.handlerThread.getLooper(), paramDrmInitData);
    this.conditionVariable.block();
    return paramArrayOfByte;
  }
  
  public byte[] downloadLicense(DrmInitData paramDrmInitData)
  {
    boolean bool;
    if (paramDrmInitData != null) {
      bool = true;
    } else {
      bool = false;
    }
    try
    {
      Assertions.checkArgument(bool);
      paramDrmInitData = blockingKeyRequest(2, null, paramDrmInitData);
      return paramDrmInitData;
    }
    finally
    {
      paramDrmInitData = finally;
      throw paramDrmInitData;
    }
  }
  
  public Pair<Long, Long> getLicenseDurationRemainingSec(byte[] paramArrayOfByte)
  {
    try
    {
      Assertions.checkNotNull(paramArrayOfByte);
      paramArrayOfByte = openBlockingKeyRequest(1, paramArrayOfByte, null);
      DrmSession.DrmSessionException localDrmSessionException = paramArrayOfByte.getError();
      Pair localPair = WidevineUtil.getLicenseDurationRemainingSec(paramArrayOfByte);
      this.drmSessionManager.releaseSession(paramArrayOfByte);
      if (localDrmSessionException != null)
      {
        if ((localDrmSessionException.getCause() instanceof KeysExpiredException))
        {
          paramArrayOfByte = Pair.create(Long.valueOf(0L), Long.valueOf(0L));
          return paramArrayOfByte;
        }
        throw localDrmSessionException;
      }
      return localPair;
    }
    finally {}
  }
  
  public byte[] getPropertyByteArray(String paramString)
  {
    try
    {
      paramString = this.drmSessionManager.getPropertyByteArray(paramString);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public String getPropertyString(String paramString)
  {
    try
    {
      paramString = this.drmSessionManager.getPropertyString(paramString);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void release()
  {
    this.handlerThread.quit();
  }
  
  public void releaseLicense(byte[] paramArrayOfByte)
  {
    try
    {
      Assertions.checkNotNull(paramArrayOfByte);
      blockingKeyRequest(3, paramArrayOfByte, null);
      return;
    }
    finally
    {
      paramArrayOfByte = finally;
      throw paramArrayOfByte;
    }
  }
  
  public byte[] renewLicense(byte[] paramArrayOfByte)
  {
    try
    {
      Assertions.checkNotNull(paramArrayOfByte);
      paramArrayOfByte = blockingKeyRequest(2, paramArrayOfByte, null);
      return paramArrayOfByte;
    }
    finally
    {
      paramArrayOfByte = finally;
      throw paramArrayOfByte;
    }
  }
  
  public void setPropertyByteArray(String paramString, byte[] paramArrayOfByte)
  {
    try
    {
      this.drmSessionManager.setPropertyByteArray(paramString, paramArrayOfByte);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void setPropertyString(String paramString1, String paramString2)
  {
    try
    {
      this.drmSessionManager.setPropertyString(paramString1, paramString2);
      return;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.drm.OfflineLicenseHelper
 * JD-Core Version:    0.7.0.1
 */