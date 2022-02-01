package com.tencent.component.media.image.region;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Gravity;
import com.tencent.component.media.image.BitmapReference;
import com.tencent.component.media.utils.ImageManagerLog;
import org.xmlpull.v1.XmlPullParser;

public class RegionDrawable
  extends Drawable
  implements RegionBitmapDecoder.OnUpdateCallback
{
  private static final int DEFAULT_PAINT_FLAGS = 6;
  public static final String TAG = "RegionDrawable";
  private boolean mApplyGravity;
  private BitmapReference mBitmap;
  private int mBitmapHeight;
  private int mBitmapWidth;
  private final Rect mDstRect = new Rect();
  private Matrix mExifMatrix;
  private String mImagePath;
  private Handler mMainHandler = new RegionDrawable.1(this, Looper.getMainLooper());
  private boolean mMutated;
  private RegionBitmapDecoder mRegionBitmapDecoder;
  private int mRegionDrawableState;
  private RegionDrawable.RegionState mRegionState;
  private int mScrollDirection;
  private boolean mShowRegion;
  private int mTargetDensity;
  private Rect mUpdateRect = new Rect();
  private int orgHeight;
  private int orgWidth;
  
  public RegionDrawable(Resources paramResources, BitmapReference paramBitmapReference, String paramString)
  {
    this(new RegionDrawable.RegionState(paramBitmapReference), paramResources, paramString);
    this.mRegionState.mTargetDensity = this.mTargetDensity;
  }
  
  private RegionDrawable(RegionDrawable.RegionState paramRegionState, Resources paramResources, String paramString)
  {
    this.mRegionState = paramRegionState;
    this.mImagePath = paramString;
    if (paramString != this.mRegionState.mPath) {
      this.mRegionState.mPath = paramString;
    }
    if (paramResources != null)
    {
      this.mTargetDensity = paramResources.getDisplayMetrics().densityDpi;
      if (paramRegionState == null) {
        break label130;
      }
    }
    label130:
    for (paramRegionState = paramRegionState.mBitmap;; paramRegionState = null)
    {
      setBitmap(paramRegionState);
      paramRegionState = new RegionBitmapDecoder(paramString);
      paramRegionState.setOnUpdateCallback(this);
      this.mRegionBitmapDecoder = paramRegionState;
      return;
      this.mTargetDensity = paramRegionState.mTargetDensity;
      break;
    }
  }
  
  private void computeBitmapSize()
  {
    Bitmap localBitmap = this.mBitmap.getBitmap();
    if (localBitmap == null)
    {
      this.mBitmapWidth = -1;
      this.mBitmapHeight = -1;
      return;
    }
    this.mBitmapWidth = localBitmap.getScaledWidth(this.mTargetDensity);
    this.mBitmapHeight = localBitmap.getScaledHeight(this.mTargetDensity);
  }
  
  private void initMatrix()
  {
    int i;
    int j;
    int k;
    if (this.mExifMatrix == null)
    {
      this.mExifMatrix = new Matrix();
      Rect localRect = getBounds();
      i = localRect.width();
      j = localRect.height();
      k = RegionImageUtil.getRotation(this.mImagePath);
    }
    switch (k)
    {
    default: 
      ImageManagerLog.e("RegionDrawable", "initMatrix rotation = " + k);
      this.mExifMatrix = null;
      return;
    case -270: 
    case 90: 
      this.mExifMatrix.postRotate(90.0F);
      this.mExifMatrix.postTranslate(i, 0.0F);
      return;
    case -180: 
    case 180: 
      this.mExifMatrix.postRotate(180.0F);
      this.mExifMatrix.postTranslate(i, j);
      return;
    }
    this.mExifMatrix.postRotate(270.0F);
    this.mExifMatrix.postTranslate(0.0F, j);
  }
  
  private void processExif(String paramString)
  {
    if ((this.orgWidth == 0) || (this.orgHeight == 0)) {
      return;
    }
    int i = RegionImageUtil.getRotation(paramString);
    if (((i > 45) && (i < 135)) || ((i > 225) && (i < 315)))
    {
      j = 1;
      if (j != 0) {
        break label83;
      }
      i = this.orgWidth;
      label58:
      if (j != 0) {
        break label91;
      }
    }
    label83:
    label91:
    for (int j = this.orgHeight;; j = this.orgWidth)
    {
      this.orgWidth = i;
      this.orgHeight = j;
      return;
      j = 0;
      break;
      i = this.orgHeight;
      break label58;
    }
  }
  
  private void setBitmap(BitmapReference paramBitmapReference)
  {
    if (paramBitmapReference != this.mBitmap)
    {
      this.mBitmap = paramBitmapReference;
      if (paramBitmapReference == null) {
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
  
  private void setOrgSize(int paramInt1, int paramInt2)
  {
    this.orgWidth = paramInt1;
    this.orgHeight = paramInt2;
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.mBitmap == null) {}
    label279:
    for (;;)
    {
      return;
      Bitmap localBitmap = this.mBitmap.getBitmap();
      if ((localBitmap == null) || (localBitmap.isRecycled())) {
        break;
      }
      RegionDrawable.RegionState localRegionState = this.mRegionState;
      Object localObject2;
      Shader.TileMode localTileMode;
      if (localRegionState.mRebuildShader)
      {
        localObject2 = localRegionState.mTileModeX;
        localTileMode = localRegionState.mTileModeY;
        if ((localObject2 == null) && (localTileMode == null))
        {
          localRegionState.mPaint.setShader(null);
          localRegionState.mRebuildShader = false;
          copyBounds(this.mDstRect);
        }
      }
      else
      {
        if (localRegionState.mPaint.getShader() != null) {
          break label245;
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
        if ((!this.mShowRegion) || (this.mRegionBitmapDecoder == null)) {
          break label279;
        }
        if (this.mExifMatrix != null) {
          paramCanvas.concat(this.mExifMatrix);
        }
        this.mRegionBitmapDecoder.draw(paramCanvas, localRegionState.mPaint);
        return;
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
        label245:
        if (this.mApplyGravity)
        {
          copyBounds(this.mDstRect);
          this.mApplyGravity = false;
        }
        paramCanvas.drawRect(this.mDstRect, localRegionState.mPaint);
      }
    }
    if ((this.mRegionState != null) && (this.mRegionState.mBitmap != null))
    {
      ImageManagerLog.e("RegionDrawable", "region drawable draw bitmap.isRecycled mRegionState.bitmap = " + this.mRegionState.mBitmap.isRecycled());
      return;
    }
    ImageManagerLog.e("RegionDrawable", "region drawable draw bitmap.isRecycled ");
  }
  
  public int getAlpha()
  {
    return this.mRegionState.mPaint.getAlpha();
  }
  
  public BitmapReference getBitmapRef()
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
  
  public int getIntrinsicHeight()
  {
    if ((this.orgHeight == 0) || (this.orgHeight < this.mBitmap.getHeight())) {
      return this.mBitmap.getHeight();
    }
    return this.orgHeight;
  }
  
  public int getIntrinsicWidth()
  {
    if ((this.orgWidth == 0) || (this.orgWidth < this.mBitmap.getWidth())) {
      return this.mBitmap.getWidth();
    }
    return this.orgWidth;
  }
  
  public int getOpacity()
  {
    if (this.mRegionState.mGravity != 119) {}
    Bitmap localBitmap;
    do
    {
      do
      {
        return -3;
      } while (this.mBitmap == null);
      localBitmap = this.mBitmap.getBitmap();
    } while ((localBitmap == null) || (localBitmap.hasAlpha()) || (this.mRegionState.mPaint.getAlpha() < 255));
    return -1;
  }
  
  public int getOrgHeight()
  {
    return this.orgHeight;
  }
  
  public int getOrgWidth()
  {
    return this.orgWidth;
  }
  
  public void inflate(Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet) {}
  
  public void initRegionDrawable(int paramInt1, int paramInt2)
  {
    setOrgSize(paramInt1, paramInt2);
    processExif(this.mImagePath);
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
    initMatrix();
    this.mApplyGravity = true;
  }
  
  public void onRecycle()
  {
    if (this.mRegionBitmapDecoder != null) {
      this.mRegionBitmapDecoder.recycle();
    }
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
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.mRegionState.mPaint.setColorFilter(paramColorFilter);
    invalidateSelf();
  }
  
  public void updateRegionRect(RegionDrawableData paramRegionDrawableData)
  {
    if (!RegionImageUtil.isNeedPieceLoad(this.orgWidth, this.orgHeight)) {}
    do
    {
      return;
      if (paramRegionDrawableData.mShowRegion != this.mShowRegion)
      {
        if (!paramRegionDrawableData.mShowRegion) {
          this.mUpdateRect.setEmpty();
        }
        this.mShowRegion = paramRegionDrawableData.mShowRegion;
        invalidateSelf();
      }
    } while (!paramRegionDrawableData.mShowRegion);
    paramRegionDrawableData.mTargetDensity = this.mTargetDensity;
    this.mRegionDrawableState = paramRegionDrawableData.mState;
    this.mRegionBitmapDecoder.updateRegionBitmap(paramRegionDrawableData);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.component.media.image.region.RegionDrawable
 * JD-Core Version:    0.7.0.1
 */