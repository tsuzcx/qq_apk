package com.tencent.component.network.module.cache.file;

import java.io.File;

class FileCacheService$FileEntry
{
  public final boolean isFile;
  public final long lastModified;
  public final String name;
  public final String path;
  
  public FileCacheService$FileEntry(String paramString1, String paramString2)
  {
    paramString1 = new File(paramString1, paramString2);
    this.path = paramString1.getPath();
    this.name = paramString2;
    this.lastModified = paramString1.lastModified();
    this.isFile = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.component.network.module.cache.file.FileCacheService.FileEntry
 * JD-Core Version:    0.7.0.1
 */