package com.bumptech.glide.load.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

class FileLoader$StreamFactory$1
  implements FileLoader.FileOpener<InputStream>
{
  public InputStream a(File paramFile)
  {
    return new FileInputStream(paramFile);
  }
  
  public Class<InputStream> a()
  {
    return InputStream.class;
  }
  
  public void a(InputStream paramInputStream)
  {
    paramInputStream.close();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.model.FileLoader.StreamFactory.1
 * JD-Core Version:    0.7.0.1
 */