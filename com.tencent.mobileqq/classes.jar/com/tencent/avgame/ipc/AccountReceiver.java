package com.tencent.avgame.ipc;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

public class AccountReceiver
  extends BroadcastReceiver
{
  private AccountReceiver.AccountListener jdField_a_of_type_ComTencentAvgameIpcAccountReceiver$AccountListener;
  private String jdField_a_of_type_JavaLangString;
  
  public AccountReceiver(AccountReceiver.AccountListener paramAccountListener, String paramString)
  {
    this.jdField_a_of_type_ComTencentAvgameIpcAccountReceiver$AccountListener = paramAccountListener;
    paramAccountListener = new StringBuilder();
    paramAccountListener.append("mqq.intent.action.EXIT_");
    paramAccountListener.append(paramString);
    this.jdField_a_of_type_JavaLangString = paramAccountListener.toString();
    paramAccountListener = new StringBuilder();
    paramAccountListener.append("AccountReceiver, packageName[");
    paramAccountListener.append(paramString);
    paramAccountListener.append("]");
    QLog.i("AccountReceiver", 1, paramAccountListener.toString());
  }
  
  public String[] a()
  {
    return new String[] { "mqq.intent.action.ACCOUNT_KICKED", "mqq.intent.action.ACCOUNT_EXPIRED", "mqq.intent.action.LOGOUT", this.jdField_a_of_type_JavaLangString, "mqq.intent.action.ACCOUNT_CHANGED" };
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null) {
      paramContext = null;
    } else {
      paramContext = paramIntent.getAction();
    }
    if (TextUtils.isEmpty(paramContext)) {
      return;
    }
    if (QLog.isColorLevel())
    {
      paramIntent = new StringBuilder();
      paramIntent.append("onReceive, mAction[");
      paramIntent.append(paramContext);
      paramIntent.append("]");
      QLog.i("AccountReceiver", 2, paramIntent.toString());
    }
    try
    {
      if ("mqq.intent.action.ACCOUNT_KICKED".equals(paramContext))
      {
        if (this.jdField_a_of_type_ComTencentAvgameIpcAccountReceiver$AccountListener != null) {
          this.jdField_a_of_type_ComTencentAvgameIpcAccountReceiver$AccountListener.b(1001);
        }
        Process.killProcess(Process.myPid());
        return;
      }
      if ("mqq.intent.action.ACCOUNT_EXPIRED".equals(paramContext))
      {
        if (this.jdField_a_of_type_ComTencentAvgameIpcAccountReceiver$AccountListener != null) {
          this.jdField_a_of_type_ComTencentAvgameIpcAccountReceiver$AccountListener.b(1003);
        }
        Process.killProcess(Process.myPid());
        return;
      }
      if ("mqq.intent.action.LOGOUT".equals(paramContext))
      {
        if (this.jdField_a_of_type_ComTencentAvgameIpcAccountReceiver$AccountListener != null) {
          this.jdField_a_of_type_ComTencentAvgameIpcAccountReceiver$AccountListener.b(1002);
        }
        Process.killProcess(Process.myPid());
        return;
      }
      if (TextUtils.equals(this.jdField_a_of_type_JavaLangString, paramContext))
      {
        if (this.jdField_a_of_type_ComTencentAvgameIpcAccountReceiver$AccountListener != null) {
          this.jdField_a_of_type_ComTencentAvgameIpcAccountReceiver$AccountListener.b(1005);
        }
        Process.killProcess(Process.myPid());
        return;
      }
      if ("mqq.intent.action.ACCOUNT_CHANGED".equals(paramContext))
      {
        if (this.jdField_a_of_type_ComTencentAvgameIpcAccountReceiver$AccountListener != null) {
          this.jdField_a_of_type_ComTencentAvgameIpcAccountReceiver$AccountListener.b(1004);
        }
        Process.killProcess(Process.myPid());
        return;
      }
    }
    catch (RuntimeException paramContext)
    {
      if (QLog.isColorLevel()) {
        QLog.e("AccountReceiver", 2, "RuntimeException", paramContext);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.ipc.AccountReceiver
 * JD-Core Version:    0.7.0.1
 */