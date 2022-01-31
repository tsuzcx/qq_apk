package com.tencent.biz.qqstory.storyHome.model;

import java.util.ArrayList;
import tbw;
import tcl;
import tcz;
import uvx;
import ved;

public final class FeedManager$1
  implements Runnable
{
  public FeedManager$1(String paramString) {}
  
  public void run()
  {
    Object localObject = (tcl)tcz.a(15);
    ((tcl)localObject).a(new ArrayList(0), this.a, false, true);
    ((tcl)localObject).a(new ArrayList(0), this.a, true, true);
    localObject = (tbw)tcz.a(17);
    ((tbw)localObject).a(new ArrayList(0), this.a, false, true);
    ((tbw)localObject).a(new ArrayList(0), this.a, true, true);
    localObject = (uvx)tcz.a(11);
    FeedItem localFeedItem = ((uvx)localObject).a(this.a);
    if (localFeedItem != null)
    {
      localFeedItem.reset();
      ((uvx)localObject).a(localFeedItem);
    }
    ved.a("Q.qqstory.home.data.FeedManager", "clear all feed interactive data %s", this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.model.FeedManager.1
 * JD-Core Version:    0.7.0.1
 */