package com.tencent.biz.qqstory.storyHome.square.model;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.channel.CmdTaskManger.CommandCallback;
import com.tencent.biz.qqstory.model.StoryManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.network.request.square.BatchGetSquareFeedInfoRequest;
import com.tencent.biz.qqstory.network.request.square.BatchGetSquareFeedInfoRequest.GetSquareFeedInfoResp;
import com.tencent.biz.qqstory.shareGroup.model.ShareGroupManager;
import com.tencent.biz.qqstory.storyHome.model.FeedListPageLoaderBase.GetFeedIdListResult;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class SquareFeedAllInfoPullSegment$1
  implements CmdTaskManger.CommandCallback<BatchGetSquareFeedInfoRequest, BatchGetSquareFeedInfoRequest.GetSquareFeedInfoResp>
{
  SquareFeedAllInfoPullSegment$1(SquareFeedAllInfoPullSegment paramSquareFeedAllInfoPullSegment, FeedListPageLoaderBase.GetFeedIdListResult paramGetFeedIdListResult, ArrayList paramArrayList) {}
  
  public void a(@NonNull BatchGetSquareFeedInfoRequest paramBatchGetSquareFeedInfoRequest, @Nullable BatchGetSquareFeedInfoRequest.GetSquareFeedInfoResp paramGetSquareFeedInfoResp, @NonNull ErrorMessage paramErrorMessage)
  {
    if ((paramGetSquareFeedInfoResp != null) && (paramErrorMessage.isSuccess()))
    {
      paramBatchGetSquareFeedInfoRequest = new SquareFeedData(new ErrorMessage());
      paramBatchGetSquareFeedInfoRequest.c = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedListPageLoaderBase$GetFeedIdListResult.jdField_a_of_type_Boolean;
      paramBatchGetSquareFeedInfoRequest.jdField_a_of_type_Boolean = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedListPageLoaderBase$GetFeedIdListResult.b;
      paramBatchGetSquareFeedInfoRequest.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_JavaUtilArrayList;
      paramBatchGetSquareFeedInfoRequest.b = paramGetSquareFeedInfoResp.jdField_a_of_type_JavaUtilList;
      paramGetSquareFeedInfoResp = (ShareGroupManager)SuperManager.a(7);
      paramErrorMessage = (StoryManager)SuperManager.a(5);
      Iterator localIterator1 = paramBatchGetSquareFeedInfoRequest.b.iterator();
      while (localIterator1.hasNext())
      {
        SquareFeed localSquareFeed = (SquareFeed)localIterator1.next();
        localSquareFeed.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem = paramGetSquareFeedInfoResp.a(localSquareFeed.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem);
        ArrayList localArrayList = new ArrayList(localSquareFeed.jdField_a_of_type_JavaUtilList.size());
        Iterator localIterator2 = localSquareFeed.jdField_a_of_type_JavaUtilList.iterator();
        while (localIterator2.hasNext()) {
          localArrayList.add(paramErrorMessage.a((StoryVideoItem)localIterator2.next()));
        }
        localSquareFeed.jdField_a_of_type_JavaUtilList = localArrayList;
        paramErrorMessage.a(localSquareFeed.jdField_a_of_type_JavaLangString, localSquareFeed.b, true);
      }
      SquareFeedAllInfoPullSegment.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeSquareModelSquareFeedAllInfoPullSegment, paramBatchGetSquareFeedInfoRequest);
      return;
    }
    SquareFeedAllInfoPullSegment.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeSquareModelSquareFeedAllInfoPullSegment, paramErrorMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.square.model.SquareFeedAllInfoPullSegment.1
 * JD-Core Version:    0.7.0.1
 */