package com.tencent.av.screenshare.floatingwindow;

import android.os.Handler;
import com.tencent.qphone.base.util.QLog;
import lyo;

public class ScreenShareFloatingWindowService$FloatingWindowPermissionCheckRunnable
  implements Runnable
{
  public ScreenShareFloatingWindowService$FloatingWindowPermissionCheckRunnable(ScreenShareFloatingWindowService paramScreenShareFloatingWindowService) {}
  
  public void run()
  {
    if (this.this$0.b)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ScreenShareFloatingWindowService", 2, "ScreenShareFloatingWindowService has destory ");
      }
      return;
    }
    boolean bool = lyo.b(this.this$0);
    if (bool != ScreenShareFloatingWindowService.a(this.this$0))
    {
      ScreenShareFloatingWindowService.a(this.this$0, bool);
      ScreenShareFloatingWindowService.a(this.this$0);
    }
    this.this$0.a().postDelayed(this, 1000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.screenshare.floatingwindow.ScreenShareFloatingWindowService.FloatingWindowPermissionCheckRunnable
 * JD-Core Version:    0.7.0.1
 */