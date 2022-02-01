package com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher;

import android.os.Bundle;
import com.tencent.luggage.wxa.gc.a.a;
import com.tencent.luggage.wxa.gc.b;
import com.tencent.luggage.wxa.gl.i;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import java.util.HashMap;

class j$10
  implements a.a
{
  j$10(j paramj) {}
  
  public void a(String paramString1, String paramString2)
  {
    if (!af.c(paramString2))
    {
      paramString1 = i.a(paramString2, false);
      o.d(j.g(this.a), "convertFilterImageToLocalPath, targetPath:%s", new Object[] { paramString1 });
      if (j.l(this.a) != null)
      {
        paramString2 = new Bundle();
        paramString2.putString("filterImage", paramString1);
        j.l(this.a).b(paramString2);
      }
    }
    else
    {
      o.d(j.g(this.a), "convertFilterImageToLocalPath, load filter image fail");
      if (j.b(this.a) != null)
      {
        paramString2 = new HashMap();
        paramString2.put("url", paramString1);
        j.b(this.a).a(this.a.B(), 10005, "load filter image fail", paramString2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.j.10
 * JD-Core Version:    0.7.0.1
 */