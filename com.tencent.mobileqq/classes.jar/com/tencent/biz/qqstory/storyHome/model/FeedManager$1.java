package com.tencent.biz.qqstory.storyHome.model;

import java.util.ArrayList;
import spd;
import sps;
import sqg;
import uje;
import urk;

public final class FeedManager$1
  implements Runnable
{
  public FeedManager$1(String paramString) {}
  
  public void run()
  {
    Object localObject = (sps)sqg.a(15);
    ((sps)localObject).a(new ArrayList(0), this.a, false, true);
    ((sps)localObject).a(new ArrayList(0), this.a, true, true);
    localObject = (spd)sqg.a(17);
    ((spd)localObject).a(new ArrayList(0), this.a, false, true);
    ((spd)localObject).a(new ArrayList(0), this.a, true, true);
    localObject = (uje)sqg.a(11);
    FeedItem localFeedItem = ((uje)localObject).a(this.a);
    if (localFeedItem != null)
    {
      localFeedItem.reset();
      ((uje)localObject).a(localFeedItem);
    }
    urk.a("Q.qqstory.home.data.FeedManager", "clear all feed interactive data %s", this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.model.FeedManager.1
 * JD-Core Version:    0.7.0.1
 */