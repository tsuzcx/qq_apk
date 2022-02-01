package com.tencent.aelight.camera.aebase;

import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.qcircle.api.IQCircleReportApi;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qroute.QRoute;
import cooperation.qzone.LocalMultiProcConfig;
import java.util.HashMap;
import mqq.app.AppRuntime;

public class AEReportUtils
{
  public static void a()
  {
    ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504("", 88, 13, 1);
  }
  
  public static void a(int paramInt)
  {
    String str;
    if (paramInt != 1) {
      str = "1";
    } else {
      str = "2";
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("ext2", str);
    ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504("", 88, 9, 1, localHashMap, null, null);
  }
  
  public static void a(int paramInt1, int paramInt2)
  {
    ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504("", 88, paramInt1, paramInt2);
  }
  
  public static void a(int paramInt1, int paramInt2, int paramInt3)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("ext3", String.valueOf(paramInt1));
    localHashMap.put("ext4", String.valueOf(paramInt2));
    localHashMap.put("ext5", String.valueOf(paramInt3));
    ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504("", 88, 13, 2, localHashMap, null, null);
  }
  
  public static void a(int paramInt1, int paramInt2, HashMap<String, String> paramHashMap)
  {
    if (paramHashMap == null)
    {
      ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504("", 89, paramInt1, paramInt2);
      return;
    }
    ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504("", 89, paramInt1, paramInt2, paramHashMap, null, null);
  }
  
  public static void a(int paramInt, long paramLong) {}
  
  public static void a(int paramInt, String paramString)
  {
    ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504("", 87, 9, paramInt, paramString, "", "", "");
  }
  
  public static void a(int paramInt, HashMap<String, String> paramHashMap)
  {
    a(paramInt, 1, paramHashMap);
  }
  
  public static void a(String paramString)
  {
    if (paramString == null) {
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("ext2", paramString);
    ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504("", 88, 6, 2, localHashMap, null, null);
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504("", 87, 6, 2, paramString1, paramString2, paramString3, paramString4, paramString5, paramString6);
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8)
  {
    ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504(paramString1, 90, 6, 2, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7, paramString8);
  }
  
  public static void a(boolean paramBoolean)
  {
    int i;
    if (paramBoolean) {
      i = 92;
    } else {
      i = 88;
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("QCIRCLE_PHOTOLIST_FIRST_ACTION", i);
    QIPCClientHelper.getInstance().callServer("PeakIpcModuleServer", "action_qcircle_picker_expose", localBundle);
  }
  
  public static void a(boolean paramBoolean, int paramInt)
  {
    int i;
    if (paramBoolean) {
      i = 87;
    } else {
      i = 90;
    }
    ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504("", i, paramInt, 1);
  }
  
  public static void a(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    String str;
    if ((paramInt1 > 0) && (paramInt2 > 0)) {
      str = "3";
    } else if (paramInt1 > 0) {
      str = "1";
    } else {
      str = "2";
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("ext2", str);
    localHashMap.put("ext3", String.valueOf(paramInt1 + paramInt2));
    localHashMap.put("ext4", String.valueOf(paramInt1));
    localHashMap.put("ext5", String.valueOf(paramInt2));
    if (paramBoolean) {
      paramInt1 = 92;
    } else {
      paramInt1 = 88;
    }
    ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504("", paramInt1, 3, 2, localHashMap, null, null);
  }
  
  private static void a(boolean paramBoolean, int paramInt, String paramString)
  {
    int i;
    if (paramBoolean) {
      i = 87;
    } else {
      i = 90;
    }
    ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504("", i, paramInt, 2, paramString, "", "", "");
  }
  
  public static void a(boolean paramBoolean, String paramString)
  {
    a(paramBoolean, 2, paramString);
  }
  
  public static void a(boolean paramBoolean, String paramString1, int paramInt, String paramString2)
  {
    int j;
    if (paramBoolean) {
      j = 87;
    } else {
      j = 90;
    }
    int i = -1;
    int k = paramString1.hashCode();
    if (k != 2195567)
    {
      if (k != 80227729)
      {
        if ((k == 1370501784) && (paramString1.equals("FancyFont"))) {
          i = 1;
        }
      }
      else if (paramString1.equals("Style")) {
        i = 2;
      }
    }
    else if (paramString1.equals("Font")) {
      i = 0;
    }
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2) {
          i = 0;
        } else {
          i = 14;
        }
      }
      else {
        i = 13;
      }
    }
    else {
      i = 12;
    }
    ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504("", j, i, paramInt, paramString2, "", "", "");
  }
  
