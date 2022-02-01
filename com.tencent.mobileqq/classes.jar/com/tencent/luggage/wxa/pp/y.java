package com.tencent.luggage.wxa.pp;

import com.tencent.luggage.wxa.pw.e;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.mm.plugin.appbrand.page.ab;
import com.tencent.mm.plugin.appbrand.page.u;
import java.lang.ref.WeakReference;

public abstract class y
  extends i
{
  void a(z paramz)
  {
    if (paramz == null)
    {
      o.c("MicroMsg.AppBrandTextAreaInvokeHandler", "removeInputImpl failed, EditText is null");
      return;
    }
    int i = paramz.getInputId();
    paramz.b(this.e);
    if (this.f == null) {
      paramz = null;
    } else {
      paramz = (u)this.f.get();
    }
    if (paramz == null)
    {
      o.c("MicroMsg.AppBrandTextAreaInvokeHandler", "removeInputImpl(viewId : %s) failed, pageView is null", new Object[] { Integer.valueOf(i) });
      return;
    }
    paramz = paramz.ak();
    if (paramz == null)
    {
      o.c("MicroMsg.AppBrandTextAreaInvokeHandler", "removeInputImpl(viewId : %s) failed, CustomViewContainer is null", new Object[] { Integer.valueOf(i) });
      return;
    }
    o.d("MicroMsg.AppBrandTextAreaInvokeHandler", "removeInputImpl(viewId : %s) success = %s", new Object[] { Integer.valueOf(i), Boolean.valueOf(paramz.e(i)) });
  }
  
  boolean a(z paramz, e parame)
  {
    if (paramz == null)
    {
      o.c("MicroMsg.AppBrandTextAreaInvokeHandler", "addInputImpl failed, EditText is null");
      return false;
    }
    int j = parame.b;
    if (this.f != null)
    {
      Object localObject = (u)this.f.get();
      if (localObject != null)
      {
        localObject = ((u)localObject).ak();
        if (localObject == null)
        {
          o.c("MicroMsg.AppBrandTextAreaInvokeHandler", "addInputImpl(viewId : %s) failed, CustomViewContainer is null", new Object[] { Integer.valueOf(j) });
          return false;
        }
        int i;
        if ((parame.B != null) && (parame.B.booleanValue())) {
          i = 4;
        } else {
          i = 0;
        }
        int k = parame.a;
        float f1 = parame.m.intValue();
        float f2 = parame.l.intValue();
        float f3 = parame.j.intValue();
        float f4 = parame.k.intValue();
        float f5 = 0;
        if ((parame.F != null) && (parame.F.booleanValue())) {
          bool = true;
        } else {
          bool = false;
        }
        boolean bool = ((ab)localObject).a(paramz, j, k, new float[] { f1, f2, f3, f4, f5 }, i, bool);
        o.d("MicroMsg.AppBrandTextAreaInvokeHandler", "addInputImpl(viewId : %s) success = %s, ", new Object[] { Integer.valueOf(j), Boolean.valueOf(bool) });
        return bool;
      }
    }
    o.c("MicroMsg.AppBrandTextAreaInvokeHandler", "addInputImpl(viewId : %s) failed, pageView is null", new Object[] { Integer.valueOf(j) });
    return false;
  }
  
  boolean b(z paramz, e parame)
  {
    if (paramz == null)
    {
      o.c("MicroMsg.AppBrandTextAreaInvokeHandler", "updateInputPosition failed, EditText is null");
      return false;
    }
    int j = paramz.getInputId();
    if (this.f != null)
    {
      paramz = (u)this.f.get();
      if (paramz != null)
      {
        paramz = paramz.ak();
        if (paramz == null)
        {
          o.c("MicroMsg.AppBrandTextAreaInvokeHandler", "updateInputPosition(viewId : %s) failed, CustomViewContainer is null", new Object[] { Integer.valueOf(j) });
          return false;
        }
        int i;
        if ((parame.B != null) && (parame.B.booleanValue())) {
          i = 4;
        } else {
          i = 0;
        }
        float f1 = parame.m.intValue();
        float f2 = parame.l.intValue();
        float f3 = parame.j.intValue();
        float f4 = parame.k.intValue();
        float f5 = 0;
        parame = parame.F;
        boolean bool = paramz.a(j, new float[] { f1, f2, f3, f4, f5 }, i, parame);
        o.d("MicroMsg.AppBrandTextAreaInvokeHandler", "updateInputPosition(viewId : %s) success = %s", new Object[] { Integer.valueOf(j), Boolean.valueOf(bool) });
        return bool;
      }
    }
    o.c("MicroMsg.AppBrandTextAreaInvokeHandler", "updateInputPosition(viewId : %s) failed, pageView is null", new Object[] { Integer.valueOf(j) });
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.pp.y
 * JD-Core Version:    0.7.0.1
 */