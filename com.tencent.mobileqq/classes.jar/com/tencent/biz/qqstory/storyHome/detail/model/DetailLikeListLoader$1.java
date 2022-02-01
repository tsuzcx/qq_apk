package com.tencent.biz.qqstory.storyHome.detail.model;

import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.StoryDispatcher;
import com.tencent.biz.qqstory.model.LikeManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatcher.Dispatchable;
import java.util.List;

class DetailLikeListLoader$1
  implements Runnable
{
  public void run()
  {
    Object localObject1 = (LikeManager)SuperManager.a(15);
    ??? = DetailLikeListLoader.a(this.this$0);
    boolean bool;
    if (DetailLikeListLoader.b(this.this$0) == 1) {
      bool = true;
    } else {
      bool = false;
    }
    ??? = ((LikeManager)localObject1).a((String)???, bool);
    localObject1 = new DetailLikeListLoader.GetLikeListEvent(new ErrorMessage(), DetailLikeListLoader.a(this.this$0));
    ((DetailLikeListLoader.GetLikeListEvent)localObject1).h = true;
    ((DetailLikeListLoader.GetLikeListEvent)localObject1).b = DetailLikeListLoader.c(this.this$0);
    ((DetailLikeListLoader.GetLikeListEvent)localObject1).c = DetailLikeListLoader.b(this.this$0);
    ((DetailLikeListLoader.GetLikeListEvent)localObject1).e = -1;
    ((DetailLikeListLoader.GetLikeListEvent)localObject1).d = -1;
    ((DetailLikeListLoader.GetLikeListEvent)localObject1).f = ((List)???);
    synchronized (this.this$0)
    {
      if (!DetailLikeListLoader.d(this.this$0))
      {
        StoryDispatcher.a().dispatch((Dispatcher.Dispatchable)localObject1);
        SLog.a("Q.qqstory.detail:DetailLikeListLoader", "dispatch like list return from cache: %s", localObject1);
      }
      else
      {
        SLog.d("Q.qqstory.detail:DetailLikeListLoader", "load cache data later than load from network");
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.detail.model.DetailLikeListLoader.1
 * JD-Core Version:    0.7.0.1
 */