package com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment;

import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;
import wqx;
import wrb;
import wrc;
import wsv;

public class LocalVideoPushSegment$1
  implements Runnable
{
  public LocalVideoPushSegment$1(wqx paramwqx) {}
  
  public void run()
  {
    wsv.b("Q.qqstory.home.LocalVideoPushSegment", "loadAlbumOrPhoto..");
    Object localObject = wqx.a(this.this$0);
    if (localObject != null)
    {
      ThreadManager.getUIHandler().post(new LocalVideoPushSegment.1.1(this, (wrb)localObject));
      return;
    }
    localObject = wqx.a(this.this$0);
    if (localObject != null)
    {
      ThreadManager.getUIHandler().post(new LocalVideoPushSegment.1.2(this, (wrc)localObject));
      return;
    }
    ThreadManager.getUIHandler().post(new LocalVideoPushSegment.1.3(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.LocalVideoPushSegment.1
 * JD-Core Version:    0.7.0.1
 */