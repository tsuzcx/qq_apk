package com.tencent.mobileqq.activity.photo;

import Override;
import akjv;
import akjx;
import akjy;
import akjz;
import akka;
import akkb;
import akkf;
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
import bdla;
import bisl;
import com.tencent.mobileqq.activity.PortraitImageview;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;

public class PhotoCropActivity
  extends BaseActivity
  implements View.OnClickListener
{
  public int a;
  final long jdField_a_of_type_Long = 10000L;
  akjv jdField_a_of_type_Akjv;
  Intent jdField_a_of_type_AndroidContentIntent;
  public Handler a;
  View jdField_a_of_type_AndroidViewView;
  public ViewGroup a;
  public Button a;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  public bisl a;
  public PortraitImageview a;
  public RegionView a;
  CardObserver jdField_a_of_type_ComTencentMobileqqAppCardObserver = new akjz(this);
  public String a;
  public boolean a;
  String[] jdField_a_of_type_ArrayOfJavaLangString;
  public int b;
  Button b;
  public String b;
  public boolean b;
  public int c;
  public String c;
  boolean c;
  public int d;
  String d;
  public boolean d;
  public int e;
  public int f;
  public int g;
  public int h;
  public int i;
  
  public PhotoCropActivity()
  {
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidOsHandler = new akjx(this);
  }
  
  private void a(int paramInt)
  {
    if (!isFinishing()) {
      QQToast.a(this, paramInt, 0).b(getTitleBarHeight());
    }
  }
  
  public void a()
  {
    if (this.jdField_c_of_type_Boolean) {
      return;
    }
    this.jdField_c_of_type_Boolean = true;
    new akkb(this, null).execute(new Void[0]);
  }
  
  @SuppressLint({"NewApi"})
  void a(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    this.jdField_a_of_type_AndroidViewView = findViewById(2131376947);
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      this.jdField_a_of_type_AndroidViewView.setFitsSystemWindows(true);
    }
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131372770));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131365367));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)findViewById(2131363336));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379001));
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
    this.jdField_a_of_type_ComTencentMobileqqActivityPortraitImageview.addOnLayoutChangeListener(new akjy(this));
  }
  
  protected boolean a()
  {
    Intent localIntent = getIntent();
    this.jdField_a_of_type_AndroidContentIntent = localIntent;
    this.jdField_b_of_type_JavaLangString = localIntent.getStringExtra("FROM_WHERE");
    localIntent.removeExtra("FROM_WHERE");
    this.jdField_c_of_type_JavaLangString = localIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
    this.jdField_d_of_type_JavaLangString = localIntent.getStringExtra("PhotoConst.QZONE_COVER_CROP_LEFT_TITLE");
    this.jdField_c_of_type_Int = localIntent.getIntExtra("PhotoConst.CLIP_WIDTH", 400);
    this.jdField_d_of_type_Int = localIntent.getIntExtra("PhotoConst.CLIP_HEIGHT", 400);
    this.jdField_a_of_type_Boolean = localIntent.getBooleanExtra("PhotoConst.32_Bit_Config", false);
    this.e = localIntent.getIntExtra("PhotoConst.TARGET_WIDTH", 400);
    this.f = localIntent.getIntExtra("PhotoConst.TARGET_HEIGHT", 400);
    this.g = localIntent.getIntExtra("PhotoConst.TARGET_SAMPLE_SIZE", 1280);
    this.jdField_b_of_type_Boolean = localIntent.getBooleanExtra("PhotoConst.ORIGIN_WITH_CLIPINFO", false);
    this.jdField_a_of_type_JavaLangString = localIntent.getStringExtra("PhotoConst.TARGET_PATH");
    this.jdField_a_of_type_Int = localIntent.getIntExtra("BUSINESS_ORIGIN_NEW", 0);
    if (this.jdField_a_of_type_JavaLangString == null)
    {
      QQToast.a(this, 2131694621, 0).a();
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.i("PhotoCropActivity", 2, String.format("initData path=%s target=%s", new Object[] { this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString }));
    }
    this.h = localIntent.getIntExtra("PhotoConst.EDIT_MASK_SHAPE_TYPE", 1);
    this.jdField_b_of_type_Int = localIntent.getIntExtra("PhotoConst.COMPRESS_QUALITY", 100);
    this.jdField_a_of_type_ArrayOfJavaLangString = localIntent.getStringArrayExtra("PhotoConst.QZONE_COVER_SOURCE");
    if (QLog.isColorLevel()) {
      QLog.d("PhotoCropActivity", 2, "initData from=" + this.jdField_b_of_type_JavaLangString + " targetSampleSize=" + this.g + " keepClipInfo=" + this.jdField_b_of_type_Boolean);
    }
    if ("FROM_SDK_AVATAR_SET_IMAGE".equals(this.jdField_b_of_type_JavaLangString)) {
      bdla.b(this.app, "dc00898", "", "", "0X8009B68", "0X8009B68", 0, 0, "", "", "", "");
    }
    return true;
  }
  
  public void b()
  {
    try
    {
      if (!isFinishing())
      {
        this.jdField_a_of_type_Bisl = new bisl(this, getTitleBarHeight());
        this.jdField_a_of_type_Bisl.setCancelable(false);
        this.jdField_a_of_type_Bisl.c(2131690806);
        this.jdField_a_of_type_Bisl.show();
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void c()
  {
    if ((this.jdField_a_of_type_Bisl != null) && (this.jdField_a_of_type_Bisl.isShowing())) {}
    try
    {
      this.jdField_a_of_type_Bisl.dismiss();
      label24:
      this.jdField_a_of_type_Bisl = null;
      return;
    }
    catch (Exception localException)
    {
      break label24;
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
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
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
    super.setContentView(2131559600);
    if (!a())
    {
      finish();
      return false;
    }
    a(this.jdField_c_of_type_JavaLangString, this.jdField_c_of_type_Int, this.jdField_d_of_type_Int, this.e, this.f, this.h);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    new akka(this, null).execute(new Void[0]);
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
  }
  
  public void doOnNewIntent(Intent paramIntent)
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
    new akka(this, null).execute(new Void[0]);
  }
  
  public String getModuleId()
  {
    return "peak";
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public boolean onBackEvent()
  {
    Intent localIntent;
    if ("FROM_PHOTO_LIST".equals(this.jdField_b_of_type_JavaLangString))
    {
      localIntent = getIntent();
      localIntent.setClass(this, NewPhotoListActivity.class);
      localIntent.removeExtra("PhotoConst.PHOTO_PATHS");
      startActivity(localIntent);
    }
    for (;;)
    {
      finish();
      AlbumUtil.anim(this, true, false);
      return true;
      if ("FROM_NEARBY_PROFILE".equals(this.jdField_b_of_type_JavaLangString))
      {
        PhotoUtils.sendPhoto(this, getIntent(), new ArrayList(), 0, false);
      }
      else if ("FROM_SDK_AVATAR_SET_IMAGE".equals(this.jdField_b_of_type_JavaLangString))
      {
        bdla.b(this.app, "dc00898", "", "", "0X8009B69", "0X8009B69", 0, 0, "", "", "", "");
        if (QLog.isColorLevel()) {
          QLog.d("PhotoCropActivity", 2, "onBackEvent");
        }
        localIntent = getIntent();
        localIntent.putExtra("key_from_sdk_set_avatar_result", false);
        setResult(0, localIntent);
      }
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.jdField_a_of_type_ArrayOfJavaLangString != null)
      {
        if (this.jdField_a_of_type_Akjv == null)
        {
          this.jdField_a_of_type_Akjv = new akkf(this);
          this.jdField_a_of_type_Akjv.a(this.jdField_a_of_type_ArrayOfJavaLangString);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoRegionView != null) {
          this.jdField_a_of_type_Akjv.a();
        }
      }
      for (;;)
      {
        AlbumUtil.clearSelectItemInfo();
        AlbumUtil.RecordLastPosByIntent(this.jdField_a_of_type_AndroidContentIntent);
        if (!"FROM_SDK_AVATAR_SET_IMAGE".equals(this.jdField_b_of_type_JavaLangString)) {
          break;
        }
        bdla.b(this.app, "dc00898", "", "", "0X8009B6A", "0X8009B6A", 0, 0, "", "", "", "");
        break;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoRegionView != null) {
          a();
        }
      }
      onBackEvent();
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.PhotoCropActivity
 * JD-Core Version:    0.7.0.1
 */