package com.tencent.biz.qqstory.network.request.square;

import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.channel.NetworkRequest;
import com.tencent.biz.qqstory.model.lbs.BasicLocation;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqDiscoveryShareGroupList;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspDiscoveryShareGroupList;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.GpsMsg;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;

public class GetSquareFeedIdListRequest
  extends NetworkRequest
{
  public static final String a;
  public BasicLocation a;
  public String b;
  
  static
  {
    jdField_a_of_type_JavaLangString = StoryApi.a("StorySvc.square_720_share_group_list");
  }
  
  public BaseResponse a(byte[] paramArrayOfByte)
  {
    qqstory_service.RspDiscoveryShareGroupList localRspDiscoveryShareGroupList = new qqstory_service.RspDiscoveryShareGroupList();
    try
    {
      localRspDiscoveryShareGroupList.mergeFrom(paramArrayOfByte);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return new GetSquareFeedIdListRequest.GetSquareFeedIdListResponse(localRspDiscoveryShareGroupList);
  }
  
  public String a()
  {
    return jdField_a_of_type_JavaLangString;
  }
  
  protected byte[] a()
  {
    qqstory_service.ReqDiscoveryShareGroupList localReqDiscoveryShareGroupList = new qqstory_service.ReqDiscoveryShareGroupList();
    localReqDiscoveryShareGroupList.start_cookie.set(ByteStringMicro.copyFromUtf8(this.b));
    if (this.jdField_a_of_type_ComTencentBizQqstoryModelLbsBasicLocation != null)
    {
      localReqDiscoveryShareGroupList.coordinate.set(this.jdField_a_of_type_ComTencentBizQqstoryModelLbsBasicLocation.c);
      localReqDiscoveryShareGroupList.gps.setHasFlag(true);
      localReqDiscoveryShareGroupList.gps.lat.set(this.jdField_a_of_type_ComTencentBizQqstoryModelLbsBasicLocation.a);
      localReqDiscoveryShareGroupList.gps.lng.set(this.jdField_a_of_type_ComTencentBizQqstoryModelLbsBasicLocation.b);
    }
    return localReqDiscoveryShareGroupList.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.request.square.GetSquareFeedIdListRequest
 * JD-Core Version:    0.7.0.1
 */