package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import aoot;
import com.tencent.mobileqq.R.styleable;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.widget.SquareImageView;
import java.util.List;
import uys;

public class QCircleAvatarListView
  extends ViewGroup
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private boolean jdField_a_of_type_Boolean;
  private int b;
  private int c;
  private int d;
  
  public QCircleAvatarListView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public QCircleAvatarListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public QCircleAvatarListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet);
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.QCircleAvatarListView);
    if (paramContext != null)
    {
      this.jdField_a_of_type_Int = paramContext.getInteger(1, 90);
      this.jdField_a_of_type_Float = paramContext.getFloat(5, 0.8F);
      this.b = ((int)paramContext.getDimension(2, 30.0F));
      this.c = ((int)paramContext.getDimension(0, 30.0F));
      this.jdField_a_of_type_Boolean = paramContext.getBoolean(4, false);
      this.d = ((int)paramContext.getDimension(3, 0.0F));
      paramContext.recycle();
    }
  }
  
  private void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    FrameLayout localFrameLayout = new FrameLayout(getContext());
    localFrameLayout.setLayoutParams(new ViewGroup.LayoutParams(this.b + this.d * 2, this.c + this.d * 2));
    if (!TextUtils.isEmpty(paramString2))
    {
      SquareImageView localSquareImageView = new SquareImageView(getContext());
      localSquareImageView.setLayoutParams(new FrameLayout.LayoutParams(this.b + this.d * 2, this.c + this.d * 2, 17));
      localFrameLayout.addView(localSquareImageView);
      uys.a(paramString2, localSquareImageView);
    }
    paramString2 = new SquareImageView(getContext());
    paramString2.setLayoutParams(new FrameLayout.LayoutParams(this.b, this.c, 17));
    paramString2.setRoundRect(this.jdField_a_of_type_Int);
    localFrameLayout.addView(paramString2);
    if (paramBoolean) {
      uys.a(paramString1, paramString2);
    }
    for (;;)
    {
      addView(localFrameLayout);
      return;
      paramString2.setImageDrawable(aoot.a(((BaseActivity)getContext()).app, 1, 4, paramString1));
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
    setData(paramList, null, false);
  }
  
  public void setData(List<String> paramList1, List<String> paramList2, boolean paramBoolean)
  {
    if ((paramList1 == null) || (paramList1.size() == 0))
    {
      setVisibility(8);
      return;
    }
    setVisibility(0);
    removeAllViews();
    int j = paramList1.size();
    if (this.jdField_a_of_type_Boolean)
    {
      i = j - 1;
      label50:
      if (i >= 0) {
        if ((paramList2 != null) && (paramList2.size() >= i)) {
          break label101;
        }
      }
      label101:
      for (str = "";; str = (String)paramList2.get(i))
      {
        a((String)paramList1.get(i), str, paramBoolean);
        i -= 1;
        break label50;
        break;
      }
    }
    int i = 0;
    label120:
    if (i < j) {
      if ((paramList2 != null) && (paramList2.size() >= i)) {
        break label173;
      }
    }
    label173:
    for (String str = "";; str = (String)paramList2.get(i))
    {
      a((String)paramList1.get(i), str, paramBoolean);
      i += 1;
      break label120;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleAvatarListView
 * JD-Core Version:    0.7.0.1
 */