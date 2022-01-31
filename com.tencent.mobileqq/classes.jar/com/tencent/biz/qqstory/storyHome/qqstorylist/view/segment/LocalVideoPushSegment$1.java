package com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment;

import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;
import vcf;
import vcj;
import vck;
import ved;

public class LocalVideoPushSegment$1
  implements Runnable
{
  public LocalVideoPushSegment$1(vcf paramvcf) {}
  
  public void run()
  {
    ved.b("Q.qqstory.home.LocalVideoPushSegment", "loadAlbumOrPhoto..");
    Object localObject = vcf.a(this.this$0);
    if (localObject != null)
    {
      ThreadManager.getUIHandler().post(new LocalVideoPushSegment.1.1(this, (vcj)localObject));
      return;
    }
    localObject = vcf.a(this.this$0);
    if (localObject != null)
    {
      ThreadManager.getUIHandler().post(new LocalVideoPushSegment.1.2(this, (vck)localObject));
      return;
    }
    ThreadManager.getUIHandler().post(new LocalVideoPushSegment.1.3(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.LocalVideoPushSegment.1
 * JD-Core Version:    0.7.0.1
 */