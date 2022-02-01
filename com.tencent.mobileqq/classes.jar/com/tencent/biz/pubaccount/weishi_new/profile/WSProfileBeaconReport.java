package com.tencent.biz.pubaccount.weishi_new.profile;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi_new.report.WSPublicAccReport;
import com.tencent.biz.pubaccount.weishi_new.report.WSStatisticsReporter;
import com.tencent.biz.pubaccount.weishi_new.report.WSStatisticsReporter.Builder;
import com.tencent.biz.pubaccount.weishi_new.util.WSInitializeHelper;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/weishi_new/profile/WSProfileBeaconReport;", "", "()V", "KEY_FOLLOW_BTN_STATUS", "", "KEY_HOMEPAGE_FROM", "KEY_PRAISE_TAB_STATUS", "KEY_TAB_TYPE", "KEY_TAG_ID", "POS_FOLLOW", "POS_HOMEPAGE_EXPOSURE", "POS_PRAISE_TAB", "POS_WORKS_TAB", "VALUE_NO_SHOW_PRAISE", "VALUE_SHOW_PRAISE", "createHeaderReportBuilder", "Lcom/tencent/biz/pubaccount/weishi_new/report/WSStatisticsReporter$Builder;", "ownerId", "positionId", "createReportBuilder", "isHost", "", "requestScene", "", "doReport", "", "builder", "eventName", "getClickFollowActionId", "curFollowStatus", "getExtMap", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "from", "getPraiseTabStatus", "isShowPraise", "getReportHomePageFrom", "getSopName", "reportDetailClick", "reportExposureAfterGetDataGuest", "followStatus", "reportExposureAfterGetDataHost", "reportFeedbackClick", "reportFollowClick", "reportHeaderElementClick", "actionId", "reportMoreClick", "reportPageVisitEnter", "reportPageVisitExit", "reportPraiseTabClick", "reportTabClick", "position", "reportWorksItemClick", "feedId", "tabType", "tagId", "reportWorksItemExposure", "reportWorksTabClick", "qqweishi_impl_release"}, k=1, mv={1, 1, 16})
public final class WSProfileBeaconReport
{
  public static final WSProfileBeaconReport a = new WSProfileBeaconReport();
  
  @JvmStatic
  private static final WSStatisticsReporter.Builder a(boolean paramBoolean, int paramInt)
  {
    WSStatisticsReporter.Builder localBuilder = new WSStatisticsReporter.Builder().setSopName(a(paramBoolean)).setTestId(WeishiUtils.a(paramInt));
    WSInitializeHelper localWSInitializeHelper = WSInitializeHelper.a();
    Intrinsics.checkExpressionValueIsNotNull(localWSInitializeHelper, "WSInitializeHelper.getInstance()");
    localBuilder = localBuilder.setPushId(localWSInitializeHelper.f()).setFlush(true);
    Intrinsics.checkExpressionValueIsNotNull(localBuilder, "WSStatisticsReporter.Bui…          .setFlush(true)");
    return localBuilder;
  }
  
  @JvmStatic
  private static final String a(int paramInt)
  {
    if ((paramInt != 1) && (paramInt != 3)) {
      return String.valueOf(1004001);
    }
    return String.valueOf(1004002);
  }
  
  @JvmStatic
  private static final String a(boolean paramBoolean)
  {
    if (paramBoolean) {
      return "homepage_main";
    }
    return "homepage_guest";
  }
  
  @JvmStatic
  private static final void a(WSStatisticsReporter.Builder paramBuilder, String paramString)
  {
    paramBuilder.build(paramString).report();
  }
  
  @JvmStatic
  public static final void a(@Nullable String paramString)
  {
    paramString = i(paramString, "wesee_info").addParams("action_id", String.valueOf(1000001));
    Intrinsics.checkExpressionValueIsNotNull(paramString, "builder");
    a(paramString, "gzh_click");
  }
  
