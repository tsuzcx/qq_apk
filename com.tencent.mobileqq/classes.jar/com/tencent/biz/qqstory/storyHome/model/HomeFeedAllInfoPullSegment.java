package com.tencent.biz.qqstory.storyHome.model;

import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.channel.CmdTaskManger;
import com.tencent.biz.qqstory.channel.NetworkRequest;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.item.FeedFeatureItem;
import com.tencent.biz.qqstory.network.request.BatchGetFeedCommentRequest;
import com.tencent.biz.qqstory.network.request.BatchGetFeedCommentRequest.BatchGetFeedCommentResp;
import com.tencent.biz.qqstory.network.request.BatchGetFeedLikeRequest;
import com.tencent.biz.qqstory.network.request.BatchGetFeedLikeRequest.BatchGetFeedLikeResp;
import com.tencent.biz.qqstory.network.request.BatchGetFriendStoryFeedInfoRequest;
import com.tencent.biz.qqstory.network.request.BatchGetFriendStoryFeedInfoRequest.GetFriendStoryFeedInfoResp;
import com.tencent.biz.qqstory.network.request.GetFeedFeatureRequest;
import com.tencent.biz.qqstory.network.response.GetFeedFeatureResponse;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import nxb;
import nxc;
import nxd;
import nxe;

