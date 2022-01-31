package com.tencent.mobileqq.activity.fling;

import ahtl;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

public class ContentWrapView
  extends RelativeLayout
{
  private ahtl jdField_a_of_type_Ahtl;
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
    ahtl localahtl = this.jdField_a_of_type_Ahtl;
    if (localahtl == null) {}
    while (!localahtl.jdField_a_of_type_Boolean) {
      return;
    }
    ahtl.a(localahtl).setTranslate(localahtl.jdField_a_of_type_Float, localahtl.b);
    localahtl.jdField_a_of_type_Boolean = false;
  }
  
  private void a(Context paramContext)
  {
    setWillNotDraw(false);
  }
  
  public void draw(Canvas paramCanvas)
  {
    ahtl localahtl = this.jdField_a_of_type_Ahtl;
    if (localahtl != null)
    {
      a();
      paramCanvas.concat(ahtl.a(localahtl));
    }
    super.draw(paramCanvas);
  }
  
  public void ensureTransformationInfo()
  {
    if (this.jdField_a_of_type_Ahtl == null) {
      this.jdField_a_of_type_Ahtl = new ahtl();
    }
  }
  
  public float getTransX()
  {
    if (this.jdField_a_of_type_Ahtl != null) {
      return this.jdField_a_of_type_Ahtl.jdField_a_of_type_Float;
    }
    return 0.0F;
  }
  
  public float getTransY()
  {
    if (this.jdField_a_of_type_Ahtl != null) {
      return this.jdField_a_of_type_Ahtl.b;
    }
    return 0.0F;
  }
  
  public void transX(float paramFloat)
  {
    ensureTransformationInfo();
    ahtl localahtl = this.jdField_a_of_type_Ahtl;
    if (localahtl.jdField_a_of_type_Float != paramFloat)
    {
      localahtl.jdField_a_of_type_Float = paramFloat;
      localahtl.jdField_a_of_type_Boolean = true;
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
    ahtl localahtl = this.jdField_a_of_type_Ahtl;
    if (localahtl.b != paramFloat)
    {
      localahtl.b = paramFloat;
      localahtl.jdField_a_of_type_Boolean = true;
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