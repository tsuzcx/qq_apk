package com.tencent.biz.qqstory.network.response;

import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetBatchUserVidList;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.UserVidList;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GetVidListResponse
  extends BaseResponse
{
  public List<GetVidListResponse.UserVidList> a = new ArrayList();
  
  public GetVidListResponse(qqstory_service.RspGetBatchUserVidList paramRspGetBatchUserVidList)
  {
    super(paramRspGetBatchUserVidList.result);
    paramRspGetBatchUserVidList = paramRspGetBatchUserVidList.user_vid_list.get().iterator();
    while (paramRspGetBatchUserVidList.hasNext())
    {
      qqstory_struct.UserVidList localUserVidList = (qqstory_struct.UserVidList)paramRspGetBatchUserVidList.next();
      this.a.add(new GetVidListResponse.UserVidList(this, localUserVidList));
    }
  }
  
  public String toString()
  {
    return "GetVidListResponse{mUserVidList=" + this.a + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.response.GetVidListResponse
 * JD-Core Version:    0.7.0.1
 */