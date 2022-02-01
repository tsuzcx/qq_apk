package com.tencent.biz.qqstory.network.response;

import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.model.ReportWatchVideoManager.InnerVideoItem;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspWatchVideoBatch;
import com.tencent.biz.qqstory.network.pb.qqstory_service.VideoItem;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class WatchVideoBatchResponse
  extends BaseResponse
{
  public List<ReportWatchVideoManager.InnerVideoItem> a = new ArrayList();
  
  public WatchVideoBatchResponse(qqstory_service.RspWatchVideoBatch paramRspWatchVideoBatch)
  {
    super(paramRspWatchVideoBatch.result);
    paramRspWatchVideoBatch = paramRspWatchVideoBatch.succ_video_list.get();
    if (paramRspWatchVideoBatch == null) {
      return;
    }
    paramRspWatchVideoBatch = paramRspWatchVideoBatch.iterator();
    while (paramRspWatchVideoBatch.hasNext())
    {
      qqstory_service.VideoItem localVideoItem = (qqstory_service.VideoItem)paramRspWatchVideoBatch.next();
      ReportWatchVideoManager.InnerVideoItem localInnerVideoItem = new ReportWatchVideoManager.InnerVideoItem();
      localInnerVideoItem.a = localVideoItem.vid.get().toStringUtf8();
      this.a.add(localInnerVideoItem);
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("WatchVideoBatchResponse{ errorCode=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(" succList=");
    localStringBuilder.append(this.a);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.response.WatchVideoBatchResponse
 * JD-Core Version:    0.7.0.1
 */