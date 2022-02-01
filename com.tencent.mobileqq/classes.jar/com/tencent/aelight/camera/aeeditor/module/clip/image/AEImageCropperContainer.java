package com.tencent.aelight.camera.aeeditor.module.clip.image;

import android.animation.Animator.AnimatorListener;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.aelight.camera.ae.album.nocropper.CropResult;
import com.tencent.aelight.camera.ae.album.nocropper.CropState;
import com.tencent.aelight.camera.aeeditor.data.AEEditorImageInfo;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.tavcut.bean.CropConfig;

public class AEImageCropperContainer
  extends FrameLayout
{
  public static final int a;
  private AEImageCropperContainer.GridCallback jdField_a_of_type_ComTencentAelightCameraAeeditorModuleClipImageAEImageCropperContainer$GridCallback;
  public AEImageCropperMask a;
  public AEImageCropperView a;
  private boolean jdField_a_of_type_Boolean = false;
  
  static
  {
    jdField_a_of_type_Int = ViewUtils.b(12.0F);
  }
  
  public AEImageCropperContainer(Context paramContext)
  {
    super(paramContext);
    a(paramContext, null);
  }
  
  public AEImageCropperContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet);
  }
  
  public AEImageCropperContainer(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet);
  }
  
  private CropResult a()
  {
    if (this.jdField_a_of_type_Boolean) {
      return CropResult.a();
    }
    CropConfig localCropConfig = this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleClipImageAEImageCropperMask.a();
    if (localCropConfig != null) {
      return CropResult.a(localCropConfig);
    }
    return CropResult.b();
  }
  
  public static String a(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3)
          {
            if (paramInt != 4) {
              return "default";
            }
            return "16to9";
          }
          return "4to3";
        }
        return "3to4";
      }
      return "1to1";
    }
    return "default";
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleClipImageAEImageCropperView = new AEImageCropperView(paramContext, paramAttributeSet);
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleClipImageAEImageCropperView.setMaxZoom(5.0F);
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleClipImageAEImageCropperView.setGestureEnabled(false);
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleClipImageAEImageCropperMask = new AEImageCropperMask(paramContext, paramAttributeSet);
    paramContext = new FrameLayout.LayoutParams(-1, -1);
    int i = jdField_a_of_type_Int;
    paramContext.setMargins(i, i, i, i);
    addView(this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleClipImageAEImageCropperView, 0, paramContext);
    paramContext = new FrameLayout.LayoutParams(-1, -1);
    addView(this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleClipImageAEImageCropperMask, 1, paramContext);
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleClipImageAEImageCropperView.setGestureCallback(new AEImageCropperContainer.TouchGestureCallback(this, null));
  }
  
  public Matrix a()
  {
    AEImageCropperView localAEImageCropperView = this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleClipImageAEImageCropperView;
    if (localAEImageCropperView == null) {
      return new Matrix();
    }
    return new Matrix(localAEImageCropperView.getImageMatrix());
  }
  
  public AEImageCropperView a()
  {
    return this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleClipImageAEImageCropperView;
  }
  
  @Nullable
  public CropConfig a()
  {
    CropResult localCropResult = a();
    if ((localCropResult.jdField_a_of_type_ComTencentAelightCameraAeAlbumNocropperCropState == CropState.b) && (localCropResult.jdField_a_of_type_ComTencentTavcutBeanCropConfig != null)) {
      return localCropResult.jdField_a_of_type_ComTencentTavcutBeanCropConfig;
    }
    return null;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleClipImageAEImageCropperView.b();
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleClipImageAEImageCropperView.setVisibility(8);
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleClipImageAEImageCropperMask.setVisibility(8);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public void setAnimateCallback(Animator.AnimatorListener paramAnimatorListener)
  {
    AEImageCropperView localAEImageCropperView = this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleClipImageAEImageCropperView;
    if (localAEImageCropperView != null) {
      localAEImageCropperView.a = paramAnimatorListener;
    }
  }
  
  public void setDebug(boolean paramBoolean)
  {
    AEImageCropperView localAEImageCropperView = this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleClipImageAEImageCropperView;
    if (localAEImageCropperView != null) {
      localAEImageCropperView.setDEBUG(paramBoolean);
    }
  }
  
  public void setGestureEnabled(boolean paramBoolean)
  {
    AEImageCropperView localAEImageCropperView = this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleClipImageAEImageCropperView;
    if (localAEImageCropperView != null) {
      localAEImageCropperView.setGestureEnabled(paramBoolean);
    }
  }
  
  public void setGridCallback(AEImageCropperContainer.GridCallback paramGridCallback)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleClipImageAEImageCropperContainer$GridCallback = paramGridCallback;
  }
  
  public void setImageBitmap(Bitmap paramBitmap, AEEditorImageInfo paramAEEditorImageInfo, int paramInt1, int paramInt2)
  {
    AEImageCropperView localAEImageCropperView = this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleClipImageAEImageCropperView;
    if (localAEImageCropperView != null)
    {
      int i = jdField_a_of_type_Int;
      localAEImageCropperView.a(paramAEEditorImageInfo, paramInt1 - i * 2, paramInt2 - i * 2, paramBitmap);
      this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleClipImageAEImageCropperMask.a(this, paramAEEditorImageInfo.a(), paramBitmap, paramAEEditorImageInfo.jdField_a_of_type_ComTencentTavcutBeanCropConfig, paramInt1, paramInt2);
      this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleClipImageAEImageCropperView.setVisibility(0);
      this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleClipImageAEImageCropperMask.setVisibility(0);
    }
  }
  
  public void setImageMatrix(@NonNull Matrix paramMatrix)
  {
    AEImageCropperView localAEImageCropperView = this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleClipImageAEImageCropperView;
    if (localAEImageCropperView != null) {
      localAEImageCropperView.setImageMatrix(paramMatrix);
    }
  }
  
  public void setMaxZoom(float paramFloat)
  {
    AEImageCropperView localAEImageCropperView = this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleClipImageAEImageCropperView;
    if (localAEImageCropperView != null) {
      localAEImageCropperView.setMaxZoom(paramFloat);
    }
  }
  
  public void setMinZoom(float paramFloat)
  {
    AEImageCropperView localAEImageCropperView = this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleClipImageAEImageCropperView;
    if (localAEImageCropperView != null) {
      localAEImageCropperView.setMinZoom(paramFloat);
    }
  }
  
  public void setRatioType(int paramInt)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleClipImageAEImageCropperMask.a(paramInt, this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleClipImageAEImageCropperView.a(), this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleClipImageAEImageCropperView.b());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.clip.image.AEImageCropperContainer
 * JD-Core Version:    0.7.0.1
 */