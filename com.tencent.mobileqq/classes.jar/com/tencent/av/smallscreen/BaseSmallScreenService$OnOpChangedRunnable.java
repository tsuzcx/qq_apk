package com.tencent.av.smallscreen;

import android.os.Handler;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import liz;
import lzj;

class BaseSmallScreenService$OnOpChangedRunnable
  implements Runnable
{
  BaseSmallScreenService$OnOpChangedRunnable(BaseSmallScreenService paramBaseSmallScreenService) {}
  
  public void run()
  {
    if (!this.this$0.d)
    {
      boolean bool = lzj.c(((AppInterface)BaseSmallScreenService.a(this.this$0)).getApp());
      if (bool != this.this$0.e)
      {
        this.this$0.e = bool;
        this.this$0.e();
      }
      bool = lzj.i();
      if (bool != this.this$0.b)
      {
        this.this$0.b = bool;
        this.this$0.d();
      }
      bool = lzj.b(((AppInterface)BaseSmallScreenService.b(this.this$0)).getApp());
      if (bool != this.this$0.c)
      {
        this.this$0.c = bool;
        this.this$0.c();
      }
      bool = this.this$0.a();
      if (bool != this.this$0.f)
      {
        l = AudioHelper.b();
        if (QLog.isDevelopLevel()) {
          QLog.w("BaseSmallScreenService", 1, "OnOpChangedRunnable, AppOnForegroundChanged, seq[" + l + "]");
        }
        this.this$0.f = bool;
        this.this$0.a(l);
        if (!bool) {
          break label229;
        }
      }
    }
    label229:
    for (long l = 1L;; l = 2L)
    {
      liz.a(20, l);
      this.this$0.a().postDelayed(this, 1000L);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.av.smallscreen.BaseSmallScreenService.OnOpChangedRunnable
 * JD-Core Version:    0.7.0.1
 */