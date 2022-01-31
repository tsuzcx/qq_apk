package com.tencent.mobileqq.activity.fling;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import wmi;

public class ContentWrapView
  extends RelativeLayout
{
  private Matrix jdField_a_of_type_AndroidGraphicsMatrix = new Matrix();
  private wmi jdField_a_of_type_Wmi;
  
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
    wmi localwmi = this.jdField_a_of_type_Wmi;
    if (localwmi == null) {}
    while (!localwmi.jdField_a_of_type_Boolean) {
      return;
    }
    wmi.a(localwmi).setTranslate(localwmi.jdField_a_of_type_Float, localwmi.b);
    localwmi.jdField_a_of_type_Boolean = false;
  }
  
  private void a(Context paramContext)
  {
    setWillNotDraw(false);
  }
  
  public void draw(Canvas paramCanvas)
  {
    wmi localwmi = this.jdField_a_of_type_Wmi;
    if (localwmi != null)
    {
      a();
      paramCanvas.concat(wmi.a(localwmi));
    }
    super.draw(paramCanvas);
  }
  
  public void ensureTransformationInfo()
  {
    if (this.jdField_a_of_type_Wmi == null) {
      this.jdField_a_of_type_Wmi = new wmi();
    }
  }
  
  public float getTransX()
  {
    if (this.jdField_a_of_type_Wmi != null) {
      return this.jdField_a_of_type_Wmi.jdField_a_of_type_Float;
    }
    return 0.0F;
  }
  
  public float getTransY()
  {
    if (this.jdField_a_of_type_Wmi != null) {
      return this.jdField_a_of_type_Wmi.b;
    }
    return 0.0F;
  }
  
  public void transX(float paramFloat)
  {
    ensureTransformationInfo();
    wmi localwmi = this.jdField_a_of_type_Wmi;
    if (localwmi.jdField_a_of_type_Float != paramFloat)
    {
      localwmi.jdField_a_of_type_Float = paramFloat;
      localwmi.jdField_a_of_type_Boolean = true;
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
    wmi localwmi = this.jdField_a_of_type_Wmi;
    if (localwmi.b != paramFloat)
    {
      localwmi.b = paramFloat;
      localwmi.jdField_a_of_type_Boolean = true;
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