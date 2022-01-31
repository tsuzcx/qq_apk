package com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment;

import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;
import vci;
import vcn;
import veg;

public class LocalVideoPushSegment$2
  implements Runnable
{
  public LocalVideoPushSegment$2(vci paramvci) {}
  
  public void run()
  {
    veg.b("Q.qqstory.home.LocalVideoPushSegment", "loadPhotos..");
    vcn localvcn = vci.a(this.this$0);
    if (localvcn != null)
    {
      ThreadManager.getUIHandler().post(new LocalVideoPushSegment.2.1(this, localvcn));
      return;
    }
    ThreadManager.getUIHandler().post(new LocalVideoPushSegment.2.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.LocalVideoPushSegment.2
 * JD-Core Version:    0.7.0.1
 */