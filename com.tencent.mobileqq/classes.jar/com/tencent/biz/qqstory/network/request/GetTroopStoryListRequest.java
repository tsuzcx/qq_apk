package com.tencent.biz.qqstory.network.request;

import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.channel.NetworkRequest;
import com.tencent.biz.qqstory.network.pb.qqstory_group.ReqGetGroupVideoList;
import com.tencent.biz.qqstory.network.pb.qqstory_group.RspGetGroupVideoList;
import com.tencent.biz.qqstory.network.response.GetTroopStoryListResponse;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public class GetTroopStoryListRequest
  extends NetworkRequest
{
  public long b;
  public int c;
  public int d;
  public int e;
  public int f;
  
  public BaseResponse a(byte[] paramArrayOfByte)
  {
    qqstory_group.RspGetGroupVideoList localRspGetGroupVideoList = new qqstory_group.RspGetGroupVideoList();
    try
    {
      localRspGetGroupVideoList.mergeFrom(paramArrayOfByte);
      return new GetTroopStoryListResponse(localRspGetGroupVideoList);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      SLog.b("Q.qqstory.troopmemories:GetTroopStoryListRequest", a(), paramArrayOfByte);
    }
    return null;
  }
  
  public String a()
  {
    return StoryApi.a("StoryGroupSvc.get_video_list");
  }
  
  public byte[] a()
  {
    qqstory_group.ReqGetGroupVideoList localReqGetGroupVideoList = new qqstory_group.ReqGetGroupVideoList();
    localReqGetGroupVideoList.group_id.set(this.b);
    localReqGetGroupVideoList.start.set(this.c);
    localReqGetGroupVideoList.size.set(this.d);
    localReqGetGroupVideoList.seq.set(this.f);
    if (this.e != -1) {
      localReqGetGroupVideoList.time_zone.set(this.e);
    }
    return localReqGetGroupVideoList.toByteArray();
  }
  
  public String toString()
  {
    return "GetTroopStoryListRequest{groupId='" + this.b + "startCookie='" + this.c + " pageSize='" + this.d + " seq='" + this.f + " timeZone=" + this.e + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.request.GetTroopStoryListRequest
 * JD-Core Version:    0.7.0.1
 */