package com.tencent.biz.qqcircle.requests;

import android.text.TextUtils;
import com.tencent.biz.qqcircle.QCircleGpsHelper;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.beans.QCirclePolymerizationBean;
import com.tencent.biz.qqcircle.beans.QCirclePolymerizeDetailBean;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StGPSV2;
import feedcloud.FeedCloudMeta.StPoiInfoV2;
import feedcloud.FeedCloudMeta.StTagInfo;
import feedcloud.FeedCloudMeta.StUser;
import feedcloud.FeedCloudRead.StGetFeedListReq;
import feedcloud.FeedCloudRead.StGetFeedListRsp;
import java.util.HashMap;
import java.util.List;
import qqcircle.QQCircleFeedBase.StFeedListBusiReqData;
import qqcircle.QQCircleFeedBase.StSimulateData;

public class QCircleGetFeedListRequest
  extends QCircleBaseRequest
{
  private final int mListNum = 10;
  public FeedCloudRead.StGetFeedListReq mRequest;
  
  public QCircleGetFeedListRequest(QCircleInitBean paramQCircleInitBean, String paramString)
  {
    this.mRequest = new FeedCloudRead.StGetFeedListReq();
    if (paramQCircleInitBean == null) {
      return;
    }
    FeedCloudMeta.StFeed localStFeed = QCirclePluginUtil.a(paramQCircleInitBean.getFeed());
    if (paramString == null)
    {
      this.mRequest.feed.set(localStFeed);
      this.mRequest.feed.busiTranparent.set(paramQCircleInitBean.getFeed().busiTranparent.get());
    }
    this.mRequest.source.set(17);
    this.mRequest.listNum.set(10);
    if (paramString != null) {
      this.mRequest.feedAttchInfo.set(paramString);
    }
    paramQCircleInitBean = paramQCircleInitBean.getFeedListBusiReq();
    paramQCircleInitBean.detailFeed.set(localStFeed);
    this.mRequest.busiReqData.set(ByteStringMicro.copyFrom(paramQCircleInitBean.toByteArray()));
  }
  
  public QCircleGetFeedListRequest(QCircleInitBean paramQCircleInitBean, String paramString1, String paramString2, String paramString3)
  {
    this.mRequest = new FeedCloudRead.StGetFeedListReq();
    FeedCloudMeta.StFeed localStFeed = QCirclePluginUtil.a(paramQCircleInitBean.getFeed());
    if (paramQCircleInitBean.getExtraTypeInfo().sourceType == 9) {
      this.mRequest.dstUserId.set(paramQCircleInitBean.getUin());
    }
    if (paramString1 == null)
    {
      this.mRequest.feed.set(localStFeed);
      this.mRequest.feed.busiTranparent.set(paramQCircleInitBean.getFeed().busiTranparent.get());
    }
    this.mRequest.source.set(covertToProtocolSource(paramQCircleInitBean.getExtraTypeInfo().sourceType));
    this.mRequest.listNum.set(10);
    if (paramString2 != null) {
      this.mRequest.adAttchInfo.set(paramString2);
    }
    if (paramString1 != null) {
      this.mRequest.feedAttchInfo.set(paramString1);
    }
    paramString1 = paramQCircleInitBean.getFeedListBusiReq();
    paramString1.isReqLayer.set(true);
    paramString1.detailFeed.set(localStFeed);
    if ((TextUtils.isEmpty(paramString1.tagId.get())) && (TextUtils.isEmpty(paramString1.tagName.get())) && (paramQCircleInitBean.getFeed().tagInfos.has()) && (paramQCircleInitBean.getFeed().tagInfos.get().size() > 0))
    {
      paramString1.tagId.set(((FeedCloudMeta.StTagInfo)paramQCircleInitBean.getFeed().tagInfos.get().get(0)).tagId.get());
      paramString1.tagName.set(((FeedCloudMeta.StTagInfo)paramQCircleInitBean.getFeed().tagInfos.get().get(0)).tagName.get());
    }
    if (paramQCircleInitBean.getPoiInfo().has()) {
      paramString1.tagName.set(paramQCircleInitBean.getPoiInfo().name.get());
    }
    if (paramString3 != null)
    {
      paramString1.refreshAttachInfo.set(paramString3);
      paramString2 = new StringBuilder();
      paramString2.append("QCircleGetFeedListRequest RefreshAttachInfo:");
      paramString2.append(paramString3);
      QLog.d("QCircleGetFeedListRequest", 2, paramString2.toString());
    }
    if (paramQCircleInitBean.getExtraTypeInfo().sourceType == 5)
    {
      paramString1.gpsInfo.set(QCircleGpsHelper.a().e());
      paramQCircleInitBean = new StringBuilder();
      paramQCircleInitBean.append("QCircleGetFeedListRequest setGpsInfo from nearbyTab:");
      paramQCircleInitBean.append(QCircleGpsHelper.a().e());
      QLog.d("QCircleGetFeedListRequest", 2, paramQCircleInitBean.toString());
    }
    a(paramString1);
    this.mRequest.busiReqData.set(ByteStringMicro.copyFrom(paramString1.toByteArray()));
  }
  
  public QCircleGetFeedListRequest(QCirclePolymerizationBean paramQCirclePolymerizationBean, String paramString1, String paramString2)
  {
    if (paramQCirclePolymerizationBean == null) {
      return;
    }
    this.mRequest = new FeedCloudRead.StGetFeedListReq();
    if (!TextUtils.isEmpty(paramString1)) {
      this.mRequest.feedAttchInfo.set(paramString1);
    }
    this.mRequest.listNum.set(10);
    this.mRequest.from.set(0);
    paramString1 = new QQCircleFeedBase.StFeedListBusiReqData();
    if (!TextUtils.isEmpty(paramString2)) {
      paramString1.refreshAttachInfo.set(paramString2);
    }
    int i = paramQCirclePolymerizationBean.getPolymerizationType();
    if (i != 7)
    {
      if (i != 16)
      {
        if (i == 20)
        {
          this.mRequest.source.set(20);
          if (paramQCirclePolymerizationBean.getSimulateData().has()) {
            paramString1.simulateInfo.set(paramQCirclePolymerizationBean.getSimulateData());
          }
          paramString2 = new StringBuilder();
          paramString2.append("QCircleGetFeedListRequest patSamePolymerization  simulate_name: ");
          paramString2.append(paramString1.simulateInfo.simulate_name.get());
          QLog.d("QCircleGetFeedListRequest", 1, paramString2.toString());
        }
      }
      else
      {
        this.mRequest.source.set(16);
        if (paramQCirclePolymerizationBean.getPoiInfo().has())
        {
          if (!TextUtils.isEmpty(paramQCirclePolymerizationBean.getPoiInfo().name.get())) {
            paramString1.tagName.set(paramQCirclePolymerizationBean.getPoiInfo().name.get());
          }
          if (paramQCirclePolymerizationBean.getPoiInfo().gps.has()) {
            paramString1.gpsInfo.set(paramQCirclePolymerizationBean.getPoiInfo().gps.get());
          }
          paramString2 = new StringBuilder();
          paramString2.append("QCircleGetFeedListRequest lbsPolymerization  tagname: ");
          paramString2.append(paramString1.tagName.get());
          QLog.d("QCircleGetFeedListRequest", 1, paramString2.toString());
        }
      }
    }
    else
    {
      this.mRequest.source.set(7);
      paramString2 = paramQCirclePolymerizationBean.getTagInfo();
      if (paramQCirclePolymerizationBean.getTagInfo().has())
      {
        if (!TextUtils.isEmpty(paramString2.tagId.get())) {
          paramString1.tagId.set(paramString2.tagId.get());
        }
        if (!TextUtils.isEmpty(paramString2.tagName.get())) {
          paramString1.tagName.set(paramString2.tagName.get());
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("QCircleGetFeedListRequest tagPolymerization tagId: ");
        localStringBuilder.append(paramString2.tagId.get());
        localStringBuilder.append(" , tagname: ");
        localStringBuilder.append(paramString2.tagName.get());
        QLog.d("QCircleGetFeedListRequest", 1, localStringBuilder.toString());
      }
    }
    paramString2 = new StringBuilder();
    paramString2.append("QCircleGetFeedListRequest polymerization type: ");
    paramString2.append(paramQCirclePolymerizationBean.getPolymerizationType());
    QLog.d("QCircleGetFeedListRequest", 1, paramString2.toString());
    a(paramQCirclePolymerizationBean, paramString1);
    this.mRequest.busiReqData.set(ByteStringMicro.copyFrom(paramString1.toByteArray()));
  }
  
  public QCircleGetFeedListRequest(QCirclePolymerizeDetailBean paramQCirclePolymerizeDetailBean, String paramString1, String paramString2)
  {
    this(paramQCirclePolymerizeDetailBean, paramString1, paramString2, false);
  }
  
  public QCircleGetFeedListRequest(QCirclePolymerizeDetailBean paramQCirclePolymerizeDetailBean, String paramString1, String paramString2, boolean paramBoolean)
  {
    if (paramQCirclePolymerizeDetailBean == null) {
      return;
    }
    this.mRequest = new FeedCloudRead.StGetFeedListReq();
    if (!TextUtils.isEmpty(paramString1)) {
      this.mRequest.feedAttchInfo.set(paramString1);
    }
    this.mRequest.listNum.set(10);
    this.mRequest.from.set(0);
    this.mRequest.source.set(paramQCirclePolymerizeDetailBean.getSourceType());
    paramString1 = new QQCircleFeedBase.StFeedListBusiReqData();
    if (!TextUtils.isEmpty(paramString2)) {
      paramString1.refreshAttachInfo.set(paramString2);
    }
    if (paramQCirclePolymerizeDetailBean.getTransData() != null) {
      paramString1.schemaTrans.set(paramQCirclePolymerizeDetailBean.getTransData());
    }
    paramString1.groupNumber.set(paramQCirclePolymerizeDetailBean.getGroupId());
    paramString1.isNewPageStyle.set(paramBoolean);
    a(paramQCirclePolymerizeDetailBean, paramString1);
    this.mRequest.busiReqData.set(ByteStringMicro.copyFrom(paramString1.toByteArray()));
  }
  
  public QCircleGetFeedListRequest(String paramString1, String paramString2, String paramString3)
  {
    this.mRequest = new FeedCloudRead.StGetFeedListReq();
    if (paramString2 != null) {
      this.mRequest.feedAttchInfo.set(paramString2);
    }
    this.mRequest.listNum.set(10);
    this.mRequest.from.set(0);
    this.mRequest.source.set(9);
    paramString2 = new FeedCloudMeta.StFeed();
    FeedCloudMeta.StUser localStUser = new FeedCloudMeta.StUser();
    localStUser.id.set(paramString1);
    paramString2.poster.set(localStUser);
    this.mRequest.feed.set(paramString2);
    paramString1 = new QQCircleFeedBase.StFeedListBusiReqData();
    if (paramString3 != null)
    {
      paramString1.refreshAttachInfo.set(paramString3);
      paramString2 = new StringBuilder();
      paramString2.append("QCircleGetFeedListRequest RefreshAttachInfo:");
      paramString2.append(paramString3);
      QLog.d("QCircleGetFeedListRequest", 2, paramString2.toString());
    }
    this.mRequest.busiReqData.set(ByteStringMicro.copyFrom(paramString1.toByteArray()));
  }
  
  public QCircleGetFeedListRequest(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this(paramString1, paramString2, false, paramString3, paramString4);
  }
  
  public QCircleGetFeedListRequest(String paramString1, String paramString2, boolean paramBoolean, String paramString3, String paramString4)
  {
    this.mRequest = new FeedCloudRead.StGetFeedListReq();
    if (paramString3 != null) {
      this.mRequest.feedAttchInfo.set(paramString3);
    }
    this.mRequest.listNum.set(10);
    this.mRequest.from.set(0);
    this.mRequest.source.set(7);
    paramString3 = new QQCircleFeedBase.StFeedListBusiReqData();
    if (!TextUtils.isEmpty(paramString1)) {
      paramString3.tagId.set(paramString1);
    }
    if (!TextUtils.isEmpty(paramString2)) {
      paramString3.tagName.set(paramString2);
    }
    if (paramString4 != null)
    {
      paramString3.refreshAttachInfo.set(paramString4);
      paramString1 = new StringBuilder();
      paramString1.append("QCircleGetFeedListRequest RefreshAttachInfo:");
      paramString1.append(paramString4);
      QLog.d("QCircleGetFeedListRequest", 2, paramString1.toString());
    }
    paramString3.isReqLayer.set(paramBoolean);
    this.mRequest.busiReqData.set(ByteStringMicro.copyFrom(paramString3.toByteArray()));
  }
  
  private void a(QCircleInitBean paramQCircleInitBean, QQCircleFeedBase.StFeedListBusiReqData paramStFeedListBusiReqData)
  {
    if (paramQCircleInitBean == null) {
      return;
    }
    if (paramQCircleInitBean.isNeedShowGoHomeButton()) {
      this.mRequest.isMiddlePage.set(true);
    }
    if ((paramQCircleInitBean.getSchemeAttrs() != null) && (paramQCircleInitBean.getSchemeAttrs().containsKey("key_scheme")))
    {
      paramQCircleInitBean = (String)paramQCircleInitBean.getSchemeAttrs().get("key_scheme");
      if (paramQCircleInitBean != null) {
        paramStFeedListBusiReqData.entrySchema.set(paramQCircleInitBean);
      }
    }
  }
  
  private void a(QQCircleFeedBase.StFeedListBusiReqData paramStFeedListBusiReqData)
  {
    int i;
    try
    {
      i = Integer.parseInt(QCircleConfigHelper.bm());
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      i = 0;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("isNewLayerMode:");
    localStringBuilder.append(i);
    QLog.i("QCircleGetFeedListRequest", 1, localStringBuilder.toString());
    if (i > 0) {
      paramStFeedListBusiReqData.pageLayoutType.set(i);
    }
  }
  
  public static int covertToProtocolSource(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 69)
      {
        if (paramInt != 70)
        {
          switch (paramInt)
          {
          default: 
            return paramInt;
          case 13: 
            return 20;
          case 12: 
            return 16;
          case 10: 
            return 10;
          case 9: 
            return 9;
          case 8: 
          case 11: 
            return 8;
          case 7: 
            return 7;
          case 6: 
            return 6;
          case 5: 
            return 5;
          case 4: 
            return 4;
          }
          return 3;
        }
        return 1;
      }
      return 17;
    }
    return 1;
  }
  
  public MessageMicro decode(byte[] paramArrayOfByte)
  {
    FeedCloudRead.StGetFeedListRsp localStGetFeedListRsp = new FeedCloudRead.StGetFeedListRsp();
    try
    {
      localStGetFeedListRsp.mergeFrom(paramArrayOfByte);
      return localStGetFeedListRsp;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return localStGetFeedListRsp;
  }
  
  public String getCmdName()
  {
    return "FeedCloudSvr.trpc.feedcloud.commreader.ComReader.GetFeedList";
  }
  
  protected byte[] getRequestByteData()
  {
    return this.mRequest.toByteArray();
  }
  
  public byte[] getRequestByteKey()
  {
    return getRequestByteData();
  }
  
  protected String getType()
  {
    FeedCloudRead.StGetFeedListReq localStGetFeedListReq = this.mRequest;
    if (localStGetFeedListReq != null) {
      return String.valueOf(localStGetFeedListReq.source.get());
    }
    return super.getType();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.requests.QCircleGetFeedListRequest
 * JD-Core Version:    0.7.0.1
 */