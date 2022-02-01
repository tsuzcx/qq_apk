package com.tencent.comic.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.comic.VipComicProxyActivity;
import com.tencent.comic.VipProxyPreLoadComicProcess;
import com.tencent.comic.jsp.QQComicDownloadObserverProxy;
import com.tencent.comic.jsp.QQComicJsCallback;
import com.tencent.comic.jsp.QQComicJsPluginBuilder;
import com.tencent.comic.jsp.QQComicJsPluginProxy;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hitrate.PreloadProcHitPluginSession;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.pluginsdk.PluginStatic;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.module.IQRoutePlugin;
import com.tencent.mobileqq.qroute.module.QRoutePluginActivityParams.Builder;
import com.tencent.mobileqq.qroute.module.QRoutePluginInfo;
import com.tencent.mobileqq.qroute.module.QRoutePluginReceiverParams.Builder;
import com.tencent.mobileqq.vas.api.IIndividuationUrlApi;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Observer;
import mqq.app.AppRuntime;

public class QQComicPluginBridge
{
  public static volatile boolean a = false;
  public static QQComicJsPluginBuilder b = null;
  public static QQComicDownloadObserverProxy c = null;
  public static FirstInObservable d = null;
  public static RuntimeCreateObservable e = null;
  private static final Object f = new Object();
  
  public static QQComicJsPluginProxy a(WebViewPlugin.PluginRuntime paramPluginRuntime, QQComicJsCallback paramQQComicJsCallback)
  {
    QQComicJsPluginBuilder localQQComicJsPluginBuilder = b;
    if (localQQComicJsPluginBuilder == null) {
      return null;
    }
    return localQQComicJsPluginBuilder.a(paramPluginRuntime, paramQQComicJsCallback);
  }
  
  public static void a(Context paramContext)
  {
    a(paramContext, null);
  }
  
