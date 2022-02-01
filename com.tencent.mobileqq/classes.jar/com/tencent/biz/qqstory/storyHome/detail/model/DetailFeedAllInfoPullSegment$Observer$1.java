package com.tencent.biz.qqstory.storyHome.detail.model;

import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tribe.async.async.JobContext;

class DetailFeedAllInfoPullSegment$Observer$1
  implements Runnable
{
  DetailFeedAllInfoPullSegment$Observer$1(DetailFeedAllInfoPullSegment.Observer paramObserver, boolean paramBoolean) {}
  
  public void run()
  {
    if (DetailFeedAllInfoPullSegment.a(this.b.a).isJobCancelled())
    {
      SLog.d("Q.qqstory.detail:DetailFeedAllInfoPullSegment", "stream cancel on all function completed.");
      return;
    }
    if (this.a)
    {
      Object localObject = this.b;
      int i1 = 0;
      localObject = (Integer)((DetailFeedAllInfoPullSegment.Observer)localObject).getFunctionResult(0);
      if (localObject != null) {
        DetailFeedAllInfoPullSegment.b(this.b.a).a.mViewTotalTime = ((Integer)localObject).intValue();
      }
      int j;
      if (DetailFeedAllInfoPullSegment.b(this.b.a).b()) {
        j = 2;
      } else {
        j = 1;
      }
      int k = 0;
      int i = 1;
      int m;
      int n;
      for (;;)
      {
        m = i1;
        n = i;
        if (k >= j) {
          break;
        }
        localObject = (DetailFeedAllInfoPullSegment.LikeData)this.b.getFunctionResult(i);
        if (localObject != null)
        {
          DetailFeedAllInfoPullSegment.b(this.b.a).b(((DetailFeedAllInfoPullSegment.LikeData)localObject).b, true, ((DetailFeedAllInfoPullSegment.LikeData)localObject).a);
          DetailFeedAllInfoPullSegment.b(this.b.a).b(((DetailFeedAllInfoPullSegment.LikeData)localObject).a, ((DetailFeedAllInfoPullSegment.LikeData)localObject).c);
          DetailFeedAllInfoPullSegment.b(this.b.a).a.mHadLike = ((DetailFeedAllInfoPullSegment.LikeData)localObject).d;
        }
        k += 1;
        i += 1;
      }
      while (m < j)
      {
        localObject = (DetailFeedAllInfoPullSegment.CommentData)this.b.getFunctionResult(n);
        if (localObject != null)
        {
          DetailFeedAllInfoPullSegment.b(this.b.a).a(((DetailFeedAllInfoPullSegment.CommentData)localObject).b, true, ((DetailFeedAllInfoPullSegment.CommentData)localObject).a);
          DetailFeedAllInfoPullSegment.b(this.b.a).a(((DetailFeedAllInfoPullSegment.CommentData)localObject).a, ((DetailFeedAllInfoPullSegment.CommentData)localObject).c);
          DetailFeedAllInfoPullSegment.b(this.b.a).a(((DetailFeedAllInfoPullSegment.CommentData)localObject).a, ((DetailFeedAllInfoPullSegment.CommentData)localObject).d);
          DetailFeedAllInfoPullSegment.b(this.b.a).a(((DetailFeedAllInfoPullSegment.CommentData)localObject).a, ((DetailFeedAllInfoPullSegment.CommentData)localObject).e);
        }
        m += 1;
        n += 1;
      }
      DetailFeedAllInfoPullSegment.a(this.b.a, DetailFeedAllInfoPullSegment.b(this.b.a));
      return;
    }
    DetailFeedAllInfoPullSegment.a(this.b.a, new ErrorMessage(-1, "get feed interact data error."));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.detail.model.DetailFeedAllInfoPullSegment.Observer.1
 * JD-Core Version:    0.7.0.1
 */