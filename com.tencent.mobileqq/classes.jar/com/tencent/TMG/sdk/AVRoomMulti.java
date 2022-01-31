package com.tencent.TMG.sdk;

import com.tencent.TMG.utils.QLog;
import java.util.ArrayList;

public class AVRoomMulti
{
  public static final int AUDIO_CATEGORY_MEDIA_PLAYBACK = 2;
  public static final int AUDIO_CATEGORY_MEDIA_PLAY_AND_RECORD = 1;
  public static final int AUDIO_CATEGORY_MEDIA_PLAY_AND_RECORD_HIGH_QUALITY = 3;
  public static final int AUDIO_CATEGORY_VOICECHAT = 0;
  public static final long AUTH_BITS_CREATE_ROOM = 1L;
  public static final long AUTH_BITS_DEFAULT = -1L;
  public static final long AUTH_BITS_JOIN_ROOM = 2L;
  public static final long AUTH_BITS_RECV_AUDIO = 8L;
  public static final long AUTH_BITS_RECV_CAMERA_VIDEO = 32L;
  public static final long AUTH_BITS_RECV_SCREEN_VIDEO = 128L;
  public static final long AUTH_BITS_SEND_AUDIO = 4L;
  public static final long AUTH_BITS_SEND_CAMERA_VIDEO = 16L;
  public static final long AUTH_BITS_SEND_SCREEN_VIDEO = 64L;
  public static final int SCREEN_RECV_MODE_MANUAL = 0;
  public static final int SCREEN_RECV_MODE_SEMI_AUTO_RECV_SCREEN_VIDEO = 1;
  static final String TAG = "SdkJni";
  public static final int VIDEO_RECV_MODE_MANUAL = 0;
  public static final int VIDEO_RECV_MODE_SEMI_AUTO_RECV_CAMERA_VIDEO = 1;
  private AVQualityStats AVQualityStatsInstance = null;
  protected int nativeObj = 0;
  
  private native boolean getAVQualityStats(AVQualityStats paramAVQualityStats, ArrayList<AVQualityStats.VideoEncodeParam> paramArrayList, ArrayList<AVQualityStats.VideoDecodeParam> paramArrayList1, ArrayList<AVQualityStats.AudioDecodeParam> paramArrayList2);
  
  public native void cancelAllView(AVCallback paramAVCallback);
  
  public native int cancelAudioList();
  
  public native void changeAVControlRole(String paramString, AVCallback paramAVCallback);
  
  @Deprecated
  public native void changeAuthority(long paramLong, byte[] paramArrayOfByte, int paramInt, AVCallback paramAVCallback);
  
  public int fillCustomData(AVCustomData paramAVCustomData)
  {
    if ((paramAVCustomData == null) || (paramAVCustomData.data == null)) {
      return 1004;
    }
    return nativefillCustomData(paramAVCustomData.data, paramAVCustomData.isAutoPushed);
  }
  
  public AVQualityStats getAVQualityStats()
  {
    if (this.AVQualityStatsInstance == null) {
      this.AVQualityStatsInstance = new AVQualityStats();
    }
    if ((this.AVQualityStatsInstance == null) || (this.AVQualityStatsInstance.videoEncodeInfo == null) || (this.AVQualityStatsInstance.videoDecodeInfo == null)) {
      QLog.e("SdkJni", 0, "AVQualityStatsInstance is not right to create");
    }
    while (!getAVQualityStats(this.AVQualityStatsInstance, this.AVQualityStatsInstance.videoEncodeInfo, this.AVQualityStatsInstance.videoDecodeInfo, this.AVQualityStatsInstance.audioDecodeInfo)) {
      return null;
    }
    return this.AVQualityStatsInstance;
  }
  
  public native AVEndpoint getEndpointById(String paramString);
  
  public native int getEndpointCount();
  
  @Deprecated
  public native String getQualityParam();
  
  public native String getQualityTips();
  
  public native int getRoomId();
  
