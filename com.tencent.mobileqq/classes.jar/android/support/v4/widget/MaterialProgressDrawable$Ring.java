package android.support.v4.widget;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.FillType;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable.Callback;

class MaterialProgressDrawable$Ring
{
  private int mAlpha;
  private Path mArrow;
  private int mArrowHeight;
  private final Paint mArrowPaint = new Paint();
  private float mArrowScale;
  private int mArrowWidth;
  private int mBackgroundColor;
  private final Drawable.Callback mCallback;
  private final Paint mCirclePaint = new Paint(1);
  private int mColorIndex;
  private int[] mColors;
  private int mCurrentColor;
  private float mEndTrim = 0.0F;
  private final Paint mPaint = new Paint();
  private double mRingCenterRadius;
  private float mRotation = 0.0F;
  private boolean mShowArrow;
  private float mStartTrim = 0.0F;
  private float mStartingEndTrim;
  private float mStartingRotation;
  private float mStartingStartTrim;
  private float mStrokeInset = 2.5F;
  private float mStrokeWidth = 5.0F;
  private final RectF mTempBounds = new RectF();
  
  public MaterialProgressDrawable$Ring(Drawable.Callback paramCallback)
  {
    this.mCallback = paramCallback;
    this.mPaint.setStrokeCap(Paint.Cap.SQUARE);
    this.mPaint.setAntiAlias(true);
    this.mPaint.setStyle(Paint.Style.STROKE);
    this.mArrowPaint.setStyle(Paint.Style.FILL);
    this.mArrowPaint.setAntiAlias(true);
  }
  
  private void drawTriangle(Canvas paramCanvas, float paramFloat1, float paramFloat2, Rect paramRect)
  {
    if (this.mShowArrow)
    {
      if (this.mArrow != null) {
        break label213;
      }
      this.mArrow = new Path();
      this.mArrow.setFillType(Path.FillType.EVEN_ODD);
    }
    for (;;)
    {
      float f1 = (int)this.mStrokeInset / 2;
      float f2 = this.mArrowScale;
      float f3 = (float)(this.mRingCenterRadius * Math.cos(0.0D) + paramRect.exactCenterX());
      float f4 = (float)(this.mRingCenterRadius * Math.sin(0.0D) + paramRect.exactCenterY());
      this.mArrow.moveTo(0.0F, 0.0F);
      this.mArrow.lineTo(this.mArrowWidth * this.mArrowScale, 0.0F);
      this.mArrow.lineTo(this.mArrowWidth * this.mArrowScale / 2.0F, this.mArrowHeight * this.mArrowScale);
      this.mArrow.offset(f3 - f1 * f2, f4);
      this.mArrow.close();
      this.mArrowPaint.setColor(this.mCurrentColor);
      paramCanvas.rotate(paramFloat1 + paramFloat2 - 5.0F, paramRect.exactCenterX(), paramRect.exactCenterY());
      paramCanvas.drawPath(this.mArrow, this.mArrowPaint);
      return;
      label213:
      this.mArrow.reset();
    }
  }
  
  private int getNextColorIndex()
  {
    return (this.mColorIndex + 1) % this.mColors.length;
  }
  
  private void invalidateSelf()
  {
    this.mCallback.invalidateDrawable(null);
  }
  
  public void draw(Canvas paramCanvas, Rect paramRect)
  {
    RectF localRectF = this.mTempBounds;
    localRectF.set(paramRect);
    localRectF.inset(this.mStrokeInset, this.mStrokeInset);
    float f1 = (this.mStartTrim + this.mRotation) * 360.0F;
    float f2 = (this.mEndTrim + this.mRotation) * 360.0F - f1;
    this.mPaint.setColor(this.mCurrentColor);
    paramCanvas.drawArc(localRectF, f1, f2, false, this.mPaint);
    drawTriangle(paramCanvas, f1, f2, paramRect);
    if (this.mAlpha < 255)
    {
      this.mCirclePaint.setColor(this.mBackgroundColor);
      this.mCirclePaint.setAlpha(255 - this.mAlpha);
      paramCanvas.drawCircle(paramRect.exactCenterX(), paramRect.exactCenterY(), paramRect.width() / 2, this.mCirclePaint);
    }
  }
  
