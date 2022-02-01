package com.tencent.biz.qqcircle.immersive.request;

import com.tencent.biz.qqcircle.immersive.model.barrage.bean.QFSLoadBarrageListBean;
import com.tencent.biz.qqcircle.requests.QCircleBaseRequest;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StLike;
import feedcloud.FeedCloudMeta.StUser;
import feedcloud.FeedCloudRead.StGetCommentListReq;
import feedcloud.FeedCloudRead.StGetCommentListRsp;
import qqcircle.QQCircleFeedBase.StBusiInfoCommentListData;

public class QFSGetBarrageListRequest
  extends QCircleBaseRequest
{
  public FeedCloudRead.StGetCommentListReq mRequest;
  
  public QFSGetBarrageListRequest(QFSLoadBarrageListBean paramQFSLoadBarrageListBean, String paramString, int paramInt)
  {
    if (paramQFSLoadBarrageListBean == null)
    {
      QLog.d("FSCommentListRequest", 1, "[FSGetCommentListRequest] bean should not be null.");
      return;
    }
    Object localObject = paramQFSLoadBarrageListBean.c();
    if (localObject == null) {
      paramQFSLoadBarrageListBean = "";
    } else {
      paramQFSLoadBarrageListBean = ((FeedCloudMeta.StFeed)localObject).likeInfo.id.get();
    }
    this.mRequest = new FeedCloudRead.StGetCommentListReq();
    if (localObject != null)
    {
      this.mRequest.userId.set(((FeedCloudMeta.StFeed)localObject).poster.id.get());
      this.mRequest.feedId.set(((FeedCloudMeta.StFeed)localObject).id.get());
      this.mRequest.busiTranparent.set(((FeedCloudMeta.StFeed)localObject).busiTranparent.get());
      localObject = new QQCircleFeedBase.StBusiInfoCommentListData();
      ((QQCircleFeedBase.StBusiInfoCommentListData)localObject).reqType.set(1);
      this.mRequest.busiReqData.set(ByteStringMicro.copyFrom(((QQCircleFeedBase.StBusiInfoCommentListData)localObject).toByteArray()));
    }
    if (paramString != null) {
      this.mRequest.feedAttchInfo.set(paramString);
    }
    this.mRequest.listNum.set(paramInt);
    this.mRequest.likeKey.set(paramQFSLoadBarrageListBean);
  }
  
  public MessageMicro decode(byte[] paramArrayOfByte)
  {
    FeedCloudRead.StGetCommentListRsp localStGetCommentListRsp = new FeedCloudRead.StGetCommentListRsp();
    try
    {
      localStGetCommentListRsp.mergeFrom(paramArrayOfByte);
      return localStGetCommentListRsp;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return localStGetCommentListRsp;
  }
  
  public String getCmdName()
  {
    return "FeedCloudSvr.trpc.feedcloud.commreader.ComReader.GetCommentList";
  }
  
  protected byte[] getRequestByteData()
  {
    return this.mRequest.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.request.QFSGetBarrageListRequest
 * JD-Core Version:    0.7.0.1
 */