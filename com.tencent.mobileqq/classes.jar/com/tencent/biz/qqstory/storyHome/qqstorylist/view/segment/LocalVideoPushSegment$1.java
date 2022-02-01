package com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment;

import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;
import ysm;
import ysq;
import ysr;
import yuk;

public class LocalVideoPushSegment$1
  implements Runnable
{
  public LocalVideoPushSegment$1(ysm paramysm) {}
  
  public void run()
  {
    yuk.b("Q.qqstory.home.LocalVideoPushSegment", "loadAlbumOrPhoto..");
    Object localObject = ysm.a(this.this$0);
    if (localObject != null)
    {
      ThreadManager.getUIHandler().post(new LocalVideoPushSegment.1.1(this, (ysq)localObject));
      return;
    }
    localObject = ysm.a(this.this$0);
    if (localObject != null)
    {
      ThreadManager.getUIHandler().post(new LocalVideoPushSegment.1.2(this, (ysr)localObject));
      return;
    }
    ThreadManager.getUIHandler().post(new LocalVideoPushSegment.1.3(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.LocalVideoPushSegment.1
 * JD-Core Version:    0.7.0.1
 */