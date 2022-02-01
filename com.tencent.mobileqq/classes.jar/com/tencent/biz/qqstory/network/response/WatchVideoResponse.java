package com.tencent.biz.qqstory.network.response;

import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspWatchVideo;
import com.tencent.mobileqq.pb.PBUInt32Field;

public class WatchVideoResponse
  extends BaseResponse
{
  public int b = 0;
  
  public WatchVideoResponse(qqstory_service.RspWatchVideo paramRspWatchVideo)
  {
    super(paramRspWatchVideo.result);
    this.b = paramRspWatchVideo.unread_count.get();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("WatchVideoResponse{unReadCount=");
    localStringBuilder.append(this.b);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.response.WatchVideoResponse
 * JD-Core Version:    0.7.0.1
 */