package com.tencent.mobileqq.activity.fling;

import afjw;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

public class ContentWrapView
  extends RelativeLayout
{
  private afjw jdField_a_of_type_Afjw;
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
    afjw localafjw = this.jdField_a_of_type_Afjw;
    if (localafjw == null) {}
    while (!localafjw.jdField_a_of_type_Boolean) {
      return;
    }
    afjw.a(localafjw).setTranslate(localafjw.jdField_a_of_type_Float, localafjw.b);
    localafjw.jdField_a_of_type_Boolean = false;
  }
  
  private void a(Context paramContext)
  {
    setWillNotDraw(false);
  }
  
  public void draw(Canvas paramCanvas)
  {
    afjw localafjw = this.jdField_a_of_type_Afjw;
    if (localafjw != null)
    {
      a();
      paramCanvas.concat(afjw.a(localafjw));
    }
    super.draw(paramCanvas);
  }
  
  public void ensureTransformationInfo()
  {
    if (this.jdField_a_of_type_Afjw == null) {
      this.jdField_a_of_type_Afjw = new afjw();
    }
  }
  
  public float getTransX()
  {
    if (this.jdField_a_of_type_Afjw != null) {
      return this.jdField_a_of_type_Afjw.jdField_a_of_type_Float;
    }
    return 0.0F;
  }
  
  public float getTransY()
  {
    if (this.jdField_a_of_type_Afjw != null) {
      return this.jdField_a_of_type_Afjw.b;
    }
    return 0.0F;
  }
  
  public void transX(float paramFloat)
  {
    ensureTransformationInfo();
    afjw localafjw = this.jdField_a_of_type_Afjw;
    if (localafjw.jdField_a_of_type_Float != paramFloat)
    {
      localafjw.jdField_a_of_type_Float = paramFloat;
      localafjw.jdField_a_of_type_Boolean = true;
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
    afjw localafjw = this.jdField_a_of_type_Afjw;
    if (localafjw.b != paramFloat)
    {
      localafjw.b = paramFloat;
      localafjw.jdField_a_of_type_Boolean = true;
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