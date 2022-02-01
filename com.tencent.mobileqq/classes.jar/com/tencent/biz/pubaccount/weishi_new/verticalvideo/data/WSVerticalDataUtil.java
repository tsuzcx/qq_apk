package com.tencent.biz.pubaccount.weishi_new.verticalvideo.data;

import UserGrowth.stSimpleMetaFeed;
import com.tencent.biz.pubaccount.readinjoy.engine.WeishiManager;
import com.tencent.biz.pubaccount.weishi_new.commercial.WSWidgetDataManager;
import com.tencent.biz.pubaccount.weishi_new.push.WSRedDotPushMsg;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.gdt.GdtAdUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.ttpic.baseutils.collection.CollectionUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class WSVerticalDataUtil
{
  public static String a()
  {
    WeishiManager localWeishiManager = WeishiUtils.a();
    String str = "";
    if (localWeishiManager != null) {
      str = localWeishiManager.c();
    }
    return str;
  }
  
  public static ArrayList<String> a(boolean paramBoolean, List<WSVerticalItemData> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if ((!paramBoolean) || (paramList == null)) {
      return localArrayList;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      WSVerticalItemData localWSVerticalItemData = (WSVerticalItemData)paramList.next();
      if ((localWSVerticalItemData != null) && (localWSVerticalItemData.a() != null)) {
        localArrayList.add(localWSVerticalItemData.a().id);
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
      if (localstSimpleMetaFeed == null)
      {
        i += 1;
      }
      else
      {
        WSVerticalItemData localWSVerticalItemData = new WSVerticalItemData();
        if ((paramBoolean) && (i == paramList.size() - 1)) {}
        for (boolean bool = true;; bool = false)
        {
          localWSVerticalItemData.a(bool);
          a(localstSimpleMetaFeed, localWSVerticalItemData);
          localstSimpleMetaFeed.opInfo = WSWidgetDataManager.a(localstSimpleMetaFeed);
          localWSVerticalItemData.a(localstSimpleMetaFeed);
          localArrayList.add(localWSVerticalItemData);
          break;
        }
      }
    }
    return localArrayList;
  }
  
  private static void a(stSimpleMetaFeed paramstSimpleMetaFeed, WSVerticalItemData paramWSVerticalItemData)
  {
    if ((paramstSimpleMetaFeed.gdt_ad_type == 1) && (paramstSimpleMetaFeed.gdt_ad_info != null))
    {
      GdtAdUtil.a(paramstSimpleMetaFeed);
      GdtAdUtil.a(BaseApplicationImpl.getContext(), paramstSimpleMetaFeed);
      paramWSVerticalItemData.a(GdtAdUtil.a(paramstSimpleMetaFeed));
    }
  }
  
  public static String b()
  {
    WSRedDotPushMsg localWSRedDotPushMsg = WeishiUtils.a();
    WeishiManager localWeishiManager = WeishiUtils.a();
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
        localArrayList.add(((WSVerticalItemData)paramList.get(i)).a());
      }
      i += 1;
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalDataUtil
 * JD-Core Version:    0.7.0.1
 */