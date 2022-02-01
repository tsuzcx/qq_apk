package com.tencent.av.utils;

import android.content.Context;
import android.os.Build.VERSION;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;

public class VideoUtil
{
  public static boolean a(Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 23) {
      return VideoController.a(paramContext) ^ true;
    }
    return false;
  }
  
  public static boolean a(VideoAppInterface paramVideoAppInterface)
  {
    paramVideoAppInterface = paramVideoAppInterface.b();
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramVideoAppInterface != null)
    {
      int i = paramVideoAppInterface.k().g;
      if (i != 1)
      {
        bool1 = bool2;
        if (i != 2) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static boolean a(VideoAppInterface paramVideoAppInterface, boolean paramBoolean)
  {
    paramVideoAppInterface = paramVideoAppInterface.b();
    boolean bool1 = true;
    if (paramVideoAppInterface != null)
    {
      int i = paramVideoAppInterface.k().g;
      int j = paramVideoAppInterface.k().aQ;
      boolean bool2 = paramVideoAppInterface.k().H;
      if (3 == j)
      {
        if (!paramBoolean) {
          break label61;
        }
        if ((i == 2) && (bool2)) {
          return true;
        }
      }
    }
    bool1 = false;
    label61:
    return bool1;
  }
  
  public static boolean b(VideoAppInterface paramVideoAppInterface)
  {
    paramVideoAppInterface = paramVideoAppInterface.b();
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramVideoAppInterface != null)
    {
      int i = paramVideoAppInterface.k().g;
      bool1 = bool2;
      if (2 == paramVideoAppInterface.k().aQ)
      {
        bool1 = bool2;
        if (i == 4) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public static boolean c(VideoAppInterface paramVideoAppInterface)
  {
    paramVideoAppInterface = paramVideoAppInterface.b();
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramVideoAppInterface != null)
    {
      int i = paramVideoAppInterface.k().g;
      bool1 = bool2;
      if (1 == paramVideoAppInterface.k().aQ)
      {
        bool1 = bool2;
        if (i == 4) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public static long d(VideoAppInterface paramVideoAppInterface)
  {
    if ((paramVideoAppInterface != null) && (paramVideoAppInterface.b() != null)) {
      return paramVideoAppInterface.b().as();
    }
    return 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.utils.VideoUtil
 * JD-Core Version:    0.7.0.1
 */