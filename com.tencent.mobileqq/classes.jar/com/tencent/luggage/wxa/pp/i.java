package com.tencent.luggage.wxa.pp;

import android.app.Activity;
import android.os.Looper;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView.OnEditorActionListener;
import androidx.annotation.MainThread;
import androidx.core.view.ViewCompat;
import com.tencent.luggage.wxa.pw.e;
import com.tencent.luggage.wxa.pw.h;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.s;
import com.tencent.luggage.wxa.rj.b.a;
import com.tencent.luggage.wxa.rz.f;
import com.tencent.mm.plugin.appbrand.page.am;
import com.tencent.mm.plugin.appbrand.page.u;
import java.lang.ref.WeakReference;
import java.util.Locale;

public abstract class i
  implements ab<z>
{
  private volatile i.c a;
  private volatile i.a b;
  private volatile i.b c;
  private int d = -1;
  final View.OnFocusChangeListener e = new i.11(this);
  protected WeakReference<u> f;
  int g;
  int h;
  private int i = -1;
  private i.d j = null;
  private e k;
  private int l;
  private z m;
  private x n;
  private v o;
  private final b.a p = new i.12(this);
  private final Runnable q = new i.13(this);
  private final com.tencent.luggage.wxa.pt.a r = new com.tencent.luggage.wxa.pt.a();
  private boolean s = false;
  private final Runnable t = new i.14(this);
  private final s u = new s(Looper.getMainLooper());
  private final x.d v = new i.6(this);
  private final x.c w = new i.7(this);
  private final x.e x = new i.8(this);
  
  private v A()
  {
    Object localObject = this.o;
    if (localObject != null) {
      return localObject;
    }
    localObject = this.f;
    if (localObject != null)
    {
      localObject = (u)((WeakReference)localObject).get();
      if (localObject == null) {
        return null;
      }
      if (((u)localObject).getContentView() != null)
      {
        if (!ViewCompat.isAttachedToWindow(((u)localObject).getContentView())) {
          return null;
        }
        localObject = v.a(((u)localObject).getContentView());
        this.o = ((v)localObject);
        return localObject;
      }
    }
    return null;
  }
  
  private void B()
  {
    if (A() != null) {
      this.o.setVisibility(8);
    }
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    b.a(this.m, paramInt1, paramInt2);
    a(false);
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.k.C.booleanValue())
    {
      Object localObject = this.n;
      if ((localObject != null) && (((x)localObject).isShown()))
      {
        localObject = this.m;
        if ((localObject != null) && (localObject == this.n.getAttachedEditText())) {
          if (paramBoolean)
          {
            int i2 = 0;
            localObject = this.f;
            int i1 = i2;
            if (localObject != null)
            {
              i1 = i2;
              if (((WeakReference)localObject).get() != null)
              {
                i1 = i2;
                if (((u)this.f.get()).aa() != null) {
                  i1 = ((u)this.f.get()).aa().getMeasuredHeight() + ((u)this.f.get()).aa().getScrollY();
                }
              }
            }
            i2 = this.h;
            if ((i2 <= this.g) || (i2 - this.m.getLineHeight() > i1))
            {
              i2 = this.h;
              if (((i2 > this.g) || (i2 + this.m.getLineHeight() > i1)) && (this.m.g() < i1)) {}
            }
            else
            {
              k.a(this.f).a(a());
            }
          }
          else
          {
            k.a(this.f).a(a());
          }
        }
      }
    }
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    this.f = this.k.h;
    Object localObject1 = this.f;
    if (localObject1 == null) {
      localObject1 = null;
    } else {
      localObject1 = (u)((WeakReference)localObject1).get();
    }
    if ((localObject1 != null) && (((u)localObject1).aj() != null))
    {
      Object localObject2;
      if (ak.a(this.k.C)) {
        localObject2 = new q(((u)localObject1).getContext());
      } else {
        localObject2 = new t(((u)localObject1).getContext());
      }
      this.m = ((z)localObject2);
      this.l = this.k.b;
      this.m.setInputId(this.l);
      o.a((u)localObject1, this);
      m();
      this.m.setText(af.b(this.k.i));
      if (ak.a(this.k.E)) {
        r();
      }
      this.m.addTextChangedListener(new i.15(this));
      this.m.setOnComposingDismissedListener(new i.16(this));
      this.m.setOnKeyUpPostImeListener(new i.17(this));
      if (!a(this.m, this.k))
      {
        com.tencent.luggage.wxa.qz.o.b("MicroMsg.AppBrandInputInvokeHandler", "add custom view into webView failed");
        b();
        return;
      }
      if ((this.k.g != null) && (!af.a(this.k.g.d))) {
        com.tencent.luggage.wxa.pq.d.a((u)localObject1, this.m, this.k.g);
      }
      if (!ak.a(this.k.C)) {
        b.a(this.m, paramInt1, paramInt2);
      }
      if (ak.a(this.k.C)) {
        this.m.post(new i.18(this));
      }
      if ((!"text".equalsIgnoreCase(this.k.c)) && (!"emoji".equalsIgnoreCase(this.k.c)))
      {
        junit.framework.a.a(String.format(Locale.US, "Unrecognized type(%s) implementation removed from here", new Object[] { this.k.c }), true);
        w();
      }
      else
      {
        w();
      }
      this.m.setOnClickListener(new i.2(this));
      w_();
      return;
    }
    com.tencent.luggage.wxa.qz.o.b("MicroMsg.AppBrandInputInvokeHandler", "insertInputImpl, view not ready, return fail");
    b();
  }
  
  private void b(boolean paramBoolean)
  {
    if (this.n == null) {
      this.n = y();
    }
    if (paramBoolean)
    {
      s();
      if (this.k.C.booleanValue()) {
        com.tencent.luggage.wxa.qz.t.a(this.q, 100L);
      }
    }
    else if (this.m != null)
    {
      if (!this.k.e)
      {
        if (this.j == null) {
          c(false);
        }
        this.m.setFocusable(false);
        this.m.setFocusableInTouchMode(false);
        this.n.b(this.m);
      }
      else
      {
        c(false);
        t();
      }
    }
    if (this.b != null) {
      this.b.a(this.m, paramBoolean);
    }
  }
  
  private void c(boolean paramBoolean)
  {
    Object localObject = this.m;
    if (localObject == null) {
      return;
    }
    localObject = ((z)localObject).getText().toString();
    int i1 = this.m.getSelectionEnd();
    boolean bool;
    if (this.j == i.d.b) {
      bool = true;
    } else {
      bool = false;
    }
    a((String)localObject, i1, bool, paramBoolean);
  }
  
  private boolean g()
  {
    Object localObject = this.f;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localObject != null)
    {
      if (((WeakReference)localObject).get() == null) {
        return false;
      }
      localObject = ((u)this.f.get()).getContext();
      bool1 = bool2;
      if ((localObject instanceof Activity))
      {
        bool1 = bool2;
        if (((Activity)localObject).getCurrentFocus() != null) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  @Deprecated
  @MainThread
  private void h()
  {
    if ((!c()) && (g()))
    {
      com.tencent.luggage.wxa.qz.o.e("MicroMsg.AppBrandInputInvokeHandler", "doHideKeyboard, not focused, return");
      return;
    }
    x localx = y();
    if (localx != null) {
      localx.setVisibility(8);
    }
  }
  
  @Deprecated
  @MainThread
  private void i()
  {
    if (this.m != null)
    {
      WeakReference localWeakReference = this.f;
      if (localWeakReference != null)
      {
        if (localWeakReference.get() == null) {
          return;
        }
        this.m.performClick();
      }
    }
  }
  
  @Deprecated
  @MainThread
  private boolean j()
  {
    if (this.m != null)
    {
      Object localObject1 = this.f;
      if (localObject1 != null)
      {
        if (((WeakReference)localObject1).get() == null) {
          return false;
        }
        this.m.p();
        localObject1 = (g)((u)this.f.get()).aa();
        if (localObject1 == null) {
          return false;
        }
        if (this.m.hasFocus())
        {
          Object localObject2 = this.o;
          if (localObject2 != null) {
            ((v)localObject2).setVisibility(8);
          }
          y();
          localObject2 = this.n;
          if (localObject2 != null) {
            ((x)localObject2).setVisibility(8);
          }
        }
        ((g)localObject1).a(this.m);
        return true;
      }
    }
    return false;
  }
  
  private void k()
  {
    this.m = null;
    com.tencent.luggage.wxa.pd.d.a(this);
  }
  
  private void l()
  {
    if ((this.m != null) && (ak.a(this.k.E)) && (ak.a(this.k.C)))
    {
      ((q)this.m).setAutoHeight(true);
      int i2 = this.m.getLineHeight();
      int i3 = this.m.g();
      int i1;
      if ((this.k.n != null) && (this.k.n.intValue() > 0)) {
        i1 = this.k.n.intValue();
      } else {
        i1 = i2;
      }
      if ((this.k.o != null) && (this.k.o.intValue() > 0)) {
        i2 = Math.max(this.k.o.intValue(), i2);
      } else {
        i2 = 2147483647;
      }
      this.m.setMinHeight(i1);
      this.m.setMaxHeight(i2);
      this.k.k = Integer.valueOf(Math.max(i1, Math.min(i3, i2)));
      b(this.m, this.k);
    }
  }
  
  private void m()
  {
    b.a(this.m, this.k);
    if (this.k.v == null) {
      this.k.v = Integer.valueOf(140);
    } else if (this.k.v.intValue() <= 0) {
      this.k.v = Integer.valueOf(2147483647);
    }
    p.a(this.m).b(this.k.v.intValue()).a(false).a(com.tencent.luggage.wxa.ri.a.a.a).a(this.p);
    this.m.setPasswordMode(this.k.d);
    if (ak.a(this.k.A))
    {
      this.m.setEnabled(false);
      this.m.setFocusable(false);
      this.m.setFocusableInTouchMode(false);
      this.m.setClickable(false);
    }
    else
    {
      this.m.setEnabled(true);
      this.m.setClickable(true);
    }
    if ((this.m instanceof q))
    {
      if (this.k.K != null) {
        ((q)this.m).setLineSpace(this.k.K.intValue());
      }
      if (this.k.L != null) {
        ((q)this.m).setLineHeight(this.k.L.intValue());
      }
    }
  }
  
  private void r()
  {
    z localz = this.m;
    if (localz == null) {
      return;
    }
    if ((localz.getLineCount() == this.d) && (this.m.g() == this.i)) {
      return;
    }
    int i1;
    if (this.d == -1) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    this.d = this.m.getLineCount();
    this.i = this.m.g();
    if (this.a != null) {
      this.a.a(this.d, this.i);
    }
    if ((this.k.C.booleanValue()) && (i1 == 0))
    {
      this.g = (ak.a(this.k.l, 0) + ak.a(this.k.k, 0));
      l();
      this.h = (ak.a(this.k.l, 0) + ak.a(this.k.k, 0));
      a(true);
    }
  }
  
  private void s()
  {
    if (this.k.C.booleanValue()) {
      y();
    }
    x localx = this.n;
    if (localx != null)
    {
      z localz = this.m;
      if (localz != null)
      {
        localx.a(localz);
        this.n.setComponentView(this.k.N.booleanValue());
        this.n.h();
        this.n.setShowDoneButton(ak.a(this.k.D));
        v();
        if ((com.tencent.mm.plugin.appbrand.ui.c.a(this.m)) && (this.m.hasFocus())) {
          this.n.f();
        }
      }
    }
  }
  
  private void t()
  {
    this.n.b(this.m);
    a(this.m);
    this.m.p();
    k();
  }
  
  private void u()
  {
    Object localObject1 = this.f;
    if (localObject1 == null) {
      localObject1 = null;
    } else {
      localObject1 = (u)((WeakReference)localObject1).get();
    }
    if (this.n == null) {
      y();
    }
    Object localObject2 = this.m;
    boolean bool3 = true;
    boolean bool1;
    if (localObject2 == null) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    boolean bool2;
    if (localObject1 == null) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    if (this.n != null) {
      bool3 = false;
    }
    com.tencent.luggage.wxa.qz.o.d("MicroMsg.AppBrandInputInvokeHandler", "ensureInputFocusedWithSoftKeyboard, null==mInput[%b], null==page[%b], null==mSmileyPanel[%b]", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
    if (localObject1 != null)
    {
      localObject2 = this.m;
      if (localObject2 != null)
      {
        if (this.n == null) {
          return;
        }
        o.a((u)localObject1, (ac)localObject2);
        localObject2 = new com.tencent.luggage.wxa.qt.a();
        ((com.tencent.luggage.wxa.qt.a)localObject2).a = false;
        i.3 local3 = new i.3(this, (com.tencent.luggage.wxa.qt.a)localObject2);
        Object localObject3 = com.tencent.luggage.wxa.rh.d.a(((u)localObject1).getContext());
        if ((localObject3 != null) && (((Activity)localObject3).getCurrentFocus() != null))
        {
          localObject3 = ((Activity)localObject3).getCurrentFocus();
          bool1 = ak.a((View)localObject3).isActive((View)localObject3);
          bool2 = ak.a(((u)localObject1).aj().getWrapperView(), (View)localObject3);
          if ((bool1) && (bool2))
          {
            com.tencent.luggage.wxa.qz.o.d("MicroMsg.AppBrandInputInvokeHandler", "ensureInputFocusedWithSoftKeyboard, servedConnecting && servedForWebView, delay checkForInput");
            this.n.setOnVisibilityChangedListener(new i.4(this, (com.tencent.luggage.wxa.qt.a)localObject2, local3));
            f.a.a(new i.5(this, (com.tencent.luggage.wxa.qt.a)localObject2, local3), 100L);
            return;
          }
        }
        local3.run();
      }
    }
  }
  
  private void v()
  {
    x localx = this.n;
    if (localx == null) {
      return;
    }
    localx.setOnSmileyChosenListener(this.v);
    this.n.setOnDoneListener(this.w);
    this.n.setOnVisibilityChangedListener(this.x);
  }
  
  private void w()
  {
    Object localObject = (u)this.f.get();
    if (!ViewCompat.isAttachedToWindow(((u)localObject).getContentView())) {
      return;
    }
    this.n = x.a(((u)localObject).getContentView(), ((u)localObject).aq());
    this.n.setComponentView(this.k.N.booleanValue());
    this.n.h();
    if (this.k.e)
    {
      v();
      B();
    }
    this.m.a(this.e);
    this.m.setOnKeyListener(new i.9(this));
    if (this.k.e) {
      o.a((u)this.f.get(), this.m);
    }
    localObject = this.n;
    boolean bool;
    if ((!this.k.d) && ("emoji".equals(this.k.c))) {
      bool = true;
    } else {
      bool = false;
    }
    ((x)localObject).setCanSmileyInput(bool);
    int i1;
    if (this.k.H == null)
    {
      i1 = com.tencent.luggage.wxa.pw.b.a(this.k.C.booleanValue()).g;
    }
    else
    {
      if ((!this.k.C.booleanValue()) && (com.tencent.luggage.wxa.pw.b.f == this.k.H)) {
        this.k.H = com.tencent.luggage.wxa.pw.b.a(false);
      }
      i1 = this.k.H.g;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("initSmileyPanelAndShow, myImeOption: ");
    ((StringBuilder)localObject).append(i1);
    com.tencent.luggage.wxa.qz.o.e("MicroMsg.AppBrandInputInvokeHandler", ((StringBuilder)localObject).toString());
    localObject = null;
    if ((!this.k.C.booleanValue()) || (i1 != 0)) {
      localObject = new i.10(this, i1);
    }
    this.m.setImeOptions(i1);
    this.m.setOnEditorActionListener((TextView.OnEditorActionListener)localObject);
    this.n.setShowDoneButton(this.k.D.booleanValue());
    this.n.a(this.m);
    if (this.k.e)
    {
      u();
    }
    else
    {
      this.m.setFocusable(false);
      this.m.setFocusableInTouchMode(false);
      this.n.j();
    }
    if (this.k.e) {
      k.a(this.f).a(a());
    }
  }
  
  private void x()
  {
    boolean bool;
    if ((this.j == i.d.b) && (ak.a(this.k.I))) {
      bool = true;
    } else {
      bool = false;
    }
    if (!bool) {
      z();
    }
    Object localObject = this.m;
    if (localObject != null)
    {
      if (((z)localObject).hasFocus()) {
        c(bool);
      }
      if (!bool)
      {
        this.m.b(this.e);
        localObject = this.n;
        if ((localObject != null) && (((x)localObject).b(this.m))) {
          this.n.j();
        }
        this.m.setFocusable(false);
        this.m.setFocusableInTouchMode(false);
        if (this.k.e) {
          t();
        }
      }
    }
  }
  
  private x y()
  {
    Object localObject = this.n;
    if (localObject != null) {
      return localObject;
    }
    localObject = this.f;
    if (localObject != null)
    {
      localObject = (u)((WeakReference)localObject).get();
      if (localObject != null)
      {
        localObject = x.c(((u)localObject).getContentView());
        this.n = ((x)localObject);
        return localObject;
      }
    }
    return null;
  }
  
  private void z()
  {
    if (y() != null)
    {
      this.n.j();
    }
    else
    {
      Object localObject = this.f;
      if (localObject != null)
      {
        localObject = (u)((WeakReference)localObject).get();
        if (localObject == null) {
          return;
        }
        localObject = ((u)localObject).ac();
        if (localObject != null) {
          ((ae)localObject).i();
        }
      }
    }
    k.a(this.f).b(a());
  }
  
  public final int a()
  {
    return this.l;
  }
  
  public final void a(int paramInt)
  {
    i.b localb = this.c;
    if (localb != null) {
      localb.a(this, paramInt);
    }
  }
  
  public void a(i.b paramb)
  {
    this.c = paramb;
  }
  
  public void a(i.c paramc)
  {
    this.a = paramc;
  }
  
  void a(z paramz)
  {
    if (paramz == null) {
      return;
    }
    paramz.b(this.e);
    Object localObject = this.f;
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = (u)((WeakReference)localObject).get();
    }
    if (localObject != null)
    {
      localObject = (g)((u)localObject).aa();
      if (localObject != null) {
        ((g)localObject).a(paramz);
      }
    }
  }
  
  public void a(com.tencent.luggage.wxa.pt.c paramc)
  {
    this.r.a(paramc);
  }
  
  @MainThread
  public final void a(e parame, int paramInt1, int paramInt2)
  {
    this.k = parame;
    parame = (u)parame.h.get();
    if (parame != null) {
      l.a(parame);
    }
    b(paramInt1, paramInt2);
  }
  
  public abstract void a(String paramString);
  
  public abstract void a(String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2);
  
  public void a(String paramString, Integer paramInteger)
  {
    z localz = this.m;
    if (localz == null) {
      return;
    }
    localz.b(paramString);
    int i1;
    if (paramInteger == null) {
      i1 = -1;
    } else {
      i1 = paramInteger.intValue();
    }
    paramString = Integer.valueOf(i1);
    a(paramString.intValue(), paramString.intValue());
    r();
  }
  
  public boolean a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    i();
    a(paramInt1, paramInt2);
    return true;
  }
  
  boolean a(z paramz, e parame)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramz != null)
    {
      Object localObject = this.f;
      bool1 = bool2;
      if (localObject != null)
      {
        if (((WeakReference)localObject).get() == null) {
          return false;
        }
        localObject = (g)((u)this.f.get()).aa();
        bool1 = bool2;
        if (localObject != null)
        {
          bool1 = bool2;
          if (((g)localObject).a(((u)this.f.get()).aj(), paramz, parame.j.intValue(), parame.k.intValue(), parame.m.intValue(), parame.l.intValue())) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  @MainThread
  public final boolean a(h paramh)
  {
    e locale = this.k;
    if (locale != null)
    {
      if (this.m == null) {
        return false;
      }
      locale.a(paramh);
      if ((!this.k.f) && ((this.k.k == null) || (this.k.k.intValue() <= 0))) {
        return false;
      }
      this.m.setWillNotDraw(true);
      m();
      if (this.k.i != null) {
        this.m.b(af.b(this.k.i));
      }
      if (!ak.a(this.k.E))
      {
        b(this.m, this.k);
      }
      else
      {
        paramh = new i.1(this);
        if (this.m.getLayout() == null) {
          this.m.post(paramh);
        } else {
          paramh.run();
        }
      }
      this.m.setWillNotDraw(false);
      this.m.invalidate();
      return true;
    }
    return false;
  }
  
  public boolean a(u paramu)
  {
    if (paramu != null)
    {
      WeakReference localWeakReference = this.f;
      if ((localWeakReference != null) && (paramu == localWeakReference.get())) {
        return true;
      }
    }
    return false;
  }
  
  public abstract void b();
  
  boolean b(z paramz, e parame)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramz != null)
    {
      Object localObject = this.f;
      bool1 = bool2;
      if (localObject != null)
      {
        if (((WeakReference)localObject).get() == null) {
          return false;
        }
        localObject = (g)((u)this.f.get()).aa();
        bool1 = bool2;
        if (localObject != null)
        {
          bool1 = bool2;
          if (((g)localObject).b(((u)this.f.get()).aj(), paramz, parame.j.intValue(), parame.k.intValue(), parame.m.intValue(), parame.l.intValue())) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public boolean c()
  {
    z localz = this.m;
    return (localz != null) && ((localz.isFocused()) || ((y() != null) && (y().getAttachedEditText() == this.m)));
  }
  
  public z d()
  {
    return this.m;
  }
  
  public boolean e()
  {
    if (j())
    {
      k();
      return true;
    }
    return false;
  }
  
  public <P extends View,  extends ad> P n()
  {
    return this.n;
  }
  
  public boolean o()
  {
    e locale = this.k;
    return (locale != null) && (ak.a(locale.J));
  }
  
  public int p()
  {
    Object localObject = this.k;
    if ((localObject != null) && (((e)localObject).G != null)) {
      return this.k.G.intValue();
    }
    localObject = this.m;
    if ((localObject != null) && (((z)localObject).c())) {
      return 5;
    }
    return 0;
  }
  
  public boolean q()
  {
    h();
    return true;
  }
  
  public abstract void w_();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.pp.i
 * JD-Core Version:    0.7.0.1
 */