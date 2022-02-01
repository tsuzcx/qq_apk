package com.tencent.biz.qqstory.network.response;

import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspBatchGetVideoInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.GroupStoryInfo;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GetShareGroupVideoInfoResponse
  extends BaseResponse
{
  public List<StoryVideoItem> a = new ArrayList();
  
  public GetShareGroupVideoInfoResponse(qqstory_service.RspBatchGetVideoInfo paramRspBatchGetVideoInfo)
  {
    super(paramRspBatchGetVideoInfo.result);
    if (paramRspBatchGetVideoInfo.vid_info_list.has())
    {
      paramRspBatchGetVideoInfo = paramRspBatchGetVideoInfo.vid_info_list.get().iterator();
      while (paramRspBatchGetVideoInfo.hasNext())
      {
        qqstory_struct.GroupStoryInfo localGroupStoryInfo = (qqstory_struct.GroupStoryInfo)paramRspBatchGetVideoInfo.next();
        StoryVideoItem localStoryVideoItem = new StoryVideoItem();
        localStoryVideoItem.convertFrom("Q.qqstory.shareGroup:GetShareGroupVideoInfoResponse", localGroupStoryInfo);
        this.a.add(localStoryVideoItem);
      }
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GetShareGroupVideoInfoResponse{errorCode=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", errorMsg='");
    localStringBuilder.append(this.d);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mVideoItemList=");
    localStringBuilder.append(this.a);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.response.GetShareGroupVideoInfoResponse
 * JD-Core Version:    0.7.0.1
 */