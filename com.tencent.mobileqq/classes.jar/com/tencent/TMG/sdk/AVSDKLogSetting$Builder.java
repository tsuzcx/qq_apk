package com.tencent.TMG.sdk;

public class AVSDKLogSetting$Builder
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.TMG.sdk.AVSDKLogSetting.Builder
 * JD-Core Version:    0.7.0.1
 */