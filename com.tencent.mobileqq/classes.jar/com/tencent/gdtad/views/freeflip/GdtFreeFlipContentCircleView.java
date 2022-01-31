package com.tencent.gdtad.views.freeflip;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.views.image.GdtCircle;

class GdtFreeFlipContentCircleView
  extends GdtFreeFlipContentViewWithRoundTrip
{
  private final float jdField_a_of_type_Float = 0.1F;
  private GdtCircle jdField_a_of_type_ComTencentGdtadViewsImageGdtCircle = new GdtCircle();
  private float jdField_b_of_type_Float = 3.4028235E+38F;
  private int jdField_b_of_type_Int = 2147483647;
  private int c = 2147483647;
  
  public GdtFreeFlipContentCircleView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public GdtFreeFlipContentCircleView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void a(float paramFloat)
  {
    this.jdField_a_of_type_ComTencentGdtadViewsImageGdtCircle.a(paramFloat);
    postInvalidate();
  }
  
  public void a(int paramInt)
  {
    GdtLog.b("GdtFreeFlipContentCircleView", String.format("onViewResume location:%d", new Object[] { Integer.valueOf(paramInt) }));
    super.a(paramInt);
    a(0.0F);
  }
  
  public boolean a()
  {
    return (super.a()) && (this.jdField_b_of_type_Int != 2147483647) && (this.c != 2147483647) && (this.jdField_b_of_type_Float != 3.4028235E+38F);
  }
  
  public void b(int paramInt)
  {
    GdtLog.b("GdtFreeFlipContentCircleView", String.format("onViewPause location:%d", new Object[] { Integer.valueOf(paramInt) }));
    super.b(paramInt);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (a()) {
      this.jdField_a_of_type_ComTencentGdtadViewsImageGdtCircle.a(paramCanvas, b());
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.jdField_b_of_type_Int = getWidth();
    this.c = getHeight();
    this.jdField_b_of_type_Float = Double.valueOf(Math.sqrt(Math.pow(this.jdField_b_of_type_Int, 2.0D) + Math.pow(this.c, 2.0D)) * 0.8999999761581421D).floatValue();
    this.jdField_a_of_type_ComTencentGdtadViewsImageGdtCircle.a(this.jdField_b_of_type_Int, this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\c222.jar
 * Qualified Name:     com.tencent.gdtad.views.freeflip.GdtFreeFlipContentCircleView
 * JD-Core Version:    0.7.0.1
 */