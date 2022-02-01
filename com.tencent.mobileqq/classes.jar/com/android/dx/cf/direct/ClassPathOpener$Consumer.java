package com.android.dx.cf.direct;

import java.io.File;

public abstract interface ClassPathOpener$Consumer
{
  public abstract void onException(Exception paramException);
  
  public abstract void onProcessArchiveStart(File paramFile);
  
  public abstract boolean processFileBytes(String paramString, long paramLong, byte[] paramArrayOfByte);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.android.dx.cf.direct.ClassPathOpener.Consumer
 * JD-Core Version:    0.7.0.1
 */