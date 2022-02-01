package com.tencent.biz.qqstory.network.request;

import android.text.TextUtils;
import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.channel.NetworkRequest;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqFriendStoryFeedVideoList;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspFriendStoryFeedVideoList;
import com.tencent.biz.qqstory.network.response.GetFeedVideoListResponse;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public class GetFeedVideoListRequest
  extends NetworkRequest<GetFeedVideoListResponse>
{
  public String e = "";
  public String f = "";
  public int g;
  
  public String a()
  {
    return StoryApi.a("StorySvc.homepage_feed_loadmore_720");
  }
  
  public BaseResponse b(byte[] paramArrayOfByte)
  {
    Object localObject = new qqstory_service.RspFriendStoryFeedVideoList();
    try
    {
      ((qqstory_service.RspFriendStoryFeedVideoList)localObject).mergeFrom(paramArrayOfByte);
      return new GetFeedVideoListResponse((qqstory_service.RspFriendStoryFeedVideoList)localObject);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("");
      ((StringBuilder)localObject).append(paramArrayOfByte);
      SLog.d("Q.qqstory:GetFeedVideoListRequest", ((StringBuilder)localObject).toString());
    }
    return null;
  }
  
  protected byte[] c()
  {
    qqstory_service.ReqFriendStoryFeedVideoList localReqFriendStoryFeedVideoList = new qqstory_service.ReqFriendStoryFeedVideoList();
    if (!TextUtils.isEmpty(this.e)) {
      localReqFriendStoryFeedVideoList.start_cookie.set(ByteStringMicro.copyFromUtf8(this.e));
    }
    if (!TextUtils.isEmpty(this.f)) {
      localReqFriendStoryFeedVideoList.feed_id.set(ByteStringMicro.copyFromUtf8(this.f));
    }
    localReqFriendStoryFeedVideoList.pull_type.set(this.g);
    return localReqFriendStoryFeedVideoList.toByteArray();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GetFeedVideoListRequest{, feedId='");
    localStringBuilder.append(this.f);
    localStringBuilder.append('\'');
    localStringBuilder.append(", startCookie='");
    localStringBuilder.append(this.e);
    localStringBuilder.append('\'');
    localStringBuilder.append(", pullType=");
    localStringBuilder.append(this.g);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.request.GetFeedVideoListRequest
 * JD-Core Version:    0.7.0.1
 */