package com.tencent.biz.qqcircle.immersive.views.banner;

import java.lang.ref.WeakReference;

class QFSImageBanner$AutoLoopTask
  implements Runnable
{
  private final WeakReference<QFSImageBanner> a;
  
  QFSImageBanner$AutoLoopTask(QFSImageBanner paramQFSImageBanner)
  {
    this.a = new WeakReference(paramQFSImageBanner);
  }
  
  public void run()
  {
    QFSImageBanner localQFSImageBanner = (QFSImageBanner)this.a.get();
    if ((localQFSImageBanner != null) && (QFSImageBanner.b(localQFSImageBanner) != null) && (QFSImageBanner.b(localQFSImageBanner).c()))
    {
      int i = localQFSImageBanner.getItemCount();
      if (i == 0) {
        return;
      }
      QFSImageBanner.d(localQFSImageBanner, (QFSImageBanner.c(localQFSImageBanner) + 1) % i);
      localQFSImageBanner.postDelayed(QFSImageBanner.f(localQFSImageBanner), QFSImageBanner.g(localQFSImageBanner) + QFSImageBanner.h(localQFSImageBanner));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.views.banner.QFSImageBanner.AutoLoopTask
 * JD-Core Version:    0.7.0.1
 */