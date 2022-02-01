package com.tencent.biz.qqcircle.requests;

import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import feedcloud.FeedCloudMeta.StGPSV2;
import feedcloud.FeedCloudRead.StGetFeedListReq;
import feedcloud.FeedCloudRead.StGetFeedListRsp;
import qqcircle.QQCircleFeedBase.StFeedListBusiReqData;
import uzo;

public class QCircleGetGroupFeedListRequest
  extends QCircleBaseRequest
{
  private boolean mIsTabRequest = true;
  private int mListNum = 10;
  public FeedCloudRead.StGetFeedListReq mRequest = new FeedCloudRead.StGetFeedListReq();
  private FeedCloudRead.StGetFeedListReq mTabRequest;
  
  public QCircleGetGroupFeedListRequest(long paramLong, uzo paramuzo, String paramString1, String paramString2, FeedCloudMeta.StGPSV2 paramStGPSV2)
  {
    if (paramString1 != null) {
      this.mRequest.feedAttchInfo.set(paramString1);
    }
    this.mRequest.listNum.set(this.mListNum);
    this.mRequest.from.set(0);
    this.mRequest.source.set(18);
    this.mTabRequest = new FeedCloudRead.StGetFeedListReq();
    try
    {
      this.mTabRequest.mergeFrom(this.mRequest.toByteArray());
      paramString1 = new QQCircleFeedBase.StFeedListBusiReqData();
      paramString1.tabAttachInfo.set(paramuzo.b());
      if (paramString2 != null)
      {
        paramString1.refreshAttachInfo.set(paramString2);
        QLog.d("QCircleGetGroupFeedListRequest", 0, "QCircleGetGroupFeedListRequest RefreshAttachInfo:" + paramString2);
      }
      if (paramStGPSV2 != null) {
        paramString1.gpsInfo.set(paramStGPSV2);
      }
      paramString1.groupNumber.set(paramLong);
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
  
  public MessageMicro decode(byte[] paramArrayOfByte)
  {
    FeedCloudRead.StGetFeedListRsp localStGetFeedListRsp = new FeedCloudRead.StGetFeedListRsp();
    localStGetFeedListRsp.mergeFrom(paramArrayOfByte);
    return localStGetFeedListRsp;
  }
  
  public String getCmdName()
  {
    return "FeedCloudSvr.trpc.feedcloud.commreader.ComReader.GetGroupFeedList";
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
 * Qualified Name:     com.tencent.biz.qqcircle.requests.QCircleGetGroupFeedListRequest
 * JD-Core Version:    0.7.0.1
 */