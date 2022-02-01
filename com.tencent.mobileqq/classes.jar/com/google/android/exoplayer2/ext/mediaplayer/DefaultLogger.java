package com.google.android.exoplayer2.ext.mediaplayer;

import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DefaultLogger
  implements ILogger
{
  public static final int LOG_LEVEL_DEBUG = 3;
  public static final int LOG_LEVEL_ERROR = 6;
  public static final int LOG_LEVEL_INFO = 4;
  public static final int LOG_LEVEL_VERBOSE = 2;
  public static final int LOG_LEVEL_WARN = 5;
  public static final int LOG_TEXT_MAX_LENGTH = 1000;
  public static final String TAG = "OskPlayer";
  
  private static List<String> splitEqually(String paramString, int paramInt)
  {
    ArrayList localArrayList = new ArrayList((paramString.length() + paramInt - 1) / paramInt);
    int j;
    for (int i = 0; i < paramString.length(); i = j)
    {
      int k = paramString.length();
      j = i + paramInt;
      localArrayList.add(paramString.substring(i, Math.min(k, j)));
    }
    return localArrayList;
  }
  
  public int d(String paramString1, String paramString2)
  {
    if (paramString2.length() > 1000) {
      return log(3, paramString1, splitEqually(paramString2, 1000));
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("OskPlayer/");
    localStringBuilder.append(paramString1);
    return Log.d(localStringBuilder.toString(), paramString2);
  }
  
  public int d(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (paramString2.length() > 1000) {
      return log(3, paramString1, splitEqually(paramString2, 1000));
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("OskPlayer/");
    localStringBuilder.append(paramString1);
    return Log.d(localStringBuilder.toString(), paramString2, paramThrowable);
  }
  
  public int e(String paramString1, String paramString2)
  {
    if (paramString2.length() > 1000) {
      return log(6, paramString1, splitEqually(paramString2, 1000));
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("OskPlayer/");
    localStringBuilder.append(paramString1);
    return Log.e(localStringBuilder.toString(), paramString2);
  }
  
  public int e(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (paramString2.length() > 1000) {
      return log(6, paramString1, splitEqually(paramString2, 1000));
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("OskPlayer/");
    localStringBuilder.append(paramString1);
    return Log.e(localStringBuilder.toString(), paramString2, paramThrowable);
  }
  
  public int i(String paramString1, String paramString2)
  {
    if (paramString2.length() > 1000) {
      return log(4, paramString1, splitEqually(paramString2, 1000));
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("OskPlayer/");
    localStringBuilder.append(paramString1);
    return Log.i(localStringBuilder.toString(), paramString2);
  }
  
  public int i(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (paramString2.length() > 1000) {
      return log(4, paramString1, splitEqually(paramString2, 1000));
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("OskPlayer/");
    localStringBuilder.append(paramString1);
    return Log.i(localStringBuilder.toString(), paramString2, paramThrowable);
  }
  
  public int log(int paramInt, String paramString, List<String> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          if (paramInt != 4)
          {
            if (paramInt != 5)
            {
              if (paramInt == 6) {
                e(paramString, str);
              }
            }
            else {
              w(paramString, str);
            }
          }
          else {
            i(paramString, str);
          }
        }
        else {
          d(paramString, str);
        }
      }
      else {
        v(paramString, str);
      }
    }
    return 0;
  }
  
  public int v(String paramString1, String paramString2)
  {
    if (paramString2.length() > 1000) {
      return log(2, paramString1, splitEqually(paramString2, 1000));
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("OskPlayer/");
    localStringBuilder.append(paramString1);
    return Log.v(localStringBuilder.toString(), paramString2);
  }
  
  public int v(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (paramString2.length() > 1000) {
      return log(2, paramString1, splitEqually(paramString2, 1000));
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("OskPlayer/");
    localStringBuilder.append(paramString1);
    return Log.v(localStringBuilder.toString(), paramString2, paramThrowable);
  }
  
  public int w(String paramString1, String paramString2)
  {
    if (paramString2.length() > 1000) {
      return log(5, paramString1, splitEqually(paramString2, 1000));
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("OskPlayer/");
    localStringBuilder.append(paramString1);
    return Log.w(localStringBuilder.toString(), paramString2);
  }
  
  public int w(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (paramString2.length() > 1000) {
      return log(5, paramString1, splitEqually(paramString2, 1000));
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("OskPlayer/");
    localStringBuilder.append(paramString1);
    return Log.w(localStringBuilder.toString(), paramString2, paramThrowable);
  }
  
  public int w(String paramString, Throwable paramThrowable)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("OskPlayer/");
    localStringBuilder.append(paramString);
    return Log.w(localStringBuilder.toString(), paramThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.ext.mediaplayer.DefaultLogger
 * JD-Core Version:    0.7.0.1
 */