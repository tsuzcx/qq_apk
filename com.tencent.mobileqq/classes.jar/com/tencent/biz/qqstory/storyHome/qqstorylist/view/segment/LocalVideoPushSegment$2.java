package com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment;

import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

class LocalVideoPushSegment$2
  implements Runnable
{
  LocalVideoPushSegment$2(LocalVideoPushSegment paramLocalVideoPushSegment) {}
  
  public void run()
  {
    SLog.b("Q.qqstory.home.LocalVideoPushSegment", "loadPhotos..");
    LocalVideoPushSegment.LoadPhotoResult localLoadPhotoResult = LocalVideoPushSegment.b(this.this$0);
    if (localLoadPhotoResult != null)
    {
      ThreadManager.getUIHandler().post(new LocalVideoPushSegment.2.1(this, localLoadPhotoResult));
      return;
    }
    ThreadManager.getUIHandler().post(new LocalVideoPushSegment.2.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.LocalVideoPushSegment.2
 * JD-Core Version:    0.7.0.1
 */