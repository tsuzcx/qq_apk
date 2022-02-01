package com.tencent.biz.qqstory.comment;

import com.tencent.biz.qqstory.comment.lego.LegoRequestBase;
import com.tencent.biz.qqstory.comment.lego.LegoResponseBase;
import com.tencent.biz.qqstory.comment.lego.LegoResponseCallBack;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqDelFeedComment;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspDelFeedComment;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public class FeedCommentDataProvider$DelFeedCommentRequest
  extends LegoRequestBase
{
  String a;
  int b;
  LegoResponseCallBack c;
  
  public FeedCommentDataProvider$DelFeedCommentRequest(CommentEntry paramCommentEntry, LegoResponseCallBack paramLegoResponseCallBack)
  {
    this.a = paramCommentEntry.feedId;
    this.b = paramCommentEntry.commentId;
    this.c = paramLegoResponseCallBack;
  }
  
  public LegoResponseBase a(byte[] paramArrayOfByte)
  {
    Object localObject = new qqstory_service.RspDelFeedComment();
    try
    {
      ((qqstory_service.RspDelFeedComment)localObject).mergeFrom(paramArrayOfByte);
      return new FeedCommentDataProvider.DelFeedCommentResponse((qqstory_service.RspDelFeedComment)localObject, this.c);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("");
      ((StringBuilder)localObject).append(paramArrayOfByte);
      SLog.d("Q.qqstory:FeedCommentDataProvider", ((StringBuilder)localObject).toString());
    }
    return null;
  }
  
  public String a()
  {
    return FeedCommentDataProvider.b;
  }
  
  protected byte[] b()
  {
    qqstory_service.ReqDelFeedComment localReqDelFeedComment = new qqstory_service.ReqDelFeedComment();
    localReqDelFeedComment.feed_id.set(ByteStringMicro.copyFromUtf8(this.a));
    localReqDelFeedComment.comment_id.set(this.b);
    return localReqDelFeedComment.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.comment.FeedCommentDataProvider.DelFeedCommentRequest
 * JD-Core Version:    0.7.0.1
 */