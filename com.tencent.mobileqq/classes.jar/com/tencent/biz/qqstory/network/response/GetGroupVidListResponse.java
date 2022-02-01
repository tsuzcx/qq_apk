package com.tencent.biz.qqstory.network.response;

import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetGroupVidList;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.UserVidList;

public class GetGroupVidListResponse
  extends BaseResponse
{
  public GetGroupVidListResponse.UserVidList a;
  
  public GetGroupVidListResponse(qqstory_service.RspGetGroupVidList paramRspGetGroupVidList)
  {
    super(paramRspGetGroupVidList.result);
    this.a = new GetGroupVidListResponse.UserVidList(this, (qqstory_struct.UserVidList)paramRspGetGroupVidList.user_vid_list.get());
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GetGroupVidListResponse{mUserVidList=");
    localStringBuilder.append(this.a);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.response.GetGroupVidListResponse
 * JD-Core Version:    0.7.0.1
 */