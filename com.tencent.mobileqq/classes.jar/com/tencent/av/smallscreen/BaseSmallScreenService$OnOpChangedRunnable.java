package com.tencent.av.smallscreen;

import android.os.Build.VERSION;
import android.os.Handler;
import com.tencent.av.VideoController;
import com.tencent.av.business.manager.report.VideoNodeManager;
import com.tencent.av.ui.ScreenRecordHelper;
import com.tencent.av.utils.AudioHelper;
import com.tencent.av.wtogether.media.WatchTogetherMediaPlayCtrl;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;

class BaseSmallScreenService$OnOpChangedRunnable
  implements Runnable
{
  BaseSmallScreenService$OnOpChangedRunnable(BaseSmallScreenService paramBaseSmallScreenService) {}
  
  public void run()
  {
    if (!this.this$0.d)
    {
      Object localObject = VideoController.a().b();
      boolean bool2 = false;
      int i;
      if ((localObject != null) && (((WatchTogetherMediaPlayCtrl)localObject).h())) {
        i = 1;
      } else {
        i = 0;
      }
      int j;
      if ((Build.VERSION.SDK_INT >= 21) && (VideoController.a().a().c())) {
        j = 1;
      } else {
        j = 0;
      }
      boolean bool1 = bool2;
      if (SmallScreenUtils.c(((AppInterface)BaseSmallScreenService.a(this.this$0)).getApp()))
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
        localObject = this.this$0;
        ((BaseSmallScreenService)localObject).e = bool1;
        ((BaseSmallScreenService)localObject).c();
      }
      bool1 = SmallScreenUtils.i();
      if (bool1 != this.this$0.b)
      {
        localObject = this.this$0;
        ((BaseSmallScreenService)localObject).b = bool1;
        ((BaseSmallScreenService)localObject).b();
      }
      bool1 = SmallScreenUtils.b(((AppInterface)BaseSmallScreenService.b(this.this$0)).getApp());
      if (bool1 != this.this$0.c)
      {
        localObject = this.this$0;
        ((BaseSmallScreenService)localObject).c = bool1;
        ((BaseSmallScreenService)localObject).a();
      }
      bool1 = this.this$0.a();
      if (bool1 != this.this$0.f)
      {
        long l = AudioHelper.b();
        if (QLog.isDevelopLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("OnOpChangedRunnable, AppOnForegroundChanged, seq[");
          ((StringBuilder)localObject).append(l);
          ((StringBuilder)localObject).append("]");
          QLog.w("BaseSmallScreenService", 1, ((StringBuilder)localObject).toString());
        }
        localObject = this.this$0;
        ((BaseSmallScreenService)localObject).f = bool1;
        ((BaseSmallScreenService)localObject).a(l);
        if (bool1) {
          l = 1L;
        } else {
          l = 2L;
        }
        VideoNodeManager.a(20, l);
      }
      this.this$0.a().postDelayed(this, 1000L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.av.smallscreen.BaseSmallScreenService.OnOpChangedRunnable
 * JD-Core Version:    0.7.0.1
 */