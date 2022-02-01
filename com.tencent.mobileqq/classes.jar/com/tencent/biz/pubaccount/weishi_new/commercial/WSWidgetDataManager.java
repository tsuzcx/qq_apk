package com.tencent.biz.pubaccount.weishi_new.commercial;

import UserGrowth.stBusinessIconInfo;
import UserGrowth.stFeedOpInfo;
import UserGrowth.stGetFeedIconOpRsp;
import UserGrowth.stSimpleMetaFeed;
import com.google.gson.Gson;
import com.tencent.biz.pubaccount.weishi_new.net.IWeishiServiceListener;
import com.tencent.biz.pubaccount.weishi_new.net.WeishiBusinessLooper;
import com.tencent.biz.pubaccount.weishi_new.net.WeishiTask;
import com.tencent.biz.pubaccount.weishi_new.request.GetRichOpInfoRequest;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalItemData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jetbrains.annotations.NotNull;

public class WSWidgetDataManager
{
  public static stFeedOpInfo a(stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    stFeedOpInfo localstFeedOpInfo2 = paramstSimpleMetaFeed.opInfo;
    stFeedOpInfo localstFeedOpInfo1 = localstFeedOpInfo2;
    if (localstFeedOpInfo2 == null) {
      localstFeedOpInfo1 = new stFeedOpInfo();
    }
    localstFeedOpInfo1.videoType = paramstSimpleMetaFeed.video_type;
    localstFeedOpInfo1.feedId = paramstSimpleMetaFeed.id;
    return localstFeedOpInfo1;
  }
  
  private AbsWSRichWidgetData a(stGetFeedIconOpRsp paramstGetFeedIconOpRsp)
  {
    WSPublisherInfo localWSPublisherInfo = null;
    if (paramstGetFeedIconOpRsp == null) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("convertRichWidgetData:");
    localStringBuilder.append(new Gson().toJson(paramstGetFeedIconOpRsp));
    WSLog.b("WSWidgetDataManager", localStringBuilder.toString());
    int i = paramstGetFeedIconOpRsp.opInfo.iconType;
    if (i == 3)
    {
      if ((paramstGetFeedIconOpRsp.businessIcon != null) && (paramstGetFeedIconOpRsp.businessIcon.cardSwitch != 0))
      {
        WSLog.a("WSWidgetDataManager", "covert to big card commercial data");
        return new WSBigCardCommercialInfo(paramstGetFeedIconOpRsp.businessIcon, paramstGetFeedIconOpRsp.feedIconOpConf);
      }
      WSLog.a("WSWidgetDataManager", "covert to commercial data");
      return new WSCommercialInfo(paramstGetFeedIconOpRsp.businessIcon);
    }
    if (i == 1) {
      localWSPublisherInfo = new WSPublisherInfo(paramstGetFeedIconOpRsp.shootIconInfo);
    }
    return localWSPublisherInfo;
  }
  
  public static WSWidgetDataManager a()
  {
    return WSWidgetDataManager.SingletonHolder.a();
  }
  
  @NotNull
  private IWeishiServiceListener a(WSVerticalItemData paramWSVerticalItemData, WSWidgetDataManager.OnDataCallback paramOnDataCallback)
  {
    return new WSWidgetDataManager.1(this, System.currentTimeMillis(), paramWSVerticalItemData, paramOnDataCallback);
  }
  
  private ArrayList<stFeedOpInfo> a(List<WSVerticalItemData> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      ArrayList localArrayList = new ArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        stFeedOpInfo localstFeedOpInfo = ((WSVerticalItemData)paramList.next()).b().opInfo;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[getOpInfoList]");
        localStringBuilder.append(localstFeedOpInfo.toString());
        WSLog.a("WSWidgetDataManager", localStringBuilder.toString());
        localArrayList.add(localstFeedOpInfo);
      }
      return localArrayList;
    }
    return null;
  }
  
  @NotNull
  private List<WSVerticalItemData> a(List<WSVerticalItemData> paramList, int paramInt1, int paramInt2)
  {
    if (paramInt1 > paramInt2) {
      return null;
    }
    return paramList.subList(paramInt1, paramInt2);
  }
  
  private boolean a(WSVerticalItemData paramWSVerticalItemData)
  {
    Object localObject = paramWSVerticalItemData.b();
    boolean bool = false;
    if (localObject != null)
    {
      localObject = ((stSimpleMetaFeed)localObject).opInfo;
      if ((localObject != null) && (((stFeedOpInfo)localObject).iconType == 255)) {
        return false;
      }
    }
    if (paramWSVerticalItemData.f() == null) {
      bool = true;
    }
    return bool;
  }
  
  public void a(int paramInt, List<WSVerticalItemData> paramList, WSWidgetDataManager.OnDataCallback paramOnDataCallback)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("[getRichOpInfo] position:");
    ((StringBuilder)localObject1).append(paramInt);
    WSLog.a("WSWidgetDataManager", ((StringBuilder)localObject1).toString());
    if ((paramInt >= 0) && (paramInt <= paramList.size()))
    {
      localObject1 = (WSVerticalItemData)paramList.get(paramInt);
      if (!a((WSVerticalItemData)localObject1)) {
        return;
      }
      Object localObject2 = a(paramList, Math.max(paramInt - 10, 0), Math.max(paramInt, 0));
      Object localObject3 = a(paramList, Math.min(paramInt + 1, paramList.size() - 1), Math.min(paramInt + 10, paramList.size() - 1));
      paramList = ((WSVerticalItemData)localObject1).b().opInfo;
      paramList.isRequesting = 1;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getRichOpInfo current");
      localStringBuilder.append(paramList.toString());
      WSLog.a("WSWidgetDataManager", localStringBuilder.toString());
      WSLog.a("WSWidgetDataManager", "preList------------------------");
      localObject2 = a((List)localObject2);
      WSLog.a("WSWidgetDataManager", "postList-----------------------");
      localObject3 = a((List)localObject3);
      WSLog.a("WSWidgetDataManager", "endList-----------------------");
      paramList = new WeishiTask(new GetRichOpInfoRequest(paramList, (ArrayList)localObject2, (ArrayList)localObject3), null, a((WSVerticalItemData)localObject1, paramOnDataCallback), 4018);
      WeishiBusinessLooper.a().a(paramList);
      return;
    }
    WSLog.a("WSWidgetDataManager", "[getRichOpInfo] position exception");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.commercial.WSWidgetDataManager
 * JD-Core Version:    0.7.0.1
 */