package com.tencent.luggage.wxa.pp;

import android.graphics.Rect;
import android.view.View;
import androidx.annotation.NonNull;
import com.tencent.luggage.wxa.nj.a;
import com.tencent.luggage.wxa.pw.e;
import com.tencent.luggage.wxa.pw.h;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.mm.plugin.appbrand.page.u;
import java.lang.ref.WeakReference;
import java.util.Map;

class d
  extends c<s>
{
  int g = 0;
  s h;
  v i;
  h j;
  boolean k;
  boolean l;
  private boolean m;
  
  d(String paramString, @NonNull u paramu, @NonNull e parame)
  {
    super(paramString, paramu, parame.b);
    this.h = new s(paramu.getContext());
    this.g = af.a((Integer)o.a.get(paramString), 0);
  }
  
  private void s()
  {
    com.tencent.luggage.wxa.qz.o.e("MicroMsg.AppBrandInputComponentAsNumber", "[input_switch] disableInputFocus %s", new Object[] { this.h });
    s locals = this.h;
    if (locals != null)
    {
      locals.setFocusable(false);
      this.h.setFocusableInTouchMode(false);
      this.h.setEnabled(false);
    }
  }
  
  private v t()
  {
    v localv = this.i;
    if (localv != null) {
      return localv;
    }
    localv = this.h.getInputPanel();
    this.i = localv;
    return localv;
  }
  
  public boolean a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (this.h == null) {
      return false;
    }
    View localView = ((u)this.e.get()).getContentView();
    if ((this.e.get() != null) && ((this.e.get() instanceof u))) {
      localObject = ((u)this.e.get()).aq();
    } else {
      localObject = null;
    }
    this.i = v.a(localView, (a)localObject);
    this.i.setComponentView(this.j.N.booleanValue());
    this.i.c();
    Object localObject = this.i;
    if (localObject == null) {
      return false;
    }
    this.m = paramBoolean;
    if (paramBoolean) {
      ((v)localObject).b();
    }
    this.l = true;
    i();
    this.i.setXMode(this.g);
    this.i.a(this.h);
    this.i.setOnDoneListener(new d.1(this));
    a(paramInt1, paramInt2);
    l();
    this.l = false;
    return true;
  }
  
  public boolean a(String paramString)
  {
    s locals = this.h;
    if (locals == null) {
      return false;
    }
    locals.b(paramString);
    return true;
  }
  
  protected boolean a(boolean paramBoolean)
  {
    com.tencent.luggage.wxa.qz.o.e("MicroMsg.AppBrandInputComponentAsNumber", "[input_switch] onFocusChanged hasFocus %b, isFocused %b", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(r()) });
    if (!paramBoolean)
    {
      if (this.k) {
        return true;
      }
      if (!r()) {
        return true;
      }
      this.k = true;
      a(h());
      q();
      g();
      this.k = false;
      this.h = null;
      return true;
    }
    if (this.l) {
      return true;
    }
    if (r()) {
      return true;
    }
    this.l = true;
    a(-2, -2, this.m);
    this.l = false;
    return true;
  }
  
  public h b(h paramh)
  {
    h localh = this.j;
    if (localh == null)
    {
      this.j = paramh;
      if (ak.a(paramh.M))
      {
        paramh = this.h;
        if (paramh != null) {
          paramh.setPasswordMode(true);
        }
      }
    }
    else
    {
      localh.a(paramh);
    }
    paramh = this.h;
    if (paramh == null) {
      return null;
    }
    b.a(paramh, this.j);
    return this.j;
  }
  
  Rect d()
  {
    return new Rect(this.j.m.intValue(), this.j.l.intValue(), this.j.m.intValue() + this.j.j.intValue(), this.j.l.intValue() + this.j.k.intValue());
  }
  
  final s m()
  {
    return this.h;
  }
  
  public View n()
  {
    t();
    return this.i;
  }
  
  public boolean o()
  {
    h localh = this.j;
    return (localh != null) && (ak.a(localh.J));
  }
  
  public int p()
  {
    h localh = this.j;
    if ((localh != null) && (localh.G != null)) {
      return this.j.G.intValue();
    }
    return 0;
  }
  
  public boolean q()
  {
    if (t() == null) {
      return false;
    }
    if (r())
    {
      this.i.d();
      s();
      j();
      k();
      return true;
    }
    return false;
  }
  
  public boolean r()
  {
    s locals = this.h;
    boolean bool = false;
    if (locals == null) {
      return false;
    }
    if (locals.isFocused()) {
      return true;
    }
    if (t() == null) {
      return false;
    }
    if (!t().isShown()) {
      return false;
    }
    if (this.i.getAttachedEditText() == this.h) {
      bool = true;
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.pp.d
 * JD-Core Version:    0.7.0.1
 */