package com.tencent.ad.tangram.device;

import android.content.Context;
import com.tencent.ad.tangram.protocol.gdt_settings.Settings;
import com.tencent.ad.tangram.protocol.gdt_settings.Settings.SettingsForRelationTarget;
import java.lang.ref.WeakReference;

class AdDeviceInfo$1
  implements Runnable
{
  AdDeviceInfo$1(AdDeviceInfo paramAdDeviceInfo, WeakReference paramWeakReference, gdt_settings.Settings paramSettings) {}
  
  public void run()
  {
    AdDeviceInfo.access$100(this.this$0, AdDeviceInfo.access$000((Context)this.val$appContext.get(), this.val$settings.settingsForRelationTarget.packageNameList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.ad.tangram.device.AdDeviceInfo.1
 * JD-Core Version:    0.7.0.1
 */