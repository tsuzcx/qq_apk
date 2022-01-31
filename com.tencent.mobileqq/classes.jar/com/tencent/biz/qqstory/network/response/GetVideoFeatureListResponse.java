package com.tencent.biz.qqstory.network.response;

import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetBatchVideoFeatureList;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.StoryVideoFeature;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GetVideoFeatureListResponse
  extends BaseResponse
{
  public List a = new ArrayList();
  
  public GetVideoFeatureListResponse(qqstory_service.RspGetBatchVideoFeatureList paramRspGetBatchVideoFeatureList)
  {
    super(paramRspGetBatchVideoFeatureList.result);
    paramRspGetBatchVideoFeatureList = paramRspGetBatchVideoFeatureList.video_list.get();
    if (paramRspGetBatchVideoFeatureList != null)
    {
      paramRspGetBatchVideoFeatureList = paramRspGetBatchVideoFeatureList.iterator();
      while (paramRspGetBatchVideoFeatureList.hasNext())
      {
        qqstory_struct.StoryVideoFeature localStoryVideoFeature = (qqstory_struct.StoryVideoFeature)paramRspGetBatchVideoFeatureList.next();
        StoryVideoItem localStoryVideoItem = new StoryVideoItem();
        localStoryVideoItem.convertFrom("Q.qqstory.player:GetVideoFeatureListResponse", localStoryVideoFeature);
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
 * Qualified Name:     com.tencent.biz.qqstory.network.response.GetVideoFeatureListResponse
 * JD-Core Version:    0.7.0.1
 */