public class HomeFeedAllInfoPullSegment
  extends JobSegment
{
  private BatchGetFeedCommentRequest.BatchGetFeedCommentResp jdField_a_of_type_ComTencentBizQqstoryNetworkRequestBatchGetFeedCommentRequest$BatchGetFeedCommentResp;
  private BatchGetFeedLikeRequest.BatchGetFeedLikeResp jdField_a_of_type_ComTencentBizQqstoryNetworkRequestBatchGetFeedLikeRequest$BatchGetFeedLikeResp;
  private BatchGetFriendStoryFeedInfoRequest.GetFriendStoryFeedInfoResp jdField_a_of_type_ComTencentBizQqstoryNetworkRequestBatchGetFriendStoryFeedInfoRequest$GetFriendStoryFeedInfoResp;
  private GetFeedFeatureResponse jdField_a_of_type_ComTencentBizQqstoryNetworkResponseGetFeedFeatureResponse;
  private Vector jdField_a_of_type_JavaUtilVector = new Vector(5);
  
  private FeedFeatureItem a(int paramInt, CommentLikeHomeFeed paramCommentLikeHomeFeed)
  {
    List localList = this.jdField_a_of_type_ComTencentBizQqstoryNetworkResponseGetFeedFeatureResponse.jdField_a_of_type_JavaUtilList;
    if (paramInt < localList.size()) {}
    for (FeedFeatureItem localFeedFeatureItem = (FeedFeatureItem)localList.get(paramInt);; localFeedFeatureItem = null)
    {
      if ((localFeedFeatureItem != null) && (localFeedFeatureItem.a.equals(paramCommentLikeHomeFeed.a.feedId))) {
        return localFeedFeatureItem;
      }
      localFeedFeatureItem = new FeedFeatureItem();
      localFeedFeatureItem.a = paramCommentLikeHomeFeed.a.feedId;
      paramInt = localList.indexOf(localFeedFeatureItem);
      if (paramInt >= 0) {
        return (FeedFeatureItem)localList.get(paramInt);
      }
      SLog.d("Q.qqstory.home.data:HomeFeedAllInfoPullSegment", "can't not find feed like for id:%s", new Object[] { paramCommentLikeHomeFeed.a.feedId });
      return null;
    }
  }
  
  private void a(FeedListPageLoaderBase.GetFeedIdListResult paramGetFeedIdListResult)
  {
    boolean bool3 = true;
    int i = 0;
    boolean bool1;
    boolean bool2;
    if (this.jdField_a_of_type_ComTencentBizQqstoryNetworkRequestBatchGetFriendStoryFeedInfoRequest$GetFriendStoryFeedInfoResp != null)
    {
      bool1 = true;
      if (this.jdField_a_of_type_ComTencentBizQqstoryNetworkRequestBatchGetFeedCommentRequest$BatchGetFeedCommentResp == null) {
        break label68;
      }
      bool2 = true;
      label24:
      if (this.jdField_a_of_type_ComTencentBizQqstoryNetworkRequestBatchGetFeedLikeRequest$BatchGetFeedLikeResp == null) {
        break label74;
      }
    }
    for (;;)
    {
      SLog.a("Q.qqstory.home.data:HomeFeedAllInfoPullSegment", "feed info resp basic info:%b, comment %b, like %b", Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3));
      if (this.jdField_a_of_type_JavaUtilVector.isEmpty()) {
        break label80;
      }
      return;
      bool1 = false;
      break;
      label68:
      bool2 = false;
      break label24;
      label74:
      bool3 = false;
    }
    label80:
    if ((this.jdField_a_of_type_ComTencentBizQqstoryNetworkRequestBatchGetFriendStoryFeedInfoRequest$GetFriendStoryFeedInfoResp == null) || (this.jdField_a_of_type_ComTencentBizQqstoryNetworkRequestBatchGetFriendStoryFeedInfoRequest$GetFriendStoryFeedInfoResp.jdField_a_of_type_Int != 0))
    {
      notifyError(new ErrorMessage(this.jdField_a_of_type_ComTencentBizQqstoryNetworkRequestBatchGetFriendStoryFeedInfoRequest$GetFriendStoryFeedInfoResp.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentBizQqstoryNetworkRequestBatchGetFriendStoryFeedInfoRequest$GetFriendStoryFeedInfoResp.b));
      return;
    }
    FeedManager localFeedManager = (FeedManager)SuperManager.a(11);
    HomeFeedData localHomeFeedData = new HomeFeedData(new ErrorMessage());
    localHomeFeedData.c = paramGetFeedIdListResult.jdField_a_of_type_Boolean;
    localHomeFeedData.jdField_a_of_type_Boolean = paramGetFeedIdListResult.b;
    localHomeFeedData.jdField_a_of_type_JavaUtilList = new ArrayList();
    Object localObject1 = this.jdField_a_of_type_ComTencentBizQqstoryNetworkRequestBatchGetFriendStoryFeedInfoRequest$GetFriendStoryFeedInfoResp.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (StoryHomeFeed)((Iterator)localObject1).next();
      localHomeFeedData.jdField_a_of_type_JavaUtilList.add(((StoryHomeFeed)localObject2).a.feedId);
    }
    localHomeFeedData.b = this.jdField_a_of_type_ComTencentBizQqstoryNetworkRequestBatchGetFriendStoryFeedInfoRequest$GetFriendStoryFeedInfoResp.jdField_a_of_type_JavaUtilList;
    localObject1 = this.jdField_a_of_type_ComTencentBizQqstoryNetworkRequestBatchGetFriendStoryFeedInfoRequest$GetFriendStoryFeedInfoResp.jdField_a_of_type_JavaUtilList.iterator();
    Object localObject3;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (StoryHomeFeed)((Iterator)localObject1).next();
      ((StoryHomeFeed)localObject2).a(i, this.jdField_a_of_type_ComTencentBizQqstoryNetworkRequestBatchGetFriendStoryFeedInfoRequest$GetFriendStoryFeedInfoResp, this.jdField_a_of_type_ComTencentBizQqstoryNetworkRequestBatchGetFeedCommentRequest$BatchGetFeedCommentResp, this.jdField_a_of_type_ComTencentBizQqstoryNetworkRequestBatchGetFeedLikeRequest$BatchGetFeedLikeResp);
      if ((localObject2 instanceof CommentLikeHomeFeed))
      {
        localObject2 = (CommentLikeHomeFeed)localObject2;
        if (this.jdField_a_of_type_ComTencentBizQqstoryNetworkResponseGetFeedFeatureResponse != null)
        {
          localObject3 = a(i, (CommentLikeHomeFeed)localObject2);
          if (localObject3 != null)
          {
            ((CommentLikeHomeFeed)localObject2).a().mViewTotalTime = ((FeedFeatureItem)localObject3).c;
            SLog.a("Q.qqstory.home.data:HomeFeedAllInfoPullSegment", "get feature feedId=%s, view total=%d", ((CommentLikeHomeFeed)localObject2).a.feedId, Long.valueOf(((CommentLikeHomeFeed)localObject2).a().mViewTotalTime));
          }
        }
      }
      i += 1;
    }
    localObject1 = this.jdField_a_of_type_ComTencentBizQqstoryNetworkRequestBatchGetFriendStoryFeedInfoRequest$GetFriendStoryFeedInfoResp.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((StoryHomeFeed)((Iterator)localObject1).next()).a();
    }
    localObject1 = new ArrayList(localHomeFeedData.b.size());
    Object localObject2 = localHomeFeedData.b.iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((ArrayList)localObject1).add(((StoryHomeFeed)((Iterator)localObject2).next()).a);
    }
    localObject1 = localFeedManager.a((List)localObject1);
    localObject2 = localHomeFeedData.b.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (StoryHomeFeed)((Iterator)localObject2).next();
      i = ((List)localObject1).indexOf(((StoryHomeFeed)localObject3).a);
      if (i >= 0)
      {
        ((StoryHomeFeed)localObject3).a = ((FeedItem)((List)localObject1).get(i));
        ((StoryHomeFeed)localObject3).a.onRefresh();
      }
    }
    if (paramGetFeedIdListResult.jdField_a_of_type_Boolean) {
      localFeedManager.a().a();
    }
    SLog.a("Q.qqstory.home.data:HomeFeedAllInfoPullSegment", "need sync comment size:%d", Integer.valueOf(this.jdField_a_of_type_ComTencentBizQqstoryNetworkRequestBatchGetFeedCommentRequest$BatchGetFeedCommentResp.b.size()));
    if ((this.jdField_a_of_type_ComTencentBizQqstoryNetworkRequestBatchGetFeedCommentRequest$BatchGetFeedCommentResp.jdField_a_of_type_Int == 0) && (this.jdField_a_of_type_ComTencentBizQqstoryNetworkRequestBatchGetFeedCommentRequest$BatchGetFeedCommentResp.b.size() > 0)) {
      localFeedManager.a().a(this.jdField_a_of_type_ComTencentBizQqstoryNetworkRequestBatchGetFeedCommentRequest$BatchGetFeedCommentResp.b);
    }
    notifyResult(localHomeFeedData);
  }
  
  private void b(JobContext paramJobContext, FeedListPageLoaderBase.GetFeedIdListResult paramGetFeedIdListResult)
  {
    List localList = paramGetFeedIdListResult.jdField_a_of_type_JavaUtilList;
    SLog.a("Q.qqstory.home.data:HomeFeedAllInfoPullSegment", "start pull feed info count:%d", Integer.valueOf(localList.size()));
    if (SLog.a()) {
      SLog.a("Q.qqstory.home.data:HomeFeedAllInfoPullSegment", "start pull feed info %s", localList);
    }
    ArrayList localArrayList = new ArrayList(localList.size());
    Object localObject = localList.iterator();
    while (((Iterator)localObject).hasNext()) {
      localArrayList.add(((FeedIdListSeqInfo)((Iterator)localObject).next()).a);
    }
    localObject = new BatchGetFriendStoryFeedInfoRequest();
    this.jdField_a_of_type_JavaUtilVector.add(localObject);
    BatchGetFeedCommentRequest localBatchGetFeedCommentRequest = new BatchGetFeedCommentRequest(localArrayList, true);
    this.jdField_a_of_type_JavaUtilVector.add(localBatchGetFeedCommentRequest);
    BatchGetFeedLikeRequest localBatchGetFeedLikeRequest = new BatchGetFeedLikeRequest(localArrayList, true);
    this.jdField_a_of_type_JavaUtilVector.add(localBatchGetFeedLikeRequest);
    GetFeedFeatureRequest localGetFeedFeatureRequest = new GetFeedFeatureRequest();
    this.jdField_a_of_type_JavaUtilVector.add(localGetFeedFeatureRequest);
    ((BatchGetFriendStoryFeedInfoRequest)localObject).jdField_a_of_type_JavaUtilList = localList;
    CmdTaskManger.a().a((NetworkRequest)localObject, new nxb(this, paramJobContext, paramGetFeedIdListResult));
    CmdTaskManger.a().a(localBatchGetFeedCommentRequest, new nxc(this, paramJobContext, paramGetFeedIdListResult));
    CmdTaskManger.a().a(localBatchGetFeedLikeRequest, new nxd(this, paramJobContext, paramGetFeedIdListResult));
    localGetFeedFeatureRequest.jdField_a_of_type_JavaUtilList = localArrayList;
    CmdTaskManger.a().a(localGetFeedFeatureRequest, new nxe(this, paramJobContext, paramGetFeedIdListResult));
  }
  
  protected void a(JobContext paramJobContext, FeedListPageLoaderBase.GetFeedIdListResult paramGetFeedIdListResult)
  {
    Iterator localIterator = paramGetFeedIdListResult.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      if (localIterator.next() == null) {
        localIterator.remove();
      }
    }
    if (paramGetFeedIdListResult.jdField_a_of_type_JavaUtilList.isEmpty())
    {
      if (paramGetFeedIdListResult.b)
      {
        paramJobContext = new HomeFeedData(new ErrorMessage());
        paramJobContext.c = paramGetFeedIdListResult.jdField_a_of_type_Boolean;
        paramJobContext.jdField_a_of_type_Boolean = paramGetFeedIdListResult.b;
        notifyResult(paramJobContext);
        return;
      }
      paramJobContext = new ErrorMessage(940001, "");
      paramJobContext.extraMsg = "data error no data";
      notifyError(paramJobContext);
      SLog.a("Q.qqstory.home.data:HomeFeedAllInfoPullSegment", "feed id arg %s", paramJobContext);
      return;
    }
    b(paramJobContext, paramGetFeedIdListResult);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.model.HomeFeedAllInfoPullSegment
 * JD-Core Version:    0.7.0.1
 */