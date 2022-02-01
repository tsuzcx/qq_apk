package com.tencent.mm.picker.base.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Rect;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.animation.AccelerateInterpolator;
import com.tencent.luggage.wxa.io.c;
import com.tencent.luggage.wxa.io.d;
import com.tencent.luggage.wxa.io.e;
import com.tencent.mm.ui.f;
import java.util.concurrent.Future;

public class WheelView
  extends View
{
  private int A;
  private int B;
  private int C;
  private int D = 5;
  private int E;
  private int F;
  private int G = 0;
  private float H = 0.0F;
  private long I = 0L;
  private int J;
  private int K = 17;
  private int L = 0;
  private Context M;
  private Rect N = new Rect();
  String a = "";
  private int b = 0;
  private int c = Color.rgb(255, 255, 255);
  private int d;
  private final int e = 2;
  private Handler f;
  private GestureDetector g;
  private com.tencent.luggage.wxa.in.b h;
  private boolean i = false;
  private boolean j = true;
  private final com.tencent.luggage.wxa.io.b k = com.tencent.luggage.wxa.iq.a.a();
  private Future<?> l;
  private Paint m;
  private Paint n;
  private com.tencent.luggage.wxa.im.b<?> o;
  private String p;
  private int q;
  private int r;
  private float s;
  private int t;
  private boolean u;
  private boolean v;
  private boolean w;
  private float x;
  private float y;
  private float z;
  
  public WheelView(Context paramContext)
  {
    this(paramContext, null);
    this.M = paramContext;
  }
  
  public WheelView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.M = paramContext;
    this.q = getResources().getDimensionPixelSize(2131298216);
    this.r = getResources().getDimensionPixelSize(2131298215);
    this.K = 17;
    this.t = -2763307;
    a(paramContext);
  }
  
  private String a(Object paramObject)
  {
    if (paramObject == null) {
      return "";
    }
    return paramObject.toString();
  }
  
  private void a(Context paramContext)
  {
    this.f = new d(this);
    this.g = new GestureDetector(paramContext, new com.tencent.luggage.wxa.in.a(this));
    this.g.setIsLongpressEnabled(false);
    this.u = true;
    this.z = 0.0F;
    this.A = -1;
    e();
  }
  
  private float b(float paramFloat)
  {
    Paint.FontMetricsInt localFontMetricsInt = this.m.getFontMetricsInt();
    float f1 = Math.abs(localFontMetricsInt.top);
    float f2 = localFontMetricsInt.bottom;
    return paramFloat - f2 + (f1 + f2) / 2.0F;
  }
  
  private int c(float paramFloat)
  {
    float f1 = this.E / 2.0F;
    paramFloat = Math.abs((paramFloat - f1) / f1);
    paramFloat = new AccelerateInterpolator(0.3F).getInterpolation(paramFloat);
    int i1 = this.d;
    int i2 = (int)(i1 * (1.0F - paramFloat));
    if (i2 < i1 * 0.14F) {
      return (int)(i1 * 0.14F);
    }
    if (i2 > i1) {
      return i1;
    }
    return i2;
  }
  
  private String c(int paramInt)
  {
    int i1 = paramInt;
    if (this.u) {
      i1 = d(paramInt);
    }
    return this.o.b(i1);
  }
  
  private int d(int paramInt)
  {
    int i2 = this.o.a();
    if (i2 == 0) {
      return i2;
    }
    int i1 = paramInt % i2;
    paramInt = i1;
    if (i1 < 0) {
      paramInt = i1 + i2;
    }
    return paramInt;
  }
  
  private void e()
  {
    this.m = new Paint();
    this.m.setColor(this.c);
    this.m.setAntiAlias(true);
    this.m.setTextSize(this.q);
    this.n = new Paint();
    this.n.setColor(this.t);
    this.n.setAntiAlias(true);
    setLayerType(2, null);
  }
  
  private void f()
  {
    if (this.o == null) {
      return;
    }
    g();
    this.E = ((int)(this.s * this.D));
    this.F = View.MeasureSpec.getSize(this.J);
    int i1 = this.E;
    float f1 = i1;
    float f2 = this.s;
    this.x = ((f1 - f2) / 2.0F);
    this.y = ((i1 + f2) / 2.0F);
    if (this.A == -1) {
      if (this.u) {
        this.A = ((this.o.a() + 1) / 2);
      } else {
        this.A = 0;
      }
    }
    this.C = this.A;
  }
  
  private void g()
  {
    this.s = (this.b + getPaddingBottom() + getPaddingTop());
  }
  
  private void h()
  {
    String str = a(c(getCurrentItem()));
    if (!TextUtils.isEmpty(str)) {
      setContentDescription(str);
    }
  }
  
  private void i()
  {
    Object localObject = this.m;
    String str = this.a;
    ((Paint)localObject).getTextBounds(str, 0, str.length(), this.N);
    int i1 = this.K;
    if (i1 != 3)
    {
      if (i1 != 5)
      {
        if (i1 != 17) {
          return;
        }
        if (!this.i)
        {
          localObject = this.p;
          if ((localObject != null) && (!((String)localObject).equals("")) && (this.j))
          {
            d1 = this.F - this.N.width();
            Double.isNaN(d1);
            this.L = ((int)(d1 * 0.25D));
            return;
          }
        }
        if (this.F < this.N.width())
        {
          k();
          if (!l()) {
            j();
          }
          localObject = this.m;
          str = this.a;
          ((Paint)localObject).getTextBounds(str, 0, str.length(), this.N);
          d1 = this.F - this.N.width();
          Double.isNaN(d1);
          this.L = ((int)(d1 * 0.5D));
          return;
        }
        double d1 = this.F - this.N.width();
        Double.isNaN(d1);
        this.L = ((int)(d1 * 0.5D));
        return;
      }
      this.L = (this.F - this.N.width());
      return;
    }
    this.L = 0;
  }
  
  private void j()
  {
    Object localObject1 = new Rect();
    Object localObject2 = this.m;
    String str = this.a;
    ((Paint)localObject2).getTextBounds(str, 0, str.length(), (Rect)localObject1);
    localObject1 = new Rect();
    this.m.getTextBounds(this.a, 0, 0, (Rect)localObject1);
    int i2 = this.a.length();
    int i1 = 0;
    for (;;)
    {
      int i3 = i2 - i1;
      if (i3 <= 1) {
        break;
      }
      localObject1 = new Rect();
      i3 = (i3 >> 1) + i1;
      this.m.getTextBounds(this.a, 0, i3, (Rect)localObject1);
      if (((Rect)localObject1).width() >= c()) {
        i2 = i3 - 1;
      } else if (((Rect)localObject1).width() < c()) {
        i1 = i3 + 1;
      }
    }
    for (this.a = this.a.substring(0, i1);; this.a = this.a.substring(0, i1))
    {
      localObject1 = this.m;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(this.a);
      ((StringBuilder)localObject2).append("...");
      if (((Paint)localObject1).measureText(((StringBuilder)localObject2).toString()) <= c()) {
        break;
      }
      i1 -= 1;
      if (i1 <= 0) {
        break;
      }
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(this.a);
    ((StringBuilder)localObject1).append("...");
    this.a = ((StringBuilder)localObject1).toString();
  }
  
  private void k()
  {
    int i1 = this.q;
    this.m.setTextSize(i1);
    while ((i1 > this.r) && (!l()))
    {
      i1 -= 1;
      this.m.setTextSize(i1);
    }
  }
  
  private boolean l()
  {
    return this.m.measureText(this.a) <= this.F - getPaddingLeft() - getPaddingRight();
  }
  
  public WheelView a(int paramInt)
  {
    this.b = paramInt;
    invalidate();
    return this;
  }
  
  public void a()
  {
    Future localFuture = this.l;
    if ((localFuture != null) && (!localFuture.isCancelled()))
    {
      this.l.cancel(true);
      this.l = null;
    }
  }
  
  public final void a(float paramFloat)
  {
    a();
    this.l = this.k.a(new c(this, paramFloat), 0L, 5L);
  }
  
  public void a(WheelView.a parama)
  {
    a();
    if ((parama == WheelView.a.b) || (parama == WheelView.a.c))
    {
      float f1 = this.z;
      float f2 = this.s;
      this.G = ((int)((f1 % f2 + f2) % f2));
      int i1 = this.G;
      if (i1 > f2 / 2.0F) {
        this.G = ((int)(f2 - i1));
      } else {
        this.G = (-i1);
      }
    }
    this.l = this.k.a(new e(this, this.G), 0L, 10L);
  }
  
  public void a(boolean paramBoolean)
  {
    this.j = paramBoolean;
  }
  
  public WheelView b(int paramInt)
  {
    this.c = paramInt;
    this.m.setColor(this.c);
    this.d = ((int)((paramInt >> 24 & 0xFF) / 255.0F * 255.0F));
    return this;
  }
  
  public final void b()
  {
    h();
    if (this.h != null) {
      postDelayed(new WheelView.1(this), 200L);
    }
  }
  
  public int c()
  {
    return this.F - getPaddingLeft() - getPaddingRight();
  }
  
  public boolean d()
  {
    return this.u;
  }
  
  public final com.tencent.luggage.wxa.im.b getAdapter()
  {
    return this.o;
  }
  
  public final int getCurrentItem()
  {
    if (this.o == null) {
      return 0;
    }
    if ((this.v) && (this.B == 0)) {
      return -1;
    }
    if (this.u)
    {
      int i1 = this.B;
      if ((i1 < 0) || (i1 >= this.o.a())) {
        return Math.max(0, Math.min(Math.abs(Math.abs(this.B) - this.o.a()), this.o.a() - 1));
      }
    }
    return Math.max(0, Math.min(this.B, this.o.a() - 1));
  }
  
  public Handler getHandler()
  {
    return this.f;
  }
  
  public int getInitPosition()
  {
    return this.A;
  }
  
  public float getItemHeight()
  {
    return this.s;
  }
  
  public int getItemsCount()
  {
    com.tencent.luggage.wxa.im.b localb = this.o;
    if (localb != null) {
      return localb.a();
    }
    return 0;
  }
  
  public float getTotalScrollY()
  {
    return this.z;
  }
  
  @SuppressLint({"DrawAllocation"})
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.o == null) {
      return;
    }
    int i1 = this.A;
    int i2 = 0;
    this.A = Math.min(Math.max(0, i1), this.o.a() - 1);
    Object[] arrayOfObject = new Object[this.D];
    Object localObject2 = new Object();
    Object localObject1 = new Object();
    i1 = (int)(this.z / this.s);
    try
    {
      this.C = (this.A + i1 % this.o.a());
    }
    catch (ArithmeticException localArithmeticException)
    {
      label109:
      float f1;
      float f2;
      float f3;
      break label109;
    }
    f.e("WheelView", "出错了！adapter.getItemsCount() == 0，联动数据不匹配", new Object[0]);
    if (!this.u)
    {
      if (this.C < 0) {
        this.C = 0;
      }
      if (this.C > this.o.a() - 1) {
        this.C = (this.o.a() - 1);
      }
    }
    else
    {
      if (this.C < 0) {
        this.C = (this.o.a() + this.C);
      }
      if (this.C > this.o.a() - 1) {
        this.C -= this.o.a();
      }
    }
    f1 = this.z;
    f2 = this.s;
    i1 = 0;
    for (;;)
    {
      int i3 = this.D;
      if (i1 >= i3) {
        break;
      }
      i3 = this.C - (i3 / 2 - i1);
      if (i1 == 0) {
        localObject2 = c(i3 - 1);
      }
      if (i1 == this.D - 1) {
        localObject1 = c(i3 + 1);
      }
      arrayOfObject[i1] = c(i3);
      i1 += 1;
    }
    f3 = this.x;
    paramCanvas.drawLine(0.0F, f3, this.F, f3, this.n);
    f3 = this.y;
    paramCanvas.drawLine(0.0F, f3, this.F, f3, this.n);
    i1 = i2;
    for (;;)
    {
      i2 = this.D;
      if (i1 >= i2 + 2) {
        break;
      }
      Object localObject3;
      if (i1 == 0) {
        localObject3 = localObject2;
      } else if (i1 == i2 + 2 - 1) {
        localObject3 = localObject1;
      } else {
        localObject3 = arrayOfObject[(i1 - 1)];
      }
      f3 = this.s;
      f3 = i1 * f3 - f1 % f2 + f3 / 2.0F - f3;
      if ((!this.j) && (!TextUtils.isEmpty(this.p)) && (!TextUtils.isEmpty(a(localObject3))))
      {
        if ((this.v) && (localObject3.equals(this.M.getString(2131892602))))
        {
          this.a = a(localObject3);
        }
        else
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(a(localObject3));
          localStringBuilder.append(this.p);
          this.a = localStringBuilder.toString();
        }
      }
      else {
        this.a = a(localObject3);
      }
      i();
      i2 = c(f3);
      this.m.setAlpha(i2);
      if ((f3 >= this.x) && (f3 <= this.y)) {
        this.B = (this.C - (this.D / 2 - i1) - 1);
      }
      if ((f3 >= 0.0F) && (f3 <= this.E)) {
        paramCanvas.drawText(this.a, this.L, b(f3), this.m);
      }
      i1 += 1;
      this.m.setTextSize(this.q);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    this.J = paramInt1;
    f();
    setMeasuredDimension(this.F, this.E);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = this.g.onTouchEvent(paramMotionEvent);
    float f1 = -this.A;
    float f2 = this.s;
    float f3 = this.o.a() - 1 - this.A;
    float f4 = this.s;
    int i1 = paramMotionEvent.getAction();
    int i2 = 0;
    if (i1 != 0)
    {
      if (i1 != 2)
      {
        i1 = i2;
        if (!bool) {
          if (System.currentTimeMillis() - this.I > 120L)
          {
            a(WheelView.a.c);
            i1 = i2;
          }
          else
          {
            i1 = (int)(paramMotionEvent.getY() - this.E / 2.0F);
            if (i1 > 0) {
              f1 = i1 + this.s / 2.0F;
            } else {
              f1 = i1 - this.s / 2.0F;
            }
            i1 = (int)f1;
            f1 = this.s;
            if (f1 == 0.0F)
            {
              i1 = i2;
            }
            else
            {
              this.G = ((int)((int)(i1 / f1) * f1));
              a(WheelView.a.a);
              i1 = i2;
            }
          }
        }
      }
      else
      {
        float f5 = this.H - paramMotionEvent.getRawY();
        this.H = paramMotionEvent.getRawY();
        this.z += f5;
        i1 = i2;
        if (!this.u) {
          if ((this.z - this.s * 0.25F >= f1 * f2) || (f5 >= 0.0F))
          {
            i1 = i2;
            if (this.z + this.s * 0.25F > f3 * f4)
            {
              i1 = i2;
              if (f5 <= 0.0F) {}
            }
          }
          else
          {
            this.z -= f5;
            i1 = 1;
          }
        }
      }
    }
    else
    {
      this.I = System.currentTimeMillis();
      a();
      this.H = paramMotionEvent.getRawY();
      i1 = i2;
    }
    if ((i1 == 0) && (paramMotionEvent.getAction() != 0)) {
      invalidate();
    }
    return true;
  }
  
  public final void setAdapter(com.tencent.luggage.wxa.im.b<?> paramb)
  {
    this.o = paramb;
    f();
    invalidate();
  }
  
  public final void setCurrentItem(int paramInt)
  {
    this.B = paramInt;
    this.A = paramInt;
    this.z = 0.0F;
    h();
    invalidate();
  }
  
  public final void setCyclic(boolean paramBoolean)
  {
    this.u = paramBoolean;
  }
  
  public void setDividerColor(int paramInt)
  {
    if (paramInt != 0)
    {
      this.t = paramInt;
      this.n.setColor(this.t);
    }
  }
  
  public void setDividerHeight(float paramFloat)
  {
    this.n.setStrokeWidth(paramFloat);
  }
  
  public void setGravity(int paramInt)
  {
    this.K = paramInt;
  }
  
  public void setIsOptions(boolean paramBoolean)
  {
    this.i = paramBoolean;
  }
  
  public void setLabel(String paramString)
  {
    this.p = paramString;
  }
  
  public void setLongTermMonthDay(boolean paramBoolean)
  {
    this.w = paramBoolean;
  }
  
  public void setLongTermYear(boolean paramBoolean)
  {
    this.v = paramBoolean;
  }
  
  public final void setOnItemSelectedListener(com.tencent.luggage.wxa.in.b paramb)
  {
    this.h = paramb;
  }
  
  public void setTotalScrollY(float paramFloat)
  {
    this.z = paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.picker.base.view.WheelView
 * JD-Core Version:    0.7.0.1
 */