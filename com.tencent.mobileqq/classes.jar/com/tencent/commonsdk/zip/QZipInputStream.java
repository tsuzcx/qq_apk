package com.tencent.commonsdk.zip;

import java.io.IOException;
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
    throws IOException
  {
    ZipEntry localZipEntry = super.getNextEntry();
    if (QZipIOException.isInvalidEntry(localZipEntry)) {
      throw new QZipIOException();
    }
    return localZipEntry;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.commonsdk.zip.QZipInputStream
 * JD-Core Version:    0.7.0.1
 */