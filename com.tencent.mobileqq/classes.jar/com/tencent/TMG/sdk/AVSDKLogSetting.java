package com.tencent.TMG.sdk;

public class AVSDKLogSetting
{
  static final int DEFAULT_MAX_LOG_FILE_SIZE = 52428800;
  boolean isEnablePrintLog;
  boolean isEnableWriteLog;
  String logDir;
  LogListener logListener;
  int maxFileSize;
  
  AVSDKLogSetting(Builder paramBuilder)
  {
    this.isEnablePrintLog = paramBuilder.isEnablePrintLog;
    this.isEnableWriteLog = paramBuilder.isEnableWriteLog;
    this.logDir = paramBuilder.logDir;
    this.maxFileSize = paramBuilder.maxFileSize;
    this.logListener = paramBuilder.logListener;
  }
  
  public static class Builder
  {
    private boolean isEnablePrintLog = true;
    private boolean isEnableWriteLog = true;
    private String logDir = "";
    private LogListener logListener = null;
    private int maxFileSize = 52428800;
    
    public AVSDKLogSetting build()
    {
      return new AVSDKLogSetting(this);
    }
    
    public Builder isEnablePrintLog(boolean paramBoolean)
    {
      this.isEnablePrintLog = paramBoolean;
      return this;
    }
    
    public Builder isEnableWriteLog(boolean paramBoolean)
    {
      this.isEnableWriteLog = paramBoolean;
      return this;
    }
    
    public Builder logDir(String paramString)
    {
      this.logDir = paramString;
      return this;
    }
    
    public Builder logListener(LogListener paramLogListener)
    {
      this.logListener = paramLogListener;
      return this;
    }
    
    public Builder maxFileSize(int paramInt)
    {
      this.maxFileSize = paramInt;
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.TMG.sdk.AVSDKLogSetting
 * JD-Core Version:    0.7.0.1
 */