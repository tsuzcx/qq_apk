package com.tencent.commonsdk.zip;

import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class QZipInputStream
  extends ZipInputStream
{
  public QZipInputStream(InputStream paramInputStream)
  {
    super(paramInputStream);
  }
  
  public ZipEntry getNextEntry()
  {
    ZipEntry localZipEntry = super.getNextEntry();
    if (!QZipIOException.isInvalidEntry(localZipEntry)) {
      return localZipEntry;
    }
    throw new QZipIOException();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.commonsdk.zip.QZipInputStream
 * JD-Core Version:    0.7.0.1
 */