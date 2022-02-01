package com.tencent.biz.qqcircle.requests;

import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
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
import feedcloud.FeedCloudMeta.StReply;
import feedcloud.FeedCloudWrite.StDoReplyReq;
import feedcloud.FeedCloudWrite.StDoReplyRsp;
import java.util.ArrayList;
import java.util.List;

public class QCircleDoReplyRequest
  extends QCircleBaseRequest
{
  public static final int OPER_TYPE_ADD = 1;
  public static final int OPER_TYPE_DELETE = 0;
  public static final int OPER_TYPE_OWNER_DELETE = 2;
  FeedCloudWrite.StDoReplyReq req;
  
  public QCircleDoReplyRequest(FeedCloudMeta.StFeed paramStFeed, FeedCloudMeta.StComment paramStComment, FeedCloudMeta.StReply paramStReply, int paramInt, boolean paramBoolean)
  {
    if (paramStFeed == null)
    {
      QLog.w("VSBaseRequest", 1, "stfeed is null");
      return;
    }
    this.req = new FeedCloudWrite.StDoReplyReq();
    this.req.feed.set(QCirclePluginUtil.a(paramStFeed));
    this.req.comment.set(paramStComment);
    this.req.reply.set(paramStReply);
    this.req.from.set(0);
    this.req.replyType.set(paramInt);
    if (paramInt == 1) {
      this.req.reply.id.set("");
    }
    paramStFeed = new FeedCloudCommon.Entry();
    paramStFeed.key.set("ext_source");
    if (paramBoolean) {
      paramStFeed.value.set("2");
    } else {
      paramStFeed.value.set("1");
    }
    paramStComment = new FeedCloudCommon.StCommonExt();
    paramStReply = new ArrayList();
    paramStReply.add(paramStFeed);
    paramStComment.mapInfo.set(paramStReply);
    this.req.extInfo.set(paramStComment);
  }
  
  public MessageMicro decode(byte[] paramArrayOfByte)
  {
    FeedCloudWrite.StDoReplyRsp localStDoReplyRsp = new FeedCloudWrite.StDoReplyRsp();
    try
    {
      localStDoReplyRsp.mergeFrom(paramArrayOfByte);
      return localStDoReplyRsp;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return localStDoReplyRsp;
  }
  
  public String getCmdName()
  {
    return "FeedCloudSvr.trpc.feedcloud.commwriter.ComWriter.DoReply";
  }
  
  protected byte[] getRequestByteData()
  {
    return this.req.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.requests.QCircleDoReplyRequest
 * JD-Core Version:    0.7.0.1
 */