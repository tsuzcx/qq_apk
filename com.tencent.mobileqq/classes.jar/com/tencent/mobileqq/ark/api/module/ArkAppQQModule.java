package com.tencent.mobileqq.ark.api.module;

import android.app.Activity;
import android.media.AudioManager;
import android.text.TextUtils;
import android.util.Log;
import com.google.gson.Gson;
import com.tencent.ark.ArkDispatchTask;
import com.tencent.ark.ArkViewModelBase.TimeRecord;
import com.tencent.ark.ark;
import com.tencent.ark.ark.Application;
import com.tencent.ark.ark.VariantWrapper;
import com.tencent.ark.open.ArkAppCacheMgr;
import com.tencent.ark.open.ArkAppConfigMgr;
import com.tencent.ark.open.ArkAppInfo.TimeRecord;
import com.tencent.ark.open.security.ArkAppUrlChecker;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.biz.common.util.Util;
import com.tencent.biz.pubaccount.NativeAd.util.ParseUtil;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.biz.subscribe.utils.SubscribeFollowUserUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.msglist.MsgList;
import com.tencent.mobileqq.activity.aio.coreui.msglist.ListUI;
import com.tencent.mobileqq.activity.aio.item.ArkAioContainerWrapper;
import com.tencent.mobileqq.activity.aio.item.ArkAppContainer;
import com.tencent.mobileqq.activity.aio.item.ArkDataRequestObj;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.ArkAppCenterUtil;
import com.tencent.mobileqq.ark.ArkAppDataReport;
import com.tencent.mobileqq.ark.api.ArkCommonUtil;
import com.tencent.mobileqq.ark.api.IArkAPIService;
import com.tencent.mobileqq.ark.api.IArkConfig;
import com.tencent.mobileqq.ark.api.IArkEnvironment;
import com.tencent.mobileqq.ark.api.IArkModuleAPIAuthority;
import com.tencent.mobileqq.ark.api.IArkSecureReport;
import com.tencent.mobileqq.ark.api.silk.ArkSilkAudioPlayerHelper;
import com.tencent.mobileqq.ark.api.silk.ArkSilkAudioPlayerWrapper;
import com.tencent.mobileqq.ark.component.ArkAppLocationManager;
import com.tencent.mobileqq.ark.config.ApiFrequencyConfig;
import com.tencent.mobileqq.ark.config.bean.ArkPlatformConfigBean;
import com.tencent.mobileqq.ark.config.config.ArkPlatformConfig;
import com.tencent.mobileqq.ark.image.ChooseImageIPCModule;
import com.tencent.mobileqq.ark.module.ArkAPIPermission;
import com.tencent.mobileqq.ark.module.ArkModuleMethod;
import com.tencent.mobileqq.ark.test.LocationSimulator;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.hitrate.PreloadProcHitSession;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.soso.location.data.SosoLocation;
import com.tencent.mobileqq.statistics.QQUserAction;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.vas.qvip.util.QQVipHelper;
import com.tencent.open.sdk.report.SdkShareReporter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@KeepClassConstructor
public class ArkAppQQModule
  extends ArkAppQQModuleBase
{
  private static long jdField_a_of_type_Long;
  private static long jdField_b_of_type_Long;
  protected ArkSilkAudioPlayerWrapper a;
  protected ArkAppLocationManager a;
  private WeakReference<QQCustomDialog> jdField_a_of_type_JavaLangRefWeakReference = null;
  private HashMap<String, String> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private HashMap<String, String> jdField_b_of_type_JavaUtilHashMap = new HashMap();
  private HashMap<String, String> c;
  
  public ArkAppQQModule(ark.Application paramApplication, int paramInt)
  {
    super(paramApplication, paramInt);
    this.jdField_c_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_ComTencentMobileqqArkComponentArkAppLocationManager = new ArkAppLocationManager(this.jdField_b_of_type_JavaLangString, 30000L);
  }
  
  private static int a(ark.VariantWrapper[] paramArrayOfVariantWrapper, long paramLong)
  {
    int i = 4;
    int k = i;
    if (paramLong >= 2L)
    {
      paramArrayOfVariantWrapper = paramArrayOfVariantWrapper[1];
      if ((paramArrayOfVariantWrapper != null) && (paramArrayOfVariantWrapper.GetType() == 5) && (paramArrayOfVariantWrapper.GetString() != null))
      {
        paramArrayOfVariantWrapper = paramArrayOfVariantWrapper.GetString().toLowerCase();
        String[] arrayOfString = new String[8];
        int m = 0;
        arrayOfString[0] = "d";
        arrayOfString[1] = "debug";
        int j = 2;
        arrayOfString[2] = "i";
        arrayOfString[3] = "info";
        arrayOfString[4] = "e";
        arrayOfString[5] = "error";
        arrayOfString[6] = "w";
        arrayOfString[7] = "warning";
        if ((!arrayOfString[0].equals(paramArrayOfVariantWrapper)) && (!arrayOfString[1].equals(paramArrayOfVariantWrapper)))
        {
          while (j < arrayOfString.length)
          {
            if (arrayOfString[j].equals(paramArrayOfVariantWrapper))
            {
              j = 1;
              i = 1;
              break label192;
            }
            j += 1;
          }
          j = 0;
        }
        else
        {
          if (QLog.isColorLevel()) {
            i = 2;
          }
          j = 0;
          m = 1;
        }
        label192:
        k = i;
        if (m == 0)
        {
          k = i;
          if (j != 0) {}
        }
      }
      else
      {
        k = 1;
      }
    }
    return k;
  }
  
  private static String a(ark.VariantWrapper[] paramArrayOfVariantWrapper)
  {
    int i = paramArrayOfVariantWrapper.length;
    String str2 = "";
    String str1 = str2;
    if (i >= 3) {
      if (!paramArrayOfVariantWrapper[2].IsArray())
      {
        str1 = str2;
        if (!paramArrayOfVariantWrapper[2].IsTable()) {}
      }
      else
      {
        str1 = paramArrayOfVariantWrapper[2].GetTableAsJsonString();
      }
    }
    return str1;
  }
  
  private void a()
  {
    if (!((IArkEnvironment)QRoute.api(IArkEnvironment.class)).isDebugMode()) {
      return;
    }
    ArkDispatchTask.getInstance().postToMainThread(new ArkAppQQModule.24(this));
  }
  
  private void a(long paramLong, String paramString)
  {
    ark.VariantWrapper localVariantWrapper1 = a(paramLong);
    if (localVariantWrapper1 == null)
    {
      QLog.e("ArkApp.ArkAppQQModule", 1, "Callback is null");
      return;
    }
    ark.VariantWrapper localVariantWrapper2 = localVariantWrapper1.Create();
    if (!TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ArkApp.ArkAppQQModule", 2, "doCallbackForGetPskeyAsync : SetString");
      }
      localVariantWrapper2.SetString(paramString);
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.d("ArkApp.ArkAppQQModule", 2, "doCallbackForGetPskeyAsync : SetNull");
      }
      localVariantWrapper2.SetNull();
    }
    paramString = localVariantWrapper1.Create();
    localVariantWrapper1.InvokeDefault(new ark.VariantWrapper[] { localVariantWrapper2 }, paramString);
    paramString.Reset();
    localVariantWrapper2.Reset();
    localVariantWrapper1.Reset();
  }
  
  private void a(long paramLong, String paramString, int paramInt)
  {
    paramString = a(paramLong);
    if (paramString == null)
    {
      QLog.e("ArkApp.ArkAppQQModule", 1, "GetUserInformation.arkGetUserInformation call back is null");
      return;
    }
    ark.VariantWrapper localVariantWrapper = paramString.Create();
    localVariantWrapper.SetNull();
    if (1 == paramInt)
    {
      localObject = ArkQQAPIIPCModule.c(null);
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        localVariantWrapper.SetTableAsJsonString((String)localObject);
      }
    }
    Object localObject = paramString.Create();
    paramString.InvokeDefault(new ark.VariantWrapper[] { localVariantWrapper }, (ark.VariantWrapper)localObject);
    ((ark.VariantWrapper)localObject).Reset();
    localVariantWrapper.Reset();
    paramString.Reset();
  }
  
  private void a(long paramLong1, String paramString, long paramLong2, long paramLong3, int paramInt)
  {
    if (1 != paramInt)
    {
      QLog.i("ArkApp.ArkAppQQModule", 1, "arkLoginGetOpenKey, no auth");
      a(null, null, paramLong1);
      return;
    }
    Object localObject = new StringBuilder(this.jdField_b_of_type_JavaLangString);
    ((StringBuilder)localObject).append("_");
    ((StringBuilder)localObject).append(paramLong3);
    ((StringBuilder)localObject).append("_");
    ((StringBuilder)localObject).append(paramString);
    paramString = ((StringBuilder)localObject).toString();
    if ((this.jdField_b_of_type_JavaUtilHashMap.containsKey(paramString)) && (!TextUtils.isEmpty((CharSequence)this.jdField_b_of_type_JavaUtilHashMap.get(paramString))) && (this.jdField_c_of_type_JavaUtilHashMap.containsKey(paramString)) && (!TextUtils.isEmpty((CharSequence)this.jdField_c_of_type_JavaUtilHashMap.get(paramString))))
    {
      localObject = String.valueOf(paramLong3);
      if ((!this.jdField_a_of_type_JavaUtilHashMap.containsKey(this.jdField_b_of_type_JavaLangString)) || (!this.jdField_a_of_type_JavaUtilHashMap.containsValue(localObject))) {
        this.jdField_a_of_type_JavaUtilHashMap.put(this.jdField_b_of_type_JavaLangString, localObject);
      }
      a((String)this.jdField_b_of_type_JavaUtilHashMap.get(paramString), (String)this.jdField_c_of_type_JavaUtilHashMap.get(paramString), paramLong1);
      return;
    }
    ArkQQAPIIPCModule.a(paramLong2, paramLong3, new ArkAppQQModule.25(this, paramLong1));
  }
  
  private void a(String paramString1, String paramString2, long paramLong)
  {
    ArkDispatchTask.getInstance().post(this.jdField_b_of_type_JavaLangString, new ArkAppQQModule.26(this, paramLong, paramString1, paramString2));
  }
  
  public void Destruct()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqArkComponentArkAppLocationManager;
    if (localObject != null) {
      ((ArkAppLocationManager)localObject).a();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqArkApiSilkArkSilkAudioPlayerWrapper;
    if (localObject != null)
    {
      ((ArkSilkAudioPlayerWrapper)localObject).a();
      this.jdField_a_of_type_ComTencentMobileqqArkApiSilkArkSilkAudioPlayerWrapper = null;
      ArkSilkAudioPlayerHelper.b();
    }
    super.Destruct();
  }
  
  public String GetTypeName()
  {
    return "QQ";
  }
  
  public boolean HasMethod(String paramString)
  {
    if (super.HasMethod(paramString)) {
      return true;
    }
    if (paramString.equals("OpenUrl")) {
      return true;
    }
    if (paramString.equals("NavigateTo")) {
      return true;
    }
    if (paramString.equals("OpenVideo")) {
      return true;
    }
    if (paramString.equals("GetVersion")) {
      return true;
    }
    if (paramString.equals("GetPerformance")) {
      return true;
    }
    if (paramString.equals("Login")) {
      return true;
    }
    if (paramString.equals("GetUserInformation")) {
      return true;
    }
    if (paramString.equals("OpenView")) {
      return true;
    }
    if (paramString.equals("CloseView")) {
      return true;
    }
    if (paramString.equals("ShareView")) {
      return true;
    }
    if (paramString.equals("ShowStatusBar")) {
      return true;
    }
    if (paramString.equals("HideStatusBar")) {
      return true;
    }
    if (paramString.equals("SetNavigationBarTitle")) {
      return true;
    }
    if (paramString.equals("ShowShareMenu")) {
      return true;
    }
    if (paramString.equals("HideShareMenu")) {
      return true;
    }
    if (paramString.equals("PreviewImage")) {
      return true;
    }
    if (paramString.equals("SetTalkBackText")) {
      return true;
    }
    if (paramString.equals("ChooseImage")) {
      return true;
    }
    if (paramString.equals("GetAppInfo")) {
      return true;
    }
    if (this.jdField_a_of_type_Int == 0)
    {
      if (paramString.equals("GetPskeyAsync")) {
        return true;
      }
      if (paramString.equals("GetNickName")) {
        return true;
      }
      if (paramString.equals("Report")) {
        return true;
      }
      if (paramString.equals("ReportEx")) {
        return true;
      }
      if (paramString.equals("Log")) {
        return true;
      }
      if (paramString.equals("GetContainerInfo")) {
        return true;
      }
      if (paramString.equals("DataRequest")) {
        return true;
      }
      if (paramString.equals("GetCurrentPosition")) {
        return true;
      }
      if (paramString.equals("WatchPosition")) {
        return true;
      }
      if (paramString.equals("ClearWatch")) {
        return true;
      }
      if (paramString.equals("GetCurrentAddress")) {
        return true;
      }
      if (paramString.equals("SendMessage")) {
        return true;
      }
      if (paramString.equals("TestGetJson")) {
        return false;
      }
      if (paramString.equals("Notify")) {
        return true;
      }
      if (paramString.equals("GetAppID")) {
        return true;
      }
      if (paramString.equals("GetAudioOutputMode")) {
        return true;
      }
      if (paramString.equals("IsMute")) {
        return true;
      }
      if (paramString.equals("GetNickNameByView")) {
        return true;
      }
      if (paramString.equals("SubscribePublicAccount")) {
        return true;
      }
    }
    return false;
  }
  
  public boolean Invoke(String paramString, ark.VariantWrapper[] paramArrayOfVariantWrapper, ark.VariantWrapper paramVariantWrapper)
  {
    if (super.Invoke(paramString, paramArrayOfVariantWrapper, paramVariantWrapper)) {
      return true;
    }
    if (!a(paramString)) {
      return false;
    }
    QQVipHelper.a(a(), paramString);
    if (paramString.equals("NavigateTo"))
    {
      paramString = a();
      if ((paramString != null) && (paramArrayOfVariantWrapper != null) && (paramArrayOfVariantWrapper.length >= 1)) {
        ArkCommonUtil.a(paramString, paramArrayOfVariantWrapper[0].GetString(), true, 0L, null, null, 3, this.jdField_b_of_type_JavaLangString, null);
      }
      return true;
    }
    boolean bool1 = paramString.equals("OpenUrl");
    Object localObject5 = "";
    Activity localActivity;
    long l1;
    Object localObject4;
    if (bool1)
    {
      paramVariantWrapper.SetBool(false);
      localActivity = a();
      if (localActivity == null)
      {
        QLog.i("ArkApp.ArkAppQQModule", 1, "open url, no activity found");
        return true;
      }
      if ((paramArrayOfVariantWrapper != null) && (paramArrayOfVariantWrapper.length >= 1))
      {
        localObject1 = paramArrayOfVariantWrapper[0].GetString();
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          if (paramArrayOfVariantWrapper.length > 1)
          {
            if (paramArrayOfVariantWrapper[1].IsView())
            {
              l1 = paramArrayOfVariantWrapper[1].GetView();
            }
            else
            {
              localObject4 = paramArrayOfVariantWrapper[1].GetTableAsJsonString();
              l1 = 0L;
              break label197;
            }
          }
          else {
            l1 = 0L;
          }
          localObject4 = null;
        }
      }
    }
    try
    {
      label197:
      if (paramArrayOfVariantWrapper.length > 2) {
        paramArrayOfVariantWrapper = new JSONObject(paramArrayOfVariantWrapper[2].GetTableAsJsonString());
      }
    }
    catch (JSONException paramString)
    {
      label220:
      Object localObject2;
      Object localObject3;
      String str1;
      MessageForArkApp localMessageForArkApp;
      int k;
      boolean bool2;
      boolean bool3;
      int j;
      break label220;
    }
    paramArrayOfVariantWrapper = null;
    if (paramArrayOfVariantWrapper != null) {
      localObject2 = paramArrayOfVariantWrapper.optString("businessId", "biz_src_jc_ark");
    } else {
      localObject2 = "biz_src_jc_ark";
    }
    if ((localActivity instanceof BaseActivity))
    {
      paramString = (BaseActivity)localActivity;
      if (paramString.getChatFragment() != null)
      {
        localObject3 = paramString.getChatFragment().a();
        paramString = (String)localObject3;
        if (!(localObject3 instanceof PublicAccountChatPie)) {
          break label399;
        }
        paramString = (String)localObject3;
        if (!"biz_src_ads".equals(localObject2)) {
          break label399;
        }
        str1 = ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).getSourceId(((BaseChatPie)localObject3).a.jdField_a_of_type_JavaLangString);
        paramString = new StringBuilder();
        paramString.append("ArkSafe.OpenUrl set hsSourceID for ");
        paramString.append(((BaseChatPie)localObject3).a.jdField_a_of_type_JavaLangString);
        paramString.append(", input ");
        paramString.append((String)localObject2);
        paramString.append(", output ");
        paramString.append(str1);
        QLog.d("ArkApp.ArkAppQQModule", 1, paramString.toString());
        break label405;
      }
    }
    paramString = null;
    label399:
    str1 = null;
    localObject3 = paramString;
    label405:
    if (l1 != 0L)
    {
      paramString = ark.arkGetContainer(l1);
      if (paramString != null)
      {
        paramString = (ArkAppContainer)ArkAppContainer.a(paramString).get();
        if ((paramString != null) && ((paramString instanceof ArkAioContainerWrapper)))
        {
          localMessageForArkApp = (MessageForArkApp)((ArkAioContainerWrapper)paramString).jdField_a_of_type_JavaLangRefWeakReference.get();
          break label465;
        }
      }
    }
    localMessageForArkApp = null;
    label465:
    int i;
    if (((IArkAPIService)QRoute.api(IArkAPIService.class)).dispatchOpenURL((String)localObject1, (String)localObject4, paramArrayOfVariantWrapper, this.jdField_a_of_type_Int, this.jdField_b_of_type_JavaLangString))
    {
      ArkAppDataReport.a(null, this.jdField_b_of_type_JavaLangString, "FullScreenOrH5ShowForAI", 0, 0, 0L, 0L, 0L, "", "");
      paramVariantWrapper.SetBool(true);
      if (!((IMiniAppService)QRoute.api(IMiniAppService.class)).isMiniAppUrl((String)localObject1))
      {
        paramArrayOfVariantWrapper = (ark.VariantWrapper[])localObject1;
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          paramArrayOfVariantWrapper = (ark.VariantWrapper[])localObject1;
          if (!((String)localObject1).startsWith("miniapp")) {}
        }
      }
      else
      {
        paramArrayOfVariantWrapper = (ark.VariantWrapper[])localObject1;
        if (localMessageForArkApp != null)
        {
          l1 = ParseUtil.a(localMessageForArkApp.ark_app_message.getAppIdFromMeta(), 0L);
          if (l1 == 0L) {
            paramString = (String)localObject5;
          } else {
            paramString = String.valueOf(l1);
          }
          ReportController.b(null, "dc00898", "", "", "0X800A86C", "0X800A86C", 0, 0, paramString, "", "", "");
          paramArrayOfVariantWrapper = (ark.VariantWrapper[])localObject1;
        }
      }
    }
    else if ((!((String)localObject1).startsWith("http://")) && (!((String)localObject1).startsWith("https://")))
    {
      paramArrayOfVariantWrapper = (ark.VariantWrapper[])localObject1;
      if (this.jdField_a_of_type_Int == 0)
      {
        paramString = JumpParser.a(a(), localActivity, (String)localObject1);
        paramArrayOfVariantWrapper = (ark.VariantWrapper[])localObject1;
        if (paramString != null)
        {
          paramArrayOfVariantWrapper = ArkAppConfigMgr.getInstance().getUrlChecker(this.jdField_b_of_type_JavaLangString);
          if (paramArrayOfVariantWrapper != null)
          {
            k = paramArrayOfVariantWrapper.checkUrlIsValidByAppNavigationList((String)localObject1);
            if (k == 0) {
              i = 1;
            } else {
              i = 0;
            }
            bool2 = ArkAppConfigMgr.getInstance().isUrlCheckEnable(this.jdField_b_of_type_JavaLangString);
            bool3 = ArkAppCenterUtil.a();
            if ((bool2) && (!bool3)) {
              bool1 = true;
            } else {
              bool1 = false;
            }
            if (QLog.isColorLevel()) {
              QLog.e("ArkApp.ArkAppQQModule", 2, new Object[] { "ArkSafe.UrlCheck.OpenUrl.http.JumpAction=", this.jdField_b_of_type_JavaLangString, ", enableCheck=", Boolean.valueOf(bool1), ", appEnableCheck=", Boolean.valueOf(bool2), ", isPublicAccount=", Boolean.valueOf(bool3) });
            }
            if (i == 0)
            {
              if (!bool1)
              {
                QLog.e("ArkApp.ArkAppQQModule", 1, new Object[] { "ArkSafe.UrlCheck.setDisable.OpenUrl.jump appName=", this.jdField_b_of_type_JavaLangString, ",url=", Util.b((String)localObject1, new String[0]), ", isValid set=true" });
                i = 1;
                j = 2;
              }
              else
              {
                j = 1;
              }
            }
            else {
              j = 0;
            }
            ((IArkSecureReport)QRoute.api(IArkSecureReport.class)).reportOpenURLAccess(this.jdField_b_of_type_JavaLangString, (String)localObject1, k, j, ArkAppContainer.jdField_c_of_type_JavaLangString);
          }
          else
          {
            i = 1;
          }
          if (i != 0)
          {
            paramString.a();
            paramArrayOfVariantWrapper = (ark.VariantWrapper[])localObject1;
          }
          else
          {
            QLog.e("ArkApp.ArkAppQQModule", 1, new Object[] { "ArkSafe.OpenUrl check url invalid, url=", Util.b((String)localObject1, new String[0]), ", app=", this.jdField_b_of_type_JavaLangString });
            paramArrayOfVariantWrapper = (ark.VariantWrapper[])localObject1;
          }
        }
      }
    }
    else
    {
      if (!ArkAPIPermission.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentArkArk$Application, "permission.BROWSER"))
      {
        QLog.d("ArkApp.ArkAppQQModule", 1, "ArkSafe.OpenUrl ModuleCheckPermission invalid!");
        return false;
      }
      paramString = ArkAppConfigMgr.getInstance().getUrlChecker(this.jdField_b_of_type_JavaLangString);
      if (paramString != null)
      {
        k = paramString.checkUrlIsValidByAppNavigationList((String)localObject1);
        if (k == 0) {
          i = 1;
        } else {
          i = 0;
        }
        bool2 = ArkAppConfigMgr.getInstance().isUrlCheckEnable(this.jdField_b_of_type_JavaLangString);
        bool3 = ArkAppCenterUtil.a();
        if ((bool2) && (!bool3)) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        if (QLog.isColorLevel()) {
          QLog.e("ArkApp.ArkAppQQModule", 2, new Object[] { "ArkSafe.UrlCheck.OpenUrl.http.appname=", this.jdField_b_of_type_JavaLangString, ", enableCheck=", Boolean.valueOf(bool1), ", appEnableCheck=", Boolean.valueOf(bool2), ", isPublicAccount=", Boolean.valueOf(bool3) });
        }
        if (i == 0)
        {
          if (!bool1)
          {
            QLog.e("ArkApp.ArkAppQQModule", 1, new Object[] { "ArkSafe.UrlCheck.setDisable.OpenUrl.http appName=", this.jdField_b_of_type_JavaLangString, ",url=", Util.b((String)localObject1, new String[0]), ", isValid set=true" });
            i = 1;
            j = 2;
          }
          else
          {
            j = 1;
          }
          a();
        }
        else
        {
          j = 0;
        }
        ((IArkSecureReport)QRoute.api(IArkSecureReport.class)).reportOpenURLAccess(this.jdField_b_of_type_JavaLangString, (String)localObject1, k, j, ArkAppContainer.jdField_c_of_type_JavaLangString);
      }
      else
      {
        i = 1;
      }
      if (i == 0)
      {
        QLog.d("ArkApp.ArkAppQQModule", 1, new Object[] { "ArkSafe.OpenUrl check url invalid!, url=", Util.b((String)localObject1, new String[0]), ", app=", this.jdField_b_of_type_JavaLangString });
        return false;
      }
      paramString = (String)localObject1;
      if (!TextUtils.isEmpty((CharSequence)localObject4))
      {
        for (;;)
        {
          try
          {
            localObject4 = new JSONObject((String)localObject4);
            localObject5 = ((JSONObject)localObject4).keys();
            paramArrayOfVariantWrapper = new String();
            i = 0;
            if (!((Iterator)localObject5).hasNext()) {
              continue;
            }
            str2 = (String)((Iterator)localObject5).next();
            if ((((JSONObject)localObject4).get(str2) instanceof String))
            {
              paramString = ((JSONObject)localObject4).getString(str2);
            }
            else
            {
              if (!(((JSONObject)localObject4).get(str2) instanceof Number)) {
                continue;
              }
              paramString = ((Number)((JSONObject)localObject4).get(str2)).toString();
            }
          }
          catch (JSONException paramString)
          {
            String str2;
            long l2;
            int m;
            int n;
            double d;
            paramString = (String)localObject1;
            continue;
            paramString = null;
            continue;
            i = 0;
            continue;
            bool1 = true;
            continue;
            paramString = null;
            continue;
          }
          if (!TextUtils.isEmpty(paramString))
          {
            paramVariantWrapper = paramArrayOfVariantWrapper;
            if (i != 0)
            {
              paramVariantWrapper = new StringBuilder();
              paramVariantWrapper.append(paramArrayOfVariantWrapper);
              paramVariantWrapper.append("&");
              paramVariantWrapper = paramVariantWrapper.toString();
            }
            paramArrayOfVariantWrapper = new StringBuilder();
            paramArrayOfVariantWrapper.append(paramVariantWrapper);
            paramArrayOfVariantWrapper.append(str2);
            paramArrayOfVariantWrapper.append("=");
            paramArrayOfVariantWrapper.append(paramString);
            paramArrayOfVariantWrapper = paramArrayOfVariantWrapper.toString();
            i = 1;
          }
        }
        paramString = (String)localObject1;
        if (!TextUtils.isEmpty(paramArrayOfVariantWrapper)) {
          if (((String)localObject1).indexOf("?", 0) == -1)
          {
            paramString = new StringBuilder();
            paramString.append((String)localObject1);
            paramString.append(paramArrayOfVariantWrapper);
            paramString = paramString.toString();
          }
          else
          {
            paramString = new StringBuilder();
            paramString.append((String)localObject1);
            paramString.append("&");
            paramString.append(paramArrayOfVariantWrapper);
            paramString = paramString.toString();
          }
        }
      }
      if ((localObject3 instanceof PublicAccountChatPie)) {
        ((PublicAccountChatPie)localObject3).a.b();
      } else {
        ArkAppDataReport.a(null, this.jdField_b_of_type_JavaLangString, "FullScreenOrH5ShowForAI", 0, 0, 0L, 0L, 0L, "", "");
      }
      if ((localMessageForArkApp != null) && (localMessageForArkApp.ark_app_message != null))
      {
        l1 = ParseUtil.a(localMessageForArkApp.ark_app_message.getAppIdFromMeta(), 0L);
        ArkCommonUtil.a(localActivity, paramString, true, l1, localMessageForArkApp, (String)localObject2, 0, this.jdField_b_of_type_JavaLangString, str1);
        SdkShareReporter.b(localMessageForArkApp);
        paramArrayOfVariantWrapper = paramString;
        if (localMessageForArkApp.isFromSdkShare())
        {
          if (l1 == 0L) {
            paramArrayOfVariantWrapper = "";
          } else {
            paramArrayOfVariantWrapper = String.valueOf(l1);
          }
          ReportController.b(null, "dc00898", "", "", "0X800A869", "0X800A869", 0, 0, paramArrayOfVariantWrapper, "", "", "");
          paramArrayOfVariantWrapper = paramString;
        }
      }
      else
      {
        ArkCommonUtil.a(localActivity, paramString, true, 0L, null, (String)localObject2, 0, this.jdField_b_of_type_JavaLangString, str1);
        paramArrayOfVariantWrapper = paramString;
      }
    }
    Log.d("ark.OpenUrl ", paramArrayOfVariantWrapper);
    ArkAppDataReport.a(null, this.jdField_b_of_type_JavaLangString, "FullScreenOrH5Show", 0, 0, 0L, 0L, 0L, "", "");
    return true;
    if (paramString.equals("OpenVideo"))
    {
      l1 = System.currentTimeMillis();
      l2 = jdField_a_of_type_Long;
      if ((l1 - l2 < 1000L) && (l1 > l2))
      {
        if (QLog.isColorLevel()) {
          QLog.e("ArkApp.ArkAppQQModule", 2, "click too offen,please try again later ");
        }
        return true;
      }
      jdField_a_of_type_Long = l1;
      paramVariantWrapper.SetBool(false);
      paramString = a();
      if (((paramString instanceof BaseActivity)) && (paramArrayOfVariantWrapper != null) && (paramArrayOfVariantWrapper.length >= 1))
      {
        paramArrayOfVariantWrapper = paramArrayOfVariantWrapper[0].GetString();
        if (!TextUtils.isEmpty(paramArrayOfVariantWrapper)) {
          try
          {
            localObject1 = new URL(paramArrayOfVariantWrapper).getProtocol();
            if ((!TextUtils.isEmpty((CharSequence)localObject1)) && ((((String)localObject1).equalsIgnoreCase("http")) || (((String)localObject1).equalsIgnoreCase("https"))))
            {
              if ((this.jdField_a_of_type_ComTencentArkArk$Application != null) && (!this.jdField_a_of_type_ComTencentArkArk$Application.CheckUrlLegality(paramArrayOfVariantWrapper))) {
                return false;
              }
              paramVariantWrapper.SetBool(true);
              ArkCommonUtil.a(paramString, paramArrayOfVariantWrapper);
              ArkAppDataReport.a(a(), this.jdField_b_of_type_JavaLangString, "AIOArkOpenVideo", 1, 0, 0L, 0L, 0L, paramArrayOfVariantWrapper, "");
              return true;
            }
          }
          catch (MalformedURLException paramString)
          {
            paramArrayOfVariantWrapper = new StringBuilder();
            paramArrayOfVariantWrapper.append("url parse error and msg= ");
            paramArrayOfVariantWrapper.append(paramString.getMessage());
            QLog.i("ArkApp.ArkAppQQModule", 1, paramArrayOfVariantWrapper.toString());
            return false;
          }
        }
      }
      return true;
    }
    if (paramString.equals("Report"))
    {
      paramString = a();
      if ((paramArrayOfVariantWrapper != null) && (paramArrayOfVariantWrapper.length == 3))
      {
        paramVariantWrapper = paramArrayOfVariantWrapper[0].GetString();
        i = (int)Math.round(paramArrayOfVariantWrapper[1].GetDouble());
        paramArrayOfVariantWrapper = paramArrayOfVariantWrapper[2].GetString();
        if (!TextUtils.isEmpty(paramArrayOfVariantWrapper))
        {
          l1 = NetConnInfoCenter.getServerTime();
          if (TextUtils.isEmpty(paramVariantWrapper)) {}
        }
      }
    }
    try
    {
      Long.parseLong(paramVariantWrapper);
      ReportController.b(paramString, "CliOper", "", "", "0X8005FFE", "0X8005FFE", i, 0, Long.toString(l1), paramVariantWrapper, paramArrayOfVariantWrapper, "");
    }
    catch (Exception paramVariantWrapper)
    {
      label2196:
      break label2196;
    }
    ReportController.b(paramString, "CliOper", "", "", "0X8005FFE", "0X8005FFE", i, 0, Long.toString(l1), "0", paramArrayOfVariantWrapper, "");
    break label2261;
    ReportController.b(paramString, "CliOper", "", "", "0X8005FFE", "0X8005FFE", i, 0, Long.toString(l1), "0", paramArrayOfVariantWrapper, "");
    label2261:
    ArkAppDataReport.a(paramString, this.jdField_b_of_type_JavaLangString, paramArrayOfVariantWrapper, i);
    return true;
    if (paramString.equals("ReportEx"))
    {
      if (paramArrayOfVariantWrapper.length > 0) {
        paramVariantWrapper = paramArrayOfVariantWrapper[0].GetString();
      } else {
        paramVariantWrapper = null;
      }
      if (paramArrayOfVariantWrapper.length > 1) {
        paramString = paramArrayOfVariantWrapper[1].GetTableAsJsonString();
      } else {
        paramString = null;
      }
      if ((!TextUtils.isEmpty(paramVariantWrapper)) && (!TextUtils.isEmpty(paramString)) && (!paramVariantWrapper.equals("898"))) {}
    }
    try
    {
      localObject3 = new JSONObject(paramString);
      paramArrayOfVariantWrapper = ((JSONObject)localObject3).getString("type");
      paramVariantWrapper = ((JSONObject)localObject3).getString("name");
      localObject1 = ((JSONObject)localObject3).optString("targetUin", "");
      i = ((JSONObject)localObject3).optInt("entry", 0);
      j = ((JSONObject)localObject3).optInt("count", 1);
      k = ((JSONObject)localObject3).optInt("result", 0);
      m = ((JSONObject)localObject3).optInt("r1", 0);
      n = ((JSONObject)localObject3).optInt("r2", 0);
      localObject2 = ((JSONObject)localObject3).optString("r3", "");
      localObject3 = ((JSONObject)localObject3).optString("r4", "");
      ReportController.b(null, "dc00898", "", (String)localObject1, paramArrayOfVariantWrapper, paramVariantWrapper, i, j, k, Integer.toString(m), Integer.toString(n), (String)localObject2, (String)localObject3);
      return true;
    }
    catch (JSONException paramArrayOfVariantWrapper)
    {
      label2500:
      break label2500;
    }
    paramArrayOfVariantWrapper = new StringBuilder();
    paramArrayOfVariantWrapper.append("QQ.ReportEx, invalid report data, data=");
    paramArrayOfVariantWrapper.append(paramString);
    QLog.i("ArkApp.ArkAppQQModule", 1, paramArrayOfVariantWrapper.toString());
    return false;
    if (paramVariantWrapper.equals("1160")) {}
    try
    {
      localObject3 = new JSONObject(paramString);
      paramArrayOfVariantWrapper = ((JSONObject)localObject3).getString("name");
      paramVariantWrapper = ((JSONObject)localObject3).optString("targetUin", "");
      i = ((JSONObject)localObject3).optInt("r2", 0);
      localObject1 = ((JSONObject)localObject3).optString("r3", "");
      localObject2 = ((JSONObject)localObject3).optString("r4", "");
      localObject3 = ((JSONObject)localObject3).optString("r5", "");
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, paramVariantWrapper, paramArrayOfVariantWrapper, paramArrayOfVariantWrapper, 0, 0, String.valueOf(i), (String)localObject1, (String)localObject2, (String)localObject3, false);
      return true;
    }
    catch (JSONException paramArrayOfVariantWrapper)
    {
      label2655:
      break label2655;
    }
    paramArrayOfVariantWrapper = new StringBuilder();
    paramArrayOfVariantWrapper.append("QQ.ReportEx, invalid report data, data=");
    paramArrayOfVariantWrapper.append(paramString);
    QLog.i("ArkApp.ArkAppQQModule", 1, paramArrayOfVariantWrapper.toString());
    return false;
    if (paramVariantWrapper.equals("Beacon")) {}
    label3503:
    label6905:
    try
    {
      localObject1 = new JSONObject(paramString);
      paramArrayOfVariantWrapper = ((JSONObject)localObject1).getString("appKey");
      paramVariantWrapper = ((JSONObject)localObject1).getString("event");
      l1 = ((JSONObject)localObject1).getLong("elapse");
      l2 = ((JSONObject)localObject1).getLong("size");
      bool1 = ((JSONObject)localObject1).getBoolean("isSuccess");
      bool2 = ((JSONObject)localObject1).getBoolean("reportImmediately");
      localObject1 = ((JSONObject)localObject1).getJSONObject("params");
      QQUserAction.a(paramArrayOfVariantWrapper, paramVariantWrapper, bool1, l1, l2, (HashMap)new Gson().fromJson(((JSONObject)localObject1).toString(), HashMap.class), bool2, true);
    }
    catch (JSONException paramArrayOfVariantWrapper)
    {
      label2815:
      break label2815;
    }
    paramArrayOfVariantWrapper = new StringBuilder();
    paramArrayOfVariantWrapper.append("QQ.ReportEx.Beacon, invalid report data, data=");
    paramArrayOfVariantWrapper.append(paramString);
    QLog.i("ArkApp.ArkAppQQModule", 1, paramArrayOfVariantWrapper.toString());
    return false;
    QLog.i("ArkApp.ArkAppQQModule", 1, "QQ.ReportEx, invalid arguments");
    return false;
    Object localObject1 = "";
    if (paramString.equals("GetVersion"))
    {
      paramArrayOfVariantWrapper = DeviceInfoUtil.c();
      paramString = paramArrayOfVariantWrapper;
      if (TextUtils.isEmpty(paramArrayOfVariantWrapper)) {
        paramString = "8.7.0";
      }
      paramVariantWrapper.SetString(paramString);
      return true;
    }
    if (paramString.equals("Log"))
    {
      if (paramArrayOfVariantWrapper != null) {
        l1 = paramArrayOfVariantWrapper.length;
      } else {
        l1 = 0L;
      }
      if (l1 <= 0L) {
        return true;
      }
      paramString = paramArrayOfVariantWrapper[0];
      i = paramString.GetType();
      j = a(paramArrayOfVariantWrapper, l1);
      if (i == 0)
      {
        QLog.i("ArkApp.QQLog", j, "none");
        return true;
      }
      if (i == 1)
      {
        QLog.i("ArkApp.QQLog", j, "null");
        return true;
      }
      if (i == 2)
      {
        if (paramString.GetBool()) {
          paramString = "true";
        } else {
          paramString = "false";
        }
        QLog.i("ArkApp.QQLog", j, paramString);
        return true;
      }
      if (i == 3)
      {
        QLog.i("ArkApp.QQLog", j, Integer.toString(paramString.GetInt()));
        return true;
      }
      if (i == 4)
      {
        QLog.i("ArkApp.QQLog", j, Double.toString(paramString.GetDouble()));
        return true;
      }
      if (i == 5)
      {
        QLog.i("ArkApp.QQLog", j, paramString.GetString());
        return true;
      }
      if (paramString.IsFunction())
      {
        QLog.i("ArkApp.QQLog", j, "Function Object");
        return true;
      }
      if (paramString.IsUserObject())
      {
        QLog.i("ArkApp.QQLog", j, "User Object");
        return true;
      }
      if ((!paramString.IsArray()) && (!paramString.IsTable()))
      {
        QLog.i("ArkApp.QQLog", j, "Unknown Object");
        return true;
      }
      QLog.i("ArkApp.QQLog", j, paramString.GetTableAsJsonString());
      return true;
    }
    if (paramString.equals("GetNickName"))
    {
      localObject2 = a();
      if (paramArrayOfVariantWrapper != null) {
        l1 = paramArrayOfVariantWrapper.length;
      } else {
        l1 = 0L;
      }
      if (l1 == 1L) {
        paramString = paramArrayOfVariantWrapper[0].GetString();
      } else if ((l1 == 0L) && (localObject2 != null)) {
        paramString = ((QQAppInterface)localObject2).getCurrentAccountUin();
      } else {
        paramString = null;
      }
      if (localObject2 != null)
      {
        if (!TextUtils.isEmpty(paramString))
        {
          if (!TextUtils.isEmpty(ArkAppContainer.jdField_a_of_type_JavaLangString)) {
            localObject1 = ContactUtils.b((AppInterface)localObject2, ArkAppContainer.jdField_a_of_type_JavaLangString, paramString);
          } else {
            localObject1 = null;
          }
          if (localObject1 != null)
          {
            paramArrayOfVariantWrapper = (ark.VariantWrapper[])localObject1;
            if (!TextUtils.equals((CharSequence)localObject1, paramString)) {}
          }
          else
          {
            localObject1 = ContactUtils.g((AppInterface)localObject2, paramString);
            paramArrayOfVariantWrapper = (ark.VariantWrapper[])localObject1;
            if (TextUtils.isEmpty((CharSequence)localObject1)) {
              paramArrayOfVariantWrapper = ContactUtils.a((AppInterface)localObject2, paramString, 0);
            }
          }
          paramVariantWrapper.SetString(paramArrayOfVariantWrapper);
          if (paramArrayOfVariantWrapper != null) {
            Log.d("ark.GetNickName ", paramArrayOfVariantWrapper);
          }
        }
        return true;
      }
      paramString = ArkQQAPIIPCModule.a(paramString);
      paramArrayOfVariantWrapper = new StringBuilder();
      paramArrayOfVariantWrapper.append("QQ.GetNickname, ipc call, nickname=");
      paramArrayOfVariantWrapper.append(paramString);
      QLog.i("ArkApp.ArkAppQQModule", 1, paramArrayOfVariantWrapper.toString());
      paramVariantWrapper.SetString(paramString);
      return true;
    }
    if (paramString.equals("GetContainerInfo"))
    {
      localObject1 = new HashMap();
      if ((paramArrayOfVariantWrapper != null) && (paramArrayOfVariantWrapper.length >= 1) && (paramArrayOfVariantWrapper[0].IsView()))
      {
        l1 = paramArrayOfVariantWrapper[0].GetView();
        if (l1 != 0L)
        {
          paramString = ark.arkGetContainer(l1);
          if (paramString != null)
          {
            paramString = (ArkAppContainer)ArkAppContainer.a(paramString).get();
            if ((paramString != null) && ((paramString instanceof ArkAioContainerWrapper))) {
              paramArrayOfVariantWrapper = ((ArkAioContainerWrapper)paramString).a();
            } else {
              paramArrayOfVariantWrapper = null;
            }
            paramString = paramArrayOfVariantWrapper;
            if (paramArrayOfVariantWrapper != null) {
              break label3503;
            }
            paramString = a();
            break label3503;
          }
        }
        paramString = null;
        if (QLog.isColorLevel()) {
          QLog.d("ArkApp.ArkAppQQModule", 2, new Object[] { "multiAio.ArkAppModuleReg GetContainerInfo Extra ViewID viewHandle=", Long.valueOf(l1), a(paramString) });
        }
      }
      else
      {
        paramArrayOfVariantWrapper = a();
        paramString = paramArrayOfVariantWrapper;
        if (QLog.isColorLevel())
        {
          QLog.d("ArkApp.ArkAppQQModule", 2, new Object[] { "multiAio.ArkAppModuleReg GetContainerInfo, ", a(paramArrayOfVariantWrapper) });
          paramString = paramArrayOfVariantWrapper;
        }
      }
      if (paramString != null)
      {
        ((HashMap)localObject1).put("ChatUIN", paramString.jdField_a_of_type_JavaLangString);
        paramArrayOfVariantWrapper = String.format("%d", new Object[] { Integer.valueOf(-1) });
        i = paramString.jdField_a_of_type_Int;
        if (i != 0)
        {
          if (i != 1)
          {
            if (i != 2)
            {
              if (i != 1004)
              {
                if (i != 1008)
                {
                  if (i != 3000) {
                    paramString = paramArrayOfVariantWrapper;
                  } else {
                    paramString = String.format("%d", new Object[] { Integer.valueOf(4) });
                  }
                }
                else {
                  paramString = String.format("%d", new Object[] { Integer.valueOf(1) });
                }
              }
              else {
                paramString = String.format("%d", new Object[] { Integer.valueOf(6) });
              }
            }
            else {
              paramString = String.format("%d", new Object[] { Integer.valueOf(5) });
            }
          }
          else
          {
            if (!TextUtils.isEmpty(paramString.jdField_a_of_type_JavaLangString))
            {
              if (AnonymousChatHelper.a().a(paramString.jdField_a_of_type_JavaLangString)) {
                paramString = "1";
              } else {
                paramString = "0";
              }
              ((HashMap)localObject1).put("AnonymousStatus", paramString);
            }
            paramString = String.format("%d", new Object[] { Integer.valueOf(3) });
          }
        }
        else {
          paramString = String.format("%d", new Object[] { Integer.valueOf(2) });
        }
        ((HashMap)localObject1).put("ChatType", paramString);
      }
      paramVariantWrapper.SetMap((Map)localObject1);
      return true;
    }
    if (paramString.equals("DataRequest"))
    {
      paramVariantWrapper.CreateObject("DataRequest", new ArkDataRequestObj(a(), this.jdField_b_of_type_JavaLangString));
      return true;
    }
    if (paramString.equals("GetPerformance"))
    {
      if ((paramArrayOfVariantWrapper != null) && (paramArrayOfVariantWrapper.length >= 1))
      {
        paramArrayOfVariantWrapper = paramArrayOfVariantWrapper[0].GetString();
        if (!TextUtils.isEmpty(paramArrayOfVariantWrapper))
        {
          paramString = ArkAioContainerWrapper.a(paramArrayOfVariantWrapper);
          if ((paramString != null) && (paramString.arkContainer != null))
          {
            paramString = paramString.arkContainer.jdField_a_of_type_ComTencentArkOpenArkAppInfo$TimeRecord;
            if (paramString == null)
            {
              QLog.i("ArkApp.ArkAppQQModule", 1, String.format("QQ.GetPerformance, timeRecord is null, viewID=%s", new Object[] { paramArrayOfVariantWrapper }));
            }
            else
            {
              try
              {
                paramArrayOfVariantWrapper = new JSONObject();
                localObject1 = new JSONObject();
                paramArrayOfVariantWrapper.put("Timing", localObject1);
                l1 = paramString.beginOfGetApp;
                d = l1;
                Double.isNaN(d);
                ((JSONObject)localObject1).put("GetApplicationStart", d + 0.01D);
                l1 = paramString.endOfGetApp;
                d = l1;
                Double.isNaN(d);
                ((JSONObject)localObject1).put("GetApplicationEnd", d + 0.01D);
                l1 = paramString.beginOfGetApp;
                d = l1;
                Double.isNaN(d);
                ((JSONObject)localObject1).put("FetchApplicationStart", d + 0.01D);
                l1 = paramString.endOfGetApp;
                d = l1;
                Double.isNaN(d);
                ((JSONObject)localObject1).put("FetchApplicationEnd", d + 0.01D);
                l1 = paramString.mRecord.beginOfCreateView;
                d = l1;
                Double.isNaN(d);
                ((JSONObject)localObject1).put("CreateViewStart", d + 0.01D);
                l1 = paramString.mRecord.endOfCreateView;
                d = l1;
                Double.isNaN(d);
                ((JSONObject)localObject1).put("CreateViewEnd", d + 0.01D);
                l1 = paramString.mRecord.beginOfDisplyView;
                d = l1;
                Double.isNaN(d);
                ((JSONObject)localObject1).put("DisplayViewStart", d + 0.01D);
                l1 = paramString.mRecord.endOfDisplyView;
                d = l1;
                Double.isNaN(d);
                ((JSONObject)localObject1).put("DisplayViewEnd", d + 0.01D);
                localObject1 = new JSONObject();
                paramArrayOfVariantWrapper.put("Navigation", localObject1);
                if (!paramString.getAppFromLocal) {
                  break label8411;
                }
                i = 1;
                ((JSONObject)localObject1).put("FetchApplicationFromCache", i);
                paramString = paramArrayOfVariantWrapper.toString();
              }
              catch (Exception paramString)
              {
                QLog.i("ArkApp.ArkAppQQModule", 1, String.format("QQ.GetPerformance, json exception, msg=%s", new Object[] { paramString.getMessage() }));
                paramString = null;
              }
              if (!TextUtils.isEmpty(paramString))
              {
                paramVariantWrapper.SetTableAsJsonString(paramString);
                return true;
              }
            }
          }
          else
          {
            QLog.i("ArkApp.ArkAppQQModule", 1, String.format("QQ.GetPerformance, arkAppMsg is null, viewID=%s", new Object[] { paramArrayOfVariantWrapper }));
          }
        }
      }
      paramVariantWrapper.SetNull();
      return true;
    }
    else
    {
      if (paramString.equals("GetCurrentPosition"))
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqArkComponentArkAppLocationManager != null) && (paramArrayOfVariantWrapper != null) && (paramArrayOfVariantWrapper.length >= 1) && (paramArrayOfVariantWrapper[0] != null) && (paramArrayOfVariantWrapper[0].IsFunction()))
        {
          if (QLog.isColorLevel()) {
            QLog.i("ArkApp.ArkAppQQModule", 2, String.format("GetCurrentPosition.app.%s", new Object[] { this.jdField_b_of_type_JavaLangString }));
          }
          l1 = a(paramArrayOfVariantWrapper[0].Copy());
          this.jdField_a_of_type_ComTencentMobileqqArkComponentArkAppLocationManager.b(new ArkAppQQModule.1(this, l1));
          return true;
        }
        return false;
      }
      if (paramString.equals("WatchPosition"))
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqArkComponentArkAppLocationManager != null) && (paramArrayOfVariantWrapper != null) && (paramArrayOfVariantWrapper.length >= 1) && (paramArrayOfVariantWrapper[0] != null))
        {
          if (!paramArrayOfVariantWrapper[0].IsFunction()) {
            return false;
          }
          if (QLog.isColorLevel()) {
            QLog.i("ArkApp.ArkAppQQModule", 2, String.format("WatchPosition.app.%s", new Object[] { this.jdField_b_of_type_JavaLangString }));
          }
          l1 = a(paramArrayOfVariantWrapper[0].Copy());
          this.jdField_a_of_type_ComTencentMobileqqArkComponentArkAppLocationManager.a(new ArkAppQQModule.2(this, l1));
          return true;
        }
        return false;
      }
      if (paramString.equals("ClearWatch"))
      {
        paramString = this.jdField_a_of_type_ComTencentMobileqqArkComponentArkAppLocationManager;
        if (paramString == null) {
          return false;
        }
        paramString.b();
        return true;
      }
      if (paramString.equals("GetCurrentAddress"))
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqArkComponentArkAppLocationManager != null) && (paramArrayOfVariantWrapper != null) && (paramArrayOfVariantWrapper.length >= 1) && (paramArrayOfVariantWrapper[0] != null))
        {
          if (!paramArrayOfVariantWrapper[0].IsFunction()) {
            return false;
          }
          l1 = a(paramArrayOfVariantWrapper[0].Copy());
          this.jdField_a_of_type_ComTencentMobileqqArkComponentArkAppLocationManager.a(new ArkAppQQModule.3(this, l1), true);
          return true;
        }
        return false;
      }
      if (paramString.equals("SendMessage"))
      {
        if ((paramArrayOfVariantWrapper != null) && (paramArrayOfVariantWrapper.length >= 1) && ((paramArrayOfVariantWrapper[0].IsArray()) || (paramArrayOfVariantWrapper[0].IsTable())))
        {
          localObject1 = paramArrayOfVariantWrapper[0].GetTableAsJsonString();
          try
          {
            paramVariantWrapper = new JSONObject((String)localObject1);
            if ((paramArrayOfVariantWrapper.length <= 1) || (paramArrayOfVariantWrapper[1].GetType() != 2)) {
              break label8417;
            }
            bool1 = paramArrayOfVariantWrapper[1].GetBool();
            if ((paramArrayOfVariantWrapper.length >= 3) && (paramArrayOfVariantWrapper[2].IsView()))
            {
              l1 = paramArrayOfVariantWrapper[2].GetView();
              if (l1 == 0L) {
                break label8423;
              }
              paramString = ark.arkGetContainer(l1);
              if (paramString == null) {
                break label8423;
              }
              paramString = (ArkAppContainer)ArkAppContainer.a(paramString).get();
              if ((paramString == null) || (!(paramString instanceof ArkAioContainerWrapper))) {
                break label8423;
              }
              paramArrayOfVariantWrapper = ((ArkAioContainerWrapper)paramString).a();
              paramString = paramArrayOfVariantWrapper;
              if (paramArrayOfVariantWrapper == null) {
                paramString = a();
              }
              paramArrayOfVariantWrapper = paramString;
              if (QLog.isColorLevel())
              {
                QLog.d("ArkApp.ArkAppQQModule", 2, new Object[] { "multiAio.ArkAppModuleReg SendMessage Extra viewid viewHandle=", Long.valueOf(l1), a(paramString) });
                paramArrayOfVariantWrapper = paramString;
              }
            }
            else
            {
              paramString = a();
              paramArrayOfVariantWrapper = paramString;
              if (QLog.isColorLevel())
              {
                QLog.d("ArkApp.ArkAppQQModule", 2, new Object[] { "multiAio.ArkAppModuleReg SendMessage old,sessionInfo=", a(paramString) });
                paramArrayOfVariantWrapper = paramString;
              }
            }
            if (paramVariantWrapper.has("light"))
            {
              localObject2 = new ArkAppMessage();
              ((ArkAppMessage)localObject2).appMinVersion = "0.0.0.1";
              paramString = paramVariantWrapper.getJSONObject("light");
              ((ArkAppMessage)localObject2).appName = paramString.getString("Application");
              if (TextUtils.isEmpty(((ArkAppMessage)localObject2).appName)) {
                return false;
              }
              ((ArkAppMessage)localObject2).appView = paramString.getString("View");
              if (TextUtils.isEmpty(((ArkAppMessage)localObject2).appView)) {
                return false;
              }
              paramVariantWrapper = ArkAppCacheMgr.getApplicationFromManifest(((ArkAppMessage)localObject2).appName, ((ArkAppMessage)localObject2).appMinVersion);
              if (paramVariantWrapper != null)
              {
                ((ArkAppMessage)localObject2).appDesc = ((String)paramVariantWrapper.get("desc"));
                ((ArkAppMessage)localObject2).appMinVersion = ((String)paramVariantWrapper.get("version"));
              }
              if (TextUtils.isEmpty(((ArkAppMessage)localObject2).appDesc)) {
                ((ArkAppMessage)localObject2).appDesc = ((ArkAppMessage)localObject2).appName;
              }
              ((ArkAppMessage)localObject2).promptText = paramString.optString("Prompt");
              if (TextUtils.isEmpty(((ArkAppMessage)localObject2).promptText)) {
                ((ArkAppMessage)localObject2).promptText = String.format(HardCodeUtil.a(2131700865), new Object[] { ((ArkAppMessage)localObject2).appDesc });
              }
              ((ArkAppMessage)localObject2).metaList = paramString.getJSONObject("MetaData").toString();
              paramVariantWrapper = paramString.optJSONObject("Config");
              paramString = paramVariantWrapper;
              if (paramVariantWrapper == null) {
                paramString = new JSONObject();
              }
              paramString.put("forward", 1);
              ((ArkAppMessage)localObject2).config = paramString.toString();
              if (bool1)
              {
                if (paramArrayOfVariantWrapper == null) {
                  break label8428;
                }
                ChatActivityFacade.b(a(), paramArrayOfVariantWrapper, (ArkAppMessage)localObject2);
                if (!QLog.isColorLevel()) {
                  break label8428;
                }
                QLog.i("ArkApp", 1, "multiAio.QQ.SendMessage light currentChat success");
                return true;
              }
              ArkDispatchTask.getInstance().postToMainThread(new ArkAppQQModule.4(this, (ArkAppMessage)localObject2));
              return true;
            }
            if (paramVariantWrapper.has("text"))
            {
              paramVariantWrapper = paramVariantWrapper.getString("text");
              if (bool1)
              {
                paramString = a();
                if ((paramArrayOfVariantWrapper != null) && (paramString != null))
                {
                  paramArrayOfVariantWrapper = MessageRecordFactory.a(a(), a().getCurrentUin(), paramArrayOfVariantWrapper.jdField_a_of_type_JavaLangString, paramArrayOfVariantWrapper.jdField_b_of_type_JavaLangString, paramArrayOfVariantWrapper.jdField_a_of_type_Int, (byte)1, (byte)0, (short)0, paramVariantWrapper);
                  paramString.getMessageFacade().a(paramArrayOfVariantWrapper, null);
                  if (QLog.isColorLevel())
                  {
                    QLog.i("ArkApp", 1, "multiAio.QQ.SendMessage text currentChat success");
                    return true;
                  }
                }
              }
              else
              {
                ArkDispatchTask.getInstance().postToMainThread(new ArkAppQQModule.5(this, paramVariantWrapper));
              }
              return true;
            }
          }
          catch (JSONException paramString)
          {
            if (QLog.isColorLevel())
            {
              paramArrayOfVariantWrapper = new StringBuilder();
              paramArrayOfVariantWrapper.append("multiAio.QQ.SendMessage parameter error: ");
              paramArrayOfVariantWrapper.append(paramString.getMessage());
              QLog.i("ArkApp", 1, paramArrayOfVariantWrapper.toString());
            }
            if (QLog.isColorLevel())
            {
              QLog.i("ArkApp", 1, String.format("multiAio.QQ.SendMessage fail, packet:%s", new Object[] { localObject1 }));
              return false;
            }
            return false;
          }
        }
        return false;
      }
      if (paramString.equals("GetPskeyAsync"))
      {
        if ((paramArrayOfVariantWrapper != null) && (paramArrayOfVariantWrapper.length >= 2) && (paramArrayOfVariantWrapper[0].IsString()) && (paramArrayOfVariantWrapper[1].IsFunction()))
        {
          ArkQQAPIIPCModule.a(paramArrayOfVariantWrapper[0].GetString(), new ArkAppQQModule.6(this, a(paramArrayOfVariantWrapper[1].Copy())));
          return true;
        }
        QLog.e("ArkApp.ArkAppQQModule", 1, "GetPskeyAsync.param error");
        return false;
      }
      if (paramString.equals("Login"))
      {
        if (!ArkAPIPermission.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentArkArk$Application, "permission.LOGIN"))
        {
          QLog.e("ArkApp.ArkAppQQModule", 1, "Login.permission not allow");
          return false;
        }
        if ((paramArrayOfVariantWrapper != null) && (paramArrayOfVariantWrapper.length >= 2) && (paramArrayOfVariantWrapper[0].IsString()) && (paramArrayOfVariantWrapper[1].IsFunction())) {
          try
          {
            l1 = Long.parseLong(paramArrayOfVariantWrapper[0].GetString());
            paramString = a();
            if (paramString == null) {
              paramString = null;
            } else {
              paramString = paramString.getCurrentAccountUin();
            }
            l2 = a(paramArrayOfVariantWrapper[1].Copy());
            ((IArkModuleAPIAuthority)QRoute.api(IArkModuleAPIAuthority.class)).showAuthDialog(paramString, this.jdField_b_of_type_JavaLangString, "ark_authority_api_login", BaseApplicationImpl.getContext().getString(2131690127), new ArkAppQQModule.7(this, l2, paramString, l1));
            return true;
          }
          catch (NumberFormatException paramString)
          {
            paramArrayOfVariantWrapper = new StringBuilder();
            paramArrayOfVariantWrapper.append("Login.Exception:");
            paramArrayOfVariantWrapper.append(paramString.getMessage());
            QLog.e("ArkApp.ArkAppQQModule", 1, paramArrayOfVariantWrapper.toString());
            return false;
          }
        }
        QLog.e("ArkApp.ArkAppQQModule", 1, "Login.param error");
        return false;
      }
      if (paramString.equals("GetUserInformation"))
      {
        if (!ArkAPIPermission.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentArkArk$Application, "permission.USER_INFORMATION"))
        {
          QLog.e("ArkApp.ArkAppQQModule", 1, "GetUserInformation.permission not allow");
          return false;
        }
        if ((paramArrayOfVariantWrapper != null) && (paramArrayOfVariantWrapper.length >= 1) && (paramArrayOfVariantWrapper[0].IsFunction()))
        {
          if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))
          {
            paramString = new StringBuilder();
            paramString.append("GetUserInformation.error app is null, app=");
            paramString.append(this.jdField_b_of_type_JavaLangString);
            QLog.e("ArkApp.ArkAppQQModule", 1, paramString.toString());
            return false;
          }
          l1 = a(paramArrayOfVariantWrapper[0].Copy());
          paramString = a();
          if (paramString != null) {
            paramString = paramString.getCurrentUin();
          } else {
            paramString = null;
          }
          ((IArkModuleAPIAuthority)QRoute.api(IArkModuleAPIAuthority.class)).showAuthDialog(paramString, this.jdField_b_of_type_JavaLangString, "ark_authority_api_user_info", BaseApplicationImpl.getContext().getString(2131690128), new ArkAppQQModule.8(this, l1, paramString));
          return true;
        }
        QLog.e("ArkApp.ArkAppQQModule", 1, "GetUserInformation.param error");
        return false;
      }
      if (paramString.equals("TestGetJson")) {
        return paramVariantWrapper.SetTableAsJsonString("{ \"ret\":0, \"msg\":\"ok\", \"data\":{ \"param_array\": [ 3.1400000000000001, true, \"hello\", { \"param10\": 10, \"param11\": 10.1, \"param12\": true, \"param13\": \"hello 10\" }, { }, 1 ], \"param_bool_false\": false, \"param_bool_true\": true, \"param_double\": 3.1400000000000001, \"param_int\": 0, \"param_int2\": -1, \"param_int3\": 1001, \"param_str_empty\": \"\", \"param_str_hello\": \"hello\", \"param_table\": { \"param1\": 0, \"param2\": 3.1400000000000001, \"param3\": true, \"param4\": \"hello\", \"param5\": { }, \"param6\": { \"param10\": 10, \"param11\": 10.1, \"param12\": true, \"param13\": \"hello 10\" }, \"param7\": \"\" } }}");
      }
      if (paramString.equals("OpenView"))
      {
        if (!ArkAPIPermission.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentArkArk$Application, "permission.OPENVIEW")) {
          return false;
        }
        if ((paramArrayOfVariantWrapper != null) && (paramArrayOfVariantWrapper.length >= 4) && (paramArrayOfVariantWrapper[0].IsView()) && (paramArrayOfVariantWrapper[1].IsString()) && (paramArrayOfVariantWrapper[2].IsString()) && ((paramArrayOfVariantWrapper[3].IsArray()) || (paramArrayOfVariantWrapper[3].IsTable())))
        {
          l1 = paramArrayOfVariantWrapper[0].GetView();
          paramString = paramArrayOfVariantWrapper[1].GetString();
          paramVariantWrapper = paramArrayOfVariantWrapper[2].GetString();
          paramArrayOfVariantWrapper = paramArrayOfVariantWrapper[3].GetTableAsJsonString();
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("OpenView holder=");
          ((StringBuilder)localObject1).append(l1);
          ((StringBuilder)localObject1).append(", type=");
          ((StringBuilder)localObject1).append(paramString);
          ((StringBuilder)localObject1).append(", view=");
          ((StringBuilder)localObject1).append(paramVariantWrapper);
          ((StringBuilder)localObject1).append(", meta=");
          ((StringBuilder)localObject1).append(paramArrayOfVariantWrapper);
          QLog.d("ArkOpenView", 1, ((StringBuilder)localObject1).toString());
          ArkDispatchTask.getInstance().postToMainThread(new ArkAppQQModule.9(this, paramString, paramVariantWrapper, paramArrayOfVariantWrapper, l1));
        }
        return true;
      }
      if (paramString.equals("CloseView"))
      {
        if (!ArkAPIPermission.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentArkArk$Application, "permission.OPENVIEW")) {
          return false;
        }
        if ((paramArrayOfVariantWrapper != null) && (paramArrayOfVariantWrapper.length >= 1) && (paramArrayOfVariantWrapper[0].IsView()))
        {
          l1 = paramArrayOfVariantWrapper[0].GetView();
          ArkDispatchTask.getInstance().postToMainThread(new ArkAppQQModule.10(this, l1));
        }
        return true;
      }
      if (paramString.equals("ShareView"))
      {
        if (!ArkAPIPermission.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentArkArk$Application, "permission.SHARE")) {
          return false;
        }
        if ((paramArrayOfVariantWrapper != null) && (paramArrayOfVariantWrapper.length >= 2) && (paramArrayOfVariantWrapper[0].IsString()) && ((paramArrayOfVariantWrapper[1].IsArray()) || (paramArrayOfVariantWrapper[1].IsTable())))
        {
          paramString = paramArrayOfVariantWrapper[0].GetString();
          paramVariantWrapper = paramArrayOfVariantWrapper[1].GetTableAsJsonString();
          paramArrayOfVariantWrapper = a(paramArrayOfVariantWrapper);
          ArkDispatchTask.getInstance().postToMainThread(new ArkAppQQModule.11(this, paramString, paramVariantWrapper, paramArrayOfVariantWrapper));
        }
        return true;
      }
      if (paramString.equals("ShowStatusBar"))
      {
        if (!ArkAPIPermission.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentArkArk$Application, "permission.STATUSBAR")) {
          return false;
        }
        if ((paramArrayOfVariantWrapper != null) && (paramArrayOfVariantWrapper.length >= 2) && (paramArrayOfVariantWrapper[0].IsView()) && (paramArrayOfVariantWrapper[1].IsString()))
        {
          l1 = paramArrayOfVariantWrapper[0].GetView();
          paramString = paramArrayOfVariantWrapper[1].GetString();
          ArkDispatchTask.getInstance().postToMainThread(new ArkAppQQModule.12(this, l1, paramString));
        }
        return true;
      }
      if (paramString.equals("HideStatusBar"))
      {
        if (!ArkAPIPermission.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentArkArk$Application, "permission.STATUSBAR")) {
          return false;
        }
        if ((paramArrayOfVariantWrapper != null) && (paramArrayOfVariantWrapper.length >= 1) && (paramArrayOfVariantWrapper[0].IsView()))
        {
          l1 = paramArrayOfVariantWrapper[0].GetView();
          ArkDispatchTask.getInstance().postToMainThread(new ArkAppQQModule.13(this, l1));
        }
        return true;
      }
      if (paramString.equals("SetNavigationBarTitle"))
      {
        if ((paramArrayOfVariantWrapper != null) && (paramArrayOfVariantWrapper.length >= 2) && (paramArrayOfVariantWrapper[0].IsView()) && (paramArrayOfVariantWrapper[1].IsString()))
        {
          l1 = paramArrayOfVariantWrapper[0].GetView();
          paramString = paramArrayOfVariantWrapper[1].GetString();
          ArkDispatchTask.getInstance().postToMainThread(new ArkAppQQModule.14(this, l1, paramString));
        }
        return true;
      }
      if (paramString.equals("ShowShareMenu"))
      {
        if ((paramArrayOfVariantWrapper != null) && (paramArrayOfVariantWrapper.length >= 1) && (paramArrayOfVariantWrapper[0].IsView()))
        {
          l1 = paramArrayOfVariantWrapper[0].GetView();
          ArkDispatchTask.getInstance().postToMainThread(new ArkAppQQModule.15(this, l1));
        }
        return true;
      }
      if (paramString.equals("HideShareMenu"))
      {
        if ((paramArrayOfVariantWrapper != null) && (paramArrayOfVariantWrapper.length >= 1) && (paramArrayOfVariantWrapper[0].IsView()))
        {
          l1 = paramArrayOfVariantWrapper[0].GetView();
          ArkDispatchTask.getInstance().postToMainThread(new ArkAppQQModule.16(this, l1));
        }
        return true;
      }
      if (paramString.equals("PreviewImage"))
      {
        if ((paramArrayOfVariantWrapper != null) && (paramArrayOfVariantWrapper.length >= 2) && ((paramArrayOfVariantWrapper[0].IsArray()) || (paramArrayOfVariantWrapper[0].IsTable())) && (paramArrayOfVariantWrapper[1].GetType() == 4))
        {
          paramString = paramArrayOfVariantWrapper[0].GetTableAsJsonString();
          localObject1 = new ArrayList();
          try
          {
            localObject2 = new JSONArray(paramString);
            i = 0;
            while (i < ((JSONArray)localObject2).length())
            {
              paramVariantWrapper = ((JSONArray)localObject2).optString(i);
              if (!TextUtils.isEmpty(paramVariantWrapper))
              {
                paramString = paramVariantWrapper;
                if (!paramVariantWrapper.startsWith("http://"))
                {
                  paramString = paramVariantWrapper;
                  if (!paramVariantWrapper.startsWith("https://"))
                  {
                    paramVariantWrapper = this.jdField_a_of_type_ComTencentArkArk$Application.GetSystemPathFromLocal(paramVariantWrapper);
                    paramString = paramVariantWrapper;
                    if (TextUtils.isEmpty(paramVariantWrapper)) {
                      break label6905;
                    }
                  }
                }
                ((ArrayList)localObject1).add(paramString);
              }
              i += 1;
            }
            i = (int)Math.round(paramArrayOfVariantWrapper[1].GetDouble());
            ArkDispatchTask.getInstance().postToMainThread(new ArkAppQQModule.17(this, i, (ArrayList)localObject1));
            return true;
          }
          catch (JSONException paramString)
          {
            if (QLog.isColorLevel())
            {
              paramArrayOfVariantWrapper = new StringBuilder();
              paramArrayOfVariantWrapper.append("QQ.PreviewImage parameter error: ");
              paramArrayOfVariantWrapper.append(paramString.getMessage());
              QLog.i("ArkApp", 1, paramArrayOfVariantWrapper.toString());
            }
          }
        }
        return true;
      }
      if (paramString.equals("Notify"))
      {
        if ((paramArrayOfVariantWrapper != null) && (paramArrayOfVariantWrapper.length >= 3))
        {
          paramString = paramArrayOfVariantWrapper[0].GetString();
          localObject1 = paramArrayOfVariantWrapper[1].GetString();
          paramArrayOfVariantWrapper = paramArrayOfVariantWrapper[2].GetTableAsJsonString();
          paramVariantWrapper.SetBool(((IArkAPIService)QRoute.api(IArkAPIService.class)).dispatchAppNotification(paramString, (String)localObject1, paramArrayOfVariantWrapper));
        }
        return true;
      }
      if (paramString.equals("SetTalkBackText"))
      {
        if ((paramArrayOfVariantWrapper != null) && (paramArrayOfVariantWrapper.length >= 2) && (paramArrayOfVariantWrapper[0].IsString()) && (paramArrayOfVariantWrapper[1].IsView()))
        {
          paramString = paramArrayOfVariantWrapper[0].GetString();
          l1 = paramArrayOfVariantWrapper[1].GetView();
          ArkDispatchTask.getInstance().postToMainThread(new ArkAppQQModule.18(this, l1, paramString));
        }
        return true;
      }
      if (paramString.equals("ChooseImage"))
      {
        if ((paramArrayOfVariantWrapper != null) && (paramArrayOfVariantWrapper.length >= 3))
        {
          l1 = a(paramArrayOfVariantWrapper[2].Copy());
          paramString = paramArrayOfVariantWrapper[1].GetTableAsJsonString();
          paramVariantWrapper = new StringBuilder();
          paramVariantWrapper.append("QQ.ChooseImage :num=");
          paramVariantWrapper.append(paramArrayOfVariantWrapper[0].GetDouble());
          paramVariantWrapper.append(" extraInfo=");
          paramVariantWrapper.append(paramString);
          QLog.i("ArkApp", 1, paramVariantWrapper.toString());
          if (this.jdField_a_of_type_ComTencentArkArk$Application != null) {
            localObject1 = this.jdField_a_of_type_ComTencentArkArk$Application.GetEngineResPath();
          }
          j = (int)paramArrayOfVariantWrapper[0].GetDouble();
          i = j;
          if (j <= 1) {
            i = 1;
          }
          j = i;
          if (i > 9) {
            j = 9;
          }
          try
          {
            if (!TextUtils.isEmpty(paramString)) {
              bool1 = new JSONObject(paramString).optBoolean("compress");
            } else {
              bool1 = false;
            }
            ChooseImageIPCModule.a().a(new ArkAppQQModule.19(this, l1));
            ArkDispatchTask.getInstance().postToMainThread(new ArkAppQQModule.20(this, j, bool1, (String)localObject1));
            return true;
          }
          catch (JSONException paramString)
          {
            QLog.e("ArkApp.ArkAppQQModule", 1, "Error:", paramString);
            return false;
          }
        }
        return true;
      }
      if (paramString.equals("GetAppID"))
      {
        paramVariantWrapper.SetString(String.valueOf(AppSetting.a()));
        return true;
      }
      if (paramString.equals("GetAudioOutputMode"))
      {
        i = ArkQQAPIIPCModule.a();
        paramString = new StringBuilder();
        paramString.append("current audio status:");
        paramString.append(i);
        QLog.i("ArkApp.ArkAppQQModule", 1, paramString.toString());
        paramVariantWrapper.SetInt(i);
        return true;
      }
      if (paramString.equals("IsMute"))
      {
        if ((paramArrayOfVariantWrapper != null) && (paramArrayOfVariantWrapper.length == 1)) {
          bool1 = paramArrayOfVariantWrapper[0].GetBool();
        } else {
          bool1 = false;
        }
        paramString = (AudioManager)BaseApplicationImpl.sApplication.getSystemService("audio");
        if (paramString != null) {
          try
          {
            i = paramString.getStreamVolume(3);
            if (i <= 0) {
              bool2 = true;
            } else {
              bool2 = false;
            }
            if ((bool2) && (bool1))
            {
              l1 = System.currentTimeMillis();
              if ((Math.abs(l1 - jdField_b_of_type_Long) < 120000L) && (l1 > jdField_b_of_type_Long))
              {
                if (QLog.isColorLevel()) {
                  QLog.e("ArkApp.ArkAppQQModule", 2, "IsMute() do not show toast so frequently in 2 min");
                }
              }
              else
              {
                if (QLog.isColorLevel()) {
                  QLog.e("ArkApp.ArkAppQQModule", 2, "IsMute() show toast");
                }
                jdField_b_of_type_Long = l1;
                paramArrayOfVariantWrapper = (ArkPlatformConfigBean)((IArkConfig)QRoute.api(IArkConfig.class)).loadConfig(ArkPlatformConfigBean.class);
                paramString = (String)localObject1;
                if (paramArrayOfVariantWrapper != null)
                {
                  paramString = (String)localObject1;
                  if (paramArrayOfVariantWrapper.a() != null) {
                    paramString = paramArrayOfVariantWrapper.a().jdField_a_of_type_JavaLangString;
                  }
                }
                localObject1 = a();
                paramArrayOfVariantWrapper = paramString;
                if (TextUtils.isEmpty(paramString))
                {
                  paramArrayOfVariantWrapper = paramString;
                  if (localObject1 != null) {
                    paramArrayOfVariantWrapper = ((Activity)localObject1).getString(2131690167);
                  }
                }
                ArkDispatchTask.getInstance().postToMainThread(new ArkAppQQModule.21(this, (Activity)localObject1, paramArrayOfVariantWrapper));
              }
            }
            paramVariantWrapper.SetBool(bool2);
            return true;
          }
          catch (Exception paramString)
          {
            QLog.e("ArkApp.ArkAppQQModule", 1, "IsMute() error:", paramString);
            return false;
          }
        }
        return false;
      }
      if (paramString.equals("GetNickNameByView"))
      {
        if (paramArrayOfVariantWrapper != null) {
          l1 = paramArrayOfVariantWrapper.length;
        } else {
          l1 = 0L;
        }
        if (l1 <= 0L)
        {
          QLog.d("ArkApp.ArkAppQQModule", 1, "ark.GetNickNameByView invalid param args == 0 ");
          return false;
        }
        if ((l1 >= 1L) && (paramArrayOfVariantWrapper[0].IsView())) {
          l2 = paramArrayOfVariantWrapper[0].GetView();
        } else {
          l2 = 0L;
        }
        if ((l1 >= 2L) && (paramArrayOfVariantWrapper[1].IsString())) {
          paramString = paramArrayOfVariantWrapper[1].GetString();
        } else {
          paramString = null;
        }
        localObject2 = a();
        if (localObject2 != null)
        {
          localObject1 = paramString;
          if (TextUtils.isEmpty(paramString)) {
            localObject1 = ((QQAppInterface)localObject2).getCurrentAccountUin();
          }
          if (l2 != 0L)
          {
            paramString = ark.arkGetContainer(l2);
            if (paramString != null)
            {
              paramString = (ArkAppContainer)ArkAppContainer.a(paramString).get();
              if ((paramString instanceof ArkAioContainerWrapper))
              {
                paramString = ((ArkAioContainerWrapper)paramString).a();
                break label7881;
              }
            }
            paramString = null;
            label7881:
            paramArrayOfVariantWrapper = paramString;
            if (paramString == null) {
              paramArrayOfVariantWrapper = a();
            }
            if (QLog.isColorLevel()) {
              QLog.d("ArkApp.ArkAppQQModule", 2, new Object[] { "ark.GetNickNameByView Extra ViewID viewHandle=", Long.valueOf(l2), a(paramArrayOfVariantWrapper) });
            }
          }
          else
          {
            paramString = a();
            paramArrayOfVariantWrapper = paramString;
            if (QLog.isColorLevel())
            {
              QLog.d("ArkApp.ArkAppQQModule", 2, new Object[] { "ark.GetNickNameByView old, ", a(paramString) });
              paramArrayOfVariantWrapper = paramString;
            }
          }
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            if (paramArrayOfVariantWrapper != null) {
              paramArrayOfVariantWrapper = ContactUtils.a((QQAppInterface)localObject2, paramArrayOfVariantWrapper, ((String)localObject1).equals(((QQAppInterface)localObject2).getCurrentUin()), (String)localObject1);
            } else {
              paramArrayOfVariantWrapper = null;
            }
            if (paramArrayOfVariantWrapper != null)
            {
              paramString = paramArrayOfVariantWrapper;
              if (!TextUtils.equals(paramArrayOfVariantWrapper, (CharSequence)localObject1)) {}
            }
            else
            {
              paramArrayOfVariantWrapper = ContactUtils.g((AppInterface)localObject2, (String)localObject1);
              paramString = paramArrayOfVariantWrapper;
              if (TextUtils.isEmpty(paramArrayOfVariantWrapper)) {
                paramString = ContactUtils.a((AppInterface)localObject2, (String)localObject1, 0);
              }
            }
            paramVariantWrapper.SetString(paramString);
            if ((paramString != null) && (QLog.isColorLevel())) {
              QLog.d("ArkApp.ArkAppQQModule", 2, new Object[] { "ark.GetNickNameByView ", paramString });
            }
            return true;
          }
          return false;
        }
        QLog.d("ArkApp.ArkAppQQModule", 1, "ark.GetNickNameByView invalid param appInterface == null ");
        paramVariantWrapper.SetString(ArkQQAPIIPCModule.a(paramString, l2));
        return true;
      }
      if (paramString.equals("GetAppInfo"))
      {
        localObject1 = new JSONObject();
        try
        {
          ((JSONObject)localObject1).put("package", BaseApplicationImpl.getApplication().getPackageName());
          ((JSONObject)localObject1).put("name", BaseApplicationImpl.getApplication().getString(2131690092));
          paramArrayOfVariantWrapper = DeviceInfoUtil.c();
          paramString = paramArrayOfVariantWrapper;
          if (TextUtils.isEmpty(paramArrayOfVariantWrapper)) {
            paramString = "8.7.0";
          }
          ((JSONObject)localObject1).put("version", paramString);
        }
        catch (Exception paramString)
        {
          QLog.e("ArkApp.ArkAppQQModule", 1, "ark.GetAppInfo: ", paramString);
        }
        if (QLog.isColorLevel()) {
          QLog.d("ArkApp.ArkAppQQModule", 2, new Object[] { "ark.GetAppInfo: ", ((JSONObject)localObject1).toString() });
        }
        paramVariantWrapper.SetTableAsJsonString(((JSONObject)localObject1).toString());
        return true;
      }
      if (paramString.equals("SubscribePublicAccount")) {
        if ((paramArrayOfVariantWrapper != null) && (paramArrayOfVariantWrapper.length >= 3) && (paramArrayOfVariantWrapper[0].IsString()) && (paramArrayOfVariantWrapper[2].IsFunction())) {
          l1 = a(paramArrayOfVariantWrapper[2].Copy());
        }
      }
    }
    for (;;)
    {
      try
      {
        if (!paramArrayOfVariantWrapper[0].IsString()) {
          break label8430;
        }
        paramString = paramArrayOfVariantWrapper[0].GetString();
        if ((int)paramArrayOfVariantWrapper[1].GetDouble() == 0)
        {
          SubscribeFollowUserUtil.a(BaseApplicationImpl.getContext(), paramString, new ArkAppQQModule.22(this, l1));
          return true;
        }
        SubscribeFollowUserUtil.c(BaseApplicationImpl.getContext(), paramString, new ArkAppQQModule.23(this, l1));
        return true;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        return true;
      }
      return false;
      return false;
      label8411:
      label8417:
      label8423:
      label8428:
      return true;
      label8430:
      paramString = null;
    }
  }
  
  public MessageForArkApp a(AIOContext paramAIOContext, ArkAppContainer paramArkAppContainer)
  {
    if (paramArkAppContainer == null) {
      return null;
    }
    Object localObject;
    Iterator localIterator;
    do
    {
      paramAIOContext = paramAIOContext.a().a().a().iterator();
      while (!localIterator.hasNext())
      {
        do
        {
          do
          {
            if (!paramAIOContext.hasNext()) {
              break;
            }
            localObject = (ChatMessage)paramAIOContext.next();
          } while (!(localObject instanceof MessageForArkApp));
          localObject = (MessageForArkApp)localObject;
          if (((MessageForArkApp)localObject).arkContainer == paramArkAppContainer) {
            return localObject;
          }
        } while (((MessageForArkApp)localObject).mExtendMsgArkAppList == null);
        localIterator = ((MessageForArkApp)localObject).mExtendMsgArkAppList.iterator();
      }
    } while (((MessageForArkApp)localIterator.next()).arkContainer != paramArkAppContainer);
    return localObject;
    return null;
  }
  
  protected void a(long paramLong, boolean paramBoolean, double paramDouble1, double paramDouble2)
  {
    ark.VariantWrapper localVariantWrapper1 = b(paramLong);
    if (localVariantWrapper1 == null) {
      return;
    }
    ark.VariantWrapper localVariantWrapper2 = localVariantWrapper1.Create();
    localVariantWrapper2.SetDouble(paramDouble1);
    ark.VariantWrapper localVariantWrapper3 = localVariantWrapper1.Create();
    localVariantWrapper3.SetDouble(paramDouble2);
    ark.VariantWrapper localVariantWrapper4 = localVariantWrapper1.Create();
    localVariantWrapper4.SetBool(paramBoolean);
    ark.VariantWrapper localVariantWrapper5 = localVariantWrapper1.Create();
    localVariantWrapper1.InvokeDefault(new ark.VariantWrapper[] { localVariantWrapper2, localVariantWrapper3, localVariantWrapper4 }, localVariantWrapper5);
    localVariantWrapper5.Reset();
    localVariantWrapper4.Reset();
    localVariantWrapper2.Reset();
    localVariantWrapper3.Reset();
  }
  
  protected void a(long paramLong, boolean paramBoolean, SosoLbsInfo paramSosoLbsInfo)
  {
    ark.VariantWrapper localVariantWrapper1 = a(paramLong);
    if (localVariantWrapper1 == null) {
      return;
    }
    ark.VariantWrapper localVariantWrapper2 = localVariantWrapper1.Create();
    if (paramSosoLbsInfo != null)
    {
      localObject = LocationSimulator.a();
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        paramSosoLbsInfo.mLocation.city = ((String)localObject);
      }
      localObject = LocationSimulator.a();
      if ((localObject != null) && (localObject.length == 2))
      {
        paramSosoLbsInfo.mLocation.mLat84 = localObject[0];
        paramSosoLbsInfo.mLocation.mLon84 = localObject[1];
      }
      try
      {
        localObject = new JSONObject();
        ((JSONObject)localObject).put("prov", paramSosoLbsInfo.mLocation.province);
        ((JSONObject)localObject).put("city", paramSosoLbsInfo.mLocation.city);
        ((JSONObject)localObject).put("dist", paramSosoLbsInfo.mLocation.district);
        ((JSONObject)localObject).put("road", paramSosoLbsInfo.mLocation.street);
        ((JSONObject)localObject).put("town", paramSosoLbsInfo.mLocation.town);
        ((JSONObject)localObject).put("lat", paramSosoLbsInfo.mLocation.mLat84);
        ((JSONObject)localObject).put("lng", paramSosoLbsInfo.mLocation.mLon84);
        paramSosoLbsInfo = ((JSONObject)localObject).toString();
      }
      catch (JSONException paramSosoLbsInfo)
      {
        QLog.i("ArkApp.ArkAppQQModule", 1, paramSosoLbsInfo.getMessage());
        paramSosoLbsInfo = "{}";
      }
      localVariantWrapper2.SetTableAsJsonString(paramSosoLbsInfo);
    }
    paramSosoLbsInfo = localVariantWrapper1.Create();
    paramSosoLbsInfo.SetBool(paramBoolean);
    Object localObject = localVariantWrapper1.Create();
    localVariantWrapper1.InvokeDefault(new ark.VariantWrapper[] { localVariantWrapper2, paramSosoLbsInfo }, (ark.VariantWrapper)localObject);
    ((ark.VariantWrapper)localObject).Reset();
    paramSosoLbsInfo.Reset();
    localVariantWrapper2.Reset();
    localVariantWrapper1.Reset();
  }
  
  protected void a(long paramLong, boolean paramBoolean, String paramString, int paramInt)
  {
    ark.VariantWrapper localVariantWrapper1 = a(paramLong);
    if (localVariantWrapper1 == null) {
      return;
    }
    ark.VariantWrapper localVariantWrapper2 = localVariantWrapper1.Create();
    try
    {
      localObject = new JSONObject();
      ((JSONObject)localObject).put("uin", paramString);
      ((JSONObject)localObject).put("followState", paramInt);
      localVariantWrapper2.SetTableAsJsonString(((JSONObject)localObject).toString());
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    paramString = localVariantWrapper1.Create();
    paramString.SetBool(paramBoolean);
    Object localObject = localVariantWrapper1.Create();
    localVariantWrapper1.InvokeDefault(new ark.VariantWrapper[] { localVariantWrapper2, paramString }, (ark.VariantWrapper)localObject);
    ((ark.VariantWrapper)localObject).Reset();
    paramString.Reset();
    localVariantWrapper2.Reset();
    localVariantWrapper1.Reset();
  }
  
  public void a(List<ApiFrequencyConfig> paramList)
  {
    super.a(paramList);
    a("OpenUrl", 1L, 500L);
    a("SendMessage", 1L, 500L);
  }
  
  public boolean a()
  {
    return true;
  }
  
  protected ArkModuleMethod[] a()
  {
    return new ArkModuleMethod[] { new ArkAppQQModule.MethodGetUIN(null), new ArkAppQQModule.MethodGetSKey(null), new ArkAppQQModule.MethodGetPSKey(null), new ArkAppQQModule.MethodReplyMessage(null), new ArkAppQQModule.MethodPlaySilkAudio(this, null), new ArkAppQQModule.MethodStopSilkAudio(this, null) };
  }
  
  public boolean b()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.api.module.ArkAppQQModule
 * JD-Core Version:    0.7.0.1
 */