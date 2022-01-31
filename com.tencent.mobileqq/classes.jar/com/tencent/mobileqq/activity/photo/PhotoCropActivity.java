package com.tencent.mobileqq.activity.photo;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import com.tencent.mobileqq.activity.PortraitImageview;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import wwt;
import wwu;
import wwv;

public class PhotoCropActivity
  extends BaseActivity
  implements View.OnClickListener
{
  public int a;
  Intent jdField_a_of_type_AndroidContentIntent;
  public Handler a;
  View jdField_a_of_type_AndroidViewView;
  public ViewGroup a;
  public Button a;
  public PortraitImageview a;
  PhotoCropAction jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoCropAction;
  public RegionView a;
  public String a;
  public boolean a;
  String[] jdField_a_of_type_ArrayOfJavaLangString;
  public int b;
  Button jdField_b_of_type_AndroidWidgetButton;
  public String b;
  boolean jdField_b_of_type_Boolean = false;
  public int c;
  public String c;
  public boolean c;
  public int d;
  String d;
  public int e;
  public int f;
  public int g;
  public int h;
  
  public void a()
  {
    if (this.jdField_b_of_type_Boolean) {
      return;
    }
    this.jdField_b_of_type_Boolean = true;
    new wwv(this, null).execute(new Void[0]);
  }
  
  @SuppressLint({"NewApi"})
  void a(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    this.jdField_a_of_type_AndroidViewView = findViewById(2131362840);
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      this.jdField_a_of_type_AndroidViewView.setFitsSystemWindows(true);
    }
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131365512));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131365509));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)findViewById(2131365511));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
    if (!TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) {
      this.jdField_b_of_type_AndroidWidgetButton.setText(this.jdField_d_of_type_JavaLangString);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityPortraitImageview = new PortraitImageview(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityPortraitImageview.addOnLayoutChangeListener(new wwt(this));
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
    this.jdField_a_of_type_JavaLangString = localIntent.getStringExtra("PhotoConst.TARGET_PATH");
    this.jdField_a_of_type_Int = localIntent.getIntExtra("BUSINESS_ORIGIN_NEW", 0);
    if (this.jdField_a_of_type_JavaLangString == null)
    {
      QQToast.a(this, 2131435907, 0).a();
      return false;
    }
    this.g = localIntent.getIntExtra("PhotoConst.EDIT_MASK_SHAPE_TYPE", 1);
    this.jdField_b_of_type_Int = localIntent.getIntExtra("PhotoConst.COMPRESS_QUALITY", 100);
    this.jdField_a_of_type_ArrayOfJavaLangString = localIntent.getStringArrayExtra("PhotoConst.QZONE_COVER_SOURCE");
    return true;
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
    super.setContentView(2130969173);
    if (!a())
    {
      finish();
      return false;
    }
    a(this.jdField_c_of_type_JavaLangString, this.jdField_c_of_type_Int, this.jdField_d_of_type_Int, this.e, this.f, this.g);
    new wwu(this, null).execute(new Void[0]);
    return true;
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
    if ("FROM_PHOTO_LIST".equals(this.jdField_b_of_type_JavaLangString))
    {
      Intent localIntent = getIntent();
      localIntent.setClass(this, PhotoListActivity.class);
      localIntent.removeExtra("PhotoConst.PHOTO_PATHS");
      startActivity(localIntent);
    }
    for (;;)
    {
      finish();
      AlbumUtil.a(this, true, false);
      return true;
      if ("FROM_NEARBY_PROFILE".equals(this.jdField_b_of_type_JavaLangString)) {
        PhotoUtils.a(this, getIntent(), new ArrayList(), 0, false);
      }
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    case 2131365510: 
    default: 
      return;
    case 2131365509: 
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
      for (;;)
      {
        AlbumUtil.c();
        AlbumUtil.a(this.jdField_a_of_type_AndroidContentIntent);
        return;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoRegionView != null) {
          a();
        }
      }
    }
    onBackEvent();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.PhotoCropActivity
 * JD-Core Version:    0.7.0.1
 */