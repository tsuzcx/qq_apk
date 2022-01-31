package com.tencent.mobileqq.activity.aio.photo;

import aegf;
import aegg;
import aegi;
import aegs;
import aejb;
import amkf;
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
import avwo;
import avwr;
import bcuc;
import bjal;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.ApngImage;
import com.tencent.image.QQLiveImage;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.qphone.base.util.QLog;
import lze;
import wxr;
import xpf;
import xpw;

public class AIOGalleryActivity
  extends PeakActivity
{
  int jdField_a_of_type_Int;
  public long a;
  public aejb a;
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = null;
  avwo jdField_a_of_type_Avwo;
  avwr jdField_a_of_type_Avwr;
  public String a;
  private wxr jdField_a_of_type_Wxr;
  xpw jdField_a_of_type_Xpw = new aegg(this);
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
  
  public avwo a()
  {
    if (this.jdField_a_of_type_Avwo == null) {
      this.jdField_a_of_type_Avwo = new avwo(this);
    }
    return this.jdField_a_of_type_Avwo;
  }
  
  public avwr a()
  {
    if (this.jdField_a_of_type_Avwr == null) {
      this.jdField_a_of_type_Avwr = new avwr(this);
    }
    return this.jdField_a_of_type_Avwr;
  }
  
  public boolean a()
  {
    return false;
  }
  
  public void finish()
  {
    xpf localxpf = this.jdField_a_of_type_Xpw.a();
    if (aegs.class.isInstance(localxpf)) {
      ((aegs)localxpf).g();
    }
    QQLiveImage.releaseAll(this);
    super.finish();
    overridePendingTransition(0, 0);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    this.jdField_a_of_type_Xpw.a(paramInt1, paramInt2, paramIntent);
  }
  
  public void onBackPressed()
  {
    if (!this.jdField_a_of_type_Xpw.b()) {
      super.onBackPressed();
    }
    QQLiveImage.releaseAll(this);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    this.jdField_a_of_type_Xpw.a(paramConfiguration);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    this.ad = false;
    super.onCreate(paramBundle);
    this.jdField_a_of_type_Wxr = wxr.a();
    this.jdField_a_of_type_Wxr.a();
    aegc.a = getResources().getDisplayMetrics().density;
    ShortVideoUtils.a(bjal.a());
    this.jdField_a_of_type_Avwo = new avwo(this);
    this.jdField_a_of_type_Avwr = new avwr(this);
    paramBundle = getIntent().getExtras();
    this.jdField_a_of_type_JavaLangString = paramBundle.getString("extra.GROUP_UIN");
    this.jdField_b_of_type_Boolean = paramBundle.getBoolean("extra.IS_FROM_CHAT_FILE_HISTORY");
    try
    {
      this.jdField_a_of_type_Xpw.a(this);
      this.jdField_b_of_type_AndroidContentBroadcastReceiver = new aegf(this);
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
    this.jdField_a_of_type_Xpw.c(this);
    if (this.jdField_a_of_type_Aejb != null) {}
    try
    {
      if ((!this.jdField_b_of_type_Boolean) && (!getIntent().getBooleanExtra("extra.IS_STARTING_CHAT_FILE_HISTORY", false))) {
        this.jdField_a_of_type_Aejb.a();
      }
      for (;;)
      {
        label62:
        if (this.jdField_b_of_type_AndroidContentBroadcastReceiver != null)
        {
          unregisterReceiver(this.jdField_b_of_type_AndroidContentBroadcastReceiver);
          this.jdField_b_of_type_AndroidContentBroadcastReceiver = null;
        }
        if (this.jdField_a_of_type_Avwo != null)
        {
          this.jdField_a_of_type_Avwo.b(this.jdField_a_of_type_Int);
          this.jdField_a_of_type_Avwo.a();
        }
        if (this.jdField_a_of_type_Avwr != null) {
          this.jdField_a_of_type_Avwr.a();
        }
        this.jdField_a_of_type_Wxr.b();
        QQLiveImage.releaseAll(this);
        return;
        this.jdField_a_of_type_Aejb.c();
      }
    }
    catch (Exception localException)
    {
      break label62;
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (!this.jdField_a_of_type_Xpw.a(paramInt, paramKeyEvent)) {
      return super.onKeyDown(paramInt, paramKeyEvent);
    }
    return true;
  }
  
  public void onPause()
  {
    lze.a(BaseApplicationImpl.getContext(), false);
    bcuc.a(BaseApplicationImpl.getContext(), true, 52);
    amkf.a(BaseApplicationImpl.getContext(), 2, true);
    AbstractGifImage.pauseAll();
    ApngImage.pauseAll();
    QQLiveImage.pauseAll(this);
    super.onPause();
    if ((Build.MODEL.equals("Coolpad 5930")) && (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null)) {}
    try
    {
      unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      this.jdField_a_of_type_Xpw.b();
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
    lze.a(BaseApplicationImpl.getContext(), true);
    bcuc.a(BaseApplicationImpl.getContext(), false, 52);
    amkf.a(BaseApplicationImpl.getContext(), 2, false);
    com.tencent.image.AbstractGifImage.DoAccumulativeRunnable.DELAY = 0;
    AbstractGifImage.resumeAll();
    ApngImage.playByTag(0);
    QQLiveImage.resumeAll(this);
    if (Build.MODEL.equals("Coolpad 5930"))
    {
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = new aegi(this);
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
      localIntentFilter.addAction("android.intent.action.SCREEN_ON");
      localIntentFilter.addAction("android.intent.action.USER_PRESENT");
      registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
    }
    this.jdField_a_of_type_Xpw.c();
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
      this.jdField_a_of_type_Xpw.b(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOGalleryActivity
 * JD-Core Version:    0.7.0.1
 */