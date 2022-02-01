package com.qwallet.temp.impl;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.app.QBaseActivity;

class QWalletFullWindowActivity$QWalletFullWindowFragment$1
  extends BroadcastReceiver
{
  QWalletFullWindowActivity$QWalletFullWindowFragment$1(QWalletFullWindowActivity.QWalletFullWindowFragment paramQWalletFullWindowFragment) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null) {
      return;
    }
    if ("action_close_camera".equals(paramIntent.getAction()))
    {
      QWalletFullWindowActivity.QWalletFullWindowFragment.a(this.a).finish();
      return;
    }
    if (("cn.abel.action.broadcast".equals(paramIntent.getAction())) && (!paramIntent.getBooleanExtra("isOpen", false))) {
      QWalletFullWindowActivity.QWalletFullWindowFragment.b(this.a).finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.qwallet.temp.impl.QWalletFullWindowActivity.QWalletFullWindowFragment.1
 * JD-Core Version:    0.7.0.1
 */