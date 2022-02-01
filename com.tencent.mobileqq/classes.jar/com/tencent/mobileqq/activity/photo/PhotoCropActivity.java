package com.tencent.mobileqq.activity.photo;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mobileqq.activity.PortraitImageview;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;

public class PhotoCropActivity
  extends BaseActivity
  implements View.OnClickListener
{
  int jdField_a_of_type_Int;
  final long jdField_a_of_type_Long = 10000L;
  Intent jdField_a_of_type_AndroidContentIntent;
  public Handler a;
  View jdField_a_of_type_AndroidViewView;
  ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  Button jdField_a_of_type_AndroidWidgetButton;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  PortraitImageview jdField_a_of_type_ComTencentMobileqqActivityPortraitImageview;
  PhotoCropAction jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoCropAction;
  RegionView jdField_a_of_type_ComTencentMobileqqActivityPhotoRegionView;
  CardObserver jdField_a_of_type_ComTencentMobileqqAppCardObserver = new PhotoCropActivity.3(this);
  public QQProgressDialog a;
  String jdField_a_of_type_JavaLangString;
  boolean jdField_a_of_type_Boolean;
  String[] jdField_a_of_type_ArrayOfJavaLangString;
  int jdField_b_of_type_Int;
  Button jdField_b_of_type_AndroidWidgetButton;
  String jdField_b_of_type_JavaLangString;
  boolean jdField_b_of_type_Boolean;
  int jdField_c_of_type_Int;
  String jdField_c_of_type_JavaLangString;
  boolean jdField_c_of_type_Boolean = false;
  int jdField_d_of_type_Int;
  String jdField_d_of_type_JavaLangString;
  protected boolean d;
  int e;
  int f;
  int g;
  int h;
  protected int i = 0;
  
  public PhotoCropActivity()
  {
    this.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidOsHandler = new PhotoCropActivity.1(this);
  }
  
  private void a(int paramInt)
  {
    if (!isFinishing()) {
      QQToast.a(this, paramInt, 0).b(getTitleBarHeight());
    }
  }
  
  void a()
  {
    if (this.jdField_c_of_type_Boolean) {
      return;
    }
    this.jdField_c_of_type_Boolean = true;
    new PhotoCropActivity.StoreFileTask(this, null).execute(new Void[0]);
  }
  
  @SuppressLint({"NewApi"})
  void a(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    this.jdField_a_of_type_AndroidViewView = findViewById(2131376809);
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      this.jdField_a_of_type_AndroidViewView.setFitsSystemWindows(true);
    }
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131372676));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131365363));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)findViewById(2131363346));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378784));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
    if (!TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) {
      this.jdField_b_of_type_AndroidWidgetButton.setText(this.jdField_d_of_type_JavaLangString);
    }
    if ("FROM_SDK_AVATAR_SET_IMAGE".equals(this.jdField_b_of_type_JavaLangString))
    {
      this.jdField_b_of_type_AndroidWidgetButton.setText("");
      this.jdField_a_of_type_AndroidWidgetTextView.setText("调整QQ头像");
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityPortraitImageview = new PortraitImageview(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityPortraitImageview.addOnLayoutChangeListener(new PhotoCropActivity.2(this));
  }
  
  protected boolean a()
  {
    Object localObject = getIntent();
    this.jdField_a_of_type_AndroidContentIntent = ((Intent)localObject);
    this.jdField_b_of_type_JavaLangString = ((Intent)localObject).getStringExtra("FROM_WHERE");
    ((Intent)localObject).removeExtra("FROM_WHERE");
    this.jdField_c_of_type_JavaLangString = ((Intent)localObject).getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
    this.jdField_d_of_type_JavaLangString = ((Intent)localObject).getStringExtra("PhotoConst.QZONE_COVER_CROP_LEFT_TITLE");
    this.jdField_c_of_type_Int = ((Intent)localObject).getIntExtra("PhotoConst.CLIP_WIDTH", 400);
    this.jdField_d_of_type_Int = ((Intent)localObject).getIntExtra("PhotoConst.CLIP_HEIGHT", 400);
    this.jdField_a_of_type_Boolean = ((Intent)localObject).getBooleanExtra("PhotoConst.32_Bit_Config", false);
    this.e = ((Intent)localObject).getIntExtra("PhotoConst.TARGET_WIDTH", 400);
    this.f = ((Intent)localObject).getIntExtra("PhotoConst.TARGET_HEIGHT", 400);
    this.g = ((Intent)localObject).getIntExtra("PhotoConst.TARGET_SAMPLE_SIZE", 1280);
    this.jdField_b_of_type_Boolean = ((Intent)localObject).getBooleanExtra("PhotoConst.ORIGIN_WITH_CLIPINFO", false);
    this.jdField_a_of_type_JavaLangString = ((Intent)localObject).getStringExtra("PhotoConst.TARGET_PATH");
    this.jdField_a_of_type_Int = ((Intent)localObject).getIntExtra("BUSINESS_ORIGIN_NEW", 0);
    if (this.jdField_a_of_type_JavaLangString == null)
    {
      QQToast.a(this, 2131694843, 0).a();
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.i("PhotoCropActivity", 2, String.format("initData path=%s target=%s", new Object[] { this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString }));
    }
    this.h = ((Intent)localObject).getIntExtra("PhotoConst.EDIT_MASK_SHAPE_TYPE", 1);
    this.jdField_b_of_type_Int = ((Intent)localObject).getIntExtra("PhotoConst.COMPRESS_QUALITY", 100);
    this.jdField_a_of_type_ArrayOfJavaLangString = ((Intent)localObject).getStringArrayExtra("PhotoConst.QZONE_COVER_SOURCE");
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("initData from=");
      ((StringBuilder)localObject).append(this.jdField_b_of_type_JavaLangString);
      ((StringBuilder)localObject).append(" targetSampleSize=");
      ((StringBuilder)localObject).append(this.g);
      ((StringBuilder)localObject).append(" keepClipInfo=");
      ((StringBuilder)localObject).append(this.jdField_b_of_type_Boolean);
      QLog.d("PhotoCropActivity", 2, ((StringBuilder)localObject).toString());
    }
    if ("FROM_SDK_AVATAR_SET_IMAGE".equals(this.jdField_b_of_type_JavaLangString)) {
      ReportController.b(this.app, "dc00898", "", "", "0X8009B68", "0X8009B68", 0, 0, "", "", "", "");
    }
    return true;
  }
  
  protected void b()
  {
    try
    {
      if (!isFinishing())
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setCancelable(false);
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(2131690840);
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
        return;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  protected void c()
  {
    QQProgressDialog localQQProgressDialog = this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
    if ((localQQProgressDialog != null) && (localQQProgressDialog.isShowing())) {}
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      label23:
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
      return;
    }
    catch (Exception localException)
    {
      break label23;
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
    if (paramInt1 == 2)
    {
      setResult(-1, paramIntent);
      finish();
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131559554);
    if (!a())
    {
      finish();
      return false;
    }
    a(this.jdField_c_of_type_JavaLangString, this.jdField_c_of_type_Int, this.jdField_d_of_type_Int, this.e, this.f, this.h);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    new PhotoCropActivity.LoadBitmapTask(this, null).execute(new Void[0]);
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    if (QLog.isColorLevel()) {
      QLog.e("doOnNewIntent", 2, "get new intent");
    }
    setIntent(paramIntent);
    if (!a())
    {
      finish();
      return;
    }
    a(this.jdField_c_of_type_JavaLangString, this.jdField_c_of_type_Int, this.jdField_d_of_type_Int, this.e, this.f, this.h);
    new PhotoCropActivity.LoadBitmapTask(this, null).execute(new Void[0]);
  }
  
  protected String getModuleId()
  {
    return "peak";
  }
  
  protected boolean isWrapContent()
  {
    return false;
  }
  
  protected boolean onBackEvent()
  {
    Intent localIntent;
    if ("FROM_PHOTO_LIST".equals(this.jdField_b_of_type_JavaLangString))
    {
      localIntent = getIntent();
      localIntent.setClass(this, NewPhotoListActivity.class);
      localIntent.removeExtra("PhotoConst.PHOTO_PATHS");
      startActivity(localIntent);
    }
    else if ("FROM_NEARBY_PROFILE".equals(this.jdField_b_of_type_JavaLangString))
    {
      PhotoUtils.sendPhoto(this, getIntent(), new ArrayList(), 0, false);
    }
    else if ("FROM_SDK_AVATAR_SET_IMAGE".equals(this.jdField_b_of_type_JavaLangString))
    {
      ReportController.b(this.app, "dc00898", "", "", "0X8009B69", "0X8009B69", 0, 0, "", "", "", "");
      if (QLog.isColorLevel()) {
        QLog.d("PhotoCropActivity", 2, "onBackEvent");
      }
      localIntent = getIntent();
      localIntent.putExtra("key_from_sdk_set_avatar_result", false);
      setResult(0, localIntent);
    }
    finish();
    AlbumUtil.anim(this, true, false);
    return true;
  }
  
  public void onClick(View paramView)
  {
    int j = paramView.getId();
    if (j != 2131363346)
    {
      if (j == 2131365363)
      {
        if (this.jdField_a_of_type_ArrayOfJavaLangString != null)
        {
          if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoCropAction == null)
          {
            this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoCropAction = new PhotoCropMenuForQzone(this);
            this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoCropAction.a(this.jdField_a_of_type_ArrayOfJavaLangString);
          }
          if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoRegionView != null) {
            this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoCropAction.a();
          }
        }
        else if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoRegionView != null)
        {
          a();
        }
        AlbumUtil.clearSelectItemInfo();
        AlbumUtil.a(this.jdField_a_of_type_AndroidContentIntent);
        if ("FROM_SDK_AVATAR_SET_IMAGE".equals(this.jdField_b_of_type_JavaLangString)) {
          ReportController.b(this.app, "dc00898", "", "", "0X8009B6A", "0X8009B6A", 0, 0, "", "", "", "");
        }
      }
    }
    else {
      onBackEvent();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.PhotoCropActivity
 * JD-Core Version:    0.7.0.1
 */