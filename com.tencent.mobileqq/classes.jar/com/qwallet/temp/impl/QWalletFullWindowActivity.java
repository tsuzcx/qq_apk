package com.qwallet.temp.impl;

import android.content.Intent;
import com.tencent.mobileqq.activity.QQTranslucentBrowserActivity;
import com.tencent.mobileqq.qroute.route.annotation.RoutePage;

@RoutePage(desc="QQ支付-sdk全屏弹层", path="/qwallet/tenpay/full")
public class QWalletFullWindowActivity
  extends QQTranslucentBrowserActivity
{
  public static final String ACTION_CLOSE_CAMERA = "action_close_camera";
  public static final String ACTION_ONPAUSE = "action_onpause";
  public static final String ACTION_ONRESUME = "action_onresume";
  
  public QWalletFullWindowActivity()
  {
    this.mFragmentClass = QWalletFullWindowActivity.QWalletFullWindowFragment.class;
  }
  
  public void doOnBackPressed()
  {
    sendBroadcast(new Intent("action_close_camera"));
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    sendBroadcast(new Intent("action_onpause"));
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    sendBroadcast(new Intent("action_onresume"));
  }
  
  public boolean showPreview()
  {
    return super.showPreview();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.qwallet.temp.impl.QWalletFullWindowActivity
 * JD-Core Version:    0.7.0.1
 */