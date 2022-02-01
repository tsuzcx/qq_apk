package com.tencent.mobileqq.activity.recent.guidebanner;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import androidx.annotation.Nullable;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.mvvm.LifeCycleAndViewModelStoreOwner;
import com.tencent.mobileqq.mvvm.QLifeCycleFragment;
import com.tencent.mobileqq.mvvm.ViewModelProviderHelper;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.Utils;
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
    LifeCycleAndViewModelStoreOwner localLifeCycleAndViewModelStoreOwner = QLifeCycleFragment.a((QBaseActivity)getContext());
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentGuidebannerNewerGuideBannerViewModel = ((NewerGuideBannerViewModel)ViewModelProviderHelper.a(localLifeCycleAndViewModelStoreOwner, NewerGuideBannerViewModel.a).get(NewerGuideBannerViewModel.class));
    a(localLifeCycleAndViewModelStoreOwner);
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
      Utils.a(this.jdField_a_of_type_AndroidWidgetImageView, null);
      Utils.a(this.jdField_a_of_type_AndroidWidgetImageView, paramDrawable);
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
    int i = paramNewerGuideBannerData.jdField_a_of_type_Int;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2) {
          return;
        }
        d();
        return;
      }
      a(paramNewerGuideBannerData.b);
      return;
    }
    a(paramNewerGuideBannerData.jdField_a_of_type_AndroidGraphicsDrawableDrawable, paramNewerGuideBannerData.jdField_a_of_type_Boolean);
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
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(getContext(), 0, 2131561251, 17);
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setContentView(2131562765);
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(getContext().getString(2131694452));
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
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, Utils.a(140.0F, getResources()));
    this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(paramContext.getString(2131694451));
    this.b = new ImageView(getContext());
    this.b.setBackgroundDrawable(null);
    this.b.setImageResource(2130849853);
    this.b.setScaleType(ImageView.ScaleType.CENTER);
    int i = Utils.a(24.0F, getResources());
    int j = Utils.a(8.0F, getResources());
    localLayoutParams = new FrameLayout.LayoutParams(i, i);
    localLayoutParams.gravity = 8388661;
    localLayoutParams.rightMargin = j;
    localLayoutParams.topMargin = j;
    this.b.setLayoutParams(localLayoutParams);
    this.b.setOnClickListener(this);
    this.b.setContentDescription(paramContext.getString(2131719458));
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
        return;
      }
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
      QBaseActivity localQBaseActivity = (QBaseActivity)getContext();
      if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog == null) {
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(localQBaseActivity, 230, HardCodeUtil.a(2131694454), HardCodeUtil.a(2131694453), HardCodeUtil.a(2131694455), HardCodeUtil.a(2131694456), new NewerGuideBannerView.3(this, localQBaseActivity), new NewerGuideBannerView.4(this, localQBaseActivity));
      }
      if (!localQBaseActivity.isFinishing())
      {
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
        ReportController.b(localQBaseActivity.getAppRuntime(), "dc00898", "", "", "0X800B4E8", "0X800B4E8", 0, 0, "", "", "", "");
        return;
      }
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
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.e("NewerGuideBannerView", 1, "[destroyPermissionDialog] err ", localException);
    }
  }
  
  public void a(oidb_0x59f.Guidelines_8410 paramGuidelines_8410)
  {
    QBaseActivity localQBaseActivity = (QBaseActivity)getContext();
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentGuidebannerNewerGuideBannerViewModel.a(localQBaseActivity, paramGuidelines_8410);
  }
  
  public void onClick(View paramView)
  {
    QBaseActivity localQBaseActivity = (QBaseActivity)getContext();
    if (paramView == this.b) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentGuidebannerNewerGuideBannerViewModel.a(localQBaseActivity.getAppRuntime());
    } else {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentGuidebannerNewerGuideBannerViewModel.b(localQBaseActivity);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onThemeChanged()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentGuidebannerNewerGuideBannerViewModel.a((QBaseActivity)getContext());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.guidebanner.NewerGuideBannerView
 * JD-Core Version:    0.7.0.1
 */