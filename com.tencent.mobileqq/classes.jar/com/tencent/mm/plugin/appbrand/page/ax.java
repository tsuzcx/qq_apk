package com.tencent.mm.plugin.appbrand.page;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.dq.c;
import com.tencent.luggage.wxa.dq.d.a;
import com.tencent.luggage.wxa.oi.e;
import com.tencent.luggage.wxa.oi.g;
import com.tencent.luggage.wxa.pd.k;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.json.JSONObject;

public class ax<PAGE extends c>
  extends a<PAGE>
  implements g
{
  private static final String[] i = { "custom_event_GenerateFuncReady", "custom_event_tapAnyWhere", "custom_event_vdSync", "onAppRoute", "onAppRouteDone" };
  private boolean c = false;
  private boolean d = false;
  private boolean e = false;
  private e f = null;
  private String g;
  private boolean h;
  private ax.a j;
  private final ba.a k = new ax.3(this);
  
  protected ax(@NonNull PAGE paramPAGE)
  {
    super(paramPAGE);
  }
  
  private void a(String paramString1, String paramString2, String paramString3)
  {
    String str = StringUtils.join(new String[] { paramString1, paramString2, paramString3 }, ":");
    if (TextUtils.isEmpty(str)) {
      return;
    }
    this.g = str;
    HashMap localHashMap = new HashMap();
    localHashMap.put("appId", paramString1);
    localHashMap.put("appUrl", paramString2);
    localHashMap.put("appStatus", paramString3);
    K().setAppBrandInfo(localHashMap);
    if (K().d())
    {
      paramString1 = K();
      paramString2 = new StringBuilder();
      paramString2.append("document.title=\"");
      paramString2.append(k.a(str));
      paramString2.append("\"");
      paramString1.evaluateJavascript(paramString2.toString(), null);
    }
  }
  
  private static URL f(String paramString)
  {
    try
    {
      paramString = new URL("https", "servicewechat.com", paramString);
      return paramString;
    }
    catch (MalformedURLException paramString)
    {
      label15:
      break label15;
    }
    return null;
  }
  
  protected void I()
  {
    super.I();
    Object localObject = (com.tencent.luggage.wxa.ol.a)((c)y()).a(com.tencent.luggage.wxa.ol.a.class);
    if (localObject != null)
    {
      String str = ((com.tencent.luggage.wxa.ol.a)localObject).a(u());
      localObject = ((com.tencent.luggage.wxa.ol.a)localObject).b(u());
      if (!TextUtils.isEmpty(str))
      {
        o.d("Luggage.MPPageViewRenderer", "onPageScriptWillExecute get RenderingCache by url[%s], content.size[%d], webviewData.size[%d]", new Object[] { u(), Integer.valueOf(af.b(str).length()), Integer.valueOf(af.b((String)localObject).length()) });
        com.tencent.luggage.wxa.ls.a.a(str, (String)localObject, (u)y());
      }
    }
  }
  
  protected final ba K()
  {
    return (ba)E();
  }
  
  public void L()
  {
    ((c)y()).M();
    K().i();
    ((c)y()).N();
  }
  
  public boolean M()
  {
    return (K() != null) && (K().z_());
  }
  
  public boolean N()
  {
    return (K() != null) && (K().h());
  }
  
  protected ap a()
  {
    return super.a();
  }
  
  public <T> T a(Class<T> paramClass)
  {
    if (e.class == paramClass)
    {
      if (this.f == null)
      {
        e locale = (e)E().a(e.class);
        if (locale != null)
        {
          this.f = new ax.1(this, locale);
          return paramClass.cast(this.f);
        }
      }
      return paramClass.cast(this.f);
    }
    return super.a(paramClass);
  }
  
  @CallSuper
  public void a(@NonNull d.a parama, boolean paramBoolean, long paramLong1, long paramLong2, @Nullable Object paramObject)
  {
    super.a(parama, paramBoolean, paramLong1, paramLong2, paramObject);
    if (("WAPageFrame.html".equals(parama.a)) && (!TextUtils.isEmpty(o()))) {
      com.tencent.mm.plugin.appbrand.keylogger.d.a(o(), com.tencent.luggage.wxa.oy.a.N, "", paramLong1, paramLong2);
    }
    if ((!this.e) && (y() != null) && (((c)y()).f() != null) && (b("checkIsAppSharedPageFrameExecutionFinished").c(parama.a))) {
      this.e = true;
    }
  }
  
  protected void a(String paramString, long paramLong1, long paramLong2) {}
  
  public void a(@NonNull Map<String, Object> paramMap, bg parambg)
  {
    super.a(paramMap, parambg);
    y().getClass();
    if (bg.c != parambg)
    {
      parambg = (com.tencent.luggage.wxa.ol.a)((c)y()).a(com.tencent.luggage.wxa.ol.a.class);
      if (parambg != null)
      {
        parambg = parambg.c(u());
        if (!TextUtils.isEmpty(parambg)) {
          try
          {
            paramMap.put("initialRenderingCacheData", new JSONObject(parambg));
          }
          catch (Exception parambg)
          {
            o.a("Luggage.MPPageViewRenderer", parambg, "onFillRouteInEventData when parsing initialRenderingCacheData", new Object[0]);
          }
        }
      }
    }
    parambg = new HashMap();
    paramMap.put("qualityData", parambg);
    parambg.put("navId", String.format(Locale.ENGLISH, "%d_%d", new Object[] { Integer.valueOf(((c)y()).getComponentId()), Long.valueOf(af.d()) }));
    parambg.put("isWebviewPreload", Boolean.valueOf(K().k()));
    parambg.put("isPreloadPageFrame", Boolean.valueOf(this.e));
    paramMap.put("prerender", Boolean.valueOf(n().w()));
  }
  
  public boolean a(String paramString)
  {
    this.h = false;
    this.c = false;
    this.d = false;
    K().b(new ax.2(this));
    boolean bool = super.a(paramString);
    a(o(), u(), "INITIAL");
    return bool;
  }
  
  public boolean a(String paramString1, String paramString2, int paramInt)
  {
    if ((!this.h) && (paramString1.startsWith("custom_event_")))
    {
      if ((!paramString1.startsWith("custom_event_vdSync")) && (!paramString1.startsWith("custom_event_vdSyncBatch")))
      {
        o.d("Luggage.MPPageViewRenderer", "dispatch critical appId[%s] url[%s] event[%s] size[%d] src[%d]", new Object[] { o(), u(), paramString1, Integer.valueOf(af.b(paramString2).length()), Integer.valueOf(paramInt) });
        return false;
      }
      if (((c)y()).aL())
      {
        if (!this.c)
        {
          com.tencent.mm.plugin.appbrand.keylogger.d.b(o(), com.tencent.luggage.wxa.oy.a.Q);
          this.c = true;
        }
        if (this.d)
        {
          com.tencent.mm.plugin.appbrand.keylogger.d.b(o(), com.tencent.luggage.wxa.oy.a.P);
          this.d = false;
        }
      }
      o.d("Luggage.MPPageViewRenderer", "dispatch critical vdSync appId[%s] url[%s] event[%s] content[%s] src[%d]", new Object[] { o(), u(), paramString1, StringUtils.substring(paramString2, 0, 20), Integer.valueOf(paramInt) });
    }
    return false;
  }
  
  public boolean a(String paramString1, String paramString2, int[] paramArrayOfInt)
  {
    if (ArrayUtils.contains(i, paramString1))
    {
      o.d("Luggage.MPPageViewRenderer", "publish critical appId[%s] url[%s] event[%s]", new Object[] { o(), u(), paramString1 });
      if ((y() != null) && (((c)y()).aL()) && ("custom_event_GenerateFuncReady".equals(paramString1)))
      {
        this.d = true;
        com.tencent.mm.plugin.appbrand.keylogger.d.a(o(), com.tencent.luggage.wxa.oy.a.P);
        if (this.c)
        {
          com.tencent.mm.plugin.appbrand.keylogger.d.b(o(), com.tencent.luggage.wxa.oy.a.P);
          this.d = false;
        }
      }
    }
    return false;
  }
  
  protected an a_(@NonNull Context paramContext)
  {
    return new ah(paramContext);
  }
  
  public final ba c(@NonNull Context paramContext)
  {
    paramContext = new bb(a_(paramContext));
    paramContext.a(this.k);
    super.a(com.tencent.luggage.wxa.dt.a.class, paramContext);
    return paramContext;
  }
  
  @CallSuper
  public void e()
  {
    super.e();
    K().j();
  }
  
  public void f()
  {
    o.d("Luggage.MPPageViewRenderer", "dispatchForeground appId[%s] url[%s]", new Object[] { o(), u() });
    super.f();
    a(o(), u(), "VISIBLE");
  }
  
  public void g()
  {
    super.g();
    a(o(), u(), "INVISIBLE");
  }
  
  @CallSuper
  public void k()
  {
    o.d("Luggage.MPPageViewRenderer", "dispatchPageReady url[%s]", new Object[] { u() });
    this.h = true;
    super.k();
    s().invalidate();
    if (((c)y()).aL())
    {
      com.tencent.mm.plugin.appbrand.keylogger.d.b(o(), com.tencent.luggage.wxa.oy.a.S);
      com.tencent.mm.plugin.appbrand.keylogger.d.b(o(), com.tencent.luggage.wxa.oy.a.H);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.ax
 * JD-Core Version:    0.7.0.1
 */