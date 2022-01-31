package com.tencent.TMG.sdk;

public class AVRoomMulti$EnterParam
{
  int audioCategory;
  long authBits;
  byte[] authBuffer;
  boolean autoCloseCamera;
  String controlRole;
  boolean createRoom;
  boolean enableHdAudio;
  boolean enableHwDec;
  boolean enableHwEnc;
  boolean enableMic;
  boolean enableMultiRequestIplist;
  boolean enableSpeaker;
  int relationId;
  int screenRecvMode;
  int videoRecvMode;
  
  AVRoomMulti$EnterParam(AVRoomMulti.EnterParam.Builder paramBuilder)
  {
    this.relationId = paramBuilder.relationId;
    this.authBits = paramBuilder.authBits;
    this.authBuffer = paramBuilder.authBuffer;
    this.controlRole = paramBuilder.controlRole;
    this.audioCategory = paramBuilder.audioCategory;
    this.createRoom = paramBuilder.autoCreateRoom;
    this.videoRecvMode = paramBuilder.videoRecvMode;
    this.screenRecvMode = paramBuilder.screenRecvMode;
    this.enableMultiRequestIplist = paramBuilder.enableMultiRequestIplist;
    this.enableMic = paramBuilder.enableMic;
    this.enableSpeaker = paramBuilder.enableSpeaker;
    this.enableHdAudio = paramBuilder.enableHdAudio;
    this.enableHwEnc = paramBuilder.enableHwEnc;
    this.enableHwDec = paramBuilder.enableHwDec;
    this.autoCloseCamera = paramBuilder.autoCloseCamera;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.TMG.sdk.AVRoomMulti.EnterParam
 * JD-Core Version:    0.7.0.1
 */