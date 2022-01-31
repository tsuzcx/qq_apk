package com.tencent.mobileqq.activity.aio.photo;

import agcv;
import agcw;
import agcy;
import agdi;
import agft;
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
import aobd;
import axon;
import axoq;
import betl;
import bllv;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.ApngImage;
import com.tencent.image.QQLiveImage;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.qphone.base.util.QLog;
import mbt;
import ymk;
import zdy;
import zep;

public class AIOGalleryActivity
  extends PeakActivity
{
  int jdField_a_of_type_Int;
  public long a;
  public agft a;
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = null;
  axon jdField_a_of_type_Axon;
  axoq jdField_a_of_type_Axoq;
  public String a;
  private ymk jdField_a_of_type_Ymk;
  zep jdField_a_of_type_Zep = new agcw(this);
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
  
  public axon a()
  {
    if (this.jdField_a_of_type_Axon == null) {
      this.jdField_a_of_type_Axon = new axon(this);
    }
    return this.jdField_a_of_type_Axon;
  }
  
  public axoq a()
  {
    if (this.jdField_a_of_type_Axoq == null) {
      this.jdField_a_of_type_Axoq = new axoq(this);
    }
    return this.jdField_a_of_type_Axoq;
  }
  
  public void finish()
  {
    zdy localzdy = this.jdField_a_of_type_Zep.a();
    if (agdi.class.isInstance(localzdy)) {
      ((agdi)localzdy).g();
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
    this.jdField_a_of_type_Zep.a(paramInt1, paramInt2, paramIntent);
  }
  
  public void onBackPressed()
  {
    if (!this.jdField_a_of_type_Zep.b()) {
      super.onBackPressed();
    }
    QQLiveImage.releaseAll(this);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    this.jdField_a_of_type_Zep.a(paramConfiguration);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    this.mActNeedImmersive = false;
    super.onCreate(paramBundle);
    this.jdField_a_of_type_Ymk = ymk.a();
    this.jdField_a_of_type_Ymk.a();
    agcs.a = getResources().getDisplayMetrics().density;
    ShortVideoUtils.a(bllv.a());
    this.jdField_a_of_type_Axon = new axon(this);
    this.jdField_a_of_type_Axoq = new axoq(this);
    paramBundle = getIntent().getExtras();
    this.jdField_a_of_type_JavaLangString = paramBundle.getString("extra.GROUP_UIN");
    this.jdField_b_of_type_Boolean = paramBundle.getBoolean("extra.IS_FROM_CHAT_FILE_HISTORY");
    try
    {
      this.jdField_a_of_type_Zep.a(this);
      this.jdField_b_of_type_AndroidContentBroadcastReceiver = new agcv(this);
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
    this.jdField_a_of_type_Zep.c(this);
    if (this.jdField_a_of_type_Agft != null) {}
    try
    {
      if ((!this.jdField_b_of_type_Boolean) && (!getIntent().getBooleanExtra("extra.IS_STARTING_CHAT_FILE_HISTORY", false))) {
        this.jdField_a_of_type_Agft.a();
      }
      for (;;)
      {
        label62:
        if (this.jdField_b_of_type_AndroidContentBroadcastReceiver != null)
        {
          unregisterReceiver(this.jdField_b_of_type_AndroidContentBroadcastReceiver);
          this.jdField_b_of_type_AndroidContentBroadcastReceiver = null;
        }
        if (this.jdField_a_of_type_Axon != null)
        {
          this.jdField_a_of_type_Axon.b(this.jdField_a_of_type_Int);
          this.jdField_a_of_type_Axon.a();
        }
        if (this.jdField_a_of_type_Axoq != null) {
          this.jdField_a_of_type_Axoq.a();
        }
        this.jdField_a_of_type_Ymk.b();
        QQLiveImage.releaseAll(this);
        return;
        this.jdField_a_of_type_Agft.c();
      }
    }
    catch (Exception localException)
    {
      break label62;
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (!this.jdField_a_of_type_Zep.a(paramInt, paramKeyEvent)) {
      return super.onKeyDown(paramInt, paramKeyEvent);
    }
    return true;
  }
  
  public void onPause()
  {
    mbt.a(BaseApplicationImpl.getContext(), false);
    betl.a(BaseApplicationImpl.getContext(), true, 52);
    aobd.a(BaseApplicationImpl.getContext(), 2, true);
    AbstractGifImage.pauseAll();
    ApngImage.pauseAll();
    QQLiveImage.pauseAll(this);
    super.onPause();
    if ((Build.MODEL.equals("Coolpad 5930")) && (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null)) {}
    try
    {
      unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      this.jdField_a_of_type_Zep.b();
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
    mbt.a(BaseApplicationImpl.getContext(), true);
    betl.a(BaseApplicationImpl.getContext(), false, 52);
    aobd.a(BaseApplicationImpl.getContext(), 2, false);
    com.tencent.image.AbstractGifImage.DoAccumulativeRunnable.DELAY = 0;
    AbstractGifImage.resumeAll();
    ApngImage.playByTag(0);
    QQLiveImage.resumeAll(this);
    if (Build.MODEL.equals("Coolpad 5930"))
    {
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = new agcy(this);
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
      localIntentFilter.addAction("android.intent.action.SCREEN_ON");
      localIntentFilter.addAction("android.intent.action.USER_PRESENT");
      registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
    }
    this.jdField_a_of_type_Zep.c();
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
      this.jdField_a_of_type_Zep.b(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOGalleryActivity
 * JD-Core Version:    0.7.0.1
 */