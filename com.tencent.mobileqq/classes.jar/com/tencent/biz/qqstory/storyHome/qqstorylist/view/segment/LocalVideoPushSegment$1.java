package com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment;

import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;
import yis;
import yiw;
import yix;
import ykq;

public class LocalVideoPushSegment$1
  implements Runnable
{
  public LocalVideoPushSegment$1(yis paramyis) {}
  
  public void run()
  {
    ykq.b("Q.qqstory.home.LocalVideoPushSegment", "loadAlbumOrPhoto..");
    Object localObject = yis.a(this.this$0);
    if (localObject != null)
    {
      ThreadManager.getUIHandler().post(new LocalVideoPushSegment.1.1(this, (yiw)localObject));
      return;
    }
    localObject = yis.a(this.this$0);
    if (localObject != null)
    {
      ThreadManager.getUIHandler().post(new LocalVideoPushSegment.1.2(this, (yix)localObject));
      return;
    }
    ThreadManager.getUIHandler().post(new LocalVideoPushSegment.1.3(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.LocalVideoPushSegment.1
 * JD-Core Version:    0.7.0.1
 */