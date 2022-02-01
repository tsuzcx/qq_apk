package com.tencent.biz.qqcircle.events;

import android.text.TextUtils;
import com.tencent.biz.qcircleshadow.lib.variation.HostDataTransUtils;
import com.tencent.biz.qqcircle.utils.QCircleProtoUtil;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import cooperation.qqcircle.beans.QCircleFakeFeed;
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
import qqcircle.QQCircleFeedBase.StImageBusiData;
import qqcircle.QQCircleFeedBase.StKuoliePasterData;
import qqcircle.QQCircleFeedBase.StSimulateData;
import qqcircle.QQCircleFeedBase.StVideoBusiData;

public class QCircleFeedEvent
  extends SimpleBaseEvent
{
  public static final int STATE_COMPLETE = 2;
  public static final int STATE_COMPOSITE_SUCCESS = 5;
  public static final int STATE_CREATE = 1;
  public static final int STATE_DELETE = 3;
  public static final int STATE_DELETE_FEEDS_BY_UID = 6;
  public static final int STATE_INIT_FAKE_DATA = 4;
  public static final int STATE_UNDO_PUSH = 7;
  public static final int TARGET_ALL_PAGE = -1;
  public List<byte[]> mFakeFeedDataList;
  public byte[] mSingleFakeFeed;
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("qcircle_fakeid_");
      localStringBuilder.append(paramQCircleFakeFeed.getClientKey());
      this.mTargetId = localStringBuilder.toString();
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
    if (paramList == null) {
      return;
    }
    this.mState = 4;
    this.mFakeFeedDataList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      QCircleFakeFeed localQCircleFakeFeed = (QCircleFakeFeed)paramList.next();
      this.mFakeFeedDataList.add(a(localQCircleFakeFeed, 1));
    }
  }
  
  private byte[] a(QCircleFakeFeed paramQCircleFakeFeed, int paramInt)
  {
    Object localObject1 = new FeedCloudMeta.StFeed();
    Object localObject3 = ((FeedCloudMeta.StFeed)localObject1).id;
    if (paramInt == 2)
    {
      localObject2 = paramQCircleFakeFeed.getFeedId();
    }
    else
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("qcircle_fakeid_");
      ((StringBuilder)localObject2).append(paramQCircleFakeFeed.getClientKey());
      localObject2 = ((StringBuilder)localObject2).toString();
    }
    ((PBStringField)localObject3).set((String)localObject2);
    ((FeedCloudMeta.StFeed)localObject1).title.set(QCircleProtoUtil.a(paramQCircleFakeFeed.getTitle()));
    ((FeedCloudMeta.StFeed)localObject1).content.set(QCircleProtoUtil.a(paramQCircleFakeFeed.getContent()));
    ((FeedCloudMeta.StFeed)localObject1).type.set(paramQCircleFakeFeed.getFeedType());
    Object localObject2 = ((FeedCloudMeta.StFeed)localObject1).createTime;
    long l;
    if (paramQCircleFakeFeed.getCreateTime() == 0L) {
      l = System.currentTimeMillis() / 1000L;
    } else {
      l = paramQCircleFakeFeed.getCreateTime();
    }
    ((PBUInt64Field)localObject2).set(l);
    ((FeedCloudMeta.StFeed)localObject1).setHasFlag(true);
    Object localObject5;
    if (paramQCircleFakeFeed.getLabelInfos() != null)
    {
      localObject2 = new ArrayList();
      localObject3 = paramQCircleFakeFeed.getLabelInfos().iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (LabelInfo)((Iterator)localObject3).next();
        localObject5 = new FeedCloudMeta.StTagInfo();
        ((FeedCloudMeta.StTagInfo)localObject5).tagName.set(QCircleProtoUtil.a(((LabelInfo)localObject4).name));
        ((FeedCloudMeta.StTagInfo)localObject5).tagId.set(QCircleProtoUtil.a(((LabelInfo)localObject4).id));
        ((ArrayList)localObject2).add(localObject5);
        ((FeedCloudMeta.StTagInfo)localObject5).setHasFlag(true);
      }
      ((FeedCloudMeta.StFeed)localObject1).tagInfos.set((List)localObject2);
    }
    if (paramQCircleFakeFeed.getPoiInfo() != null)
    {
      ((FeedCloudMeta.StFeed)localObject1).poiInfo.address.set(QCircleProtoUtil.a(paramQCircleFakeFeed.getPoiInfo().address));
      ((FeedCloudMeta.StFeed)localObject1).poiInfo.defaultName.set(QCircleProtoUtil.a(paramQCircleFakeFeed.getPoiInfo().poiDefaultName));
      ((FeedCloudMeta.StFeed)localObject1).poiInfo.name.set(QCircleProtoUtil.a(paramQCircleFakeFeed.getPoiInfo().poiName));
      ((FeedCloudMeta.StFeed)localObject1).poiInfo.setHasFlag(true);
    }
    ((FeedCloudMeta.StFeed)localObject1).poster.setHasFlag(true);
    ((FeedCloudMeta.StFeed)localObject1).poster.id.set(HostDataTransUtils.getAccount());
    if (!TextUtils.isEmpty(HostDataTransUtils.getAccountNickName(HostDataTransUtils.getAccount()))) {
      ((FeedCloudMeta.StFeed)localObject1).poster.nick.set(QCircleProtoUtil.a(HostDataTransUtils.getAccountNickName(HostDataTransUtils.getAccount())));
    }
    ((FeedCloudMeta.StFeed)localObject1).cover.picUrl.set(QCircleProtoUtil.a(paramQCircleFakeFeed.getCoverPath()));
    ((FeedCloudMeta.StFeed)localObject1).cover.setHasFlag(true);
    Object localObject4 = paramQCircleFakeFeed.getMaterialId();
    ArrayList localArrayList7 = paramQCircleFakeFeed.getFilterId();
    ArrayList localArrayList8 = paramQCircleFakeFeed.getSimulateName();
    ArrayList localArrayList9 = paramQCircleFakeFeed.getSimulateSchema();
    ArrayList localArrayList10 = paramQCircleFakeFeed.getShowCircleTakeSame();
    ArrayList localArrayList1 = paramQCircleFakeFeed.getKuolieId();
    ArrayList localArrayList2 = paramQCircleFakeFeed.getKuolieCentreX();
    ArrayList localArrayList3 = paramQCircleFakeFeed.getKuolieCentreY();
    ArrayList localArrayList4 = paramQCircleFakeFeed.getKuolieWidthScale();
    ArrayList localArrayList5 = paramQCircleFakeFeed.getKuolieHeightScale();
    ArrayList localArrayList6 = paramQCircleFakeFeed.getKuolieRotate();
    paramInt = paramQCircleFakeFeed.getFeedType();
    if (paramInt != 2)
    {
      if (paramInt == 3)
      {
        ((FeedCloudMeta.StFeed)localObject1).video.width.set(paramQCircleFakeFeed.getWidth());
        ((FeedCloudMeta.StFeed)localObject1).video.height.set(paramQCircleFakeFeed.getHeight());
        ((FeedCloudMeta.StFeed)localObject1).video.duration.set(paramQCircleFakeFeed.getDuration());
        ((FeedCloudMeta.StFeed)localObject1).video.playUrl.set(QCircleProtoUtil.a(paramQCircleFakeFeed.getVideoPath()));
        if ((localArrayList10 != null) && (localArrayList10.size() == 1)) {
          paramInt = 1;
        } else {
          paramInt = 0;
        }
        paramQCircleFakeFeed = new QQCircleFeedBase.StVideoBusiData();
        if (!TextUtils.isEmpty((CharSequence)localArrayList9.get(0)))
        {
          localObject2 = new QQCircleFeedBase.StSimulateData();
          ((QQCircleFeedBase.StSimulateData)localObject2).material_id.set((String)((ArrayList)localObject4).get(0));
          ((QQCircleFeedBase.StSimulateData)localObject2).filter_id.set((String)localArrayList7.get(0));
          ((QQCircleFeedBase.StSimulateData)localObject2).simulate_name.set((String)localArrayList8.get(0));
          ((QQCircleFeedBase.StSimulateData)localObject2).simulate_schema.set((String)localArrayList9.get(0));
          if (paramInt != 0) {
            ((QQCircleFeedBase.StSimulateData)localObject2).is_show_button.set(((Integer)localArrayList10.get(0)).intValue());
          } else {
            ((QQCircleFeedBase.StSimulateData)localObject2).is_show_button.set(0);
          }
          ((QQCircleFeedBase.StSimulateData)localObject2).setHasFlag(true);
          paramQCircleFakeFeed.simulate_date.set((MessageMicro)localObject2);
        }
        if (!TextUtils.isEmpty((CharSequence)localArrayList1.get(0)))
        {
          localObject2 = new QQCircleFeedBase.StKuoliePasterData();
          ((QQCircleFeedBase.StKuoliePasterData)localObject2).kuolie_id.set((String)localArrayList1.get(0));
          ((QQCircleFeedBase.StKuoliePasterData)localObject2).center_x.set(((Float)localArrayList2.get(0)).floatValue());
          ((QQCircleFeedBase.StKuoliePasterData)localObject2).center_y.set(((Float)localArrayList3.get(0)).floatValue());
          ((QQCircleFeedBase.StKuoliePasterData)localObject2).width.set(((Float)localArrayList4.get(0)).floatValue());
          ((QQCircleFeedBase.StKuoliePasterData)localObject2).height.set(((Float)localArrayList5.get(0)).floatValue());
          ((QQCircleFeedBase.StKuoliePasterData)localObject2).rotation.set(((Float)localArrayList6.get(0)).floatValue());
          ((QQCircleFeedBase.StKuoliePasterData)localObject2).setHasFlag(true);
          paramQCircleFakeFeed.kuolie_data.set((MessageMicro)localObject2);
        }
        ((FeedCloudMeta.StFeed)localObject1).video.busiData.set(ByteStringMicro.copyFrom(paramQCircleFakeFeed.toByteArray()));
        paramQCircleFakeFeed.setHasFlag(true);
        ((FeedCloudMeta.StFeed)localObject1).video.setHasFlag(true);
      }
    }
    else
    {
      ((FeedCloudMeta.StFeed)localObject1).cover.width.set(paramQCircleFakeFeed.getWidth());
      ((FeedCloudMeta.StFeed)localObject1).cover.height.set(paramQCircleFakeFeed.getHeight());
      localObject2 = new ArrayList();
      localObject3 = localObject1;
      localObject5 = localObject2;
      if (paramQCircleFakeFeed.getImgLists() != null)
      {
        if ((localArrayList10 != null) && (localArrayList10.size() == paramQCircleFakeFeed.getImgLists().size())) {
          paramInt = 1;
        } else {
          paramInt = 0;
        }
        int i = 0;
        for (;;)
        {
          localObject3 = localObject1;
          localObject5 = localObject2;
          if (i >= paramQCircleFakeFeed.getImgLists().size()) {
            break;
          }
          localObject5 = (String)paramQCircleFakeFeed.getImgLists().get(i);
          localObject3 = new FeedCloudMeta.StImage();
          ((FeedCloudMeta.StImage)localObject3).picUrl.set((String)localObject5);
          ((FeedCloudMeta.StImage)localObject3).width.set(paramQCircleFakeFeed.getWidth());
          ((FeedCloudMeta.StImage)localObject3).height.set(paramQCircleFakeFeed.getHeight());
          localObject5 = new QQCircleFeedBase.StImageBusiData();
          Object localObject6;
          if (!TextUtils.isEmpty((CharSequence)localArrayList9.get(i)))
          {
            localObject6 = new QQCircleFeedBase.StSimulateData();
            ((QQCircleFeedBase.StSimulateData)localObject6).material_id.set((String)((ArrayList)localObject4).get(i));
            ((QQCircleFeedBase.StSimulateData)localObject6).filter_id.set((String)localArrayList7.get(i));
            ((QQCircleFeedBase.StSimulateData)localObject6).simulate_name.set((String)localArrayList8.get(i));
            ((QQCircleFeedBase.StSimulateData)localObject6).simulate_schema.set((String)localArrayList9.get(i));
            if (paramInt != 0) {
              ((QQCircleFeedBase.StSimulateData)localObject6).is_show_button.set(((Integer)localArrayList10.get(i)).intValue());
            } else {
              ((QQCircleFeedBase.StSimulateData)localObject6).is_show_button.set(0);
            }
            ((QQCircleFeedBase.StSimulateData)localObject6).setHasFlag(true);
            ((QQCircleFeedBase.StImageBusiData)localObject5).simulate_date.set((MessageMicro)localObject6);
          }
          if (!TextUtils.isEmpty((CharSequence)localArrayList1.get(i)))
          {
            localObject6 = new QQCircleFeedBase.StKuoliePasterData();
            ((QQCircleFeedBase.StKuoliePasterData)localObject6).kuolie_id.set((String)localArrayList1.get(i));
            ((QQCircleFeedBase.StKuoliePasterData)localObject6).center_x.set(((Float)localArrayList2.get(i)).floatValue());
            ((QQCircleFeedBase.StKuoliePasterData)localObject6).center_y.set(((Float)localArrayList3.get(i)).floatValue());
            ((QQCircleFeedBase.StKuoliePasterData)localObject6).width.set(((Float)localArrayList4.get(i)).floatValue());
            ((QQCircleFeedBase.StKuoliePasterData)localObject6).height.set(((Float)localArrayList5.get(i)).floatValue());
            ((QQCircleFeedBase.StKuoliePasterData)localObject6).rotation.set(((Float)localArrayList6.get(i)).floatValue());
            ((QQCircleFeedBase.StKuoliePasterData)localObject6).setHasFlag(true);
            ((QQCircleFeedBase.StImageBusiData)localObject5).kuolie_data.set((MessageMicro)localObject6);
          }
          ((QQCircleFeedBase.StImageBusiData)localObject5).setHasFlag(true);
          ((FeedCloudMeta.StImage)localObject3).busiData.set(ByteStringMicro.copyFrom(((QQCircleFeedBase.StImageBusiData)localObject5).toByteArray()));
          ((List)localObject2).add(localObject3);
          i += 1;
        }
      }
      ((FeedCloudMeta.StFeed)localObject3).images.set((List)localObject5);
      localObject1 = localObject3;
    }
    return ((FeedCloudMeta.StFeed)localObject1).toByteArray();
  }
  
  public void setTargetPage(int paramInt)
  {
    this.mTargetPage = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.events.QCircleFeedEvent
 * JD-Core Version:    0.7.0.1
 */