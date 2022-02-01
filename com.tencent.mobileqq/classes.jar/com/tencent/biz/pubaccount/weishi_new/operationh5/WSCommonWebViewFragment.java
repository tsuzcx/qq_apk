package com.tencent.biz.pubaccount.weishi_new.operationh5;

import com.tencent.biz.pubaccount.weishi_new.WSQQConnectAuthManager;
import com.tencent.biz.pubaccount.weishi_new.WSQQConnectAuthManager.WSQQConnectData;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.utils.WebViewKernelCallBack;
import com.tencent.smtt.sdk.CookieManager;
import com.tencent.smtt.sdk.CookieSyncManager;

public class WSCommonWebViewFragment
  extends WebViewFragment
{
  private void a()
  {
    CookieSyncManager.createInstance(BaseApplicationImpl.getContext());
    CookieManager localCookieManager = CookieManager.getInstance();
    localCookieManager.setAcceptCookie(true);
    localCookieManager.setCookie(".weishi.qq.com", "Domain=.weishi.qq.com");
    localCookieManager.setCookie(".weishi.qq.com", "Path=/");
    localCookieManager.setCookie(".weishi.qq.com", "iAuthType=1");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("openid=");
    localStringBuilder.append(WSQQConnectAuthManager.a().c().a);
    localCookieManager.setCookie(".weishi.qq.com", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("sSessionKey=");
    localStringBuilder.append(WSQQConnectAuthManager.a().c().b);
    localCookieManager.setCookie(".weishi.qq.com", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("person_id=");
    localStringBuilder.append(WeishiUtils.n());
    localCookieManager.setCookie(".weishi.qq.com", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("sUid=");
    localStringBuilder.append(WeishiUtils.c());
    localCookieManager.setCookie(".weishi.qq.com", localStringBuilder.toString());
    CookieSyncManager.getInstance().sync();
  }
  
  public WebViewKernelCallBack getWebViewKernelCallBack()
  {
    return new WSCommonWebViewFragment.1(this, this.webViewSurface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.operationh5.WSCommonWebViewFragment
 * JD-Core Version:    0.7.0.1
 */