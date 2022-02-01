package com.tencent.luggage.wxa.iu;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyEvent;
import android.view.WindowManager;
import android.widget.FrameLayout;
import androidx.annotation.CallSuper;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import com.tencent.luggage.wxa.jj.h;
import com.tencent.luggage.wxa.oq.c;
import com.tencent.luggage.wxa.oq.c.a;
import com.tencent.luggage.wxa.oq.c.b;
import com.tencent.luggage.wxa.oq.c.c;
import com.tencent.luggage.wxa.oq.d.a;
import com.tencent.luggage.wxa.oq.d.b;
import com.tencent.luggage.wxa.oq.e;
import com.tencent.luggage.wxa.oq.j;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.t;
import com.tencent.luggage.wxa.rc.a;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Map;
import org.joor.Reflect;

@SuppressLint({"ViewConstructor"})
public class f<RUNTIME extends d>
  extends FrameLayout
  implements n, c
{
  f<RUNTIME>.a a;
  private boolean b;
  private Context c;
  private boolean d;
  private final Class<? extends RUNTIME> e;
  private final FrameLayout f;
  private final com.tencent.luggage.wxa.pp.n g;
  private final LinkedList<RUNTIME> h;
  private final Map<String, RUNTIME> i;
  private e j;
  
  private void a(com.tencent.mm.plugin.appbrand.widget.f paramf)
  {
    if (this.f.indexOfChild(paramf) == -1)
    {
      o.c("Luggage.WXA.AppBrandRuntimeContainerViewImpl", "bringRtViewToTop: such runtime view does not exist");
      return;
    }
    this.f.bringChildToFront(paramf);
    if (g()) {
      this.f.bringChildToFront(this.g);
    }
    c();
    a();
  }
  
  private void a(Runnable paramRunnable)
  {
    if (t.a())
    {
      paramRunnable.run();
      return;
    }
    post(paramRunnable);
  }
  
  private void b(com.tencent.mm.plugin.appbrand.widget.f paramf)
  {
    int k = this.f.getChildCount();
    if ((g()) && (j())) {
      k -= 1;
    } else {
      k = 0;
    }
    o.d("Luggage.WXA.AppBrandRuntimeContainerViewImpl", "loadNewRtContentView: name = [%s], index = [%d]", new Object[] { paramf.getTag(), Integer.valueOf(k) });
    this.f.addView(paramf, k);
    a();
    c();
    getActiveRuntime().a(4, 1, new f.5(this));
  }
  
  private void c()
  {
    if (Thread.currentThread() != Looper.getMainLooper().getThread())
    {
      t.a(new f.4(this));
      return;
    }
    if (this.b) {
      this.f.setPadding(0, 0, 0, 0);
    }
    f.a locala;
    if (h_()) {
      locala = getWindowCompatInfo();
    } else {
      locala = this.a;
    }
    this.f.setPadding(locala.a, locala.c, locala.b, locala.d);
  }
  
  private void f(@NonNull RUNTIME paramRUNTIME)
  {
    this.h.remove(paramRUNTIME);
    this.h.push(paramRUNTIME);
    paramRUNTIME.ai().setVisibility(0);
    a(paramRUNTIME.ai());
  }
  
  private void g(@NonNull RUNTIME paramRUNTIME)
  {
    if (this.h.contains(paramRUNTIME)) {
      return;
    }
    this.h.push(paramRUNTIME);
    if (this.f.indexOfChild(paramRUNTIME.ai()) == -1) {
      b(paramRUNTIME.ai());
    }
    this.i.remove(paramRUNTIME.aa());
  }
  
  private boolean g()
  {
    return this.g != null;
  }
  
  private boolean j()
  {
    int k = this.f.getChildCount();
    boolean bool = true;
    if (k <= 1)
    {
      if ((k == 1) && (this.g != null)) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
  
  public final int a(c paramc)
  {
    if (this == paramc) {
      return 0;
    }
    return -1;
  }
  
  public RUNTIME a(d paramd)
  {
    if (paramd != null)
    {
      ListIterator localListIterator = this.h.listIterator();
      int k = 0;
      while (localListIterator.hasNext())
      {
        d locald = (d)localListIterator.next();
        if (locald == paramd) {
          k = 1;
        } else if (k != 0) {
          return locald;
        }
      }
      if (k != 0) {
        return null;
      }
      throw new IllegalAccessError(String.format("Runtime not in stack %s", new Object[] { paramd.aa() }));
    }
    paramd = new NullPointerException("Null runtime");
    for (;;)
    {
      throw paramd;
    }
  }
  
  @UiThread
  protected RUNTIME a(@NonNull h paramh)
  {
    return (d)Reflect.on(this.e).create(new Object[] { this }).get();
  }
  
  @UiThread
  protected RUNTIME a(String paramString)
  {
    Iterator localIterator = this.h.iterator();
    while (localIterator.hasNext())
    {
      d locald = (d)localIterator.next();
      if (locald.aa().equals(paramString)) {
        return locald;
      }
    }
    return (d)this.i.get(paramString);
  }
  
  public com.tencent.luggage.wxa.oq.d a(@Nullable d.b paramb)
  {
    return d.a.a();
  }
  
  protected void a()
  {
    this.f.setBackgroundColor(getResources().getColor(2131165191));
  }
  
  public void a(@ColorInt int paramInt, @NonNull d paramd) {}
  
  @UiThread
  protected void a(RUNTIME paramRUNTIME1, RUNTIME paramRUNTIME2, h paramh)
  {
    paramRUNTIME2.a(paramRUNTIME1);
    paramRUNTIME2.c(paramh);
    this.h.push(paramRUNTIME2);
    b(paramRUNTIME2.ai());
    if (paramRUNTIME1 != null) {
      paramRUNTIME1.ay();
    }
    paramRUNTIME2.Y();
  }
  
  @CallSuper
  protected void a(@Nullable d paramd1, @NonNull d paramd2, @NonNull Runnable paramRunnable) {}
  
  public void a(d paramd, h paramh)
  {
    if (paramh == null) {
      return;
    }
    a(new f.1(this, paramd, paramh));
  }
  
  public void a(d paramd, @Nullable Object paramObject)
  {
    if (paramd == null) {
      return;
    }
    a(new f.2(this, paramd, paramObject));
  }
  
  public void a(j paramj, d paramd) {}
  
  protected final void b()
  {
    Iterator localIterator = this.h.iterator();
    while (localIterator.hasNext())
    {
      d locald = (d)localIterator.next();
      locald.ai().setVisibility(8);
      this.i.put(locald.aa(), locald);
      locald.aN();
    }
    this.h.clear();
  }
  
  @UiThread
  protected void b(RUNTIME paramRUNTIME1, RUNTIME paramRUNTIME2, h paramh)
  {
    g(paramRUNTIME2);
    f(paramRUNTIME2);
    paramRUNTIME2.a(paramRUNTIME1);
    paramRUNTIME2.d(paramh);
    if (paramRUNTIME1 != null)
    {
      paramRUNTIME1.ay();
      paramRUNTIME2.aA();
    }
  }
  
  public boolean b(d paramd)
  {
    return this.h.contains(paramd);
  }
  
  public void c(d paramd)
  {
    if (paramd == null) {
      return;
    }
    a(new f.3(this, paramd));
  }
  
  protected final boolean d(@NonNull RUNTIME paramRUNTIME)
  {
    return this.h.peekFirst() == paramRUNTIME;
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    if ((paramKeyEvent.getAction() == 0) && (paramKeyEvent.getKeyCode() == 4))
    {
      d locald = getActiveRuntime();
      if ((locald != null) && (!locald.au()))
      {
        locald.V();
        return true;
      }
    }
    return super.dispatchKeyEvent(paramKeyEvent);
  }
  
  public void e(d paramd)
  {
    if (paramd == null) {
      return;
    }
    this.h.remove(paramd);
  }
  
  public boolean f()
  {
    return false;
  }
  
  public boolean g_()
  {
    return false;
  }
  
  public d getActiveRuntime()
  {
    return (d)this.h.peek();
  }
  
  public final Activity getActivity()
  {
    return a.a(this.c);
  }
  
  @Nullable
  public c.b getNavigationBar()
  {
    return null;
  }
  
  public e getOrientationHandler()
  {
    if (this.j == null) {
      this.j = new m(this);
    }
    return this.j;
  }
  
  public Rect getSafeAreaInsets()
  {
    return null;
  }
  
  public float getScale()
  {
    return 1.0F;
  }
  
  public int getStackSize()
  {
    return this.h.size();
  }
  
  @Nullable
  public c.c getStatusBar()
  {
    return null;
  }
  
  public DisplayMetrics getVDisplayMetrics()
  {
    Object localObject = getContext().getResources().getDisplayMetrics();
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    localDisplayMetrics.setTo((DisplayMetrics)localObject);
    localObject = getWindowCompatInfo();
    localDisplayMetrics.widthPixels = (getWidth() - ((f.a)localObject).a - ((f.a)localObject).b);
    localDisplayMetrics.heightPixels = (getHeight() - ((f.a)localObject).c - ((f.a)localObject).d);
    return localDisplayMetrics;
  }
  
  public c getWindowAndroid()
  {
    return this;
  }
  
  public f<RUNTIME>.a getWindowCompatInfo()
  {
    if (!h_()) {
      return this.a;
    }
    Point localPoint = new Point();
    ((WindowManager)getContext().getSystemService("window")).getDefaultDisplay().getSize(localPoint);
    o.f("Luggage.WXA.AppBrandRuntimeContainerViewImpl", "getWindowCompatInfo: android orientation = [%d]", new Object[] { Integer.valueOf(getContext().getResources().getConfiguration().orientation) });
    double d1 = localPoint.y;
    Double.isNaN(d1);
    d1 /= 1.777777777777778D;
    double d2 = localPoint.x;
    Double.isNaN(d2);
    int k = (int)((d2 - d1) / 2.0D);
    return new f.a(this, k, k, 0, 0);
  }
  
  public boolean h_()
  {
    return false;
  }
  
  public boolean i()
  {
    return false;
  }
  
  @Nullable
  public boolean i_()
  {
    return false;
  }
  
  public void setSoftOrientation(String paramString) {}
  
  public void setWindowDescription(c.a parama) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.iu.f
 * JD-Core Version:    0.7.0.1
 */