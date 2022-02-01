package com.tencent.biz.qqstory.network.request;

import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.channel.NetworkRequest;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqMarkAsRead;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspMarkAsRead;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;

public class MarkAsReadRequest
  extends NetworkRequest<MarkAsReadRequest.Response>
{
  public static final String e = StoryApi.a("StorySvc.mark_as_read");
  public String f;
  
  public MarkAsReadRequest.Response a(byte[] paramArrayOfByte)
  {
    qqstory_service.RspMarkAsRead localRspMarkAsRead = new qqstory_service.RspMarkAsRead();
    try
    {
      localRspMarkAsRead.mergeFrom(paramArrayOfByte);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return new MarkAsReadRequest.Response(localRspMarkAsRead);
  }
  
  public String a()
  {
    return e;
  }
  
  protected byte[] c()
  {
    qqstory_service.ReqMarkAsRead localReqMarkAsRead = new qqstory_service.ReqMarkAsRead();
    localReqMarkAsRead.union_id.set(ByteStringMicro.copyFromUtf8(this.f));
    return localReqMarkAsRead.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.request.MarkAsReadRequest
 * JD-Core Version:    0.7.0.1
 */