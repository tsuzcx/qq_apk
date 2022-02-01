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
  String a;
  String b;
  String c;
  long d;
  int e;
  int f;
  int g;
  String h;
  CommentEntry i;
  LegoResponseCallBack j;
  
  public FeedCommentDataProvider$AddFeedCommentRequest(CommentEntry paramCommentEntry, LegoResponseCallBack paramLegoResponseCallBack)
  {
    this(paramCommentEntry.feedId, paramCommentEntry.replierUnionId, paramCommentEntry.content, paramCommentEntry.fakeId, paramCommentEntry.pbType, paramCommentEntry.extras, paramCommentEntry.commentType, paramLegoResponseCallBack);
    this.i = paramCommentEntry;
  }
  
  public FeedCommentDataProvider$AddFeedCommentRequest(String paramString1, String paramString2, String paramString3, long paramLong, int paramInt1, String paramString4, int paramInt2, LegoResponseCallBack paramLegoResponseCallBack)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramString3;
    this.d = paramLong;
    this.f = paramInt1;
    this.g = paramInt2;
    this.h = paramString4;
    this.j = paramLegoResponseCallBack;
    paramString1 = StoryReportor.a("home_page-comment_suc-d1");
    if (TextUtils.isEmpty(paramString1)) {
      paramInt1 = 0;
    } else {
      paramInt1 = Integer.parseInt(paramString1);
    }
    this.e = paramInt1;
  }
  
  public LegoResponseBase a(byte[] paramArrayOfByte)
  {
    Object localObject = new qqstory_service.RspAddFeedComment();
    try
    {
      ((qqstory_service.RspAddFeedComment)localObject).mergeFrom(paramArrayOfByte);
      return new FeedCommentDataProvider.AddFeedCommentResponse((qqstory_service.RspAddFeedComment)localObject, this.j);
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
    return FeedCommentDataProvider.a;
  }
  
  protected byte[] b()
  {
    qqstory_service.ReqAddFeedComment localReqAddFeedComment = new qqstory_service.ReqAddFeedComment();
    localReqAddFeedComment.feed_id.set(ByteStringMicro.copyFromUtf8(this.a));
    localReqAddFeedComment.content.set(ByteStringMicro.copyFromUtf8(this.c));
    localReqAddFeedComment.fake_id.set(this.d);
    localReqAddFeedComment.source.set(this.e);
    if (!TextUtils.isEmpty(this.b)) {
      localReqAddFeedComment.reply_union_id.set(ByteStringMicro.copyFromUtf8(this.b));
    }
    if (this.f == 1) {
      localReqAddFeedComment.type.set(1);
    } else {
      localReqAddFeedComment.type.set(0);
    }
    localReqAddFeedComment.comment_type.set(this.g);
    if (!TextUtils.isEmpty(this.h)) {
      localReqAddFeedComment.extras.set(ByteStringMicro.copyFromUtf8(this.h));
    }
    return localReqAddFeedComment.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.comment.FeedCommentDataProvider.AddFeedCommentRequest
 * JD-Core Version:    0.7.0.1
 */