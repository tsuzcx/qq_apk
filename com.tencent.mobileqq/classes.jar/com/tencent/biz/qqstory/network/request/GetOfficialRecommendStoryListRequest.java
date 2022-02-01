package com.tencent.biz.qqstory.network.request;

import com.tencent.biz.qqstory.base.QQStoryHandler;
import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.channel.NetworkRequest;
import com.tencent.biz.qqstory.model.lbs.BasicLocation;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqGetOfficialRecommends;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetOfficialRecommends;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.GpsMsg;
import com.tencent.biz.qqstory.network.response.GetOfficialRecommendStoryListResponse;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;

public class GetOfficialRecommendStoryListRequest
  extends NetworkRequest
{
  public static final String a;
  public BasicLocation a;
  public String b = "";
  
  static
  {
    jdField_a_of_type_JavaLangString = QQStoryHandler.g;
  }
  
  public BaseResponse a(byte[] paramArrayOfByte)
  {
    if (!QQStoryHandler.a(paramArrayOfByte))
    {
      SLog.d("Q.qqstory:GetOfficialRecommendStoryListRequest", "GetOfficialRecommendStoryListRequest data is no valid");
      return null;
    }
    qqstory_service.RspGetOfficialRecommends localRspGetOfficialRecommends = new qqstory_service.RspGetOfficialRecommends();
    try
    {
      localRspGetOfficialRecommends.mergeFrom(paramArrayOfByte);
      return new GetOfficialRecommendStoryListResponse(localRspGetOfficialRecommends);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      SLog.d("Q.qqstory:GetOfficialRecommendStoryListRequest", "" + paramArrayOfByte);
    }
    return null;
  }
  
  public String a()
  {
    return jdField_a_of_type_JavaLangString;
  }
  
  public byte[] a()
  {
    qqstory_service.ReqGetOfficialRecommends localReqGetOfficialRecommends = new qqstory_service.ReqGetOfficialRecommends();
    localReqGetOfficialRecommends.count.set(50);
    localReqGetOfficialRecommends.start_cookie.set(ByteStringMicro.copyFromUtf8(this.b));
    if (this.jdField_a_of_type_ComTencentBizQqstoryModelLbsBasicLocation != null)
    {
      localReqGetOfficialRecommends.gps.lat.set(this.jdField_a_of_type_ComTencentBizQqstoryModelLbsBasicLocation.a);
      localReqGetOfficialRecommends.gps.lng.set(this.jdField_a_of_type_ComTencentBizQqstoryModelLbsBasicLocation.b);
      localReqGetOfficialRecommends.gps.setHasFlag(true);
    }
    return localReqGetOfficialRecommends.toByteArray();
  }
  
  public String toString()
  {
    return "GetOfficialRecommendStoryListRequest{count=50start_cookie=" + this.b + "location" + this.jdField_a_of_type_ComTencentBizQqstoryModelLbsBasicLocation + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.request.GetOfficialRecommendStoryListRequest
 * JD-Core Version:    0.7.0.1
 */