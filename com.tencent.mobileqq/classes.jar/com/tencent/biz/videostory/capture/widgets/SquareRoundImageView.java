package com.tencent.biz.videostory.capture.widgets;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Path;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import axlk;
import com.tencent.mobileqq.R.styleable;
import com.tencent.qphone.base.util.QLog;
import xfm;

public class SquareRoundImageView
  extends ImageView
{
  private static int jdField_a_of_type_Int = axlk.a(2.0F);
  private BitmapShader jdField_a_of_type_AndroidGraphicsBitmapShader;
  private Matrix jdField_a_of_type_AndroidGraphicsMatrix;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private PaintFlagsDrawFilter jdField_a_of_type_AndroidGraphicsPaintFlagsDrawFilter;
  protected Path a;
  private xfm jdField_a_of_type_Xfm;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = jdField_a_of_type_Int;
  private Paint jdField_b_of_type_AndroidGraphicsPaint;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private Paint jdField_c_of_type_AndroidGraphicsPaint;
  private int d;
  private int e;
  private int f;
  
  public SquareRoundImageView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SquareRoundImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet, 0);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.SquareRoundImageView);
    int i = paramContext.getColor(0, Color.parseColor("#74000000"));
    this.jdField_b_of_type_Int = paramContext.getDimensionPixelSize(1, 2);
    this.jdField_a_of_type_AndroidGraphicsPath = new Path();
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_c_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_c_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_c_of_type_AndroidGraphicsPaint.setColor(i);
    this.jdField_c_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    this.jdField_a_of_type_AndroidGraphicsPaintFlagsDrawFilter = new PaintFlagsDrawFilter(0, 3);
    paramContext.recycle();
    if (Build.VERSION.SDK_INT <= 19) {
      setLayerType(1, null);
    }
  }
  
  private Bitmap a(Drawable paramDrawable)
  {
    if ((paramDrawable == null) || (Build.BRAND.contains("Meitu"))) {
      return null;
    }
    if ((paramDrawable instanceof BitmapDrawable)) {
      return ((BitmapDrawable)paramDrawable).getBitmap();
    }
    int i = paramDrawable.getIntrinsicWidth();
    int j = paramDrawable.getIntrinsicHeight();
    if ((i <= 0) || (j <= 0)) {
      return null;
    }
    try
    {
      Bitmap localBitmap = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
      Canvas localCanvas = new Canvas(localBitmap);
      paramDrawable.setBounds(0, 0, i, j);
      paramDrawable.draw(localCanvas);
      return localBitmap;
    }
    catch (OutOfMemoryError paramDrawable)
    {
      return null;
    }
    catch (Exception paramDrawable) {}
    return null;
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_AndroidGraphicsPath.reset();
    if ((paramInt1 <= 0) || (paramInt2 <= 0)) {
      return;
    }
    float f1 = Math.min(paramInt1 * 0.0618F, paramInt2 * 0.0618F);
    float f2 = paramInt1 / 2.0F;
    float f3 = paramInt2 / 2.0F;
    this.jdField_a_of_type_AndroidGraphicsPath.moveTo(jdField_a_of_type_Int, f3);
    this.jdField_a_of_type_AndroidGraphicsPath.cubicTo(jdField_a_of_type_Int, f1, f1, jdField_a_of_type_Int, f2, jdField_a_of_type_Int);
    this.jdField_a_of_type_AndroidGraphicsPath.cubicTo(paramInt1 - f1, jdField_a_of_type_Int, paramInt1 - jdField_a_of_type_Int, f1, paramInt1 - jdField_a_of_type_Int, f3);
    this.jdField_a_of_type_AndroidGraphicsPath.cubicTo(paramInt1 - jdField_a_of_type_Int, paramInt2 - f1, paramInt1 - f1, paramInt2 - jdField_a_of_type_Int, f2, paramInt2 - jdField_a_of_type_Int);
    this.jdField_a_of_type_AndroidGraphicsPath.cubicTo(f1, paramInt2 - jdField_a_of_type_Int, jdField_a_of_type_Int, paramInt2 - f1, jdField_a_of_type_Int, f3);
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_Xfm == null) {
      try
      {
        if (this.jdField_a_of_type_Xfm == null) {
          this.jdField_a_of_type_Xfm = new xfm(Looper.getMainLooper(), this, null);
        }
        return;
      }
      finally {}
    }
  }
  
  private void c()
  {
    int i = getWidth() - getPaddingLeft() - getPaddingRight();
    int j = getHeight() - getPaddingTop() - getPaddingBottom();
    if ((i != this.e) || (j != this.f))
    {
      this.e = i;
      this.f = j;
      a(this.e, this.f);
      if (this.jdField_a_of_type_AndroidGraphicsBitmapShader != null) {
        e();
      }
    }
  }
  
  private void d()
  {
    Bitmap localBitmap = a(getDrawable());
    if (localBitmap != null)
    {
      this.jdField_a_of_type_AndroidGraphicsBitmapShader = new BitmapShader(localBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
      this.jdField_c_of_type_Int = localBitmap.getWidth();
      this.d = localBitmap.getHeight();
      e();
    }
    for (;;)
    {
      invalidate();
      return;
      this.jdField_a_of_type_AndroidGraphicsBitmapShader = null;
      this.jdField_c_of_type_Int = 0;
      this.d = 0;
    }
  }
  
  private void e()
  {
    float f1 = 0.0F;
    if (this.jdField_a_of_type_AndroidGraphicsMatrix == null) {
      this.jdField_a_of_type_AndroidGraphicsMatrix = new Matrix();
    }
    for (;;)
    {
      if ((this.jdField_c_of_type_Int > 0) && (this.d > 0) && (this.e > 0) && (this.f > 0))
      {
        ImageView.ScaleType localScaleType = getScaleType();
        if (ImageView.ScaleType.FIT_XY != localScaleType) {
          break;
        }
        this.jdField_a_of_type_AndroidGraphicsMatrix.setScale(this.e / this.jdField_c_of_type_Int, this.f / this.d);
      }
      return;
      this.jdField_a_of_type_AndroidGraphicsMatrix.reset();
    }
    float f3;
    float f2;
    if (this.jdField_c_of_type_Int * this.f > this.e * this.d)
    {
      f3 = this.f / this.d;
      f2 = (this.e - this.jdField_c_of_type_Int * f3) * 0.5F;
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidGraphicsMatrix.setScale(f3, f3);
      this.jdField_a_of_type_AndroidGraphicsMatrix.postTranslate(Math.round(f2), Math.round(f1));
      return;
      f3 = this.e / this.jdField_c_of_type_Int;
      f1 = this.f;
      float f4 = this.d;
      f2 = 0.0F;
      f1 = (f1 - f4 * f3) * 0.5F;
    }
  }
  
  public void a()
  {
    b();
    if (!this.jdField_a_of_type_Xfm.hasMessages(1)) {
      this.jdField_a_of_type_Xfm.sendEmptyMessage(1);
    }
  }
  
  public void invalidateDrawable(@NonNull Drawable paramDrawable)
  {
    super.invalidateDrawable(paramDrawable);
    a();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (this.jdField_a_of_type_AndroidGraphicsPath != null)
    {
      if (this.jdField_b_of_type_Boolean) {
        paramCanvas.drawPath(this.jdField_a_of_type_AndroidGraphicsPath, this.jdField_c_of_type_AndroidGraphicsPaint);
      }
      if (this.jdField_a_of_type_AndroidGraphicsBitmapShader == null) {
        break label109;
      }
      this.jdField_a_of_type_AndroidGraphicsBitmapShader.setLocalMatrix(this.jdField_a_of_type_AndroidGraphicsMatrix);
      this.jdField_a_of_type_AndroidGraphicsPaint.setShader(this.jdField_a_of_type_AndroidGraphicsBitmapShader);
      paramCanvas.translate(getPaddingLeft(), getPaddingTop());
      paramCanvas.drawPath(this.jdField_a_of_type_AndroidGraphicsPath, this.jdField_a_of_type_AndroidGraphicsPaint);
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_Boolean) && (this.jdField_b_of_type_AndroidGraphicsPaint != null)) {
        paramCanvas.drawPath(this.jdField_a_of_type_AndroidGraphicsPath, this.jdField_b_of_type_AndroidGraphicsPaint);
      }
      return;
      try
      {
        label109:
        paramCanvas.setDrawFilter(this.jdField_a_of_type_AndroidGraphicsPaintFlagsDrawFilter);
        paramCanvas.save();
        this.jdField_a_of_type_AndroidGraphicsPath.offset(getPaddingLeft(), getPaddingRight());
        paramCanvas.clipPath(this.jdField_a_of_type_AndroidGraphicsPath);
        super.onDraw(paramCanvas);
        this.jdField_a_of_type_AndroidGraphicsPath.offset(0 - getPaddingLeft(), 0 - getPaddingRight());
        paramCanvas.restore();
      }
      catch (Exception localException)
      {
        super.onDraw(paramCanvas);
      }
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if ((paramInt1 != 0) && (paramInt2 != 0) && ((paramInt1 != paramInt3) || (paramInt2 != paramInt4))) {
      c();
    }
  }
  
  public void setDrawBack(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    invalidate();
  }
  
  public void setDrawChecked(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_b_of_type_AndroidGraphicsPaint == null))
    {
      this.jdField_b_of_type_AndroidGraphicsPaint = new Paint();
      this.jdField_b_of_type_AndroidGraphicsPaint.setAntiAlias(true);
      this.jdField_b_of_type_AndroidGraphicsPaint.setColor(Color.parseColor("#FFFFFF"));
      this.jdField_b_of_type_AndroidGraphicsPaint.setStrokeWidth(this.jdField_b_of_type_Int);
      this.jdField_b_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    }
    invalidate();
  }
  
  public void setDrawShadowLayer()
  {
    this.jdField_a_of_type_AndroidGraphicsPaint.setShadowLayer(10.0F, 15.0F, 15.0F, -7829368);
  }
  
  public void setImageDrawable(@Nullable Drawable paramDrawable)
  {
    super.setImageDrawable(paramDrawable);
    if (paramDrawable == null)
    {
      b();
      if (this.jdField_a_of_type_Xfm.hasMessages(1)) {
        this.jdField_a_of_type_Xfm.removeMessages(1);
      }
      this.jdField_a_of_type_AndroidGraphicsBitmapShader = null;
      this.d = 0;
      this.jdField_c_of_type_Int = 0;
      return;
    }
    a();
  }
  
  public void setImageResource(int paramInt)
  {
    if (getResources() == null) {
      return;
    }
    try
    {
      setImageDrawable(getResources().getDrawable(paramInt));
      return;
    }
    catch (Exception localException)
    {
      QLog.e("SquareRoundImageView", 4, localException, new Object[0]);
    }
  }
  
  public void setPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.setPadding(paramInt1, paramInt2, paramInt3, paramInt4);
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.biz.videostory.capture.widgets.SquareRoundImageView
 * JD-Core Version:    0.7.0.1
 */