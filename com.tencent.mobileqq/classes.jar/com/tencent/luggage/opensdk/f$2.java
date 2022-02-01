package com.tencent.luggage.opensdk;

import com.tencent.luggage.wxa.iu.b;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.ro.e.a;
import com.tencent.mm.plugin.appbrand.widget.dialog.i;
import com.tencent.mm.plugin.appbrand.widget.dialog.l;

class f$2
  implements e.a
{
  f$2(f paramf, b paramb, int paramInt) {}
  
  public void a(Object paramObject)
  {
    if (this.a.d())
    {
      localObject = this.a.getDialogContainer().getCurrentDialog();
      if ((localObject instanceof k)) {
        ((i)localObject).dismiss();
      }
    }
    boolean bool = paramObject instanceof Exception;
    Object localObject = "fail";
    if (bool)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("fail ");
      ((StringBuilder)localObject).append(((Exception)paramObject).getMessage());
      localObject = ((StringBuilder)localObject).toString();
    }
    else if ((paramObject instanceof String))
    {
      localObject = (String)paramObject;
      if (!((String)localObject).startsWith("fail"))
      {
        paramObject = new StringBuilder();
        paramObject.append("fail ");
        paramObject.append((String)localObject);
        localObject = paramObject.toString();
      }
    }
    o.b("Luggage.OpenSDKBridgedJsApi", "invoke onInterrupt appId:%s, callbackId:%d, name:%s message:%s", new Object[] { this.a.getAppId(), Integer.valueOf(this.b), this.c.d(), localObject });
    paramObject = this.c;
    f.a(paramObject, this.a, this.b, paramObject.b((String)localObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.opensdk.f.2
 * JD-Core Version:    0.7.0.1
 */