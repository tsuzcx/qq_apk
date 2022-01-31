package com.tencent.biz.qqstory.storyHome.model;

import java.util.ArrayList;
import tbz;
import tco;
import tdc;
import uwa;
import veg;

public final class FeedManager$1
  implements Runnable
{
  public FeedManager$1(String paramString) {}
  
  public void run()
  {
    Object localObject = (tco)tdc.a(15);
    ((tco)localObject).a(new ArrayList(0), this.a, false, true);
    ((tco)localObject).a(new ArrayList(0), this.a, true, true);
    localObject = (tbz)tdc.a(17);
    ((tbz)localObject).a(new ArrayList(0), this.a, false, true);
    ((tbz)localObject).a(new ArrayList(0), this.a, true, true);
    localObject = (uwa)tdc.a(11);
    FeedItem localFeedItem = ((uwa)localObject).a(this.a);
    if (localFeedItem != null)
    {
      localFeedItem.reset();
      ((uwa)localObject).a(localFeedItem);
    }
    veg.a("Q.qqstory.home.data.FeedManager", "clear all feed interactive data %s", this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.model.FeedManager.1
 * JD-Core Version:    0.7.0.1
 */