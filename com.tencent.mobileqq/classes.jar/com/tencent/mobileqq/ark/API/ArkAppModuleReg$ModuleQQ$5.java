package com.tencent.mobileqq.ark.API;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import anke;
import aryv;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;

public class ArkAppModuleReg$ModuleQQ$5
  implements Runnable
{
  public ArkAppModuleReg$ModuleQQ$5(anke paramanke, String paramString) {}
  
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
      aryv.a(localBaseActivity, localIntent, 21);
      if (QLog.isColorLevel()) {
        QLog.i("ArkApp", 1, "multiAio.QQ.SendMessage text success.");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppModuleReg.ModuleQQ.5
 * JD-Core Version:    0.7.0.1
 */