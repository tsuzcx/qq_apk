package com.tencent.mobileqq.activity.qqsettingme;

import android.text.TextUtils;
import com.tencent.mobileqq.activity.QQSettingMe;
import com.tencent.mobileqq.apollo.drawer.ISettingMeApolloViewController;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hitrate.PreloadProcHitSession;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.webview.api.IWebProcessPreload;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;

public class QQSettingMeApolloProcessor
  extends QQSettingMeBaseProcessor
{
  private static final List<String> a = new ArrayList();
  private static final List<String> b;
  private final PreloadProcHitSession i = new PreloadProcHitSession("QQSetting_me", "com.tencent.mobileqq:tool");
  private ISettingMeApolloViewController j;
  private boolean k;
  
  static
  {
    a.add("h5.vip.qq.com");
    a.add("mc.vip.qq.com");
    a.add("m.vip.qq.com");
    a.add("proxy.vip.qq.com");
    a.add("red.vip.qq.com");
    a.add("r.vip.qq.com");
    a.add("cgi.vip.qq.com");
    a.add("iyouxi.vip.qq.com");
    b = new ArrayList();
    b.add("zb.vip.qq.com");
    b.add("gxh.vip.qq.com");
    b.add("g.vip.qq.com");
    b.add("imgcache.gtimg.cn");
    b.add("i.gtimg.cn");
    b.add("imgcache.qq.com");
    b.add("logic.content.qq.com");
  }
  
  public void a()
  {
    this.i.b();
  }
  
  public void a(QQSettingMe paramQQSettingMe)
  {
    this.j = ((ISettingMeApolloViewController)QRoute.api(ISettingMeApolloViewController.class));
    this.j.init(paramQQSettingMe, paramQQSettingMe.d);
  }
  
  public void a(AppRuntime paramAppRuntime)
  {
    if (this.k)
    {
      if (paramAppRuntime != null)
      {
        localISettingMeApolloViewController = this.j;
        if (localISettingMeApolloViewController != null) {
          ((QQAppInterface)paramAppRuntime).removeObserver(localISettingMeApolloViewController.getObserver());
        }
      }
      this.c = paramAppRuntime;
      ISettingMeApolloViewController localISettingMeApolloViewController = this.j;
      if (localISettingMeApolloViewController != null) {
        ((QQAppInterface)paramAppRuntime).addObserver(localISettingMeApolloViewController.getObserver());
      }
      paramAppRuntime = this.j;
      if (paramAppRuntime != null) {
        paramAppRuntime.destroyApollo();
      }
    }
    else
    {
      this.c = paramAppRuntime;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    new QQSettingMeApolloProcessor.WebPreloadTask(this).run();
  }
  
  public String b()
  {
    return "d_apollo";
  }
  
  public void b(String paramString)
  {
    ISettingMeApolloViewController localISettingMeApolloViewController = this.j;
    if (localISettingMeApolloViewController != null) {
      localISettingMeApolloViewController.showExploreBox(paramString);
    }
  }
  
  public void d()
  {
    super.d();
    this.k = true;
    if (this.j != null)
    {
      if (this.c != null) {
        ((QQAppInterface)this.c).addObserver(this.j.getObserver());
      }
      this.j.initApolloDrawerStatus();
      this.j.updateCmshowStatus();
      this.j.refreshApolloView();
    }
    String str = this.c.getCurrentAccountUin();
    if (TextUtils.isEmpty(str)) {
      return;
    }
    IWebProcessPreload localIWebProcessPreload = (IWebProcessPreload)QRoute.api(IWebProcessPreload.class);
    if (localIWebProcessPreload != null)
    {
      long l = localIWebProcessPreload.getBusinessClickTimeMills(str, "individuation");
      if ((l == -1L) || (System.currentTimeMillis() - l < 259200000L)) {
        localIWebProcessPreload.preParseDns(b, "key_individuation_dns_parse");
      }
      l = localIWebProcessPreload.getBusinessClickTimeMills(str, "vip");
      if (System.currentTimeMillis() - l < 604800000L) {
        localIWebProcessPreload.preParseDns(a, "key_vip_dns_parse");
      }
    }
  }
  
  public void e()
  {
    super.e();
    ISettingMeApolloViewController localISettingMeApolloViewController = this.j;
    if (localISettingMeApolloViewController != null) {
      localISettingMeApolloViewController.onPause();
    }
    this.i.e();
  }
  
  public void f()
  {
    if (this.j != null)
    {
      if (this.c != null) {
        ((QQAppInterface)this.c).removeObserver(this.j.getObserver());
      }
      this.j.onDestroy();
    }
  }
  
  public void h()
  {
    ISettingMeApolloViewController localISettingMeApolloViewController = this.j;
    if (localISettingMeApolloViewController != null) {
      localISettingMeApolloViewController.recoverApollo();
    }
  }
  
  public void j()
  {
    ISettingMeApolloViewController localISettingMeApolloViewController = this.j;
    if (localISettingMeApolloViewController != null) {
      localISettingMeApolloViewController.onDrawerOpened();
    }
  }
  
  public void k()
  {
    ISettingMeApolloViewController localISettingMeApolloViewController = this.j;
    if (localISettingMeApolloViewController != null) {
      localISettingMeApolloViewController.onDrawerClosed();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qqsettingme.QQSettingMeApolloProcessor
 * JD-Core Version:    0.7.0.1
 */