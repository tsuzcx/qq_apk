package com.tencent.biz.qqcircle.requests;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import feedcloud.FeedCloudRead.StGetFeedListReq;
import feedcloud.FeedCloudRead.StGetFeedListRsp;
import qqcircle.QQCircleFeedBase.StFeedListBusiReqData;

public class QCircleGetGroupFeedListRequest
  extends QCircleBaseRequest
{
  private int mListNum = 10;
  public FeedCloudRead.StGetFeedListReq mRequest = new FeedCloudRead.StGetFeedListReq();
  
  public QCircleGetGroupFeedListRequest(long paramLong, String paramString)
  {
    if (paramString != null) {
      this.mRequest.feedAttchInfo.set(paramString);
    }
    this.mRequest.listNum.set(this.mListNum);
    this.mRequest.from.set(0);
    this.mRequest.source.set(18);
    paramString = new QQCircleFeedBase.StFeedListBusiReqData();
    paramString.groupNumber.set(paramLong);
    this.mRequest.busiReqData.set(ByteStringMicro.copyFrom(paramString.toByteArray()));
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
    return "FeedCloudSvr.trpc.feedcloud.commreader.ComReader.GetGroupFeedList";
  }
  
  protected byte[] getRequestByteData()
  {
    return this.mRequest.toByteArray();
  }
  
  public byte[] getRequestByteKey()
  {
    return getRequestByteData();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.requests.QCircleGetGroupFeedListRequest
 * JD-Core Version:    0.7.0.1
 */