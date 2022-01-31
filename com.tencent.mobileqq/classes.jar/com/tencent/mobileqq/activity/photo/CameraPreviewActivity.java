package com.tencent.mobileqq.activity.photo;

import aeiw;
import aglg;
import aglh;
import agli;
import aglj;
import aglk;
import agll;
import aglm;
import agqd;
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
import ayxe;
import bbdj;
import bbgu;
import bbll;
import bcql;
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
  private aglm jdField_a_of_type_Aglm;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable = new ColorDrawable(0);
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  public bbgu a;
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
      agqd.c();
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
      agqd.a();
    }
  }
  
  private void a(int paramInt)
  {
    String str1;
    String str2;
    if (paramInt == 6)
    {
      str1 = getString(2131719062);
      str2 = getString(2131719061);
    }
    for (;;)
    {
      this.jdField_a_of_type_Bbgu = bbdj.a(this, 230, str1, str2, new aglj(this), null);
      this.jdField_a_of_type_Bbgu.setOnCancelListener(new aglk(this));
      this.jdField_a_of_type_Bbgu.setOnDismissListener(new agll(this));
      this.jdField_a_of_type_Bbgu.show();
      return;
      if (paramInt == 7)
      {
        str1 = getString(2131719064);
        str2 = getString(2131719063);
      }
      else
      {
        if (this.jdField_a_of_type_Bbgu != null)
        {
          this.jdField_a_of_type_Bbgu.dismiss();
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
    if (aeiw.a() < 10L)
    {
      a(6);
      return true;
    }
    return false;
  }
  
  private boolean a(String paramString)
  {
    boolean bool = false;
    if (new File(paramString).length() > ayxe.a())
    {
      bcql.a(this, getResources().getString(2131695113), 0).b(getResources().getDimensionPixelSize(2131298865));
      bool = true;
    }
    return bool;
  }
  
  private void b()
  {
    this.jdField_a_of_type_ComTencentWidgetGallery = new Gallery(this);
    this.jdField_a_of_type_ComTencentWidgetGallery.setSpacing(getResources().getDimensionPixelSize(2131297009));
    this.jdField_a_of_type_AndroidViewViewGroup.addView(this.jdField_a_of_type_ComTencentWidgetGallery, -1, -1);
    this.jdField_a_of_type_Aglm = new aglm(this);
    this.jdField_a_of_type_ComTencentWidgetGallery.setAdapter(this.jdField_a_of_type_Aglm);
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if ((this.jdField_a_of_type_Bbgu != null) && (this.jdField_a_of_type_Bbgu.isShowing())) {
      this.jdField_a_of_type_Bbgu.hide();
    }
    this.jdField_a_of_type_Bbgu = null;
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
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)getLayoutInflater().inflate(2131559382, null));
    b();
    getLayoutInflater().inflate(2131559384, this.jdField_a_of_type_AndroidViewViewGroup);
    this.jdField_a_of_type_Int = getResources().getDisplayMetrics().widthPixels;
    this.jdField_b_of_type_Int = getResources().getDisplayMetrics().heightPixels;
    super.setContentView(this.jdField_a_of_type_AndroidViewViewGroup);
    if (this.jdField_a_of_type_Boolean) {
      setRightButton(2131695140, new aglg(this));
    }
    setTitle(2131695337);
    this.leftView.setVisibility(8);
    this.leftViewNotBack = ((TextView)findViewById(2131368431));
    this.leftViewNotBack.setVisibility(8);
    paramBundle = (TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131371554);
    QLog.d("IphoneTitleBarActivity", 2, "BUILD MODEL:" + Build.MODEL);
    RelativeLayout.LayoutParams localLayoutParams;
    if (this.jdField_a_of_type_JavaLangString != null)
    {
      paramBundle.setText(this.jdField_a_of_type_JavaLangString);
      if (Build.MODEL.equals("PAFM00"))
      {
        localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
        localLayoutParams.setMargins(0, 0, bbll.b(12.0F), 0);
        localLayoutParams.addRule(11);
        paramBundle.setLayoutParams(localLayoutParams);
      }
    }
    paramBundle.setOnClickListener(new aglh(this));
    paramBundle = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131371553);
    if (Build.MODEL.equals("PAFM00"))
    {
      localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(9);
      localLayoutParams.setMargins(bbll.b(12.0F), 0, 0, 0);
      paramBundle.setLayoutParams(localLayoutParams);
    }
    paramBundle.setOnClickListener(new agli(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.CameraPreviewActivity
 * JD-Core Version:    0.7.0.1
 */