package com.tencent.mobileqq.activity.aio;

import android.content.Context;
import android.content.res.Resources;
import android.text.Layout;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;

public class AioTitleLayout
  extends LinearLayout
{
  private TextView a;
  private TextView b;
  
  public AioTitleLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public AioTitleLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private int a()
  {
    int i = getChildCount() - 1;
    while (i >= 0)
    {
      View localView = getChildAt(i);
      if (localView.getVisibility() != 8) {
        return localView.getRight();
      }
      i -= 1;
    }
    return -2147483647;
  }
  
  private TextView a()
  {
    if (this.a == null) {
      this.a = ((TextView)findViewById(2131365602));
    }
    return this.a;
  }
  
  private void a()
  {
    int i = 0;
    while (i < getChildCount())
    {
      if (QLog.isColorLevel()) {
        QLog.d("AioTitleLayout", 2, "printChildren() called child = " + getChildAt(i).toString());
      }
      i += 1;
    }
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3)
  {
    int i = 0;
    while (i < getChildCount())
    {
      View localView = getChildAt(i);
      if (localView.getVisibility() != 8)
      {
        int j = localView.getLeft() + paramInt3;
        int k = localView.getRight() + paramInt3;
        if (QLog.isColorLevel()) {
          QLog.d("AioTitleLayout", 2, new Object[] { "alignScreenHorizontalCenter() called with: l = [" + paramInt1 + "], r = [" + paramInt2 + "], diff = [" + paramInt3 + "], i = [" + i + "], candidateLeft = [" + j + "]", ", candidateRight = [" + k + "]" });
        }
        localView.layout(j, localView.getTop(), k, localView.getBottom());
      }
      i += 1;
    }
  }
  
  private int b()
  {
    int i = 0;
    while (i < getChildCount())
    {
      View localView = getChildAt(i);
      if (localView.getVisibility() != 8) {
        return localView.getLeft();
      }
      i += 1;
    }
    return 2147483647;
  }
  
  private TextView b()
  {
    if (this.b == null) {
      this.b = ((TextView)findViewById(2131378936));
    }
    return this.b;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int j = getPaddingLeft();
    int i = 0;
    while (i < getChildCount())
    {
      localObject1 = getChildAt(i);
      k = j;
      if (((View)localObject1).getVisibility() != 8)
      {
        localObject2 = (LinearLayout.LayoutParams)((View)localObject1).getLayoutParams();
        j += ((LinearLayout.LayoutParams)localObject2).leftMargin;
        k = (getMeasuredHeight() - ((View)localObject1).getMeasuredHeight()) / 2;
        ((View)localObject1).layout(j, k, ((View)localObject1).getMeasuredWidth() + j, ((View)localObject1).getMeasuredHeight() + k);
        k = j + ((View)localObject1).getMeasuredWidth() + ((LinearLayout.LayoutParams)localObject2).rightMargin;
      }
      i += 1;
      j = k;
    }
    a();
    i = getResources().getDisplayMetrics().widthPixels;
    Object localObject1 = b();
    Object localObject2 = a();
    j = i / 2;
    int k = paramInt1 + ((TextView)localObject1).getLeft();
    int m = ((TextView)localObject1).getRight();
    if (((TextView)localObject2).isShown())
    {
      i = ((TextView)localObject2).getRight();
      i = (Math.max(m, i) - ((TextView)localObject1).getLeft()) / 2;
      QLog.d("AioTitleLayout", 2, "onLayout() called with: textLeftOnScreenX = [" + k + "], titleTv.getRight() = [" + ((TextView)localObject1).getRight() + "], countTv.getRight() = [" + ((TextView)localObject2).getRight() + "], titleTv.getLeft() = [" + ((TextView)localObject1).getLeft() + "], half width = [" + i + "]");
      k += i;
      i = j - k;
      if (QLog.isColorLevel())
      {
        QLog.d("AioTitleLayout", 2, "onLayout() called with: changed = [" + paramBoolean + "], l = [" + paramInt1 + "], t = [" + paramInt2 + "], r = [" + paramInt3 + "], b = [" + paramInt4 + "]");
        QLog.d("AioTitleLayout", 2, "onLayout() called with: screenCenterX = [" + j + "], textCenterX = [" + k + "], diff = [" + i + "]");
      }
      if (i != 0) {
        break label488;
      }
      paramInt2 = i;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AioTitleLayout", 2, "onLayout() called diff = " + paramInt2);
      }
      if (paramInt2 != 0) {
        a(paramInt1, paramInt3, paramInt2);
      }
      return;
      i = -2147483648;
      break;
      label488:
      if (i > 0)
      {
        paramInt2 = getMeasuredWidth() - a();
        if (QLog.isColorLevel()) {
          QLog.d("AioTitleLayout", 2, "onLayout() called rightSpace = " + paramInt2);
        }
        paramInt2 = Math.min(paramInt2, i);
      }
      else
      {
        paramInt2 = b();
        if (QLog.isColorLevel()) {
          QLog.d("AioTitleLayout", 2, "onLayout() called leftSpace = " + paramInt2);
        }
        paramInt2 = Math.max(-paramInt2, i);
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int n = View.MeasureSpec.getMode(paramInt1);
    int m = View.MeasureSpec.getSize(paramInt1);
    paramInt1 = 0;
    paramInt2 = 0;
    if (n == 1073741824)
    {
      paramInt1 = getPaddingLeft();
      paramInt2 = getPaddingRight();
      int i = 0;
      int j = paramInt2 + paramInt1;
      int k = 0;
      if (k < getChildCount())
      {
        localObject1 = getChildAt(k);
        paramInt2 = j;
        paramInt1 = i;
        if (((View)localObject1).getVisibility() != 8)
        {
          paramInt2 = j;
          paramInt1 = i;
          if (((View)localObject1).getId() != 2131378936)
          {
            localObject2 = (LinearLayout.LayoutParams)((View)localObject1).getLayoutParams();
            paramInt1 = View.MeasureSpec.makeMeasureSpec(0, 0);
            if (((LinearLayout.LayoutParams)localObject2).width != -2) {
              break label201;
            }
            paramInt1 = View.MeasureSpec.makeMeasureSpec(0, 0);
            label125:
            paramInt2 = View.MeasureSpec.makeMeasureSpec(0, 0);
            if (((LinearLayout.LayoutParams)localObject2).height != -2) {
              break label244;
            }
            paramInt2 = View.MeasureSpec.makeMeasureSpec(0, 0);
          }
        }
        for (;;)
        {
          ((View)localObject1).measure(paramInt1, paramInt2);
          paramInt2 = j + ((LinearLayout.LayoutParams)localObject2).leftMargin + ((View)localObject1).getMeasuredWidth() + ((LinearLayout.LayoutParams)localObject2).rightMargin;
          paramInt1 = Math.max(i, ((View)localObject1).getMeasuredHeight());
          k += 1;
          j = paramInt2;
          i = paramInt1;
          break;
          label201:
          if (((LinearLayout.LayoutParams)localObject2).width == -1)
          {
            QLog.e("AioTitleLayout", 1, "onMeasure: ", new IllegalArgumentException("lp.width == ViewGroup.LayoutParams.MATCH_PARENT is not support now"));
            break label125;
          }
          paramInt1 = View.MeasureSpec.makeMeasureSpec(((LinearLayout.LayoutParams)localObject2).width, 1073741824);
          break label125;
          label244:
          if (((LinearLayout.LayoutParams)localObject2).height == -1) {
            QLog.e("AioTitleLayout", 1, "onMeasure: ", new IllegalArgumentException("lp.height == ViewGroup.LayoutParams.MATCH_PARENT is not support now"));
          } else {
            paramInt2 = View.MeasureSpec.makeMeasureSpec(((LinearLayout.LayoutParams)localObject2).height, 1073741824);
          }
        }
      }
      k = m - j;
      QLog.d("AioTitleLayout", 2, "onMeasure() called with: maxTextWidth = [" + k + "]");
      if (m < j) {
        QLog.e("AioTitleLayout", 1, "onMeasure: ", new IllegalArgumentException("icon totalLength = [" + j + "]> measuredWidth = [" + m + "]"));
      }
      Object localObject1 = b();
      ((TextView)localObject1).setMaxWidth(k);
      paramInt2 = 0;
      do
      {
        ((TextView)localObject1).measure(View.MeasureSpec.makeMeasureSpec(k, -2147483648), View.MeasureSpec.makeMeasureSpec(0, 0));
        localObject2 = ((TextView)localObject1).getLayout();
        paramInt1 = paramInt2;
        if (localObject2 != null)
        {
          paramInt1 = ((Layout)localObject2).getEllipsisStart(0);
          paramInt2 = ((Layout)localObject2).getEllipsisCount(0);
          int i1 = ((Layout)localObject2).getEllipsizedWidth();
          QLog.d("AioTitleLayout", 1, "onMeasure() called with: ellipsisStart = [" + paramInt1 + "], ellipsisCount = [" + paramInt2 + "], ellipsizedWidth = [" + i1 + "]");
          if ((paramInt2 <= 0) || (paramInt1 != 0) || (i1 != k)) {
            break;
          }
          paramInt1 = 1;
          float f = ((TextView)localObject1).getTextSize() * 0.75F;
          QLog.d("AioTitleLayout", 1, "onMeasure() called with: autoResizeText from = [" + ((TextView)localObject1).getTextSize() + "], to = [" + f + "]");
          ((TextView)localObject1).setTextSize(0, f);
        }
        paramInt2 = paramInt1;
      } while (paramInt1 != 0);
      Object localObject2 = (LinearLayout.LayoutParams)((TextView)localObject1).getLayoutParams();
      paramInt1 = ((LinearLayout.LayoutParams)localObject2).leftMargin;
      paramInt2 = ((TextView)localObject1).getMeasuredWidth();
      paramInt1 = ((LinearLayout.LayoutParams)localObject2).rightMargin + (paramInt1 + j + paramInt2);
      if (m < paramInt1) {
        QLog.e("AioTitleLayout", 1, "onMeasure: ", new IllegalArgumentException("icon totalLength = [" + paramInt1 + "]> measuredWidth = [" + m + "]"));
      }
      paramInt2 = Math.max(i, ((TextView)localObject1).getMeasuredHeight());
      paramInt1 = m;
    }
    for (;;)
    {
      QLog.d("AioTitleLayout", 2, "onMeasure() called with: widthMode = [" + n + "], widthSize = [" + m + "],measuredWidth = [" + paramInt1 + "],measuredHeight = [" + paramInt2 + "]");
      setMeasuredDimension(paramInt1, paramInt2);
      return;
      paramInt1 = 0;
      break;
      QLog.e("AioTitleLayout", 1, "onMeasure: ", new IllegalArgumentException("widthMeasureSpec is not support now"));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.AioTitleLayout
 * JD-Core Version:    0.7.0.1
 */