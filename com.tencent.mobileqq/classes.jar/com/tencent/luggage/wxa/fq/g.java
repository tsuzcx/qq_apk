package com.tencent.luggage.wxa.fq;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.util.Log;
import com.tencent.ilinkservice.aq;
import com.tencent.luggage.opensdk.d.b;
import com.tencent.luggage.opensdk.i;
import com.tencent.luggage.wxa.cx.k;
import com.tencent.luggage.wxa.da.f.a;
import com.tencent.luggage.wxa.dc.m;
import com.tencent.luggage.wxa.dc.m.a;
import com.tencent.luggage.wxa.ea.c;
import com.tencent.luggage.wxa.ea.c.a;
import com.tencent.luggage.wxa.ef.d.a;
import com.tencent.luggage.wxa.pd.u;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.r;
import com.tencent.luggage.wxa.qz.x;
import com.tencent.luggage.wxa.ro.e.a;
import com.tencent.luggage.wxa.ro.e.c;
import com.tencent.luggage.wxaapi.DebugApi;
import com.tencent.luggage.wxaapi.InitDynamicPkgResult;
import com.tencent.luggage.wxaapi.LaunchByUsernameResultListener;
import com.tencent.luggage.wxaapi.LaunchWxaAppResult;
import com.tencent.luggage.wxaapi.LaunchWxaAppResultListener;
import com.tencent.luggage.wxaapi.LaunchWxaAppWithShortLinkResult;
import com.tencent.luggage.wxaapi.LaunchWxaAppWithShortLinkResultListener;
import com.tencent.luggage.wxaapi.PreloadWxaProcessEnvResult;
import com.tencent.luggage.wxaapi.PreloadWxaProcessEnvResultListener;
import com.tencent.luggage.wxaapi.TdiAuthCheckStateListener;
import com.tencent.luggage.wxaapi.TdiAuthListener;
import com.tencent.luggage.wxaapi.TdiAuthState;
import com.tencent.luggage.wxaapi.UploadLogResultCode;
import com.tencent.luggage.wxaapi.UploadLogResultListener;
import com.tencent.luggage.wxaapi.WxaApi;
import com.tencent.luggage.wxaapi.WxaAppCloseEventListener;
import com.tencent.mm.opensdk.modelbiz.WXLaunchWxaRedirectingPage.Resp;
import com.tencent.mm.opensdk.modelmsg.SendAuth.Req;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import com.tencent.mm.plugin.appbrand.shortlink.WxaShortLinkLaunchErrorCode;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.contracts.ExperimentalContracts;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/wxaapi/internal/WxaApiImpl;", "Lcom/tencent/luggage/wxaapi/WxaApi;", "context", "Landroid/content/Context;", "hostAppID", "", "abiType", "", "(Landroid/content/Context;Ljava/lang/String;I)V", "callbackMap", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/luggage/wxaapi/internal/WxaApiImpl$AuthCallbackHolder;", "mDebugAPI", "Lcom/tencent/luggage/wxaapi/DebugApi;", "getMDebugAPI", "()Lcom/tencent/luggage/wxaapi/DebugApi;", "mDebugAPI$delegate", "Lkotlin/Lazy;", "mWXAPI", "Lcom/tencent/mm/opensdk/openapi/IWXAPI;", "addWxaAppCloseEventListener", "", "listener", "Lcom/tencent/luggage/wxaapi/WxaAppCloseEventListener;", "checkAuthState", "Lcom/tencent/luggage/wxaapi/TdiAuthCheckStateListener;", "checkAuthStateSuspended", "Lcom/tencent/luggage/wxaapi/TdiAuthState;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "checkIfWechatSupportWxaApi", "", "clearAuth", "closeWxaApp", "wxaAppID", "allowBackgroundRunning", "getDebugApi", "getSDKVersion", "getSDKVersionInt", "getTdiUserId", "handleIntent", "intent", "Landroid/content/Intent;", "handleIntentImpl", "initDynamicPkg", "Lcom/tencent/luggage/wxaapi/InitDynamicPkgResult;", "dynamicPkgPath", "isDynamicPkgLoaded", "launchByQRRawData", "", "qrRawData", "hostExtraData", "", "", "Lcom/tencent/luggage/wxaapi/LaunchWxaAppResultListener;", "launchByQRScanCode", "launchByUsername", "username", "versionType", "enterPath", "Lcom/tencent/luggage/wxaapi/LaunchByUsernameResultListener;", "launchWxaApp", "", "launchWxaAppInner", "shortLink", "launchWxaByShortLink", "ctx", "Landroid/app/Activity;", "showLaunchWxaTipDialog", "Lcom/tencent/luggage/wxaapi/LaunchWxaAppWithShortLinkResultListener;", "preloadWxaProcessEnv", "wxaAppType", "Lcom/tencent/luggage/wxaapi/PreloadWxaProcessEnvResultListener;", "removeWxaAppCloseEventListener", "requestUploadLogFiles", "startTime", "endTime", "Lcom/tencent/luggage/wxaapi/UploadLogResultListener;", "sendAuth", "Lcom/tencent/luggage/wxaapi/TdiAuthListener;", "sendAuthImpl", "sendCombineAuth", "req", "Lcom/tencent/mm/opensdk/modelmsg/SendAuth$Req;", "handler", "Lcom/tencent/mm/opensdk/openapi/IWXAPIEventHandler;", "sendCombineAuthImpl", "setWxaProcessMaxCount", "maxCount", "updateTuringOAID", "oaid", "toLaunchWxaAppWithShortLinkResult", "Lcom/tencent/luggage/wxaapi/LaunchWxaAppWithShortLinkResult;", "Lcom/tencent/mm/plugin/appbrand/shortlink/WxaShortLinkLaunchErrorCode;", "AuthCallbackHolder", "Companion", "Global", "WxaApiUtils", "luggage-standalone-open-runtime-sdk_release"}, k=1, mv={1, 1, 16})
public final class g
  implements WxaApi
{
  @Deprecated
  public static final g.b a = new g.b(null);
  private final IWXAPI b;
  private final Lazy c;
  private final ConcurrentHashMap<String, g.a> d;
  private final String e;
  private final int f;
  
  public g(@NotNull Context paramContext, @NotNull String paramString, int paramInt)
  {
    this.e = paramString;
    this.f = paramInt;
    this.c = LazyKt.lazy((Function0)new g.r(this));
    g.c.a.a(this.e);
    g.c.a.a((g)this);
    l.a.a(this.f);
    paramString = new StringBuilder();
    paramString.append("ProcessStartupFactory.initialize process:");
    paramString.append(r.b(paramContext));
    String str = paramString.toString();
    long l = SystemClock.elapsedRealtime();
    com.tencent.luggage.wxa.fu.g.a.a(paramContext);
    paramString = Unit.INSTANCE;
    if ((paramString instanceof d.a))
    {
      paramString = ((d.a)paramString).a();
    }
    else
    {
      paramString = paramString.toString();
      if (paramString == null) {
        paramString = "";
      }
    }
    boolean bool = u.a();
    l = SystemClock.elapsedRealtime() - l;
    StringBuilder localStringBuilder;
    if ((l > 32) && (bool))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("block main thread and skip ");
      localStringBuilder.append((int)(l / 16));
      localStringBuilder.append(" frames! runProfiled:log:");
      localStringBuilder.append(str);
      localStringBuilder.append(" cost ");
      localStringBuilder.append(l);
      localStringBuilder.append(" ms result:");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" isMainThread: ");
      localStringBuilder.append(bool);
      localStringBuilder.append(' ');
      o.c("Luggage.Utils.Profile", localStringBuilder.toString());
    }
    else
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("runProfiled:log:");
      localStringBuilder.append(str);
      localStringBuilder.append(" cost ");
      localStringBuilder.append(l);
      localStringBuilder.append(" ms result:");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" isMainThread: ");
      localStringBuilder.append(bool);
      localStringBuilder.append(' ');
      o.d("Luggage.Utils.Profile", localStringBuilder.toString());
    }
    paramContext = WXAPIFactory.createWXAPI(paramContext, this.e, f.a.c() ^ true);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "WXAPIFactory.createWXAPI…s.IS_DEBUG_WX_ACCEPTABLE)");
    this.b = paramContext;
    com.tencent.luggage.opensdk.d.a(this.b);
    com.tencent.luggage.opensdk.d.a(WXLaunchWxaRedirectingPage.Resp.class, (d.b)g.1.a);
    if (r.h())
    {
      com.tencent.luggage.wxa.fv.e.a.b(this.e);
      com.tencent.luggage.wxa.fv.e.a.a(this.f);
    }
    paramContext = new StringBuilder();
    paramContext.append("<init> process:");
    paramContext.append(r.c());
    paramContext.append(", version:");
    paramContext.append(g.c.a.c());
    paramContext.append("(0x");
    paramString = Integer.toString(553976065, CharsKt.checkRadix(16));
    Intrinsics.checkExpressionValueIsNotNull(paramString, "java.lang.Integer.toStri…(this, checkRadix(radix))");
    paramContext.append(paramString);
    paramContext.append("), hostAppID:");
    paramContext.append(this.e);
    paramContext.append(", abiType:");
    paramContext.append(this.f);
    paramContext = paramContext.toString();
    Log.i("Luggage.WxaApiImpl", paramContext);
    o.d("Luggage.WxaApiImpl", paramContext);
    this.d = new ConcurrentHashMap();
  }
  
  private final long a(Context paramContext, String paramString1, int paramInt, String paramString2, String paramString3, Map<String, ? extends Object> paramMap, LaunchWxaAppResultListener paramLaunchWxaAppResultListener)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("launchWxaApp wxaAppID:");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(" versionType:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" enterPath:");
    localStringBuilder.append(paramString2);
    localStringBuilder.append(" start");
    o.d("Luggage.WxaApiImpl", localStringBuilder.toString());
    long l = g.d.a.a();
    com.tencent.luggage.wxa.ft.a.a.a(l, paramString1, paramInt, (LaunchWxaAppResultListener)new g.n(paramLaunchWxaAppResultListener));
    com.tencent.mm.plugin.appbrand.keylogger.d.a(com.tencent.luggage.wxa.oy.a.class, paramString1);
    paramLaunchWxaAppResultListener = new StringBuilder();
    paramLaunchWxaAppResultListener.append("Network:");
    paramLaunchWxaAppResultListener.append(x.b(r.a()));
    com.tencent.mm.plugin.appbrand.keylogger.d.a(com.tencent.luggage.wxa.oy.a.class, paramString1, paramLaunchWxaAppResultListener.toString());
    if (!isDynamicPkgLoaded())
    {
      o.b("Luggage.WxaApiImpl", "launchWxaApp rejected, dynamic pkg not loaded");
      com.tencent.luggage.wxa.ft.a.a.a(l, LaunchWxaAppResult.FailNotLoadDynamicPkg);
      com.tencent.mm.plugin.appbrand.keylogger.d.b(com.tencent.luggage.wxa.oy.a.class, paramString1);
      return l;
    }
    com.tencent.luggage.wxa.fu.d.a.a((Function0)new g.o(this, paramString1, paramContext, paramInt, paramString2, paramString3, l, paramMap));
    return l;
  }
  
  private final LaunchWxaAppWithShortLinkResult a(@NotNull WxaShortLinkLaunchErrorCode paramWxaShortLinkLaunchErrorCode)
  {
    switch (h.b[paramWxaShortLinkLaunchErrorCode.ordinal()])
    {
    default: 
      return LaunchWxaAppWithShortLinkResult.UNKNOWN;
    case 7: 
      return LaunchWxaAppWithShortLinkResult.LAUNCH_PHASE_FAIL;
    case 6: 
      return LaunchWxaAppWithShortLinkResult.INTERRUPT;
    case 5: 
      return LaunchWxaAppWithShortLinkResult.CONTEXT_RELEASE;
    case 4: 
      return LaunchWxaAppWithShortLinkResult.USER_CANCEL;
    case 3: 
      return LaunchWxaAppWithShortLinkResult.DECODE_LINK_FAIL;
    case 2: 
      return LaunchWxaAppWithShortLinkResult.ILLEGAL_LINK;
    }
    return LaunchWxaAppWithShortLinkResult.SUCCESS;
  }
  
  /* Error */
  private final void a(TdiAuthListener paramTdiAuthListener)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 400	com/tencent/luggage/wxa/fq/g:isDynamicPkgLoaded	()Z
    //   4: ifne +20 -> 24
    //   7: aload_1
    //   8: ifnull +15 -> 23
    //   11: aload_1
    //   12: getstatic 483	com/tencent/luggage/wxaapi/TdiAuthErrCode:WechatTdi_Auth_Err_Dynamic_Pkg_Not_Loaded	Lcom/tencent/luggage/wxaapi/TdiAuthErrCode;
    //   15: ldc_w 485
    //   18: invokeinterface 491 3 0
    //   23: return
    //   24: aload_0
    //   25: getfield 280	com/tencent/luggage/wxa/fq/g:b	Lcom/tencent/mm/opensdk/openapi/IWXAPI;
    //   28: invokeinterface 496 1 0
    //   33: ifne +33 -> 66
    //   36: aload_1
    //   37: ifnull +13 -> 50
    //   40: aload_1
    //   41: getstatic 499	com/tencent/luggage/wxaapi/TdiAuthErrCode:WechatTdi_Auth_Err_WechatNotInstalled	Lcom/tencent/luggage/wxaapi/TdiAuthErrCode;
    //   44: aconst_null
    //   45: invokeinterface 491 3 0
    //   50: getstatic 363	com/tencent/luggage/wxa/fq/g$d:a	Lcom/tencent/luggage/wxa/fq/g$d;
    //   53: ldc_w 500
    //   56: iconst_0
    //   57: aconst_null
    //   58: iconst_0
    //   59: bipush 12
    //   61: aconst_null
    //   62: invokestatic 503	com/tencent/luggage/wxa/fq/g$d:a	(Lcom/tencent/luggage/wxa/fq/g$d;Ljava/lang/String;ZLjava/lang/String;IILjava/lang/Object;)V
    //   65: return
    //   66: aload_0
    //   67: invokevirtual 505	com/tencent/luggage/wxa/fq/g:checkIfWechatSupportWxaApi	()Z
    //   70: ifne +33 -> 103
    //   73: aload_1
    //   74: ifnull +13 -> 87
    //   77: aload_1
    //   78: getstatic 508	com/tencent/luggage/wxaapi/TdiAuthErrCode:WechatTdi_Auth_Err_WechatVersionTooLow	Lcom/tencent/luggage/wxaapi/TdiAuthErrCode;
    //   81: aconst_null
    //   82: invokeinterface 491 3 0
    //   87: getstatic 363	com/tencent/luggage/wxa/fq/g$d:a	Lcom/tencent/luggage/wxa/fq/g$d;
    //   90: ldc_w 500
    //   93: iconst_0
    //   94: aconst_null
    //   95: iconst_0
    //   96: bipush 12
    //   98: aconst_null
    //   99: invokestatic 503	com/tencent/luggage/wxa/fq/g$d:a	(Lcom/tencent/luggage/wxa/fq/g$d;Ljava/lang/String;ZLjava/lang/String;IILjava/lang/Object;)V
    //   102: return
    //   103: new 510	com/tencent/mm/opensdk/modelmsg/SendAuth$Req
    //   106: dup
    //   107: invokespecial 511	com/tencent/mm/opensdk/modelmsg/SendAuth$Req:<init>	()V
    //   110: astore_3
    //   111: new 180	java/lang/StringBuilder
    //   114: dup
    //   115: invokespecial 181	java/lang/StringBuilder:<init>	()V
    //   118: astore 4
    //   120: aload 4
    //   122: aload_0
    //   123: invokevirtual 514	com/tencent/luggage/wxa/fq/g:hashCode	()I
    //   126: invokevirtual 232	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   129: pop
    //   130: aload 4
    //   132: bipush 95
    //   134: invokevirtual 249	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   137: pop
    //   138: aload 4
    //   140: invokestatic 518	com/tencent/luggage/wxa/qz/af:d	()J
    //   143: invokevirtual 239	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   146: pop
    //   147: aload_3
    //   148: aload 4
    //   150: invokevirtual 196	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   153: putfield 521	com/tencent/mm/opensdk/modelmsg/SendAuth$Req:transaction	Ljava/lang/String;
    //   156: aload_3
    //   157: ldc_w 523
    //   160: putfield 526	com/tencent/mm/opensdk/modelmsg/SendAuth$Req:scope	Ljava/lang/String;
    //   163: aload_0
    //   164: getfield 348	com/tencent/luggage/wxa/fq/g:d	Ljava/util/concurrent/ConcurrentHashMap;
    //   167: checkcast 528	java/util/Map
    //   170: astore 4
    //   172: aload_3
    //   173: getfield 521	com/tencent/mm/opensdk/modelmsg/SendAuth$Req:transaction	Ljava/lang/String;
    //   176: astore 5
    //   178: aload 5
    //   180: ldc_w 530
    //   183: invokestatic 278	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   186: aload 4
    //   188: aload 5
    //   190: new 532	com/tencent/luggage/wxa/fq/g$a
    //   193: dup
    //   194: aload_1
    //   195: aconst_null
    //   196: iconst_2
    //   197: aconst_null
    //   198: invokespecial 535	com/tencent/luggage/wxa/fq/g$a:<init>	(Lcom/tencent/luggage/wxaapi/TdiAuthListener;Lcom/tencent/mm/opensdk/openapi/IWXAPIEventHandler;ILkotlin/jvm/internal/DefaultConstructorMarker;)V
    //   201: invokeinterface 539 3 0
    //   206: pop
    //   207: aload_0
    //   208: getfield 280	com/tencent/luggage/wxa/fq/g:b	Lcom/tencent/mm/opensdk/openapi/IWXAPI;
    //   211: aload_3
    //   212: checkcast 541	com/tencent/mm/opensdk/modelbase/BaseReq
    //   215: invokeinterface 545 2 0
    //   220: istore_2
    //   221: iload_2
    //   222: ifne +24 -> 246
    //   225: aload_1
    //   226: ifnull +20 -> 246
    //   229: aload_1
    //   230: getstatic 548	com/tencent/luggage/wxaapi/TdiAuthErrCode:WechatTdi_Auth_Err_NormalErr	Lcom/tencent/luggage/wxaapi/TdiAuthErrCode;
    //   233: aconst_null
    //   234: invokeinterface 491 3 0
    //   239: goto +7 -> 246
    //   242: astore_1
    //   243: goto +22 -> 265
    //   246: getstatic 363	com/tencent/luggage/wxa/fq/g$d:a	Lcom/tencent/luggage/wxa/fq/g$d;
    //   249: ldc_w 500
    //   252: iload_2
    //   253: aconst_null
    //   254: iconst_0
    //   255: bipush 12
    //   257: aconst_null
    //   258: invokestatic 503	com/tencent/luggage/wxa/fq/g$d:a	(Lcom/tencent/luggage/wxa/fq/g$d;Ljava/lang/String;ZLjava/lang/String;IILjava/lang/Object;)V
    //   261: return
    //   262: astore_1
    //   263: iconst_0
    //   264: istore_2
    //   265: getstatic 363	com/tencent/luggage/wxa/fq/g$d:a	Lcom/tencent/luggage/wxa/fq/g$d;
    //   268: ldc_w 500
    //   271: iload_2
    //   272: aconst_null
    //   273: iconst_0
    //   274: bipush 12
    //   276: aconst_null
    //   277: invokestatic 503	com/tencent/luggage/wxa/fq/g$d:a	(Lcom/tencent/luggage/wxa/fq/g$d;Ljava/lang/String;ZLjava/lang/String;IILjava/lang/Object;)V
    //   280: aload_1
    //   281: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	282	0	this	g
    //   0	282	1	paramTdiAuthListener	TdiAuthListener
    //   220	52	2	bool	boolean
    //   110	102	3	localReq	SendAuth.Req
    //   118	69	4	localObject	Object
    //   176	13	5	str	String
    // Exception table:
    //   from	to	target	type
    //   229	239	242	finally
    //   24	36	262	finally
    //   40	50	262	finally
    //   66	73	262	finally
    //   77	87	262	finally
    //   103	221	262	finally
  }
  
  /* Error */
  private final void a(SendAuth.Req paramReq, IWXAPIEventHandler paramIWXAPIEventHandler, TdiAuthListener paramTdiAuthListener)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 400	com/tencent/luggage/wxa/fq/g:isDynamicPkgLoaded	()Z
    //   4: ifne +20 -> 24
    //   7: aload_3
    //   8: ifnull +15 -> 23
    //   11: aload_3
    //   12: getstatic 483	com/tencent/luggage/wxaapi/TdiAuthErrCode:WechatTdi_Auth_Err_Dynamic_Pkg_Not_Loaded	Lcom/tencent/luggage/wxaapi/TdiAuthErrCode;
    //   15: ldc_w 485
    //   18: invokeinterface 491 3 0
    //   23: return
    //   24: iconst_0
    //   25: istore 5
    //   27: aload_0
    //   28: getfield 280	com/tencent/luggage/wxa/fq/g:b	Lcom/tencent/mm/opensdk/openapi/IWXAPI;
    //   31: invokeinterface 496 1 0
    //   36: ifne +33 -> 69
    //   39: aload_3
    //   40: ifnull +13 -> 53
    //   43: aload_3
    //   44: getstatic 499	com/tencent/luggage/wxaapi/TdiAuthErrCode:WechatTdi_Auth_Err_WechatNotInstalled	Lcom/tencent/luggage/wxaapi/TdiAuthErrCode;
    //   47: aconst_null
    //   48: invokeinterface 491 3 0
    //   53: getstatic 363	com/tencent/luggage/wxa/fq/g$d:a	Lcom/tencent/luggage/wxa/fq/g$d;
    //   56: ldc_w 550
    //   59: iconst_0
    //   60: aconst_null
    //   61: iconst_0
    //   62: bipush 12
    //   64: aconst_null
    //   65: invokestatic 503	com/tencent/luggage/wxa/fq/g$d:a	(Lcom/tencent/luggage/wxa/fq/g$d;Ljava/lang/String;ZLjava/lang/String;IILjava/lang/Object;)V
    //   68: return
    //   69: aload_0
    //   70: invokevirtual 505	com/tencent/luggage/wxa/fq/g:checkIfWechatSupportWxaApi	()Z
    //   73: ifne +33 -> 106
    //   76: aload_3
    //   77: ifnull +13 -> 90
    //   80: aload_3
    //   81: getstatic 508	com/tencent/luggage/wxaapi/TdiAuthErrCode:WechatTdi_Auth_Err_WechatVersionTooLow	Lcom/tencent/luggage/wxaapi/TdiAuthErrCode;
    //   84: aconst_null
    //   85: invokeinterface 491 3 0
    //   90: getstatic 363	com/tencent/luggage/wxa/fq/g$d:a	Lcom/tencent/luggage/wxa/fq/g$d;
    //   93: ldc_w 550
    //   96: iconst_0
    //   97: aconst_null
    //   98: iconst_0
    //   99: bipush 12
    //   101: aconst_null
    //   102: invokestatic 503	com/tencent/luggage/wxa/fq/g$d:a	(Lcom/tencent/luggage/wxa/fq/g$d;Ljava/lang/String;ZLjava/lang/String;IILjava/lang/Object;)V
    //   105: return
    //   106: aload_1
    //   107: ifnonnull +6 -> 113
    //   110: invokestatic 553	kotlin/jvm/internal/Intrinsics:throwNpe	()V
    //   113: aload_1
    //   114: getfield 521	com/tencent/mm/opensdk/modelmsg/SendAuth$Req:transaction	Ljava/lang/String;
    //   117: checkcast 555	java/lang/CharSequence
    //   120: astore 7
    //   122: aload 7
    //   124: ifnull +208 -> 332
    //   127: aload 7
    //   129: invokeinterface 558 1 0
    //   134: ifne +192 -> 326
    //   137: goto +195 -> 332
    //   140: iload 4
    //   142: ifne +148 -> 290
    //   145: aload_1
    //   146: getfield 526	com/tencent/mm/opensdk/modelmsg/SendAuth$Req:scope	Ljava/lang/String;
    //   149: astore 7
    //   151: new 180	java/lang/StringBuilder
    //   154: dup
    //   155: invokespecial 181	java/lang/StringBuilder:<init>	()V
    //   158: astore 8
    //   160: aload 8
    //   162: aload 7
    //   164: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: pop
    //   168: aload 8
    //   170: ldc_w 560
    //   173: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: pop
    //   177: aload_1
    //   178: aload 8
    //   180: invokevirtual 196	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   183: putfield 526	com/tencent/mm/opensdk/modelmsg/SendAuth$Req:scope	Ljava/lang/String;
    //   186: aload_0
    //   187: getfield 348	com/tencent/luggage/wxa/fq/g:d	Ljava/util/concurrent/ConcurrentHashMap;
    //   190: checkcast 528	java/util/Map
    //   193: astore 7
    //   195: aload_1
    //   196: getfield 521	com/tencent/mm/opensdk/modelmsg/SendAuth$Req:transaction	Ljava/lang/String;
    //   199: astore 8
    //   201: aload 8
    //   203: ldc_w 562
    //   206: invokestatic 278	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   209: aload 7
    //   211: aload 8
    //   213: new 532	com/tencent/luggage/wxa/fq/g$a
    //   216: dup
    //   217: aload_3
    //   218: aload_2
    //   219: invokespecial 565	com/tencent/luggage/wxa/fq/g$a:<init>	(Lcom/tencent/luggage/wxaapi/TdiAuthListener;Lcom/tencent/mm/opensdk/openapi/IWXAPIEventHandler;)V
    //   222: invokeinterface 539 3 0
    //   227: pop
    //   228: aload_0
    //   229: getfield 280	com/tencent/luggage/wxa/fq/g:b	Lcom/tencent/mm/opensdk/openapi/IWXAPI;
    //   232: aload_1
    //   233: checkcast 541	com/tencent/mm/opensdk/modelbase/BaseReq
    //   236: invokeinterface 545 2 0
    //   241: istore 6
    //   243: iload 6
    //   245: ifne +28 -> 273
    //   248: aload_3
    //   249: ifnull +24 -> 273
    //   252: aload_3
    //   253: getstatic 548	com/tencent/luggage/wxaapi/TdiAuthErrCode:WechatTdi_Auth_Err_NormalErr	Lcom/tencent/luggage/wxaapi/TdiAuthErrCode;
    //   256: aconst_null
    //   257: invokeinterface 491 3 0
    //   262: goto +11 -> 273
    //   265: astore_1
    //   266: iload 6
    //   268: istore 5
    //   270: goto +38 -> 308
    //   273: getstatic 363	com/tencent/luggage/wxa/fq/g$d:a	Lcom/tencent/luggage/wxa/fq/g$d;
    //   276: ldc_w 550
    //   279: iload 6
    //   281: aconst_null
    //   282: iconst_0
    //   283: bipush 12
    //   285: aconst_null
    //   286: invokestatic 503	com/tencent/luggage/wxa/fq/g$d:a	(Lcom/tencent/luggage/wxa/fq/g$d;Ljava/lang/String;ZLjava/lang/String;IILjava/lang/Object;)V
    //   289: return
    //   290: new 567	java/lang/IllegalStateException
    //   293: dup
    //   294: ldc_w 569
    //   297: invokevirtual 221	java/lang/Object:toString	()Ljava/lang/String;
    //   300: invokespecial 571	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   303: checkcast 573	java/lang/Throwable
    //   306: athrow
    //   307: astore_1
    //   308: getstatic 363	com/tencent/luggage/wxa/fq/g$d:a	Lcom/tencent/luggage/wxa/fq/g$d;
    //   311: ldc_w 550
    //   314: iload 5
    //   316: aconst_null
    //   317: iconst_0
    //   318: bipush 12
    //   320: aconst_null
    //   321: invokestatic 503	com/tencent/luggage/wxa/fq/g$d:a	(Lcom/tencent/luggage/wxa/fq/g$d;Ljava/lang/String;ZLjava/lang/String;IILjava/lang/Object;)V
    //   324: aload_1
    //   325: athrow
    //   326: iconst_0
    //   327: istore 4
    //   329: goto -189 -> 140
    //   332: iconst_1
    //   333: istore 4
    //   335: goto -195 -> 140
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	338	0	this	g
    //   0	338	1	paramReq	SendAuth.Req
    //   0	338	2	paramIWXAPIEventHandler	IWXAPIEventHandler
    //   0	338	3	paramTdiAuthListener	TdiAuthListener
    //   140	194	4	i	int
    //   25	290	5	bool1	boolean
    //   241	39	6	bool2	boolean
    //   120	90	7	localObject1	Object
    //   158	54	8	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   252	262	265	finally
    //   27	39	307	finally
    //   43	53	307	finally
    //   69	76	307	finally
    //   80	90	307	finally
    //   110	113	307	finally
    //   113	122	307	finally
    //   127	137	307	finally
    //   145	243	307	finally
    //   290	307	307	finally
  }
  
  private final boolean a(Context paramContext, Intent paramIntent)
  {
    if (paramIntent != null)
    {
      if (com.tencent.luggage.opensdk.d.a(paramContext, paramIntent))
      {
        g.d.a(g.d.a, "handleIntent", true, null, 0, 12, null);
        return true;
      }
      paramContext = new boolean[1];
      int i = 0;
      while (i < 1)
      {
        paramContext[i] = 0;
        i += 1;
      }
      this.b.handleIntent(paramIntent, (IWXAPIEventHandler)new g.h(this, paramContext));
      int j = paramContext[0];
      g.d.a(g.d.a, "handleIntent", j, null, 0, 12, null);
      return j;
    }
    return false;
  }
  
  private final DebugApi b()
  {
    return (DebugApi)this.c.getValue();
  }
  
  public void addWxaAppCloseEventListener(@Nullable WxaAppCloseEventListener paramWxaAppCloseEventListener)
  {
    j.a.a(paramWxaAppCloseEventListener);
  }
  
  public void checkAuthState(@Nullable TdiAuthCheckStateListener paramTdiAuthCheckStateListener)
  {
    o.d("Luggage.WxaApiImpl", "checkAuthState start");
    if (!r.h())
    {
      o.d("Luggage.WxaApiImpl", "checkAuthStateSync() return NoAuth in non-main process");
      if (paramTdiAuthCheckStateListener != null) {
        paramTdiAuthCheckStateListener.onStateChecked(TdiAuthState.WechatTdi_Auth_State_NoAuth, null);
      }
      g.d.a(g.d.a, "checkAuthState", false, null, 0, 12, null);
      return;
    }
    if (!isDynamicPkgLoaded())
    {
      if (paramTdiAuthCheckStateListener != null) {
        paramTdiAuthCheckStateListener.onStateChecked(TdiAuthState.WechatTdi_Auth_State_Dynamic_Pkg_Not_Loaded, null);
      }
      g.d.a(g.d.a, "checkAuthState", false, null, 0, 12, null);
      return;
    }
    com.tencent.luggage.wxa.fu.d.a.a((Function0)new g.e(this, paramTdiAuthCheckStateListener));
    g.d.a(g.d.a, "checkAuthState", true, null, 0, 12, null);
  }
  
  public boolean checkIfWechatSupportWxaApi()
  {
    boolean bool = i.a.a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("checkIfWechatSupportWxaApi ");
    localStringBuilder.append(bool);
    o.d("Luggage.WxaApiImpl", localStringBuilder.toString());
    g.d.a(g.d.a, "checkIfWechatSupportWxaApi", true, null, 0, 12, null);
    return bool;
  }
  
  public void clearAuth()
  {
    o.d("Luggage.WxaApiImpl", "clearAuth start");
    if (!r.h()) {
      return;
    }
    com.tencent.luggage.wxa.fu.d.a.a((Function0)g.g.a);
  }
  
  public void closeWxaApp(@NotNull String paramString, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "wxaAppID");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("closeWxaApp wxaAppID:");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" allowBackgroundRunning:");
    localStringBuilder.append(paramBoolean);
    o.d("Luggage.WxaApiImpl", localStringBuilder.toString());
    if (!r.h())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("closeWxaApp wxaAppID:");
      localStringBuilder.append(paramString);
      localStringBuilder.append(", allowBackgroundRunning:");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(", not supported in non-main process");
      o.b("Luggage.WxaApiImpl", localStringBuilder.toString());
      g.d.a(g.d.a, "closeWxaApp", false, paramString, 0, 8, null);
      return;
    }
    com.tencent.luggage.wxa.standalone_open_runtime.container.a.a.b();
    if (!paramBoolean) {
      c.c.b().c(paramString, -1);
    } else {
      c.c.b().b(paramString, -1);
    }
    g.d.a(g.d.a, "closeWxaApp", true, paramString, 0, 8, null);
  }
  
  @NotNull
  public DebugApi getDebugApi()
  {
    return b();
  }
  
  @NotNull
  public String getSDKVersion()
  {
    String str = g.c.a.c();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getSDKVersion ");
    localStringBuilder.append(str);
    o.d("Luggage.WxaApiImpl", localStringBuilder.toString());
    g.d.a(g.d.a, "getSDKVersion", true, null, 0, 12, null);
    return str;
  }
  
  public int getSDKVersionInt()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getSDKVersionInt: ");
    localStringBuilder.append(553976065);
    o.d("Luggage.WxaApiImpl", localStringBuilder.toString());
    g.d.a(g.d.a, "getSDKVersionInt", true, null, 0, 12, null);
    return 553976065;
  }
  
  @NotNull
  public String getTdiUserId()
  {
    return m.a.a(g.c.a.b());
  }
  
  public boolean handleIntent(@Nullable Context paramContext, @Nullable Intent paramIntent)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("handleIntent: ctx [");
    String str = "null";
    if (paramContext != null) {
      localObject = Integer.valueOf(paramContext.hashCode());
    } else {
      localObject = "null";
    }
    localStringBuilder.append(localObject);
    localStringBuilder.append("], intent [");
    Object localObject = str;
    if (paramIntent != null) {
      localObject = Integer.valueOf(paramIntent.hashCode());
    }
    localStringBuilder.append(localObject);
    localStringBuilder.append(']');
    o.d("Luggage.WxaApiImpl", localStringBuilder.toString());
    return a(paramContext, paramIntent);
  }
  
  @NotNull
  public InitDynamicPkgResult initDynamicPkg(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "dynamicPkgPath");
    if (!r.h())
    {
      o.b("Luggage.WxaApiImpl", "initDynamicPkg() return false in non-main process");
      return InitDynamicPkgResult.FailNotInMainProcess;
    }
    paramString = l.a.a(paramString);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("initDynamicPkg dynamicPkgPath: ");
    localStringBuilder.append(paramString);
    o.d("Luggage.WxaApiImpl", localStringBuilder.toString());
    return paramString;
  }
  
  public boolean isDynamicPkgLoaded()
  {
    if (!r.h())
    {
      o.b("Luggage.WxaApiImpl", "isDynamicPkgLoaded() return false in non-main process");
      return false;
    }
    boolean bool = l.a.b();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("isDynamicPkgLoaded ");
    localStringBuilder.append(bool);
    o.d("Luggage.WxaApiImpl", localStringBuilder.toString());
    return bool;
  }
  
  public long launchByQRRawData(@Nullable Context paramContext, @NotNull String paramString, @Nullable Map<String, ? extends Object> paramMap, @Nullable LaunchWxaAppResultListener paramLaunchWxaAppResultListener)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "qrRawData");
    o.d("Luggage.WxaApiImpl", "launchByQRCodeRawData");
    long l = g.d.a.a();
    com.tencent.luggage.wxa.ft.a.a(com.tencent.luggage.wxa.ft.a.a, l, null, 0, (LaunchWxaAppResultListener)new g.i(paramLaunchWxaAppResultListener), 6, null);
    int i;
    if (((CharSequence)paramString).length() == 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      com.tencent.luggage.wxa.ft.a.a.a(l, LaunchWxaAppResult.FailQRCodeInvalid);
      return l;
    }
    if (!isDynamicPkgLoaded())
    {
      o.b("Luggage.WxaApiImpl", "launchByQRCodeRawData rejected, dynamic pkg not loaded");
      com.tencent.luggage.wxa.ft.a.a.a(l, LaunchWxaAppResult.FailNotLoadDynamicPkg);
      return l;
    }
    com.tencent.luggage.wxa.fu.d.a.a((Function0)new g.j(this, paramContext, paramString, l, paramMap));
    return l;
  }
  
  public long launchByQRScanCode(@Nullable Context paramContext, @Nullable LaunchWxaAppResultListener paramLaunchWxaAppResultListener)
  {
    return launchByQRScanCode(paramContext, null, paramLaunchWxaAppResultListener);
  }
  
  public long launchByQRScanCode(@Nullable Context paramContext, @Nullable Map<String, ? extends Object> paramMap, @Nullable LaunchWxaAppResultListener paramLaunchWxaAppResultListener)
  {
    o.d("Luggage.WxaApiImpl", "launchByQRScanCode");
    if (paramLaunchWxaAppResultListener != null) {
      paramLaunchWxaAppResultListener.onLaunchResult(null, 0, 0L, LaunchWxaAppResult.Fail);
    }
    return -1L;
  }
  
  public long launchByUsername(@Nullable Context paramContext, @NotNull String paramString1, int paramInt, @Nullable String paramString2, @Nullable LaunchByUsernameResultListener paramLaunchByUsernameResultListener)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "username");
    return launchByUsername(paramContext, paramString1, paramInt, paramString2, null, paramLaunchByUsernameResultListener);
  }
  
  public long launchByUsername(@Nullable Context paramContext, @NotNull String paramString1, int paramInt, @Nullable String paramString2, @Nullable Map<String, ? extends Object> paramMap, @Nullable LaunchByUsernameResultListener paramLaunchByUsernameResultListener)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "username");
    paramMap = new StringBuilder();
    paramMap.append("launchByUsername username:");
    paramMap.append(paramString1);
    paramMap.append(" versionType:");
    paramMap.append(paramInt);
    paramMap.append(" enterPath:");
    paramMap.append(paramString2);
    paramMap.append(" start");
    o.d("Luggage.WxaApiImpl", paramMap.toString());
    long l = g.d.a.a();
    com.tencent.luggage.wxa.ft.a.a.a(l, paramString1, paramInt, (LaunchWxaAppResultListener)new g.k(paramLaunchByUsernameResultListener));
    if (!isDynamicPkgLoaded())
    {
      o.b("Luggage.WxaApiImpl", "launchByUsername rejected, dynamic pkg not loaded");
      com.tencent.luggage.wxa.ft.a.a.a(l, LaunchWxaAppResult.FailNotLoadDynamicPkg);
      return l;
    }
    k.a.a(paramString1).a((e.c)new g.l(this, l, paramString1, paramContext, paramInt, paramString2)).a((e.a)new g.m(l));
    return l;
  }
  
  public long launchWxaApp(@Nullable Context paramContext, @NotNull String paramString1, int paramInt, @Nullable String paramString2, @Nullable LaunchWxaAppResultListener paramLaunchWxaAppResultListener)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "wxaAppID");
    return a(paramContext, paramString1, paramInt, paramString2, "", null, paramLaunchWxaAppResultListener);
  }
  
  public long launchWxaApp(@Nullable Context paramContext, @NotNull String paramString1, int paramInt, @Nullable String paramString2, @Nullable Map<String, Object> paramMap, @Nullable LaunchWxaAppResultListener paramLaunchWxaAppResultListener)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "wxaAppID");
    return a(paramContext, paramString1, paramInt, paramString2, "", paramMap, paramLaunchWxaAppResultListener);
  }
  
  @ExperimentalContracts
  public void launchWxaByShortLink(@NotNull Activity paramActivity, @NotNull String paramString, boolean paramBoolean, @Nullable LaunchWxaAppWithShortLinkResultListener paramLaunchWxaAppWithShortLinkResultListener)
  {
    Intrinsics.checkParameterIsNotNull(paramActivity, "ctx");
    Intrinsics.checkParameterIsNotNull(paramString, "shortLink");
    launchWxaByShortLink(paramActivity, paramString, paramBoolean, null, paramLaunchWxaAppWithShortLinkResultListener);
  }
  
  @ExperimentalContracts
  public void launchWxaByShortLink(@NotNull Activity paramActivity, @NotNull String paramString, boolean paramBoolean, @Nullable Map<String, ? extends Object> paramMap, @Nullable LaunchWxaAppWithShortLinkResultListener paramLaunchWxaAppWithShortLinkResultListener)
  {
    Intrinsics.checkParameterIsNotNull(paramActivity, "ctx");
    Intrinsics.checkParameterIsNotNull(paramString, "shortLink");
    new g.p(this, paramString, paramMap).a(paramActivity, paramString, paramBoolean, (Function2)new g.q(this, paramLaunchWxaAppWithShortLinkResultListener, paramString));
  }
  
  public void preloadWxaProcessEnv(int paramInt, @Nullable PreloadWxaProcessEnvResultListener paramPreloadWxaProcessEnvResultListener)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("preloadWxaProcessEnv: ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" start");
    o.d("Luggage.WxaApiImpl", localStringBuilder.toString());
    if (!isDynamicPkgLoaded())
    {
      if (paramPreloadWxaProcessEnvResultListener != null) {
        paramPreloadWxaProcessEnvResultListener.onPreloadResult(PreloadWxaProcessEnvResult.Preload_NotLoadDynamicPkg);
      }
      return;
    }
    com.tencent.luggage.wxa.fu.d.a.a((Function0)new g.s(paramInt, paramPreloadWxaProcessEnvResultListener));
  }
  
  public void removeWxaAppCloseEventListener(@Nullable WxaAppCloseEventListener paramWxaAppCloseEventListener)
  {
    j.a.b(paramWxaAppCloseEventListener);
  }
  
  public void requestUploadLogFiles(int paramInt1, int paramInt2, @Nullable UploadLogResultListener paramUploadLogResultListener)
  {
    o.d("Luggage.WxaApiImpl", "requestUploadLogFiles, start: %d, end: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramInt1 > 0) && (paramInt2 > 0))
    {
      if (paramInt2 < paramInt1)
      {
        o.b("Luggage.WxaApiImpl", "end time must be later then start time!");
        if (paramUploadLogResultListener != null) {
          paramUploadLogResultListener.onResult(UploadLogResultCode.FailParamsError);
        }
        return;
      }
      t.a.a((Function1)new g.t(paramUploadLogResultListener));
      try
      {
        paramUploadLogResultListener = com.tencent.luggage.wxa.fv.a.c.f();
      }
      catch (Exception paramUploadLogResultListener)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("requestUploadLogFiles, get tdiSession, exception=");
        localStringBuilder.append(paramUploadLogResultListener);
        o.b("Luggage.WxaApiImpl", localStringBuilder.toString());
        paramUploadLogResultListener = null;
      }
      if (paramUploadLogResultListener != null)
      {
        o.d("Luggage.WxaApiImpl", "requestUploadLogFiles impl");
        paramUploadLogResultListener.a(paramInt1, paramInt2);
      }
      return;
    }
    o.b("Luggage.WxaApiImpl", "time value is illegal");
    if (paramUploadLogResultListener != null) {
      paramUploadLogResultListener.onResult(UploadLogResultCode.FailParamsError);
    }
  }
  
  public void sendAuth(@Nullable TdiAuthListener paramTdiAuthListener)
  {
    o.d("Luggage.WxaApiImpl", "sendAuth: start");
    a((TdiAuthListener)new g.u(paramTdiAuthListener));
  }
  
  public void sendCombineAuth(@Nullable SendAuth.Req paramReq, @Nullable IWXAPIEventHandler paramIWXAPIEventHandler, @Nullable TdiAuthListener paramTdiAuthListener)
  {
    o.d("Luggage.WxaApiImpl", "sendCombineAuth start");
    a(paramReq, paramIWXAPIEventHandler, (TdiAuthListener)new g.v(paramTdiAuthListener));
  }
  
  public void setWxaProcessMaxCount(int paramInt)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("setWxaProcessMaxCount: maxCount:");
    ((StringBuilder)localObject1).append(paramInt);
    o.d("Luggage.WxaApiImpl", ((StringBuilder)localObject1).toString());
    com.tencent.luggage.wxa.standalone_open_runtime.container.a.a.b();
    boolean bool = true;
    int i;
    if (paramInt > 5)
    {
      i = 5;
    }
    else
    {
      i = paramInt;
      if (paramInt < 1) {
        i = 1;
      }
    }
    if (!r.h()) {
      return;
    }
    Object localObject2 = new ArrayList((Collection)com.tencent.luggage.wxa.da.f.a.a().a(i));
    if (((ArrayList)localObject2).size() < i) {
      ((ArrayList)localObject2).addAll((Collection)com.tencent.luggage.wxa.standalone_open_runtime.container.a.a.a().subList(((ArrayList)localObject2).size(), i));
    }
    if (((ArrayList)localObject2).size() != i) {
      bool = false;
    }
    junit.framework.a.a(bool);
    localObject1 = c.c;
    localObject2 = ((Collection)localObject2).toArray(new com.tencent.luggage.wxa.da.e[0]);
    if (localObject2 != null)
    {
      ((c.a)localObject1).c((c)new com.tencent.luggage.wxa.da.f((com.tencent.luggage.wxa.da.e[])localObject2));
      g.d.a(g.d.a, "setWxaProcessMaxCount", true, null, 0, 12, null);
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
  }
  
  public void updateTuringOAID(@Nullable String paramString)
  {
    com.tencent.luggage.wxa.hd.g.b(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fq.g
 * JD-Core Version:    0.7.0.1
 */