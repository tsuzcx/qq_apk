package com.tencent.commonsdk.zip;

import java.io.File;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class QZipFile
  extends ZipFile
{
  public QZipFile(File paramFile)
  {
    super(paramFile);
  }
  
  public QZipFile(File paramFile, int paramInt)
  {
    super(paramFile, paramInt);
  }
  
  public QZipFile(String paramString)
  {
    super(paramString);
  }
  
  public InputStream getInputStream(ZipEntry paramZipEntry)
  {
    if (!QZipIOException.isInvalidEntry(paramZipEntry)) {
      return super.getInputStream(paramZipEntry);
    }
    throw new QZipIOException();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.commonsdk.zip.QZipFile
 * JD-Core Version:    0.7.0.1
 */