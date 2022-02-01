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
  public long e;
  public int f;
  public int g;
  public int h;
  public int i;
  
  public String a()
  {
    return StoryApi.a("StoryGroupSvc.get_video_list");
  }
  
  public BaseResponse b(byte[] paramArrayOfByte)
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
  
  protected byte[] c()
  {
    qqstory_group.ReqGetGroupVideoList localReqGetGroupVideoList = new qqstory_group.ReqGetGroupVideoList();
    localReqGetGroupVideoList.group_id.set(this.e);
    localReqGetGroupVideoList.start.set(this.f);
    localReqGetGroupVideoList.size.set(this.g);
    localReqGetGroupVideoList.seq.set(this.i);
    if (this.h != -1) {
      localReqGetGroupVideoList.time_zone.set(this.h);
    }
    return localReqGetGroupVideoList.toByteArray();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GetTroopStoryListRequest{groupId='");
    localStringBuilder.append(this.e);
    localStringBuilder.append("startCookie='");
    localStringBuilder.append(this.f);
    localStringBuilder.append(" pageSize='");
    localStringBuilder.append(this.g);
    localStringBuilder.append(" seq='");
    localStringBuilder.append(this.i);
    localStringBuilder.append(" timeZone=");
    localStringBuilder.append(this.h);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.request.GetTroopStoryListRequest
 * JD-Core Version:    0.7.0.1
 */