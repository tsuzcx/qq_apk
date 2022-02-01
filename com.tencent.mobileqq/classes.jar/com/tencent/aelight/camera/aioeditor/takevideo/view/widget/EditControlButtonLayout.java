package com.tencent.aelight.camera.aioeditor.takevideo.view.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class EditControlButtonLayout
  extends LinearLayout
{
  private final List<Integer> a = new ArrayList(20);
  private final Comparator<Integer> b = new EditControlButtonLayout.2(this);
  
  public EditControlButtonLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public EditControlButtonLayout(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public EditControlButtonLayout(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  @TargetApi(21)
  public EditControlButtonLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    a(paramContext);
  }
  
  private void a()
  {
    if (!(getParent() instanceof HorizontalScrollView)) {
      return;
    }
    Object localObject = (HorizontalScrollView)getParent();
    int i1 = ((HorizontalScrollView)localObject).getWidth() - ((HorizontalScrollView)localObject).getPaddingLeft() - ((HorizontalScrollView)localObject).getPaddingRight();
    int k = getMeasuredWidth();
    if (k <= i1) {
      return;
    }
    this.a.clear();
    int i = 0;
    while (i < getChildCount())
    {
      if (getChildAt(i).getVisibility() != 8) {
        this.a.add(Integer.valueOf(i));
      }
      i += 1;
    }
    if (this.a.isEmpty()) {
      return;
    }
    Collections.sort(this.a, this.b);
    i = -1;
    int j = 0;
    while (j < this.a.size())
    {
      localObject = getChildAt(((Integer)this.a.get(j)).intValue());
      int n = Math.abs(i1 - (((View)localObject).getLeft() + ((View)localObject).getRight()) / 2);
      int m = k;
      if (n < k)
      {
        i = j;
        m = n;
      }
      j += 1;
      k = m;
    }
    if (i <= 0) {
      return;
    }
    localObject = getChildAt(((Integer)this.a.get(i)).intValue());
    j = ((View)localObject).getRight();
    k = ((View)localObject).getWidth();
    if ((j >= i1) && (j - i1 < k / 2)) {
      return;
    }
    j = getPaddingLeft();
    k = 0;
    while (k <= i)
    {
      j += getChildAt(((Integer)this.a.get(k)).intValue()).getWidth();
      k += 1;
    }
    if (i < 4)
    {
      k = i + 1;
      if (k < this.a.size())
      {
        localObject = getChildAt(((Integer)this.a.get(k)).intValue());
        if (((View)localObject).getWidth() + j < i1)
        {
          j += ((View)localObject).getWidth();
          i = k;
        }
      }
    }
    float f = (i1 - j) / (i * 2);
    if (f > 0.0F)
    {
      i = 0;
      while (i < this.a.size())
      {
        localObject = getChildAt(((Integer)this.a.get(i)).intValue());
        LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)((View)localObject).getLayoutParams();
        if (i == 0) {
          j = 0;
        } else {
          j = (int)(1.0F + f);
        }
        localLayoutParams.leftMargin = j;
        if (i == this.a.size() - 1) {
          j = 0;
        } else {
          j = (int)f;
        }
        localLayoutParams.rightMargin = j;
        ((View)localObject).setLayoutParams(localLayoutParams);
        i += 1;
      }
    }
  }
  
  private void a(Context paramContext)
  {
    addOnLayoutChangeListener(new EditControlButtonLayout.1(this));
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.view.widget.EditControlButtonLayout
 * JD-Core Version:    0.7.0.1
 */