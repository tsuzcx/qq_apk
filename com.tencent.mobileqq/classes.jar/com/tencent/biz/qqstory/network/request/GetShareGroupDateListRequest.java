package com.tencent.biz.qqstory.network.request;

import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.channel.NetworkRequest;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqGroupDateVideoList;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGroupDateVideoList;
import com.tencent.biz.qqstory.network.response.GetShareGroupDateListResponse;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public class GetShareGroupDateListRequest
  extends NetworkRequest
{
  public String e;
  public String f = "";
  public int g;
  public int h;
  public int i;
  public long j;
  public int k;
  private final String l = StoryApi.a("StoryGroupSvc.datacard_get_feeds_new");
  
  public String a()
  {
    return this.l;
  }
  
  public BaseResponse b(byte[] paramArrayOfByte)
  {
    qqstory_service.RspGroupDateVideoList localRspGroupDateVideoList = new qqstory_service.RspGroupDateVideoList();
    try
    {
      localRspGroupDateVideoList.mergeFrom(paramArrayOfByte);
      return new GetShareGroupDateListResponse(this.e, localRspGroupDateVideoList);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      SLog.b("Q.qqstory.shareGroup:GetShareGroupDateListRequest", a(), paramArrayOfByte);
    }
    return null;
  }
  
  protected byte[] c()
  {
    qqstory_service.ReqGroupDateVideoList localReqGroupDateVideoList = new qqstory_service.ReqGroupDateVideoList();
    localReqGroupDateVideoList.from.set(this.i);
    localReqGroupDateVideoList.group_unionid.set(ByteStringMicro.copyFromUtf8(this.e));
    localReqGroupDateVideoList.start_cookie.set(ByteStringMicro.copyFromUtf8(this.f));
    localReqGroupDateVideoList.date_count.set(this.g);
    localReqGroupDateVideoList.video_count.set(this.h);
    localReqGroupDateVideoList.seqno.set(this.j);
    if (this.k != -1) {
      localReqGroupDateVideoList.time_zone.set(this.k);
    }
    return localReqGroupDateVideoList.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.request.GetShareGroupDateListRequest
 * JD-Core Version:    0.7.0.1
 */