  public static void a(Context paramContext, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQComicDebug", 2, "load plugin start");
    }
    if (!QIPCServerHelper.getInstance().isModuleRunning("comic_plugin.apk")) {
      VasWebviewUtil.a("qqcomic", "launch_plugin_action", "0", 0, 201);
    }
    Intent localIntent = new Intent(paramContext, VipProxyPreLoadComicProcess.class);
    localIntent.putExtra("userQqResources", 2);
    localIntent.putExtra("useSkinEngine", false);
    localIntent.putExtra("params_remote_connect_at_launch", true);
    localIntent.putExtra("sendTime", SystemClock.elapsedRealtime());
    PreloadSuccessRateReporter.a(AppHelper.b(), 1, 1, 0L);
    a(localIntent);
    Map localMap = ((IIndividuationUrlApi)QRoute.api(IIndividuationUrlApi.class)).getUrlMap();
    if ((localMap instanceof Serializable)) {
      localIntent.putExtra("urlMap", (Serializable)localMap);
    }
    if (paramBundle != null) {
      localIntent.putExtra("extraBundle", paramBundle);
    }
    paramContext = new QRoutePluginReceiverParams.Builder(paramContext).setReceiverName("com.qqcomic.app.VipPreloadComicProcess").setIntent(localIntent).build();
    QRoute.plugin("comic_plugin.apk").sendBroadcast(paramContext);
    if (QLog.isColorLevel()) {
      QLog.d("QQComicDebug", 2, "load plugin end");
    }
  }
  
  /* Error */
  public static void a(Intent paramIntent)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +4 -> 5
    //   4: return
    //   5: ldc 183
    //   7: invokestatic 133	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   10: checkcast 183	com/tencent/mobileqq/dpc/api/IDPCApi
    //   13: getstatic 189	com/tencent/mobileqq/dpc/enumname/DPCNames:comic_plugin_profile	Lcom/tencent/mobileqq/dpc/enumname/DPCNames;
    //   16: invokevirtual 193	com/tencent/mobileqq/dpc/enumname/DPCNames:name	()Ljava/lang/String;
    //   19: ldc 195
    //   21: invokeinterface 199 3 0
    //   26: astore 9
    //   28: invokestatic 51	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   31: ifeq +39 -> 70
    //   34: new 201	java/lang/StringBuilder
    //   37: dup
    //   38: invokespecial 202	java/lang/StringBuilder:<init>	()V
    //   41: astore 10
    //   43: aload 10
    //   45: ldc 204
    //   47: invokevirtual 208	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: pop
    //   51: aload 10
    //   53: aload 9
    //   55: invokevirtual 208	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: pop
    //   59: ldc 210
    //   61: iconst_2
    //   62: aload 10
    //   64: invokevirtual 213	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   67: invokestatic 58	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   70: aload 9
    //   72: invokestatic 219	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   75: istore 4
    //   77: iconst_0
    //   78: istore 7
    //   80: iconst_0
    //   81: istore 8
    //   83: iconst_1
    //   84: istore_3
    //   85: iconst_1
    //   86: istore 5
    //   88: iload 4
    //   90: ifne +213 -> 303
    //   93: bipush 7
    //   95: anewarray 221	java/lang/Integer
    //   98: astore 10
    //   100: aload 10
    //   102: iconst_0
    //   103: invokestatic 225	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   106: invokestatic 231	java/util/Arrays:fill	([Ljava/lang/Object;Ljava/lang/Object;)V
    //   109: aload 10
    //   111: iconst_2
    //   112: iconst_1
    //   113: invokestatic 225	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   116: aastore
    //   117: ldc 183
    //   119: invokestatic 133	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   122: checkcast 183	com/tencent/mobileqq/dpc/api/IDPCApi
    //   125: aload 9
    //   127: aload 10
    //   129: invokeinterface 235 3 0
    //   134: aload 10
    //   136: arraylength
    //   137: if_icmplt +166 -> 303
    //   140: aload 10
    //   142: iconst_0
    //   143: aaload
    //   144: invokevirtual 239	java/lang/Integer:intValue	()I
    //   147: istore_1
    //   148: iload_1
    //   149: iconst_1
    //   150: if_icmpne +8 -> 158
    //   153: iconst_1
    //   154: istore_3
    //   155: goto +5 -> 160
    //   158: iconst_0
    //   159: istore_3
    //   160: aload 10
    //   162: iconst_1
    //   163: aaload
    //   164: invokevirtual 239	java/lang/Integer:intValue	()I
    //   167: istore_1
    //   168: iload_1
    //   169: iconst_1
    //   170: if_icmpne +9 -> 179
    //   173: iconst_1
    //   174: istore 4
    //   176: goto +6 -> 182
    //   179: iconst_0
    //   180: istore 4
    //   182: aload 10
    //   184: iconst_2
    //   185: aaload
    //   186: invokevirtual 239	java/lang/Integer:intValue	()I
    //   189: istore_1
    //   190: iload_1
    //   191: iconst_1
    //   192: if_icmpne +9 -> 201
    //   195: iconst_1
    //   196: istore 5
    //   198: goto +6 -> 204
    //   201: iconst_0
    //   202: istore 5
    //   204: aload 10
    //   206: iconst_3
    //   207: aaload
    //   208: invokevirtual 239	java/lang/Integer:intValue	()I
    //   211: istore_1
    //   212: iload_1
    //   213: iconst_1
    //   214: if_icmpne +9 -> 223
    //   217: iconst_1
    //   218: istore 6
    //   220: goto +6 -> 226
    //   223: iconst_0
    //   224: istore 6
    //   226: aload 10
    //   228: iconst_5
    //   229: aaload
    //   230: invokevirtual 239	java/lang/Integer:intValue	()I
    //   233: istore_1
    //   234: aload 10
    //   236: bipush 6
    //   238: aaload
    //   239: invokevirtual 239	java/lang/Integer:intValue	()I
    //   242: istore_2
    //   243: iload 8
    //   245: istore 7
    //   247: iload_2
    //   248: iconst_1
    //   249: if_icmpne +6 -> 255
    //   252: iconst_1
    //   253: istore 7
    //   255: goto +65 -> 320
    //   258: astore 9
    //   260: goto +35 -> 295
    //   263: astore 9
    //   265: goto +28 -> 293
    //   268: astore 9
    //   270: goto +20 -> 290
    //   273: astore 9
    //   275: goto +15 -> 290
    //   278: astore 9
    //   280: goto +7 -> 287
    //   283: astore 9
    //   285: iconst_0
    //   286: istore_3
    //   287: iconst_0
    //   288: istore 4
    //   290: iconst_0
    //   291: istore 6
    //   293: iconst_0
    //   294: istore_1
    //   295: aload 9
    //   297: invokevirtual 242	java/lang/Exception:printStackTrace	()V
    //   300: goto +20 -> 320
    //   303: iconst_0
    //   304: istore 8
    //   306: iconst_0
    //   307: istore 4
    //   309: iconst_0
    //   310: istore 6
    //   312: iconst_0
    //   313: istore_1
    //   314: iload_3
    //   315: istore 5
    //   317: iload 8
    //   319: istore_3
    //   320: aload_0
    //   321: ldc 244
    //   323: iload 4
    //   325: invokevirtual 99	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   328: pop
    //   329: aload_0
    //   330: ldc 246
    //   332: iload 5
    //   334: invokevirtual 99	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   337: pop
    //   338: aload_0
    //   339: ldc 248
    //   341: iload 6
    //   343: invokevirtual 99	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   346: pop
    //   347: aload_0
    //   348: ldc 250
    //   350: iload_1
    //   351: invokevirtual 94	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   354: pop
    //   355: aload_0
    //   356: ldc 252
    //   358: iload 7
    //   360: invokevirtual 99	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   363: pop
    //   364: invokestatic 51	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   367: ifeq +108 -> 475
    //   370: new 201	java/lang/StringBuilder
    //   373: dup
    //   374: invokespecial 202	java/lang/StringBuilder:<init>	()V
    //   377: astore_0
    //   378: aload_0
    //   379: ldc 254
    //   381: invokevirtual 208	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   384: pop
    //   385: aload_0
    //   386: iload_3
    //   387: invokevirtual 257	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   390: pop
    //   391: aload_0
    //   392: ldc_w 259
    //   395: invokevirtual 208	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   398: pop
    //   399: aload_0
    //   400: iload 4
    //   402: invokevirtual 257	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   405: pop
    //   406: aload_0
    //   407: ldc_w 261
    //   410: invokevirtual 208	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   413: pop
    //   414: aload_0
    //   415: iload 5
    //   417: invokevirtual 257	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   420: pop
    //   421: aload_0
    //   422: ldc_w 263
    //   425: invokevirtual 208	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   428: pop
    //   429: aload_0
    //   430: iload 6
    //   432: invokevirtual 257	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   435: pop
    //   436: aload_0
    //   437: ldc_w 265
    //   440: invokevirtual 208	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   443: pop
    //   444: aload_0
    //   445: iload_1
    //   446: invokevirtual 268	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   449: pop
    //   450: aload_0
    //   451: ldc_w 270
    //   454: invokevirtual 208	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   457: pop
    //   458: aload_0
    //   459: iload 7
    //   461: invokevirtual 257	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   464: pop
    //   465: ldc 53
    //   467: iconst_2
    //   468: aload_0
    //   469: invokevirtual 213	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   472: invokestatic 58	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   475: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	476	0	paramIntent	Intent
    //   147	299	1	i	int
    //   242	8	2	j	int
    //   84	303	3	bool1	boolean
    //   75	326	4	bool2	boolean
    //   86	330	5	bool3	boolean
    //   218	213	6	bool4	boolean
    //   78	382	7	bool5	boolean
    //   81	237	8	bool6	boolean
    //   26	100	9	str	String
    //   258	1	9	localException1	Exception
    //   263	1	9	localException2	Exception
    //   268	1	9	localException3	Exception
    //   273	1	9	localException4	Exception
    //   278	1	9	localException5	Exception
    //   283	13	9	localException6	Exception
    //   41	194	10	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   234	243	258	java/lang/Exception
    //   226	234	263	java/lang/Exception
    //   204	212	268	java/lang/Exception
    //   182	190	273	java/lang/Exception
    //   160	168	278	java/lang/Exception
    //   93	148	283	java/lang/Exception
  }
  
  public static void a(String paramString)
  {
    try
    {
      long l = System.currentTimeMillis();
      Object localObject = PluginStatic.getOrCreateClassLoader(AppHelper.a(), "comic_plugin.apk").loadClass("com.qqcomic.utils.ComicPluginVersionInfo");
      ((Class)localObject).getDeclaredMethod("printVersionInfo", new Class[] { String.class }).invoke(localObject, new Object[] { paramString });
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("ComicPlugin.checkBoodoPluginVersion, msg=");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(", call_time=");
      ((StringBuilder)localObject).append(System.currentTimeMillis() - l);
      QLog.i("QQComicPluginBridge", 2, ((StringBuilder)localObject).toString());
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("QQComicPluginBridge", 1, paramString, new Object[0]);
      return;
    }
    catch (InstantiationException paramString)
    {
      QLog.e("QQComicPluginBridge", 1, paramString, new Object[0]);
      return;
    }
    catch (IllegalAccessException paramString)
    {
      QLog.e("QQComicPluginBridge", 1, paramString, new Object[0]);
      return;
    }
    catch (ClassNotFoundException paramString)
    {
      QLog.e("QQComicPluginBridge", 1, paramString, new Object[0]);
    }
  }
  
  public static void a(Observer paramObserver)
  {
    FirstInObservable localFirstInObservable = d;
    if (localFirstInObservable == null) {
      d = new FirstInObservable();
    } else {
      localFirstInObservable.deleteObservers();
    }
    d.addObserver(paramObserver);
  }
  
  public static boolean a(Activity paramActivity, Intent paramIntent, String paramString, PreloadProcHitPluginSession paramPreloadProcHitPluginSession)
  {
    if ((a) && (paramActivity != null) && (paramIntent != null))
    {
      if (TextUtils.isEmpty(paramString)) {
        return false;
      }
      paramIntent.putExtra("big_brother_source_key", "biz_src_zz_bodong");
      if ((paramActivity instanceof BasePluginActivity))
      {
        paramActivity.startActivity(paramIntent);
        return true;
      }
      paramIntent.putExtra("userQqResources", 2);
      paramIntent.putExtra("useSkinEngine", false);
      paramIntent.putExtra("params_remote_connect_at_launch", true);
      paramActivity = new QRoutePluginActivityParams.Builder(paramActivity).setActivityName(paramString).setActivityProxy(VipComicProxyActivity.a(paramString)).setIntent(paramIntent).setTimeoutMills(10000).setSession(paramPreloadProcHitPluginSession).build();
      QRoute.plugin("comic_plugin.apk").startActivityForResult(paramActivity);
      return true;
    }
    return false;
  }
  
  public static boolean a(AppRuntime paramAppRuntime)
  {
    if (a)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQComicPluginBridge", 2, "QQComic is ready");
      }
      return true;
    }
    if (!(paramAppRuntime instanceof BaseQQAppInterface))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQComicPluginBridge", 2, "Not in main process, QQComic is NOT installed");
      }
      return a;
    }
    paramAppRuntime = QRoute.plugin("comic_plugin.apk");
    boolean bool = false;
    if (paramAppRuntime == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQComicPluginBridge", 2, "PluginManager is NOT ready");
      }
      return false;
    }
    paramAppRuntime = paramAppRuntime.queryPluginInfo();
    if (paramAppRuntime == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQComicPluginBridge", 2, "QQComic is NOT found");
      }
      return false;
    }
    if (paramAppRuntime.getState() == 4) {
      bool = true;
    }
    a = bool;
    return a;
  }
  
  public static boolean a(AppRuntime paramAppRuntime, boolean paramBoolean, QQComicPluginBridge.PluginInstallObserver arg2)
  {
    boolean bool2 = a(paramAppRuntime);
    boolean bool1 = true;
    if (bool2)
    {
      a = true;
      if (QLog.isColorLevel()) {
        QLog.d("QQComicPluginBridge", 2, "QQComic is ready");
      }
      return true;
    }
    paramAppRuntime = QRoute.plugin("comic_plugin.apk");
    if (paramAppRuntime == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQComicPluginBridge", 2, "PluginManager is NOT ready");
      }
      return false;
    }
    ThreadManager.executeOnNetWorkThread(new QQComicPluginBridge.1(paramAppRuntime, ???, paramBoolean));
    if (paramBoolean)
    {
      QRoutePluginInfo localQRoutePluginInfo = paramAppRuntime.queryPluginInfo();
      while ((localQRoutePluginInfo != null) && (localQRoutePluginInfo.getState() != 4)) {
        synchronized (f)
        {
          if (QLog.isColorLevel()) {
            QLog.d("QQComicPluginBridge", 2, "QQComic is waiting for installation");
          }
          try
          {
            f.wait();
            if (QLog.isColorLevel()) {
              QLog.d("QQComicPluginBridge", 2, "QQComic installation is finished");
            }
          }
          catch (InterruptedException localInterruptedException)
          {
            label147:
            break label147;
          }
        }
      }
      localQRoutePluginInfo = paramAppRuntime.queryPluginInfo();
      if ((localQRoutePluginInfo != null) && (localQRoutePluginInfo.getState() == 4)) {
        paramBoolean = bool1;
      } else {
        paramBoolean = false;
      }
      a = paramBoolean;
      if (QLog.isColorLevel())
      {
        ??? = new StringBuilder();
        ???.append("QQComic is ");
        if (a) {
          paramAppRuntime = "installed";
        } else {
          paramAppRuntime = "NOT installed";
        }
        ???.append(paramAppRuntime);
        ???.append(", ComicPlugin.pluginInfo.version=");
        if (localQRoutePluginInfo == null) {
          paramAppRuntime = "info null";
        } else {
          paramAppRuntime = localQRoutePluginInfo.getVersion();
        }
        ???.append(paramAppRuntime);
        QLog.d("QQComicPluginBridge", 2, ???.toString());
      }
      if (a) {
        a("plugin_ready");
      }
      return a;
    }
    else
    {
      return false;
    }
  }
  
  public static void b(Observer paramObserver)
  {
    RuntimeCreateObservable localRuntimeCreateObservable = e;
    if (localRuntimeCreateObservable == null) {
      e = new RuntimeCreateObservable();
    } else {
      localRuntimeCreateObservable.deleteObservers();
    }
    e.addObserver(paramObserver);
  }
  
  public static void c(Observer paramObserver)
  {
    RuntimeCreateObservable localRuntimeCreateObservable = e;
    if ((localRuntimeCreateObservable != null) && (paramObserver != null)) {
      localRuntimeCreateObservable.deleteObserver(paramObserver);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.comic.utils.QQComicPluginBridge
 * JD-Core Version:    0.7.0.1
 */