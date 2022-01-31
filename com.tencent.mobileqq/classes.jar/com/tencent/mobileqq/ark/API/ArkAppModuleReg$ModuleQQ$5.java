package com.tencent.mobileqq.ark.API;

import alpe;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import aqbe;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;

public class ArkAppModuleReg$ModuleQQ$5
  implements Runnable
{
  public ArkAppModuleReg$ModuleQQ$5(alpe paramalpe, String paramString) {}
  
  public void run()
  {
    BaseActivity localBaseActivity = BaseActivity.sTopActivity;
    if ((localBaseActivity instanceof FragmentActivity))
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("forward_text", this.a);
      Intent localIntent = new Intent();
      localIntent.putExtras(localBundle);
      localIntent.putExtra("direct_send_if_dataline_forward", true);
      aqbe.a(localBaseActivity, localIntent, 21);
      if (QLog.isColorLevel()) {
        QLog.i("ArkApp", 1, "multiAio.QQ.SendMessage text success.");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppModuleReg.ModuleQQ.5
 * JD-Core Version:    0.7.0.1
 */