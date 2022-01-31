package com.tencent.mobileqq.app;

import android.content.Context;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import com.tencent.qphone.base.util.QLog;

class BaseActivity$MyRelativeLayout
  extends RelativeLayout
{
  public BaseActivity$MyRelativeLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void b()
  {
    Object localObject = this;
    if (localObject != null)
    {
      QLog.e("qqBaseActivity", 1, "view id: " + ((View)localObject).getId());
      localObject = ((View)localObject).getParent();
      if ((localObject != null) && ((localObject instanceof View))) {}
      for (localObject = (View)localObject;; localObject = null) {
        break;
      }
    }
  }
  
  public void a()
  {
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      QLog.e("qqBaseActivity", 1, "modify view in subThread");
      b();
    }
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    a();
    super.addView(paramView, paramInt, paramLayoutParams);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    try
    {
      super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("qqBaseActivity", 1, "onLayout crash", localException);
      b();
    }
  }
  
  public void removeAllViews()
  {
    a();
    super.removeAllViews();
  }
  
  public void removeView(View paramView)
  {
    a();
    super.removeView(paramView);
  }
  
  public void removeViewInLayout(View paramView)
  {
    a();
    super.removeViewInLayout(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.BaseActivity.MyRelativeLayout
 * JD-Core Version:    0.7.0.1
 */