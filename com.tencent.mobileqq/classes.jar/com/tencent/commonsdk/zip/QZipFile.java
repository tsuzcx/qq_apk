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
    if (QZipIOException.isInvalidEntry(paramZipEntry)) {
      throw new QZipIOException();
    }
    return super.getInputStream(paramZipEntry);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.commonsdk.zip.QZipFile
 * JD-Core Version:    0.7.0.1
 */