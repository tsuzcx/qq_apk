package com.bumptech.glide.load.data.mediastore;

import java.io.File;

class FileService
{
  public File a(String paramString)
  {
    return new File(paramString);
  }
  
  public boolean a(File paramFile)
  {
    return paramFile.exists();
  }
  
  public long b(File paramFile)
  {
    return paramFile.length();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.data.mediastore.FileService
 * JD-Core Version:    0.7.0.1
 */