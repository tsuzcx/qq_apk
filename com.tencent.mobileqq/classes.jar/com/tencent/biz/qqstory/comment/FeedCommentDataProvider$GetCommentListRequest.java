package com.tencent.biz.qqstory.comment;

import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.comment.lego.LegoRequestBase;
import com.tencent.biz.qqstory.comment.lego.LegoResponseBase;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqGetCommentList;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetCommentList;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;

public class FeedCommentDataProvider$GetCommentListRequest
  extends LegoRequestBase
{
  public final String a = StoryApi.a("StorySvc.get_comment_list");
  String b;
  int c;
  
  public FeedCommentDataProvider$GetCommentListRequest(FeedCommentDataProvider paramFeedCommentDataProvider, String paramString, int paramInt)
  {
    this.b = paramString;
    this.c = paramInt;
  }
  
  public LegoResponseBase a(byte[] paramArrayOfByte)
  {
    Object localObject = new qqstory_service.RspGetCommentList();
    try
    {
      ((qqstory_service.RspGetCommentList)localObject).mergeFrom(paramArrayOfByte);
      return new FeedCommentDataProvider.GetCommentListResponse(this.d, (qqstory_service.RspGetCommentList)localObject);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("");
      ((StringBuilder)localObject).append(paramArrayOfByte);
      SLog.d("Q.qqstory:GetCommentListRequest", ((StringBuilder)localObject).toString());
    }
    return null;
  }
  
  public String a()
  {
    return this.a;
  }
  
  protected byte[] b()
  {
    qqstory_service.ReqGetCommentList localReqGetCommentList = new qqstory_service.ReqGetCommentList();
    localReqGetCommentList.vid.set(ByteStringMicro.copyFromUtf8(this.b));
    localReqGetCommentList.latest_comment_id.set(this.c);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getCommentListData by latest_comment_id: ");
      localStringBuilder.append(this.c);
      QLog.d("Q.qqstory:GetCommentListRequest", 2, localStringBuilder.toString());
    }
    return localReqGetCommentList.toByteArray();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GetCommentListRequest{ vid=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", startCommentID=");
    localStringBuilder.append(this.c);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.comment.FeedCommentDataProvider.GetCommentListRequest
 * JD-Core Version:    0.7.0.1
 */