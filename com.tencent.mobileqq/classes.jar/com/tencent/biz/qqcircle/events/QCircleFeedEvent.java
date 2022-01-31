package com.tencent.biz.qqcircle.events;

import android.text.TextUtils;
import com.tencent.biz.subscribe.event.SimpleBaseEvent;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import cooperation.qzone.LbsDataV2.PoiInfo;
import cooperation.qzone.model.LabelInfo;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StImage;
import feedcloud.FeedCloudMeta.StPoiInfoV2;
import feedcloud.FeedCloudMeta.StTagInfo;
import feedcloud.FeedCloudMeta.StUser;
import feedcloud.FeedCloudMeta.StVideo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tqg;

public class QCircleFeedEvent
  extends SimpleBaseEvent
{
  public static final int STATE_COMPLETE = 2;
  public static final int STATE_COMPOSITE_SUCCESS = 5;
  public static final int STATE_CREATE = 1;
  public static final int STATE_DELETE = 3;
  public static final int STATE_INIT_FAKE_DATA = 4;
  public List<FeedCloudMeta.StFeed> mFakeFeedDataList;
  public FeedCloudMeta.StFeed mSingleFakeFeed;
  public int mState;
  public String mTargetId;
  
  public QCircleFeedEvent(int paramInt)
  {
    this.mState = paramInt;
  }
  
  public QCircleFeedEvent(QCircleFakeFeed paramQCircleFakeFeed, int paramInt)
  {
    this.mState = paramInt;
    if (paramQCircleFakeFeed != null)
    {
      this.mTargetId = ("qcircle_fakeid_" + paramQCircleFakeFeed.b());
      this.mSingleFakeFeed = a(paramQCircleFakeFeed, paramInt);
    }
  }
  
  public QCircleFeedEvent(String paramString, int paramInt)
  {
    this.mState = paramInt;
    if (paramString != null) {
      this.mTargetId = paramString;
    }
  }
  
  public QCircleFeedEvent(List<QCircleFakeFeed> paramList)
  {
    if (paramList == null) {}
    for (;;)
    {
      return;
      this.mState = 4;
      this.mFakeFeedDataList = new ArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        QCircleFakeFeed localQCircleFakeFeed = (QCircleFakeFeed)paramList.next();
        this.mFakeFeedDataList.add(a(localQCircleFakeFeed, 1));
      }
    }
  }
  
  private FeedCloudMeta.StFeed a(QCircleFakeFeed paramQCircleFakeFeed, int paramInt)
  {
    FeedCloudMeta.StFeed localStFeed = new FeedCloudMeta.StFeed();
    Object localObject2 = localStFeed.id;
    if (paramInt == 2)
    {
      localObject1 = paramQCircleFakeFeed.a();
      ((PBStringField)localObject2).set((String)localObject1);
      localStFeed.title.set(paramQCircleFakeFeed.c());
      localStFeed.content.set(paramQCircleFakeFeed.d());
      localStFeed.type.set(paramQCircleFakeFeed.a());
      localObject1 = localStFeed.createTime;
      if (paramQCircleFakeFeed.a() != 0L) {
        break label220;
      }
    }
    Object localObject3;
    Object localObject4;
    label220:
    for (long l = System.currentTimeMillis() / 1000L;; l = paramQCircleFakeFeed.a())
    {
      ((PBUInt64Field)localObject1).set(l);
      if (paramQCircleFakeFeed.b() == null) {
        break label238;
      }
      localObject1 = new ArrayList();
      localObject2 = paramQCircleFakeFeed.b().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (LabelInfo)((Iterator)localObject2).next();
        localObject4 = new FeedCloudMeta.StTagInfo();
        ((FeedCloudMeta.StTagInfo)localObject4).tagName.set(((LabelInfo)localObject3).name);
        ((FeedCloudMeta.StTagInfo)localObject4).tagId.set(((LabelInfo)localObject3).id);
        ((ArrayList)localObject1).add(localObject4);
      }
      localObject1 = "qcircle_fakeid_" + paramQCircleFakeFeed.b();
      break;
    }
    localStFeed.tagInfos.set((List)localObject1);
    label238:
    if (paramQCircleFakeFeed.a() != null)
    {
      localStFeed.poiInfo.address.set(paramQCircleFakeFeed.a().address);
      localStFeed.poiInfo.defaultName.set(paramQCircleFakeFeed.a().poiDefaultName);
    }
    localStFeed.poster.set(tqg.a());
    if (!TextUtils.isEmpty(tqg.b())) {
      localStFeed.poster.nick.set(tqg.b());
    }
    localStFeed.cover.picUrl.set(paramQCircleFakeFeed.e());
    switch (paramQCircleFakeFeed.a())
    {
    default: 
      return localStFeed;
    case 3: 
      localStFeed.video.width.set(paramQCircleFakeFeed.b());
      localStFeed.video.height.set(paramQCircleFakeFeed.c());
      localStFeed.video.duration.set(paramQCircleFakeFeed.d());
      localStFeed.video.playUrl.set(paramQCircleFakeFeed.f());
      return localStFeed;
    }
    localStFeed.cover.width.set(paramQCircleFakeFeed.b());
    localStFeed.cover.height.set(paramQCircleFakeFeed.c());
    Object localObject1 = new ArrayList();
    if (paramQCircleFakeFeed.a() != null)
    {
      localObject2 = paramQCircleFakeFeed.a().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (String)((Iterator)localObject2).next();
        localObject4 = new FeedCloudMeta.StImage();
        ((FeedCloudMeta.StImage)localObject4).picUrl.set((String)localObject3);
        ((FeedCloudMeta.StImage)localObject4).width.set(paramQCircleFakeFeed.b());
        ((FeedCloudMeta.StImage)localObject4).height.set(paramQCircleFakeFeed.c());
        ((List)localObject1).add(localObject4);
      }
    }
    localStFeed.images.set((List)localObject1);
    return localStFeed;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.events.QCircleFeedEvent
 * JD-Core Version:    0.7.0.1
 */