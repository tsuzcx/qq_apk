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
    if (paramResources != null) {
      this.mTargetDensity = paramResources.getDisplayMetrics().densityDpi;
    } else {
      this.mTargetDensity = paramRegionState.mTargetDensity;
    }
    if (paramRegionState != null) {
      paramRegionState = paramRegionState.mBitmap;
    } else {
      paramRegionState = null;
    }
    setBitmap(paramRegionState);
    paramRegionState = new RegionBitmapDecoder(paramString);
    paramRegionState.setOnUpdateCallback(this);
    this.mRegionBitmapDecoder = paramRegionState;
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
    if (this.mExifMatrix == null)
    {
      this.mExifMatrix = new Matrix();
      Object localObject = getBounds();
      int i = ((Rect)localObject).width();
      int j = ((Rect)localObject).height();
      int k = RegionImageUtil.getRotation(this.mImagePath);
      if (k != -270)
      {
        if (k != -180)
        {
          if (k != -90)
          {
            if (k == 90) {
              break label169;
            }
            if (k == 180) {
              break label146;
            }
            if (k != 270)
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("initMatrix rotation = ");
              ((StringBuilder)localObject).append(k);
              ImageManagerLog.e("RegionDrawable", ((StringBuilder)localObject).toString());
              this.mExifMatrix = null;
              return;
            }
          }
          this.mExifMatrix.postRotate(270.0F);
          this.mExifMatrix.postTranslate(0.0F, j);
          return;
        }
        label146:
        this.mExifMatrix.postRotate(180.0F);
        this.mExifMatrix.postTranslate(i, j);
        return;
      }
      label169:
      this.mExifMatrix.postRotate(90.0F);
      this.mExifMatrix.postTranslate(i, 0.0F);
    }
  }
  
  private void processExif(String paramString)
  {
    if (this.orgWidth != 0)
    {
      if (this.orgHeight == 0) {
        return;
      }
      int i = RegionImageUtil.getRotation(paramString);
      int j;
      if (((i > 45) && (i < 135)) || ((i > 225) && (i < 315))) {
        j = 1;
      } else {
        j = 0;
      }
      if (j == 0) {
        i = this.orgWidth;
      } else {
        i = this.orgHeight;
      }
      if (j == 0) {
        j = this.orgHeight;
      } else {
        j = this.orgWidth;
      }
      this.orgWidth = i;
      this.orgHeight = j;
    }
  }
  
  private void setBitmap(BitmapReference paramBitmapReference)
  {
    if (paramBitmapReference != this.mBitmap)
    {
      this.mBitmap = paramBitmapReference;
      if (paramBitmapReference != null)
      {
        computeBitmapSize();
      }
      else
      {
        this.mBitmapHeight = -1;
        this.mBitmapWidth = -1;
      }
      invalidateSelf();
    }
  }
  
  private void setOrgSize(int paramInt1, int paramInt2)
  {
    this.orgWidth = paramInt1;
    this.orgHeight = paramInt2;
  }
  
  public void draw(Canvas paramCanvas)
  {
    Object localObject1 = this.mBitmap;
    if (localObject1 == null) {
      return;
    }
    Bitmap localBitmap = ((BitmapReference)localObject1).getBitmap();
    if ((localBitmap != null) && (!localBitmap.isRecycled()))
    {
      RegionDrawable.RegionState localRegionState = this.mRegionState;
      if (localRegionState.mRebuildShader)
      {
        Object localObject2 = localRegionState.mTileModeX;
        Shader.TileMode localTileMode = localRegionState.mTileModeY;
        if ((localObject2 == null) && (localTileMode == null))
        {
          localRegionState.mPaint.setShader(null);
        }
        else
        {
          Paint localPaint = localRegionState.mPaint;
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = Shader.TileMode.CLAMP;
          }
          localObject2 = localTileMode;
          if (localTileMode == null) {
            localObject2 = Shader.TileMode.CLAMP;
          }
          localPaint.setShader(new BitmapShader(localBitmap, (Shader.TileMode)localObject1, (Shader.TileMode)localObject2));
        }
        localRegionState.mRebuildShader = false;
        copyBounds(this.mDstRect);
      }
      if (localRegionState.mPaint.getShader() == null)
      {
        if (this.mApplyGravity)
        {
          Gravity.apply(localRegionState.mGravity, this.mBitmapWidth, this.mBitmapHeight, getBounds(), this.mDstRect);
          this.mApplyGravity = false;
        }
        paramCanvas.drawBitmap(localBitmap, null, this.mDstRect, localRegionState.mPaint);
      }
      else
      {
        if (this.mApplyGravity)
        {
          copyBounds(this.mDstRect);
          this.mApplyGravity = false;
        }
        paramCanvas.drawRect(this.mDstRect, localRegionState.mPaint);
      }
      if ((this.mShowRegion) && (this.mRegionBitmapDecoder != null))
      {
        localObject1 = this.mExifMatrix;
        if (localObject1 != null) {
          paramCanvas.concat((Matrix)localObject1);
        }
        this.mRegionBitmapDecoder.draw(paramCanvas, localRegionState.mPaint);
      }
    }
    else
    {
      paramCanvas = this.mRegionState;
      if ((paramCanvas != null) && (paramCanvas.mBitmap != null))
      {
        paramCanvas = new StringBuilder();
        paramCanvas.append("region drawable draw bitmap.isRecycled mRegionState.bitmap = ");
        paramCanvas.append(this.mRegionState.mBitmap.isRecycled());
        ImageManagerLog.e("RegionDrawable", paramCanvas.toString());
        return;
      }
      ImageManagerLog.e("RegionDrawable", "region drawable draw bitmap.isRecycled ");
    }
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
    int i = this.orgHeight;
    if ((i != 0) && (i >= this.mBitmap.getHeight())) {
      return this.orgHeight;
    }
    return this.mBitmap.getHeight();
  }
  
  public int getIntrinsicWidth()
  {
    int i = this.orgWidth;
    if ((i != 0) && (i >= this.mBitmap.getWidth())) {
      return this.orgWidth;
    }
    return this.mBitmap.getWidth();
  }
  
  public int getOpacity()
  {
    int i = this.mRegionState.mGravity;
    int j = -3;
    if (i != 119) {
      return -3;
    }
    Object localObject = this.mBitmap;
    if (localObject == null) {
      return -3;
    }
    localObject = ((BitmapReference)localObject).getBitmap();
    i = j;
    if (localObject != null)
    {
      i = j;
      if (!((Bitmap)localObject).hasAlpha())
      {
        if (this.mRegionState.mPaint.getAlpha() < 255) {
          return -3;
        }
        i = -1;
      }
    }
    return i;
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
    RegionBitmapDecoder localRegionBitmapDecoder = this.mRegionBitmapDecoder;
    if (localRegionBitmapDecoder != null) {
      localRegionBitmapDecoder.recycle();
    }
  }
  
  public void regionRefreshed()
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      invalidateSelf();
      return;
    }
    Handler localHandler = this.mMainHandler;
    localHandler.sendMessage(localHandler.obtainMessage(0));
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
    if (!RegionImageUtil.isNeedPieceLoad(this.orgWidth, this.orgHeight)) {
      return;
    }
    if (paramRegionDrawableData.mShowRegion != this.mShowRegion)
    {
      if (!paramRegionDrawableData.mShowRegion) {
        this.mUpdateRect.setEmpty();
      }
      this.mShowRegion = paramRegionDrawableData.mShowRegion;
      invalidateSelf();
    }
    if (!paramRegionDrawableData.mShowRegion) {
      return;
    }
    paramRegionDrawableData.mTargetDensity = this.mTargetDensity;
    this.mRegionDrawableState = paramRegionDrawableData.mState;
    this.mRegionBitmapDecoder.updateRegionBitmap(paramRegionDrawableData);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.media.image.region.RegionDrawable
 * JD-Core Version:    0.7.0.1
 */