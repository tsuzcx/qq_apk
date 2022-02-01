package com.tencent.luggage.wxa.ju;

import com.tencent.luggage.wxa.gf.b;
import com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.j;
import org.joor.Reflect;

public class d
  implements com.tencent.luggage.wxa.gf.c
{
  public b a(String paramString)
  {
    switch (paramString.hashCode())
    {
    default: 
      break;
    case 1702014259: 
      if (paramString.equals("livepusher")) {
        i = 5;
      }
      break;
    case 1693182669: 
      if (paramString.equals("liveplayer")) {
        i = 4;
      }
      break;
    case 112202875: 
      if (paramString.equals("video")) {
        i = 0;
      }
      break;
    case 107868: 
      if (paramString.equals("map")) {
        i = 1;
      }
      break;
    case -1367706280: 
      if (paramString.equals("canvas")) {
        i = 2;
      }
      break;
    case -1367751899: 
      if (paramString.equals("camera")) {
        i = 3;
      }
      break;
    }
    int i = -1;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3)
          {
            if (i != 4)
            {
              if (i != 5) {
                return null;
              }
              paramString = new j();
              paramString.a(new com.tencent.luggage.wxa.nd.a());
              return paramString;
            }
            paramString = new com.tencent.luggage.wxa.ga.a();
            paramString.a(new com.tencent.luggage.wxa.nb.a());
            return paramString;
          }
          return new com.tencent.luggage.wxa.mv.a();
        }
        return new com.tencent.luggage.wxa.mx.a();
      }
      return (b)Reflect.on("com.tencent.mm.plugin.appbrand.jsapi.xwebplugin.map.AppBrandMapPluginHandler").create().get();
    }
    paramString = new com.tencent.luggage.wxa.gd.d();
    paramString.a(new com.tencent.luggage.wxa.nf.c());
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ju.d
 * JD-Core Version:    0.7.0.1
 */