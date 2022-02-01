package com.tencent.biz.qqcircle.widgets.comment;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class SoftKeyboardStateHelper
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  private final List<SoftKeyboardStateHelper.SoftKeyboardStateListener> a = new LinkedList();
  private final View b;
  private int c;
  private boolean d;
  private int e = 0;
  
  public SoftKeyboardStateHelper(View paramView)
  {
    this(paramView, false);
  }
  
  public SoftKeyboardStateHelper(View paramView, boolean paramBoolean)
  {
    this.b = paramView;
    this.d = paramBoolean;
    paramView.getViewTreeObserver().addOnGlobalLayoutListener(this);
  }
  
  private void a(int paramInt)
  {
    this.c = paramInt;
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      SoftKeyboardStateHelper.SoftKeyboardStateListener localSoftKeyboardStateListener = (SoftKeyboardStateHelper.SoftKeyboardStateListener)localIterator.next();
      if (localSoftKeyboardStateListener != null) {
        localSoftKeyboardStateListener.a(paramInt);
      }
    }
  }
  
  private void b()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      SoftKeyboardStateHelper.SoftKeyboardStateListener localSoftKeyboardStateListener = (SoftKeyboardStateHelper.SoftKeyboardStateListener)localIterator.next();
      if (localSoftKeyboardStateListener != null) {
        localSoftKeyboardStateListener.a();
      }
    }
  }
  
  public void a()
  {
    this.a.clear();
    if (Build.VERSION.SDK_INT < 16)
    {
      this.b.getViewTreeObserver().removeGlobalOnLayoutListener(this);
      return;
    }
    this.b.getViewTreeObserver().removeOnGlobalLayoutListener(this);
  }
  
  public void a(SoftKeyboardStateHelper.SoftKeyboardStateListener paramSoftKeyboardStateListener)
  {
    this.a.add(paramSoftKeyboardStateListener);
  }
  
  public void onGlobalLayout()
  {
    Rect localRect = new Rect();
    this.b.getWindowVisibleDisplayFrame(localRect);
    int i = localRect.height();
    int j = this.e;
    if (j == 0)
    {
      this.e = i;
      return;
    }
    i = j - i;
    if ((!this.d) && (i >= 250))
    {
      this.d = true;
      a(i);
      return;
    }
    if ((this.d) && (i < 100))
    {
      this.d = false;
      b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.comment.SoftKeyboardStateHelper
 * JD-Core Version:    0.7.0.1
 */