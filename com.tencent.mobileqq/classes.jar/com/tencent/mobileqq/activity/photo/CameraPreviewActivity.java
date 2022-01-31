package com.tencent.mobileqq.activity.photo;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Environment;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.image.AbstractGifImage;
import com.tencent.mobileqq.activity.aio.photo.AIOPhotoListUtils;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.Gallery;
import java.io.File;
import java.util.ArrayList;
import wwa;
import wwb;
import wwc;
import wwd;
import wwe;
import wwf;
import wwg;

public class CameraPreviewActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable = new ColorDrawable(0);
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  public QQCustomDialog a;
  private Gallery jdField_a_of_type_ComTencentWidgetGallery;
  String jdField_a_of_type_JavaLangString = null;
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private wwg jdField_a_of_type_Wwg;
  boolean jdField_a_of_type_Boolean;
  private int b;
  public boolean b;
  
  private void a()
  {
    boolean bool = false;
    Intent localIntent = getIntent();
    this.jdField_b_of_type_Boolean = localIntent.getBooleanExtra("callFromFastImage", false);
    if (this.jdField_b_of_type_Boolean) {
      StatisticConstants.c();
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
      StatisticConstants.a();
    }
  }
  
  private void a(int paramInt)
  {
    String str1;
    String str2;
    if (paramInt == 6)
    {
      str1 = getString(2131433446);
      str2 = getString(2131433447);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this, 230, str1, str2, new wwd(this), null);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setOnCancelListener(new wwe(this));
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setOnDismissListener(new wwf(this));
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
      return;
      if (paramInt == 7)
      {
        str1 = getString(2131433442);
        str2 = getString(2131433443);
      }
      else
      {
        if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
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
    if (AIOPhotoListUtils.a() < 10L)
    {
      a(6);
      return true;
    }
    return false;
  }
  
  private boolean a(String paramString)
  {
    boolean bool = false;
    if (new File(paramString).length() > 19922944L)
    {
      QQToast.a(this, getResources().getString(2131435920), 0).b(getResources().getDimensionPixelSize(2131558448));
      bool = true;
    }
    return bool;
  }
  
  private void b()
  {
    this.jdField_a_of_type_ComTencentWidgetGallery = new Gallery(this);
    this.jdField_a_of_type_ComTencentWidgetGallery.setSpacing(getResources().getDimensionPixelSize(2131558524));
    this.jdField_a_of_type_AndroidViewViewGroup.addView(this.jdField_a_of_type_ComTencentWidgetGallery, -1, -1);
    this.jdField_a_of_type_Wwg = new wwg(this);
    this.jdField_a_of_type_ComTencentWidgetGallery.setAdapter(this.jdField_a_of_type_Wwg);
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing())) {
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
    PhotoUtils.a(this, paramInt1, paramInt2, paramIntent, false);
  }
  
  public void onClick(View paramView) {}
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    a();
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)getLayoutInflater().inflate(2130969176, null));
    b();
    getLayoutInflater().inflate(2130969178, this.jdField_a_of_type_AndroidViewViewGroup);
    this.jdField_a_of_type_Int = getResources().getDisplayMetrics().widthPixels;
    this.jdField_b_of_type_Int = getResources().getDisplayMetrics().heightPixels;
    super.setContentView(this.jdField_a_of_type_AndroidViewViewGroup);
    if (this.jdField_a_of_type_Boolean) {
      setRightButton(2131436109, new wwa(this));
    }
    setTitle(2131434556);
    this.leftView.setVisibility(8);
    this.leftViewNotBack = ((TextView)findViewById(2131363473));
    this.leftViewNotBack.setVisibility(8);
    paramBundle = (TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131365520);
    if (this.jdField_a_of_type_JavaLangString != null) {
      paramBundle.setText(this.jdField_a_of_type_JavaLangString);
    }
    paramBundle.setOnClickListener(new wwb(this));
    this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131365519).setOnClickListener(new wwc(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.CameraPreviewActivity
 * JD-Core Version:    0.7.0.1
 */