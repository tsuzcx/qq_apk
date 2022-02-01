package com.tencent.luggage.opensdk;

import android.content.Intent;
import com.tencent.luggage.ui.OpenSDKBridgedActivity;
import com.tencent.luggage.util.LuggageActivityHelper;
import com.tencent.luggage.util.LuggageActivityHelper.ILuggageActivityHelper;
import com.tencent.luggage.wxa.iu.b;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram.Req;
import com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram.Resp;
import com.tencent.mm.plugin.appbrand.page.u;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import org.json.JSONObject;

public abstract class f<CONTEXT extends b>
  extends com.tencent.luggage.wxa.jx.a<CONTEXT>
  implements LuggageActivityHelper.ILuggageActivityHelper
{
  static
  {
    d.a(WXLaunchMiniProgram.Resp.class, new f.1());
  }
  
  public static <CONTEXT extends a.a> g.a a(CONTEXT paramCONTEXT, String paramString, JSONObject paramJSONObject, int paramInt)
  {
    boolean bool = paramCONTEXT instanceof a.b;
    if (bool) {
      OpenSDKApiContentProvider.a(((a.b)paramCONTEXT).i(), paramJSONObject);
    }
    Object localObject1 = null;
    if (bool) {
      localObject1 = (com.tencent.luggage.wxa.em.d)((a.b)paramCONTEXT).i().q();
    } else if ((paramCONTEXT instanceof b)) {
      localObject1 = (com.tencent.luggage.wxa.em.d)((b)paramCONTEXT).q();
    }
    str3 = "";
    if (localObject1 != null)
    {
      str4 = ((com.tencent.luggage.wxa.em.d)localObject1).G().i();
      str5 = ((com.tencent.luggage.wxa.em.d)localObject1).G().h();
    }
    try
    {
      com.tencent.luggage.wxa.ct.a locala = ((com.tencent.luggage.wxa.em.c)((com.tencent.luggage.wxa.em.d)localObject1).k().getCurrentPage().getCurrentPageView()).r();
      str1 = str3;
      str2 = str4;
      localObject1 = str5;
      if (locala == null) {
        break label162;
      }
      str1 = locala.getCurrentURL();
      str2 = str4;
      localObject1 = str5;
    }
    catch (NullPointerException localNullPointerException)
    {
      for (;;)
      {
        String str1 = str3;
        String str2 = str4;
        Object localObject2 = str5;
      }
    }
    str2 = "";
    localObject1 = str2;
    str1 = str3;
    label162:
    return new g.a().a(paramString).a(paramInt).j(str2).i((String)localObject1).h(paramCONTEXT.a()).e(com.tencent.luggage.wxa.dg.d.a.d()).g(com.tencent.luggage.wxa.dd.i.a.e()).f("Test").c(paramCONTEXT.f()).k(paramCONTEXT.g()).l(paramCONTEXT.h()).b(1).m(str1).a(true).b(paramJSONObject.toString()).c(paramCONTEXT.b()).d(b(paramCONTEXT)).b(a(paramCONTEXT));
  }
  
  public static <CONTEXT extends b> g.a a(CONTEXT paramCONTEXT, String paramString, JSONObject paramJSONObject, int paramInt)
  {
    return a(a.b.a.a(paramCONTEXT), paramString, paramJSONObject, paramInt);
  }
  
  public static String a(com.tencent.luggage.wxa.jx.h paramh)
  {
    boolean bool = paramh.q().B() instanceof com.tencent.luggage.wxa.do.c;
    String str = "";
    if (bool)
    {
      str = ((com.tencent.luggage.wxa.do.c)paramh.q().B()).b;
      if (str.endsWith("@app")) {
        return str.replace("@app", "");
      }
    }
    return str;
  }
  
  public static void a(int paramInt, WXLaunchMiniProgram.Req paramReq, f.a parama)
  {
    o.e("Luggage.OpenSDKBridgedJsApi", "send mini program launch request: %s", new Object[] { paramReq.path });
    d.a(b(paramInt), paramReq, new f.7(parama));
  }
  
  private void a(CONTEXT paramCONTEXT, int paramInt, String paramString)
  {
    if (k_())
    {
      Intent localIntent = new Intent();
      localIntent.setClass(paramCONTEXT.getContext(), OpenSDKBridgedActivity.class);
      LuggageActivityHelper.FOR(paramCONTEXT.getContext()).startActivityForResult(localIntent, new f.4(this, paramCONTEXT, paramInt, paramString));
      return;
    }
    paramCONTEXT.a(paramInt, paramString);
  }
  
  public static boolean a(Object paramObject)
  {
    if ((paramObject instanceof a.b)) {
      return a(((a.b)paramObject).i());
    }
    if ((paramObject instanceof b))
    {
      com.tencent.luggage.wxa.iu.d locald = ((b)paramObject).q();
      if ((locald instanceof com.tencent.luggage.wxa.em.d)) {
        return ((com.tencent.luggage.wxa.em.d)locald).t();
      }
    }
    o.b("Luggage.OpenSDKBridgedJsApi", "invalid isGame type: %s", new Object[] { paramObject.getClass() });
    return false;
  }
  
  private static String b(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(paramInt);
    return localStringBuilder.toString();
  }
  
  public static String b(Object paramObject)
  {
    if ((paramObject instanceof a.b)) {
      return b(((a.b)paramObject).i());
    }
    if ((paramObject instanceof com.tencent.luggage.wxa.iu.h)) {
      return "appservice";
    }
    if ((paramObject instanceof u)) {
      return "webview";
    }
    o.b("Luggage.OpenSDKBridgedJsApi", "invalid jsapi env type: %s", new Object[] { paramObject.getClass() });
    return "appservice";
  }
  
  private com.tencent.luggage.wxa.ro.d<String> c(CONTEXT paramCONTEXT, JSONObject paramJSONObject, int paramInt)
  {
    return com.tencent.luggage.wxa.ro.h.a().b(new f.6(this, paramCONTEXT, paramJSONObject, paramInt)).b(new f.5(this, paramCONTEXT, paramInt));
  }
  
  private String c(String paramString)
  {
    try
    {
      paramString = URLEncoder.encode(paramString, "utf-8");
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      label10:
      break label10;
    }
    return "";
  }
  
  public com.tencent.luggage.wxa.ro.d<String> a(CONTEXT paramCONTEXT, JSONObject paramJSONObject, int paramInt)
  {
    return com.tencent.luggage.wxa.ro.h.a().a(new f.8(this, paramCONTEXT, paramJSONObject, paramInt));
  }
  
  protected String a(String paramString)
  {
    return paramString;
  }
  
  public void b(CONTEXT paramCONTEXT, JSONObject paramJSONObject, int paramInt)
  {
    o.d("Luggage.OpenSDKBridgedJsApi", "redirect jsapi %s call via open sdk, callbackId=%d", new Object[] { d(), Integer.valueOf(paramInt) });
    if (e.a())
    {
      if (i.a.a())
      {
        a.c localc = new a.c();
        localc.a = a.b.a.a(paramCONTEXT);
        localc.b = d();
        localc.c = paramJSONObject.toString();
        localc.d = paramInt;
        localc.e = 1;
        paramJSONObject = i.a.a(localc);
      }
      else
      {
        paramJSONObject = c(paramCONTEXT, paramJSONObject, paramInt);
      }
    }
    else
    {
      if (!com.tencent.luggage.wxa.qz.c.h) {
        break label162;
      }
      paramJSONObject = m.a(paramCONTEXT, this, paramJSONObject, paramInt);
    }
    paramJSONObject.a(new f.3(this, paramCONTEXT, paramInt)).a(com.tencent.luggage.wxa.rp.d.a, new f.2(this, paramCONTEXT, paramInt));
    return;
    label162:
    o.b("Luggage.OpenSDKBridgedJsApi", "redirect jsapi %s call via open sdk, callbackId=%d, no invoker supported", new Object[] { d(), Integer.valueOf(paramInt) });
    paramCONTEXT.a(paramInt, b("fail wechat not installed"));
  }
  
  protected boolean k_()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.opensdk.f
 * JD-Core Version:    0.7.0.1
 */