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
  private ImageView a;
  private ImageView b;
  private NewerGuideBannerViewModel c;
  private QQProgressDialog d;
  private QQCustomDialog e;
  
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
    this.c = ((NewerGuideBannerViewModel)ViewModelProviderHelper.a(localLifeCycleAndViewModelStoreOwner, NewerGuideBannerViewModel.b).get(NewerGuideBannerViewModel.class));
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
      Utils.a(this.a, null);
      Utils.a(this.a, paramDrawable);
      if (paramBoolean)
      {
        if (this.a.getParent() == null) {
          addView(this.a);
        }
        if (this.b.getParent() == null) {
          addView(this.b);
        }
      }
    }
  }
  
  private void a(LifecycleOwner paramLifecycleOwner)
  {
    this.c.a().observe(paramLifecycleOwner, new NewerGuideBannerView.1(this));
    paramLifecycleOwner.getLifecycle().addObserver(new NewerGuideBannerView.2(this));
  }
  
  private void a(NewerGuideBannerData paramNewerGuideBannerData)
  {
    if (paramNewerGuideBannerData == null) {
      return;
    }
    int i = paramNewerGuideBannerData.a;
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
      a(paramNewerGuideBannerData.d);
      return;
    }
    a(paramNewerGuideBannerData.b, paramNewerGuideBannerData.c);
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
      if (this.d == null)
      {
        this.d = new QQProgressDialog(getContext(), 0, 2131627607, 17);
        this.d.setContentView(2131629210);
        this.d.a(getContext().getString(2131892132));
        this.d.c(false);
        this.d.setCancelable(false);
      }
      this.d.show();
      return;
    }
    catch (Exception localException)
    {
      QLog.d("NewerGuideBannerView", 1, "showProgressDialog exception", localException);
    }
  }
  
  private void b(Context paramContext)
  {
    this.a = new ImageView(paramContext);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, Utils.a(140.0F, getResources()));
    this.a.setLayoutParams(localLayoutParams);
    this.a.setContentDescription(paramContext.getString(2131892131));
    this.b = new ImageView(getContext());
    this.b.setBackgroundDrawable(null);
    this.b.setImageResource(2130851560);
    this.b.setScaleType(ImageView.ScaleType.CENTER);
    int i = Utils.a(24.0F, getResources());
    int j = Utils.a(8.0F, getResources());
    localLayoutParams = new FrameLayout.LayoutParams(i, i);
    localLayoutParams.gravity = 8388661;
    localLayoutParams.rightMargin = j;
    localLayoutParams.topMargin = j;
    this.b.setLayoutParams(localLayoutParams);
    this.b.setOnClickListener(this);
    this.b.setContentDescription(paramContext.getString(2131917019));
    setOnClickListener(this);
  }
  
  private void c()
  {
    try
    {
      if (this.d != null)
      {
        this.d.dismiss();
        this.d = null;
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
      if (this.e == null) {
        this.e = DialogUtil.a(localQBaseActivity, 230, HardCodeUtil.a(2131892134), HardCodeUtil.a(2131892133), HardCodeUtil.a(2131892135), HardCodeUtil.a(2131892136), new NewerGuideBannerView.3(this, localQBaseActivity), new NewerGuideBannerView.4(this, localQBaseActivity));
      }
      if (!localQBaseActivity.isFinishing())
      {
        this.e.show();
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
      if (this.e != null)
      {
        if (this.e.isShowing()) {
          this.e.dismiss();
        }
        this.e = null;
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
    this.c.a(localQBaseActivity, paramGuidelines_8410);
  }
  
  public void onClick(View paramView)
  {
    QBaseActivity localQBaseActivity = (QBaseActivity)getContext();
    if (paramView == this.b) {
      this.c.a(localQBaseActivity.getAppRuntime());
    } else {
      this.c.b(localQBaseActivity);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onThemeChanged()
  {
    this.c.a((QBaseActivity)getContext());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.guidebanner.NewerGuideBannerView
 * JD-Core Version:    0.7.0.1
 */