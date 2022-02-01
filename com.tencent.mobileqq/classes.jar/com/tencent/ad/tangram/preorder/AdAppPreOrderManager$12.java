package com.tencent.ad.tangram.preorder;

import com.tencent.ad.tangram.protocol.gdt_settings.Settings;
import com.tencent.ad.tangram.protocol.gdt_settings.Settings.SettingsForAppPreOrder;
import com.tencent.ad.tangram.settings.AdSettingsManager;
import com.tencent.ad.tangram.thread.AdThreadManager;
import com.tencent.ad.tangram.util.AdLifecycleManager;

class AdAppPreOrderManager$12
  implements Runnable
{
  AdAppPreOrderManager$12(AdAppPreOrderManager paramAdAppPreOrderManager) {}
  
  public void run()
  {
    gdt_settings.Settings localSettings = AdSettingsManager.INSTANCE.getCache();
    long l;
    if (localSettings != null) {
      l = localSettings.settingsForAppPreOrder.delayMillisAfterMessageSynced;
    } else {
      l = 30000L;
    }
    if (!AdAppPreOrderManager.access$600(this.this$0))
    {
      AdAppPreOrderManager.access$602(this.this$0, true);
      AdThreadManager.INSTANCE.postDelayed(new AdAppPreOrderManager.12.1(this), 5, l);
    }
    if (!AdLifecycleManager.INSTANCE.isOnForeground())
    {
      AdAppPreOrderManager.access$102(this.this$0, System.currentTimeMillis());
      if (localSettings != null) {
        l = localSettings.settingsForAppPreOrder.delayMillisAfterBackground;
      } else {
        l = 20000L;
      }
      if (!AdAppPreOrderManager.access$200(this.this$0)) {
        AdThreadManager.INSTANCE.postDelayed(new AdAppPreOrderManager.12.2(this, l), 5, l);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.preorder.AdAppPreOrderManager.12
 * JD-Core Version:    0.7.0.1
 */