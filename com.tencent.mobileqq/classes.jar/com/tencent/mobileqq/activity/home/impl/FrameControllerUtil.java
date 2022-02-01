package com.tencent.mobileqq.activity.home.impl;

import com.tencent.mobileqq.activity.qqsettingme.api.IVasApngUtilApi;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qroute.QRoute;

public class FrameControllerUtil
  extends BaseFrameControllerUtil
{
  public static final String a = HardCodeUtil.a(2131693875);
  public static final String b = HardCodeUtil.a(2131693874);
  public static final String c = HardCodeUtil.a(2131719445);
  public static final String d = HardCodeUtil.a(2131693876);
  public static final String e = HardCodeUtil.a(2131699906);
  public static final String f = HardCodeUtil.a(2131693524);
  public static final String g = HardCodeUtil.a(2131697851);
  
  public static int a(int paramInt)
  {
    int i = 0;
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3)
          {
            if (paramInt != 4)
            {
              if (paramInt != 5)
              {
                if (paramInt != 99) {
                  return 0;
                }
                return 99;
              }
              return 5;
            }
            return 4;
          }
          return 3;
        }
        return 2;
      }
      i = 1;
    }
    return i;
  }
  
  public static boolean a()
  {
    return ((IVasApngUtilApi)QRoute.api(IVasApngUtilApi.class)).updateIsDefaultTheme();
  }
  
  public static int b(int paramInt)
  {
    int i = 5;
    if (paramInt != -1) {
      if (paramInt != 0)
      {
        if (paramInt != 3)
        {
          if (paramInt == 4) {
            return i;
          }
          if (paramInt != 5)
          {
            if (paramInt == 9) {
              return 4;
            }
          }
          else {
            return 1;
          }
        }
        else
        {
          return 6;
        }
      }
      else {
        return 2;
      }
    }
    i = 0;
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.impl.FrameControllerUtil
 * JD-Core Version:    0.7.0.1
 */