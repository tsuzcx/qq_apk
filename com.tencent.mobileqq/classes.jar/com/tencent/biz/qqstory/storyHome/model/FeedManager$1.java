package com.tencent.biz.qqstory.storyHome.model;

import java.util.ArrayList;
import woj;
import woy;
import wpm;
import yij;
import yqp;

public final class FeedManager$1
  implements Runnable
{
  public FeedManager$1(String paramString) {}
  
  public void run()
  {
    Object localObject = (woy)wpm.a(15);
    ((woy)localObject).a(new ArrayList(0), this.a, false, true);
    ((woy)localObject).a(new ArrayList(0), this.a, true, true);
    localObject = (woj)wpm.a(17);
    ((woj)localObject).a(new ArrayList(0), this.a, false, true);
    ((woj)localObject).a(new ArrayList(0), this.a, true, true);
    localObject = (yij)wpm.a(11);
    FeedItem localFeedItem = ((yij)localObject).a(this.a);
    if (localFeedItem != null)
    {
      localFeedItem.reset();
      ((yij)localObject).a(localFeedItem);
    }
    yqp.a("Q.qqstory.home.data.FeedManager", "clear all feed interactive data %s", this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.model.FeedManager.1
 * JD-Core Version:    0.7.0.1
 */