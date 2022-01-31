package com.tencent.mobileqq.activity.fling;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import wpn;

public class ContentWrapView
  extends RelativeLayout
{
  private Matrix jdField_a_of_type_AndroidGraphicsMatrix = new Matrix();
  private wpn jdField_a_of_type_Wpn;
  
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
    wpn localwpn = this.jdField_a_of_type_Wpn;
    if (localwpn == null) {}
    while (!localwpn.jdField_a_of_type_Boolean) {
      return;
    }
    wpn.a(localwpn).setTranslate(localwpn.jdField_a_of_type_Float, localwpn.b);
    localwpn.jdField_a_of_type_Boolean = false;
  }
  
  private void a(Context paramContext)
  {
    setWillNotDraw(false);
  }
  
  public void draw(Canvas paramCanvas)
  {
    wpn localwpn = this.jdField_a_of_type_Wpn;
    if (localwpn != null)
    {
      a();
      paramCanvas.concat(wpn.a(localwpn));
    }
    super.draw(paramCanvas);
  }
  
  public void ensureTransformationInfo()
  {
    if (this.jdField_a_of_type_Wpn == null) {
      this.jdField_a_of_type_Wpn = new wpn();
    }
  }
  
  public float getTransX()
  {
    if (this.jdField_a_of_type_Wpn != null) {
      return this.jdField_a_of_type_Wpn.jdField_a_of_type_Float;
    }
    return 0.0F;
  }
  
  public float getTransY()
  {
    if (this.jdField_a_of_type_Wpn != null) {
      return this.jdField_a_of_type_Wpn.b;
    }
    return 0.0F;
  }
  
  public void transX(float paramFloat)
  {
    ensureTransformationInfo();
    wpn localwpn = this.jdField_a_of_type_Wpn;
    if (localwpn.jdField_a_of_type_Float != paramFloat)
    {
      localwpn.jdField_a_of_type_Float = paramFloat;
      localwpn.jdField_a_of_type_Boolean = true;
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
    wpn localwpn = this.jdField_a_of_type_Wpn;
    if (localwpn.b != paramFloat)
    {
      localwpn.b = paramFloat;
      localwpn.jdField_a_of_type_Boolean = true;
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