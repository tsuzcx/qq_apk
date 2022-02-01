package com.tencent.ilivesdk.pluginloaderservice.install;

import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public final class SafeZipInputStream
  extends ZipInputStream
{
  public SafeZipInputStream(InputStream paramInputStream)
  {
    super(paramInputStream);
  }
  
  public final ZipEntry getNextEntry()
  {
    ZipEntry localZipEntry = super.getNextEntry();
    if (localZipEntry != null)
    {
      String str = localZipEntry.getName();
      if ((str != null) && ((str.contains("../")) || (str.contains("..\\")))) {
        throw new SecurityException("非法entry路径:" + localZipEntry.getName());
      }
    }
    return localZipEntry;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.pluginloaderservice.install.SafeZipInputStream
 * JD-Core Version:    0.7.0.1
 */