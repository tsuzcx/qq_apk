package com.tencent.av.ui;

import android.view.View;
import anni;
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
      AudioHelper.a(anni.a(2131714791));
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
      localObject = ((AVActivity)localObject).findViewById(2131373385);
    } while ((localObject != null) && (((View)localObject).getVisibility() == 0));
    this.this$0.e(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.ui.VideoControlUI.4
 * JD-Core Version:    0.7.0.1
 */