package com.tencent.mobileqq.activity.fling;

import ajoo;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

public class ContentWrapView
  extends RelativeLayout
{
  private ajoo jdField_a_of_type_Ajoo;
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
    ajoo localajoo = this.jdField_a_of_type_Ajoo;
    if (localajoo == null) {}
    while (!localajoo.jdField_a_of_type_Boolean) {
      return;
    }
    ajoo.a(localajoo).setTranslate(localajoo.jdField_a_of_type_Float, localajoo.b);
    localajoo.jdField_a_of_type_Boolean = false;
  }
  
  private void a(Context paramContext)
  {
    setWillNotDraw(false);
  }
  
  public void draw(Canvas paramCanvas)
  {
    ajoo localajoo = this.jdField_a_of_type_Ajoo;
    if (localajoo != null)
    {
      a();
      paramCanvas.concat(ajoo.a(localajoo));
    }
    super.draw(paramCanvas);
  }
  
  public void ensureTransformationInfo()
  {
    if (this.jdField_a_of_type_Ajoo == null) {
      this.jdField_a_of_type_Ajoo = new ajoo();
    }
  }
  
  public float getTransX()
  {
    if (this.jdField_a_of_type_Ajoo != null) {
      return this.jdField_a_of_type_Ajoo.jdField_a_of_type_Float;
    }
    return 0.0F;
  }
  
  public float getTransY()
  {
    if (this.jdField_a_of_type_Ajoo != null) {
      return this.jdField_a_of_type_Ajoo.b;
    }
    return 0.0F;
  }
  
  public void transX(float paramFloat)
  {
    ensureTransformationInfo();
    ajoo localajoo = this.jdField_a_of_type_Ajoo;
    if (localajoo.jdField_a_of_type_Float != paramFloat)
    {
      localajoo.jdField_a_of_type_Float = paramFloat;
      localajoo.jdField_a_of_type_Boolean = true;
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
    ajoo localajoo = this.jdField_a_of_type_Ajoo;
    if (localajoo.b != paramFloat)
    {
      localajoo.b = paramFloat;
      localajoo.jdField_a_of_type_Boolean = true;
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