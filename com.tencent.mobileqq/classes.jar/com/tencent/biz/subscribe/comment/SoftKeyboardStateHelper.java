package com.tencent.biz.subscribe.comment;

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
  private int jdField_a_of_type_Int;
  private final View jdField_a_of_type_AndroidViewView;
  private final List<SoftKeyboardStateHelper.SoftKeyboardStateListener> jdField_a_of_type_JavaUtilList = new LinkedList();
  private boolean jdField_a_of_type_Boolean;
  private int b = 0;
  
  public SoftKeyboardStateHelper(View paramView)
  {
    this(paramView, false);
  }
  
  public SoftKeyboardStateHelper(View paramView, boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_Boolean = paramBoolean;
    paramView.getViewTreeObserver().addOnGlobalLayoutListener(this);
  }
  
  private void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
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
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
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
    this.jdField_a_of_type_JavaUtilList.clear();
    if (Build.VERSION.SDK_INT < 16)
    {
      this.jdField_a_of_type_AndroidViewView.getViewTreeObserver().removeGlobalOnLayoutListener(this);
      return;
    }
    this.jdField_a_of_type_AndroidViewView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
  }
  
  public void a(SoftKeyboardStateHelper.SoftKeyboardStateListener paramSoftKeyboardStateListener)
  {
    this.jdField_a_of_type_JavaUtilList.add(paramSoftKeyboardStateListener);
  }
  
  public void onGlobalLayout()
  {
    Rect localRect = new Rect();
    this.jdField_a_of_type_AndroidViewView.getWindowVisibleDisplayFrame(localRect);
    int i = localRect.height();
    int j = this.b;
    if (j == 0)
    {
      this.b = i;
      return;
    }
    i = j - i;
    if ((!this.jdField_a_of_type_Boolean) && (i >= 250))
    {
      this.jdField_a_of_type_Boolean = true;
      a(i);
      return;
    }
    if ((this.jdField_a_of_type_Boolean) && (i < 100))
    {
      this.jdField_a_of_type_Boolean = false;
      b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.comment.SoftKeyboardStateHelper
 * JD-Core Version:    0.7.0.1
 */