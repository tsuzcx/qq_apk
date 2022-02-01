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
  public boolean a;
  public String b;
  public String e;
  public boolean f;
  public ArrayList<MsgTabNodeInfo> g;
  
  public MsgTabNodeListRequest$MsgTabNodeListResponse(qqstory_service.RspMsgTabNodeList paramRspMsgTabNodeList)
  {
    super(paramRspMsgTabNodeList.result);
    boolean bool2 = false;
    this.a = false;
    this.b = paramRspMsgTabNodeList.list_seq.get().toStringUtf8();
    this.e = paramRspMsgTabNodeList.next_cookie.get().toStringUtf8();
    boolean bool1;
    if (paramRspMsgTabNodeList.is_animate.get() > 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.a = bool1;
    if (paramRspMsgTabNodeList.is_end.has())
    {
      bool1 = bool2;
      if (paramRspMsgTabNodeList.is_end.get() != 1) {}
    }
    else
    {
      bool1 = true;
    }
    this.f = bool1;
    this.g = new ArrayList(paramRspMsgTabNodeList.node_list.size());
    paramRspMsgTabNodeList = paramRspMsgTabNodeList.node_list.get().iterator();
    while (paramRspMsgTabNodeList.hasNext())
    {
      qqstory_service.MsgTabNodeInfo localMsgTabNodeInfo = (qqstory_service.MsgTabNodeInfo)paramRspMsgTabNodeList.next();
      MsgTabNodeInfo localMsgTabNodeInfo1 = new MsgTabNodeInfo();
      localMsgTabNodeInfo1.a(localMsgTabNodeInfo);
      this.g.add(localMsgTabNodeInfo1);
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MsgTabNodeListResponse{shouldAnimate=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", seq='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append(", cookie='");
    localStringBuilder.append(this.e);
    localStringBuilder.append('\'');
    localStringBuilder.append(", isEnd=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", nodeList=");
    localStringBuilder.append(this.g);
    localStringBuilder.append("} ");
    localStringBuilder.append(super.toString());
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.network.MsgTabNodeListRequest.MsgTabNodeListResponse
 * JD-Core Version:    0.7.0.1
 */