package com.tencent.biz.webviewplugin;

import android.widget.LinearLayout;
import android.widget.ProgressBar;
import java.util.HashMap;

class OfflinePlugin$9
  implements Runnable
{
  OfflinePlugin$9(OfflinePlugin paramOfflinePlugin) {}
  
  public void run()
  {
    if (OfflinePlugin.e != null)
    {
      OfflineUpdateStatus localOfflineUpdateStatus = (OfflineUpdateStatus)OfflinePlugin.e.get(OfflinePlugin.a(this.this$0));
      if ((localOfflineUpdateStatus != null) && (localOfflineUpdateStatus.c() == 1))
      {
        if (this.this$0.b != null) {
          this.this$0.b.setVisibility(8);
        }
        if (this.this$0.d != null) {
          this.this$0.d.setVisibility(0);
        }
        localOfflineUpdateStatus.a(2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.OfflinePlugin.9
 * JD-Core Version:    0.7.0.1
 */