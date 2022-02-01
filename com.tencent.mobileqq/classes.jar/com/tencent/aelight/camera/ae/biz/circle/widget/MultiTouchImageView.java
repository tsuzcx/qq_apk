package com.tencent.aelight.camera.ae.biz.circle.widget;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.ImageView.ScaleType;
import com.tencent.image.URLImageView;

public class MultiTouchImageView
  extends URLImageView
{
  private ImageView.ScaleType jdField_a_of_type_AndroidWidgetImageView$ScaleType;
  private PhotoViewAttacher jdField_a_of_type_ComTencentAelightCameraAeBizCircleWidgetPhotoViewAttacher;
  
  public MultiTouchImageView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public MultiTouchImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public MultiTouchImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleWidgetPhotoViewAttacher = new PhotoViewAttacher(this);
    super.setScaleType(ImageView.ScaleType.MATRIX);
    ImageView.ScaleType localScaleType = this.jdField_a_of_type_AndroidWidgetImageView$ScaleType;
    if (localScaleType != null)
    {
      setScaleType(localScaleType);
      this.jdField_a_of_type_AndroidWidgetImageView$ScaleType = null;
    }
  }
  
  public Matrix getImageMatrix()
  {
    return this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleWidgetPhotoViewAttacher.a();
  }
  
  public ImageView.ScaleType getScaleType()
  {
    return this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleWidgetPhotoViewAttacher.a();
  }
  
  public void setAllowParentInterceptOnEdge(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleWidgetPhotoViewAttacher.a(paramBoolean);
  }
  
  protected boolean setFrame(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    boolean bool = super.setFrame(paramInt1, paramInt2, paramInt3, paramInt4);
    if (bool) {
      this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleWidgetPhotoViewAttacher.a();
    }
    return bool;
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    super.setImageDrawable(paramDrawable);
    paramDrawable = this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleWidgetPhotoViewAttacher;
    if (paramDrawable != null) {
      paramDrawable.a();
    }
  }
  
  public void setImageResource(int paramInt)
  {
    super.setImageResource(paramInt);
    PhotoViewAttacher localPhotoViewAttacher = this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleWidgetPhotoViewAttacher;
    if (localPhotoViewAttacher != null) {
      localPhotoViewAttacher.a();
    }
  }
  
  public void setImageURI(Uri paramUri)
  {
    super.setImageURI(paramUri);
    paramUri = this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleWidgetPhotoViewAttacher;
    if (paramUri != null) {
      paramUri.a();
    }
  }
  
  public void setMaximumScale(float paramFloat)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleWidgetPhotoViewAttacher.e(paramFloat);
  }
  
  public void setMediumScale(float paramFloat)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleWidgetPhotoViewAttacher.d(paramFloat);
  }
  
  public void setMinimumScale(float paramFloat)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleWidgetPhotoViewAttacher.c(paramFloat);
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleWidgetPhotoViewAttacher.a(paramOnClickListener);
  }
  
  public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener paramOnDoubleTapListener)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleWidgetPhotoViewAttacher.a(paramOnDoubleTapListener);
  }
  
  public void setOnLongClickListener(View.OnLongClickListener paramOnLongClickListener)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleWidgetPhotoViewAttacher.a(paramOnLongClickListener);
  }
  
  public void setRotationBy(float paramFloat)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleWidgetPhotoViewAttacher.b(paramFloat);
  }
  
  public void setRotationTo(float paramFloat)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleWidgetPhotoViewAttacher.a(paramFloat);
  }
  
  public void setScale(float paramFloat)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleWidgetPhotoViewAttacher.f(paramFloat);
  }
  
  public void setScale(float paramFloat1, float paramFloat2, float paramFloat3, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleWidgetPhotoViewAttacher.a(paramFloat1, paramFloat2, paramFloat3, paramBoolean);
  }
  
  public void setScale(float paramFloat, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleWidgetPhotoViewAttacher.a(paramFloat, paramBoolean);
  }
  
  public void setScaleLevels(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleWidgetPhotoViewAttacher.a(paramFloat1, paramFloat2, paramFloat3);
  }
  
  public void setScaleType(ImageView.ScaleType paramScaleType)
  {
    PhotoViewAttacher localPhotoViewAttacher = this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleWidgetPhotoViewAttacher;
    if (localPhotoViewAttacher == null)
    {
      this.jdField_a_of_type_AndroidWidgetImageView$ScaleType = paramScaleType;
      return;
    }
    localPhotoViewAttacher.a(paramScaleType);
  }
  
  public void setZoomTransitionDuration(int paramInt)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleWidgetPhotoViewAttacher.a(paramInt);
  }
  
  public void setZoomable(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleWidgetPhotoViewAttacher.b(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.biz.circle.widget.MultiTouchImageView
 * JD-Core Version:    0.7.0.1
 */