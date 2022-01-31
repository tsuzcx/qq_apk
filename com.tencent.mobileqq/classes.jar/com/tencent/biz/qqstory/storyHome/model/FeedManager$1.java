package com.tencent.biz.qqstory.storyHome.model;

import java.util.ArrayList;
import uqo;
import urd;
import urr;
import wkp;
import wsv;

public final class FeedManager$1
  implements Runnable
{
  public FeedManager$1(String paramString) {}
  
  public void run()
  {
    Object localObject = (urd)urr.a(15);
    ((urd)localObject).a(new ArrayList(0), this.a, false, true);
    ((urd)localObject).a(new ArrayList(0), this.a, true, true);
    localObject = (uqo)urr.a(17);
    ((uqo)localObject).a(new ArrayList(0), this.a, false, true);
    ((uqo)localObject).a(new ArrayList(0), this.a, true, true);
    localObject = (wkp)urr.a(11);
    FeedItem localFeedItem = ((wkp)localObject).a(this.a);
    if (localFeedItem != null)
    {
      localFeedItem.reset();
      ((wkp)localObject).a(localFeedItem);
    }
    wsv.a("Q.qqstory.home.data.FeedManager", "clear all feed interactive data %s", this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.model.FeedManager.1
 * JD-Core Version:    0.7.0.1
 */