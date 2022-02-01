package com.tencent.biz.pubaccount.util.api.impl;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.FontSettingManager;

class PublicAccountH5AbilityPluginImpl$7$2$1
  implements DialogInterface.OnClickListener
{
  PublicAccountH5AbilityPluginImpl$7$2$1(PublicAccountH5AbilityPluginImpl.7.2 param2) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    FontSettingManager.killProcess();
    this.a.a.this$0.activity.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.api.impl.PublicAccountH5AbilityPluginImpl.7.2.1
 * JD-Core Version:    0.7.0.1
 */