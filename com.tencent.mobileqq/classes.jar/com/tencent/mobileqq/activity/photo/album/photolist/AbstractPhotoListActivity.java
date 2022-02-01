package com.tencent.mobileqq.activity.photo.album.photolist;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.Window;
import com.tencent.mobileqq.activity.aio.photo.PeakFragmentActivity;
import com.tencent.mobileqq.activity.photo.album.OtherCommonData;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.activity.photo.album.QAlbumCustomAlbumConstants;
import com.tencent.mobileqq.activity.photo.album.albumlist.AbstractAlbumListFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class AbstractPhotoListActivity
  extends PeakFragmentActivity
{
  static final String SHARE_PREFERENCE_NAME = "share";
  public static final String TAG = "QQAlbum";
  public PhotoListCustomization<? extends OtherCommonData> mPhotoListCustomization;
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    this.mPhotoListCustomization.a(paramInt1, paramInt2, paramIntent);
  }
  
  public void doOnBackPressed()
  {
    int i;
    if ((this.mPhotoListCustomization.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListSceneBase.a != null) && (!this.mPhotoListCustomization.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListSceneBase.a.isHidden())) {
      i = 0;
    } else {
      i = 1;
    }
    if (i != 0)
    {
      this.mPhotoListCustomization.c();
      return;
    }
    this.mPhotoListCustomization.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListSceneBase.a(false);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    paramBundle = getIntent();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("QQAlbum onCreate(),extra is:");
      localStringBuilder.append(paramBundle.getExtras());
      QLog.d("QQAlbum", 2, localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("QQAlbum,hashCode is:");
      localStringBuilder.append(System.identityHashCode(this));
      QLog.d("QQAlbum", 2, localStringBuilder.toString());
    }
    super.adjustStatusBar();
    this.mPhotoListCustomization = generateCustomization();
    this.mPhotoListCustomization.a(paramBundle);
    super.setContentView(this.mPhotoListCustomization.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListSceneBase.d());
    getWindow().setBackgroundDrawable(null);
    this.mPhotoListCustomization.h();
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    this.mPhotoListCustomization.g();
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    paramIntent.putExtra("NEED_NEW_PHOTO_COMMON_DATA", false);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("QQAlbum onNewIntent() is called,extra is:");
      localStringBuilder.append(paramIntent.getExtras());
      QLog.d("QQAlbum", 2, localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("QQAlbumhashCode is:");
      localStringBuilder.append(System.identityHashCode(this));
      QLog.d("QQAlbum", 2, localStringBuilder.toString());
      QLog.d("QQAlbum", 2, "onNewIntent()");
    }
    processNewIntent(paramIntent);
    if (this.mPhotoListCustomization.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumName != null) {
      paramIntent = this.mPhotoListCustomization.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumName;
    } else if (this.mPhotoListCustomization.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.showMediaType == 2) {
      paramIntent = QAlbumCustomAlbumConstants.RECENT_ALBUM_NAME_VIDEO;
    } else {
      paramIntent = QAlbumCustomAlbumConstants.RECENT_ALBUM_NAME;
    }
    setTitle(paramIntent);
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    this.mPhotoListCustomization.j();
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    this.mPhotoListCustomization.f();
  }
  
  public void finish()
  {
    super.finish();
  }
  
  protected PhotoListCustomization<? extends OtherCommonData> generateCustomization()
  {
    return new PhotoListCustomizationBase(this);
  }
  
  protected boolean isWrapContent()
  {
    return false;
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void processNewIntent(Intent paramIntent)
  {
    setIntent(paramIntent);
    this.mPhotoListCustomization.a(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.photolist.AbstractPhotoListActivity
 * JD-Core Version:    0.7.0.1
 */