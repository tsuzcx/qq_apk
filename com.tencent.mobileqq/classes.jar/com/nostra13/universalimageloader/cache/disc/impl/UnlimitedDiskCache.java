package com.nostra13.universalimageloader.cache.disc.impl;

import com.nostra13.universalimageloader.cache.disc.naming.FileNameGenerator;
import java.io.File;

public class UnlimitedDiskCache
  extends BaseDiskCache
{
  public UnlimitedDiskCache(File paramFile)
  {
    super(paramFile);
  }
  
  public UnlimitedDiskCache(File paramFile1, File paramFile2)
  {
    super(paramFile1, paramFile2);
  }
  
  public UnlimitedDiskCache(File paramFile1, File paramFile2, FileNameGenerator paramFileNameGenerator)
  {
    super(paramFile1, paramFile2, paramFileNameGenerator);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiskCache
 * JD-Core Version:    0.7.0.1
 */