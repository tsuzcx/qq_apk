package com.tencent.biz.qqstory.storyHome.detail.model;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.channel.CmdTaskManger.CommandCallback;
import com.tencent.biz.qqstory.model.item.FeedFeatureItem;
import com.tencent.biz.qqstory.network.request.GetFeedFeatureRequest;
import com.tencent.biz.qqstory.network.response.GetFeedFeatureResponse;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tribe.async.async.JobContext;
import java.util.Iterator;
import java.util.List;

class DetailFeedAllInfoPullSegment$RequestViewCountSegment$1
  implements CmdTaskManger.CommandCallback<GetFeedFeatureRequest, GetFeedFeatureResponse>
{
  DetailFeedAllInfoPullSegment$RequestViewCountSegment$1(DetailFeedAllInfoPullSegment.RequestViewCountSegment paramRequestViewCountSegment, JobContext paramJobContext, String paramString) {}
  
  public void a(@NonNull GetFeedFeatureRequest paramGetFeedFeatureRequest, @Nullable GetFeedFeatureResponse paramGetFeedFeatureResponse, @NonNull ErrorMessage paramErrorMessage)
  {
    if (this.jdField_a_of_type_ComTribeAsyncAsyncJobContext.isJobCancelled())
    {
      SLog.d("Q.qqstory.detail:DetailFeedAllInfoPullSegment", "segment cancel on net respond");
      return;
    }
    if ((paramGetFeedFeatureResponse != null) && (!paramErrorMessage.isFail()))
    {
      int j = 0;
      int i = j;
      if (paramGetFeedFeatureResponse.a != null)
      {
        paramGetFeedFeatureRequest = paramGetFeedFeatureResponse.a.iterator();
        do
        {
          i = j;
          if (!paramGetFeedFeatureRequest.hasNext()) {
            break;
          }
          paramGetFeedFeatureResponse = (FeedFeatureItem)paramGetFeedFeatureRequest.next();
        } while (!paramGetFeedFeatureResponse.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_JavaLangString));
        i = paramGetFeedFeatureResponse.c;
      }
      DetailFeedAllInfoPullSegment.RequestViewCountSegment.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedAllInfoPullSegment$RequestViewCountSegment, Integer.valueOf(i));
      return;
    }
    SLog.d("Q.qqstory.detail:DetailFeedAllInfoPullSegment", "request fail for feature request");
    DetailFeedAllInfoPullSegment.RequestViewCountSegment.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedAllInfoPullSegment$RequestViewCountSegment, paramErrorMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.detail.model.DetailFeedAllInfoPullSegment.RequestViewCountSegment.1
 * JD-Core Version:    0.7.0.1
 */