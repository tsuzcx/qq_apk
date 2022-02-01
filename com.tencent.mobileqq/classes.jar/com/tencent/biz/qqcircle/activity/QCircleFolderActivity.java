package com.tencent.biz.qqcircle.activity;

import Override;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.MotionEvent;
import android.view.Window;
import com.tencent.biz.qqcircle.events.QCircleAtUpdateEvent;
import com.tencent.biz.qqcircle.fragments.QCircleBaseTabFragment;
import com.tencent.biz.qqcircle.fragments.main.QCircleFolderActivityFragment;
import com.tencent.biz.qqcircle.picload.QCircleFeedPicLoader;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import uxc;
import uxh;
import uxx;
import uxz;
import viy;
import vri;
import vrl;
import vsc;
import vtj;
import zwp;

public class QCircleFolderActivity
  extends FragmentActivity
{
  private QCircleFolderActivityFragment a;
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool);
    return bool;
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (300001 == paramInt1)
    {
      QLog.d("QCircleFolderActivity", 1, "doOnActivityResult，return from qzone publish page");
      vri.a().d(36);
    }
    while (300002 != paramInt1) {
      return;
    }
    zwp.a().a(new QCircleAtUpdateEvent(paramIntent));
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    QLog.d("QCircleFolderActivity", 1, "QCircleFolderActivity->doOnCreate");
    if (paramBundle != null) {
      paramBundle.remove("android:support:fragments");
    }
    this.mNeedStatusTrans = false;
    this.mActNeedImmersive = false;
    super.doOnCreate(paramBundle);
    uxx.a(this);
    getWindow().setSoftInputMode(32);
    setContentView(2131560710);
    QCircleBaseTabFragment.a();
    this.a = new QCircleFolderActivityFragment();
    getSupportFragmentManager().beginTransaction().add(2131373820, this.a).commit();
    this.mFlingHandler = new uxz(this);
    vri.a().a(0);
    vtj.a().a();
    viy.a().a(5, null, null);
    return true;
  }
  
  public void doOnDestroy()
  {
    QLog.d("QCircleFolderActivity", 1, "QCircleFolderActivity->doOnDestroy");
    super.doOnDestroy();
    vri.a().b(0);
    uxh.a();
    vrl.a().a();
    VSNetworkHelper.a().a(this);
    vsc.g();
    uxc.b();
    QCircleFeedPicLoader.a().a();
  }
  
  public void doOnNewIntent(Intent paramIntent)
  {
    QLog.d("QCircleFolderActivity", 1, "QCircleFolderActivity->doOnNewIntent");
    super.doOnNewIntent(paramIntent);
    if (this.a != null) {
      this.a.onNewIntent(paramIntent);
    }
    getIntent().putExtras(paramIntent);
  }
  
  public void doOnRestoreInstanceState(Bundle paramBundle)
  {
    super.doOnRestoreInstanceState(paramBundle);
    getIntent().putExtra("key_is_publish", paramBundle.getBoolean("key_is_publish", false));
  }
  
  public void doOnResume()
  {
    boolean bool1 = true;
    QLog.d("QCircleFolderActivity", 1, "QCircleFolderActivity->doOnResume");
    super.doOnResume();
    boolean bool2 = getIntent().getBooleanExtra("key_is_publish", false);
    StringBuilder localStringBuilder = new StringBuilder().append("doOnResume isWrite?").append(bool2).append(", mQCircleFragment?");
    if (this.a != null) {}
    for (;;)
    {
      QLog.d("QCircleFolderActivity", 4, bool1);
      if ((bool2) && (this.a != null))
      {
        this.a.a();
        getIntent().putExtra("key_is_publish", false);
      }
      return;
      bool1 = false;
    }
  }
  
  public void doOnSaveInstanceState(Bundle paramBundle)
  {
    super.doOnSaveInstanceState(paramBundle);
    paramBundle.putBoolean("key_is_publish", getIntent().getBooleanExtra("key_is_publish", false));
  }
  
  public boolean onBackEvent()
  {
    QLog.d("QCircleFolderActivity", 1, "QCircleFolderActivity->onBackEvent");
    viy.a().a(6, null, null);
    if ((this.a != null) && (this.a.onBackEvent())) {
      return true;
    }
    return super.onBackEvent();
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
    super.requestWindowFeature(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.activity.QCircleFolderActivity
 * JD-Core Version:    0.7.0.1
 */