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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("RspEditShareGroup{errorCode=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", errorMsg='");
    localStringBuilder.append(this.d);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.response.EditShareGroupResponse
 * JD-Core Version:    0.7.0.1
 */