package com.tencent.ad.tangram.preorder;

import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.protocol.gdt_settings.Settings;
import com.tencent.ad.tangram.protocol.gdt_settings.Settings.SettingsForAppPreOrder;
import com.tencent.ad.tangram.settings.AdSettingsManager;
import com.tencent.ad.tangram.thread.AdThreadManager;

class AdAppPreOrderManager$10$2
  implements Runnable
{
  AdAppPreOrderManager$10$2(AdAppPreOrderManager.10 param10) {}
  
  public void run()
  {
    AdLog.i("AdAppPreOrderManager", "onBackground");
    AdAppPreOrderManager.access$102(this.this$1.this$0, System.currentTimeMillis());
    gdt_settings.Settings localSettings = AdSettingsManager.INSTANCE.getCache();
    long l;
    if (localSettings != null) {
      l = localSettings.settingsForAppPreOrder.delayMillisAfterBackground;
    } else {
      l = 20000L;
    }
    if (!AdAppPreOrderManager.access$200(this.this$1.this$0))
    {
      AdThreadManager.INSTANCE.postDelayed(new AdAppPreOrderManager.10.2.1(this, l), 5, l);
      return;
    }
    this.this$1.this$0.runTasks();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.preorder.AdAppPreOrderManager.10.2
 * JD-Core Version:    0.7.0.1
 */