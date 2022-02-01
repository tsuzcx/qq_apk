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
  public AECropperImageView a;
  private AECropperGridView b;
  private boolean c = false;
  private AECropperView.GridCallback d;
  
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
  
  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    this.a = new AECropperImageView(paramContext, paramAttributeSet);
    this.b = new AECropperGridView(paramContext, paramAttributeSet);
    paramAttributeSet = new FrameLayout.LayoutParams(-1, 0);
    if (paramContext.getResources().getConfiguration().orientation == 2)
    {
      paramAttributeSet.width = 0;
      paramAttributeSet.height = -1;
    }
    addView(this.a, 0, paramAttributeSet);
    addView(this.b, 1, paramAttributeSet);
    this.a.setGestureCallback(new AECropperView.TouchGestureCallback(this, null));
  }
  
  private CropResult getCropInfo()
  {
    if (this.c) {
      return CropResult.a();
    }
    CropInfo localCropInfo = this.a.getCropInfo();
    if (localCropInfo != null) {
      return CropResult.a(localCropInfo);
    }
    return CropResult.b();
  }
  
  @Nullable
  public EditorPicInfo a(@NonNull EditorPicInfo paramEditorPicInfo)
  {
    CropResult localCropResult = getCropInfo();
    if ((localCropResult.c == CropState.b) && (localCropResult.b != null))
    {
      int i = getImageWidth();
      int j = getImageHeight();
      double d2 = localCropResult.b.a;
      Double.isNaN(d2);
      double d1 = i;
      Double.isNaN(d1);
      paramEditorPicInfo.x = (d2 * 1.0D / d1);
      double d3 = localCropResult.b.b;
      Double.isNaN(d3);
      d2 = j;
      Double.isNaN(d2);
      paramEditorPicInfo.y = (d3 * 1.0D / d2);
      d3 = localCropResult.b.c;
      Double.isNaN(d3);
      Double.isNaN(d1);
      paramEditorPicInfo.w = (d3 * 1.0D / d1);
      d1 = localCropResult.b.d;
      Double.isNaN(d1);
      Double.isNaN(d2);
      paramEditorPicInfo.h = (d1 * 1.0D / d2);
      return paramEditorPicInfo;
    }
    return null;
  }
  
  public void a()
  {
    AECropperImageView localAECropperImageView = this.a;
    if (localAECropperImageView != null) {
      localAECropperImageView.a();
    }
  }
  
  public float getCropToCenterZoom()
  {
    AECropperImageView localAECropperImageView = this.a;
    if (localAECropperImageView == null) {
      return 0.0F;
    }
    return localAECropperImageView.getCropCenterZoom();
  }
  
  public int getImageHeight()
  {
    AECropperImageView localAECropperImageView = this.a;
    if (localAECropperImageView == null) {
      return 0;
    }
    return localAECropperImageView.getImageHeight();
  }
  
  public Matrix getImageMatrix()
  {
    AECropperImageView localAECropperImageView = this.a;
    if (localAECropperImageView == null) {
      return new Matrix();
    }
    return new Matrix(localAECropperImageView.getImageMatrix());
  }
  
  public int getImageWidth()
  {
    AECropperImageView localAECropperImageView = this.a;
    if (localAECropperImageView == null) {
      return 0;
    }
    return localAECropperImageView.getImageWidth();
  }
  
  public float getMaxZoom()
  {
    AECropperImageView localAECropperImageView = this.a;
    if (localAECropperImageView == null) {
      return 0.0F;
    }
    return localAECropperImageView.getMaxZoom();
  }
  
  public float getMinZoom()
  {
    AECropperImageView localAECropperImageView = this.a;
    if (localAECropperImageView == null) {
      return 0.0F;
    }
    return localAECropperImageView.getMinZoom();
  }
  
  public int getRatioType()
  {
    AECropperImageView localAECropperImageView = this.a;
    if (localAECropperImageView == null) {
      return 1;
    }
    return localAECropperImageView.getRatioType();
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
    AECropperImageView localAECropperImageView = this.a;
    if (localAECropperImageView != null) {
      localAECropperImageView.d = paramAnimatorListener;
    }
  }
  
  public void setDebug(boolean paramBoolean)
  {
    AECropperImageView localAECropperImageView = this.a;
    if (localAECropperImageView != null) {
      localAECropperImageView.setDEBUG(paramBoolean);
    }
  }
  
  public void setGestureEnabled(boolean paramBoolean)
  {
    AECropperImageView localAECropperImageView = this.a;
    if (localAECropperImageView != null) {
      localAECropperImageView.setGestureEnabled(paramBoolean);
    }
  }
  
  public void setGridCallback(AECropperView.GridCallback paramGridCallback)
  {
    this.d = paramGridCallback;
  }
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    AECropperImageView localAECropperImageView = this.a;
    if (localAECropperImageView != null) {
      localAECropperImageView.setImageBitmap(paramBitmap);
    }
  }
  
  public void setImageMatrix(@NonNull Matrix paramMatrix)
  {
    AECropperImageView localAECropperImageView = this.a;
    if (localAECropperImageView != null) {
      localAECropperImageView.setImageMatrix(paramMatrix);
    }
  }
  
  public void setMaxZoom(float paramFloat)
  {
    AECropperImageView localAECropperImageView = this.a;
    if (localAECropperImageView != null) {
      localAECropperImageView.setMaxZoom(paramFloat);
    }
  }
  
  public void setMinZoom(float paramFloat)
  {
    AECropperImageView localAECropperImageView = this.a;
    if (localAECropperImageView != null) {
      localAECropperImageView.setMinZoom(paramFloat);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.album.nocropper.AECropperView
 * JD-Core Version:    0.7.0.1
 */