package com.tencent.mobileqq.activity.fling;

import afvr;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

public class ContentWrapView
  extends RelativeLayout
{
  private afvr jdField_a_of_type_Afvr;
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
    afvr localafvr = this.jdField_a_of_type_Afvr;
    if (localafvr == null) {}
    while (!localafvr.jdField_a_of_type_Boolean) {
      return;
    }
    afvr.a(localafvr).setTranslate(localafvr.jdField_a_of_type_Float, localafvr.b);
    localafvr.jdField_a_of_type_Boolean = false;
  }
  
  private void a(Context paramContext)
  {
    setWillNotDraw(false);
  }
  
  public void draw(Canvas paramCanvas)
  {
    afvr localafvr = this.jdField_a_of_type_Afvr;
    if (localafvr != null)
    {
      a();
      paramCanvas.concat(afvr.a(localafvr));
    }
    super.draw(paramCanvas);
  }
  
  public void ensureTransformationInfo()
  {
    if (this.jdField_a_of_type_Afvr == null) {
      this.jdField_a_of_type_Afvr = new afvr();
    }
  }
  
  public float getTransX()
  {
    if (this.jdField_a_of_type_Afvr != null) {
      return this.jdField_a_of_type_Afvr.jdField_a_of_type_Float;
    }
    return 0.0F;
  }
  
  public float getTransY()
  {
    if (this.jdField_a_of_type_Afvr != null) {
      return this.jdField_a_of_type_Afvr.b;
    }
    return 0.0F;
  }
  
  public void transX(float paramFloat)
  {
    ensureTransformationInfo();
    afvr localafvr = this.jdField_a_of_type_Afvr;
    if (localafvr.jdField_a_of_type_Float != paramFloat)
    {
      localafvr.jdField_a_of_type_Float = paramFloat;
      localafvr.jdField_a_of_type_Boolean = true;
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
    afvr localafvr = this.jdField_a_of_type_Afvr;
    if (localafvr.b != paramFloat)
    {
      localafvr.b = paramFloat;
      localafvr.jdField_a_of_type_Boolean = true;
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