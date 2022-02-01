package com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher;

import com.tencent.luggage.wxa.gc.a.b;
import com.tencent.luggage.wxa.qz.o;
import org.json.JSONObject;

class j$6
  implements a.b
{
  j$6(j paramj, com.tencent.luggage.wxa.fx.a parama, JSONObject paramJSONObject, String paramString) {}
  
  public void a(String paramString)
  {
    o.c(j.g(this.d), "convertResourcePathAndOperateLivePusher#onLoadFailure");
    this.a.a("fail");
  }
  
  public void a(String paramString1, String paramString2)
  {
    Object localObject = "fail";
    o.d(j.g(this.d), "convertResourcePathAndOperateLivePusher#onLoad, path: %s, localPath: %s", new Object[] { paramString1, paramString2 });
    try
    {
      this.b.put("path", paramString2);
      if (j.l(this.d) == null)
      {
        o.c(j.g(this.d), "convertResourcePathAndOperateLivePusher#onLoad, adapter is null");
        return;
      }
      com.tencent.luggage.wxa.fz.a locala = j.l(this.d).a(this.c, this.b);
      o.d(j.g(this.d), "convertResourcePathAndOperateLivePusher#onLoad, type:%s, error:[%s, %s]", new Object[] { this.c, Integer.valueOf(locala.a), locala.b });
      paramString2 = this.a;
      paramString1 = (String)localObject;
      if (locala.a == 0) {
        paramString1 = "ok";
      }
      paramString2.a(paramString1);
      return;
    }
    catch (Exception paramString1)
    {
      paramString2 = j.g(this.d);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("convertResourcePathAndOperateLivePusher#onLoad, put fail since ");
      ((StringBuilder)localObject).append(paramString1);
      o.c(paramString2, ((StringBuilder)localObject).toString());
      this.a.a("fail");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.j.6
 * JD-Core Version:    0.7.0.1
 */