package com.tencent.TMG.sdk;

public class AVSDKLogSetting
{
  static final int DEFAULT_MAX_LOG_FILE_SIZE = 52428800;
  boolean isEnablePrintLog;
  boolean isEnableWriteLog;
  String logDir;
  LogListener logListener;
  int maxFileSize;
  
  AVSDKLogSetting(AVSDKLogSetting.Builder paramBuilder)
  {
    this.isEnablePrintLog = AVSDKLogSetting.Builder.access$000(paramBuilder);
    this.isEnableWriteLog = AVSDKLogSetting.Builder.access$100(paramBuilder);
    this.logDir = AVSDKLogSetting.Builder.access$200(paramBuilder);
    this.maxFileSize = AVSDKLogSetting.Builder.access$300(paramBuilder);
    this.logListener = AVSDKLogSetting.Builder.access$400(paramBuilder);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.TMG.sdk.AVSDKLogSetting
 * JD-Core Version:    0.7.0.1
 */