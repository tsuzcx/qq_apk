package com.tencent.luggage.wxa.rh;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.annotation.UiThread;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.re.d;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import java.util.WeakHashMap;

public class c
{
  public static final boolean a;
  @SuppressLint({"StaticFieldLeak"})
  private static final c g = new c.2(null);
  private static final WeakHashMap<Activity, c> h = new WeakHashMap();
  private final WeakReference<Activity> b;
  private final Set<WeakReference<c.a>> c = new HashSet();
  private boolean d = false;
  private int e = 0;
  private WeakReference<View> f;
  
  static
  {
    boolean bool;
    if ((Build.VERSION.SDK_INT >= 21) && (!d.a())) {
      bool = true;
    } else {
      bool = false;
    }
    a = bool;
  }
  
  private c(Activity paramActivity)
  {
    this.b = new WeakReference(paramActivity);
  }
  
  public static c a(Activity paramActivity)
  {
    if ((a) && (paramActivity != null))
    {
      c localc2 = (c)h.get(paramActivity);
      c localc1 = localc2;
      if (localc2 == null)
      {
        localc1 = new c(paramActivity);
        h.put(paramActivity, localc1);
      }
      return localc1;
    }
    return g;
  }
  
  private void a(int paramInt)
  {
    Object localObject = new LinkedList();
    ((LinkedList)localObject).addAll(this.c);
    localObject = ((LinkedList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      WeakReference localWeakReference = (WeakReference)((Iterator)localObject).next();
      c.a locala = (c.a)localWeakReference.get();
      if (locala != null) {
        locala.b_(paramInt);
      } else {
        this.c.remove(localWeakReference);
      }
    }
  }
  
  @TargetApi(21)
  private void c()
  {
    Object localObject1;
    if (!this.d)
    {
      this.d = true;
      localObject1 = (Activity)this.b.get();
      if (localObject1 != null) {
        if (((Activity)localObject1).getWindow() == null) {
          return;
        }
      }
    }
    for (;;)
    {
      ViewGroup localViewGroup;
      int i;
      try
      {
        localViewGroup = (ViewGroup)((Activity)localObject1).getWindow().getDecorView();
        localObject2 = null;
        i = 0;
        localObject1 = localObject2;
        if (i >= localViewGroup.getChildCount()) {
          break label159;
        }
        localObject1 = localViewGroup.getChildAt(i);
        if ("android:status:background".equals(((View)localObject1).getTransitionName())) {
          break label152;
        }
        if (!"android:navigation:background".equals(((View)localObject1).getTransitionName())) {
          break label149;
        }
      }
      catch (Exception localException)
      {
        this.d = false;
        o.b("MicroMsg.StatusBarHeightWatcher", "setOnApplyWindowInsetsListener e=%s", new Object[] { localException });
      }
      ((View)localObject2).setOnApplyWindowInsetsListener(new c.1(this, localViewGroup));
      ((View)localObject2).requestApplyInsets();
      this.f = new WeakReference(localObject2);
      return;
      return;
      label149:
      break label159;
      label152:
      i += 1;
      continue;
      label159:
      Object localObject2 = localException;
      if (localException == null) {
        localObject2 = localViewGroup;
      }
    }
  }
  
  public void a()
  {
    WeakReference localWeakReference = this.f;
    if ((localWeakReference != null) && (localWeakReference.get() != null)) {
      ((View)this.f.get()).requestApplyInsets();
    }
  }
  
  @UiThread
  public void a(c.a parama)
  {
    c();
    if (parama != null)
    {
      this.c.add(new WeakReference(parama));
      int i = this.e;
      if (i > 0) {
        parama.b_(i);
      }
    }
  }
  
  public int b()
  {
    return this.e;
  }
  
  @UiThread
  public void b(c.a parama)
  {
    if (parama != null)
    {
      Iterator localIterator = new LinkedList(this.c).iterator();
      while (localIterator.hasNext())
      {
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        if ((parama == localWeakReference.get()) || (localWeakReference.get() == null)) {
          this.c.remove(localWeakReference);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.rh.c
 * JD-Core Version:    0.7.0.1
 */