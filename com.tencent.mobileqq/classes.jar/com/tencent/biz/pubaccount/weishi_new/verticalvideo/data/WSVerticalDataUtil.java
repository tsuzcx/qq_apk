package com.tencent.biz.pubaccount.weishi_new.verticalvideo.data;

import UserGrowth.stCollection;
import UserGrowth.stDrama;
import UserGrowth.stDramaFeed;
import UserGrowth.stDramaInfo;
import UserGrowth.stSimpleMetaFeed;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.pubaccount.weishi_new.commercial.WSWidgetDataManager;
import com.tencent.biz.pubaccount.weishi_new.drama.data.WSDramaItemData;
import com.tencent.biz.pubaccount.weishi_new.push.WSRedDotPushMsg;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.gdt.GdtAdUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.WeishiManager;
import com.tencent.ttpic.baseutils.collection.CollectionUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class WSVerticalDataUtil
{
  public static int a(@Nullable WSVerticalItemData paramWSVerticalItemData)
  {
    if ((paramWSVerticalItemData != null) && (paramWSVerticalItemData.g() != null)) {
      return paramWSVerticalItemData.g().c();
    }
    return 0;
  }
  
  @NonNull
  public static WSVerticalItemData a(@NonNull stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    WSVerticalItemData localWSVerticalItemData = new WSVerticalItemData();
    a(paramstSimpleMetaFeed, localWSVerticalItemData);
    paramstSimpleMetaFeed.opInfo = WSWidgetDataManager.a(paramstSimpleMetaFeed);
    localWSVerticalItemData.a(paramstSimpleMetaFeed);
    return localWSVerticalItemData;
  }
  
  @Nullable
  public static WSVerticalItemData a(@Nullable WSDramaItemData paramWSDramaItemData)
  {
    if (paramWSDramaItemData != null)
    {
      Object localObject = paramWSDramaItemData.g();
      if (localObject != null)
      {
        WSVerticalItemData localWSVerticalItemData = new WSVerticalItemData();
        localObject = new WSDramaEpisodeInfo(paramWSDramaItemData.b(), a(paramWSDramaItemData.f()), ((stDramaFeed)localObject).num);
        ((WSDramaEpisodeInfo)localObject).a(paramWSDramaItemData.f());
        localWSVerticalItemData.b(paramWSDramaItemData.j());
        localWSVerticalItemData.a((WSDramaEpisodeInfo)localObject);
        localWSVerticalItemData.a(paramWSDramaItemData.i());
        return localWSVerticalItemData;
      }
    }
    return null;
  }
  
  public static String a()
  {
    WeishiManager localWeishiManager = WeishiUtils.d();
    if (localWeishiManager != null) {
      return localWeishiManager.d();
    }
    return "";
  }
  
  @NonNull
  private static String a(@Nullable stDrama paramstDrama)
  {
    if ((paramstDrama != null) && (paramstDrama.dramaInfo != null))
    {
      paramstDrama = paramstDrama.dramaInfo.name;
      if (paramstDrama != null) {
        return paramstDrama;
      }
    }
    return "";
  }
  
  @NonNull
  public static ArrayList<WSVerticalItemData> a(@Nullable stDrama paramstDrama, @Nullable List<stDramaFeed> paramList, boolean paramBoolean)
  {
    String str = a(paramstDrama);
    ArrayList localArrayList = new ArrayList();
    if (CollectionUtils.isEmpty(paramList)) {
      return localArrayList;
    }
    int i = 0;
    while (i < paramList.size())
    {
      Object localObject = (stDramaFeed)paramList.get(i);
      if ((localObject != null) && (((stDramaFeed)localObject).feed != null))
      {
        WSVerticalItemData localWSVerticalItemData = a(((stDramaFeed)localObject).feed);
        localObject = new WSDramaEpisodeInfo(((stDramaFeed)localObject).dramaID, str, ((stDramaFeed)localObject).num);
        ((WSDramaEpisodeInfo)localObject).a(paramstDrama);
        boolean bool = true;
        if ((!paramBoolean) || (i != paramList.size() - 1)) {
          bool = false;
        }
        localWSVerticalItemData.b(bool);
        localWSVerticalItemData.a((WSDramaEpisodeInfo)localObject);
        localArrayList.add(localWSVerticalItemData);
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public static ArrayList<String> a(boolean paramBoolean, List<WSVerticalItemData> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramBoolean)
    {
      if (paramList == null) {
        return localArrayList;
      }
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        WSVerticalItemData localWSVerticalItemData = (WSVerticalItemData)paramList.next();
        if ((localWSVerticalItemData != null) && (localWSVerticalItemData.b() != null)) {
          localArrayList.add(localWSVerticalItemData.b().id);
        }
      }
    }
    return localArrayList;
  }
  
  public static List<WSVerticalItemData> a(List<stSimpleMetaFeed> paramList)
  {
    return a(paramList, false);
  }
  
  public static List<WSVerticalItemData> a(List<stSimpleMetaFeed> paramList, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    if (CollectionUtils.isEmpty(paramList)) {
      return localArrayList;
    }
    int i = 0;
    while (i < paramList.size())
    {
      stSimpleMetaFeed localstSimpleMetaFeed = (stSimpleMetaFeed)paramList.get(i);
      if (localstSimpleMetaFeed != null)
      {
        Object localObject = a(localstSimpleMetaFeed);
        boolean bool = true;
        if ((!paramBoolean) || (i != paramList.size() - 1)) {
          bool = false;
        }
        ((WSVerticalItemData)localObject).b(bool);
        localArrayList.add(localObject);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[WSVerticalDataUtil.java][convertStSimpleFeedList] id:");
        ((StringBuilder)localObject).append(localstSimpleMetaFeed.id);
        ((StringBuilder)localObject).append(", title:");
        ((StringBuilder)localObject).append(localstSimpleMetaFeed.feed_desc);
        WSLog.e("WSVerticalDataUtilLog", ((StringBuilder)localObject).toString());
      }
      i += 1;
    }
    return localArrayList;
  }
  
  private static void a(stSimpleMetaFeed paramstSimpleMetaFeed, WSVerticalItemData paramWSVerticalItemData)
  {
    if ((paramstSimpleMetaFeed.gdt_ad_type == 1) && (paramstSimpleMetaFeed.gdt_ad_info != null))
    {
      GdtAdUtil.c(paramstSimpleMetaFeed);
      GdtAdUtil.a(BaseApplicationImpl.getContext(), paramstSimpleMetaFeed);
      paramWSVerticalItemData.a(GdtAdUtil.b(paramstSimpleMetaFeed));
    }
  }
  
  public static void a(@Nullable WSDramaItemData paramWSDramaItemData, @Nullable WSVerticalItemData paramWSVerticalItemData)
  {
    if (paramWSDramaItemData != null)
    {
      paramWSDramaItemData = paramWSDramaItemData.g();
      if ((paramWSDramaItemData != null) && (paramWSVerticalItemData != null))
      {
        WSDramaEpisodeInfo localWSDramaEpisodeInfo = paramWSVerticalItemData.g();
        if (localWSDramaEpisodeInfo != null)
        {
          paramWSVerticalItemData = paramWSVerticalItemData.b();
          if (paramWSVerticalItemData == null) {
            return;
          }
          paramWSDramaItemData.num = localWSDramaEpisodeInfo.c();
          paramWSDramaItemData.feed = paramWSVerticalItemData;
          paramWSDramaItemData.id = paramWSVerticalItemData.id;
        }
      }
    }
  }
  
  public static stCollection b(@Nullable WSVerticalItemData paramWSVerticalItemData)
  {
    if (paramWSVerticalItemData == null) {
      return null;
    }
    return paramWSVerticalItemData.h();
  }
  
  public static String b()
  {
    WSRedDotPushMsg localWSRedDotPushMsg = WeishiUtils.g();
    WeishiManager localWeishiManager = WeishiUtils.d();
    if (localWeishiManager != null) {
      localWeishiManager.a(null);
    }
    if (localWSRedDotPushMsg == null) {
      return "";
    }
    return localWSRedDotPushMsg.mMsgData;
  }
  
  public static List<stSimpleMetaFeed> b(List paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if (CollectionUtils.isEmpty(paramList)) {
      return localArrayList;
    }
    int i = 0;
    while (i < paramList.size())
    {
      if ((paramList.get(i) instanceof WSVerticalItemData)) {
        localArrayList.add(((WSVerticalItemData)paramList.get(i)).b());
      }
      i += 1;
    }
    return localArrayList;
  }
  
  @NonNull
  public static String c(@Nullable WSVerticalItemData paramWSVerticalItemData)
  {
    if ((paramWSVerticalItemData != null) && (paramWSVerticalItemData.b() != null) && (paramWSVerticalItemData.b().id != null)) {
      return paramWSVerticalItemData.b().id;
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalDataUtil
 * JD-Core Version:    0.7.0.1
 */