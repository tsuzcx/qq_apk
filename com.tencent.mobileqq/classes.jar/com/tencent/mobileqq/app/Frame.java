package com.tencent.mobileqq.app;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.utils.BlurUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQBlurView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.app.AppRuntime;
import mqq.app.Constants.LogoutReason;

public abstract class Frame
{
  private static IFrameInjectInterface c;
  private QBaseActivity a;
  public AppRuntime aF;
  protected boolean aG;
  protected QQBlurView aH;
  private View b;
  
  static
  {
    try
    {
      if (FrameInjectUtil.a.size() > 0)
      {
        c = (IFrameInjectInterface)((Class)FrameInjectUtil.a.get(0)).newInstance();
        QLog.d("Frame", 1, "FrameInjectUtil newInstance");
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.e("Frame", 1, "FrameInjectUtil static statement: ", localException);
    }
  }
  
  public final QBaseActivity P()
  {
    return this.a;
  }
  
  public Resources Q()
  {
    return this.a.getResources();
  }
  
  public void R()
  {
    this.a.finish();
  }
  
  public void S()
  {
    Object localObject = this.b;
    if (localObject != null)
    {
      localObject = ((View)localObject).getAnimation();
      if (localObject != null) {
        ((Animation)localObject).setAnimationListener(null);
      }
      this.b.clearAnimation();
    }
    c.a(this);
  }
  
  protected void T() {}
  
  public View a(LayoutInflater paramLayoutInflater)
  {
    return null;
  }
  
  protected void a()
  {
    this.aF = this.a.getAppRuntime();
  }
  
  protected void a(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void a(Intent paramIntent)
  {
    this.a.startActivity(paramIntent);
  }
  
  public void a(Configuration paramConfiguration) {}
  
  void a(View paramView)
  {
    this.b = paramView;
  }
  
  public void a(View paramView, boolean paramBoolean)
  {
    if (paramView != null)
    {
      if (paramBoolean)
      {
        paramView.setBackgroundResource(2130852228);
        return;
      }
      paramView.setBackgroundColor(Q().getColor(2131168092));
    }
  }
  
  protected void a(TextView paramTextView)
  {
    if (paramTextView == null) {
      return;
    }
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramTextView.getLayoutParams();
    if (QQTheme.isNowSimpleUI())
    {
      localLayoutParams.leftMargin = ViewUtils.dip2px(54.0F);
      localLayoutParams.removeRule(13);
      paramTextView.setLayoutParams(localLayoutParams);
      paramTextView.setTextSize(20.0F);
      return;
    }
    localLayoutParams.leftMargin = 0;
    localLayoutParams.addRule(13);
    paramTextView.setLayoutParams(localLayoutParams);
    paramTextView.setTextSize(17.0F);
  }
  
  protected void a(QBaseActivity paramQBaseActivity)
  {
    this.a = paramQBaseActivity;
  }
  
  protected void a(QQBlurView paramQQBlurView, View paramView)
  {
    a(paramQQBlurView, paramView, null);
  }
  
  protected void a(QQBlurView paramQQBlurView, View paramView, View[] paramArrayOfView)
  {
    if (paramQQBlurView == null)
    {
      QLog.e("Frame", 1, "dealBlurTitleBar: blurView is null");
      return;
    }
    if ((QQTheme.isSimpleWhite()) && (BlurUtil.a()))
    {
      paramQQBlurView.setVisibility(0);
      paramQQBlurView.a(paramView);
      paramQQBlurView.b(paramQQBlurView);
      paramQQBlurView.a(8);
      paramQQBlurView.c(-1);
      paramView = new ColorDrawable(Q().getColor(2131168092));
      paramView.setAlpha(229);
      paramQQBlurView.a(paramView);
      paramQQBlurView.setInitBlurColorDrawable(paramView);
      paramQQBlurView.setEnableBlur(true);
      if (paramArrayOfView != null) {
        paramQQBlurView.setDirtyListener(new Frame.2(this, paramArrayOfView));
      }
      paramQQBlurView.d();
      return;
    }
    paramQQBlurView.setVisibility(8);
  }
  
  protected void a(Runnable paramRunnable)
  {
    View localView = this.b;
    if (localView != null) {
      localView.post(paramRunnable);
    }
  }
  
  protected void a(Constants.LogoutReason paramLogoutReason) {}
  
  public void a(boolean paramBoolean)
  {
    this.aG = true;
    if (Build.VERSION.SDK_INT >= 15) {
      c.a(this, false);
    }
    QQBlurView localQQBlurView = this.aH;
    if (localQQBlurView != null) {
      localQQBlurView.a();
    }
  }
  
  public void b(Runnable paramRunnable)
  {
    this.a.runOnUiThread(paramRunnable);
  }
  
  public abstract void b(boolean paramBoolean);
  
  public void bQ_()
  {
    this.aG = false;
    if (Build.VERSION.SDK_INT >= 15) {
      c.a(this, true);
    }
    QQBlurView localQQBlurView = this.aH;
    if (localQQBlurView != null) {
      localQQBlurView.b();
    }
  }
  
  protected void bS_() {}
  
  public void c()
  {
    if (this.aG) {
      bQ_();
    }
  }
  
  public void cx_() {}
  
  protected String cy_()
  {
    return null;
  }
  
  public boolean cz_()
  {
    return true;
  }
  
  public View d(int paramInt)
  {
    return this.b.findViewById(paramInt);
  }
  
  protected void d()
  {
    QQBlurView localQQBlurView = this.aH;
    if (localQQBlurView != null) {
      localQQBlurView.c();
    }
  }
  
  public String e(int paramInt)
  {
    return this.a.getString(paramInt);
  }
  
  protected void f()
  {
    k();
    AppRuntime localAppRuntime1 = this.aF;
    this.aF = this.a.getAppRuntime();
    AppRuntime localAppRuntime2 = this.aF;
    boolean bool;
    if ((localAppRuntime1 != null) && (localAppRuntime2 != null)) {
      bool = TextUtils.equals(localAppRuntime1.getAccount(), localAppRuntime2.getAccount()) ^ true;
    } else {
      bool = false;
    }
    b(bool);
  }
  
  public boolean h()
  {
    return c.a();
  }
  
  protected void k() {}
  
  public void v() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.Frame
 * JD-Core Version:    0.7.0.1
 */