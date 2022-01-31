package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import bdbk;
import com.tencent.mobileqq.R.styleable;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.widget.SquareImageView;
import java.util.List;
import tql;

public class AvatarListView
  extends ViewGroup
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private boolean jdField_a_of_type_Boolean;
  private int b;
  private int c;
  private int d;
  private int e;
  
  public AvatarListView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public AvatarListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public AvatarListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet);
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.AvatarListView);
    if (paramContext != null)
    {
      this.jdField_a_of_type_Int = paramContext.getInteger(1, 90);
      this.jdField_a_of_type_Float = paramContext.getFloat(6, 0.8F);
      this.b = ((int)paramContext.getDimension(2, 30.0F));
      this.c = ((int)paramContext.getDimension(0, 30.0F));
      this.jdField_a_of_type_Boolean = paramContext.getBoolean(5, false);
      this.d = paramContext.getColor(3, -1);
      this.e = ((int)paramContext.getDimension(4, 0.0F));
      paramContext.recycle();
    }
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    SquareImageView localSquareImageView = new SquareImageView(getContext());
    ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(this.b, this.c);
    if ((this.d != -1) && (this.e != 0))
    {
      localSquareImageView.setPadding(this.e, this.e, this.e, this.e);
      localSquareImageView.setCircleBgColor(this.d);
    }
    localSquareImageView.setLayoutParams(localLayoutParams);
    localSquareImageView.setRoundRect(this.jdField_a_of_type_Int);
    if (paramBoolean) {
      tql.a(paramString, localSquareImageView);
    }
    for (;;)
    {
      addView(localSquareImageView);
      return;
      localSquareImageView.setImageDrawable(bdbk.a(((BaseActivity)getContext()).app, 1, 4, paramString));
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = getChildCount();
    View localView;
    int j;
    if (this.jdField_a_of_type_Boolean)
    {
      paramInt4 = paramInt3 - paramInt1;
      paramInt3 -= paramInt1;
      paramInt2 = i - 1;
      paramInt1 = paramInt4;
      if (paramInt2 >= 0)
      {
        localView = getChildAt(i - 1 - paramInt2);
        paramInt4 = localView.getMeasuredWidth();
        j = localView.getMeasuredHeight();
        if (paramInt2 == i - 1) {
          paramInt1 -= paramInt4;
        }
        for (;;)
        {
          localView.layout(paramInt1, 0, paramInt3, j);
          paramInt3 = (int)(paramInt3 - paramInt4 * this.jdField_a_of_type_Float);
          paramInt2 -= 1;
          break;
          paramInt1 = (int)(paramInt1 - paramInt4 * this.jdField_a_of_type_Float);
        }
      }
    }
    else
    {
      paramInt3 = 0;
      paramInt1 = 0;
      paramInt2 = 0;
      if (paramInt2 < i)
      {
        localView = getChildAt(paramInt2);
        paramInt4 = localView.getMeasuredWidth();
        j = localView.getMeasuredHeight();
        if (paramInt2 == 0) {
          paramInt1 += paramInt4;
        }
        for (;;)
        {
          localView.layout(paramInt3, 0, paramInt1, j);
          paramInt3 = (int)(paramInt3 + paramInt4 * this.jdField_a_of_type_Float);
          paramInt2 += 1;
          break;
          paramInt1 = (int)(paramInt1 + paramInt4 * this.jdField_a_of_type_Float);
        }
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int j = 0;
    super.onMeasure(paramInt1, paramInt2);
    int m = View.MeasureSpec.getSize(paramInt2);
    int i1 = View.MeasureSpec.getMode(paramInt2);
    int i2 = View.MeasureSpec.getMode(paramInt1);
    int n = View.MeasureSpec.getSize(paramInt1);
    int i3 = getChildCount();
    int k = 0;
    int i = 0;
    if (k < i3)
    {
      View localView = getChildAt(k);
      measureChild(localView, paramInt1, paramInt2);
      int i5 = localView.getMeasuredWidth();
      int i4 = localView.getMeasuredHeight();
      if (k == 0) {
        j += i5;
      }
      for (;;)
      {
        i = Math.max(i, i4);
        k += 1;
        break;
        j = (int)(j + i5 * this.jdField_a_of_type_Float);
      }
    }
    if (i2 == 1073741824)
    {
      paramInt1 = n;
      if (i1 != 1073741824) {
        break label160;
      }
    }
    label160:
    for (paramInt2 = m;; paramInt2 = i)
    {
      setMeasuredDimension(paramInt1, paramInt2);
      return;
      paramInt1 = j;
      break;
    }
  }
  
  public void setData(List<String> paramList)
  {
    setData(paramList, false);
  }
  
  public void setData(List<String> paramList, boolean paramBoolean)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      setVisibility(8);
    }
    for (;;)
    {
      return;
      setVisibility(0);
      removeAllViews();
      int j = paramList.size();
      int i;
      if (this.jdField_a_of_type_Boolean)
      {
        i = j - 1;
        while (i >= 0)
        {
          a((String)paramList.get(i), paramBoolean);
          i -= 1;
        }
      }
      else
      {
        i = 0;
        while (i < j)
        {
          a((String)paramList.get(i), paramBoolean);
          i += 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.AvatarListView
 * JD-Core Version:    0.7.0.1
 */