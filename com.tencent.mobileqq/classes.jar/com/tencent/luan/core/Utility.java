package com.tencent.luan.core;

import java.io.Closeable;

public class Utility
{
  public static void close(Closeable paramCloseable)
  {
    if (paramCloseable == null) {
      return;
    }
    try
    {
      paramCloseable.close();
      return;
    }
    catch (Throwable paramCloseable) {}
  }
  
  public static boolean isEmpty(CharSequence paramCharSequence)
  {
    return (paramCharSequence == null) || (paramCharSequence.length() == 0);
  }
  
  public static void makeSureNotNull(Object paramObject, String paramString)
  {
    if (paramObject == null) {
      throw new NullPointerException("input param " + paramString + " cannot be null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.luan.core.Utility
 * JD-Core Version:    0.7.0.1
 */