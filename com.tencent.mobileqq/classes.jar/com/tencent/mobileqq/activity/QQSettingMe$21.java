package com.tencent.mobileqq.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import bdfk;
import bdvn;
import blvm;
import com.tencent.qphone.base.util.QLog;
import cooperation.ilive.manager.IliveDbManager;
import zqn;

class QQSettingMe$21
  implements Runnable
{
  QQSettingMe$21(QQSettingMe paramQQSettingMe) {}
  
  public void run()
  {
    String str = "";
    Object localObject2 = "";
    Object localObject1;
    if ((blvm.d()) && (!bdvn.a()))
    {
      str = IliveDbManager.getILiveEnterInfo(1);
      localObject1 = localObject2;
      if (!zqn.a())
      {
        localObject1 = localObject2;
        if (!bdfk.a()) {
          localObject1 = IliveDbManager.getILiveEnterInfo(2);
        }
      }
    }
    for (boolean bool = true;; bool = false)
    {
      localObject2 = this.this$0.a.obtainMessage(2);
      Bundle localBundle = new Bundle();
      localBundle.putString("enter_title", str);
      localBundle.putString("enter_icon", (String)localObject1);
      localBundle.putBoolean("is_visible", bool);
      ((Message)localObject2).setData(localBundle);
      this.this$0.a.sendMessage((Message)localObject2);
      if (QLog.isColorLevel()) {
        QLog.d("QQSettingRedesign", 2, "updateShoppingItemView:" + str + "  " + (String)localObject1);
      }
      return;
      localObject1 = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQSettingMe.21
 * JD-Core Version:    0.7.0.1
 */