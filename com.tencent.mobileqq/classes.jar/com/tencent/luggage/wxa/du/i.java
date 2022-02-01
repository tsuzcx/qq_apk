package com.tencent.luggage.wxa.du;

import android.text.TextUtils;
import com.tencent.luggage.wxa.dq.b.a;
import com.tencent.luggage.wxa.jj.a;
import com.tencent.luggage.wxa.jx.ba;
import com.tencent.luggage.wxa.qw.jy;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.mm.plugin.appbrand.debugger.g;
import com.tencent.mm.plugin.appbrand.debugger.l;
import org.json.JSONObject;

public class i<SERVICE extends c>
  extends e<SERVICE>
  implements com.tencent.mm.plugin.appbrand.debugger.c
{
  public static final b.a a = new i.a(null);
  private com.tencent.mm.plugin.appbrand.debugger.e b;
  private g c;
  
  public i(SERVICE paramSERVICE)
  {
    super(paramSERVICE);
    super.a(com.tencent.mm.plugin.appbrand.debugger.c.class, this);
  }
  
  protected void a(com.tencent.luggage.wxa.iu.d paramd)
  {
    ((c)y()).M();
    if (l.a != null)
    {
      this.b = l.a;
      l.a = null;
    }
    else
    {
      this.b = new com.tencent.mm.plugin.appbrand.debugger.e();
    }
    this.b.a((c)y(), ((c)y()).i().j().k);
    this.c.a(this.b);
  }
  
  public void a(String paramString)
  {
    o.e("Luggage.MPRemoteDebugServiceLogic", "RemoteDebugInfo %s", new Object[] { paramString });
    jy localjy = new jy();
    localjy.b = ((c)y()).f().getComponentId();
    localjy.a = paramString;
    paramString = l.a(localjy, this.b, "domEvent");
    this.c.a(paramString);
  }
  
  public boolean a(int paramInt, String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "{}";
    }
    this.c.a(paramInt, str);
    return true;
  }
  
  public boolean a(String paramString1, String paramString2, int paramInt)
  {
    String str = paramString2;
    if (TextUtils.isEmpty(paramString2)) {
      str = "{}";
    }
    o.e("Luggage.MPRemoteDebugServiceLogic", "dispatch, event: %s, data size: %s, srcId: %d", new Object[] { paramString1, Integer.valueOf(str.length()), Integer.valueOf(paramInt) });
    this.c.a(paramString1);
    ba.b(this.c, paramString1, str, paramInt);
    return true;
  }
  
  public String b()
  {
    JSONObject localJSONObject = ((c)y()).j();
    String str = ((c)y()).i().aj().b;
    return String.format("var __wxConfig = %s;\nvar __wxIndexPage = \"%s\"", new Object[] { localJSONObject.toString(), str });
  }
  
  public boolean b(String paramString)
  {
    return false;
  }
  
  public boolean d()
  {
    return false;
  }
  
  protected com.tencent.mm.plugin.appbrand.jsruntime.i e()
  {
    this.c = new g();
    return this.c;
  }
  
  public void p()
  {
    super.p();
    this.c.a();
  }
  
  protected void v()
  {
    C();
  }
  
  protected void w() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.du.i
 * JD-Core Version:    0.7.0.1
 */