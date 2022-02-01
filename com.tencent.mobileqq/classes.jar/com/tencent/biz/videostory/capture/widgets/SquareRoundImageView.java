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
import com.tencent.mobileqq.R.styleable;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.qphone.base.util.QLog;

public class SquareRoundImageView
  extends ImageView
{
  private static int jdField_a_of_type_Int = ScreenUtil.dip2px(2.0F);
  private BitmapShader jdField_a_of_type_AndroidGraphicsBitmapShader;
  private Matrix jdField_a_of_type_AndroidGraphicsMatrix;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private PaintFlagsDrawFilter jdField_a_of_type_AndroidGraphicsPaintFlagsDrawFilter;
  protected Path a;
  private SquareRoundImageView.ShaderHandler jdField_a_of_type_ComTencentBizVideostoryCaptureWidgetsSquareRoundImageView$ShaderHandler;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = jdField_a_of_type_Int;
  private Paint jdField_b_of_type_AndroidGraphicsPaint;
  private boolean jdField_b_of_type_Boolean = false;
  private int jdField_c_of_type_Int = 0;
  private Paint jdField_c_of_type_AndroidGraphicsPaint;
  private int d = 0;
  private int e = 0;
  private int f = 0;
  
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
    int i;
    int j;
    if (paramDrawable != null)
    {
      if (Build.BRAND.contains("Meitu")) {
        return null;
      }
      if ((paramDrawable instanceof BitmapDrawable)) {
        return ((BitmapDrawable)paramDrawable).getBitmap();
      }
      i = paramDrawable.getIntrinsicWidth();
      j = paramDrawable.getIntrinsicHeight();
      if (i > 0) {
        if (j <= 0) {
          return null;
        }
      }
    }
    try
    {
      Bitmap localBitmap = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
      Canvas localCanvas = new Canvas(localBitmap);
      paramDrawable.setBounds(0, 0, i, j);
      paramDrawable.draw(localCanvas);
      return localBitmap;
    }
    catch (OutOfMemoryError|Exception paramDrawable) {}
    return null;
    return null;
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_AndroidGraphicsPath.reset();
    if (paramInt1 > 0)
    {
      if (paramInt2 <= 0) {
        return;
      }
      float f5 = paramInt1;
      float f4 = paramInt2;
      float f1 = Math.min(f5 * 0.0618F, 0.0618F * f4);
      float f2 = f5 / 2.0F;
      float f3 = f4 / 2.0F;
      this.jdField_a_of_type_AndroidGraphicsPath.moveTo(jdField_a_of_type_Int, f3);
      Path localPath = this.jdField_a_of_type_AndroidGraphicsPath;
      int i = jdField_a_of_type_Int;
      localPath.cubicTo(i, f1, f1, i, f2, i);
      localPath = this.jdField_a_of_type_AndroidGraphicsPath;
      f5 -= f1;
      i = jdField_a_of_type_Int;
      localPath.cubicTo(f5, i, paramInt1 - i, f1, paramInt1 - i, f3);
      localPath = this.jdField_a_of_type_AndroidGraphicsPath;
      i = jdField_a_of_type_Int;
      float f6 = paramInt1 - i;
      f4 -= f1;
      localPath.cubicTo(f6, f4, f5, paramInt2 - i, f2, paramInt2 - i);
      localPath = this.jdField_a_of_type_AndroidGraphicsPath;
      paramInt1 = jdField_a_of_type_Int;
      localPath.cubicTo(f1, paramInt2 - paramInt1, paramInt1, f4, paramInt1, f3);
    }
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_ComTencentBizVideostoryCaptureWidgetsSquareRoundImageView$ShaderHandler == null) {
      try
      {
        if (this.jdField_a_of_type_ComTencentBizVideostoryCaptureWidgetsSquareRoundImageView$ShaderHandler == null) {
          this.jdField_a_of_type_ComTencentBizVideostoryCaptureWidgetsSquareRoundImageView$ShaderHandler = new SquareRoundImageView.ShaderHandler(Looper.getMainLooper(), this, null);
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
    else
    {
      this.jdField_a_of_type_AndroidGraphicsBitmapShader = null;
      this.jdField_c_of_type_Int = 0;
      this.d = 0;
    }
    invalidate();
  }
  
  private void e()
  {
    Object localObject = this.jdField_a_of_type_AndroidGraphicsMatrix;
    if (localObject == null) {
      this.jdField_a_of_type_AndroidGraphicsMatrix = new Matrix();
    } else {
      ((Matrix)localObject).reset();
    }
    if ((this.jdField_c_of_type_Int > 0) && (this.d > 0) && (this.e > 0) && (this.f > 0))
    {
      localObject = getScaleType();
      if (ImageView.ScaleType.FIT_XY == localObject)
      {
        this.jdField_a_of_type_AndroidGraphicsMatrix.setScale(this.e / this.jdField_c_of_type_Int, this.f / this.d);
        return;
      }
      int i = this.jdField_c_of_type_Int;
      int j = this.f;
      int k = this.e;
      int m = this.d;
      float f3 = 0.0F;
      float f1;
      float f2;
      if (i * j > k * m)
      {
        f1 = j / m;
        f3 = (k - i * f1) * 0.5F;
        f2 = 0.0F;
      }
      else
      {
        f1 = k / i;
        f2 = (j - m * f1) * 0.5F;
      }
      this.jdField_a_of_type_AndroidGraphicsMatrix.setScale(f1, f1);
      this.jdField_a_of_type_AndroidGraphicsMatrix.postTranslate(Math.round(f3), Math.round(f2));
    }
  }
  
  public void a()
  {
    b();
    if (!this.jdField_a_of_type_ComTencentBizVideostoryCaptureWidgetsSquareRoundImageView$ShaderHandler.hasMessages(1)) {
      this.jdField_a_of_type_ComTencentBizVideostoryCaptureWidgetsSquareRoundImageView$ShaderHandler.sendEmptyMessage(1);
    }
  }
  
  public void invalidateDrawable(@NonNull Drawable paramDrawable)
  {
    super.invalidateDrawable(paramDrawable);
    a();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    Object localObject = this.jdField_a_of_type_AndroidGraphicsPath;
    if (localObject != null)
    {
      if (this.jdField_b_of_type_Boolean) {
        paramCanvas.drawPath((Path)localObject, this.jdField_c_of_type_AndroidGraphicsPaint);
      }
      localObject = this.jdField_a_of_type_AndroidGraphicsBitmapShader;
      if (localObject != null)
      {
        ((BitmapShader)localObject).setLocalMatrix(this.jdField_a_of_type_AndroidGraphicsMatrix);
        this.jdField_a_of_type_AndroidGraphicsPaint.setShader(this.jdField_a_of_type_AndroidGraphicsBitmapShader);
        paramCanvas.translate(getPaddingLeft(), getPaddingTop());
        paramCanvas.drawPath(this.jdField_a_of_type_AndroidGraphicsPath, this.jdField_a_of_type_AndroidGraphicsPaint);
      }
    }
    try
    {
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
      label155:
      break label155;
    }
    super.onDraw(paramCanvas);
    if (this.jdField_a_of_type_Boolean)
    {
      localObject = this.jdField_b_of_type_AndroidGraphicsPaint;
      if (localObject != null) {
        paramCanvas.drawPath(this.jdField_a_of_type_AndroidGraphicsPath, (Paint)localObject);
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
      if (this.jdField_a_of_type_ComTencentBizVideostoryCaptureWidgetsSquareRoundImageView$ShaderHandler.hasMessages(1)) {
        this.jdField_a_of_type_ComTencentBizVideostoryCaptureWidgetsSquareRoundImageView$ShaderHandler.removeMessages(1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.videostory.capture.widgets.SquareRoundImageView
 * JD-Core Version:    0.7.0.1
 */