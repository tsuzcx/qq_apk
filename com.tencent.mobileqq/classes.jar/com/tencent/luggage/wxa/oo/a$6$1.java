package com.tencent.luggage.wxa.oo;

import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.mm.plugin.appbrand.widget.dialog.g;
import java.util.ArrayList;

class a$6$1
  implements g
{
  a$6$1(a.6 param6) {}
  
  public void a(int paramInt1, @Nullable ArrayList<String> paramArrayList, int paramInt2)
  {
    if (paramInt1 != 1)
    {
      if (paramInt1 != 2)
      {
        if (paramInt1 != 3) {
          return;
        }
        a.b().c(this.a.d, this.a.e);
        o.d("MicroMsg.AppBrandJsApiUserAuth", "requestUserAuth, user cancel, appId %s, api %s", new Object[] { this.a.d, this.a.e });
        a.b(this.a.m).b();
        return;
      }
      a.a(this.a.m, this.a.c, 2);
      a.b().c(this.a.d, this.a.e);
      o.d("MicroMsg.AppBrandJsApiUserAuth", "requestUserAuth, user deny, appId %s, api %s", new Object[] { this.a.d, this.a.e });
      a.b(this.a.m).a(null);
      return;
    }
    a.a(this.a.m, this.a.c, 1);
    a.b().b(this.a.d, this.a.e);
    o.d("MicroMsg.AppBrandJsApiUserAuth", "requestUserAuth, user confirm, appId %s, api %s", new Object[] { this.a.d, this.a.e });
    a.b(this.a.m).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.oo.a.6.1
 * JD-Core Version:    0.7.0.1
 */