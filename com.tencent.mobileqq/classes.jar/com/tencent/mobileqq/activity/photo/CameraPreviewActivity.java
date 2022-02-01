package com.tencent.mobileqq.activity.photo;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.AbstractGifImage;
import com.tencent.mobileqq.activity.aio.photo.AIOPhotoListUtils;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.pic.api.IPicBus;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.Gallery;
import java.io.File;
import java.util.ArrayList;

public class CameraPreviewActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable = new ColorDrawable(0);
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private CameraPreviewActivity.GalleryImageAdapter jdField_a_of_type_ComTencentMobileqqActivityPhotoCameraPreviewActivity$GalleryImageAdapter;
  protected QQCustomDialog a;
  private Gallery jdField_a_of_type_ComTencentWidgetGallery;
  String jdField_a_of_type_JavaLangString = null;
  private ArrayList<String> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  boolean jdField_b_of_type_Boolean;
  
  private void a()
  {
    Intent localIntent = getIntent();
    boolean bool = false;
    this.jdField_b_of_type_Boolean = localIntent.getBooleanExtra("callFromFastImage", false);
    if (this.jdField_b_of_type_Boolean) {
      StatisticConstants.c();
    } else {
      StatisticConstants.a();
    }
    this.jdField_a_of_type_JavaUtilArrayList = localIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
    int i = localIntent.getIntExtra("uintype", 1003);
    if ((i == 0) || (i == 1) || (i == 3000) || (i == 7)) {
      bool = true;
    }
    this.jdField_a_of_type_Boolean = bool;
    this.jdField_a_of_type_JavaLangString = localIntent.getStringExtra("PhotoConst.CUSTOM_SENDBTN_TEXT");
  }
  
  private void a(int paramInt)
  {
    Object localObject1;
    Object localObject2;
    if (paramInt == 6)
    {
      localObject1 = getString(2131718579);
      localObject2 = getString(2131718578);
    }
    for (;;)
    {
      break;
      if (paramInt == 7)
      {
        localObject1 = getString(2131718581);
        localObject2 = getString(2131718580);
      }
      else
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
        if (localObject1 != null)
        {
          ((QQCustomDialog)localObject1).dismiss();
          return;
        }
        localObject1 = null;
        localObject2 = localObject1;
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this, 230, (String)localObject1, (String)localObject2, new CameraPreviewActivity.4(this), null);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setOnCancelListener(new CameraPreviewActivity.5(this));
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setOnDismissListener(new CameraPreviewActivity.6(this));
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
  }
  
  private boolean a()
  {
    if (!Environment.getExternalStorageState().equalsIgnoreCase("mounted"))
    {
      a(7);
      return true;
    }
    if (AIOPhotoListUtils.a() < 10L)
    {
      a(6);
      return true;
    }
    return false;
  }
  
  private boolean a(String paramString)
  {
    long l1 = new File(paramString).length();
    long l2 = ((IPicBus)QRoute.api(IPicBus.class)).getC2CPicSizeLimit();
    boolean bool = false;
    if (l1 > l2)
    {
      QQToast.a(this, getResources().getString(2131694867), 0).b(getResources().getDimensionPixelSize(2131299168));
      bool = true;
    }
    return bool;
  }
  
  private void b()
  {
    this.jdField_a_of_type_ComTencentWidgetGallery = new Gallery(this);
    this.jdField_a_of_type_ComTencentWidgetGallery.setSpacing(getResources().getDimensionPixelSize(2131297150));
    this.jdField_a_of_type_AndroidViewViewGroup.addView(this.jdField_a_of_type_ComTencentWidgetGallery, -1, -1);
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoCameraPreviewActivity$GalleryImageAdapter = new CameraPreviewActivity.GalleryImageAdapter(this);
    this.jdField_a_of_type_ComTencentWidgetGallery.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoCameraPreviewActivity$GalleryImageAdapter);
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    QQCustomDialog localQQCustomDialog = this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
    if ((localQQCustomDialog != null) && (localQQCustomDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.hide();
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    AbstractGifImage.pauseAll();
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    AbstractGifImage.resumeAll();
  }
  
  protected boolean isWrapContent()
  {
    return false;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (getIntent().getIntExtra("uintype", 1003) == 8000)
    {
      PhotoUtils.onSendResult(this, paramInt1, paramInt2, paramIntent, getIntent().getBooleanExtra("PhotoConst.IS_CALL_IN_PLUGIN", true));
      finish();
      return;
    }
    PhotoUtils.onSendResult(this, paramInt1, paramInt2, paramIntent, false);
  }
  
  public void onClick(View paramView) {}
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    a();
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)getLayoutInflater().inflate(2131559557, null));
    b();
    getLayoutInflater().inflate(2131559559, this.jdField_a_of_type_AndroidViewViewGroup);
    this.jdField_a_of_type_Int = getResources().getDisplayMetrics().widthPixels;
    this.jdField_b_of_type_Int = getResources().getDisplayMetrics().heightPixels;
    super.setContentView(this.jdField_a_of_type_AndroidViewViewGroup);
    if (this.jdField_a_of_type_Boolean) {
      setRightButton(2131694881, new CameraPreviewActivity.1(this));
    }
    setTitle(2131694994);
    this.leftView.setVisibility(8);
    this.leftViewNotBack = ((TextView)findViewById(2131369204));
    this.leftViewNotBack.setVisibility(8);
    paramBundle = (TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131372643);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("BUILD MODEL:");
    ((StringBuilder)localObject).append(Build.MODEL);
    QLog.d("IphoneTitleBarActivity", 2, ((StringBuilder)localObject).toString());
    localObject = this.jdField_a_of_type_JavaLangString;
    if (localObject != null)
    {
      paramBundle.setText((CharSequence)localObject);
      if (Build.MODEL.equals("PAFM00"))
      {
        localObject = new RelativeLayout.LayoutParams(-2, -2);
        ((RelativeLayout.LayoutParams)localObject).setMargins(0, 0, ViewUtils.b(12.0F), 0);
        ((RelativeLayout.LayoutParams)localObject).addRule(11);
        paramBundle.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
    }
    paramBundle.setOnClickListener(new CameraPreviewActivity.2(this));
    paramBundle = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131372642);
    if (Build.MODEL.equals("PAFM00"))
    {
      localObject = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject).addRule(9);
      ((RelativeLayout.LayoutParams)localObject).setMargins(ViewUtils.b(12.0F), 0, 0, 0);
      paramBundle.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    paramBundle.setOnClickListener(new CameraPreviewActivity.3(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.CameraPreviewActivity
 * JD-Core Version:    0.7.0.1
 */