package com.tencent.biz.qqstory.msgTabNode.network;

import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_service.MsgTabNodeInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspMsgTabNodeList;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MsgTabNodeListRequest$MsgTabNodeListResponse
  extends BaseResponse
{
  public String a;
  public ArrayList a;
  public boolean a;
  public String c;
  
  public MsgTabNodeListRequest$MsgTabNodeListResponse(qqstory_service.RspMsgTabNodeList paramRspMsgTabNodeList)
  {
    super(paramRspMsgTabNodeList.result);
    this.jdField_a_of_type_JavaLangString = paramRspMsgTabNodeList.list_seq.get().toStringUtf8();
    this.c = paramRspMsgTabNodeList.next_cookie.get().toStringUtf8();
    boolean bool1 = bool2;
    if (paramRspMsgTabNodeList.is_end.has()) {
      if (paramRspMsgTabNodeList.is_end.get() != 1) {
        break label148;
      }
    }
    label148:
    for (bool1 = bool2;; bool1 = false)
    {
      this.jdField_a_of_type_Boolean = bool1;
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(paramRspMsgTabNodeList.node_list.size());
      paramRspMsgTabNodeList = paramRspMsgTabNodeList.node_list.get().iterator();
      while (paramRspMsgTabNodeList.hasNext())
      {
        qqstory_service.MsgTabNodeInfo localMsgTabNodeInfo = (qqstory_service.MsgTabNodeInfo)paramRspMsgTabNodeList.next();
        MsgTabNodeInfo localMsgTabNodeInfo1 = new MsgTabNodeInfo();
        localMsgTabNodeInfo1.a(localMsgTabNodeInfo);
        this.jdField_a_of_type_JavaUtilArrayList.add(localMsgTabNodeInfo1);
      }
    }
  }
  
  public String toString()
  {
    return "MsgTabNodeListResponse{cookie='" + this.c + '\'' + ", seq='" + this.jdField_a_of_type_JavaLangString + '\'' + ", isEnd=" + this.jdField_a_of_type_Boolean + ", nodeList=" + this.jdField_a_of_type_JavaUtilArrayList + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.network.MsgTabNodeListRequest.MsgTabNodeListResponse
 * JD-Core Version:    0.7.0.1
 */