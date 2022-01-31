package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import azqs;
import bhtb;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;

public class QQIdentiferLegacyActivity
  extends IphoneTitleBarActivity
{
  public static void a(FragmentActivity paramFragmentActivity, Fragment paramFragment)
  {
    paramFragmentActivity = paramFragmentActivity.getSupportFragmentManager();
    FragmentTransaction localFragmentTransaction = paramFragmentActivity.beginTransaction();
    if (paramFragmentActivity.findFragmentById(2131367400) != null) {
      localFragmentTransaction.replace(2131367400, paramFragment);
    }
    while (bhtb.e())
    {
      localFragmentTransaction.commitAllowingStateLoss();
      return;
      localFragmentTransaction.add(2131367400, paramFragment);
    }
    localFragmentTransaction.commit();
  }
  
  private void a(String paramString)
  {
    String str = getIntent().getStringExtra("method");
    if ("setFaceData".equals(str)) {
      azqs.b(null, "dc00898", "", "", paramString, paramString, 0, 0, "1", "", "", "");
    }
    if ("loginVerify".equals(str)) {
      azqs.a(null, "dc00898", "", "", paramString, paramString, 0, 0, "2", "", "", "");
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    paramBundle = new FrameLayout(this);
    paramBundle.setId(2131367400);
    paramBundle.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    setContentView(paramBundle);
    a(this, new QQIdentiferLegacy());
    return true;
  }
  
  public boolean onBackEvent()
  {
    Fragment localFragment = getSupportFragmentManager().findFragmentById(2131367400);
    if ((localFragment != null) && ((localFragment instanceof QQLightRecognitionGuide))) {
      a("0X800A85E");
    }
    return super.onBackEvent();
  }
  
  public void onBackPressed()
  {
    super.onBackPressed();
    Fragment localFragment = getSupportFragmentManager().findFragmentById(2131367400);
    if ((localFragment != null) && ((localFragment instanceof QQLightRecognitionGuide))) {
      a("0X800A85E");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQIdentiferLegacyActivity
 * JD-Core Version:    0.7.0.1
 */