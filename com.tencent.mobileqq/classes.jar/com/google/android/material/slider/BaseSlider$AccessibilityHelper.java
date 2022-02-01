package com.google.android.material.slider;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.widget.SeekBar;
import androidx.annotation.NonNull;
import androidx.core.math.MathUtils;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat.RangeInfoCompat;
import androidx.customview.widget.ExploreByTouchHelper;
import com.google.android.material.R.string;
import java.util.List;

class BaseSlider$AccessibilityHelper
  extends ExploreByTouchHelper
{
  Rect a = new Rect();
  private final BaseSlider<?, ?, ?> b;
  
  BaseSlider$AccessibilityHelper(BaseSlider<?, ?, ?> paramBaseSlider)
  {
    super(paramBaseSlider);
    this.b = paramBaseSlider;
  }
  
  @NonNull
  private String a(int paramInt)
  {
    if (paramInt == this.b.getValues().size() - 1) {
      return this.b.getContext().getString(R.string.m);
    }
    if (paramInt == 0) {
      return this.b.getContext().getString(R.string.n);
    }
    return "";
  }
  
  protected int getVirtualViewAt(float paramFloat1, float paramFloat2)
  {
    int i = 0;
    while (i < this.b.getValues().size())
    {
      this.b.a(i, this.a);
      if (this.a.contains((int)paramFloat1, (int)paramFloat2)) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  protected void getVisibleVirtualViews(List<Integer> paramList)
  {
    int i = 0;
    while (i < this.b.getValues().size())
    {
      paramList.add(Integer.valueOf(i));
      i += 1;
    }
  }
  
  protected boolean onPerformActionForVirtualView(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    if (!this.b.isEnabled()) {
      return false;
    }
    if ((paramInt2 != 4096) && (paramInt2 != 8192))
    {
      if (paramInt2 != 16908349) {
        return false;
      }
      if (paramBundle != null)
      {
        if (!paramBundle.containsKey("android.view.accessibility.action.ARGUMENT_PROGRESS_VALUE")) {
          return false;
        }
        f1 = paramBundle.getFloat("android.view.accessibility.action.ARGUMENT_PROGRESS_VALUE");
        if (BaseSlider.a(this.b, paramInt1, f1))
        {
          BaseSlider.c(this.b);
          this.b.postInvalidate();
          invalidateVirtualView(paramInt1);
          return true;
        }
      }
      return false;
    }
    float f2 = BaseSlider.a(this.b, 20);
    float f1 = f2;
    if (paramInt2 == 8192) {
      f1 = -f2;
    }
    f2 = f1;
    if (this.b.c()) {
      f2 = -f1;
    }
    f1 = MathUtils.clamp(((Float)this.b.getValues().get(paramInt1)).floatValue() + f2, this.b.getValueFrom(), this.b.getValueTo());
    if (BaseSlider.a(this.b, paramInt1, f1))
    {
      BaseSlider.c(this.b);
      this.b.postInvalidate();
      invalidateVirtualView(paramInt1);
      return true;
    }
    return false;
  }
  
  protected void onPopulateNodeForVirtualView(int paramInt, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
  {
    paramAccessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SET_PROGRESS);
    List localList = this.b.getValues();
    float f1 = ((Float)localList.get(paramInt)).floatValue();
    float f2 = this.b.getValueFrom();
    float f3 = this.b.getValueTo();
    if (this.b.isEnabled())
    {
      if (f1 > f2) {
        paramAccessibilityNodeInfoCompat.addAction(8192);
      }
      if (f1 < f3) {
        paramAccessibilityNodeInfoCompat.addAction(4096);
      }
    }
    paramAccessibilityNodeInfoCompat.setRangeInfo(AccessibilityNodeInfoCompat.RangeInfoCompat.obtain(1, f2, f3, f1));
    paramAccessibilityNodeInfoCompat.setClassName(SeekBar.class.getName());
    StringBuilder localStringBuilder = new StringBuilder();
    if (this.b.getContentDescription() != null)
    {
      localStringBuilder.append(this.b.getContentDescription());
      localStringBuilder.append(",");
    }
    if (localList.size() > 1)
    {
      localStringBuilder.append(a(paramInt));
      localStringBuilder.append(BaseSlider.a(this.b, f1));
    }
    paramAccessibilityNodeInfoCompat.setContentDescription(localStringBuilder.toString());
    this.b.a(paramInt, this.a);
    paramAccessibilityNodeInfoCompat.setBoundsInParent(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.slider.BaseSlider.AccessibilityHelper
 * JD-Core Version:    0.7.0.1
 */