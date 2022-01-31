package com.tencent.biz.qqstory.msgTabNode.network;

import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.channel.NetworkRequest;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqMsgTabNodeList;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspMsgTabNodeList;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public class MsgTabNodeListRequest
  extends NetworkRequest
{
  static final String a = StoryApi.a("StoryTabSvc.startpage_feeds_list_725");
  public String b;
  public int c;
  public String c;
  
  public BaseResponse a(byte[] paramArrayOfByte)
  {
    qqstory_service.RspMsgTabNodeList localRspMsgTabNodeList = new qqstory_service.RspMsgTabNodeList();
    try
    {
      localRspMsgTabNodeList.mergeFrom(paramArrayOfByte);
      return new MsgTabNodeListRequest.MsgTabNodeListResponse(localRspMsgTabNodeList);
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
    return a;
  }
  
  protected byte[] a()
  {
    qqstory_service.ReqMsgTabNodeList localReqMsgTabNodeList = new qqstory_service.ReqMsgTabNodeList();
    if (this.b != null) {
      localReqMsgTabNodeList.current_seq.set(ByteStringMicro.copyFromUtf8(this.b));
    }
    localReqMsgTabNodeList.source.set(this.jdField_c_of_type_Int);
    if (this.jdField_c_of_type_JavaLangString != null) {
      localReqMsgTabNodeList.start_cookie.set(ByteStringMicro.copyFromUtf8(this.jdField_c_of_type_JavaLangString));
    }
    localReqMsgTabNodeList.version.set(1);
    return localReqMsgTabNodeList.toByteArray();
  }
  
  public String toString()
  {
    return "MsgTabNodeListRequest{cookie='" + this.jdField_c_of_type_JavaLangString + '\'' + ", seq='" + this.b + '\'' + ", source=" + this.jdField_c_of_type_Int + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.network.MsgTabNodeListRequest
 * JD-Core Version:    0.7.0.1
 */