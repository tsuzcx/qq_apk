package com.tencent.biz;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.qphone.base.util.QLog;

public class SoftKeyboardObserver
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  private View a;
  private SoftKeyboardObserver.OnSoftKeyboardToggledListener b;
  private boolean c = false;
  private final int d;
  
  public SoftKeyboardObserver(View paramView, SoftKeyboardObserver.OnSoftKeyboardToggledListener paramOnSoftKeyboardToggledListener)
  {
    this(paramView, paramOnSoftKeyboardToggledListener, UIUtils.a(paramView.getContext(), 160.0F));
  }
  
  public SoftKeyboardObserver(View paramView, SoftKeyboardObserver.OnSoftKeyboardToggledListener paramOnSoftKeyboardToggledListener, int paramInt)
  {
    this.a = paramView;
    this.b = paramOnSoftKeyboardToggledListener;
    this.d = paramInt;
    this.a.getViewTreeObserver().addOnGlobalLayoutListener(this);
  }
  
  public void a()
  {
    this.b = null;
    try
    {
      if (Build.VERSION.SDK_INT >= 16)
      {
        this.a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.d("SoftKeyboardObserver", 1, localThrowable, new Object[0]);
    }
  }
  
  public void onGlobalLayout()
  {
    Rect localRect = new Rect();
    boolean bool = true;
    try
    {
      this.a.getWindowVisibleDisplayFrame(localRect);
      int i = this.a.getRootView().getHeight();
      int j = localRect.bottom;
      int k = localRect.top;
      if (this.b != null)
      {
        if (i - (j - k) < this.d) {
          bool = false;
        }
        if (bool != this.c)
        {
          this.c = bool;
          this.b.a(bool, localRect.right, localRect.bottom);
        }
      }
      return;
    }
    catch (NullPointerException localNullPointerException)
    {
      QLog.e("SoftKeyboardObserver", 1, "getWindowVisibleDisplayFrame error", localNullPointerException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.SoftKeyboardObserver
 * JD-Core Version:    0.7.0.1
 */