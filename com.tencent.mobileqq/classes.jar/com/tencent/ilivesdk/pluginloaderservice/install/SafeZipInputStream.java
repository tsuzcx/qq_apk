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
      Object localObject = localZipEntry.getName();
      if (localObject != null)
      {
        if ((!((String)localObject).contains("../")) && (!((String)localObject).contains("..\\"))) {
          return localZipEntry;
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("非法entry路径:");
        ((StringBuilder)localObject).append(localZipEntry.getName());
        throw new SecurityException(((StringBuilder)localObject).toString());
      }
    }
    return localZipEntry;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilivesdk.pluginloaderservice.install.SafeZipInputStream
 * JD-Core Version:    0.7.0.1
 */