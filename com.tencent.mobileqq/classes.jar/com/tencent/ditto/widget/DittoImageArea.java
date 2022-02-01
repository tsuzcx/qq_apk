package com.tencent.ditto.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Matrix.ScaleToFit;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View.MeasureSpec;
import android.widget.ImageView.ScaleType;
import com.tencent.ditto.annoations.SourceCode.DittoJsonElement;
import com.tencent.ditto.area.DittoArea;
import com.tencent.ditto.area.DittoHost;
import com.tencent.ditto.shell.LayoutAttrSet;
import com.tencent.ditto.utils.DittoLog;

public class DittoImageArea
  extends DittoArea
{
  @DittoJsonElement("占位图资源id")
  public static final String RESOURCE_ID = "resource_id";
  public static final String SCALE_TYPE = "scale_type";
  private static final String TAG = DittoImageArea.class.getSimpleName();
  private static final Matrix.ScaleToFit[] sS2FArray = { Matrix.ScaleToFit.FILL, Matrix.ScaleToFit.START, Matrix.ScaleToFit.CENTER, Matrix.ScaleToFit.END };
  private static final ImageView.ScaleType[] sScaleTypeArray = { ImageView.ScaleType.MATRIX, ImageView.ScaleType.FIT_XY, ImageView.ScaleType.FIT_START, ImageView.ScaleType.FIT_CENTER, ImageView.ScaleType.FIT_END, ImageView.ScaleType.CENTER, ImageView.ScaleType.CENTER_CROP, ImageView.ScaleType.CENTER_INSIDE };
  Paint circleBorderPaint = new Paint(1);
  private boolean mDrawCircleBorder = false;
  private Matrix mDrawMatrix;
  private Drawable mDrawable;
  private int mDrawableHeight;
  private int mDrawableWidth;
  private int mHeight = 0;
  private int mLevel;
  private final Matrix mMatrix = new Matrix();
  private int mResourceId;
  private ImageView.ScaleType mScaleType = ImageView.ScaleType.FIT_XY;
  private RectF mTempDst = new RectF();
  private RectF mTempSrc = new RectF();
  private int mWidth = 0;
  
  public DittoImageArea(DittoHost paramDittoHost, LayoutAttrSet paramLayoutAttrSet)
  {
    super(paramDittoHost, paramLayoutAttrSet);
    if (this.mTempSrc == null) {
      this.mTempSrc = new RectF();
    }
    if (this.mTempDst == null) {
      this.mTempDst = new RectF();
    }
  }
  
  private void configureBounds()
  {
    int j = 0;
    float f1 = 0.0F;
    for (;;)
    {
      int k;
      int m;
      int n;
      int i1;
      int i;
      try
      {
        Drawable localDrawable = this.mDrawable;
        if (localDrawable == null) {
          return;
        }
        this.mDrawMatrix = null;
        if ((this.mDrawable.getBounds() != null) && ((this.mDrawable.getBounds().right > 0) || (this.mDrawable.getBounds().bottom > 0)) && (this.mScaleType == ImageView.ScaleType.FIT_XY)) {
          continue;
        }
        k = this.mDrawableWidth;
        m = this.mDrawableHeight;
        n = getWidth() - getPaddingLeft() - getPaddingRight();
        i1 = getHeight() - getPaddingTop() - getPaddingBottom();
        if (k < 0) {
          break label655;
        }
        i = j;
        if (n == k) {
          break label655;
        }
        if ((k <= 0) || (m <= 0) || (this.mScaleType == ImageView.ScaleType.FIT_XY))
        {
          this.mDrawable.setBounds(0, 0, n, i1);
          this.mDrawMatrix = null;
          continue;
        }
        this.mDrawable.setBounds(0, 0, k, m);
      }
      finally {}
      if (this.mScaleType == ImageView.ScaleType.MATRIX)
      {
        if (this.mMatrix.isIdentity()) {
          this.mDrawMatrix = null;
        } else {
          this.mDrawMatrix = this.mMatrix;
        }
      }
      else if (i != 0)
      {
        this.mDrawMatrix = null;
      }
      else if (this.mScaleType == ImageView.ScaleType.CENTER)
      {
        this.mDrawMatrix = this.mMatrix;
        this.mDrawMatrix.setTranslate((int)((n - k) * 0.5F + 0.5F), (int)((i1 - m) * 0.5F + 0.5F));
      }
      else
      {
        float f3;
        float f2;
        if (this.mScaleType == ImageView.ScaleType.CENTER_CROP)
        {
          this.mDrawMatrix = this.mMatrix;
          if (k * i1 > n * m)
          {
            f3 = i1 / m;
            f2 = (n - k * f3) * 0.5F;
          }
          for (;;)
          {
            this.mDrawMatrix.setScale(f3, f3);
            this.mDrawMatrix.postTranslate((int)(f2 + 0.5F), (int)(f1 + 0.5F));
            break;
            f3 = n / k;
            f1 = i1;
            float f4 = m;
            f2 = 0.0F;
            f1 = (f1 - f4 * f3) * 0.5F;
          }
        }
        if (this.mScaleType == ImageView.ScaleType.CENTER_INSIDE)
        {
          this.mDrawMatrix = this.mMatrix;
          if ((k <= n) && (m <= i1)) {}
          for (f1 = 1.0F;; f1 = Math.min(n / k, i1 / m))
          {
            f2 = (int)((n - k * f1) * 0.5F + 0.5F);
            f3 = (int)((i1 - m * f1) * 0.5F + 0.5F);
            this.mDrawMatrix.setScale(f1, f1);
            this.mDrawMatrix.postTranslate(f2, f3);
            break;
          }
        }
        if (this.mTempSrc == null)
        {
          this.mTempSrc = new RectF(0.0F, 0.0F, k, m);
          label559:
          if (this.mTempDst != null) {
            break label637;
          }
          this.mTempDst = new RectF(0.0F, 0.0F, n, i1);
        }
        for (;;)
        {
          this.mDrawMatrix = this.mMatrix;
          this.mDrawMatrix.setRectToRect(this.mTempSrc, this.mTempDst, scaleTypeToScaleToFit(this.mScaleType));
          break;
          this.mTempSrc.set(0.0F, 0.0F, k, m);
          break label559;
          label637:
          this.mTempDst.set(0.0F, 0.0F, n, i1);
        }
        label655:
        if (m >= 0)
        {
          i = j;
          if (i1 != m) {}
        }
        else
        {
          i = 1;
        }
      }
    }
  }
  
  private void resizeFromDrawable()
  {
    if (this.mDrawable == null) {}
    int j;
    int i;
    do
    {
      return;
      j = this.mDrawable.getIntrinsicWidth();
      i = j;
      if (j < 0) {
        i = this.mDrawableWidth;
      }
      int k = this.mDrawable.getIntrinsicHeight();
      j = k;
      if (k < 0) {
        j = this.mDrawableHeight;
      }
    } while ((i == this.mDrawableWidth) && (j == this.mDrawableHeight));
    this.mDrawableWidth = i;
    this.mDrawableHeight = j;
    requestLayout();
  }
  
  private void resolveUri()
  {
    if (this.mDrawable != null) {}
    for (;;)
    {
      return;
      Object localObject1 = null;
      if (this.mResourceId != 0) {}
      try
      {
        Object localObject2 = getContext().getResources();
        if (localObject2 != null)
        {
          localObject2 = ((Resources)localObject2).getDrawable(this.mResourceId);
          localObject1 = localObject2;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.w(TAG, "Unable to find resource: " + this.mResourceId, localException);
        }
      }
    }
    updateDrawable(localObject1);
  }
  
  private static Matrix.ScaleToFit scaleTypeToScaleToFit(ImageView.ScaleType paramScaleType)
  {
    if (paramScaleType == null) {
      return sS2FArray[(ImageView.ScaleType.FIT_XY.ordinal() - 1)];
    }
    return sS2FArray[(paramScaleType.ordinal() - 1)];
  }
  
  private void setDrawableVisible(boolean paramBoolean)
  {
    if (this.mDrawable != null) {
      this.mDrawable.setVisible(paramBoolean, false);
    }
  }
  
  private void updateDrawable(Drawable paramDrawable)
  {
    if (this.mDrawable != null) {
      this.mDrawable.setCallback(null);
    }
    if (paramDrawable != null)
    {
      if (paramDrawable.isStateful()) {}
      paramDrawable.setLevel(this.mLevel);
      if (getVisibility() == 0) {}
      for (boolean bool = true;; bool = false)
      {
        paramDrawable.setVisible(bool, true);
        this.mDrawableWidth = paramDrawable.getIntrinsicWidth();
        this.mDrawableHeight = paramDrawable.getIntrinsicHeight();
        this.mDrawable = paramDrawable;
        configureBounds();
        return;
      }
    }
    this.mDrawableHeight = -1;
    this.mDrawableWidth = -1;
  }
  
  public void clearDrawable()
  {
    this.mDrawable = null;
  }
  
  public Drawable getDrawable()
  {
    return this.mDrawable;
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.mDrawable == null) {}
    while ((this.mDrawableWidth == 0) || (this.mDrawableHeight == 0)) {
      return;
    }
    int i;
    int j;
    for (;;)
    {
      try
      {
        this.mDrawable.setAlpha((int)getAlpha());
        if ((this.mDrawCircleBorder) && (this.borderWidth != 0))
        {
          this.circleBorderPaint.setColor(this.borderColor);
          paramCanvas.drawCircle(getWidth() / 2, getHeight() / 2, getWidth() / 2, this.circleBorderPaint);
          if ((this.mDrawableWidth <= 0) || (this.mDrawableHeight <= 0) || (this.mScaleType == ImageView.ScaleType.FIT_XY)) {
            this.mDrawable.setBounds(this.borderWidth, this.borderWidth, getWidth() - this.borderWidth * 2, getHeight() - this.borderWidth * 2);
          }
          i = getPaddingLeft();
          j = getPaddingTop();
          if ((this.mDrawMatrix != null) || (i != 0) || (j != 0)) {
            break;
          }
          this.mDrawable.draw(paramCanvas);
          return;
        }
      }
      catch (Throwable paramCanvas)
      {
        paramCanvas = paramCanvas;
        DittoLog.e("DITTO_UI", "", paramCanvas);
        return;
      }
      finally {}
      if ((this.mDrawableWidth <= 0) || (this.mDrawableHeight <= 0) || (this.mScaleType == ImageView.ScaleType.FIT_XY)) {
        this.mDrawable.setBounds(0, 0, getWidth(), getHeight());
      }
    }
    int k = paramCanvas.getSaveCount();
    paramCanvas.save();
    paramCanvas.translate(i, j);
    if (this.mDrawMatrix != null) {
      paramCanvas.concat(this.mDrawMatrix);
    }
    this.mDrawable.draw(paramCanvas);
    paramCanvas.restoreToCount(k);
  }
  
  public void onLayout(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    configureBounds();
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    int i = 0;
    int n = View.MeasureSpec.getMode(paramInt1);
    int m = View.MeasureSpec.getMode(paramInt2);
    int k = View.MeasureSpec.getSize(paramInt1);
    int j = View.MeasureSpec.getSize(paramInt2);
    resolveUri();
    if (n == 1073741824) {
      paramInt1 = k;
    }
    label91:
    label477:
    for (;;)
    {
      if (m == 1073741824) {
        paramInt2 = j;
      }
      for (;;)
      {
        float f1;
        float f2;
        if ((n != 1073741824) && (m == 1073741824))
        {
          j = (int)(this.mDrawableWidth * 1.0F / this.mDrawableHeight * paramInt2);
          i = paramInt2;
          if (n == 1073741824)
          {
            paramInt1 = i;
            paramInt2 = j;
            if (m == 1073741824) {}
          }
          else
          {
            paramInt1 = i;
            paramInt2 = j;
            if (this.mDrawable != null)
            {
              paramInt1 = i;
              paramInt2 = j;
              if (this.mDrawable.getBounds().width() > 0)
              {
                paramInt1 = i;
                paramInt2 = j;
                if (this.mDrawable.getBounds().height() > 0)
                {
                  paramInt1 = i;
                  paramInt2 = j;
                  if (j > 0)
                  {
                    paramInt1 = i;
                    paramInt2 = j;
                    if (i > 0)
                    {
                      f1 = this.mDrawable.getBounds().width() * 1.0F / this.mDrawable.getBounds().height();
                      f2 = j * 1.0F / i;
                      if (f2 <= f1) {
                        break label429;
                      }
                      paramInt2 = (int)(i * f1);
                      paramInt1 = i;
                    }
                  }
                }
              }
            }
          }
        }
        for (;;)
        {
          if ((this.mWidth == 0) || (this.mHeight == 0)) {
            break label467;
          }
          setMeasuredDimension(this.mWidth, this.mHeight);
          return;
          if (this.mDrawable == null) {
            this.mDrawableWidth = -1;
          }
          for (paramInt1 = 0;; paramInt1 = Math.max(1, this.mDrawableWidth) + getPaddingLeft() + getPaddingRight())
          {
            if (n != -2147483648) {
              break label477;
            }
            paramInt1 = Math.min(k, paramInt1);
            break;
          }
          if (this.mDrawable == null) {
            this.mDrawableHeight = -1;
          }
          for (paramInt2 = i;; paramInt2 = Math.max(1, this.mDrawableHeight) + getPaddingTop() + getPaddingBottom())
          {
            if (m != -2147483648) {
              break label474;
            }
            paramInt2 = Math.min(j, paramInt2);
            break;
          }
          i = paramInt2;
          j = paramInt1;
          if (m == 1073741824) {
            break label91;
          }
          i = paramInt2;
          j = paramInt1;
          if (n != 1073741824) {
            break label91;
          }
          i = (int)(this.mDrawableHeight * 1.0F / this.mDrawableWidth * paramInt1);
          j = paramInt1;
          break label91;
          paramInt1 = i;
          paramInt2 = j;
          if (f2 < f1)
          {
            paramInt1 = i;
            paramInt2 = j;
            if (f1 > 0.0F)
            {
              paramInt1 = (int)(j / f1);
              paramInt2 = j;
            }
          }
        }
        setMeasuredDimension(paramInt2, paramInt1);
        return;
      }
    }
  }
  
  public void onRecycled()
  {
    this.clickListener = null;
    this.longClickListener = null;
  }
  
  public void setDimens(int paramInt1, int paramInt2)
  {
    this.mWidth = paramInt1;
    this.mHeight = paramInt2;
  }
  
  public void setDrawCircleBorder(boolean paramBoolean)
  {
    this.mDrawCircleBorder = paramBoolean;
  }
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    setImageDrawable(new BitmapDrawable(getContext().getResources(), paramBitmap));
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    this.mResourceId = 0;
    int i = this.mDrawableWidth;
    int j = this.mDrawableHeight;
    updateDrawable(paramDrawable);
    if ((i != this.mDrawableWidth) || (j != this.mDrawableHeight)) {
      requestLayout();
    }
  }
  
  public void setImageResource(int paramInt)
  {
    if (this.mResourceId == paramInt) {
      return;
    }
    updateDrawable(null);
    this.mResourceId = paramInt;
    paramInt = this.mDrawableWidth;
    int i = this.mDrawableHeight;
    resolveUri();
    if ((paramInt != this.mDrawableWidth) || (i != this.mDrawableHeight)) {
      requestLayout();
    }
    invalidate();
  }
  
  public void setLayoutAttr(LayoutAttrSet paramLayoutAttrSet)
  {
    super.setLayoutAttr(paramLayoutAttrSet);
    String str;
    if (paramLayoutAttrSet.hasAttr("scale_type"))
    {
      str = paramLayoutAttrSet.getAttr("scale_type", "fitXY");
      if (!"fitXY".equals(str)) {
        break label61;
      }
      setScaleType(ImageView.ScaleType.FIT_XY);
    }
    for (;;)
    {
      if (paramLayoutAttrSet.hasAttr("resource_id")) {
        setImageResource(paramLayoutAttrSet.getResourceId("resource_id"));
      }
      return;
      label61:
      if ("fitStart".equals(str)) {
        setScaleType(ImageView.ScaleType.FIT_START);
      } else if ("fitCenter".equals(str)) {
        setScaleType(ImageView.ScaleType.FIT_CENTER);
      } else if ("fitEnd".equals(str)) {
        setScaleType(ImageView.ScaleType.FIT_END);
      } else if ("center".equals(str)) {
        setScaleType(ImageView.ScaleType.CENTER);
      } else if ("centerCrop".equals(str)) {
        setScaleType(ImageView.ScaleType.CENTER_CROP);
      } else if ("centerInside".equals(str)) {
        setScaleType(ImageView.ScaleType.CENTER_INSIDE);
      }
    }
  }
  
  public void setScaleType(ImageView.ScaleType paramScaleType)
  {
    if (paramScaleType == null) {
      throw new NullPointerException();
    }
    if (this.mScaleType == paramScaleType) {
      return;
    }
    this.mScaleType = paramScaleType;
    requestLayout();
    invalidate();
  }
  
  public void setVisibility(int paramInt)
  {
    super.setVisibility(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.ditto.widget.DittoImageArea
 * JD-Core Version:    0.7.0.1
 */