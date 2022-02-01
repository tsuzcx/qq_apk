package com.tencent.biz.qqstory.storyHome.detail.model;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.model.CommentManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.storyHome.model.FeedCommentSync;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.SimpleJob;

class CommentListPageLoader$2
  extends SimpleJob
{
  CommentListPageLoader$2(CommentListPageLoader paramCommentListPageLoader, String paramString, CommentListPageLoader.GetFeedCommentEvent paramGetFeedCommentEvent, boolean paramBoolean)
  {
    super(paramString);
  }
  
  public Object doInBackground(@NonNull JobContext paramJobContext, @Nullable Object[] paramArrayOfObject)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelCommentListPageLoader.a();
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelCommentListPageLoader.b();
    ((CommentManager)SuperManager.a(17)).a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelCommentListPageLoader$GetFeedCommentEvent.a, CommentListPageLoader.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelCommentListPageLoader).a, CommentListPageLoader.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelCommentListPageLoader).a(), this.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelCommentListPageLoader.a("Q.qqstory.detail:CommentListPageLoader");
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.detail.model.CommentListPageLoader.2
 * JD-Core Version:    0.7.0.1
 */