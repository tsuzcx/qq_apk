package com.tencent.mm.plugin.appbrand.widget.picker;

import android.content.Context;
import android.view.View;
import com.tencent.luggage.wxa.lo.c;
import com.tencent.luggage.wxa.pp.n;
import com.tencent.luggage.wxa.qz.o;
import org.joor.Reflect;

public abstract class b
{
  private a a;
  
  private a a(boolean paramBoolean)
  {
    Object localObject = this.a;
    if (localObject != null) {
      return localObject;
    }
    View localView = a();
    if (localView == null) {
      return null;
    }
    n localn = n.a(localView);
    if (localn == null) {
      return null;
    }
    a locala = a.a(localn);
    localObject = locala;
    if (locala == null)
    {
      localObject = locala;
      if (paramBoolean)
      {
        localObject = a(localView.getContext());
        localn.a((View)localObject, true);
      }
    }
    return localObject;
  }
  
  private a b()
  {
    a locala = a(true);
    this.a = locala;
    return locala;
  }
  
  protected abstract View a();
  
  protected final <T extends c> T a(Class<T> paramClass)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("");
    ((StringBuilder)localObject).append(paramClass.getSimpleName());
    o.e("MicroMsg.AppBrandBottomPickerInvokeHandler", ((StringBuilder)localObject).toString());
    localObject = b();
    if (localObject == null) {
      return null;
    }
    try
    {
      ((a)localObject).setPickerImpl((c)Reflect.on(paramClass).create(new Object[] { ((a)localObject).getContext() }).get());
      return ((a)localObject).getPicker();
    }
    catch (Exception paramClass) {}
    return null;
  }
  
  protected a a(Context paramContext)
  {
    return new a(paramContext);
  }
  
  protected final <T extends c> T b(Class<T> paramClass)
  {
    a locala = a(false);
    if ((locala != null) && (paramClass.isInstance(locala.getPicker()))) {
      return locala.getPicker();
    }
    return null;
  }
  
  protected final a c()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.picker.b
 * JD-Core Version:    0.7.0.1
 */