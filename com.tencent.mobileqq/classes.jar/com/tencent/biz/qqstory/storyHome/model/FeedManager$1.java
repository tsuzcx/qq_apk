package com.tencent.biz.qqstory.storyHome.model;

import java.util.ArrayList;
import wse;
import wst;
import wth;
import yme;
import yuk;

public final class FeedManager$1
  implements Runnable
{
  public FeedManager$1(String paramString) {}
  
  public void run()
  {
    Object localObject = (wst)wth.a(15);
    ((wst)localObject).a(new ArrayList(0), this.a, false, true);
    ((wst)localObject).a(new ArrayList(0), this.a, true, true);
    localObject = (wse)wth.a(17);
    ((wse)localObject).a(new ArrayList(0), this.a, false, true);
    ((wse)localObject).a(new ArrayList(0), this.a, true, true);
    localObject = (yme)wth.a(11);
    FeedItem localFeedItem = ((yme)localObject).a(this.a);
    if (localFeedItem != null)
    {
      localFeedItem.reset();
      ((yme)localObject).a(localFeedItem);
    }
    yuk.a("Q.qqstory.home.data.FeedManager", "clear all feed interactive data %s", this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.model.FeedManager.1
 * JD-Core Version:    0.7.0.1
 */