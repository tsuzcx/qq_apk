package com.tencent.biz.qqcircle.utils.zip;

import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class QZipInputStream
  extends ZipInputStream
{
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
 * Qualified Name:     com.tencent.biz.qqcircle.utils.zip.QZipInputStream
 * JD-Core Version:    0.7.0.1
 */