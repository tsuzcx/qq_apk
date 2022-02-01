package com.tencent.mobileqq.activity.recent.guidebanner;

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
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.mvvm.ActivityExtKt;
import com.tencent.mobileqq.mvvm.LifeCycleExtKt;
import com.tencent.mobileqq.mvvm.LifeCycleFragment;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.theme.SkinnableView;
import tencent.im.oidb.cmd0x59f.oidb_0x59f.Guidelines_8410;

public class NewerGuideBannerView
  extends FrameLayout
  implements View.OnClickListener, SkinnableView
{
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private NewerGuideBannerViewModel jdField_a_of_type_ComTencentMobileqqActivityRecentGuidebannerNewerGuideBannerViewModel;
  private QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
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
    LifeCycleFragment localLifeCycleFragment = ActivityExtKt.a((FragmentActivity)getContext());
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentGuidebannerNewerGuideBannerViewModel = ((NewerGuideBannerViewModel)LifeCycleExtKt.a(localLifeCycleFragment, NewerGuideBannerViewModel.a).get(NewerGuideBannerViewModel.class));
    a(localLifeCycleFragment);
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
      AIOUtils.a(this.jdField_a_of_type_AndroidWidgetImageView, null);
      AIOUtils.a(this.jdField_a_of_type_AndroidWidgetImageView, paramDrawable);
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
  
  private void a(LifecycleOwner paramLifecycleOwner)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentGuidebannerNewerGuideBannerViewModel.a().observe(paramLifecycleOwner, new NewerGuideBannerView.1(this));
    paramLifecycleOwner.getLifecycle().addObserver(new NewerGuideBannerView.2(this));
  }
  
  private void a(NewerGuideBannerData paramNewerGuideBannerData)
  {
    if (paramNewerGuideBannerData == null) {
      return;
    }
    switch (paramNewerGuideBannerData.jdField_a_of_type_Int)
    {
    default: 
      return;
    case 0: 
      a(paramNewerGuideBannerData.jdField_a_of_type_AndroidGraphicsDrawableDrawable, paramNewerGuideBannerData.jdField_a_of_type_Boolean);
      return;
    case 1: 
      a(paramNewerGuideBannerData.b);
      return;
    }
    d();
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
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(getContext(), 0, 2131561412, 17);
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setContentView(2131562946);
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(getContext().getString(2131694487));
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(false);
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setCancelable(false);
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
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
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, AIOUtils.a(140.0F, getResources()));
    this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(paramContext.getString(2131694486));
    this.b = new ImageView(getContext());
    this.b.setBackgroundDrawable(null);
    this.b.setImageResource(2130849955);
    this.b.setScaleType(ImageView.ScaleType.CENTER);
    int i = AIOUtils.a(24.0F, getResources());
    int j = AIOUtils.a(8.0F, getResources());
    localLayoutParams = new FrameLayout.LayoutParams(i, i);
    localLayoutParams.gravity = 8388661;
    localLayoutParams.rightMargin = j;
    localLayoutParams.topMargin = j;
    this.b.setLayoutParams(localLayoutParams);
    this.b.setOnClickListener(this);
    this.b.setContentDescription(paramContext.getString(2131719734));
    setOnClickListener(this);
  }
  
  private void c()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
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
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(localBaseActivity, 230, HardCodeUtil.a(2131694489), HardCodeUtil.a(2131694488), HardCodeUtil.a(2131694490), HardCodeUtil.a(2131694491), new NewerGuideBannerView.3(this, localBaseActivity), new NewerGuideBannerView.4(this, localBaseActivity));
      }
      if (!localBaseActivity.isFinishing())
      {
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
        ReportController.b(localBaseActivity.app, "dc00898", "", "", "0X800B4E8", "0X800B4E8", 0, 0, "", "", "", "");
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("NewerGuideBannerView", 1, "[showPermissionDeniedDialog] err ", localException);
    }
  }
  
  private void e()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing()) {
          this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
        }
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("NewerGuideBannerView", 1, "[destroyPermissionDialog] err ", localException);
    }
  }
  
  public void a(oidb_0x59f.Guidelines_8410 paramGuidelines_8410)
  {
    BaseActivity localBaseActivity = (BaseActivity)getContext();
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentGuidebannerNewerGuideBannerViewModel.a(localBaseActivity, paramGuidelines_8410);
  }
  
  public void onClick(View paramView)
  {
    BaseActivity localBaseActivity = (BaseActivity)getContext();
    if (paramView == this.b) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentGuidebannerNewerGuideBannerViewModel.a(localBaseActivity.app);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentGuidebannerNewerGuideBannerViewModel.b(localBaseActivity);
    }
  }
  
  public void onThemeChanged()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentGuidebannerNewerGuideBannerViewModel.a((BaseActivity)getContext());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.guidebanner.NewerGuideBannerView
 * JD-Core Version:    0.7.0.1
 */