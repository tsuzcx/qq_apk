package com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment;

import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

class LocalVideoPushSegment$1
  implements Runnable
{
  LocalVideoPushSegment$1(LocalVideoPushSegment paramLocalVideoPushSegment) {}
  
  public void run()
  {
    SLog.b("Q.qqstory.home.LocalVideoPushSegment", "loadAlbumOrPhoto..");
    Object localObject = LocalVideoPushSegment.a(this.this$0);
    if (localObject != null)
    {
      ThreadManager.getUIHandler().post(new LocalVideoPushSegment.1.1(this, (LocalVideoPushSegment.LoadAlbumResult)localObject));
      return;
    }
    localObject = LocalVideoPushSegment.a(this.this$0);
    if (localObject != null)
    {
      ThreadManager.getUIHandler().post(new LocalVideoPushSegment.1.2(this, (LocalVideoPushSegment.LoadPhotoResult)localObject));
      return;
    }
    ThreadManager.getUIHandler().post(new LocalVideoPushSegment.1.3(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.LocalVideoPushSegment.1
 * JD-Core Version:    0.7.0.1
 */