package com.tencent.biz.qqstory.network.request.promotetask;

import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetPromoteTaskList;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.ErrorInfo;
import com.tencent.biz.qqstory.network.response.CommonResponse;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.PBUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public class GetPromoteTaskRequest$GetPromoteTaskResponse
  extends CommonResponse
{
  public qqstory_service.RspGetPromoteTaskList a = new qqstory_service.RspGetPromoteTaskList();
  
  public GetPromoteTaskRequest$GetPromoteTaskResponse(byte[] paramArrayOfByte)
  {
    super(paramArrayOfByte);
    try
    {
      this.a.mergeFrom(paramArrayOfByte);
      this.d = this.a.result.error_desc.get().toStringUtf8();
      this.c = this.a.result.error_code.get();
      SLog.a("GetPromoteTaskResponse", "GetPromoteTaskResponse(): %s", PBUtils.b(this.a));
      return;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      SLog.c("GetPromoteTaskResponse", "Error GetPromoteTaskResponse()", paramArrayOfByte);
    }
  }
  
  public String toString()
  {
    return PBUtils.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.request.promotetask.GetPromoteTaskRequest.GetPromoteTaskResponse
 * JD-Core Version:    0.7.0.1
 */