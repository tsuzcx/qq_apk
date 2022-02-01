package com.tencent.avgame.ipc;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import ngm;

public class AccountReceiver
  extends BroadcastReceiver
{
  private String jdField_a_of_type_JavaLangString;
  private ngm jdField_a_of_type_Ngm;
  
  public AccountReceiver(ngm paramngm, String paramString)
  {
    this.jdField_a_of_type_Ngm = paramngm;
    this.jdField_a_of_type_JavaLangString = ("mqq.intent.action.EXIT_" + paramString);
    QLog.i("AccountReceiver", 1, "AccountReceiver, packageName[" + paramString + "]");
  }
  
  public String[] a()
  {
    return new String[] { "mqq.intent.action.ACCOUNT_KICKED", "mqq.intent.action.ACCOUNT_EXPIRED", "mqq.intent.action.LOGOUT", this.jdField_a_of_type_JavaLangString, "mqq.intent.action.ACCOUNT_CHANGED" };
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null)
    {
      paramContext = null;
      if (!TextUtils.isEmpty(paramContext)) {
        break label22;
      }
    }
    label22:
    label110:
    do
    {
      do
      {
        return;
        paramContext = paramIntent.getAction();
        break;
        if (QLog.isColorLevel()) {
          QLog.i("AccountReceiver", 2, "onReceive, mAction[" + paramContext + "]");
        }
        try
        {
          if (!"mqq.intent.action.ACCOUNT_KICKED".equals(paramContext)) {
            break label110;
          }
          if (this.jdField_a_of_type_Ngm != null) {
            this.jdField_a_of_type_Ngm.b(1001);
          }
          Process.killProcess(Process.myPid());
          return;
        }
        catch (RuntimeException paramContext) {}
      } while (!QLog.isColorLevel());
      QLog.e("AccountReceiver", 2, "RuntimeException", paramContext);
      return;
      if ("mqq.intent.action.ACCOUNT_EXPIRED".equals(paramContext))
      {
        if (this.jdField_a_of_type_Ngm != null) {
          this.jdField_a_of_type_Ngm.b(1003);
        }
        Process.killProcess(Process.myPid());
        return;
      }
      if ("mqq.intent.action.LOGOUT".equals(paramContext))
      {
        if (this.jdField_a_of_type_Ngm != null) {
          this.jdField_a_of_type_Ngm.b(1002);
        }
        Process.killProcess(Process.myPid());
        return;
      }
      if (TextUtils.equals(this.jdField_a_of_type_JavaLangString, paramContext))
      {
        if (this.jdField_a_of_type_Ngm != null) {
          this.jdField_a_of_type_Ngm.b(1005);
        }
        Process.killProcess(Process.myPid());
        return;
      }
    } while (!"mqq.intent.action.ACCOUNT_CHANGED".equals(paramContext));
    if (this.jdField_a_of_type_Ngm != null) {
      this.jdField_a_of_type_Ngm.b(1004);
    }
    Process.killProcess(Process.myPid());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.ipc.AccountReceiver
 * JD-Core Version:    0.7.0.1
 */