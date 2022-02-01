package com.tencent.av.config.api.impl;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class ConfigManagerImpl$1
  extends BroadcastReceiver
{
  ConfigManagerImpl$1(ConfigManagerImpl paramConfigManagerImpl) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramIntent = paramIntent.getAction();
    if (paramIntent.equals("com.tencent.av.ui.ConfigTipsConstant.ACTION_IS_WRITE_CONFIG_INFO_TO_FILE"))
    {
      this.a.reload(paramContext);
      return;
    }
    if (paramIntent.equals("com.tencent.av.ui.ConfigTipsConstant.ACTION_IS_GETTED_SHARP_CONFIG_PAYLOAD")) {
      this.a.reload(paramContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.config.api.impl.ConfigManagerImpl.1
 * JD-Core Version:    0.7.0.1
 */