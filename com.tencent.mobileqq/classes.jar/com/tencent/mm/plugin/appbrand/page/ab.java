package com.tencent.mm.plugin.appbrand.page;

import android.os.Looper;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import com.tencent.luggage.wxa.id.a.b;
import com.tencent.luggage.wxa.jx.e.a;
import com.tencent.luggage.wxa.ks.e;
import com.tencent.luggage.wxa.kt.b;
import com.tencent.luggage.wxa.kt.r;
import com.tencent.luggage.wxa.oq.d;
import com.tencent.luggage.wxa.qz.ac;
import com.tencent.luggage.wxa.qz.o;
import java.lang.ref.WeakReference;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedDeque;

public class ab
  implements e.a
{
  private ViewGroup b;
  private com.tencent.luggage.wxa.qz.s c;
  private final Deque<ab.b> d;
  private int e = -1;
  private float[] f;
  private View g;
  private bc h;
  private d i;
  private int j = -1;
  private ao k;
  private q l;
  private FrameLayout m;
  private ar n;
  
  public ab(ViewGroup paramViewGroup)
  {
    this.b = paramViewGroup;
    this.c = new com.tencent.luggage.wxa.qz.s(Looper.getMainLooper());
    this.d = new ConcurrentLinkedDeque();
    this.g = new View(paramViewGroup.getContext());
  }
  
  private int a(int paramInt1, int paramInt2)
  {
    Iterator localIterator = this.d.iterator();
    int i1 = 0;
    while (localIterator.hasNext())
    {
      ab.b localb = (ab.b)localIterator.next();
      if ((paramInt1 == localb.c) && (paramInt2 >= localb.d)) {
        i1 += 1;
      }
    }
    return i1;
  }
  
  private <T extends View> T a(ViewGroup paramViewGroup, Class<T> paramClass)
  {
    int i2 = paramViewGroup.getChildCount();
    int i1 = 0;
    while (i1 < i2)
    {
      View localView = paramViewGroup.getChildAt(i1);
      if ((localView instanceof ViewGroup)) {
        return a((ViewGroup)localView, paramClass);
      }
      if (paramClass.isInstance(localView)) {
        return (View)paramClass.cast(localView);
      }
      i1 += 1;
    }
    return null;
  }
  
  private ab.b a(View paramView, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    paramView = new ab.b(paramView, paramInt1, paramInt2, paramInt3, paramBoolean1, paramBoolean2, paramBoolean3);
    a(paramView);
    return paramView;
  }
  
  private void b(ab.b paramb)
  {
    try
    {
      Iterator localIterator = c(paramb).iterator();
      while (localIterator.hasNext()) {
        e((ab.b)localIterator.next());
      }
    }
    catch (StackOverflowError localStackOverflowError)
    {
      label36:
      break label36;
    }
    d(paramb);
  }
  
  private boolean b(int paramInt1, bc parambc, int paramInt2)
  {
    if (paramInt1 == this.e) {
      return false;
    }
    ab.b localb2 = k(paramInt1);
    if (localb2 != null)
    {
      if (localb2.a == null) {
        return false;
      }
      View localView = (View)localb2.a.get();
      if (localView == null) {
        return false;
      }
      this.j = paramInt1;
      ViewGroup localViewGroup = a(localb2.c, false, false);
      Object localObject2 = localb2;
      Object localObject1 = localViewGroup;
      Object localObject3;
      if ((localViewGroup instanceof com.tencent.luggage.wxa.ks.a))
      {
        localObject2 = localb2;
        localObject1 = localViewGroup;
        if (((com.tencent.luggage.wxa.ks.a)localViewGroup).a())
        {
          ab.b localb1 = k(localb2.c);
          localObject2 = localb2;
          localObject1 = localViewGroup;
          if (localb1 != null)
          {
            localObject3 = a(localb1.c, false, false);
            localObject2 = localb2;
            localObject1 = localViewGroup;
            if (localObject3 != null)
            {
              localObject1 = (View)localb2.a.get();
              if (localObject1 != null)
              {
                localObject2 = ((View)localObject1).getLayoutParams();
                ((ViewGroup.LayoutParams)localObject2).width = -1;
                ((ViewGroup.LayoutParams)localObject2).height = -1;
                ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
              }
              this.j = localb1.b;
              localObject2 = localb1;
              localObject1 = localObject3;
            }
          }
        }
      }
      if (localObject1 != null)
      {
        localView = (View)((ab.b)localObject2).a.get();
        int i1 = ((ViewGroup)localObject1).indexOfChild(localView);
        localObject3 = this.g;
        if (localObject3 != null)
        {
          localObject3 = (ViewGroup)((View)localObject3).getParent();
          if (localObject3 != null) {
            ((ViewGroup)localObject3).removeView(this.g);
          }
        }
        ((ViewGroup)localObject1).addView(this.g, i1);
        ((ViewGroup)localObject1).removeView(localView);
      }
      this.f = new float[] { localView.getX(), localView.getY(), localView.getWidth(), localView.getHeight(), ((ab.b)localObject2).d };
      this.i.a(localView, paramInt2);
      this.e = paramInt1;
      this.h = parambc;
      return true;
    }
    return false;
  }
  
  private boolean b(int paramInt1, float[] paramArrayOfFloat, int paramInt2, Boolean paramBoolean1, Boolean paramBoolean2)
  {
    if (g(paramInt1)) {
      return true;
    }
    ab.b localb = k(paramInt1);
    if (localb == null) {
      return false;
    }
    View localView = (View)localb.a.get();
    boolean bool1;
    if (paramBoolean2 != null) {
      bool1 = paramBoolean2.booleanValue();
    } else {
      bool1 = localb.f;
    }
    paramBoolean2 = a(localb.c, bool1, localb.g);
    if (paramBoolean2 == null) {
      return false;
    }
    int i1;
    if (paramInt2 >= 0)
    {
      if (paramInt2 == 0) {
        i1 = 0;
      } else {
        i1 = 4;
      }
      localView.setVisibility(i1);
    }
    if (paramArrayOfFloat != null)
    {
      if (paramArrayOfFloat.length < 5) {
        return true;
      }
      float f4 = paramArrayOfFloat[0];
      float f3 = paramArrayOfFloat[1];
      float f5 = paramArrayOfFloat[2];
      float f6 = paramArrayOfFloat[3];
      i1 = (int)paramArrayOfFloat[4];
      boolean bool2;
      if (paramBoolean1 != null) {
        bool2 = paramBoolean1.booleanValue();
      } else {
        bool2 = localb.e;
      }
      if ((localb.d == i1) && (localb.f == bool1))
      {
        paramBoolean1 = localb.h;
        paramArrayOfFloat = paramBoolean1;
        if (localb.c == 0)
        {
          paramArrayOfFloat = paramBoolean1;
          if ((paramBoolean2 instanceof bd))
          {
            paramArrayOfFloat = paramBoolean1;
            if (bool2 != localb.e) {
              if (bool2)
              {
                paramArrayOfFloat = paramBoolean1;
                if (paramBoolean1 == null)
                {
                  paramArrayOfFloat = new ab.a(null);
                  paramArrayOfFloat.a = localView;
                  localb.h = paramArrayOfFloat;
                }
                ((bd)paramBoolean2).a(paramArrayOfFloat);
              }
              else
              {
                ((bd)paramBoolean2).b(localb.h);
                paramArrayOfFloat = paramBoolean1;
              }
            }
          }
        }
        float f2 = f4;
        float f1 = f3;
        if (paramArrayOfFloat != null)
        {
          paramArrayOfFloat.b = f4;
          paramArrayOfFloat.c = f3;
          paramArrayOfFloat.d = this.b.getScrollX();
          paramArrayOfFloat.e = this.b.getScrollY();
          f2 = f4 + paramArrayOfFloat.d;
          f1 = f3 + paramArrayOfFloat.e;
        }
        paramArrayOfFloat = localView.getLayoutParams();
        paramArrayOfFloat.width = ((int)f5);
        paramArrayOfFloat.height = ((int)f6);
        localView.setX(f2);
        localView.setY(f1);
        localView.requestLayout();
        paramInt1 = paramBoolean2.indexOfChild(this.g);
        if ((paramBoolean2.indexOfChild(localView) == -1) && (paramInt1 != -1))
        {
          paramBoolean2.addView(localView, paramInt1);
          paramBoolean2.removeView(this.g);
        }
        return true;
      }
      e(localb);
      paramBoolean2.removeView(localView);
      if (localView.getParent() != null)
      {
        if ((localb.h != null) && ((localView.getParent() instanceof bd))) {
          ((bd)localView.getParent()).b(localb.h);
        }
        ((ViewGroup)localView.getParent()).removeView(localView);
      }
      if (b(localView, paramInt1, localb.c, paramArrayOfFloat, paramInt2, bool2, bool1)) {
        return true;
      }
      b(localb);
      return false;
    }
    return true;
  }
  
  private boolean b(View paramView, int paramInt1, int paramInt2, float[] paramArrayOfFloat, int paramInt3, boolean paramBoolean1, boolean paramBoolean2)
  {
    return b(paramView, paramInt1, paramInt2, paramArrayOfFloat, paramInt3, paramBoolean1, paramBoolean2, false);
  }
  
  private boolean b(View paramView, int paramInt1, int paramInt2, float[] paramArrayOfFloat, int paramInt3, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    int i4 = 0;
    if ((paramView != null) && (paramArrayOfFloat != null))
    {
      if (paramArrayOfFloat.length < 5) {
        return false;
      }
      ViewGroup localViewGroup = a(paramInt2, paramBoolean2, paramBoolean3);
      if (localViewGroup == null) {
        return false;
      }
      if (b(paramInt1) != null) {
        return false;
      }
      float f4 = paramArrayOfFloat[0];
      float f3 = paramArrayOfFloat[1];
      float f1 = paramArrayOfFloat[2];
      float f2 = paramArrayOfFloat[3];
      int i5 = (int)paramArrayOfFloat[4];
      paramArrayOfFloat = new ViewGroup.LayoutParams((int)f1, (int)f2);
      int i2 = a(paramInt2, i5);
      int i1 = i2;
      if (i2 < 0) {
        i1 = 0;
      }
      if ((localViewGroup instanceof r)) {
        i2 = ((r)localViewGroup).getTargetViewChildCount();
      } else {
        i2 = localViewGroup.getChildCount();
      }
      int i3 = i1;
      if (i1 > i2) {
        i3 = i2;
      }
      if (paramInt3 >= 0)
      {
        if (paramInt3 == 0) {
          paramInt3 = i4;
        } else {
          paramInt3 = 4;
        }
        paramView.setVisibility(paramInt3);
      }
      localViewGroup.addView(paramView, i3, paramArrayOfFloat);
      paramArrayOfFloat = a(paramView, paramInt1, paramInt2, i5, paramBoolean1, paramBoolean2, paramBoolean3);
      f2 = f4;
      f1 = f3;
      if (paramInt2 == 0)
      {
        f2 = f4;
        f1 = f3;
        if ((localViewGroup instanceof bd))
        {
          f2 = f4;
          f1 = f3;
          if (paramBoolean1)
          {
            ab.a locala = new ab.a(null);
            locala.a = paramView;
            locala.b = f4;
            locala.c = f3;
            locala.d = this.b.getScrollX();
            locala.e = this.b.getScrollY();
            f2 = f4 + locala.d;
            f1 = f3 + locala.e;
            ((bd)localViewGroup).a(locala);
            paramArrayOfFloat.h = locala;
          }
        }
      }
      paramView.setX(f2);
      paramView.setY(f1);
      return true;
    }
    return false;
  }
  
  private List<ab.b> c(ab.b paramb)
  {
    if (paramb.c == paramb.b) {
      return new LinkedList();
    }
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = this.d.iterator();
    while (localIterator.hasNext())
    {
      ab.b localb = (ab.b)localIterator.next();
      if ((paramb.b == localb.c) && (paramb.c != localb.b)) {
        localLinkedList.addAll(c(localb));
      }
    }
    localLinkedList.add(paramb);
    return localLinkedList;
  }
  
  private void d(ab.b paramb)
  {
    Object localObject = new LinkedList(this.d);
    o.d("MicroMsg.AppBrandWebViewCustomViewContainer", "dumpViewInfoBeforeCrash: oops");
    o.d("MicroMsg.AppBrandWebViewCustomViewContainer", "dumpViewInfoBeforeCrash: root: [id] = %d [parent] = %d", new Object[] { Integer.valueOf(paramb.b), Integer.valueOf(paramb.c) });
    o.d("MicroMsg.AppBrandWebViewCustomViewContainer", "==================ViewInfoListBegin==================");
    paramb = ((LinkedList)localObject).iterator();
    int i1 = -1;
    while (paramb.hasNext())
    {
      localObject = (ab.b)paramb.next();
      i1 += 1;
      o.d("MicroMsg.AppBrandWebViewCustomViewContainer", "dumpViewInfoBeforeCrash: vi#%d [id] = %d [parent] = %d", new Object[] { Integer.valueOf(i1), Integer.valueOf(((ab.b)localObject).b), Integer.valueOf(((ab.b)localObject).c) });
    }
    o.d("MicroMsg.AppBrandWebViewCustomViewContainer", "==================ViewInfoListEnd==================");
    o.b();
    paramb = new StackOverflowError();
    for (;;)
    {
      throw paramb;
    }
  }
  
  private void e(ab.b paramb)
  {
    o.d("MicroMsg.AppBrandWebViewCustomViewContainer", "removeViewInfo: [%d, %d]", new Object[] { Integer.valueOf(paramb.b), Integer.valueOf(paramb.c) });
    this.d.remove(paramb);
  }
  
  private void h()
  {
    if (this.l == null)
    {
      this.l = new q(this.b.getContext());
      ao localao = this.k;
      if (localao != null) {
        localao.a(this.l);
      }
    }
  }
  
  private void i()
  {
    if (this.m == null)
    {
      this.m = new FrameLayout(this.b.getContext());
      ar localar = this.n;
      if (localar != null) {
        localar.a(this.m);
      }
    }
  }
  
  private void j()
  {
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = this.d.iterator();
    while (localIterator.hasNext()) {
      localLinkedList.add((ab.b)localIterator.next());
    }
    localIterator = localLinkedList.iterator();
    while (localIterator.hasNext()) {
      j(((ab.b)localIterator.next()).b);
    }
    localLinkedList.clear();
  }
  
  private boolean j(int paramInt)
  {
    ab.b localb = k(paramInt);
    if (localb == null) {
      return false;
    }
    l(paramInt);
    b(localb);
    ViewGroup localViewGroup = a(localb.c, localb.f, localb.g);
    if (localViewGroup != null)
    {
      e(localb);
      localViewGroup.removeView((View)localb.a.get());
      if ((localb.c == 0) && ((localViewGroup instanceof bd)) && (localb.e)) {
        ((bd)localViewGroup).b(localb.h);
      }
      return true;
    }
    return false;
  }
  
  private ab.b k(int paramInt)
  {
    Iterator localIterator = this.d.iterator();
    while (localIterator.hasNext())
    {
      ab.b localb = (ab.b)localIterator.next();
      if (localb.b == paramInt) {
        return localb;
      }
    }
    return null;
  }
  
  private void k()
  {
    ab.b localb = k(this.j);
    float[] arrayOfFloat = this.f;
    if ((localb != null) && (localb.a != null))
    {
      if (arrayOfFloat == null) {
        return;
      }
      View localView = (View)localb.a.get();
      if (localView == null) {
        return;
      }
      int i1 = this.j;
      int i2 = this.e;
      if (i1 != i2)
      {
        Object localObject = k(i2);
        if ((localObject != null) && (((ab.b)localObject).a != null))
        {
          localObject = (View)((ab.b)localObject).a.get();
          if (localObject != null) {
            b(this.e, arrayOfFloat, ((View)localObject).getVisibility(), Boolean.valueOf(localb.e), Boolean.valueOf(false));
          }
        }
      }
      i1 = this.j;
      this.e = -1;
      this.j = -1;
      b(i1, arrayOfFloat, localView.getVisibility(), Boolean.valueOf(localb.e), Boolean.valueOf(false));
    }
  }
  
  private boolean l(int paramInt)
  {
    if (paramInt != this.e) {
      return false;
    }
    if (k(paramInt) == null) {
      return false;
    }
    this.i.c();
    return true;
  }
  
  public View a()
  {
    return this.b;
  }
  
  public <T extends View> T a(Class<T> paramClass)
  {
    return a(this.b, paramClass);
  }
  
  protected final ViewGroup a(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean2) {
      return e();
    }
    if (paramBoolean1) {
      return d();
    }
    if (paramInt == 0) {
      return this.b;
    }
    Object localObject = k(paramInt);
    if (localObject == null) {
      return null;
    }
    localObject = (View)((ab.b)localObject).a.get();
    if (((localObject instanceof e)) && ((localObject instanceof com.tencent.luggage.wxa.kt.s)) && ((localObject instanceof ViewGroup))) {
      return (ViewGroup)((e)localObject).a(com.tencent.luggage.wxa.ks.a.class);
    }
    if (((localObject instanceof com.tencent.luggage.wxa.kt.s)) && ((localObject instanceof ViewGroup))) {
      return (ViewGroup)localObject;
    }
    return null;
  }
  
  public a.b a(int paramInt)
  {
    com.tencent.luggage.wxa.id.a locala = com.tencent.luggage.wxa.id.a.a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(hashCode());
    localStringBuilder.append("#");
    localStringBuilder.append(paramInt);
    return locala.b(localStringBuilder.toString());
  }
  
  public a.b a(int paramInt, boolean paramBoolean)
  {
    com.tencent.luggage.wxa.id.a locala = com.tencent.luggage.wxa.id.a.a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(hashCode());
    localStringBuilder.append("#");
    localStringBuilder.append(paramInt);
    return locala.a(localStringBuilder.toString(), paramBoolean);
  }
  
  public void a(d paramd)
  {
    this.i = paramd;
    this.i.a(new ab.1(this));
  }
  
  protected final void a(ab.b paramb)
  {
    o.d("MicroMsg.AppBrandWebViewCustomViewContainer", "addViewInfo: [%d, %d]", new Object[] { Integer.valueOf(paramb.b), Integer.valueOf(paramb.c) });
    this.d.add(paramb);
  }
  
  public void a(ao paramao)
  {
    boolean bool = true;
    if (paramao == null) {
      bool = false;
    }
    o.d("MicroMsg.AppBrandWebViewCustomViewContainer", "setFullScreenViewObtainer fullScreenViewAttacher:%b", new Object[] { Boolean.valueOf(bool) });
    this.k = paramao;
    paramao = this.l;
    if (paramao != null) {
      this.k.a(paramao);
    }
  }
  
  public void a(ar paramar)
  {
    boolean bool = true;
    if (paramar == null) {
      bool = false;
    }
    o.d("MicroMsg.AppBrandWebViewCustomViewContainer", "setUnderViewAttacher notnull:%b", new Object[] { Boolean.valueOf(bool) });
    this.n = paramar;
    if (this.m != null)
    {
      if ((!a) && (this.n == null)) {
        throw new AssertionError();
      }
      this.n.a(this.m);
    }
  }
  
  public boolean a(int paramInt1, bc parambc, int paramInt2)
  {
    parambc = new ab.6(this, 1000L, Boolean.valueOf(false), paramInt1, parambc, paramInt2);
    if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
      return ((Boolean)parambc.a(null)).booleanValue();
    }
    return ((Boolean)parambc.a(this.c)).booleanValue();
  }
  
  public boolean a(int paramInt1, float[] paramArrayOfFloat, int paramInt2, Boolean paramBoolean)
  {
    return a(paramInt1, paramArrayOfFloat, paramInt2, paramBoolean, Boolean.valueOf(false));
  }
  
  public boolean a(int paramInt1, float[] paramArrayOfFloat, int paramInt2, Boolean paramBoolean1, Boolean paramBoolean2)
  {
    paramArrayOfFloat = new ab.5(this, 1000L, Boolean.valueOf(false), paramInt1, paramArrayOfFloat, paramInt2, paramBoolean1, paramBoolean2);
    if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
      return ((Boolean)paramArrayOfFloat.a(null)).booleanValue();
    }
    return ((Boolean)paramArrayOfFloat.a(this.c)).booleanValue();
  }
  
  public boolean a(View paramView, int paramInt1, int paramInt2, float[] paramArrayOfFloat, int paramInt3, boolean paramBoolean)
  {
    return a(paramView, paramInt1, paramInt2, paramArrayOfFloat, paramInt3, paramBoolean, false);
  }
  
  public boolean a(View paramView, int paramInt1, int paramInt2, float[] paramArrayOfFloat, int paramInt3, boolean paramBoolean1, boolean paramBoolean2)
  {
    return a(paramView, paramInt1, paramInt2, paramArrayOfFloat, paramInt3, paramBoolean1, paramBoolean2, false);
  }
  
  public boolean a(View paramView, int paramInt1, int paramInt2, float[] paramArrayOfFloat, int paramInt3, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    paramView = new ab.2(this, 1000L, Boolean.valueOf(false), paramView, paramInt1, paramInt2, paramArrayOfFloat, paramInt3, paramBoolean1, paramBoolean2, paramBoolean3);
    if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
      return ((Boolean)paramView.a(null)).booleanValue();
    }
    return ((Boolean)paramView.a(this.c)).booleanValue();
  }
  
  public View b(int paramInt)
  {
    ab.b localb = k(paramInt);
    if (localb == null) {
      return null;
    }
    return (View)localb.a.get();
  }
  
  public ViewGroup b()
  {
    return a(0, false, false);
  }
  
  public void c()
  {
    long l1 = SystemClock.uptimeMillis();
    MotionEvent localMotionEvent = MotionEvent.obtain(l1, l1, 3, 0.0F, 0.0F, 0);
    localMotionEvent.setSource(4098);
    Iterator localIterator = this.d.iterator();
    while (localIterator.hasNext())
    {
      View localView = (View)((ab.b)localIterator.next()).a.get();
      if (localView != null) {
        localView.dispatchTouchEvent(localMotionEvent);
      }
    }
    localMotionEvent.recycle();
  }
  
  public boolean c(int paramInt)
  {
    return k(paramInt) != null;
  }
  
  public int d(int paramInt)
  {
    ab.b localb = k(paramInt);
    if (localb == null) {
      return 0;
    }
    return localb.c;
  }
  
  public ViewGroup d()
  {
    h();
    return this.l;
  }
  
  public ViewGroup e()
  {
    i();
    return this.m;
  }
  
  public boolean e(int paramInt)
  {
    ab.3 local3 = new ab.3(this, 1000L, Boolean.valueOf(false), paramInt);
    if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
      return ((Boolean)local3.a(null)).booleanValue();
    }
    return ((Boolean)local3.a(this.c)).booleanValue();
  }
  
  public void f()
  {
    ab.4 local4 = new ab.4(this, 1000L, Boolean.valueOf(false));
    if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
      local4.a(null);
    }
    local4.a(this.c);
  }
  
  public boolean f(int paramInt)
  {
    ab.7 local7 = new ab.7(this, 1000L, Boolean.valueOf(false), paramInt);
    if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
      return ((Boolean)local7.a(null)).booleanValue();
    }
    return ((Boolean)local7.a(this.c)).booleanValue();
  }
  
  public void g()
  {
    o.d("MicroMsg.AppBrandWebViewCustomViewContainer", "clear: ");
    this.d.clear();
  }
  
  public boolean g(int paramInt)
  {
    return (this.j == paramInt) || (this.e == paramInt);
  }
  
  public boolean h(int paramInt)
  {
    if (paramInt == 0) {
      return false;
    }
    ab.b localb = k(paramInt);
    if (localb == null) {
      return false;
    }
    View localView = (View)localb.a.get();
    if ((localView instanceof b))
    {
      boolean bool = ((b)localView).c();
      if (bool) {
        return true;
      }
      if ((!bool) && (localb.c > 0)) {
        return h(localb.c);
      }
    }
    return false;
  }
  
  public int i(int paramInt)
  {
    if (paramInt == 0) {
      return -1;
    }
    ab.b localb = k(paramInt);
    if (localb == null) {
      return -1;
    }
    View localView = (View)localb.a.get();
    if ((localView instanceof b))
    {
      boolean bool = ((b)localView).c();
      if (bool) {
        return localb.b;
      }
      if ((!bool) && (localb.c > 0)) {
        return i(localb.c);
      }
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.ab
 * JD-Core Version:    0.7.0.1
 */