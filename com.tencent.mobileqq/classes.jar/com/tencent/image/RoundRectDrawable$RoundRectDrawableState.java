package com.tencent.image;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Matrix;
import android.graphics.Matrix.ScaleToFit;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;

final class RoundRectDrawable$RoundRectDrawableState
  extends Drawable.ConstantState
{
  final int mBitmapHeight;
  final Paint mBitmapPaint;
  final RectF mBitmapRect = new RectF();
  final BitmapShader mBitmapShader;
  final int mBitmapWidth;
  final Paint mBorderPaint;
  final RectF mBorderRect = new RectF();
  int mChangingConfigurations;
  final RectF mDrawableRect = new RectF();
  boolean mOval = false;
  final RoundRectBitmap mRoundRectBitmap;
  final Matrix mShaderMatrix = new Matrix();
  int mTargetDensity = 160;
  
  RoundRectDrawable$RoundRectDrawableState(RoundRectBitmap paramRoundRectBitmap)
  {
    this.mRoundRectBitmap = paramRoundRectBitmap;
    this.mBitmapWidth = this.mRoundRectBitmap.mBitmap.getWidth();
    this.mBitmapHeight = this.mRoundRectBitmap.mBitmap.getHeight();
    this.mBitmapRect.set(0.0F, 0.0F, this.mBitmapWidth, this.mBitmapHeight);
    this.mBitmapShader = new BitmapShader(this.mRoundRectBitmap.mBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
    this.mBitmapShader.setLocalMatrix(this.mShaderMatrix);
    this.mBitmapPaint = new Paint();
    this.mBitmapPaint.setStyle(Paint.Style.FILL);
    this.mBitmapPaint.setAntiAlias(true);
    this.mBitmapPaint.setShader(this.mBitmapShader);
    this.mBorderPaint = new Paint();
    this.mBorderPaint.setStyle(Paint.Style.STROKE);
    this.mBorderPaint.setAntiAlias(true);
    this.mBorderPaint.setColor(this.mRoundRectBitmap.mBoardColor);
    this.mBorderPaint.setStrokeWidth(this.mRoundRectBitmap.mBorderWidth);
  }
  
  public int getChangingConfigurations()
  {
    return this.mChangingConfigurations;
  }
  
  public Drawable newDrawable()
  {
    return new RoundRectDrawable(this, null, null);
  }
  
  public Drawable newDrawable(Resources paramResources)
  {
    return new RoundRectDrawable(this, paramResources, null);
  }
  
  void updateShaderMatrix(RectF paramRectF)
  {
    this.mBorderRect.set(this.mBitmapRect);
    this.mShaderMatrix.setRectToRect(this.mBitmapRect, paramRectF, Matrix.ScaleToFit.CENTER);
    this.mShaderMatrix.mapRect(this.mBorderRect);
    this.mBorderRect.inset(this.mRoundRectBitmap.mBorderWidth / 2.0F, this.mRoundRectBitmap.mBorderWidth / 2.0F);
    this.mShaderMatrix.setRectToRect(this.mBitmapRect, this.mBorderRect, Matrix.ScaleToFit.FILL);
    this.mDrawableRect.set(this.mBorderRect);
    this.mBitmapShader.setLocalMatrix(this.mShaderMatrix);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.image.RoundRectDrawable.RoundRectDrawableState
 * JD-Core Version:    0.7.0.1
 */