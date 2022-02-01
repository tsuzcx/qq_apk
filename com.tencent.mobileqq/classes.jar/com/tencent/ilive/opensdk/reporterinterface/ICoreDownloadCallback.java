package com.tencent.ilive.opensdk.reporterinterface;

import java.io.File;

public abstract interface ICoreDownloadCallback
{
  public static final int ERR_EX = -2;
  public static final int ERR_IO = -1;
  
  public abstract void onFail(int paramInt);
  
  public abstract void onProgress(long paramLong1, long paramLong2, int paramInt);
  
  public abstract void onSuccess(File paramFile);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilive.opensdk.reporterinterface.ICoreDownloadCallback
 * JD-Core Version:    0.7.0.1
 */