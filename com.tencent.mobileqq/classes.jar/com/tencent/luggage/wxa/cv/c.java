package com.tencent.luggage.wxa.cv;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.annotation.WorkerThread;
import com.tencent.luggage.wxa.qw.aa;
import com.tencent.luggage.wxa.qw.bs;
import com.tencent.luggage.wxa.qw.bt;
import com.tencent.luggage.wxa.qw.gx;
import com.tencent.luggage.wxa.qw.hf;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.rz.f;
import com.tencent.luggage.wxa.rz.g;
import com.tencent.xweb.WebView;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/jsapi/webview/model/HTMLWebViewUrlCheckLogic;", "", "viewController", "Lcom/tencent/luggage/jsapi/webview/model/WebViewController;", "(Lcom/tencent/luggage/jsapi/webview/model/WebViewController;)V", "cookie", "Lcom/tencent/mm/protocal/protobuf/SKBuiltinBuffer_t;", "isFirstRequest", "Ljava/util/concurrent/atomic/AtomicBoolean;", "mRequestedUrls", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/mm/protocal/protobuf/GetA8KeyReq;", "", "permissionStorage", "", "webviewCommitUrl", "wxaGetA8KeyCgiFactory", "Lcom/tencent/luggage/jsapi/webview/model/WxaGetA8KeyCgiFactory;", "checkIframeRequest", "", "view", "Lcom/tencent/xweb/WebView;", "url", "callback", "Lkotlin/Function2;", "Lcom/tencent/luggage/jsapi/webview/model/ReplaceWebViewUrlCallback;", "doAsyncCheckUrl", "passedReason", "getReason", "reason", "handleA8KeyResult", "resp", "Lcom/tencent/mm/protocal/protobuf/GetA8KeyResp;", "req", "Lcom/tencent/luggage/jsapi/webview/model/WxaDefGetA8KeyReq;", "forceRedirect", "", "hasPermission", "onInitLoad", "onPageCommitVisible", "onPageDestroy", "onPageFinished", "onPageStarted", "shouldOverrideUrlLoading", "isValidCommitUrl", "Companion", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
public final class c
{
  public static final c.a a = new c.a(null);
  private static final Pattern i = Pattern.compile(".*#.*wechat_redirect");
  private String b;
  private final AtomicBoolean c;
  private final ConcurrentHashMap<bs, Integer> d;
  private final ConcurrentHashMap<String, Integer> e;
  private volatile gx f;
  private final k g;
  private final i h;
  
  public c(@NotNull i parami)
  {
    this.h = parami;
    this.c = new AtomicBoolean(true);
    this.d = new ConcurrentHashMap();
    this.e = new ConcurrentHashMap();
    this.g = new k();
  }
  
  private final int a(String paramString, int paramInt)
  {
    if (paramInt != -1) {
      return paramInt;
    }
    paramString = i.matcher((CharSequence)paramString);
    Intrinsics.checkExpressionValueIsNotNull(paramString, "weChatRedirectPattern.matcher(url)");
    if (paramString.find()) {
      return 2;
    }
    return 1;
  }
  
