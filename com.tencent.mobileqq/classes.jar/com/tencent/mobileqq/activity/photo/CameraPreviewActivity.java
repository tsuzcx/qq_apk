package com.tencent.mobileqq.activity.photo;

import adxz;
import afzk;
import afzl;
import afzm;
import afzn;
import afzo;
import afzp;
import afzq;
import ageh;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import axwv;
import babr;
import bafb;
import bajq;
import bbmy;
import com.tencent.image.AbstractGifImage;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.Gallery;
import java.io.File;
import java.util.ArrayList;

public class CameraPreviewActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private afzq jdField_a_of_type_Afzq;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable = new ColorDrawable(0);
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  public bafb a;
  private Gallery jdField_a_of_type_ComTencentWidgetGallery;
  String jdField_a_of_type_JavaLangString = null;
  private ArrayList<String> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  boolean jdField_a_of_type_Boolean;
  private int b;
  public boolean b;
  
  private void a()
  {
    boolean bool = false;
    Intent localIntent = getIntent();
    this.jdField_b_of_type_Boolean = localIntent.getBooleanExtra("callFromFastImage", false);
    if (this.jdField_b_of_type_Boolean) {
      ageh.c();
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilArrayList = localIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
      int i = localIntent.getIntExtra("uintype", 1003);
      if ((i == 0) || (i == 1) || (i == 3000) || (i == 7)) {
        bool = true;
      }
      this.jdField_a_of_type_Boolean = bool;
      this.jdField_a_of_type_JavaLangString = localIntent.getStringExtra("PhotoConst.CUSTOM_SENDBTN_TEXT");
      return;
      ageh.a();
    }
  }
  
  private void a(int paramInt)
  {
    String str1;
    String str2;
    if (paramInt == 6)
    {
      str1 = getString(2131653223);
      str2 = getString(2131653222);
    }
    for (;;)
    {
      this.jdField_a_of_type_Bafb = babr.a(this, 230, str1, str2, new afzn(this), null);
      this.jdField_a_of_type_Bafb.setOnCancelListener(new afzo(this));
      this.jdField_a_of_type_Bafb.setOnDismissListener(new afzp(this));
      this.jdField_a_of_type_Bafb.show();
      return;
      if (paramInt == 7)
      {
        str1 = getString(2131653225);
        str2 = getString(2131653224);
      }
      else
      {
        if (this.jdField_a_of_type_Bafb != null)
        {
          this.jdField_a_of_type_Bafb.dismiss();
          return;
        }
        str1 = null;
        str2 = null;
      }
    }
  }
  
  private boolean a()
  {
    if (!Environment.getExternalStorageState().equalsIgnoreCase("mounted"))
    {
      a(7);
      return true;
    }
    if (adxz.a() < 10L)
    {
      a(6);
      return true;
    }
    return false;
  }
  
  private boolean a(String paramString)
  {
    boolean bool = false;
    if (new File(paramString).length() > axwv.a())
    {
      bbmy.a(this, getResources().getString(2131629431), 0).b(getResources().getDimensionPixelSize(2131167766));
      bool = true;
    }
    return bool;
  }
  
  private void b()
  {
    this.jdField_a_of_type_ComTencentWidgetGallery = new Gallery(this);
    this.jdField_a_of_type_ComTencentWidgetGallery.setSpacing(getResources().getDimensionPixelSize(2131165934));
    this.jdField_a_of_type_AndroidViewViewGroup.addView(this.jdField_a_of_type_ComTencentWidgetGallery, -1, -1);
    this.jdField_a_of_type_Afzq = new afzq(this);
    this.jdField_a_of_type_ComTencentWidgetGallery.setAdapter(this.jdField_a_of_type_Afzq);
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if ((this.jdField_a_of_type_Bafb != null) && (this.jdField_a_of_type_Bafb.isShowing())) {
      this.jdField_a_of_type_Bafb.hide();
    }
    this.jdField_a_of_type_Bafb = null;
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    AbstractGifImage.pauseAll();
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    AbstractGifImage.resumeAll();
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (getIntent().getIntExtra("uintype", 1003) == 8000)
    {
      PhotoUtils.a(this, paramInt1, paramInt2, paramIntent, getIntent().getBooleanExtra("PhotoConst.IS_CALL_IN_PLUGIN", true));
      finish();
      return;
    }
    PhotoUtils.a(this, paramInt1, paramInt2, paramIntent, false);
  }
  
  public void onClick(View paramView) {}
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    a();
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)getLayoutInflater().inflate(2131493814, null));
    b();
    getLayoutInflater().inflate(2131493816, this.jdField_a_of_type_AndroidViewViewGroup);
    this.jdField_a_of_type_Int = getResources().getDisplayMetrics().widthPixels;
    this.jdField_b_of_type_Int = getResources().getDisplayMetrics().heightPixels;
    super.setContentView(this.jdField_a_of_type_AndroidViewViewGroup);
    if (this.jdField_a_of_type_Boolean) {
      setRightButton(2131629458, new afzk(this));
    }
    setTitle(2131629655);
    this.leftView.setVisibility(8);
    this.leftViewNotBack = ((TextView)findViewById(2131302806));
    this.leftViewNotBack.setVisibility(8);
    paramBundle = (TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131305858);
    QLog.d("IphoneTitleBarActivity", 2, "BUILD MODEL:" + Build.MODEL);
    RelativeLayout.LayoutParams localLayoutParams;
    if (this.jdField_a_of_type_JavaLangString != null)
    {
      paramBundle.setText(this.jdField_a_of_type_JavaLangString);
      if (Build.MODEL.equals("PAFM00"))
      {
        localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
        localLayoutParams.setMargins(0, 0, bajq.b(12.0F), 0);
        localLayoutParams.addRule(11);
        paramBundle.setLayoutParams(localLayoutParams);
      }
    }
    paramBundle.setOnClickListener(new afzl(this));
    paramBundle = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131305857);
    if (Build.MODEL.equals("PAFM00"))
    {
      localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(9);
      localLayoutParams.setMargins(bajq.b(12.0F), 0, 0, 0);
      paramBundle.setLayoutParams(localLayoutParams);
    }
    paramBundle.setOnClickListener(new afzm(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.CameraPreviewActivity
 * JD-Core Version:    0.7.0.1
 */