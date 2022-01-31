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
        int i = this.mMeasureChildrenHeight;
        this.mMeasureChildrenHeight = (localViewBase.getComMeasuredHeightWithMargin() + i);
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
        int i = this.mMeasureChildrenWidth;
        this.mMeasureChildrenWidth = (localViewBase.getComMeasuredWidthWithMargin() + i);
      }
    }
    return this.mMeasureChildrenWidth;
  }
  
  private int getRealHeight(int paramInt1, int paramInt2)
  {
    int i = 0;
    int j = 0;
    Iterator localIterator;
    ViewBase localViewBase;
    if (-2147483648 == paramInt1) {
      if (1 == this.mOrientation)
      {
        localIterator = this.mSubViews.iterator();
        paramInt1 = 0;
        while (localIterator.hasNext())
        {
          localViewBase = (ViewBase)localIterator.next();
          if (!localViewBase.isGone())
          {
            i = localViewBase.getComMeasuredHeightWithMargin();
            if (i <= paramInt1) {
              break label393;
            }
            paramInt1 = i;
          }
        }
      }
    }
    label390:
    label393:
    for (;;)
    {
      break;
      this.mMeasureChildrenHeight = paramInt1;
      paramInt1 = this.mPaddingTop + this.mPaddingBottom + (this.mBorderWidth << 1) + paramInt1;
      paramInt2 = Math.min(paramInt2, paramInt1);
      do
      {
        return paramInt2;
        paramInt1 = j;
        if (this.mOrientation != 0) {
          break;
        }
        localIterator = this.mSubViews.iterator();
        paramInt1 = 0;
        while (localIterator.hasNext())
        {
          localViewBase = (ViewBase)localIterator.next();
          if (!localViewBase.isGone()) {
            paramInt1 = localViewBase.getComMeasuredHeightWithMargin() + paramInt1;
          }
        }
        this.mMeasureChildrenHeight = paramInt1;
        paramInt1 = this.mPaddingTop + this.mPaddingBottom + (this.mBorderWidth << 1) + paramInt1;
        break;
      } while (1073741824 == paramInt1);
      if (1 == this.mOrientation)
      {
        localIterator = this.mSubViews.iterator();
        paramInt1 = 0;
        while (localIterator.hasNext())
        {
          localViewBase = (ViewBase)localIterator.next();
          if (!localViewBase.isGone())
          {
            paramInt2 = localViewBase.getComMeasuredHeightWithMargin();
            if (paramInt2 <= paramInt1) {
              break label390;
            }
            paramInt1 = paramInt2;
          }
        }
      }
      for (;;)
      {
        break;
        this.mMeasureChildrenHeight = paramInt1;
        paramInt1 = this.mPaddingTop + this.mPaddingBottom + (this.mBorderWidth << 1) + paramInt1;
        for (;;)
        {
          return paramInt1;
          paramInt1 = i;
          if (this.mOrientation == 0)
          {
            localIterator = this.mSubViews.iterator();
            paramInt1 = 0;
            while (localIterator.hasNext())
            {
              localViewBase = (ViewBase)localIterator.next();
              if (!localViewBase.isGone()) {
                paramInt1 = localViewBase.getComMeasuredHeightWithMargin() + paramInt1;
              }
            }
            this.mMeasureChildrenHeight = paramInt1;
            paramInt1 = this.mPaddingTop + this.mPaddingBottom + (this.mBorderWidth << 1) + paramInt1;
          }
        }
      }
    }
  }
  
  private int getRealWidth(int paramInt1, int paramInt2, int paramInt3)
  {
    if (-2147483648 == paramInt1)
    {
      paramInt1 = 0;
      ViewBase localViewBase;
      if (1 == this.mOrientation)
      {
        localIterator = this.mSubViews.iterator();
        paramInt1 = 0;
        while (localIterator.hasNext())
        {
          localViewBase = (ViewBase)localIterator.next();
          if (!localViewBase.isGone()) {
            paramInt1 = localViewBase.getComMeasuredWidthWithMargin() + paramInt1;
          }
        }
        this.mMeasureChildrenWidth = paramInt1;
        paramInt1 = this.mPaddingLeft + this.mPaddingRight + (this.mBorderWidth << 1) + paramInt1;
      }
      label100:
      while (this.mOrientation != 0)
      {
        paramInt2 = Math.min(paramInt2, paramInt1);
        return paramInt2;
      }
      Iterator localIterator = this.mSubViews.iterator();
      paramInt1 = 0;
      label122:
      while (localIterator.hasNext())
      {
        localViewBase = (ViewBase)localIterator.next();
        if (!localViewBase.isGone())
        {
          paramInt3 = localViewBase.getComMeasuredWidthWithMargin();
          if (paramInt3 <= paramInt1) {
            break label213;
          }
          paramInt1 = paramInt3;
        }
      }
    }
    label213:
    for (;;)
    {
      break label122;
      this.mMeasureChildrenWidth = paramInt1;
      paramInt1 = this.mPaddingLeft + this.mPaddingRight + (this.mBorderWidth << 1) + paramInt1;
      break;
      if (1073741824 == paramInt1) {
        break label100;
      }
      return this.mPaddingLeft + paramInt3 + this.mPaddingRight;
    }
  }
  
  private void measureHorizontal(int paramInt1, int paramInt2)
  {
    int m = View.MeasureSpec.getSize(paramInt1);
    int n = View.MeasureSpec.getSize(paramInt2);
    int i1 = View.MeasureSpec.getMode(paramInt1);
    int i2 = View.MeasureSpec.getMode(paramInt2);
    Iterator localIterator = this.mSubViews.iterator();
    int j = 0;
    int i = 0;
    ViewBase localViewBase;
    int k;
    if (localIterator.hasNext())
    {
      localViewBase = (ViewBase)localIterator.next();
      if (localViewBase.isGone()) {
        break label262;
      }
      Layout.Params localParams = localViewBase.getComLayoutParams();
      k = i;
      if (1073741824 != i2)
      {
        k = i;
        if (-1 == localParams.mLayoutHeight) {
          k = 1;
        }
      }
      if (i1 != 0)
      {
        measureComChild(localViewBase, View.MeasureSpec.makeMeasureSpec(m - j, 1073741824), paramInt2);
        label124:
        i = localViewBase.getComMeasuredWidthWithMargin() + j;
      }
    }
    for (j = k;; j = k)
    {
      k = j;
      j = i;
      i = k;
      break;
      measureComChild(localViewBase, paramInt1, paramInt2);
      break label124;
      setComMeasuredDimension(getRealWidth(i1, m, j), getRealHeight(i2, n));
      if (i != 0)
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
      return;
      label262:
      k = i;
      i = j;
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
    int k;
    if (localIterator.hasNext())
    {
      localViewBase = (ViewBase)localIterator.next();
      if (localViewBase.isGone()) {
        break label253;
      }
      LinearLayout.Params localParams = (LinearLayout.Params)localViewBase.getComLayoutParams();
      k = j;
      if (1073741824 != i1)
      {
        k = j;
        if (-1 == localParams.mLayoutWidth) {
          k = 1;
        }
      }
      measureComChild(localViewBase, paramInt1, paramInt2);
      if (i > localViewBase.getComMeasuredWidthWithMargin()) {
        label124:
        j = i;
      }
    }
    for (i = k;; i = k)
    {
      k = i;
      i = j;
      j = k;
      break;
      i = localViewBase.getComMeasuredWidthWithMargin();
      break label124;
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
      return;
      label253:
      k = j;
      j = i;
    }
  }
  
  public LinearLayout.Params generateParams()
  {
    return new LinearLayout.Params();
  }
  
  public void onComLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Iterator localIterator;
    label61:
    ViewBase localViewBase;
    LinearLayout.Params localParams;
    int i;
    int j;
    switch (this.mOrientation)
    {
    default: 
      return;
    case 1: 
      if ((this.mGravity & 0x1) != 0)
      {
        paramInt1 = this.mPaddingLeft + paramInt1 + this.mBorderWidth;
        localIterator = this.mSubViews.iterator();
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          localViewBase = (ViewBase)localIterator.next();
        } while (localViewBase.isGone());
        localParams = (LinearLayout.Params)localViewBase.getComLayoutParams();
        paramInt3 = localViewBase.getComMeasuredWidth();
        i = localViewBase.getComMeasuredHeight();
        j = localParams.mLayoutMarginLeft + paramInt1;
        if ((localParams.mLayoutGravity & 0x20) == 0) {
          break label222;
        }
        paramInt1 = paramInt4 + paramInt2 - i >> 1;
      }
      for (;;)
      {
        localViewBase.comLayout(j, paramInt1, j + paramInt3, i + paramInt1);
        paramInt1 = localParams.mLayoutMarginRight + paramInt3 + j;
        break label61;
        if ((this.mGravity & 0x4) != 0)
        {
          paramInt1 = paramInt3 - paramInt1 - getChildrenWidth() >> 1;
          break;
        }
        paramInt1 = paramInt3 - getChildrenWidth() - this.mPaddingRight - this.mBorderWidth;
        break;
        label222:
        if ((localParams.mLayoutGravity & 0x10) != 0) {
          paramInt1 = paramInt4 - i - this.mPaddingBottom - this.mBorderWidth - localParams.mLayoutMarginBottom;
        } else {
          paramInt1 = this.mPaddingTop + paramInt2 + this.mBorderWidth + localParams.mLayoutMarginTop;
        }
      }
    }
    if ((this.mGravity & 0x8) != 0)
    {
      paramInt2 = this.mPaddingTop + paramInt2 + this.mBorderWidth;
      label301:
      localIterator = this.mSubViews.iterator();
      label312:
      while (localIterator.hasNext())
      {
        localViewBase = (ViewBase)localIterator.next();
        if (!localViewBase.isGone())
        {
          localParams = (LinearLayout.Params)localViewBase.getComLayoutParams();
          paramInt4 = localViewBase.getComMeasuredWidth();
          i = localViewBase.getComMeasuredHeight();
          j = localParams.mLayoutMarginTop + paramInt2;
          if ((localParams.mLayoutGravity & 0x4) == 0) {
            break label473;
          }
          paramInt2 = paramInt3 + paramInt1 - paramInt4 >> 1;
        }
      }
    }
    for (;;)
    {
      localViewBase.comLayout(paramInt2, j, paramInt4 + paramInt2, j + i);
      paramInt2 = localParams.mLayoutMarginBottom + i + j;
      break label312;
      break;
      if ((this.mGravity & 0x20) != 0)
      {
        paramInt2 = paramInt4 + paramInt2 - getChildrenHeight() >> 1;
        break label301;
      }
      paramInt2 = paramInt4 - getChildrenHeight() - this.mPaddingBottom - this.mBorderWidth;
      break label301;
      label473:
      if ((localParams.mLayoutGravity & 0x2) != 0) {
        paramInt2 = paramInt3 - this.mPaddingRight - this.mBorderWidth - localParams.mLayoutMarginRight - paramInt4;
      } else {
        paramInt2 = this.mPaddingLeft + paramInt1 + this.mBorderWidth + localParams.mLayoutMarginLeft;
      }
    }
  }
  
  public void onComMeasure(int paramInt1, int paramInt2)
  {
    this.mMeasureChildrenWidth = 0;
    this.mMeasureChildrenHeight = 0;
    int i = paramInt1;
    int j = paramInt2;
    if (this.mAutoDimDirection > 0) {
      switch (this.mAutoDimDirection)
      {
      default: 
        j = paramInt2;
        i = paramInt1;
      }
    }
    for (;;)
    {
      switch (this.mOrientation)
      {
      default: 
        return;
        i = paramInt1;
        j = paramInt2;
        if (1073741824 == View.MeasureSpec.getMode(paramInt1))
        {
          j = View.MeasureSpec.makeMeasureSpec((int)(View.MeasureSpec.getSize(paramInt1) * this.mAutoDimY / this.mAutoDimX), 1073741824);
          i = paramInt1;
          continue;
          i = paramInt1;
          j = paramInt2;
          if (1073741824 == View.MeasureSpec.getMode(paramInt2))
          {
            i = View.MeasureSpec.makeMeasureSpec((int)(View.MeasureSpec.getSize(paramInt2) * this.mAutoDimX / this.mAutoDimY), 1073741824);
            j = paramInt2;
          }
        }
        break;
      }
    }
    measureVertical(i, j);
    return;
    measureHorizontal(i, j);
  }
  
  public boolean setAttribute(int paramInt, String paramString)
  {
    boolean bool = super.setAttribute(paramInt, paramString);
    if (!bool) {}
    switch (paramInt)
    {
    default: 
      return bool;
    }
    if (TextUtils.equals("vertical", paramString))
    {
      this.mOrientation = 0;
      return bool;
    }
    this.mOrientation = 1;
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.layout.LinearLayout
 * JD-Core Version:    0.7.0.1
 */