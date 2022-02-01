package com.tencent.biz.pubaccount.weishi_new.profilecard;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi_new.report.WSReportEvent.ActionId;
import com.tencent.biz.pubaccount.weishi_new.report.WSReportUtils;
import com.tencent.biz.pubaccount.weishi_new.report.WSStatisticsReporter;
import com.tencent.biz.pubaccount.weishi_new.report.WSStatisticsReporter.Builder;
import java.util.HashMap;
import java.util.Map;

public class WSProfileCardReport
{
  private static Map<String, Long> a = new HashMap();
  
  private static WSStatisticsReporter.Builder a(String paramString)
  {
    return new WSStatisticsReporter.Builder().setSopName(paramString).setFlush(true);
  }
  
  private static String a(boolean paramBoolean)
  {
    if (paramBoolean) {
      return "profile_main";
    }
    return "profile_guest";
  }
  
  public static void a()
  {
    a("privacy_settings", "");
  }
  
  private static void a(WSStatisticsReporter.Builder paramBuilder, String paramString)
  {
    paramBuilder.build(paramString).report();
  }
  
  private static void a(String paramString1, String paramString2)
  {
    a.put(paramString1, Long.valueOf(System.currentTimeMillis()));
    a(paramString1, "1", 0L, paramString2);
  }
  
  private static void a(String paramString1, String paramString2, long paramLong, String paramString3)
  {
    paramString1 = a(paramString1).addParams("event_type", paramString2);
    if (TextUtils.equals("2", paramString2)) {
      paramString1.addParams("page_live_time", String.valueOf(paramLong));
    }
    if (!TextUtils.isEmpty(paramString3))
    {
      paramString2 = new HashMap();
      paramString2.put("owner_id", paramString3);
      paramString1.addExtParams(paramString2);
    }
    a(paramString1, "gzh_pagevisit");
  }
  
  public static void a(String paramString, boolean paramBoolean)
  {
    WSReportUtils.a("QQ_profile_settings");
    a(a(paramBoolean), paramString);
  }
  
  public static void a(boolean paramBoolean)
  {
    if (!paramBoolean) {
      return;
    }
    a(a("privacy_settings").addParams("position", "weishi_switch").addParams("feed_id", "").addParams("owner_id", ""), "gzh_exposure");
  }
  
  public static void a(boolean paramBoolean, String paramString)
  {
    WSStatisticsReporter.Builder localBuilder = a(a(paramBoolean));
    String str;
    if (paramBoolean) {
      str = "my_weishi";
    } else {
      str = "owner_weishi";
    }
    a(localBuilder.addParams("position", str).addParams("feed_id", "").addParams("owner_id", paramString), "gzh_exposure");
  }
  
  public static void a(boolean paramBoolean1, String paramString, boolean paramBoolean2, boolean paramBoolean3)
  {
    Object localObject2 = a(a(paramBoolean1));
    if (paramBoolean1) {
      localObject1 = "my_weishi_jump";
    } else {
      localObject1 = "owner_weishi_jump";
    }
    localObject2 = ((WSStatisticsReporter.Builder)localObject2).addParams("position", (String)localObject1);
    if (paramBoolean2) {
      localObject1 = WSReportEvent.ActionId.c;
    } else {
      localObject1 = WSReportEvent.ActionId.b;
    }
    Object localObject1 = ((WSStatisticsReporter.Builder)localObject2).addParams("action_id", (String)localObject1).addParams("feed_id", "").addParams("owner_id", paramString);
    localObject2 = new HashMap();
    if (paramBoolean1)
    {
      if (paramBoolean3) {
        paramString = "0";
      } else {
        paramString = "1";
      }
      ((Map)localObject2).put("click_status", paramString);
    }
    ((WSStatisticsReporter.Builder)localObject1).addExtParams((Map)localObject2);
    a((WSStatisticsReporter.Builder)localObject1, "gzh_click");
  }
  
  public static void b()
  {
    b("privacy_settings", "");
  }
  
  private static void b(String paramString1, String paramString2)
  {
    long l2 = 0L;
    Long localLong = Long.valueOf(0L);
    Map localMap = a;
    if (localMap != null) {
      localLong = (Long)localMap.get(paramString1);
    }
    long l1 = l2;
    if (localLong != null)
    {
      l1 = l2;
      if (localLong.longValue() > 0L) {
        l1 = System.currentTimeMillis() - localLong.longValue();
      }
    }
    a(paramString1, "2", l1, paramString2);
  }
  
  public static void b(String paramString, boolean paramBoolean)
  {
    b(a(paramBoolean), paramString);
  }
  
  public static void b(boolean paramBoolean)
  {
    WSStatisticsReporter.Builder localBuilder = a("privacy_settings").addParams("position", "weishi_switch").addParams("action_id", WSReportEvent.ActionId.a).addParams("feed_id", "").addParams("owner_id", "");
    HashMap localHashMap = new HashMap();
    String str;
    if (paramBoolean) {
      str = "1";
    } else {
      str = "0";
    }
    localHashMap.put("switch", str);
    localBuilder.addExtParams(localHashMap);
    a(localBuilder, "gzh_click");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.profilecard.WSProfileCardReport
 * JD-Core Version:    0.7.0.1
 */