package com.tencent.luggage.wxa.standalone_open_runtime.ui.menu.devtools;

import android.annotation.SuppressLint;
import android.content.Context;
import android.webkit.ValueCallback;
import com.tencent.luggage.wxa.ed.d;
import com.tencent.luggage.wxa.hz.a;
import com.tencent.luggage.wxa.iu.h;
import com.tencent.luggage.wxa.rt.i;
import com.tencent.magicbrush.MBRuntime;
import com.tencent.magicbrush.e;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/wxa/standalone_open_runtime/ui/menu/devtools/SecondaryMenuDelegate_GameCpuProfiler;", "Lcom/tencent/mm/plugin/appbrand/menu/base/BaseSecondaryMenuDelegate;", "Lcom/tencent/luggage/sdk/jsapi/component/AppBrandPageViewLU;", "()V", "isProfiling", "", "dumpToFile", "dumpFileName", "", "content", "getAllWorkerExecutables", "", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJsRuntimeAddonExecutable;", "runtime", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "getMagicBrush", "Lcom/tencent/magicbrush/MagicBrush;", "Lcom/tencent/luggage/sdk/runtime/AppBrandRuntimeLU;", "getTitle", "context", "Landroid/content/Context;", "pageView", "appId", "performItemClick", "", "shouldShow", "startProfile", "executable", "mbRuntime", "Lcom/tencent/magicbrush/MBRuntime;", "stopProfile", "path", "Companion", "luggage-standalone-open-runtime-sdk_release"}, k=1, mv={1, 1, 16})
public final class SecondaryMenuDelegate_GameCpuProfiler
  implements com.tencent.luggage.wxa.nv.b<com.tencent.luggage.wxa.dq.c>
{
  public static final SecondaryMenuDelegate_GameCpuProfiler.a a = new SecondaryMenuDelegate_GameCpuProfiler.a(null);
  private boolean b;
  
  private final e a(d paramd)
  {
    Object localObject = null;
    if (paramd != null) {
      paramd = paramd.ae();
    } else {
      paramd = null;
    }
    if (paramd != null)
    {
      com.tencent.luggage.wxa.bp.b localb = (com.tencent.luggage.wxa.bp.b)((com.tencent.luggage.wxa.du.c)paramd).d(com.tencent.luggage.wxa.bp.b.class);
      paramd = localObject;
      if (localb != null) {
        paramd = localb.r();
      }
      return paramd;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.luggage.sdk.jsapi.component.service.AppBrandServiceLU");
  }
  
  private final void a(com.tencent.mm.plugin.appbrand.jsruntime.o paramo, MBRuntime paramMBRuntime, Context paramContext)
  {
    paramo.evaluateJavascript(";var __debug_v8_cpu_profiler = (function(profiler) {if (typeof profiler === 'undefined') { profiler = new NativeGlobal.CpuProfiler();} profiler.startProfiling(); return profiler;})(__debug_v8_cpu_profiler);", (ValueCallback)new SecondaryMenuDelegate_GameCpuProfiler.b(this, paramContext));
    if (paramMBRuntime != null) {
      paramMBRuntime.a(true);
    }
  }
  
  private final void a(com.tencent.mm.plugin.appbrand.jsruntime.o paramo, MBRuntime paramMBRuntime, Context paramContext, String paramString)
  {
    paramo.evaluateJavascript(";(function(profiler) {return JSON.stringify(profiler.stopProfiling());})(__debug_v8_cpu_profiler);", (ValueCallback)new SecondaryMenuDelegate_GameCpuProfiler.c(this, paramString, paramContext));
    if (paramMBRuntime != null) {
      paramMBRuntime.a(false);
    }
  }
  
  /* Error */
  private final boolean a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: invokestatic 134	com/tencent/luggage/wxa/hg/d:a	()Z
    //   3: istore 4
    //   5: iconst_0
    //   6: istore_3
    //   7: iload 4
    //   9: ifne +12 -> 21
    //   12: ldc 136
    //   14: ldc 138
    //   16: invokestatic 143	com/tencent/luggage/wxa/qz/o:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   19: iconst_0
    //   20: ireturn
    //   21: aconst_null
    //   22: checkcast 145	com/tencent/luggage/wxa/rt/m
    //   25: astore 6
    //   27: aload 6
    //   29: astore 5
    //   31: new 147	java/lang/StringBuilder
    //   34: dup
    //   35: invokespecial 148	java/lang/StringBuilder:<init>	()V
    //   38: astore 7
    //   40: aload 6
    //   42: astore 5
    //   44: aload 7
    //   46: invokestatic 153	com/tencent/luggage/wxa/hz/a:d	()Ljava/lang/String;
    //   49: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: pop
    //   53: aload 6
    //   55: astore 5
    //   57: aload 7
    //   59: ldc 159
    //   61: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: pop
    //   65: aload 6
    //   67: astore 5
    //   69: new 161	com/tencent/luggage/wxa/rt/i
    //   72: dup
    //   73: aload 7
    //   75: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   78: invokespecial 165	com/tencent/luggage/wxa/rt/i:<init>	(Ljava/lang/String;)V
    //   81: astore 7
    //   83: aload 6
    //   85: astore 5
    //   87: aload 7
    //   89: invokevirtual 168	com/tencent/luggage/wxa/rt/i:j	()Z
    //   92: ifne +13 -> 105
    //   95: aload 6
    //   97: astore 5
    //   99: aload 7
    //   101: invokevirtual 171	com/tencent/luggage/wxa/rt/i:u	()Z
    //   104: pop
    //   105: aload 6
    //   107: astore 5
    //   109: new 145	com/tencent/luggage/wxa/rt/m
    //   112: dup
    //   113: new 161	com/tencent/luggage/wxa/rt/i
    //   116: dup
    //   117: aload 7
    //   119: aload_1
    //   120: invokespecial 174	com/tencent/luggage/wxa/rt/i:<init>	(Lcom/tencent/luggage/wxa/rt/i;Ljava/lang/String;)V
    //   123: iconst_0
    //   124: invokespecial 177	com/tencent/luggage/wxa/rt/m:<init>	(Lcom/tencent/luggage/wxa/rt/i;Z)V
    //   127: astore_1
    //   128: aload_1
    //   129: aload_2
    //   130: invokevirtual 180	com/tencent/luggage/wxa/rt/m:write	(Ljava/lang/String;)V
    //   133: iconst_1
    //   134: istore_3
    //   135: aload_1
    //   136: invokevirtual 183	com/tencent/luggage/wxa/rt/m:close	()V
    //   139: iconst_1
    //   140: ireturn
    //   141: astore_1
    //   142: new 147	java/lang/StringBuilder
    //   145: dup
    //   146: invokespecial 148	java/lang/StringBuilder:<init>	()V
    //   149: astore_2
    //   150: aload_2
    //   151: ldc 185
    //   153: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: pop
    //   157: aload_2
    //   158: aload_1
    //   159: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   162: pop
    //   163: ldc 136
    //   165: aload_2
    //   166: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   169: invokestatic 143	com/tencent/luggage/wxa/qz/o:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   172: iload_3
    //   173: ireturn
    //   174: astore_2
    //   175: aload_1
    //   176: astore 5
    //   178: aload_2
    //   179: astore_1
    //   180: goto +85 -> 265
    //   183: astore_2
    //   184: goto +11 -> 195
    //   187: astore_1
    //   188: goto +77 -> 265
    //   191: astore_2
    //   192: aload 6
    //   194: astore_1
    //   195: aload_1
    //   196: astore 5
    //   198: new 147	java/lang/StringBuilder
    //   201: dup
    //   202: invokespecial 148	java/lang/StringBuilder:<init>	()V
    //   205: astore 6
    //   207: aload_1
    //   208: astore 5
    //   210: aload 6
    //   212: ldc 190
    //   214: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   217: pop
    //   218: aload_1
    //   219: astore 5
    //   221: aload 6
    //   223: aload_2
    //   224: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   227: pop
    //   228: aload_1
    //   229: astore 5
    //   231: ldc 136
    //   233: aload 6
    //   235: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   238: invokestatic 143	com/tencent/luggage/wxa/qz/o:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   241: aload_1
    //   242: ifnull +21 -> 263
    //   245: aload_1
    //   246: invokevirtual 183	com/tencent/luggage/wxa/rt/m:close	()V
    //   249: iconst_0
    //   250: ireturn
    //   251: astore_1
    //   252: new 147	java/lang/StringBuilder
    //   255: dup
    //   256: invokespecial 148	java/lang/StringBuilder:<init>	()V
    //   259: astore_2
    //   260: goto -110 -> 150
    //   263: iconst_0
    //   264: ireturn
    //   265: aload 5
    //   267: ifnull +46 -> 313
    //   270: aload 5
    //   272: invokevirtual 183	com/tencent/luggage/wxa/rt/m:close	()V
    //   275: goto +38 -> 313
    //   278: astore_2
    //   279: new 147	java/lang/StringBuilder
    //   282: dup
    //   283: invokespecial 148	java/lang/StringBuilder:<init>	()V
    //   286: astore 5
    //   288: aload 5
    //   290: ldc 185
    //   292: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   295: pop
    //   296: aload 5
    //   298: aload_2
    //   299: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   302: pop
    //   303: ldc 136
    //   305: aload 5
    //   307: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   310: invokestatic 143	com/tencent/luggage/wxa/qz/o:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   313: goto +5 -> 318
    //   316: aload_1
    //   317: athrow
    //   318: goto -2 -> 316
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	321	0	this	SecondaryMenuDelegate_GameCpuProfiler
    //   0	321	1	paramString1	String
    //   0	321	2	paramString2	String
    //   6	167	3	bool1	boolean
    //   3	5	4	bool2	boolean
    //   29	277	5	localObject1	Object
    //   25	209	6	localObject2	Object
    //   38	80	7	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   135	139	141	java/lang/Exception
    //   128	133	174	finally
    //   128	133	183	java/lang/Exception
    //   31	40	187	finally
    //   44	53	187	finally
    //   57	65	187	finally
    //   69	83	187	finally
    //   87	95	187	finally
    //   99	105	187	finally
    //   109	128	187	finally
    //   198	207	187	finally
    //   210	218	187	finally
    //   221	228	187	finally
    //   231	241	187	finally
    //   31	40	191	java/lang/Exception
    //   44	53	191	java/lang/Exception
    //   57	65	191	java/lang/Exception
    //   69	83	191	java/lang/Exception
    //   87	95	191	java/lang/Exception
    //   99	105	191	java/lang/Exception
    //   109	128	191	java/lang/Exception
    //   245	249	251	java/lang/Exception
    //   270	275	278	java/lang/Exception
  }
  
  public boolean a(@NotNull Context paramContext, @NotNull com.tencent.luggage.wxa.dq.c paramc, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intrinsics.checkParameterIsNotNull(paramc, "pageView");
    Intrinsics.checkParameterIsNotNull(paramString, "appId");
    return a(paramc.f()) != null;
  }
  
  @NotNull
  public String b(@NotNull Context paramContext, @NotNull com.tencent.luggage.wxa.dq.c paramc, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intrinsics.checkParameterIsNotNull(paramc, "pageView");
    Intrinsics.checkParameterIsNotNull(paramString, "appId");
    if (this.b) {
      return "Stop CPU Profile";
    }
    return "Start CPU Profile";
  }
  
  @SuppressLint({"DefaultLocale"})
  public void c(@NotNull Context paramContext, @NotNull com.tencent.luggage.wxa.dq.c paramc, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intrinsics.checkParameterIsNotNull(paramc, "pageView");
    Intrinsics.checkParameterIsNotNull(paramString, "appId");
    Object localObject1 = paramc.f();
    if (localObject1 != null)
    {
      if (((d)localObject1).ae() == null) {
        return;
      }
      paramc = a((d)localObject1);
      if (paramc == null) {
        com.tencent.luggage.wxa.qz.o.c("MiroMsg.GameCpuProfile", "hy: not magicbrush env");
      }
      if (this.b)
      {
        long l = System.currentTimeMillis();
        localObject1 = ((d)localObject1).ae();
        Intrinsics.checkExpressionValueIsNotNull(localObject1, "runtime.service");
        localObject1 = ((h)localObject1).getJsRuntime();
        Intrinsics.checkExpressionValueIsNotNull(localObject1, "runtime.service.jsRuntime");
        localObject1 = (com.tencent.mm.plugin.appbrand.jsruntime.o)localObject1;
        paramc = (MBRuntime)paramc;
        Object localObject2 = StringCompanionObject.INSTANCE;
        localObject2 = new Object[2];
        localObject2[0] = paramString;
        localObject2[1] = Long.valueOf(l);
        paramString = String.format("CPU_%s_%d.cpuprofile", Arrays.copyOf((Object[])localObject2, localObject2.length));
        Intrinsics.checkExpressionValueIsNotNull(paramString, "java.lang.String.format(format, *args)");
        a((com.tencent.mm.plugin.appbrand.jsruntime.o)localObject1, paramc, paramContext, paramString);
        return;
      }
      paramString = new StringBuilder();
      paramString.append(a.d());
      paramString.append("appbrand/trace/");
      paramString = new i(paramString.toString());
      if (!paramString.j()) {
        paramString.u();
      }
      paramString = ((d)localObject1).ae();
      Intrinsics.checkExpressionValueIsNotNull(paramString, "runtime.service");
      paramString = paramString.getJsRuntime();
      Intrinsics.checkExpressionValueIsNotNull(paramString, "runtime.service.jsRuntime");
      a((com.tencent.mm.plugin.appbrand.jsruntime.o)paramString, (MBRuntime)paramc, paramContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.standalone_open_runtime.ui.menu.devtools.SecondaryMenuDelegate_GameCpuProfiler
 * JD-Core Version:    0.7.0.1
 */