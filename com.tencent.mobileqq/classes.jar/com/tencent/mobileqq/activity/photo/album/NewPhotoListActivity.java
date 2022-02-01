package com.tencent.mobileqq.activity.photo.album;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.av.camera.QavCameraUsage;
import com.tencent.av.smallscreen.SmallScreenUtils;
import com.tencent.mobileqq.activity.photo.album.photolist.AbstractPhotoListActivity;
import com.tencent.mobileqq.activity.photo.album.photolist.PhotoListCustomization;
import com.tencent.mobileqq.activity.photo.album.photolist.PhotoListSceneBase;
import com.tencent.mobileqq.colornote.api.IColorNoteUtil;
import com.tencent.mobileqq.qqalbum.IPhotoLogicFactory;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.annotation.RoutePage;
import com.tencent.mobileqq.utils.kapalaiadapter.FileProvider7Helper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.PermissionUtil;
import java.io.File;
import java.io.IOException;
import mqq.app.MobileQQ;

@RoutePage(desc="相册图片列表页面", path="/base/album/photolist")
public class NewPhotoListActivity
  extends AbstractPhotoListActivity
{
  public TextView imgCountTipsTv;
  public TextView magicStickBtn;
  public CheckBox qualityCheckBox;
  public TextView qualityCountTv;
  public TextView qualityTv;
  
  public void dispatchTakePictureIntent()
  {
    if (QavCameraUsage.b(MobileQQ.getContext())) {
      return;
    }
    Intent localIntent = new Intent();
    Object localObject = null;
    try
    {
      File localFile = this.mPhotoListCustomization.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListSceneBase.a();
      localObject = localFile;
    }
    catch (IOException localIOException)
    {
      label33:
      break label33;
    }
    if (localObject != null)
    {
      FileProvider7Helper.setSystemCapture(this, localObject, localIntent);
      startActivityForResult(localIntent, 16);
    }
  }
  
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
    if (QLog.isColorLevel()) {
      QLog.d("QQAlbum", 2, "-----doOnActivityResult-----");
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    if (!PermissionUtil.b(this)) {
      PermissionUtil.c(this, null);
    }
    if (QLog.isColorLevel())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("-----doOnCreate-----");
      paramBundle.append(this);
      QLog.d("QQAlbum", 2, paramBundle.toString());
    }
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("-----doOnDestroy-----");
      localStringBuilder.append(this);
      QLog.d("QQAlbum", 2, localStringBuilder.toString());
    }
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    SmallScreenUtils.a(MobileQQ.getContext(), false);
    ((IColorNoteUtil)QRoute.api(IColorNoteUtil.class)).sendUpdateSmallScreenStateBroadcast(MobileQQ.getContext(), 2, true);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("-----doOnPause-----");
      localStringBuilder.append(this);
      QLog.d("QQAlbum", 2, localStringBuilder.toString());
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("-----doOnResume-----");
      localStringBuilder.append(this);
      QLog.d("QQAlbum", 2, localStringBuilder.toString());
    }
  }
  
  public void doOnStart()
  {
    super.doOnStart();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("-----doOnStart-----");
      localStringBuilder.append(this);
      QLog.d("QQAlbum", 2, localStringBuilder.toString());
    }
  }
  
  public void doOnStop()
  {
    super.doOnStop();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("-----doOnStop-----");
      localStringBuilder.append(this);
      QLog.d("QQAlbum", 2, localStringBuilder.toString());
    }
  }
  
  public PhotoListCustomization<? extends OtherCommonData> generateCustomization()
  {
    int i = getIntent().getIntExtra("enter_from", 0);
    PhotoListCustomization localPhotoListCustomization = ((IPhotoLogicFactory)QRoute.api(IPhotoLogicFactory.class)).createPhotoListLogic(this, getIntent());
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("generateLogic:");
      localStringBuilder.append(localPhotoListCustomization.getClass().getName());
      localStringBuilder.append(" enterFrom:");
      localStringBuilder.append(i);
      QLog.d("QQAlbum", 2, localStringBuilder.toString());
    }
    return localPhotoListCustomization;
  }
  
  protected boolean handleCaptureResult(Intent paramIntent)
  {
    if (paramIntent != null)
    {
      boolean bool1 = paramIntent.getBooleanExtra("extra_directly_back", false);
      boolean bool2 = paramIntent.getBooleanExtra("PhotoConst.IS_VIDEO_RECORDED", false);
      if (bool1)
      {
        if (bool2) {
          this.mPhotoListCustomization.f(paramIntent);
        } else {
          this.mPhotoListCustomization.e(paramIntent);
        }
        return true;
      }
    }
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
    boolean bool = paramIntent.getBooleanExtra("extra_directly_back", false);
    if (paramIntent.getIntExtra("p_e_s_type", 0) == 7)
    {
      this.mPhotoListCustomization.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListBaseData.o = false;
      this.mPhotoListCustomization.a(paramIntent);
    }
    else if (bool)
    {
      this.mPhotoListCustomization.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListBaseData.o = false;
      handleCaptureResult(paramIntent);
      QLog.d("QQAlbum", 2, "QQAlbum onNewIntent() camera back");
    }
    else
    {
      setIntent(paramIntent);
      this.mPhotoListCustomization.a(paramIntent);
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQAlbum", 2, "-----do ProcessNewIntent-----");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity
 * JD-Core Version:    0.7.0.1
 */