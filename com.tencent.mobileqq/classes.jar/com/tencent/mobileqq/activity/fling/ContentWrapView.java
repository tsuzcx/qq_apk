package com.tencent.mobileqq.activity.fling;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

public class ContentWrapView
  extends RelativeLayout
{
  private Matrix mMatrix = new Matrix();
  private ContentWrapView.TransformationInfo mTransInfo;
  
  public ContentWrapView(Context paramContext)
  {
    super(paramContext);
    init(paramContext);
  }
  
  public ContentWrapView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ContentWrapView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext);
  }
  
  private void init(Context paramContext)
  {
    setWillNotDraw(false);
  }
  
  private void updateMatrix()
  {
    ContentWrapView.TransformationInfo localTransformationInfo = this.mTransInfo;
    if (localTransformationInfo == null) {
      return;
    }
    if (localTransformationInfo.mMatrixDirty)
    {
      ContentWrapView.TransformationInfo.access$000(localTransformationInfo).setTranslate(localTransformationInfo.mTranslationX, localTransformationInfo.mTranslationY);
      localTransformationInfo.mMatrixDirty = false;
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    ContentWrapView.TransformationInfo localTransformationInfo = this.mTransInfo;
    if (localTransformationInfo != null)
    {
      updateMatrix();
      paramCanvas.concat(ContentWrapView.TransformationInfo.access$000(localTransformationInfo));
    }
    super.draw(paramCanvas);
  }
  
  public void ensureTransformationInfo()
  {
    if (this.mTransInfo == null) {
      this.mTransInfo = new ContentWrapView.TransformationInfo();
    }
  }
  
  public float getTransX()
  {
    ContentWrapView.TransformationInfo localTransformationInfo = this.mTransInfo;
    if (localTransformationInfo != null) {
      return localTransformationInfo.mTranslationX;
    }
    return 0.0F;
  }
  
  public float getTransY()
  {
    ContentWrapView.TransformationInfo localTransformationInfo = this.mTransInfo;
    if (localTransformationInfo != null) {
      return localTransformationInfo.mTranslationY;
    }
    return 0.0F;
  }
  
  public void transX(float paramFloat)
  {
    ensureTransformationInfo();
    ContentWrapView.TransformationInfo localTransformationInfo = this.mTransInfo;
    if (localTransformationInfo.mTranslationX != paramFloat)
    {
      localTransformationInfo.mTranslationX = paramFloat;
      localTransformationInfo.mMatrixDirty = true;
      invalidate();
    }
  }
  
  public void transXBy(float paramFloat)
  {
    if (paramFloat != 0.0F) {
      transX(paramFloat + getTransX());
    }
  }
  
  public void transY(float paramFloat)
  {
    ensureTransformationInfo();
    ContentWrapView.TransformationInfo localTransformationInfo = this.mTransInfo;
    if (localTransformationInfo.mTranslationY != paramFloat)
    {
      localTransformationInfo.mTranslationY = paramFloat;
      localTransformationInfo.mMatrixDirty = true;
      invalidate();
    }
  }
  
  public void transYBy(float paramFloat)
  {
    if (paramFloat != 0.0F) {
      transX(paramFloat + getTransX());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.fling.ContentWrapView
 * JD-Core Version:    0.7.0.1
 */