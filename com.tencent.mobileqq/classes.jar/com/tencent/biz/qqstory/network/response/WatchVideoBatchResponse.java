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
  public List<ReportWatchVideoManager.InnerVideoItem> a;
  
  public WatchVideoBatchResponse(qqstory_service.RspWatchVideoBatch paramRspWatchVideoBatch)
  {
    super(paramRspWatchVideoBatch.result);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
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
      this.jdField_a_of_type_JavaUtilList.add(localInnerVideoItem);
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("WatchVideoBatchResponse{ errorCode=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(" succList=");
    localStringBuilder.append(this.jdField_a_of_type_JavaUtilList);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.response.WatchVideoBatchResponse
 * JD-Core Version:    0.7.0.1
 */