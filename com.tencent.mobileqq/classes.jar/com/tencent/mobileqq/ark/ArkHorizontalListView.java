package com.tencent.mobileqq.ark;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.widget.LinearLayout;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.HorizontalListView;
import com.tencent.widget.ListView;
import com.tencent.widget.OverScroller;
import java.lang.ref.WeakReference;

public class ArkHorizontalListView
  extends HorizontalListView
{
  private float jdField_a_of_type_Float = 0.08F;
  private int jdField_a_of_type_Int;
  private WeakReference<ArkHorizontalListView.RefreshUiCallback> jdField_a_of_type_JavaLangRefWeakReference;
  private boolean jdField_a_of_type_Boolean;
  private int b = 3;
  
  public ArkHorizontalListView(Context paramContext)
  {
    super(paramContext);
    paramContext = paramContext.getResources();
    this.jdField_a_of_type_Int = (BaseChatItemLayout.o * 2 + MessageForArkApp.dp2px(40.0F) + paramContext.getDimensionPixelSize(2131296383));
    setStayDisplayOffsetZero(true);
    a();
  }
  
  public ArkHorizontalListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.getResources();
    this.jdField_a_of_type_Int = (BaseChatItemLayout.o * 2 + MessageForArkApp.dp2px(40.0F) + paramContext.getDimensionPixelSize(2131296383));
    setStayDisplayOffsetZero(true);
    a();
  }
  
  private void a() {}
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  protected boolean checkScrollToChild()
  {
    boolean bool1 = this.mStayDisplayOffsetZero;
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    int m = ArkAppCenterUtil.d;
    int i = 0;
    while (i <= getChildCount())
    {
      localObject = getChildAt(i);
      if ((localObject != null) && ((localObject instanceof LinearLayout)))
      {
        i = ((View)localObject).getRight() - ((View)localObject).getLeft();
        break label75;
      }
      i += 1;
    }
    i = 0;
    label75:
    int j;
    if (this.jdField_a_of_type_Boolean) {
      j = ArkAppCenterUtil.d - this.jdField_a_of_type_Int - i / 2;
    } else {
      j = this.jdField_a_of_type_Int + i / 2;
    }
    QLog.d("ArkHorizontalListView", 2, new Object[] { "---start find card mNextX=", Integer.valueOf(this.mNextX), ",scrollStartX=", Integer.valueOf(this.mScroller.getStartX()), ",sRealDisplayWith=", Integer.valueOf(ArkAppCenterUtil.d), ",priovtX=", Integer.valueOf(j), ",mIsSend=", Boolean.valueOf(this.jdField_a_of_type_Boolean) });
    int k = 0;
    Object localObject = null;
    i = 0;
    int n;
    while (i <= getChildCount())
    {
      View localView = getChildAt(i);
      if ((localView != null) && ((localView instanceof LinearLayout)))
      {
        n = (localView.getLeft() + localView.getRight()) / 2;
        int i2 = n - j;
        int i1 = Math.abs(i2);
        if (QLog.isColorLevel()) {
          QLog.d("ArkHorizontalListView", 2, new Object[] { "view index=", Integer.valueOf(i), " view pos(", Integer.valueOf(localView.getLeft()), ",", Integer.valueOf(localView.getRight()), "),viewCenter=", Integer.valueOf(n), ",curDistance=", Integer.valueOf(i1), ",delta=", Integer.valueOf(i2) });
        }
        n = m;
        if (i1 <= m)
        {
          k = i;
          localObject = localView;
          n = i1;
        }
      }
      else
      {
        n = m;
      }
      i += 1;
      m = n;
    }
    bool1 = bool2;
    if (localObject != null)
    {
      n = this.mNextX;
      if (this.jdField_a_of_type_Boolean) {
        j = ((View)localObject).getRight();
      } else {
        j = ((View)localObject).getLeft();
      }
      if (this.jdField_a_of_type_Boolean ? j > ArkAppCenterUtil.d : j < 0) {
        m = 1;
      } else {
        m = 0;
      }
      if (this.jdField_a_of_type_Boolean)
      {
        if (m != 0) {
          i = j - ArkAppCenterUtil.d;
        } else {
          i = ArkAppCenterUtil.d - j;
        }
      }
      else
      {
        i = j;
        if (m != 0) {
          i = -j;
        }
      }
      if (this.jdField_a_of_type_Boolean)
      {
        if (m != 0) {
          i = -(i + this.jdField_a_of_type_Int);
        } else {
          i -= this.jdField_a_of_type_Int;
        }
      }
      else if (m != 0) {
        i += this.jdField_a_of_type_Int;
      } else {
        i = this.jdField_a_of_type_Int - i;
      }
      i = n - i;
      if (QLog.isColorLevel()) {
        QLog.d("ArkHorizontalListView", 2, new Object[] { "---end find card mNextX=", Integer.valueOf(this.mNextX), ", newNextX=", Integer.valueOf(i), ", mIsSend=", Boolean.valueOf(this.jdField_a_of_type_Boolean), ",targetIndex=", Integer.valueOf(k) });
      }
      bool1 = bool2;
      if (this.mScroller.springBack(this.mNextX + getScrollX(), 0, i, i, 0, 0, 1000))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ArkHorizontalListView", 2, "checkScrollToChild springBack return true");
        }
        invalidate();
        bool1 = true;
      }
    }
    post(new ArkHorizontalListView.1(this));
    return bool1;
  }
  
  protected int getFlingVelocity(int paramInt)
  {
    return paramInt / this.b;
  }
  
  protected float getScrollerFriction()
  {
    return this.jdField_a_of_type_Float;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.onInterceptTouchEvent(paramMotionEvent);
    if (paramMotionEvent.getAction() != 0) {
      return bool;
    }
    for (paramMotionEvent = getParent(); !(paramMotionEvent instanceof ListView); paramMotionEvent = paramMotionEvent.getParent()) {}
    paramMotionEvent = paramMotionEvent.getParent();
    if (paramMotionEvent != null) {
      paramMotionEvent.requestDisallowInterceptTouchEvent(true);
    }
    return bool;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    Object localObject = this.jdField_a_of_type_JavaLangRefWeakReference;
    if ((localObject != null) && (((WeakReference)localObject).get() != null))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onTouchEvent updateHeadBorder action=");
        ((StringBuilder)localObject).append(paramMotionEvent.getAction() & 0xFF);
        QLog.d("ArkHorizontalListView", 2, ((StringBuilder)localObject).toString());
      }
      ((ArkHorizontalListView.RefreshUiCallback)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a(this);
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setIsSend(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void setRefreshCallback(ArkHorizontalListView.RefreshUiCallback paramRefreshUiCallback)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramRefreshUiCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkHorizontalListView
 * JD-Core Version:    0.7.0.1
 */