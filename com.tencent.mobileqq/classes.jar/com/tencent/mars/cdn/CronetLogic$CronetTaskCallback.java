package com.tencent.mars.cdn;

public abstract interface CronetLogic$CronetTaskCallback
{
  public abstract int onCronetReceiveHeader(CronetLogic.ResponseHeader paramResponseHeader, int paramInt);
  
  public abstract void onCronetTaskCompleted(String paramString, CronetLogic.CronetTaskResult paramCronetTaskResult);
  
  public abstract void onDownloadProgressChanged(String paramString, CronetLogic.CronetDownloadProgress paramCronetDownloadProgress);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mars.cdn.CronetLogic.CronetTaskCallback
 * JD-Core Version:    0.7.0.1
 */