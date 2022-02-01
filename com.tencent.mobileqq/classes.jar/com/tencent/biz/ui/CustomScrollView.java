package com.tencent.biz.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import androidx.lifecycle.MutableLiveData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.OverScroller;

@TargetApi(9)
public class CustomScrollView
  extends RelativeLayout
  implements TouchWebView.OnOverScrollHandler
{
  DisplayMetrics a;
  public MutableLiveData<Integer> b = new MutableLiveData();
  private OverScroller c;
  private boolean d = true;
  
  public CustomScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet);
  }
  
  public CustomScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet);
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(" springBack y:");
      localStringBuilder.append(paramInt);
      QLog.d("CustomScrollView", 2, localStringBuilder.toString());
    }
    if (this.c.springBack(getScrollX(), getScrollY(), 0, 0, -paramInt, 0)) {
      invalidate();
    }
  }
  
  protected void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    if (Build.VERSION.SDK_INT >= 9) {
      setOverScrollMode(0);
    }
    this.c = new OverScroller(getContext());
    try
    {
      this.a = new DisplayMetrics();
      ((WindowManager)getContext().getSystemService("window")).getDefaultDisplay().getMetrics(this.a);
      return;
    }
    catch (Throwable paramContext) {}
  }
  
  public void a(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  protected boolean a()
  {
    return true;
  }
  
  public void computeScroll()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CustomScrollView", 2, " computeScroll:");
    }
    OverScroller localOverScroller = this.c;
    if ((localOverScroller != null) && (localOverScroller.computeScrollOffset()))
    {
      int i = getScrollX();
      int j = getScrollY();
      int k = this.c.getCurrX();
      int m = this.c.getCurrY();
      if (((i != k) || (j != m)) && (Build.VERSION.SDK_INT >= 9)) {
        overScrollBy(k - i, m - j, i, j, 0, 0, 0, 5000, false);
      }
      postInvalidate();
    }
  }
  
  public void onBack()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CustomScrollView", 2, "onBack:");
    }
    if (this.c.springBack(getScrollX(), getScrollY(), 0, 0, 0, 0)) {
      invalidate();
    }
  }
  
  public void onOverScroll(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(" onOverScroll y:");
      localStringBuilder.append(paramInt);
      QLog.d("CustomScrollView", 2, localStringBuilder.toString());
    }
    if ((this.d) && (Build.VERSION.SDK_INT >= 9))
    {
      int i = paramInt;
      if (getScrollY() + paramInt > 0) {
        i = -getScrollY();
      }
      if (a()) {
        overScrollBy(0, i, getScrollX(), getScrollY(), 0, 0, 0, 5000, true);
      }
    }
  }
  
  protected void onOverScrolled(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CustomScrollView", 2, " onOverScrolled");
    }
    this.b.postValue(Integer.valueOf(paramInt2));
    if (!this.c.isFinished())
    {
      super.scrollTo(paramInt1, paramInt2);
      if ((paramBoolean1) || (paramBoolean2)) {
        this.c.springBack(getScrollX(), getScrollY(), 0, 0, 0, 0);
      }
    }
    else
    {
      super.scrollTo(paramInt1, paramInt2);
    }
    awakenScrollBars();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.ui.CustomScrollView
 * JD-Core Version:    0.7.0.1
 */