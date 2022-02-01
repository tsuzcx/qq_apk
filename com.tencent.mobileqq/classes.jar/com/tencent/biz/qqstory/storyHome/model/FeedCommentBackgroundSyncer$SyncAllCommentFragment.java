package com.tencent.biz.qqstory.storyHome.model;

import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.storyHome.detail.model.CommentListPageLoader;
import com.tencent.biz.qqstory.storyHome.detail.model.CommentListPageLoader.GetFeedCommentEvent;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import java.util.ArrayList;
import java.util.List;

class FeedCommentBackgroundSyncer$SyncAllCommentFragment
  extends JobSegment<FeedCommentSync, CommentListPageLoader.GetFeedCommentEvent>
{
  private int jdField_a_of_type_Int;
  private CommentListPageLoader jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelCommentListPageLoader;
  private List<CommentEntry> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  protected void a(JobContext paramJobContext, FeedCommentSync paramFeedCommentSync)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelCommentListPageLoader = new CommentListPageLoader(paramFeedCommentSync, new FeedCommentBackgroundSyncer.SyncAllCommentFragment.1(this, paramJobContext, paramFeedCommentSync));
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelCommentListPageLoader.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.model.FeedCommentBackgroundSyncer.SyncAllCommentFragment
 * JD-Core Version:    0.7.0.1
 */