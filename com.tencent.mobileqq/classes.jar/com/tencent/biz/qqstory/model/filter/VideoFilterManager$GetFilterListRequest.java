package com.tencent.biz.qqstory.model.filter;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.channel.NetworkRequest;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqGetFilterList;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public class VideoFilterManager$GetFilterListRequest
  extends NetworkRequest<VideoFilterManager.GetFilterListResponse>
{
  @NonNull
  public final String a;
  public final int c;
  
  public VideoFilterManager$GetFilterListRequest(@NonNull String paramString)
  {
    this(paramString, 20);
  }
  
  public VideoFilterManager$GetFilterListRequest(@NonNull String paramString, int paramInt)
  {
    this.a = paramString;
    this.c = paramInt;
  }
  
  public BaseResponse a(byte[] paramArrayOfByte)
  {
    return new VideoFilterManager.GetFilterListResponse(paramArrayOfByte);
  }
  
  public String a()
  {
    return StoryApi.a("StorySvc.video_filter_list");
  }
  
  public byte[] a()
  {
    qqstory_service.ReqGetFilterList localReqGetFilterList = new qqstory_service.ReqGetFilterList();
    localReqGetFilterList.count.set(this.c);
    localReqGetFilterList.start_cookie.set(ByteStringMicro.copyFromUtf8(this.a));
    return localReqGetFilterList.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.model.filter.VideoFilterManager.GetFilterListRequest
 * JD-Core Version:    0.7.0.1
 */