  public int getAlpha()
  {
    return this.mAlpha;
  }
  
  public double getCenterRadius()
  {
    return this.mRingCenterRadius;
  }
  
  public float getEndTrim()
  {
    return this.mEndTrim;
  }
  
  public float getInsets()
  {
    return this.mStrokeInset;
  }
  
  public int getNextColor()
  {
    return this.mColors[getNextColorIndex()];
  }
  
  public float getRotation()
  {
    return this.mRotation;
  }
  
  public float getStartTrim()
  {
    return this.mStartTrim;
  }
  
  public int getStartingColor()
  {
    return this.mColors[this.mColorIndex];
  }
  
  public float getStartingEndTrim()
  {
    return this.mStartingEndTrim;
  }
  
  public float getStartingRotation()
  {
    return this.mStartingRotation;
  }
  
  public float getStartingStartTrim()
  {
    return this.mStartingStartTrim;
  }
  
  public float getStrokeWidth()
  {
    return this.mStrokeWidth;
  }
  
  public void goToNextColor()
  {
    setColorIndex(getNextColorIndex());
  }
  
  public void resetOriginals()
  {
    this.mStartingStartTrim = 0.0F;
    this.mStartingEndTrim = 0.0F;
    this.mStartingRotation = 0.0F;
    setStartTrim(0.0F);
    setEndTrim(0.0F);
    setRotation(0.0F);
  }
  
  public void setAlpha(int paramInt)
  {
    this.mAlpha = paramInt;
  }
  
  public void setArrowDimensions(float paramFloat1, float paramFloat2)
  {
    this.mArrowWidth = ((int)paramFloat1);
    this.mArrowHeight = ((int)paramFloat2);
  }
  
  public void setArrowScale(float paramFloat)
  {
    if (paramFloat != this.mArrowScale)
    {
      this.mArrowScale = paramFloat;
      invalidateSelf();
    }
  }
  
  public void setBackgroundColor(int paramInt)
  {
    this.mBackgroundColor = paramInt;
  }
  
  public void setCenterRadius(double paramDouble)
  {
    this.mRingCenterRadius = paramDouble;
  }
  
  public void setColor(int paramInt)
  {
    this.mCurrentColor = paramInt;
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.mPaint.setColorFilter(paramColorFilter);
    invalidateSelf();
  }
  
  public void setColorIndex(int paramInt)
  {
    this.mColorIndex = paramInt;
    this.mCurrentColor = this.mColors[this.mColorIndex];
  }
  
  public void setColors(int[] paramArrayOfInt)
  {
    this.mColors = paramArrayOfInt;
    setColorIndex(0);
  }
  
  public void setEndTrim(float paramFloat)
  {
    this.mEndTrim = paramFloat;
    invalidateSelf();
  }
  
  public void setInsets(int paramInt1, int paramInt2)
  {
    float f = Math.min(paramInt1, paramInt2);
    if ((this.mRingCenterRadius <= 0.0D) || (f < 0.0F)) {}
    for (f = (float)Math.ceil(this.mStrokeWidth / 2.0F);; f = (float)(f / 2.0F - this.mRingCenterRadius))
    {
      this.mStrokeInset = f;
      return;
    }
  }
  
  public void setRotation(float paramFloat)
  {
    this.mRotation = paramFloat;
    invalidateSelf();
  }
  
  public void setShowArrow(boolean paramBoolean)
  {
    if (this.mShowArrow != paramBoolean)
    {
      this.mShowArrow = paramBoolean;
      invalidateSelf();
    }
  }
  
  public void setStartTrim(float paramFloat)
  {
    this.mStartTrim = paramFloat;
    invalidateSelf();
  }
  
  public void setStrokeWidth(float paramFloat)
  {
    this.mStrokeWidth = paramFloat;
    this.mPaint.setStrokeWidth(paramFloat);
    invalidateSelf();
  }
  
  public void storeOriginals()
  {
    this.mStartingStartTrim = this.mStartTrim;
    this.mStartingEndTrim = this.mEndTrim;
    this.mStartingRotation = this.mRotation;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     android.support.v4.widget.MaterialProgressDrawable.Ring
 * JD-Core Version:    0.7.0.1
 */