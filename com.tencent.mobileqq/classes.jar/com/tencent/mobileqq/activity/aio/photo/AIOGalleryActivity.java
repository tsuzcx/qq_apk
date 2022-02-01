package com.tencent.mobileqq.activity.aio.photo;

import Override;
import aasb;
import abjp;
import abkg;
import aibe;
import aibf;
import aibh;
import aibr;
import aidz;
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
import aquy;
import bbjq;
import bbjt;
import bjfr;
import bplg;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.ApngImage;
import com.tencent.image.QQLiveImage;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import lzq;

public class AIOGalleryActivity
  extends PeakActivity
{
  int jdField_a_of_type_Int;
  public long a;
  private aasb jdField_a_of_type_Aasb;
  abkg jdField_a_of_type_Abkg = new aibf(this);
  public aidz a;
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = null;
  bbjq jdField_a_of_type_Bbjq;
  bbjt jdField_a_of_type_Bbjt;
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
  
  public bbjq a()
  {
    if (this.jdField_a_of_type_Bbjq == null) {
      this.jdField_a_of_type_Bbjq = new bbjq(this);
    }
    return this.jdField_a_of_type_Bbjq;
  }
  
  public bbjt a()
  {
    if (this.jdField_a_of_type_Bbjt == null) {
      this.jdField_a_of_type_Bbjt = new bbjt(this);
    }
    return this.jdField_a_of_type_Bbjt;
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool);
    return bool;
  }
  
  public void finish()
  {
    abjp localabjp = this.jdField_a_of_type_Abkg.a();
    if (aibr.class.isInstance(localabjp)) {
      ((aibr)localabjp).d();
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
    this.jdField_a_of_type_Abkg.a(paramInt1, paramInt2, paramIntent);
  }
  
  public void onBackPressed()
  {
    if (!this.jdField_a_of_type_Abkg.b()) {
      super.onBackPressed();
    }
    QQLiveImage.releaseAll(this);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    this.jdField_a_of_type_Abkg.a(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    this.mActNeedImmersive = false;
    super.onCreate(paramBundle);
    this.jdField_a_of_type_Aasb = aasb.a();
    this.jdField_a_of_type_Aasb.a();
    aibb.a = getResources().getDisplayMetrics().density;
    ShortVideoUtils.a(bplg.a());
    this.jdField_a_of_type_Bbjq = new bbjq(this);
    this.jdField_a_of_type_Bbjt = new bbjt(this);
    paramBundle = getIntent().getExtras();
    this.jdField_a_of_type_JavaLangString = paramBundle.getString("extra.GROUP_UIN");
    this.jdField_b_of_type_Boolean = paramBundle.getBoolean("extra.IS_FROM_CHAT_FILE_HISTORY");
    try
    {
      this.jdField_a_of_type_Abkg.a(this);
      this.jdField_b_of_type_AndroidContentBroadcastReceiver = new aibe(this);
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
    this.jdField_a_of_type_Abkg.c(this);
    if (this.jdField_a_of_type_Aidz != null) {}
    try
    {
      if ((!this.jdField_b_of_type_Boolean) && (!getIntent().getBooleanExtra("extra.IS_STARTING_CHAT_FILE_HISTORY", false))) {
        this.jdField_a_of_type_Aidz.a();
      }
      for (;;)
      {
        label62:
        if (this.jdField_b_of_type_AndroidContentBroadcastReceiver != null)
        {
          unregisterReceiver(this.jdField_b_of_type_AndroidContentBroadcastReceiver);
          this.jdField_b_of_type_AndroidContentBroadcastReceiver = null;
        }
        if (this.jdField_a_of_type_Bbjq != null)
        {
          this.jdField_a_of_type_Bbjq.b(this.jdField_a_of_type_Int);
          this.jdField_a_of_type_Bbjq.a();
        }
        if (this.jdField_a_of_type_Bbjt != null) {
          this.jdField_a_of_type_Bbjt.a();
        }
        this.jdField_a_of_type_Aasb.b();
        QQLiveImage.releaseAll(this);
        return;
        this.jdField_a_of_type_Aidz.c();
      }
    }
    catch (Exception localException)
    {
      break label62;
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (!this.jdField_a_of_type_Abkg.a(paramInt, paramKeyEvent)) {
      return super.onKeyDown(paramInt, paramKeyEvent);
    }
    return true;
  }
  
  public void onPause()
  {
    lzq.a(BaseApplicationImpl.getContext(), false);
    bjfr.a(BaseApplicationImpl.getContext(), true, 52);
    aquy.a(BaseApplicationImpl.getContext(), 2, true);
    AbstractGifImage.pauseAll();
    ApngImage.pauseAll();
    QQLiveImage.pauseAll(this);
    super.onPause();
    if ((Build.MODEL.equals("Coolpad 5930")) && (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null)) {}
    try
    {
      unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      this.jdField_a_of_type_Abkg.b();
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
    lzq.a(BaseApplicationImpl.getContext(), true);
    bjfr.a(BaseApplicationImpl.getContext(), false, 52);
    aquy.a(BaseApplicationImpl.getContext(), 2, false);
    com.tencent.image.AbstractGifImage.DoAccumulativeRunnable.DELAY = 0;
    AbstractGifImage.resumeAll();
    ApngImage.playByTag(0);
    QQLiveImage.resumeAll(this);
    if (Build.MODEL.equals("Coolpad 5930"))
    {
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = new aibh(this);
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
      localIntentFilter.addAction("android.intent.action.SCREEN_ON");
      localIntentFilter.addAction("android.intent.action.USER_PRESENT");
      registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
    }
    this.jdField_a_of_type_Abkg.c();
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
      this.jdField_a_of_type_Abkg.b(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOGalleryActivity
 * JD-Core Version:    0.7.0.1
 */