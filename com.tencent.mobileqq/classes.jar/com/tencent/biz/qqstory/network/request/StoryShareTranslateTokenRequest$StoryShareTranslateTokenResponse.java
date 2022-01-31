package com.tencent.biz.qqstory.network.request;

import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspTranslateToken;

public class StoryShareTranslateTokenRequest$StoryShareTranslateTokenResponse
  extends BaseResponse
{
  public long a;
  public String a;
  public String c;
  
  public StoryShareTranslateTokenRequest$StoryShareTranslateTokenResponse(qqstory_service.RspTranslateToken paramRspTranslateToken) {}
  
  public String toString()
  {
    return "StoryShareTranslateTokenResponse{coverUrl='" + this.c + '\'' + ", dstBuffer='" + this.jdField_a_of_type_JavaLangString + '\'' + ", shootTimeMillis=" + this.jdField_a_of_type_Long + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.request.StoryShareTranslateTokenRequest.StoryShareTranslateTokenResponse
 * JD-Core Version:    0.7.0.1
 */