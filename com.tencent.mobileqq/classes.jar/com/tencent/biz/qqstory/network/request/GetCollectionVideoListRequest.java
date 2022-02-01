package com.tencent.biz.qqstory.network.request;

import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.channel.NetworkRequest;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqGetCollectionVideoList;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetCollectionVideoList;
import com.tencent.biz.qqstory.network.response.GetCollectionVideoListResponse;
import com.tencent.biz.qqstory.utils.AssertUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;

public class GetCollectionVideoListRequest
  extends NetworkRequest
{
  public static final String e = StoryApi.a("StorySvc.new_get_date_share_list");
  public static final String f = StoryApi.a("StorySvc.get_share_video_info_list");
  public String g;
  public String h = "";
  public int i;
  public int j = -1;
  public int k;
  public String l;
  public int m;
  public int n;
  
  public String a()
  {
    if (this.l == null) {
      return e;
    }
    return f;
  }
  
  public BaseResponse b(byte[] paramArrayOfByte)
  {
    qqstory_service.RspGetCollectionVideoList localRspGetCollectionVideoList = new qqstory_service.RspGetCollectionVideoList();
    try
    {
      localRspGetCollectionVideoList.mergeFrom(paramArrayOfByte);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return new GetCollectionVideoListResponse(this.g, localRspGetCollectionVideoList);
  }
  
  protected byte[] c()
  {
    qqstory_service.ReqGetCollectionVideoList localReqGetCollectionVideoList = new qqstory_service.ReqGetCollectionVideoList();
    localReqGetCollectionVideoList.start_cookie.set(ByteStringMicro.copyFromUtf8(this.h));
    localReqGetCollectionVideoList.count.set(this.i);
    if (this.l == null)
    {
      localReqGetCollectionVideoList.collection_id.set(this.j);
      if (this.k != -1) {
        localReqGetCollectionVideoList.time_zone.set(this.k);
      }
    }
    else
    {
      localReqGetCollectionVideoList.feed_id.set(ByteStringMicro.copyFromUtf8(this.l));
      localReqGetCollectionVideoList.identify.set(this.m);
    }
    AssertUtils.checkNotNull(this.g);
    localReqGetCollectionVideoList.union_id.set(ByteStringMicro.copyFromUtf8(this.g));
    localReqGetCollectionVideoList.video_dir.set(this.n);
    return localReqGetCollectionVideoList.toByteArray();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(super.toString());
    localStringBuilder.append(" GetCollectionVideoListRequest{targetUid=");
    localStringBuilder.append(this.g);
    localStringBuilder.append(", startCookie='");
    localStringBuilder.append(this.h);
    localStringBuilder.append(", count=");
    localStringBuilder.append(this.i);
    localStringBuilder.append(", collectionId=");
    localStringBuilder.append(this.j);
    localStringBuilder.append(", timeZoneOffset=");
    localStringBuilder.append(this.k);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.request.GetCollectionVideoListRequest
 * JD-Core Version:    0.7.0.1
 */