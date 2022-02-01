package com.tencent.luggage.wxa.lo;

import android.content.Context;
import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import com.tencent.luggage.wxa.jx.ah;
import com.tencent.luggage.wxa.jx.e;
import com.tencent.luggage.wxa.jx.e.a;
import com.tencent.luggage.wxa.jx.m;
import com.tencent.luggage.wxa.pd.j.a;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.mm.plugin.appbrand.widget.picker.b;
import java.lang.ref.WeakReference;
import java.util.Map;
import org.json.JSONObject;

public abstract class d
  extends b
{
  @NonNull
  private static j.a f = com.tencent.luggage.wxa.pd.a.a;
  String a;
  private m b;
  private WeakReference<e> c;
  private int d;
  private final boolean e = true;
  
  public static void a(@NonNull j.a parama)
  {
    f = parama;
  }
  
  protected final View a()
  {
    try
    {
      View localView = ((e)this.c.get()).getCustomViewContainer().a();
      return localView;
    }
    catch (NullPointerException localNullPointerException)
    {
      label23:
      break label23;
    }
    o.c("MicroMsg.AppBrand.JsApiPickerHandler", "getInvokerView: return a null invoker view");
    return null;
  }
  
  protected com.tencent.mm.plugin.appbrand.widget.picker.a a(Context paramContext)
  {
    paramContext = super.a(paramContext);
    o.e("MicroMsg.AppBrand.JsApiPickerHandler", "createPanel, hook for setOrientationGetter");
    if (paramContext != null)
    {
      Object localObject = this.c;
      if (localObject != null)
      {
        localObject = (e)((WeakReference)localObject).get();
        if (localObject != null) {
          paramContext.setOrientationGetter(f.a((e)localObject));
        }
      }
    }
    return paramContext;
  }
  
  final void a(ah paramah)
  {
    Object localObject = this.c;
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = (e)((WeakReference)localObject).get();
    }
    if (localObject == null) {
      return;
    }
    paramah.b((com.tencent.luggage.wxa.jx.c)localObject).a();
  }
  
  final void a(m paramm, e parame, JSONObject paramJSONObject, int paramInt, boolean paramBoolean)
  {
    this.b = paramm;
    this.c = new WeakReference(parame);
    this.d = paramInt;
    a(paramJSONObject);
  }
  
  protected final void a(Runnable paramRunnable)
  {
    if (paramRunnable == null) {
      return;
    }
    Object localObject = this.c;
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = (e)((WeakReference)localObject).get();
    }
    if (localObject == null) {
      return;
    }
    ((e)localObject).a(paramRunnable);
  }
  
  final void a(String paramString)
  {
    a(paramString, null);
  }
  
  final void a(String paramString, Map<String, Object> paramMap)
  {
    WeakReference localWeakReference = this.c;
    if ((localWeakReference != null) && (localWeakReference.get() != null) && (this.b != null)) {
      ((e)this.c.get()).a(this.d, this.b.a(paramString, paramMap));
    }
  }
  
  @CallSuper
  void a(JSONObject paramJSONObject)
  {
    this.a = paramJSONObject.optString("headerText");
    b(paramJSONObject);
  }
  
  @MainThread
  final void b()
  {
    if ((com.tencent.mm.plugin.appbrand.widget.picker.c)a(com.tencent.mm.plugin.appbrand.widget.picker.c.class) == null)
    {
      o.b("MicroMsg.AppBrand.JsApiPickerHandler", "showEmptyView settlePicker returns NULL");
      return;
    }
    c().setOnResultListener(new d.1(this));
    c().a();
  }
  
  abstract void b(JSONObject paramJSONObject);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.lo.d
 * JD-Core Version:    0.7.0.1
 */