package com.tencent.biz.subscribe.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import bcwh;
import com.tencent.common.app.BaseApplicationImpl;

public class RadiusLinerLayout
  extends LinearLayout
{
  public static final int a = bcwh.a(BaseApplicationImpl.context, 8.0F);
  private int b = a;
  
  public RadiusLinerLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public RadiusLinerLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public RadiusLinerLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    setWillNotDraw(false);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.RadiusLinerLayout
 * JD-Core Version:    0.7.0.1
 */