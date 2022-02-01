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
  public static final String a = StoryApi.a("StorySvc.mark_as_read");
  public String b;
  
  public MarkAsReadRequest.Response a(byte[] paramArrayOfByte)
  {
    qqstory_service.RspMarkAsRead localRspMarkAsRead = new qqstory_service.RspMarkAsRead();
    try
    {
      localRspMarkAsRead.mergeFrom(paramArrayOfByte);
      return new MarkAsReadRequest.Response(localRspMarkAsRead);
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
    return a;
  }
  
  public byte[] a()
  {
    qqstory_service.ReqMarkAsRead localReqMarkAsRead = new qqstory_service.ReqMarkAsRead();
    localReqMarkAsRead.union_id.set(ByteStringMicro.copyFromUtf8(this.b));
    return localReqMarkAsRead.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.request.MarkAsReadRequest
 * JD-Core Version:    0.7.0.1
 */