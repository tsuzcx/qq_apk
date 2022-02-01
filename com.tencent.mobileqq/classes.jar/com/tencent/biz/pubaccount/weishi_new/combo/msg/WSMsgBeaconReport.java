package com.tencent.biz.pubaccount.weishi_new.combo.msg;

import com.tencent.biz.pubaccount.weishi_new.report.WSPublicAccReport;
import com.tencent.biz.pubaccount.weishi_new.report.WSStatisticsReporter;
import com.tencent.biz.pubaccount.weishi_new.report.WSStatisticsReporter.Builder;
import com.tencent.biz.pubaccount.weishi_new.util.WSInitializeHelper;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/weishi_new/combo/msg/WSMsgBeaconReport;", "", "()V", "ICON_TYPE_FANS", "", "ICON_TYPE_LIKE", "ICON_TYPE_PRIVATE", "KEY_FANS_RED_NUM", "", "KEY_LIKE_RED_NUM", "KEY_MSG_ID", "KEY_PRIVATE_RED_NUM", "KEY_REPLY_DELETE", "KEY_REPLY_STATUS", "KEY_THEME_ID", "KEY_USER_ID", "POSITION_ALL_ICON", "POSITION_CONTENT_ITEM", "POSITION_ITEM_OTHER_PLACE", "POSITION_SECTION_JUMP", "POSITION_USER_HEAD", "createReportBuilder", "Lcom/tencent/biz/pubaccount/weishi_new/report/WSStatisticsReporter$Builder;", "doReport", "", "builder", "eventName", "msgItemClick", "msgId", "themeId", "userId", "actionId", "feedId", "flag", "delFlag", "msgItemExposure", "msgPageHeaderClick", "redNum", "iconType", "msgPageHeaderExposure", "likeRedNum", "fansRedNum", "privateRedNum", "msgSectionClick", "msgUserAreaClick", "qqweishi_impl_release"}, k=1, mv={1, 1, 16})
public final class WSMsgBeaconReport
{
  public static final WSMsgBeaconReport a = new WSMsgBeaconReport();
  
  @JvmStatic
  private static final WSStatisticsReporter.Builder a()
  {
    WSStatisticsReporter.Builder localBuilder = new WSStatisticsReporter.Builder().setSopName("message");
    WSInitializeHelper localWSInitializeHelper = WSInitializeHelper.a();
    Intrinsics.checkExpressionValueIsNotNull(localWSInitializeHelper, "WSInitializeHelper.getInstance()");
    localBuilder = localBuilder.setPushId(localWSInitializeHelper.f()).setFlush(true);
    Intrinsics.checkExpressionValueIsNotNull(localBuilder, "WSStatisticsReporter.Bui…          .setFlush(true)");
    return localBuilder;
  }
  
  @JvmStatic
  public static final void a(int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject = new HashMap();
    ((HashMap)localObject).put("like_num", String.valueOf(paramInt1));
    ((HashMap)localObject).put("fans_num", String.valueOf(paramInt2));
    ((HashMap)localObject).put("letter_num", String.valueOf(paramInt3));
    localObject = a().addParams(WSPublicAccReport.getInstance().getFeedsBaseParamsWithoutFeed("all_icon", 0)).addExtParams((Map)localObject);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "builder");
    a((WSStatisticsReporter.Builder)localObject, "gzh_exposure");
  }
  
  @JvmStatic
  private static final void a(WSStatisticsReporter.Builder paramBuilder, String paramString)
  {
    paramBuilder.build(paramString).report();
  }
  
  @JvmStatic
  public static final void a(@NotNull String paramString, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "themeId");
    HashMap localHashMap = new HashMap();
    localHashMap.put("theme_id", paramString);
    paramString = a().addParams(WSPublicAccReport.getInstance().getFeedsBaseParamsWithoutFeed("jump_btn", paramInt)).addExtParams((Map)localHashMap);
    Intrinsics.checkExpressionValueIsNotNull(paramString, "builder");
    a(paramString, "gzh_click");
  }
  
  @JvmStatic
  public static final void a(@NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "msgId");
    Intrinsics.checkParameterIsNotNull(paramString2, "themeId");
    HashMap localHashMap = new HashMap();
    localHashMap.put("message_id", paramString1);
    localHashMap.put("theme_id", paramString2);
    paramString1 = a().addParams(WSPublicAccReport.getInstance().getFeedsBaseParamsWithoutFeed("content_item", 0)).addExtParams((Map)localHashMap);
    Intrinsics.checkExpressionValueIsNotNull(paramString1, "builder");
    a(paramString1, "gzh_exposure");
  }
  
  @JvmStatic
  public static final void a(@NotNull String paramString1, @NotNull String paramString2, @NotNull String paramString3, int paramInt1, @NotNull String paramString4, int paramInt2, int paramInt3)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "msgId");
    Intrinsics.checkParameterIsNotNull(paramString2, "themeId");
    Intrinsics.checkParameterIsNotNull(paramString3, "userId");
    Intrinsics.checkParameterIsNotNull(paramString4, "feedId");
    HashMap localHashMap = new HashMap();
    localHashMap.put("message_id", paramString1);
    localHashMap.put("theme_id", paramString2);
    localHashMap.put("user_id", paramString3);
    localHashMap.put("reply_status", String.valueOf(paramInt2));
    localHashMap.put("reply_delete", String.valueOf(paramInt3));
    paramString1 = a().addParams("position", "item_other_place").addParams("feed_id", paramString4).addParams("owner_id", "").addParams("action_id", String.valueOf(paramInt1)).addExtParams((Map)localHashMap);
    Intrinsics.checkExpressionValueIsNotNull(paramString1, "builder");
    a(paramString1, "gzh_click");
  }
  
  @JvmStatic
  public static final void a(@NotNull String paramString1, @NotNull String paramString2, @NotNull String paramString3, @NotNull String paramString4)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "msgId");
    Intrinsics.checkParameterIsNotNull(paramString2, "themeId");
    Intrinsics.checkParameterIsNotNull(paramString3, "userId");
    Intrinsics.checkParameterIsNotNull(paramString4, "feedId");
    HashMap localHashMap = new HashMap();
    localHashMap.put("message_id", paramString1);
    localHashMap.put("theme_id", paramString2);
    localHashMap.put("user_id", paramString3);
    paramString1 = a().addParams("position", "headpic").addParams("feed_id", paramString4).addParams("owner_id", "").addParams("action_id", String.valueOf(1000001)).addExtParams((Map)localHashMap);
    Intrinsics.checkExpressionValueIsNotNull(paramString1, "builder");
    a(paramString1, "gzh_click");
  }
  
  @JvmStatic
  public static final void b(int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject = new HashMap();
    ((HashMap)localObject).put("num", String.valueOf(paramInt1));
    ((HashMap)localObject).put("icon_type", String.valueOf(paramInt2));
    localObject = a().addParams(WSPublicAccReport.getInstance().getFeedsBaseParamsWithoutFeed("all_icon", paramInt3)).addExtParams((Map)localObject);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "builder");
    a((WSStatisticsReporter.Builder)localObject, "gzh_click");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.combo.msg.WSMsgBeaconReport
 * JD-Core Version:    0.7.0.1
 */