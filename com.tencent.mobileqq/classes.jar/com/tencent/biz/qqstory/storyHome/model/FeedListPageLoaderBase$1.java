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
    FeedListPageLoaderBase localFeedListPageLoaderBase1 = this.this$0;
    Stream localStream = Stream.of(Integer.valueOf(localFeedListPageLoaderBase1.a.a)).map(new ThreadOffFunction("Q.qqstory.home.data.FeedListPageLoaderBase", 2));
    FeedListPageLoaderBase localFeedListPageLoaderBase2 = this.this$0;
    FeedListPageLoaderBase.a(localFeedListPageLoaderBase1, localStream.map(localFeedListPageLoaderBase2.a(localFeedListPageLoaderBase2.a)).map(this.this$0.a()));
    FeedListPageLoaderBase.a(this.this$0).subscribe(new FeedListPageLoaderBase.RequestFeedObserver(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.model.FeedListPageLoaderBase.1
 * JD-Core Version:    0.7.0.1
 */