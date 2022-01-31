package com.tencent.mobileqq.activity.fling;

import afvt;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

public class ContentWrapView
  extends RelativeLayout
{
  private afvt jdField_a_of_type_Afvt;
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
    afvt localafvt = this.jdField_a_of_type_Afvt;
    if (localafvt == null) {}
    while (!localafvt.jdField_a_of_type_Boolean) {
      return;
    }
    afvt.a(localafvt).setTranslate(localafvt.jdField_a_of_type_Float, localafvt.b);
    localafvt.jdField_a_of_type_Boolean = false;
  }
  
  private void a(Context paramContext)
  {
    setWillNotDraw(false);
  }
  
  public void draw(Canvas paramCanvas)
  {
    afvt localafvt = this.jdField_a_of_type_Afvt;
    if (localafvt != null)
    {
      a();
      paramCanvas.concat(afvt.a(localafvt));
    }
    super.draw(paramCanvas);
  }
  
  public void ensureTransformationInfo()
  {
    if (this.jdField_a_of_type_Afvt == null) {
      this.jdField_a_of_type_Afvt = new afvt();
    }
  }
  
  public float getTransX()
  {
    if (this.jdField_a_of_type_Afvt != null) {
      return this.jdField_a_of_type_Afvt.jdField_a_of_type_Float;
    }
    return 0.0F;
  }
  
  public float getTransY()
  {
    if (this.jdField_a_of_type_Afvt != null) {
      return this.jdField_a_of_type_Afvt.b;
    }
    return 0.0F;
  }
  
  public void transX(float paramFloat)
  {
    ensureTransformationInfo();
    afvt localafvt = this.jdField_a_of_type_Afvt;
    if (localafvt.jdField_a_of_type_Float != paramFloat)
    {
      localafvt.jdField_a_of_type_Float = paramFloat;
      localafvt.jdField_a_of_type_Boolean = true;
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
    afvt localafvt = this.jdField_a_of_type_Afvt;
    if (localafvt.b != paramFloat)
    {
      localafvt.b = paramFloat;
      localafvt.jdField_a_of_type_Boolean = true;
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