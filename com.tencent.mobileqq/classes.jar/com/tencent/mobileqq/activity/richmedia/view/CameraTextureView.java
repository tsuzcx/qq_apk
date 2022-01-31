package com.tencent.mobileqq.activity.richmedia.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import axit;
import axjn;
import com.tencent.qphone.base.util.QLog;

@TargetApi(14)
public class CameraTextureView
  extends TextureView
  implements TextureView.SurfaceTextureListener
{
  public axit a;
  
  public CameraTextureView(Context paramContext)
  {
    this(paramContext, null);
    a();
  }
  
  public CameraTextureView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    a();
  }
  
  public CameraTextureView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    setSurfaceTextureListener(this);
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (QLog.isColorLevel()) {
      QLog.i("PEAK_CAMERA", 2, "onAttachedToWindow");
    }
  }
  
  public void onDetachedFromWindow()
  {
    try
    {
      super.onDetachedFromWindow();
      if (QLog.isColorLevel()) {
        QLog.i("PEAK_CAMERA", 2, "onDetachedFromWindow");
      }
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i("PEAK_CAMERA", 2, "onAttachedToWindow[crash]", localRuntimeException);
        }
        axjn.a(3);
      }
    }
  }
  
  public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CameraTextureView", 2, "onSurfaceTextureAvailable width " + paramInt1 + ", height " + paramInt2);
    }
    this.a.onSurfaceTextureAvailable(paramSurfaceTexture, paramInt1, paramInt2);
  }
  
  public boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CameraTextureView", 2, "onSurfaceTextureDestroyed");
    }
    this.a.onSurfaceTextureDestroyed(paramSurfaceTexture);
    return true;
  }
  
  public void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CameraTextureView", 2, "onSurfaceTextureSizeChanged width " + paramInt1 + ", height " + paramInt2);
    }
    this.a.onSurfaceTextureSizeChanged(paramSurfaceTexture, paramInt1, paramInt2);
  }
  
  public void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture)
  {
    this.a.onSurfaceTextureUpdated(paramSurfaceTexture);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.view.CameraTextureView
 * JD-Core Version:    0.7.0.1
 */