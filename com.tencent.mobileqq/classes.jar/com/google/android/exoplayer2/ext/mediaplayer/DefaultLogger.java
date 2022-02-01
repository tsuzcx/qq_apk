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
    int i = 0;
    while (i < paramString.length())
    {
      localArrayList.add(paramString.substring(i, Math.min(paramString.length(), i + paramInt)));
      i += paramInt;
    }
    return localArrayList;
  }
  
  public int d(String paramString1, String paramString2)
  {
    if (paramString2.length() > 1000) {
      return log(3, paramString1, splitEqually(paramString2, 1000));
    }
    return Log.d("OskPlayer/" + paramString1, paramString2);
  }
  
  public int d(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (paramString2.length() > 1000) {
      return log(3, paramString1, splitEqually(paramString2, 1000));
    }
    return Log.d("OskPlayer/" + paramString1, paramString2, paramThrowable);
  }
  
  public int e(String paramString1, String paramString2)
  {
    if (paramString2.length() > 1000) {
      return log(6, paramString1, splitEqually(paramString2, 1000));
    }
    return Log.e("OskPlayer/" + paramString1, paramString2);
  }
  
  public int e(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (paramString2.length() > 1000) {
      return log(6, paramString1, splitEqually(paramString2, 1000));
    }
    return Log.e("OskPlayer/" + paramString1, paramString2, paramThrowable);
  }
  
  public int i(String paramString1, String paramString2)
  {
    if (paramString2.length() > 1000) {
      return log(4, paramString1, splitEqually(paramString2, 1000));
    }
    return Log.i("OskPlayer/" + paramString1, paramString2);
  }
  
  public int i(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (paramString2.length() > 1000) {
      return log(4, paramString1, splitEqually(paramString2, 1000));
    }
    return Log.i("OskPlayer/" + paramString1, paramString2, paramThrowable);
  }
  
  public int log(int paramInt, String paramString, List<String> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      switch (paramInt)
      {
      default: 
        break;
      case 2: 
        v(paramString, str);
        break;
      case 3: 
        d(paramString, str);
        break;
      case 4: 
        i(paramString, str);
        break;
      case 5: 
        w(paramString, str);
        break;
      case 6: 
        e(paramString, str);
      }
    }
    return 0;
  }
  
  public int v(String paramString1, String paramString2)
  {
    if (paramString2.length() > 1000) {
      return log(2, paramString1, splitEqually(paramString2, 1000));
    }
    return Log.v("OskPlayer/" + paramString1, paramString2);
  }
  
  public int v(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (paramString2.length() > 1000) {
      return log(2, paramString1, splitEqually(paramString2, 1000));
    }
    return Log.v("OskPlayer/" + paramString1, paramString2, paramThrowable);
  }
  
  public int w(String paramString1, String paramString2)
  {
    if (paramString2.length() > 1000) {
      return log(5, paramString1, splitEqually(paramString2, 1000));
    }
    return Log.w("OskPlayer/" + paramString1, paramString2);
  }
  
  public int w(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (paramString2.length() > 1000) {
      return log(5, paramString1, splitEqually(paramString2, 1000));
    }
    return Log.w("OskPlayer/" + paramString1, paramString2, paramThrowable);
  }
  
  public int w(String paramString, Throwable paramThrowable)
  {
    return Log.w("OskPlayer/" + paramString, paramThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.exoplayer2.ext.mediaplayer.DefaultLogger
 * JD-Core Version:    0.7.0.1
 */