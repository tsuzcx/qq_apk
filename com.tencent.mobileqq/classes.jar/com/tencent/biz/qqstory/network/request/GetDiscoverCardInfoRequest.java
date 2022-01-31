package com.tencent.biz.qqstory.network.request;

import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.channel.NetworkRequest;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqCardList;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspCardList;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.GpsMsg;
import com.tencent.biz.qqstory.network.response.GetDiscoverCardInfoResponse;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public class GetDiscoverCardInfoRequest
  extends NetworkRequest
{
  public long a;
  public String a;
  public int c;
  public int d;
  public int e;
  public int f;
  
  public BaseResponse a(byte[] paramArrayOfByte)
  {
    qqstory_service.RspCardList localRspCardList = new qqstory_service.RspCardList();
    try
    {
      localRspCardList.mergeFrom(paramArrayOfByte);
      return new GetDiscoverCardInfoResponse(localRspCardList);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      SLog.d("Q.qqstory:GetDiscoverCardInfoRequest", "" + paramArrayOfByte);
    }
    return null;
  }
  
  public String a()
  {
    return StoryApi.a("StorySvc.get_discovery_index");
  }
  
  protected byte[] a()
  {
    qqstory_service.ReqCardList localReqCardList = new qqstory_service.ReqCardList();
    localReqCardList.start_cookie.set(ByteStringMicro.copyFromUtf8(this.jdField_a_of_type_JavaLangString));
    localReqCardList.count.set(this.c);
    if (this.d == 0) {
      localReqCardList.req_type.set(2);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Long > 0L) {
        localReqCardList.topic_id.set(this.jdField_a_of_type_Long);
      }
      if (this.e > 0)
      {
        qqstory_struct.GpsMsg localGpsMsg = new qqstory_struct.GpsMsg();
        localGpsMsg.lat.set(this.e);
        localGpsMsg.lng.set(this.f);
        localReqCardList.gps.set(localGpsMsg);
      }
      return localReqCardList.toByteArray();
      if (this.d == 1) {
        localReqCardList.req_type.set(1);
      } else if (this.d == 2) {
        localReqCardList.req_type.set(3);
      }
    }
  }
  
  public String toString()
  {
    return "GetDiscoverCardInfoRequest{listType=" + this.d + ", startCookie='" + this.jdField_a_of_type_JavaLangString + '\'' + ", pageCount=" + this.c + ", topicId=" + this.jdField_a_of_type_Long + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.request.GetDiscoverCardInfoRequest
 * JD-Core Version:    0.7.0.1
 */