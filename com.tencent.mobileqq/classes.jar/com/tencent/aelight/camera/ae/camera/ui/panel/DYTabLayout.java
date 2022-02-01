package com.tencent.aelight.camera.ae.camera.ui.panel;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class DYTabLayout
  extends FrameLayout
{
  private LinearLayout a;
  private View b;
  private DYTabLayout.TabSelectListener c;
  private DYTabLayout.DYTabItemView d;
  private boolean e;
  
  public DYTabLayout(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public DYTabLayout(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    a(paramContext, paramAttributeSet);
  }
  
  public DYTabLayout(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet);
  }
  
  @TargetApi(21)
  public DYTabLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    a(paramContext, paramAttributeSet);
  }
  
  private void a()
  {
    if (this.b.getVisibility() != 0) {
      return;
    }
    DYTabLayout.DYTabItemView localDYTabItemView = this.d;
    if (localDYTabItemView == null) {
      return;
    }
    int i = localDYTabItemView.getLeft();
    int j = this.d.getWidth();
    int k = this.b.getLeft();
    int m = this.b.getWidth();
    this.b.offsetLeftAndRight(i + j / 2 - k - m / 2);
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    this.a = new LinearLayout(paramContext);
    this.a.setOrientation(0);
    paramAttributeSet = generateDefaultLayoutParams();
    paramAttributeSet.width = -2;
    paramAttributeSet.height = -1;
    addView(this.a, paramAttributeSet);
    this.a.setVisibility(4);
    int i = (int)TypedValue.applyDimension(1, 3.0F, paramContext.getResources().getDisplayMetrics());
    int j = (int)TypedValue.applyDimension(1, 10.0F, paramContext.getResources().getDisplayMetrics());
    this.b = new View(paramContext);
    this.b.setBackgroundDrawable(c(i));
    paramContext = generateDefaultLayoutParams();
    paramContext.gravity = 80;
    paramContext.height = i;
    paramContext.width = j;
    addView(this.b, paramContext);
    this.b.setVisibility(4);
    getViewTreeObserver().addOnGlobalLayoutListener(new DYTabLayout.1(this));
  }
  
  private void b(int paramInt)
  {
    Object localObject1 = this.d;
    if ((localObject1 != null) && (((DYTabLayout.DYTabItemView)localObject1).b == paramInt)) {
      return;
    }
    localObject1 = null;
    int i = 0;
    while (i < this.a.getChildCount())
    {
      localObject2 = (DYTabLayout.DYTabItemView)this.a.getChildAt(i);
      boolean bool;
      if (((DYTabLayout.DYTabItemView)localObject2).b == paramInt) {
        bool = true;
      } else {
        bool = false;
      }
      ((DYTabLayout.DYTabItemView)localObject2).setSelected(bool);
      if (((DYTabLayout.DYTabItemView)localObject2).b == paramInt) {
        localObject1 = localObject2;
      }
      i += 1;
    }
    if (localObject1 == null) {
      return;
    }
    this.d = ((DYTabLayout.DYTabItemView)localObject1);
    Object localObject2 = this.c;
    if (localObject2 != null) {
      ((DYTabLayout.TabSelectListener)localObject2).a((View)localObject1, paramInt);
    }
    requestLayout();
  }
  
  private Drawable c(int paramInt)
  {
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setShape(0);
    localGradientDrawable.setCornerRadius(paramInt);
    localGradientDrawable.setColor(Color.parseColor("#FFFFFF"));
    return localGradientDrawable;
  }
  
  public void a(int paramInt)
  {
    b(paramInt);
  }
  
  public int getSelectTabIndex()
  {
    DYTabLayout.DYTabItemView localDYTabItemView = this.d;
    if (localDYTabItemView == null) {
      return -1;
    }
    return localDYTabItemView.b;
  }
  
  public void setupTabs(String[] paramArrayOfString, DYTabLayout.TabSelectListener paramTabSelectListener)
  {
    this.c = paramTabSelectListener;
    int k = (int)TypedValue.applyDimension(1, 20.0F, getResources().getDisplayMetrics());
    this.a.removeAllViews();
    int i = 0;
    while (i < paramArrayOfString.length)
    {
      paramTabSelectListener = new DYTabLayout.DYTabItemView(this, getContext(), paramArrayOfString[i], i);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -1);
      int j;
      if (i < paramArrayOfString.length - 1) {
        j = k;
      } else {
        j = 0;
      }
      localLayoutParams.rightMargin = j;
      this.a.addView(paramTabSelectListener, localLayoutParams);
      paramTabSelectListener.setOnClickListener(new DYTabLayout.2(this));
      if (i == 0) {
        post(new DYTabLayout.3(this));
      }
      i += 1;
    }
    if (paramArrayOfString.length > 0)
    {
      this.a.setVisibility(0);
      if (this.e) {
        this.b.setVisibility(0);
      }
    }
    else
    {
      this.a.setVisibility(4);
      this.b.setVisibility(4);
    }
    requestLayout();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.panel.DYTabLayout
 * JD-Core Version:    0.7.0.1
 */