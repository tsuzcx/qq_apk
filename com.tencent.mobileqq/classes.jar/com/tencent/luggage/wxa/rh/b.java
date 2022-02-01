package com.tencent.luggage.wxa.rh;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.os.Build.VERSION;
import android.os.Looper;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import com.tencent.luggage.wxa.qz.o;

public class b
  extends FrameLayout
  implements c.a
{
  protected static final boolean b = c.a;
  private final Runnable a = new b.1(this);
  @Nullable
  private c c;
  @Nullable
  private Activity d;
  private Paint e;
  private volatile int f;
  private int g = 0;
  private int h = 0;
  private boolean i = false;
  private boolean j = false;
  private boolean k = false;
  private boolean l = false;
  private boolean m = false;
  private final int[] n = new int[2];
  private int o = 0;
  
  public b(@NonNull Context paramContext)
  {
    super(b.a.a(paramContext));
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      s_();
      if ((getContext() instanceof b.a)) {
        ((b.a)getContext()).a(new b.2(this));
      }
      return;
    }
    throw new RuntimeException("Should be called on main-thread");
  }
  
  private void a(@NonNull Canvas paramCanvas)
  {
    if ((this.f > 0) && (b) && (!this.i))
    {
      if (willNotDraw()) {
        return;
      }
      Paint localPaint = this.e;
      if (localPaint == null)
      {
        o.b("MicroMsg.DrawStatusBarFrameLayout", "drawStatusBarBackground NULL paint");
        return;
      }
      localPaint.setColor(this.g);
      paramCanvas.drawRect(0.0F, 0.0F, getWidth(), this.f, this.e);
    }
  }
  
  private void b()
  {
    c localc = this.c;
    if (localc == null) {
      return;
    }
    b_(localc.b());
  }
  
  private void b(int paramInt)
  {
    getLocationInWindow(this.n);
    this.o = this.n[1];
    if (o.c() <= 1) {
      o.e("MicroMsg.DrawStatusBarFrameLayout", "applyStatusBarHeight height[%d] mFrozen[%b] mLocationInWindow[%d.%d]", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(this.j), Integer.valueOf(this.n[0]), Integer.valueOf(this.n[1]) });
    }
    this.f = Math.max(0, paramInt - this.n[1]);
    if (this.j)
    {
      this.l = true;
      return;
    }
    try
    {
      if (this.i) {
        paramInt = 0;
      } else {
        paramInt = this.f;
      }
      setPadding(0, paramInt, 0, 0);
    }
    catch (IllegalStateException localIllegalStateException)
    {
      o.c("MicroMsg.DrawStatusBarFrameLayout", "applyStatusBarHeight setPadding e=%s", new Object[] { localIllegalStateException.getMessage() });
    }
    if (isLayoutRequested()) {
      d();
    }
  }
  
  private void b(@NonNull Canvas paramCanvas)
  {
    if ((this.f > 0) && (b) && (this.i))
    {
      if (willNotDraw()) {
        return;
      }
      Paint localPaint = this.e;
      if (localPaint == null)
      {
        o.b("MicroMsg.DrawStatusBarFrameLayout", "drawStatusBarForeground NULL paint");
        return;
      }
      localPaint.setColor(this.h);
      paramCanvas.drawRect(0.0F, 0.0F, getWidth(), this.f, this.e);
    }
  }
  
  private void d()
  {
    if (e())
    {
      invalidate();
      return;
    }
    postInvalidate();
  }
  
  private boolean e()
  {
    return Looper.getMainLooper() == Looper.myLooper();
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    a(paramInt, paramBoolean, true);
  }
  
  public void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i2 = this.g;
    int i3 = this.h;
    this.g = paramInt;
    if (b)
    {
      Object localObject = this.d;
      if (localObject == null) {
        return;
      }
      localObject = ((Activity)localObject).getWindow();
      d.d((Window)localObject);
      if (paramBoolean2 ? d.c((Window)localObject, paramBoolean1) : d.a())
      {
        this.g = paramInt;
        this.h = 0;
      }
      else if (Build.VERSION.SDK_INT >= 21)
      {
        int i1 = paramInt;
        if (paramBoolean1) {
          i1 = d.a(paramInt, -16777216, 0.78F);
        }
        this.g = i1;
        if (paramBoolean1) {
          paramInt = Color.argb(51, 0, 0, 0);
        } else {
          paramInt = 0;
        }
        this.h = paramInt;
      }
      if ((this.g == 0) && (this.h == 0))
      {
        super.setWillNotDraw(true);
        d();
        return;
      }
      if ((i2 != this.g) || (i3 != this.h))
      {
        super.setWillNotDraw(false);
        d();
      }
    }
  }
  
  public void b_(int paramInt)
  {
    b(paramInt);
  }
  
  public final boolean c()
  {
    return this.j;
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    a(paramCanvas);
    super.dispatchDraw(paramCanvas);
    b(paramCanvas);
  }
  
  public void dispatchSystemUiVisibilityChanged(int paramInt)
  {
    super.dispatchSystemUiVisibilityChanged(paramInt);
    b();
  }
  
  public int getDrawnStatusBarHeight()
  {
    return Math.max(0, this.f);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    b();
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if ((this.c != null) && (!this.j))
    {
      getLocationInWindow(this.n);
      if (this.o != this.n[1]) {
        this.c.a();
      }
      this.o = this.n[1];
    }
  }
  
  public void requestLayout()
  {
    if (this.j)
    {
      this.m = true;
      return;
    }
    super.requestLayout();
  }
  
  @UiThread
  protected void s_()
  {
    if (!b)
    {
      this.d = null;
      this.e = null;
      return;
    }
    setPadding(0, 0, 0, 0);
    this.f = 0;
    Object localObject = this.c;
    if (localObject != null) {
      ((c)localObject).b(this);
    }
    this.d = d.a(getContext());
    localObject = this.d;
    if (localObject == null)
    {
      this.e = null;
      super.setWillNotDraw(true);
      return;
    }
    localObject = c.a((Activity)localObject);
    this.c = ((c)localObject);
    ((c)localObject).a(this);
    this.e = new Paint(0);
    this.e.setStyle(Paint.Style.FILL);
    super.setWillNotDraw(false);
  }
  
  @SuppressLint({"WrongThread"})
  @AnyThread
  public final void setLayoutFrozen(boolean paramBoolean)
  {
    if (!e())
    {
      post(new b.3(this, paramBoolean));
      return;
    }
    boolean bool = this.j;
    int i1 = 1;
    o.e("MicroMsg.DrawStatusBarFrameLayout", "setLayoutFrozen frozen[%b], mFrozen[%b], mDeferLayout[%b], mDeferInvalidate[%b], mReInitializeDeferred[%b]", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(bool), Boolean.valueOf(this.m), Boolean.valueOf(this.l), Boolean.valueOf(this.k) });
    if (paramBoolean == this.j) {
      i1 = 0;
    }
    this.j = paramBoolean;
    if ((i1 != 0) && (!paramBoolean))
    {
      if (this.k)
      {
        s_();
        this.k = false;
      }
      if ((this.m) || (this.l))
      {
        b(this.f);
        this.m = false;
        this.l = false;
      }
    }
  }
  
  public void setStatusBarColor(int paramInt)
  {
    if (!b) {
      return;
    }
    a(paramInt, d.a(this.d));
  }
  
  public final void setWillNotDraw(boolean paramBoolean) {}
  
  public final boolean willNotDraw()
  {
    return super.willNotDraw();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.rh.b
 * JD-Core Version:    0.7.0.1
 */