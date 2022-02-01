package com.tencent.biz.qqcircle.requests;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import feedcloud.FeedCloudMeta.StUserRecomInfo;
import feedcloud.FeedCloudRead.StGetRecomUserListReq;
import feedcloud.FeedCloudRead.StGetRecomUserListRsp;
import java.util.Iterator;
import java.util.List;
import qqcircle.QQCircleFeedBase.StGetRecomUserListBusiReqData;
import qqcircle.QQCircleFeedBase.StUserRecomInfoBusiData;

public class QCircleGetRecomUserListRequest
  extends QCircleBaseRequest
{
  public FeedCloudRead.StGetRecomUserListReq mRequest = new FeedCloudRead.StGetRecomUserListReq();
  
  public QCircleGetRecomUserListRequest(String paramString1, int paramInt, String paramString2)
  {
    if (paramString1 != null) {
      this.mRequest.attachInfo.set(paramString1);
    }
    paramString1 = new QQCircleFeedBase.StGetRecomUserListBusiReqData();
    paramString1.desUserID.set(paramString2);
    this.mRequest.busiReqData.set(ByteStringMicro.copyFrom(((QQCircleFeedBase.StGetRecomUserListBusiReqData)paramString1.get()).toByteArray()));
    this.mRequest.listType.set(paramInt);
  }
  
  public MessageMicro decode(byte[] paramArrayOfByte)
  {
    FeedCloudRead.StGetRecomUserListRsp localStGetRecomUserListRsp = new FeedCloudRead.StGetRecomUserListRsp();
    try
    {
      localStGetRecomUserListRsp.mergeFrom(paramArrayOfByte);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    paramArrayOfByte = localStGetRecomUserListRsp.userRecoms.get();
    if (!paramArrayOfByte.isEmpty())
    {
      paramArrayOfByte = paramArrayOfByte.iterator();
      int i = 0;
      while (paramArrayOfByte.hasNext())
      {
        FeedCloudMeta.StUserRecomInfo localStUserRecomInfo = (FeedCloudMeta.StUserRecomInfo)paramArrayOfByte.next();
        QQCircleFeedBase.StUserRecomInfoBusiData localStUserRecomInfoBusiData = new QQCircleFeedBase.StUserRecomInfoBusiData();
        try
        {
          localStUserRecomInfoBusiData.mergeFrom(localStUserRecomInfo.busiData.get().toByteArray());
          if ((localStUserRecomInfoBusiData.recomSource.get() == 1) && (i == 0))
          {
            i = 1;
          }
          else if ((localStUserRecomInfoBusiData.recomSource.get() == 1) && (i != 0))
          {
            localStUserRecomInfoBusiData.recomSource.set(0);
            localStUserRecomInfo.busiData.set(ByteStringMicro.copyFrom(((QQCircleFeedBase.StUserRecomInfoBusiData)localStUserRecomInfoBusiData.get()).toByteArray()));
          }
        }
        catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
        {
          localInvalidProtocolBufferMicroException.printStackTrace();
        }
      }
    }
    return localStGetRecomUserListRsp;
  }
  
  public String getCmdName()
  {
    return "FeedCloudSvr.trpc.feedcloud.commreader.ComReader.GetRecomUserList";
  }
  
  protected byte[] getRequestByteData()
  {
    return this.mRequest.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.requests.QCircleGetRecomUserListRequest
 * JD-Core Version:    0.7.0.1
 */