package com.tencent.component.media.image.region;

import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import com.tencent.component.media.image.BitmapReference;

final class RegionDrawable$RegionState
  extends Drawable.ConstantState
{
  boolean mAutoMirrored;
  BitmapReference mBitmap;
  int mChangingConfigurations;
  int mGravity = 119;
  Paint mPaint = new Paint(6);
  String mPath;
  boolean mRebuildShader;
  int mTargetDensity = 160;
  Shader.TileMode mTileModeX = null;
  Shader.TileMode mTileModeY = null;
  
  RegionDrawable$RegionState(BitmapReference paramBitmapReference)
  {
    this.mBitmap = paramBitmapReference;
  }
  
  RegionDrawable$RegionState(RegionState paramRegionState)
  {
    this(paramRegionState.mBitmap);
    this.mChangingConfigurations = paramRegionState.mChangingConfigurations;
    this.mGravity = paramRegionState.mGravity;
    this.mTileModeX = paramRegionState.mTileModeX;
    this.mTileModeY = paramRegionState.mTileModeY;
    this.mTargetDensity = paramRegionState.mTargetDensity;
    this.mPaint = new Paint(paramRegionState.mPaint);
    this.mRebuildShader = paramRegionState.mRebuildShader;
    this.mAutoMirrored = paramRegionState.mAutoMirrored;
  }
  
  public int getChangingConfigurations()
  {
    return this.mChangingConfigurations;
  }
  
  public Drawable newDrawable()
  {
    return new RegionDrawable(this, null, this.mPath, null);
  }
  
  public Drawable newDrawable(Resources paramResources)
  {
    return new RegionDrawable(this, paramResources, this.mPath, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.component.media.image.region.RegionDrawable.RegionState
 * JD-Core Version:    0.7.0.1
 */