package com.tencent.biz.qqcircle.activity;

import abvb;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Window;
import com.tencent.biz.qqcircle.fragments.QCircleBaseTabFragment;
import com.tencent.biz.qqcircle.fragments.QCircleFolderActivityFragment;
import com.tencent.biz.videostory.network.VSNetworkHelper;
import com.tencent.qphone.base.util.QLog;
import tqc;
import tqg;
import tql;
import tra;
import trc;
import tzy;
import uab;

public class QCircleFolderActivity
  extends FragmentActivity
{
  private QCircleFolderActivityFragment a;
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (300001 == paramInt1)
    {
      QLog.d("QCircleFolderActivity", 1, "doOnActivityResult，return from qzone publish page");
      tzy.a().a(36);
    }
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
    tra.a(this);
    getWindow().setSoftInputMode(32);
    setContentView(2131560548);
    QCircleBaseTabFragment.b();
    this.a = new QCircleFolderActivityFragment();
    getSupportFragmentManager().beginTransaction().add(2131373183, this.a).commit();
    this.mFlingHandler = new trc(this);
    if (tzy.a().b(0)) {
      tzy.a().a(getActivity().getIntent());
    }
    return true;
  }
  
  public void doOnDestroy()
  {
    QLog.d("QCircleFolderActivity", 1, "QCircleFolderActivity->doOnDestroy");
    super.doOnDestroy();
    tzy.a().a(0);
    tql.a();
    uab.a().a();
    abvb.a(this);
    VSNetworkHelper.a().a(this);
    tqc.e();
    tqg.b();
  }
  
  public void doOnNewIntent(Intent paramIntent)
  {
    QLog.d("QCircleFolderActivity", 1, "QCircleFolderActivity->doOnNewIntent");
    super.doOnNewIntent(paramIntent);
    if (this.a != null) {
      this.a.onNewIntent(paramIntent);
    }
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
        this.a.b();
        getIntent().putExtra("key_is_publish", false);
      }
      return;
      bool1 = false;
    }
  }
  
  public boolean onBackEvent()
  {
    QLog.d("QCircleFolderActivity", 1, "QCircleFolderActivity->onBackEvent");
    if ((this.a != null) && (this.a.onBackEvent())) {
      return true;
    }
    return super.onBackEvent();
  }
  
  public void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
    super.requestWindowFeature(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.activity.QCircleFolderActivity
 * JD-Core Version:    0.7.0.1
 */