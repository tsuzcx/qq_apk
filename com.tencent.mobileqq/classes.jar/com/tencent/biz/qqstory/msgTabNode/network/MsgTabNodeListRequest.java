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
  static final String e = StoryApi.a("StoryTabSvc.startpage_feeds_list_725");
  static boolean j = false;
  public String f;
  public int g;
  public String h;
  public boolean i = false;
  
  public String a()
  {
    return e;
  }
  
  public BaseResponse b(byte[] paramArrayOfByte)
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
  
  protected byte[] c()
  {
    if (j)
    {
      this.f = null;
      this.h = null;
    }
    qqstory_service.ReqMsgTabNodeList localReqMsgTabNodeList = new qqstory_service.ReqMsgTabNodeList();
    if (this.f != null) {
      localReqMsgTabNodeList.current_seq.set(ByteStringMicro.copyFromUtf8(this.f));
    }
    localReqMsgTabNodeList.source.set(this.g);
    if (this.h != null) {
      localReqMsgTabNodeList.start_cookie.set(ByteStringMicro.copyFromUtf8(this.h));
    }
    localReqMsgTabNodeList.version.set(4);
    Long localLong = LocationUtils.a();
    if (localLong != null) {
      localReqMsgTabNodeList.adcode.set(localLong.longValue());
    }
    localReqMsgTabNodeList.device.set(ByteStringMicro.copyFromUtf8(Build.DEVICE));
    localReqMsgTabNodeList.force_refresh.set(this.i);
    localReqMsgTabNodeList.client_version.set(ByteStringMicro.copyFromUtf8("8.8.17"));
    return localReqMsgTabNodeList.toByteArray();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MsgTabNodeListRequest{cookie='");
    localStringBuilder.append(this.h);
    localStringBuilder.append('\'');
    localStringBuilder.append(", seq='");
    localStringBuilder.append(this.f);
    localStringBuilder.append('\'');
    localStringBuilder.append(", source=");
    localStringBuilder.append(this.g);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.network.MsgTabNodeListRequest
 * JD-Core Version:    0.7.0.1
 */