package com.tencent.biz.qqstory.network.request.promotetask;

import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqGetPromoteTaskList;
import com.tencent.biz.qqstory.network.request.CommonRequest;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.PBUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;

public class GetPromoteTaskRequest
  extends CommonRequest<qqstory_service.ReqGetPromoteTaskList>
{
  public static final String b = StoryApi.a("StorySvc.get_promote_tasklist");
  
  public GetPromoteTaskRequest(String paramString)
  {
    super(b, new qqstory_service.ReqGetPromoteTaskList(), null);
    ((qqstory_service.ReqGetPromoteTaskList)this.a).bytes_cookie.set(ByteStringMicro.copyFromUtf8(paramString));
  }
  
  public BaseResponse a(byte[] paramArrayOfByte)
  {
    return new GetPromoteTaskRequest.GetPromoteTaskResponse(paramArrayOfByte);
  }
  
  public byte[] a()
  {
    SLog.a("GetPromoteTaskRequest", "encode: %s", this);
    return super.a();
  }
  
  public String toString()
  {
    return PBUtils.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.request.promotetask.GetPromoteTaskRequest
 * JD-Core Version:    0.7.0.1
 */