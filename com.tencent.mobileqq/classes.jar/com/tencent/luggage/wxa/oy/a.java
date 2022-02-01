package com.tencent.luggage.wxa.oy;

import com.tencent.luggage.wxa.nk.b;
import com.tencent.luggage.wxa.nk.f;
import com.tencent.luggage.wxa.nk.g;
import com.tencent.luggage.wxa.nk.h;
import com.tencent.luggage.wxa.nk.k;
import java.util.ArrayList;
import java.util.List;

public final class a
  implements com.tencent.luggage.wxa.nk.a
{
  public static b A;
  public static b B;
  public static b C;
  public static b D;
  public static b E;
  public static b F;
  public static b G;
  public static b H;
  public static b I;
  public static b J;
  public static b K;
  public static b L;
  public static b M;
  public static b N;
  public static b O;
  public static b P;
  public static b Q;
  public static b R;
  public static b S;
  public static b T;
  public static b a;
  public static b b;
  public static b c;
  public static b d;
  public static b e;
  public static b f;
  public static b g;
  public static b h;
  public static b i;
  public static b j;
  public static b k;
  public static b l;
  public static b m;
  public static b n;
  public static b o;
  public static b p;
  public static b q;
  public static b r;
  public static b s;
  public static final List<f> sStepNodes = new ArrayList();
  public static b t;
  public static b u;
  public static b v;
  public static b w;
  public static b x;
  public static b y;
  public static b z;
  
  static
  {
    sStepNodes.add(new k("WeAppLaunch"));
    a = new g("WeAppLaunch", "Launch", true, false, "", 2, 0, 1);
    sStepNodes.add((f)a);
    b = new g("WeAppLaunch", "GetContact", true, false, "", 3, 1, 2);
    sStepNodes.add((f)b);
    c = new g("WeAppLaunch", "GetContact_DB", true, true, "读取contact信息", 1, 2, -2147483648);
    sStepNodes.add((f)c);
    d = new g("WeAppLaunch", "GetContact_CGI", false, true, "拉contact cgi", 1, 2, -2147483648);
    sStepNodes.add((f)d);
    e = new g("WeAppLaunch", "CheckBan", true, false, "封禁逻辑", 1, 1, -2147483648);
    sStepNodes.add((f)e);
    f = new g("WeAppLaunch", "ContainerUILaunch", true, true, "拉起容器UI界面", 1, 1, -2147483648);
    sStepNodes.add((f)f);
    g = new g("WeAppLaunch", "PrepareRuntime", true, false, "", 3, 1, 3);
    sStepNodes.add((f)g);
    h = new g("WeAppLaunch", "PrepareMainProcess", true, true, "准备主进程通讯", 1, 3, -2147483648);
    sStepNodes.add((f)h);
    i = new g("WeAppLaunch", "InstallLibraries", true, true, "动态安装小程序环境所需二进制库", 1, 3, -2147483648);
    sStepNodes.add((f)i);
    j = new g("WeAppLaunch", "PrepareWebView", true, true, "准备WebView (View)", 1, 3, -2147483648);
    sStepNodes.add((f)j);
    k = new g("WeAppLaunch", "PrepareResourceGroup", true, false, "Launch CGI及准备小程序包", 3, 3, 4);
    sStepNodes.add((f)k);
    l = new g("WeAppLaunch", "PrepareResourceProcess", true, false, "资源准备逻辑过程", 1, 4, -2147483648);
    sStepNodes.add((f)l);
    m = new g("WeAppLaunch", "PrepareResourceWaitForResult", true, false, "runtime监听过程结果", 1, 4, -2147483648);
    sStepNodes.add((f)m);
    n = new g("WeAppLaunch", "PrepareResourceTimeout", true, true, "资源准备10s超时事件", 1, 4, -2147483648);
    sStepNodes.add((f)n);
    o = new g("WeAppLaunch", "PrepareResourceSubProcessLaunchWxaApp_DB", true, true, "使用本地缓存的launch数据打开", 1, 4, -2147483648);
    sStepNodes.add((f)o);
    p = new g("WeAppLaunch", "PrepareResourceSubProcessLaunchWxaApp_CGI", true, true, "同步请求launch数据打开", 1, 4, -2147483648);
    sStepNodes.add((f)p);
    q = new g("WeAppLaunch", "PrepareResourceSubProcessCodePkg_DB", true, true, "使用本地缓存好的代码包打开", 1, 4, -2147483648);
    sStepNodes.add((f)q);
    r = new g("WeAppLaunch", "PrepareResourceSubProcessCodePkg_Download", true, true, "同步下载代码包打开", 1, 4, -2147483648);
    sStepNodes.add((f)r);
    s = new g("WeAppLaunch", "SetupConfigsPostResourcePrepared", true, false, "资源准备完的配置解析", 1, 3, -2147483648);
    sStepNodes.add((f)s);
    t = new g("WeAppLaunch", "WaitForCommLibConfirm", true, true, "确定基础库版本", 1, 3, -2147483648);
    sStepNodes.add((f)t);
    u = new g("WeAppLaunch", "WaitForWebViewPreloadDone", true, true, "等待启动前预加载webview完成 (View)", 1, 3, -2147483648);
    sStepNodes.add((f)u);
    v = new g("WeAppLaunch", "WaitForWebViewAheadPreloadDone", true, true, "等待运行时预加载webview完成 (View)", 1, 3, -2147483648);
    sStepNodes.add((f)v);
    w = new g("WeAppLaunch", "WaitForAppServicePreloadDone", true, true, "等待启动前预加载appservice完成 (Service)", 1, 3, -2147483648);
    sStepNodes.add((f)w);
    x = new g("WeAppLaunch", "WaitForAppServiceAheadPreloadDone", true, true, "等待运行时预加载appservice完成 (Service)", 1, 3, -2147483648);
    sStepNodes.add((f)x);
    y = new g("WeAppLaunch", "InitRuntimeGroup", true, false, "", 3, 1, 4);
    sStepNodes.add((f)y);
    z = new g("WeAppLaunch", "ServiceInit", true, false, "", 2, 4, 5);
    sStepNodes.add((f)z);
    A = new g("WeAppLaunch", "InjectJSWAMainContext", true, true, "注入WAMainContext.js (Service)", 1, 5, -2147483648);
    sStepNodes.add((f)A);
    B = new g("WeAppLaunch", "InjectJSWASubContext", true, true, "注入WASubContext.js (Service)", 1, 5, -2147483648);
    sStepNodes.add((f)B);
    C = new g("WeAppLaunch", "InjectJSAppService", true, true, "注入appservice.js (Service)", 1, 5, -2147483648);
    sStepNodes.add((f)C);
    D = new g("WeAppLaunch", "InjectWAGameContext", true, true, "注入WAGame.js (Service)", 1, 5, -2147483648);
    sStepNodes.add((f)D);
    E = new g("WeAppLaunch", "InjectWAGameSubContext", true, true, "注入WAGameSubContext.js (Service)", 1, 5, -2147483648);
    sStepNodes.add((f)E);
    F = new g("WeAppLaunch", "InjectGameJs", true, true, "注入game.js (Service)", 1, 5, -2147483648);
    sStepNodes.add((f)F);
    G = new g("WeAppLaunch", "InjectWxConfig", true, false, "注入wxConfig (Service)", 1, 5, -2147483648);
    sStepNodes.add((f)G);
    H = new g("WeAppLaunch", "PageInit", true, false, "", 2, 4, 6);
    sStepNodes.add((f)H);
    I = new g("WeAppLaunch", "PageInitUIGroup", true, false, "", 3, 6, 7);
    sStepNodes.add((f)I);
    J = new g("WeAppLaunch", "CreatePageUI", true, false, "首页界面创建", 1, 7, -2147483648);
    sStepNodes.add((f)J);
    K = new g("WeAppLaunch", "CreateWebViewInstance", true, true, "", 1, 7, -2147483648);
    sStepNodes.add((f)K);
    L = new g("WeAppLaunch", "CreateMagicBrushView", true, true, "", 1, 7, -2147483648);
    sStepNodes.add((f)L);
    M = new g("WeAppLaunch", "InjectWAPageFrameHtml", true, true, "注入WAPageframe.html (View)", 1, 6, -2147483648);
    sStepNodes.add((f)M);
    N = new g("WeAppLaunch", "InjectJSWAWebview", true, true, "注入WAWebview.js (View)", 1, 6, -2147483648);
    sStepNodes.add((f)N);
    O = new g("WeAppLaunch", "InjectJSPageScript", true, true, "页面js注入 (View)", 1, 6, -2147483648);
    sStepNodes.add((f)O);
    P = new g("WeAppLaunch", "GenerateFuncReadyRespond", false, true, "webview发出的GenerateFuncReady被appservice响应 (View)", 1, 6, -2147483648);
    sStepNodes.add((f)P);
    Q = new g("WeAppLaunch", "VdSync", true, true, "第一次VdSync (View)", 1, 6, -2147483648);
    sStepNodes.add((f)Q);
    R = new g("WeAppLaunch", "SurfaceAvailable", true, true, "SurfaceAvailable (View)", 1, 6, -2147483648);
    sStepNodes.add((f)R);
    S = new g("WeAppLaunch", "PageReady", true, false, "page ready (View)", 1, 6, -2147483648);
    sStepNodes.add((f)S);
    T = new g("WeAppLaunch", "ColdLaunchFailed", true, true, "", 1, 1, -2147483648);
    sStepNodes.add((f)T);
    sStepNodes.add(new h("WeAppLaunch"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.oy.a
 * JD-Core Version:    0.7.0.1
 */