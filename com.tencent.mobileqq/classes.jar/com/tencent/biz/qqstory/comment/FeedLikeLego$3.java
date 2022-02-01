package com.tencent.biz.qqstory.comment;

import com.tencent.biz.qqstory.database.LikeEntry;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.List;
import mqq.os.MqqHandler;
import wqs;
import wst;
import yme;

public class FeedLikeLego$3
  implements Runnable
{
  public FeedLikeLego$3(wqs paramwqs, String paramString) {}
  
  public void run()
  {
    this.this$0.jdField_a_of_type_Yme.a(this.this$0.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem);
    if (this.this$0.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mLikeCount > 0)
    {
      CommentLikeFeedItem localCommentLikeFeedItem = this.this$0.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem;
      localCommentLikeFeedItem.mLikeCount -= 1;
    }
    int i = 0;
    while (i < this.this$0.jdField_a_of_type_JavaUtilList.size())
    {
      if (((LikeEntry)this.this$0.jdField_a_of_type_JavaUtilList.get(i)).unionId.equals(this.a))
      {
        this.this$0.jdField_a_of_type_Wst.b((LikeEntry)this.this$0.jdField_a_of_type_JavaUtilList.get(i));
        this.this$0.jdField_a_of_type_JavaUtilList.remove(i);
      }
      i += 1;
    }
    ThreadManager.getUIHandler().post(new FeedLikeLego.3.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.comment.FeedLikeLego.3
 * JD-Core Version:    0.7.0.1
 */