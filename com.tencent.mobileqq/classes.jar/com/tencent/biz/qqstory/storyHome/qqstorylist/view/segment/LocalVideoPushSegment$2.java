package com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment;

import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;
import vcf;
import vck;
import ved;

public class LocalVideoPushSegment$2
  implements Runnable
{
  public LocalVideoPushSegment$2(vcf paramvcf) {}
  
  public void run()
  {
    ved.b("Q.qqstory.home.LocalVideoPushSegment", "loadPhotos..");
    vck localvck = vcf.a(this.this$0);
    if (localvck != null)
    {
      ThreadManager.getUIHandler().post(new LocalVideoPushSegment.2.1(this, localvck));
      return;
    }
    ThreadManager.getUIHandler().post(new LocalVideoPushSegment.2.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.LocalVideoPushSegment.2
 * JD-Core Version:    0.7.0.1
 */