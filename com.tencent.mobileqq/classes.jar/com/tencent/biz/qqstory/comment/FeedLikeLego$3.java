package com.tencent.biz.qqstory.comment;

import com.tencent.biz.qqstory.database.LikeEntry;
import com.tencent.biz.qqstory.model.LikeManager;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.storyHome.model.FeedManager;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.List;
import mqq.os.MqqHandler;

class FeedLikeLego$3
  implements Runnable
{
  public void run()
  {
    this.this$0.g.a(this.this$0.b);
    if (this.this$0.b.mLikeCount > 0)
    {
      CommentLikeFeedItem localCommentLikeFeedItem = this.this$0.b;
      localCommentLikeFeedItem.mLikeCount -= 1;
    }
    int i = 0;
    while (i < this.this$0.e.size())
    {
      if (((LikeEntry)this.this$0.e.get(i)).unionId.equals(this.a))
      {
        this.this$0.f.b((LikeEntry)this.this$0.e.get(i));
        this.this$0.e.remove(i);
      }
      i += 1;
    }
    ThreadManager.getUIHandler().post(new FeedLikeLego.3.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.comment.FeedLikeLego.3
 * JD-Core Version:    0.7.0.1
 */