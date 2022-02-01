package com.tencent.biz.pubaccount.weishi_new.report;

import UserGrowth.stSimpleMetaFeed;
import UserGrowth.stSimpleMetaPerson;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerParam;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerWrapper;
import com.tencent.biz.pubaccount.weishi_new.player.WSVideoInfo;
import com.tencent.biz.pubaccount.weishi_new.richtext.WSRichTextParserImpl.WSTopic;
import com.tencent.biz.pubaccount.weishi_new.richtext.WSRichTextParserImpl.WSUser;
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
    WSStatisticsReporter.Builder localBuilder = c("focus").addParams(WSPublicAccReport.getInstance().getFeedsBaseParamsWithoutFeed("focus_recommend_gap", 0));
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
      boolean bool = WSFeedUtils.b(paramstSimpleMetaFeed.poster.followStatus);
      String str = "1";
      if (bool) {
        localObject = "1";
      } else {
        localObject = "0";
      }
      localHashMap.put("is_focus", localObject);
      if (paramInt3 > 1) {
        localObject = "1";
      } else {
        localObject = "0";
      }
      localHashMap.put("is_fold", localObject);
      localHashMap.put("fold_num", String.valueOf(paramInt3));
      if (paramBoolean) {
        localObject = "1";
      } else {
        localObject = "0";
      }
      localHashMap.put("is_unread", localObject);
      if (WSFeedUtils.a(paramstSimpleMetaFeed.poster)) {
        localObject = str;
      } else {
        localObject = "0";
      }
      localHashMap.put("is_livenow", localObject);
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("friend_video");
    ((StringBuilder)localObject).append(paramInt1);
    a(((StringBuilder)localObject).toString(), paramInt2, localHashMap, paramstSimpleMetaFeed);
  }
  
  public static void a(int paramInt1, stSimpleMetaFeed paramstSimpleMetaFeed, boolean paramBoolean, int paramInt2)
  {
    HashMap localHashMap = new HashMap();
    if ((paramstSimpleMetaFeed != null) && (paramstSimpleMetaFeed.poster != null))
    {
      boolean bool = WSFeedUtils.b(paramstSimpleMetaFeed.poster.followStatus);
      String str = "1";
      if (bool) {
        localObject = "1";
      } else {
        localObject = "0";
      }
      localHashMap.put("is_focus", localObject);
      if (paramInt2 > 1) {
        localObject = "1";
      } else {
        localObject = "0";
      }
      localHashMap.put("is_fold", localObject);
      localHashMap.put("fold_num", String.valueOf(paramInt2));
      if (paramBoolean) {
        localObject = "1";
      } else {
        localObject = "0";
      }
      localHashMap.put("is_unread", localObject);
      if (WSFeedUtils.a(paramstSimpleMetaFeed.poster)) {
        localObject = str;
      } else {
        localObject = "0";
      }
      localHashMap.put("is_livenow", localObject);
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("friend_video");
    ((StringBuilder)localObject).append(paramInt1);
    a(((StringBuilder)localObject).toString(), localHashMap, paramstSimpleMetaFeed);
  }
  
  public static void a(int paramInt, stSimpleMetaFeed paramstSimpleMetaFeed, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, ArrayList<WSRichTextParserImpl.WSUser> paramArrayList, ArrayList<WSRichTextParserImpl.WSTopic> paramArrayList1)
  {
    new WSFollowBeaconReport.1(paramInt, paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4, paramBoolean5, paramstSimpleMetaFeed, paramArrayList, paramArrayList1).run();
  }
  
  public static void a(int paramInt, stSimpleMetaPerson paramstSimpleMetaPerson)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("index", String.valueOf(paramInt));
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("recommend_profile");
    ((StringBuilder)localObject).append(paramInt);
    localHashMap.put("position_profile", ((StringBuilder)localObject).toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("recommend_nickname");
    ((StringBuilder)localObject).append(paramInt);
    localHashMap.put("position_nickname", ((StringBuilder)localObject).toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("recommend_close");
    ((StringBuilder)localObject).append(paramInt);
    localHashMap.put("position_close", ((StringBuilder)localObject).toString());
    if ((paramstSimpleMetaPerson != null) && (!WSFeedUtils.b(paramstSimpleMetaPerson.followStatus)))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("recommend_follow");
      ((StringBuilder)localObject).append(paramInt);
      localHashMap.put("position_follow", ((StringBuilder)localObject).toString());
    }
    localObject = c("focus").addParams("position", "recommend_profile_card");
    if (paramstSimpleMetaPerson != null) {
      paramstSimpleMetaPerson = paramstSimpleMetaPerson.id;
    } else {
      paramstSimpleMetaPerson = "";
    }
    b(((WSStatisticsReporter.Builder)localObject).addParams("owner_id", paramstSimpleMetaPerson).addExtParams(localHashMap), "gzh_exposure");
  }
  
  private static void a(int paramInt, WSPlayerParam paramWSPlayerParam, boolean paramBoolean)
  {
    if (paramWSPlayerParam != null)
    {
      if (paramWSPlayerParam.c == null) {
        return;
      }
      WSVideoInfo localWSVideoInfo = paramWSPlayerParam.c;
      if (WSVerticalUtils.a(a, paramInt, localWSVideoInfo)) {
        return;
      }
      Object localObject = paramWSPlayerParam.d;
      long l2 = 0L;
      long l1;
      if (localObject != null) {
        l1 = ((WSPlayerWrapper)localObject).m();
      } else {
        l1 = 0L;
      }
      paramWSPlayerParam = new HashMap();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramInt);
      localStringBuilder.append("");
      paramWSPlayerParam.put("event_type", localStringBuilder.toString());
      paramWSPlayerParam.put("feed_id", localWSVideoInfo.a);
      paramWSPlayerParam.put("owner_id", localWSVideoInfo.j);
      paramWSPlayerParam.put("global_key", WSRecommendReportManager.a().a(localWSVideoInfo.k));
      paramWSPlayerParam.put("feed_pass_key", localWSVideoInfo.l);
      if (paramInt == 2)
      {
        if (localObject != null) {
          l2 = ((WSPlayerWrapper)localObject).c(paramBoolean);
        }
        paramWSPlayerParam.put("duration", String.valueOf(l2));
        paramWSPlayerParam.put("last_location", String.valueOf(l1));
      }
      paramWSPlayerParam.put("video_length", String.valueOf(localWSVideoInfo.d));
      paramWSPlayerParam.put("recommend_id", "");
      paramWSPlayerParam.put("poolType", String.valueOf(localWSVideoInfo.h));
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[WSFollowBeaconReport.java][reportVerticalVideoPlay] title:");
      ((StringBuilder)localObject).append(localWSVideoInfo.g);
      ((StringBuilder)localObject).append(", map:");
      ((StringBuilder)localObject).append(paramWSPlayerParam.toString());
      WSLog.e("WS_VIDEO_PLAY_TIME", ((StringBuilder)localObject).toString());
      b(c("focus").addParams(paramWSPlayerParam), "gzh_video_play");
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
    b(c("backstage").addParams("position", "focus_pullout").addParams("feed_id", "").addParams("owner_id", "").addExtParams(localHashMap), "gzh_exposure");
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
    WSStatisticsReporter.Builder localBuilder = c("focus");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("recommend_");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(paramInt);
    b(localBuilder.addParams("position", localStringBuilder.toString()).addParams("owner_id", paramString2).addParams("action_id", paramString3), "gzh_click");
  }
  
  public static void a(String paramString1, int paramInt, String paramString2, Map<String, String> paramMap, stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("dynamics_");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(paramInt);
    a(localStringBuilder.toString(), Integer.valueOf(paramString2).intValue(), paramMap, paramstSimpleMetaFeed);
  }
  
  public static void a(String paramString, int paramInt, Map<String, String> paramMap, stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    paramString = c("focus").addParams(WSPublicAccReport.getInstance().getFeedsBaseParams(paramString, paramInt, paramstSimpleMetaFeed));
    if ((paramMap != null) && (!paramMap.isEmpty())) {
      paramString.addExtParams(paramMap);
    }
    b(paramString, "gzh_click");
  }
  
  public static void a(String paramString, Map<String, String> paramMap, stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    paramString = c("focus").addParams(WSPublicAccReport.getInstance().getFeedsBaseParams(paramString, 0, paramstSimpleMetaFeed));
    if ((paramMap != null) && (!paramMap.isEmpty())) {
      paramString.addExtParams(paramMap);
    }
    b(paramString, "gzh_exposure");
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
      boolean bool = WSFeedUtils.b(paramstSimpleMetaFeed.poster.followStatus);
      String str = "1";
      if (bool) {
        localObject = "1";
      } else {
        localObject = "0";
      }
      localHashMap.put("is_focus", localObject);
      if (paramInt3 > 1) {
        localObject = "1";
      } else {
        localObject = "0";
      }
      localHashMap.put("is_fold", localObject);
      localHashMap.put("fold_num", String.valueOf(paramInt3));
      if (paramBoolean) {
        localObject = str;
      } else {
        localObject = "0";
      }
      localHashMap.put("is_unread", localObject);
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("friend_focus");
    ((StringBuilder)localObject).append(paramInt1);
    a(((StringBuilder)localObject).toString(), paramInt2, localHashMap, paramstSimpleMetaFeed);
  }
  
  public static void b(int paramInt1, stSimpleMetaFeed paramstSimpleMetaFeed, boolean paramBoolean, int paramInt2)
  {
    HashMap localHashMap = new HashMap();
    if ((paramstSimpleMetaFeed != null) && (paramstSimpleMetaFeed.poster != null))
    {
      boolean bool = WSFeedUtils.b(paramstSimpleMetaFeed.poster.followStatus);
      String str = "0";
      if (bool) {
        localObject = "1";
      } else {
        localObject = "0";
      }
      localHashMap.put("is_focus", localObject);
      if (paramInt2 > 1) {
        localObject = "1";
      } else {
        localObject = "0";
      }
      localHashMap.put("is_fold", localObject);
      localHashMap.put("fold_num", String.valueOf(paramInt2));
      localObject = str;
      if (paramBoolean) {
        localObject = "1";
      }
      localHashMap.put("is_unread", localObject);
      localHashMap.put("is_livenow", "1");
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("friend_live_headpic");
    ((StringBuilder)localObject).append(paramInt1);
    a(((StringBuilder)localObject).toString(), 1000001, localHashMap, paramstSimpleMetaFeed);
  }
  
  private static void b(WSStatisticsReporter.Builder paramBuilder, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(", ");
    localStringBuilder.append(paramBuilder.getSopName());
    localStringBuilder.append(": ");
    localStringBuilder.append(paramBuilder.getParams().toString());
    WSLog.e("WSFollowBeaconReport", localStringBuilder.toString());
    paramBuilder.build(paramString).report();
  }
  
  public static void b(String paramString, int paramInt, Map<String, String> paramMap, stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("dynamics_");
    localStringBuilder.append(paramString);
    localStringBuilder.append(paramInt);
    a(localStringBuilder.toString(), paramMap, paramstSimpleMetaFeed);
  }
  
  private static WSStatisticsReporter.Builder c(String paramString)
  {
    return new WSStatisticsReporter.Builder().setSopName(paramString).setTestId(WeishiUtils.a(9)).setPushId(WSInitializeHelper.a().f()).setFlush(true);
  }
  
  public static void c()
  {
    a("friend_info_float", 1000001, null, null);
  }
  
  private static void c(Map<String, String> paramMap, ArrayList<WSRichTextParserImpl.WSTopic> paramArrayList, int paramInt)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      int i = 0;
      while (i < paramArrayList.size())
      {
        localStringBuilder.append("dynamics_topic");
        localStringBuilder.append(paramInt);
        localStringBuilder.append(":");
        localStringBuilder.append(((WSRichTextParserImpl.WSTopic)paramArrayList.get(i)).a);
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
  
  private static void d(Map<String, String> paramMap, ArrayList<WSRichTextParserImpl.WSUser> paramArrayList, int paramInt)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      int i = 0;
      while (i < paramArrayList.size())
      {
        localStringBuilder.append("dynamics_user_at");
        localStringBuilder.append(paramInt);
        localStringBuilder.append(":");
        localStringBuilder.append(((WSRichTextParserImpl.WSUser)paramArrayList.get(i)).a);
        if (i != paramArrayList.size() - 1) {
          localStringBuilder.append("#");
        }
        i += 1;
      }
      paramMap.put("position_at", localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.report.WSFollowBeaconReport
 * JD-Core Version:    0.7.0.1
 */