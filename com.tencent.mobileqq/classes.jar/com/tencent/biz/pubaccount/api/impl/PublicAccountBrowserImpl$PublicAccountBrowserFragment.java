package com.tencent.biz.pubaccount.api.impl;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.tencent.biz.common.util.Util;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.biz.webviewbase.WebAIOController;
import com.tencent.biz.webviewbase.WebAIOController.Builder;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.StartAppCheckHandler;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.qwallet.utils.IPayInterceptApi;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.webview.swift.SwiftBrowserUIStyle;
import com.tencent.mobileqq.webview.swift.SwiftIphoneTitleBarUI;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserComponentsProvider;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserShareMenuHandler;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler;
import com.tencent.mobileqq.webview.swift.utils.WebViewKernelCallBack;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.WebTitleBarInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import java.lang.ref.SoftReference;
import mqq.app.AppRuntime;

public class PublicAccountBrowserImpl$PublicAccountBrowserFragment
  extends WebViewFragment
{
  public int a;
  protected Bundle a;
  WebAIOController jdField_a_of_type_ComTencentBizWebviewbaseWebAIOController;
  protected String a;
  private SoftReference<PublicAccountBrowserImpl.PublicAccountBrowserFragment.PublicAccountBrowserShareMenuHandler> jdField_a_of_type_JavaLangRefSoftReference;
  protected boolean a;
  private int b;
  public String b;
  protected boolean b;
  public String c;
  protected boolean c;
  public String d;
  protected boolean d;
  protected boolean e = false;
  
  public PublicAccountBrowserImpl$PublicAccountBrowserFragment()
  {
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_b_of_type_Int = -1;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_c_of_type_JavaLangString = "";
  }
  
  public static String a(String paramString)
  {
    if (paramString.startsWith("qqnews://"))
    {
      paramString = new StringBuilder();
      paramString.append("即将离开\"QQ\"\r\n打开");
      paramString.append("\"腾讯新闻\"");
      return paramString.toString();
    }
    if ((!paramString.startsWith("tenvideo://")) && (!paramString.startsWith("tenvideo2://")) && (!paramString.startsWith("tenvideo3://")) && (!paramString.startsWith("tencent1004498506://")))
    {
      if (paramString.startsWith("mttbrowser://"))
      {
        paramString = new StringBuilder();
        paramString.append("即将离开\"QQ\"\r\n打开");
        paramString.append("\"QQ浏览器\"");
        return paramString.toString();
      }
      if (paramString.startsWith("qnreading://"))
      {
        paramString = new StringBuilder();
        paramString.append("即将离开\"QQ\"\r\n打开");
        paramString.append("\"天天快报\"");
        return paramString.toString();
      }
      if ((!paramString.startsWith("weishiandroidscheme://")) && (!paramString.startsWith("weishi://")))
      {
        if (paramString.startsWith("tnow://"))
        {
          paramString = new StringBuilder();
          paramString.append("即将离开\"QQ\"\r\n打开");
          paramString.append("\"NOW直播\"");
          return paramString.toString();
        }
        if ((!paramString.startsWith("sms://")) && (!paramString.startsWith("tel://")) && (!paramString.startsWith("tel://")) && (!paramString.startsWith("mailto://")) && (!paramString.startsWith("file://")) && (!paramString.startsWith("ftp://")) && (!paramString.startsWith("mqqapi://")) && (!paramString.startsWith("http://")) && (!paramString.startsWith("https://")) && (paramString.indexOf("://") != -1))
        {
          paramString = new StringBuilder();
          paramString.append("即将离开\"QQ\"\r\n打开");
          paramString.append(HardCodeUtil.a(2131708774));
          return paramString.toString();
        }
        return null;
      }
      paramString = new StringBuilder();
      paramString.append("即将离开\"QQ\"\r\n打开");
      paramString.append("\"微视\"");
      return paramString.toString();
    }
    paramString = new StringBuilder();
    paramString.append("即将离开\"QQ\"\r\n打开");
    paramString.append("\"腾讯视频\"");
    return paramString.toString();
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidOsBundle = this.intent.getExtras();
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidOsBundle.getString("uin_name");
    this.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidOsBundle.getInt("uin_type");
    this.jdField_d_of_type_JavaLangString = this.intent.getStringExtra("title");
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
    boolean bool1 = QLog.isColorLevel();
    boolean bool2 = false;
    if (bool1)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("get a url:");
      ((StringBuilder)localObject2).append(Util.b((String)localObject1, new String[0]));
      QLog.d("WebLog_WebViewFragment", 2, ((StringBuilder)localObject2).toString());
    }
    localObject2 = localObject1;
    if (((String)localObject1).startsWith("http://browserApp.p.qq.com/"))
    {
      localObject2 = localObject1;
      if (!((String)localObject1).contains("?"))
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append("?");
        localObject2 = ((StringBuilder)localObject2).toString();
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append((String)localObject2);
      ((StringBuilder)localObject1).append("&openid=");
      ((StringBuilder)localObject1).append(str1);
      ((StringBuilder)localObject1).append("&token=");
      ((StringBuilder)localObject1).append(str2);
      localObject2 = ((StringBuilder)localObject1).toString();
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
      getUIStyle().jdField_a_of_type_Long = Long.parseLong(((String)localObject1).trim());
      getUIStyleHandler().a.jdField_a_of_type_Long = getUIStyle().jdField_a_of_type_Long;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      label338:
      break label338;
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("QQBrowser", 4, "sorry, i can not get rules from QQBrowser url, maybe have more than one '_wv' in the url");
    }
    this.jdField_b_of_type_Int = this.jdField_a_of_type_AndroidOsBundle.getInt("call_from");
    this.intent.removeExtra("call_from");
    this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_AndroidOsBundle.getString("puin");
    this.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_AndroidOsBundle.getString("msg_id");
    if (this.jdField_c_of_type_JavaLangString == null) {
      this.jdField_c_of_type_JavaLangString = "";
    }
    this.jdField_b_of_type_Boolean = (this.jdField_a_of_type_AndroidOsBundle.getBoolean("hide_operation_bar") ^ true);
    if ((!((String)localObject2).startsWith("http://s.p.qq.com/pub/msg")) && (!((String)localObject2).startsWith("http://s.p.qq.com/pub/show"))) {
      bool1 = false;
    } else {
      bool1 = true;
    }
    this.jdField_a_of_type_Boolean = bool1;
    if (!this.jdField_a_of_type_AndroidOsBundle.containsKey("hide_operation_bar"))
    {
      this.jdField_b_of_type_Boolean = (this.jdField_a_of_type_Boolean ^ true);
      this.intent.putExtra("hide_operation_bar", this.jdField_b_of_type_Boolean ^ true);
    }
    localObject1 = this.jdField_a_of_type_AndroidOsBundle.getString("webStyle");
    if ((localObject1 != null) && (((String)localObject1).equals("noBottomBar"))) {
      this.jdField_b_of_type_Boolean = false;
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
    this.jdField_c_of_type_Boolean = bool1;
    localObject1 = (SwiftBrowserShareMenuHandler)this.mComponentsProvider.a(4);
    if ((!this.jdField_c_of_type_Boolean) && ((getUIStyle().jdField_a_of_type_Long & 0x2378) == 9080L) && (!((SwiftBrowserShareMenuHandler)localObject1).a())) {
      this.jdField_c_of_type_Boolean = true;
    }
    localObject1 = localObject2;
    if (((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).isKandianNeedAddSkinParamsUrl((String)localObject2)) {
      localObject1 = ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).addSkinParams((String)localObject2);
    }
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("initParams url = ");
      ((StringBuilder)localObject2).append((String)localObject1);
      QLog.d("WebLog_WebViewFragment", 1, ((StringBuilder)localObject2).toString());
    }
    this.intent.putExtra("url", (String)localObject1);
  }
  
  private void b(Bundle paramBundle)
  {
    if ((getAppRuntime() != null) && (!NetworkUtil.isNetSupport(getAppRuntime().getApplication()))) {
      QQToast.a(getAppRuntime().getApplication(), 2131694422, 0).b(getWebTitleBarInterface().a());
    }
    if (!getUIStyleHandler().a.jdField_a_of_type_Boolean)
    {
      paramBundle = this.jdField_a_of_type_AndroidOsBundle.getString("assignBackText");
      if (!TextUtils.isEmpty(paramBundle)) {
        getSwiftTitleUI().jdField_a_of_type_AndroidWidgetTextView.setText(paramBundle);
      }
      if (!this.jdField_c_of_type_Boolean)
      {
        getSwiftTitleUI().c.setText("");
        getSwiftTitleUI().jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840351);
        getSwiftTitleUI().jdField_a_of_type_AndroidWidgetImageView.setContentDescription(super.getText(2131692635));
      }
      else
      {
        getSwiftTitleUI().c.setVisibility(8);
        getSwiftTitleUI().jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        int i = (int)DisplayUtils.a(BaseApplicationImpl.getApplication(), 8.0F);
        if (getSwiftTitleUI().jdField_a_of_type_AndroidWidgetRelativeLayout != null) {
          ((RelativeLayout.LayoutParams)getSwiftTitleUI().jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams()).setMargins(i, 0, i, 0);
        }
      }
      if (this.jdField_b_of_type_Int == 1001)
      {
        getSwiftTitleUI().jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        getSwiftTitleUI().jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        getSwiftTitleUI().c.setText(HardCodeUtil.a(2131708730));
        getSwiftTitleUI().c.setOnClickListener(this);
        getSwiftTitleUI().c.setVisibility(0);
      }
    }
  }
  
  public WebAIOController a()
  {
    if (this.jdField_a_of_type_ComTencentBizWebviewbaseWebAIOController == null)
    {
      WebAIOController.Builder localBuilder = new WebAIOController.Builder(getWebTitleBarInterface().b());
      boolean bool = this.intent.getBooleanExtra("switch_msg_btn", false);
      Bundle localBundle = new Bundle();
      localBundle.putBoolean("enable_switch", bool);
      localBundle.putString("banner_txt", String.format(PublicAccountBrowserImpl.access$1200(), new Object[] { this.jdField_d_of_type_JavaLangString, "" }));
      localBundle.putInt("banner_icon_res", 2130841670);
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
    if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
      return;
    }
    localObject1 = Uri.parse((String)localObject2);
    String str;
    try
    {
      localObject1 = ((Uri)localObject1).getQueryParameter("article_id");
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      str = "";
    }
    if (str == null) {
      str = "";
    }
    if (paramInt != 7)
    {
      if (paramInt != 8) {
        return;
      }
      ReportController.b(null, "dc01160", "Pb_account_lifeservice", "", "0X8007C04", "0X8007C04", 0, 1, 0, str, (String)localObject2, "1009", "");
      return;
    }
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "P_CliOper", "Pb_account_lifeservice", "", "0X800572A", "0X800572A", 1010, 0, this.jdField_b_of_type_JavaLangString, (String)localObject2, this.jdField_c_of_type_JavaLangString, str, false);
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
      paramString2 = HardCodeUtil.a(2131708772);
      String str = HardCodeUtil.a(2131708751);
      paramString1 = new PublicAccountBrowserImpl.PublicAccountBrowserFragment.3(this, paramContext, paramUri, paramString1, paramString4);
      try
      {
        paramContext = DialogUtil.a(paramContext, 230, null, paramString3, paramString2, str, paramString1, new PublicAccountBrowserImpl.PublicAccountBrowserFragment.4(this, paramString4));
        paramContext.show();
        paramContext.setCancelable(false);
        return;
      }
      catch (Exception paramContext) {}
      paramContext.printStackTrace();
    }
    catch (Exception paramContext) {}
  }
  
  public void a(DialogInterface paramDialogInterface, boolean paramBoolean, String paramString)
  {
    paramDialogInterface.dismiss();
    if (!paramBoolean)
    {
      if (getAppRuntime() != null) {
        ReportController.b(null, "dc01160", "Pb_account_lifeservice", getAppRuntime().getCurrentAccountUin(), "0X80090F3", "0X80090F3", 0, 0, "", "", "", paramString);
      }
    }
    else if (getAppRuntime() != null) {
      ReportController.b(null, "dc01160", "Pb_account_lifeservice", getAppRuntime().getCurrentAccountUin(), "0X80090F4", "0X80090F4", 0, 0, "", "", "", paramString);
    }
  }
  
  public void a(Bundle paramBundle)
  {
    if ((this.intent.getIntExtra("reqType", -1) == 5) && (!getUIStyleHandler().a.jdField_a_of_type_Boolean))
    {
      PublicAccountBrowserImpl.PublicAccountBrowserFragment.1 local1 = new PublicAccountBrowserImpl.PublicAccountBrowserFragment.1(this);
      getSwiftTitleUI().jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(local1);
      getSwiftTitleUI().c.setText(2131691877);
      getSwiftTitleUI().c.setOnClickListener(local1);
    }
    b(paramBundle);
  }
  
  void a(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = this.jdField_b_of_type_JavaLangString;
    }
    if (str != null)
    {
      paramString = new ActivityURIRequest(super.getActivity(), "/pubaccount/detail");
      paramString.extra().putString("uin", str);
      paramString.extra().putInt("source", 111);
      QRoute.startUri(paramString, null);
    }
  }
  
  public boolean a(WebView paramWebView, String paramString)
  {
    Uri localUri = Uri.parse(paramString);
    long l = System.currentTimeMillis();
    boolean bool = ((IPayInterceptApi)QRoute.api(IPayInterceptApi.class)).tryIntercept(paramString, this);
    StringBuilder localStringBuilder = new StringBuilder("TryPayIntercept result:");
    localStringBuilder.append(bool);
    localStringBuilder.append(" cost:");
    localStringBuilder.append(System.currentTimeMillis() - l);
    localStringBuilder.append(" ms.");
    QLog.i("WebLog_WebViewFragment", 1, localStringBuilder.toString());
    if (bool) {
      return true;
    }
    if ("2909288299".equalsIgnoreCase(this.jdField_b_of_type_JavaLangString))
    {
      paramString = a(paramString);
      if (!TextUtils.isEmpty(paramString))
      {
        paramWebView = paramWebView.getUrl();
        a(getActivity(), paramWebView, localUri, "QQ", paramString, this.jdField_b_of_type_JavaLangString);
        return true;
      }
    }
    a(getActivity(), localUri, paramWebView.getUrl());
    return true;
  }
  
  public boolean a(WebView paramWebView, String paramString, WebViewKernelCallBack paramWebViewKernelCallBack)
  {
    if ((!paramString.startsWith("http://")) && (!paramString.startsWith("https://")) && (!paramString.startsWith("file://"))) {
      return paramWebViewKernelCallBack.shouldOverrideUrlLoading(paramWebView, paramString);
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("shouldOverride: ");
      ((StringBuilder)localObject).append(Util.b(paramString, new String[0]));
      QLog.d("WebLog_WebViewFragment", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = paramWebView.getUrl();
    int i;
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!((String)localObject).startsWith("http://s.p.qq.com/pub/jump"))) {
      i = 0;
    } else {
      i = 1;
    }
    if ((!this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Boolean) && (i == 0))
    {
      if (!this.jdField_d_of_type_Boolean)
      {
        paramWebView = new Intent(super.getActivity(), PublicAccountBrowserImpl.class);
        if (getAppRuntime() != null) {
          paramWebView.putExtra("uin", getAppRuntime().getCurrentAccountUin());
        }
        paramWebView.putExtra("url", paramString);
        super.startActivity(paramWebView);
        return true;
      }
      return paramWebViewKernelCallBack.shouldOverrideUrlLoading(paramWebView, paramString);
    }
    this.e = false;
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).startsWith("https://www.urlshare.cn/")))
    {
      localObject = getActivity();
      if ((localObject instanceof PublicAccountBrowserImpl))
      {
        localObject = (PublicAccountBrowserImpl)localObject;
        PublicAccountBrowserImpl.access$200((PublicAccountBrowserImpl)localObject, paramString);
        PublicAccountBrowserImpl.access$100((PublicAccountBrowserImpl)localObject, paramString);
      }
    }
    return paramWebViewKernelCallBack.shouldOverrideUrlLoading(paramWebView, paramString);
  }
  
  public void activityFinish()
  {
    super.activityFinish();
    if (this.jdField_b_of_type_Int == 1001) {
      ThreadManager.executeOnSubThread(new PublicAccountBrowserImpl.PublicAccountBrowserFragment.6(this));
    }
  }
  
  public SwiftBrowserComponentsProvider createComponentsProvider()
  {
    return new SwiftBrowserComponentsProvider(this, 511, new PublicAccountBrowserImpl.PublicAccountBrowserFragment.2(this));
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    a();
    return super.doOnCreate(paramBundle);
  }
  
  public WebViewKernelCallBack getWebViewKernelCallBack()
  {
    return new PublicAccountBrowserImpl.PublicAccountBrowserFragment.5(this, this.webViewSurface);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    Object localObject = this.jdField_a_of_type_JavaLangRefSoftReference;
    if (localObject != null)
    {
      localObject = (PublicAccountBrowserImpl.PublicAccountBrowserFragment.PublicAccountBrowserShareMenuHandler)((SoftReference)localObject).get();
      if (localObject != null)
      {
        ((PublicAccountBrowserImpl.PublicAccountBrowserFragment.PublicAccountBrowserShareMenuHandler)localObject).C_();
        this.jdField_a_of_type_JavaLangRefSoftReference.clear();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.api.impl.PublicAccountBrowserImpl.PublicAccountBrowserFragment
 * JD-Core Version:    0.7.0.1
 */