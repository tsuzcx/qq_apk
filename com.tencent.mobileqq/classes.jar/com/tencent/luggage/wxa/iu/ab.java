package com.tencent.luggage.wxa.iu;

import android.annotation.SuppressLint;
import android.os.Build.VERSION;
import com.eclipsesource.mmv8.ScriptPartObject;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.mm.plugin.appbrand.appcache.ad;
import com.tencent.mm.plugin.appbrand.appcache.d.a;
import com.tencent.mm.plugin.appbrand.appstorage.n;
import com.tencent.mm.plugin.appbrand.jsruntime.i;
import java.util.ArrayList;
import java.util.Locale;

public class ab
{
  @SuppressLint({"DefaultLocal"})
  public static String a()
  {
    return String.format("typeof __wxSourceMap !== 'undefined' && (__wxSourceMap.__system = 'Android %s')", new Object[] { Build.VERSION.RELEASE });
  }
  
  public static String a(b paramb)
  {
    o.d("MicroMsg.SourceMapUtil", "hy: injecting sourcemap.js");
    if (paramb == null)
    {
      o.c("MicroMsg.SourceMapUtil", "hy: not valid runtime");
      return "";
    }
    if (paramb.q() == null)
    {
      o.c("MicroMsg.SourceMapUtil", "hy: runtime not prepared. do not try to inject sourcemap.js. maybe preloading");
      return "";
    }
    if (d.a.a(paramb.q().ab()))
    {
      o.d("MicroMsg.SourceMapUtil", "current running type is ReleaseType do not need to inject sourceMap.");
      return "";
    }
    paramb = (n)paramb.a(n.class);
    if (paramb == null)
    {
      o.b("MicroMsg.SourceMapUtil", "execSourceMapScript NULL reader");
      return "";
    }
    return paramb.a("WASourceMap.js");
  }
  
  public static String a(d paramd, String paramString1, String paramString2)
  {
    o.d("MicroMsg.SourceMapUtil", "hy: getting sourcemap %s, %s", new Object[] { paramString1, paramString2 });
    if ((paramd != null) && (paramString1 != null) && (paramString1.length() != 0))
    {
      if (d.a.a(paramd.A().c()))
      {
        o.d("MicroMsg.SourceMapUtil", "current running type is ReleaseType do not need to inject sourceMap.");
        return "";
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString1);
      localStringBuilder.append(".map");
      paramd = ad.a(paramd, localStringBuilder.toString());
      if ((paramd != null) && (paramd.length() != 0))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString2);
        localStringBuilder.append(paramString1);
        return String.format("typeof __wxSourceMap !== 'undefined' && (__wxSourceMap['%s'] = %s)", new Object[] { localStringBuilder.toString(), paramd });
      }
      o.d("MicroMsg.SourceMapUtil", "sourceMap of the script(%s) is null or nil.", new Object[] { paramString1 });
      return "";
    }
    o.c("MicroMsg.SourceMapUtil", "runtime or jsRuntime or filePath is null.");
    return "";
  }
  
  public static ArrayList<ScriptPartObject> a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    o.d("MicroMsg.SourceMapUtil", "buildSourceMapAppendList wxapkgPath: %s, filePath: %s", new Object[] { paramString1, paramString2 });
    ArrayList localArrayList = new ArrayList();
    ScriptPartObject localScriptPartObject = new ScriptPartObject();
    localScriptPartObject.type = 1;
    localScriptPartObject.content = String.format(Locale.US, "typeof __wxSourceMap !== 'undefined' && (__wxSourceMap['%s'] = ", new Object[] { paramString4 });
    localArrayList.add(localScriptPartObject);
    paramString4 = new ScriptPartObject();
    paramString4.type = 2;
    paramString4.wxaPkgPath = paramString1;
    paramString4.wxaFileName = paramString2;
    paramString4.wxaPkgKeyFilePath = paramString3;
    localArrayList.add(paramString4);
    paramString1 = new ScriptPartObject();
    paramString1.type = 1;
    paramString1.content = ")";
    localArrayList.add(paramString1);
    return localArrayList;
  }
  
  public static void a(b paramb, i parami)
  {
    com.tencent.luggage.wxa.pd.l.a(parami, a(paramb), new ab.1());
    parami.evaluateJavascript(a(), null);
  }
  
  public static boolean a(d paramd, String paramString)
  {
    o.d("MicroMsg.SourceMapUtil", "is sourcemap exist: %s", new Object[] { paramString });
    if ((paramd != null) && (paramString != null) && (paramString.length() != 0))
    {
      if (d.a.a(paramd.A().c()))
      {
        o.d("MicroMsg.SourceMapUtil", "current running type is ReleaseType do not need to inject sourceMap.");
        return false;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append(".map");
      return ad.d(paramd, localStringBuilder.toString());
    }
    o.c("MicroMsg.SourceMapUtil", "runtime or jsRuntime or filePath is null.");
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.iu.ab
 * JD-Core Version:    0.7.0.1
 */