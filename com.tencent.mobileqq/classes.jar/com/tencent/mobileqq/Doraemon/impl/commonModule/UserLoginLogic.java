package com.tencent.mobileqq.Doraemon.impl.commonModule;

import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.Doraemon.APICallback;
import com.tencent.mobileqq.Doraemon.DoraemonAPIManager;
import com.tencent.mobileqq.Doraemon.impl.DefaultDoraemonAPIManager;
import com.tencent.mobileqq.Doraemon.impl.webview.WebViewDoraemonAPIManager;
import com.tencent.mobileqq.Doraemon.util.DoraemonUtil;
import com.tencent.mobileqq.miniapp.MiniAppInfo;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBSInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.webview.swift.SwiftWebViewFragmentSupporter;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.agent.CardContainer.Permission;
import com.tencent.open.appcommon.OpensdkServlet;
import com.tencent.protofile.sdkauthorize.SdkAuthorize.AuthorizeRequest;
import com.tencent.protofile.sdkauthorize.SdkAuthorize.GetAuthApiListRequest;
import com.tencent.protofile.sdkauthorize.SdkAuthorize.GetAuthApiListResponse;
import com.tencent.qconn.protofile.appType.AuthItem;
import com.tencent.qphone.base.util.QLog;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import mqq.manager.TicketManager;
import org.json.JSONObject;

public class UserLoginLogic
{
  public static final String a;
  int jdField_a_of_type_Int = 0;
  protected APICallback a;
  final DoraemonAPIManager jdField_a_of_type_ComTencentMobileqqDoraemonDoraemonAPIManager;
  final UserInfoModule jdField_a_of_type_ComTencentMobileqqDoraemonImplCommonModuleUserInfoModule;
  protected List<CardContainer.Permission> a;
  
  static
  {
    jdField_a_of_type_JavaLangString = "DoraemonOpenAPI." + UserLoginLogic.class.getSimpleName();
  }
  
  public UserLoginLogic(DoraemonAPIManager paramDoraemonAPIManager, UserInfoModule paramUserInfoModule)
  {
    this.jdField_a_of_type_ComTencentMobileqqDoraemonDoraemonAPIManager = paramDoraemonAPIManager;
    this.jdField_a_of_type_ComTencentMobileqqDoraemonImplCommonModuleUserInfoModule = paramUserInfoModule;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  private String a(AppRuntime paramAppRuntime, String paramString1, String paramString2, String paramString3)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    localLinkedHashMap.put("app_id", this.jdField_a_of_type_ComTencentMobileqqDoraemonDoraemonAPIManager.jdField_a_of_type_JavaLangString);
    localLinkedHashMap.put("uin", paramAppRuntime.getAccount());
    localLinkedHashMap.put("sdkp", "a");
    localLinkedHashMap.put("response_type", "token");
    MiniAppInfo localMiniAppInfo = this.jdField_a_of_type_ComTencentMobileqqDoraemonDoraemonAPIManager.a();
    if (localMiniAppInfo == null)
    {
      paramAppRuntime = "";
      localLinkedHashMap.put("app_name", paramAppRuntime);
      localLinkedHashMap.put("kSSOLoginTypeKey", "1");
      localLinkedHashMap.put("scope", "get_user_info,get_simple_userinfo,add_share,get_info,server_side");
      if (localMiniAppInfo != null) {
        break label265;
      }
    }
    label265:
    for (paramAppRuntime = "";; paramAppRuntime = localMiniAppInfo.i)
    {
      localLinkedHashMap.put("bundleid", paramAppRuntime);
      localLinkedHashMap.put("skey", paramString1);
      localLinkedHashMap.put("state", paramString3);
      localLinkedHashMap.put("redirect_uri", paramString2);
      paramString2 = localLinkedHashMap.entrySet().iterator();
      while (paramString2.hasNext())
      {
        paramString3 = (Map.Entry)paramString2.next();
        paramString1 = (String)paramString3.getValue();
        paramAppRuntime = paramString1;
        if (paramString1 == null) {
          paramAppRuntime = "";
        }
        localStringBuilder.append((String)paramString3.getKey() + "=" + URLEncoder.encode(paramAppRuntime) + "&");
      }
      paramAppRuntime = localMiniAppInfo.jdField_b_of_type_JavaLangString;
      break;
    }
    int i = localStringBuilder.length();
    if (i > 0) {
      localStringBuilder.delete(i - 1, i);
    }
    return localStringBuilder.toString();
  }
  
