package com.tencent.biz.qqcircle.requests;

import android.text.TextUtils;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudRead.StClearCountInfo;
import feedcloud.FeedCloudRead.StClearCountReq;
import feedcloud.FeedCloudRead.StClearCountRsp;
import java.util.ArrayList;
import java.util.List;

public class QCircleClearCountRequest
  extends QCircleBaseRequest
{
  private FeedCloudRead.StClearCountReq mRequest = new FeedCloudRead.StClearCountReq();
  
  public QCircleClearCountRequest(String paramString, FeedCloudRead.StClearCountInfo paramStClearCountInfo)
  {
    if (paramStClearCountInfo != null)
    {
      ArrayList localArrayList = new ArrayList(1);
      localArrayList.add(paramStClearCountInfo);
      this.mRequest.clearCountInfos.set(localArrayList);
    }
    if (!TextUtils.isEmpty(paramString)) {
      this.mRequest.userId.set(paramString);
    }
  }
  
  public MessageMicro decode(byte[] paramArrayOfByte)
  {
    FeedCloudRead.StClearCountRsp localStClearCountRsp = new FeedCloudRead.StClearCountRsp();
    try
    {
      localStClearCountRsp.mergeFrom(paramArrayOfByte);
      return localStClearCountRsp;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return localStClearCountRsp;
  }
  
  public String getCmdName()
  {
    return "FeedCloudSvr.trpc.feedcloud.commreader.ComReader.ClearCount";
  }
  
  protected byte[] getRequestByteData()
  {
    return this.mRequest.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.requests.QCircleClearCountRequest
 * JD-Core Version:    0.7.0.1
 */