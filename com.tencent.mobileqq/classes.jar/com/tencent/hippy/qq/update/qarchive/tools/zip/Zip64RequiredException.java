package com.tencent.hippy.qq.update.qarchive.tools.zip;

import java.util.zip.ZipException;

public class Zip64RequiredException
  extends ZipException
{
  static final String ARCHIVE_TOO_BIG_MESSAGE = "archive's size exceeds the limit of 4GByte.";
  static final String TOO_MANY_ENTRIES_MESSAGE = "archive contains more than 65535 entries.";
  private static final long serialVersionUID = 20110809L;
  
  public Zip64RequiredException(String paramString)
  {
    super(paramString);
  }
  
  static String getEntryTooBigMessage(ZipEntry paramZipEntry)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramZipEntry.getName());
    localStringBuilder.append("'s size exceeds the limit of 4GByte.");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.hippy.qq.update.qarchive.tools.zip.Zip64RequiredException
 * JD-Core Version:    0.7.0.1
 */