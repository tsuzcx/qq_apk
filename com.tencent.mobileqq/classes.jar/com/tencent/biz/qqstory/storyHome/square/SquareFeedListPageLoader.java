package com.tencent.biz.qqstory.storyHome.square;

import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.channel.CmdTaskManger;
import com.tencent.biz.qqstory.model.DiscoverManager;
import com.tencent.biz.qqstory.model.StoryManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.network.request.square.GetSquareBannerRequest;
import com.tencent.biz.qqstory.network.request.square.GetSquareBannerRequest.GetSquareBannerResponse;
import com.tencent.biz.qqstory.shareGroup.model.ShareGroupManager;
import com.tencent.biz.qqstory.storyHome.model.FeedListPageLoaderBase;
import com.tencent.biz.qqstory.storyHome.model.FeedListPageLoaderBase.FeedIdListCache;
import com.tencent.biz.qqstory.storyHome.model.FeedListPageLoaderBase.OnFeedItemPageLoadListener;
import com.tencent.biz.qqstory.storyHome.square.model.SquareFeed;
import com.tencent.biz.qqstory.storyHome.square.model.SquareFeed.FeedIdVid;
import com.tencent.biz.qqstory.storyHome.square.model.SquareFeedAllInfoPullSegment;
import com.tencent.biz.qqstory.storyHome.square.model.SquareFeedData;
import com.tencent.map.geolocation.TencentLocation;
import com.tribe.async.async.JobSegment;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import obx;
import oby;

public class SquareFeedListPageLoader
  extends FeedListPageLoaderBase
  implements FeedListPageLoaderBase.OnFeedItemPageLoadListener
{
  private GetSquareBannerRequest.GetSquareBannerResponse jdField_a_of_type_ComTencentBizQqstoryNetworkRequestSquareGetSquareBannerRequest$GetSquareBannerResponse;
  private SquareFeedData jdField_a_of_type_ComTencentBizQqstoryStoryHomeSquareModelSquareFeedData;
  private FeedListPageLoaderBase.OnFeedItemPageLoadListener b;
  
  private void d()
  {
    GetSquareBannerRequest localGetSquareBannerRequest = new GetSquareBannerRequest();
    CmdTaskManger.a().a(localGetSquareBannerRequest, new obx(this));
  }
  
  private void e()
  {
    if ((this.jdField_a_of_type_ComTencentBizQqstoryNetworkRequestSquareGetSquareBannerRequest$GetSquareBannerResponse != null) && (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeSquareModelSquareFeedData != null))
    {
      if ((this.jdField_a_of_type_ComTencentBizQqstoryNetworkRequestSquareGetSquareBannerRequest$GetSquareBannerResponse.jdField_a_of_type_Int != 0) || (!this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeSquareModelSquareFeedData.a.isSuccess())) {
        break label65;
      }
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeSquareModelSquareFeedData.jdField_c_of_type_JavaUtilList = this.jdField_a_of_type_ComTencentBizQqstoryNetworkRequestSquareGetSquareBannerRequest$GetSquareBannerResponse.jdField_a_of_type_JavaUtilList;
    }
    for (;;)
    {
      this.b.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeSquareModelSquareFeedData);
      return;
      label65:
      if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeSquareModelSquareFeedData.a.isSuccess()) {
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeSquareModelSquareFeedData.a = new ErrorMessage(this.jdField_a_of_type_ComTencentBizQqstoryNetworkRequestSquareGetSquareBannerRequest$GetSquareBannerResponse.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentBizQqstoryNetworkRequestSquareGetSquareBannerRequest$GetSquareBannerResponse.b);
      }
    }
  }
  
  protected SquareFeedData a()
  {
    SquareFeedData localSquareFeedData = new SquareFeedData(new ErrorMessage());
    localSquareFeedData.jdField_b_of_type_Boolean = true;
    Object localObject1 = (DiscoverManager)SuperManager.a(22);
    localSquareFeedData.jdField_c_of_type_JavaUtilList = ((DiscoverManager)localObject1).b();
    Object localObject2 = ((DiscoverManager)localObject1).a();
    localObject1 = (ShareGroupManager)SuperManager.a(7);
    StoryManager localStoryManager = (StoryManager)SuperManager.a(5);
    localObject2 = ((List)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      Object localObject3 = (String)((Iterator)localObject2).next();
      SquareFeed localSquareFeed = new SquareFeed();
      localSquareFeed.jdField_a_of_type_JavaLangString = ((String)localObject3);
      localSquareFeed.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem = ((ShareGroupManager)localObject1).a((String)localObject3);
      localSquareFeed.jdField_b_of_type_JavaUtilList = localStoryManager.a((String)localObject3);
      localSquareFeed.jdField_a_of_type_JavaUtilList = new ArrayList(localSquareFeed.jdField_a_of_type_JavaUtilList.size());
      localObject3 = localSquareFeed.jdField_b_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        StoryVideoItem localStoryVideoItem = localStoryManager.a(((SquareFeed.FeedIdVid)((Iterator)localObject3).next()).b);
        if (localStoryVideoItem != null) {
          localSquareFeed.jdField_a_of_type_JavaUtilList.add(localStoryVideoItem);
        }
      }
      if (localSquareFeed.jdField_a_of_type_JavaUtilList.size() > 0) {
        localSquareFeedData.jdField_b_of_type_JavaUtilList.add(localSquareFeed);
      }
    }
    return localSquareFeedData;
  }
  
  protected SquareFeedData a(ErrorMessage paramErrorMessage)
  {
    return new SquareFeedData(paramErrorMessage);
  }
  
  protected JobSegment a()
  {
    return new SquareFeedAllInfoPullSegment();
  }
  
  protected JobSegment a(FeedListPageLoaderBase.FeedIdListCache paramFeedIdListCache)
  {
    return new oby(paramFeedIdListCache, this.jdField_a_of_type_ComTencentBizQqstoryModelLbsBasicLocation);
  }
  
  public void a(SquareFeedData paramSquareFeedData)
  {
    if (!paramSquareFeedData.jdField_c_of_type_Boolean)
    {
      this.b.a(paramSquareFeedData);
      return;
    }
    try
    {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeSquareModelSquareFeedData = paramSquareFeedData;
      e();
      return;
    }
    finally {}
  }
  
  public void a(@Nullable TencentLocation paramTencentLocation, int paramInt)
  {
    super.a(paramTencentLocation, paramInt);
    d();
  }
  
  protected void a(List paramList, boolean paramBoolean)
  {
    ((DiscoverManager)SuperManager.a(22)).a(paramList, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.square.SquareFeedListPageLoader
 * JD-Core Version:    0.7.0.1
 */