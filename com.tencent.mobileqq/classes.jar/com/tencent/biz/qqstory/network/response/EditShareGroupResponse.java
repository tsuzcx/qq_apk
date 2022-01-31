package com.tencent.biz.qqstory.network.response;

import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspEditShareGroup;

public class EditShareGroupResponse
  extends BaseResponse
{
  public EditShareGroupResponse(qqstory_service.RspEditShareGroup paramRspEditShareGroup)
  {
    super(paramRspEditShareGroup.result);
  }
  
  public String toString()
  {
    return "RspEditShareGroup{errorCode=" + this.a + ", errorMsg='" + this.b + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.response.EditShareGroupResponse
 * JD-Core Version:    0.7.0.1
 */