  public native String getStatisticsParam();
  
  public native void linkRoom(long paramLong, String paramString1, String paramString2, AVCallback paramAVCallback);
  
  native int nativeRequestAudioList(String[] paramArrayOfString, int paramInt);
  
  native int nativefillCustomData(byte[] paramArrayOfByte, boolean paramBoolean);
  
  public int requestAudioList(String[] paramArrayOfString)
  {
    QLog.e("SdkJni", 0, "loki:requestAudioList");
    return nativeRequestAudioList(paramArrayOfString, paramArrayOfString.length);
  }
  
  public native void requestViewList(String[] paramArrayOfString, AVView[] paramArrayOfAVView, int paramInt, RequestViewListCompleteCallback paramRequestViewListCompleteCallback);
  
  public native void setNetType(int paramInt);
  
  public native void unlinkRoom(AVCallback paramAVCallback);
  
  public static class AVCustomData
  {
    byte[] data;
    boolean isAutoPushed;
    
    private AVCustomData() {}
    
    public AVCustomData(byte[] paramArrayOfByte, boolean paramBoolean)
    {
      this.data = paramArrayOfByte;
      this.isAutoPushed = paramBoolean;
    }
    
    public byte[] getData()
    {
      return this.data;
    }
    
    public boolean getIsAutoPushed()
    {
      return this.isAutoPushed;
    }
  }
  
  public static class ChangeRoomInfo
  {
    long authBits;
    byte[] authBuffer;
    int relationId;
    
    public ChangeRoomInfo(Builder paramBuilder)
    {
      this.relationId = paramBuilder.relationId;
      this.authBits = paramBuilder.authBits;
      this.authBuffer = paramBuilder.authBuffer;
    }
    
    public static class Builder
    {
      long authBits = -1L;
      byte[] authBuffer = null;
      int relationId;
      
      public Builder(int paramInt)
      {
        this.relationId = paramInt;
      }
      
      public Builder auth(long paramLong, byte[] paramArrayOfByte)
      {
        this.authBits = paramLong;
        this.authBuffer = paramArrayOfByte;
        return this;
      }
      
      public AVRoomMulti.ChangeRoomInfo build()
      {
        return new AVRoomMulti.ChangeRoomInfo(this);
      }
    }
  }
  
  public static class EnterParam
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
    
    EnterParam(Builder paramBuilder)
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
    
    public static class Builder
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
      
      public Builder(int paramInt)
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
  }
  
  public static abstract interface EventListener
  {
    public abstract void onCameraSettingNotify(int paramInt1, int paramInt2, int paramInt3);
    
    public abstract void onDisableAudioIssue();
    
    public abstract void onEndpointsUpdateInfo(int paramInt, String[] paramArrayOfString);
    
    public abstract void onEnterRoomComplete(int paramInt, String paramString);
    
    public abstract void onExitRoomComplete();
    
    public abstract void onHwStateChangeNotify(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString);
    
    public abstract void onPrivilegeDiffNotify(int paramInt);
    
    public abstract void onRecvCustomData(AVRoomMulti.AVCustomData paramAVCustomData, String paramString);
    
    public abstract void onRoomDisconnect(int paramInt, String paramString);
    
    public abstract void onRoomEvent(int paramInt1, int paramInt2, Object paramObject);
    
    public abstract void onSemiAutoRecvCameraVideo(String[] paramArrayOfString);
    
    public abstract void onSemiAutoRecvMediaFileVideo(String[] paramArrayOfString);
    
    public abstract void onSemiAutoRecvScreenVideo(String[] paramArrayOfString);
    
    public abstract void onSwitchRoomComplete(int paramInt, String paramString);
  }
  
  public static abstract interface RequestViewListCompleteCallback
  {
    public abstract void OnComplete(String[] paramArrayOfString, AVView[] paramArrayOfAVView, int paramInt1, int paramInt2, String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.TMG.sdk.AVRoomMulti
 * JD-Core Version:    0.7.0.1
 */