package com.tencent.aelight.camera.aeeditor.module.clip.image;

import android.animation.Animator.AnimatorListener;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.aelight.camera.ae.album.nocropper.CropResult;
import com.tencent.aelight.camera.ae.album.nocropper.CropState;
import com.tencent.aelight.camera.aeeditor.data.AEEditorImageInfo;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qcircle.tavcut.bean.CropConfig;

public class AEEditorClipContainer
  extends FrameLayout
{
  public static final int a = ViewUtils.dpToPx(12.0F);
  private static final String d = "AEEditorClipContainer";
  public AEEditorClipImageView b;
  public AEEditorClipMaskView c;
  private boolean e = false;
  private AEEditorClipContainer.GridCallback f;
  
  public AEEditorClipContainer(Context paramContext)
  {
    super(paramContext);
    a(paramContext, null);
  }
  
  public AEEditorClipContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet);
  }
  
  public AEEditorClipContainer(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet);
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
    this.b = new AEEditorClipImageView(paramContext, paramAttributeSet, this);
    this.b.setMaxZoom(5.0F);
    this.b.setGestureEnabled(true);
    this.c = new AEEditorClipMaskView(paramContext, paramAttributeSet);
    paramContext = new FrameLayout.LayoutParams(-1, -1);
    int i = a;
    paramContext.setMargins(i, i, i, i);
    addView(this.b, 0, paramContext);
    paramContext = new FrameLayout.LayoutParams(-1, -1);
    addView(this.c, 1, paramContext);
    this.b.setGestureCallback(new AEEditorClipContainer.TouchGestureCallback(this, null));
  }
  
  private CropResult getCropInfo()
  {
    if (this.e) {
      return CropResult.a();
    }
    Object localObject = this.b.getImageBounds();
    Rect localRect = this.c.getCropRect();
    if ((localObject != null) && (localRect != null)) {
      localObject = new CropConfig((localRect.left - ((Rect)localObject).left) / (((Rect)localObject).right - ((Rect)localObject).left), (localRect.top - ((Rect)localObject).top) / (((Rect)localObject).bottom - ((Rect)localObject).top), (localRect.right - localRect.left) / (((Rect)localObject).right - ((Rect)localObject).left), (localRect.bottom - localRect.top) / (((Rect)localObject).bottom - ((Rect)localObject).top));
    } else {
      localObject = new CropConfig(0.0F, 0.0F, 1.0F, 1.0F);
    }
    return CropResult.a((CropConfig)localObject);
  }
  
  public void a()
  {
    this.b.c();
    this.b.setVisibility(8);
    this.c.setVisibility(8);
  }
  
  public float getCropToCenterZoom()
  {
    AEEditorClipImageView localAEEditorClipImageView = this.b;
    if (localAEEditorClipImageView == null) {
      return 0.0F;
    }
    return localAEEditorClipImageView.getCropCenterZoom();
  }
  
  @Nullable
  public CropConfig getEditorPicInfo()
  {
    CropResult localCropResult = getCropInfo();
    if ((localCropResult.c == CropState.b) && (localCropResult.a != null)) {
      return localCropResult.a;
    }
    return null;
  }
  
  public int getImageHeight()
  {
    AEEditorClipImageView localAEEditorClipImageView = this.b;
    if (localAEEditorClipImageView == null) {
      return 0;
    }
    return localAEEditorClipImageView.getImageHeight();
  }
  
  public Matrix getImageMatrix()
  {
    AEEditorClipImageView localAEEditorClipImageView = this.b;
    if (localAEEditorClipImageView == null) {
      return new Matrix();
    }
    return new Matrix(localAEEditorClipImageView.getImageMatrix());
  }
  
  public AEEditorClipImageView getImageView()
  {
    return this.b;
  }
  
  public int getImageWidth()
  {
    AEEditorClipImageView localAEEditorClipImageView = this.b;
    if (localAEEditorClipImageView == null) {
      return 0;
    }
    return localAEEditorClipImageView.getImageWidth();
  }
  
  public AEEditorClipMaskView getMaskView()
  {
    return this.c;
  }
  
  public float getMaxZoom()
  {
    AEEditorClipImageView localAEEditorClipImageView = this.b;
    if (localAEEditorClipImageView == null) {
      return 0.0F;
    }
    return localAEEditorClipImageView.getMaxZoom();
  }
  
  public float getMinZoom()
  {
    AEEditorClipImageView localAEEditorClipImageView = this.b;
    if (localAEEditorClipImageView == null) {
      return 0.0F;
    }
    return localAEEditorClipImageView.getMinZoom();
  }
  
  public int getRatioType()
  {
    AEEditorClipMaskView localAEEditorClipMaskView = this.c;
    if (localAEEditorClipMaskView == null) {
      return 0;
    }
    return localAEEditorClipMaskView.getRatioType();
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public void setAnimateCallback(Animator.AnimatorListener paramAnimatorListener)
  {
    AEEditorClipImageView localAEEditorClipImageView = this.b;
    if (localAEEditorClipImageView != null) {
      localAEEditorClipImageView.d = paramAnimatorListener;
    }
  }
  
  public void setDebug(boolean paramBoolean)
  {
    AEEditorClipImageView localAEEditorClipImageView = this.b;
    if (localAEEditorClipImageView != null) {
      localAEEditorClipImageView.setDEBUG(paramBoolean);
    }
  }
  
  public void setGestureEnabled(boolean paramBoolean)
  {
    AEEditorClipImageView localAEEditorClipImageView = this.b;
    if (localAEEditorClipImageView != null) {
      localAEEditorClipImageView.setGestureEnabled(paramBoolean);
    }
  }
  
  public void setGridCallback(AEEditorClipContainer.GridCallback paramGridCallback)
  {
    this.f = paramGridCallback;
  }
  
  public void setImageBitmap(Bitmap paramBitmap, AEEditorImageInfo paramAEEditorImageInfo, int paramInt1, int paramInt2)
  {
    AEEditorClipImageView localAEEditorClipImageView = this.b;
    if (localAEEditorClipImageView != null)
    {
      int i = a;
      localAEEditorClipImageView.a(paramAEEditorImageInfo, paramInt1 - i * 2, paramInt2 - i * 2, paramBitmap);
      this.c.a(this, paramAEEditorImageInfo.b(), paramInt1, paramInt2);
      this.b.setVisibility(0);
      this.c.setVisibility(0);
    }
  }
  
  public void setImageMatrix(@NonNull Matrix paramMatrix)
  {
    AEEditorClipImageView localAEEditorClipImageView = this.b;
    if (localAEEditorClipImageView != null) {
      localAEEditorClipImageView.setImageMatrix(paramMatrix);
    }
  }
  
  public void setMaxZoom(float paramFloat)
  {
    AEEditorClipImageView localAEEditorClipImageView = this.b;
    if (localAEEditorClipImageView != null) {
      localAEEditorClipImageView.setMaxZoom(paramFloat);
    }
  }
  
  public void setMinZoom(float paramFloat)
  {
    AEEditorClipImageView localAEEditorClipImageView = this.b;
    if (localAEEditorClipImageView != null) {
      localAEEditorClipImageView.setMinZoom(paramFloat);
    }
  }
  
  public void setRatioType(int paramInt)
  {
    this.c.a(paramInt);
    this.b.a(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.clip.image.AEEditorClipContainer
 * JD-Core Version:    0.7.0.1
 */