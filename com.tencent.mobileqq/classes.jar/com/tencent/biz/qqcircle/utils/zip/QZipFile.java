package com.tencent.biz.qqcircle.utils.zip;

import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class QZipFile
  extends ZipFile
{
  public InputStream getInputStream(ZipEntry paramZipEntry)
  {
    if (!QZipIOException.isInvalidEntry(paramZipEntry)) {
      return super.getInputStream(paramZipEntry);
    }
    throw new QZipIOException();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.utils.zip.QZipFile
 * JD-Core Version:    0.7.0.1
 */