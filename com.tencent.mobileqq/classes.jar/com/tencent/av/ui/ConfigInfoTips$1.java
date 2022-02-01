package com.tencent.av.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.av.report.TraeConfigUpdate;
import com.tencent.avcore.config.ConfigInfo;

class ConfigInfoTips$1
  extends BroadcastReceiver
{
  ConfigInfoTips$1(ConfigInfoTips paramConfigInfoTips) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramIntent = paramIntent.getAction();
    if (paramIntent.equals("com.tencent.av.ui.ConfigTipsConstant.ACTION_IS_WRITE_CONFIG_INFO_TO_FILE"))
    {
      if (!ConfigInfoTips.a(this.a))
      {
        ConfigInfoTips.a(this.a, true);
        if (ConfigInfoTips.b(this.a)) {
          ConfigInfoTips.c(this.a);
        }
      }
      int i = ConfigInfo.getSharpConfigVersionFromFile(paramContext);
      TraeConfigUpdate.a().a("update", i);
      return;
    }
    if ((paramIntent.equals("com.tencent.av.ui.ConfigTipsConstant.ACTION_IS_GETTED_SHARP_CONFIG_PAYLOAD")) && (!ConfigInfoTips.b(this.a)))
    {
      ConfigInfoTips.b(this.a, true);
      if (ConfigInfoTips.a(this.a)) {
        ConfigInfoTips.c(this.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.ConfigInfoTips.1
 * JD-Core Version:    0.7.0.1
 */