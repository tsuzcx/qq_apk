package com.tencent.biz.qqstory.storyHome.model;

import java.util.ArrayList;
import vtu;
import vuj;
import vux;
import xnp;
import xvv;

public final class FeedManager$1
  implements Runnable
{
  public FeedManager$1(String paramString) {}
  
  public void run()
  {
    Object localObject = (vuj)vux.a(15);
    ((vuj)localObject).a(new ArrayList(0), this.a, false, true);
    ((vuj)localObject).a(new ArrayList(0), this.a, true, true);
    localObject = (vtu)vux.a(17);
    ((vtu)localObject).a(new ArrayList(0), this.a, false, true);
    ((vtu)localObject).a(new ArrayList(0), this.a, true, true);
    localObject = (xnp)vux.a(11);
    FeedItem localFeedItem = ((xnp)localObject).a(this.a);
    if (localFeedItem != null)
    {
      localFeedItem.reset();
      ((xnp)localObject).a(localFeedItem);
    }
    xvv.a("Q.qqstory.home.data.FeedManager", "clear all feed interactive data %s", this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.model.FeedManager.1
 * JD-Core Version:    0.7.0.1
 */