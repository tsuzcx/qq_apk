package com.tencent.ad.tangram.settings;

import com.tencent.ad.tangram.analysis.AdABTest;
import com.tencent.ad.tangram.analysis.AdUin;
import com.tencent.ad.tangram.protocol.gdt_abtest.ABTest;
import com.tencent.ad.tangram.protocol.gdt_settings.Settings;
import com.tencent.ad.tangram.protocol.gdt_settings.Settings.SettingsForNewHost;

class a$1
  implements Runnable
{
  a$1(a parama) {}
  
  public void run()
  {
    gdt_settings.Settings localSettings = b.load(a.access$000(this.this$0), 8, "https://i.gtimg.cn/ams-web/public/tangram-report/settings-android-qq-8-8-17.json");
    if (localSettings != null)
    {
      String str = AdUin.INSTANCE.getUIN();
      gdt_abtest.ABTest localABTest;
      if (localSettings != null) {
        localABTest = localSettings.settingsForNewHost.abTest;
      } else {
        localABTest = null;
      }
      if (AdABTest.isABTestByUIN(str, localABTest)) {
        b.load(a.access$000(this.this$0), 9, "https://public.gdtimg.com/ams-web/public/tangram-report/settings-android-qq-8-8-17.json");
      }
    }
    if (a.access$100(this.this$0, localSettings)) {
      a.access$300(a.access$000(this.this$0), a.access$200(this.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.settings.a.1
 * JD-Core Version:    0.7.0.1
 */