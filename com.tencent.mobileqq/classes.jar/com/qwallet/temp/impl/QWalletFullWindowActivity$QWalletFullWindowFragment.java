package com.qwallet.temp.impl;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.os.Bundle;
import com.tencent.mobileqq.activity.QQTranslucentBrowserActivity.QQTranslucentBrowserFragment;
import com.tencent.mobileqq.webview.swift.utils.WebViewKernelCallBack;
import com.tencent.qphone.base.util.BaseApplication;
import mqq.app.MobileQQ;

public class QWalletFullWindowActivity$QWalletFullWindowFragment
  extends QQTranslucentBrowserActivity.QQTranslucentBrowserFragment
{
  BroadcastReceiver a = new QWalletFullWindowActivity.QWalletFullWindowFragment.1(this);
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.a != null) {
      try
      {
        MobileQQ.getContext().unregisterReceiver(this.a);
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public void onFinalState(Bundle paramBundle, WebViewKernelCallBack paramWebViewKernelCallBack)
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("action_close_camera");
    localIntentFilter.addAction("cn.abel.action.broadcast");
    MobileQQ.getContext().registerReceiver(this.a, localIntentFilter);
    super.onFinalState(paramBundle, paramWebViewKernelCallBack);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.qwallet.temp.impl.QWalletFullWindowActivity.QWalletFullWindowFragment
 * JD-Core Version:    0.7.0.1
 */