package com.tencent.biz.qqstory.network.request;

import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.channel.NetworkRequest;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqGetLabelList;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetLabelList;
import com.tencent.biz.qqstory.network.response.GetLabelListResponse;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public class GetLabelListRequest
  extends NetworkRequest
{
  public static final String a = StoryApi.a("StorySvc.video_tag_search");
  public String b;
  public int c;
  public String c;
  
  public GetLabelListRequest()
  {
    this.jdField_c_of_type_JavaLangString = "";
  }
  
  public BaseResponse a(byte[] paramArrayOfByte)
  {
    qqstory_service.RspGetLabelList localRspGetLabelList = new qqstory_service.RspGetLabelList();
    try
    {
      localRspGetLabelList.mergeFrom(paramArrayOfByte);
      return new GetLabelListResponse(localRspGetLabelList);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      SLog.d("Q.qqstory:GetLabelListRequest", "" + paramArrayOfByte);
    }
    return null;
  }
  
  public String a()
  {
    return a;
  }
  
  public byte[] a()
  {
    qqstory_service.ReqGetLabelList localReqGetLabelList = new qqstory_service.ReqGetLabelList();
    localReqGetLabelList.keyword.set(ByteStringMicro.copyFromUtf8(this.b));
    localReqGetLabelList.count.set(this.jdField_c_of_type_Int);
    localReqGetLabelList.start_cookie.set(ByteStringMicro.copyFromUtf8(this.jdField_c_of_type_JavaLangString));
    return localReqGetLabelList.toByteArray();
  }
  
  public String toString()
  {
    return "GetLabelListRequest{count=" + this.jdField_c_of_type_Int + ", keyword='" + this.b + '\'' + ", startCookie='" + this.jdField_c_of_type_JavaLangString + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.request.GetLabelListRequest
 * JD-Core Version:    0.7.0.1
 */