package com.tencent.TMG.sdk;

public class AVRoomMulti$EnterParam$Builder
{
  int audioCategory = 0;
  long authBits = -1L;
  byte[] authBuffer = null;
  boolean autoCloseCamera = true;
  boolean autoCreateRoom = true;
  String controlRole = "";
  boolean enableHdAudio = false;
  boolean enableHwDec = true;
  boolean enableHwEnc = true;
  boolean enableMic = false;
  boolean enableMultiRequestIplist = false;
  boolean enableSpeaker = false;
  int relationId;
  int screenRecvMode = 0;
  int videoRecvMode = 0;
  
  public AVRoomMulti$EnterParam$Builder(int paramInt)
  {
    this.relationId = paramInt;
  }
  
  public Builder audioCategory(int paramInt)
  {
    this.audioCategory = paramInt;
    return this;
  }
  
  public Builder auth(long paramLong, byte[] paramArrayOfByte)
  {
    this.authBits = paramLong;
    this.authBuffer = paramArrayOfByte;
    return this;
  }
  
  public Builder autoCloseCamera(boolean paramBoolean)
  {
    this.autoCloseCamera = paramBoolean;
    return this;
  }
  
  public Builder autoCreateRoom(boolean paramBoolean)
  {
    this.autoCreateRoom = paramBoolean;
    return this;
  }
  
  public Builder avControlRole(String paramString)
  {
    this.controlRole = paramString;
    return this;
  }
  
  public AVRoomMulti.EnterParam build()
  {
    return new AVRoomMulti.EnterParam(this);
  }
  
  public Builder isEnableHdAudio(boolean paramBoolean)
  {
    this.enableHdAudio = paramBoolean;
    return this;
  }
  
  public Builder isEnableHwDec(boolean paramBoolean)
  {
    this.enableHwDec = paramBoolean;
    return this;
  }
  
  public Builder isEnableHwEnc(boolean paramBoolean)
  {
    this.enableHwEnc = paramBoolean;
    return this;
  }
  
  public Builder isEnableMic(boolean paramBoolean)
  {
    this.enableMic = paramBoolean;
    return this;
  }
  
  public Builder isEnableMultiRequestIplist(boolean paramBoolean)
  {
    this.enableMultiRequestIplist = paramBoolean;
    return this;
  }
  
  public Builder isEnableSpeaker(boolean paramBoolean)
  {
    this.enableSpeaker = paramBoolean;
    return this;
  }
  
  public Builder screenRecvMode(int paramInt)
  {
    this.screenRecvMode = paramInt;
    return this;
  }
  
  public Builder videoRecvMode(int paramInt)
  {
    this.videoRecvMode = paramInt;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.TMG.sdk.AVRoomMulti.EnterParam.Builder
 * JD-Core Version:    0.7.0.1
 */