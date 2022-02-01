package com.tencent.ilive.circleimageview;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

public class CircleImageView
  extends ImageView
{
  private static final Bitmap.Config BITMAP_CONFIG = Bitmap.Config.ARGB_8888;
  private static final int COLORDRAWABLE_DIMENSION = 2;
  private static final int DEFAULT_BORDER_COLOR = 0;
  private static final boolean DEFAULT_BORDER_OVERLAY = false;
  private static final int DEFAULT_BORDER_WIDTH = 0;
  private static final int DEFAULT_FILL_COLOR = 0;
  private static final int DEFAULT_ROUND_RADIUS = 0;
  private static final ImageView.ScaleType SCALE_TYPE = ImageView.ScaleType.CENTER_CROP;
  private Bitmap mBitmap;
  private int mBitmapHeight;
  private final Paint mBitmapPaint = new Paint();
  private BitmapShader mBitmapShader;
  private int mBitmapWidth;
  private int mBorderColor = 0;
  private boolean mBorderOverlay;
  private final Paint mBorderPaint = new Paint();
  private float mBorderRadius;
  private final RectF mBorderRect = new RectF();
  private int mBorderWidth = 0;
  private ColorFilter mColorFilter;
  private float mDrawableRadius;
  private final RectF mDrawableRect = new RectF();
  private int mFillColor = 0;
  private final Paint mFillPaint = new Paint();
  private boolean mReady;
  private int mRoundRadius = 0;
  private boolean mSetupPending;
  private final Matrix mShaderMatrix = new Matrix();
  
  public CircleImageView(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public CircleImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public CircleImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.q, paramInt, 0);
    this.mBorderWidth = paramContext.getDimensionPixelSize(R.styleable.c, 0);
    this.mBorderColor = paramContext.getColor(R.styleable.a, 0);
    this.mBorderOverlay = paramContext.getBoolean(R.styleable.b, false);
    this.mFillColor = paramContext.getColor(R.styleable.d, 0);
    this.mRoundRadius = paramContext.getDimensionPixelOffset(R.styleable.e, 0);
    paramContext.recycle();
    init();
  }
  
  private Bitmap getBitmapFromDrawable(Drawable paramDrawable)
  {
    if (paramDrawable == null) {
      return null;
    }
    if ((paramDrawable instanceof BitmapDrawable)) {
      return ((BitmapDrawable)paramDrawable).getBitmap();
    }
    try
    {
      Bitmap localBitmap;
      if ((paramDrawable instanceof ColorDrawable)) {
        localBitmap = Bitmap.createBitmap(2, 2, BITMAP_CONFIG);
      } else {
        localBitmap = Bitmap.createBitmap(paramDrawable.getIntrinsicWidth(), paramDrawable.getIntrinsicHeight(), BITMAP_CONFIG);
      }
      Canvas localCanvas = new Canvas(localBitmap);
      paramDrawable.setBounds(0, 0, localCanvas.getWidth(), localCanvas.getHeight());
      paramDrawable.draw(localCanvas);
      return localBitmap;
    }
    catch (Exception paramDrawable)
    {
      paramDrawable.printStackTrace();
    }
    return null;
  }
  
  private void init()
  {
    super.setScaleType(SCALE_TYPE);
    this.mReady = true;
    if (this.mSetupPending)
    {
      setup();
      this.mSetupPending = false;
    }
  }
  
  private void setup()
  {
    if (!this.mReady)
    {
      this.mSetupPending = true;
      return;
    }
    if ((getWidth() == 0) && (getHeight() == 0)) {
      return;
    }
    Object localObject = this.mBitmap;
    if (localObject == null)
    {
      invalidate();
      return;
    }
    this.mBitmapShader = new BitmapShader((Bitmap)localObject, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
    this.mBitmapPaint.setAntiAlias(true);
    this.mBitmapPaint.setShader(this.mBitmapShader);
    this.mBorderPaint.setStyle(Paint.Style.STROKE);
    this.mBorderPaint.setAntiAlias(true);
    this.mBorderPaint.setColor(this.mBorderColor);
    this.mBorderPaint.setStrokeWidth(this.mBorderWidth);
    this.mFillPaint.setStyle(Paint.Style.FILL);
    this.mFillPaint.setAntiAlias(true);
    this.mFillPaint.setColor(this.mFillColor);
    this.mBitmapHeight = this.mBitmap.getHeight();
    this.mBitmapWidth = this.mBitmap.getWidth();
    this.mBorderRect.set(0.0F, 0.0F, getWidth(), getHeight());
    this.mBorderRadius = Math.min((this.mBorderRect.height() - this.mBorderWidth) / 2.0F, (this.mBorderRect.width() - this.mBorderWidth) / 2.0F);
    this.mDrawableRect.set(this.mBorderRect);
    if (!this.mBorderOverlay)
    {
      localObject = this.mDrawableRect;
      int i = this.mBorderWidth;
      ((RectF)localObject).inset(i, i);
    }
    this.mDrawableRadius = Math.min(this.mDrawableRect.height() / 2.0F, this.mDrawableRect.width() / 2.0F);
    updateShaderMatrix();
    invalidate();
  }
  
  private void updateShaderMatrix()
  {
    this.mShaderMatrix.set(null);
    float f1 = this.mBitmapWidth;
    float f2 = this.mDrawableRect.height();
    float f4 = this.mDrawableRect.width();
    float f5 = this.mBitmapHeight;
    float f3 = 0.0F;
    if (f1 * f2 > f4 * f5)
    {
      f1 = this.mDrawableRect.height() / this.mBitmapHeight;
      f2 = (this.mDrawableRect.width() - this.mBitmapWidth * f1) * 0.5F;
    }
    else
    {
      f1 = this.mDrawableRect.width() / this.mBitmapWidth;
      f3 = (this.mDrawableRect.height() - this.mBitmapHeight * f1) * 0.5F;
      f2 = 0.0F;
    }
    this.mShaderMatrix.setScale(f1, f1);
    this.mShaderMatrix.postTranslate((int)(f2 + 0.5F) + this.mDrawableRect.left, (int)(f3 + 0.5F) + this.mDrawableRect.top);
    this.mBitmapShader.setLocalMatrix(this.mShaderMatrix);
  }
  
  public int getBorderColor()
  {
    return this.mBorderColor;
  }
  
  public int getBorderWidth()
  {
    return this.mBorderWidth;
  }
  
  public int getFillColor()
  {
    return this.mFillColor;
  }
  
  public ImageView.ScaleType getScaleType()
  {
    return SCALE_TYPE;
  }
  
  public boolean isBorderOverlay()
  {
    return this.mBorderOverlay;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (this.mBitmap == null) {
      return;
    }
    if (this.mFillColor != 0) {
      paramCanvas.drawRect(0.0F, 0.0F, getWidth(), getHeight(), this.mFillPaint);
    }
    if (this.mRoundRadius == 0)
    {
      paramCanvas.drawCircle(getWidth() / 2.0F, getHeight() / 2.0F, this.mDrawableRadius, this.mBitmapPaint);
    }
    else
    {
      RectF localRectF = new RectF(new Rect(0, 0, getWidth(), getHeight()));
      int i = this.mRoundRadius;
      paramCanvas.drawRoundRect(localRectF, i, i, this.mBitmapPaint);
    }
    if (this.mBorderWidth != 0) {
      paramCanvas.drawCircle(getWidth() / 2.0F, getHeight() / 2.0F, this.mBorderRadius, this.mBorderPaint);
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    setup();
  }
  
  public void setAdjustViewBounds(boolean paramBoolean)
  {
    if (!paramBoolean) {
      return;
    }
    throw new IllegalArgumentException("adjustViewBounds not supported.");
  }
  
  public void setBorderColor(int paramInt)
  {
    if (paramInt == this.mBorderColor) {
      return;
    }
    this.mBorderColor = paramInt;
    this.mBorderPaint.setColor(this.mBorderColor);
    invalidate();
  }
  
  public void setBorderColorResource(int paramInt)
  {
    setBorderColor(getContext().getResources().getColor(paramInt));
  }
  
  public void setBorderOverlay(boolean paramBoolean)
  {
    if (paramBoolean == this.mBorderOverlay) {
      return;
    }
    this.mBorderOverlay = paramBoolean;
    setup();
  }
  
  public void setBorderWidth(int paramInt)
  {
    if (paramInt == this.mBorderWidth) {
      return;
    }
    this.mBorderWidth = paramInt;
    setup();
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    if (paramColorFilter == this.mColorFilter) {
      return;
    }
    this.mColorFilter = paramColorFilter;
    this.mBitmapPaint.setColorFilter(this.mColorFilter);
    invalidate();
  }
  
  public void setFillColor(int paramInt)
  {
    if (paramInt == this.mFillColor) {
      return;
    }
    this.mFillColor = paramInt;
    this.mFillPaint.setColor(paramInt);
    invalidate();
  }
  
  public void setFillColorResource(int paramInt)
  {
    setFillColor(getContext().getResources().getColor(paramInt));
  }
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    super.setImageBitmap(paramBitmap);
    this.mBitmap = paramBitmap;
    setup();
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    super.setImageDrawable(paramDrawable);
    this.mBitmap = getBitmapFromDrawable(paramDrawable);
    setup();
  }
  
  public void setImageResource(int paramInt)
  {
    super.setImageResource(paramInt);
    this.mBitmap = getBitmapFromDrawable(getDrawable());
    setup();
  }
  
  public void setImageURI(Uri paramUri)
  {
    super.setImageURI(paramUri);
    if (paramUri != null) {
      paramUri = getBitmapFromDrawable(getDrawable());
    } else {
      paramUri = null;
    }
    this.mBitmap = paramUri;
    setup();
  }
  
  public void setRoundRadius(int paramInt)
  {
    this.mRoundRadius = paramInt;
  }
  
  public void setScaleType(ImageView.ScaleType paramScaleType)
  {
    if (paramScaleType == SCALE_TYPE) {
      return;
    }
    throw new IllegalArgumentException(String.format("ScaleType %s not supported.", new Object[] { paramScaleType }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilive.circleimageview.CircleImageView
 * JD-Core Version:    0.7.0.1
 */