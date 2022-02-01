package com.tencent.biz.qqstory.storyHome.model;

import java.util.ArrayList;
import wip;
import wje;
import wjs;
import yck;
import ykq;

public final class FeedManager$1
  implements Runnable
{
  public FeedManager$1(String paramString) {}
  
  public void run()
  {
    Object localObject = (wje)wjs.a(15);
    ((wje)localObject).a(new ArrayList(0), this.a, false, true);
    ((wje)localObject).a(new ArrayList(0), this.a, true, true);
    localObject = (wip)wjs.a(17);
    ((wip)localObject).a(new ArrayList(0), this.a, false, true);
    ((wip)localObject).a(new ArrayList(0), this.a, true, true);
    localObject = (yck)wjs.a(11);
    FeedItem localFeedItem = ((yck)localObject).a(this.a);
    if (localFeedItem != null)
    {
      localFeedItem.reset();
      ((yck)localObject).a(localFeedItem);
    }
    ykq.a("Q.qqstory.home.data.FeedManager", "clear all feed interactive data %s", this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.model.FeedManager.1
 * JD-Core Version:    0.7.0.1
 */