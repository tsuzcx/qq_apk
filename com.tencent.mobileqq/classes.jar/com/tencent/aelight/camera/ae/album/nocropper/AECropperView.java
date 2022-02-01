package com.tencent.aelight.camera.ae.album.nocropper;

import android.animation.Animator.AnimatorListener;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.aelight.camera.aeeditor.module.clip.image.EditorPicInfo;

public class AECropperView
  extends FrameLayout
{
  private AECropperGridView jdField_a_of_type_ComTencentAelightCameraAeAlbumNocropperAECropperGridView;
  public AECropperImageView a;
  private AECropperView.GridCallback jdField_a_of_type_ComTencentAelightCameraAeAlbumNocropperAECropperView$GridCallback;
  private boolean jdField_a_of_type_Boolean = false;
  
  public AECropperView(Context paramContext)
  {
    super(paramContext);
    a(paramContext, null);
  }
  
  public AECropperView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet);
  }
  
  public AECropperView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet);
  }
  
  private CropResult a()
  {
    if (this.jdField_a_of_type_Boolean) {
      return CropResult.a();
    }
    CropInfo localCropInfo = this.jdField_a_of_type_ComTencentAelightCameraAeAlbumNocropperAECropperImageView.a();
    if (localCropInfo != null) {
      return CropResult.a(localCropInfo);
    }
    return CropResult.b();
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeAlbumNocropperAECropperImageView = new AECropperImageView(paramContext, paramAttributeSet);
    this.jdField_a_of_type_ComTencentAelightCameraAeAlbumNocropperAECropperGridView = new AECropperGridView(paramContext, paramAttributeSet);
    paramAttributeSet = new FrameLayout.LayoutParams(-1, 0);
    if (paramContext.getResources().getConfiguration().orientation == 2)
    {
      paramAttributeSet.width = 0;
      paramAttributeSet.height = -1;
    }
    addView(this.jdField_a_of_type_ComTencentAelightCameraAeAlbumNocropperAECropperImageView, 0, paramAttributeSet);
    addView(this.jdField_a_of_type_ComTencentAelightCameraAeAlbumNocropperAECropperGridView, 1, paramAttributeSet);
    this.jdField_a_of_type_ComTencentAelightCameraAeAlbumNocropperAECropperImageView.setGestureCallback(new AECropperView.TouchGestureCallback(this, null));
  }
  
  public float a()
  {
    AECropperImageView localAECropperImageView = this.jdField_a_of_type_ComTencentAelightCameraAeAlbumNocropperAECropperImageView;
    if (localAECropperImageView == null) {
      return 0.0F;
    }
    return localAECropperImageView.a();
  }
  
  public int a()
  {
    AECropperImageView localAECropperImageView = this.jdField_a_of_type_ComTencentAelightCameraAeAlbumNocropperAECropperImageView;
    if (localAECropperImageView == null) {
      return 1;
    }
    return localAECropperImageView.a();
  }
  
  public Matrix a()
  {
    AECropperImageView localAECropperImageView = this.jdField_a_of_type_ComTencentAelightCameraAeAlbumNocropperAECropperImageView;
    if (localAECropperImageView == null) {
      return new Matrix();
    }
    return new Matrix(localAECropperImageView.getImageMatrix());
  }
  
  @Nullable
  public EditorPicInfo a(@NonNull EditorPicInfo paramEditorPicInfo)
  {
    CropResult localCropResult = a();
    if ((localCropResult.jdField_a_of_type_ComTencentAelightCameraAeAlbumNocropperCropState == CropState.b) && (localCropResult.jdField_a_of_type_ComTencentAelightCameraAeAlbumNocropperCropInfo != null))
    {
      int i = b();
      int j = c();
      double d2 = localCropResult.jdField_a_of_type_ComTencentAelightCameraAeAlbumNocropperCropInfo.a;
      Double.isNaN(d2);
      double d1 = i;
      Double.isNaN(d1);
      paramEditorPicInfo.x = (d2 * 1.0D / d1);
      double d3 = localCropResult.jdField_a_of_type_ComTencentAelightCameraAeAlbumNocropperCropInfo.b;
      Double.isNaN(d3);
      d2 = j;
      Double.isNaN(d2);
      paramEditorPicInfo.y = (d3 * 1.0D / d2);
      d3 = localCropResult.jdField_a_of_type_ComTencentAelightCameraAeAlbumNocropperCropInfo.c;
      Double.isNaN(d3);
      Double.isNaN(d1);
      paramEditorPicInfo.w = (d3 * 1.0D / d1);
      d1 = localCropResult.jdField_a_of_type_ComTencentAelightCameraAeAlbumNocropperCropInfo.d;
      Double.isNaN(d1);
      Double.isNaN(d2);
      paramEditorPicInfo.h = (d1 * 1.0D / d2);
      return paramEditorPicInfo;
    }
    return null;
  }
  
  public void a()
  {
    AECropperImageView localAECropperImageView = this.jdField_a_of_type_ComTencentAelightCameraAeAlbumNocropperAECropperImageView;
    if (localAECropperImageView != null) {
      localAECropperImageView.a();
    }
  }
  
  public float b()
  {
    AECropperImageView localAECropperImageView = this.jdField_a_of_type_ComTencentAelightCameraAeAlbumNocropperAECropperImageView;
    if (localAECropperImageView == null) {
      return 0.0F;
    }
    return localAECropperImageView.b();
  }
  
  public int b()
  {
    AECropperImageView localAECropperImageView = this.jdField_a_of_type_ComTencentAelightCameraAeAlbumNocropperAECropperImageView;
    if (localAECropperImageView == null) {
      return 0;
    }
    return localAECropperImageView.b();
  }
  
  public int c()
  {
    AECropperImageView localAECropperImageView = this.jdField_a_of_type_ComTencentAelightCameraAeAlbumNocropperAECropperImageView;
    if (localAECropperImageView == null) {
      return 0;
    }
    return localAECropperImageView.c();
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    int i = getContext().getResources().getConfiguration().orientation;
    if ((i != 1) && (i != 0))
    {
      paramInt1 = View.MeasureSpec.getSize(paramInt2);
      setMeasuredDimension(View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824), paramInt1);
      return;
    }
    paramInt1 = View.MeasureSpec.getSize(paramInt1);
    setMeasuredDimension(paramInt1, View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824));
  }
  
  public void setAnimateCallback(Animator.AnimatorListener paramAnimatorListener)
  {
    AECropperImageView localAECropperImageView = this.jdField_a_of_type_ComTencentAelightCameraAeAlbumNocropperAECropperImageView;
    if (localAECropperImageView != null) {
      localAECropperImageView.a = paramAnimatorListener;
    }
  }
  
  public void setDebug(boolean paramBoolean)
  {
    AECropperImageView localAECropperImageView = this.jdField_a_of_type_ComTencentAelightCameraAeAlbumNocropperAECropperImageView;
    if (localAECropperImageView != null) {
      localAECropperImageView.setDEBUG(paramBoolean);
    }
  }
  
  public void setGestureEnabled(boolean paramBoolean)
  {
    AECropperImageView localAECropperImageView = this.jdField_a_of_type_ComTencentAelightCameraAeAlbumNocropperAECropperImageView;
    if (localAECropperImageView != null) {
      localAECropperImageView.setGestureEnabled(paramBoolean);
    }
  }
  
  public void setGridCallback(AECropperView.GridCallback paramGridCallback)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeAlbumNocropperAECropperView$GridCallback = paramGridCallback;
  }
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    AECropperImageView localAECropperImageView = this.jdField_a_of_type_ComTencentAelightCameraAeAlbumNocropperAECropperImageView;
    if (localAECropperImageView != null) {
      localAECropperImageView.setImageBitmap(paramBitmap);
    }
  }
  
  public void setImageMatrix(@NonNull Matrix paramMatrix)
  {
    AECropperImageView localAECropperImageView = this.jdField_a_of_type_ComTencentAelightCameraAeAlbumNocropperAECropperImageView;
    if (localAECropperImageView != null) {
      localAECropperImageView.setImageMatrix(paramMatrix);
    }
  }
  
  public void setMaxZoom(float paramFloat)
  {
    AECropperImageView localAECropperImageView = this.jdField_a_of_type_ComTencentAelightCameraAeAlbumNocropperAECropperImageView;
    if (localAECropperImageView != null) {
      localAECropperImageView.setMaxZoom(paramFloat);
    }
  }
  
  public void setMinZoom(float paramFloat)
  {
    AECropperImageView localAECropperImageView = this.jdField_a_of_type_ComTencentAelightCameraAeAlbumNocropperAECropperImageView;
    if (localAECropperImageView != null) {
      localAECropperImageView.setMinZoom(paramFloat);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.album.nocropper.AECropperView
 * JD-Core Version:    0.7.0.1
 */