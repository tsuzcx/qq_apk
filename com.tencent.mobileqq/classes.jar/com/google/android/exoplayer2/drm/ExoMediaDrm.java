package com.google.android.exoplayer2.drm;

import android.annotation.TargetApi;
import java.util.HashMap;
import java.util.Map;

@TargetApi(18)
public abstract interface ExoMediaDrm<T extends ExoMediaCrypto>
{
  public static final int EVENT_KEY_EXPIRED = 3;
  public static final int EVENT_KEY_REQUIRED = 2;
  public static final int EVENT_PROVISION_REQUIRED = 1;
  public static final int KEY_TYPE_OFFLINE = 2;
  public static final int KEY_TYPE_RELEASE = 3;
  public static final int KEY_TYPE_STREAMING = 1;
  
  public abstract void closeSession(byte[] paramArrayOfByte);
  
  public abstract T createMediaCrypto(byte[] paramArrayOfByte);
  
  public abstract ExoMediaDrm.KeyRequest getKeyRequest(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, String paramString, int paramInt, HashMap<String, String> paramHashMap);
  
  public abstract byte[] getPropertyByteArray(String paramString);
  
  public abstract String getPropertyString(String paramString);
  
  public abstract ExoMediaDrm.ProvisionRequest getProvisionRequest();
  
  public abstract byte[] openSession();
  
  public abstract byte[] provideKeyResponse(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2);
  
  public abstract void provideProvisionResponse(byte[] paramArrayOfByte);
  
  public abstract Map<String, String> queryKeyStatus(byte[] paramArrayOfByte);
  
  public abstract void release();
  
  public abstract void restoreKeys(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2);
  
  public abstract void setOnEventListener(ExoMediaDrm.OnEventListener<? super T> paramOnEventListener);
  
  public abstract void setOnKeyStatusChangeListener(ExoMediaDrm.OnKeyStatusChangeListener<? super T> paramOnKeyStatusChangeListener);
  
  public abstract void setPropertyByteArray(String paramString, byte[] paramArrayOfByte);
  
  public abstract void setPropertyString(String paramString1, String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.exoplayer2.drm.ExoMediaDrm
 * JD-Core Version:    0.7.0.1
 */