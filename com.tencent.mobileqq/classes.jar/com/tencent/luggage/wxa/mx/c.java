package com.tencent.luggage.wxa.mx;

import android.util.SparseArray;
import androidx.annotation.NonNull;
import com.tencent.luggage.wxa.hg.f;
import com.tencent.luggage.wxa.iu.h;
import com.tencent.luggage.wxa.mz.d;
import com.tencent.luggage.wxa.mz.e;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.mm.plugin.appbrand.jsruntime.q;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.xweb.WebView;
import com.tencent.xweb.skia_canvas.SkiaCanvasApp;
import com.tencent.xweb.skia_canvas.XWebLibraryLoader;
import java.util.ArrayList;
import java.util.List;
import org.xwalk.core.XWalkEnvironment;

public class c
{
  private static boolean a = false;
  private static SparseArray<SkiaCanvasApp> b = new SparseArray();
  
  public static SkiaCanvasApp a(int paramInt)
  {
    try
    {
      SkiaCanvasApp localSkiaCanvasApp = (SkiaCanvasApp)b.get(paramInt);
      return localSkiaCanvasApp;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static SkiaCanvasApp a(com.tencent.luggage.wxa.jx.c paramc)
  {
    int i;
    if ((paramc instanceof h))
    {
      i = paramc.hashCode();
      paramc = a(i);
    }
    else if ((paramc instanceof u))
    {
      i = ((u)paramc).p().hashCode();
      paramc = a(i);
    }
    else
    {
      paramc = null;
      i = -1;
    }
    if (paramc == null) {
      o.b("Luggage.XWebCanvasLogic", "id:%d app is null, err", new Object[] { Integer.valueOf(i) });
    }
    return paramc;
  }
  
  public static String a()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(com.tencent.luggage.wxa.pc.c.a("wxa_library/js_binding_skia.js"));
    return localStringBuffer.toString();
  }
  
  public static void a(com.tencent.luggage.wxa.jl.b paramb, com.tencent.luggage.wxa.jl.a parama, h paramh)
  {
    f();
    Object localObject = paramh.getJsRuntime();
    if (localObject != null)
    {
      localObject = (q)((com.tencent.mm.plugin.appbrand.jsruntime.i)localObject).a(q.class);
      if (localObject != null)
      {
        ((q)localObject).a(new c.2(paramb, parama, paramh));
        return;
      }
      o.b("Luggage.XWebCanvasLogic", "jsThreadAddon is null, fail");
    }
  }
  
  public static void a(@NonNull com.tencent.mm.plugin.appbrand.jsruntime.i parami, @NonNull h paramh)
  {
    f();
    q localq = (q)parami.a(q.class);
    if (localq != null)
    {
      localq.a(new c.3(parami, paramh, localq));
      parami = (com.tencent.mm.plugin.appbrand.jsruntime.m)parami.a(com.tencent.mm.plugin.appbrand.jsruntime.m.class);
      if (parami != null)
      {
        parami.a(new c.a(new c.4(paramh)));
        return;
      }
      o.b("Luggage.XWebCanvasLogic", "addonDestroyListener is null, fail");
    }
  }
  
  public static void b() {}
  
  private static void b(int paramInt, SkiaCanvasApp paramSkiaCanvasApp)
  {
    try
    {
      b.put(paramInt, paramSkiaCanvasApp);
      return;
    }
    finally
    {
      paramSkiaCanvasApp = finally;
      throw paramSkiaCanvasApp;
    }
  }
  
  public static List<com.tencent.luggage.wxa.jx.m> c()
  {
    boolean bool = d() ^ true;
    o.d("Luggage.XWebCanvasLogic", "createCavnasJsApis useCoverView:%b", new Object[] { Boolean.valueOf(bool) });
    ArrayList localArrayList = new ArrayList();
    if (bool)
    {
      localArrayList.add(new com.tencent.luggage.wxa.my.a());
      localArrayList.add(new com.tencent.luggage.wxa.my.b());
      localArrayList.add(new com.tencent.luggage.wxa.my.c());
      return localArrayList;
    }
    localArrayList.add(new com.tencent.luggage.wxa.mz.b());
    localArrayList.add(new d());
    localArrayList.add(new e());
    return localArrayList;
  }
  
  public static boolean d()
  {
    boolean bool3 = XWalkEnvironment.isCurrentVersionSupportMapExtendPluginForAppbrand();
    boolean bool4 = WebView.isXWalk();
    boolean bool2 = false;
    o.d("Luggage.XWebCanvasLogic", "supportXWebCanvasSameLayer supportXWeb:%b isXWeb:%b", new Object[] { Boolean.valueOf(bool3), Boolean.valueOf(bool4) });
    boolean bool1 = bool2;
    if (bool3)
    {
      bool1 = bool2;
      if (bool4) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private static void f()
  {
    if (!a)
    {
      f.a("c++_shared", com.tencent.mm.appbrand.v8.i.class.getClassLoader());
      XWebLibraryLoader.initXWebLibraryLoader(new c.1());
      a = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.mx.c
 * JD-Core Version:    0.7.0.1
 */