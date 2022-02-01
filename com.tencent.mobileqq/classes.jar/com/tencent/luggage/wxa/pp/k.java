package com.tencent.luggage.wxa.pp;

import android.content.Context;
import android.graphics.Point;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.collection.ArrayMap;
import androidx.core.view.ViewCompat;
import com.tencent.luggage.wxa.jx.f.c;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.rh.a;
import com.tencent.mm.plugin.appbrand.page.u;
import java.lang.ref.Reference;
import java.util.Map;
import java.util.Set;

public class k
  implements f.c
{
  private static final k b = new k.1();
  private static final ArrayMap<u, k> j = new ArrayMap();
  private final Map<k.a, k> a = new ArrayMap();
  @NonNull
  private final u c;
  private final int d;
  private final int e = 5;
  private int f = 0;
  private boolean g = false;
  private int h = -1;
  private int i = 0;
  private final Runnable k = new k.2(this);
  private final Runnable l = new k.3(this);
  
  private k()
  {
    this.c = null;
    this.d = 0;
  }
  
  private k(@NonNull u paramu)
  {
    this.c = paramu;
    this.c.a(this);
    this.d = a.a(paramu.Y());
  }
  
  private View a()
  {
    if (!this.c.d()) {
      return null;
    }
    return b(this.c);
  }
  
  @MainThread
  public static k a(u paramu)
  {
    if ((paramu != null) && (paramu.d()))
    {
      k localk = (k)j.get(paramu);
      localObject = localk;
      if (localk == null)
      {
        localObject = new k(paramu);
        j.put(paramu, localObject);
      }
      return localObject;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(" obtain with invalid page ");
    ((StringBuilder)localObject).append(paramu);
    o.g("MicroMsg.AppBrandInputPageOffsetHelper", ((StringBuilder)localObject).toString(), new Object[0]);
    return b;
  }
  
  @MainThread
  public static k a(Reference<u> paramReference)
  {
    if (paramReference == null) {
      paramReference = null;
    } else {
      paramReference = (u)paramReference.get();
    }
    return a(paramReference);
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.f = 0;
      this.g = false;
    }
    if (!this.c.d()) {
      return;
    }
    if (this.g)
    {
      this.f = 0;
      return;
    }
    if (this.f == 0)
    {
      o.f("MicroMsg.AppBrandInputPageOffsetHelper", "[scrollUp] post, attached %B", new Object[] { Boolean.valueOf(ViewCompat.isAttachedToWindow(this.c.getContentView())) });
      this.c.getContentView().post(this.l);
      return;
    }
    o.f("MicroMsg.AppBrandInputPageOffsetHelper", "[scrollUp] postOnAnimation, attached %B", new Object[] { Boolean.valueOf(ViewCompat.isAttachedToWindow(this.c.getContentView())) });
    this.c.getContentView().postOnAnimationDelayed(this.l, 100L);
  }
  
  private int b()
  {
    Display localDisplay = ((WindowManager)this.c.getContentView().getContext().getSystemService("window")).getDefaultDisplay();
    Point localPoint = new Point();
    localDisplay.getSize(localPoint);
    return localPoint.y;
  }
  
  @MainThread
  public static View b(@NonNull u paramu)
  {
    return paramu.ag();
  }
  
  private void c()
  {
    if (this.a.size() <= 0) {
      return;
    }
    k.a[] arrayOfa = new k.a[this.a.size()];
    arrayOfa = (k.a[])this.a.keySet().toArray(arrayOfa);
    int n = arrayOfa.length;
    int m = 0;
    while (m < n)
    {
      arrayOfa[m].a();
      m += 1;
    }
  }
  
  private void e()
  {
    if (this.a.size() <= 0) {
      return;
    }
    k.a[] arrayOfa = new k.a[this.a.size()];
    arrayOfa = (k.a[])this.a.keySet().toArray(arrayOfa);
    int n = arrayOfa.length;
    int m = 0;
    while (m < n)
    {
      arrayOfa[m].b();
      m += 1;
    }
  }
  
  public void a(int paramInt)
  {
    this.h = paramInt;
    a(true);
  }
  
  public void a(k.a parama)
  {
    if (parama == null) {
      return;
    }
    if (this.a.containsKey(parama)) {
      return;
    }
    this.a.put(parama, this);
  }
  
  public void b(int paramInt)
  {
    if (!this.c.d()) {
      return;
    }
    int m = this.h;
    if (paramInt != m)
    {
      o.c("MicroMsg.AppBrandInputPageOffsetHelper", "requestScrollDown, skip last-ticket %d, pass-in-ticket %d", new Object[] { Integer.valueOf(m), Integer.valueOf(paramInt) });
      return;
    }
    this.g = true;
    this.c.getContentView().post(this.k);
  }
  
  public void b(k.a parama)
  {
    if (parama == null) {
      return;
    }
    this.a.remove(parama);
  }
  
  public void d()
  {
    this.c.b(this);
    j.remove(this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.pp.k
 * JD-Core Version:    0.7.0.1
 */