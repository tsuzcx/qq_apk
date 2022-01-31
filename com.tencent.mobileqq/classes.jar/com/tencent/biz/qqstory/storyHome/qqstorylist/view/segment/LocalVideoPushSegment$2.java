package com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment;

import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;
import wvg;
import wvl;
import wxe;

public class LocalVideoPushSegment$2
  implements Runnable
{
  public LocalVideoPushSegment$2(wvg paramwvg) {}
  
  public void run()
  {
    wxe.b("Q.qqstory.home.LocalVideoPushSegment", "loadPhotos..");
    wvl localwvl = wvg.a(this.this$0);
    if (localwvl != null)
    {
      ThreadManager.getUIHandler().post(new LocalVideoPushSegment.2.1(this, localwvl));
      return;
    }
    ThreadManager.getUIHandler().post(new LocalVideoPushSegment.2.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.LocalVideoPushSegment.2
 * JD-Core Version:    0.7.0.1
 */