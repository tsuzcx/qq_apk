package com.tencent.mobileqq.ark;

import abbc;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.widget.LinearLayout;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
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
  private WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  private int b = 3;
  private boolean e;
  
  public ArkHorizontalListView(Context paramContext)
  {
    super(paramContext);
    paramContext = paramContext.getResources();
    int i = BaseChatItemLayout.n;
    int j = AIOUtils.a(40.0F, paramContext);
    this.jdField_a_of_type_Int = (paramContext.getDimensionPixelSize(2131558619) + (i * 2 + j));
    setStayDisplayOffsetZero(true);
    a();
  }
  
  public ArkHorizontalListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.getResources();
    int i = BaseChatItemLayout.n;
    int j = AIOUtils.a(40.0F, paramContext);
    this.jdField_a_of_type_Int = (paramContext.getDimensionPixelSize(2131558619) + (i * 2 + j));
    setStayDisplayOffsetZero(true);
    a();
  }
  
  private void a() {}
  
  protected float a()
  {
    return this.jdField_a_of_type_Float;
  }
  
  protected int a(int paramInt)
  {
    return paramInt / this.b;
  }
  
  protected boolean a()
  {
    boolean bool2 = false;
    if (!this.c) {
      return false;
    }
    Object localObject = null;
    int i = BaseChatItemLayout.c;
    int j = 0;
    int k;
    if (j <= getChildCount())
    {
      View localView = getChildAt(j);
      if ((localView == null) || (!(localView instanceof LinearLayout))) {
        break label382;
      }
      k = Math.abs((localView.getLeft() + localView.getRight()) / 2 % BaseChatItemLayout.c - BaseChatItemLayout.c / 2);
      if (k >= i) {
        break label382;
      }
      localObject = localView;
      i = k;
    }
    label138:
    label155:
    label299:
    label308:
    label313:
    label327:
    label336:
    label348:
    label358:
    label382:
    for (;;)
    {
      j += 1;
      break;
      boolean bool1 = bool2;
      int m;
      if (localObject != null)
      {
        m = this.h;
        if (!this.e) {
          break label299;
        }
        k = localObject.getRight();
        if (!this.e) {
          break label313;
        }
        if (k <= BaseChatItemLayout.c) {
          break label308;
        }
        i = 1;
        if (!this.e) {
          break label336;
        }
        if (i == 0) {
          break label327;
        }
        j = k - BaseChatItemLayout.c;
        if (!this.e) {
          break label358;
        }
        if (i == 0) {
          break label348;
        }
        i = -(j + this.jdField_a_of_type_Int);
      }
      for (;;)
      {
        i = m - i;
        if (QLog.isColorLevel()) {
          QLog.d("ArkHorizontalListView", 2, "checkScrollToChild mNextX=" + this.h + ", newNextX=" + i + ", mIsSend=" + this.e);
        }
        bool1 = bool2;
        if (this.jdField_a_of_type_ComTencentWidgetOverScroller.a(this.h + getScrollX(), 0, i, i, 0, 0, 1000))
        {
          if (QLog.isColorLevel()) {
            QLog.d("ArkHorizontalListView", 2, "checkScrollToChild springBack return true");
          }
          invalidate();
          bool1 = true;
        }
        post(new abbc(this));
        return bool1;
        k = localObject.getLeft();
        break;
        i = 0;
        break label138;
        if (k < 0)
        {
          i = 1;
          break label138;
        }
        i = 0;
        break label138;
        j = BaseChatItemLayout.c - k;
        break label155;
        j = k;
        if (i == 0) {
          break label155;
        }
        j = -k;
        break label155;
        i = j - this.jdField_a_of_type_Int;
        continue;
        if (i != 0) {
          i = j + this.jdField_a_of_type_Int;
        } else {
          i = this.jdField_a_of_type_Int - j;
        }
      }
    }
  }
  
  public boolean b()
  {
    return this.e;
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
      ((ArkHorizontalListView.RefreshUiCallback)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a(this);
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setIsSend(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
  
  public void setRefreshCallback(ArkHorizontalListView.RefreshUiCallback paramRefreshUiCallback)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramRefreshUiCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkHorizontalListView
 * JD-Core Version:    0.7.0.1
 */