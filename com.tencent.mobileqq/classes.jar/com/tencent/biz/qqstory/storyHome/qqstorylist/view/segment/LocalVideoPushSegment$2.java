package com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment;

import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;
import upm;
import upr;
import urk;

public class LocalVideoPushSegment$2
  implements Runnable
{
  public LocalVideoPushSegment$2(upm paramupm) {}
  
  public void run()
  {
    urk.b("Q.qqstory.home.LocalVideoPushSegment", "loadPhotos..");
    upr localupr = upm.a(this.this$0);
    if (localupr != null)
    {
      ThreadManager.getUIHandler().post(new LocalVideoPushSegment.2.1(this, localupr));
      return;
    }
    ThreadManager.getUIHandler().post(new LocalVideoPushSegment.2.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.LocalVideoPushSegment.2
 * JD-Core Version:    0.7.0.1
 */