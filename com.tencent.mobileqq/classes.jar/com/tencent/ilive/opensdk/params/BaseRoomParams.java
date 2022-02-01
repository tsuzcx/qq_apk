package com.tencent.ilive.opensdk.params;

import java.lang.reflect.Field;

public class BaseRoomParams
{
  static final String TAG = "MediaPE|MediaRoomInfo";
  public int audioCategory = 0;
  public long authBits = -1L;
  public byte[] authBuffer = null;
  public int authEncryptionType = 1;
  public boolean autoCloseCamera = true;
  public boolean autoCreateRoom = true;
  public String bussInfo = "";
  public String controlRole = "";
  public boolean enableHdAudio = false;
  public boolean enableHwDec = true;
  public boolean enableHwEnc = true;
  public boolean enableMic = false;
  public boolean enableMultiRequestIplist = false;
  public boolean enableSpeaker = false;
  public int roomId;
  public int screenRecvMode = 0;
  public int videoRecvMode = 0;
  
  public BaseRoomParams(int paramInt)
  {
    this.roomId = paramInt;
  }
  
  public BaseRoomParams audioCategory(int paramInt)
  {
    this.audioCategory = paramInt;
    return this;
  }
  
  public BaseRoomParams auth(long paramLong, byte[] paramArrayOfByte)
  {
    this.authBits = paramLong;
    this.authBuffer = paramArrayOfByte;
    return this;
  }
  
  public BaseRoomParams authEncryptionType(int paramInt)
  {
    this.authEncryptionType = paramInt;
    return this;
  }
  
  public BaseRoomParams autoCloseCamera(boolean paramBoolean)
  {
    this.autoCloseCamera = paramBoolean;
    return this;
  }
  
  public BaseRoomParams autoCreateRoom(boolean paramBoolean)
  {
    this.autoCreateRoom = paramBoolean;
    return this;
  }
  
  public BaseRoomParams avControlRole(String paramString)
  {
    this.controlRole = paramString;
    return this;
  }
  
  public BaseRoomParams bussInfo(String paramString)
  {
    this.bussInfo = paramString;
    return this;
  }
  
  public BaseRoomParams isEnableHdAudio(boolean paramBoolean)
  {
    this.enableHdAudio = paramBoolean;
    return this;
  }
  
  public BaseRoomParams isEnableHwDec(boolean paramBoolean)
  {
    this.enableHwDec = paramBoolean;
    return this;
  }
  
  public BaseRoomParams isEnableHwEnc(boolean paramBoolean)
  {
    this.enableHwEnc = paramBoolean;
    return this;
  }
  
  public BaseRoomParams isEnableMic(boolean paramBoolean)
  {
    this.enableMic = paramBoolean;
    return this;
  }
  
  public BaseRoomParams isEnableMultiRequestIplist(boolean paramBoolean)
  {
    this.enableMultiRequestIplist = paramBoolean;
    return this;
  }
  
  public BaseRoomParams isEnableSpeaker(boolean paramBoolean)
  {
    this.enableSpeaker = paramBoolean;
    return this;
  }
  
  public BaseRoomParams screenRecvMode(int paramInt)
  {
    this.screenRecvMode = paramInt;
    return this;
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    for (;;)
    {
      int i;
      try
      {
        Field[] arrayOfField = getClass().getFields();
        int j = arrayOfField.length;
        i = 0;
        if (i < j)
        {
          Field localField = arrayOfField[i];
          Object localObject1 = null;
          try
          {
            Object localObject2 = localField.get(this);
            localObject1 = localObject2;
          }
          catch (IllegalAccessException localIllegalAccessException)
          {
            localIllegalAccessException.printStackTrace();
            continue;
          }
          if (localObject1 == null) {
            break label117;
          }
          localStringBuffer.append(localField.getName());
          localStringBuffer.append("=");
          localStringBuffer.append(localObject1.toString());
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return String.format("MediaRoomInfo={%s}", new Object[] { localStringBuffer.toString() });
      }
      label117:
      i += 1;
    }
  }
  
  public BaseRoomParams videoRecvMode(int paramInt)
  {
    this.videoRecvMode = paramInt;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilive.opensdk.params.BaseRoomParams
 * JD-Core Version:    0.7.0.1
 */