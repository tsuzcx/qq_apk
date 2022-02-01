package com.tencent.biz.qqstory.msgTabNode.network;

import android.os.Build;
import android.text.TextUtils;
import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.channel.NetworkRequest;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqMsgTabNodeVideoList;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspMsgTabNodeVideoList;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.LocationUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public class MsgTabNodeVidListRequest
  extends NetworkRequest<MsgTabNodeVidListRequest.MsgTabNodeVidListResponse>
{
  static final String jdField_a_of_type_JavaLangString = StoryApi.a("StorySvc.get_tab_node_vid_list");
  MsgTabNodeInfo jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeInfo;
  String b = "";
  String c = "";
  
  public MsgTabNodeVidListRequest(MsgTabNodeInfo paramMsgTabNodeInfo, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeInfo = paramMsgTabNodeInfo;
    this.b = paramString1;
    this.c = paramString2;
  }
  
  public static MsgTabNodeVidListRequest.MsgTabNodeVidListResponse a(MsgTabNodeInfo paramMsgTabNodeInfo, byte[] paramArrayOfByte)
  {
    qqstory_service.RspMsgTabNodeVideoList localRspMsgTabNodeVideoList = new qqstory_service.RspMsgTabNodeVideoList();
    if (paramArrayOfByte != null) {}
    try
    {
      localRspMsgTabNodeVideoList.mergeFrom(paramArrayOfByte);
      return new MsgTabNodeVidListRequest.MsgTabNodeVidListResponse(paramMsgTabNodeInfo, localRspMsgTabNodeVideoList, paramArrayOfByte);
    }
    catch (InvalidProtocolBufferMicroException paramMsgTabNodeInfo)
    {
      SLog.d("Q.qqstory:ReqMsgTabNodeVideoList", "" + paramMsgTabNodeInfo);
    }
    return null;
  }
  
  public MsgTabNodeVidListRequest.MsgTabNodeVidListResponse a(byte[] paramArrayOfByte)
  {
    return a(this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeInfo, paramArrayOfByte);
  }
  
  public String a()
  {
    return jdField_a_of_type_JavaLangString;
  }
  
  public byte[] a()
  {
    qqstory_service.ReqMsgTabNodeVideoList localReqMsgTabNodeVideoList = new qqstory_service.ReqMsgTabNodeVideoList();
    localReqMsgTabNodeVideoList.unionID.set(ByteStringMicro.copyFromUtf8(this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeInfo.jdField_a_of_type_JavaLangString));
    localReqMsgTabNodeVideoList.req_time_stamp.set(this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeInfo.c);
    localReqMsgTabNodeVideoList.node_type.set(this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeInfo.jdField_a_of_type_Int);
    localReqMsgTabNodeVideoList.recommend_id.set(this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeInfo.e);
    localReqMsgTabNodeVideoList.source.set(this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeInfo.f);
    if (this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeInfo.jdField_a_of_type_Int == 12)
    {
      if ((TextUtils.isEmpty(this.b)) && (!TextUtils.isEmpty(this.c))) {
        localReqMsgTabNodeVideoList.start_vid.set(this.c);
      }
      if (!TextUtils.isEmpty(this.b)) {
        localReqMsgTabNodeVideoList.cookie.set(this.b);
      }
      localReqMsgTabNodeVideoList.page_size.set(20);
    }
    Long localLong = LocationUtils.a();
    if (localLong != null) {
      localReqMsgTabNodeVideoList.adcode.set(localLong.longValue());
    }
    localReqMsgTabNodeVideoList.device.set(ByteStringMicro.copyFromUtf8(Build.DEVICE));
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeInfo.k)) {
      localReqMsgTabNodeVideoList.passthrough.set(ByteStringMicro.copyFromUtf8(this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeInfo.k));
    }
    return localReqMsgTabNodeVideoList.toByteArray();
  }
  
  public String toString()
  {
    return "MsgTabNodeVidListRequest{nodeInfo.unionId=" + this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeInfo.jdField_a_of_type_JavaLangString + ", mCookie='" + this.b + '\'' + ", mStartVid='" + this.c + '\'' + "} " + super.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.network.MsgTabNodeVidListRequest
 * JD-Core Version:    0.7.0.1
 */