package com.tencent.biz.webviewplugin;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.video.api.IVideoFeedsIPCClient;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.webview.swift.IPreCreatePluginChecker;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler;
import com.tencent.mobileqq.webview.swift.utils.SwiftOfflineDataUtils;
import com.tencent.mobileqq.webview.swift.utils.SwiftOfflineDataUtils.OfflineData;
import com.tencent.mobileqq.widget.WebViewProgressBarController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import java.lang.ref.WeakReference;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ReadInJoyWebRenderPlugin
  extends WebViewPlugin
  implements IPreCreatePluginChecker
{
  private long jdField_a_of_type_Long;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  IVideoFeedsIPCClient jdField_a_of_type_ComTencentMobileqqKandianBizVideoApiIVideoFeedsIPCClient = null;
  private String jdField_a_of_type_JavaLangString;
  private WeakReference<WebView> jdField_a_of_type_JavaLangRefWeakReference;
  private boolean jdField_a_of_type_Boolean = false;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean = false;
  
  public ReadInJoyWebRenderPlugin()
  {
    this.mPluginNameSpace = "readInJoyWebRender";
  }
  
  private Boolean a(String paramString)
  {
    boolean bool = TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString);
    Boolean localBoolean = Boolean.valueOf(false);
    if (bool)
    {
      ((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).reportWebRenderPluginEventCost(true, "shouldOfflineIntercept", 0, System.currentTimeMillis() - this.jdField_a_of_type_Long);
      return localBoolean;
    }
    SwiftOfflineDataUtils.OfflineData localOfflineData = SwiftOfflineDataUtils.a(this.jdField_b_of_type_JavaLangString);
    if ((localOfflineData != null) && (!TextUtils.isEmpty(localOfflineData.jdField_b_of_type_JavaLangString)))
    {
      this.mRuntime.a().loadDataWithBaseURL(paramString, localOfflineData.jdField_b_of_type_JavaLangString, "text/html", "utf-8", paramString);
      this.jdField_a_of_type_Boolean = true;
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("native_render  shouldOfflineIntercept offline data with cache transUrl = ");
        paramString.append(this.jdField_b_of_type_JavaLangString);
        QLog.d("ReadInJoyWebRenderPlugin", 2, paramString.toString());
      }
      ((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).reportWebRenderPluginEventCost(true, "shouldOfflineIntercept", 1, System.currentTimeMillis() - this.jdField_a_of_type_Long);
      return Boolean.valueOf(true);
    }
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("native_render  shouldOfflineIntercept offline data no cache transUrl = ");
      paramString.append(this.jdField_b_of_type_JavaLangString);
      QLog.e("ReadInJoyWebRenderPlugin", 2, paramString.toString());
    }
    return localBoolean;
  }
  
  private String a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoApiIVideoFeedsIPCClient != null)
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("bundle_params_render_url", paramString);
      paramString = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoApiIVideoFeedsIPCClient.callServer("CMD_GET_WEB_RENDER_DATA", localBundle);
      if (paramString != null) {
        return paramString.getString("VALUE_WEB_RENDER_DATA");
      }
    }
    return "";
  }
  
  private void a(String paramString1, String paramString2, Map<String, Object> paramMap)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.mRuntime == null) {
      return;
    }
    Object localObject = this.mRuntime.a();
    if ((localObject instanceof QBaseActivity))
    {
      localObject = a((QBaseActivity)localObject);
      if ((localObject != null) && (((WebViewFragment)localObject).getUIStyleHandler() != null))
      {
        if (((WebViewFragment)localObject).getUIStyleHandler().a != null)
        {
          ((WebViewFragment)localObject).getUIStyleHandler().d = (paramBoolean ^ true);
          ((WebViewFragment)localObject).getUIStyleHandler().a.a(paramBoolean);
          return;
        }
        ((WebViewFragment)localObject).getUIStyleHandler().d = (paramBoolean ^ true);
      }
    }
  }
  
  public WebViewFragment a(QBaseActivity paramQBaseActivity)
  {
    paramQBaseActivity = paramQBaseActivity.getSupportFragmentManager();
    if (paramQBaseActivity != null)
    {
      paramQBaseActivity = paramQBaseActivity.getFragments();
      if ((paramQBaseActivity != null) && (paramQBaseActivity.size() > 0))
      {
        paramQBaseActivity = paramQBaseActivity.iterator();
        while (paramQBaseActivity.hasNext())
        {
          Fragment localFragment = (Fragment)paramQBaseActivity.next();
          if ((localFragment instanceof WebViewFragment)) {
            return (WebViewFragment)localFragment;
          }
        }
      }
    }
    return null;
  }
  
  public boolean a(String paramString)
  {
    if (!((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).getWebRenderConfig())
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyWebRenderPlugin", 2, "native_render shouldIntercept  getWebRenderConfig false");
      }
      return false;
    }
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    try
    {
      Object localObject1 = new URL(paramString);
      String str = ((URL)localObject1).getHost();
      localObject1 = ((URL)localObject1).getPath();
      Object localObject2 = Uri.parse(paramString);
      if ((localObject2 != null) && (((Uri)localObject2).isHierarchical()))
      {
        paramString = ((Uri)localObject2).getQueryParameter("_prenr");
        localObject2 = ((Uri)localObject2).getQueryParameter("_pbid");
        if (("kandian.qq.com".equalsIgnoreCase(str)) && (!TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.isEmpty((CharSequence)localObject2)) && (((String)localObject1).endsWith(".html")))
        {
          boolean bool = "1".equals(paramString);
          if (bool) {
            return true;
          }
        }
      }
    }
    catch (MalformedURLException paramString)
    {
      paramString.printStackTrace();
    }
    return false;
  }
  
  public long getWebViewEventByNameSpace(String paramString)
  {
    return 32L;
  }
  
  protected boolean handleEvent(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    if (!a(paramString)) {
      return false;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("native_render handleEvent type: ");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("; timeStamp: ");
      localStringBuilder.append(System.currentTimeMillis());
      localStringBuilder.append("; isRender: ");
      localStringBuilder.append(this.jdField_a_of_type_Boolean);
      localStringBuilder.append("; url:");
      localStringBuilder.append(paramString);
      QLog.i("ReadInJoyWebRenderPlugin", 2, localStringBuilder.toString());
    }
    if (paramLong == 32L)
    {
      a(paramString, "KEY_EVENT_BEFORE_LOAD", paramMap);
      if ((!((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).getCanLoadStartWebRenderModeConfig()) && (!this.jdField_a_of_type_Boolean)) {
        return a(paramString).booleanValue();
      }
      return this.jdField_a_of_type_Boolean;
    }
    if ((paramLong == 8589934593L) && (((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).getCanLoadStartWebRenderModeConfig()))
    {
      a(paramString, "EVENT_LOAD_START", paramMap);
      if (!this.jdField_a_of_type_Boolean) {
        return a(paramString).booleanValue();
      }
    }
    return false;
  }
  
  public boolean isNeedPreCreatePlugin(Intent paramIntent, String paramString1, String paramString2)
  {
    return paramString1.contains("kandian.qq.com");
  }
  
  protected void onCreate()
  {
    super.onCreate();
    if (this.mRuntime != null)
    {
      this.jdField_a_of_type_ComTencentCommonAppAppInterface = this.mRuntime.a();
      this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount();
      this.jdField_b_of_type_Boolean = ((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).getWebRenderConfig();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoApiIVideoFeedsIPCClient == null) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoApiIVideoFeedsIPCClient = ((IVideoFeedsIPCClient)QRoute.api(IVideoFeedsIPCClient.class));
    }
    if ((this.mRuntime != null) && (this.jdField_b_of_type_Boolean))
    {
      Activity localActivity = this.mRuntime.a();
      if ((localActivity instanceof QBaseActivity))
      {
        Object localObject = a((QBaseActivity)localActivity);
        if (localObject != null)
        {
          localObject = ((WebViewFragment)localObject).getCurrentUrl();
          String str = Uri.parse((String)localObject).getQueryParameter("_pbid");
          if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!TextUtils.isEmpty(str)))
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("_bid=");
            localStringBuilder.append(str);
            this.jdField_b_of_type_JavaLangString = HtmlOffline.a((String)localObject, localStringBuilder.toString());
            ThreadManager.post(new ReadInJoyWebRenderPlugin.1(this), 5, null, true);
          }
        }
      }
      this.jdField_a_of_type_Long = localActivity.getIntent().getLongExtra("bundle_param_click_time", System.currentTimeMillis());
      ((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).reportWebRenderPluginEventCost(true, "REPORT_EVENT_CREATE", 0, System.currentTimeMillis() - this.jdField_a_of_type_Long);
    }
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoApiIVideoFeedsIPCClient != null) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoApiIVideoFeedsIPCClient = null;
    }
    super.onDestroy();
  }
  
  protected void onWebViewCreated(CustomWebView paramCustomWebView)
  {
    super.onWebViewCreated(paramCustomWebView);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(this.mRuntime.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.ReadInJoyWebRenderPlugin
 * JD-Core Version:    0.7.0.1
 */