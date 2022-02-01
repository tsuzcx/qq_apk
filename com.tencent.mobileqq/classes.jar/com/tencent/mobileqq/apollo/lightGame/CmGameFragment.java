package com.tencent.mobileqq.apollo.lightGame;

import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import arph;
import arui;
import bkgm;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.qphone.base.util.QLog;

public class CmGameFragment
  extends WebViewFragment
  implements Handler.Callback
{
  private Bundle jdField_a_of_type_AndroidOsBundle;
  private bkgm jdField_a_of_type_Bkgm = new bkgm(Looper.getMainLooper(), this);
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CmGameConn_CmGameFragment", 2, new Object[] { "[sendStatus] isAlive=", Boolean.valueOf(paramBoolean1), ", wakeup=", Boolean.valueOf(paramBoolean2) });
    }
    if (paramBoolean1) {
      this.b = true;
    }
    this.jdField_a_of_type_AndroidOsBundle.clear();
    this.jdField_a_of_type_AndroidOsBundle.putBoolean("isAlive", paramBoolean1);
    this.jdField_a_of_type_AndroidOsBundle.putBoolean("wakeup", paramBoolean2);
    Bundle localBundle = arph.a("ipc_cm_game_match_page_report_status", "", 0, this.jdField_a_of_type_AndroidOsBundle);
    arui.a().b(localBundle);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    Message localMessage;
    switch (paramMessage.what)
    {
    default: 
    case 16: 
      do
      {
        return false;
        if (QLog.isColorLevel()) {
          QLog.d("CmGameConn_CmGameFragment", 2, new Object[] { "[handleMessage] check service, mIsDestroy=", Boolean.valueOf(this.jdField_a_of_type_Boolean) });
        }
      } while (this.jdField_a_of_type_Boolean);
      if (!arui.a().a())
      {
        if (QLog.isColorLevel()) {
          QLog.d("CmGameConn_CmGameFragment", 2, "[handleMessage] service not binded");
        }
        this.jdField_a_of_type_Bkgm.sendEmptyMessageDelayed(16, 100L);
        return false;
      }
      if (QLog.isColorLevel()) {
        QLog.d("CmGameConn_CmGameFragment", 2, "[handleMessage] service binded");
      }
      this.jdField_a_of_type_Bkgm.removeMessages(32);
      localMessage = this.jdField_a_of_type_Bkgm.obtainMessage(32);
      localMessage.obj = Boolean.valueOf(true);
      paramMessage.arg1 = 1;
      this.jdField_a_of_type_Bkgm.sendMessage(localMessage);
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("CmGameConn_CmGameFragment", 2, new Object[] { "[handleMessage] MSG_REPORT_STATUS, isAlive=", paramMessage.obj, ", wakeup=", Integer.valueOf(paramMessage.arg1) });
    }
    boolean bool2 = ((Boolean)paramMessage.obj).booleanValue();
    if (paramMessage.arg1 == 1) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      a(bool2, bool1);
      if (!bool2) {
        break;
      }
      this.jdField_a_of_type_Bkgm.removeMessages(32);
      localMessage = this.jdField_a_of_type_Bkgm.obtainMessage(32);
      localMessage.obj = Boolean.valueOf(true);
      paramMessage.arg1 = 0;
      this.jdField_a_of_type_Bkgm.sendMessageDelayed(localMessage, 120000L);
      return false;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (QLog.isColorLevel()) {
      QLog.d("CmGameConn_CmGameFragment", 2, "[onCreate]");
    }
    this.jdField_a_of_type_AndroidOsBundle = new Bundle();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (QLog.isColorLevel()) {
      QLog.d("CmGameConn_CmGameFragment", 2, "[onDestroy]");
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Bkgm.removeMessages(16);
    if (this.b)
    {
      this.jdField_a_of_type_Bkgm.removeMessages(32);
      Message localMessage = this.jdField_a_of_type_Bkgm.obtainMessage(32);
      localMessage.obj = Boolean.valueOf(false);
      this.jdField_a_of_type_Bkgm.sendMessage(localMessage);
    }
  }
  
  public void onPause()
  {
    super.onPause();
    if (QLog.isColorLevel()) {
      QLog.d("CmGameConn_CmGameFragment", 2, "[onPause]");
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (QLog.isColorLevel()) {
      QLog.d("CmGameConn_CmGameFragment", 2, "[onResume]");
    }
    try
    {
      if (!arui.a().a())
      {
        QLog.w("CmGameConn_CmGameFragment", 1, "[onResume] ipc not binded");
        this.jdField_a_of_type_Bkgm.sendEmptyMessage(16);
        return;
      }
      QLog.d("CmGameConn_CmGameFragment", 2, "[onResume] ipc binded");
      this.jdField_a_of_type_Bkgm.removeMessages(32);
      Message localMessage = this.jdField_a_of_type_Bkgm.obtainMessage(32);
      localMessage.obj = Boolean.valueOf(true);
      localMessage.arg1 = 1;
      this.jdField_a_of_type_Bkgm.sendMessage(localMessage);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("CmGameConn_CmGameFragment", 1, "[onResume] exception=", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.lightGame.CmGameFragment
 * JD-Core Version:    0.7.0.1
 */