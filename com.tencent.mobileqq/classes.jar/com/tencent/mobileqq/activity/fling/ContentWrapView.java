package com.tencent.mobileqq.activity.fling;

import ajqm;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

public class ContentWrapView
  extends RelativeLayout
{
  private ajqm jdField_a_of_type_Ajqm;
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
    ajqm localajqm = this.jdField_a_of_type_Ajqm;
    if (localajqm == null) {}
    while (!localajqm.jdField_a_of_type_Boolean) {
      return;
    }
    ajqm.a(localajqm).setTranslate(localajqm.jdField_a_of_type_Float, localajqm.b);
    localajqm.jdField_a_of_type_Boolean = false;
  }
  
  private void a(Context paramContext)
  {
    setWillNotDraw(false);
  }
  
  public void draw(Canvas paramCanvas)
  {
    ajqm localajqm = this.jdField_a_of_type_Ajqm;
    if (localajqm != null)
    {
      a();
      paramCanvas.concat(ajqm.a(localajqm));
    }
    super.draw(paramCanvas);
  }
  
  public void ensureTransformationInfo()
  {
    if (this.jdField_a_of_type_Ajqm == null) {
      this.jdField_a_of_type_Ajqm = new ajqm();
    }
  }
  
  public float getTransX()
  {
    if (this.jdField_a_of_type_Ajqm != null) {
      return this.jdField_a_of_type_Ajqm.jdField_a_of_type_Float;
    }
    return 0.0F;
  }
  
  public float getTransY()
  {
    if (this.jdField_a_of_type_Ajqm != null) {
      return this.jdField_a_of_type_Ajqm.b;
    }
    return 0.0F;
  }
  
  public void transX(float paramFloat)
  {
    ensureTransformationInfo();
    ajqm localajqm = this.jdField_a_of_type_Ajqm;
    if (localajqm.jdField_a_of_type_Float != paramFloat)
    {
      localajqm.jdField_a_of_type_Float = paramFloat;
      localajqm.jdField_a_of_type_Boolean = true;
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
    ajqm localajqm = this.jdField_a_of_type_Ajqm;
    if (localajqm.b != paramFloat)
    {
      localajqm.b = paramFloat;
      localajqm.jdField_a_of_type_Boolean = true;
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