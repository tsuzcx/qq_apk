package com.tencent.biz;

import com.tencent.biz.authorize.AIOAuthorizeConfigInjector;
import com.tencent.biz.authorize.ArkAuthorizeConfigInjector;
import com.tencent.biz.authorize.AuthorizeConfigCommonBusinessDownloader;
import com.tencent.biz.authorize.PublicAccountAuthorizeConfigInjector;
import com.tencent.biz.authorize.WhiteScreenAuthorizeConfigInjector;
import com.tencent.mobileqq.qroute.annotation.ConfigInject;
import com.tencent.mobileqq.webview.authorize.IAuthorizeConfigDownloadInjector;
import com.tencent.mobileqq.webview.authorize.IAuthorizeConfigInjector;
import java.util.ArrayList;

public class AuthorizeConfigInjectUtil
{
  @ConfigInject(configPath="/Business/webview/src/main/resources/Inject_authorize_config_business.yml", version=1)
  public static ArrayList<Class<? extends IAuthorizeConfigInjector>> a = new ArrayList();
  @ConfigInject(configPath="/Business/webview/src/main/resources/Inject_authorize_config_business.yml", version=1)
  public static ArrayList<Class<? extends IAuthorizeConfigDownloadInjector>> b;
  
  static
  {
    a.add(AIOAuthorizeConfigInjector.class);
    a.add(ArkAuthorizeConfigInjector.class);
    a.add(WhiteScreenAuthorizeConfigInjector.class);
    a.add(PublicAccountAuthorizeConfigInjector.class);
    b = new ArrayList();
    b.add(AuthorizeConfigCommonBusinessDownloader.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.AuthorizeConfigInjectUtil
 * JD-Core Version:    0.7.0.1
 */