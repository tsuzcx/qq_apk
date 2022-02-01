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
  private static int b = ScreenUtil.dip2px(2.0F);
  protected Path a;
  private int c = b;
  private Paint d;
  private Paint e;
  private Paint f;
  private Matrix g;
  private PaintFlagsDrawFilter h;
  private BitmapShader i;
  private SquareRoundImageView.ShaderHandler j;
  private int k = 0;
  private int l = 0;
  private int m = 0;
  private int n = 0;
  private boolean o;
  private boolean p = false;
  
  public SquareRoundImageView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SquareRoundImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet, 0);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.SquareRoundImageView);
    int i1 = paramContext.getColor(0, Color.parseColor("#74000000"));
    this.c = paramContext.getDimensionPixelSize(1, 2);
    this.a = new Path();
    this.d = new Paint();
    this.d.setAntiAlias(true);
    this.f = new Paint();
    this.f.setAntiAlias(true);
    this.f.setColor(i1);
    this.f.setStyle(Paint.Style.FILL);
    this.h = new PaintFlagsDrawFilter(0, 3);
    paramContext.recycle();
    if (Build.VERSION.SDK_INT <= 19) {
      setLayerType(1, null);
    }
  }
  
  private Bitmap a(Drawable paramDrawable)
  {
    int i1;
    int i2;
    if (paramDrawable != null)
    {
      if (Build.BRAND.contains("Meitu")) {
        return null;
      }
      if ((paramDrawable instanceof BitmapDrawable)) {
        return ((BitmapDrawable)paramDrawable).getBitmap();
      }
      i1 = paramDrawable.getIntrinsicWidth();
      i2 = paramDrawable.getIntrinsicHeight();
      if (i1 > 0) {
        if (i2 <= 0) {
          return null;
        }
      }
    }
    try
    {
      Bitmap localBitmap = Bitmap.createBitmap(i1, i2, Bitmap.Config.ARGB_8888);
      Canvas localCanvas = new Canvas(localBitmap);
      paramDrawable.setBounds(0, 0, i1, i2);
      paramDrawable.draw(localCanvas);
      return localBitmap;
    }
    catch (OutOfMemoryError|Exception paramDrawable) {}
    return null;
    return null;
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    this.a.reset();
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
      this.a.moveTo(b, f3);
      Path localPath = this.a;
      int i1 = b;
      localPath.cubicTo(i1, f1, f1, i1, f2, i1);
      localPath = this.a;
      f5 -= f1;
      i1 = b;
      localPath.cubicTo(f5, i1, paramInt1 - i1, f1, paramInt1 - i1, f3);
      localPath = this.a;
      i1 = b;
      float f6 = paramInt1 - i1;
      f4 -= f1;
      localPath.cubicTo(f6, f4, f5, paramInt2 - i1, f2, paramInt2 - i1);
      localPath = this.a;
      paramInt1 = b;
      localPath.cubicTo(f1, paramInt2 - paramInt1, paramInt1, f4, paramInt1, f3);
    }
  }
  
  private void b()
  {
    if (this.j == null) {
      try
      {
        if (this.j == null) {
          this.j = new SquareRoundImageView.ShaderHandler(Looper.getMainLooper(), this, null);
        }
        return;
      }
      finally {}
    }
  }
  
  private void c()
  {
    int i1 = getWidth() - getPaddingLeft() - getPaddingRight();
    int i2 = getHeight() - getPaddingTop() - getPaddingBottom();
    if ((i1 != this.m) || (i2 != this.n))
    {
      this.m = i1;
      this.n = i2;
      a(this.m, this.n);
      if (this.i != null) {
        e();
      }
    }
  }
  
  private void d()
  {
    Bitmap localBitmap = a(getDrawable());
    if (localBitmap != null)
    {
      this.i = new BitmapShader(localBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
      this.k = localBitmap.getWidth();
      this.l = localBitmap.getHeight();
      e();
    }
    else
    {
      this.i = null;
      this.k = 0;
      this.l = 0;
    }
    invalidate();
  }
  
  private void e()
  {
    Object localObject = this.g;
    if (localObject == null) {
      this.g = new Matrix();
    } else {
      ((Matrix)localObject).reset();
    }
    if ((this.k > 0) && (this.l > 0) && (this.m > 0) && (this.n > 0))
    {
      localObject = getScaleType();
      if (ImageView.ScaleType.FIT_XY == localObject)
      {
        this.g.setScale(this.m / this.k, this.n / this.l);
        return;
      }
      int i1 = this.k;
      int i2 = this.n;
      int i3 = this.m;
      int i4 = this.l;
      float f3 = 0.0F;
      float f1;
      float f2;
      if (i1 * i2 > i3 * i4)
      {
        f1 = i2 / i4;
        f3 = (i3 - i1 * f1) * 0.5F;
        f2 = 0.0F;
      }
      else
      {
        f1 = i3 / i1;
        f2 = (i2 - i4 * f1) * 0.5F;
      }
      this.g.setScale(f1, f1);
      this.g.postTranslate(Math.round(f3), Math.round(f2));
    }
  }
  
  public void a()
  {
    b();
    if (!this.j.hasMessages(1)) {
      this.j.sendEmptyMessage(1);
    }
  }
  
  public void invalidateDrawable(@NonNull Drawable paramDrawable)
  {
    super.invalidateDrawable(paramDrawable);
    a();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    Object localObject = this.a;
    if (localObject != null)
    {
      if (this.p) {
        paramCanvas.drawPath((Path)localObject, this.f);
      }
      localObject = this.i;
      if (localObject != null)
      {
        ((BitmapShader)localObject).setLocalMatrix(this.g);
        this.d.setShader(this.i);
        paramCanvas.translate(getPaddingLeft(), getPaddingTop());
        paramCanvas.drawPath(this.a, this.d);
      }
    }
    try
    {
      paramCanvas.setDrawFilter(this.h);
      paramCanvas.save();
      this.a.offset(getPaddingLeft(), getPaddingRight());
      paramCanvas.clipPath(this.a);
      super.onDraw(paramCanvas);
      this.a.offset(0 - getPaddingLeft(), 0 - getPaddingRight());
      paramCanvas.restore();
    }
    catch (Exception localException)
    {
      label155:
      break label155;
    }
    super.onDraw(paramCanvas);
    if (this.o)
    {
      localObject = this.e;
      if (localObject != null) {
        paramCanvas.drawPath(this.a, (Paint)localObject);
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
    this.p = paramBoolean;
    invalidate();
  }
  
  public void setDrawChecked(boolean paramBoolean)
  {
    this.o = paramBoolean;
    if ((this.o) && (this.e == null))
    {
      this.e = new Paint();
      this.e.setAntiAlias(true);
      this.e.setColor(Color.parseColor("#FFFFFF"));
      this.e.setStrokeWidth(this.c);
      this.e.setStyle(Paint.Style.STROKE);
    }
    invalidate();
  }
  
  public void setDrawShadowLayer()
  {
    this.d.setShadowLayer(10.0F, 15.0F, 15.0F, -7829368);
  }
  
  public void setImageDrawable(@Nullable Drawable paramDrawable)
  {
    super.setImageDrawable(paramDrawable);
    if (paramDrawable == null)
    {
      b();
      if (this.j.hasMessages(1)) {
        this.j.removeMessages(1);
      }
      this.i = null;
      this.l = 0;
      this.k = 0;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.videostory.capture.widgets.SquareRoundImageView
 * JD-Core Version:    0.7.0.1
 */