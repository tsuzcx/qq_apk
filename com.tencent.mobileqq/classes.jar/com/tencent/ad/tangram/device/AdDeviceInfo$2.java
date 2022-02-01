package com.tencent.ad.tangram.device;

import android.content.Context;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.settings.AdSettingsUtil.a;
import java.lang.ref.WeakReference;

class AdDeviceInfo$2
  implements AdSettingsUtil.a
{
  AdDeviceInfo$2(AdDeviceInfo paramAdDeviceInfo) {}
  
  public void onUpdated(WeakReference<Context> paramWeakReference, boolean paramBoolean)
  {
    AdLog.i("AdDeviceInfo", String.format("onUpdated %b", new Object[] { Boolean.valueOf(paramBoolean) }));
    if (!paramBoolean) {
      return;
    }
    AdDeviceInfo.access$200(this.this$0, paramWeakReference);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.ad.tangram.device.AdDeviceInfo.2
 * JD-Core Version:    0.7.0.1
 */