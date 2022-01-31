package com.tencent.biz.qqcircle.activity;

import abqm;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.biz.qqcircle.fragments.QCircleBaseFragment;
import com.tencent.biz.videostory.network.VSNetworkHelper;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.qphone.base.util.QLog;
import tql;
import tym;
import typ;

public class QCircleFragmentActivity
  extends PublicFragmentActivity
{
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (300001 == paramInt1)
    {
      QLog.d("QCircleFragmentActivity", 1, "doOnActivityResult，return from qzone publish page");
      tym.a().a(36);
    }
  }
  
  public void doOnBackPressed()
  {
    QLog.d("QCircleFragmentActivity", 1, "QCircleFragmentActivity->doOnBackPressed");
    super.doOnBackPressed();
    PublicBaseFragment localPublicBaseFragment = a();
    if ((localPublicBaseFragment instanceof QCircleBaseFragment)) {
      ((QCircleBaseFragment)localPublicBaseFragment).a();
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    QLog.d("QCircleFragmentActivity", 1, "QCircleFragmentActivity->doOnCreate");
    return super.doOnCreate(paramBundle);
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    tql.a();
    abqm.a(this);
    VSNetworkHelper.a().a(this);
    typ.a().a();
  }
  
  public void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    QLog.d("QCircleFragmentActivity", 1, "QCircleFragmentActivity->doOnNewIntent");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.activity.QCircleFragmentActivity
 * JD-Core Version:    0.7.0.1
 */