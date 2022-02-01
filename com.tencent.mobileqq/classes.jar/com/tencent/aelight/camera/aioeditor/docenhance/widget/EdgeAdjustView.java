package com.tencent.aelight.camera.aioeditor.docenhance.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.Nullable;
import com.tencent.biz.qqstory.utils.UIUtils;
import java.util.Arrays;

public class EdgeAdjustView
  extends View
{
  private Paint A = new Paint();
  private Matrix B = new Matrix();
  private int C;
  private float D = 1.538462F;
  private final float[] a = new float[8];
  private final float[] b = new float[8];
  private int c = -1;
  private EdgeAdjustView.InteractionListener d;
  private boolean e = true;
  private Bitmap f;
  private Path g = new Path();
  private Paint h = new Paint();
  private Paint i = new Paint();
  private int j;
  private int k;
  private int l;
  private int m;
  private final RectF n = new RectF();
  private final RectF o = new RectF();
  private int p = -2147483648;
  private int q = -16725252;
  private int r = -42646;
  private Drawable s;
  private Drawable t;
  private float u;
  private float v;
  private Canvas w;
  private Bitmap x;
  private int y;
  private BitmapShader z;
  
  public EdgeAdjustView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public EdgeAdjustView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  private void a()
  {
    setLayerType(1, null);
    this.j = UIUtils.a(getContext(), 100.0F);
    this.k = UIUtils.a(getContext(), 17.5F);
    this.l = UIUtils.a(getContext(), 18.0F);
    this.m = UIUtils.a(getContext(), 18.0F);
    this.y = UIUtils.a(getContext(), 50.0F);
    this.C = UIUtils.a(getContext(), 20.0F);
    this.s = getResources().getDrawable(2063925310);
    this.t = getResources().getDrawable(2063925309);
    this.h.setAntiAlias(true);
    this.h.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
    this.h.setStyle(Paint.Style.FILL);
    this.i.setAntiAlias(true);
    this.i.setStrokeWidth(3.0F);
    this.i.setStyle(Paint.Style.STROKE);
    this.A.setAntiAlias(true);
  }
  
  private void a(Canvas paramCanvas)
  {
    paramCanvas.drawColor(-16777216);
    Object localObject = this.f;
    if ((localObject != null) && (!((Bitmap)localObject).isRecycled())) {
      paramCanvas.drawBitmap(this.f, null, this.o, null);
    }
    int i1 = Build.VERSION.SDK_INT;
    int i2 = 0;
    if (i1 >= 21)
    {
      paramCanvas.saveLayer(0.0F, 0.0F, getWidth(), getHeight(), null);
      i1 = 1;
    }
    else
    {
      i1 = 0;
    }
    paramCanvas.drawColor(this.p);
    this.g.reset();
    localObject = this.g;
    float[] arrayOfFloat = this.b;
    ((Path)localObject).moveTo(arrayOfFloat[0], arrayOfFloat[1]);
    localObject = this.g;
    arrayOfFloat = this.b;
    ((Path)localObject).lineTo(arrayOfFloat[2], arrayOfFloat[3]);
    localObject = this.g;
    arrayOfFloat = this.b;
    ((Path)localObject).lineTo(arrayOfFloat[4], arrayOfFloat[5]);
    localObject = this.g;
    arrayOfFloat = this.b;
    ((Path)localObject).lineTo(arrayOfFloat[6], arrayOfFloat[7]);
    this.g.close();
    paramCanvas.drawPath(this.g, this.h);
    paramCanvas.drawPath(this.g, this.i);
    if (this.e) {
      localObject = this.s;
    } else {
      localObject = this.t;
    }
    if ((localObject != null) && (((Drawable)localObject).getIntrinsicWidth() > 0))
    {
      float f1 = ((Drawable)localObject).getIntrinsicWidth() / 2.0F;
      while (i2 < 4)
      {
        if (i2 != this.c)
        {
          arrayOfFloat = this.b;
          int i3 = i2 * 2;
          int i4 = (int)(arrayOfFloat[i3] - f1);
          int i5 = i3 + 1;
          ((Drawable)localObject).setBounds(i4, (int)(arrayOfFloat[i5] - f1), (int)(arrayOfFloat[i3] + f1), (int)(arrayOfFloat[i5] + f1));
          ((Drawable)localObject).draw(paramCanvas);
        }
        i2 += 1;
      }
    }
    if (i1 != 0) {
      paramCanvas.restore();
    }
  }
  
  private boolean a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    paramFloat1 -= paramFloat3;
    paramFloat2 -= paramFloat4;
    return Math.sqrt(paramFloat1 * paramFloat1 + paramFloat2 * paramFloat2) <= 100.0D;
  }
  
  private void b()
  {
    if (!this.o.isEmpty())
    {
      int i1 = 0;
      while (i1 < 4)
      {
        float[] arrayOfFloat = this.b;
        int i2 = i1 * 2;
        arrayOfFloat[i2] = (this.o.left + this.o.width() * this.a[i2]);
        arrayOfFloat = this.b;
        i2 += 1;
        arrayOfFloat[i2] = (this.o.top + this.o.height() * this.a[i2]);
        i1 += 1;
      }
    }
  }
  
  private void c()
  {
    if ((this.f != null) && (!this.n.isEmpty()))
    {
      if (this.f.getHeight() * 1.0F / this.f.getWidth() > this.n.height() * 1.0F / this.n.width())
      {
        f1 = this.n.height() / this.f.getHeight();
        f2 = this.f.getWidth();
        f1 = (this.n.width() - f2 * f1) / 2.0F;
        this.o.set(this.n.left + f1, this.n.top, this.n.right - f1, this.n.bottom);
        return;
      }
      float f1 = this.n.width() / this.f.getWidth();
      float f2 = this.f.getHeight();
      f1 = (this.n.height() - f2 * f1) / 2.0F;
      this.o.set(this.n.left, this.n.top + f1, this.n.right, this.n.bottom - f1);
    }
  }
  
  public float[] getAdjustPoints()
  {
    return Arrays.copyOf(this.a, 8);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    Bitmap localBitmap = this.x;
    if (localBitmap != null)
    {
      localBitmap.recycle();
      this.x = null;
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (this.e) {
      this.i.setColor(this.q);
    } else {
      this.i.setColor(this.r);
    }
    if (this.c != -1)
    {
      a(this.w);
      paramCanvas.drawBitmap(this.x, 0.0F, 0.0F, null);
      Object localObject = this.b;
      int i1 = this.c;
      float f1 = localObject[(i1 * 2)];
      float f2 = localObject[(i1 * 2 + 1)];
      float f3 = this.C;
      i1 = this.y;
      f3 = Math.max(f2 - f3 - i1, this.j - i1);
      this.B.reset();
      localObject = this.B;
      float f4 = this.D;
      ((Matrix)localObject).postScale(f4, f4);
      localObject = this.B;
      f4 = this.D;
      ((Matrix)localObject).postTranslate(f1 - f1 * f4, f3 - f2 * f4);
      this.z.setLocalMatrix(this.B);
      paramCanvas.drawCircle(f1, f3, this.y, this.A);
      this.i.setColor(-1);
      paramCanvas.drawCircle(f1, f3, this.y - 3, this.i);
      return;
    }
    a(paramCanvas);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.n.set(0.0F, 0.0F, paramInt1, paramInt2);
    Object localObject = this.n;
    ((RectF)localObject).top += this.j;
    localObject = this.n;
    ((RectF)localObject).bottom -= this.k;
    localObject = this.n;
    ((RectF)localObject).left += this.l;
    localObject = this.n;
    ((RectF)localObject).right -= this.m;
    c();
    b();
    localObject = this.x;
    if (localObject != null) {
      ((Bitmap)localObject).recycle();
    }
    this.x = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.RGB_565);
    this.w = new Canvas(this.x);
    this.z = new BitmapShader(this.x, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
    this.A.setShader(this.z);
    invalidate();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getPointerCount() > 1) {
      return true;
    }
    int i1 = paramMotionEvent.getActionMasked();
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    if (i1 != 0)
    {
      if (i1 != 1)
      {
        if (i1 != 2) {
          return true;
        }
        i1 = this.c;
        if (i1 != -1)
        {
          this.b[(i1 * 2)] = Math.min(Math.max(f1, this.o.left), this.o.right);
          this.b[(this.c * 2 + 1)] = Math.min(Math.max(f2, this.o.top), this.o.bottom);
          paramMotionEvent = this.a;
          i1 = this.c;
          paramMotionEvent[(i1 * 2)] = ((this.b[(i1 * 2)] - this.o.left) / this.o.width());
          paramMotionEvent = this.a;
          i1 = this.c;
          paramMotionEvent[(i1 * 2 + 1)] = ((this.b[(i1 * 2 + 1)] - this.o.top) / this.o.height());
          paramMotionEvent = this.d;
          if (paramMotionEvent != null)
          {
            this.e = paramMotionEvent.a(this.a);
            this.d.a(this.e);
          }
          invalidate();
        }
        this.u = f1;
        this.v = f2;
        return true;
      }
      if (this.c != -1)
      {
        paramMotionEvent = this.d;
        if (paramMotionEvent != null) {
          paramMotionEvent.b(this.e);
        }
        this.c = -1;
        invalidate();
        return true;
      }
    }
    else
    {
      this.c = -1;
      if (!this.o.isEmpty())
      {
        paramMotionEvent = this.b;
        if (a(paramMotionEvent[0], paramMotionEvent[1], f1, f2))
        {
          this.c = 0;
        }
        else
        {
          paramMotionEvent = this.b;
          if (a(paramMotionEvent[2], paramMotionEvent[3], f1, f2))
          {
            this.c = 1;
          }
          else
          {
            paramMotionEvent = this.b;
            if (a(paramMotionEvent[4], paramMotionEvent[5], f1, f2))
            {
              this.c = 2;
            }
            else
            {
              paramMotionEvent = this.b;
              if (a(paramMotionEvent[6], paramMotionEvent[7], f1, f2)) {
                this.c = 3;
              }
            }
          }
        }
      }
      this.u = f1;
      this.v = f2;
    }
    return true;
  }
  
  public void setAdjustPoints(float[] paramArrayOfFloat)
  {
    if (paramArrayOfFloat != null)
    {
      if (paramArrayOfFloat.length != 8) {
        return;
      }
      int i1 = 0;
      while (i1 < 8)
      {
        this.a[i1] = Math.min(Math.max(0.0F, paramArrayOfFloat[i1]), 1.0F);
        i1 += 1;
      }
      b();
      invalidate();
    }
  }
  
  public void setBitmap(Bitmap paramBitmap)
  {
    this.f = paramBitmap;
    c();
    b();
    invalidate();
  }
  
  public void setInteractionListener(EdgeAdjustView.InteractionListener paramInteractionListener)
  {
    this.d = paramInteractionListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.docenhance.widget.EdgeAdjustView
 * JD-Core Version:    0.7.0.1
 */