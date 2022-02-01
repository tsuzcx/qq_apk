package com.tencent.common.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class InnerFrame
  extends FrameLayout
{
  private Activity a = null;
  private InnerFrameManager b = null;
  private BaseQQAppInterface c = null;
  
  public InnerFrame(Context paramContext)
  {
    super(paramContext);
  }
  
  public InnerFrame(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public InnerFrame(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("InnerFrame", 2, "onResume");
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void a(Intent paramIntent, int paramInt)
  {
    this.a.startActivityForResult(paramIntent, paramInt);
  }
  
  public void a(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("InnerFrame", 2, "onCreate");
    }
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("InnerFrame", 2, "onPause");
    }
  }
  
  public void b(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("InnerFrame", 2, "onStart");
    }
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("InnerFrame", 2, "onStop");
    }
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("InnerFrame", 2, "onDestroy");
    }
  }
  
  protected void e() {}
  
  public Activity getActivity()
  {
    return this.a;
  }
  
  public BaseQQAppInterface getAppIntf()
  {
    return this.c;
  }
  
  public InnerFrameManager getInnerFrameManager()
  {
    return this.b;
  }
  
  public void setActivity(Activity paramActivity)
  {
    if (QLog.isColorLevel()) {
      QLog.d("InnerFrame", 2, "setActivity");
    }
    this.a = paramActivity;
  }
  
  public void setAppIntf(BaseQQAppInterface paramBaseQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("InnerFrame", 2, "setAppIntf");
    }
    this.c = paramBaseQQAppInterface;
    e();
  }
  
  public void setContentView(int paramInt)
  {
    setContentView(LayoutInflater.from(this.a).inflate(paramInt, this, false));
  }
  
  public void setContentView(View paramView)
  {
    if (getChildCount() > 0) {
      removeAllViews();
    }
    addView(paramView);
  }
  
  public void setInnerFrameManager(InnerFrameManager paramInnerFrameManager)
  {
    this.b = paramInnerFrameManager;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.common.app.InnerFrame
 * JD-Core Version:    0.7.0.1
 */