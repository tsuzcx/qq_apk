package com.tencent.luggage.wxa.pp;

import android.graphics.Rect;
import android.text.Editable;
import android.text.Selection;
import android.view.View.OnFocusChangeListener;
import android.widget.EditText;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import com.tencent.luggage.wxa.pq.d;
import com.tencent.luggage.wxa.rj.b.a;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.ui.widget.MMTextWatcherAdapter;
import java.lang.ref.WeakReference;

abstract class c<Input extends EditText,  extends ac>
  extends MMTextWatcherAdapter
  implements ab
{
  ag a;
  af b;
  final int c;
  final String d;
  final WeakReference<u> e;
  final View.OnFocusChangeListener f = new c.1(this);
  private final b.a g = new c.2(this);
  
  c(String paramString, @NonNull u paramu, int paramInt)
  {
    this.d = paramString;
    this.e = new WeakReference(paramu);
    this.c = paramInt;
  }
  
  private void b(Editable paramEditable)
  {
    ag localag = this.a;
    if (localag != null)
    {
      String str;
      if (paramEditable == null) {
        str = "";
      } else {
        str = paramEditable.toString();
      }
      localag.a(str, Selection.getSelectionEnd(paramEditable), ag.a.c);
    }
  }
  
  public final int a()
  {
    return this.c;
  }
  
  public final void a(int paramInt)
  {
    af localaf = this.b;
    if (localaf != null) {
      localaf.a(paramInt);
    }
  }
  
  protected final void a(int paramInt1, int paramInt2)
  {
    b.a(b(), paramInt1, paramInt2);
  }
  
  final void a(Editable paramEditable)
  {
    ag localag = this.a;
    if (localag != null)
    {
      String str;
      if (paramEditable == null) {
        str = "";
      } else {
        str = paramEditable.toString();
      }
      localag.a(str, Selection.getSelectionEnd(paramEditable), ag.a.a);
    }
  }
  
  public void a(af paramaf)
  {
    this.b = paramaf;
  }
  
  public void a(ag paramag)
  {
    this.a = paramag;
  }
  
  final void a(@NonNull com.tencent.luggage.wxa.pw.a.a parama)
  {
    u localu = (u)this.e.get();
    if (localu != null)
    {
      if (b() == null) {
        return;
      }
      d.a(localu, b(), parama);
    }
  }
  
  public final void a(String paramString, Integer paramInteger)
  {
    a(paramString);
    int i;
    if (paramInteger == null) {
      i = -1;
    } else {
      i = paramInteger.intValue();
    }
    paramString = Integer.valueOf(i);
    a(paramString.intValue(), paramString.intValue());
  }
  
  public final boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    u localu = (u)this.e.get();
    if (localu != null)
    {
      if (localu.aj() == null) {
        return false;
      }
      EditText localEditText = b();
      if (localEditText == null) {
        return false;
      }
      g localg = (g)localu.aa();
      if (localg == null) {
        return false;
      }
      boolean bool = localg.a(localu.aj(), localEditText, paramInt1, paramInt2, paramInt3, paramInt4);
      if (bool)
      {
        ((ac)localEditText).a(this.f);
        localEditText.addTextChangedListener(this);
      }
      return bool;
    }
    return false;
  }
  
  final boolean a(com.tencent.luggage.wxa.pw.h paramh)
  {
    paramh = b(paramh);
    if (paramh == null) {
      return false;
    }
    if (paramh.v == null) {
      paramh.v = Integer.valueOf(140);
    } else if (paramh.v.intValue() <= 0) {
      paramh.v = Integer.valueOf(2147483647);
    }
    if (b() == null) {
      return false;
    }
    p.a(b()).b(paramh.v.intValue()).a(false).a(com.tencent.luggage.wxa.ri.a.a.a).a(this.g);
    return true;
  }
  
  public boolean a(u paramu)
  {
    return (paramu != null) && (paramu == this.e.get());
  }
  
  public abstract boolean a(String paramString);
  
  protected abstract boolean a(boolean paramBoolean);
  
  public final void afterTextChanged(Editable paramEditable)
  {
    b(paramEditable);
  }
  
  abstract Input b();
  
  protected abstract com.tencent.luggage.wxa.pw.h b(com.tencent.luggage.wxa.pw.h paramh);
  
  @CallSuper
  void c()
  {
    EditText localEditText = b();
    if (localEditText == null) {
      return;
    }
    u localu = (u)this.e.get();
    if (localu != null)
    {
      if (localu.aj() == null) {
        return;
      }
      g localg = (g)localu.aa();
      if (localg == null) {
        return;
      }
      Rect localRect = d();
      if (localRect == null) {
        return;
      }
      localg.b(localu.aj(), localEditText, localRect.width(), localRect.height(), localRect.left, localRect.top);
    }
  }
  
  abstract Rect d();
  
  public boolean e()
  {
    return g();
  }
  
  public Input f()
  {
    return b();
  }
  
  public final boolean g()
  {
    EditText localEditText = b();
    if (localEditText == null) {
      return false;
    }
    Object localObject = (ac)localEditText;
    ((ac)localObject).b(this.f);
    localEditText.removeTextChangedListener(this);
    ((ac)localObject).p();
    localObject = (u)this.e.get();
    if (localObject == null) {
      return false;
    }
    localObject = (g)((u)localObject).aa();
    if (localObject == null) {
      return false;
    }
    ((g)localObject).a(localEditText);
    return true;
  }
  
  public final Editable h()
  {
    if (b() == null) {
      return null;
    }
    return b().getEditableText();
  }
  
  protected final void i()
  {
    u localu = (u)this.e.get();
    if ((localu != null) && (localu.aj() != null)) {
      h.a().b(localu.aj());
    }
  }
  
  protected final void j()
  {
    u localu = (u)this.e.get();
    if ((localu != null) && (localu.aj() != null)) {
      h.a().c(localu.aj());
    }
  }
  
  void k()
  {
    k.a(this.e).b(a());
  }
  
  void l()
  {
    k.a(this.e).a(a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.pp.c
 * JD-Core Version:    0.7.0.1
 */