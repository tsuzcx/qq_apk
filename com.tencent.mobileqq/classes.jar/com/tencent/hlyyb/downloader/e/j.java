package com.tencent.hlyyb.downloader.e;

import java.io.File;
import java.io.RandomAccessFile;

final class j
  extends RandomAccessFile
{
  public j(File paramFile, String paramString)
  {
    super(paramFile, paramString);
  }
  
  protected final void finalize()
  {
    try
    {
      super.finalize();
      return;
    }
    catch (Throwable localThrowable) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.hlyyb.downloader.e.j
 * JD-Core Version:    0.7.0.1
 */