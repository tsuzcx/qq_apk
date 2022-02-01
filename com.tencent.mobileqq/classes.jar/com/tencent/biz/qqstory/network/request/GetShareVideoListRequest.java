package com.tencent.biz.qqstory.network.request;

import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.channel.NetworkRequest;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqGetShareVideoList;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetShareVideoList;
import com.tencent.biz.qqstory.network.response.GetShareVideoListResponse;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public class GetShareVideoListRequest
  extends NetworkRequest
{
  public static final String a = StoryApi.a("StorySvc.new_get_shared_video_list");
  public long b;
  public String b;
  public int c;
  public String c;
  public int d = -1;
  
  public GetShareVideoListRequest(String paramString, long paramLong, int paramInt)
  {
    this.jdField_b_of_type_Long = -1L;
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = paramString;
    this.jdField_b_of_type_Long = paramLong;
    this.jdField_c_of_type_Int = 50;
    this.d = paramInt;
  }
  
  public BaseResponse a(byte[] paramArrayOfByte)
  {
    qqstory_service.RspGetShareVideoList localRspGetShareVideoList = new qqstory_service.RspGetShareVideoList();
    try
    {
      localRspGetShareVideoList.mergeFrom(paramArrayOfByte);
      return new GetShareVideoListResponse(this.jdField_b_of_type_JavaLangString, localRspGetShareVideoList);
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
    qqstory_service.ReqGetShareVideoList localReqGetShareVideoList = new qqstory_service.ReqGetShareVideoList();
    if (this.jdField_b_of_type_Long != -1L) {
      localReqGetShareVideoList.share_time.set(this.jdField_b_of_type_Long);
    }
    localReqGetShareVideoList.start_cookie.set(ByteStringMicro.copyFromUtf8(this.jdField_c_of_type_JavaLangString));
    localReqGetShareVideoList.count.set(this.jdField_c_of_type_Int);
    if (this.d != -1) {
      localReqGetShareVideoList.time_zone.set(this.d);
    }
    localReqGetShareVideoList.union_id.set(ByteStringMicro.copyFromUtf8(this.jdField_b_of_type_JavaLangString));
    return localReqGetShareVideoList.toByteArray();
  }
  
  public String toString()
  {
    return "GetShareVideoListRequest{, uid=" + this.jdField_b_of_type_JavaLangString + "count=" + this.jdField_c_of_type_Int + "timeZoneOffset=" + this.d + ", startCookie='" + this.jdField_c_of_type_JavaLangString + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.request.GetShareVideoListRequest
 * JD-Core Version:    0.7.0.1
 */