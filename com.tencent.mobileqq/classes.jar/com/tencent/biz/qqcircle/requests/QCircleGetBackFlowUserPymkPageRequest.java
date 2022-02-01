package com.tencent.biz.qqcircle.requests;

import com.tencent.biz.qqcircle.utils.QCircleProtoUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.global.QCircleHostGlobalInfo;
import feedcloud.FeedCloudCommon.Entry;
import feedcloud.FeedCloudCommon.StCommonExt;
import feedcloud.FeedCloudEeveeBase.StEeveeAttachInfo;
import feedcloud.FeedCloudRead.StGetFeedListReq;
import feedcloud.FeedCloudRead.StGetFeedListRsp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import qqcircle.QQCircleFeedBase.StFeedListBusiReqData;

public class QCircleGetBackFlowUserPymkPageRequest
  extends QCircleBaseRequest
{
  public FeedCloudRead.StGetFeedListReq mRequest = new FeedCloudRead.StGetFeedListReq();
  
  public QCircleGetBackFlowUserPymkPageRequest()
  {
    this.mRequest.source.set(32);
    this.mRequest.extInfo.mapInfo.set(a(QCircleProtoUtil.a(QCircleHostGlobalInfo.getEeveeAttachInfos())));
  }
  
  private List<FeedCloudCommon.Entry> a(List<FeedCloudEeveeBase.StEeveeAttachInfo> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      FeedCloudEeveeBase.StEeveeAttachInfo localStEeveeAttachInfo = (FeedCloudEeveeBase.StEeveeAttachInfo)paramList.next();
      FeedCloudCommon.Entry localEntry = new FeedCloudCommon.Entry();
      localEntry.key.set(localStEeveeAttachInfo.key.get());
      localEntry.value.set(localStEeveeAttachInfo.value.get());
      localArrayList.add(localEntry);
    }
    return localArrayList;
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
    return "FeedCloudSvr.trpc.feedcloud.commreader.ComReader.GetBackflowUserPymkPageFeedList";
  }
  
  protected byte[] getRequestByteData()
  {
    return this.mRequest.toByteArray();
  }
  
  public byte[] getRequestByteKey()
  {
    return getRequestByteData();
  }
  
  public void setTransferData(String paramString)
  {
    if (this.mRequest != null)
    {
      QQCircleFeedBase.StFeedListBusiReqData localStFeedListBusiReqData = new QQCircleFeedBase.StFeedListBusiReqData();
      localStFeedListBusiReqData.schemaTrans.set(paramString);
      this.mRequest.busiReqData.set(ByteStringMicro.copyFrom(localStFeedListBusiReqData.toByteArray()));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.requests.QCircleGetBackFlowUserPymkPageRequest
 * JD-Core Version:    0.7.0.1
 */