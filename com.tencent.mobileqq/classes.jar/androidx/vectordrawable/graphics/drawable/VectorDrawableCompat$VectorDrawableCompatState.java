package androidx.vectordrawable.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import androidx.annotation.NonNull;

class VectorDrawableCompat$VectorDrawableCompatState
  extends Drawable.ConstantState
{
  boolean mAutoMirrored;
  boolean mCacheDirty;
  boolean mCachedAutoMirrored;
  Bitmap mCachedBitmap;
  int mCachedRootAlpha;
  int[] mCachedThemeAttrs;
  ColorStateList mCachedTint;
  PorterDuff.Mode mCachedTintMode;
  int mChangingConfigurations;
  Paint mTempPaint;
  ColorStateList mTint = null;
  PorterDuff.Mode mTintMode = VectorDrawableCompat.DEFAULT_TINT_MODE;
  VectorDrawableCompat.VPathRenderer mVPathRenderer;
  
  public VectorDrawableCompat$VectorDrawableCompatState()
  {
    this.mVPathRenderer = new VectorDrawableCompat.VPathRenderer();
  }
  
  public VectorDrawableCompat$VectorDrawableCompatState(VectorDrawableCompatState paramVectorDrawableCompatState)
  {
    if (paramVectorDrawableCompatState != null)
    {
      this.mChangingConfigurations = paramVectorDrawableCompatState.mChangingConfigurations;
      this.mVPathRenderer = new VectorDrawableCompat.VPathRenderer(paramVectorDrawableCompatState.mVPathRenderer);
      if (paramVectorDrawableCompatState.mVPathRenderer.mFillPaint != null) {
        this.mVPathRenderer.mFillPaint = new Paint(paramVectorDrawableCompatState.mVPathRenderer.mFillPaint);
      }
      if (paramVectorDrawableCompatState.mVPathRenderer.mStrokePaint != null) {
        this.mVPathRenderer.mStrokePaint = new Paint(paramVectorDrawableCompatState.mVPathRenderer.mStrokePaint);
      }
      this.mTint = paramVectorDrawableCompatState.mTint;
      this.mTintMode = paramVectorDrawableCompatState.mTintMode;
      this.mAutoMirrored = paramVectorDrawableCompatState.mAutoMirrored;
    }
  }
  
  public boolean canReuseBitmap(int paramInt1, int paramInt2)
  {
    return (paramInt1 == this.mCachedBitmap.getWidth()) && (paramInt2 == this.mCachedBitmap.getHeight());
  }
  
  public boolean canReuseCache()
  {
    return (!this.mCacheDirty) && (this.mCachedTint == this.mTint) && (this.mCachedTintMode == this.mTintMode) && (this.mCachedAutoMirrored == this.mAutoMirrored) && (this.mCachedRootAlpha == this.mVPathRenderer.getRootAlpha());
  }
  
  public void createCachedBitmapIfNeeded(int paramInt1, int paramInt2)
  {
    if ((this.mCachedBitmap == null) || (!canReuseBitmap(paramInt1, paramInt2)))
    {
      this.mCachedBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
      this.mCacheDirty = true;
    }
  }
  
  public void drawCachedBitmapWithRootAlpha(Canvas paramCanvas, ColorFilter paramColorFilter, Rect paramRect)
  {
    paramColorFilter = getPaint(paramColorFilter);
    paramCanvas.drawBitmap(this.mCachedBitmap, null, paramRect, paramColorFilter);
  }
  
  public int getChangingConfigurations()
  {
    return this.mChangingConfigurations;
  }
  
  public Paint getPaint(ColorFilter paramColorFilter)
  {
    if ((!hasTranslucentRoot()) && (paramColorFilter == null)) {
      return null;
    }
    if (this.mTempPaint == null)
    {
      this.mTempPaint = new Paint();
      this.mTempPaint.setFilterBitmap(true);
    }
    this.mTempPaint.setAlpha(this.mVPathRenderer.getRootAlpha());
    this.mTempPaint.setColorFilter(paramColorFilter);
    return this.mTempPaint;
  }
  
  public boolean hasTranslucentRoot()
  {
    return this.mVPathRenderer.getRootAlpha() < 255;
  }
  
  public boolean isStateful()
  {
    return this.mVPathRenderer.isStateful();
  }
  
  @NonNull
  public Drawable newDrawable()
  {
    return new VectorDrawableCompat(this);
  }
  
  @NonNull
  public Drawable newDrawable(Resources paramResources)
  {
    return new VectorDrawableCompat(this);
  }
  
  public boolean onStateChanged(int[] paramArrayOfInt)
  {
    boolean bool = this.mVPathRenderer.onStateChanged(paramArrayOfInt);
    this.mCacheDirty |= bool;
    return bool;
  }
  
  public void updateCacheStates()
  {
    this.mCachedTint = this.mTint;
    this.mCachedTintMode = this.mTintMode;
    this.mCachedRootAlpha = this.mVPathRenderer.getRootAlpha();
    this.mCachedAutoMirrored = this.mAutoMirrored;
    this.mCacheDirty = false;
  }
  
  public void updateCachedBitmap(int paramInt1, int paramInt2)
  {
    this.mCachedBitmap.eraseColor(0);
    Canvas localCanvas = new Canvas(this.mCachedBitmap);
    this.mVPathRenderer.draw(localCanvas, paramInt1, paramInt2, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.VectorDrawableCompatState
 * JD-Core Version:    0.7.0.1
 */