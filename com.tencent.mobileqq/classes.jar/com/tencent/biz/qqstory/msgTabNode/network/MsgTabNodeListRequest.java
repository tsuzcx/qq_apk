package com.tencent.biz.qqstory.msgTabNode.network;

import android.os.Build;
import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.channel.NetworkRequest;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqMsgTabNodeList;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspMsgTabNodeList;
import com.tencent.biz.qqstory.utils.LocationUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public class MsgTabNodeListRequest
  extends NetworkRequest
{
  static final String a;
  static boolean b;
  public boolean a;
  public String b;
  public int c;
  public String c;
  
  static
  {
    jdField_a_of_type_JavaLangString = StoryApi.a("StoryTabSvc.startpage_feeds_list_725");
    jdField_b_of_type_Boolean = false;
  }
  
  public MsgTabNodeListRequest()
  {
    this.jdField_a_of_type_Boolean = false;
  }
  
  public BaseResponse a(byte[] paramArrayOfByte)
  {
    qqstory_service.RspMsgTabNodeList localRspMsgTabNodeList = new qqstory_service.RspMsgTabNodeList();
    try
    {
      localRspMsgTabNodeList.mergeFrom(paramArrayOfByte);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return new MsgTabNodeListRequest.MsgTabNodeListResponse(localRspMsgTabNodeList);
  }
  
  public String a()
  {
    return jdField_a_of_type_JavaLangString;
  }
  
  protected byte[] a()
  {
    if (jdField_b_of_type_Boolean)
    {
      this.jdField_b_of_type_JavaLangString = null;
      this.jdField_c_of_type_JavaLangString = null;
    }
    qqstory_service.ReqMsgTabNodeList localReqMsgTabNodeList = new qqstory_service.ReqMsgTabNodeList();
    if (this.jdField_b_of_type_JavaLangString != null) {
      localReqMsgTabNodeList.current_seq.set(ByteStringMicro.copyFromUtf8(this.jdField_b_of_type_JavaLangString));
    }
    localReqMsgTabNodeList.source.set(this.jdField_c_of_type_Int);
    if (this.jdField_c_of_type_JavaLangString != null) {
      localReqMsgTabNodeList.start_cookie.set(ByteStringMicro.copyFromUtf8(this.jdField_c_of_type_JavaLangString));
    }
    localReqMsgTabNodeList.version.set(4);
    Long localLong = LocationUtils.a();
    if (localLong != null) {
      localReqMsgTabNodeList.adcode.set(localLong.longValue());
    }
    localReqMsgTabNodeList.device.set(ByteStringMicro.copyFromUtf8(Build.DEVICE));
    localReqMsgTabNodeList.force_refresh.set(this.jdField_a_of_type_Boolean);
    localReqMsgTabNodeList.client_version.set(ByteStringMicro.copyFromUtf8("8.7.0"));
    return localReqMsgTabNodeList.toByteArray();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MsgTabNodeListRequest{cookie='");
    localStringBuilder.append(this.jdField_c_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", seq='");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", source=");
    localStringBuilder.append(this.jdField_c_of_type_Int);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.network.MsgTabNodeListRequest
 * JD-Core Version:    0.7.0.1
 */