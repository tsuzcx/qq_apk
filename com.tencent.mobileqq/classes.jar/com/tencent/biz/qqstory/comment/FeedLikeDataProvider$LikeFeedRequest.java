package com.tencent.biz.qqstory.comment;

import com.tencent.biz.qqstory.comment.lego.LegoRequestBase;
import com.tencent.biz.qqstory.comment.lego.LegoResponseBase;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqLikeFeed;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspLikeFeed;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public class FeedLikeDataProvider$LikeFeedRequest
  extends LegoRequestBase
{
  int jdField_a_of_type_Int;
  String jdField_a_of_type_JavaLangString;
  boolean jdField_a_of_type_Boolean;
  int b = -1;
  
  public FeedLikeDataProvider$LikeFeedRequest(String paramString, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.b = paramInt1;
    this.jdField_a_of_type_Int = paramInt2;
  }
  
  public LegoResponseBase a(byte[] paramArrayOfByte)
  {
    qqstory_service.RspLikeFeed localRspLikeFeed = new qqstory_service.RspLikeFeed();
    try
    {
      localRspLikeFeed.mergeFrom(paramArrayOfByte);
      return new FeedLikeDataProvider.LikeFeedRespone(localRspLikeFeed);
    }
    catch (Exception paramArrayOfByte)
    {
      SLog.d("Q.qqstory:FeedLikeDataProvider", "" + paramArrayOfByte);
    }
    return null;
  }
  
  public String a()
  {
    return FeedLikeDataProvider.b;
  }
  
  public byte[] a()
  {
    qqstory_service.ReqLikeFeed localReqLikeFeed = new qqstory_service.ReqLikeFeed();
    localReqLikeFeed.feed_id.set(ByteStringMicro.copyFromUtf8(this.jdField_a_of_type_JavaLangString));
    PBUInt32Field localPBUInt32Field = localReqLikeFeed.operation;
    if (this.jdField_a_of_type_Boolean) {}
    for (int i = 1;; i = 2)
    {
      localPBUInt32Field.set(i);
      localReqLikeFeed.source.set(this.jdField_a_of_type_Int);
      if (this.b != -1) {
        localReqLikeFeed.type.set(this.b);
      }
      return localReqLikeFeed.toByteArray();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.comment.FeedLikeDataProvider.LikeFeedRequest
 * JD-Core Version:    0.7.0.1
 */