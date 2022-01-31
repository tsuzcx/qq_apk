package com.tencent.biz.qqstory.network.request;

import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.channel.NetworkRequest;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqGroupDateVideoList;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGroupDateVideoList;
import com.tencent.biz.qqstory.network.response.GetShareGroupDateListResponse;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public class GetShareGroupDateListRequest
  extends NetworkRequest
{
  public long a;
  public String a;
  public String b = "";
  public int c;
  private final String c;
  public int d;
  public int e;
  public int f;
  
  public GetShareGroupDateListRequest()
  {
    this.jdField_c_of_type_JavaLangString = StoryApi.a("StoryGroupSvc.datacard_get_feeds_new");
  }
  
  public BaseResponse a(byte[] paramArrayOfByte)
  {
    qqstory_service.RspGroupDateVideoList localRspGroupDateVideoList = new qqstory_service.RspGroupDateVideoList();
    try
    {
      localRspGroupDateVideoList.mergeFrom(paramArrayOfByte);
      return new GetShareGroupDateListResponse(this.jdField_a_of_type_JavaLangString, localRspGroupDateVideoList);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      SLog.b("Q.qqstory.shareGroup:GetShareGroupDateListRequest", a(), paramArrayOfByte);
    }
    return null;
  }
  
  public String a()
  {
    return this.jdField_c_of_type_JavaLangString;
  }
  
  protected byte[] a()
  {
    qqstory_service.ReqGroupDateVideoList localReqGroupDateVideoList = new qqstory_service.ReqGroupDateVideoList();
    localReqGroupDateVideoList.from.set(this.e);
    localReqGroupDateVideoList.group_unionid.set(ByteStringMicro.copyFromUtf8(this.jdField_a_of_type_JavaLangString));
    localReqGroupDateVideoList.start_cookie.set(ByteStringMicro.copyFromUtf8(this.b));
    localReqGroupDateVideoList.date_count.set(this.jdField_c_of_type_Int);
    localReqGroupDateVideoList.video_count.set(this.d);
    localReqGroupDateVideoList.seqno.set(this.jdField_a_of_type_Long);
    if (this.f != -1) {
      localReqGroupDateVideoList.time_zone.set(this.f);
    }
    return localReqGroupDateVideoList.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.request.GetShareGroupDateListRequest
 * JD-Core Version:    0.7.0.1
 */