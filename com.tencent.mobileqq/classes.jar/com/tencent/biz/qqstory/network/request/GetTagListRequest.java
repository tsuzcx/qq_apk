package com.tencent.biz.qqstory.network.request;

import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.channel.NetworkRequest;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqGetTagList;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetTagList;
import com.tencent.biz.qqstory.network.response.GetTagListResponse;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public class GetTagListRequest
  extends NetworkRequest
{
  private static final String jdField_a_of_type_JavaLangString = StoryApi.a("StorySvc.get_label_list");
  private long jdField_a_of_type_Long;
  private final boolean jdField_a_of_type_Boolean;
  private final String b;
  private int c;
  private final int d;
  
  public GetTagListRequest(int paramInt1, long paramLong, String paramString, int paramInt2)
  {
    this.c = paramInt1;
    this.jdField_a_of_type_Long = paramLong;
    this.b = paramString;
    this.d = paramInt2;
    this.jdField_a_of_type_Boolean = true;
  }
  
  public GetTagListRequest(String paramString, int paramInt)
  {
    this.b = paramString;
    this.d = paramInt;
    this.jdField_a_of_type_Boolean = false;
  }
  
  public BaseResponse a(byte[] paramArrayOfByte)
  {
    qqstory_service.RspGetTagList localRspGetTagList = new qqstory_service.RspGetTagList();
    try
    {
      localRspGetTagList.mergeFrom(paramArrayOfByte);
      return new GetTagListResponse(localRspGetTagList);
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
    return jdField_a_of_type_JavaLangString;
  }
  
  protected byte[] a()
  {
    qqstory_service.ReqGetTagList localReqGetTagList = new qqstory_service.ReqGetTagList();
    if (this.jdField_a_of_type_Boolean)
    {
      localReqGetTagList.music_type.set(this.c);
      localReqGetTagList.music_id.set(this.jdField_a_of_type_Long);
    }
    localReqGetTagList.start_cookie.set(this.b);
    localReqGetTagList.size.set(this.d);
    return localReqGetTagList.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.request.GetTagListRequest
 * JD-Core Version:    0.7.0.1
 */