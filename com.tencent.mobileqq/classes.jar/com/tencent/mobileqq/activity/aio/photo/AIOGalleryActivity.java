package com.tencent.mobileqq.activity.aio.photo;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import com.tencent.av.smallscreen.SmallScreenUtils;
import com.tencent.biz.troop.TroopMemberApiClient;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.galleryactivity.GalleryManager;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.ApngImage;
import com.tencent.image.QQLiveImage;
import com.tencent.mobileqq.richmedia.dc.DCAIOPreview;
import com.tencent.mobileqq.richmedia.dc.DCAIOPreviewProgressive;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.qphone.base.util.QLog;
import vma;
import vmf;

public class AIOGalleryActivity
  extends PeakActivity
{
  int jdField_a_of_type_Int;
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = null;
  private TroopMemberApiClient jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient;
  GalleryManager jdField_a_of_type_ComTencentCommonGalleryactivityGalleryManager = new vma(this);
  public IAIOImageProvider a;
  DCAIOPreview jdField_a_of_type_ComTencentMobileqqRichmediaDcDCAIOPreview;
  DCAIOPreviewProgressive jdField_a_of_type_ComTencentMobileqqRichmediaDcDCAIOPreviewProgressive;
  public String a;
  boolean jdField_a_of_type_Boolean = false;
  public boolean b;
  
  public DCAIOPreview a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaDcDCAIOPreview == null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaDcDCAIOPreview = new DCAIOPreview(this);
    }
    return this.jdField_a_of_type_ComTencentMobileqqRichmediaDcDCAIOPreview;
  }
  
  public DCAIOPreviewProgressive a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaDcDCAIOPreviewProgressive == null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaDcDCAIOPreviewProgressive = new DCAIOPreviewProgressive(this);
    }
    return this.jdField_a_of_type_ComTencentMobileqqRichmediaDcDCAIOPreviewProgressive;
  }
  
  protected boolean a()
  {
    return false;
  }
  
  public void finish()
  {
    super.finish();
    overridePendingTransition(0, 0);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    this.jdField_a_of_type_ComTencentCommonGalleryactivityGalleryManager.a(paramInt1, paramInt2, paramIntent);
  }
  
  public void onBackPressed()
  {
    if (!this.jdField_a_of_type_ComTencentCommonGalleryactivityGalleryManager.b()) {
      super.onBackPressed();
    }
    QQLiveImage.releaseAll();
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    this.jdField_a_of_type_ComTencentCommonGalleryactivityGalleryManager.a(paramConfiguration);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    this.V = false;
    super.onCreate(paramBundle);
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient = TroopMemberApiClient.a();
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a();
    AIOConstants.a = getResources().getDisplayMetrics().density;
    ShortVideoUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppPeakAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaDcDCAIOPreview = new DCAIOPreview(this);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaDcDCAIOPreviewProgressive = new DCAIOPreviewProgressive(this);
    paramBundle = getIntent().getExtras();
    this.jdField_a_of_type_JavaLangString = paramBundle.getString("extra.GROUP_UIN");
    this.b = paramBundle.getBoolean("extra.IS_FROM_CHAT_FILE_HISTORY");
    try
    {
      this.jdField_a_of_type_ComTencentCommonGalleryactivityGalleryManager.a(this);
      return;
    }
    catch (Exception paramBundle)
    {
      if (QLog.isColorLevel()) {
        QLog.e("AIOGalleryActivity", 2, "", paramBundle);
      }
      finish();
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider != null) {}
    try
    {
      if ((!this.b) && (!getIntent().getBooleanExtra("extra.IS_STARTING_CHAT_FILE_HISTORY", false))) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.a();
      }
      for (;;)
      {
        label40:
        this.jdField_a_of_type_ComTencentCommonGalleryactivityGalleryManager.c(this);
        if (this.jdField_a_of_type_ComTencentMobileqqRichmediaDcDCAIOPreview != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqRichmediaDcDCAIOPreview.b(this.jdField_a_of_type_Int);
          this.jdField_a_of_type_ComTencentMobileqqRichmediaDcDCAIOPreview.a();
        }
        if (this.jdField_a_of_type_ComTencentMobileqqRichmediaDcDCAIOPreviewProgressive != null) {
          this.jdField_a_of_type_ComTencentMobileqqRichmediaDcDCAIOPreviewProgressive.a();
        }
        this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.b();
        QQLiveImage.releaseAll();
        return;
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.c();
      }
    }
    catch (Exception localException)
    {
      break label40;
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (!this.jdField_a_of_type_ComTencentCommonGalleryactivityGalleryManager.a(paramInt, paramKeyEvent)) {
      return super.onKeyDown(paramInt, paramKeyEvent);
    }
    return true;
  }
  
  protected void onPause()
  {
    SmallScreenUtils.a(BaseApplicationImpl.getContext(), false);
    AbstractGifImage.pauseAll();
    ApngImage.pauseAll();
    QQLiveImage.pauseAll();
    super.onPause();
    if ((Build.MODEL.equals("Coolpad 5930")) && (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null)) {}
    try
    {
      unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("AIOGalleryActivity", 2, localException.getMessage());
    }
  }
  
  protected void onResume()
  {
    super.onResume();
    SmallScreenUtils.a(BaseApplicationImpl.getContext(), true);
    com.tencent.image.AbstractGifImage.DoAccumulativeRunnable.DELAY = 0;
    AbstractGifImage.resumeAll();
    ApngImage.playByTag(0);
    QQLiveImage.resumeAll();
    if (Build.MODEL.equals("Coolpad 5930"))
    {
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = new vmf(this);
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
      localIntentFilter.addAction("android.intent.action.SCREEN_ON");
      localIntentFilter.addAction("android.intent.action.USER_PRESENT");
      registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
    }
    this.jdField_a_of_type_ComTencentCommonGalleryactivityGalleryManager.c();
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    if (paramBoolean) {
      this.jdField_a_of_type_ComTencentCommonGalleryactivityGalleryManager.b(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOGalleryActivity
 * JD-Core Version:    0.7.0.1
 */