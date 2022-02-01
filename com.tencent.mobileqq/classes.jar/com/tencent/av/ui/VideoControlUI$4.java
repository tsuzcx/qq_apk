package com.tencent.av.ui;

import android.view.View;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.utils.AudioHelper;
import com.tencent.av.wtogether.callback.WatchTogetherUIProxy;
import com.tencent.av.wtogether.media.WatchTogetherMediaPlayCtrl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.qphone.base.util.QLog;

class VideoControlUI$4
  implements Runnable
{
  VideoControlUI$4(VideoControlUI paramVideoControlUI) {}
  
  public void run()
  {
    if (this.this$0.af)
    {
      if (QLog.isDevelopLevel()) {
        QLog.w(this.this$0.X, 1, "HideToolbarRunnable");
      }
      if (AudioHelper.a(1) == 1)
      {
        AudioHelper.a(HardCodeUtil.a(2131913328));
        return;
      }
      Object localObject1 = this.this$0.U();
      if (localObject1 != null)
      {
        localObject2 = ((AVActivity)localObject1).findViewById(2131441197);
        if ((localObject2 != null) && (((View)localObject2).getVisibility() == 0)) {
          return;
        }
      }
      Object localObject2 = this.this$0.am.k();
      if ((((SessionInfo)localObject2).r()) && (this.this$0.am.aD()))
      {
        WatchTogetherMediaPlayCtrl localWatchTogetherMediaPlayCtrl = this.this$0.am.aA();
        if (localWatchTogetherMediaPlayCtrl != null)
        {
          localObject1 = ((AVActivity)localObject1).d(localWatchTogetherMediaPlayCtrl.r());
          ((SessionInfo)localObject2).c(this.this$0.af);
          ((WatchTogetherUIProxy)localObject1).setImmersiveStatus(this.this$0.af);
        }
      }
      this.this$0.f(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.VideoControlUI.4
 * JD-Core Version:    0.7.0.1
 */