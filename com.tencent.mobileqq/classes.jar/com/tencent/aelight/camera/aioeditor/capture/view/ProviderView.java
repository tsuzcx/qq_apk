package com.tencent.aelight.camera.aioeditor.capture.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.aelight.camera.aioeditor.capture.CaptureContext;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleLayout.DoodleEventListener;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;

public abstract class ProviderView
  extends FrameLayout
{
  public Context a;
  protected View a;
  protected ViewGroup a;
  protected ProviderView.ProviderViewListener a;
  protected QIMSlidingTabView a;
  protected DoodleLayout.DoodleEventListener a;
  protected AppInterface a;
  protected Handler b;
  protected View b;
  private QIMSlidingTabView b;
  private QIMSlidingTabView c;
  protected boolean c;
  public boolean d = false;
  protected int e;
  protected int f = 206;
  public int g = 0;
  public int h = 2;
  
  public ProviderView(Context paramContext)
  {
    super(paramContext);
    this.jdField_c_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_b_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper());
  }
  
  protected abstract int a();
  
  public QIMSlidingTabView a()
  {
    return this.jdField_c_of_type_ComTencentAelightCameraAioeditorCaptureViewQIMSlidingTabView;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = null;
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void a(int paramInt, String paramString1, String paramString2) {}
  
  public void a(Bundle paramBundle)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = CaptureContext.a();
    if (this.jdField_b_of_type_AndroidViewView == null)
    {
      paramBundle = LayoutInflater.from(getContext()).inflate(2131560867, this, false);
      addView(paramBundle);
      this.jdField_b_of_type_ComTencentAelightCameraAioeditorCaptureViewQIMSlidingTabView = ((QIMSlidingTabView)paramBundle.findViewById(2131373175));
      this.jdField_c_of_type_ComTencentAelightCameraAioeditorCaptureViewQIMSlidingTabView = ((QIMSlidingTabView)paramBundle.findViewById(2131373172));
      this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramBundle.findViewById(2131373173));
    }
    paramBundle = this.jdField_a_of_type_AndroidViewViewGroup.getLayoutParams();
    paramBundle.height = UIUtils.a(getContext(), this.f);
    this.jdField_a_of_type_AndroidViewViewGroup.setLayoutParams(paramBundle);
    if (this.e == 1) {
      paramBundle = this.jdField_b_of_type_ComTencentAelightCameraAioeditorCaptureViewQIMSlidingTabView;
    } else {
      paramBundle = this.jdField_c_of_type_ComTencentAelightCameraAioeditorCaptureViewQIMSlidingTabView;
    }
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewQIMSlidingTabView = paramBundle;
    if (this.jdField_c_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewQIMSlidingTabView.setVisibility(0);
      if (this.e == 1) {
        findViewById(2131373176).setVisibility(0);
      }
    }
    this.d = true;
    if (QLog.isColorLevel()) {
      QLog.i("ProviderView", 2, "onCreate");
    }
  }
  
  public void a(View paramView)
  {
    ViewGroup localViewGroup = this.jdField_a_of_type_AndroidViewViewGroup;
    if (localViewGroup != null)
    {
      localViewGroup.addView(paramView);
      return;
    }
    throw new IllegalStateException("no content layout");
  }
  
  public boolean a()
  {
    return false;
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public void b() {}
  
  public void b(Bundle paramBundle)
  {
    if (this.jdField_a_of_type_AndroidViewView == null) {
      try
      {
        paramBundle = LayoutInflater.from(getContext()).inflate(2131560867, this, false);
        addView(paramBundle);
        if (this.jdField_b_of_type_AndroidViewView == null)
        {
          this.jdField_b_of_type_AndroidViewView = paramBundle;
          this.jdField_b_of_type_ComTencentAelightCameraAioeditorCaptureViewQIMSlidingTabView = ((QIMSlidingTabView)this.jdField_b_of_type_AndroidViewView.findViewById(2131373175));
          this.jdField_c_of_type_ComTencentAelightCameraAioeditorCaptureViewQIMSlidingTabView = ((QIMSlidingTabView)this.jdField_b_of_type_AndroidViewView.findViewById(2131373172));
          this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_b_of_type_AndroidViewView.findViewById(2131373173));
        }
        paramBundle = LayoutInflater.from(getContext()).inflate(a(), this, false);
        if (this.jdField_a_of_type_AndroidViewView == null)
        {
          this.jdField_a_of_type_AndroidViewView = paramBundle;
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
  
  public int c()
  {
    return this.f;
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
    this.f = paramInt;
  }
  
  public boolean d()
  {
    return this.d;
  }
  
  public void e() {}
  
  public boolean e()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  public void f() {}
  
  public void setCaptureScene(int paramInt)
  {
    this.g = paramInt;
  }
  
  public void setDoodleEventListener(DoodleLayout.DoodleEventListener paramDoodleEventListener)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout$DoodleEventListener = paramDoodleEventListener;
  }
  
  public void setNeedTabBar(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  public void setProviderViewListener(ProviderView.ProviderViewListener paramProviderViewListener)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewProviderView$ProviderViewListener = paramProviderViewListener;
  }
  
  public void setTabBarPosition(int paramInt)
  {
    this.e = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.view.ProviderView
 * JD-Core Version:    0.7.0.1
 */