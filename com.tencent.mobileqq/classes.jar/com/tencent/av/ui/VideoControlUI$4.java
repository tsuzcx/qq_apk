package com.tencent.av.ui;

import android.view.View;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.wtogether.callback.WatchTogetherUIProxy;
import com.tencent.av.wtogether.media.WatchTogetherMediaPlayCtrl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;

class VideoControlUI$4
  implements Runnable
{
  VideoControlUI$4(VideoControlUI paramVideoControlUI) {}
  
  public void run()
  {
    if (this.this$0.h)
    {
      if (QLog.isDevelopLevel()) {
        QLog.w(this.this$0.d, 1, "HideToolbarRunnable");
      }
      if (AudioHelper.a(1) != 1) {
        break label46;
      }
      AudioHelper.a(HardCodeUtil.a(2131715948));
    }
    label46:
    Object localObject1;
    do
    {
      return;
      localObject1 = this.this$0.a();
      if (localObject1 == null) {
        break;
      }
      localObject2 = ((AVActivity)localObject1).findViewById(2131373952);
    } while ((localObject2 != null) && (((View)localObject2).getVisibility() == 0));
    Object localObject2 = this.this$0.a.a();
    if ((((SessionInfo)localObject2).A()) && (this.this$0.a.r()))
    {
      WatchTogetherMediaPlayCtrl localWatchTogetherMediaPlayCtrl = this.this$0.a.a();
      if (localWatchTogetherMediaPlayCtrl != null)
      {
        localObject1 = ((AVActivity)localObject1).a(localWatchTogetherMediaPlayCtrl.i());
        ((SessionInfo)localObject2).c(this.this$0.h);
        ((WatchTogetherUIProxy)localObject1).setImmersiveStatus(this.this$0.h);
      }
    }
    this.this$0.e(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.ui.VideoControlUI.4
 * JD-Core Version:    0.7.0.1
 */