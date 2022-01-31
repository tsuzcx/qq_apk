package com.tencent.image;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader.TileMode;
import android.graphics.Xfermode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Gravity;
import org.xmlpull.v1.XmlPullParser;

public class RegionDrawable
  extends Drawable
  implements RegionBitmap.OnUpdateCallback
{
  private static final int CACHED_RECT_SCALE = 5;
  private static final int DEFAULT_PAINT_FLAGS = 6;
  public static final String TAG = "RegionDrawable";
  private boolean mApplyGravity;
  private Bitmap mBitmap;
  private int mBitmapHeight;
  private int mBitmapWidth;
  private final Rect mDstRect = new Rect();
  private Handler mMainHandler = new RegionDrawable.1(this, Looper.getMainLooper());
  private boolean mMutated;
  private RegionBitmap mRegionBitmap;
  private int mRegionDrawableState;
  private RegionDrawable.RegionState mRegionState;
  private int mScrollDirection;
  private boolean mShowRegion;
  private int mTargetDensity;
  private Rect mUpdateRect = new Rect();
  
  @Deprecated
  public RegionDrawable()
  {
    this.mRegionState = new RegionDrawable.RegionState((Bitmap)null);
  }
  
  @Deprecated
  public RegionDrawable(Resources paramResources)
  {
    this.mRegionState = new RegionDrawable.RegionState((Bitmap)null);
    this.mRegionState.mTargetDensity = this.mTargetDensity;
  }
  
  public RegionDrawable(Resources paramResources, Bitmap paramBitmap, String paramString)
  {
    this(new RegionDrawable.RegionState(paramBitmap), paramResources, paramString);
    this.mRegionState.mTargetDensity = this.mTargetDensity;
  }
  
  @Deprecated
  public RegionDrawable(Bitmap paramBitmap)
  {
    this(new RegionDrawable.RegionState(paramBitmap), null, null);
  }
  
  private RegionDrawable(RegionDrawable.RegionState paramRegionState, Resources paramResources, String paramString)
  {
    this.mRegionState = paramRegionState;
    if (paramString != paramRegionState.mPath) {
      paramRegionState.mPath = paramString;
    }
    if (paramResources != null)
    {
      this.mTargetDensity = paramResources.getDisplayMetrics().densityDpi;
      if (paramRegionState == null) {
        break label119;
      }
    }
    label119:
    for (paramRegionState = paramRegionState.mBitmap;; paramRegionState = null)
    {
      setBitmap(paramRegionState);
      paramRegionState = new RegionBitmap(paramString);
      paramRegionState.setOnUpdateCallback(this);
      this.mRegionBitmap = paramRegionState;
      return;
      this.mTargetDensity = paramRegionState.mTargetDensity;
      break;
    }
  }
  
  private Rect calcCachedArea(Rect paramRect1, Rect paramRect2)
  {
    paramRect1 = new Rect(paramRect1);
    paramRect1.intersect(paramRect2);
    return paramRect1;
  }
  
  private void computeBitmapSize()
  {
    this.mBitmapWidth = this.mBitmap.getScaledWidth(this.mTargetDensity);
    this.mBitmapHeight = this.mBitmap.getScaledHeight(this.mTargetDensity);
  }
  
  private void setBitmap(Bitmap paramBitmap)
  {
    if (paramBitmap != this.mBitmap)
    {
      this.mBitmap = paramBitmap;
      if (paramBitmap == null) {
        break label26;
      }
      computeBitmapSize();
    }
    for (;;)
    {
      invalidateSelf();
      return;
      label26:
      this.mBitmapHeight = -1;
      this.mBitmapWidth = -1;
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    Bitmap localBitmap = this.mBitmap;
    RegionDrawable.RegionState localRegionState;
    Object localObject2;
    Shader.TileMode localTileMode;
    if (localBitmap != null)
    {
      localRegionState = this.mRegionState;
      if (localRegionState.mRebuildShader)
      {
        localObject2 = localRegionState.mTileModeX;
        localTileMode = localRegionState.mTileModeY;
        if ((localObject2 != null) || (localTileMode != null)) {
          break label162;
        }
        localRegionState.mPaint.setShader(null);
        localRegionState.mRebuildShader = false;
        copyBounds(this.mDstRect);
      }
      if (localRegionState.mPaint.getShader() != null) {
        break label211;
      }
      if (this.mApplyGravity)
      {
        Gravity.apply(localRegionState.mGravity, this.mBitmapWidth, this.mBitmapHeight, getBounds(), this.mDstRect);
        this.mApplyGravity = false;
      }
      paramCanvas.drawBitmap(localBitmap, null, this.mDstRect, localRegionState.mPaint);
    }
    for (;;)
    {
      if ((this.mShowRegion) && (this.mRegionBitmap != null)) {
        this.mRegionBitmap.draw(paramCanvas, localRegionState.mPaint);
      }
      return;
      label162:
      Paint localPaint = localRegionState.mPaint;
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = Shader.TileMode.CLAMP;
      }
      localObject2 = localTileMode;
      if (localTileMode == null) {
        localObject2 = Shader.TileMode.CLAMP;
      }
      localPaint.setShader(new BitmapShader(localBitmap, (Shader.TileMode)localObject1, (Shader.TileMode)localObject2));
      break;
      label211:
      if (this.mApplyGravity)
      {
        copyBounds(this.mDstRect);
        this.mApplyGravity = false;
      }
      paramCanvas.drawRect(this.mDstRect, localRegionState.mPaint);
    }
  }
  
  public int getAlpha()
  {
    return this.mRegionState.mPaint.getAlpha();
  }
  
  public final Bitmap getBitmap()
  {
    return this.mBitmap;
  }
  
  public int getChangingConfigurations()
  {
    return super.getChangingConfigurations() | this.mRegionState.mChangingConfigurations;
  }
  
  public final Drawable.ConstantState getConstantState()
  {
    this.mRegionState.mChangingConfigurations = getChangingConfigurations();
    return this.mRegionState;
  }
  
  public int getGravity()
  {
    return this.mRegionState.mGravity;
  }
  
  public int getIntrinsicHeight()
  {
    return this.mBitmapHeight;
  }
  
  public int getIntrinsicWidth()
  {
    return this.mBitmapWidth;
  }
  
  public int getOpacity()
  {
    if (this.mRegionState.mGravity != 119) {}
    Bitmap localBitmap;
    do
    {
      return -3;
      localBitmap = this.mBitmap;
    } while ((localBitmap == null) || (localBitmap.hasAlpha()) || (this.mRegionState.mPaint.getAlpha() < 255));
    return -1;
  }
  
  public final Paint getPaint()
  {
    return this.mRegionState.mPaint;
  }
  
  public Shader.TileMode getTileModeX()
  {
    return this.mRegionState.mTileModeX;
  }
  
  public Shader.TileMode getTileModeY()
  {
    return this.mRegionState.mTileModeY;
  }
  
  public boolean hasAntiAlias()
  {
    return this.mRegionState.mPaint.isAntiAlias();
  }
  
  public void inflate(Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet) {}
  
  public final boolean isAutoMirrored()
  {
    return this.mRegionState.mAutoMirrored;
  }
  
  public Drawable mutate()
  {
    if ((!this.mMutated) && (super.mutate() == this))
    {
      this.mRegionState = new RegionDrawable.RegionState(this.mRegionState);
      this.mMutated = true;
    }
    return this;
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    super.onBoundsChange(paramRect);
    this.mApplyGravity = true;
  }
  
  public void regionRefreshed()
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      invalidateSelf();
      return;
    }
    this.mMainHandler.sendMessage(this.mMainHandler.obtainMessage(0));
  }
  
  public void setAlpha(int paramInt)
  {
    if (paramInt != this.mRegionState.mPaint.getAlpha())
    {
      this.mRegionState.mPaint.setAlpha(paramInt);
      invalidateSelf();
    }
  }
  
  public void setAntiAlias(boolean paramBoolean)
  {
    this.mRegionState.mPaint.setAntiAlias(paramBoolean);
    invalidateSelf();
  }
  
  public void setAutoMirrored(boolean paramBoolean)
  {
    if (this.mRegionState.mAutoMirrored != paramBoolean)
    {
      this.mRegionState.mAutoMirrored = paramBoolean;
      invalidateSelf();
    }
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.mRegionState.mPaint.setColorFilter(paramColorFilter);
    invalidateSelf();
  }
  
  public void setDither(boolean paramBoolean)
  {
    this.mRegionState.mPaint.setDither(paramBoolean);
    invalidateSelf();
  }
  
  public void setFilterBitmap(boolean paramBoolean)
  {
    this.mRegionState.mPaint.setFilterBitmap(paramBoolean);
    invalidateSelf();
  }
  
  public void setGravity(int paramInt)
  {
    if (this.mRegionState.mGravity != paramInt)
    {
      this.mRegionState.mGravity = paramInt;
      this.mApplyGravity = true;
      invalidateSelf();
    }
  }
  
  public void setTargetDensity(int paramInt)
  {
    if (this.mTargetDensity != paramInt)
    {
      int i = paramInt;
      if (paramInt == 0) {
        i = 160;
      }
      this.mTargetDensity = i;
      if (this.mBitmap != null) {
        computeBitmapSize();
      }
      invalidateSelf();
    }
  }
  
  public void setTargetDensity(Canvas paramCanvas)
  {
    setTargetDensity(paramCanvas.getDensity());
  }
  
  public void setTargetDensity(DisplayMetrics paramDisplayMetrics)
  {
    setTargetDensity(paramDisplayMetrics.densityDpi);
  }
  
  public void setTileModeX(Shader.TileMode paramTileMode)
  {
    setTileModeXY(paramTileMode, this.mRegionState.mTileModeY);
  }
  
  public void setTileModeXY(Shader.TileMode paramTileMode1, Shader.TileMode paramTileMode2)
  {
    RegionDrawable.RegionState localRegionState = this.mRegionState;
    if ((localRegionState.mTileModeX != paramTileMode1) || (localRegionState.mTileModeY != paramTileMode2))
    {
      localRegionState.mTileModeX = paramTileMode1;
      localRegionState.mTileModeY = paramTileMode2;
      localRegionState.mRebuildShader = true;
      invalidateSelf();
    }
  }
  
  public final void setTileModeY(Shader.TileMode paramTileMode)
  {
    setTileModeXY(this.mRegionState.mTileModeX, paramTileMode);
  }
  
  public void setXfermode(Xfermode paramXfermode)
  {
    this.mRegionState.mPaint.setXfermode(paramXfermode);
    invalidateSelf();
  }
  
  public void updateRegionRect(RegionDrawableData paramRegionDrawableData)
  {
    if (paramRegionDrawableData.mShowRegion != this.mShowRegion)
    {
      if (!paramRegionDrawableData.mShowRegion) {
        this.mUpdateRect.setEmpty();
      }
      this.mShowRegion = paramRegionDrawableData.mShowRegion;
      invalidateSelf();
    }
    if (!paramRegionDrawableData.mShowRegion) {}
    Rect localRect;
    do
    {
      return;
      localRect = calcCachedArea(paramRegionDrawableData.mImageArea, paramRegionDrawableData.mShowArea);
    } while ((localRect.equals(this.mUpdateRect)) && (this.mRegionDrawableState == paramRegionDrawableData.mState));
    this.mUpdateRect.set(localRect);
    paramRegionDrawableData.mShowArea.set(localRect);
    paramRegionDrawableData.mTargetDensity = this.mTargetDensity;
    paramRegionDrawableData.mSourceDensity = getBitmap().getDensity();
    this.mRegionDrawableState = paramRegionDrawableData.mState;
    this.mRegionBitmap.updateRegionBitmap(paramRegionDrawableData);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.image.RegionDrawable
 * JD-Core Version:    0.7.0.1
 */