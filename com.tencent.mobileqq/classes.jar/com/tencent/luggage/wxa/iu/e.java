package com.tencent.luggage.wxa.iu;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import androidx.annotation.AnyThread;
import androidx.annotation.CallSuper;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import com.tencent.luggage.wxa.jj.h;
import com.tencent.luggage.wxa.or.b;
import com.tencent.luggage.wxa.pa.a;
import com.tencent.luggage.wxa.qz.c;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.s;
import com.tencent.luggage.wxa.qz.t;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import org.joor.Reflect;

public class e<RUNTIME extends d>
  extends com.tencent.luggage.wxa.or.n
  implements n
{
  private FrameLayout b;
  private final LinkedList<RUNTIME> c;
  private final HashMap<String, RUNTIME> d;
  private final a e;
  private Class<? extends RUNTIME> f;
  private boolean g = false;
  private boolean h = false;
  private com.tencent.luggage.wxa.pp.n i;
  private Application.ActivityLifecycleCallbacks j;
  
  public e(a parama, Class<? extends RUNTIME> paramClass)
  {
    super.a(parama.g());
    this.c = new LinkedList();
    this.d = new HashMap();
    this.b = parama.c();
    this.e = parama;
    this.f = paramClass;
    this.b.setOnSystemUiVisibilityChangeListener(new e.1(this));
    com.tencent.luggage.wxa.or.f.a(u()).f();
    parama = (Application)getContext().getApplicationContext();
    paramClass = new e.4(this);
    this.j = paramClass;
    parama.registerActivityLifecycleCallbacks(paramClass);
  }
  
  private void a()
  {
    if (this.j != null)
    {
      ((Application)getContext().getApplicationContext()).unregisterActivityLifecycleCallbacks(this.j);
      this.j = null;
    }
    v().d();
  }
  
  private void a(ViewGroup paramViewGroup)
  {
    if (this.b.indexOfChild(paramViewGroup) == -1)
    {
      o.c("MicroMsg.AppBrandRuntimeContainer", "bringRtViewToTop: such runtime view does not exist");
      return;
    }
    this.b.bringChildToFront(paramViewGroup);
    if (g()) {
      this.b.bringChildToFront(this.i);
    }
  }
  
  private void a(@NonNull RUNTIME paramRUNTIME, boolean paramBoolean)
  {
    if ((this.c.contains(paramRUNTIME)) && (!paramBoolean)) {
      return;
    }
    this.c.remove(paramRUNTIME);
    this.c.push(paramRUNTIME);
    if (this.b.indexOfChild(paramRUNTIME.ai()) == -1) {
      a(paramRUNTIME.ai());
    }
    this.d.remove(paramRUNTIME.aa());
  }
  
  private void a(com.tencent.mm.plugin.appbrand.widget.f paramf)
  {
    int k = this.b.getChildCount();
    if ((g()) && (b())) {
      k -= 1;
    } else {
      k = 0;
    }
    o.d("MicroMsg.AppBrandRuntimeContainer", "attachRtViewToTree: name = [%s], index = [%d]", new Object[] { (String)paramf.getTag(), Integer.valueOf(k) });
    if (paramf.getParent() != null) {
      if (!c.a) {
        ((ViewGroup)paramf.getParent()).removeAllViews();
      } else {
        throw new IllegalArgumentException("runtimeLayout's parent should be null");
      }
    }
    this.b.addView(paramf, k);
    paramf = this.i;
    if ((paramf != null) && (paramf.getParent() == null))
    {
      this.b.addView(this.i);
      this.b.bringChildToFront(this.i);
    }
    getActiveRuntime().a(4, 1, new e.3(this));
  }
  
  private boolean b()
  {
    int k = this.b.getChildCount();
    boolean bool = true;
    if (k <= 1)
    {
      if ((k == 1) && (this.i != null)) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
  
  private void g(RUNTIME paramRUNTIME)
  {
    o.d("MicroMsg.AppBrandRuntimeContainer", "removeImpl entered appId[%s]", new Object[] { paramRUNTIME.aa() });
    e.11 local11 = new e.11(this, paramRUNTIME);
    if (!b(paramRUNTIME))
    {
      o.d("MicroMsg.AppBrandRuntimeContainer", "removeImpl appId[%s], not in runtime stack, just cleanup", new Object[] { paramRUNTIME.aa() });
      local11.run();
      return;
    }
    d locald = a(paramRUNTIME);
    a(locald, paramRUNTIME, new e.2(this, paramRUNTIME, locald, local11));
  }
  
  private boolean g()
  {
    return this.i != null;
  }
  
  private void h(@NonNull RUNTIME paramRUNTIME)
  {
    this.c.remove(paramRUNTIME);
    this.c.push(paramRUNTIME);
    paramRUNTIME.ai().setVisibility(0);
    a(paramRUNTIME.ai());
  }
  
  private void i(@NonNull RUNTIME paramRUNTIME)
  {
    a(paramRUNTIME, false);
  }
  
  public RUNTIME a(d paramd)
  {
    if (paramd != null)
    {
      ListIterator localListIterator = this.c.listIterator();
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
  protected RUNTIME a(String paramString)
  {
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext())
    {
      d locald = (d)localIterator.next();
      if (locald.aa().equals(paramString)) {
        return locald;
      }
    }
    return (d)this.d.get(paramString);
  }
  
  public void a(@ColorInt int paramInt, @NonNull d paramd)
  {
    super.a(paramInt, paramd);
    paramd = (View)paramd.ai().getParent();
    if (paramd != null) {
      paramd.setBackgroundColor(paramInt);
    }
  }
  
  public void a(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext()) {
      com.tencent.luggage.wxa.on.n.a(((d)localIterator.next()).aa(), paramInt, paramArrayOfString, paramArrayOfInt, false);
    }
  }
  
  protected void a(Configuration paramConfiguration)
  {
    Object localObject = this.c;
    if (localObject != null)
    {
      localObject = ((LinkedList)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((d)((Iterator)localObject).next()).a(paramConfiguration);
      }
    }
  }
  
  @UiThread
  protected void a(RUNTIME paramRUNTIME1, RUNTIME paramRUNTIME2, h paramh)
  {
    paramRUNTIME2.a(paramRUNTIME1);
    paramRUNTIME2.c(paramh);
    this.c.push(paramRUNTIME2);
    a(paramRUNTIME2.ai());
    if (paramRUNTIME1 != null) {
      paramRUNTIME1.ay();
    }
    paramRUNTIME2.Y();
  }
  
  @CallSuper
  protected void a(@Nullable d paramd1, @NonNull d paramd2, @NonNull Runnable paramRunnable)
  {
    if (paramd1 == null) {
      paramd1 = "null";
    } else {
      paramd1 = paramd1.aa();
    }
    o.d("MicroMsg.AppBrandRuntimeContainer", "onRuntimeClose entered, in.appId[%s], out.appId[%s]", new Object[] { paramd1, paramd2.aa() });
    paramRunnable.run();
  }
  
  @AnyThread
  public void a(d paramd, h paramh)
  {
    if (paramh == null) {
      return;
    }
    u().runOnUiThread(new e.5(this, paramd, paramh));
  }
  
  public void a(d paramd, @Nullable Object paramObject)
  {
    if (paramd == null) {
      return;
    }
    Activity localActivity = u();
    if (localActivity == null) {
      return;
    }
    localActivity.runOnUiThread(new e.6(this, paramd, paramObject));
  }
  
  public void a(com.tencent.luggage.wxa.pp.n paramn)
  {
    this.b.removeView(paramn);
    int k = this.b.getChildCount();
    this.b.addView(paramn, k, new ViewGroup.LayoutParams(-1, -1));
    this.i = paramn;
    paramn = this.b;
    com.tencent.luggage.wxa.pp.n localn = this.i;
    paramn.requestChildFocus(localn, localn);
  }
  
  public final void a(Runnable paramRunnable)
  {
    if (paramRunnable == null) {
      return;
    }
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      paramRunnable.run();
      return;
    }
    if (u() != null)
    {
      u().runOnUiThread(paramRunnable);
      return;
    }
    o.b("MicroMsg.AppBrandRuntimeContainer", "runOnUiThread getActivity()==null");
    new s(Looper.getMainLooper()).a(paramRunnable);
  }
  
  @UiThread
  protected RUNTIME b(@NonNull h paramh)
  {
    return (d)Reflect.on(this.f).create(new Object[] { this }).get();
  }
  
  @UiThread
  protected void b(RUNTIME paramRUNTIME1, RUNTIME paramRUNTIME2, h paramh)
  {
    i(paramRUNTIME2);
    h(paramRUNTIME2);
    paramRUNTIME2.a(paramRUNTIME1);
    paramRUNTIME2.d(paramh);
    if (paramRUNTIME1 != null)
    {
      paramRUNTIME1.ay();
      paramRUNTIME2.aA();
    }
  }
  
  @UiThread
  protected final void b(@Nullable String paramString)
  {
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext())
    {
      d locald = (d)localIterator.next();
      if ((paramString != null) && (paramString.equals(locald.aa())))
      {
        o.d("MicroMsg.AppBrandRuntimeContainer", "detachCurrentStack, exclude appId(%s)", new Object[] { paramString });
      }
      else
      {
        localIterator.remove();
        locald.ai().setVisibility(8);
        this.d.put(locald.aa(), locald);
        locald.aN();
        if (!locald.aw())
        {
          o.d("MicroMsg.AppBrandRuntimeContainer", "detachCurrentStack, rt(%s).initialized()=false, just destroy", new Object[] { locald.aa() });
          g(locald);
        }
        else if (locald.aQ())
        {
          o.d("MicroMsg.AppBrandRuntimeContainer", "detachCurrentStack, rt(%s).isResumed()=true, make it pause", new Object[] { locald.aa() });
          locald.ay();
        }
      }
    }
  }
  
  @UiThread
  public boolean b(d paramd)
  {
    return this.c.contains(paramd);
  }
  
  public void c()
  {
    o.d("MicroMsg.AppBrandRuntimeContainer", "onResume tid = %d", new Object[] { Long.valueOf(Thread.currentThread().getId()) });
    a(new e.8(this));
  }
  
  public void c(d paramd)
  {
    if (paramd == null) {
      return;
    }
    a(new e.10(this, paramd));
  }
  
  public void d()
  {
    o.d("MicroMsg.AppBrandRuntimeContainer", "onPause tid = %d", new Object[] { Long.valueOf(Thread.currentThread().getId()) });
    a(new e.7(this));
  }
  
  protected final boolean d(@NonNull RUNTIME paramRUNTIME)
  {
    return this.c.peekFirst() == paramRUNTIME;
  }
  
  public void e()
  {
    Object localObject = new LinkedList();
    ((LinkedList)localObject).addAll(this.c);
    ((LinkedList)localObject).addAll(this.d.values());
    p();
    localObject = ((LinkedList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      d locald = (d)((Iterator)localObject).next();
      locald.b(false);
      c(locald);
    }
    o.d("MicroMsg.AppBrandRuntimeContainer", "cleanup");
    a();
  }
  
  public final void e(d paramd)
  {
    if (paramd == null) {
      return;
    }
    this.c.remove(paramd);
  }
  
  protected final void f(RUNTIME paramRUNTIME)
  {
    if (paramRUNTIME == null) {
      return;
    }
    this.c.remove(paramRUNTIME);
    if (Build.VERSION.SDK_INT >= 24)
    {
      this.d.remove(paramRUNTIME.aa(), paramRUNTIME);
      return;
    }
    this.d.remove(paramRUNTIME.aa());
  }
  
  public boolean g_()
  {
    return this.e.e();
  }
  
  public RUNTIME getActiveRuntime()
  {
    return (d)this.c.peek();
  }
  
  public final DisplayMetrics getVDisplayMetrics()
  {
    DisplayMetrics localDisplayMetrics = super.getVDisplayMetrics();
    if (this.b.isLaidOut())
    {
      localDisplayMetrics.widthPixels = this.b.getMeasuredWidth();
      localDisplayMetrics.heightPixels = this.b.getMeasuredHeight();
    }
    return localDisplayMetrics;
  }
  
  public void h()
  {
    d locald = getActiveRuntime();
    if (locald != null) {
      try
      {
        locald.V();
        return;
      }
      catch (Exception localException)
      {
        o.b("MicroMsg.AppBrandRuntimeContainer", "onBackPressed e = %s", new Object[] { localException });
        t.a(new e.9(this, localException));
      }
    }
  }
  
  protected boolean k()
  {
    return true;
  }
  
  public final boolean l()
  {
    return this.h;
  }
  
  public final com.tencent.luggage.wxa.or.n m()
  {
    return this;
  }
  
  public final FrameLayout n()
  {
    return this.b;
  }
  
  public int o()
  {
    return this.c.size();
  }
  
  @UiThread
  protected final void p()
  {
    b(null);
  }
  
  protected final Iterator<RUNTIME> q()
  {
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.addAll(this.c);
    localLinkedList.addAll(this.d.values());
    return localLinkedList.iterator();
  }
  
  protected final Iterator<RUNTIME> r()
  {
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.addAll(this.c);
    return localLinkedList.iterator();
  }
  
  public final a s()
  {
    return this.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.iu.e
 * JD-Core Version:    0.7.0.1
 */