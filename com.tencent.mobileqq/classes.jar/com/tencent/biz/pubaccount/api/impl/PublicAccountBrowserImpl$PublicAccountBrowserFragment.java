package com.tencent.biz.pubaccount.api.impl;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.AuthorizeConfig;
import com.tencent.biz.common.util.Util;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.biz.webviewbase.WebAIOController;
import com.tencent.biz.webviewbase.WebAIOController.Builder;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.qwallet.PayInterceptHelper;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.StartAppCheckHandler;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.webview.swift.SwiftIphoneTitleBarUI;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserComponentsProvider;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserShareMenuHandler;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler.SwiftBrowserUIStyle;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import java.lang.ref.SoftReference;

public class PublicAccountBrowserImpl$PublicAccountBrowserFragment
  extends WebViewFragment
{
  private int jdField_a_of_type_Int = -1;
  protected Bundle a;
  WebAIOController jdField_a_of_type_ComTencentBizWebviewbaseWebAIOController;
  protected String a;
  private SoftReference<PublicAccountBrowserImpl.PublicAccountBrowserFragment.PublicAccountBrowserShareMenuHandler> jdField_a_of_type_JavaLangRefSoftReference;
  protected boolean a;
  protected boolean b = true;
  protected boolean c;
  protected boolean d = false;
  protected boolean e = false;
  
  public PublicAccountBrowserImpl$PublicAccountBrowserFragment()
  {
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_a_of_type_Boolean = false;
  }
  
  public static String a(String paramString)
  {
    Object localObject2 = null;
    Object localObject1;
    if (paramString.startsWith("qqnews://")) {
      localObject1 = "即将离开\"QQ\"\r\n打开" + "\"腾讯新闻\"";
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        return localObject1;
                        if ((paramString.startsWith("tenvideo://")) || (paramString.startsWith("tenvideo2://")) || (paramString.startsWith("tenvideo3://")) || (paramString.startsWith("tencent1004498506://"))) {
                          return "即将离开\"QQ\"\r\n打开" + "\"腾讯视频\"";
                        }
                        if (paramString.startsWith("mttbrowser://")) {
                          return "即将离开\"QQ\"\r\n打开" + "\"QQ浏览器\"";
                        }
                        if (paramString.startsWith("qnreading://")) {
                          return "即将离开\"QQ\"\r\n打开" + "\"天天快报\"";
                        }
                        if ((paramString.startsWith("weishiandroidscheme://")) || (paramString.startsWith("weishi://"))) {
                          return "即将离开\"QQ\"\r\n打开" + "\"微视\"";
                        }
                        if (paramString.startsWith("tnow://")) {
                          return "即将离开\"QQ\"\r\n打开" + "\"NOW直播\"";
                        }
                        localObject1 = localObject2;
                      } while (paramString.startsWith("sms://"));
                      localObject1 = localObject2;
                    } while (paramString.startsWith("tel://"));
                    localObject1 = localObject2;
                  } while (paramString.startsWith("tel://"));
                  localObject1 = localObject2;
                } while (paramString.startsWith("mailto://"));
                localObject1 = localObject2;
              } while (paramString.startsWith("file://"));
              localObject1 = localObject2;
            } while (paramString.startsWith("ftp://"));
            localObject1 = localObject2;
          } while (paramString.startsWith("mqqapi://"));
          localObject1 = localObject2;
        } while (paramString.startsWith("http://"));
        localObject1 = localObject2;
      } while (paramString.startsWith("https://"));
      localObject1 = localObject2;
    } while (paramString.indexOf("://") == -1);
    return "即将离开\"QQ\"\r\n打开" + HardCodeUtil.a(2131708768);
  }
  
  private void a()
  {
    boolean bool2 = false;
    this.jdField_a_of_type_AndroidOsBundle = this.intent.getExtras();
    this.uin = this.jdField_a_of_type_AndroidOsBundle.getString("uin");
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidOsBundle.getString("uin_name");
    this.uinType = this.jdField_a_of_type_AndroidOsBundle.getInt("uin_type");
    String str1 = this.jdField_a_of_type_AndroidOsBundle.getString("openid");
    String str2 = this.jdField_a_of_type_AndroidOsBundle.getString("token");
    Object localObject2 = this.jdField_a_of_type_AndroidOsBundle.getString("url");
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("WebLog_WebViewFragment", 2, "url not found, use \"\" default");
      }
      localObject1 = "";
    }
    if (QLog.isColorLevel()) {
      QLog.d("WebLog_WebViewFragment", 2, "get a url:" + Util.b((String)localObject1, new String[0]));
    }
    localObject2 = localObject1;
    if (((String)localObject1).startsWith("http://browserApp.p.qq.com/"))
    {
      localObject2 = localObject1;
      if (!((String)localObject1).contains("?")) {
        localObject2 = (String)localObject1 + "?";
      }
      localObject2 = (String)localObject2 + "&openid=" + str1 + "&token=" + str2;
      this.intent.putExtra("url", (String)localObject2);
    }
    localObject1 = Uri.parse((String)localObject2);
    if ((localObject1 != null) && (((Uri)localObject1).isHierarchical()))
    {
      localObject1 = ((Uri)localObject1).getQueryParameter("_wv");
      if (localObject1 == null) {}
    }
    try
    {
      this.mUIStyle.jdField_a_of_type_Long = Long.parseLong(((String)localObject1).trim());
      this.mUIStyleHandler.a.jdField_a_of_type_Long = this.mUIStyle.jdField_a_of_type_Long;
      this.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidOsBundle.getInt("call_from");
      this.intent.removeExtra("call_from");
      this.publicUin = this.jdField_a_of_type_AndroidOsBundle.getString("puin");
      this.msgid = this.jdField_a_of_type_AndroidOsBundle.getString("msg_id");
      if (this.msgid == null) {
        this.msgid = "";
      }
      if (!this.jdField_a_of_type_AndroidOsBundle.getBoolean("hide_operation_bar"))
      {
        bool1 = true;
        this.b = bool1;
        if ((!((String)localObject2).startsWith("http://s.p.qq.com/pub/msg")) && (!((String)localObject2).startsWith("http://s.p.qq.com/pub/show"))) {
          break label698;
        }
        bool1 = true;
        this.jdField_a_of_type_Boolean = bool1;
        if (!this.jdField_a_of_type_AndroidOsBundle.containsKey("hide_operation_bar"))
        {
          if (this.jdField_a_of_type_Boolean) {
            break label703;
          }
          bool1 = true;
          this.b = bool1;
          localObject1 = this.intent;
          if (this.b) {
            break label708;
          }
          bool1 = true;
          ((Intent)localObject1).putExtra("hide_operation_bar", bool1);
        }
        localObject1 = this.jdField_a_of_type_AndroidOsBundle.getString("webStyle");
        if ((localObject1 != null) && (((String)localObject1).equals("noBottomBar"))) {
          this.b = false;
        }
        localObject1 = this.jdField_a_of_type_AndroidOsBundle.getString("disableshare");
        if (!this.jdField_a_of_type_AndroidOsBundle.getBoolean("hideRightButton", false))
        {
          bool1 = bool2;
          if (localObject1 != null)
          {
            bool1 = bool2;
            if (!((String)localObject1).equals("true")) {}
          }
        }
        else
        {
          bool1 = true;
        }
        this.c = bool1;
        localObject1 = (SwiftBrowserShareMenuHandler)this.mComponentsProvider.a(4);
        if ((!this.c) && ((this.mUIStyle.jdField_a_of_type_Long & 0x2378) == 9080L) && (!((SwiftBrowserShareMenuHandler)localObject1).a())) {
          this.c = true;
        }
        localObject1 = localObject2;
        if (((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).isKandianNeedAddSkinParamsUrl((String)localObject2)) {
          localObject1 = ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).addSkinParams((String)localObject2);
        }
        if (QLog.isColorLevel()) {
          QLog.d("WebLog_WebViewFragment", 1, "initParams url = " + (String)localObject1);
        }
        this.intent.putExtra("url", (String)localObject1);
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        boolean bool1;
        if (QLog.isDevelopLevel())
        {
          QLog.d("QQBrowser", 4, "sorry, i can not get rules from QQBrowser url, maybe have more than one '_wv' in the url");
          continue;
          bool1 = false;
          continue;
          label698:
          bool1 = false;
          continue;
          label703:
          bool1 = false;
          continue;
          label708:
          bool1 = false;
        }
      }
    }
  }
  
  private void a(Bundle paramBundle)
  {
    if ((this.mApp != null) && (!NetworkUtil.d(this.mApp.getApplication()))) {
      QQToast.a(this.mApp.getApplication(), 2131694457, 0).b(super.getTitleBarHeight());
    }
    if (!this.mUIStyleHandler.a.jdField_a_of_type_Boolean)
    {
      paramBundle = this.jdField_a_of_type_AndroidOsBundle.getString("assignBackText");
      if (!TextUtils.isEmpty(paramBundle)) {
        this.mSwiftTitleUI.jdField_a_of_type_AndroidWidgetTextView.setText(paramBundle);
      }
      if (this.c) {
        break label206;
      }
      this.mSwiftTitleUI.c.setText("");
      this.mSwiftTitleUI.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840482);
      this.mSwiftTitleUI.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(super.getText(2131692678));
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Int == 1001)
      {
        this.mSwiftTitleUI.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        this.mSwiftTitleUI.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        this.mSwiftTitleUI.c.setText(HardCodeUtil.a(2131708724));
        this.mSwiftTitleUI.c.setOnClickListener(this);
        this.mSwiftTitleUI.c.setVisibility(0);
      }
      return;
      label206:
      this.mSwiftTitleUI.c.setVisibility(8);
      this.mSwiftTitleUI.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      int i = (int)DisplayUtils.a(BaseApplicationImpl.getApplication(), 8.0F);
      if (this.mSwiftTitleUI.jdField_a_of_type_AndroidWidgetRelativeLayout != null) {
        ((RelativeLayout.LayoutParams)this.mSwiftTitleUI.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams()).setMargins(i, 0, i, 0);
      }
    }
  }
  
  public WebAIOController a()
  {
    if (this.jdField_a_of_type_ComTencentBizWebviewbaseWebAIOController == null)
    {
      WebAIOController.Builder localBuilder = new WebAIOController.Builder(getTitleBarView());
      boolean bool = this.intent.getBooleanExtra("switch_msg_btn", false);
      Bundle localBundle = new Bundle();
      localBundle.putBoolean("enable_switch", bool);
      localBundle.putString("banner_txt", String.format(PublicAccountBrowserImpl.access$700(), new Object[] { this.webViewTitle, "" }));
      localBundle.putInt("banner_icon_res", 2130841784);
      this.jdField_a_of_type_ComTencentBizWebviewbaseWebAIOController = localBuilder.a(localBundle).a();
    }
    return this.jdField_a_of_type_ComTencentBizWebviewbaseWebAIOController;
  }
  
  public void a(int paramInt)
  {
    Object localObject1 = getShareUrl();
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = this.mUrl;
    }
    if (TextUtils.isEmpty(this.publicUin)) {
      return;
    }
    localObject1 = "";
    Object localObject3 = Uri.parse((String)localObject2);
    try
    {
      localObject3 = ((Uri)localObject3).getQueryParameter("article_id");
      localObject1 = localObject3;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
      ReportController.b(null, "dc01160", "Pb_account_lifeservice", "", "0X8007C04", "0X8007C04", 0, 1, 0, localException, (String)localObject2, "1009", "");
    }
    localObject3 = localObject1;
    if (localObject1 == null) {
      localObject3 = "";
    }
    switch (paramInt)
    {
    default: 
    case 7: 
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "P_CliOper", "Pb_account_lifeservice", "", "0X800572A", "0X800572A", 1010, 0, this.publicUin, (String)localObject2, this.msgid, (String)localObject3, false);
      return;
    }
  }
  
  void a(Context paramContext, Uri paramUri, String paramString)
  {
    Intent localIntent = new Intent("android.intent.action.VIEW", paramUri);
    localIntent.addFlags(268435456);
    try
    {
      ActivityInfo localActivityInfo = localIntent.resolveActivityInfo(getActivity().getPackageManager(), 0);
      paramUri = "";
      if (localActivityInfo != null) {
        paramUri = localActivityInfo.packageName;
      }
      StartAppCheckHandler.a("scheme", paramString, paramUri, "1", "web", getActivity().getClass().getName());
      paramContext.startActivity(localIntent);
      return;
    }
    catch (Exception paramContext)
    {
      QLog.e("WebLog_WebViewFragment", 1, "afterWebViewEngineHandleOverrideUrl error!", paramContext);
    }
  }
  
  public void a(Context paramContext, String paramString1, Uri paramUri, String paramString2, String paramString3, String paramString4)
  {
    try
    {
      paramContext = DialogUtil.a(paramContext, 230, null, paramString3, HardCodeUtil.a(2131708766), HardCodeUtil.a(2131708745), new PublicAccountBrowserImpl.PublicAccountBrowserFragment.3(this, paramContext, paramUri, paramString1, paramString4), new PublicAccountBrowserImpl.PublicAccountBrowserFragment.4(this, paramString4));
      paramContext.show();
      paramContext.setCancelable(false);
      return;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  public void a(DialogInterface paramDialogInterface, boolean paramBoolean, String paramString)
  {
    paramDialogInterface.dismiss();
    if (!paramBoolean) {
      if (this.mApp != null) {
        ReportController.b(null, "dc01160", "Pb_account_lifeservice", this.mApp.getCurrentAccountUin(), "0X80090F3", "0X80090F3", 0, 0, "", "", "", paramString);
      }
    }
    while (this.mApp == null) {
      return;
    }
    ReportController.b(null, "dc01160", "Pb_account_lifeservice", this.mApp.getCurrentAccountUin(), "0X80090F4", "0X80090F4", 0, 0, "", "", "", paramString);
  }
  
  void a(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = this.publicUin;
    }
    if (str != null)
    {
      paramString = new ActivityURIRequest(super.getActivity(), "/pubaccount/detail");
      paramString.extra().putString("uin", str);
      paramString.extra().putInt("source", 111);
      QRoute.startUri(paramString, null);
    }
  }
  
  public void activityFinish()
  {
    super.activityFinish();
    if (this.jdField_a_of_type_Int == 1001) {
      ThreadManager.executeOnSubThread(new PublicAccountBrowserImpl.PublicAccountBrowserFragment.5(this));
    }
  }
  
  public boolean afterWebViewEngineHandleOverrideUrl(WebView paramWebView, String paramString)
  {
    Uri localUri = Uri.parse(paramString);
    String str = localUri.getScheme();
    if ((super.getActivity().isResume()) && ((System.currentTimeMillis() - this.mLastTouchTime < 1000L) || (this.authConfig.a(paramWebView.getUrl(), str).booleanValue())))
    {
      long l = System.currentTimeMillis();
      boolean bool = PayInterceptHelper.a().a(paramString, this);
      QLog.i("WebLog_WebViewFragment", 1, "TryPayIntercept result:" + bool + " cost:" + (System.currentTimeMillis() - l) + " ms.");
      if (!bool) {}
    }
    else
    {
      return true;
    }
    if ("2909288299".equalsIgnoreCase(this.publicUin))
    {
      paramString = a(paramString);
      if (!TextUtils.isEmpty(paramString))
      {
        paramWebView = paramWebView.getUrl();
        a(getActivity(), paramWebView, localUri, "QQ", paramString, this.publicUin);
        return true;
      }
    }
    a(getActivity(), localUri, paramWebView.getUrl());
    return true;
  }
  
  public SwiftBrowserComponentsProvider createComponentsProvider()
  {
    return new SwiftBrowserComponentsProvider(this, 127, new PublicAccountBrowserImpl.PublicAccountBrowserFragment.2(this));
  }
  
  public int doCreateLoopStep_Final(Bundle paramBundle)
  {
    int i = super.doCreateLoopStep_Final(paramBundle);
    if ((this.intent.getIntExtra("reqType", -1) == 5) && (!this.mUIStyleHandler.a.jdField_a_of_type_Boolean))
    {
      PublicAccountBrowserImpl.PublicAccountBrowserFragment.1 local1 = new PublicAccountBrowserImpl.PublicAccountBrowserFragment.1(this);
      this.mSwiftTitleUI.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(local1);
      this.mSwiftTitleUI.c.setText(2131691952);
      this.mSwiftTitleUI.c.setOnClickListener(local1);
    }
    a(paramBundle);
    return i;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    a();
    return super.doOnCreate(paramBundle);
  }
  
  public String getUAMark()
  {
    return "PA";
  }
  
  public void initFinish() {}
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_JavaLangRefSoftReference != null)
    {
      PublicAccountBrowserImpl.PublicAccountBrowserFragment.PublicAccountBrowserShareMenuHandler localPublicAccountBrowserShareMenuHandler = (PublicAccountBrowserImpl.PublicAccountBrowserFragment.PublicAccountBrowserShareMenuHandler)this.jdField_a_of_type_JavaLangRefSoftReference.get();
      if (localPublicAccountBrowserShareMenuHandler != null)
      {
        localPublicAccountBrowserShareMenuHandler.a();
        this.jdField_a_of_type_JavaLangRefSoftReference.clear();
      }
    }
  }
  
  public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    if (paramInt == -8) {
      QRUtils.a(1, 2131695216);
    }
    super.onReceivedError(paramWebView, paramInt, paramString1, paramString2);
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    if ((!paramString.startsWith("http://")) && (!paramString.startsWith("https://")) && (!paramString.startsWith("file://"))) {
      return super.shouldOverrideUrlLoading(paramWebView, paramString);
    }
    if (QLog.isColorLevel()) {
      QLog.d("WebLog_WebViewFragment", 2, "shouldOverride: " + Util.b(paramString, new String[0]));
    }
    Object localObject = paramWebView.getUrl();
    if ((TextUtils.isEmpty((CharSequence)localObject)) || (((String)localObject).startsWith("http://s.p.qq.com/pub/jump"))) {}
    for (int i = 1; (this.b) || (!this.jdField_a_of_type_Boolean) || (i != 0); i = 0)
    {
      this.e = false;
      if ((!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).startsWith("https://www.urlshare.cn/")))
      {
        localObject = getActivity();
        if ((localObject instanceof PublicAccountBrowserImpl))
        {
          PublicAccountBrowserImpl.access$200((PublicAccountBrowserImpl)localObject, paramString);
          PublicAccountBrowserImpl.access$100((PublicAccountBrowserImpl)localObject, paramString);
        }
      }
      return super.shouldOverrideUrlLoading(paramWebView, paramString);
    }
    if (!this.d)
    {
      paramWebView = new Intent(super.getActivity(), PublicAccountBrowserImpl.class);
      if (this.mApp != null) {
        paramWebView.putExtra("uin", this.mApp.getCurrentAccountUin());
      }
      paramWebView.putExtra("url", paramString);
      super.startActivity(paramWebView);
      return true;
    }
    return super.shouldOverrideUrlLoading(paramWebView, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.api.impl.PublicAccountBrowserImpl.PublicAccountBrowserFragment
 * JD-Core Version:    0.7.0.1
 */