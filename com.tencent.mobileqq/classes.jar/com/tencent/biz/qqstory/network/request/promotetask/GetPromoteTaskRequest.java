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
  public static final String h = StoryApi.a("StorySvc.get_promote_tasklist");
  
  public GetPromoteTaskRequest(String paramString)
  {
    super(h, new qqstory_service.ReqGetPromoteTaskList(), null);
    ((qqstory_service.ReqGetPromoteTaskList)this.f).bytes_cookie.set(ByteStringMicro.copyFromUtf8(paramString));
  }
  
  public BaseResponse b(byte[] paramArrayOfByte)
  {
    return new GetPromoteTaskRequest.GetPromoteTaskResponse(paramArrayOfByte);
  }
  
  protected byte[] c()
  {
    SLog.a("GetPromoteTaskRequest", "encode: %s", this);
    return super.c();
  }
  
  public String toString()
  {
    return PBUtils.b(this.f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.request.promotetask.GetPromoteTaskRequest
 * JD-Core Version:    0.7.0.1
 */