  public static void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2)
  {
    int i;
    if (paramBoolean2) {
      i = 2;
    } else {
      i = 3;
    }
    String str;
    if (paramInt1 != 1) {
      str = "1";
    } else {
      str = "2";
    }
    if (paramBoolean1) {
      paramInt1 = 92;
    } else {
      paramInt1 = 88;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("ext2", str);
    localHashMap.put("ext3", String.valueOf(paramInt2 + 1));
    ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504("", paramInt1, 2, i, localHashMap, null, null);
  }
  
  public static void b()
  {
    ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504("", 87, 5, 2);
  }
  
  public static void b(int paramInt)
  {
    ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504("", 90, 8, paramInt);
  }
  
  public static void b(int paramInt1, int paramInt2, int paramInt3)
  {
    ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504("", paramInt1, 15, paramInt2, String.valueOf(paramInt3));
  }
  
  public static void b(int paramInt, HashMap<String, String> paramHashMap)
  {
    a(paramInt, 2, paramHashMap);
  }
  
  public static void b(String paramString)
  {
    ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504("", 90, 9, 2, paramString, "", "", "");
  }
  
  public static void b(boolean paramBoolean)
  {
    int i;
    if (paramBoolean) {
      i = 92;
    } else {
      i = 88;
    }
    ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504("", i, 4, 1);
  }
  
  private static void b(boolean paramBoolean, int paramInt, String paramString)
  {
    int i;
    if (paramBoolean) {
      i = 87;
    } else {
      i = 90;
    }
    ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504("", i, paramInt, 3, paramString, "", "", "");
  }
  
  public static void b(boolean paramBoolean, String paramString)
  {
    b(paramBoolean, 2, paramString);
  }
  
  public static void c()
  {
    ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504("", 87, 7, 1);
  }
  
  public static void c(int paramInt)
  {
    IQCircleReportApi localIQCircleReportApi = (IQCircleReportApi)QRoute.api(IQCircleReportApi.class);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append("");
    localObject = ((StringBuilder)localObject).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(LocalMultiProcConfig.getInt4Uin("_qq_circle_publish_draft_from", 0, BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin()));
    localStringBuilder.append("");
    localIQCircleReportApi.report5504("", 88, 12, 1, (String)localObject, localStringBuilder.toString(), "", "");
  }
  
  public static void c(int paramInt, HashMap<String, String> paramHashMap)
  {
    a(paramInt, 3, paramHashMap);
  }
  
  public static void c(String paramString)
  {
    ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504("", 90, 9, 3, paramString, "", "", "");
  }
  
  public static void c(boolean paramBoolean)
  {
    a(paramBoolean, 2);
  }
  
  private static void c(boolean paramBoolean, int paramInt, String paramString)
  {
    int i;
    if (paramBoolean) {
      i = 87;
    } else {
      i = 90;
    }
    ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504("", i, paramInt, 4, paramString, "", "", "");
  }
  
  public static void c(boolean paramBoolean, String paramString)
  {
    c(paramBoolean, 2, paramString);
  }
  
  public static void d()
  {
    ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504("", 87, 7, 2);
  }
  
  public static void d(int paramInt)
  {
    IQCircleReportApi localIQCircleReportApi = (IQCircleReportApi)QRoute.api(IQCircleReportApi.class);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append("");
    localObject = ((StringBuilder)localObject).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(LocalMultiProcConfig.getInt4Uin("_qq_circle_publish_draft_from", 0, BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin()));
    localStringBuilder.append("");
    localIQCircleReportApi.report5504("", 88, 12, 3, (String)localObject, localStringBuilder.toString(), "", "");
  }
  
  public static void d(String paramString)
  {
    ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504("", 90, 9, 4, paramString, "", "", "");
  }
  
  public static void d(boolean paramBoolean)
  {
    a(paramBoolean, 3);
  }
  
  public static void d(boolean paramBoolean, String paramString)
  {
    a(paramBoolean, 3, paramString);
  }
  
  public static void e()
  {
    ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504("", 87, 8, 1);
  }
  
  public static void e(int paramInt)
  {
    IQCircleReportApi localIQCircleReportApi = (IQCircleReportApi)QRoute.api(IQCircleReportApi.class);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append("");
    localObject = ((StringBuilder)localObject).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(LocalMultiProcConfig.getInt4Uin("_qq_circle_publish_draft_from", 0, BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin()));
    localStringBuilder.append("");
    localIQCircleReportApi.report5504("", 88, 12, 2, (String)localObject, localStringBuilder.toString(), "", "");
  }
  
  public static void e(String paramString)
  {
    ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504("", 90, 9, 5, paramString, "", "", "");
  }
  
  public static void e(boolean paramBoolean)
  {
    int i;
    if (paramBoolean) {
      i = 87;
    } else {
      i = 90;
    }
    ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504("", i, 3, 5);
  }
  
  public static void e(boolean paramBoolean, String paramString)
  {
    b(paramBoolean, 3, paramString);
  }
  
  public static void f()
  {
    ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504("", 87, 8, 2);
  }
  
  public static void f(String paramString)
  {
    a(true, 11, paramString);
  }
  
  public static void f(boolean paramBoolean, String paramString)
  {
    c(paramBoolean, 3, paramString);
  }
  
  public static void g()
  {
    ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504("", 87, 10, 1);
  }
  
  public static void g(String paramString)
  {
    b(true, 11, paramString);
  }
  
  public static void h()
  {
    ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504("", 87, 7, 1);
  }
  
  public static void h(String paramString)
  {
    c(true, 11, paramString);
  }
  
  public static void i()
  {
    a(false, 9);
  }
  
  public static void i(String paramString)
  {
    a(true, 4, paramString);
  }
  
  public static void j()
  {
    a(true, 11);
  }
  
  public static void j(String paramString)
  {
    b(true, 4, paramString);
  }
  
  public static void k()
  {
    a(true, 4);
  }
  
  public static void k(String paramString)
  {
    c(true, 4, paramString);
  }
  
  public static void l()
  {
    a(false, 8);
  }
  
  public static void l(String paramString)
  {
    ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504("", 90, 8, 2, paramString, "", "", "");
  }
  
  public static void m()
  {
    ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504("", 90, 7, 1);
  }
  
  public static void m(String paramString)
  {
    ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504("", 90, 7, 3, paramString, "", "", "");
  }
  
  public static void n()
  {
    ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504("", 90, 5, 2);
  }
  
  public static void o()
  {
    ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504("", 90, 7, 2);
  }
  
  public static void p()
  {
    ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504("", 90, 7, 4);
  }
  
  public static void q()
  {
    ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504("", 90, 7, 5);
  }
  
  public static void r()
  {
    ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504("", 90, 7, 6);
  }
  
  public static void s() {}
  
  public static void t()
  {
    ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504("", 90, 1, 1);
  }
  
  public static void u()
  {
    ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504("", 87, 1, 1);
    c();
    e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aebase.AEReportUtils
 * JD-Core Version:    0.7.0.1
 */