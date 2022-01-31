package com.tencent.biz.qqstory.network.response;

import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetBatchVideoBasicInfoList;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.StoryVideoBasicInfo;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GetVideoBasicInfoListResponse
  extends BaseResponse
{
  public List a = new ArrayList();
  
  public GetVideoBasicInfoListResponse(qqstory_service.RspGetBatchVideoBasicInfoList paramRspGetBatchVideoBasicInfoList)
  {
    super(paramRspGetBatchVideoBasicInfoList.result);
    paramRspGetBatchVideoBasicInfoList = paramRspGetBatchVideoBasicInfoList.video_list.get();
    if (paramRspGetBatchVideoBasicInfoList != null)
    {
      paramRspGetBatchVideoBasicInfoList = paramRspGetBatchVideoBasicInfoList.iterator();
      while (paramRspGetBatchVideoBasicInfoList.hasNext())
      {
        qqstory_struct.StoryVideoBasicInfo localStoryVideoBasicInfo = (qqstory_struct.StoryVideoBasicInfo)paramRspGetBatchVideoBasicInfoList.next();
        StoryVideoItem localStoryVideoItem = new StoryVideoItem();
        localStoryVideoItem.convertFrom("Q.qqstory.net:GetVideoBasicInfoListResponse", localStoryVideoBasicInfo);
        this.a.add(localStoryVideoItem);
      }
    }
  }
  
  public String toString()
  {
    return "GetVideoBasicInfoListResponse{mVideoItemList=" + this.a + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.response.GetVideoBasicInfoListResponse
 * JD-Core Version:    0.7.0.1
 */