package com.tencent.luggage.wxa.em;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.jj.n;
import com.tencent.luggage.wxa.nu.b;
import com.tencent.mm.plugin.appbrand.appcache.r;
import com.tencent.mm.plugin.appbrand.page.am;
import com.tencent.mm.plugin.appbrand.page.w;
import com.tencent.xweb.WebView;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
import org.xwalk.core.XWalkEnvironment;

public class c
  extends com.tencent.luggage.wxa.dq.c
{
  @Deprecated
  public c()
  {
    this(com.tencent.luggage.wxa.eu.c.class);
  }
  
  public c(@Nullable Class<? extends w> paramClass)
  {
    super(paramClass);
    a(r.b());
  }
  
  protected void a(Context paramContext)
  {
    super.a(paramContext);
    if (aj() != null) {
      aj().a(paramContext);
    }
    com.tencent.luggage.wxa.ct.a locala = r();
    if (locala != null) {
      locala.a(paramContext);
    }
  }
  
  public void a(Context paramContext, com.tencent.luggage.wxa.iu.d paramd)
  {
    if ((paramd instanceof d)) {
      a(new com.tencent.luggage.wxa.iu.a(paramd, this, ((d)paramd).a()));
    }
    super.a(paramContext, paramd);
  }
  
  public final void a(com.tencent.luggage.wxa.oq.c paramc)
  {
    if ((paramc != null) && (y() != null) && (paramc.compareTo(y()) == 0)) {
      return;
    }
    super.a(paramc);
    if (paramc != null)
    {
      Activity localActivity = com.tencent.luggage.wxa.rc.a.a(paramc.getContext());
      Object localObject = localActivity;
      if (localActivity == null) {
        localObject = paramc.getContext();
      }
      a((Context)localObject);
    }
  }
  
  public void a(@NonNull JSONObject paramJSONObject)
  {
    super.a(paramJSONObject);
    a(paramJSONObject, "clientVersion", Integer.valueOf(654316592));
    boolean bool = true;
    com.tencent.luggage.wxa.ju.a.a(true, paramJSONObject);
    com.tencent.luggage.wxa.ju.a.h(com.tencent.luggage.wxa.sq.c.a(getContext()), paramJSONObject);
    com.tencent.luggage.wxa.ju.a.g(com.tencent.luggage.wxa.sq.c.a(getContext()), paramJSONObject);
    com.tencent.luggage.wxa.ju.a.b(true, paramJSONObject);
    com.tencent.luggage.wxa.ju.a.e(true, paramJSONObject);
    com.tencent.luggage.wxa.ju.a.f(true, paramJSONObject);
    com.tencent.luggage.wxa.ju.a.c(false, paramJSONObject);
    if ((!XWalkEnvironment.isCurrentVersionSupportCustomTextAreaForAppbrand()) || (!WebView.isXWalk())) {
      bool = false;
    }
    com.tencent.luggage.wxa.ju.a.d(bool, paramJSONObject);
  }
  
  public boolean a(String paramString)
  {
    a(f().W());
    return super.a(paramString);
  }
  
  public boolean m()
  {
    return (super.m()) || (((com.tencent.luggage.wxa.do.a)b(com.tencent.luggage.wxa.do.a.class)).b);
  }
  
  @Nullable
  public com.tencent.luggage.wxa.ct.a r()
  {
    try
    {
      Object localObject = getContentView().findViewById(2131428553);
      if ((localObject instanceof com.tencent.luggage.wxa.ct.a))
      {
        localObject = (com.tencent.luggage.wxa.ct.a)localObject;
        return localObject;
      }
      return null;
    }
    catch (NullPointerException localNullPointerException) {}
    return null;
  }
  
  public List<com.tencent.luggage.wxa.nu.a> s()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new com.tencent.luggage.wxa.nu.a(new c.1(this, b.d.ordinal())));
    localArrayList.add(new com.tencent.luggage.wxa.nu.a(new c.2(this, b.b.ordinal())));
    localArrayList.add(new com.tencent.luggage.wxa.nu.a(new c.3(this, b.x.ordinal())));
    if (n.a(f())) {
      localArrayList.add(new com.tencent.luggage.wxa.nu.a(new com.tencent.luggage.wxa.es.a()));
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.em.c
 * JD-Core Version:    0.7.0.1
 */