package com.tencent.ilive.opensdk.coreinterface;

import com.tencent.ilive.opensdk.params.IAVMediaInfo.IVideoInfo;

public abstract interface ICoreEventCallback
{
  public static final int ACTION_EVENT_FIRST_DECODE_FRAME = 102;
  public static final int ACTION_EVENT_FIRST_PACKET = 101;
  public static final int ACTION_EVENT_FIRST_RENDER_FRAME = 103;
  public static final int ACTION_EVENT_OPEN_MIC_FAILED = 104;
  public static final int EVENT_AV_ENTER_ROOM_RETRY = 12;
  public static final int EVENT_AV_ERROR = 7;
  public static final int EVENT_AV_IM_LOGIN_FAIL = 10;
  public static final int EVENT_AV_IM_LOGIN_SUCCESS = 11;
  public static final int EVENT_AV_ROOM_NOT_EXIST = 14;
  public static final int EVENT_AV_START = 8;
  public static final int EVENT_AV_STOP = 9;
  public static final int EVENT_AV_VIDEO_DISCONNECT = 13;
  public static final int EVENT_FRAME_EXCEPTION = 2;
  public static final int EVENT_NETWORK_NOT_OK_EXCEPTION = 3;
  public static final int EVENT_ROOMDISCONNECT = 6;
  public static final int EVENT_SIG_EXCEPTION = 4;
  public static final int EVENT_STREAM_EXCEPTION = 1;
  public static final int EVENT_TIMEOUT_EXCEPTION = 5;
  public static final int STREAM_EVENT_AUDIO_ADD = 5;
  public static final int STREAM_EVENT_AUDIO_DEL = 6;
  public static final int STREAM_EVENT_VIDEO_ADD = 3;
  public static final int STREAM_EVENT_VIDEO_DEL = 4;
  public static final int TIME_EVENT_VIDEO_SEI_REPORT = 201;
  
  public abstract void onAVActionEvent(int paramInt1, int paramInt2, String paramString);
  
  public abstract void onAVEvent(int paramInt1, int paramInt2);
  
  public abstract void onAVMediaInfoChange(IAVMediaInfo.IVideoInfo paramIVideoInfo);
  
  public abstract void onAVStart();
  
  public abstract void onAVStop();
  
  public abstract boolean onAVStreamEvent(int paramInt, String paramString);
  
  public abstract void onAVTerminated(int paramInt);
  
  public abstract void onAVTimeEvent(int paramInt1, int paramInt2, String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilive.opensdk.coreinterface.ICoreEventCallback
 * JD-Core Version:    0.7.0.1
 */