  @JvmStatic
  public static final void a(@Nullable String paramString1, @Nullable String paramString2)
  {
    WSPublicAccReport.getInstance().reportPageVisitEnter(b(paramString2), (Map)h(paramString1, paramString2));
  }
  
  @JvmStatic
  public static final void a(@Nullable String paramString1, @Nullable String paramString2, int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("homepage_from", c(paramString1));
    localHashMap.put("btn_status", String.valueOf(paramInt));
    paramString1 = i(paramString2, "follow").addParams("action_id", a(paramInt)).addExtParams((Map)localHashMap);
    Intrinsics.checkExpressionValueIsNotNull(paramString1, "builder");
    a(paramString1, "gzh_click");
  }
  
  @JvmStatic
  public static final void a(@Nullable String paramString1, @Nullable String paramString2, int paramInt, boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("homepage_from", c(paramString1));
    localHashMap.put("btn_status", String.valueOf(paramInt));
    localHashMap.put("tab_status", b(paramBoolean));
    paramString1 = i(paramString2, "homepage_exp").addExtParams((Map)localHashMap);
    Intrinsics.checkExpressionValueIsNotNull(paramString1, "builder");
    a(paramString1, "gzh_exposure");
  }
  
  @JvmStatic
  private static final void a(String paramString1, String paramString2, String paramString3)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("homepage_from", c(paramString1));
    paramString1 = i(paramString2, paramString3).addParams("action_id", String.valueOf(1000001)).addExtParams((Map)localHashMap);
    Intrinsics.checkExpressionValueIsNotNull(paramString1, "builder");
    a(paramString1, "gzh_click");
  }
  
  @JvmStatic
  public static final void a(@Nullable String paramString1, @NotNull String paramString2, @Nullable String paramString3, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramString2, "positionId");
    HashMap localHashMap = new HashMap();
    localHashMap.put("homepage_from", c(paramString1));
    paramString1 = i(paramString3, paramString2).addParams("action_id", String.valueOf(paramInt)).addExtParams((Map)localHashMap);
    Intrinsics.checkExpressionValueIsNotNull(paramString1, "builder");
    a(paramString1, "gzh_click");
  }
  
  @JvmStatic
  public static final void a(@Nullable String paramString1, @NotNull String paramString2, @Nullable String paramString3, @Nullable String paramString4, @Nullable String paramString5, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramString2, "positionId");
    HashMap localHashMap = new HashMap();
    localHashMap.put("homepage_from", c(paramString1));
    if (paramString5 == null) {
      paramString5 = "";
    }
    localHashMap.put("tab_type", paramString5);
    localHashMap.put("tag_id", String.valueOf(paramInt));
    paramString1 = a(a.d(paramString4), 10019).addParams("position", paramString2).addParams("feed_id", paramString3).addParams("owner_id", paramString4).addExtParams((Map)localHashMap);
    Intrinsics.checkExpressionValueIsNotNull(paramString1, "builder");
    a(paramString1, "gzh_exposure");
  }
  
  @JvmStatic
  @NotNull
  public static final String b(@Nullable String paramString)
  {
    return a(a.d(paramString));
  }
  
  @JvmStatic
  private static final String b(boolean paramBoolean)
  {
    if (paramBoolean) {
      return "1";
    }
    return "0";
  }
  
  @JvmStatic
  public static final void b(@Nullable String paramString1, @Nullable String paramString2)
  {
    WSPublicAccReport.getInstance().reportPageVisitExit(b(paramString2), (Map)h(paramString1, paramString2));
  }
  
  @JvmStatic
  public static final void b(@Nullable String paramString1, @NotNull String paramString2, @Nullable String paramString3, @Nullable String paramString4, @Nullable String paramString5, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramString2, "positionId");
    HashMap localHashMap = new HashMap();
    localHashMap.put("homepage_from", c(paramString1));
    if (paramString5 == null) {
      paramString5 = "";
    }
    localHashMap.put("tab_type", paramString5);
    localHashMap.put("tag_id", String.valueOf(paramInt));
    paramString1 = a(a.d(paramString4), 10019).addParams("position", paramString2).addParams("feed_id", paramString3).addParams("owner_id", paramString4).addParams("action_id", String.valueOf(1000001)).addExtParams((Map)localHashMap);
    Intrinsics.checkExpressionValueIsNotNull(paramString1, "builder");
    a(paramString1, "gzh_click");
  }
  
  @JvmStatic
  @NotNull
  public static final String c(@Nullable String paramString)
  {
    if (paramString != null) {
      switch (paramString.hashCode())
      {
      default: 
        break;
      case 193277936: 
        if (paramString.equals("click_avatar")) {
          return "2";
        }
        break;
      case 3343801: 
        if (paramString.equals("main")) {
          return "6";
        }
        break;
      case 108417: 
        if (paramString.equals("msg")) {
          return "7";
        }
        break;
      case -596386102: 
        if (paramString.equals("slide_enter")) {
          return "1";
        }
        break;
      case -694359057: 
        if (paramString.equals("at_nick")) {
          return "5";
        }
        break;
      case -1209335648: 
        if (paramString.equals("qq_schema")) {
          return "4";
        }
        break;
      case -1849961962: 
        if (paramString.equals("my_profile")) {
          return "3";
        }
        break;
      }
    }
    return "";
  }
  
  @JvmStatic
  public static final void c(@Nullable String paramString1, @Nullable String paramString2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("homepage_from", c(paramString1));
    paramString1 = i(paramString2, "homepage_exp").addExtParams((Map)localHashMap);
    Intrinsics.checkExpressionValueIsNotNull(paramString1, "builder");
    a(paramString1, "gzh_exposure");
  }
  
  @JvmStatic
  public static final void d(@Nullable String paramString1, @Nullable String paramString2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("homepage_from", c(paramString1));
    paramString1 = i(paramString2, "feedback").addParams("action_id", String.valueOf(1000001)).addExtParams((Map)localHashMap);
    Intrinsics.checkExpressionValueIsNotNull(paramString1, "builder");
    a(paramString1, "gzh_click");
  }
  
  private final boolean d(String paramString)
  {
    return TextUtils.equals((CharSequence)paramString, (CharSequence)WeishiUtils.n());
  }
  
  @JvmStatic
  public static final void e(@Nullable String paramString1, @Nullable String paramString2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("homepage_from", c(paramString1));
    paramString1 = i(paramString2, "feedback").addParams("action_id", String.valueOf(1000001)).addExtParams((Map)localHashMap);
    Intrinsics.checkExpressionValueIsNotNull(paramString1, "builder");
    a(paramString1, "gzh_click");
  }
  
  @JvmStatic
  public static final void f(@Nullable String paramString1, @Nullable String paramString2)
  {
    a(paramString1, paramString2, "works_tab");
  }
  
  @JvmStatic
  public static final void g(@Nullable String paramString1, @Nullable String paramString2)
  {
    a(paramString1, paramString2, "like_tab");
  }
  
  @JvmStatic
  private static final HashMap<String, String> h(String paramString1, String paramString2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("homepage_from", c(paramString1));
    if (paramString2 == null) {
      paramString2 = "";
    }
    localHashMap.put("owner_id", paramString2);
    return localHashMap;
  }
  
  @JvmStatic
  private static final WSStatisticsReporter.Builder i(String paramString1, String paramString2)
  {
    paramString2 = a(a.d(paramString1), 10015).addParams("position", paramString2).addParams("feed_id", "");
    if (paramString1 == null) {
      paramString1 = "";
    }
    paramString1 = paramString2.addParams("owner_id", paramString1);
    Intrinsics.checkExpressionValueIsNotNull(paramString1, "createReportBuilder(isHo…_OWNER_ID, ownerId ?: \"\")");
    return paramString1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.profile.WSProfileBeaconReport
 * JD-Core Version:    0.7.0.1
 */