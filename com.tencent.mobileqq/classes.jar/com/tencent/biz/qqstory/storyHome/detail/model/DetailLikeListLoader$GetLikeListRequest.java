package com.tencent.biz.qqstory.storyHome.detail.model;

import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.channel.NetworkRequest;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqFeedLikeList;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspFeedLikeList;
import com.tencent.biz.qqstory.network.response.GetFeedVideoListResponse;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public class DetailLikeListLoader$GetLikeListRequest
  extends NetworkRequest<GetFeedVideoListResponse>
{
  public String e;
  public boolean f;
  public int g = -1;
  
  public String a()
  {
    return StoryApi.a("StorySvc.feed_like_list_715");
  }
  
  public BaseResponse b(byte[] paramArrayOfByte)
  {
    Object localObject = new qqstory_service.RspFeedLikeList();
    try
    {
      ((qqstory_service.RspFeedLikeList)localObject).mergeFrom(paramArrayOfByte);
      return new DetailLikeListLoader.GetLikeListResponse((qqstory_service.RspFeedLikeList)localObject);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("");
      ((StringBuilder)localObject).append(paramArrayOfByte);
      SLog.d("Q.qqstory:GetLikeListRequest", ((StringBuilder)localObject).toString());
    }
    return null;
  }
  
  protected byte[] c()
  {
    qqstory_service.ReqFeedLikeList localReqFeedLikeList = new qqstory_service.ReqFeedLikeList();
    localReqFeedLikeList.feed_id.set(ByteStringMicro.copyFromUtf8(this.e));
    int i;
    if (this.f) {
      i = 2;
    } else {
      i = 1;
    }
    localReqFeedLikeList.source.set(i);
    if (this.g != -1) {
      localReqFeedLikeList.type.set(this.g);
    }
    return localReqFeedLikeList.toByteArray();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GetLikeListRequest{, feedId='");
    localStringBuilder.append(this.e);
    localStringBuilder.append('\'');
    localStringBuilder.append(", isOpen=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", type=");
    localStringBuilder.append(this.g);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.detail.model.DetailLikeListLoader.GetLikeListRequest
 * JD-Core Version:    0.7.0.1
 */