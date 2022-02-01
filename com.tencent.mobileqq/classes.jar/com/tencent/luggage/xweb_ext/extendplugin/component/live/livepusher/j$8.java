package com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher;

import com.tencent.luggage.wxa.gc.a.b;
import com.tencent.luggage.wxa.qz.o;
import org.json.JSONObject;

class j$8
  implements a.b
{
  j$8(j paramj, int paramInt, com.tencent.luggage.wxa.fx.a parama, JSONObject paramJSONObject1, String[] paramArrayOfString, j.b paramb, JSONObject paramJSONObject2) {}
  
  public void a(String paramString)
  {
    paramString = j.g(this.g);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("convertPathAndApplyMakeupInner#onLoadFailure#");
    localStringBuilder.append(this.a);
    o.c(paramString, localStringBuilder.toString());
    this.b.a("fail");
  }
  
  public void a(String paramString1, String paramString2)
  {
    String str = "fail";
    o.d(j.g(this.g), "convertPathAndApplyMakeupInner#onLoad#%d, path: %s, localPath: %s", new Object[] { Integer.valueOf(this.a), paramString1, paramString2 });
    try
    {
      this.c.put(this.d[this.a], paramString2);
      if (j.l(this.g) == null)
      {
        o.c(j.g(this.g), "convertPathAndApplyMakeupInner#onLoad#%d, adapter is null", new Object[] { Integer.valueOf(this.a) });
        return;
      }
      paramString1 = this.e;
      paramString1.a -= 1;
      o.d(j.g(this.g), "convertPathAndApplyMakeupInner#onLoad#%d, pendingConvertCount: %d", new Object[] { Integer.valueOf(this.a), Integer.valueOf(this.e.a) });
      if (this.e.a == 0)
      {
        com.tencent.luggage.wxa.fz.a locala = j.l(this.g).a("applyMakeup", this.f);
        o.d(j.g(this.g), "convertResourcePathWorkaroundAndOperateLivePusher1#onLoad#%d, type:applyMakeup, error:[%s, %s]", new Object[] { Integer.valueOf(this.a), Integer.valueOf(locala.a), locala.b });
        paramString2 = this.b;
        paramString1 = str;
        if (locala.a == 0) {
          paramString1 = "ok";
        }
        paramString2.a(paramString1);
      }
      return;
    }
    catch (Exception paramString1)
    {
      o.c(j.g(this.g), "convertPathAndApplyMakeupInner#onLoad#%d, put fail since %s", new Object[] { Integer.valueOf(this.a), paramString1 });
      this.b.a("fail");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.j.8
 * JD-Core Version:    0.7.0.1
 */