  private void a()
  {
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "doAuthorize");
    }
    long l = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqDoraemonDoraemonAPIManager.jdField_a_of_type_JavaLangString);
    SdkAuthorize.AuthorizeRequest localAuthorizeRequest = new SdkAuthorize.AuthorizeRequest();
    localAuthorizeRequest.client_id.set(l);
    localAuthorizeRequest.need_pay.set(1);
    Object localObject1 = this.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (CardContainer.Permission)((Iterator)localObject1).next();
      if (((CardContainer.Permission)localObject2).jdField_a_of_type_Int > 0) {
        localAuthorizeRequest.openapi.add(Integer.valueOf(((CardContainer.Permission)localObject2).jdField_b_of_type_Int));
      }
    }
    localAuthorizeRequest.os.set(Build.VERSION.RELEASE + "|android os|" + Build.MODEL);
    localAuthorizeRequest.qqv.set(CommonDataAdapter.a().d());
    localAuthorizeRequest.pf.set("openmobile_android");
    localAuthorizeRequest.sdkp.set(DoraemonUtil.a(this.jdField_a_of_type_ComTencentMobileqqDoraemonDoraemonAPIManager.jdField_a_of_type_Int));
    localAuthorizeRequest.sdkv.set("1.5.9");
    localAuthorizeRequest.response_type.set("token");
    if ((this.jdField_a_of_type_ComTencentMobileqqDoraemonDoraemonAPIManager instanceof DefaultDoraemonAPIManager))
    {
      localObject1 = ((DefaultDoraemonAPIManager)this.jdField_a_of_type_ComTencentMobileqqDoraemonDoraemonAPIManager).a();
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        localAuthorizeRequest.appUniqueIdentifier.set((String)localObject1);
      }
    }
    localObject1 = BaseApplicationImpl.getApplication().getRuntime();
    Object localObject2 = ((AppRuntime)localObject1).getAccount();
    Object localObject3 = ((TicketManager)((AppRuntime)localObject1).getManager(2)).getSkey((String)localObject2);
    if (localObject3 != null) {
      localAuthorizeRequest.skey.set((String)localObject3);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqDoraemonDoraemonAPIManager instanceof WebViewDoraemonAPIManager))
    {
      WebViewDoraemonAPIManager localWebViewDoraemonAPIManager = (WebViewDoraemonAPIManager)this.jdField_a_of_type_ComTencentMobileqqDoraemonDoraemonAPIManager;
      if (localWebViewDoraemonAPIManager.b)
      {
        localObject3 = a((AppRuntime)localObject1, (String)localObject3, localWebViewDoraemonAPIManager.e, localWebViewDoraemonAPIManager.d);
        localAuthorizeRequest.passData.set((String)localObject3);
      }
    }
    localObject3 = new NewIntent(BaseApplicationImpl.getApplication(), OpensdkServlet.class);
    ((NewIntent)localObject3).setWithouLogin(true);
    ((NewIntent)localObject3).putExtra("uin", (String)localObject2);
    ((NewIntent)localObject3).putExtra("data", localAuthorizeRequest.toByteArray());
    ((NewIntent)localObject3).putExtra("cmd", "ConnAuthSvr.sdk_auth_api");
    ((NewIntent)localObject3).setObserver(new UserLoginLogic.5(this, (String)localObject2));
    ((AppRuntime)localObject1).startServlet((NewIntent)localObject3);
  }
  
  private void a(String paramString)
  {
    String str = null;
    MiniAppInfo localMiniAppInfo = this.jdField_a_of_type_ComTencentMobileqqDoraemonDoraemonAPIManager.a();
    Object localObject;
    if (localMiniAppInfo == null)
    {
      localObject = null;
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        break label144;
      }
      localObject = BaseApplicationImpl.getApplication().getString(2131694691);
    }
    label144:
    for (;;)
    {
      if (TextUtils.isEmpty(paramString))
      {
        a();
        return;
        localObject = localMiniAppInfo.jdField_b_of_type_JavaLangString;
        break;
      }
      DoraemonAPIManager localDoraemonAPIManager = this.jdField_a_of_type_ComTencentMobileqqDoraemonDoraemonAPIManager;
      if (localMiniAppInfo == null) {}
      for (;;)
      {
        localDoraemonAPIManager.a((String)localObject, str, BaseApplicationImpl.getApplication().getString(2131694690, new Object[] { localObject }), paramString, BaseApplicationImpl.getApplication().getString(2131720671), new UserLoginLogic.2(this), BaseApplicationImpl.getApplication().getString(2131720681), new UserLoginLogic.3(this), new UserLoginLogic.4(this));
        return;
        str = localMiniAppInfo.c;
      }
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "-->queryAuthority");
    }
    SdkAuthorize.GetAuthApiListRequest localGetAuthApiListRequest = new SdkAuthorize.GetAuthApiListRequest();
    long l1 = 0L;
    try
    {
      long l2 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqDoraemonDoraemonAPIManager.jdField_a_of_type_JavaLangString);
      l1 = l2;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        String str2;
        Object localObject2;
        Object localObject1;
        String str3;
        PBStringField localPBStringField;
        continue;
        String str1 = "all";
      }
    }
    localGetAuthApiListRequest.client_id.set(l1);
    localGetAuthApiListRequest.os.set(Build.VERSION.RELEASE + "|android os|" + Build.MODEL);
    str2 = CommonDataAdapter.a().d();
    localObject2 = localGetAuthApiListRequest.qqv;
    localObject1 = str2;
    if (str2 == null) {
      localObject1 = "";
    }
    ((PBStringField)localObject2).set((String)localObject1);
    localGetAuthApiListRequest.pf.set("openmobile_android");
    if (((this.jdField_a_of_type_ComTencentMobileqqDoraemonDoraemonAPIManager instanceof WebViewDoraemonAPIManager)) && (((WebViewDoraemonAPIManager)this.jdField_a_of_type_ComTencentMobileqqDoraemonDoraemonAPIManager).b))
    {
      localObject1 = "all" + ",server_side";
      localGetAuthApiListRequest.scope.set((String)localObject1);
      localGetAuthApiListRequest.sdkp.set(DoraemonUtil.a(this.jdField_a_of_type_ComTencentMobileqqDoraemonDoraemonAPIManager.jdField_a_of_type_Int));
      localGetAuthApiListRequest.sdkv.set("1.5.9");
      localGetAuthApiListRequest.need_pay.set(1);
      if ((this.jdField_a_of_type_ComTencentMobileqqDoraemonDoraemonAPIManager instanceof DefaultDoraemonAPIManager))
      {
        localObject1 = ((DefaultDoraemonAPIManager)this.jdField_a_of_type_ComTencentMobileqqDoraemonDoraemonAPIManager).a();
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          localGetAuthApiListRequest.appUniqueIdentifier.set((String)localObject1);
        }
      }
      localObject2 = BaseApplicationImpl.getApplication().getRuntime();
      str3 = ((AppRuntime)localObject2).getAccount();
      str2 = ((TicketManager)((AppRuntime)localObject2).getManager(2)).getSkey(str3);
      localPBStringField = localGetAuthApiListRequest.skey;
      localObject1 = str2;
      if (str2 == null) {
        localObject1 = "";
      }
      localPBStringField.set((String)localObject1);
      localObject1 = new NewIntent(BaseApplicationImpl.getApplication(), OpensdkServlet.class);
      ((NewIntent)localObject1).setWithouLogin(true);
      ((NewIntent)localObject1).putExtra("uin", str3);
      ((NewIntent)localObject1).putExtra("data", localGetAuthApiListRequest.toByteArray());
      ((NewIntent)localObject1).putExtra("cmd", "ConnAuthSvr.get_auth_api_list");
      ((NewIntent)localObject1).setObserver(new UserLoginLogic.1(this, str3, paramBoolean));
      ((AppRuntime)localObject2).startServlet((NewIntent)localObject1);
      return;
    }
  }
  
  private boolean a(SdkAuthorize.GetAuthApiListResponse paramGetAuthApiListResponse)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    paramGetAuthApiListResponse = paramGetAuthApiListResponse.authorized_form_list.get().iterator();
    while (paramGetAuthApiListResponse.hasNext())
    {
      appType.AuthItem localAuthItem = (appType.AuthItem)paramGetAuthApiListResponse.next();
      if (localAuthItem.is_new.get() != 0)
      {
        CardContainer.Permission localPermission = new CardContainer.Permission();
        localPermission.jdField_b_of_type_JavaLangString = localAuthItem.api_list.get();
        localPermission.jdField_a_of_type_Int = localAuthItem.default_flag.get();
        localPermission.jdField_b_of_type_Int = localAuthItem.id.get();
        if (localAuthItem.is_new.get() != 0) {}
        for (boolean bool = true;; bool = false)
        {
          localPermission.jdField_a_of_type_Boolean = bool;
          localPermission.jdField_a_of_type_JavaLangString = localAuthItem.title.get();
          this.jdField_a_of_type_JavaUtilList.add(localPermission);
          break;
        }
      }
    }
    return this.jdField_a_of_type_JavaUtilList.isEmpty();
  }
  
  private void b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "openBrowserForRedirect: invoked.  url: " + paramString);
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqDoraemonDoraemonAPIManager.a();
    if ((localObject != null) && ((this.jdField_a_of_type_ComTencentMobileqqDoraemonDoraemonAPIManager instanceof WebViewDoraemonAPIManager)) && ((localObject instanceof SwiftWebViewFragmentSupporter)))
    {
      localObject = ((SwiftWebViewFragmentSupporter)localObject).getCurrentWebViewFragment();
      if (localObject != null) {
        ((WebViewFragment)localObject).webView.loadUrl(paramString);
      }
    }
  }
  
  public void a(JSONObject paramJSONObject, APICallback paramAPICallback, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqDoraemonAPICallback = paramAPICallback;
    if (this.jdField_a_of_type_Int != 0) {
      return;
    }
    a(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.Doraemon.impl.commonModule.UserLoginLogic
 * JD-Core Version:    0.7.0.1
 */