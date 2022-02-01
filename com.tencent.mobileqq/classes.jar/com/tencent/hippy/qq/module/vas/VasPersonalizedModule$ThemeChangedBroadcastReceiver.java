package com.tencent.hippy.qq.module.vas;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.vas.api.IVasService;
import com.tencent.mobileqq.vas.manager.api.IThemeSwitchManager;
import com.tencent.mobileqq.vas.util.VasUtil;

class VasPersonalizedModule$ThemeChangedBroadcastReceiver
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    VasUtil.a().getThemeSwitchManager().onPostThemeChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.hippy.qq.module.vas.VasPersonalizedModule.ThemeChangedBroadcastReceiver
 * JD-Core Version:    0.7.0.1
 */