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
  
  public int fillCustomData(AVRoomMulti.AVCustomData paramAVCustomData)
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
  
  public native void requestViewList(String[] paramArrayOfString, AVView[] paramArrayOfAVView, int paramInt, AVRoomMulti.RequestViewListCompleteCallback paramRequestViewListCompleteCallback);
  
  public native void setNetType(int paramInt);
  
  public native void unlinkRoom(AVCallback paramAVCallback);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.TMG.sdk.AVRoomMulti
 * JD-Core Version:    0.7.0.1
 */