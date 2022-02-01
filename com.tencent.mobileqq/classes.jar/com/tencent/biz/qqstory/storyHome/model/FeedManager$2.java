package com.tencent.biz.qqstory.storyHome.model;

import com.tencent.biz.qqstory.support.logging.SLog;
import java.util.ArrayList;

class FeedManager$2
  implements Runnable
{
  FeedManager$2(FeedManager paramFeedManager) {}
  
  public void run()
  {
    if (FeedManager.a(this.this$0) == 0L)
    {
      SLog.d("Q.qqstory.home.position", "cache in use");
      return;
    }
    this.this$0.e.clear();
    if (this.this$0.d != null) {
      this.this$0.d.a();
    }
    SLog.d("Q.qqstory.home.position", "release cache");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.model.FeedManager.2
 * JD-Core Version:    0.7.0.1
 */