package com.tencent.biz.qqcircle.activity;

import Override;
import aaak;
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
import com.tencent.biz.qqcircle.launchbean.QCircleFolderBean;
import com.tencent.biz.qqcircle.picload.QCircleFeedPicLoader;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import uyn;
import uys;
import uzg;
import uzi;
import vlc;
import vtt;
import vtw;
import vup;
import vwh;

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
      vtt.a().d(36);
    }
    while (300002 != paramInt1) {
      return;
    }
    aaak.a().a(new QCircleAtUpdateEvent(paramIntent));
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    QLog.d("QCircleFolderActivity", 1, "QCircleFolderActivity->doOnCreate");
    if (paramBundle != null) {
      paramBundle.remove("android:support:fragments");
    }
    uyn.c();
    this.mNeedStatusTrans = false;
    this.mActNeedImmersive = false;
    super.doOnCreate(paramBundle);
    uzg.a(this);
    getWindow().setSoftInputMode(32);
    setContentView(2131560727);
    QCircleBaseTabFragment.a();
    this.a = new QCircleFolderActivityFragment();
    getSupportFragmentManager().beginTransaction().add(2131373950, this.a).commit();
    this.mFlingHandler = new uzi(this);
    vtt.a().a(0);
    vwh.a().a();
    vlc.a().a(5, null, null);
    return true;
  }
  
  public void doOnDestroy()
  {
    QLog.d("QCircleFolderActivity", 1, "QCircleFolderActivity->doOnDestroy");
    super.doOnDestroy();
    uyn.d();
    vtt.a().b(0);
    uys.a();
    vtw.a().a();
    VSNetworkHelper.a().a(this);
    vup.h();
    uyn.a(false);
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
    getIntent().putExtra("key_bundle_common_init_bean", getIntent().getSerializableExtra("key_bundle_common_init_bean"));
  }
  
  public void doOnResume()
  {
    boolean bool1 = true;
    QLog.d("QCircleFolderActivity", 1, "QCircleFolderActivity->doOnResume");
    super.doOnResume();
    QCircleFolderBean localQCircleFolderBean = (QCircleFolderBean)getIntent().getSerializableExtra("key_bundle_common_init_bean");
    boolean bool2 = localQCircleFolderBean.isPublish();
    StringBuilder localStringBuilder = new StringBuilder().append("doOnResume isWrite?").append(bool2).append(", mQCircleFragment?");
    if (this.a != null) {}
    for (;;)
    {
      QLog.d("QCircleFolderActivity", 4, bool1);
      if ((bool2) && (this.a != null))
      {
        this.a.a();
        localQCircleFolderBean.setPublish(false);
      }
      return;
      bool1 = false;
    }
  }
  
  public void doOnSaveInstanceState(Bundle paramBundle)
  {
    super.doOnSaveInstanceState(paramBundle);
    paramBundle.putSerializable("key_bundle_common_init_bean", getIntent().getSerializableExtra("key_bundle_common_init_bean"));
  }
  
  public void doOnStop()
  {
    QLog.d("QCircleFolderActivity", 1, "QCircleFolderActivity->doOnStop");
    super.doOnStop();
  }
  
  public boolean onBackEvent()
  {
    QLog.d("QCircleFolderActivity", 1, "QCircleFolderActivity->onBackEvent");
    vlc.a().a(6, null, null);
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