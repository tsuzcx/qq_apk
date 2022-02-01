package com.tencent.biz.qqcircle.immersive.aggregation.request;

import android.text.TextUtils;
import com.tencent.biz.qqcircle.immersive.aggregation.bean.QFSMusicAggregationInitBean;
import com.tencent.biz.qqcircle.requests.QCircleBaseRequest;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudMeta.StFeedMusic;
import feedcloud.FeedCloudRead.StGetFeedListReq;
import feedcloud.FeedCloudRead.StGetFeedListRsp;
import qqcircle.QQCircleFeedBase.StFeedListBusiReqData;

public class QFSGetFeedListMusicRequest
  extends QCircleBaseRequest
{
  public FeedCloudRead.StGetFeedListReq mRequest = new FeedCloudRead.StGetFeedListReq();
  
  public QFSGetFeedListMusicRequest(QFSMusicAggregationInitBean paramQFSMusicAggregationInitBean, String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString1)) {
      this.mRequest.feedAttchInfo.set(paramString1);
    }
    this.mRequest.from.set(0);
    this.mRequest.source.set(43);
    paramString1 = new QQCircleFeedBase.StFeedListBusiReqData();
    if (!TextUtils.isEmpty(paramString2)) {
      paramString1.refreshAttachInfo.set(paramString2);
    }
    if ((paramQFSMusicAggregationInitBean != null) && (paramQFSMusicAggregationInitBean.getFeedMusic() != null)) {
      paramString1.musicInfo.set(paramQFSMusicAggregationInitBean.getFeedMusic());
    }
    this.mRequest.busiReqData.set(ByteStringMicro.copyFrom(paramString1.toByteArray()));
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
    return "FeedCloudSvr.trpc.feedcloud.commreader.ComReader.GetFeedListMusic";
  }
  
  protected byte[] getRequestByteData()
  {
    return this.mRequest.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.aggregation.request.QFSGetFeedListMusicRequest
 * JD-Core Version:    0.7.0.1
 */