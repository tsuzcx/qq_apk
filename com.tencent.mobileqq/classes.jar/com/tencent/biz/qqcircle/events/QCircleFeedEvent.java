package com.tencent.biz.qqcircle.events;

import android.text.TextUtils;
import com.tencent.biz.qqcircle.beans.QCircleFakeFeed;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
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
import qqcircle.QQCircleFeedBase.StSimulateData;
import qqcircle.QQCircleFeedBase.StVideoBusiData;
import uyn;

public class QCircleFeedEvent
  extends SimpleBaseEvent
{
  public static final int STATE_COMPLETE = 2;
  public static final int STATE_COMPOSITE_SUCCESS = 5;
  public static final int STATE_CREATE = 1;
  public static final int STATE_DELETE = 3;
  public static final int STATE_DELETE_FEEDS_BY_UID = 6;
  public static final int STATE_INIT_FAKE_DATA = 4;
  public static final int TARGET_ALL_PAGE = -1;
  public List<FeedCloudMeta.StFeed> mFakeFeedDataList;
  public FeedCloudMeta.StFeed mSingleFakeFeed;
  public int mState;
  public String mTargetId;
  public int mTargetPage = -1;
  
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
    label220:
    for (long l = System.currentTimeMillis() / 1000L;; l = paramQCircleFakeFeed.a())
    {
      ((PBUInt64Field)localObject1).set(l);
      if (paramQCircleFakeFeed.f() == null) {
        break label238;
      }
      localObject1 = new ArrayList();
      localObject2 = paramQCircleFakeFeed.f().iterator();
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
      localStFeed.poiInfo.name.set(paramQCircleFakeFeed.a().poiName);
    }
    localStFeed.poster.set(uyn.a());
    if (!TextUtils.isEmpty(uyn.b())) {
      localStFeed.poster.nick.set(uyn.b());
    }
    localStFeed.cover.picUrl.set(paramQCircleFakeFeed.e());
    Object localObject1 = paramQCircleFakeFeed.a();
    localObject2 = paramQCircleFakeFeed.b();
    Object localObject3 = paramQCircleFakeFeed.c();
    Object localObject4 = paramQCircleFakeFeed.d();
    switch (paramQCircleFakeFeed.a())
    {
    default: 
    case 3: 
      do
      {
        return localStFeed;
        localStFeed.video.width.set(paramQCircleFakeFeed.b());
        localStFeed.video.height.set(paramQCircleFakeFeed.c());
        localStFeed.video.duration.set(paramQCircleFakeFeed.d());
        localStFeed.video.playUrl.set(paramQCircleFakeFeed.f());
      } while (TextUtils.isEmpty((CharSequence)((ArrayList)localObject4).get(0)));
      paramQCircleFakeFeed = new QQCircleFeedBase.StSimulateData();
      paramQCircleFakeFeed.material_id.set((String)((ArrayList)localObject1).get(0));
      paramQCircleFakeFeed.filter_id.set((String)((ArrayList)localObject2).get(0));
      paramQCircleFakeFeed.simulate_name.set((String)((ArrayList)localObject3).get(0));
      paramQCircleFakeFeed.simulate_schema.set((String)((ArrayList)localObject4).get(0));
      if ((!TextUtils.isEmpty(paramQCircleFakeFeed.material_id.get())) && (!TextUtils.isEmpty(paramQCircleFakeFeed.simulate_name.get()))) {
        paramQCircleFakeFeed.is_show_button.set(1);
      }
      localObject1 = new QQCircleFeedBase.StVideoBusiData();
      ((QQCircleFeedBase.StVideoBusiData)localObject1).simulate_date.set(paramQCircleFakeFeed);
      localStFeed.video.busiData.set(ByteStringMicro.copyFrom(((QQCircleFeedBase.StVideoBusiData)localObject1).toByteArray()));
      return localStFeed;
    }
    localStFeed.cover.width.set(paramQCircleFakeFeed.b());
    localStFeed.cover.height.set(paramQCircleFakeFeed.c());
    ArrayList localArrayList = new ArrayList();
    if (paramQCircleFakeFeed.e() != null)
    {
      paramInt = 0;
      while (paramInt < paramQCircleFakeFeed.e().size())
      {
        Object localObject5 = (String)paramQCircleFakeFeed.e().get(paramInt);
        FeedCloudMeta.StImage localStImage = new FeedCloudMeta.StImage();
        localStImage.picUrl.set((String)localObject5);
        localStImage.width.set(paramQCircleFakeFeed.b());
        localStImage.height.set(paramQCircleFakeFeed.c());
        if (!TextUtils.isEmpty((CharSequence)((ArrayList)localObject4).get(paramInt)))
        {
          localObject5 = new QQCircleFeedBase.StSimulateData();
          ((QQCircleFeedBase.StSimulateData)localObject5).material_id.set((String)((ArrayList)localObject1).get(paramInt));
          ((QQCircleFeedBase.StSimulateData)localObject5).filter_id.set((String)((ArrayList)localObject2).get(paramInt));
          ((QQCircleFeedBase.StSimulateData)localObject5).simulate_name.set((String)((ArrayList)localObject3).get(paramInt));
          ((QQCircleFeedBase.StSimulateData)localObject5).simulate_schema.set((String)((ArrayList)localObject4).get(paramInt));
          if ((!TextUtils.isEmpty(((QQCircleFeedBase.StSimulateData)localObject5).material_id.get())) && (!TextUtils.isEmpty(((QQCircleFeedBase.StSimulateData)localObject5).simulate_name.get()))) {
            ((QQCircleFeedBase.StSimulateData)localObject5).is_show_button.set(1);
          }
          QQCircleFeedBase.StVideoBusiData localStVideoBusiData = new QQCircleFeedBase.StVideoBusiData();
          localStVideoBusiData.simulate_date.set((MessageMicro)localObject5);
          localStImage.busiData.set(ByteStringMicro.copyFrom(localStVideoBusiData.toByteArray()));
        }
        localArrayList.add(localStImage);
        paramInt += 1;
      }
    }
    localStFeed.images.set(localArrayList);
    return localStFeed;
  }
  
  public void setTargetPage(int paramInt)
  {
    this.mTargetPage = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.events.QCircleFeedEvent
 * JD-Core Version:    0.7.0.1
 */