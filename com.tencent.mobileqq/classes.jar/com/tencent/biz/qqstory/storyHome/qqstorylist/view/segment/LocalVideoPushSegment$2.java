package com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment;

import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;
import ysm;
import ysr;
import yuk;

public class LocalVideoPushSegment$2
  implements Runnable
{
  public LocalVideoPushSegment$2(ysm paramysm) {}
  
  public void run()
  {
    yuk.b("Q.qqstory.home.LocalVideoPushSegment", "loadPhotos..");
    ysr localysr = ysm.a(this.this$0);
    if (localysr != null)
    {
      ThreadManager.getUIHandler().post(new LocalVideoPushSegment.2.1(this, localysr));
      return;
    }
    ThreadManager.getUIHandler().post(new LocalVideoPushSegment.2.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.LocalVideoPushSegment.2
 * JD-Core Version:    0.7.0.1
 */