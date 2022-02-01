package com.tencent.luggage.wxa.fy;

import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.view.TextureView.SurfaceTextureListener;
import androidx.annotation.Nullable;

public abstract interface h
{
  public abstract Bitmap getBitmap();
  
  @Nullable
  public abstract SurfaceTexture getSurfaceTexture();
  
  public abstract void setImageBitmap(Bitmap paramBitmap);
  
  public abstract void setSurfaceTextureListener(TextureView.SurfaceTextureListener paramSurfaceTextureListener);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fy.h
 * JD-Core Version:    0.7.0.1
 */