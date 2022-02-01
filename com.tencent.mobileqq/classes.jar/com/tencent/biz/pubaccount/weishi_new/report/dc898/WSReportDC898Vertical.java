package com.tencent.biz.pubaccount.weishi_new.report.dc898;

import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerParam;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerWrapper;
import com.tencent.biz.pubaccount.weishi_new.player.WSVideoInfo;
import com.tencent.component.network.module.common.NetworkState;
import java.util.HashMap;
import java.util.Map;
import org.jetbrains.annotations.NotNull;

public class WSReportDC898Vertical
{
  private static WSReportDC898Base a;
  
  public static void a()
  {
    WSReportDC898Base localWSReportDC898Base = a;
    if (localWSReportDC898Base == null) {
      return;
    }
    localWSReportDC898Base.e();
  }
  
  public static void a(int paramInt)
  {
    WSReportDC898Base localWSReportDC898Base = a;
    if (localWSReportDC898Base == null) {
      return;
    }
    localWSReportDC898Base.b(paramInt);
  }
  
  public static void a(int paramInt1, int paramInt2)
  {
    WSReportDC898Base localWSReportDC898Base = a;
    if (localWSReportDC898Base == null) {
      return;
    }
    localWSReportDC898Base.a(paramInt1, paramInt2);
  }
  
  public static void a(WSPlayerParam paramWSPlayerParam, boolean paramBoolean)
  {
    if (a == null) {
      return;
    }
    if (paramWSPlayerParam != null)
    {
      if (paramWSPlayerParam.c == null) {
        return;
      }
      paramWSPlayerParam = b(paramWSPlayerParam, paramBoolean);
      a.a(paramWSPlayerParam);
    }
  }
  
  public static void a(String paramString)
  {
    WSReportDC898Base localWSReportDC898Base = a;
    if (localWSReportDC898Base == null) {
      return;
    }
    localWSReportDC898Base.c(paramString);
  }
  
  public static void a(String paramString, int paramInt1, int paramInt2)
  {
    WSReportDC898Base localWSReportDC898Base = a;
    if (localWSReportDC898Base == null) {
      return;
    }
    localWSReportDC898Base.a(paramString, paramInt1, paramInt2);
  }
  
  public static void a(String paramString1, String paramString2)
  {
    WSReportDC898Base localWSReportDC898Base = a;
    if (localWSReportDC898Base != null)
    {
      localWSReportDC898Base.b(paramString2);
      a.a(paramString1);
    }
  }
  
  public static void a(String paramString1, String paramString2, String paramString3)
  {
    a = new WSReportDC898Base(WSPublicAccParamFactory.a(paramString1));
    a(paramString2, paramString3);
  }
  
  @NotNull
  public static Map<String, String> b(WSPlayerParam paramWSPlayerParam, boolean paramBoolean)
  {
    Object localObject = paramWSPlayerParam.d;
    if (localObject == null) {
      localObject = "0";
    } else {
      localObject = String.valueOf(((WSPlayerWrapper)localObject).c(paramBoolean));
    }
    paramWSPlayerParam = paramWSPlayerParam.c;
    HashMap localHashMap = new HashMap();
    localHashMap.put("video_total_time", String.valueOf(paramWSPlayerParam.d));
    localHashMap.put("video_play_time", localObject);
    localHashMap.put("videoid", paramWSPlayerParam.a);
    localHashMap.put("feedid", paramWSPlayerParam.a);
    localHashMap.put("author_uin", paramWSPlayerParam.j);
    int j = NetworkState.g().getNetworkType();
    int i = 1;
    if (j != 1) {
      i = 2;
    }
    localHashMap.put("network", String.valueOf(i));
    localHashMap.put("video_type", String.valueOf(paramWSPlayerParam.i));
    return localHashMap;
  }
  
  public static void b()
  {
    WSReportDC898Base localWSReportDC898Base = a;
    if (localWSReportDC898Base == null) {
      return;
    }
    localWSReportDC898Base.b();
  }
  
  public static void b(int paramInt)
  {
    WSReportDC898Base localWSReportDC898Base = a;
    if (localWSReportDC898Base == null) {
      return;
    }
    localWSReportDC898Base.c(paramInt);
  }
  
  public static void b(String paramString, int paramInt1, int paramInt2)
  {
    WSReportDC898Base localWSReportDC898Base = a;
    if (localWSReportDC898Base == null) {
      return;
    }
    localWSReportDC898Base.b(paramString, paramInt1, paramInt2);
  }
  
  public static void c()
  {
    WSReportDC898Base localWSReportDC898Base = a;
    if (localWSReportDC898Base == null) {
      return;
    }
    localWSReportDC898Base.c();
  }
  
  public static void c(String paramString, int paramInt1, int paramInt2)
  {
    WSReportDC898Base localWSReportDC898Base = a;
    if (localWSReportDC898Base == null) {
      return;
    }
    localWSReportDC898Base.c(paramString, paramInt1, paramInt2);
  }
  
  public static void d()
  {
    WSReportDC898Base localWSReportDC898Base = a;
    if (localWSReportDC898Base == null) {
      return;
    }
    localWSReportDC898Base.d();
  }
  
  public static void e()
  {
    WSReportDC898Base localWSReportDC898Base = a;
    if (localWSReportDC898Base == null) {
      return;
    }
    localWSReportDC898Base.f();
  }
  
  public static void f()
  {
    WSReportDC898Base localWSReportDC898Base = a;
    if (localWSReportDC898Base == null) {
      return;
    }
    localWSReportDC898Base.g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.report.dc898.WSReportDC898Vertical
 * JD-Core Version:    0.7.0.1
 */