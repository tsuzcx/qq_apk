package com.tencent.av.smallscreen;

import android.os.Build.VERSION;
import android.os.Handler;
import com.tencent.av.VideoController;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import lic;
import lzq;
import mjq;

class BaseSmallScreenService$OnOpChangedRunnable
  implements Runnable
{
  BaseSmallScreenService$OnOpChangedRunnable(BaseSmallScreenService paramBaseSmallScreenService) {}
  
  public void run()
  {
    boolean bool2 = false;
    int i;
    if (!this.this$0.d)
    {
      if ((Build.VERSION.SDK_INT < 21) || (!VideoController.a().a().c())) {
        break label270;
      }
      i = 1;
      boolean bool1 = bool2;
      if (lzq.c(((AppInterface)BaseSmallScreenService.a(this.this$0)).getApp()))
      {
        bool1 = bool2;
        if (i == 0) {
          bool1 = true;
        }
      }
      if (bool1 != this.this$0.e)
      {
        this.this$0.e = bool1;
        this.this$0.c();
      }
      bool1 = lzq.i();
      if (bool1 != this.this$0.b)
      {
        this.this$0.b = bool1;
        this.this$0.b();
      }
      bool1 = lzq.b(((AppInterface)BaseSmallScreenService.b(this.this$0)).getApp());
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
          break label275;
        }
      }
    }
    label270:
    label275:
    for (long l = 1L;; l = 2L)
    {
      lic.a(20, l);
      this.this$0.a().postDelayed(this, 1000L);
      return;
      i = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.smallscreen.BaseSmallScreenService.OnOpChangedRunnable
 * JD-Core Version:    0.7.0.1
 */