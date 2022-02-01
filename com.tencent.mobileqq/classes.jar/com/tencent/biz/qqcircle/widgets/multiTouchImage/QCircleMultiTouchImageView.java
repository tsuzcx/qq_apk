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
import wba;
import wbc;
import wbd;
import wbe;
import wbf;
import wbg;
import wbh;
import wbi;
import wbj;
import wbk;

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
  
  public void setOnDoubleTabListener(wba paramwba)
  {
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsMultiTouchImagePhotoViewAttacher.a(paramwba);
  }
  
  public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener paramOnDoubleTapListener)
  {
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsMultiTouchImagePhotoViewAttacher.a(paramOnDoubleTapListener);
  }
  
  public void setOnLongClickListener(View.OnLongClickListener paramOnLongClickListener)
  {
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsMultiTouchImagePhotoViewAttacher.a(paramOnLongClickListener);
  }
  
  public void setOnMatrixChangeListener(wbc paramwbc)
  {
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsMultiTouchImagePhotoViewAttacher.a(paramwbc);
  }
  
  public void setOnOutsidePhotoTapListener(wbd paramwbd)
  {
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsMultiTouchImagePhotoViewAttacher.a(paramwbd);
  }
  
  public void setOnPhotoTapListener(wbe paramwbe)
  {
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsMultiTouchImagePhotoViewAttacher.a(paramwbe);
  }
  
  public void setOnScaleBeginListener(wbf paramwbf)
  {
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsMultiTouchImagePhotoViewAttacher.a(paramwbf);
  }
  
  public void setOnScaleChangeListener(wbg paramwbg)
  {
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsMultiTouchImagePhotoViewAttacher.a(paramwbg);
  }
  
  public void setOnScaleEndListener(wbh paramwbh)
  {
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsMultiTouchImagePhotoViewAttacher.a(paramwbh);
  }
  
  public void setOnSingleFlingListener(wbi paramwbi)
  {
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsMultiTouchImagePhotoViewAttacher.a(paramwbi);
  }
  
  public void setOnViewDragListener(wbj paramwbj)
  {
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsMultiTouchImagePhotoViewAttacher.a(paramwbj);
  }
  
  public void setOnViewTapListener(wbk paramwbk)
  {
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsMultiTouchImagePhotoViewAttacher.a(paramwbk);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.multiTouchImage.QCircleMultiTouchImageView
 * JD-Core Version:    0.7.0.1
 */