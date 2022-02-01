package com.tencent.biz.qqstory.storyHome.model;

import com.tribe.async.async.ThreadOffFunction;
import com.tribe.async.reactive.Stream;
import yce;
import ycg;
import ycj;

public class FeedListPageLoaderBase$1
  implements Runnable
{
  public FeedListPageLoaderBase$1(yce paramyce) {}
  
  public void run()
  {
    if (yce.a(this.this$0) != null) {
      yce.a(this.this$0).cancel();
    }
    yce.a(this.this$0, Stream.of(Integer.valueOf(this.this$0.a.a)).map(new ThreadOffFunction("Q.qqstory.home.data.FeedListPageLoaderBase", 2)).map(this.this$0.a(this.this$0.a)).map(this.this$0.a()));
    yce.a(this.this$0).subscribe(new ycj(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.model.FeedListPageLoaderBase.1
 * JD-Core Version:    0.7.0.1
 */