package com.tencent.biz.pubaccount.weishi_new.report;

import UserGrowth.stSimpleMetaFeed;
import UserGrowth.stSimpleMetaPerson;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerParam;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerWrapper;
import com.tencent.biz.pubaccount.weishi_new.player.WSVideoInfo;
import com.tencent.biz.pubaccount.weishi_new.util.FeedTextParser.WSTopic;
import com.tencent.biz.pubaccount.weishi_new.util.FeedTextParser.WSUser;
import com.tencent.biz.pubaccount.weishi_new.util.WSFeedUtils;
import com.tencent.biz.pubaccount.weishi_new.util.WSInitializeHelper;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.utils.WSVerticalUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WSFollowBeaconReport
{
  private static final Set<String> a = new HashSet();
  
  public static void a()
  {
    a("friend_info", 1000001, null, null);
  }
  
  public static void a(int paramInt)
  {
    WSStatisticsReporter.Builder localBuilder = b("focus").addParams(WSPublicAccReport.getInstance().getFeedsBaseParamsWithoutFeed("focus_recommend_gap", 0));
    HashMap localHashMap = new HashMap();
    localHashMap.put("gap_type", String.valueOf(paramInt));
    localBuilder.addExtParams(localHashMap);
    b(localBuilder, "gzh_exposure");
  }
  
  public static void a(int paramInt1, int paramInt2, stSimpleMetaFeed paramstSimpleMetaFeed, boolean paramBoolean, int paramInt3)
  {
    HashMap localHashMap = new HashMap();
    if ((paramstSimpleMetaFeed != null) && (paramstSimpleMetaFeed.poster != null))
    {
      if (!WSFeedUtils.a(paramstSimpleMetaFeed.poster.followStatus)) {
        break label159;
      }
      str = "1";
      localHashMap.put("is_focus", str);
      if (paramInt3 <= 1) {
        break label166;
      }
      str = "1";
      label59:
      localHashMap.put("is_fold", str);
      localHashMap.put("fold_num", String.valueOf(paramInt3));
      if (!paramBoolean) {
        break label173;
      }
      str = "1";
      label94:
      localHashMap.put("is_unread", str);
      if (!WSFeedUtils.a(paramstSimpleMetaFeed.poster)) {
        break label180;
      }
    }
    label159:
    label166:
    label173:
    label180:
    for (String str = "1";; str = "0")
    {
      localHashMap.put("is_livenow", str);
      a("friend_video" + paramInt1, paramInt2, localHashMap, paramstSimpleMetaFeed);
      return;
      str = "0";
      break;
      str = "0";
      break label59;
      str = "0";
      break label94;
    }
  }
  
  public static void a(int paramInt1, stSimpleMetaFeed paramstSimpleMetaFeed, boolean paramBoolean, int paramInt2)
  {
    HashMap localHashMap = new HashMap();
    if ((paramstSimpleMetaFeed != null) && (paramstSimpleMetaFeed.poster != null))
    {
      if (!WSFeedUtils.a(paramstSimpleMetaFeed.poster.followStatus)) {
        break label156;
      }
      str = "1";
      localHashMap.put("is_focus", str);
      if (paramInt2 <= 1) {
        break label163;
      }
      str = "1";
      label58:
      localHashMap.put("is_fold", str);
      localHashMap.put("fold_num", String.valueOf(paramInt2));
      if (!paramBoolean) {
        break label170;
      }
      str = "1";
      label92:
      localHashMap.put("is_unread", str);
      if (!WSFeedUtils.a(paramstSimpleMetaFeed.poster)) {
        break label177;
      }
    }
    label156:
    label163:
    label170:
    label177:
    for (String str = "1";; str = "0")
    {
      localHashMap.put("is_livenow", str);
      a("friend_video" + paramInt1, localHashMap, paramstSimpleMetaFeed);
      return;
      str = "0";
      break;
      str = "0";
      break label58;
      str = "0";
      break label92;
    }
  }
  
  public static void a(int paramInt, stSimpleMetaFeed paramstSimpleMetaFeed, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, ArrayList<FeedTextParser.WSUser> paramArrayList, ArrayList<FeedTextParser.WSTopic> paramArrayList1)
  {
    new WSFollowBeaconReport.1(paramInt, paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4, paramBoolean5, paramstSimpleMetaFeed, paramArrayList, paramArrayList1).run();
  }
  
  public static void a(int paramInt, stSimpleMetaPerson paramstSimpleMetaPerson)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("index", String.valueOf(paramInt));
    localHashMap.put("position_profile", "recommend_profile" + paramInt);
    localHashMap.put("position_nickname", "recommend_nickname" + paramInt);
    localHashMap.put("position_close", "recommend_close" + paramInt);
    if ((paramstSimpleMetaPerson != null) && (!WSFeedUtils.a(paramstSimpleMetaPerson.followStatus))) {
      localHashMap.put("position_follow", "recommend_follow" + paramInt);
    }
    WSStatisticsReporter.Builder localBuilder = b("focus").addParams("position", "recommend_profile_card");
    if (paramstSimpleMetaPerson != null) {}
    for (paramstSimpleMetaPerson = paramstSimpleMetaPerson.id;; paramstSimpleMetaPerson = "")
    {
      b(localBuilder.addParams("owner_id", paramstSimpleMetaPerson).addExtParams(localHashMap), "gzh_exposure");
      return;
    }
  }
  
  private static void a(int paramInt, WSPlayerParam paramWSPlayerParam, boolean paramBoolean)
  {
    long l2 = 0L;
    if ((paramWSPlayerParam == null) || (paramWSPlayerParam.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoInfo == null)) {}
    WSVideoInfo localWSVideoInfo;
    do
    {
      return;
      localWSVideoInfo = paramWSPlayerParam.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoInfo;
    } while (WSVerticalUtils.a(a, paramInt, localWSVideoInfo));
    paramWSPlayerParam = paramWSPlayerParam.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerWrapper;
    long l1;
    HashMap localHashMap;
    if (paramWSPlayerParam != null)
    {
      l1 = paramWSPlayerParam.a();
      localHashMap = new HashMap();
      localHashMap.put("event_type", paramInt + "");
      localHashMap.put("feed_id", localWSVideoInfo.a);
      localHashMap.put("owner_id", localWSVideoInfo.e);
      localHashMap.put("global_key", WSRecommendReportManager.a().a(localWSVideoInfo.f));
      localHashMap.put("feed_pass_key", localWSVideoInfo.g);
      if (paramInt == 2) {
        if (paramWSPlayerParam != null) {
          break label300;
        }
      }
    }
    for (;;)
    {
      localHashMap.put("duration", String.valueOf(l2));
      localHashMap.put("last_location", String.valueOf(l1));
      localHashMap.put("video_length", String.valueOf(localWSVideoInfo.c));
      localHashMap.put("recommend_id", "");
      localHashMap.put("poolType", String.valueOf(localWSVideoInfo.jdField_d_of_type_Int));
      WSLog.e("WS_VIDEO_PLAY_TIME", "[WSFollowBeaconReport.java][reportVerticalVideoPlay] title:" + localWSVideoInfo.jdField_d_of_type_JavaLangString + ", map:" + localHashMap.toString());
      b(b("focus").addParams(localHashMap), "gzh_video_play");
      return;
      l1 = 0L;
      break;
      label300:
      l2 = paramWSPlayerParam.a(paramBoolean);
    }
  }
  
  public static void a(WSPlayerParam paramWSPlayerParam)
  {
    a(1, paramWSPlayerParam, false);
  }
  
  public static void a(WSPlayerParam paramWSPlayerParam, boolean paramBoolean)
  {
    a(2, paramWSPlayerParam, paramBoolean);
  }
  
  public static void a(String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("page_type", paramString);
    b(b("backstage").addParams("position", "focus_pullout").addParams("feed_id", "").addParams("owner_id", "").addExtParams(localHashMap), "gzh_exposure");
  }
  
  public static void a(String paramString, int paramInt, stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    b(paramString, paramInt, null, paramstSimpleMetaFeed);
  }
  
  public static void a(String paramString1, int paramInt, String paramString2, stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    a(paramString1, paramInt, paramString2, null, paramstSimpleMetaFeed);
  }
  
  public static void a(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    b(b("focus").addParams("position", "recommend_" + paramString1 + paramInt).addParams("owner_id", paramString2).addParams("action_id", paramString3), "gzh_click");
  }
  
  public static void a(String paramString1, int paramInt, String paramString2, Map<String, String> paramMap, stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    a("dynamics_" + paramString1 + paramInt, Integer.valueOf(paramString2).intValue(), paramMap, paramstSimpleMetaFeed);
  }
  
  public static void a(String paramString, int paramInt, Map<String, String> paramMap, stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    paramString = b("focus").addParams(WSPublicAccReport.getInstance().getFeedsBaseParams(paramString, paramInt, paramstSimpleMetaFeed));
    if ((paramMap != null) && (!paramMap.isEmpty())) {
      paramString.addExtParams(paramMap);
    }
    b(paramString, "gzh_click");
  }
  
  public static void a(String paramString, Map<String, String> paramMap, stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    paramString = b("focus").addParams(WSPublicAccReport.getInstance().getFeedsBaseParams(paramString, 0, paramstSimpleMetaFeed));
    if ((paramMap != null) && (!paramMap.isEmpty())) {
      paramString.addExtParams(paramMap);
    }
    b(paramString, "gzh_exposure");
  }
  
  private static WSStatisticsReporter.Builder b(String paramString)
  {
    return new WSStatisticsReporter.Builder().setSopName(paramString).setTestId(WeishiUtils.a(9)).setPushId(WSInitializeHelper.a().a()).setFlush(true).setImmediatelyUpload(WeishiUtils.d());
  }
  
  public static void b()
  {
    a("friend_all", 1000001, null, null);
  }
  
  public static void b(int paramInt1, int paramInt2, stSimpleMetaFeed paramstSimpleMetaFeed, boolean paramBoolean, int paramInt3)
  {
    HashMap localHashMap = new HashMap();
    if ((paramstSimpleMetaFeed != null) && (paramstSimpleMetaFeed.poster != null))
    {
      if (!WSFeedUtils.a(paramstSimpleMetaFeed.poster.followStatus)) {
        break label134;
      }
      str = "1";
      localHashMap.put("is_focus", str);
      if (paramInt3 <= 1) {
        break label141;
      }
      str = "1";
      label59:
      localHashMap.put("is_fold", str);
      localHashMap.put("fold_num", String.valueOf(paramInt3));
      if (!paramBoolean) {
        break label148;
      }
    }
    label134:
    label141:
    label148:
    for (String str = "1";; str = "0")
    {
      localHashMap.put("is_unread", str);
      a("friend_focus" + paramInt1, paramInt2, localHashMap, paramstSimpleMetaFeed);
      return;
      str = "0";
      break;
      str = "0";
      break label59;
    }
  }
  
  public static void b(int paramInt1, stSimpleMetaFeed paramstSimpleMetaFeed, boolean paramBoolean, int paramInt2)
  {
    HashMap localHashMap = new HashMap();
    if ((paramstSimpleMetaFeed != null) && (paramstSimpleMetaFeed.poster != null))
    {
      if (!WSFeedUtils.a(paramstSimpleMetaFeed.poster.followStatus)) {
        break label145;
      }
      str = "1";
      localHashMap.put("is_focus", str);
      if (paramInt2 <= 1) {
        break label152;
      }
      str = "1";
      label58:
      localHashMap.put("is_fold", str);
      localHashMap.put("fold_num", String.valueOf(paramInt2));
      if (!paramBoolean) {
        break label159;
      }
    }
    label145:
    label152:
    label159:
    for (String str = "1";; str = "0")
    {
      localHashMap.put("is_unread", str);
      localHashMap.put("is_livenow", "1");
      a("friend_live_headpic" + paramInt1, 1000001, localHashMap, paramstSimpleMetaFeed);
      return;
      str = "0";
      break;
      str = "0";
      break label58;
    }
  }
  
  private static void b(WSStatisticsReporter.Builder paramBuilder, String paramString)
  {
    WSLog.b("WSFollowBeaconReport", paramString + ", " + paramBuilder.getSopName() + ": " + paramBuilder.getParams().toString());
    paramBuilder.build(paramString).report();
  }
  
  public static void b(String paramString, int paramInt, Map<String, String> paramMap, stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    a("dynamics_" + paramString + paramInt, paramMap, paramstSimpleMetaFeed);
  }
  
  public static void c()
  {
    a("friend_info_float", 1000001, null, null);
  }
  
  private static void c(Map<String, String> paramMap, ArrayList<FeedTextParser.WSTopic> paramArrayList, int paramInt)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      int i = 0;
      while (i < paramArrayList.size())
      {
        localStringBuilder.append("dynamics_topic").append(paramInt).append(":").append(((FeedTextParser.WSTopic)paramArrayList.get(i)).a);
        if (i != paramArrayList.size() - 1) {
          localStringBuilder.append("#");
        }
        i += 1;
      }
      paramMap.put("position_topic", localStringBuilder.toString());
    }
  }
  
  public static void d()
  {
    a("friend_info_float", null, null);
  }
  
  private static void d(Map<String, String> paramMap, ArrayList<FeedTextParser.WSUser> paramArrayList, int paramInt)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      int i = 0;
      while (i < paramArrayList.size())
      {
        localStringBuilder.append("dynamics_user_at").append(paramInt).append(":").append(((FeedTextParser.WSUser)paramArrayList.get(i)).a);
        if (i != paramArrayList.size() - 1) {
          localStringBuilder.append("#");
        }
        i += 1;
      }
      paramMap.put("position_at", localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.report.WSFollowBeaconReport
 * JD-Core Version:    0.7.0.1
 */