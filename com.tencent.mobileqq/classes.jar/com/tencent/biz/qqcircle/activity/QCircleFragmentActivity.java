package com.tencent.biz.qqcircle.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import androidx.annotation.Nullable;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.fragments.QCircleBaseFragment;
import com.tencent.biz.qqcircle.richframework.compat.QCircleBaseActivity;
import com.tencent.biz.richframework.compat.CompatPublicFragment;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.mobileqq.auto.engine.lib.ASInject;
import com.tencent.mobileqq.auto.engine.lib.IASEngineDelegate;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.report.QCircleReportHelper;
import cooperation.qqcircle.report.QCircleReporter;

public class QCircleFragmentActivity
  extends QCircleBaseActivity
{
  public static final int a = 2131952237;
  
  private void a()
  {
    QLog.d("QCircleFragmentActivity", 1, "startActivityCheck for activity onCreate");
    d().postDelayed(new QCircleFragmentActivity.1(this), 5000L);
  }
  
  private void i()
  {
    ASInject.g().getAsEngineDelegate().setForceNative("qcircle-app", true);
    Object localObject1 = getIntent();
    if (localObject1 != null)
    {
      if (!((Intent)localObject1).hasExtra("key_bundle_common_init_bean")) {
        return;
      }
      Object localObject2 = ((Intent)localObject1).getSerializableExtra("key_bundle_common_init_bean");
      if (!(localObject2 instanceof QCircleInitBean)) {
        return;
      }
      localObject1 = ASInject.g().getAsEngineDelegate();
      localObject2 = (QCircleInitBean)localObject2;
      ((IASEngineDelegate)localObject1).enter("qcircle-app", ((QCircleInitBean)localObject2).getAction(), ((QCircleInitBean)localObject2).getSchemeAttrs(), ((QCircleInitBean)localObject2).getSchemeBytes());
      QLog.d("QCircleFragmentActivity", 1, "startActivityCheck for activity trans to native");
    }
  }
  
  private boolean j()
  {
    Intent localIntent = getIntent();
    if (localIntent == null) {
      return false;
    }
    return localIntent.getBooleanExtra("param_skip_activity_empty_check", false);
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (256 == paramInt1)
    {
      QLog.d("QCircleFragmentActivity", 1, "onActivityResult，return from qzone publish page");
      QCircleReportHelper.getInstance().recordPageEndShow(36, true);
    }
  }
  
  public void onBackPressed()
  {
    QLog.d("QCircleFragmentActivity", 1, "QCircleFragmentActivity->onBackPressed");
    super.onBackPressed();
    CompatPublicFragment localCompatPublicFragment = g();
    if ((localCompatPublicFragment instanceof QCircleBaseFragment)) {
      ((QCircleBaseFragment)localCompatPublicFragment).m();
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  protected void onCreate(@Nullable Bundle paramBundle)
  {
    QLog.d("QCircleFragmentActivity", 1, "QCircleFragmentActivity->before onCreate");
    a();
    super.onCreate(paramBundle);
    QLog.d("QCircleFragmentActivity", 1, "QCircleFragmentActivity->after onCreate");
  }
  
  protected void onDestroy()
  {
    QLog.d("QCircleFragmentActivity", 1, "QCircleFragmentActivity->onDestroy");
    super.onDestroy();
    VSNetworkHelper.getInstance().cancelRequest(this);
    QCircleReporter.getInstance().flush();
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    QLog.d("QCircleFragmentActivity", 1, "QCircleFragmentActivity->onNewIntent");
  }
  
  protected void onResume()
  {
    QLog.d("QCircleFragmentActivity", 1, "QCircleFragmentActivity->before onResume");
    super.onResume();
    QLog.d("QCircleFragmentActivity", 1, "QCircleFragmentActivity->after onResume");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.activity.QCircleFragmentActivity
 * JD-Core Version:    0.7.0.1
 */