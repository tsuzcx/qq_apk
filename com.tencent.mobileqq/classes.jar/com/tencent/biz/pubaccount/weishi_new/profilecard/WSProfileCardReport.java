package com.tencent.biz.pubaccount.weishi_new.profilecard;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi_new.report.WSReportEvent.ActionId;
import com.tencent.biz.pubaccount.weishi_new.report.WSReportUtils;
import com.tencent.biz.pubaccount.weishi_new.report.WSStatisticsReporter;
import com.tencent.biz.pubaccount.weishi_new.report.WSStatisticsReporter.Builder;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import java.util.HashMap;
import java.util.Map;

public class WSProfileCardReport
{
  private static Map<String, Long> a = new HashMap();
  
  private static WSStatisticsReporter.Builder a(String paramString)
  {
    return new WSStatisticsReporter.Builder().setSopName(paramString).setFlush(true).setImmediatelyUpload(WeishiUtils.d());
  }
  
  private static String a(ProfileCardInfo paramProfileCardInfo)
  {
    if ((paramProfileCardInfo != null) && (paramProfileCardInfo.a != null)) {
      return paramProfileCardInfo.a.jdField_a_of_type_JavaLangString;
    }
    return "";
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
  
  public static void a(ProfileCardInfo paramProfileCardInfo, QQAppInterface paramQQAppInterface)
  {
    WSReportUtils.a("QQ_profile_settings");
    String str = a(paramProfileCardInfo);
    a(a(a(paramProfileCardInfo, paramQQAppInterface, str)), str);
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
    if (paramBoolean) {}
    for (String str = "my_weishi";; str = "owner_weishi")
    {
      a(localBuilder.addParams("position", str).addParams("feed_id", "").addParams("owner_id", paramString), "gzh_exposure");
      return;
    }
  }
  
  public static void a(boolean paramBoolean1, String paramString, boolean paramBoolean2, boolean paramBoolean3)
  {
    Object localObject2 = a(a(paramBoolean1));
    Object localObject1;
    if (paramBoolean1)
    {
      localObject1 = "my_weishi_jump";
      localObject2 = ((WSStatisticsReporter.Builder)localObject2).addParams("position", (String)localObject1);
      if (!paramBoolean2) {
        break label115;
      }
      localObject1 = WSReportEvent.ActionId.c;
      label37:
      localObject1 = ((WSStatisticsReporter.Builder)localObject2).addParams("action_id", (String)localObject1).addParams("feed_id", "").addParams("owner_id", paramString);
      localObject2 = new HashMap();
      if (paramBoolean1) {
        if (!paramBoolean3) {
          break label123;
        }
      }
    }
    label115:
    label123:
    for (paramString = "0";; paramString = "1")
    {
      ((Map)localObject2).put("click_status", paramString);
      ((WSStatisticsReporter.Builder)localObject1).addExtParams((Map)localObject2);
      a((WSStatisticsReporter.Builder)localObject1, "gzh_click");
      return;
      localObject1 = "owner_weishi_jump";
      break;
      localObject1 = WSReportEvent.ActionId.b;
      break label37;
    }
  }
  
  private static boolean a(ProfileCardInfo paramProfileCardInfo, QQAppInterface paramQQAppInterface, String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramProfileCardInfo != null)
    {
      bool1 = bool2;
      if (paramProfileCardInfo.a != null)
      {
        bool1 = bool2;
        if (paramQQAppInterface != null)
        {
          bool1 = bool2;
          if (!TextUtils.isEmpty(paramString)) {
            if (paramProfileCardInfo.a.jdField_a_of_type_Int != 0)
            {
              bool1 = bool2;
              if (!TextUtils.equals(paramQQAppInterface.getCurrentAccountUin(), paramString)) {}
            }
            else
            {
              bool1 = true;
            }
          }
        }
      }
    }
    return bool1;
  }
  
  public static void b()
  {
    b("privacy_settings", "");
  }
  
  public static void b(ProfileCardInfo paramProfileCardInfo, QQAppInterface paramQQAppInterface)
  {
    String str = a(paramProfileCardInfo);
    b(a(a(paramProfileCardInfo, paramQQAppInterface, str)), str);
  }
  
  private static void b(String paramString1, String paramString2)
  {
    Long localLong = Long.valueOf(0L);
    if (a != null) {
      localLong = (Long)a.get(paramString1);
    }
    if ((localLong != null) && (localLong.longValue() > 0L)) {}
    for (long l = System.currentTimeMillis() - localLong.longValue();; l = 0L)
    {
      a(paramString1, "2", l, paramString2);
      return;
    }
  }
  
  public static void b(boolean paramBoolean)
  {
    WSStatisticsReporter.Builder localBuilder = a("privacy_settings").addParams("position", "weishi_switch").addParams("action_id", WSReportEvent.ActionId.jdField_a_of_type_JavaLangString).addParams("feed_id", "").addParams("owner_id", "");
    HashMap localHashMap = new HashMap();
    if (paramBoolean) {}
    for (String str = "1";; str = "0")
    {
      localHashMap.put("switch", str);
      localBuilder.addExtParams(localHashMap);
      a(localBuilder, "gzh_click");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.profilecard.WSProfileCardReport
 * JD-Core Version:    0.7.0.1
 */