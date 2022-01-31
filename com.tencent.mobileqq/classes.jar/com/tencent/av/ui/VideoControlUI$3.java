package com.tencent.av.ui;

import ajya;
import android.view.View;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;

class VideoControlUI$3
  implements Runnable
{
  VideoControlUI$3(VideoControlUI paramVideoControlUI) {}
  
  public void run()
  {
    if (this.this$0.h)
    {
      if (QLog.isDevelopLevel()) {
        QLog.w(this.this$0.c, 1, "HideToolbarRunnable");
      }
      if (AudioHelper.a(1) != 1) {
        break label46;
      }
      AudioHelper.a(ajya.a(2131716130));
    }
    label46:
    Object localObject;
    do
    {
      return;
      localObject = this.this$0.a();
      if (localObject == null) {
        break;
      }
      localObject = ((AVActivity)localObject).findViewById(2131372388);
    } while ((localObject != null) && (((View)localObject).getVisibility() == 0));
    this.this$0.e(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.av.ui.VideoControlUI.3
 * JD-Core Version:    0.7.0.1
 */