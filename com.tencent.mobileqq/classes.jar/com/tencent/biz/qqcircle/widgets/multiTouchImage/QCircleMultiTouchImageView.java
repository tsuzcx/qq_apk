package com.tencent.biz.qqcircle.widgets.multiTouchImage;

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
import uhq;
import uhs;
import uht;
import uhu;
import uhv;
import uhw;
import uhx;
import uhy;

public class QCircleMultiTouchImageView
  extends URLImageView
{
  private ImageView.ScaleType jdField_a_of_type_AndroidWidgetImageView$ScaleType;
  private PhotoViewAttacher jdField_a_of_type_ComTencentBizQqcircleWidgetsMultiTouchImagePhotoViewAttacher;
  
  public QCircleMultiTouchImageView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public QCircleMultiTouchImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public QCircleMultiTouchImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    c();
  }
  
  private void c()
  {
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsMultiTouchImagePhotoViewAttacher = new PhotoViewAttacher(this);
    super.setScaleType(ImageView.ScaleType.MATRIX);
    if (this.jdField_a_of_type_AndroidWidgetImageView$ScaleType != null)
    {
      setScaleType(this.jdField_a_of_type_AndroidWidgetImageView$ScaleType);
      this.jdField_a_of_type_AndroidWidgetImageView$ScaleType = null;
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsMultiTouchImagePhotoViewAttacher != null) {
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsMultiTouchImagePhotoViewAttacher.a();
    }
  }
  
  public boolean a(float paramFloat1, float paramFloat2)
  {
    if (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsMultiTouchImagePhotoViewAttacher != null) {
      return this.jdField_a_of_type_ComTencentBizQqcircleWidgetsMultiTouchImagePhotoViewAttacher.a(paramFloat1, paramFloat2);
    }
    return true;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsMultiTouchImagePhotoViewAttacher != null) {
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsMultiTouchImagePhotoViewAttacher.b();
    }
  }
  
  public Matrix getImageMatrix()
  {
    return this.jdField_a_of_type_ComTencentBizQqcircleWidgetsMultiTouchImagePhotoViewAttacher.a();
  }
  
  public ImageView.ScaleType getScaleType()
  {
    return this.jdField_a_of_type_ComTencentBizQqcircleWidgetsMultiTouchImagePhotoViewAttacher.a();
  }
  
  public void setAllowParentInterceptOnEdge(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsMultiTouchImagePhotoViewAttacher.a(paramBoolean);
  }
  
  protected boolean setFrame(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    boolean bool = super.setFrame(paramInt1, paramInt2, paramInt3, paramInt4);
    if (bool) {
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsMultiTouchImagePhotoViewAttacher.a();
    }
    return bool;
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    super.setImageDrawable(paramDrawable);
    if (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsMultiTouchImagePhotoViewAttacher != null) {
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsMultiTouchImagePhotoViewAttacher.a();
    }
  }
  
  public void setImageResource(int paramInt)
  {
    super.setImageResource(paramInt);
    if (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsMultiTouchImagePhotoViewAttacher != null) {
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsMultiTouchImagePhotoViewAttacher.a();
    }
  }
  
  public void setImageURI(Uri paramUri)
  {
    super.setImageURI(paramUri);
    if (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsMultiTouchImagePhotoViewAttacher != null) {
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsMultiTouchImagePhotoViewAttacher.a();
    }
  }
  
  public void setMaximumScale(float paramFloat)
  {
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsMultiTouchImagePhotoViewAttacher.e(paramFloat);
  }
  
  public void setMediumScale(float paramFloat)
  {
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsMultiTouchImagePhotoViewAttacher.d(paramFloat);
  }
  
  public void setMinimumScale(float paramFloat)
  {
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsMultiTouchImagePhotoViewAttacher.c(paramFloat);
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsMultiTouchImagePhotoViewAttacher.a(paramOnClickListener);
  }
  
  public void setOnDoubleTabListener(uhq paramuhq)
  {
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsMultiTouchImagePhotoViewAttacher.a(paramuhq);
  }
  
  public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener paramOnDoubleTapListener)
  {
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsMultiTouchImagePhotoViewAttacher.a(paramOnDoubleTapListener);
  }
  
  public void setOnLongClickListener(View.OnLongClickListener paramOnLongClickListener)
  {
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsMultiTouchImagePhotoViewAttacher.a(paramOnLongClickListener);
  }
  
  public void setOnMatrixChangeListener(uhs paramuhs)
  {
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsMultiTouchImagePhotoViewAttacher.a(paramuhs);
  }
  
  public void setOnOutsidePhotoTapListener(uht paramuht)
  {
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsMultiTouchImagePhotoViewAttacher.a(paramuht);
  }
  
  public void setOnPhotoTapListener(uhu paramuhu)
  {
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsMultiTouchImagePhotoViewAttacher.a(paramuhu);
  }
  
  public void setOnScaleChangeListener(uhv paramuhv)
  {
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsMultiTouchImagePhotoViewAttacher.a(paramuhv);
  }
  
  public void setOnSingleFlingListener(uhw paramuhw)
  {
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsMultiTouchImagePhotoViewAttacher.a(paramuhw);
  }
  
  public void setOnViewDragListener(uhx paramuhx)
  {
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsMultiTouchImagePhotoViewAttacher.a(paramuhx);
  }
  
  public void setOnViewTapListener(uhy paramuhy)
  {
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsMultiTouchImagePhotoViewAttacher.a(paramuhy);
  }
  
  public void setRotationBy(float paramFloat)
  {
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsMultiTouchImagePhotoViewAttacher.b(paramFloat);
  }
  
  public void setRotationTo(float paramFloat)
  {
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsMultiTouchImagePhotoViewAttacher.a(paramFloat);
  }
  
  public void setScale(float paramFloat)
  {
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsMultiTouchImagePhotoViewAttacher.f(paramFloat);
  }
  
  public void setScale(float paramFloat1, float paramFloat2, float paramFloat3, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsMultiTouchImagePhotoViewAttacher.a(paramFloat1, paramFloat2, paramFloat3, paramBoolean);
  }
  
  public void setScale(float paramFloat, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsMultiTouchImagePhotoViewAttacher.a(paramFloat, paramBoolean);
  }
  
  public void setScaleLevels(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsMultiTouchImagePhotoViewAttacher.a(paramFloat1, paramFloat2, paramFloat3);
  }
  
  public void setScaleType(ImageView.ScaleType paramScaleType)
  {
    if (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsMultiTouchImagePhotoViewAttacher == null)
    {
      this.jdField_a_of_type_AndroidWidgetImageView$ScaleType = paramScaleType;
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsMultiTouchImagePhotoViewAttacher.a(paramScaleType);
  }
  
  public void setZoomTransitionDuration(int paramInt)
  {
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsMultiTouchImagePhotoViewAttacher.a(paramInt);
  }
  
  public void setZoomable(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsMultiTouchImagePhotoViewAttacher.b(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.multiTouchImage.QCircleMultiTouchImageView
 * JD-Core Version:    0.7.0.1
 */