package com.tencent.mobileqq.activity.fling;

import ahya;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

public class ContentWrapView
  extends RelativeLayout
{
  private ahya jdField_a_of_type_Ahya;
  private Matrix jdField_a_of_type_AndroidGraphicsMatrix = new Matrix();
  
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
    ahya localahya = this.jdField_a_of_type_Ahya;
    if (localahya == null) {}
    while (!localahya.jdField_a_of_type_Boolean) {
      return;
    }
    ahya.a(localahya).setTranslate(localahya.jdField_a_of_type_Float, localahya.b);
    localahya.jdField_a_of_type_Boolean = false;
  }
  
  private void a(Context paramContext)
  {
    setWillNotDraw(false);
  }
  
  public void draw(Canvas paramCanvas)
  {
    ahya localahya = this.jdField_a_of_type_Ahya;
    if (localahya != null)
    {
      a();
      paramCanvas.concat(ahya.a(localahya));
    }
    super.draw(paramCanvas);
  }
  
  public void ensureTransformationInfo()
  {
    if (this.jdField_a_of_type_Ahya == null) {
      this.jdField_a_of_type_Ahya = new ahya();
    }
  }
  
  public float getTransX()
  {
    if (this.jdField_a_of_type_Ahya != null) {
      return this.jdField_a_of_type_Ahya.jdField_a_of_type_Float;
    }
    return 0.0F;
  }
  
  public float getTransY()
  {
    if (this.jdField_a_of_type_Ahya != null) {
      return this.jdField_a_of_type_Ahya.b;
    }
    return 0.0F;
  }
  
  public void transX(float paramFloat)
  {
    ensureTransformationInfo();
    ahya localahya = this.jdField_a_of_type_Ahya;
    if (localahya.jdField_a_of_type_Float != paramFloat)
    {
      localahya.jdField_a_of_type_Float = paramFloat;
      localahya.jdField_a_of_type_Boolean = true;
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
    ahya localahya = this.jdField_a_of_type_Ahya;
    if (localahya.b != paramFloat)
    {
      localahya.b = paramFloat;
      localahya.jdField_a_of_type_Boolean = true;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.fling.ContentWrapView
 * JD-Core Version:    0.7.0.1
 */