package com.tencent.luggage.wxa.fx;

import com.tencent.luggage.wxa.gh.a;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.mm.plugin.appbrand.page.ag;
import com.tencent.xweb.WebView;
import java.util.Locale;
import org.xwalk.core.XWalkEnvironment;
import org.xwalk.core.XWalkExtendPluginClient;
import org.xwalk.core.XWalkExtendTextAreaClient;
import org.xwalk.core.XWalkView;

public class d
{
  public static int a()
  {
    return 300;
  }
  
  public static com.tencent.luggage.wxa.gg.c a(WebView paramWebView, com.tencent.luggage.wxa.gg.d paramd, com.tencent.luggage.wxa.gf.c paramc, ag paramag)
  {
    if (!b())
    {
      o.c("MicroMsg.SameLayer.WebViewExtendPluginUtil", "applyExtendPluginClientIfNeed, current version not support extend plugin");
      return null;
    }
    if ((paramWebView != null) && (paramWebView.isXWalkKernel()))
    {
      paramWebView = paramWebView.getWebViewUI();
      if (((paramWebView instanceof XWalkView)) && (paramd != null))
      {
        paramWebView = (XWalkView)paramWebView;
        paramd = paramd.b();
        Object localObject = new c(paramWebView);
        ((c)localObject).a(paramd);
        paramd.a((c)localObject);
        paramWebView.setExtendPluginClient((XWalkExtendPluginClient)localObject);
        if (paramag != null)
        {
          localObject = new a(paramWebView);
          ((a)localObject).a(paramag);
          paramWebView.setExtendTextAreaClient((XWalkExtendTextAreaClient)localObject);
        }
        if (paramc != null) {
          paramd.a(paramc);
        }
        o.d("MicroMsg.SameLayer.WebViewExtendPluginUtil", "applyExtendPluginClientIfNeed, set extend plugin client success");
        return paramd;
      }
      o.d("MicroMsg.SameLayer.WebViewExtendPluginUtil", "applyExtendPluginClientIfNeed, set extend plugin client fail");
      return null;
    }
    o.d("MicroMsg.SameLayer.WebViewExtendPluginUtil", "applyExtendPluginClientIfNeed, current webview is not xweb kernel");
    return null;
  }
  
  public static String a(String paramString, int paramInt)
  {
    return String.format(Locale.US, "%s#%d", new Object[] { paramString, Integer.valueOf(paramInt) });
  }
  
  public static void a(com.tencent.luggage.wxa.gg.c paramc, String paramString, int paramInt)
  {
    if ((paramc != null) && (paramc.a() != null))
    {
      o.d("MicroMsg.SameLayer.WebViewExtendPluginUtil", "applyPluginScreenshot, %s#%d", new Object[] { paramString, Integer.valueOf(paramInt) });
      paramc.a().takePluginScreenshot(paramString, paramInt);
    }
  }
  
  public static void a(com.tencent.luggage.wxa.gg.c paramc, String paramString, int paramInt, float paramFloat1, float paramFloat2)
  {
    if ((paramc != null) && (paramc.a() != null))
    {
      o.d("MicroMsg.SameLayer.WebViewExtendPluginUtil", "applyPluginTextureScale, %s#%d, scale:[%s,%s]", new Object[] { paramString, Integer.valueOf(paramInt), Float.valueOf(paramFloat1), Float.valueOf(paramFloat2) });
      paramc.a().setPluginTextureScale(paramString, paramInt, paramFloat1, paramFloat2);
    }
  }
  
  public static boolean b()
  {
    return XWalkEnvironment.isCurrentVersionSupportExtendPluginForAppbrand();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fx.d
 * JD-Core Version:    0.7.0.1
 */