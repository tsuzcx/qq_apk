package com.tencent.biz.pubaccount.weishi_new.verticalvideo.utils;

import NS_KING_SOCIALIZE_META.stMetaUgcVideoSeg;
import UserGrowth.stSimpleMetaFeed;
import android.app.Activity;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.weishi_new.player.WSVideoInfo;
import com.tencent.biz.pubaccount.weishi_new.player.WSVideoPreDownloadManager.VideoPreDownloadParam;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUIUtil;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalItemData;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.jetbrains.annotations.NotNull;

public class WSVerticalUtils
{
  public static int a(String paramString)
  {
    if (TextUtils.equals(paramString, "trends")) {
      return 6;
    }
    if (TextUtils.equals(paramString, "aio_home_page")) {
      return 12;
    }
    if (TextUtils.equals(paramString, "qqchat")) {
      return 10007;
    }
    return 2;
  }
  
  public static WSVideoPreDownloadManager.VideoPreDownloadParam a(stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    WSVideoPreDownloadManager.VideoPreDownloadParam localVideoPreDownloadParam = new WSVideoPreDownloadManager.VideoPreDownloadParam(paramstSimpleMetaFeed.video_url, paramstSimpleMetaFeed.video.duration);
    localVideoPreDownloadParam.a = paramstSimpleMetaFeed.id;
    localVideoPreDownloadParam.c = paramstSimpleMetaFeed.feed_desc;
    return localVideoPreDownloadParam;
  }
  
  @NotNull
  public static String a(String paramString)
  {
    if (TextUtils.equals(paramString, "aio_home_page")) {
      return "recommend_tab";
    }
    if (TextUtils.equals(paramString, "trends")) {
      return "trends_ws";
    }
    return "vertical_page";
  }
  
  public static List<WSVerticalItemData> a(List<stSimpleMetaFeed> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      ArrayList localArrayList = new ArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        stSimpleMetaFeed localstSimpleMetaFeed = (stSimpleMetaFeed)paramList.next();
        WSVerticalItemData localWSVerticalItemData = new WSVerticalItemData();
        localWSVerticalItemData.a(localstSimpleMetaFeed);
        localArrayList.add(localWSVerticalItemData);
      }
      return localArrayList;
    }
    return null;
  }
  
  public static List<WSVideoPreDownloadManager.VideoPreDownloadParam> a(List<WSVerticalItemData> paramList, int paramInt, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = new ArrayList(paramList);
    if (paramBoolean)
    {
      i = paramInt + 1;
      paramInt = i;
      while (paramInt < i + 3)
      {
        a(localArrayList, paramList, paramInt);
        paramInt += 1;
      }
    }
    int i = paramInt - 1;
    paramInt = i;
    while (paramInt > i - 3)
    {
      a(localArrayList, paramList, paramInt);
      paramInt -= 1;
    }
    return localArrayList;
  }
  
  public static void a(Activity paramActivity, ViewGroup paramViewGroup)
  {
    if ((paramActivity != null) && (paramViewGroup != null)) {
      paramViewGroup.setPadding(paramViewGroup.getPaddingLeft(), paramViewGroup.getPaddingTop() + WeishiUIUtil.a(paramActivity), paramViewGroup.getPaddingRight(), paramViewGroup.getPaddingBottom());
    }
  }
  
  public static void a(String paramString, List<WSVerticalItemData> paramList)
  {
    if (QLog.isColorLevel())
    {
      if (paramList == null)
      {
        paramList = new StringBuilder();
        paramList.append(paramString);
        paramList.append(" itemList is null!");
        WSLog.d("FEED_TITLE", paramList.toString());
        return;
      }
      Object localObject1 = paramList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (WSVerticalItemData)((Iterator)localObject1).next();
        if ((((WSVerticalItemData)localObject2).a() instanceof stSimpleMetaFeed))
        {
          localObject2 = ((WSVerticalItemData)localObject2).a();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(paramString);
          localStringBuilder.append(" title:");
          localStringBuilder.append(((stSimpleMetaFeed)localObject2).feed_desc);
          WSLog.a("FEED_TITLE", localStringBuilder.toString());
        }
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(paramString);
      ((StringBuilder)localObject1).append(" feedListSize:");
      ((StringBuilder)localObject1).append(paramList.size());
      WSLog.b("FEED_TITLE", ((StringBuilder)localObject1).toString());
    }
  }
  
  private static void a(List<WSVideoPreDownloadManager.VideoPreDownloadParam> paramList, List<WSVerticalItemData> paramList1, int paramInt)
  {
    if ((paramList1.size() > paramInt) && (paramInt >= 0))
    {
      paramList1 = (WSVerticalItemData)paramList1.get(paramInt);
      if (!(paramList1.a() instanceof stSimpleMetaFeed)) {
        return;
      }
      paramList.add(a(paramList1.a()));
    }
  }
  
  public static boolean a(Set<String> paramSet, int paramInt, WSVideoInfo paramWSVideoInfo)
  {
    if (paramInt == 1)
    {
      if (!TextUtils.isEmpty(paramWSVideoInfo.a)) {
        paramSet.add(paramWSVideoInfo.a);
      }
    }
    else
    {
      if (!paramSet.contains(paramWSVideoInfo.a))
      {
        paramSet = new StringBuilder();
        paramSet.append("[checkNoStartedVideo] title:");
        paramSet.append(paramWSVideoInfo.d);
        WSLog.d("WSVerticalUtils", paramSet.toString());
        return true;
      }
      paramSet.remove(paramWSVideoInfo.a);
    }
    return false;
  }
  
  public static int b(String paramString)
  {
    if ((!TextUtils.equals(paramString, "recommend_tab")) && (!TextUtils.equals(paramString, "trends")) && (!TextUtils.equals(paramString, "aio_new_msg")) && (!TextUtils.equals(paramString, "mini_app_personal_main")) && (!TextUtils.equals(paramString, "mini_app_personal_guest")) && (!TextUtils.equals(paramString, "vertical_layer_collection")) && (!TextUtils.equals(paramString, "vertical_layer_collection_of_card")) && (!TextUtils.equals(paramString, "aio_home_page")) && (!TextUtils.equals(paramString, "qqchat")) && (!TextUtils.equals(paramString, "share")) && (!TextUtils.equals(paramString, "drama_history")) && (!TextUtils.equals(paramString, "drama_preview")) && (!TextUtils.equals(paramString, "qq_scheme_open_player")))
    {
      if ((!TextUtils.equals(paramString, "follow_tab")) && (!TextUtils.equals(paramString, "friend_feed"))) {
        return -1;
      }
      return 0;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.utils.WSVerticalUtils
 * JD-Core Version:    0.7.0.1
 */