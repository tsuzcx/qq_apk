package com.tencent.biz.qqstory.network.request;

import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.channel.NetworkRequest;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqFeedCommentList;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspFeedCommentList;
import com.tencent.biz.qqstory.storyHome.model.FeedCommentSync;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public class GetFeedCommentRequest
  extends NetworkRequest
{
  public static final String a;
  public FeedCommentSync a;
  
  static
  {
    jdField_a_of_type_JavaLangString = StoryApi.a("StorySvc.feed_comment_list_768");
  }
  
  public BaseResponse a(byte[] paramArrayOfByte)
  {
    qqstory_service.RspFeedCommentList localRspFeedCommentList = new qqstory_service.RspFeedCommentList();
    try
    {
      localRspFeedCommentList.mergeFrom(paramArrayOfByte);
      return new GetFeedCommentRequest.GetFeedCommentResponse(localRspFeedCommentList);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      for (;;)
      {
        paramArrayOfByte.printStackTrace();
      }
    }
  }
  
  public String a()
  {
    return jdField_a_of_type_JavaLangString;
  }
  
  protected byte[] a()
  {
    qqstory_service.ReqFeedCommentList localReqFeedCommentList = new qqstory_service.ReqFeedCommentList();
    localReqFeedCommentList.feed_id.set(ByteStringMicro.copyFromUtf8(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedCommentSync.jdField_a_of_type_JavaLangString));
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedCommentSync.jdField_b_of_type_JavaLangString == null) {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedCommentSync.jdField_b_of_type_JavaLangString = "";
    }
    localReqFeedCommentList.cookie.set(ByteStringMicro.copyFromUtf8(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedCommentSync.jdField_b_of_type_JavaLangString));
    localReqFeedCommentList.source.set(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedCommentSync.jdField_a_of_type_Int);
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedCommentSync.jdField_b_of_type_Int != -1) {
      localReqFeedCommentList.type.set(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedCommentSync.jdField_b_of_type_Int);
    }
    return localReqFeedCommentList.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.request.GetFeedCommentRequest
 * JD-Core Version:    0.7.0.1
 */