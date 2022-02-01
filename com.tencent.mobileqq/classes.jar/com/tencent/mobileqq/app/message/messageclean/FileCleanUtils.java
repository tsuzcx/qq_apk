package com.tencent.mobileqq.app.message.messageclean;

public class FileCleanUtils
{
  public static String a(long paramLong)
  {
    if (paramLong <= 0L) {
      return "";
    }
    if (paramLong < 1024L)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramLong);
      localStringBuilder.append("B");
      return localStringBuilder.toString();
    }
    if (paramLong < 1048576L)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(String.format("%.1f", new Object[] { Float.valueOf((float)paramLong / 1024.0F) }));
      localStringBuilder.append("K");
      return localStringBuilder.toString();
    }
    if (paramLong < 1073741824L)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(String.format("%.1f", new Object[] { Float.valueOf((float)paramLong / 1024.0F / 1024.0F) }));
      localStringBuilder.append("M");
      return localStringBuilder.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(String.format("%.1f", new Object[] { Float.valueOf((float)paramLong / 1024.0F / 1024.0F / 1024.0F) }));
    localStringBuilder.append("G");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.message.messageclean.FileCleanUtils
 * JD-Core Version:    0.7.0.1
 */