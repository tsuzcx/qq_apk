package com.tencent.biz.qqcircle.requests;

import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudRead.StGetMainPageReq;
import feedcloud.FeedCloudRead.StGetMainPageRsp;
import java.util.HashMap;
import qqcircle.QQCircleFeedBase.StMainPageBusiReqData;

public class QCircleGetMainPageRequest
  extends QCircleBaseRequest
{
  public FeedCloudRead.StGetMainPageReq mRequest = new FeedCloudRead.StGetMainPageReq();
  
  public QCircleGetMainPageRequest(String paramString)
  {
    this(paramString, null);
  }
  
  public QCircleGetMainPageRequest(String paramString1, String paramString2)
  {
    this(paramString1, paramString2, null);
  }
  
  public QCircleGetMainPageRequest(String paramString1, String paramString2, QCircleInitBean paramQCircleInitBean)
  {
    if (paramString2 != null) {
      this.mRequest.feedAttchInfo.set(paramString2);
    }
    if (paramString1 != null) {
      this.mRequest.userId.set(paramString1);
    }
    this.mRequest.from.set(0);
    if (paramQCircleInitBean != null)
    {
      if (paramQCircleInitBean.isNeedShowGoHomeButton()) {
        this.mRequest.isMiddlePage.set(true);
      }
      if ((paramQCircleInitBean.getSchemeAttrs() != null) && (paramQCircleInitBean.getSchemeAttrs().containsKey("key_scheme")))
      {
        paramString1 = (String)paramQCircleInitBean.getSchemeAttrs().get("key_scheme");
        paramString2 = new QQCircleFeedBase.StMainPageBusiReqData();
        if (paramString1 != null) {
          paramString2.entrySchema.set(paramString1);
        }
        this.mRequest.busiReqData.set(ByteStringMicro.copyFrom(paramString2.toByteArray()));
      }
    }
  }
  
  public MessageMicro decode(byte[] paramArrayOfByte)
  {
    FeedCloudRead.StGetMainPageRsp localStGetMainPageRsp = new FeedCloudRead.StGetMainPageRsp();
    try
    {
      localStGetMainPageRsp.mergeFrom(paramArrayOfByte);
      return localStGetMainPageRsp;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return localStGetMainPageRsp;
  }
  
  public String getCmdName()
  {
    return "FeedCloudSvr.trpc.feedcloud.commreader.ComReader.GetMainpage";
  }
  
  protected byte[] getRequestByteData()
  {
    return this.mRequest.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.requests.QCircleGetMainPageRequest
 * JD-Core Version:    0.7.0.1
 */