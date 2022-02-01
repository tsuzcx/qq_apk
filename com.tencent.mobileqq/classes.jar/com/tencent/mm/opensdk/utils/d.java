package com.tencent.mm.opensdk.utils;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class d
{
  public static Context D;
  public static ThreadPoolExecutor E = new ThreadPoolExecutor(0, 8, 1L, TimeUnit.SECONDS, new LinkedBlockingDeque());
  
  private static int a(ContentResolver paramContentResolver, Uri paramUri)
  {
    int i = 0;
    Log.i("MicroMsg.SDK.Util", "getFileSize with content url");
    if ((paramContentResolver == null) || (paramUri == null)) {
      Log.w("MicroMsg.SDK.Util", "getFileSize fail, resolver or uri is null");
    }
    Object localObject;
    for (;;)
    {
      return i;
      localObject = null;
      ContentResolver localContentResolver = null;
      try
      {
        paramContentResolver = paramContentResolver.openInputStream(paramUri);
        if (paramContentResolver == null)
        {
          if (paramContentResolver == null) {
            continue;
          }
          try
          {
            paramContentResolver.close();
            return 0;
          }
          catch (IOException paramContentResolver)
          {
            return 0;
          }
        }
        localContentResolver = paramContentResolver;
        localObject = paramContentResolver;
        int j = paramContentResolver.available();
        i = j;
        if (paramContentResolver != null) {
          try
          {
            paramContentResolver.close();
            return j;
          }
          catch (IOException paramContentResolver)
          {
            return j;
          }
        }
      }
      catch (Exception paramContentResolver)
      {
        localObject = localContentResolver;
        Log.w("MicroMsg.SDK.Util", "getFileSize fail, " + paramContentResolver.getMessage());
        if (localContentResolver != null) {
          try
          {
            localContentResolver.close();
            return 0;
          }
          catch (IOException paramContentResolver)
          {
            return 0;
          }
        }
      }
      finally
      {
        if (localObject == null) {}
      }
    }
    try
    {
      ((InputStream)localObject).close();
      label136:
      throw paramContentResolver;
    }
    catch (IOException paramUri)
    {
      break label136;
    }
  }
  
  public static boolean a(int paramInt)
  {
    return (paramInt == 36) || (paramInt == 46);
  }
  
  public static boolean b(String paramString)
  {
    return (paramString == null) || (paramString.length() <= 0);
  }
  
  public static int c(String paramString)
  {
    if (paramString != null) {
      try
      {
        if (paramString.length() <= 0) {
          return 0;
        }
        int i = Integer.parseInt(paramString);
        return i;
      }
      catch (Exception paramString) {}
    }
    return 0;
  }
  
  public static int getFileSize(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {}
    File localFile;
    do
    {
      return 0;
      localFile = new File(paramString);
    } while ((!localFile.exists()) && ((D == null) || (!paramString.startsWith("content"))));
    try
    {
      int i = a(D.getContentResolver(), Uri.parse(paramString));
      return i;
    }
    catch (Exception paramString) {}
    return (int)localFile.length();
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.opensdk.utils.d
 * JD-Core Version:    0.7.0.1
 */