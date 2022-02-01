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
  int jdField_b_of_type_Int;
  String jdField_b_of_type_JavaLangString;
  int jdField_c_of_type_Int;
  String jdField_c_of_type_JavaLangString;
  String d;
  
  public FeedCommentDataProvider$AddFeedCommentRequest(CommentEntry paramCommentEntry, LegoResponseCallBack paramLegoResponseCallBack)
  {
    this(paramCommentEntry.feedId, paramCommentEntry.replierUnionId, paramCommentEntry.content, paramCommentEntry.fakeId, paramCommentEntry.pbType, paramCommentEntry.extras, paramCommentEntry.commentType, paramLegoResponseCallBack);
    this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry = paramCommentEntry;
  }
  
  public FeedCommentDataProvider$AddFeedCommentRequest(String paramString1, String paramString2, String paramString3, long paramLong, int paramInt1, String paramString4, int paramInt2, LegoResponseCallBack paramLegoResponseCallBack)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_c_of_type_JavaLangString = paramString3;
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_b_of_type_Int = paramInt1;
    this.jdField_c_of_type_Int = paramInt2;
    this.d = paramString4;
    this.jdField_a_of_type_ComTencentBizQqstoryCommentLegoLegoResponseCallBack = paramLegoResponseCallBack;
    paramString1 = StoryReportor.a("home_page-comment_suc-d1");
    if (TextUtils.isEmpty(paramString1)) {
      paramInt1 = 0;
    } else {
      paramInt1 = Integer.parseInt(paramString1);
    }
    this.jdField_a_of_type_Int = paramInt1;
  }
  
  public LegoResponseBase a(byte[] paramArrayOfByte)
  {
    Object localObject = new qqstory_service.RspAddFeedComment();
    try
    {
      ((qqstory_service.RspAddFeedComment)localObject).mergeFrom(paramArrayOfByte);
      return new FeedCommentDataProvider.AddFeedCommentResponse((qqstory_service.RspAddFeedComment)localObject, this.jdField_a_of_type_ComTencentBizQqstoryCommentLegoLegoResponseCallBack);
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
    return FeedCommentDataProvider.jdField_a_of_type_JavaLangString;
  }
  
  protected byte[] a()
  {
    qqstory_service.ReqAddFeedComment localReqAddFeedComment = new qqstory_service.ReqAddFeedComment();
    localReqAddFeedComment.feed_id.set(ByteStringMicro.copyFromUtf8(this.jdField_a_of_type_JavaLangString));
    localReqAddFeedComment.content.set(ByteStringMicro.copyFromUtf8(this.jdField_c_of_type_JavaLangString));
    localReqAddFeedComment.fake_id.set(this.jdField_a_of_type_Long);
    localReqAddFeedComment.source.set(this.jdField_a_of_type_Int);
    if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
      localReqAddFeedComment.reply_union_id.set(ByteStringMicro.copyFromUtf8(this.jdField_b_of_type_JavaLangString));
    }
    if (this.jdField_b_of_type_Int == 1) {
      localReqAddFeedComment.type.set(1);
    } else {
      localReqAddFeedComment.type.set(0);
    }
    localReqAddFeedComment.comment_type.set(this.jdField_c_of_type_Int);
    if (!TextUtils.isEmpty(this.d)) {
      localReqAddFeedComment.extras.set(ByteStringMicro.copyFromUtf8(this.d));
    }
    return localReqAddFeedComment.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.comment.FeedCommentDataProvider.AddFeedCommentRequest
 * JD-Core Version:    0.7.0.1
 */