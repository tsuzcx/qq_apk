package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.ScrollView;
import com.tencent.biz.qqcircle.utils.ImmersiveUtils;
import com.tencent.mobileqq.biz.qcircle.R.styleable;

public class QCircleMaxHeightScrollView
  extends ScrollView
{
  private int a;
  
  public QCircleMaxHeightScrollView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public QCircleMaxHeightScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public QCircleMaxHeightScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.cL);
    this.a = paramContext.getDimensionPixelSize(R.styleable.cM, ImmersiveUtils.a(300.0F));
    paramContext.recycle();
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(this.a, -2147483648));
  }
  
  public void setMaxHeight(int paramInt)
  {
    this.a = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleMaxHeightScrollView
 * JD-Core Version:    0.7.0.1
 */