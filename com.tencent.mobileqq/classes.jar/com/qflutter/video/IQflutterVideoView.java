package com.qflutter.video;

import java.util.Map;

public abstract interface IQflutterVideoView
{
  public static final int QFlutterVideoViewStatusClickDanmakuBtn = 15;
  public static final int QFlutterVideoViewStatusClickFullScreenBtn = 14;
  public static final int QFlutterVideoViewStatusEnded = 8;
  public static final int QFlutterVideoViewStatusError = 9;
  public static final int QFlutterVideoViewStatusFullScreenChange = 16;
  public static final int QFlutterVideoViewStatusLoadProgress = 11;
  public static final int QFlutterVideoViewStatusLoadStart = 10;
  public static final int QFlutterVideoViewStatusLoaded = 12;
  public static final int QFlutterVideoViewStatusLoadedMetaData = 13;
  public static final int QFlutterVideoViewStatusPause = 3;
  public static final int QFlutterVideoViewStatusPlay = 2;
  public static final int QFlutterVideoViewStatusSeeked = 6;
  public static final int QFlutterVideoViewStatusSeeking = 5;
  public static final int QFlutterVideoViewStatusStop = 4;
  public static final int QFlutterVideoViewStatusTimeUpdate = 7;
  public static final int QFlutterVideoViewStatusUnknown = 0;
  public static final int QFlutterVideoViewStatusWaiting = 1;
  
  public abstract void onStatus(IQflutterVideoView.StatusCallBack paramStatusCallBack);
  
  public abstract void operate(Map<String, Object> paramMap);
  
  public abstract void update(Map<String, Object> paramMap);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.qflutter.video.IQflutterVideoView
 * JD-Core Version:    0.7.0.1
 */