package com.tencent.mobileqq.activity.aio.item;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qqcommon.api.IHapticManagerApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;
import mqq.os.MqqHandler;

public class CustomFrameAnimationDrawable
  extends Drawable
  implements Runnable
{
  ArrayList<Bitmap> a;
  public CustomFrameAnimationDrawable.FrameAnimationState b;
  Resources c = null;
  Rect d = new Rect();
  RectF e = new RectF();
  Bitmap f = null;
  MqqHandler g;
  CustomFrameAnimationDrawable.DecodeRunnable h = null;
  CustomFrameAnimationDrawable.AnimationEndListener i = null;
  private String j;
  private int k;
  private int l = 160;
  private int m;
  private int n;
  private CustomFrameAnimationDrawable.FrameListener o = null;
  private boolean p = false;
  private boolean q = true;
  private boolean r;
  private CustomFrameAnimationDrawable.KeyGenerator s;
  private boolean t = true;
  private int u;
  private boolean v;
  private Vector<Bitmap> w;
  
  public CustomFrameAnimationDrawable(Resources paramResources, Bitmap paramBitmap, MqqHandler paramMqqHandler)
  {
    this.g = paramMqqHandler;
    this.f = paramBitmap;
    this.a = null;
    this.c = paramResources;
    this.a = null;
    this.b = new CustomFrameAnimationDrawable.FrameAnimationState();
    this.w = new Vector();
    if (paramResources != null)
    {
      int i2 = paramResources.getDisplayMetrics().densityDpi;
      i1 = i2;
      if (i2 == 0) {
        i1 = 160;
      }
      this.l = i1;
    }
    else
    {
      this.l = this.b.e;
    }
    paramResources = this.b;
    int i1 = this.l;
    paramResources.e = i1;
    if (paramBitmap != null)
    {
      this.m = paramBitmap.getScaledWidth(i1);
      this.n = paramBitmap.getScaledHeight(this.l);
      return;
    }
    this.n = -1;
    this.m = -1;
  }
  
  public CustomFrameAnimationDrawable(Resources paramResources, Bitmap paramBitmap, MqqHandler paramMqqHandler, CustomFrameAnimationDrawable.FrameAnimationState paramFrameAnimationState, String paramString, boolean paramBoolean)
  {
    this(paramResources, paramBitmap, paramMqqHandler);
    this.b = paramFrameAnimationState;
    this.j = paramString;
    this.p = paramBoolean;
    if ((this.j != null) && (this.p)) {
      ThreadManager.postImmediately(new CustomFrameAnimationDrawable.1(this), null, true);
    }
  }
  
  private CustomFrameAnimationDrawable(CustomFrameAnimationDrawable.FrameAnimationState paramFrameAnimationState, Resources paramResources)
  {
    this.b = paramFrameAnimationState;
    a(paramResources);
  }
  
  private void a(int paramInt, long paramLong)
  {
    if (paramInt < this.b.b.size())
    {
      if (paramInt - this.b.j < 2)
      {
        localObject = (CustomFrameAnimationDrawable.OneFrame)this.b.b.get(paramInt);
        if (this.h == null)
        {
          this.h = new CustomFrameAnimationDrawable.DecodeRunnable(this, paramInt, ((CustomFrameAnimationDrawable.OneFrame)localObject).c, ((CustomFrameAnimationDrawable.OneFrame)localObject).d, this.b.f);
          this.h.a(this.c);
          localObject = this.g;
          if (localObject != null) {
            ((MqqHandler)localObject).post(this.h);
          }
          localObject = this.b;
          ((CustomFrameAnimationDrawable.FrameAnimationState)localObject).j += 1;
          if (!this.b.i)
          {
            localObject = this.b;
            ((CustomFrameAnimationDrawable.FrameAnimationState)localObject).j %= this.b.b.size();
          }
        }
      }
      localObject = (CustomFrameAnimationDrawable.OneFrame)this.b.b.get(this.b.c);
      if (paramLong == 0L) {
        paramLong = SystemClock.uptimeMillis() + ((CustomFrameAnimationDrawable.OneFrame)localObject).b;
      } else {
        paramLong += SystemClock.uptimeMillis();
      }
      scheduleSelf(this, paramLong);
      if ((this.j != null) && (this.p)) {
        ((IHapticManagerApi)QRoute.api(IHapticManagerApi.class)).update(this.k, this.b.c * ((CustomFrameAnimationDrawable.OneFrame)localObject).b);
      }
      return;
    }
    Object localObject = this.i;
    if (localObject != null) {
      ((CustomFrameAnimationDrawable.AnimationEndListener)localObject).a();
    }
    if (this.q)
    {
      m();
      this.b.b.clear();
    }
    localObject = this.b;
    ((CustomFrameAnimationDrawable.FrameAnimationState)localObject).d = false;
    ((CustomFrameAnimationDrawable.FrameAnimationState)localObject).h = true;
  }
  
  private void a(Resources paramResources)
  {
    if (paramResources != null)
    {
      int i2 = paramResources.getDisplayMetrics().densityDpi;
      int i1 = i2;
      if (i2 == 0) {
        i1 = 160;
      }
      this.l = i1;
    }
    else
    {
      this.l = this.b.e;
    }
    q();
  }
  
  public static boolean p()
  {
    return (!Build.VERSION.RELEASE.equals("5.0.2")) || ((!Build.MODEL.equals("SM-A5009")) && (!Build.MODEL.equals("SM-A7000")) && (!Build.MODEL.equals("Redmi Note 2")));
  }
  
  private void q()
  {
    Object localObject = this.a;
    if (localObject != null)
    {
      if (((ArrayList)localObject).size() == 0) {
        localObject = null;
      } else {
        localObject = (Bitmap)this.a.get(0);
      }
      if (localObject != null)
      {
        this.m = ((Bitmap)localObject).getScaledWidth(this.l);
        this.n = ((Bitmap)localObject).getScaledHeight(this.l);
        return;
      }
      this.n = -1;
      this.m = -1;
    }
  }
  
  private void r()
  {
    Object localObject = h();
    if (localObject != null)
    {
      Bitmap localBitmap = this.f;
      if ((!this.r) && (this.w.size() <= 2)) {
        this.w.add(localBitmap);
      }
      this.f = ((Bitmap)localObject);
      localObject = this.b;
      ((CustomFrameAnimationDrawable.FrameAnimationState)localObject).c += 1;
      if (!this.b.i)
      {
        localObject = this.b;
        ((CustomFrameAnimationDrawable.FrameAnimationState)localObject).c %= this.b.b.size();
      }
      localObject = this.o;
      if (localObject != null) {
        ((CustomFrameAnimationDrawable.FrameListener)localObject).onUpdate(this.b.c);
      }
      invalidateSelf();
    }
    int i2 = this.b.j + 1;
    long l1 = 0L;
    int i1 = i2;
    long l2 = l1;
    if (!this.b.i)
    {
      if (i2 >= this.b.b.size()) {
        l1 = this.u;
      }
      i1 = i2 % this.b.b.size();
      l2 = l1;
    }
    a(i1, l2);
  }
  
  private void s()
  {
    Object localObject;
    if (this.b.i)
    {
      if (this.b.c < this.b.b.size())
      {
        invalidateSelf();
        localObject = this.o;
        if (localObject != null) {
          ((CustomFrameAnimationDrawable.FrameListener)localObject).onUpdate(this.b.c);
        }
        localObject = (CustomFrameAnimationDrawable.OneFrame)this.b.b.get(this.b.c);
        scheduleSelf(this, SystemClock.uptimeMillis() + ((CustomFrameAnimationDrawable.OneFrame)localObject).b);
        localObject = this.b;
        ((CustomFrameAnimationDrawable.FrameAnimationState)localObject).c += 1;
        return;
      }
      if (!this.b.h)
      {
        localObject = this.i;
        if (localObject != null) {
          ((CustomFrameAnimationDrawable.AnimationEndListener)localObject).a();
        }
        localObject = this.b;
        ((CustomFrameAnimationDrawable.FrameAnimationState)localObject).d = false;
        ((CustomFrameAnimationDrawable.FrameAnimationState)localObject).h = true;
        if (this.j != null)
        {
          if (this.p) {
            ((IHapticManagerApi)QRoute.api(IHapticManagerApi.class)).stopEffect(this.k);
          }
          this.k = 0;
        }
      }
    }
    else
    {
      localObject = this.b;
      ((CustomFrameAnimationDrawable.FrameAnimationState)localObject).c %= this.b.b.size();
      invalidateSelf();
      localObject = this.o;
      if (localObject != null) {
        ((CustomFrameAnimationDrawable.FrameListener)localObject).onUpdate(this.b.c);
      }
      localObject = (CustomFrameAnimationDrawable.OneFrame)this.b.b.get(this.b.c);
      scheduleSelf(this, SystemClock.uptimeMillis() + ((CustomFrameAnimationDrawable.OneFrame)localObject).b);
      localObject = this.b;
      ((CustomFrameAnimationDrawable.FrameAnimationState)localObject).c += 1;
    }
  }
  
  public void a()
  {
    this.q = false;
  }
  
  public void a(int paramInt)
  {
    this.b.k = paramInt;
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    CustomFrameAnimationDrawable.OneFrame localOneFrame = new CustomFrameAnimationDrawable.OneFrame();
    localOneFrame.a = paramInt1;
    localOneFrame.b = paramInt2;
    localOneFrame.d = paramInt3;
    localOneFrame.c = null;
    this.b.b.add(localOneFrame);
  }
  
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    CustomFrameAnimationDrawable.OneFrame localOneFrame = new CustomFrameAnimationDrawable.OneFrame();
    localOneFrame.a = paramInt1;
    localOneFrame.b = paramInt2;
    localOneFrame.c = paramString;
    localOneFrame.d = 0;
    this.b.b.add(localOneFrame);
  }
  
  public void a(Bitmap paramBitmap)
  {
    this.f = paramBitmap;
  }
  
  public void a(CustomFrameAnimationDrawable.AnimationEndListener paramAnimationEndListener)
  {
    this.i = paramAnimationEndListener;
  }
  
  public void a(CustomFrameAnimationDrawable.FrameListener paramFrameListener)
  {
    this.o = paramFrameListener;
  }
  
  public void a(boolean paramBoolean)
  {
    this.b.g = paramBoolean;
  }
  
  public void b()
  {
    this.b.g = true;
  }
  
  public void b(int paramInt)
  {
    CustomFrameAnimationDrawable.FrameAnimationState localFrameAnimationState = this.b;
    localFrameAnimationState.c = paramInt;
    localFrameAnimationState.j = paramInt;
  }
  
  public CustomFrameAnimationDrawable.OneFrame c(int paramInt)
  {
    CustomFrameAnimationDrawable.FrameAnimationState localFrameAnimationState = this.b;
    if ((localFrameAnimationState != null) && (localFrameAnimationState.b != null) && (this.b.b.size() > 0) && (paramInt >= 0) && (paramInt < this.b.b.size())) {
      return (CustomFrameAnimationDrawable.OneFrame)this.b.b.get(paramInt);
    }
    return null;
  }
  
  public void c()
  {
    unscheduleSelf(this);
    if ((this.a == null) && (this.f != null))
    {
      localFrameAnimationState = this.b;
      localFrameAnimationState.c = 0;
      localFrameAnimationState.j = 0;
      invalidateSelf();
      scheduleSelf(this, 0L);
    }
    else if (this.b.b.size() != 0)
    {
      if ((this.b.b.size() != -1) && (this.b.b.size() != 0)) {
        this.b.c = 0;
      } else {
        this.b.c = -1;
      }
      scheduleSelf(this, 0L);
    }
    if ((this.j != null) && (this.p)) {
      this.k = ((IHapticManagerApi)QRoute.api(IHapticManagerApi.class)).playEffect(this.j, 2);
    }
    CustomFrameAnimationDrawable.FrameAnimationState localFrameAnimationState = this.b;
    localFrameAnimationState.d = true;
    localFrameAnimationState.h = false;
  }
  
  public void d()
  {
    this.v = false;
    unscheduleSelf(this);
    this.b.d = true;
    scheduleSelf(this, 0L);
  }
  
  public void draw(Canvas paramCanvas)
  {
    Paint localPaint = this.b.a;
    Object localObject2 = this.a;
    Object localObject1 = null;
    if (localObject2 == null)
    {
      localObject2 = this.f;
      if (localObject2 != null)
      {
        if (((Bitmap)localObject2).isRecycled())
        {
          if (QLog.isColorLevel()) {
            QLog.d("CustomFrameAnimationDrawable", 2, "draw use recycle bitmap");
          }
          this.f = null;
          return;
        }
        localObject1 = this.f;
        if (this.b.g)
        {
          paramCanvas.save();
          paramCanvas.scale(-1.0F, 1.0F, this.m / 2, this.n / 2);
        }
        this.d.set(0, 0, ((Bitmap)localObject1).getWidth(), ((Bitmap)localObject1).getHeight());
        this.e.set(0.0F, 0.0F, this.m, this.n);
        int i1 = paramCanvas.getWidth();
        float f1 = paramCanvas.getHeight() * 1.0F / this.n;
        if (this.b.k == 1) {
          paramCanvas.translate((i1 / f1 - this.m) / 2.0F, 0.0F);
        } else if (this.b.k == 2) {
          paramCanvas.translate(Math.abs(i1 / f1 - this.m) / 2.0F, 0.0F);
        }
        paramCanvas.drawBitmap((Bitmap)localObject1, this.d, this.e, localPaint);
        if (!this.b.g) {
          return;
        }
        paramCanvas.restore();
        return;
      }
    }
    if (this.a != null)
    {
      if (this.b.c >= 0) {
        if (this.b.c >= this.b.b.size())
        {
          localObject1 = (Bitmap)this.a.get(((CustomFrameAnimationDrawable.OneFrame)this.b.b.get(this.b.b.size() - 1)).a);
        }
        else
        {
          localObject1 = (CustomFrameAnimationDrawable.OneFrame)this.b.b.get(this.b.c);
          localObject1 = (Bitmap)this.a.get(((CustomFrameAnimationDrawable.OneFrame)localObject1).a);
        }
      }
      if (localObject1 != null)
      {
        if (((Bitmap)localObject1).isRecycled()) {
          return;
        }
        if (this.b.g)
        {
          paramCanvas.save();
          paramCanvas.scale(-1.0F, 1.0F, ((Bitmap)localObject1).getWidth() / 2, ((Bitmap)localObject1).getHeight() / 2);
        }
        this.d.set(0, 0, ((Bitmap)localObject1).getWidth(), ((Bitmap)localObject1).getHeight());
        this.e.set(0.0F, 0.0F, ((Bitmap)localObject1).getWidth(), ((Bitmap)localObject1).getHeight());
        paramCanvas.drawBitmap((Bitmap)localObject1, 0.0F, 0.0F, localPaint);
        if (this.b.g) {
          paramCanvas.restore();
        }
      }
    }
  }
  
  public void e()
  {
    this.v = true;
    f();
  }
  
  public void f()
  {
    if (this.b.d) {
      unscheduleSelf(this);
    }
    if ((this.a == null) && (this.f != null) && (this.t))
    {
      int i1 = 0;
      while (i1 < this.b.f.size())
      {
        localObject = (Bitmap)this.b.f.remove(0);
        if (localObject != null) {
          ((Bitmap)localObject).recycle();
        }
        i1 += 1;
      }
      this.b.f.clear();
      Object localObject = this.b;
      ((CustomFrameAnimationDrawable.FrameAnimationState)localObject).j = ((CustomFrameAnimationDrawable.FrameAnimationState)localObject).c;
    }
  }
  
  public void g()
  {
    if (this.b.d) {
      unscheduleSelf(this);
    }
  }
  
  public int getAlpha()
  {
    return this.b.a.getAlpha();
  }
  
  public int getIntrinsicHeight()
  {
    return this.n;
  }
  
  public int getIntrinsicWidth()
  {
    return this.m;
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  public Bitmap h()
  {
    ArrayList localArrayList = this.b.f;
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (localArrayList != null)
    {
      localObject1 = localObject2;
      if (this.b.f.size() > 0) {
        localObject1 = (Bitmap)this.b.f.remove(0);
      }
    }
    return localObject1;
  }
  
  public void i()
  {
    this.b.i = true;
  }
  
  public int j()
  {
    return this.b.c;
  }
  
  public int k()
  {
    return this.b.b.size() - 1;
  }
  
  public void l()
  {
    if (this.b.b != null) {
      this.b.b.clear();
    }
  }
  
  public void m()
  {
    Object localObject1 = this.f;
    if (localObject1 != null)
    {
      ((Bitmap)localObject1).recycle();
      this.f = null;
    }
    localObject1 = this.b.f;
    Object localObject2 = ((ArrayList)localObject1).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      Bitmap localBitmap = (Bitmap)((Iterator)localObject2).next();
      if ((localBitmap != null) && (!localBitmap.isRecycled())) {
        localBitmap.recycle();
      }
    }
    ((ArrayList)localObject1).clear();
    localObject1 = this.w;
    if (localObject1 != null)
    {
      localObject1 = ((Vector)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Bitmap)((Iterator)localObject1).next();
        if ((localObject2 != null) && (!((Bitmap)localObject2).isRecycled())) {
          ((Bitmap)localObject2).recycle();
        }
      }
      this.w.clear();
    }
  }
  
  public void n()
  {
    unscheduleSelf(this);
    if ((this.j != null) && (this.p)) {
      ((IHapticManagerApi)QRoute.api(IHapticManagerApi.class)).pauseEffect(this.k);
    }
  }
  
  public void o()
  {
    scheduleSelf(this, SystemClock.uptimeMillis() + 50L);
    if ((this.j != null) && (this.p)) {
      ((IHapticManagerApi)QRoute.api(IHapticManagerApi.class)).resumeEffect(this.k);
    }
  }
  
  public void run()
  {
    if (this.v)
    {
      if (QLog.isColorLevel()) {
        QLog.i("CustomFrameAnimationDrawable", 2, "paused");
      }
      return;
    }
    Object localObject;
    if ((this.a == null) && (this.f != null))
    {
      int i2 = this.b.c + 1;
      int i1 = i2;
      if (!this.b.i) {
        i1 = i2 % this.b.b.size();
      }
      if (i1 < this.b.b.size())
      {
        r();
        return;
      }
      localObject = this.i;
      if (localObject != null) {
        ((CustomFrameAnimationDrawable.AnimationEndListener)localObject).a();
      }
      if (this.q)
      {
        m();
        this.b.b.clear();
      }
      localObject = this.b;
      ((CustomFrameAnimationDrawable.FrameAnimationState)localObject).d = false;
      ((CustomFrameAnimationDrawable.FrameAnimationState)localObject).h = true;
      if (this.j != null)
      {
        if (this.p) {
          ((IHapticManagerApi)QRoute.api(IHapticManagerApi.class)).stopEffect(this.k);
        }
        this.k = 0;
      }
    }
    else
    {
      if (this.b.b.size() == 1)
      {
        invalidateSelf();
        localObject = this.o;
        if (localObject != null) {
          ((CustomFrameAnimationDrawable.FrameListener)localObject).onUpdate(this.b.c);
        }
        return;
      }
      s();
    }
  }
  
  public void setAlpha(int paramInt)
  {
    if (paramInt != this.b.a.getAlpha())
    {
      this.b.a.setAlpha(paramInt);
      invalidateSelf();
    }
  }
  
  public void setBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.setBounds(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.b.a.setColorFilter(paramColorFilter);
    invalidateSelf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.CustomFrameAnimationDrawable
 * JD-Core Version:    0.7.0.1
 */