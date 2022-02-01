package com.tencent.biz.qqstory.comment;

import com.tencent.biz.qqstory.comment.lego.LegoRequestBase;
import com.tencent.biz.qqstory.comment.lego.LegoResponseBase;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqFeedLikeList;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspFeedLikeList;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public class FeedLikeDataProvider$GetLikeListRequest
  extends LegoRequestBase
{
  String jdField_a_of_type_JavaLangString;
  boolean jdField_a_of_type_Boolean;
  
  public FeedLikeDataProvider$GetLikeListRequest(FeedLikeDataProvider paramFeedLikeDataProvider, String paramString, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public LegoResponseBase a(byte[] paramArrayOfByte)
  {
    Object localObject = new qqstory_service.RspFeedLikeList();
    try
    {
      ((qqstory_service.RspFeedLikeList)localObject).mergeFrom(paramArrayOfByte);
      return new FeedLikeDataProvider.GetLikeListResponse(this.jdField_a_of_type_ComTencentBizQqstoryCommentFeedLikeDataProvider, (qqstory_service.RspFeedLikeList)localObject, this.jdField_a_of_type_Boolean);
    }
    catch (Exception paramArrayOfByte)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("");
      ((StringBuilder)localObject).append(paramArrayOfByte);
      SLog.d("Q.qqstory:FeedLikeDataProvider", ((StringBuilder)localObject).toString());
    }
    return null;
  }
  
  public String a()
  {
    return FeedLikeDataProvider.jdField_a_of_type_JavaLangString;
  }
  
  protected byte[] a()
  {
    qqstory_service.ReqFeedLikeList localReqFeedLikeList = new qqstory_service.ReqFeedLikeList();
    localReqFeedLikeList.feed_id.set(ByteStringMicro.copyFromUtf8(this.jdField_a_of_type_JavaLangString));
    int i;
    if (this.jdField_a_of_type_Boolean) {
      i = 2;
    } else {
      i = 1;
    }
    localReqFeedLikeList.source.set(i);
    return localReqFeedLikeList.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.comment.FeedLikeDataProvider.GetLikeListRequest
 * JD-Core Version:    0.7.0.1
 */