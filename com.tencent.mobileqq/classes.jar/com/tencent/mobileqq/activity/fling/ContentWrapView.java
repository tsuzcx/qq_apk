package com.tencent.mobileqq.activity.fling;

import ajzx;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

public class ContentWrapView
  extends RelativeLayout
{
  private ajzx jdField_a_of_type_Ajzx;
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
    ajzx localajzx = this.jdField_a_of_type_Ajzx;
    if (localajzx == null) {}
    while (!localajzx.jdField_a_of_type_Boolean) {
      return;
    }
    ajzx.a(localajzx).setTranslate(localajzx.jdField_a_of_type_Float, localajzx.b);
    localajzx.jdField_a_of_type_Boolean = false;
  }
  
  private void a(Context paramContext)
  {
    setWillNotDraw(false);
  }
  
  public void draw(Canvas paramCanvas)
  {
    ajzx localajzx = this.jdField_a_of_type_Ajzx;
    if (localajzx != null)
    {
      a();
      paramCanvas.concat(ajzx.a(localajzx));
    }
    super.draw(paramCanvas);
  }
  
  public void ensureTransformationInfo()
  {
    if (this.jdField_a_of_type_Ajzx == null) {
      this.jdField_a_of_type_Ajzx = new ajzx();
    }
  }
  
  public float getTransX()
  {
    if (this.jdField_a_of_type_Ajzx != null) {
      return this.jdField_a_of_type_Ajzx.jdField_a_of_type_Float;
    }
    return 0.0F;
  }
  
  public float getTransY()
  {
    if (this.jdField_a_of_type_Ajzx != null) {
      return this.jdField_a_of_type_Ajzx.b;
    }
    return 0.0F;
  }
  
  public void transX(float paramFloat)
  {
    ensureTransformationInfo();
    ajzx localajzx = this.jdField_a_of_type_Ajzx;
    if (localajzx.jdField_a_of_type_Float != paramFloat)
    {
      localajzx.jdField_a_of_type_Float = paramFloat;
      localajzx.jdField_a_of_type_Boolean = true;
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
    ajzx localajzx = this.jdField_a_of_type_Ajzx;
    if (localajzx.b != paramFloat)
    {
      localajzx.b = paramFloat;
      localajzx.jdField_a_of_type_Boolean = true;
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