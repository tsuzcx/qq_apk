package com.tencent.biz.qqstory.storyHome.detail.model;

import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.CommentManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.storyHome.model.FeedCommentSync;
import com.tencent.biz.qqstory.support.logging.SLog;
import java.util.List;

class CommentListPageLoader$1
  implements Runnable
{
  public void run()
  {
    ??? = ((CommentManager)SuperManager.a(17)).a(CommentListPageLoader.a(this.this$0).jdField_a_of_type_JavaLangString, CommentListPageLoader.a(this.this$0).a());
    CommentListPageLoader.GetFeedCommentEvent localGetFeedCommentEvent = new CommentListPageLoader.GetFeedCommentEvent(new ErrorMessage(), CommentListPageLoader.a(this.this$0).jdField_a_of_type_JavaLangString, CommentListPageLoader.a(this.this$0).jdField_a_of_type_Int);
    localGetFeedCommentEvent.d = false;
    localGetFeedCommentEvent.jdField_b_of_type_Boolean = true;
    localGetFeedCommentEvent.jdField_a_of_type_JavaUtilList = ((List)???);
    localGetFeedCommentEvent.jdField_b_of_type_Int = -1;
    localGetFeedCommentEvent.jdField_a_of_type_Boolean = true;
    localGetFeedCommentEvent.jdField_a_of_type_Int = CommentListPageLoader.a(this.this$0).jdField_b_of_type_Int;
    synchronized (this.this$0)
    {
      if (!this.this$0.jdField_b_of_type_Boolean)
      {
        CommentListPageLoader.a(this.this$0, localGetFeedCommentEvent);
        SLog.a("Q.qqstory.detail:CommentListPageLoader", "dispatch comment list return from cache: %s", localGetFeedCommentEvent);
      }
      else
      {
        SLog.d("Q.qqstory.detail:CommentListPageLoader", "load cache data later than load from network");
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.detail.model.CommentListPageLoader.1
 * JD-Core Version:    0.7.0.1
 */