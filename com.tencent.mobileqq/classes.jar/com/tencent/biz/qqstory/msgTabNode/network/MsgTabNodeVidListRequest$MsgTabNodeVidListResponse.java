package com.tencent.biz.qqstory.msgTabNode.network;

import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspMsgTabNodeVideoList;

public class MsgTabNodeVidListRequest$MsgTabNodeVidListResponse
  extends BaseResponse
{
  public MsgTabNodeInfo a;
  public qqstory_service.RspMsgTabNodeVideoList a;
  public byte[] a;
  
  public MsgTabNodeVidListRequest$MsgTabNodeVidListResponse(MsgTabNodeInfo paramMsgTabNodeInfo, qqstory_service.RspMsgTabNodeVideoList paramRspMsgTabNodeVideoList, byte[] paramArrayOfByte)
  {
    super(paramRspMsgTabNodeVideoList.result);
    this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeInfo = paramMsgTabNodeInfo;
    this.jdField_a_of_type_ComTencentBizQqstoryNetworkPbQqstory_service$RspMsgTabNodeVideoList = paramRspMsgTabNodeVideoList;
    this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.network.MsgTabNodeVidListRequest.MsgTabNodeVidListResponse
 * JD-Core Version:    0.7.0.1
 */