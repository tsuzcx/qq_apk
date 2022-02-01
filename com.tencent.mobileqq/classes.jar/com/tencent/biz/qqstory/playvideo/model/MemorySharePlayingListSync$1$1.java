package com.tencent.biz.qqstory.playvideo.model;

import com.tencent.biz.qqstory.base.StoryDispatcher;
import com.tencent.biz.qqstory.model.DefaultPlayerVideoListSynchronizer.PlayerVideoListEvent;
import com.tencent.biz.qqstory.network.BatchHandlerListPuller;
import com.tencent.biz.qqstory.network.BatchHandlerListPuller.IPullResultCallback;
import com.tencent.biz.qqstory.network.response.GetCollectionVideoListResponse;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tribe.async.dispatch.Dispatcher;
import java.util.List;

class MemorySharePlayingListSync$1$1
  implements BatchHandlerListPuller.IPullResultCallback
{
  MemorySharePlayingListSync$1$1(MemorySharePlayingListSync.1 param1, BatchHandlerListPuller paramBatchHandlerListPuller, GetCollectionVideoListResponse paramGetCollectionVideoListResponse) {}
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryNetworkBatchHandlerListPuller.a();
    DefaultPlayerVideoListSynchronizer.PlayerVideoListEvent localPlayerVideoListEvent = new DefaultPlayerVideoListSynchronizer.PlayerVideoListEvent();
    localPlayerVideoListEvent.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoModelMemorySharePlayingListSync$1.a.jdField_b_of_type_JavaLangString;
    localPlayerVideoListEvent.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoModelMemorySharePlayingListSync$1.a.jdField_d_of_type_JavaLangString;
    localPlayerVideoListEvent.jdField_a_of_type_Boolean = false;
    localPlayerVideoListEvent.jdField_b_of_type_Boolean = this.jdField_a_of_type_ComTencentBizQqstoryNetworkResponseGetCollectionVideoListResponse.jdField_a_of_type_Boolean;
    localPlayerVideoListEvent.c = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoModelMemorySharePlayingListSync$1.a.jdField_d_of_type_Boolean;
    localPlayerVideoListEvent.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoModelMemorySharePlayingListSync$1.a.jdField_a_of_type_JavaUtilList;
    localPlayerVideoListEvent.jdField_a_of_type_Int = localPlayerVideoListEvent.jdField_a_of_type_JavaUtilList.size();
    if (localPlayerVideoListEvent.jdField_a_of_type_Int < localPlayerVideoListEvent.jdField_a_of_type_JavaUtilList.size()) {
      localPlayerVideoListEvent.jdField_a_of_type_Int = localPlayerVideoListEvent.jdField_a_of_type_JavaUtilList.size();
    }
    StoryDispatcher.a().dispatch(localPlayerVideoListEvent);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("get video list return:");
    localStringBuilder.append(localPlayerVideoListEvent);
    SLog.b("Q.qqstory.player.MemorySharePlayingListSync", localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.model.MemorySharePlayingListSync.1.1
 * JD-Core Version:    0.7.0.1
 */