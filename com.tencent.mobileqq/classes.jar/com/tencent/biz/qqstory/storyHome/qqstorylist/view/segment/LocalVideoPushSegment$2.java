package com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment;

import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;
import yor;
import yow;
import yqp;

public class LocalVideoPushSegment$2
  implements Runnable
{
  public LocalVideoPushSegment$2(yor paramyor) {}
  
  public void run()
  {
    yqp.b("Q.qqstory.home.LocalVideoPushSegment", "loadPhotos..");
    yow localyow = yor.a(this.this$0);
    if (localyow != null)
    {
      ThreadManager.getUIHandler().post(new LocalVideoPushSegment.2.1(this, localyow));
      return;
    }
    ThreadManager.getUIHandler().post(new LocalVideoPushSegment.2.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.LocalVideoPushSegment.2
 * JD-Core Version:    0.7.0.1
 */