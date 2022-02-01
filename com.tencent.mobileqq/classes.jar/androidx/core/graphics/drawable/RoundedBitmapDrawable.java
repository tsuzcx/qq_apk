package androidx.core.graphics.drawable;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public abstract class RoundedBitmapDrawable
  extends Drawable
{
  private static final int DEFAULT_PAINT_FLAGS = 3;
  private boolean mApplyGravity = true;
  final Bitmap mBitmap;
  private int mBitmapHeight;
  private final BitmapShader mBitmapShader;
  private int mBitmapWidth;
  private float mCornerRadius;
  final Rect mDstRect = new Rect();
  private final RectF mDstRectF = new RectF();
  private int mGravity = 119;
  private boolean mIsCircular;
  private final Paint mPaint = new Paint(3);
  private final Matrix mShaderMatrix = new Matrix();
  private int mTargetDensity = 160;
  
  RoundedBitmapDrawable(Resources paramResources, Bitmap paramBitmap)
  {
    if (paramResources != null) {
      this.mTargetDensity = paramResources.getDisplayMetrics().densityDpi;
    }
    this.mBitmap = paramBitmap;
    if (this.mBitmap != null)
    {
      computeBitmapSize();
      this.mBitmapShader = new BitmapShader(this.mBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
      return;
    }
    this.mBitmapHeight = -1;
    this.mBitmapWidth = -1;
    this.mBitmapShader = null;
  }
  
  private void computeBitmapSize()
  {
    this.mBitmapWidth = this.mBitmap.getScaledWidth(this.mTargetDensity);
    this.mBitmapHeight = this.mBitmap.getScaledHeight(this.mTargetDensity);
  }
  
  private static boolean isGreaterThanZero(float paramFloat)
  {
    return paramFloat > 0.05F;
  }
  
  private void updateCircularCornerRadius()
  {
    this.mCornerRadius = (Math.min(this.mBitmapHeight, this.mBitmapWidth) / 2);
  }
  
  public void draw(@NonNull Canvas paramCanvas)
  {
    Object localObject = this.mBitmap;
    if (localObject == null) {
      return;
    }
    updateDstRect();
    if (this.mPaint.getShader() == null)
    {
      paramCanvas.drawBitmap((Bitmap)localObject, null, this.mDstRect, this.mPaint);
      return;
    }
    localObject = this.mDstRectF;
    float f = this.mCornerRadius;
    paramCanvas.drawRoundRect((RectF)localObject, f, f, this.mPaint);
  }
  
  public int getAlpha()
  {
    return this.mPaint.getAlpha();
  }
  
  @Nullable
  public final Bitmap getBitmap()
  {
    return this.mBitmap;
  }
  
  public ColorFilter getColorFilter()
  {
    return this.mPaint.getColorFilter();
  }
  
  public float getCornerRadius()
  {
    return this.mCornerRadius;
  }
  
  public int getGravity()
  {
    return this.mGravity;
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
    int k = this.mGravity;
    int j = -3;
    int i = j;
    if (k == 119)
    {
      if (this.mIsCircular) {
        return -3;
      }
      Bitmap localBitmap = this.mBitmap;
      i = j;
      if (localBitmap != null)
      {
        i = j;
        if (!localBitmap.hasAlpha())
        {
          i = j;
          if (this.mPaint.getAlpha() >= 255)
          {
            if (isGreaterThanZero(this.mCornerRadius)) {
              return -3;
            }
            i = -1;
          }
        }
      }
    }
    return i;
  }
  
  @NonNull
  public final Paint getPaint()
  {
    return this.mPaint;
  }
  
  void gravityCompatApply(int paramInt1, int paramInt2, int paramInt3, Rect paramRect1, Rect paramRect2)
  {
    throw new UnsupportedOperationException();
  }
  
  public boolean hasAntiAlias()
  {
    return this.mPaint.isAntiAlias();
  }
  
  public boolean hasMipMap()
  {
    throw new UnsupportedOperationException();
  }
  
  public boolean isCircular()
  {
    return this.mIsCircular;
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    super.onBoundsChange(paramRect);
    if (this.mIsCircular) {
      updateCircularCornerRadius();
    }
    this.mApplyGravity = true;
  }
  
  public void setAlpha(int paramInt)
  {
    if (paramInt != this.mPaint.getAlpha())
    {
      this.mPaint.setAlpha(paramInt);
      invalidateSelf();
    }
  }
  
  public void setAntiAlias(boolean paramBoolean)
  {
    this.mPaint.setAntiAlias(paramBoolean);
    invalidateSelf();
  }
  
  public void setCircular(boolean paramBoolean)
  {
    this.mIsCircular = paramBoolean;
    this.mApplyGravity = true;
    if (paramBoolean)
    {
      updateCircularCornerRadius();
      this.mPaint.setShader(this.mBitmapShader);
      invalidateSelf();
      return;
    }
    setCornerRadius(0.0F);
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.mPaint.setColorFilter(paramColorFilter);
    invalidateSelf();
  }
  
  public void setCornerRadius(float paramFloat)
  {
    if (this.mCornerRadius == paramFloat) {
      return;
    }
    this.mIsCircular = false;
    if (isGreaterThanZero(paramFloat)) {
      this.mPaint.setShader(this.mBitmapShader);
    } else {
      this.mPaint.setShader(null);
    }
    this.mCornerRadius = paramFloat;
    invalidateSelf();
  }
  
  public void setDither(boolean paramBoolean)
  {
    this.mPaint.setDither(paramBoolean);
    invalidateSelf();
  }
  
  public void setFilterBitmap(boolean paramBoolean)
  {
    this.mPaint.setFilterBitmap(paramBoolean);
    invalidateSelf();
  }
  
  public void setGravity(int paramInt)
  {
    if (this.mGravity != paramInt)
    {
      this.mGravity = paramInt;
      this.mApplyGravity = true;
      invalidateSelf();
    }
  }
  
  public void setMipMap(boolean paramBoolean)
  {
    throw new UnsupportedOperationException();
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
  
  public void setTargetDensity(@NonNull Canvas paramCanvas)
  {
    setTargetDensity(paramCanvas.getDensity());
  }
  
  public void setTargetDensity(@NonNull DisplayMetrics paramDisplayMetrics)
  {
    setTargetDensity(paramDisplayMetrics.densityDpi);
  }
  
  void updateDstRect()
  {
    if (this.mApplyGravity)
    {
      if (this.mIsCircular)
      {
        int i = Math.min(this.mBitmapWidth, this.mBitmapHeight);
        gravityCompatApply(this.mGravity, i, i, getBounds(), this.mDstRect);
        i = Math.min(this.mDstRect.width(), this.mDstRect.height());
        int j = Math.max(0, (this.mDstRect.width() - i) / 2);
        int k = Math.max(0, (this.mDstRect.height() - i) / 2);
        this.mDstRect.inset(j, k);
        this.mCornerRadius = (i * 0.5F);
      }
      else
      {
        gravityCompatApply(this.mGravity, this.mBitmapWidth, this.mBitmapHeight, getBounds(), this.mDstRect);
      }
      this.mDstRectF.set(this.mDstRect);
      if (this.mBitmapShader != null)
      {
        this.mShaderMatrix.setTranslate(this.mDstRectF.left, this.mDstRectF.top);
        this.mShaderMatrix.preScale(this.mDstRectF.width() / this.mBitmap.getWidth(), this.mDstRectF.height() / this.mBitmap.getHeight());
        this.mBitmapShader.setLocalMatrix(this.mShaderMatrix);
        this.mPaint.setShader(this.mBitmapShader);
      }
      this.mApplyGravity = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.core.graphics.drawable.RoundedBitmapDrawable
 * JD-Core Version:    0.7.0.1
 */