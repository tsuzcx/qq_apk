package com.tencent.mobileqq.activity.fling;

import aiux;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

public class ContentWrapView
  extends RelativeLayout
{
  private aiux jdField_a_of_type_Aiux;
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
    aiux localaiux = this.jdField_a_of_type_Aiux;
    if (localaiux == null) {}
    while (!localaiux.jdField_a_of_type_Boolean) {
      return;
    }
    aiux.a(localaiux).setTranslate(localaiux.jdField_a_of_type_Float, localaiux.b);
    localaiux.jdField_a_of_type_Boolean = false;
  }
  
  private void a(Context paramContext)
  {
    setWillNotDraw(false);
  }
  
  public void draw(Canvas paramCanvas)
  {
    aiux localaiux = this.jdField_a_of_type_Aiux;
    if (localaiux != null)
    {
      a();
      paramCanvas.concat(aiux.a(localaiux));
    }
    super.draw(paramCanvas);
  }
  
  public void ensureTransformationInfo()
  {
    if (this.jdField_a_of_type_Aiux == null) {
      this.jdField_a_of_type_Aiux = new aiux();
    }
  }
  
  public float getTransX()
  {
    if (this.jdField_a_of_type_Aiux != null) {
      return this.jdField_a_of_type_Aiux.jdField_a_of_type_Float;
    }
    return 0.0F;
  }
  
  public float getTransY()
  {
    if (this.jdField_a_of_type_Aiux != null) {
      return this.jdField_a_of_type_Aiux.b;
    }
    return 0.0F;
  }
  
  public void transX(float paramFloat)
  {
    ensureTransformationInfo();
    aiux localaiux = this.jdField_a_of_type_Aiux;
    if (localaiux.jdField_a_of_type_Float != paramFloat)
    {
      localaiux.jdField_a_of_type_Float = paramFloat;
      localaiux.jdField_a_of_type_Boolean = true;
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
    aiux localaiux = this.jdField_a_of_type_Aiux;
    if (localaiux.b != paramFloat)
    {
      localaiux.b = paramFloat;
      localaiux.jdField_a_of_type_Boolean = true;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.fling.ContentWrapView
 * JD-Core Version:    0.7.0.1
 */