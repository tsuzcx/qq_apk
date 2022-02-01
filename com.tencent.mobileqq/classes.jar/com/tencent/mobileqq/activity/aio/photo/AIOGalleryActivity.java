package com.tencent.mobileqq.activity.aio.photo;

import Override;
import aady;
import aavk;
import aawb;
import ahqv;
import ahqw;
import ahqy;
import ahri;
import ahtp;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.media.AudioManager;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.MotionEvent;
import aqrl;
import bbka;
import bbkd;
import biwn;
import bofz;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.ApngImage;
import com.tencent.image.QQLiveImage;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import lzr;

public class AIOGalleryActivity
  extends PeakActivity
{
  int jdField_a_of_type_Int;
  public long a;
  private aady jdField_a_of_type_Aady;
  aawb jdField_a_of_type_Aawb = new ahqw(this);
  public ahtp a;
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = null;
  bbka jdField_a_of_type_Bbka;
  bbkd jdField_a_of_type_Bbkd;
  public String a;
  boolean jdField_a_of_type_Boolean = false;
  int jdField_b_of_type_Int = 1;
  BroadcastReceiver jdField_b_of_type_AndroidContentBroadcastReceiver = null;
  public boolean b;
  public boolean c = true;
  public boolean d = false;
  
  public AIOGalleryActivity()
  {
    this.jdField_a_of_type_Long = -1L;
  }
  
  public bbka a()
  {
    if (this.jdField_a_of_type_Bbka == null) {
      this.jdField_a_of_type_Bbka = new bbka(this);
    }
    return this.jdField_a_of_type_Bbka;
  }
  
  public bbkd a()
  {
    if (this.jdField_a_of_type_Bbkd == null) {
      this.jdField_a_of_type_Bbkd = new bbkd(this);
    }
    return this.jdField_a_of_type_Bbkd;
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public void finish()
  {
    aavk localaavk = this.jdField_a_of_type_Aawb.a();
    if (ahri.class.isInstance(localaavk)) {
      ((ahri)localaavk).d();
    }
    QQLiveImage.releaseAll(this);
    super.finish();
    overridePendingTransition(0, 0);
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    this.jdField_a_of_type_Aawb.a(paramInt1, paramInt2, paramIntent);
  }
  
  public void onBackPressed()
  {
    if (!this.jdField_a_of_type_Aawb.b()) {
      super.onBackPressed();
    }
    QQLiveImage.releaseAll(this);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    this.jdField_a_of_type_Aawb.a(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    this.mActNeedImmersive = false;
    super.onCreate(paramBundle);
    this.jdField_a_of_type_Aady = aady.a();
    this.jdField_a_of_type_Aady.a();
    ahqs.a = getResources().getDisplayMetrics().density;
    ShortVideoUtils.loadShortVideoSo(bofz.a());
    this.jdField_a_of_type_Bbka = new bbka(this);
    this.jdField_a_of_type_Bbkd = new bbkd(this);
    paramBundle = getIntent().getExtras();
    this.jdField_a_of_type_JavaLangString = paramBundle.getString("extra.GROUP_UIN");
    this.jdField_b_of_type_Boolean = paramBundle.getBoolean("extra.IS_FROM_CHAT_FILE_HISTORY");
    try
    {
      this.jdField_a_of_type_Aawb.a(this);
      this.jdField_b_of_type_AndroidContentBroadcastReceiver = new ahqv(this);
      paramBundle = new IntentFilter();
      paramBundle.addAction("tencent.av.v2q.StartVideoChat");
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        try
        {
          registerReceiver(this.jdField_b_of_type_AndroidContentBroadcastReceiver, paramBundle);
          return;
        }
        catch (Exception paramBundle)
        {
          paramBundle.printStackTrace();
        }
        paramBundle = paramBundle;
        if (QLog.isColorLevel()) {
          QLog.e("AIOGalleryActivity", 2, "", paramBundle);
        }
        finish();
      }
    }
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOGalleryActivity", 2, "onDestroy()");
    }
    super.onDestroy();
    this.jdField_a_of_type_Aawb.c(this);
    if (this.jdField_a_of_type_Ahtp != null) {}
    try
    {
      if ((!this.jdField_b_of_type_Boolean) && (!getIntent().getBooleanExtra("extra.IS_STARTING_CHAT_FILE_HISTORY", false))) {
        this.jdField_a_of_type_Ahtp.a();
      }
      for (;;)
      {
        label62:
        if (this.jdField_b_of_type_AndroidContentBroadcastReceiver != null)
        {
          unregisterReceiver(this.jdField_b_of_type_AndroidContentBroadcastReceiver);
          this.jdField_b_of_type_AndroidContentBroadcastReceiver = null;
        }
        if (this.jdField_a_of_type_Bbka != null)
        {
          this.jdField_a_of_type_Bbka.b(this.jdField_a_of_type_Int);
          this.jdField_a_of_type_Bbka.a();
        }
        if (this.jdField_a_of_type_Bbkd != null) {
          this.jdField_a_of_type_Bbkd.a();
        }
        this.jdField_a_of_type_Aady.b();
        QQLiveImage.releaseAll(this);
        return;
        this.jdField_a_of_type_Ahtp.c();
      }
    }
    catch (Exception localException)
    {
      break label62;
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (!this.jdField_a_of_type_Aawb.a(paramInt, paramKeyEvent)) {
      return super.onKeyDown(paramInt, paramKeyEvent);
    }
    return true;
  }
  
  public void onPause()
  {
    lzr.a(BaseApplicationImpl.getContext(), false);
    biwn.a(BaseApplicationImpl.getContext(), true, 52);
    aqrl.a(BaseApplicationImpl.getContext(), 2, true);
    AbstractGifImage.pauseAll();
    ApngImage.pauseAll();
    QQLiveImage.pauseAll(this);
    super.onPause();
    if ((Build.MODEL.equals("Coolpad 5930")) && (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null)) {}
    try
    {
      unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      this.jdField_a_of_type_Aawb.b();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("AIOGalleryActivity", 2, localException.getMessage());
        }
      }
    }
  }
  
  public void onResume()
  {
    super.onResume();
    lzr.a(BaseApplicationImpl.getContext(), true);
    biwn.a(BaseApplicationImpl.getContext(), false, 52);
    aqrl.a(BaseApplicationImpl.getContext(), 2, false);
    com.tencent.image.AbstractGifImage.DoAccumulativeRunnable.DELAY = 0;
    AbstractGifImage.resumeAll();
    ApngImage.playByTag(0);
    QQLiveImage.resumeAll(this);
    if (Build.MODEL.equals("Coolpad 5930"))
    {
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = new ahqy(this);
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
      localIntentFilter.addAction("android.intent.action.SCREEN_ON");
      localIntentFilter.addAction("android.intent.action.USER_PRESENT");
      registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
    }
    this.jdField_a_of_type_Aawb.c();
  }
  
  public void onStart()
  {
    super.onStart();
    QQLiveImage.onForeground(this);
  }
  
  public void onStop()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOGalleryActivity", 2, "onStop()");
    }
    super.onStop();
    ((AudioManager)getSystemService("audio")).abandonAudioFocus(null);
    QQLiveImage.onBackground(this);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    if (paramBoolean) {
      this.jdField_a_of_type_Aawb.b(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOGalleryActivity
 * JD-Core Version:    0.7.0.1
 */