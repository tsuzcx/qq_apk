package com.tencent.feedback.upload;

public abstract interface UploadHandleListener
{
  public abstract void onUploadEnd(int paramInt1, int paramInt2, long paramLong1, long paramLong2, boolean paramBoolean, String paramString);
  
  public abstract void onUploadStart(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.feedback.upload.UploadHandleListener
 * JD-Core Version:    0.7.0.1
 */