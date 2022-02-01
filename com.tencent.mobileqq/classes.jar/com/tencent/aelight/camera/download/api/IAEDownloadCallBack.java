package com.tencent.aelight.camera.download.api;

public abstract interface IAEDownloadCallBack
{
  public abstract void onAEDownloadFinish(AEResInfo paramAEResInfo, String paramString, boolean paramBoolean, int paramInt);
  
  public abstract void onAEProgressUpdate(AEResInfo paramAEResInfo, long paramLong1, long paramLong2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.aelight.camera.download.api.IAEDownloadCallBack
 * JD-Core Version:    0.7.0.1
 */