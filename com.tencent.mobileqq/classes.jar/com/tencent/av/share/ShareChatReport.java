package com.tencent.av.share;

import android.text.TextUtils;
import com.tencent.av.share.api.IShareChatApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.util.Pair;

public class ShareChatReport
{
  public static Pair<Integer, Integer> a(int paramInt1, int paramInt2)
  {
    int i = ((IShareChatApi)QRoute.api(IShareChatApi.class)).getLinkTypeNoVerify();
    int j = 2;
    if (paramInt2 == i)
    {
      i = 1;
    }
    else
    {
      if (paramInt2 != ((IShareChatApi)QRoute.api(IShareChatApi.class)).getLinkTypeNeedVerify()) {
        break label117;
      }
      i = 2;
    }
    if (paramInt1 != 0)
    {
      paramInt2 = j;
      if (paramInt1 != 1) {
        if (paramInt1 != 2)
        {
          if (paramInt1 != 3)
          {
            if (paramInt1 != 4)
            {
              if (paramInt1 != 5) {
                return null;
              }
              paramInt2 = 7;
            }
            else
            {
              paramInt2 = 5;
            }
          }
          else {
            paramInt2 = 4;
          }
        }
        else {
          paramInt2 = 3;
        }
      }
    }
    else
    {
      paramInt2 = 1;
    }
    return new Pair(Integer.valueOf(paramInt2), Integer.valueOf(i));
    label117:
    return null;
  }
  
  public static void a()
  {
    a("0X800A2B9");
  }
  
  public static void a(int paramInt)
  {
    String str;
    if (paramInt != 0)
    {
      if (paramInt != 3)
      {
        if (paramInt != 4)
        {
          if (paramInt != 5) {
            return;
          }
          str = "0X800A2C1";
        }
        else
        {
          str = "0X800A2BF";
        }
      }
      else {
        str = "0X800A2BE";
      }
    }
    else {
      str = "0X800A2C3";
    }
    a(str);
  }
  
  public static void a(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    String str;
    if (paramInt3 != 1)
    {
      if (paramInt3 != 2)
      {
        if (paramInt3 != 99) {
          return;
        }
        str = "0X800A2BC";
      }
      else
      {
        str = "0X800A3E1";
      }
    }
    else {
      str = "0X800A3E3";
    }
    Object localObject = a(paramInt1, paramInt2);
    if (localObject == null) {
      return;
    }
    paramInt1 = ((Integer)((Pair)localObject).first).intValue();
    localObject = String.valueOf(((Pair)localObject).second);
    if (TextUtils.isEmpty(paramString)) {
      paramString = (String)localObject;
    }
    ReportController.b(null, "dc00898", "", "", str, str, paramInt1, 0, paramString, "", "", "");
  }
  
  public static void a(int paramInt, String paramString)
  {
    if (paramInt == 1) {
      ReportController.b(null, "dc00898", "", "", "0X800A3E2", "0X800A3E2", 0, 0, "", paramString, "", "");
    }
  }
  
  static void a(String paramString)
  {
    ReportController.b(null, "dc00898", "", "", paramString, paramString, 0, 0, "", "", "", "");
  }
  
  public static void b()
  {
    a("0X800A2BA");
  }
  
  public static void b(int paramInt1, int paramInt2)
  {
    Pair localPair = a(paramInt1, paramInt2);
    if (localPair == null) {
      return;
    }
    ReportController.b(null, "dc00898", "", "", "0X800A2BB", "0X800A2BB", ((Integer)localPair.first).intValue(), 0, String.valueOf(((Integer)localPair.second).intValue()), "", "", "");
  }
  
  public static void c()
  {
    a("0X800A2BD");
  }
  
  public static void d()
  {
    a("0X800A2C0");
  }
  
  public static void e()
  {
    a("0X800A2C2");
  }
  
  public static void f()
  {
    a("0X800A3DB");
  }
  
  public static void g()
  {
    a("0X800A3DC");
  }
  
  public static void h()
  {
    a("0X800B5A0");
  }
  
  public static void i()
  {
    a("0X800B5A1");
  }
  
  public static void j()
  {
    a("0X800B5A2");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.share.ShareChatReport
 * JD-Core Version:    0.7.0.1
 */