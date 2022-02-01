package com.tencent.biz.qqstory.network.response;

import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.model.item.FeedFeatureItem;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetBatchFeedFeature;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.FeedFeature;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GetFeedFeatureResponse
  extends BaseResponse
{
  public List<FeedFeatureItem> a = new ArrayList();
  
  public GetFeedFeatureResponse(qqstory_service.RspGetBatchFeedFeature paramRspGetBatchFeedFeature)
  {
    if ((paramRspGetBatchFeedFeature.feed_feature_list.has()) && (!paramRspGetBatchFeedFeature.feed_feature_list.isEmpty()))
    {
      paramRspGetBatchFeedFeature = paramRspGetBatchFeedFeature.feed_feature_list.get().iterator();
      while (paramRspGetBatchFeedFeature.hasNext())
      {
        qqstory_struct.FeedFeature localFeedFeature = (qqstory_struct.FeedFeature)paramRspGetBatchFeedFeature.next();
        FeedFeatureItem localFeedFeatureItem = new FeedFeatureItem();
        localFeedFeatureItem.a(localFeedFeature);
        this.a.add(localFeedFeatureItem);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.response.GetFeedFeatureResponse
 * JD-Core Version:    0.7.0.1
 */