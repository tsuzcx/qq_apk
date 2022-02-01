package com.tencent.biz.pubaccount.weishi_new.profilecard;

import com.tencent.biz.pubaccount.weishi_new.report.WSReportEvent.ActionId;
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
  
  private static void a(WSStatisticsReporter.Builder paramBuilder, String paramString)
  {
    paramBuilder.build(paramString).report();
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
    WSStatisticsReporter.Builder localBuilder = a(c(paramBoolean));
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
    Object localObject2 = a(c(paramBoolean1));
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
  
  private static String c(boolean paramBoolean)
  {
    if (paramBoolean) {
      return "profile_main";
    }
    return "profile_guest";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.profilecard.WSProfileCardReport
 * JD-Core Version:    0.7.0.1
 */