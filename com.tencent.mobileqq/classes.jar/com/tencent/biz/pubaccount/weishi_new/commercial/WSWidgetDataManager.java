package com.tencent.biz.pubaccount.weishi_new.commercial;

import UserGrowth.stFeedOpInfo;
import UserGrowth.stGetFeedIconOpRsp;
import UserGrowth.stSimpleMetaFeed;
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
    if (paramstGetFeedIconOpRsp == null) {}
    int i;
    do
    {
      return null;
      i = paramstGetFeedIconOpRsp.opInfo.iconType;
      if (i == 3) {
        return new WSCommercialInfo(paramstGetFeedIconOpRsp.businessIcon);
      }
    } while (i != 1);
    return new WSPublisherInfo(paramstGetFeedIconOpRsp.shootIconInfo);
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
    if ((paramList == null) || (paramList.size() <= 0)) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      stFeedOpInfo localstFeedOpInfo = ((WSVerticalItemData)paramList.next()).a().opInfo;
      WSLog.a("WSWidgetDataManager", "[getOpInfoList]" + localstFeedOpInfo.toString());
      localArrayList.add(localstFeedOpInfo);
    }
    return localArrayList;
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
    Object localObject = paramWSVerticalItemData.a();
    if (localObject != null)
    {
      localObject = ((stSimpleMetaFeed)localObject).opInfo;
      if ((localObject == null) || (((stFeedOpInfo)localObject).iconType != 255)) {}
    }
    while (paramWSVerticalItemData.a() != null) {
      return false;
    }
    return true;
  }
  
  public void a(int paramInt, List<WSVerticalItemData> paramList, WSWidgetDataManager.OnDataCallback paramOnDataCallback)
  {
    WSLog.a("WSWidgetDataManager", "[getRichOpInfo] position:" + paramInt);
    if ((paramInt < 0) || (paramInt > paramList.size())) {
      WSLog.a("WSWidgetDataManager", "[getRichOpInfo] position exception");
    }
    WSVerticalItemData localWSVerticalItemData;
    do
    {
      return;
      localWSVerticalItemData = (WSVerticalItemData)paramList.get(paramInt);
    } while (!a(localWSVerticalItemData));
    Object localObject1 = a(paramList, Math.max(paramInt - 10, 0), Math.max(paramInt, 0));
    Object localObject2 = a(paramList, Math.min(paramInt + 1, paramList.size() - 1), Math.min(paramInt + 10, paramList.size() - 1));
    paramList = localWSVerticalItemData.a().opInfo;
    paramList.isRequesting = 1;
    WSLog.a("WSWidgetDataManager", "getRichOpInfo current" + paramList.toString());
    WSLog.a("WSWidgetDataManager", "preList------------------------");
    localObject1 = a((List)localObject1);
    WSLog.a("WSWidgetDataManager", "postList-----------------------");
    localObject2 = a((List)localObject2);
    WSLog.a("WSWidgetDataManager", "endList-----------------------");
    paramList = new WeishiTask(new GetRichOpInfoRequest(paramList, (ArrayList)localObject1, (ArrayList)localObject2), null, a(localWSVerticalItemData, paramOnDataCallback), 4018);
    WeishiBusinessLooper.a().a(paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.commercial.WSWidgetDataManager
 * JD-Core Version:    0.7.0.1
 */