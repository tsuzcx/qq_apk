package com.google.android.exoplayer2.drm;

public class DecryptionException
  extends Exception
{
  public final int errorCode;
  
  public DecryptionException(int paramInt, String paramString)
  {
    super(paramString);
    this.errorCode = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.drm.DecryptionException
 * JD-Core Version:    0.7.0.1
 */