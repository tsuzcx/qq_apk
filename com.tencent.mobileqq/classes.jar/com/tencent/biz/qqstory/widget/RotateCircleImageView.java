package com.tencent.biz.qqstory.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.DashPathEffect;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.mobileqq.R.styleable;
import java.util.Arrays;
import ziy;
import ziz;
import zja;
import zjb;
import zjc;
import zjd;
import zje;
import zjf;

public class RotateCircleImageView
  extends ImageView
{
  private static final Bitmap.Config jdField_a_of_type_AndroidGraphicsBitmap$Config;
  private static final SparseArray<RotateCircleImageView.BorderStyle> jdField_a_of_type_AndroidUtilSparseArray = new ziy(2);
  private static final ImageView.ScaleType jdField_a_of_type_AndroidWidgetImageView$ScaleType = ImageView.ScaleType.CENTER_CROP;
  private static final int jdField_e_of_type_Int;
  private static final int f;
  private static final int g;
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int = 0;
  private ValueAnimator jdField_a_of_type_AndroidAnimationValueAnimator;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private BitmapShader jdField_a_of_type_AndroidGraphicsBitmapShader;
  private ColorFilter jdField_a_of_type_AndroidGraphicsColorFilter;
  private DashPathEffect jdField_a_of_type_AndroidGraphicsDashPathEffect = new DashPathEffect(new float[] { 10.0F, 10.0F }, 0.0F);
  private final Matrix jdField_a_of_type_AndroidGraphicsMatrix = new Matrix();
  private final Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  private final RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  private RotateCircleImageView.BorderStyle jdField_a_of_type_ComTencentBizQqstoryWidgetRotateCircleImageView$BorderStyle = RotateCircleImageView.BorderStyle.STILL;
  private boolean jdField_a_of_type_Boolean;
  private int[] jdField_a_of_type_ArrayOfInt = { g };
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int = 0;
  private ValueAnimator jdField_b_of_type_AndroidAnimationValueAnimator;
  private final Paint jdField_b_of_type_AndroidGraphicsPaint = new Paint();
  private final RectF jdField_b_of_type_AndroidGraphicsRectF = new RectF();
  private boolean jdField_b_of_type_Boolean;
  private float jdField_c_of_type_Float;
  private int jdField_c_of_type_Int;
  private ValueAnimator jdField_c_of_type_AndroidAnimationValueAnimator;
  private final Paint jdField_c_of_type_AndroidGraphicsPaint = new Paint();
  private boolean jdField_c_of_type_Boolean;
  private float jdField_d_of_type_Float;
  private int jdField_d_of_type_Int;
  private ValueAnimator jdField_d_of_type_AndroidAnimationValueAnimator;
  private Paint jdField_d_of_type_AndroidGraphicsPaint = new Paint();
  private boolean jdField_d_of_type_Boolean;
  private ValueAnimator jdField_e_of_type_AndroidAnimationValueAnimator;
  private Paint jdField_e_of_type_AndroidGraphicsPaint = new Paint();
  private int h = 1200;
  private int i = 2000;
  private int j = jdField_e_of_type_Int;
  private int k = f;
  private int l = 0;
  
  static
  {
    jdField_a_of_type_AndroidGraphicsBitmap$Config = Bitmap.Config.ARGB_8888;
    jdField_e_of_type_Int = Color.parseColor("#4799FE");
    f = Color.parseColor("#19D7FD");
    g = jdField_e_of_type_Int;
  }
  
  public RotateCircleImageView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public RotateCircleImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public RotateCircleImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.RotateCircleImageView, paramInt, 0);
    try
    {
      this.jdField_a_of_type_Int = paramContext.getDimensionPixelSize(8, 0);
      this.jdField_c_of_type_Boolean = paramContext.getBoolean(1, false);
      this.jdField_b_of_type_Int = paramContext.getColor(9, 0);
      this.l = paramContext.getDimensionPixelSize(2, 0);
      this.j = paramContext.getColor(7, jdField_e_of_type_Int);
      this.k = paramContext.getColor(7, f);
      this.i = paramContext.getInt(5, 2000);
      this.h = paramContext.getInt(3, 1200);
      setBorderStyle((RotateCircleImageView.BorderStyle)jdField_a_of_type_AndroidUtilSparseArray.get(paramContext.getInt(4, RotateCircleImageView.BorderStyle.STILL.ordinal())));
      paramInt = paramContext.getResourceId(0, 0);
      if (paramInt != 0) {
        this.jdField_a_of_type_ArrayOfInt = paramContext.getResources().getIntArray(paramInt);
      }
      paramContext.recycle();
      a();
      return;
    }
    finally
    {
      paramContext.recycle();
    }
  }
  
  private Bitmap a(Drawable paramDrawable)
  {
    if (paramDrawable == null) {
      return null;
    }
    if ((paramDrawable instanceof BitmapDrawable)) {
      return ((BitmapDrawable)paramDrawable).getBitmap();
    }
    try
    {
      if ((paramDrawable instanceof ColorDrawable)) {}
      for (Bitmap localBitmap = Bitmap.createBitmap(2, 2, jdField_a_of_type_AndroidGraphicsBitmap$Config);; localBitmap = Bitmap.createBitmap(paramDrawable.getIntrinsicWidth(), paramDrawable.getIntrinsicHeight(), jdField_a_of_type_AndroidGraphicsBitmap$Config))
      {
        Canvas localCanvas = new Canvas(localBitmap);
        paramDrawable.setBounds(0, 0, localCanvas.getWidth(), localCanvas.getHeight());
        paramDrawable.draw(localCanvas);
        return localBitmap;
      }
      return null;
    }
    catch (Exception paramDrawable)
    {
      paramDrawable.printStackTrace();
    }
  }
  
  private RectF a()
  {
    int m = getWidth() - getPaddingLeft() - getPaddingRight();
    int n = getHeight() - getPaddingTop() - getPaddingBottom();
    int i1 = Math.min(m, n);
    float f1 = getPaddingLeft();
    f1 = (m - i1) / 2.0F + f1;
    float f2 = getPaddingTop();
    f2 = (n - i1) / 2.0F + f2;
    return new RectF(f1, f2, i1 + f1, i1 + f2);
  }
  
  private void a()
  {
    super.setScaleType(jdField_a_of_type_AndroidWidgetImageView$ScaleType);
    this.jdField_a_of_type_Boolean = true;
    if (this.jdField_b_of_type_Boolean)
    {
      d();
      this.jdField_b_of_type_Boolean = false;
    }
  }
  
  private void a(Canvas paramCanvas)
  {
    paramCanvas.rotate(this.jdField_b_of_type_Float, this.jdField_b_of_type_AndroidGraphicsRectF.centerX(), this.jdField_b_of_type_AndroidGraphicsRectF.centerY());
    paramCanvas.drawArc(this.jdField_b_of_type_AndroidGraphicsRectF, 270.0F, this.jdField_c_of_type_Float, false, this.jdField_d_of_type_AndroidGraphicsPaint);
    paramCanvas.drawArc(this.jdField_b_of_type_AndroidGraphicsRectF, 270.0F, this.jdField_d_of_type_Float, false, this.jdField_e_of_type_AndroidGraphicsPaint);
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_AndroidGraphicsPaint != null) {
      this.jdField_a_of_type_AndroidGraphicsPaint.setColorFilter(this.jdField_a_of_type_AndroidGraphicsColorFilter);
    }
  }
  
  private void b(Canvas paramCanvas)
  {
    int m = 0;
    if (m < this.jdField_a_of_type_ArrayOfInt.length)
    {
      this.jdField_b_of_type_AndroidGraphicsPaint.setColor(this.jdField_a_of_type_ArrayOfInt[m]);
      float f2 = 360.0F / this.jdField_a_of_type_ArrayOfInt.length;
      float f3 = m;
      if (this.jdField_a_of_type_ArrayOfInt.length > 1) {}
      for (float f1 = 6.0F;; f1 = 0.0F)
      {
        paramCanvas.drawArc(this.jdField_b_of_type_AndroidGraphicsRectF, 270.0F + f2 * f3, 360.0F / this.jdField_a_of_type_ArrayOfInt.length - f1, false, this.jdField_b_of_type_AndroidGraphicsPaint);
        m += 1;
        break;
      }
    }
  }
  
  private void c()
  {
    if (this.jdField_d_of_type_Boolean) {}
    for (this.jdField_a_of_type_AndroidGraphicsBitmap = null;; this.jdField_a_of_type_AndroidGraphicsBitmap = a(getDrawable()))
    {
      d();
      return;
    }
  }
  
  private void d()
  {
    if (!this.jdField_a_of_type_Boolean) {
      this.jdField_b_of_type_Boolean = true;
    }
    while ((getWidth() == 0) && (getHeight() == 0)) {
      return;
    }
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null)
    {
      this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
      this.jdField_a_of_type_AndroidGraphicsBitmapShader = new BitmapShader(this.jdField_a_of_type_AndroidGraphicsBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
      this.jdField_a_of_type_AndroidGraphicsPaint.setShader(this.jdField_a_of_type_AndroidGraphicsBitmapShader);
      this.jdField_d_of_type_Int = this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight();
      this.jdField_c_of_type_Int = this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth();
    }
    this.jdField_b_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    this.jdField_b_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_b_of_type_AndroidGraphicsPaint.setStrokeWidth(this.jdField_a_of_type_Int);
    this.jdField_b_of_type_AndroidGraphicsPaint.setStrokeCap(Paint.Cap.ROUND);
    this.jdField_c_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    this.jdField_c_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_c_of_type_AndroidGraphicsPaint.setColor(this.jdField_b_of_type_Int);
    this.jdField_b_of_type_AndroidGraphicsRectF.set(a());
    this.jdField_b_of_type_AndroidGraphicsRectF.inset(this.jdField_a_of_type_Int / 2.0F, this.jdField_a_of_type_Int / 2.0F);
    this.jdField_a_of_type_AndroidGraphicsRectF.set(a());
    if (this.l > 0) {
      this.jdField_a_of_type_AndroidGraphicsRectF.inset(this.l, this.l);
    }
    if ((!this.jdField_c_of_type_Boolean) && (this.jdField_a_of_type_Int > 0)) {
      this.jdField_a_of_type_AndroidGraphicsRectF.inset(this.jdField_a_of_type_Int - 1.0F, this.jdField_a_of_type_Int - 1.0F);
    }
    this.jdField_a_of_type_Float = Math.min(this.jdField_a_of_type_AndroidGraphicsRectF.height() / 2.0F, this.jdField_a_of_type_AndroidGraphicsRectF.width() / 2.0F);
    LinearGradient localLinearGradient = new LinearGradient(0.0F, 0.0F, getWidth(), getHeight(), this.j, this.k, Shader.TileMode.CLAMP);
    this.jdField_d_of_type_AndroidGraphicsPaint.setShader(localLinearGradient);
    this.jdField_d_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    this.jdField_d_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_d_of_type_AndroidGraphicsPaint.setStrokeWidth(this.jdField_a_of_type_Int);
    this.jdField_d_of_type_AndroidGraphicsPaint.setStrokeCap(Paint.Cap.ROUND);
    this.jdField_e_of_type_AndroidGraphicsPaint = new Paint(this.jdField_d_of_type_AndroidGraphicsPaint);
    this.jdField_e_of_type_AndroidGraphicsPaint.setPathEffect(this.jdField_a_of_type_AndroidGraphicsDashPathEffect);
    b();
    e();
    invalidate();
  }
  
  private void e()
  {
    float f1 = 0.0F;
    if (this.jdField_a_of_type_AndroidGraphicsBitmap == null) {
      return;
    }
    this.jdField_a_of_type_AndroidGraphicsMatrix.set(null);
    float f3;
    float f2;
    if (this.jdField_c_of_type_Int * this.jdField_a_of_type_AndroidGraphicsRectF.height() > this.jdField_a_of_type_AndroidGraphicsRectF.width() * this.jdField_d_of_type_Int)
    {
      f3 = this.jdField_a_of_type_AndroidGraphicsRectF.height() / this.jdField_d_of_type_Int;
      f2 = (this.jdField_a_of_type_AndroidGraphicsRectF.width() - this.jdField_c_of_type_Int * f3) * 0.5F;
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidGraphicsMatrix.setScale(f3, f3);
      this.jdField_a_of_type_AndroidGraphicsMatrix.postTranslate((int)(f2 + 0.5F) + this.jdField_a_of_type_AndroidGraphicsRectF.left, (int)(f1 + 0.5F) + this.jdField_a_of_type_AndroidGraphicsRectF.top);
      this.jdField_a_of_type_AndroidGraphicsBitmapShader.setLocalMatrix(this.jdField_a_of_type_AndroidGraphicsMatrix);
      return;
      f3 = this.jdField_a_of_type_AndroidGraphicsRectF.width() / this.jdField_c_of_type_Int;
      f1 = this.jdField_a_of_type_AndroidGraphicsRectF.height();
      float f4 = this.jdField_d_of_type_Int;
      f2 = 0.0F;
      f1 = (f1 - f4 * f3) * 0.5F;
    }
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_AndroidAnimationValueAnimator == null)
    {
      this.jdField_a_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 360.0F });
      this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(new ziz(this));
      this.jdField_a_of_type_AndroidAnimationValueAnimator.setInterpolator(new LinearInterpolator());
      this.jdField_a_of_type_AndroidAnimationValueAnimator.setDuration(this.h);
      this.jdField_a_of_type_AndroidAnimationValueAnimator.setRepeatCount(-1);
    }
    this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
    if (this.jdField_b_of_type_AndroidAnimationValueAnimator == null)
    {
      this.jdField_b_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 216.0F });
      this.jdField_b_of_type_AndroidAnimationValueAnimator.setDuration(this.i);
      this.jdField_b_of_type_AndroidAnimationValueAnimator.setRepeatCount(0);
      this.jdField_b_of_type_AndroidAnimationValueAnimator.addUpdateListener(new zja(this));
      this.jdField_b_of_type_AndroidAnimationValueAnimator.addListener(new zjb(this));
    }
    if (this.jdField_c_of_type_AndroidAnimationValueAnimator == null)
    {
      this.jdField_c_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { 216.0F, 36.0F });
      this.jdField_c_of_type_AndroidAnimationValueAnimator.setDuration(this.i);
      this.jdField_c_of_type_AndroidAnimationValueAnimator.setRepeatCount(-1);
      this.jdField_c_of_type_AndroidAnimationValueAnimator.setRepeatMode(2);
      this.jdField_c_of_type_AndroidAnimationValueAnimator.addUpdateListener(new zjc(this));
    }
    this.jdField_b_of_type_AndroidAnimationValueAnimator.start();
    if (this.jdField_d_of_type_AndroidAnimationValueAnimator == null)
    {
      this.jdField_d_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 360.0F });
      this.jdField_d_of_type_AndroidAnimationValueAnimator.setInterpolator(new LinearInterpolator());
      this.jdField_d_of_type_AndroidAnimationValueAnimator.setDuration(this.i);
      this.jdField_d_of_type_AndroidAnimationValueAnimator.setRepeatCount(0);
      this.jdField_d_of_type_AndroidAnimationValueAnimator.addUpdateListener(new zjd(this));
      this.jdField_d_of_type_AndroidAnimationValueAnimator.addListener(new zje(this));
    }
    if (this.jdField_e_of_type_AndroidAnimationValueAnimator == null)
    {
      this.jdField_e_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { 360.0F, 108.0F });
      this.jdField_e_of_type_AndroidAnimationValueAnimator.setInterpolator(new LinearInterpolator());
      this.jdField_e_of_type_AndroidAnimationValueAnimator.setDuration(this.i);
      this.jdField_e_of_type_AndroidAnimationValueAnimator.setRepeatCount(-1);
      this.jdField_e_of_type_AndroidAnimationValueAnimator.setRepeatMode(2);
      this.jdField_e_of_type_AndroidAnimationValueAnimator.addUpdateListener(new zjf(this));
    }
    this.jdField_d_of_type_AndroidAnimationValueAnimator.start();
  }
  
  private void g()
  {
    if (this.jdField_a_of_type_AndroidAnimationValueAnimator != null) {
      this.jdField_a_of_type_AndroidAnimationValueAnimator.end();
    }
    if (this.jdField_b_of_type_AndroidAnimationValueAnimator != null) {
      this.jdField_b_of_type_AndroidAnimationValueAnimator.end();
    }
    if (this.jdField_c_of_type_AndroidAnimationValueAnimator != null) {
      this.jdField_c_of_type_AndroidAnimationValueAnimator.end();
    }
    if (this.jdField_d_of_type_AndroidAnimationValueAnimator != null) {
      this.jdField_d_of_type_AndroidAnimationValueAnimator.end();
    }
    if (this.jdField_e_of_type_AndroidAnimationValueAnimator != null) {
      this.jdField_e_of_type_AndroidAnimationValueAnimator.end();
    }
  }
  
  public ColorFilter getColorFilter()
  {
    return this.jdField_a_of_type_AndroidGraphicsColorFilter;
  }
  
  public ImageView.ScaleType getScaleType()
  {
    return jdField_a_of_type_AndroidWidgetImageView$ScaleType;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (this.jdField_d_of_type_Boolean) {
      super.onDraw(paramCanvas);
    }
    do
    {
      return;
      if (this.jdField_a_of_type_AndroidGraphicsBitmap != null)
      {
        if (this.jdField_b_of_type_Int != 0) {
          paramCanvas.drawCircle(this.jdField_a_of_type_AndroidGraphicsRectF.centerX(), this.jdField_a_of_type_AndroidGraphicsRectF.centerY(), this.jdField_a_of_type_Float, this.jdField_c_of_type_AndroidGraphicsPaint);
        }
        paramCanvas.drawCircle(this.jdField_a_of_type_AndroidGraphicsRectF.centerX(), this.jdField_a_of_type_AndroidGraphicsRectF.centerY(), this.jdField_a_of_type_Float, this.jdField_a_of_type_AndroidGraphicsPaint);
      }
    } while (this.jdField_a_of_type_Int <= 0);
    switch (zjg.jdField_a_of_type_ArrayOfInt[this.jdField_a_of_type_ComTencentBizQqstoryWidgetRotateCircleImageView$BorderStyle.ordinal()])
    {
    default: 
      return;
    case 1: 
      a(paramCanvas);
      return;
    }
    b(paramCanvas);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    d();
  }
  
  protected void onVisibilityChanged(View paramView, int paramInt)
  {
    super.onVisibilityChanged(paramView, paramInt);
    if (paramInt == 0) {
      if (this.jdField_a_of_type_ComTencentBizQqstoryWidgetRotateCircleImageView$BorderStyle == RotateCircleImageView.BorderStyle.ROTATE) {
        f();
      }
    }
    while (this.jdField_a_of_type_ComTencentBizQqstoryWidgetRotateCircleImageView$BorderStyle != RotateCircleImageView.BorderStyle.ROTATE) {
      return;
    }
    g();
  }
  
  public void setAdjustViewBounds(boolean paramBoolean)
  {
    if (paramBoolean) {
      throw new IllegalArgumentException("adjustViewBounds not supported.");
    }
  }
  
  public void setBorderColors(int[] paramArrayOfInt)
  {
    if ((paramArrayOfInt != null) && (!Arrays.equals(this.jdField_a_of_type_ArrayOfInt, paramArrayOfInt)))
    {
      int[] arrayOfInt = paramArrayOfInt;
      if (paramArrayOfInt.length > 50) {
        arrayOfInt = Arrays.copyOfRange(paramArrayOfInt, 0, 50);
      }
      this.jdField_a_of_type_ArrayOfInt = arrayOfInt;
      invalidate();
    }
  }
  
  public void setBorderOverlay(boolean paramBoolean)
  {
    if (paramBoolean == this.jdField_c_of_type_Boolean) {
      return;
    }
    this.jdField_c_of_type_Boolean = paramBoolean;
    d();
  }
  
  public void setBorderPadding(int paramInt)
  {
    if (paramInt == this.l) {
      return;
    }
    this.l = paramInt;
    d();
  }
  
  public void setBorderRotateDuration(int paramInt)
  {
    if (this.h != paramInt)
    {
      this.h = paramInt;
      this.jdField_a_of_type_AndroidAnimationValueAnimator.setDuration(this.h);
    }
  }
  
  public void setBorderStyle(RotateCircleImageView.BorderStyle paramBorderStyle)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryWidgetRotateCircleImageView$BorderStyle != paramBorderStyle)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryWidgetRotateCircleImageView$BorderStyle = paramBorderStyle;
      if (this.jdField_a_of_type_ComTencentBizQqstoryWidgetRotateCircleImageView$BorderStyle != RotateCircleImageView.BorderStyle.ROTATE) {
        break label32;
      }
      f();
    }
    for (;;)
    {
      invalidate();
      return;
      label32:
      g();
    }
  }
  
  public void setBorderTrackDuration(int paramInt)
  {
    if (this.i != paramInt)
    {
      this.i = paramInt;
      this.jdField_b_of_type_AndroidAnimationValueAnimator.setDuration(this.i);
    }
  }
  
  public void setBorderTrackEndColor(int paramInt)
  {
    if (paramInt != this.k)
    {
      this.k = paramInt;
      this.jdField_d_of_type_AndroidGraphicsPaint = null;
      this.jdField_e_of_type_AndroidGraphicsPaint = null;
    }
  }
  
  public void setBorderTrackStartColor(int paramInt)
  {
    if (paramInt != this.j)
    {
      this.j = paramInt;
      this.jdField_d_of_type_AndroidGraphicsPaint = null;
      this.jdField_e_of_type_AndroidGraphicsPaint = null;
    }
  }
  
  public void setBorderWidth(int paramInt)
  {
    if (paramInt == this.jdField_a_of_type_Int) {
      return;
    }
    this.jdField_a_of_type_Int = paramInt;
    d();
  }
  
  public void setCircleBackgroundColor(int paramInt)
  {
    if (paramInt == this.jdField_b_of_type_Int) {
      return;
    }
    this.jdField_b_of_type_Int = paramInt;
    this.jdField_c_of_type_AndroidGraphicsPaint.setColor(paramInt);
    invalidate();
  }
  
  public void setCircleBackgroundColorResource(int paramInt)
  {
    setCircleBackgroundColor(getContext().getResources().getColor(paramInt));
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    if (paramColorFilter == this.jdField_a_of_type_AndroidGraphicsColorFilter) {
      return;
    }
    this.jdField_a_of_type_AndroidGraphicsColorFilter = paramColorFilter;
    b();
    invalidate();
  }
  
  public void setDisableCircularTransformation(boolean paramBoolean)
  {
    if (this.jdField_d_of_type_Boolean == paramBoolean) {
      return;
    }
    this.jdField_d_of_type_Boolean = paramBoolean;
    c();
  }
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    super.setImageBitmap(paramBitmap);
    c();
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    super.setImageDrawable(paramDrawable);
    c();
  }
  
  public void setImageResource(int paramInt)
  {
    super.setImageResource(paramInt);
    c();
  }
  
  public void setImageURI(Uri paramUri)
  {
    super.setImageURI(paramUri);
    c();
  }
  
  public void setPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.setPadding(paramInt1, paramInt2, paramInt3, paramInt4);
    d();
  }
  
  public void setScaleType(ImageView.ScaleType paramScaleType)
  {
    if (paramScaleType != jdField_a_of_type_AndroidWidgetImageView$ScaleType) {
      throw new IllegalArgumentException(String.format("ScaleType %s not supported.", new Object[] { paramScaleType }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.widget.RotateCircleImageView
 * JD-Core Version:    0.7.0.1
 */