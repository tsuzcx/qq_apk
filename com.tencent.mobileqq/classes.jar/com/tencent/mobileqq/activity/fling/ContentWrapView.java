package com.tencent.mobileqq.activity.fling;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

public class ContentWrapView
  extends RelativeLayout
{
  private Matrix jdField_a_of_type_AndroidGraphicsMatrix = new Matrix();
  private ContentWrapView.TransformationInfo jdField_a_of_type_ComTencentMobileqqActivityFlingContentWrapView$TransformationInfo;
  
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
    ContentWrapView.TransformationInfo localTransformationInfo = this.jdField_a_of_type_ComTencentMobileqqActivityFlingContentWrapView$TransformationInfo;
    if (localTransformationInfo == null) {}
    while (!localTransformationInfo.jdField_a_of_type_Boolean) {
      return;
    }
    ContentWrapView.TransformationInfo.a(localTransformationInfo).setTranslate(localTransformationInfo.jdField_a_of_type_Float, localTransformationInfo.b);
    localTransformationInfo.jdField_a_of_type_Boolean = false;
  }
  
  private void a(Context paramContext)
  {
    setWillNotDraw(false);
  }
  
  public void draw(Canvas paramCanvas)
  {
    ContentWrapView.TransformationInfo localTransformationInfo = this.jdField_a_of_type_ComTencentMobileqqActivityFlingContentWrapView$TransformationInfo;
    if (localTransformationInfo != null)
    {
      a();
      paramCanvas.concat(ContentWrapView.TransformationInfo.a(localTransformationInfo));
    }
    super.draw(paramCanvas);
  }
  
  public void ensureTransformationInfo()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFlingContentWrapView$TransformationInfo == null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityFlingContentWrapView$TransformationInfo = new ContentWrapView.TransformationInfo();
    }
  }
  
  public float getTransX()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFlingContentWrapView$TransformationInfo != null) {
      return this.jdField_a_of_type_ComTencentMobileqqActivityFlingContentWrapView$TransformationInfo.jdField_a_of_type_Float;
    }
    return 0.0F;
  }
  
  public float getTransY()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFlingContentWrapView$TransformationInfo != null) {
      return this.jdField_a_of_type_ComTencentMobileqqActivityFlingContentWrapView$TransformationInfo.b;
    }
    return 0.0F;
  }
  
  public void transX(float paramFloat)
  {
    ensureTransformationInfo();
    ContentWrapView.TransformationInfo localTransformationInfo = this.jdField_a_of_type_ComTencentMobileqqActivityFlingContentWrapView$TransformationInfo;
    if (localTransformationInfo.jdField_a_of_type_Float != paramFloat)
    {
      localTransformationInfo.jdField_a_of_type_Float = paramFloat;
      localTransformationInfo.jdField_a_of_type_Boolean = true;
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
    ContentWrapView.TransformationInfo localTransformationInfo = this.jdField_a_of_type_ComTencentMobileqqActivityFlingContentWrapView$TransformationInfo;
    if (localTransformationInfo.b != paramFloat)
    {
      localTransformationInfo.b = paramFloat;
      localTransformationInfo.jdField_a_of_type_Boolean = true;
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