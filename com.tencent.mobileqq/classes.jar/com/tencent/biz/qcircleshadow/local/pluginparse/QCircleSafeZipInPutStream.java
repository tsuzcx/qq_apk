package com.tencent.biz.qcircleshadow.local.pluginparse;

import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class QCircleSafeZipInPutStream
  extends ZipInputStream
{
  QCircleSafeZipInPutStream(InputStream paramInputStream)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.local.pluginparse.QCircleSafeZipInPutStream
 * JD-Core Version:    0.7.0.1
 */