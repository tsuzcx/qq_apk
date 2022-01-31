package com.tencent.mobileqq.activity;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import cooperation.qzone.thread.BaseHandler;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.webviewplugin.QzonePersonalizeJsPlugin;
import tss;
import tst;

public class QzoneTiantaiTranslucentBrowserActivity
  extends QQTranslucentBrowserActivity
{
  private long jdField_a_of_type_Long;
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new tst(this);
  private Runnable jdField_a_of_type_JavaLangRunnable = new tss(this);
  private volatile boolean jdField_a_of_type_Boolean;
  private volatile boolean b;
  private volatile boolean c;
  
  private void a()
  {
    View localView = findViewById(2131362372);
    if (localView == null) {
      return;
    }
    if (!this.jdField_a_of_type_Boolean)
    {
      if (System.currentTimeMillis() - this.jdField_a_of_type_Long < 6000L)
      {
        localView.setAlpha(0.0F);
        this.b = false;
        QZLog.i("QzoneTiantaiTranslucentBrowserActivity", "setAlpha(0)");
        return;
      }
      QZLog.i("QzoneTiantaiTranslucentBrowserActivity", "视频播放超时了，setAlpha(1)");
      a(localView);
      return;
    }
    QZLog.i("QzoneTiantaiTranslucentBrowserActivity", "视频播放完了，setAlpha(1)");
    a(localView);
  }
  
  private void a(View paramView)
  {
    if (!this.b)
    {
      this.b = true;
      QZLog.i("QzoneTiantaiTranslucentBrowserActivity", "setAlpha(1)");
      if (paramView != null) {
        paramView.setAlpha(1.0F);
      }
    }
    for (;;)
    {
      try
      {
        paramView = b().a();
        if (paramView != null)
        {
          Object localObject = paramView.getTag(2131361916);
          if ((localObject == null) || (!((Boolean)localObject).booleanValue())) {
            break label106;
          }
          i = 1;
          paramView.setTag(2131361917, Boolean.TRUE);
          if (i != 0)
          {
            QZLog.i("QzoneTiantaiTranslucentBrowserActivity", "tiantai jsReady true,notify webview.");
            QzonePersonalizeJsPlugin.a(paramView);
            return;
          }
          QZLog.i("QzoneTiantaiTranslucentBrowserActivity", "tiantai jsReady false,not notify webview.");
          return;
        }
      }
      catch (Exception paramView)
      {
        QZLog.e("QzoneTiantaiTranslucentBrowserActivity", "notify webview qzRoofStartAnimation fail.", paramView);
      }
      return;
      label106:
      int i = 0;
    }
  }
  
  private void b()
  {
    if (this.c) {}
    for (;;)
    {
      return;
      try
      {
        QZLog.i("QzoneTiantaiTranslucentBrowserActivity", "registerBroadcast");
        IntentFilter localIntentFilter = new IntentFilter();
        localIntentFilter.addAction("QZONE.ACTION_VIDEO_PLAY_FINISH");
        boolean bool = this.c;
        if (bool) {
          continue;
        }
        try
        {
          registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter, "com.tencent.msg.permission.pushnotify", null);
          this.c = true;
          return;
        }
        catch (Exception localException1)
        {
          QZLog.e("QzoneTiantaiTranslucentBrowserActivity", "regist receiver error:", localException1);
          return;
        }
        return;
      }
      catch (Exception localException2)
      {
        QZLog.e("QzoneTiantaiTranslucentBrowserActivity", "registerBroadcast error", localException2);
      }
    }
  }
  
  private void c()
  {
    try
    {
      if (this.c)
      {
        QZLog.i("QzoneTiantaiTranslucentBrowserActivity", "removeBroadcast");
        try
        {
          unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
          this.c = false;
          return;
        }
        catch (Exception localException1)
        {
          for (;;)
          {
            QZLog.e("QzoneTiantaiTranslucentBrowserActivity", "unregisterReceiver error ", localException1);
          }
        }
      }
      return;
    }
    catch (Exception localException2)
    {
      QZLog.e("QzoneTiantaiTranslucentBrowserActivity", "removeBroadcast error", localException2);
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    boolean bool = super.doOnCreate(paramBundle);
    a();
    return bool;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    c();
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    b();
    new BaseHandler().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 6100L);
    super.onCreate(paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QzoneTiantaiTranslucentBrowserActivity
 * JD-Core Version:    0.7.0.1
 */