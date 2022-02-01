package com.tencent.biz.qqstory.storyHome.detail.model;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.channel.CmdTaskManger;
import com.tencent.biz.qqstory.network.request.BatchGetFriendStoryFeedInfoRequest;
import com.tencent.biz.qqstory.storyHome.model.FeedIdListSeqInfo;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import java.util.ArrayList;
import java.util.List;

public class DetailFeedAllInfoPuller$FeedItemPullSegment
  extends JobSegment<String, DetailFeedItem>
{
  private BatchGetFriendStoryFeedInfoRequest jdField_a_of_type_ComTencentBizQqstoryNetworkRequestBatchGetFriendStoryFeedInfoRequest = new BatchGetFriendStoryFeedInfoRequest();
  
  public DetailFeedAllInfoPuller$FeedItemPullSegment(DetailFeedAllInfoPuller paramDetailFeedAllInfoPuller, @NonNull String paramString)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryNetworkRequestBatchGetFriendStoryFeedInfoRequest.a = new ArrayList();
    paramDetailFeedAllInfoPuller = new FeedIdListSeqInfo(paramString, 0, "", "");
    this.jdField_a_of_type_ComTencentBizQqstoryNetworkRequestBatchGetFriendStoryFeedInfoRequest.a.add(paramDetailFeedAllInfoPuller);
  }
  
  protected void a(JobContext paramJobContext, String paramString)
  {
    CmdTaskManger.a().a(this.jdField_a_of_type_ComTencentBizQqstoryNetworkRequestBatchGetFriendStoryFeedInfoRequest, new DetailFeedAllInfoPuller.FeedItemPullSegment.1(this, paramJobContext));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.detail.model.DetailFeedAllInfoPuller.FeedItemPullSegment
 * JD-Core Version:    0.7.0.1
 */