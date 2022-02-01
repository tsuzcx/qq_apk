package com.tencent.biz.pubaccount.weishi_new.view;

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
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.widget.ImageView.ScaleType;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.base.view.widget.ResizeURLImageView;

public class RoundImageView
  extends ResizeURLImageView
  implements Handler.Callback
{
  private static final ImageView.ScaleType a = ImageView.ScaleType.CENTER_CROP;
  private static final Bitmap.Config b = Bitmap.Config.ARGB_8888;
  private final RectF c = new RectF();
  private final RectF d = new RectF();
  private final Matrix e = new Matrix();
  private final Paint f = new Paint();
  private final Paint g = new Paint();
  private int h = 0;
  private int i = 0;
  private int j = 0;
  private Bitmap k;
  private BitmapShader l;
  private int m;
  private int n;
  private float o;
  private float p;
  private boolean q;
  private boolean r;
  private Handler s = new Handler(Looper.getMainLooper(), this);
  
  public RoundImageView(Context paramContext)
  {
    super(paramContext);
  }
  
  public RoundImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public RoundImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    super.setScaleType(a);
    this.q = true;
    if (this.r)
    {
      a();
      this.r = false;
    }
  }
  
  private Bitmap a(Drawable paramDrawable)
  {
    if (paramDrawable == null) {
      return null;
    }
    if ((paramDrawable instanceof BitmapDrawable))
    {
      Bitmap localBitmap = ((BitmapDrawable)paramDrawable).getBitmap();
      if ((localBitmap == null) || (localBitmap.isMutable())) {
        return localBitmap;
      }
    }
    try
    {
      if ((!(paramDrawable instanceof ColorDrawable)) && (paramDrawable.getIntrinsicWidth() != 0) && (paramDrawable.getIntrinsicHeight() != 0)) {
        return Bitmap.createBitmap(paramDrawable.getIntrinsicWidth(), paramDrawable.getIntrinsicHeight(), b);
      }
      paramDrawable = Bitmap.createBitmap(1, 1, b);
      return paramDrawable;
    }
    catch (OutOfMemoryError paramDrawable) {}
    return null;
  }
  
  private void a()
  {
    if (!this.q)
    {
      this.r = true;
      return;
    }
    Object localObject = this.k;
    if (localObject == null) {
      return;
    }
    this.l = new BitmapShader((Bitmap)localObject, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
    this.f.setAntiAlias(true);
    this.f.setShader(this.l);
    this.g.setStyle(Paint.Style.STROKE);
    this.g.setAntiAlias(true);
    this.g.setColor(this.h);
    this.g.setStrokeWidth(this.i);
    this.n = this.k.getHeight();
    this.m = this.k.getWidth();
    this.d.set(0.0F, 0.0F, getWidth(), getHeight());
    this.p = Math.min((this.d.height() - this.i) / 2.0F, (this.d.width() - this.i) / 2.0F);
    localObject = this.c;
    int i1 = this.i;
    ((RectF)localObject).set(i1, i1, this.d.width() - this.i, this.d.height() - this.i);
    this.o = (Math.min(this.c.height() / 2.0F, this.c.width() / 2.0F) - this.j);
    b();
    invalidate();
  }
  
  private void b()
  {
    this.e.set(null);
    float f1 = this.m;
    float f2 = this.c.height();
    float f4 = this.c.width();
    float f5 = this.n;
    float f3 = 0.0F;
    if (f1 * f2 > f4 * f5)
    {
      f1 = this.c.height() / this.n;
      f2 = (this.c.width() - this.m * f1) * 0.5F;
    }
    else
    {
      f1 = this.c.width() / this.m;
      f3 = (this.c.height() - this.n * f1) * 0.5F;
      f2 = 0.0F;
    }
    this.e.setScale(f1, f1);
    Matrix localMatrix = this.e;
    int i1 = (int)(f2 + 0.5F);
    int i2 = this.i;
    localMatrix.postTranslate(i1 + i2, (int)(f3 + 0.5F) + i2);
    this.l.setLocalMatrix(this.e);
  }
  
  private void setupBitmapFromDrawable(Drawable paramDrawable)
  {
    ThreadManager.post(new RoundImageView.1(this, paramDrawable), 8, null, true);
  }
  
  public int getBorderColor()
  {
    return this.h;
  }
  
  public int getBorderInnerPadding()
  {
    return this.j;
  }
  
  public int getBorderWidth()
  {
    return this.i;
  }
  
  public ImageView.ScaleType getScaleType()
  {
    return a;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage != null)
    {
      if (paramMessage.what != 101) {
        return false;
      }
      if ((paramMessage.obj instanceof RoundImageView.MsgBody))
      {
        Object localObject = (RoundImageView.MsgBody)paramMessage.obj;
        paramMessage = ((RoundImageView.MsgBody)localObject).a;
        localObject = ((RoundImageView.MsgBody)localObject).b;
        Canvas localCanvas = new Canvas(paramMessage);
        ((Drawable)localObject).setBounds(0, 0, localCanvas.getWidth(), localCanvas.getHeight());
        ((Drawable)localObject).draw(localCanvas);
        this.k = paramMessage;
        a();
      }
    }
    return false;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (getDrawable() == null) {
      return;
    }
    paramCanvas.drawCircle(getWidth() / 2, getHeight() / 2, this.o, this.f);
    paramCanvas.drawCircle(getWidth() / 2, getHeight() / 2, this.p, this.g);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    a();
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
  
  public void setBorderInnerPadding(int paramInt)
  {
    if (paramInt == this.j) {
      return;
    }
    this.j = paramInt;
    a();
  }
  
  public void setBorderWidth(int paramInt)
  {
    if (paramInt == this.i) {
      return;
    }
    this.i = paramInt;
    a();
  }
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    super.setImageBitmap(paramBitmap);
    this.k = paramBitmap;
    a();
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    super.setImageDrawable(paramDrawable);
    setupBitmapFromDrawable(paramDrawable);
  }
  
  public void setImageResource(int paramInt)
  {
    super.setImageResource(paramInt);
    setupBitmapFromDrawable(getDrawable());
  }
  
  public void setScaleType(ImageView.ScaleType paramScaleType)
  {
    if (paramScaleType == a) {
      return;
    }
    throw new IllegalArgumentException(String.format("ScaleType %s not supported.", new Object[] { paramScaleType }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.view.RoundImageView
 * JD-Core Version:    0.7.0.1
 */