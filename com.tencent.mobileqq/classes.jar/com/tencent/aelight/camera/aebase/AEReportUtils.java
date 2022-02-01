package com.tencent.aelight.camera.aebase;

import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.qcircle.api.IQCircleReportApi;
import com.tencent.mobileqq.qcircle.api.constant.QCircleLpReportDc05504DataBuilder;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qroute.QRoute;
import cooperation.qzone.LocalMultiProcConfig;
import java.util.HashMap;
import mqq.app.AppRuntime;

public class AEReportUtils
{
  public static void a()
  {
    ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504(new QCircleLpReportDc05504DataBuilder().setActionType(88).setSubActionType(13).setThrActionType(1));
  }
  
  public static void a(int paramInt)
  {
    ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504(new QCircleLpReportDc05504DataBuilder().setActionType(90).setSubActionType(8).setThrActionType(paramInt));
  }
  
  public static void a(int paramInt1, int paramInt2, int paramInt3)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("ext3", String.valueOf(paramInt1));
    localHashMap.put("ext4", String.valueOf(paramInt2));
    localHashMap.put("ext5", String.valueOf(paramInt3));
    ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504(new QCircleLpReportDc05504DataBuilder().setActionType(88).setSubActionType(13).setThrActionType(2).setExtras(localHashMap));
  }
  
  public static void a(int paramInt1, int paramInt2, String paramString)
  {
    ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504(new QCircleLpReportDc05504DataBuilder().setActionType(88).setSubActionType(paramInt1).setThrActionType(paramInt2).setExt6(paramString));
  }
  
  public static void a(int paramInt1, int paramInt2, HashMap<String, String> paramHashMap)
  {
    IQCircleReportApi localIQCircleReportApi = (IQCircleReportApi)QRoute.api(IQCircleReportApi.class);
    QCircleLpReportDc05504DataBuilder localQCircleLpReportDc05504DataBuilder = new QCircleLpReportDc05504DataBuilder().setActionType(89).setSubActionType(paramInt1).setThrActionType(paramInt2);
    Object localObject = paramHashMap;
    if (paramHashMap == null) {
      localObject = new HashMap();
    }
    localIQCircleReportApi.report5504(localQCircleLpReportDc05504DataBuilder.setExtras((HashMap)localObject));
  }
  
  public static void a(int paramInt, long paramLong) {}
  
  public static void a(int paramInt, String paramString)
  {
    String str;
    if (paramInt != 1) {
      str = "1";
    } else {
      str = "2";
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("ext2", str);
    localHashMap.put("ext6", paramString);
    ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504(new QCircleLpReportDc05504DataBuilder().setActionType(88).setSubActionType(9).setThrActionType(1).setExtras(localHashMap));
  }
  
  public static void a(int paramInt, HashMap<String, String> paramHashMap)
  {
    a(paramInt, 1, paramHashMap);
  }
  
  public static void a(String paramString)
  {
    ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504(new QCircleLpReportDc05504DataBuilder().setActionType(90).setSubActionType(9).setThrActionType(2).setExt15(paramString));
  }
  
  public static void a(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8)
  {
    ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504(new QCircleLpReportDc05504DataBuilder().setToUin(paramString1).setActionType(104).setSubActionType(paramInt1).setThrActionType(paramInt2).setExt3(paramString2).setExt4(paramString3).setExt5(paramString4).setExt6(paramString5).setExt7(paramString6).setExt8(paramString7).setExt15(paramString8));
  }
  
  public static void a(String paramString1, int paramInt, String paramString2)
  {
    ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504(new QCircleLpReportDc05504DataBuilder().setToUin(paramString1).setActionType(88).setSubActionType(paramInt).setThrActionType(2).setExt6(paramString2));
  }
  
  public static void a(String paramString1, int paramInt, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504(new QCircleLpReportDc05504DataBuilder().setToUin(paramString1).setActionType(88).setSubActionType(14).setThrActionType(paramInt).setExt6(paramString2).setExt7(paramString3).setExt8(paramString4).setExt15(paramString5));
  }
  
  public static void a(String paramString1, String paramString2)
  {
    if (paramString1 == null) {
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("ext2", paramString1);
    localHashMap.put("ext6", paramString2);
    ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504(new QCircleLpReportDc05504DataBuilder().setActionType(88).setSubActionType(6).setThrActionType(2).setExtras(localHashMap));
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504(new QCircleLpReportDc05504DataBuilder().setActionType(87).setSubActionType(6).setThrActionType(2).setExt8(paramString5).setExt9(paramString6).setExt15(paramString1).setExt16(paramString2).setExt17(paramString3).setExt18(paramString4));
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8)
  {
    ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504(new QCircleLpReportDc05504DataBuilder().setToUin(paramString1).setActionType(90).setSubActionType(6).setThrActionType(2).setExt6(paramString2).setExt7(paramString3).setExt9(paramString4).setExt15(paramString5).setExt16(paramString6).setExt17(paramString7).setExt18(paramString8));
  }
  
  public static void a(boolean paramBoolean)
  {
    int i;
    if (paramBoolean) {
      i = 92;
    } else {
      i = 88;
    }
    ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504(new QCircleLpReportDc05504DataBuilder().setActionType(i).setSubActionType(4).setThrActionType(1));
  }
  
  public static void a(boolean paramBoolean, int paramInt)
  {
    int i;
    if (paramBoolean) {
      i = 87;
    } else {
      i = 90;
    }
    ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504(new QCircleLpReportDc05504DataBuilder().setActionType(i).setSubActionType(paramInt).setThrActionType(1));
  }
  
  public static void a(boolean paramBoolean, int paramInt1, int paramInt2, String paramString)
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
    localHashMap.put("ext6", paramString);
    if (paramBoolean) {
      paramInt1 = 92;
    } else {
      paramInt1 = 88;
    }
    ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504(new QCircleLpReportDc05504DataBuilder().setActionType(paramInt1).setSubActionType(3).setThrActionType(2).setExtras(localHashMap));
  }
  
  private static void a(boolean paramBoolean, int paramInt, String paramString)
  {
    int i;
    if (paramBoolean) {
      i = 87;
    } else {
      i = 90;
    }
    ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504(new QCircleLpReportDc05504DataBuilder().setActionType(i).setSubActionType(paramInt).setThrActionType(2).setExt15(paramString));
  }
  
  public static void a(boolean paramBoolean, String paramString)
  {
    int i;
    if (paramBoolean) {
      i = 92;
    } else {
      i = 88;
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("QCIRCLE_PHOTOLIST_FIRST_ACTION", i);
    localBundle.putString("qcircle_photolist_type_key", paramString);
    QIPCClientHelper.getInstance().callServer("PeakIpcModuleServer", "action_qcircle_picker_expose", localBundle);
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
    int m = paramString1.hashCode();
    int k = 0;
    if (m != 2195567)
    {
      if (m != 80227729)
      {
        if ((m == 1370501784) && (paramString1.equals("FancyFont"))) {
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
          i = k;
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
    ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504(new QCircleLpReportDc05504DataBuilder().setActionType(j).setSubActionType(i).setThrActionType(paramInt).setExt15(paramString2));
  }
  
  public static void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, String paramString)
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
    localHashMap.put("ext6", paramString);
    ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504(new QCircleLpReportDc05504DataBuilder().setActionType(paramInt1).setSubActionType(2).setThrActionType(i).setExtras(localHashMap));
  }
  
  public static void b()
  {
    ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504(new QCircleLpReportDc05504DataBuilder().setActionType(87).setSubActionType(5).setThrActionType(2));
  }
  
  public static void b(int paramInt1, int paramInt2, int paramInt3)
  {
    ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504(new QCircleLpReportDc05504DataBuilder().setActionType(paramInt1).setSubActionType(15).setThrActionType(paramInt2).setExt15(String.valueOf(paramInt3)));
  }
  
  public static void b(int paramInt, String paramString)
  {
    ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504(new QCircleLpReportDc05504DataBuilder().setActionType(87).setSubActionType(9).setThrActionType(paramInt).setExt15(paramString));
  }
  
  public static void b(int paramInt, HashMap<String, String> paramHashMap)
  {
    a(paramInt, 2, paramHashMap);
  }
  
  public static void b(String paramString)
  {
    ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504(new QCircleLpReportDc05504DataBuilder().setActionType(90).setSubActionType(9).setThrActionType(3).setExt15(paramString));
  }
  
  public static void b(boolean paramBoolean)
  {
    a(paramBoolean, 2);
  }
  
  private static void b(boolean paramBoolean, int paramInt, String paramString)
  {
    int i;
    if (paramBoolean) {
      i = 87;
    } else {
      i = 90;
    }
    ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504(new QCircleLpReportDc05504DataBuilder().setActionType(i).setSubActionType(paramInt).setThrActionType(3).setExt15(paramString));
  }
  
  public static void b(boolean paramBoolean, String paramString)
  {
    a(paramBoolean, 2, paramString);
  }
  
  public static void c()
  {
    ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504(new QCircleLpReportDc05504DataBuilder().setActionType(87).setSubActionType(7).setThrActionType(1));
  }
  
  public static void c(int paramInt, String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("ext6", paramString);
    paramString = new StringBuilder();
    paramString.append(paramInt);
    paramString.append("");
    localHashMap.put("ext15", paramString.toString());
    paramString = new StringBuilder();
    paramString.append(LocalMultiProcConfig.getInt4Uin("_qq_circle_publish_draft_from", 0, BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin()));
    paramString.append("");
    localHashMap.put("ext16", paramString.toString());
    ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504(new QCircleLpReportDc05504DataBuilder().setActionType(88).setSubActionType(12).setThrActionType(1).setExtras(localHashMap));
  }
  
  public static void c(int paramInt, HashMap<String, String> paramHashMap)
  {
    a(paramInt, 3, paramHashMap);
  }
  
  public static void c(String paramString)
  {
    ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504(new QCircleLpReportDc05504DataBuilder().setActionType(90).setSubActionType(9).setThrActionType(4).setExt15(paramString));
  }
  
  public static void c(boolean paramBoolean)
  {
    a(paramBoolean, 3);
  }
  
  private static void c(boolean paramBoolean, int paramInt, String paramString)
  {
    int i;
    if (paramBoolean) {
      i = 87;
    } else {
      i = 90;
    }
    ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504(new QCircleLpReportDc05504DataBuilder().setActionType(i).setSubActionType(paramInt).setThrActionType(4).setExt15(paramString));
  }
  
  public static void c(boolean paramBoolean, String paramString)
  {
    b(paramBoolean, 2, paramString);
  }
  
  public static void d()
  {
    ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504(new QCircleLpReportDc05504DataBuilder().setActionType(87).setSubActionType(7).setThrActionType(2));
  }
  
  public static void d(int paramInt, String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("ext6", paramString);
    paramString = new StringBuilder();
    paramString.append(paramInt);
    paramString.append("");
    localHashMap.put("ext15", paramString.toString());
    paramString = new StringBuilder();
    paramString.append(LocalMultiProcConfig.getInt4Uin("_qq_circle_publish_draft_from", 0, BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin()));
    paramString.append("");
    localHashMap.put("ext16", paramString.toString());
    ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504(new QCircleLpReportDc05504DataBuilder().setActionType(88).setSubActionType(12).setThrActionType(3).setExtras(localHashMap));
  }
  
  public static void d(String paramString)
  {
    ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504(new QCircleLpReportDc05504DataBuilder().setActionType(90).setSubActionType(9).setThrActionType(5).setExt15(paramString));
  }
  
  public static void d(boolean paramBoolean)
  {
    int i;
    if (paramBoolean) {
      i = 87;
    } else {
      i = 90;
    }
    ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504(new QCircleLpReportDc05504DataBuilder().setActionType(i).setSubActionType(3).setThrActionType(5));
  }
  
  public static void d(boolean paramBoolean, String paramString)
  {
    c(paramBoolean, 2, paramString);
  }
  
  public static void e()
  {
    ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504(new QCircleLpReportDc05504DataBuilder().setActionType(87).setSubActionType(8).setThrActionType(1));
  }
  
  public static void e(int paramInt, String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("ext6", paramString);
    paramString = new StringBuilder();
    paramString.append(paramInt);
    paramString.append("");
    localHashMap.put("ext15", paramString.toString());
    paramString = new StringBuilder();
    paramString.append(LocalMultiProcConfig.getInt4Uin("_qq_circle_publish_draft_from", 0, BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin()));
    paramString.append("");
    localHashMap.put("ext16", paramString.toString());
    ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504(new QCircleLpReportDc05504DataBuilder().setActionType(88).setSubActionType(12).setThrActionType(2).setExtras(localHashMap));
  }
  
  public static void e(String paramString)
  {
    a(true, 11, paramString);
  }
  
  public static void e(boolean paramBoolean, String paramString)
  {
    a(paramBoolean, 3, paramString);
  }
  
  public static void f()
  {
    ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504(new QCircleLpReportDc05504DataBuilder().setActionType(87).setSubActionType(8).setThrActionType(2));
  }
  
  public static void f(String paramString)
  {
    b(true, 11, paramString);
  }
  
  public static void f(boolean paramBoolean, String paramString)
  {
    b(paramBoolean, 3, paramString);
  }
  
  public static void g()
  {
    ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504(new QCircleLpReportDc05504DataBuilder().setActionType(87).setSubActionType(7).setThrActionType(1));
  }
  
  public static void g(String paramString)
  {
    c(true, 11, paramString);
  }
  
  public static void g(boolean paramBoolean, String paramString)
  {
    c(paramBoolean, 3, paramString);
  }
  
  public static void h()
  {
    a(false, 9);
  }
  
  public static void h(String paramString)
  {
    a(true, 4, paramString);
  }
  
  public static void i()
  {
    a(true, 11);
  }
  
  public static void i(String paramString)
  {
    b(true, 4, paramString);
  }
  
  public static void j()
  {
    a(true, 4);
  }
  
  public static void j(String paramString)
  {
    c(true, 4, paramString);
  }
  
  public static void k()
  {
    a(false, 8);
  }
  
  public static void k(String paramString)
  {
    ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504(new QCircleLpReportDc05504DataBuilder().setActionType(90).setSubActionType(8).setThrActionType(2).setExt15(paramString));
  }
  
  public static void l()
  {
    ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504(new QCircleLpReportDc05504DataBuilder().setActionType(90).setSubActionType(7).setThrActionType(1));
  }
  
  public static void l(String paramString)
  {
    ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504(new QCircleLpReportDc05504DataBuilder().setActionType(90).setSubActionType(7).setThrActionType(3).setExt15(paramString));
  }
  
  public static void m()
  {
    ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504(new QCircleLpReportDc05504DataBuilder().setActionType(90).setSubActionType(5).setThrActionType(2));
  }
  
  public static void n()
  {
    ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504(new QCircleLpReportDc05504DataBuilder().setActionType(90).setSubActionType(7).setThrActionType(2));
  }
  
  public static void o()
  {
    ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504(new QCircleLpReportDc05504DataBuilder().setActionType(90).setSubActionType(7).setThrActionType(4));
  }
  
  public static void p()
  {
    ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504(new QCircleLpReportDc05504DataBuilder().setActionType(90).setSubActionType(7).setThrActionType(5));
  }
  
  public static void q()
  {
    ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504(new QCircleLpReportDc05504DataBuilder().setActionType(90).setSubActionType(7).setThrActionType(6));
  }
  
  public static void r() {}
  
  public static void s()
  {
    ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504(new QCircleLpReportDc05504DataBuilder().setActionType(90).setSubActionType(1).setThrActionType(1));
  }
  
  public static void t()
  {
    ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504(new QCircleLpReportDc05504DataBuilder().setActionType(87).setSubActionType(1).setThrActionType(1));
    c();
    e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aebase.AEReportUtils
 * JD-Core Version:    0.7.0.1
 */