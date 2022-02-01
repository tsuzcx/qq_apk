package com.tencent.commonsdk.zip;

import java.io.IOException;
import java.util.zip.ZipEntry;

public class QZipIOException
  extends IOException
{
  public static boolean isInvalidEntry(ZipEntry paramZipEntry)
  {
    if (paramZipEntry != null)
    {
      paramZipEntry = paramZipEntry.getName();
      if ((paramZipEntry != null) && ((paramZipEntry.contains("../")) || (paramZipEntry.contains("..\\")))) {
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.commonsdk.zip.QZipIOException
 * JD-Core Version:    0.7.0.1
 */