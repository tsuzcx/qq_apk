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
  static final String e = StoryApi.a("StorySvc.get_tab_node_vid_list");
  MsgTabNodeInfo f;
  String g = "";
  String h = "";
  
  public MsgTabNodeVidListRequest(MsgTabNodeInfo paramMsgTabNodeInfo, String paramString1, String paramString2)
  {
    this.f = paramMsgTabNodeInfo;
    this.g = paramString1;
    this.h = paramString2;
  }
  
  public static MsgTabNodeVidListRequest.MsgTabNodeVidListResponse a(MsgTabNodeInfo paramMsgTabNodeInfo, byte[] paramArrayOfByte)
  {
    qqstory_service.RspMsgTabNodeVideoList localRspMsgTabNodeVideoList = new qqstory_service.RspMsgTabNodeVideoList();
    if (paramArrayOfByte != null) {
      try
      {
        localRspMsgTabNodeVideoList.mergeFrom(paramArrayOfByte);
      }
      catch (InvalidProtocolBufferMicroException paramMsgTabNodeInfo)
      {
        paramArrayOfByte = new StringBuilder();
        paramArrayOfByte.append("");
        paramArrayOfByte.append(paramMsgTabNodeInfo);
        SLog.d("Q.qqstory:ReqMsgTabNodeVideoList", paramArrayOfByte.toString());
        return null;
      }
    }
    return new MsgTabNodeVidListRequest.MsgTabNodeVidListResponse(paramMsgTabNodeInfo, localRspMsgTabNodeVideoList, paramArrayOfByte);
  }
  
  public MsgTabNodeVidListRequest.MsgTabNodeVidListResponse a(byte[] paramArrayOfByte)
  {
    return a(this.f, paramArrayOfByte);
  }
  
  public String a()
  {
    return e;
  }
  
  protected byte[] c()
  {
    qqstory_service.ReqMsgTabNodeVideoList localReqMsgTabNodeVideoList = new qqstory_service.ReqMsgTabNodeVideoList();
    localReqMsgTabNodeVideoList.unionID.set(ByteStringMicro.copyFromUtf8(this.f.d));
    localReqMsgTabNodeVideoList.req_time_stamp.set(this.f.g);
    localReqMsgTabNodeVideoList.node_type.set(this.f.b);
    localReqMsgTabNodeVideoList.recommend_id.set(this.f.j);
    localReqMsgTabNodeVideoList.source.set(this.f.w);
    if (this.f.b == 12)
    {
      if ((TextUtils.isEmpty(this.g)) && (!TextUtils.isEmpty(this.h))) {
        localReqMsgTabNodeVideoList.start_vid.set(this.h);
      }
      if (!TextUtils.isEmpty(this.g)) {
        localReqMsgTabNodeVideoList.cookie.set(this.g);
      }
      localReqMsgTabNodeVideoList.page_size.set(20);
    }
    Long localLong = LocationUtils.a();
    if (localLong != null) {
      localReqMsgTabNodeVideoList.adcode.set(localLong.longValue());
    }
    localReqMsgTabNodeVideoList.device.set(ByteStringMicro.copyFromUtf8(Build.DEVICE));
    if (!TextUtils.isEmpty(this.f.A)) {
      localReqMsgTabNodeVideoList.passthrough.set(ByteStringMicro.copyFromUtf8(this.f.A));
    }
    return localReqMsgTabNodeVideoList.toByteArray();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MsgTabNodeVidListRequest{nodeInfo.unionId=");
    localStringBuilder.append(this.f.d);
    localStringBuilder.append(", mCookie='");
    localStringBuilder.append(this.g);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mStartVid='");
    localStringBuilder.append(this.h);
    localStringBuilder.append('\'');
    localStringBuilder.append("} ");
    localStringBuilder.append(super.toString());
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.network.MsgTabNodeVidListRequest
 * JD-Core Version:    0.7.0.1
 */