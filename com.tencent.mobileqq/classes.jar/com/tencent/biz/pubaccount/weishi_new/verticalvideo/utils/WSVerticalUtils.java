package com.tencent.biz.pubaccount.weishi_new.verticalvideo.utils;

import NS_KING_SOCIALIZE_META.stMetaUgcVideoSeg;
import UserGrowth.stSimpleMetaFeed;
import android.app.Activity;
import android.text.TextUtils;
import android.widget.RelativeLayout;
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
    int i = 2;
    if (TextUtils.equals(paramString, "trends")) {
      i = 6;
    }
    do
    {
      return i;
      if (TextUtils.equals(paramString, "aio_home_page")) {
        return 12;
      }
    } while (!TextUtils.equals(paramString, "qqchat"));
    return 10007;
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
      while (i < paramInt + 1 + 3)
      {
        a(localArrayList, paramList, i);
        i += 1;
      }
    }
    int i = paramInt - 1;
    while (i > paramInt - 1 - 3)
    {
      a(localArrayList, paramList, i);
      i -= 1;
    }
    return localArrayList;
  }
  
  public static void a(Activity paramActivity, RelativeLayout paramRelativeLayout)
  {
    if ((paramActivity != null) && (paramRelativeLayout != null)) {
      paramRelativeLayout.setPadding(paramRelativeLayout.getPaddingLeft(), paramRelativeLayout.getPaddingTop() + WeishiUIUtil.a(paramActivity), paramRelativeLayout.getPaddingRight(), paramRelativeLayout.getPaddingBottom());
    }
  }
  
  public static void a(String paramString, List<WSVerticalItemData> paramList)
  {
    if (QLog.isColorLevel())
    {
      if (paramList == null) {
        WSLog.d("FEED_TITLE", paramString + " itemList is null!");
      }
    }
    else {
      return;
    }
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (WSVerticalItemData)localIterator.next();
      if ((((WSVerticalItemData)localObject).a() instanceof stSimpleMetaFeed))
      {
        localObject = ((WSVerticalItemData)localObject).a();
        WSLog.a("FEED_TITLE", paramString + " title:" + ((stSimpleMetaFeed)localObject).feed_desc);
      }
    }
    WSLog.b("FEED_TITLE", paramString + " feedListSize:" + paramList.size());
  }
  
  private static void a(List<WSVideoPreDownloadManager.VideoPreDownloadParam> paramList, List<WSVerticalItemData> paramList1, int paramInt)
  {
    if ((paramList1.size() > paramInt) && (paramInt >= 0))
    {
      paramList1 = (WSVerticalItemData)paramList1.get(paramInt);
      if ((paramList1.a() instanceof stSimpleMetaFeed)) {}
    }
    else
    {
      return;
    }
    paramList.add(a(paramList1.a()));
  }
  
  public static boolean a(Set<String> paramSet, int paramInt, WSVideoInfo paramWSVideoInfo)
  {
    if (paramInt == 1) {
      if (!TextUtils.isEmpty(paramWSVideoInfo.a)) {
        paramSet.add(paramWSVideoInfo.a);
      }
    }
    for (;;)
    {
      return false;
      if (!paramSet.contains(paramWSVideoInfo.a))
      {
        WSLog.d("WSVerticalUtils", "[checkNoStartedVideo] title:" + paramWSVideoInfo.d);
        return true;
      }
      paramSet.remove(paramWSVideoInfo.a);
    }
  }
  
  public static int b(String paramString)
  {
    if ((TextUtils.equals(paramString, "recommend_tab")) || (TextUtils.equals(paramString, "trends")) || (TextUtils.equals(paramString, "aio_new_msg")) || (TextUtils.equals(paramString, "mini_app_personal_main")) || (TextUtils.equals(paramString, "mini_app_personal_guest")) || (TextUtils.equals(paramString, "vertical_layer_collection")) || (TextUtils.equals(paramString, "vertical_layer_collection_of_card")) || (TextUtils.equals(paramString, "aio_home_page")) || (TextUtils.equals(paramString, "qqchat"))) {
      return 1;
    }
    if ((TextUtils.equals(paramString, "follow_tab")) || (TextUtils.equals(paramString, "friend_feed"))) {
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.utils.WSVerticalUtils
 * JD-Core Version:    0.7.0.1
 */