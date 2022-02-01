package com.tencent.biz.pubaccount.weishi_new.report;

import UserGrowth.stSimpleMetaFeed;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi_new.util.WSInitializeHelper;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.report.WSVerticalBeaconReport;
import java.util.HashMap;
import java.util.Map;

public class WSCommentBeaconReport
{
  private static WSStatisticsReporter.Builder a(String paramString)
  {
    return new WSStatisticsReporter.Builder().setTabId(d(paramString)).setSopName(paramString).setTestId(WeishiUtils.a(10003)).setPushId(WSInitializeHelper.a().a()).setFlush(true);
  }
  
  public static String a(String paramString)
  {
    if ("fullscreen_videoplay".equals(paramString)) {
      return "comment_entry";
    }
    if ("focus".equals(paramString)) {
      return "dynamics_comment_entry";
    }
    if ("focus_fallback".equals(paramString)) {}
    return "dynamics_comment_entry";
  }
  
  private static void a(WSStatisticsReporter.Builder paramBuilder, String paramString)
  {
    paramBuilder.build(paramString).report();
  }
  
  public static void a(String paramString, int paramInt1, int paramInt2, stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("dynamics_comment_like");
    localStringBuilder.append(paramInt1);
    a(localStringBuilder.toString(), paramString, paramInt2, null, paramstSimpleMetaFeed);
  }
  
  public static void a(String paramString1, String paramString2, int paramInt, stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    a(paramString2, paramString1, paramInt, null, paramstSimpleMetaFeed);
  }
  
  public static void a(String paramString1, String paramString2, int paramInt, stSimpleMetaFeed paramstSimpleMetaFeed, boolean paramBoolean1, boolean paramBoolean2, Map<String, String> paramMap)
  {
    Object localObject1;
    if (TextUtils.equals(paramString1, "focus"))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("dynamics_comment_page_reply");
      ((StringBuilder)localObject1).append(paramInt);
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    else if (paramBoolean1)
    {
      localObject1 = "comment_page_reply_explicit";
    }
    else
    {
      localObject1 = "comment_page_reply";
    }
    if (paramBoolean2) {
      paramInt = 1002002;
    } else {
      paramInt = 1002003;
    }
    Object localObject2 = paramMap;
    if (paramMap == null) {
      localObject2 = new HashMap();
    }
    if (!TextUtils.equals(paramString1, "focus")) {
      ((Map)localObject2).put("play_scene", paramString2);
    }
    a((String)localObject1, paramString1, paramInt, (Map)localObject2, paramstSimpleMetaFeed);
  }
  
  public static void a(String paramString1, String paramString2, int paramInt, Map<String, String> paramMap, stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    paramString1 = a(paramString2).addParams(WSPublicAccReport.getInstance().getFeedsBaseParams(paramString1, paramInt, paramstSimpleMetaFeed));
    if ((paramMap != null) && (!paramMap.isEmpty())) {
      paramString1.addExtParams(paramMap);
    }
    a(paramString1, "gzh_click");
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, stSimpleMetaFeed paramstSimpleMetaFeed, Map<String, String> paramMap)
  {
    Object localObject = paramMap;
    if (paramMap == null) {
      localObject = new HashMap();
    }
    if (!TextUtils.equals(paramString1, "focus")) {
      ((Map)localObject).put("play_scene", paramString2);
    }
    ((Map)localObject).put("object", String.valueOf(paramInt2));
    a(paramString3, paramString1, paramInt1, (Map)localObject, paramstSimpleMetaFeed);
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, int paramInt, stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    if (!TextUtils.equals(paramString1, "focus"))
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("play_scene", paramString2);
      paramString2 = localHashMap;
    }
    else
    {
      paramString2 = null;
    }
    a(paramString3, paramString1, paramInt, paramString2, paramstSimpleMetaFeed);
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    if (!TextUtils.equals(paramString1, "focus"))
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("play_scene", paramString2);
      paramString2 = localHashMap;
    }
    else
    {
      paramString2 = null;
    }
    a(paramString3, paramString1, paramString2, paramstSimpleMetaFeed);
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, stSimpleMetaFeed paramstSimpleMetaFeed, Map<String, String> paramMap)
  {
    Object localObject = paramMap;
    if (paramMap == null) {
      localObject = new HashMap();
    }
    if (!TextUtils.equals(paramString1, "focus"))
    {
      localObject = new HashMap();
      ((Map)localObject).put("play_scene", paramString2);
    }
    a(paramString3, paramString1, (Map)localObject, paramstSimpleMetaFeed);
  }
  
  public static void a(String paramString1, String paramString2, Map<String, String> paramMap, stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    paramString1 = a(paramString2).addParams(WSPublicAccReport.getInstance().getFeedsBaseParams(paramString1, 0, paramstSimpleMetaFeed));
    if ((paramMap != null) && (!paramMap.isEmpty())) {
      paramString1.addExtParams(paramMap);
    }
    a(paramString1, "gzh_exposure");
  }
  
  public static boolean a(String paramString)
  {
    return (TextUtils.equals(paramString, "fullscreen_videoplay")) || (TextUtils.equals(paramString, "collection_videoplay")) || (TextUtils.equals(paramString, "feeds_fullscreen")) || (TextUtils.equals(paramString, "drama_fullscreen_videoplay"));
  }
  
  public static String b(String paramString)
  {
    if (a(paramString)) {
      return "comment_page";
    }
    if ("focus".equals(paramString)) {
      return "dynamics_comment_page";
    }
    if ("focus_fallback".equals(paramString)) {}
    return "dynamics_comment_page";
  }
  
  public static void b(String paramString, int paramInt1, int paramInt2, stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("dynamics_comment_entry_text");
    localStringBuilder.append(paramInt1);
    a(localStringBuilder.toString(), paramString, paramInt2, null, paramstSimpleMetaFeed);
  }
  
  public static String c(String paramString)
  {
    if (a(paramString)) {
      return "comment_tag";
    }
    if ("focus".equals(paramString)) {
      return "dynamics_comment_tag";
    }
    if ("focus_fallback".equals(paramString)) {}
    return "dynamics_comment_tag";
  }
  
  public static String d(String paramString)
  {
    if (a(paramString)) {
      return WSVerticalBeaconReport.a();
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.report.WSCommentBeaconReport
 * JD-Core Version:    0.7.0.1
 */