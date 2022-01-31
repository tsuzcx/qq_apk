package com.tencent.biz.qqstory.msgTabNode.network;

import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.channel.NetworkRequest;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqMsgTabNodeVideoList;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspMsgTabNodeVideoList;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public class MsgTabNodeVidListRequest
  extends NetworkRequest
{
  static final String jdField_a_of_type_JavaLangString = StoryApi.a("StorySvc.get_tab_node_vid_list");
  MsgTabNodeInfo jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeInfo;
  
  public MsgTabNodeVidListRequest(MsgTabNodeInfo paramMsgTabNodeInfo)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeInfo = paramMsgTabNodeInfo;
  }
  
  public static MsgTabNodeVidListRequest.MsgTabNodeVidListResponse a(MsgTabNodeInfo paramMsgTabNodeInfo, byte[] paramArrayOfByte)
  {
    qqstory_service.RspMsgTabNodeVideoList localRspMsgTabNodeVideoList = new qqstory_service.RspMsgTabNodeVideoList();
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
  
  protected byte[] a()
  {
    qqstory_service.ReqMsgTabNodeVideoList localReqMsgTabNodeVideoList = new qqstory_service.ReqMsgTabNodeVideoList();
    localReqMsgTabNodeVideoList.unionID.set(ByteStringMicro.copyFromUtf8(this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeInfo.jdField_a_of_type_JavaLangString));
    localReqMsgTabNodeVideoList.req_time_stamp.set(this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeInfo.c);
    localReqMsgTabNodeVideoList.node_type.set(this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeInfo.jdField_a_of_type_Int);
    localReqMsgTabNodeVideoList.recommend_id.set(this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeInfo.jdField_e_of_type_Long);
    localReqMsgTabNodeVideoList.source.set(this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeInfo.jdField_e_of_type_Int);
    return localReqMsgTabNodeVideoList.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.network.MsgTabNodeVidListRequest
 * JD-Core Version:    0.7.0.1
 */