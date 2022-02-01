package com.jakewharton.disklrucache;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.io.StringWriter;
import java.nio.charset.Charset;

public final class Util
{
  static final Charset US_ASCII = Charset.forName("US-ASCII");
  static final Charset UTF_8 = Charset.forName("UTF-8");
  
  static void closeQuietly(Closeable paramCloseable)
  {
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      return;
    }
    catch (RuntimeException paramCloseable)
    {
      throw paramCloseable;
      return;
    }
    catch (Exception paramCloseable) {}
  }
  
  static void deleteContents(File paramFile)
  {
    Object localObject = paramFile.listFiles();
    if (localObject != null)
    {
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        paramFile = localObject[i];
        if (paramFile.isDirectory()) {
          deleteContents(paramFile);
        }
        if (paramFile.delete())
        {
          i += 1;
        }
        else
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("failed to delete file: ");
          ((StringBuilder)localObject).append(paramFile);
          throw new IOException(((StringBuilder)localObject).toString());
        }
      }
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("not a readable directory: ");
    ((StringBuilder)localObject).append(paramFile);
    paramFile = new IOException(((StringBuilder)localObject).toString());
    for (;;)
    {
      throw paramFile;
    }
  }
  
  static String readFully(Reader paramReader)
  {
    try
    {
      Object localObject1 = new StringWriter();
      char[] arrayOfChar = new char[1024];
      for (;;)
      {
        int i = paramReader.read(arrayOfChar);
        if (i == -1) {
          break;
        }
        ((StringWriter)localObject1).write(arrayOfChar, 0, i);
      }
      localObject1 = ((StringWriter)localObject1).toString();
      paramReader.close();
      return localObject1;
    }
    finally
    {
      paramReader.close();
    }
    for (;;)
    {
      throw localObject2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.jakewharton.disklrucache.Util
 * JD-Core Version:    0.7.0.1
 */