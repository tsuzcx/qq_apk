package com.huawei.agconnect.config.a;

import android.util.Log;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;

public final class h
{
  public static String a(InputStream paramInputStream, String paramString)
  {
    StringWriter localStringWriter = new StringWriter();
    a(new InputStreamReader(paramInputStream, paramString), localStringWriter);
    return localStringWriter.toString();
  }
  
  public static void a(Closeable paramCloseable)
  {
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      return;
    }
    catch (IOException paramCloseable)
    {
      Log.e("Utils", "Exception when closing the 'Closeable'.");
    }
  }
  
  public static void a(Reader paramReader, Writer paramWriter)
  {
    a(paramReader, paramWriter, new char[4096]);
  }
  
  public static void a(Reader paramReader, Writer paramWriter, char[] paramArrayOfChar)
  {
    for (int i = paramReader.read(paramArrayOfChar); -1 != i; i = paramReader.read(paramArrayOfChar)) {
      paramWriter.write(paramArrayOfChar, 0, i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.agconnect.config.a.h
 * JD-Core Version:    0.7.0.1
 */