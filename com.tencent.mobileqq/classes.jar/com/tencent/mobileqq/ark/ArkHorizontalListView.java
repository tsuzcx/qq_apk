package com.tencent.mobileqq.ark;

import alta;
import alto;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.widget.LinearLayout;
import bftl;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.HorizontalListView;
import com.tencent.widget.ListView;
import java.lang.ref.WeakReference;

public class ArkHorizontalListView
  extends HorizontalListView
{
  private float jdField_a_of_type_Float = 0.08F;
  private int jdField_a_of_type_Int;
  private WeakReference<alto> jdField_a_of_type_JavaLangRefWeakReference;
  private boolean jdField_a_of_type_Boolean;
  private int b = 3;
  
  public ArkHorizontalListView(Context paramContext)
  {
    super(paramContext);
    paramContext = paramContext.getResources();
    int i = BaseChatItemLayout.n;
    int j = MessageForArkApp.dp2px(40.0F);
    this.jdField_a_of_type_Int = (paramContext.getDimensionPixelSize(2131296291) + (i * 2 + j));
    setStayDisplayOffsetZero(true);
    a();
  }
  
  public ArkHorizontalListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.getResources();
    int i = BaseChatItemLayout.n;
    int j = MessageForArkApp.dp2px(40.0F);
    this.jdField_a_of_type_Int = (paramContext.getDimensionPixelSize(2131296291) + (i * 2 + j));
    setStayDisplayOffsetZero(true);
    a();
  }
  
  private void a() {}
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean checkScrollToChild()
  {
    if (!this.mStayDisplayOffsetZero) {
      return false;
    }
    Object localObject = null;
    int j = alta.d;
    int i = 0;
    View localView;
    if (i <= getChildCount())
    {
      localView = getChildAt(i);
      if ((localView == null) || (!(localView instanceof LinearLayout))) {}
    }
    label646:
    label656:
    for (i = localView.getRight() - localView.getLeft();; i = 0)
    {
      int k;
      label78:
      int m;
      label172:
      int n;
      if (this.jdField_a_of_type_Boolean)
      {
        k = alta.d - this.jdField_a_of_type_Int - i / 2;
        QLog.d("ArkHorizontalListView", 2, new Object[] { "---start find card mNextX=", Integer.valueOf(this.mNextX), ",scrollStartX=", Integer.valueOf(this.mScroller.c()), ",sRealDisplayWith=", Integer.valueOf(alta.d), ",priovtX=", Integer.valueOf(k), ",mIsSend=", Boolean.valueOf(this.jdField_a_of_type_Boolean) });
        i = 0;
        m = 0;
        if (i > getChildCount()) {
          break label378;
        }
        localView = getChildAt(i);
        if ((localView == null) || (!(localView instanceof LinearLayout))) {
          break label686;
        }
        int i1 = (localView.getLeft() + localView.getRight()) / 2;
        int i2 = i1 - k;
        n = Math.abs(i2);
        if (QLog.isColorLevel()) {
          QLog.d("ArkHorizontalListView", 2, new Object[] { "view index=", Integer.valueOf(i), " view pos(", Integer.valueOf(localView.getLeft()), ",", Integer.valueOf(localView.getRight()), "),viewCenter=", Integer.valueOf(i1), ",curDistance=", Integer.valueOf(n), ",delta=", Integer.valueOf(i2) });
        }
        if (n > j) {
          break label686;
        }
        m = i;
        localObject = localView;
        j = n;
      }
      label418:
      label680:
      label686:
      for (;;)
      {
        i += 1;
        break label172;
        i += 1;
        break;
        k = this.jdField_a_of_type_Int;
        k = i / 2 + k;
        break label78;
        label378:
        if (localObject != null)
        {
          n = this.mNextX;
          if (this.jdField_a_of_type_Boolean)
          {
            k = localObject.getRight();
            if (!this.jdField_a_of_type_Boolean) {
              break label611;
            }
            if (k <= alta.d) {
              break label606;
            }
            i = 1;
            if (!this.jdField_a_of_type_Boolean) {
              break label634;
            }
            if (i == 0) {
              break label625;
            }
            j = k - alta.d;
            if (!this.jdField_a_of_type_Boolean) {
              break label656;
            }
            if (i == 0) {
              break label646;
            }
            i = -(j + this.jdField_a_of_type_Int);
            i = n - i;
            if (QLog.isColorLevel()) {
              QLog.d("ArkHorizontalListView", 2, new Object[] { "---end find card mNextX=", Integer.valueOf(this.mNextX), ", newNextX=", Integer.valueOf(i), ", mIsSend=", Boolean.valueOf(this.jdField_a_of_type_Boolean), ",targetIndex=", Integer.valueOf(m) });
            }
            if (!this.mScroller.a(this.mNextX + getScrollX(), 0, i, i, 0, 0, 1000)) {
              break label680;
            }
            if (QLog.isColorLevel()) {
              QLog.d("ArkHorizontalListView", 2, "checkScrollToChild springBack return true");
            }
            invalidate();
          }
        }
        label435:
        label454:
        for (boolean bool = true;; bool = false)
        {
          post(new ArkHorizontalListView.1(this));
          return bool;
          k = localObject.getLeft();
          break;
          label606:
          i = 0;
          break label418;
          label611:
          if (k < 0)
          {
            i = 1;
            break label418;
          }
          i = 0;
          break label418;
          label625:
          j = alta.d - k;
          break label435;
          label634:
          j = k;
          if (i == 0) {
            break label435;
          }
          j = -k;
          break label435;
          i = j - this.jdField_a_of_type_Int;
          break label454;
          if (i != 0)
          {
            i = j + this.jdField_a_of_type_Int;
            break label454;
          }
          i = this.jdField_a_of_type_Int - j;
          break label454;
        }
      }
    }
  }
  
  public int getFlingVelocity(int paramInt)
  {
    return paramInt / this.b;
  }
  
  public float getScrollerFriction()
  {
    return this.jdField_a_of_type_Float;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.onInterceptTouchEvent(paramMotionEvent);
    switch (paramMotionEvent.getAction())
    {
    }
    do
    {
      return bool;
      for (paramMotionEvent = getParent(); !(paramMotionEvent instanceof ListView); paramMotionEvent = paramMotionEvent.getParent()) {}
      paramMotionEvent = paramMotionEvent.getParent();
    } while (paramMotionEvent == null);
    paramMotionEvent.requestDisallowInterceptTouchEvent(true);
    return bool;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ArkHorizontalListView", 2, "onTouchEvent updateHeadBorder action=" + (paramMotionEvent.getAction() & 0xFF));
      }
      ((alto)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a(this);
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setIsSend(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void setRefreshCallback(alto paramalto)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramalto);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkHorizontalListView
 * JD-Core Version:    0.7.0.1
 */