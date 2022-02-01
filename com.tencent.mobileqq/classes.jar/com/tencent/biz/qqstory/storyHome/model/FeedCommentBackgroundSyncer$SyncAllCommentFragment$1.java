package com.tencent.biz.qqstory.storyHome.model;

import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.detail.model.CommentListPageLoader;
import com.tencent.biz.qqstory.storyHome.detail.model.CommentListPageLoader.CommentListener;
import com.tencent.biz.qqstory.storyHome.detail.model.CommentListPageLoader.GetFeedCommentEvent;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tribe.async.async.JobContext;
import java.util.List;

class FeedCommentBackgroundSyncer$SyncAllCommentFragment$1
  implements CommentListPageLoader.CommentListener
{
  FeedCommentBackgroundSyncer$SyncAllCommentFragment$1(FeedCommentBackgroundSyncer.SyncAllCommentFragment paramSyncAllCommentFragment, JobContext paramJobContext, FeedCommentSync paramFeedCommentSync) {}
  
  public void a(CommentListPageLoader.GetFeedCommentEvent paramGetFeedCommentEvent)
  {
    if (this.jdField_a_of_type_ComTribeAsyncAsyncJobContext.isJobCancelled())
    {
      SLog.d("Q.qqstory.home.data.FeedCommentBackgroundSyncer", "comment is cancel, feedId:%d", new Object[] { this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedCommentSync });
      return;
    }
    FeedCommentBackgroundSyncer.SyncAllCommentFragment.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedCommentBackgroundSyncer$SyncAllCommentFragment);
    SLog.a("Q.qqstory.home.data.FeedCommentBackgroundSyncer", "on comment back loop count:%d, event:%s", Integer.valueOf(FeedCommentBackgroundSyncer.SyncAllCommentFragment.b(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedCommentBackgroundSyncer$SyncAllCommentFragment)), paramGetFeedCommentEvent);
    if (paramGetFeedCommentEvent.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess())
    {
      FeedCommentBackgroundSyncer.SyncAllCommentFragment.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedCommentBackgroundSyncer$SyncAllCommentFragment).addAll(paramGetFeedCommentEvent.jdField_a_of_type_JavaUtilList);
      if ((!paramGetFeedCommentEvent.jdField_a_of_type_Boolean) && (FeedCommentBackgroundSyncer.SyncAllCommentFragment.b(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedCommentBackgroundSyncer$SyncAllCommentFragment) < 10))
      {
        SLog.a("Q.qqstory.home.data.FeedCommentBackgroundSyncer", "pull next page, loop count:%d", Integer.valueOf(FeedCommentBackgroundSyncer.SyncAllCommentFragment.b(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedCommentBackgroundSyncer$SyncAllCommentFragment)));
        FeedCommentBackgroundSyncer.SyncAllCommentFragment.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedCommentBackgroundSyncer$SyncAllCommentFragment).c();
        return;
      }
      paramGetFeedCommentEvent.jdField_a_of_type_JavaUtilList = FeedCommentBackgroundSyncer.SyncAllCommentFragment.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedCommentBackgroundSyncer$SyncAllCommentFragment);
      SLog.b("Q.qqstory.home.data.FeedCommentBackgroundSyncer", "pull comment end, comment count:%d", Integer.valueOf(FeedCommentBackgroundSyncer.SyncAllCommentFragment.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedCommentBackgroundSyncer$SyncAllCommentFragment).size()));
      FeedCommentBackgroundSyncer.SyncAllCommentFragment.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedCommentBackgroundSyncer$SyncAllCommentFragment, paramGetFeedCommentEvent);
      return;
    }
    paramGetFeedCommentEvent.jdField_a_of_type_JavaUtilList = FeedCommentBackgroundSyncer.SyncAllCommentFragment.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedCommentBackgroundSyncer$SyncAllCommentFragment);
    SLog.b("Q.qqstory.home.data.FeedCommentBackgroundSyncer", "pull comment error, comment count:%d", Integer.valueOf(FeedCommentBackgroundSyncer.SyncAllCommentFragment.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedCommentBackgroundSyncer$SyncAllCommentFragment).size()));
    FeedCommentBackgroundSyncer.SyncAllCommentFragment.b(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedCommentBackgroundSyncer$SyncAllCommentFragment, paramGetFeedCommentEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.model.FeedCommentBackgroundSyncer.SyncAllCommentFragment.1
 * JD-Core Version:    0.7.0.1
 */