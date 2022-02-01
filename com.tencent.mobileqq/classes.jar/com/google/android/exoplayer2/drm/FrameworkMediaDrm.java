package com.google.android.exoplayer2.drm;

import android.annotation.TargetApi;
import android.media.MediaCrypto;
import android.media.MediaDrm;
import android.media.MediaDrm.KeyRequest;
import android.media.MediaDrm.ProvisionRequest;
import android.media.UnsupportedSchemeException;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@TargetApi(23)
public final class FrameworkMediaDrm
  implements ExoMediaDrm<FrameworkMediaCrypto>
{
  private final MediaDrm mediaDrm;
  private final UUID uuid;
  
  private FrameworkMediaDrm(UUID paramUUID)
  {
    Assertions.checkNotNull(paramUUID);
    Assertions.checkArgument(C.COMMON_PSSH_UUID.equals(paramUUID) ^ true, "Use C.CLEARKEY_UUID instead");
    UUID localUUID = paramUUID;
    if (Util.SDK_INT < 27)
    {
      localUUID = paramUUID;
      if (C.CLEARKEY_UUID.equals(paramUUID)) {
        localUUID = C.COMMON_PSSH_UUID;
      }
    }
    this.uuid = localUUID;
    this.mediaDrm = new MediaDrm(localUUID);
  }
  
  public static FrameworkMediaDrm newInstance(UUID paramUUID)
  {
    try
    {
      paramUUID = new FrameworkMediaDrm(paramUUID);
      return paramUUID;
    }
    catch (Exception paramUUID)
    {
      throw new UnsupportedDrmException(2, paramUUID);
    }
    catch (UnsupportedSchemeException paramUUID)
    {
      throw new UnsupportedDrmException(1, paramUUID);
    }
  }
  
  public void closeSession(byte[] paramArrayOfByte)
  {
    this.mediaDrm.closeSession(paramArrayOfByte);
  }
  
  public FrameworkMediaCrypto createMediaCrypto(byte[] paramArrayOfByte)
  {
    boolean bool;
    if ((Util.SDK_INT < 21) && (C.WIDEVINE_UUID.equals(this.uuid)) && ("L3".equals(getPropertyString("securityLevel")))) {
      bool = true;
    } else {
      bool = false;
    }
    return new FrameworkMediaCrypto(new MediaCrypto(this.uuid, paramArrayOfByte), bool);
  }
  
  public ExoMediaDrm.KeyRequest getKeyRequest(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, String paramString, int paramInt, HashMap<String, String> paramHashMap)
  {
    paramArrayOfByte1 = this.mediaDrm.getKeyRequest(paramArrayOfByte1, paramArrayOfByte2, paramString, paramInt, paramHashMap);
    return new ExoMediaDrm.DefaultKeyRequest(paramArrayOfByte1.getData(), paramArrayOfByte1.getDefaultUrl());
  }
  
  public byte[] getPropertyByteArray(String paramString)
  {
    return this.mediaDrm.getPropertyByteArray(paramString);
  }
  
  public String getPropertyString(String paramString)
  {
    return this.mediaDrm.getPropertyString(paramString);
  }
  
  public ExoMediaDrm.ProvisionRequest getProvisionRequest()
  {
    MediaDrm.ProvisionRequest localProvisionRequest = this.mediaDrm.getProvisionRequest();
    return new ExoMediaDrm.DefaultProvisionRequest(localProvisionRequest.getData(), localProvisionRequest.getDefaultUrl());
  }
  
  public byte[] openSession()
  {
    return this.mediaDrm.openSession();
  }
  
  public byte[] provideKeyResponse(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    return this.mediaDrm.provideKeyResponse(paramArrayOfByte1, paramArrayOfByte2);
  }
  
  public void provideProvisionResponse(byte[] paramArrayOfByte)
  {
    this.mediaDrm.provideProvisionResponse(paramArrayOfByte);
  }
  
  public Map<String, String> queryKeyStatus(byte[] paramArrayOfByte)
  {
    return this.mediaDrm.queryKeyStatus(paramArrayOfByte);
  }
  
  public void release()
  {
    this.mediaDrm.release();
  }
  
  public void restoreKeys(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    this.mediaDrm.restoreKeys(paramArrayOfByte1, paramArrayOfByte2);
  }
  
  public void setOnEventListener(ExoMediaDrm.OnEventListener<? super FrameworkMediaCrypto> paramOnEventListener)
  {
    MediaDrm localMediaDrm = this.mediaDrm;
    if (paramOnEventListener == null) {
      paramOnEventListener = null;
    } else {
      paramOnEventListener = new FrameworkMediaDrm.1(this, paramOnEventListener);
    }
    localMediaDrm.setOnEventListener(paramOnEventListener);
  }
  
  public void setOnKeyStatusChangeListener(ExoMediaDrm.OnKeyStatusChangeListener<? super FrameworkMediaCrypto> paramOnKeyStatusChangeListener)
  {
    if (Util.SDK_INT >= 23)
    {
      MediaDrm localMediaDrm = this.mediaDrm;
      if (paramOnKeyStatusChangeListener == null) {
        paramOnKeyStatusChangeListener = null;
      } else {
        paramOnKeyStatusChangeListener = new FrameworkMediaDrm.2(this, paramOnKeyStatusChangeListener);
      }
      localMediaDrm.setOnKeyStatusChangeListener(paramOnKeyStatusChangeListener, null);
      return;
    }
    throw new UnsupportedOperationException();
  }
  
  public void setPropertyByteArray(String paramString, byte[] paramArrayOfByte)
  {
    this.mediaDrm.setPropertyByteArray(paramString, paramArrayOfByte);
  }
  
  public void setPropertyString(String paramString1, String paramString2)
  {
    this.mediaDrm.setPropertyString(paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.drm.FrameworkMediaDrm
 * JD-Core Version:    0.7.0.1
 */