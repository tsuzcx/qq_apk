package com.tencent.av.smallscreen;

import android.os.Build.VERSION;
import android.os.Handler;
import com.tencent.av.VideoController;
import com.tencent.av.wtogether.media.WatchTogetherMediaPlayCtrl;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import lii;
import lzr;
import mjw;

class BaseSmallScreenService$OnOpChangedRunnable
  implements Runnable
{
  BaseSmallScreenService$OnOpChangedRunnable(BaseSmallScreenService paramBaseSmallScreenService) {}
  
  public void run()
  {
    boolean bool2 = false;
    int i;
    int j;
    if (!this.this$0.d)
    {
      WatchTogetherMediaPlayCtrl localWatchTogetherMediaPlayCtrl = VideoController.a().b();
      if ((localWatchTogetherMediaPlayCtrl == null) || (!localWatchTogetherMediaPlayCtrl.h())) {
        break label303;
      }
      i = 1;
      if ((Build.VERSION.SDK_INT < 21) || (!VideoController.a().a().c())) {
        break label308;
      }
      j = 1;
      label58:
      boolean bool1 = bool2;
      if (lzr.c(((AppInterface)BaseSmallScreenService.a(this.this$0)).getApp()))
      {
        bool1 = bool2;
        if (j == 0)
        {
          bool1 = bool2;
          if (i == 0) {
            bool1 = true;
          }
        }
      }
      if (bool1 != this.this$0.e)
      {
        this.this$0.e = bool1;
        this.this$0.c();
      }
      bool1 = lzr.i();
      if (bool1 != this.this$0.b)
      {
        this.this$0.b = bool1;
        this.this$0.b();
      }
      bool1 = lzr.b(((AppInterface)BaseSmallScreenService.b(this.this$0)).getApp());
      if (bool1 != this.this$0.c)
      {
        this.this$0.c = bool1;
        this.this$0.a();
      }
      bool1 = this.this$0.a();
      if (bool1 != this.this$0.f)
      {
        l = AudioHelper.b();
        if (QLog.isDevelopLevel()) {
          QLog.w("BaseSmallScreenService", 1, "OnOpChangedRunnable, AppOnForegroundChanged, seq[" + l + "]");
        }
        this.this$0.f = bool1;
        this.this$0.a(l);
        if (!bool1) {
          break label313;
        }
      }
    }
    label303:
    label308:
    label313:
    for (long l = 1L;; l = 2L)
    {
      lii.a(20, l);
      this.this$0.a().postDelayed(this, 1000L);
      return;
      i = 0;
      break;
      j = 0;
      break label58;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.smallscreen.BaseSmallScreenService.OnOpChangedRunnable
 * JD-Core Version:    0.7.0.1
 */