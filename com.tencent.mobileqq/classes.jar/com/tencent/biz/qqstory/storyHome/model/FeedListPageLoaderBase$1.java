package com.tencent.biz.qqstory.storyHome.model;

import com.tribe.async.async.ThreadOffFunction;
import com.tribe.async.reactive.Stream;
import uvr;
import uvt;
import uvw;

public class FeedListPageLoaderBase$1
  implements Runnable
{
  public FeedListPageLoaderBase$1(uvr paramuvr) {}
  
  public void run()
  {
    if (uvr.a(this.this$0) != null) {
      uvr.a(this.this$0).cancel();
    }
    uvr.a(this.this$0, Stream.of(Integer.valueOf(this.this$0.a.a)).map(new ThreadOffFunction("Q.qqstory.home.data.FeedListPageLoaderBase", 2)).map(this.this$0.a(this.this$0.a)).map(this.this$0.a()));
    uvr.a(this.this$0).subscribe(new uvw(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.model.FeedListPageLoaderBase.1
 * JD-Core Version:    0.7.0.1
 */