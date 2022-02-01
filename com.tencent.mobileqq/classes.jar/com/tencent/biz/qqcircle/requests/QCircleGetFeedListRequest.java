package com.tencent.biz.qqcircle.requests;

import android.text.TextUtils;
import com.tencent.TMG.utils.QLog;
import com.tencent.biz.qqcircle.QCircleInitBean;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StGPSV2;
import feedcloud.FeedCloudMeta.StPoiInfoV2;
import feedcloud.FeedCloudMeta.StTagInfo;
import feedcloud.FeedCloudMeta.StUser;
import feedcloud.FeedCloudRead.StGetFeedListReq;
import feedcloud.FeedCloudRead.StGetFeedListRsp;
import java.util.List;
import qqcircle.QQCircleFeedBase.StFeedListBusiReqData;
import uxx;
import uzo;

public class QCircleGetFeedListRequest
  extends QCircleBaseRequest
{
  private boolean mIsTabRequest;
  private int mListNum = 10;
  public FeedCloudRead.StGetFeedListReq mRequest;
  private FeedCloudRead.StGetFeedListReq mTabRequest;
  
  public QCircleGetFeedListRequest(QCircleInitBean paramQCircleInitBean, String paramString)
  {
    this.mRequest = new FeedCloudRead.StGetFeedListReq();
    FeedCloudMeta.StFeed localStFeed = uxx.a(paramQCircleInitBean.getFeed());
    if (paramString == null)
    {
      this.mRequest.feed.set(localStFeed);
      this.mRequest.feed.busiTranparent.set(paramQCircleInitBean.getFeed().busiTranparent.get());
    }
    this.mRequest.source.set(17);
    this.mRequest.listNum.set(this.mListNum);
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
    FeedCloudMeta.StFeed localStFeed = uxx.a(paramQCircleInitBean.getFeed());
    if (paramString1 == null)
    {
      this.mRequest.feed.set(localStFeed);
      this.mRequest.feed.busiTranparent.set(paramQCircleInitBean.getFeed().busiTranparent.get());
    }
    this.mRequest.source.set(covertToProtocolSource(paramQCircleInitBean.getExtraTypeInfo().sourceType));
    this.mRequest.listNum.set(this.mListNum);
    if (paramString2 != null) {
      this.mRequest.adAttchInfo.set(paramString2);
    }
    if (paramString1 != null) {
      this.mRequest.feedAttchInfo.set(paramString1);
    }
    paramString1 = paramQCircleInitBean.getFeedListBusiReq();
    paramString1.isReqLayer.set(true);
    paramString1.detailFeed.set(localStFeed);
    if ((paramQCircleInitBean.getFeed().tagInfos.has()) && (paramQCircleInitBean.getFeed().tagInfos.get().size() > 0))
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
      QLog.d("QCircleGetFeedListRequest", 0, "QCircleGetFeedListRequest RefreshAttachInfo:" + paramString3);
    }
    this.mRequest.busiReqData.set(ByteStringMicro.copyFrom(paramString1.toByteArray()));
  }
  
  public QCircleGetFeedListRequest(String paramString1, String paramString2, String paramString3)
  {
    this.mRequest = new FeedCloudRead.StGetFeedListReq();
    if (paramString2 != null) {
      this.mRequest.feedAttchInfo.set(paramString2);
    }
    this.mRequest.listNum.set(this.mListNum);
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
      QLog.d("QCircleGetFeedListRequest", 0, "QCircleGetFeedListRequest RefreshAttachInfo:" + paramString3);
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
    this.mRequest.listNum.set(this.mListNum);
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
      QLog.d("QCircleGetFeedListRequest", 0, "QCircleGetFeedListRequest RefreshAttachInfo:" + paramString4);
    }
    paramString3.isReqLayer.set(paramBoolean);
    this.mRequest.busiReqData.set(ByteStringMicro.copyFrom(paramString3.toByteArray()));
  }
  
  public QCircleGetFeedListRequest(uzo paramuzo, String paramString1, String paramString2, FeedCloudMeta.StGPSV2 paramStGPSV2)
  {
    this.mIsTabRequest = true;
    this.mRequest = new FeedCloudRead.StGetFeedListReq();
    if (paramString1 != null) {
      this.mRequest.feedAttchInfo.set(paramString1);
    }
    this.mRequest.listNum.set(this.mListNum);
    this.mRequest.from.set(0);
    this.mRequest.source.set(paramuzo.b());
    this.mTabRequest = new FeedCloudRead.StGetFeedListReq();
    try
    {
      this.mTabRequest.mergeFrom(this.mRequest.toByteArray());
      paramString1 = new QQCircleFeedBase.StFeedListBusiReqData();
      paramString1.tabAttachInfo.set(paramuzo.b());
      if (paramString2 != null)
      {
        paramString1.refreshAttachInfo.set(paramString2);
        QLog.d("QCircleGetFeedListRequest", 0, "QCircleGetFeedListRequest RefreshAttachInfo:" + paramString2);
      }
      if (paramStGPSV2 != null) {
        paramString1.gpsInfo.set(paramStGPSV2);
      }
      this.mRequest.busiReqData.set(ByteStringMicro.copyFrom(paramString1.toByteArray()));
      return;
    }
    catch (InvalidProtocolBufferMicroException paramString1)
    {
      for (;;)
      {
        paramString1.printStackTrace();
      }
    }
  }
  
  public static int covertToProtocolSource(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return -1;
    case 1: 
      return 1;
    case 3: 
      return 3;
    case 4: 
      return 4;
    case 5: 
      return 5;
    case 6: 
      return 6;
    case 7: 
      return 7;
    case 9: 
      return 9;
    case 10: 
      return 10;
    case 8: 
    case 11: 
      return 8;
    case 12: 
      return 16;
    }
    return 17;
  }
  
  public MessageMicro decode(byte[] paramArrayOfByte)
  {
    FeedCloudRead.StGetFeedListRsp localStGetFeedListRsp = new FeedCloudRead.StGetFeedListRsp();
    localStGetFeedListRsp.mergeFrom(paramArrayOfByte);
    return localStGetFeedListRsp;
  }
  
  public String getCmdName()
  {
    return "FeedCloudSvr.trpc.feedcloud.commreader.ComReader.GetFeedList";
  }
  
  public byte[] getRequestByteData()
  {
    return this.mRequest.toByteArray();
  }
  
  public byte[] getRequestByteKey()
  {
    if ((this.mIsTabRequest) && (this.mTabRequest != null)) {
      return this.mTabRequest.toByteArray();
    }
    return getRequestByteData();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.requests.QCircleGetFeedListRequest
 * JD-Core Version:    0.7.0.1
 */