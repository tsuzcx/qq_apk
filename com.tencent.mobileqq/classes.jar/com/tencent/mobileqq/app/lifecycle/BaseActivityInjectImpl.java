package com.tencent.mobileqq.app.lifecycle;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import com.tencent.mobileqq.activity.GesturePWDUnlockActivity;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.IBaseActivityInjectInterface;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ShakeListener;
import com.tencent.mobileqq.haoliyou.JefsClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.vas.URLInterceptManager;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class BaseActivityInjectImpl
  implements IBaseActivityInjectInterface
{
  public BroadcastReceiver a()
  {
    return new BaseActivityInjectImpl.MyScreenReceiver(null);
  }
  
  public Intent a(QBaseActivity paramQBaseActivity)
  {
    GesturePWDUnlockActivity.sGesturePWDUnlockShowing = true;
    return new Intent(paramQBaseActivity, GesturePWDUnlockActivity.class);
  }
  
  public ShakeListener a()
  {
    return new BaseActivityInjectImpl.MyShakeListener(null);
  }
  
  public void a(QBaseActivity paramQBaseActivity, Intent paramIntent)
  {
    JumpActivity.processIntent(paramIntent);
    JumpActivity.handleIntentForQQBrowser(paramQBaseActivity, paramIntent);
  }
  
  public void a(QBaseActivity paramQBaseActivity, Intent paramIntent, int paramInt)
  {
    JumpActivity.processIntent(paramIntent);
    JumpActivity.handleIntentForQQBrowser(paramQBaseActivity, paramIntent);
  }
  
  public void a(QBaseActivity paramQBaseActivity, Intent paramIntent, Bundle paramBundle)
  {
    JumpActivity.processIntent(paramIntent);
    JumpActivity.handleIntentForQQBrowser(paramQBaseActivity, paramIntent);
  }
  
  public boolean a(QBaseActivity paramQBaseActivity, Intent paramIntent, int paramInt, Bundle paramBundle)
  {
    JumpActivity.processIntent(paramIntent);
    JumpActivity.handleIntentForQQBrowser(paramQBaseActivity, paramIntent);
    Object localObject = paramQBaseActivity.getAppRuntime();
    if ((localObject instanceof QQAppInterface))
    {
      URLInterceptManager localURLInterceptManager = (URLInterceptManager)((AppRuntime)localObject).getManager(QQManagerFactory.URL_INTECEPT_MANAGER);
      if ((localURLInterceptManager != null) && (localURLInterceptManager.a(paramIntent, (QQAppInterface)localObject, paramQBaseActivity))) {
        return true;
      }
    }
    else if ((paramQBaseActivity instanceof QQBrowserActivity))
    {
      localObject = ((QQBrowserActivity)paramQBaseActivity).getCurrentWebViewFragment();
      if ((localObject != null) && (((WebViewFragment)localObject).getAppRuntime() != null) && (((WebViewFragment)localObject).getAppRuntime().getManager(QQManagerFactory.URL_INTECEPT_MANAGER) != null) && (((URLInterceptManager)((WebViewFragment)localObject).getAppRuntime().getManager(QQManagerFactory.URL_INTECEPT_MANAGER)).a(paramIntent, paramQBaseActivity))) {
        return true;
      }
    }
    try
    {
      JefsClass.getInstance().b(paramQBaseActivity, paramIntent, new BaseActivityInjectImpl.1(this, paramQBaseActivity, paramIntent, paramInt, paramBundle));
      return false;
    }
    catch (Throwable paramQBaseActivity)
    {
      QLog.e("qqBaseActivity", 1, paramQBaseActivity, new Object[0]);
    }
    return false;
  }
  
  public boolean a(QBaseActivity paramQBaseActivity, MotionEvent paramMotionEvent)
  {
    ReportController.a(paramMotionEvent);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.lifecycle.BaseActivityInjectImpl
 * JD-Core Version:    0.7.0.1
 */