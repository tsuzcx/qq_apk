package com.tencent.mobileqq.activity.recent.guidebanner;

import alkb;
import alkl;
import alkm;
import alkn;
import alko;
import alkp;
import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.app.FragmentActivity;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import anvx;
import axnd;
import axne;
import bdla;
import bhdj;
import bisl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.mvvm.LifeCycleFragment;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.theme.SkinnableView;
import tencent.im.oidb.cmd0x59f.oidb_0x59f.Guidelines_8410;

public class NewerGuideBannerView
  extends FrameLayout
  implements View.OnClickListener, SkinnableView
{
  private alkp jdField_a_of_type_Alkp;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private bisl jdField_a_of_type_Bisl;
  private QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  private ImageView b;
  
  public NewerGuideBannerView(@NonNull Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public NewerGuideBannerView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public NewerGuideBannerView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a()
  {
    LifeCycleFragment localLifeCycleFragment = axnd.a((FragmentActivity)getContext());
    this.jdField_a_of_type_Alkp = ((alkp)axne.a(localLifeCycleFragment).get(alkp.class));
    a(localLifeCycleFragment);
  }
  
  private void a(alkb paramalkb)
  {
    if (paramalkb == null) {
      return;
    }
    switch (paramalkb.jdField_a_of_type_Int)
    {
    default: 
      return;
    case 0: 
      a(paramalkb.jdField_a_of_type_AndroidGraphicsDrawableDrawable, paramalkb.jdField_a_of_type_Boolean);
      return;
    case 1: 
      a(paramalkb.b);
      return;
    }
    d();
  }
  
  private void a(LifecycleOwner paramLifecycleOwner)
  {
    this.jdField_a_of_type_Alkp.a().observe(paramLifecycleOwner, new alkl(this));
    paramLifecycleOwner.getLifecycle().addObserver(new alkm(this));
  }
  
  private void a(Context paramContext)
  {
    b(paramContext);
    a();
  }
  
  private void a(Drawable paramDrawable, boolean paramBoolean)
  {
    if (paramDrawable != null)
    {
      AIOUtils.setViewDrawable(this.jdField_a_of_type_AndroidWidgetImageView, null);
      AIOUtils.setViewDrawable(this.jdField_a_of_type_AndroidWidgetImageView, paramDrawable);
      if (paramBoolean)
      {
        if (this.jdField_a_of_type_AndroidWidgetImageView.getParent() == null) {
          addView(this.jdField_a_of_type_AndroidWidgetImageView);
        }
        if (this.b.getParent() == null) {
          addView(this.b);
        }
      }
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      b();
      return;
    }
    c();
  }
  
  private void b()
  {
    try
    {
      if (this.jdField_a_of_type_Bisl == null)
      {
        this.jdField_a_of_type_Bisl = new bisl(getContext(), 0, 2131561307, 17);
        this.jdField_a_of_type_Bisl.setContentView(2131562799);
        this.jdField_a_of_type_Bisl.a(getContext().getString(2131694283));
        this.jdField_a_of_type_Bisl.c(false);
        this.jdField_a_of_type_Bisl.setCancelable(false);
      }
      this.jdField_a_of_type_Bisl.show();
      return;
    }
    catch (Exception localException)
    {
      QLog.d("NewerGuideBannerView", 1, "showProgressDialog exception", localException);
    }
  }
  
  private void b(Context paramContext)
  {
    this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(paramContext);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, AIOUtils.dp2px(140.0F, getResources()));
    this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(paramContext.getString(2131694282));
    this.b = new ImageView(getContext());
    this.b.setBackgroundDrawable(null);
    this.b.setImageResource(2130849564);
    this.b.setScaleType(ImageView.ScaleType.CENTER);
    int i = AIOUtils.dp2px(24.0F, getResources());
    int j = AIOUtils.dp2px(8.0F, getResources());
    localLayoutParams = new FrameLayout.LayoutParams(i, i);
    localLayoutParams.gravity = 8388661;
    localLayoutParams.rightMargin = j;
    localLayoutParams.topMargin = j;
    this.b.setLayoutParams(localLayoutParams);
    this.b.setOnClickListener(this);
    this.b.setContentDescription(paramContext.getString(2131719177));
    setOnClickListener(this);
  }
  
  private void c()
  {
    try
    {
      if (this.jdField_a_of_type_Bisl != null)
      {
        this.jdField_a_of_type_Bisl.dismiss();
        this.jdField_a_of_type_Bisl = null;
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.d("NewerGuideBannerView", 1, "hideProgressDialog exception", localException);
    }
  }
  
  private void d()
  {
    try
    {
      BaseActivity localBaseActivity = (BaseActivity)getContext();
      if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog == null) {
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = bhdj.a(localBaseActivity, 230, anvx.a(2131694285), anvx.a(2131694284), anvx.a(2131694286), anvx.a(2131694287), new alkn(this, localBaseActivity), new alko(this, localBaseActivity));
      }
      if (!localBaseActivity.isFinishing())
      {
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
        bdla.b(localBaseActivity.app, "dc00898", "", "", "0X800B4E8", "0X800B4E8", 0, 0, "", "", "", "");
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("NewerGuideBannerView", 1, "[showPermissionDeniedDialog] err ", localException);
    }
  }
  
  public void a(oidb_0x59f.Guidelines_8410 paramGuidelines_8410)
  {
    BaseActivity localBaseActivity = (BaseActivity)getContext();
    this.jdField_a_of_type_Alkp.a(localBaseActivity, paramGuidelines_8410);
  }
  
  public void onClick(View paramView)
  {
    BaseActivity localBaseActivity = (BaseActivity)getContext();
    if (paramView == this.b) {
      this.jdField_a_of_type_Alkp.a(localBaseActivity.app);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.jdField_a_of_type_Alkp.b(localBaseActivity);
    }
  }
  
  public void onThemeChanged()
  {
    this.jdField_a_of_type_Alkp.a((BaseActivity)getContext());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.guidebanner.NewerGuideBannerView
 * JD-Core Version:    0.7.0.1
 */