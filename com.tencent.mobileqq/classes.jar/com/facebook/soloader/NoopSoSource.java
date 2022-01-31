package com.facebook.soloader;

import java.io.File;

public class NoopSoSource
  extends SoSource
{
  public int loadLibrary(String paramString, int paramInt)
  {
    return 1;
  }
  
  public File unpackLibrary(String paramString)
  {
    throw new UnsupportedOperationException("unpacking not supported in test mode");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.facebook.soloader.NoopSoSource
 * JD-Core Version:    0.7.0.1
 */