  @WorkerThread
  private final void a(bt parambt, j paramj, Function2<? super String, ? super String, Unit> paramFunction2, boolean paramBoolean)
  {
    if (parambt == null)
    {
      this.d.remove(paramj);
      f.a.a((Runnable)new c.c(paramFunction2));
      o.c("Luggage.HTMLWebViewUrlCheckLogic", "doAsyncCheckUrlByA8Key: fail:resp is null");
      return;
    }
    this.f = parambt.v;
    Object localObject1 = af.b(parambt.a);
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "Util.nullAsNil(resp.FullURL)");
    localObject1 = (CharSequence)localObject1;
    int j = ((CharSequence)localObject1).length() - 1;
    int k = 0;
    int m = 0;
    while (k <= j)
    {
      int n;
      if (m == 0) {
        n = k;
      } else {
        n = j;
      }
      if (((CharSequence)localObject1).charAt(n) <= ' ') {
        n = 1;
      } else {
        n = 0;
      }
      if (m == 0)
      {
        if (n == 0) {
          m = 1;
        } else {
          k += 1;
        }
      }
      else
      {
        if (n == 0) {
          break;
        }
        j -= 1;
      }
    }
    localObject1 = (CharSequence)((CharSequence)localObject1).subSequence(k, j + 1).toString();
    localObject1 = new Regex(" ").replace((CharSequence)localObject1, "%20");
    ((Map)this.e).put(localObject1, Integer.valueOf(0));
    j = parambt.c;
    k = parambt.z.a;
    Object localObject2 = parambt.z.b;
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "resp.BaseResponse.ErrMsg");
    localObject2 = ((hf)localObject2).a();
    String str = parambt.b;
    parambt = parambt.v;
    if (parambt != null)
    {
      parambt = parambt.a();
      if (parambt != null) {}
    }
    else
    {
      parambt = new byte[0];
    }
    parambt = af.b(parambt);
    if (parambt == null) {
      parambt = "null";
    }
    o.d("Luggage.HTMLWebViewUrlCheckLogic", "doAsyncCheckUrlByA8Key: resp actionCode = [%d], (ret, msg) = [%d][%s], A8Key = [%s], cookie = [%s], fullUrl = [%s], force = [%b]", new Object[] { Integer.valueOf(j), Integer.valueOf(k), localObject2, str, parambt, localObject1, Boolean.valueOf(paramBoolean) });
    if (!paramBoolean)
    {
      parambt = paramj.f;
      Intrinsics.checkExpressionValueIsNotNull(parambt, "req.ReqUrl");
      if (!(Intrinsics.areEqual(parambt.a(), localObject1) ^ true)) {}
    }
    else
    {
      f.a.a((Runnable)new c.d(paramFunction2, paramj, (String)localObject1));
    }
  }
  
  private final void a(String paramString, Function2<? super String, ? super String, Unit> paramFunction2, int paramInt)
  {
    Object localObject = (CharSequence)paramString;
    boolean bool = true;
    if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
      j = 0;
    } else {
      j = 1;
    }
    if (j != 0) {
      return;
    }
    if (this.e.contains(paramString))
    {
      o.e("Luggage.HTMLWebViewUrlCheckLogic", "doAsyncCheckUrl: skip, had permission [%s]", new Object[] { paramString });
      return;
    }
    localObject = this.h.b();
    if (localObject == null) {
      localObject = "";
    }
    j localj = new j();
    localj.a();
    localj.i = this.h.c();
    localj.f = new hf().a(paramString);
    localj.m = a(paramString, paramInt);
    localj.o = 0;
    localj.t = this.h.a();
    localj.c = new hf().a((String)localObject);
    localj.a = 2;
    localj.w = this.f;
    if (paramInt == 5)
    {
      paramString = this.b;
      if (paramString == null) {
        paramString = this.h.d();
      }
      localj.x = paramString;
    }
    int j = localj.m;
    localObject = localj.q;
    int k = localj.i;
    hf localhf = localj.c;
    int m = localj.a;
    paramString = localj.w;
    if (paramString != null)
    {
      paramString = paramString.a();
      if (paramString != null) {}
    }
    else
    {
      paramString = new byte[0];
    }
    paramString = af.b(paramString);
    if (paramString == null) {
      paramString = "null";
    }
    o.d("Luggage.HTMLWebViewUrlCheckLogic", "doAsyncCheckUrlByA8Key: req: reason = [%d], netType = [%s], scene = [%d], appId = [%s], opCode = [%d], cookie = [%s], reqId = [%s], reqUrl = [%s]", new Object[] { Integer.valueOf(j), localObject, Integer.valueOf(k), localhf, Integer.valueOf(m), paramString, Integer.valueOf(localj.t), localj.f });
    if (paramInt == 5) {
      bool = false;
    }
    if (this.d.put(localj, Integer.valueOf(0)) == null)
    {
      f.a.d((Runnable)new c.b(this, localj, paramFunction2, bool));
      return;
    }
    o.d("Luggage.HTMLWebViewUrlCheckLogic", "doAsyncCheckUrl this url is requested");
  }
  
  @JvmStatic
  public static final boolean b(@Nullable String paramString)
  {
    return a.a(paramString);
  }
  
  private final boolean c(@Nullable String paramString)
  {
    CharSequence localCharSequence = (CharSequence)paramString;
    int j;
    if ((localCharSequence != null) && (localCharSequence.length() != 0)) {
      j = 0;
    } else {
      j = 1;
    }
    if (j != 0) {
      return false;
    }
    if (Intrinsics.areEqual("about:blank", paramString)) {
      return false;
    }
    return !StringsKt.startsWith$default(paramString, "data:text/html;charset=utf-8", false, 2, null);
  }
  
  public final void a()
  {
    this.d.clear();
    this.e.clear();
    this.c.set(true);
    this.f = ((gx)null);
  }
  
  public final void a(@NotNull WebView paramWebView, @Nullable String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramWebView, "view");
    if (c(paramString)) {
      this.b = paramString;
    }
  }
  
  public final void a(@NotNull WebView paramWebView, @Nullable String paramString, @Nullable Function2<? super String, ? super String, Unit> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramWebView, "view");
    if (!a.a(paramString)) {
      return;
    }
    if (c(paramString)) {
      this.b = paramString;
    }
  }
  
  public final void a(@Nullable String paramString, @NotNull Function2<? super String, ? super String, Unit> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction2, "callback");
    if (!a.a(paramString)) {
      return;
    }
    a(this, paramString, paramFunction2, 0, 4, null);
  }
  
  public final boolean a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "url");
    return this.e.containsKey(paramString);
  }
  
  public final void b(@NotNull WebView paramWebView, @Nullable String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramWebView, "view");
    if (c(paramString)) {
      this.b = paramString;
    }
  }
  
  public final boolean b(@NotNull WebView paramWebView, @Nullable String paramString, @Nullable Function2<? super String, ? super String, Unit> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramWebView, "view");
    if (paramString == null) {
      return true;
    }
    if (StringsKt.startsWith$default(paramString, "file:///android_asset", false, 2, null))
    {
      o.c("Luggage.HTMLWebViewUrlCheckLogic", "shouldOverrideUrlLoading found %s", new Object[] { paramString });
      return true;
    }
    if (StringsKt.startsWith$default(paramString, "tel:", false, 2, null))
    {
      paramFunction2 = new Intent("android.intent.action.DIAL");
      paramFunction2.setData(Uri.parse(paramString));
      paramWebView.getContext().startActivity(paramFunction2);
      return true;
    }
    if ((!StringsKt.startsWith$default(paramString, "sms:", false, 2, null)) && (!StringsKt.startsWith$default(paramString, "smsto:", false, 2, null)))
    {
      if (a(paramString)) {
        return false;
      }
      a(this, paramString, paramFunction2, 0, 4, null);
      return true;
    }
    paramFunction2 = new Intent("android.intent.action.SENDTO");
    paramFunction2.setData(Uri.parse(paramString));
    paramWebView.getContext().startActivity(paramFunction2);
    return true;
  }
  
  public final void c(@NotNull WebView paramWebView, @Nullable String paramString, @Nullable Function2<? super String, ? super String, Unit> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramWebView, "view");
    a(paramString, paramFunction2, 5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.cv.c
 * JD-Core Version:    0.7.0.1
 */