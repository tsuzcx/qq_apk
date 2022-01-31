package com.tencent.biz.qqcircle.requests;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudCommon.Entry;
import feedcloud.FeedCloudCommon.StCommonExt;
import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudWrite.StDoCommentReq;
import feedcloud.FeedCloudWrite.StDoCommentRsp;
import java.util.ArrayList;
import java.util.List;
import tra;
import tzy;

public class QCircleDoCommentRequest
  extends QCircleBaseRequest
{
  public static final int OPER_TYPE_ADD = 1;
  public static final int OPER_TYPE_DELETE = 0;
  public static final int OPER_TYPE_OWNER_DELETE = 2;
  FeedCloudWrite.StDoCommentReq req;
  
  public QCircleDoCommentRequest(FeedCloudMeta.StFeed paramStFeed, FeedCloudMeta.StComment paramStComment, int paramInt)
  {
    if (paramStFeed == null)
    {
      QLog.w("VSBaseRequest", 1, "stfeed is null");
      return;
    }
    this.req = new FeedCloudWrite.StDoCommentReq();
    this.req.feed.set(tra.a(paramStFeed));
    this.req.comment.set(paramStComment);
    this.req.commentType.set(paramInt);
    this.req.from.set(0);
    if (paramInt == 1) {
      this.req.comment.id.set("");
    }
    paramStFeed = new FeedCloudCommon.Entry();
    paramStFeed.key.set("ext_source");
    if (((tzy.a().c(61)) && (tzy.a().d(57))) || (tzy.a().c(57))) {
      paramStFeed.value.set("2");
    }
    for (;;)
    {
      paramStComment = new FeedCloudCommon.StCommonExt();
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(paramStFeed);
      paramStComment.mapInfo.set(localArrayList);
      this.req.extInfo.set(paramStComment);
      return;
      paramStFeed.value.set("1");
    }
  }
  
  public MessageMicro decode(byte[] paramArrayOfByte)
  {
    FeedCloudWrite.StDoCommentRsp localStDoCommentRsp = new FeedCloudWrite.StDoCommentRsp();
    localStDoCommentRsp.mergeFrom(paramArrayOfByte);
    return localStDoCommentRsp;
  }
  
  public String getCmdName()
  {
    return "FeedCloudSvr.trpc.feedcloud.commwriter.ComWriter.DoComment";
  }
  
  public byte[] getRequestByteData()
  {
    return this.req.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.requests.QCircleDoCommentRequest
 * JD-Core Version:    0.7.0.1
 */