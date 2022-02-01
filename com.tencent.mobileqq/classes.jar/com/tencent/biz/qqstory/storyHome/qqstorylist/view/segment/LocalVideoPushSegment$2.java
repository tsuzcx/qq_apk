package com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment;

import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;
import yis;
import yix;
import ykq;

public class LocalVideoPushSegment$2
  implements Runnable
{
  public LocalVideoPushSegment$2(yis paramyis) {}
  
  public void run()
  {
    ykq.b("Q.qqstory.home.LocalVideoPushSegment", "loadPhotos..");
    yix localyix = yis.a(this.this$0);
    if (localyix != null)
    {
      ThreadManager.getUIHandler().post(new LocalVideoPushSegment.2.1(this, localyix));
      return;
    }
    ThreadManager.getUIHandler().post(new LocalVideoPushSegment.2.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.LocalVideoPushSegment.2
 * JD-Core Version:    0.7.0.1
 */