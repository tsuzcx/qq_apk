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
  private WadlProxyServiceCallBackInterface a = new ArkAppDownloadModule.6(this);
  private ArkAppDownloadModule.QueryPackageStateListener b;
  private ArkAppDownloadModule.QueryPackageStateViaListener c;
  private ArkAppDownloadModule.DownloadStateListener d;
  private ArrayList<Long> k = new ArrayList();
  private boolean l = false;
  private INetInfoHandler m;
  private boolean n = false;
  
  public ArkAppDownloadModule(ark.Application paramApplication, int paramInt)
  {
    super(paramApplication, paramInt);
    WadlProxyServiceUtil.a().a(this.a);
    this.m = new ArkAppDownloadModule.7(this);
    paramApplication = BaseActivity.sTopActivity;
    if (paramApplication != null) {
      AppNetConnInfo.registerConnectionChangeReceiver(paramApplication, this.m);
    }
  }
  
  private int a(Context paramContext, double paramDouble, WadlParams paramWadlParams)
  {
    if (paramContext != null)
    {
      SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("sp_ark_authority", 0);
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("key_download_show_not_wifi_dialog");
      ((StringBuilder)localObject).append(paramWadlParams.e);
      localObject = ((StringBuilder)localObject).toString();
      boolean bool;
      if (localSharedPreferences != null) {
        bool = localSharedPreferences.getBoolean((String)localObject, true);
      } else {
        bool = true;
      }
      if (paramDouble > Utils.c())
      {
        ((IArkThreadManager)QRoute.api(IArkThreadManager.class)).postToMainThread(new ArkAppDownloadModule.9(this, paramContext, paramWadlParams));
        return 2;
      }
      if ((bool) && (NetworkUtil.isNetworkAvailable(paramContext)) && (NetworkUtil.getNetworkType(paramContext) != 1))
      {
        String str1 = String.format(paramContext.getString(2131887053), new Object[] { FileSizeFormat.a(paramDouble) });
        String str2 = paramContext.getString(2131887052);
        ((IArkThreadManager)QRoute.api(IArkThreadManager.class)).postToMainThread(new ArkAppDownloadModule.10(this, paramContext, str1, paramWadlParams, localSharedPreferences, (String)localObject, str2));
        return 2;
      }
    }
    WadlProxyServiceUtil.a().b(paramWadlParams);
    this.n = true;
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
          return localBaseActivity.getString(2131887050);
        }
        return localBaseActivity.getString(2131887049);
      }
      return localBaseActivity.getString(2131887048);
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
          ((JSONObject)localObject).put("actionCode", paramWadlParams.c);
          ((JSONObject)localObject).put("appId", paramWadlParams.e);
          ((JSONObject)localObject).put("apkUrl", paramWadlParams.k);
          ((JSONObject)localObject).put("apkSign", paramWadlParams.f);
          ((JSONObject)localObject).put("versionCode", paramWadlParams.l);
          ((JSONObject)localObject).put("packageName", paramWadlParams.m);
          ((JSONObject)localObject).put("appName", paramWadlParams.u);
          if (paramWadlParams.g)
          {
            i = 1;
            ((JSONObject)localObject).put("delayDownload", i);
            ((JSONObject)localObject).put("fromWebUrl", paramWadlParams.x);
            ((JSONObject)localObject).put("apkChannel", paramWadlParams.i);
            ((JSONObject)localObject).put("via", paramWadlParams.w);
            ((JSONObject)localObject).put("yyStartTime", paramWadlParams.n);
            ((JSONObject)localObject).put("yyEndTime", paramWadlParams.o);
            ((JSONObject)localObject).put("adtag", paramWadlParams.y);
            ((JSONObject)localObject).put("from", paramWadlParams.h);
            ((JSONObject)localObject).put("flags", paramWadlParams.d);
            ((JSONObject)localObject).put("extraData", paramWadlParams.z);
            ((JSONObject)localObject).put("sourceId", paramWadlParams.A);
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
      if (paramWadlResult.a != null)
      {
        JSONObject localJSONObject = a(paramWadlResult.a, paramString);
        if (localJSONObject != null) {
          ((JSONObject)localObject).put("wadlParams", localJSONObject.toString());
        }
      }
      ((JSONObject)localObject).put("event", paramWadlResult.b);
      ((JSONObject)localObject).put("taskId", paramWadlResult.c);
      ((JSONObject)localObject).put("taskStatus", paramWadlResult.d);
      ((JSONObject)localObject).put("fileSize", paramWadlResult.e);
      ((JSONObject)localObject).put("downloadFileSize", paramWadlResult.f);
      ((JSONObject)localObject).put("downloadFilePath", paramWadlResult.g);
      ((JSONObject)localObject).put("createTime", paramWadlResult.h);
      ((JSONObject)localObject).put("errCode", GameCenterUtil.b(paramWadlResult.j));
      ((JSONObject)localObject).put("progress", paramWadlResult.k);
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
    WadlProxyServiceUtil.a().b(this.a);
    this.a = null;
    this.b = null;
    this.c = null;
    AppNetConnInfo.unregisterNetInfoHandler(this.m);
    this.m = null;
    ArrayList localArrayList = this.k;
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      int i = 0;
      while (i < this.k.size())
      {
        a(((Long)this.k.get(i)).longValue());
        i += 1;
      }
      this.k.clear();
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
    if (!ArkAPIPermission.a(this.f, this.e, this.i, "permission.DOWNLOAD"))
    {
      QLog.i("ark.download.module", 1, "ark.dctrl.ArkAppDownloadModule.invokeFunc permission denied");
      paramString = BaseActivity.sTopActivity;
      if (paramString != null) {
        b(paramString.getString(2131887054));
      }
      return false;
    }
    QLog.i("ark.download.module", 1, String.format("ark.dctrl.ArkAppDownloadModule.invokeFunc.%s", new Object[] { paramString }));
    boolean bool = paramString.equals("QueryPackageState");
    int i = 2;
    long l1;
    if (bool)
    {
      if ((paramArrayOfVariantWrapper != null) && (paramArrayOfVariantWrapper.length >= 2) && (paramArrayOfVariantWrapper[0].IsString()))
      {
        paramString = paramArrayOfVariantWrapper[0].GetString();
        l1 = a(paramArrayOfVariantWrapper[1].Copy());
        paramArrayOfVariantWrapper = new ArrayList();
        paramArrayOfVariantWrapper.add(paramString);
        QLog.i("ark.download.module", 1, String.format("ark.dctrl.QueryPackageState.appid:%s", new Object[] { Long.valueOf(l1) }));
        this.b = new ArkAppDownloadModule.1(this, l1);
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
        paramString = GameCenterUtil.d((String)localObject1);
        if (paramString == null) {
          break label1687;
        }
        i = paramString.versionCode;
        paramString = paramString.versionName;
        paramArrayOfVariantWrapper = GameCenterUtil.e(GameCenterUtil.c((String)localObject1));
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
          this.c = new ArkAppDownloadModule.2(this, a(paramArrayOfVariantWrapper[1].Copy()));
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
          l1 = a(paramArrayOfVariantWrapper[0].Copy());
          paramString = new StringBuilder();
          paramString.append("ark.dctrl.DownloadInit callbackid=");
          paramString.append(l1);
          QLog.i("ark.download.module", 1, paramString.toString());
          this.d = new ArkAppDownloadModule.3(this);
          this.k.add(Long.valueOf(l1));
          paramVariantWrapper.SetBool(true);
          return true;
        }
        paramVariantWrapper.SetBool(false);
        return true;
      }
      if (paramString.equals("StartDownload"))
      {
        if (this.d == null)
        {
          QLog.e("ark.download.module", 1, "should DownloadInit first ");
          paramVariantWrapper.SetInt(-1);
          return true;
        }
        paramString = BaseActivity.sTopActivity;
        if ((paramArrayOfVariantWrapper != null) && (paramArrayOfVariantWrapper.length >= 2) && (paramArrayOfVariantWrapper[0].IsString()))
        {
          localObject1 = paramArrayOfVariantWrapper[0].GetString();
          double d1 = paramArrayOfVariantWrapper[1].GetDouble();
          paramArrayOfVariantWrapper = new WadlParams((String)localObject1);
          if (paramArrayOfVariantWrapper.c == 12) {
            ReportController.a(null, "dc00898", "", "", "0X8009E12", "0X8009E12", 0, 0, "", "", paramArrayOfVariantWrapper.e, "");
          } else if (paramArrayOfVariantWrapper.c == 2) {
            ReportController.a(null, "dc00898", "", "", "0X8009E11", "0X8009E11", 0, 0, "", "", paramArrayOfVariantWrapper.e, "");
          }
          localObject1 = (ArkPlatformConfigBean)((IArkConfig)QRoute.api(IArkConfig.class)).loadConfig(ArkPlatformConfigBean.class);
          if ((localObject1 != null) && (((ArkPlatformConfigBean)localObject1).b() != null))
          {
            localObject1 = ((ArkPlatformConfigBean)localObject1).b();
            if ((((ArkPlatformConfig)localObject1).l != null) && (((ArkPlatformConfig)localObject1).l.contains(this.f)))
            {
              bool = false;
              break label895;
            }
          }
          bool = true;
          label895:
          QLog.d("ark.download.module", 1, new Object[] { "ark.dctrl [StartDownload] mAppName:", this.f, ",showDownloadCtrlDialog=", Boolean.valueOf(bool), ",appid=", paramArrayOfVariantWrapper.e, ",name=", paramArrayOfVariantWrapper.u, ",iconUrl:", paramArrayOfVariantWrapper.v });
          if (bool) {
            ArkDownloadController.a().a(this.f, paramArrayOfVariantWrapper.e, paramArrayOfVariantWrapper.u, paramArrayOfVariantWrapper.v, new ArkAppDownloadModule.4(this, paramArrayOfVariantWrapper, paramString, d1));
          } else {
            i = a(paramString, d1, paramArrayOfVariantWrapper);
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
            String str1 = paramArrayOfVariantWrapper.getString(2131887045);
            String str2 = paramArrayOfVariantWrapper.getString(2131887052);
            ((IArkThreadManager)QRoute.api(IArkThreadManager.class)).postToMainThread(new ArkAppDownloadModule.5(this, paramArrayOfVariantWrapper, str1, i, paramString, (SharedPreferences)localObject1, (String)localObject2, str2));
            paramVariantWrapper.SetBool(true);
            return true;
          }
          WadlProxyServiceUtil.a().b(i, paramString);
          this.n = true;
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
          ReportController.a(null, "dc00898", "", "", "0X8009E16", "0X8009E16", 0, 0, "", "", paramString.e, "");
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
      label1687:
      paramString = "";
      paramArrayOfVariantWrapper = paramString;
      i = 0;
    }
  }
  
  protected ArkModuleMethod[] a()
  {
    return null;
  }
  
  public boolean b()
  {
    return true;
  }
  
  public boolean c()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.api.module.ArkAppDownloadModule
 * JD-Core Version:    0.7.0.1
 */