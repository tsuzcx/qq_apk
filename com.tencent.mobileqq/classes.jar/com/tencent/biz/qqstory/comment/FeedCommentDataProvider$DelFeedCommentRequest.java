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
  int jdField_a_of_type_Int;
  LegoResponseCallBack jdField_a_of_type_ComTencentBizQqstoryCommentLegoLegoResponseCallBack;
  String jdField_a_of_type_JavaLangString;
  
  public FeedCommentDataProvider$DelFeedCommentRequest(CommentEntry paramCommentEntry, LegoResponseCallBack paramLegoResponseCallBack)
  {
    this.jdField_a_of_type_JavaLangString = paramCommentEntry.feedId;
    this.jdField_a_of_type_Int = paramCommentEntry.commentId;
    this.jdField_a_of_type_ComTencentBizQqstoryCommentLegoLegoResponseCallBack = paramLegoResponseCallBack;
  }
  
  public LegoResponseBase a(byte[] paramArrayOfByte)
  {
    qqstory_service.RspDelFeedComment localRspDelFeedComment = new qqstory_service.RspDelFeedComment();
    try
    {
      localRspDelFeedComment.mergeFrom(paramArrayOfByte);
      return new FeedCommentDataProvider.DelFeedCommentResponse(localRspDelFeedComment, this.jdField_a_of_type_ComTencentBizQqstoryCommentLegoLegoResponseCallBack);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      SLog.d("Q.qqstory:FeedCommentDataProvider", "" + paramArrayOfByte);
    }
    return null;
  }
  
  public String a()
  {
    return FeedCommentDataProvider.b;
  }
  
  public byte[] a()
  {
    qqstory_service.ReqDelFeedComment localReqDelFeedComment = new qqstory_service.ReqDelFeedComment();
    localReqDelFeedComment.feed_id.set(ByteStringMicro.copyFromUtf8(this.jdField_a_of_type_JavaLangString));
    localReqDelFeedComment.comment_id.set(this.jdField_a_of_type_Int);
    return localReqDelFeedComment.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.comment.FeedCommentDataProvider.DelFeedCommentRequest
 * JD-Core Version:    0.7.0.1
 */