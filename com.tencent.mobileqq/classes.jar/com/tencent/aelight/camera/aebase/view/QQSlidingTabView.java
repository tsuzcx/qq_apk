package com.tencent.aelight.camera.aebase.view;

import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.R.styleable;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.widget.RedDotTextView;
import java.util.ArrayList;

public class QQSlidingTabView
  extends HorizontalScrollView
{
  private static final int[] jdField_a_of_type_ArrayOfInt = { 16842901, 16842904 };
  private int jdField_a_of_type_Int = -7829368;
  private Paint jdField_a_of_type_AndroidGraphicsPaint = null;
  private LinearLayout.LayoutParams jdField_a_of_type_AndroidWidgetLinearLayout$LayoutParams = null;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout = null;
  private QQSlidingTabView.IOnTabCheckListener jdField_a_of_type_ComTencentAelightCameraAebaseViewQQSlidingTabView$IOnTabCheckListener;
  private ArrayList<View> jdField_a_of_type_JavaUtilArrayList = new ArrayList(5);
  private boolean jdField_a_of_type_Boolean = false;
  private int b = -16777216;
  private int c = 14;
  private int d = 0;
  private int e = 15;
  private int f = 5;
  private int g = 52;
  private int h = 0;
  private int i = 4;
  private int j = -16776961;
  private int k = 1;
  private int l = -3355444;
  private int m = 0;
  private int n = 0;
  private int o = 0;
  private int p = 0;
  
  public QQSlidingTabView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet);
  }
  
  public QQSlidingTabView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet);
  }
  
  @TargetApi(11)
  private void a()
  {
    int i1 = this.n;
    int i2 = this.m;
    if (i1 != i2)
    {
      Object localObject = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(i1);
      View localView = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(this.m);
      if ((localObject != null) && (localView != null))
      {
        i1 = ((View)localObject).getLeft();
        i2 = localView.getLeft();
        if ((i1 == 0) && (i2 == 0))
        {
          this.jdField_a_of_type_Boolean = true;
          return;
        }
        this.jdField_a_of_type_Boolean = false;
        localObject = ValueAnimator.ofInt(new int[] { i1, i2 });
        ((ValueAnimator)localObject).setDuration(100L);
        ((ValueAnimator)localObject).addUpdateListener(new QQSlidingTabView.2(this));
        ((ValueAnimator)localObject).start();
      }
    }
    else
    {
      this.h = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(i2).getLeft();
      invalidate();
    }
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout$LayoutParams = new LinearLayout.LayoutParams(-2, -1);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = new LinearLayout(paramContext);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOrientation(0);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams(this.jdField_a_of_type_AndroidWidgetLinearLayout$LayoutParams);
    addView(this.jdField_a_of_type_AndroidWidgetLinearLayout);
    DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
    this.d = ((int)TypedValue.applyDimension(1, this.d, localDisplayMetrics));
    this.g = ((int)TypedValue.applyDimension(1, this.g, localDisplayMetrics));
    this.i = ((int)TypedValue.applyDimension(1, this.i, localDisplayMetrics));
    this.k = ((int)TypedValue.applyDimension(1, this.k, localDisplayMetrics));
    this.e = ((int)TypedValue.applyDimension(1, this.e, localDisplayMetrics));
    this.c = ((int)TypedValue.applyDimension(1, this.c, localDisplayMetrics));
    this.f = ((int)TypedValue.applyDimension(1, this.f, localDisplayMetrics));
    paramContext.obtainStyledAttributes(paramAttributeSet, jdField_a_of_type_ArrayOfInt).recycle();
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.QIMSlidingTabViewStyle);
    this.d = paramContext.getDimensionPixelSize(4, this.d);
    this.e = paramContext.getDimensionPixelSize(3, this.e);
    this.j = paramContext.getColor(0, this.j);
    this.i = paramContext.getDimensionPixelSize(1, this.i);
    this.jdField_a_of_type_Int = paramContext.getColor(6, this.jdField_a_of_type_Int);
    this.b = paramContext.getColor(5, this.b);
    this.l = paramContext.getColor(8, this.l);
    this.k = paramContext.getDimensionPixelSize(9, this.k);
    this.c = paramContext.getDimensionPixelSize(7, this.c);
    this.f = paramContext.getDimensionPixelSize(2, this.f);
    paramContext.recycle();
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.j);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    setFillViewport(true);
    setWillNotDraw(false);
    setHorizontalScrollBarEnabled(false);
    this.p = ScreenUtil.dip2px(this.o);
  }
  
  private void b(int paramInt)
  {
    int i2 = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount();
    int i1 = 0;
    while (i1 < i2)
    {
      Object localObject2 = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(i1);
      Object localObject1 = this.jdField_a_of_type_JavaUtilArrayList;
      if ((localObject1 != null) && (i1 < ((ArrayList)localObject1).size()))
      {
        localObject1 = (View)this.jdField_a_of_type_JavaUtilArrayList.get(i1);
        if (i1 == paramInt)
        {
          if ((localObject1 instanceof ImageView))
          {
            localObject2 = (Bundle)((View)localObject1).getTag();
            if (localObject2 != null) {
              ((ImageView)localObject1).setImageResource(((Bundle)localObject2).getInt("checked_image_bg_id", 2130846887));
            }
          }
          else if ((localObject1 instanceof RedDotTextView))
          {
            localObject1 = (RedDotTextView)localObject2;
            ((RedDotTextView)localObject1).setTextColor(this.b);
            ((RedDotTextView)localObject1).a(false);
          }
          else if ((localObject1 instanceof TextView))
          {
            ((TextView)localObject2).setTextColor(this.b);
          }
        }
        else if ((localObject1 instanceof ImageView))
        {
          localObject2 = (Bundle)((View)localObject1).getTag();
          if (localObject2 != null) {
            ((ImageView)localObject1).setImageResource(((Bundle)localObject2).getInt("normal_image_bg_id", 2130846886));
          }
        }
        else if ((localObject1 instanceof RedDotTextView))
        {
          ((RedDotTextView)localObject2).setTextColor(this.jdField_a_of_type_Int);
        }
        else if ((localObject1 instanceof TextView))
        {
          ((TextView)localObject2).setTextColor(this.jdField_a_of_type_Int);
        }
      }
      i1 += 1;
    }
  }
  
  private void c(int paramInt)
  {
    View localView = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(paramInt);
    if (localView != null)
    {
      paramInt = getScrollX();
      int i1 = this.e * 4;
      int i2 = localView.getRight() - paramInt - getWidth() + i1;
      if (i2 > 0)
      {
        smoothScrollBy(i2, 0);
        return;
      }
      paramInt = localView.getLeft() - paramInt - i1;
      if (paramInt < 0) {
        smoothScrollBy(paramInt, 0);
      }
    }
  }
  
  public void a(int paramInt)
  {
    if (paramInt >= 0)
    {
      if (paramInt >= this.jdField_a_of_type_JavaUtilArrayList.size()) {
        return;
      }
      this.m = paramInt;
      b(paramInt);
      c(paramInt);
      a();
      QQSlidingTabView.IOnTabCheckListener localIOnTabCheckListener = this.jdField_a_of_type_ComTencentAelightCameraAebaseViewQQSlidingTabView$IOnTabCheckListener;
      if (localIOnTabCheckListener != null) {
        localIOnTabCheckListener.a(paramInt);
      }
      this.n = this.m;
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int i1 = getHeight();
    Object localObject = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(this.m);
    if (localObject != null)
    {
      if (this.jdField_a_of_type_Boolean)
      {
        this.h = ((View)localObject).getLeft();
        c(this.m);
        this.jdField_a_of_type_Boolean = false;
      }
      if ((this.m == 0) && (this.h < ((View)localObject).getLeft())) {
        this.h = ((View)localObject).getLeft();
      }
      int i2 = this.h;
      localObject = new RectF(this.f + i2, i1 - this.i, i2 + ((View)localObject).getWidth() - this.f, i1);
      i1 = this.p;
      paramCanvas.drawRoundRect((RectF)localObject, i1, i1, this.jdField_a_of_type_AndroidGraphicsPaint);
    }
  }
  
  public void setIndicateColor(int paramInt)
  {
    this.j = paramInt;
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.j);
    invalidate();
  }
  
  public void setTabCheckListener(QQSlidingTabView.IOnTabCheckListener paramIOnTabCheckListener)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAebaseViewQQSlidingTabView$IOnTabCheckListener = paramIOnTabCheckListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aebase.view.QQSlidingTabView
 * JD-Core Version:    0.7.0.1
 */