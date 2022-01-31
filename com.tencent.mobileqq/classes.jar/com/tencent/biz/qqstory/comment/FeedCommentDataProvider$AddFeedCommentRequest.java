package com.tencent.biz.qqstory.comment;

import android.text.TextUtils;
import com.tencent.biz.qqstory.comment.lego.LegoRequestBase;
import com.tencent.biz.qqstory.comment.lego.LegoResponseBase;
import com.tencent.biz.qqstory.comment.lego.LegoResponseCallBack;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqAddFeedComment;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspAddFeedComment;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public class FeedCommentDataProvider$AddFeedCommentRequest
  extends LegoRequestBase
{
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long;
  LegoResponseCallBack jdField_a_of_type_ComTencentBizQqstoryCommentLegoLegoResponseCallBack;
  CommentEntry jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry;
  String jdField_a_of_type_JavaLangString;
  String b;
  String c;
  
  public FeedCommentDataProvider$AddFeedCommentRequest(CommentEntry paramCommentEntry, LegoResponseCallBack paramLegoResponseCallBack)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry = paramCommentEntry;
    this.jdField_a_of_type_JavaLangString = paramCommentEntry.feedId;
    this.b = paramCommentEntry.replierUnionId;
    this.c = paramCommentEntry.content;
    this.jdField_a_of_type_Long = paramCommentEntry.fakeId;
    this.jdField_a_of_type_ComTencentBizQqstoryCommentLegoLegoResponseCallBack = paramLegoResponseCallBack;
    paramCommentEntry = StoryReportor.a("home_page-comment_suc-d1");
    if (TextUtils.isEmpty(paramCommentEntry)) {}
    for (int i = 0;; i = Integer.parseInt(paramCommentEntry))
    {
      this.jdField_a_of_type_Int = i;
      return;
    }
  }
  
  public LegoResponseBase a(byte[] paramArrayOfByte)
  {
    qqstory_service.RspAddFeedComment localRspAddFeedComment = new qqstory_service.RspAddFeedComment();
    try
    {
      localRspAddFeedComment.mergeFrom(paramArrayOfByte);
      return new FeedCommentDataProvider.AddFeedCommentResponse(localRspAddFeedComment, this.jdField_a_of_type_ComTencentBizQqstoryCommentLegoLegoResponseCallBack);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      SLog.d("Q.qqstory:FeedCommentDataProvider", "" + paramArrayOfByte);
    }
    return null;
  }
  
  public String a()
  {
    return FeedCommentDataProvider.jdField_a_of_type_JavaLangString;
  }
  
  protected byte[] a()
  {
    qqstory_service.ReqAddFeedComment localReqAddFeedComment = new qqstory_service.ReqAddFeedComment();
    localReqAddFeedComment.feed_id.set(ByteStringMicro.copyFromUtf8(this.jdField_a_of_type_JavaLangString));
    localReqAddFeedComment.content.set(ByteStringMicro.copyFromUtf8(this.c));
    localReqAddFeedComment.fake_id.set(this.jdField_a_of_type_Long);
    localReqAddFeedComment.source.set(this.jdField_a_of_type_Int);
    if (!TextUtils.isEmpty(this.b)) {
      localReqAddFeedComment.reply_union_id.set(ByteStringMicro.copyFromUtf8(this.b));
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry.pbType == 1) {
      localReqAddFeedComment.type.set(1);
    }
    for (;;)
    {
      return localReqAddFeedComment.toByteArray();
      localReqAddFeedComment.type.set(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.comment.FeedCommentDataProvider.AddFeedCommentRequest
 * JD-Core Version:    0.7.0.1
 */