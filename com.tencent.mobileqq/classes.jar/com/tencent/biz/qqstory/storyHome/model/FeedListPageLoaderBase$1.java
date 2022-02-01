package com.tencent.biz.qqstory.storyHome.model;

import com.tribe.async.async.ThreadOffFunction;
import com.tribe.async.reactive.Stream;
import yly;
import yma;
import ymd;

public class FeedListPageLoaderBase$1
  implements Runnable
{
  public FeedListPageLoaderBase$1(yly paramyly) {}
  
  public void run()
  {
    if (yly.a(this.this$0) != null) {
      yly.a(this.this$0).cancel();
    }
    yly.a(this.this$0, Stream.of(Integer.valueOf(this.this$0.a.a)).map(new ThreadOffFunction("Q.qqstory.home.data.FeedListPageLoaderBase", 2)).map(this.this$0.a(this.this$0.a)).map(this.this$0.a()));
    yly.a(this.this$0).subscribe(new ymd(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.model.FeedListPageLoaderBase.1
 * JD-Core Version:    0.7.0.1
 */