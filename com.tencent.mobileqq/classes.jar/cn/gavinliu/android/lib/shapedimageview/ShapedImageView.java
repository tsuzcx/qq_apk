package cn.gavinliu.android.lib.shapedimageview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.shapes.RoundRectShape;
import android.graphics.drawable.shapes.Shape;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.widget.ImageView;
import java.util.Arrays;

public class ShapedImageView
  extends ImageView
{
  private static final int LAYER_FLAGS = 31;
  public static final int SHAPE_MODE_CIRCLE = 2;
  public static final int SHAPE_MODE_ROUND_RECT = 1;
  private PathExtension mExtension;
  private Paint mPaint;
  private Path mPath;
  private Paint mPathPaint;
  private float mRadius = 0.0F;
  private Shape mShape;
  private boolean mShapeChanged;
  private int mShapeMode = 0;
  private Bitmap mStrokeBitmap;
  private int mStrokeColor = 637534208;
  private Paint mStrokePaint;
  private Shape mStrokeShape;
  private float mStrokeWidth = 0.0F;
  
  public ShapedImageView(Context paramContext)
  {
    super(paramContext);
    init(null);
  }
  
  public ShapedImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramAttributeSet);
  }
  
  public ShapedImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramAttributeSet);
  }
  
  private void init(AttributeSet paramAttributeSet)
  {
    if (Build.VERSION.SDK_INT >= 11) {
      setLayerType(2, null);
    }
    if (paramAttributeSet != null)
    {
      paramAttributeSet = getContext().obtainStyledAttributes(paramAttributeSet, R.styleable.ShapedImageView);
      this.mShapeMode = paramAttributeSet.getInt(R.styleable.ShapedImageView_shape_mode, 0);
      this.mRadius = paramAttributeSet.getDimension(R.styleable.ShapedImageView_round_radius, 0.0F);
      this.mStrokeWidth = paramAttributeSet.getDimension(R.styleable.ShapedImageView_stroke_width, 0.0F);
      this.mStrokeColor = paramAttributeSet.getColor(R.styleable.ShapedImageView_stroke_color, this.mStrokeColor);
      paramAttributeSet.recycle();
    }
    this.mPaint = new Paint(1);
    this.mPaint.setFilterBitmap(true);
    this.mPaint.setColor(-16777216);
    this.mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
    this.mStrokePaint = new Paint(1);
    this.mStrokePaint.setFilterBitmap(true);
    this.mStrokePaint.setColor(-16777216);
    this.mPathPaint = new Paint(1);
    this.mPathPaint.setFilterBitmap(true);
    this.mPathPaint.setColor(-16777216);
    this.mPathPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
    this.mPath = new Path();
  }
  
  private Bitmap makeStrokeBitmap()
  {
    if (this.mStrokeWidth <= 0.0F) {}
    int i;
    int j;
    do
    {
      return null;
      i = getMeasuredWidth();
      j = getMeasuredHeight();
    } while ((i == 0) || (j == 0));
    releaseStrokeBitmap();
    this.mStrokeBitmap = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(this.mStrokeBitmap);
    Paint localPaint = new Paint(1);
    localPaint.setColor(this.mStrokeColor);
    localCanvas.drawRect(new RectF(0.0F, 0.0F, i, j), localPaint);
    return this.mStrokeBitmap;
  }
  
  private void releaseStrokeBitmap()
  {
    if (this.mStrokeBitmap != null)
    {
      this.mStrokeBitmap.recycle();
      this.mStrokeBitmap = null;
    }
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (this.mStrokeBitmap == null) {
      makeStrokeBitmap();
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    releaseStrokeBitmap();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if ((this.mStrokeWidth > 0.0F) && (this.mStrokeShape != null) && (this.mStrokeBitmap != null))
    {
      int i = paramCanvas.saveLayer(0.0F, 0.0F, getMeasuredWidth(), getMeasuredHeight(), null, 31);
      this.mStrokePaint.setXfermode(null);
      paramCanvas.drawBitmap(this.mStrokeBitmap, 0.0F, 0.0F, this.mStrokePaint);
      paramCanvas.translate(this.mStrokeWidth, this.mStrokeWidth);
      this.mStrokePaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
      this.mStrokeShape.draw(paramCanvas, this.mStrokePaint);
      paramCanvas.restoreToCount(i);
    }
    if (this.mExtension != null) {
      paramCanvas.drawPath(this.mPath, this.mPathPaint);
    }
    switch (this.mShapeMode)
    {
    }
    do
    {
      return;
    } while (this.mShape == null);
    this.mShape.draw(paramCanvas, this.mPaint);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if ((paramBoolean) || (this.mShapeChanged))
    {
      this.mShapeChanged = false;
      paramInt1 = getMeasuredWidth();
      paramInt2 = getMeasuredHeight();
      switch (this.mShapeMode)
      {
      }
    }
    for (;;)
    {
      if ((this.mShape == null) || (this.mRadius != 0.0F))
      {
        float[] arrayOfFloat = new float[8];
        Arrays.fill(arrayOfFloat, this.mRadius);
        this.mShape = new RoundRectShape(arrayOfFloat, null, null);
        this.mStrokeShape = new RoundRectShape(arrayOfFloat, null, null);
      }
      this.mShape.resize(paramInt1, paramInt2);
      this.mStrokeShape.resize(paramInt1 - this.mStrokeWidth * 2.0F, paramInt2 - this.mStrokeWidth * 2.0F);
      makeStrokeBitmap();
      if (this.mExtension != null) {
        this.mExtension.onLayout(this.mPath, paramInt1, paramInt2);
      }
      return;
      this.mRadius = (Math.min(paramInt1, paramInt2) / 2.0F);
    }
  }
  
  public void setExtension(PathExtension paramPathExtension)
  {
    this.mExtension = paramPathExtension;
    requestLayout();
  }
  
  public void setShape(int paramInt, float paramFloat)
  {
    if ((this.mShapeMode != paramInt) || (this.mRadius != paramFloat)) {}
    for (boolean bool = true;; bool = false)
    {
      this.mShapeChanged = bool;
      if (this.mShapeChanged)
      {
        this.mShapeMode = paramInt;
        this.mRadius = paramFloat;
        this.mShape = null;
        this.mStrokeShape = null;
        requestLayout();
      }
      return;
    }
  }
  
  public void setShapeMode(int paramInt)
  {
    setShape(paramInt, this.mRadius);
  }
  
  public void setShapeRadius(float paramFloat)
  {
    setShape(this.mShapeMode, paramFloat);
  }
  
  public void setStroke(int paramInt, float paramFloat)
  {
    if (this.mStrokeWidth <= 0.0F) {}
    do
    {
      return;
      if (this.mStrokeWidth != paramFloat)
      {
        this.mStrokeWidth = paramFloat;
        int i = getMeasuredWidth();
        int j = getMeasuredHeight();
        this.mStrokeShape.resize(i - this.mStrokeWidth * 2.0F, j - this.mStrokeWidth * 2.0F);
        postInvalidate();
      }
    } while (this.mStrokeColor == paramInt);
    this.mStrokeColor = paramInt;
    makeStrokeBitmap();
    postInvalidate();
  }
  
  public void setStrokeColor(int paramInt)
  {
    setStroke(paramInt, this.mStrokeWidth);
  }
  
  public void setStrokeWidth(float paramFloat)
  {
    setStroke(this.mStrokeColor, paramFloat);
  }
  
  public static abstract interface PathExtension
  {
    public abstract void onLayout(Path paramPath, int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     cn.gavinliu.android.lib.shapedimageview.ShapedImageView
 * JD-Core Version:    0.7.0.1
 */