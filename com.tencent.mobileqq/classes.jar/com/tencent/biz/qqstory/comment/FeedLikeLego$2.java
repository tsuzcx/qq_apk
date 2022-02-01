package com.tencent.biz.qqstory.comment;

import com.tencent.biz.qqstory.database.LikeEntry;
import com.tencent.biz.qqstory.model.LikeManager;
import com.tencent.biz.qqstory.model.UserManager;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.storyHome.model.FeedManager;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.List;
import mqq.os.MqqHandler;

class FeedLikeLego$2
  implements Runnable
{
  public void run()
  {
    QQUserUIItem localQQUserUIItem = this.a.b(this.b);
    if (localQQUserUIItem != null)
    {
      LikeEntry localLikeEntry = this.c;
      long l;
      if (localQQUserUIItem.isVip) {
        l = 2L;
      } else {
        l = 0L;
      }
      localLikeEntry.role = l;
    }
    this.this$0.e.add(this.c);
    this.this$0.f.a(this.c);
    this.this$0.g.a(this.this$0.b);
    ThreadManager.getUIHandler().post(new FeedLikeLego.2.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.comment.FeedLikeLego.2
 * JD-Core Version:    0.7.0.1
 */