package com.tencent.biz.qqcircle.publish.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View.MeasureSpec;
import android.view.WindowManager;
import com.tencent.mobileqq.biz.qcircle.R.styleable;
import com.tencent.widget.GridView;

public class ExtendGridView
  extends GridView
{
  protected int a;
  protected int b;
  private int c;
  private int d;
  private int e;
  private boolean f;
  private boolean g;
  
  public ExtendGridView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ExtendGridView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ExtendGridView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.bh);
    this.f = paramContext.getBoolean(R.styleable.bj, false);
    this.g = paramContext.getBoolean(R.styleable.bi, false);
    paramContext.recycle();
    a();
  }
  
  private void a()
  {
    b();
  }
  
  private void b()
  {
    Display localDisplay = ((WindowManager)getContext().getSystemService("window")).getDefaultDisplay();
    this.a = localDisplay.getWidth();
    this.b = localDisplay.getHeight();
  }
  
  public int getHorizontalSpacing()
  {
    return this.c;
  }
  
  public int getNumColumns()
  {
    return this.e;
  }
  
  public int getVerticalSpacing()
  {
    return this.d;
  }
  
  @TargetApi(8)
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    b();
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if (this.f) {
      paramInt2 = View.MeasureSpec.makeMeasureSpec(536870911, -2147483648);
    }
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = pointToPosition((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
    if ((this.g) && (i < 0)) {
      return false;
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setHorizontalSpacing(int paramInt)
  {
    super.setHorizontalSpacing(paramInt);
    this.c = paramInt;
  }
  
  public void setNumColumns(int paramInt)
  {
    super.setNumColumns(paramInt);
    this.e = paramInt;
  }
  
  public void setPenetrateTouch(boolean paramBoolean)
  {
    this.g = paramBoolean;
  }
  
  public void setStretchable(boolean paramBoolean)
  {
    if (this.f != paramBoolean)
    {
      this.f = paramBoolean;
      requestLayout();
    }
  }
  
  public void setVerticalSpacing(int paramInt)
  {
    super.setVerticalSpacing(paramInt);
    this.d = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.view.ExtendGridView
 * JD-Core Version:    0.7.0.1
 */