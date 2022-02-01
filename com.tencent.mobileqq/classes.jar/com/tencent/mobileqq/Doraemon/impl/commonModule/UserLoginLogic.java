package com.tencent.mobileqq.Doraemon.impl.commonModule;

import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.CustomWebView;
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
import com.tencent.open.agent.entity.Permission;
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
  final DoraemonAPIManager b;
  final UserInfoModule c;
  protected APICallback d;
  protected List<Permission> e;
  int f = 0;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DoraemonOpenAPI.");
    localStringBuilder.append(UserLoginLogic.class.getSimpleName());
    a = localStringBuilder.toString();
  }
  
  public UserLoginLogic(DoraemonAPIManager paramDoraemonAPIManager, UserInfoModule paramUserInfoModule)
  {
    this.b = paramDoraemonAPIManager;
    this.c = paramUserInfoModule;
    this.e = new ArrayList();
  }
  
  private String a(AppRuntime paramAppRuntime, String paramString1, String paramString2, String paramString3)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    localLinkedHashMap.put("app_id", this.b.b);
    localLinkedHashMap.put("uin", paramAppRuntime.getAccount());
    localLinkedHashMap.put("sdkp", "a");
    localLinkedHashMap.put("response_type", "token");
    MiniAppInfo localMiniAppInfo = this.b.f();
    if (localMiniAppInfo == null) {
      paramAppRuntime = "";
    } else {
      paramAppRuntime = localMiniAppInfo.d;
    }
    localLinkedHashMap.put("app_name", paramAppRuntime);
    localLinkedHashMap.put("kSSOLoginTypeKey", "1");
    localLinkedHashMap.put("scope", "get_user_info,get_simple_userinfo,add_share,get_info,server_side");
    if (localMiniAppInfo == null) {
      paramAppRuntime = "";
    } else {
      paramAppRuntime = localMiniAppInfo.r;
    }
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
      paramString1 = new StringBuilder();
      paramString1.append((String)paramString3.getKey());
      paramString1.append("=");
      paramString1.append(URLEncoder.encode(paramAppRuntime));
      paramString1.append("&");
      localStringBuilder.append(paramString1.toString());
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
      QLog.i(a, 2, "doAuthorize");
    }
    long l = Long.parseLong(this.b.b);
    SdkAuthorize.AuthorizeRequest localAuthorizeRequest = new SdkAuthorize.AuthorizeRequest();
    localAuthorizeRequest.client_id.set(l);
    localAuthorizeRequest.need_pay.set(1);
    Object localObject1 = this.e.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Permission)((Iterator)localObject1).next();
      if (((Permission)localObject2).a > 0) {
        localAuthorizeRequest.openapi.add(Integer.valueOf(((Permission)localObject2).e));
      }
    }
    localObject1 = localAuthorizeRequest.os;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(Build.VERSION.RELEASE);
    ((StringBuilder)localObject2).append("|android os|");
    ((StringBuilder)localObject2).append(Build.MODEL);
    ((PBStringField)localObject1).set(((StringBuilder)localObject2).toString());
    localAuthorizeRequest.qqv.set(CommonDataAdapter.a().j());
    localAuthorizeRequest.pf.set("openmobile_android");
    localAuthorizeRequest.sdkp.set(DoraemonUtil.a(this.b.a));
    localAuthorizeRequest.sdkv.set("1.5.9");
    localAuthorizeRequest.response_type.set("token");
    localObject1 = this.b;
    if ((localObject1 instanceof DefaultDoraemonAPIManager))
    {
      localObject1 = ((DefaultDoraemonAPIManager)localObject1).i();
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        localAuthorizeRequest.appUniqueIdentifier.set((String)localObject1);
      }
    }
    localObject1 = BaseApplicationImpl.getApplication().getRuntime();
    localObject2 = ((AppRuntime)localObject1).getAccount();
    Object localObject3 = ((TicketManager)((AppRuntime)localObject1).getManager(2)).getSkey((String)localObject2);
    if (localObject3 != null) {
      localAuthorizeRequest.skey.set((String)localObject3);
    }
    Object localObject4 = this.b;
    if ((localObject4 instanceof WebViewDoraemonAPIManager))
    {
      localObject4 = (WebViewDoraemonAPIManager)localObject4;
      if (((WebViewDoraemonAPIManager)localObject4).n)
      {
        localObject3 = a((AppRuntime)localObject1, (String)localObject3, ((WebViewDoraemonAPIManager)localObject4).p, ((WebViewDoraemonAPIManager)localObject4).o);
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
    MiniAppInfo localMiniAppInfo = this.b.f();
    Object localObject3 = null;
    Object localObject1;
    if (localMiniAppInfo == null) {
      localObject1 = null;
    } else {
      localObject1 = localMiniAppInfo.d;
    }
    Object localObject2 = localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      localObject2 = BaseApplicationImpl.getApplication().getString(2131892352);
    }
    if (TextUtils.isEmpty(paramString))
    {
      a();
      return;
    }
    DoraemonAPIManager localDoraemonAPIManager = this.b;
    if (localMiniAppInfo == null) {
      localObject1 = localObject3;
    } else {
      localObject1 = localMiniAppInfo.e;
    }
    localDoraemonAPIManager.a((String)localObject2, (String)localObject1, BaseApplicationImpl.getApplication().getString(2131892351, new Object[] { localObject2 }), paramString, BaseApplicationImpl.getApplication().getString(2131918066), new UserLoginLogic.2(this), BaseApplicationImpl.getApplication().getString(2131918076), new UserLoginLogic.3(this), new UserLoginLogic.4(this));
  }
  
  private void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(a, 2, "-->queryAuthority");
    }
    SdkAuthorize.GetAuthApiListRequest localGetAuthApiListRequest = new SdkAuthorize.GetAuthApiListRequest();
    long l1 = 0L;
    try
    {
      long l2 = Long.parseLong(this.b.b);
      l1 = l2;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      label42:
      Object localObject1;
      Object localObject2;
      Object localObject3;
      String str;
      PBStringField localPBStringField;
      break label42;
    }
    localGetAuthApiListRequest.client_id.set(l1);
    localObject1 = localGetAuthApiListRequest.os;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(Build.VERSION.RELEASE);
    ((StringBuilder)localObject2).append("|android os|");
    ((StringBuilder)localObject2).append(Build.MODEL);
    ((PBStringField)localObject1).set(((StringBuilder)localObject2).toString());
    localObject2 = CommonDataAdapter.a().j();
    localObject3 = localGetAuthApiListRequest.qqv;
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    ((PBStringField)localObject3).set((String)localObject1);
    localGetAuthApiListRequest.pf.set("openmobile_android");
    localObject2 = "all";
    localObject3 = this.b;
    localObject1 = localObject2;
    if ((localObject3 instanceof WebViewDoraemonAPIManager))
    {
      localObject1 = localObject2;
      if (((WebViewDoraemonAPIManager)localObject3).n)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("all");
        ((StringBuilder)localObject1).append(",server_side");
        localObject1 = ((StringBuilder)localObject1).toString();
      }
    }
    localGetAuthApiListRequest.scope.set((String)localObject1);
    localGetAuthApiListRequest.sdkp.set(DoraemonUtil.a(this.b.a));
    localGetAuthApiListRequest.sdkv.set("1.5.9");
    localGetAuthApiListRequest.need_pay.set(1);
    localObject1 = this.b;
    if ((localObject1 instanceof DefaultDoraemonAPIManager))
    {
      localObject1 = ((DefaultDoraemonAPIManager)localObject1).i();
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        localGetAuthApiListRequest.appUniqueIdentifier.set((String)localObject1);
      }
    }
    localObject3 = BaseApplicationImpl.getApplication().getRuntime();
    str = ((AppRuntime)localObject3).getAccount();
    localObject2 = ((TicketManager)((AppRuntime)localObject3).getManager(2)).getSkey(str);
    localPBStringField = localGetAuthApiListRequest.skey;
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    localPBStringField.set((String)localObject1);
    localObject1 = new NewIntent(BaseApplicationImpl.getApplication(), OpensdkServlet.class);
    ((NewIntent)localObject1).setWithouLogin(true);
    ((NewIntent)localObject1).putExtra("uin", str);
    ((NewIntent)localObject1).putExtra("data", localGetAuthApiListRequest.toByteArray());
    ((NewIntent)localObject1).putExtra("cmd", "ConnAuthSvr.get_auth_api_list");
    ((NewIntent)localObject1).setObserver(new UserLoginLogic.1(this, str, paramBoolean));
    ((AppRuntime)localObject3).startServlet((NewIntent)localObject1);
  }
  
  private boolean a(SdkAuthorize.GetAuthApiListResponse paramGetAuthApiListResponse)
  {
    this.e.clear();
    paramGetAuthApiListResponse = paramGetAuthApiListResponse.authorized_form_list.get().iterator();
    while (paramGetAuthApiListResponse.hasNext())
    {
      appType.AuthItem localAuthItem = (appType.AuthItem)paramGetAuthApiListResponse.next();
      if (localAuthItem.is_new.get() != 0)
      {
        Permission localPermission = new Permission();
        localPermission.d = localAuthItem.api_list.get();
        localPermission.a = localAuthItem.default_flag.get();
        localPermission.e = localAuthItem.id.get();
        boolean bool;
        if (localAuthItem.is_new.get() != 0) {
          bool = true;
        } else {
          bool = false;
        }
        localPermission.c = bool;
        localPermission.b = localAuthItem.title.get();
        this.e.add(localPermission);
      }
    }
    return this.e.isEmpty();
  }
  
  private void b(String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("openBrowserForRedirect: invoked.  url: ");
      localStringBuilder.append(paramString);
      QLog.i((String)localObject, 2, localStringBuilder.toString());
    }
    Object localObject = this.b.h();
    if ((localObject != null) && ((this.b instanceof WebViewDoraemonAPIManager)) && ((localObject instanceof SwiftWebViewFragmentSupporter)))
    {
      localObject = ((SwiftWebViewFragmentSupporter)localObject).getCurrentWebViewFragment();
      if (localObject != null) {
        ((WebViewFragment)localObject).getWebView().loadUrl(paramString);
      }
    }
  }
  
  public void a(JSONObject paramJSONObject, APICallback paramAPICallback, boolean paramBoolean)
  {
    this.d = paramAPICallback;
    if (this.f != 0) {
      return;
    }
    a(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.Doraemon.impl.commonModule.UserLoginLogic
 * JD-Core Version:    0.7.0.1
 */