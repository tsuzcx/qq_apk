package com.tencent.biz.qqstory.storyHome.model;

import java.util.ArrayList;
import uux;
import uvm;
import uwa;
import woy;
import wxe;

public final class FeedManager$1
  implements Runnable
{
  public FeedManager$1(String paramString) {}
  
  public void run()
  {
    Object localObject = (uvm)uwa.a(15);
    ((uvm)localObject).a(new ArrayList(0), this.a, false, true);
    ((uvm)localObject).a(new ArrayList(0), this.a, true, true);
    localObject = (uux)uwa.a(17);
    ((uux)localObject).a(new ArrayList(0), this.a, false, true);
    ((uux)localObject).a(new ArrayList(0), this.a, true, true);
    localObject = (woy)uwa.a(11);
    FeedItem localFeedItem = ((woy)localObject).a(this.a);
    if (localFeedItem != null)
    {
      localFeedItem.reset();
      ((woy)localObject).a(localFeedItem);
    }
    wxe.a("Q.qqstory.home.data.FeedManager", "clear all feed interactive data %s", this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.model.FeedManager.1
 * JD-Core Version:    0.7.0.1
 */