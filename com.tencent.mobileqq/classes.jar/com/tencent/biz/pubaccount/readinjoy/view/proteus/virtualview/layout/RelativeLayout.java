package com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.layout;

import android.view.View.MeasureSpec;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.Layout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.layout.helper.RelativeLayoutHelper;
import java.util.Iterator;
import java.util.List;

public class RelativeLayout
  extends Layout
{
  private static final String TAG = "RelativeLayout_TMTEST";
  private RelativeLayoutHelper relativeLayoutHelper = new RelativeLayoutHelper();
  private List<ViewBase> sortedHorizontalView;
  private List<ViewBase> sortedVerticalView;
  
  public RelativeLayout(VafContext paramVafContext)
  {
    super(paramVafContext);
  }
  
  private int getMaxHeight()
  {
    Iterator localIterator = this.mSubViews.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      ViewBase localViewBase = (ViewBase)localIterator.next();
      if (!localViewBase.isGone())
      {
        RelativeLayout.Params localParams = (RelativeLayout.Params)localViewBase.getComLayoutParams();
        int j = localParams.mTop + localViewBase.getComMeasuredHeight() + localParams.mLayoutMarginBottom;
        if (j > i) {
          i = j;
        }
      }
    }
    return i + (this.mPaddingBottom + (this.mBorderWidth << 1));
  }
  
  private int getMaxWidth()
  {
    Iterator localIterator = this.mSubViews.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      ViewBase localViewBase = (ViewBase)localIterator.next();
      if (!localViewBase.isGone())
      {
        RelativeLayout.Params localParams = (RelativeLayout.Params)localViewBase.getComLayoutParams();
        int j = localParams.mLeft + localViewBase.getComMeasuredWidth() + localParams.mLayoutMarginRight;
        if (j > i) {
          i = j;
        }
      }
    }
    return i + (this.mPaddingRight + (this.mBorderWidth << 1));
  }
  
  private int getRealHeight(int paramInt1, int paramInt2)
  {
    if (-2147483648 == paramInt1) {
      return getMaxHeight();
    }
    if (1073741824 == paramInt1) {
      return paramInt2;
    }
    return getMaxHeight();
  }
  
  private int getRealWidth(int paramInt1, int paramInt2)
  {
    if (-2147483648 == paramInt1) {
      return getMaxWidth();
    }
    if (1073741824 == paramInt1) {
      return paramInt2;
    }
    return getMaxWidth();
  }
  
  private List<ViewBase> sortHorizontal()
  {
    List localList = this.sortedHorizontalView;
    if ((localList == null) || (localList.size() != this.mSubViews.size()))
    {
      if (this.relativeLayoutHelper.getParent() == null) {
        this.relativeLayoutHelper.setParent(this);
      }
      this.sortedHorizontalView = this.relativeLayoutHelper.getHorizontalSortedView();
    }
    return this.sortedHorizontalView;
  }
  
  private List<ViewBase> sortVertical()
  {
    List localList = this.sortedVerticalView;
    if ((localList == null) || (localList.size() != this.mSubViews.size()))
    {
      if (this.relativeLayoutHelper.getParent() == null) {
        this.relativeLayoutHelper.setParent(this);
      }
      this.sortedVerticalView = this.relativeLayoutHelper.getVerticalSortedView();
    }
    return this.sortedVerticalView;
  }
  
  public RelativeLayout.Params generateParams()
  {
    return new RelativeLayout.Params();
  }
  
  public void onComLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Iterator localIterator = this.mSubViews.iterator();
    while (localIterator.hasNext())
    {
      ViewBase localViewBase = (ViewBase)localIterator.next();
      if (!localViewBase.isGone())
      {
        RelativeLayout.Params localParams = (RelativeLayout.Params)localViewBase.getComLayoutParams();
        localViewBase.comLayout(localParams.mLeft + paramInt1, localParams.mTop + paramInt2, localParams.mRight + paramInt1, localParams.mBottom + paramInt2);
      }
    }
  }
  
  public void onComMeasure(int paramInt1, int paramInt2)
  {
    int n = View.MeasureSpec.getMode(paramInt1);
    int i1 = View.MeasureSpec.getMode(paramInt2);
    paramInt1 = View.MeasureSpec.getSize(paramInt1);
    paramInt2 = View.MeasureSpec.getSize(paramInt2);
    if (n == 0) {
      paramInt1 = -1;
    }
    if (i1 == 0) {
      paramInt2 = -1;
    }
    List localList = sortHorizontal();
    int i2 = localList.size();
    boolean bool2 = true;
    int k = 0;
    boolean bool1;
    if (n != 1073741824) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    if (i1 == 1073741824) {
      bool2 = false;
    }
    int j = 0;
    ViewBase localViewBase;
    int i;
    RelativeLayout.Params localParams;
    while (j < i2)
    {
      localViewBase = (ViewBase)localList.get(j);
      i = paramInt1;
      if (localViewBase.getVisibility() != 8)
      {
        localParams = (RelativeLayout.Params)localViewBase.getComLayoutParams();
        this.relativeLayoutHelper.applyHorizontalSizeRules(localParams, paramInt1);
        i = paramInt1;
        if (bool1)
        {
          i = paramInt1;
          if (localParams.mLayoutWidth == -1)
          {
            int m = getMaxWidth();
            i = paramInt1;
            if (m > 0) {
              i = m;
            }
          }
        }
        this.relativeLayoutHelper.measureChildHorizontal(localViewBase, localParams, i, paramInt2);
        this.relativeLayoutHelper.positionChildHorizontal(localViewBase, localParams, i, bool1);
      }
      j += 1;
      paramInt1 = i;
    }
    localList = sortVertical();
    j = k;
    while (j < i2)
    {
      localViewBase = (ViewBase)localList.get(j);
      i = paramInt2;
      if (localViewBase.getVisibility() != 8)
      {
        localParams = (RelativeLayout.Params)localViewBase.getComLayoutParams();
        this.relativeLayoutHelper.applyVerticalSizeRules(localParams, paramInt2);
        i = paramInt2;
        if (bool2) {
          if (localParams.mLayoutHeight != -1)
          {
            i = paramInt2;
            if (!RelativeLayoutHelper.hasVerticleCenterRule(localParams)) {}
          }
          else
          {
            k = getMaxHeight();
            i = paramInt2;
            if (k > 0) {
              i = k;
            }
          }
        }
        this.relativeLayoutHelper.measureChild(localViewBase, localParams, paramInt1, i);
        this.relativeLayoutHelper.positionChildVertical(localViewBase, localParams, i, bool2);
      }
      j += 1;
      paramInt2 = i;
    }
    setComMeasuredDimension(getRealWidth(n, paramInt1), getRealHeight(i1, paramInt2));
  }
  
  protected boolean setAttribute(int paramInt, String paramString)
  {
    return super.setAttribute(paramInt, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.layout.RelativeLayout
 * JD-Core Version:    0.7.0.1
 */