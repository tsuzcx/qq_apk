package com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.layout;

import android.text.TextUtils;
import android.view.View.MeasureSpec;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.Layout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.Layout.Params;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import java.util.Iterator;
import java.util.List;

public class LinearLayout
  extends Layout
{
  private static final String TAG = "LinearLayout";
  protected int mMeasureChildrenHeight;
  protected int mMeasureChildrenWidth;
  public int mOrientation = 0;
  
  public LinearLayout(VafContext paramVafContext)
  {
    super(paramVafContext);
  }
  
  private int getChildrenHeight()
  {
    if (this.mMeasureChildrenHeight <= 0)
    {
      this.mMeasureChildrenHeight = 0;
      Iterator localIterator = this.mSubViews.iterator();
      while (localIterator.hasNext())
      {
        ViewBase localViewBase = (ViewBase)localIterator.next();
        this.mMeasureChildrenHeight += localViewBase.getComMeasuredHeightWithMargin();
      }
    }
    return this.mMeasureChildrenHeight;
  }
  
  private int getChildrenWidth()
  {
    if (this.mMeasureChildrenWidth <= 0)
    {
      this.mMeasureChildrenWidth = 0;
      Iterator localIterator = this.mSubViews.iterator();
      while (localIterator.hasNext())
      {
        ViewBase localViewBase = (ViewBase)localIterator.next();
        this.mMeasureChildrenWidth += localViewBase.getComMeasuredWidthWithMargin();
      }
    }
    return this.mMeasureChildrenWidth;
  }
  
  private int getRealHeight(int paramInt1, int paramInt2)
  {
    int i = 0;
    int k = 0;
    int m = 0;
    int n = 0;
    int j = 0;
    Iterator localIterator;
    ViewBase localViewBase;
    if (-2147483648 == paramInt1)
    {
      m = this.mOrientation;
      if (1 == m)
      {
        localIterator = this.mSubViews.iterator();
        paramInt1 = j;
        while (localIterator.hasNext())
        {
          localViewBase = (ViewBase)localIterator.next();
          if (!localViewBase.isGone())
          {
            i = localViewBase.getComMeasuredHeightWithMargin();
            if (i > paramInt1) {
              paramInt1 = i;
            }
          }
        }
        this.mMeasureChildrenHeight = paramInt1;
        j = this.mPaddingTop + this.mPaddingBottom;
      }
      for (i = this.mBorderWidth;; i = this.mBorderWidth)
      {
        paramInt1 += j + (i << 1);
        break;
        paramInt1 = k;
        if (m != 0) {
          break;
        }
        localIterator = this.mSubViews.iterator();
        paramInt1 = i;
        while (localIterator.hasNext())
        {
          localViewBase = (ViewBase)localIterator.next();
          if (!localViewBase.isGone()) {
            paramInt1 += localViewBase.getComMeasuredHeightWithMargin();
          }
        }
        this.mMeasureChildrenHeight = paramInt1;
        j = this.mPaddingTop + this.mPaddingBottom;
      }
      return Math.min(paramInt2, paramInt1);
    }
    if (1073741824 == paramInt1) {
      return paramInt2;
    }
    paramInt1 = this.mOrientation;
    if (1 == paramInt1)
    {
      localIterator = this.mSubViews.iterator();
      paramInt1 = m;
      while (localIterator.hasNext())
      {
        localViewBase = (ViewBase)localIterator.next();
        if (!localViewBase.isGone())
        {
          paramInt2 = localViewBase.getComMeasuredHeightWithMargin();
          if (paramInt2 > paramInt1) {
            paramInt1 = paramInt2;
          }
        }
      }
      this.mMeasureChildrenHeight = paramInt1;
      paramInt2 = this.mPaddingTop + this.mPaddingBottom;
    }
    for (i = this.mBorderWidth;; i = this.mBorderWidth)
    {
      return paramInt1 + (paramInt2 + (i << 1));
      if (paramInt1 != 0) {
        break;
      }
      localIterator = this.mSubViews.iterator();
      paramInt1 = n;
      while (localIterator.hasNext())
      {
        localViewBase = (ViewBase)localIterator.next();
        if (!localViewBase.isGone()) {
          paramInt1 += localViewBase.getComMeasuredHeightWithMargin();
        }
      }
      this.mMeasureChildrenHeight = paramInt1;
      paramInt2 = this.mPaddingTop + this.mPaddingBottom;
    }
    return 0;
  }
  
  private int getRealWidth(int paramInt1, int paramInt2, int paramInt3)
  {
    if (-2147483648 == paramInt1)
    {
      paramInt3 = 0;
      int i = 0;
      paramInt1 = 0;
      int j = this.mOrientation;
      Iterator localIterator;
      ViewBase localViewBase;
      if (1 == j)
      {
        localIterator = this.mSubViews.iterator();
        while (localIterator.hasNext())
        {
          localViewBase = (ViewBase)localIterator.next();
          if (!localViewBase.isGone()) {
            paramInt1 += localViewBase.getComMeasuredWidthWithMargin();
          }
        }
        this.mMeasureChildrenWidth = paramInt1;
        i = this.mPaddingLeft + this.mPaddingRight;
      }
      for (paramInt3 = this.mBorderWidth;; paramInt3 = this.mBorderWidth)
      {
        paramInt1 += i + (paramInt3 << 1);
        break;
        paramInt1 = i;
        if (j != 0) {
          break;
        }
        localIterator = this.mSubViews.iterator();
        paramInt1 = paramInt3;
        while (localIterator.hasNext())
        {
          localViewBase = (ViewBase)localIterator.next();
          if (!localViewBase.isGone())
          {
            paramInt3 = localViewBase.getComMeasuredWidthWithMargin();
            if (paramInt3 > paramInt1) {
              paramInt1 = paramInt3;
            }
          }
        }
        this.mMeasureChildrenWidth = paramInt1;
        i = this.mPaddingLeft + this.mPaddingRight;
      }
      return Math.min(paramInt2, paramInt1);
    }
    if (1073741824 == paramInt1) {
      return paramInt2;
    }
    return paramInt3 + this.mPaddingLeft + this.mPaddingRight;
  }
  
  private void measureHorizontal(int paramInt1, int paramInt2)
  {
    int m = View.MeasureSpec.getSize(paramInt1);
    int n = View.MeasureSpec.getSize(paramInt2);
    int i1 = View.MeasureSpec.getMode(paramInt1);
    int i2 = View.MeasureSpec.getMode(paramInt2);
    Iterator localIterator = this.mSubViews.iterator();
    int i = 0;
    int j = 0;
    ViewBase localViewBase;
    while (localIterator.hasNext())
    {
      localViewBase = (ViewBase)localIterator.next();
      if (!localViewBase.isGone())
      {
        Layout.Params localParams = localViewBase.getComLayoutParams();
        int k = j;
        if (1073741824 != i2)
        {
          k = j;
          if (-1 == localParams.mLayoutHeight) {
            k = 1;
          }
        }
        if (i1 != 0) {
          measureComChild(localViewBase, View.MeasureSpec.makeMeasureSpec(m - i, 1073741824), paramInt2);
        } else {
          measureComChild(localViewBase, paramInt1, paramInt2);
        }
        i += localViewBase.getComMeasuredWidthWithMargin();
        j = k;
      }
    }
    setComMeasuredDimension(getRealWidth(i1, m, i), getRealHeight(i2, n));
    if (j != 0)
    {
      paramInt2 = View.MeasureSpec.makeMeasureSpec(getComMeasuredHeight(), 1073741824);
      localIterator = this.mSubViews.iterator();
      while (localIterator.hasNext())
      {
        localViewBase = (ViewBase)localIterator.next();
        if ((!localViewBase.isGone()) && (-1 == localViewBase.getComLayoutParams().mLayoutHeight)) {
          measureComChild(localViewBase, paramInt1, paramInt2);
        }
      }
    }
  }
  
  private final void measureVertical(int paramInt1, int paramInt2)
  {
    int m = View.MeasureSpec.getSize(paramInt1);
    int n = View.MeasureSpec.getSize(paramInt2);
    int i1 = View.MeasureSpec.getMode(paramInt1);
    int i2 = View.MeasureSpec.getMode(paramInt2);
    Iterator localIterator = this.mSubViews.iterator();
    int i = 0;
    int j = 0;
    ViewBase localViewBase;
    while (localIterator.hasNext())
    {
      localViewBase = (ViewBase)localIterator.next();
      if (!localViewBase.isGone())
      {
        LinearLayout.Params localParams = (LinearLayout.Params)localViewBase.getComLayoutParams();
        int k = j;
        if (1073741824 != i1)
        {
          k = j;
          if (-1 == localParams.mLayoutWidth) {
            k = 1;
          }
        }
        measureComChild(localViewBase, paramInt1, paramInt2);
        if (i > localViewBase.getComMeasuredWidthWithMargin())
        {
          j = k;
        }
        else
        {
          i = localViewBase.getComMeasuredWidthWithMargin();
          j = k;
        }
      }
    }
    setComMeasuredDimension(getRealWidth(i1, m, i), getRealHeight(i2, n));
    if (j != 0)
    {
      paramInt1 = View.MeasureSpec.makeMeasureSpec(getComMeasuredWidth(), 1073741824);
      localIterator = this.mSubViews.iterator();
      while (localIterator.hasNext())
      {
        localViewBase = (ViewBase)localIterator.next();
        if ((!localViewBase.isGone()) && (-1 == localViewBase.getComLayoutParams().mLayoutWidth)) {
          measureComChild(localViewBase, paramInt1, paramInt2);
        }
      }
    }
  }
  
  public LinearLayout.Params generateParams()
  {
    return new LinearLayout.Params();
  }
  
  public void onComLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = this.mOrientation;
    ViewBase localViewBase;
    LinearLayout.Params localParams;
    int j;
    if (i != 0)
    {
      if (i != 1) {
        return;
      }
      if ((this.mGravity & 0x1) != 0) {
        paramInt1 = paramInt1 + this.mPaddingLeft + this.mBorderWidth;
      } else if ((this.mGravity & 0x4) != 0) {
        paramInt1 = paramInt3 - paramInt1 - getChildrenWidth() >> 1;
      } else {
        paramInt1 = paramInt3 - getChildrenWidth() - this.mPaddingRight - this.mBorderWidth;
      }
      localIterator = this.mSubViews.iterator();
      while (localIterator.hasNext())
      {
        localViewBase = (ViewBase)localIterator.next();
        if (!localViewBase.isGone())
        {
          localParams = (LinearLayout.Params)localViewBase.getComLayoutParams();
          paramInt3 = localViewBase.getComMeasuredWidth();
          i = localViewBase.getComMeasuredHeight();
          j = paramInt1 + localParams.mLayoutMarginLeft;
          if ((localParams.mLayoutGravity & 0x20) != 0) {
            paramInt1 = paramInt4 + paramInt2 - i >> 1;
          } else if ((localParams.mLayoutGravity & 0x10) != 0) {
            paramInt1 = paramInt4 - i - this.mPaddingBottom - this.mBorderWidth - localParams.mLayoutMarginBottom;
          } else {
            paramInt1 = this.mPaddingTop + paramInt2 + this.mBorderWidth + localParams.mLayoutMarginTop;
          }
          localViewBase.comLayout(j, paramInt1, j + paramInt3, i + paramInt1);
          paramInt1 = j + (paramInt3 + localParams.mLayoutMarginRight);
        }
      }
    }
    if ((this.mGravity & 0x8) != 0) {
      paramInt2 = paramInt2 + this.mPaddingTop + this.mBorderWidth;
    } else if ((this.mGravity & 0x20) != 0) {
      paramInt2 = paramInt4 + paramInt2 - getChildrenHeight() >> 1;
    } else {
      paramInt2 = paramInt4 - getChildrenHeight() - this.mPaddingBottom - this.mBorderWidth;
    }
    Iterator localIterator = this.mSubViews.iterator();
    while (localIterator.hasNext())
    {
      localViewBase = (ViewBase)localIterator.next();
      if (!localViewBase.isGone())
      {
        localParams = (LinearLayout.Params)localViewBase.getComLayoutParams();
        paramInt4 = localViewBase.getComMeasuredWidth();
        i = localViewBase.getComMeasuredHeight();
        j = paramInt2 + localParams.mLayoutMarginTop;
        if ((localParams.mLayoutGravity & 0x4) != 0) {
          paramInt2 = paramInt3 + paramInt1 - paramInt4 >> 1;
        } else if ((localParams.mLayoutGravity & 0x2) != 0) {
          paramInt2 = paramInt3 - this.mPaddingRight - this.mBorderWidth - localParams.mLayoutMarginRight - paramInt4;
        } else {
          paramInt2 = this.mPaddingLeft + paramInt1 + this.mBorderWidth + localParams.mLayoutMarginLeft;
        }
        localViewBase.comLayout(paramInt2, j, paramInt4 + paramInt2, j + i);
        paramInt2 = j + (i + localParams.mLayoutMarginBottom);
      }
    }
  }
  
  public void onComMeasure(int paramInt1, int paramInt2)
  {
    this.mMeasureChildrenWidth = 0;
    this.mMeasureChildrenHeight = 0;
    int i = paramInt1;
    int j = paramInt2;
    if (this.mAutoDimDirection > 0)
    {
      i = this.mAutoDimDirection;
      if (i != 1)
      {
        if (i != 2)
        {
          i = paramInt1;
          j = paramInt2;
        }
        else
        {
          i = paramInt1;
          j = paramInt2;
          if (1073741824 == View.MeasureSpec.getMode(paramInt2))
          {
            i = View.MeasureSpec.makeMeasureSpec((int)(View.MeasureSpec.getSize(paramInt2) * this.mAutoDimX / this.mAutoDimY), 1073741824);
            j = paramInt2;
          }
        }
      }
      else
      {
        i = paramInt1;
        j = paramInt2;
        if (1073741824 == View.MeasureSpec.getMode(paramInt1))
        {
          j = View.MeasureSpec.makeMeasureSpec((int)(View.MeasureSpec.getSize(paramInt1) * this.mAutoDimY / this.mAutoDimX), 1073741824);
          i = paramInt1;
        }
      }
    }
    paramInt1 = this.mOrientation;
    if (paramInt1 != 0)
    {
      if (paramInt1 != 1) {
        return;
      }
      measureHorizontal(i, j);
      return;
    }
    measureVertical(i, j);
  }
  
  protected boolean setAttribute(int paramInt, String paramString)
  {
    boolean bool = super.setAttribute(paramInt, paramString);
    if (!bool)
    {
      if (paramInt != 12) {
        return bool;
      }
      if (TextUtils.equals("vertical", paramString))
      {
        this.mOrientation = 0;
        return bool;
      }
      this.mOrientation = 1;
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.layout.LinearLayout
 * JD-Core Version:    0.7.0.1
 */