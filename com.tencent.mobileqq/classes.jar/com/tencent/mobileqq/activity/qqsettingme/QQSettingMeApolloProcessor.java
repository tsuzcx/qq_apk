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
  private static final List<String> jdField_a_of_type_JavaUtilList = new ArrayList();
  private static final List<String> jdField_b_of_type_JavaUtilList;
  private ISettingMeApolloViewController jdField_a_of_type_ComTencentMobileqqApolloDrawerISettingMeApolloViewController;
  private final PreloadProcHitSession jdField_a_of_type_ComTencentMobileqqHitratePreloadProcHitSession = new PreloadProcHitSession("QQSetting_me", "com.tencent.mobileqq:tool");
  private boolean jdField_b_of_type_Boolean;
  
  static
  {
    jdField_a_of_type_JavaUtilList.add("h5.vip.qq.com");
    jdField_a_of_type_JavaUtilList.add("mc.vip.qq.com");
    jdField_a_of_type_JavaUtilList.add("m.vip.qq.com");
    jdField_a_of_type_JavaUtilList.add("proxy.vip.qq.com");
    jdField_a_of_type_JavaUtilList.add("red.vip.qq.com");
    jdField_a_of_type_JavaUtilList.add("r.vip.qq.com");
    jdField_a_of_type_JavaUtilList.add("cgi.vip.qq.com");
    jdField_a_of_type_JavaUtilList.add("iyouxi.vip.qq.com");
    jdField_b_of_type_JavaUtilList = new ArrayList();
    jdField_b_of_type_JavaUtilList.add("zb.vip.qq.com");
    jdField_b_of_type_JavaUtilList.add("gxh.vip.qq.com");
    jdField_b_of_type_JavaUtilList.add("g.vip.qq.com");
    jdField_b_of_type_JavaUtilList.add("imgcache.gtimg.cn");
    jdField_b_of_type_JavaUtilList.add("i.gtimg.cn");
    jdField_b_of_type_JavaUtilList.add("imgcache.qq.com");
    jdField_b_of_type_JavaUtilList.add("logic.content.qq.com");
  }
  
  public String a()
  {
    return "d_apollo";
  }
  
  public void a(QQSettingMe paramQQSettingMe)
  {
    this.jdField_a_of_type_ComTencentMobileqqApolloDrawerISettingMeApolloViewController = ((ISettingMeApolloViewController)QRoute.api(ISettingMeApolloViewController.class));
    this.jdField_a_of_type_ComTencentMobileqqApolloDrawerISettingMeApolloViewController.init(paramQQSettingMe, paramQQSettingMe.a);
  }
  
  public void a(AppRuntime paramAppRuntime)
  {
    if (this.jdField_b_of_type_Boolean)
    {
      if (paramAppRuntime != null)
      {
        localISettingMeApolloViewController = this.jdField_a_of_type_ComTencentMobileqqApolloDrawerISettingMeApolloViewController;
        if (localISettingMeApolloViewController != null) {
          ((QQAppInterface)paramAppRuntime).removeObserver(localISettingMeApolloViewController.getObserver());
        }
      }
      this.jdField_a_of_type_MqqAppAppRuntime = paramAppRuntime;
      ISettingMeApolloViewController localISettingMeApolloViewController = this.jdField_a_of_type_ComTencentMobileqqApolloDrawerISettingMeApolloViewController;
      if (localISettingMeApolloViewController != null) {
        ((QQAppInterface)paramAppRuntime).addObserver(localISettingMeApolloViewController.getObserver());
      }
      paramAppRuntime = this.jdField_a_of_type_ComTencentMobileqqApolloDrawerISettingMeApolloViewController;
      if (paramAppRuntime != null) {
        paramAppRuntime.destroyApollo();
      }
    }
    else
    {
      this.jdField_a_of_type_MqqAppAppRuntime = paramAppRuntime;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    new QQSettingMeApolloProcessor.WebPreloadTask(this).run();
  }
  
  public void b()
  {
    super.b();
    this.jdField_b_of_type_Boolean = true;
    if (this.jdField_a_of_type_ComTencentMobileqqApolloDrawerISettingMeApolloViewController != null)
    {
      if (this.jdField_a_of_type_MqqAppAppRuntime != null) {
        ((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime).addObserver(this.jdField_a_of_type_ComTencentMobileqqApolloDrawerISettingMeApolloViewController.getObserver());
      }
      this.jdField_a_of_type_ComTencentMobileqqApolloDrawerISettingMeApolloViewController.initApolloDrawerStatus();
      this.jdField_a_of_type_ComTencentMobileqqApolloDrawerISettingMeApolloViewController.updateCmshowStatus();
      this.jdField_a_of_type_ComTencentMobileqqApolloDrawerISettingMeApolloViewController.refreshApolloView();
    }
    String str = this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin();
    if (TextUtils.isEmpty(str)) {
      return;
    }
    IWebProcessPreload localIWebProcessPreload = (IWebProcessPreload)QRoute.api(IWebProcessPreload.class);
    if (localIWebProcessPreload != null)
    {
      long l = localIWebProcessPreload.getBusinessClickTimeMills(str, "individuation");
      if ((l == -1L) || (System.currentTimeMillis() - l < 259200000L)) {
        localIWebProcessPreload.preParseDns(jdField_b_of_type_JavaUtilList, "key_individuation_dns_parse");
      }
      l = localIWebProcessPreload.getBusinessClickTimeMills(str, "vip");
      if (System.currentTimeMillis() - l < 604800000L) {
        localIWebProcessPreload.preParseDns(jdField_a_of_type_JavaUtilList, "key_vip_dns_parse");
      }
    }
  }
  
  public void b(String paramString)
  {
    ISettingMeApolloViewController localISettingMeApolloViewController = this.jdField_a_of_type_ComTencentMobileqqApolloDrawerISettingMeApolloViewController;
    if (localISettingMeApolloViewController != null) {
      localISettingMeApolloViewController.showExploreBox(paramString);
    }
  }
  
  public void c()
  {
    super.c();
    ISettingMeApolloViewController localISettingMeApolloViewController = this.jdField_a_of_type_ComTencentMobileqqApolloDrawerISettingMeApolloViewController;
    if (localISettingMeApolloViewController != null) {
      localISettingMeApolloViewController.onPause();
    }
    this.jdField_a_of_type_ComTencentMobileqqHitratePreloadProcHitSession.d();
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloDrawerISettingMeApolloViewController != null)
    {
      if (this.jdField_a_of_type_MqqAppAppRuntime != null) {
        ((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime).removeObserver(this.jdField_a_of_type_ComTencentMobileqqApolloDrawerISettingMeApolloViewController.getObserver());
      }
      this.jdField_a_of_type_ComTencentMobileqqApolloDrawerISettingMeApolloViewController.onDestroy();
    }
  }
  
  public void f()
  {
    ISettingMeApolloViewController localISettingMeApolloViewController = this.jdField_a_of_type_ComTencentMobileqqApolloDrawerISettingMeApolloViewController;
    if (localISettingMeApolloViewController != null) {
      localISettingMeApolloViewController.recoverApollo();
    }
  }
  
  public void h()
  {
    ISettingMeApolloViewController localISettingMeApolloViewController = this.jdField_a_of_type_ComTencentMobileqqApolloDrawerISettingMeApolloViewController;
    if (localISettingMeApolloViewController != null) {
      localISettingMeApolloViewController.onDrawerOpened();
    }
  }
  
  public void i()
  {
    ISettingMeApolloViewController localISettingMeApolloViewController = this.jdField_a_of_type_ComTencentMobileqqApolloDrawerISettingMeApolloViewController;
    if (localISettingMeApolloViewController != null) {
      localISettingMeApolloViewController.onDrawerClosed();
    }
  }
  
  public void j()
  {
    this.jdField_a_of_type_ComTencentMobileqqHitratePreloadProcHitSession.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qqsettingme.QQSettingMeApolloProcessor
 * JD-Core Version:    0.7.0.1
 */