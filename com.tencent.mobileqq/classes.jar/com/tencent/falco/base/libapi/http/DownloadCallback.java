package com.tencent.falco.base.libapi.http;

import java.io.File;

public abstract interface DownloadCallback
{
  public static final int ERR_EX = -2;
  public static final int ERR_IO = -1;
  
  public abstract void onFail(int paramInt);
  
  public abstract void onProgress(long paramLong1, long paramLong2, int paramInt);
  
  public abstract void onSuccess(File paramFile);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.falco.base.libapi.http.DownloadCallback
 * JD-Core Version:    0.7.0.1
 */