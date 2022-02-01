package androidx.cardview.widget;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.FillType;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import androidx.annotation.Nullable;
import androidx.cardview.R.color;
import androidx.cardview.R.dimen;

class RoundRectDrawableWithShadow
  extends Drawable
{
  private static final double COS_45 = Math.cos(Math.toRadians(45.0D));
  private static final float SHADOW_MULTIPLIER = 1.5F;
  static RoundRectDrawableWithShadow.RoundRectHelper sRoundRectHelper;
  private boolean mAddPaddingForCorners = true;
  private ColorStateList mBackground;
  private final RectF mCardBounds;
  private float mCornerRadius;
  private Paint mCornerShadowPaint;
  private Path mCornerShadowPath;
  private boolean mDirty = true;
  private Paint mEdgeShadowPaint;
  private final int mInsetShadow;
  private Paint mPaint;
  private boolean mPrintedShadowClipWarning = false;
  private float mRawMaxShadowSize;
  private float mRawShadowSize;
  private final int mShadowEndColor;
  private float mShadowSize;
  private final int mShadowStartColor;
  
  RoundRectDrawableWithShadow(Resources paramResources, ColorStateList paramColorStateList, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.mShadowStartColor = paramResources.getColor(R.color.cardview_shadow_start_color);
    this.mShadowEndColor = paramResources.getColor(R.color.cardview_shadow_end_color);
    this.mInsetShadow = paramResources.getDimensionPixelSize(R.dimen.cardview_compat_inset_shadow);
    this.mPaint = new Paint(5);
    setBackground(paramColorStateList);
    this.mCornerShadowPaint = new Paint(5);
    this.mCornerShadowPaint.setStyle(Paint.Style.FILL);
    this.mCornerRadius = ((int)(paramFloat1 + 0.5F));
    this.mCardBounds = new RectF();
    this.mEdgeShadowPaint = new Paint(this.mCornerShadowPaint);
    this.mEdgeShadowPaint.setAntiAlias(false);
    setShadowSize(paramFloat2, paramFloat3);
  }
  
  private void buildComponents(Rect paramRect)
  {
    float f = this.mRawMaxShadowSize * 1.5F;
    this.mCardBounds.set(paramRect.left + this.mRawMaxShadowSize, paramRect.top + f, paramRect.right - this.mRawMaxShadowSize, paramRect.bottom - f);
    buildShadowCorners();
  }
  
  private void buildShadowCorners()
  {
    float f1 = this.mCornerRadius;
    Object localObject1 = new RectF(-f1, -f1, f1, f1);
    Object localObject2 = new RectF((RectF)localObject1);
    f1 = this.mShadowSize;
    ((RectF)localObject2).inset(-f1, -f1);
    Path localPath = this.mCornerShadowPath;
    if (localPath == null) {
      this.mCornerShadowPath = new Path();
    } else {
      localPath.reset();
    }
    this.mCornerShadowPath.setFillType(Path.FillType.EVEN_ODD);
    this.mCornerShadowPath.moveTo(-this.mCornerRadius, 0.0F);
    this.mCornerShadowPath.rLineTo(-this.mShadowSize, 0.0F);
    this.mCornerShadowPath.arcTo((RectF)localObject2, 180.0F, 90.0F, false);
    this.mCornerShadowPath.arcTo((RectF)localObject1, 270.0F, -90.0F, false);
    this.mCornerShadowPath.close();
    f1 = this.mCornerRadius;
    float f2 = this.mShadowSize;
    float f3 = f1 / (f1 + f2);
    localObject1 = this.mCornerShadowPaint;
    int i = this.mShadowStartColor;
    int j = this.mShadowEndColor;
    localObject2 = Shader.TileMode.CLAMP;
    ((Paint)localObject1).setShader(new RadialGradient(0.0F, 0.0F, f1 + f2, new int[] { i, i, j }, new float[] { 0.0F, f3, 1.0F }, (Shader.TileMode)localObject2));
    localObject1 = this.mEdgeShadowPaint;
    f3 = this.mCornerRadius;
    f1 = -f3;
    f2 = this.mShadowSize;
    f3 = -f3;
    i = this.mShadowStartColor;
    j = this.mShadowEndColor;
    localObject2 = Shader.TileMode.CLAMP;
    ((Paint)localObject1).setShader(new LinearGradient(0.0F, f1 + f2, 0.0F, f3 - f2, new int[] { i, i, j }, new float[] { 0.0F, 0.5F, 1.0F }, (Shader.TileMode)localObject2));
    this.mEdgeShadowPaint.setAntiAlias(false);
  }
  
  static float calculateHorizontalPadding(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    float f = paramFloat1;
    if (paramBoolean)
    {
      double d1 = paramFloat1;
      double d2 = COS_45;
      double d3 = paramFloat2;
      Double.isNaN(d3);
      Double.isNaN(d1);
      f = (float)(d1 + (1.0D - d2) * d3);
    }
    return f;
  }
  
  static float calculateVerticalPadding(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      double d1 = paramFloat1 * 1.5F;
      double d2 = COS_45;
      double d3 = paramFloat2;
      Double.isNaN(d3);
      Double.isNaN(d1);
      return (float)(d1 + (1.0D - d2) * d3);
    }
    return paramFloat1 * 1.5F;
  }
  
  private void drawShadow(Canvas paramCanvas)
  {
    float f2 = this.mCornerRadius;
    float f1 = -f2 - this.mShadowSize;
    f2 = f2 + this.mInsetShadow + this.mRawShadowSize / 2.0F;
    float f3 = this.mCardBounds.width();
    float f4 = f2 * 2.0F;
    if (f3 - f4 > 0.0F) {
      i = 1;
    } else {
      i = 0;
    }
    int j;
    if (this.mCardBounds.height() - f4 > 0.0F) {
      j = 1;
    } else {
      j = 0;
    }
    int k = paramCanvas.save();
    paramCanvas.translate(this.mCardBounds.left + f2, this.mCardBounds.top + f2);
    paramCanvas.drawPath(this.mCornerShadowPath, this.mCornerShadowPaint);
    if (i != 0) {
      paramCanvas.drawRect(0.0F, f1, this.mCardBounds.width() - f4, -this.mCornerRadius, this.mEdgeShadowPaint);
    }
    paramCanvas.restoreToCount(k);
    k = paramCanvas.save();
    paramCanvas.translate(this.mCardBounds.right - f2, this.mCardBounds.bottom - f2);
    paramCanvas.rotate(180.0F);
    paramCanvas.drawPath(this.mCornerShadowPath, this.mCornerShadowPaint);
    if (i != 0) {
      paramCanvas.drawRect(0.0F, f1, this.mCardBounds.width() - f4, -this.mCornerRadius + this.mShadowSize, this.mEdgeShadowPaint);
    }
    paramCanvas.restoreToCount(k);
    int i = paramCanvas.save();
    paramCanvas.translate(this.mCardBounds.left + f2, this.mCardBounds.bottom - f2);
    paramCanvas.rotate(270.0F);
    paramCanvas.drawPath(this.mCornerShadowPath, this.mCornerShadowPaint);
    if (j != 0) {
      paramCanvas.drawRect(0.0F, f1, this.mCardBounds.height() - f4, -this.mCornerRadius, this.mEdgeShadowPaint);
    }
    paramCanvas.restoreToCount(i);
    i = paramCanvas.save();
    paramCanvas.translate(this.mCardBounds.right - f2, this.mCardBounds.top + f2);
    paramCanvas.rotate(90.0F);
    paramCanvas.drawPath(this.mCornerShadowPath, this.mCornerShadowPaint);
    if (j != 0) {
      paramCanvas.drawRect(0.0F, f1, this.mCardBounds.height() - f4, -this.mCornerRadius, this.mEdgeShadowPaint);
    }
    paramCanvas.restoreToCount(i);
  }
  
  private void setBackground(ColorStateList paramColorStateList)
  {
    ColorStateList localColorStateList = paramColorStateList;
    if (paramColorStateList == null) {
      localColorStateList = ColorStateList.valueOf(0);
    }
    this.mBackground = localColorStateList;
    this.mPaint.setColor(this.mBackground.getColorForState(getState(), this.mBackground.getDefaultColor()));
  }
  
  private void setShadowSize(float paramFloat1, float paramFloat2)
  {
    if (paramFloat1 >= 0.0F)
    {
      if (paramFloat2 >= 0.0F)
      {
        float f = toEven(paramFloat1);
        paramFloat2 = toEven(paramFloat2);
        paramFloat1 = f;
        if (f > paramFloat2)
        {
          if (!this.mPrintedShadowClipWarning) {
            this.mPrintedShadowClipWarning = true;
          }
          paramFloat1 = paramFloat2;
        }
        if ((this.mRawShadowSize == paramFloat1) && (this.mRawMaxShadowSize == paramFloat2)) {
          return;
        }
        this.mRawShadowSize = paramFloat1;
        this.mRawMaxShadowSize = paramFloat2;
        this.mShadowSize = ((int)(paramFloat1 * 1.5F + this.mInsetShadow + 0.5F));
        this.mDirty = true;
        invalidateSelf();
        return;
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Invalid max shadow size ");
      localStringBuilder.append(paramFloat2);
      localStringBuilder.append(". Must be >= 0");
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Invalid shadow size ");
    localStringBuilder.append(paramFloat1);
    localStringBuilder.append(". Must be >= 0");
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  private int toEven(float paramFloat)
  {
    int j = (int)(paramFloat + 0.5F);
    int i = j;
    if (j % 2 == 1) {
      i = j - 1;
    }
    return i;
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.mDirty)
    {
      buildComponents(getBounds());
      this.mDirty = false;
    }
    paramCanvas.translate(0.0F, this.mRawShadowSize / 2.0F);
    drawShadow(paramCanvas);
    paramCanvas.translate(0.0F, -this.mRawShadowSize / 2.0F);
    sRoundRectHelper.drawRoundRect(paramCanvas, this.mCardBounds, this.mCornerRadius, this.mPaint);
  }
  
  ColorStateList getColor()
  {
    return this.mBackground;
  }
  
  float getCornerRadius()
  {
    return this.mCornerRadius;
  }
  
  void getMaxShadowAndCornerPadding(Rect paramRect)
  {
    getPadding(paramRect);
  }
  
  float getMaxShadowSize()
  {
    return this.mRawMaxShadowSize;
  }
  
  float getMinHeight()
  {
    float f = this.mRawMaxShadowSize;
    return Math.max(f, this.mCornerRadius + this.mInsetShadow + f * 1.5F / 2.0F) * 2.0F + (this.mRawMaxShadowSize * 1.5F + this.mInsetShadow) * 2.0F;
  }
  
  float getMinWidth()
  {
    float f = this.mRawMaxShadowSize;
    return Math.max(f, this.mCornerRadius + this.mInsetShadow + f / 2.0F) * 2.0F + (this.mRawMaxShadowSize + this.mInsetShadow) * 2.0F;
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  public boolean getPadding(Rect paramRect)
  {
    int i = (int)Math.ceil(calculateVerticalPadding(this.mRawMaxShadowSize, this.mCornerRadius, this.mAddPaddingForCorners));
    int j = (int)Math.ceil(calculateHorizontalPadding(this.mRawMaxShadowSize, this.mCornerRadius, this.mAddPaddingForCorners));
    paramRect.set(j, i, j, i);
    return true;
  }
  
  float getShadowSize()
  {
    return this.mRawShadowSize;
  }
  
  public boolean isStateful()
  {
    ColorStateList localColorStateList = this.mBackground;
    return ((localColorStateList != null) && (localColorStateList.isStateful())) || (super.isStateful());
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    super.onBoundsChange(paramRect);
    this.mDirty = true;
  }
  
  protected boolean onStateChange(int[] paramArrayOfInt)
  {
    ColorStateList localColorStateList = this.mBackground;
    int i = localColorStateList.getColorForState(paramArrayOfInt, localColorStateList.getDefaultColor());
    if (this.mPaint.getColor() == i) {
      return false;
    }
    this.mPaint.setColor(i);
    this.mDirty = true;
    invalidateSelf();
    return true;
  }
  
  void setAddPaddingForCorners(boolean paramBoolean)
  {
    this.mAddPaddingForCorners = paramBoolean;
    invalidateSelf();
  }
  
  public void setAlpha(int paramInt)
  {
    this.mPaint.setAlpha(paramInt);
    this.mCornerShadowPaint.setAlpha(paramInt);
    this.mEdgeShadowPaint.setAlpha(paramInt);
  }
  
  void setColor(@Nullable ColorStateList paramColorStateList)
  {
    setBackground(paramColorStateList);
    invalidateSelf();
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.mPaint.setColorFilter(paramColorFilter);
  }
  
  void setCornerRadius(float paramFloat)
  {
    if (paramFloat >= 0.0F)
    {
      paramFloat = (int)(paramFloat + 0.5F);
      if (this.mCornerRadius == paramFloat) {
        return;
      }
      this.mCornerRadius = paramFloat;
      this.mDirty = true;
      invalidateSelf();
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Invalid radius ");
    localStringBuilder.append(paramFloat);
    localStringBuilder.append(". Must be >= 0");
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  void setMaxShadowSize(float paramFloat)
  {
    setShadowSize(this.mRawShadowSize, paramFloat);
  }
  
  void setShadowSize(float paramFloat)
  {
    setShadowSize(paramFloat, this.mRawMaxShadowSize);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     androidx.cardview.widget.RoundRectDrawableWithShadow
 * JD-Core Version:    0.7.0.1
 */