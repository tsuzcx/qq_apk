package com.tencent.biz.qqstory.shareGroup.infocard.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView.ScaleType;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.qphone.base.util.QLog;

public class CircleImageView
  extends URLImageView
{
  private static final ImageView.ScaleType a = ImageView.ScaleType.CENTER_CROP;
  private static final Bitmap.Config b = Bitmap.Config.ARGB_8888;
  private final RectF c = new RectF();
  private final RectF d = new RectF();
  private final Matrix e = new Matrix();
  private final Paint f = new Paint();
  private final Paint g = new Paint();
  private int h = -1;
  private int i = -1;
  private Bitmap j;
  private BitmapShader k;
  private int l;
  private int m;
  private float n;
  private float o;
  private boolean p;
  private boolean q;
  
  public CircleImageView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public CircleImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public CircleImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
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
      Bitmap localBitmap;
      if ((paramDrawable instanceof ColorDrawable)) {
        localBitmap = Bitmap.createBitmap(1, 1, b);
      } else {
        localBitmap = Bitmap.createBitmap(paramDrawable.getIntrinsicWidth(), paramDrawable.getIntrinsicHeight(), b);
      }
      if (localBitmap == null)
      {
        if (QLog.isColorLevel())
        {
          QLog.e("CircleImageView", 2, "猜猜是不是魅族");
          return null;
        }
      }
      else
      {
        Canvas localCanvas = new Canvas(localBitmap);
        paramDrawable.setBounds(0, 0, localCanvas.getWidth(), localCanvas.getHeight());
        paramDrawable.draw(localCanvas);
        return localBitmap;
      }
    }
    catch (OutOfMemoryError paramDrawable)
    {
      return null;
    }
    return null;
  }
  
  private void c()
  {
    this.e.set(null);
    float f1 = this.l;
    float f2 = this.c.height();
    float f4 = this.c.width();
    float f5 = this.m;
    float f3 = 0.0F;
    if (f1 * f2 > f4 * f5)
    {
      f1 = this.c.height() / this.m;
      f2 = (this.c.width() - this.l * f1) * 0.5F;
    }
    else
    {
      f1 = this.c.width() / this.l;
      f3 = (this.c.height() - this.m * f1) * 0.5F;
      f2 = 0.0F;
    }
    this.e.setScale(f1, f1);
    Matrix localMatrix = this.e;
    int i1 = (int)(f2 + 0.5F);
    int i2 = this.i;
    localMatrix.postTranslate(i1 + i2, (int)(f3 + 0.5F) + i2);
    this.k.setLocalMatrix(this.e);
  }
  
  public void a()
  {
    this.p = true;
    if (this.q)
    {
      b();
      this.q = false;
    }
  }
  
  protected void b()
  {
    if (!this.p)
    {
      this.q = true;
      return;
    }
    if (this.j == null) {
      return;
    }
    if (this.i == -1) {
      this.i = AIOUtils.b(1.0F, getContext().getResources());
    }
    this.k = new BitmapShader(this.j, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
    this.f.setAntiAlias(true);
    this.f.setShader(this.k);
    this.g.setStyle(Paint.Style.STROKE);
    this.g.setAntiAlias(true);
    this.g.setColor(this.h);
    this.g.setStrokeWidth(this.i);
    this.m = this.j.getHeight();
    this.l = this.j.getWidth();
    this.d.set(0.0F, 0.0F, getWidth(), getHeight());
    this.o = Math.min((this.d.height() - this.i) / 2.0F, (this.d.width() - this.i) / 2.0F);
    RectF localRectF = this.c;
    int i1 = this.i;
    localRectF.set(i1, i1, this.d.width() - this.i, this.d.height() - this.i);
    this.n = Math.min(this.c.height() / 2.0F, this.c.width() / 2.0F);
    c();
    invalidate();
  }
  
  public ImageView.ScaleType getScaleType()
  {
    return a;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (getDrawable() == null) {
      return;
    }
    paramCanvas.drawCircle(getWidth() / 2, getHeight() / 2, this.n, this.f);
    paramCanvas.drawCircle(getWidth() / 2, getHeight() / 2, this.o, this.g);
  }
  
  @TargetApi(11)
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    if (QLog.isColorLevel()) {
      QLog.d("faceuu", 4, "onLoadSuccessed");
    }
    setImageDrawable(paramURLDrawable);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    b();
  }
  
  public void setBorderColor(int paramInt)
  {
    if (paramInt == this.h) {
      return;
    }
    this.h = paramInt;
    this.g.setColor(this.h);
    invalidate();
  }
  
  public void setBorderWidth(int paramInt)
  {
    if (paramInt == this.i) {
      return;
    }
    this.i = paramInt;
    b();
  }
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    super.setImageBitmap(paramBitmap);
    this.j = paramBitmap;
    b();
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    super.setImageDrawable(paramDrawable);
    this.j = a(paramDrawable);
    b();
  }
  
  public void setImageResource(int paramInt)
  {
    super.setImageResource(paramInt);
    this.j = a(getDrawable());
    b();
  }
  
  public void setScaleType(ImageView.ScaleType paramScaleType)
  {
    if (paramScaleType == a) {
      return;
    }
    throw new IllegalArgumentException(String.format("ScaleType %s not supported.", new Object[] { paramScaleType }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.shareGroup.infocard.view.CircleImageView
 * JD-Core Version:    0.7.0.1
 */