package com.tencent.aelight.camera.aioeditor.capture.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import com.tencent.aelight.camera.aioeditor.capture.CaptureContext;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleLayout.DoodleEventListener;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import javax.annotation.Nullable;

public abstract class ProviderView
  extends FrameLayout
{
  protected Handler A;
  public boolean B = false;
  protected int C = 206;
  public int D = 0;
  public int E = 2;
  protected ProviderView.ProviderViewListener F;
  private QIMSlidingTabView a;
  private QIMSlidingTabView b;
  public Context r;
  protected AppInterface s;
  protected int t;
  protected boolean u = true;
  protected QIMSlidingTabView v;
  protected View w;
  protected View x;
  protected ViewGroup y;
  protected DoodleLayout.DoodleEventListener z;
  
  public ProviderView(Context paramContext)
  {
    super(paramContext);
    this.r = paramContext;
    this.A = new Handler(ThreadManager.getSubThreadLooper());
  }
  
  public ProviderView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ProviderView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, @AttrRes int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void a()
  {
    this.s = null;
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void a(int paramInt, String paramString1, String paramString2) {}
  
  public void a(Bundle paramBundle)
  {
    this.s = CaptureContext.a();
    if (this.x == null)
    {
      paramBundle = LayoutInflater.from(getContext()).inflate(2131627189, this, false);
      addView(paramBundle);
      this.a = ((QIMSlidingTabView)paramBundle.findViewById(2131440785));
      this.b = ((QIMSlidingTabView)paramBundle.findViewById(2131440782));
      this.y = ((ViewGroup)paramBundle.findViewById(2131440783));
    }
    paramBundle = this.y.getLayoutParams();
    paramBundle.height = UIUtils.a(getContext(), this.C);
    this.y.setLayoutParams(paramBundle);
    if (this.t == 1) {
      paramBundle = this.a;
    } else {
      paramBundle = this.b;
    }
    this.v = paramBundle;
    if (this.u)
    {
      this.v.setVisibility(0);
      if (this.t == 1) {
        findViewById(2131440786).setVisibility(0);
      }
    }
    this.B = true;
    if (QLog.isColorLevel()) {
      QLog.i("ProviderView", 2, "onCreate");
    }
  }
  
  public void a(View paramView)
  {
    ViewGroup localViewGroup = this.y;
    if (localViewGroup != null)
    {
      localViewGroup.addView(paramView);
      return;
    }
    throw new IllegalStateException("no content layout");
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public void b() {}
  
  public void b(Bundle paramBundle)
  {
    if (this.w == null) {
      try
      {
        paramBundle = LayoutInflater.from(getContext()).inflate(2131627189, this, false);
        addView(paramBundle);
        if (this.x == null)
        {
          this.x = paramBundle;
          this.a = ((QIMSlidingTabView)this.x.findViewById(2131440785));
          this.b = ((QIMSlidingTabView)this.x.findViewById(2131440782));
          this.y = ((ViewGroup)this.x.findViewById(2131440783));
        }
        paramBundle = LayoutInflater.from(getContext()).inflate(getInflateLayout(), this, false);
        if (this.w == null)
        {
          this.w = paramBundle;
          return;
        }
      }
      catch (Exception paramBundle)
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("preInflate failed ");
          localStringBuilder.append(paramBundle.toString());
          QLog.e("ProviderView", 2, localStringBuilder.toString());
        }
      }
    }
  }
  
  public void c()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[cc]onProviderShow ");
      localStringBuilder.append(getClass().getSimpleName());
      QLog.d("ProviderView", 2, localStringBuilder.toString());
    }
  }
  
  public void d()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[cc]onProviderDismiss ");
      localStringBuilder.append(getClass().getSimpleName());
      QLog.d("ProviderView", 2, localStringBuilder.toString());
    }
  }
  
  public void d(int paramInt)
  {
    this.C = paramInt;
  }
  
  public void e() {}
  
  public void f() {}
  
  public int getContentHeight()
  {
    return this.C;
  }
  
  protected abstract int getInflateLayout();
  
  public boolean getNeedTabBar()
  {
    return this.u;
  }
  
  public QIMSlidingTabView getmBottomTabBar()
  {
    return this.b;
  }
  
  public boolean k()
  {
    return false;
  }
  
  public boolean l()
  {
    return this.B;
  }
  
  public void setCaptureScene(int paramInt)
  {
    this.D = paramInt;
  }
  
  public void setDoodleEventListener(DoodleLayout.DoodleEventListener paramDoodleEventListener)
  {
    this.z = paramDoodleEventListener;
  }
  
  public void setNeedTabBar(boolean paramBoolean)
  {
    this.u = paramBoolean;
  }
  
  public void setProviderViewListener(ProviderView.ProviderViewListener paramProviderViewListener)
  {
    this.F = paramProviderViewListener;
  }
  
  public void setTabBarPosition(int paramInt)
  {
    this.t = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.view.ProviderView
 * JD-Core Version:    0.7.0.1
 */