package com.tencent.mobileqq.activity.fling;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import wuy;

public class ContentWrapView
  extends RelativeLayout
{
  private Matrix jdField_a_of_type_AndroidGraphicsMatrix = new Matrix();
  private wuy jdField_a_of_type_Wuy;
  
  public ContentWrapView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public ContentWrapView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ContentWrapView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a()
  {
    wuy localwuy = this.jdField_a_of_type_Wuy;
    if (localwuy == null) {}
    while (!localwuy.jdField_a_of_type_Boolean) {
      return;
    }
    wuy.a(localwuy).setTranslate(localwuy.jdField_a_of_type_Float, localwuy.b);
    localwuy.jdField_a_of_type_Boolean = false;
  }
  
  private void a(Context paramContext)
  {
    setWillNotDraw(false);
  }
  
  public void draw(Canvas paramCanvas)
  {
    wuy localwuy = this.jdField_a_of_type_Wuy;
    if (localwuy != null)
    {
      a();
      paramCanvas.concat(wuy.a(localwuy));
    }
    super.draw(paramCanvas);
  }
  
  public void ensureTransformationInfo()
  {
    if (this.jdField_a_of_type_Wuy == null) {
      this.jdField_a_of_type_Wuy = new wuy();
    }
  }
  
  public float getTransX()
  {
    if (this.jdField_a_of_type_Wuy != null) {
      return this.jdField_a_of_type_Wuy.jdField_a_of_type_Float;
    }
    return 0.0F;
  }
  
  public float getTransY()
  {
    if (this.jdField_a_of_type_Wuy != null) {
      return this.jdField_a_of_type_Wuy.b;
    }
    return 0.0F;
  }
  
  public void transX(float paramFloat)
  {
    ensureTransformationInfo();
    wuy localwuy = this.jdField_a_of_type_Wuy;
    if (localwuy.jdField_a_of_type_Float != paramFloat)
    {
      localwuy.jdField_a_of_type_Float = paramFloat;
      localwuy.jdField_a_of_type_Boolean = true;
      invalidate();
    }
  }
  
  public void transXBy(float paramFloat)
  {
    if (paramFloat != 0.0F) {
      transX(getTransX() + paramFloat);
    }
  }
  
  public void transY(float paramFloat)
  {
    ensureTransformationInfo();
    wuy localwuy = this.jdField_a_of_type_Wuy;
    if (localwuy.b != paramFloat)
    {
      localwuy.b = paramFloat;
      localwuy.jdField_a_of_type_Boolean = true;
      invalidate();
    }
  }
  
  public void transYBy(float paramFloat)
  {
    if (paramFloat != 0.0F) {
      transX(getTransX() + paramFloat);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.fling.ContentWrapView
 * JD-Core Version:    0.7.0.1
 */