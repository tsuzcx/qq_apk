package com.tencent.mobileqq.ark.api.module;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.tencent.ark.ark.Application;
import com.tencent.ark.ark.VariantWrapper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gamecenter.wadl.biz.entity.WadlParams;
import com.tencent.gamecenter.wadl.biz.entity.WadlResult;
import com.tencent.gamecenter.wadl.biz.listener.WadlProxyServiceCallBackInterface;
import com.tencent.gamecenter.wadl.util.GameCenterUtil;
import com.tencent.gamecenter.wadl.util.WadlProxyServiceUtil;
import com.tencent.gamecenter.wadl.util.WadlProxyServiceWrap;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.ark.api.IArkConfig;
import com.tencent.mobileqq.ark.api.IArkThreadManager;
import com.tencent.mobileqq.ark.config.bean.ArkPlatformConfigBean;
import com.tencent.mobileqq.ark.config.config.ArkPlatformConfig;
import com.tencent.mobileqq.ark.download.ArkDownloadController;
import com.tencent.mobileqq.ark.module.ArkAPIPermission;
import com.tencent.mobileqq.ark.module.ArkModuleMethod;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.FileSizeFormat;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

@KeepClassConstructor
public class ArkAppDownloadModule
  extends ArkAppQQModuleBase
{
  private WadlProxyServiceCallBackInterface jdField_a_of_type_ComTencentGamecenterWadlBizListenerWadlProxyServiceCallBackInterface = new ArkAppDownloadModule.6(this);
  private ArkAppDownloadModule.DownloadStateListener jdField_a_of_type_ComTencentMobileqqArkApiModuleArkAppDownloadModule$DownloadStateListener;
  private ArkAppDownloadModule.QueryPackageStateListener jdField_a_of_type_ComTencentMobileqqArkApiModuleArkAppDownloadModule$QueryPackageStateListener;
  private ArkAppDownloadModule.QueryPackageStateViaListener jdField_a_of_type_ComTencentMobileqqArkApiModuleArkAppDownloadModule$QueryPackageStateViaListener;
  private INetInfoHandler jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler;
  private ArrayList<Long> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private boolean b;
  private boolean c = false;
  
  public ArkAppDownloadModule(ark.Application paramApplication, int paramInt)
  {
    super(paramApplication, paramInt);
    this.jdField_b_of_type_Boolean = false;
    WadlProxyServiceUtil.a().a(this.jdField_a_of_type_ComTencentGamecenterWadlBizListenerWadlProxyServiceCallBackInterface);
    this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler = new ArkAppDownloadModule.7(this);
    paramApplication = BaseActivity.sTopActivity;
    if (paramApplication != null) {
      AppNetConnInfo.registerConnectionChangeReceiver(paramApplication, this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
    }
  }
  
  private int a(Context paramContext, double paramDouble, WadlParams paramWadlParams)
  {
    if (paramContext != null)
    {
      SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("sp_ark_authority", 0);
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("key_download_show_not_wifi_dialog");
      ((StringBuilder)localObject).append(paramWadlParams.jdField_a_of_type_JavaLangString);
      localObject = ((StringBuilder)localObject).toString();
      boolean bool;
      if (localSharedPreferences != null) {
        bool = localSharedPreferences.getBoolean((String)localObject, true);
      } else {
        bool = true;
      }
      if (paramDouble > Utils.b())
      {
        ((IArkThreadManager)QRoute.api(IArkThreadManager.class)).postToMainThread(new ArkAppDownloadModule.9(this, paramContext, paramWadlParams));
        return 2;
      }
      if ((bool) && (NetworkUtil.isNetworkAvailable(paramContext)) && (NetworkUtil.getNetworkType(paramContext) != 1))
      {
        String str1 = String.format(paramContext.getString(2131690154), new Object[] { FileSizeFormat.a(paramDouble) });
        String str2 = paramContext.getString(2131690153);
        ((IArkThreadManager)QRoute.api(IArkThreadManager.class)).postToMainThread(new ArkAppDownloadModule.10(this, paramContext, str1, paramWadlParams, localSharedPreferences, (String)localObject, str2));
        return 2;
      }
    }
    WadlProxyServiceUtil.a().b(paramWadlParams);
    this.c = true;
    return 1;
  }
  
  private String a(int paramInt)
  {
    BaseActivity localBaseActivity = BaseActivity.sTopActivity;
    if (localBaseActivity != null)
    {
      if (paramInt != 1)
      {
        if (paramInt != 3) {
          return localBaseActivity.getString(2131690151);
        }
        return localBaseActivity.getString(2131690150);
      }
      return localBaseActivity.getString(2131690149);
    }
    return "";
  }
  
  private JSONArray a(ArrayList<WadlResult> paramArrayList, String paramString)
  {
    if ((paramArrayList != null) && (paramArrayList.size() != 0))
    {
      JSONArray localJSONArray = new JSONArray();
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        Object localObject = (WadlResult)paramArrayList.next();
        if (localObject != null)
        {
          localObject = a((WadlResult)localObject, paramString);
          if (localObject != null) {
            localJSONArray.put(localObject);
          }
        }
      }
      return localJSONArray;
    }
    return null;
  }
  
  private JSONObject a(WadlParams paramWadlParams, String paramString)
  {
    for (;;)
    {
      try
      {
        localObject = new JSONObject();
        if (paramWadlParams != null)
        {
          ((JSONObject)localObject).put("actionCode", paramWadlParams.jdField_b_of_type_Int);
          ((JSONObject)localObject).put("appId", paramWadlParams.jdField_a_of_type_JavaLangString);
          ((JSONObject)localObject).put("apkUrl", paramWadlParams.jdField_e_of_type_JavaLangString);
          ((JSONObject)localObject).put("apkSign", paramWadlParams.jdField_b_of_type_JavaLangString);
          ((JSONObject)localObject).put("versionCode", paramWadlParams.jdField_e_of_type_Int);
          ((JSONObject)localObject).put("packageName", paramWadlParams.f);
          ((JSONObject)localObject).put("appName", paramWadlParams.j);
          if (paramWadlParams.jdField_b_of_type_Boolean)
          {
            i = 1;
            ((JSONObject)localObject).put("delayDownload", i);
            ((JSONObject)localObject).put("fromWebUrl", paramWadlParams.m);
            ((JSONObject)localObject).put("apkChannel", paramWadlParams.jdField_c_of_type_JavaLangString);
            ((JSONObject)localObject).put("via", paramWadlParams.l);
            ((JSONObject)localObject).put("yyStartTime", paramWadlParams.jdField_a_of_type_Long);
            ((JSONObject)localObject).put("yyEndTime", paramWadlParams.jdField_b_of_type_Long);
            ((JSONObject)localObject).put("adtag", paramWadlParams.n);
            ((JSONObject)localObject).put("from", paramWadlParams.d);
            ((JSONObject)localObject).put("flags", paramWadlParams.jdField_c_of_type_Int);
            ((JSONObject)localObject).put("extraData", paramWadlParams.o);
            ((JSONObject)localObject).put("sourceId", paramWadlParams.p);
          }
        }
        else
        {
          return localObject;
        }
      }
      catch (Exception paramWadlParams)
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append(" parseWadlParams error::");
        QLog.i("ark.download.module", 1, ((StringBuilder)localObject).toString(), paramWadlParams);
        return null;
      }
      int i = 0;
    }
  }
  
  private JSONObject a(WadlResult paramWadlResult, String paramString)
  {
    try
    {
      localObject = new JSONObject();
      if (paramWadlResult == null)
      {
        ((JSONObject)localObject).put("taskStatus", -1);
        ((JSONObject)localObject).put("progress", 0);
        return localObject;
      }
      if (paramWadlResult.jdField_a_of_type_ComTencentGamecenterWadlBizEntityWadlParams != null)
      {
        JSONObject localJSONObject = a(paramWadlResult.jdField_a_of_type_ComTencentGamecenterWadlBizEntityWadlParams, paramString);
        if (localJSONObject != null) {
          ((JSONObject)localObject).put("wadlParams", localJSONObject.toString());
        }
      }
      ((JSONObject)localObject).put("event", paramWadlResult.jdField_a_of_type_Int);
      ((JSONObject)localObject).put("taskId", paramWadlResult.jdField_a_of_type_JavaLangString);
      ((JSONObject)localObject).put("taskStatus", paramWadlResult.jdField_b_of_type_Int);
      ((JSONObject)localObject).put("fileSize", paramWadlResult.jdField_a_of_type_Long);
      ((JSONObject)localObject).put("downloadFileSize", paramWadlResult.jdField_b_of_type_Long);
      ((JSONObject)localObject).put("downloadFilePath", paramWadlResult.jdField_b_of_type_JavaLangString);
      ((JSONObject)localObject).put("createTime", paramWadlResult.jdField_c_of_type_Long);
      ((JSONObject)localObject).put("errCode", GameCenterUtil.b(paramWadlResult.jdField_c_of_type_Int));
      ((JSONObject)localObject).put("progress", paramWadlResult.d);
      return localObject;
    }
    catch (Exception paramWadlResult)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(" parseWadlResult error::");
      QLog.i("ark.download.module", 1, ((StringBuilder)localObject).toString(), paramWadlResult);
    }
    return null;
  }
  
  private boolean b(String paramString)
  {
    try
    {
      ((IArkThreadManager)QRoute.api(IArkThreadManager.class)).postToMainThread(new ArkAppDownloadModule.8(this, paramString));
      return true;
    }
    catch (Exception paramString)
    {
      QLog.i("ark.download.module", 1, " showToast error::", paramString);
    }
    return false;
  }
  
  public void Destruct()
  {
    super.Destruct();
    WadlProxyServiceUtil.a().b(this.jdField_a_of_type_ComTencentGamecenterWadlBizListenerWadlProxyServiceCallBackInterface);
    this.jdField_a_of_type_ComTencentGamecenterWadlBizListenerWadlProxyServiceCallBackInterface = null;
    this.jdField_a_of_type_ComTencentMobileqqArkApiModuleArkAppDownloadModule$QueryPackageStateListener = null;
    this.jdField_a_of_type_ComTencentMobileqqArkApiModuleArkAppDownloadModule$QueryPackageStateViaListener = null;
    AppNetConnInfo.unregisterNetInfoHandler(this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
    this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler = null;
    ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      int i = 0;
      while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        a(((Long)this.jdField_a_of_type_JavaUtilArrayList.get(i)).longValue());
        i += 1;
      }
      this.jdField_a_of_type_JavaUtilArrayList.clear();
    }
  }
  
  public String GetTypeName()
  {
    return "QQDownload";
  }
  
  public boolean HasMethod(String paramString)
  {
    if (paramString.equals("QueryPackageState")) {
      return true;
    }
    if (paramString.equals("QueryPackageStateVia")) {
      return true;
    }
    if (paramString.equals("StartDownload")) {
      return true;
    }
    if (paramString.equals("PauseDownload")) {
      return true;
    }
    if (paramString.equals("ContinueDownload")) {
      return true;
    }
    if (paramString.equals("InstallPackage")) {
      return true;
    }
    if (paramString.equals("DownloadInit")) {
      return true;
    }
    if (paramString.equals("QueryPackageInfo")) {
      return true;
    }
    return paramString.equals("DeletePackage");
  }
  
  public boolean Invoke(String paramString, ark.VariantWrapper[] paramArrayOfVariantWrapper, ark.VariantWrapper paramVariantWrapper)
  {
    if (!ArkAPIPermission.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentArkArk$Application, "permission.DOWNLOAD"))
    {
      QLog.i("ark.download.module", 1, "ark.dctrl.ArkAppDownloadModule.invokeFunc permission denied");
      paramString = BaseActivity.sTopActivity;
      if (paramString != null) {
        b(paramString.getString(2131690155));
      }
      return false;
    }
    QLog.i("ark.download.module", 1, String.format("ark.dctrl.ArkAppDownloadModule.invokeFunc.%s", new Object[] { paramString }));
    boolean bool = paramString.equals("QueryPackageState");
    int i = 2;
    long l;
    if (bool)
    {
      if ((paramArrayOfVariantWrapper != null) && (paramArrayOfVariantWrapper.length >= 2) && (paramArrayOfVariantWrapper[0].IsString()))
      {
        paramString = paramArrayOfVariantWrapper[0].GetString();
        l = a(paramArrayOfVariantWrapper[1].Copy());
        paramArrayOfVariantWrapper = new ArrayList();
        paramArrayOfVariantWrapper.add(paramString);
        QLog.i("ark.download.module", 1, String.format("ark.dctrl.QueryPackageState.appid:%s", new Object[] { Long.valueOf(l) }));
        this.jdField_a_of_type_ComTencentMobileqqArkApiModuleArkAppDownloadModule$QueryPackageStateListener = new ArkAppDownloadModule.1(this, l);
        if (paramArrayOfVariantWrapper.size() > 0) {
          WadlProxyServiceUtil.a().a(paramArrayOfVariantWrapper);
        }
        return true;
      }
      return false;
    }
    if (paramString.equals("QueryPackageInfo")) {
      if ((paramArrayOfVariantWrapper == null) || (paramArrayOfVariantWrapper.length < 1) || (!paramArrayOfVariantWrapper[0].IsString())) {}
    }
    for (;;)
    {
      Object localObject1;
      Object localObject2;
      try
      {
        localObject1 = paramArrayOfVariantWrapper[0].GetString();
        if (QLog.isColorLevel())
        {
          paramString = new StringBuilder();
          paramString.append("QueryPackageInfo pkgName:");
          paramString.append((String)localObject1);
          QLog.i("ark.download.module", 1, paramString.toString());
        }
        paramString = GameCenterUtil.a((String)localObject1);
        if (paramString == null) {
          break label1688;
        }
        i = paramString.versionCode;
        paramString = paramString.versionName;
        paramArrayOfVariantWrapper = GameCenterUtil.b(GameCenterUtil.a((String)localObject1));
        localObject2 = new JSONObject();
        ((JSONObject)localObject2).put("packageName", localObject1);
        ((JSONObject)localObject2).put("versionCode", i);
        ((JSONObject)localObject2).put("versionName", paramString);
        ((JSONObject)localObject2).put("channel", paramArrayOfVariantWrapper);
        if (QLog.isColorLevel())
        {
          paramString = new StringBuilder();
          paramString.append("QueryPackageInfo result:");
          paramString.append(((JSONObject)localObject2).toString());
          QLog.i("ark.download.module", 1, paramString.toString());
        }
        paramVariantWrapper.SetTableAsJsonString(((JSONObject)localObject2).toString());
        return true;
      }
      catch (Throwable paramString)
      {
        paramArrayOfVariantWrapper = new StringBuilder();
        paramArrayOfVariantWrapper.append("QueryPackageInfo result fail:");
        paramArrayOfVariantWrapper.append(paramString.getMessage());
        QLog.i("ark.download.module", 1, paramArrayOfVariantWrapper.toString());
      }
      return false;
      if (paramString.equals("QueryPackageStateVia"))
      {
        if ((paramArrayOfVariantWrapper != null) && (paramArrayOfVariantWrapper.length >= 2) && (paramArrayOfVariantWrapper[0].IsString()))
        {
          paramString = paramArrayOfVariantWrapper[0].GetString();
          QLog.i("ark.download.module", 1, String.format("ark.dctrl.QueryPackageStateVia.via:%s", new Object[] { paramString }));
          this.jdField_a_of_type_ComTencentMobileqqArkApiModuleArkAppDownloadModule$QueryPackageStateViaListener = new ArkAppDownloadModule.2(this, a(paramArrayOfVariantWrapper[1].Copy()));
          if (!TextUtils.isEmpty(paramString)) {
            WadlProxyServiceUtil.a().a(paramString);
          }
          return true;
        }
        return false;
      }
      if (paramString.equals("DownloadInit"))
      {
        if ((paramArrayOfVariantWrapper != null) && (paramArrayOfVariantWrapper.length >= 1))
        {
          l = a(paramArrayOfVariantWrapper[0].Copy());
          paramString = new StringBuilder();
          paramString.append("ark.dctrl.DownloadInit callbackid=");
          paramString.append(l);
          QLog.i("ark.download.module", 1, paramString.toString());
          this.jdField_a_of_type_ComTencentMobileqqArkApiModuleArkAppDownloadModule$DownloadStateListener = new ArkAppDownloadModule.3(this);
          this.jdField_a_of_type_JavaUtilArrayList.add(Long.valueOf(l));
          paramVariantWrapper.SetBool(true);
          return true;
        }
        paramVariantWrapper.SetBool(false);
        return true;
      }
      if (paramString.equals("StartDownload"))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqArkApiModuleArkAppDownloadModule$DownloadStateListener == null)
        {
          QLog.e("ark.download.module", 1, "should DownloadInit first ");
          paramVariantWrapper.SetInt(-1);
          return true;
        }
        paramString = BaseActivity.sTopActivity;
        if ((paramArrayOfVariantWrapper != null) && (paramArrayOfVariantWrapper.length >= 2) && (paramArrayOfVariantWrapper[0].IsString()))
        {
          localObject1 = paramArrayOfVariantWrapper[0].GetString();
          double d = paramArrayOfVariantWrapper[1].GetDouble();
          paramArrayOfVariantWrapper = new WadlParams((String)localObject1);
          if (paramArrayOfVariantWrapper.jdField_b_of_type_Int == 12) {
            ReportController.a(null, "dc00898", "", "", "0X8009E12", "0X8009E12", 0, 0, "", "", paramArrayOfVariantWrapper.jdField_a_of_type_JavaLangString, "");
          } else if (paramArrayOfVariantWrapper.jdField_b_of_type_Int == 2) {
            ReportController.a(null, "dc00898", "", "", "0X8009E11", "0X8009E11", 0, 0, "", "", paramArrayOfVariantWrapper.jdField_a_of_type_JavaLangString, "");
          }
          localObject1 = (ArkPlatformConfigBean)((IArkConfig)QRoute.api(IArkConfig.class)).loadConfig(ArkPlatformConfigBean.class);
          if ((localObject1 != null) && (((ArkPlatformConfigBean)localObject1).a() != null))
          {
            localObject1 = ((ArkPlatformConfigBean)localObject1).a();
            if ((((ArkPlatformConfig)localObject1).c != null) && (((ArkPlatformConfig)localObject1).c.contains(this.jdField_b_of_type_JavaLangString)))
            {
              bool = false;
              break label896;
            }
          }
          bool = true;
          label896:
          QLog.d("ark.download.module", 1, new Object[] { "ark.dctrl [StartDownload] mAppName:", this.jdField_b_of_type_JavaLangString, ",showDownloadCtrlDialog=", Boolean.valueOf(bool), ",appid=", paramArrayOfVariantWrapper.jdField_a_of_type_JavaLangString, ",name=", paramArrayOfVariantWrapper.j, ",iconUrl:", paramArrayOfVariantWrapper.k });
          if (bool) {
            ArkDownloadController.a().a(this.jdField_b_of_type_JavaLangString, paramArrayOfVariantWrapper.jdField_a_of_type_JavaLangString, paramArrayOfVariantWrapper.j, paramArrayOfVariantWrapper.k, new ArkAppDownloadModule.4(this, paramArrayOfVariantWrapper, paramString, d));
          } else {
            i = a(paramString, d, paramArrayOfVariantWrapper);
          }
        }
        else
        {
          i = -2;
        }
        paramVariantWrapper.SetInt(i);
        return true;
      }
      if (paramString.equals("PauseDownload"))
      {
        if ((paramArrayOfVariantWrapper != null) && (paramArrayOfVariantWrapper.length >= 2) && (paramArrayOfVariantWrapper[1].IsString()))
        {
          i = paramArrayOfVariantWrapper[0].GetInt();
          paramString = paramArrayOfVariantWrapper[1].GetString();
          QLog.d("ark.download.module", 1, new Object[] { "ark.dctrl.pause download appid:", paramString, ",from:", Integer.valueOf(i) });
          WadlProxyServiceUtil.a().a(i, paramString);
          paramVariantWrapper.SetBool(true);
          ReportController.a(null, "dc00898", "", "", "0X8009E13", "0X8009E13", 0, 0, "1", "", paramString, "");
          return true;
        }
        paramVariantWrapper.SetBool(false);
        return true;
      }
      if (paramString.equals("ContinueDownload"))
      {
        if ((paramArrayOfVariantWrapper != null) && (paramArrayOfVariantWrapper.length >= 2) && (paramArrayOfVariantWrapper[1].IsString()))
        {
          i = paramArrayOfVariantWrapper[0].GetInt();
          paramString = paramArrayOfVariantWrapper[1].GetString();
          QLog.d("ark.download.module", 1, new Object[] { "ark.dctrl.continue download appid:", paramString, ",from:", Integer.valueOf(i) });
          paramArrayOfVariantWrapper = BaseActivity.sTopActivity;
          localObject1 = BaseApplicationImpl.getApplication().getSharedPreferences("sp_ark_authority", 0);
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("key_download_show_not_wifi_dialog");
          ((StringBuilder)localObject2).append(paramString);
          localObject2 = ((StringBuilder)localObject2).toString();
          if (localObject1 != null) {
            bool = ((SharedPreferences)localObject1).getBoolean((String)localObject2, true);
          } else {
            bool = true;
          }
          if ((bool) && (paramArrayOfVariantWrapper != null) && (NetworkUtil.isNetworkAvailable(paramArrayOfVariantWrapper)) && (NetworkUtil.getNetworkType(paramArrayOfVariantWrapper) != 1))
          {
            String str1 = paramArrayOfVariantWrapper.getString(2131690146);
            String str2 = paramArrayOfVariantWrapper.getString(2131690153);
            ((IArkThreadManager)QRoute.api(IArkThreadManager.class)).postToMainThread(new ArkAppDownloadModule.5(this, paramArrayOfVariantWrapper, str1, i, paramString, (SharedPreferences)localObject1, (String)localObject2, str2));
            paramVariantWrapper.SetBool(true);
            return true;
          }
          WadlProxyServiceUtil.a().b(i, paramString);
          this.c = true;
          ReportController.a(null, "dc00898", "", "", "0X8009E13", "0X8009E13", 0, 0, "2", "", paramString, "");
          paramVariantWrapper.SetBool(true);
          return true;
        }
        paramVariantWrapper.SetBool(false);
        return true;
      }
      if (paramString.equals("InstallPackage"))
      {
        if ((paramArrayOfVariantWrapper != null) && (paramArrayOfVariantWrapper.length >= 1) && (paramArrayOfVariantWrapper[0].IsString()))
        {
          paramString = paramArrayOfVariantWrapper[0].GetString();
          QLog.d("ark.download.module", 1, new Object[] { "ark.dctrl.install package:", paramString });
          paramString = new WadlParams(paramString);
          WadlProxyServiceUtil.a().c(paramString);
          ReportController.a(null, "dc00898", "", "", "0X8009E16", "0X8009E16", 0, 0, "", "", paramString.jdField_a_of_type_JavaLangString, "");
          paramVariantWrapper.SetBool(true);
          return true;
        }
        paramVariantWrapper.SetBool(false);
        return true;
      }
      if (paramString.equals("DeletePackage"))
      {
        if ((paramArrayOfVariantWrapper != null) && (paramArrayOfVariantWrapper.length >= 2) && (paramArrayOfVariantWrapper[1].IsString()))
        {
          i = paramArrayOfVariantWrapper[0].GetInt();
          paramString = paramArrayOfVariantWrapper[1].GetString();
          QLog.d("ark.download.module", 1, new Object[] { "ark.dctrl.delete package appId:", paramString, ",from:", Integer.valueOf(i) });
          WadlProxyServiceUtil.a().c(i, paramString);
          paramVariantWrapper.SetBool(true);
          return true;
        }
        paramVariantWrapper.SetBool(false);
        return true;
      }
      return false;
      label1688:
      paramString = "";
      paramArrayOfVariantWrapper = paramString;
      i = 0;
    }
  }
  
  public boolean a()
  {
    return true;
  }
  
  protected ArkModuleMethod[] a()
  {
    return null;
  }
  
  public boolean b()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.api.module.ArkAppDownloadModule
 * JD-Core Version:    0.7.0.1
 */