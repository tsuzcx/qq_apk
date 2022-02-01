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
  extends NetworkRequest<GetTagListResponse>
{
  private static final String jdField_a_of_type_JavaLangString = StoryApi.a("StorySvc.get_label_list");
  private final boolean jdField_a_of_type_Boolean;
  private long jdField_b_of_type_Long;
  private final String jdField_b_of_type_JavaLangString;
  private int c;
  private final int d;
  
  public BaseResponse a(byte[] paramArrayOfByte)
  {
    qqstory_service.RspGetTagList localRspGetTagList = new qqstory_service.RspGetTagList();
    try
    {
      localRspGetTagList.mergeFrom(paramArrayOfByte);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return new GetTagListResponse(localRspGetTagList);
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
      localReqGetTagList.music_id.set(this.jdField_b_of_type_Long);
    }
    localReqGetTagList.start_cookie.set(this.jdField_b_of_type_JavaLangString);
    localReqGetTagList.size.set(this.d);
    return localReqGetTagList.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.request.GetTagListRequest
 * JD-Core Version:    0.7.0.1
 */