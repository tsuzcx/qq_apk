package com.tencent.biz.qqstory.playvideo.dataprovider;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.channel.CmdTaskManger;
import com.tencent.biz.qqstory.channel.CmdTaskManger.CommandCallback;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.network.request.GetStoryFeedIdListRequest;
import com.tencent.biz.qqstory.network.request.GetStoryFeedIdListRequest.GetStoryFeedIdListResponse;
import com.tencent.biz.qqstory.storyHome.model.FeedListPageLoaderBase.FeedIdListCache;
import com.tencent.biz.qqstory.storyHome.model.FeedManager;
import com.tencent.biz.qqstory.storyHome.model.HomeFeedListPageLoader.FeedIdPullSegment;
import com.tencent.biz.qqstory.support.logging.SLog;
import java.util.concurrent.atomic.AtomicBoolean;

class HomeFeedPlayPageLoader$1
  implements CmdTaskManger.CommandCallback<GetStoryFeedIdListRequest, GetStoryFeedIdListRequest.GetStoryFeedIdListResponse>
{
  HomeFeedPlayPageLoader$1(HomeFeedPlayPageLoader paramHomeFeedPlayPageLoader, IGroupPageLoader.CallBack paramCallBack) {}
  
  public void a(@NonNull GetStoryFeedIdListRequest paramGetStoryFeedIdListRequest, @Nullable GetStoryFeedIdListRequest.GetStoryFeedIdListResponse paramGetStoryFeedIdListResponse, @NonNull ErrorMessage paramErrorMessage)
  {
    if ((paramErrorMessage.isFail()) || (paramGetStoryFeedIdListResponse == null))
    {
      SLog.a("Q.qqstory.player.data.HomeFeedPlayPageLoader", "pull feedId list fail %s", paramErrorMessage.toString());
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIGroupPageLoader$CallBack.a(paramErrorMessage, null, false);
      return;
    }
    HomeFeedPlayPageLoader.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderHomeFeedPlayPageLoader);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderHomeFeedPlayPageLoader.b.a(paramGetStoryFeedIdListResponse.jdField_a_of_type_JavaUtilList, paramGetStoryFeedIdListResponse.jdField_a_of_type_JavaLangString, paramGetStoryFeedIdListResponse.jdField_a_of_type_Boolean);
    ((FeedManager)SuperManager.a(11)).a(paramGetStoryFeedIdListResponse.jdField_a_of_type_JavaUtilList);
    AtomicBoolean localAtomicBoolean = new AtomicBoolean(false);
    boolean bool = HomeFeedListPageLoader.FeedIdPullSegment.a(paramGetStoryFeedIdListResponse, localAtomicBoolean);
    SLog.d("Q.qqstory.player.data.HomeFeedPlayPageLoader", "today is end:%b, loop count:%d, last date has fail:%b", new Object[] { Boolean.valueOf(paramGetStoryFeedIdListResponse.b), Integer.valueOf(HomeFeedPlayPageLoader.b(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderHomeFeedPlayPageLoader)), Boolean.valueOf(bool) });
    if ((!paramGetStoryFeedIdListResponse.jdField_a_of_type_Boolean) && (HomeFeedPlayPageLoader.b(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderHomeFeedPlayPageLoader) < 10) && ((!paramGetStoryFeedIdListResponse.b) || (bool)))
    {
      SLog.d("Q.qqstory.player.data.HomeFeedPlayPageLoader", "feedId list not end, pull more");
      paramGetStoryFeedIdListRequest.b = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderHomeFeedPlayPageLoader.b.a();
      CmdTaskManger.a().a(paramGetStoryFeedIdListRequest, this);
      return;
    }
    if (localAtomicBoolean.getAndSet(false)) {
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderHomeFeedPlayPageLoader.b.c();
    }
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIGroupPageLoader$CallBack.a(paramErrorMessage, FeedIdBasePlayPageLoader.b(paramGetStoryFeedIdListResponse.jdField_a_of_type_JavaUtilList), paramGetStoryFeedIdListResponse.jdField_a_of_type_Boolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.dataprovider.HomeFeedPlayPageLoader.1
 * JD-Core Version:    0.7.0.1
 */