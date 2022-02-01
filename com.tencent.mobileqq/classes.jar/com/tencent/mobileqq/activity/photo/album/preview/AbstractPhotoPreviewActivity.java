package com.tencent.mobileqq.activity.photo.album.preview;

import android.annotation.TargetApi;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import com.tencent.mobileqq.activity.aio.photo.PeakFragmentActivity;
import com.tencent.mobileqq.activity.photo.album.OtherCommonData;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richmediabrowser.api.BrowserParamsBuilder;
import com.tencent.richmediabrowser.core.BrowserDirector;

public abstract class AbstractPhotoPreviewActivity
  extends PeakFragmentActivity
{
  public static final String FROM_WHERE_KEY = "FROM_WHERE";
  public static final String TAG = "QQAlbum";
  public PhotoPreviewCustomization<? extends OtherCommonData> mPhotoPreviewCustomization;
  
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
    this.mPhotoPreviewCustomization.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void doOnBackPressed()
  {
    this.mPhotoPreviewCustomization.i();
    QAlbumUtil.anim(this, true, false);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    if (Build.VERSION.SDK_INT >= 26)
    {
      int i = getWindow().getDecorView().getSystemUiVisibility();
      getWindow().getDecorView().setSystemUiVisibility(i & 0xFFFFFFEF);
    }
    getWindow().setSoftInputMode(32);
    this.mPhotoPreviewCustomization = generateCustomization();
    Object localObject = new BrowserParamsBuilder();
    ((BrowserParamsBuilder)localObject).a(true);
    ((BrowserParamsBuilder)localObject).b(true);
    ((BrowserParamsBuilder)localObject).c(this.mPhotoPreviewCustomization.t());
    ((BrowserParamsBuilder)localObject).a(new AlbumPreviewFactory());
    paramBundle = new AlbumPreviewBuilder(this.mPhotoPreviewCustomization);
    paramBundle.a((BrowserParamsBuilder)localObject);
    localObject = new BrowserDirector();
    Intent localIntent = getIntent();
    localIntent.putExtra("isNeedFullScreen", false);
    ((BrowserDirector)localObject).construct(paramBundle, localIntent);
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    this.mPhotoPreviewCustomization.c();
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    paramIntent.putExtra("NEED_NEW_PHOTO_COMMON_DATA", false);
    setIntent(paramIntent);
    this.mPhotoPreviewCustomization.a(paramIntent);
    this.mPhotoPreviewCustomization.a();
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    this.mPhotoPreviewCustomization.u();
  }
  
  @TargetApi(9)
  public void doOnResume()
  {
    super.doOnResume();
    this.mPhotoPreviewCustomization.n();
  }
  
  public PhotoPreviewCustomization<? extends OtherCommonData> generateCustomization()
  {
    return new PhotoPreviewCustomizationBase(this);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.preview.AbstractPhotoPreviewActivity
 * JD-Core Version:    0.7.0.1
 */