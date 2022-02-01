package com.tencent.biz.qqstory.storyHome.model;

import com.tribe.async.async.ThreadOffFunction;
import com.tribe.async.reactive.Stream;

class FeedListPageLoaderBase$1
  implements Runnable
{
  FeedListPageLoaderBase$1(FeedListPageLoaderBase paramFeedListPageLoaderBase) {}
  
  public void run()
  {
    if (FeedListPageLoaderBase.a(this.this$0) != null) {
      FeedListPageLoaderBase.a(this.this$0).cancel();
    }
    FeedListPageLoaderBase.a(this.this$0, Stream.of(Integer.valueOf(this.this$0.a.a)).map(new ThreadOffFunction("Q.qqstory.home.data.FeedListPageLoaderBase", 2)).map(this.this$0.a(this.this$0.a)).map(this.this$0.a()));
    FeedListPageLoaderBase.a(this.this$0).subscribe(new FeedListPageLoaderBase.RequestFeedObserver(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.model.FeedListPageLoaderBase.1
 * JD-Core Version:    0.7.0.1
 */