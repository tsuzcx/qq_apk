package com.tencent.mobileqq.Doraemon.impl.commonModule;

import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.Doraemon.APICallback;
import com.tencent.mobileqq.Doraemon.APIParam;
import com.tencent.mobileqq.Doraemon.AppInfo;
import com.tencent.mobileqq.Doraemon.DoraemonAPIManager;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBSInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.agent.CardContainer.Permission;
import com.tencent.open.appcommon.OpensdkServlet;
import com.tencent.protofile.sdkauthorize.SdkAuthorize.AuthItem;
import com.tencent.protofile.sdkauthorize.SdkAuthorize.AuthorizeRequest;
import com.tencent.protofile.sdkauthorize.SdkAuthorize.GetAuthApiListRequest;
import com.tencent.protofile.sdkauthorize.SdkAuthorize.GetAuthApiListResponse;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import mqq.manager.TicketManager;
import rjo;
import rjp;
import rjq;
import rjr;
import rjs;

public class UserLoginLogic
{
  public static final String a;
  int jdField_a_of_type_Int = 0;
  public APICallback a;
  final DoraemonAPIManager jdField_a_of_type_ComTencentMobileqqDoraemonDoraemonAPIManager;
  public final UserInfoModule a;
  protected List a;
  
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
  
  private void a()
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
      label39:
      AppRuntime localAppRuntime;
      String str;
      Object localObject;
      break label39;
    }
    localGetAuthApiListRequest.client_id.set(l1);
    localGetAuthApiListRequest.os.set(Build.VERSION.RELEASE + "|android os|" + Build.MODEL);
    localGetAuthApiListRequest.qqv.set(CommonDataAdapter.a().d());
    localGetAuthApiListRequest.pf.set("openmobile_android");
    localGetAuthApiListRequest.scope.set("all");
    localGetAuthApiListRequest.sdkp.set(DoraemonAPIManager.a(this.jdField_a_of_type_ComTencentMobileqqDoraemonDoraemonAPIManager.jdField_a_of_type_Int));
    localGetAuthApiListRequest.sdkv.set("1.5.9");
    localGetAuthApiListRequest.need_pay.set(1);
    localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    str = localAppRuntime.getAccount();
    localObject = ((TicketManager)localAppRuntime.getManager(2)).getSkey(str);
    localGetAuthApiListRequest.skey.set((String)localObject);
    localObject = new NewIntent(BaseApplicationImpl.getApplication(), OpensdkServlet.class);
    ((NewIntent)localObject).setWithouLogin(true);
    ((NewIntent)localObject).putExtra("uin", str);
    ((NewIntent)localObject).putExtra("data", localGetAuthApiListRequest.toByteArray());
    ((NewIntent)localObject).putExtra("cmd", "ConnAuthSvr.get_auth_api_list");
    ((NewIntent)localObject).setObserver(new rjo(this, str));
    localAppRuntime.startServlet((NewIntent)localObject);
  }
  
  private boolean a(SdkAuthorize.GetAuthApiListResponse paramGetAuthApiListResponse)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    paramGetAuthApiListResponse = paramGetAuthApiListResponse.authorized_form_list.get().iterator();
    while (paramGetAuthApiListResponse.hasNext())
    {
      SdkAuthorize.AuthItem localAuthItem = (SdkAuthorize.AuthItem)paramGetAuthApiListResponse.next();
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
  
  private void b()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqDoraemonDoraemonAPIManager.a();
    if (TextUtils.isEmpty(((AppInfo)localObject).jdField_b_of_type_JavaLangString)) {}
    for (localObject = "当前应用";; localObject = ((AppInfo)localObject).jdField_b_of_type_JavaLangString + "需要访问你的帐号进行登录")
    {
      this.jdField_a_of_type_ComTencentMobileqqDoraemonDoraemonAPIManager.a("用户授权", (String)localObject, "允许", new rjp(this), "拒绝", new rjq(this), new rjr(this));
      return;
    }
  }
  
  private void c()
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
    localAuthorizeRequest.sdkp.set(DoraemonAPIManager.a(this.jdField_a_of_type_ComTencentMobileqqDoraemonDoraemonAPIManager.jdField_a_of_type_Int));
    localAuthorizeRequest.sdkv.set("1.5.9");
    localAuthorizeRequest.response_type.set("token");
    localObject1 = BaseApplicationImpl.getApplication().getRuntime();
    Object localObject2 = ((AppRuntime)localObject1).getAccount();
    Object localObject3 = ((TicketManager)((AppRuntime)localObject1).getManager(2)).getSkey((String)localObject2);
    localAuthorizeRequest.skey.set((String)localObject3);
    localObject3 = new NewIntent(BaseApplicationImpl.getApplication(), OpensdkServlet.class);
    ((NewIntent)localObject3).setWithouLogin(true);
    ((NewIntent)localObject3).putExtra("uin", (String)localObject2);
    ((NewIntent)localObject3).putExtra("data", localAuthorizeRequest.toByteArray());
    ((NewIntent)localObject3).putExtra("cmd", "ConnAuthSvr.sdk_auth_api");
    ((NewIntent)localObject3).setObserver(new rjs(this, (String)localObject2));
    ((AppRuntime)localObject1).startServlet((NewIntent)localObject3);
  }
  
  public void a(APIParam paramAPIParam, APICallback paramAPICallback)
  {
    this.jdField_a_of_type_ComTencentMobileqqDoraemonAPICallback = paramAPICallback;
    if (this.jdField_a_of_type_Int != 0) {
      return;
    }
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.Doraemon.impl.commonModule.UserLoginLogic
 * JD-Core Version:    0.7.0.1
 */