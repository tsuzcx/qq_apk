package com.tencent.luggage.wxa.ct;

import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.ContextCompat;
import com.tencent.luggage.wxa.dq.c;
import com.tencent.luggage.wxa.ed.d;
import com.tencent.luggage.wxa.kd.b;
import com.tencent.luggage.wxa.pc.g;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.mm.plugin.appbrand.page.ab;
import com.tencent.mm.plugin.appbrand.page.am;
import com.tencent.xweb.WebView;
import org.json.JSONObject;

public class e
  extends b<c>
{
  public static final int CTRL_INDEX = 298;
  public static final String NAME = "insertHTMLWebView";
  
  private int b(c paramc, JSONObject paramJSONObject)
  {
    try
    {
      if (paramJSONObject.has("backgroundColor"))
      {
        int i = g.b(paramJSONObject.getString("backgroundColor"));
        return i;
      }
    }
    catch (Exception paramJSONObject)
    {
      label21:
      break label21;
    }
    if (paramc.f().t()) {
      return 0;
    }
    if (paramc.f().aj().a()) {
      return ContextCompat.getColor(paramc.getContext(), 2131165259);
    }
    return -1;
  }
  
  private static void b(a parama)
  {
    try
    {
      Object localObject = parama.getPageView().aj();
      if (localObject != null)
      {
        ((am)localObject).getWrapperView().setFocusable(false);
        ((am)localObject).getWrapperView().setFocusableInTouchMode(false);
        ((am)localObject).getContentView().setFocusable(false);
        ((am)localObject).getContentView().setFocusableInTouchMode(false);
        if ((((am)localObject).getWrapperView() instanceof ViewGroup)) {
          ((ViewGroup)((am)localObject).getWrapperView()).setDescendantFocusability(393216);
        }
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        try
        {
          localObject = parama.getWebView().getView();
          ((View)localObject).setFocusable(true);
          ((View)localObject).setFocusableInTouchMode(true);
          ((View)localObject).setFocusable(true);
          ((View)localObject).setFocusableInTouchMode(true);
          parama.requestFocus();
          return;
        }
        catch (Throwable parama) {}
        localThrowable = localThrowable;
      }
    }
  }
  
  protected int a(JSONObject paramJSONObject)
  {
    return paramJSONObject.getInt("htmlId");
  }
  
  protected View a(c paramc, JSONObject paramJSONObject)
  {
    if (paramc.e(h(paramJSONObject)).a(a.class) != null) {
      return null;
    }
    paramc.b(new e.1(this, paramc));
    a locala = new a(paramc.getContext(), paramc.f(), paramc);
    locala.setId(2131428553);
    locala.setBackgroundColor(b(paramc, paramJSONObject));
    paramc.a(new e.2(this, locala));
    paramc.a(new e.3(this, locala));
    paramc.a(new e.4(this, locala));
    return locala;
  }
  
  protected void a(c paramc, int paramInt, View paramView, JSONObject paramJSONObject)
  {
    a locala = (a)paramView;
    locala.setViewId(paramInt);
    o.d("MicroMsg.AppBrand.JsApiInsertHTMLWebView", "onInsertView appId[%s] viewId[%d] viewHash[%d]", new Object[] { paramc.getAppId(), Integer.valueOf(paramInt), Integer.valueOf(paramView.hashCode()) });
    b(locala);
    if (paramc.f().t()) {
      locala.a(paramJSONObject.optString("src"));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ct.e
 * JD-Core Version:    0.7.0.1
 */