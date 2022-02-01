package com.tencent.ditto.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
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

public class DittoImageArea
  extends DittoArea
{
  @DittoJsonElement("占位图资源id")
  public static final String RESOURCE_ID = "resource_id";
  public static final String SCALE_TYPE = "scale_type";
  private static final String TAG = "DittoImageArea";
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
    for (;;)
    {
      Object localObject1;
      ImageView.ScaleType localScaleType;
      int j;
      int k;
      int m;
      int n;
      int i;
      try
      {
        localObject1 = this.mDrawable;
        if (localObject1 == null) {
          return;
        }
        this.mDrawMatrix = null;
        if ((this.mDrawable.getBounds() != null) && ((this.mDrawable.getBounds().right > 0) || (this.mDrawable.getBounds().bottom > 0)))
        {
          localObject1 = this.mScaleType;
          localScaleType = ImageView.ScaleType.FIT_XY;
          if (localObject1 == localScaleType) {
            return;
          }
        }
        j = this.mDrawableWidth;
        k = this.mDrawableHeight;
        m = getWidth() - getPaddingLeft() - getPaddingRight();
        n = getHeight() - getPaddingTop() - getPaddingBottom();
        if (j < 0) {
          break label664;
        }
        if (m != j) {
          break label679;
        }
      }
      finally {}
      if ((j > 0) && (k > 0) && (this.mScaleType != ImageView.ScaleType.FIT_XY))
      {
        this.mDrawable.setBounds(0, 0, j, k);
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
          this.mDrawMatrix.setTranslate((int)((m - j) * 0.5F + 0.5F), (int)((n - k) * 0.5F + 0.5F));
        }
        else
        {
          localObject1 = this.mScaleType;
          localScaleType = ImageView.ScaleType.CENTER_CROP;
          float f3 = 0.0F;
          float f1;
          float f2;
          if (localObject1 == localScaleType)
          {
            this.mDrawMatrix = this.mMatrix;
            if (j * n > m * k)
            {
              f1 = n / k;
              f2 = (m - j * f1) * 0.5F;
            }
            else
            {
              f1 = m / j;
              f3 = (n - k * f1) * 0.5F;
              f2 = 0.0F;
            }
            this.mDrawMatrix.setScale(f1, f1);
            this.mDrawMatrix.postTranslate((int)(f2 + 0.5F), (int)(f3 + 0.5F));
          }
          else if (this.mScaleType == ImageView.ScaleType.CENTER_INSIDE)
          {
            this.mDrawMatrix = this.mMatrix;
            if ((j <= m) && (k <= n)) {
              f1 = 1.0F;
            } else {
              f1 = Math.min(m / j, n / k);
            }
            f2 = (int)((m - j * f1) * 0.5F + 0.5F);
            f3 = (int)((n - k * f1) * 0.5F + 0.5F);
            this.mDrawMatrix.setScale(f1, f1);
            this.mDrawMatrix.postTranslate(f2, f3);
          }
          else
          {
            if (this.mTempSrc == null) {
              this.mTempSrc = new RectF(0.0F, 0.0F, j, k);
            } else {
              this.mTempSrc.set(0.0F, 0.0F, j, k);
            }
            if (this.mTempDst == null) {
              this.mTempDst = new RectF(0.0F, 0.0F, m, n);
            } else {
              this.mTempDst.set(0.0F, 0.0F, m, n);
            }
            this.mDrawMatrix = this.mMatrix;
            this.mDrawMatrix.setRectToRect(this.mTempSrc, this.mTempDst, scaleTypeToScaleToFit(this.mScaleType));
          }
        }
      }
      else
      {
        this.mDrawable.setBounds(0, 0, m, n);
        this.mDrawMatrix = null;
      }
      return;
      label664:
      if ((k >= 0) && (n != k)) {
        label679:
        i = 0;
      } else {
        i = 1;
      }
    }
  }
  
  private void resizeFromDrawable()
  {
    Drawable localDrawable = this.mDrawable;
    if (localDrawable == null) {
      return;
    }
    int j = localDrawable.getIntrinsicWidth();
    int i = j;
    if (j < 0) {
      i = this.mDrawableWidth;
    }
    int k = this.mDrawable.getIntrinsicHeight();
    j = k;
    if (k < 0) {
      j = this.mDrawableHeight;
    }
    if ((i != this.mDrawableWidth) || (j != this.mDrawableHeight))
    {
      this.mDrawableWidth = i;
      this.mDrawableHeight = j;
      requestLayout();
    }
  }
  
  private void resolveUri()
  {
    if (this.mDrawable != null) {
      return;
    }
    Object localObject1 = null;
    if (this.mResourceId != 0)
    {
      try
      {
        Object localObject2 = getContext().getResources();
        if (localObject2 == null) {
          return;
        }
        localObject2 = ((Resources)localObject2).getDrawable(this.mResourceId);
        localObject1 = localObject2;
      }
      catch (Exception localException)
      {
        String str = TAG;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Unable to find resource: ");
        localStringBuilder.append(this.mResourceId);
        Log.w(str, localStringBuilder.toString(), localException);
      }
      updateDrawable(localObject1);
    }
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
    Drawable localDrawable = this.mDrawable;
    if (localDrawable != null) {
      localDrawable.setVisible(paramBoolean, false);
    }
  }
  
  private void updateDrawable(Drawable paramDrawable)
  {
    Drawable localDrawable = this.mDrawable;
    if (localDrawable != null) {
      localDrawable.setCallback(null);
    }
    if (paramDrawable != null)
    {
      paramDrawable.isStateful();
      paramDrawable.setLevel(this.mLevel);
      boolean bool;
      if (getVisibility() == 0) {
        bool = true;
      } else {
        bool = false;
      }
      paramDrawable.setVisible(bool, true);
      this.mDrawableWidth = paramDrawable.getIntrinsicWidth();
      this.mDrawableHeight = paramDrawable.getIntrinsicHeight();
      this.mDrawable = paramDrawable;
      configureBounds();
      return;
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
  
  /* Error */
  public void onDraw(android.graphics.Canvas paramCanvas)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokespecial 297	com/tencent/ditto/area/DittoArea:onDraw	(Landroid/graphics/Canvas;)V
    //   5: aload_0
    //   6: getfield 124	com/tencent/ditto/widget/DittoImageArea:mDrawable	Landroid/graphics/drawable/Drawable;
    //   9: astore 5
    //   11: aload 5
    //   13: ifnonnull +4 -> 17
    //   16: return
    //   17: aload_0
    //   18: getfield 142	com/tencent/ditto/widget/DittoImageArea:mDrawableWidth	I
    //   21: ifeq +281 -> 302
    //   24: aload_0
    //   25: getfield 144	com/tencent/ditto/widget/DittoImageArea:mDrawableHeight	I
    //   28: ifne +4 -> 32
    //   31: return
    //   32: aload 5
    //   34: aload_0
    //   35: invokevirtual 301	com/tencent/ditto/widget/DittoImageArea:getAlpha	()F
    //   38: f2i
    //   39: invokevirtual 304	android/graphics/drawable/Drawable:setAlpha	(I)V
    //   42: aload_0
    //   43: getfield 110	com/tencent/ditto/widget/DittoImageArea:mDrawCircleBorder	Z
    //   46: ifeq +114 -> 160
    //   49: aload_0
    //   50: getfield 307	com/tencent/ditto/widget/DittoImageArea:borderWidth	I
    //   53: ifeq +107 -> 160
    //   56: aload_0
    //   57: getfield 121	com/tencent/ditto/widget/DittoImageArea:circleBorderPaint	Landroid/graphics/Paint;
    //   60: aload_0
    //   61: getfield 310	com/tencent/ditto/widget/DittoImageArea:borderColor	I
    //   64: invokevirtual 313	android/graphics/Paint:setColor	(I)V
    //   67: aload_1
    //   68: aload_0
    //   69: invokevirtual 148	com/tencent/ditto/widget/DittoImageArea:getWidth	()I
    //   72: iconst_2
    //   73: idiv
    //   74: i2f
    //   75: aload_0
    //   76: invokevirtual 157	com/tencent/ditto/widget/DittoImageArea:getHeight	()I
    //   79: iconst_2
    //   80: idiv
    //   81: i2f
    //   82: aload_0
    //   83: invokevirtual 148	com/tencent/ditto/widget/DittoImageArea:getWidth	()I
    //   86: iconst_2
    //   87: idiv
    //   88: i2f
    //   89: aload_0
    //   90: getfield 121	com/tencent/ditto/widget/DittoImageArea:circleBorderPaint	Landroid/graphics/Paint;
    //   93: invokevirtual 319	android/graphics/Canvas:drawCircle	(FFFLandroid/graphics/Paint;)V
    //   96: aload_0
    //   97: getfield 142	com/tencent/ditto/widget/DittoImageArea:mDrawableWidth	I
    //   100: ifle +20 -> 120
    //   103: aload_0
    //   104: getfield 144	com/tencent/ditto/widget/DittoImageArea:mDrawableHeight	I
    //   107: ifle +13 -> 120
    //   110: aload_0
    //   111: getfield 108	com/tencent/ditto/widget/DittoImageArea:mScaleType	Landroid/widget/ImageView$ScaleType;
    //   114: getstatic 52	android/widget/ImageView$ScaleType:FIT_XY	Landroid/widget/ImageView$ScaleType;
    //   117: if_acmpne +84 -> 201
    //   120: aload_0
    //   121: getfield 124	com/tencent/ditto/widget/DittoImageArea:mDrawable	Landroid/graphics/drawable/Drawable;
    //   124: aload_0
    //   125: getfield 307	com/tencent/ditto/widget/DittoImageArea:borderWidth	I
    //   128: aload_0
    //   129: getfield 307	com/tencent/ditto/widget/DittoImageArea:borderWidth	I
    //   132: aload_0
    //   133: invokevirtual 148	com/tencent/ditto/widget/DittoImageArea:getWidth	()I
    //   136: aload_0
    //   137: getfield 307	com/tencent/ditto/widget/DittoImageArea:borderWidth	I
    //   140: iconst_2
    //   141: imul
    //   142: isub
    //   143: aload_0
    //   144: invokevirtual 157	com/tencent/ditto/widget/DittoImageArea:getHeight	()I
    //   147: aload_0
    //   148: getfield 307	com/tencent/ditto/widget/DittoImageArea:borderWidth	I
    //   151: iconst_2
    //   152: imul
    //   153: isub
    //   154: invokevirtual 167	android/graphics/drawable/Drawable:setBounds	(IIII)V
    //   157: goto +44 -> 201
    //   160: aload_0
    //   161: getfield 142	com/tencent/ditto/widget/DittoImageArea:mDrawableWidth	I
    //   164: ifle +20 -> 184
    //   167: aload_0
    //   168: getfield 144	com/tencent/ditto/widget/DittoImageArea:mDrawableHeight	I
    //   171: ifle +13 -> 184
    //   174: aload_0
    //   175: getfield 108	com/tencent/ditto/widget/DittoImageArea:mScaleType	Landroid/widget/ImageView$ScaleType;
    //   178: getstatic 52	android/widget/ImageView$ScaleType:FIT_XY	Landroid/widget/ImageView$ScaleType;
    //   181: if_acmpne +20 -> 201
    //   184: aload_0
    //   185: getfield 124	com/tencent/ditto/widget/DittoImageArea:mDrawable	Landroid/graphics/drawable/Drawable;
    //   188: iconst_0
    //   189: iconst_0
    //   190: aload_0
    //   191: invokevirtual 148	com/tencent/ditto/widget/DittoImageArea:getWidth	()I
    //   194: aload_0
    //   195: invokevirtual 157	com/tencent/ditto/widget/DittoImageArea:getHeight	()I
    //   198: invokevirtual 167	android/graphics/drawable/Drawable:setBounds	(IIII)V
    //   201: aload_0
    //   202: invokevirtual 151	com/tencent/ditto/widget/DittoImageArea:getPaddingLeft	()I
    //   205: istore_2
    //   206: aload_0
    //   207: invokevirtual 160	com/tencent/ditto/widget/DittoImageArea:getPaddingTop	()I
    //   210: istore_3
    //   211: aload_0
    //   212: getfield 126	com/tencent/ditto/widget/DittoImageArea:mDrawMatrix	Landroid/graphics/Matrix;
    //   215: ifnonnull +20 -> 235
    //   218: iload_2
    //   219: ifne +16 -> 235
    //   222: iload_3
    //   223: ifne +12 -> 235
    //   226: aload_0
    //   227: getfield 124	com/tencent/ditto/widget/DittoImageArea:mDrawable	Landroid/graphics/drawable/Drawable;
    //   230: aload_1
    //   231: invokevirtual 322	android/graphics/drawable/Drawable:draw	(Landroid/graphics/Canvas;)V
    //   234: return
    //   235: aload_1
    //   236: invokevirtual 325	android/graphics/Canvas:getSaveCount	()I
    //   239: istore 4
    //   241: aload_1
    //   242: invokevirtual 328	android/graphics/Canvas:save	()I
    //   245: pop
    //   246: aload_1
    //   247: iload_2
    //   248: i2f
    //   249: iload_3
    //   250: i2f
    //   251: invokevirtual 331	android/graphics/Canvas:translate	(FF)V
    //   254: aload_0
    //   255: getfield 126	com/tencent/ditto/widget/DittoImageArea:mDrawMatrix	Landroid/graphics/Matrix;
    //   258: ifnull +11 -> 269
    //   261: aload_1
    //   262: aload_0
    //   263: getfield 126	com/tencent/ditto/widget/DittoImageArea:mDrawMatrix	Landroid/graphics/Matrix;
    //   266: invokevirtual 335	android/graphics/Canvas:concat	(Landroid/graphics/Matrix;)V
    //   269: aload_0
    //   270: getfield 124	com/tencent/ditto/widget/DittoImageArea:mDrawable	Landroid/graphics/drawable/Drawable;
    //   273: aload_1
    //   274: invokevirtual 322	android/graphics/drawable/Drawable:draw	(Landroid/graphics/Canvas;)V
    //   277: aload_1
    //   278: iload 4
    //   280: invokevirtual 338	android/graphics/Canvas:restoreToCount	(I)V
    //   283: return
    //   284: astore_1
    //   285: goto +15 -> 300
    //   288: astore_1
    //   289: ldc_w 340
    //   292: ldc_w 342
    //   295: aload_1
    //   296: invokestatic 348	com/tencent/ditto/utils/DittoLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   299: return
    //   300: aload_1
    //   301: athrow
    //   302: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	303	0	this	DittoImageArea
    //   0	303	1	paramCanvas	android.graphics.Canvas
    //   205	43	2	i	int
    //   210	40	3	j	int
    //   239	40	4	k	int
    //   9	24	5	localDrawable	Drawable
    // Exception table:
    //   from	to	target	type
    //   32	120	284	finally
    //   120	157	284	finally
    //   160	184	284	finally
    //   184	201	284	finally
    //   201	218	284	finally
    //   226	234	284	finally
    //   235	269	284	finally
    //   269	283	284	finally
    //   289	299	284	finally
    //   32	120	288	java/lang/Throwable
    //   120	157	288	java/lang/Throwable
    //   160	184	288	java/lang/Throwable
    //   184	201	288	java/lang/Throwable
    //   201	218	288	java/lang/Throwable
    //   226	234	288	java/lang/Throwable
    //   235	269	288	java/lang/Throwable
    //   269	283	288	java/lang/Throwable
  }
  
  public void onLayout(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    configureBounds();
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    int m = View.MeasureSpec.getMode(paramInt1);
    int k = View.MeasureSpec.getMode(paramInt2);
    int j = View.MeasureSpec.getSize(paramInt1);
    int i = View.MeasureSpec.getSize(paramInt2);
    resolveUri();
    if (m == 1073741824)
    {
      paramInt1 = j;
    }
    else
    {
      if (this.mDrawable == null)
      {
        this.mDrawableWidth = -1;
        paramInt1 = 0;
      }
      else
      {
        paramInt1 = Math.max(1, this.mDrawableWidth) + getPaddingLeft() + getPaddingRight();
      }
      if (m == -2147483648) {
        paramInt1 = Math.min(j, paramInt1);
      }
    }
    if (k == 1073741824)
    {
      paramInt2 = i;
    }
    else
    {
      if (this.mDrawable == null)
      {
        this.mDrawableHeight = -1;
        paramInt2 = 0;
      }
      else
      {
        paramInt2 = Math.max(1, this.mDrawableHeight) + getPaddingTop() + getPaddingBottom();
      }
      if (k == -2147483648) {
        paramInt2 = Math.min(i, paramInt2);
      }
    }
    if ((m != 1073741824) && (k == 1073741824))
    {
      i = (int)(this.mDrawableWidth * 1.0F / this.mDrawableHeight * paramInt2);
      j = paramInt2;
    }
    else
    {
      i = paramInt1;
      j = paramInt2;
      if (k != 1073741824)
      {
        i = paramInt1;
        j = paramInt2;
        if (m == 1073741824)
        {
          j = (int)(this.mDrawableHeight * 1.0F / this.mDrawableWidth * paramInt1);
          i = paramInt1;
        }
      }
    }
    if (m == 1073741824)
    {
      paramInt1 = i;
      paramInt2 = j;
      if (k == 1073741824) {}
    }
    else
    {
      Drawable localDrawable = this.mDrawable;
      paramInt1 = i;
      paramInt2 = j;
      if (localDrawable != null)
      {
        paramInt1 = i;
        paramInt2 = j;
        if (localDrawable.getBounds().width() > 0)
        {
          paramInt1 = i;
          paramInt2 = j;
          if (this.mDrawable.getBounds().height() > 0)
          {
            paramInt1 = i;
            paramInt2 = j;
            if (i > 0)
            {
              paramInt1 = i;
              paramInt2 = j;
              if (j > 0)
              {
                float f1 = this.mDrawable.getBounds().width() * 1.0F / this.mDrawable.getBounds().height();
                float f2 = i;
                float f3 = j;
                float f4 = 1.0F * f2 / f3;
                if (f4 > f1)
                {
                  paramInt1 = (int)(f1 * f3);
                  paramInt2 = j;
                }
                else
                {
                  paramInt1 = i;
                  paramInt2 = j;
                  if (f4 < f1)
                  {
                    paramInt1 = i;
                    paramInt2 = j;
                    if (f1 > 0.0F)
                    {
                      paramInt2 = (int)(f2 / f1);
                      paramInt1 = i;
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    i = this.mWidth;
    if (i != 0)
    {
      j = this.mHeight;
      if (j != 0)
      {
        setMeasuredDimension(i, j);
        return;
      }
    }
    setMeasuredDimension(paramInt1, paramInt2);
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
    if (paramLayoutAttrSet.hasAttr("scale_type"))
    {
      String str = paramLayoutAttrSet.getAttr("scale_type", "fitXY");
      if ("fitXY".equals(str)) {
        setScaleType(ImageView.ScaleType.FIT_XY);
      } else if ("fitStart".equals(str)) {
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
    if (paramLayoutAttrSet.hasAttr("resource_id")) {
      setImageResource(paramLayoutAttrSet.getResourceId("resource_id"));
    }
  }
  
  public void setScaleType(ImageView.ScaleType paramScaleType)
  {
    if (paramScaleType != null)
    {
      if (this.mScaleType == paramScaleType) {
        return;
      }
      this.mScaleType = paramScaleType;
      requestLayout();
      invalidate();
      return;
    }
    throw new NullPointerException();
  }
  
  public void setVisibility(int paramInt)
  {
    super.setVisibility(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ditto.widget.DittoImageArea
 * JD-Core Version:    0.7.0.1
 */