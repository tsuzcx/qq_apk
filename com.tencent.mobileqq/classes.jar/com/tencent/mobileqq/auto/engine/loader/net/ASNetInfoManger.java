package com.tencent.mobileqq.auto.engine.loader.net;

import android.text.TextUtils;
import com.tencent.biz.qcircleshadow.remotecheck.QCircleGetRainBowRequest;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.auto.engine.loader.ASDynamicEngine;
import com.tencent.mobileqq.auto.engine.loader.ASDynamicEngineFactory;
import com.tencent.mobileqq.auto.engine.loader.ASEngineUtils;
import com.tencent.mobileqq.auto.engine.loader.ASPluginBean;
import com.tencent.mobileqq.config.api.IAppSettingApi;
import com.tencent.mobileqq.mqq.api.IAccountRuntime;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.sender.util.EventControlUtils;
import cooperation.qqcircle.report.ASEngineQualityReport;
import cooperation.qqcircle.report.ASEngineQualityReport.ReportData;
import cooperation.qzone.QUA;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;
import qqcircle.QQCircleConfig.GetRainbowTableConfigRsp;

public class ASNetInfoManger
{
  private static final Object a = new Object();
  private EntityManager b;
  private CountDownLatch c;
  
  public ASNetInfoManger()
  {
    if (this.b == null) {
      this.b = ASEngineUtils.d();
    }
  }
  
  private void a(ASDataBaseInfo paramASDataBaseInfo)
  {
    synchronized (a)
    {
      if (paramASDataBaseInfo.isReady()) {
        b().delete(ASDataBaseInfo.class.getSimpleName(), "mBusinessKey=?", new String[] { paramASDataBaseInfo.getBusinessKey() });
      } else {
        b().delete(ASDataBaseInfo.class.getSimpleName(), "mBusinessKey=? and mVersion=?", new String[] { paramASDataBaseInfo.getBusinessKey(), String.valueOf(paramASDataBaseInfo.getVersion()) });
      }
      paramASDataBaseInfo.setStatus(1000);
      b().persistOrReplace(paramASDataBaseInfo);
      if (paramASDataBaseInfo.isReady()) {
        c();
      }
      return;
    }
  }
  
  private void a(ASDataBaseInfo paramASDataBaseInfo, String paramString)
  {
    ASPluginDownloadManager.a().a(paramASDataBaseInfo.getZipFileUrl(), paramString, new ASNetInfoManger.2(this, paramASDataBaseInfo, paramString));
  }
  
  private void a(String paramString, QQCircleConfig.GetRainbowTableConfigRsp paramGetRainbowTableConfigRsp)
  {
    if (paramGetRainbowTableConfigRsp.update.get() == 1)
    {
      QLog.e("ASNetInfoManger", 1, "handleUpdate");
      b(paramString, paramGetRainbowTableConfigRsp);
      return;
    }
    paramString = a(paramString, false);
    if ((paramString != null) && (!paramString.isReady()))
    {
      QLog.e("ASNetInfoManger", 1, "plugin is not already downLoadFile");
      b(paramString);
      return;
    }
    QLog.e("ASNetInfoManger", 1, "plugin is already");
    c();
  }
  
  public static boolean a()
  {
    boolean bool = false;
    if (QCircleConfigHelper.a("qqflash", "qqflash_auto_shadow_gray_switch", Integer.valueOf(0)).intValue() == 1) {
      bool = true;
    }
    return bool;
  }
  
  private EntityManager b()
  {
    return this.b;
  }
  
  private void b(ASDataBaseInfo paramASDataBaseInfo)
  {
    if (paramASDataBaseInfo == null)
    {
      QLog.e("ASNetInfoManger", 1, "downloadFile but dataBaseInfo is null");
      return;
    }
    String str = c(paramASDataBaseInfo);
    File localFile = new File(str);
    int i;
    if ((localFile.exists()) && (localFile.length() == paramASDataBaseInfo.getZipFileLength())) {
      i = 1;
    } else {
      i = 0;
    }
    if (i == 0) {
      a(paramASDataBaseInfo, str);
    } else {
      paramASDataBaseInfo.setPluginZipPath(str);
    }
    str = d(paramASDataBaseInfo);
    localFile = new File(str);
    if ((localFile.exists()) && (localFile.length() == paramASDataBaseInfo.getManagerFileLength())) {
      paramASDataBaseInfo.setPluginManagerPath(str);
    } else {
      b(paramASDataBaseInfo, str);
    }
    if ((!TextUtils.isEmpty(paramASDataBaseInfo.getPluginZipPath())) && (!TextUtils.isEmpty(paramASDataBaseInfo.getPluginManagerPath())))
    {
      paramASDataBaseInfo.setIsReady(true);
      a(paramASDataBaseInfo);
      c();
    }
  }
  
  private void b(ASDataBaseInfo paramASDataBaseInfo, String paramString)
  {
    ASPluginDownloadManager.a().a(paramASDataBaseInfo.getManagerFileUrl(), paramString, new ASNetInfoManger.3(this, paramASDataBaseInfo, paramString));
  }
  
  private void b(String paramString, QQCircleConfig.GetRainbowTableConfigRsp paramGetRainbowTableConfigRsp)
  {
    if (TextUtils.isEmpty(paramGetRainbowTableConfigRsp.data.get()))
    {
      paramString = new StringBuilder();
      paramString.append("data =");
      paramString.append(paramGetRainbowTableConfigRsp.data);
      QLog.e("ASNetInfoManger", 1, paramString.toString());
      c();
      return;
    }
    try
    {
      Object localObject = new JSONObject(paramGetRainbowTableConfigRsp.data.get());
      int i = ((JSONObject)localObject).getInt("version");
      paramGetRainbowTableConfigRsp = paramGetRainbowTableConfigRsp.cookie.get();
      String str1 = ((JSONObject)localObject).getString("zipFileUrl");
      String str2 = ((JSONObject)localObject).getString("managerFileUrl");
      long l1 = ((JSONObject)localObject).getLong("zipFileLength");
      long l2 = ((JSONObject)localObject).getLong("managerFileLength");
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(" version= ");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append(" cookie= ");
      ((StringBuilder)localObject).append(paramGetRainbowTableConfigRsp);
      ((StringBuilder)localObject).append(" zipFileUrl= ");
      ((StringBuilder)localObject).append(str1);
      ((StringBuilder)localObject).append(" managerFileUrl= ");
      ((StringBuilder)localObject).append(str2);
      ((StringBuilder)localObject).append("  zipFileLength =");
      ((StringBuilder)localObject).append(l1);
      ((StringBuilder)localObject).append(" managerFilelength =");
      ((StringBuilder)localObject).append(l2);
      QLog.e("ASNetInfoManger", 1, ((StringBuilder)localObject).toString());
      b(e(ASDataBaseInfo.ASDataBaseInfoBuilder.a().a(paramString).a(i).c(paramGetRainbowTableConfigRsp).e(str2).b(l2).d(str1).a(l1).b(QUA.getQUA3()).c(Long.parseLong(((IAccountRuntime)QRoute.api(IAccountRuntime.class)).getAccount())).b()));
      return;
    }
    catch (JSONException paramString)
    {
      QLog.e("ASNetInfoManger", 1, paramString, new Object[0]);
      paramString.printStackTrace();
    }
  }
  
  private String c(ASDataBaseInfo paramASDataBaseInfo)
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append(MobileQQ.sMobileQQ.getDir(paramASDataBaseInfo.getBusinessKey(), 0).getPath());
    localStringBuilder1.append(File.separator);
    localStringBuilder1.append(paramASDataBaseInfo.getVersion());
    localStringBuilder1.append(File.separator);
    StringBuilder localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(paramASDataBaseInfo.getZipFileUrl());
    localStringBuilder2.append(paramASDataBaseInfo.getManagerFileUrl());
    localStringBuilder1.append(MD5.toMD5(localStringBuilder2.toString()));
    localStringBuilder1.append(File.separator);
    localStringBuilder1.append(paramASDataBaseInfo.getBusinessKey());
    localStringBuilder1.append(".zip");
    return localStringBuilder1.toString();
  }
  
  private String c(String paramString)
  {
    Object localObject;
    if (((IAppSettingApi)QRoute.api(IAppSettingApi.class)).isGrayVersion())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("-gray");
      localObject = ((StringBuilder)localObject).toString();
      paramString = (String)localObject;
      if (a())
      {
        paramString = new StringBuilder();
        paramString.append((String)localObject);
        paramString.append("-test");
        paramString = paramString.toString();
      }
    }
    else if (((IAppSettingApi)QRoute.api(IAppSettingApi.class)).isPublicVersion())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("-public");
      paramString = ((StringBuilder)localObject).toString();
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("-dev");
      paramString = ((StringBuilder)localObject).toString();
    }
    QLog.i("ASNetInfoManger", 1, "getRainbowGroup");
    return paramString;
  }
  
  private void c()
  {
    CountDownLatch localCountDownLatch = this.c;
    if ((localCountDownLatch != null) && (localCountDownLatch.getCount() > 0L)) {
      this.c.countDown();
    }
  }
  
  private String d(ASDataBaseInfo paramASDataBaseInfo)
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append(MobileQQ.sMobileQQ.getDir(paramASDataBaseInfo.getBusinessKey(), 0).getPath());
    localStringBuilder1.append(File.separator);
    localStringBuilder1.append(paramASDataBaseInfo.getVersion());
    localStringBuilder1.append(File.separator);
    StringBuilder localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(paramASDataBaseInfo.getZipFileUrl());
    localStringBuilder2.append(paramASDataBaseInfo.getManagerFileUrl());
    localStringBuilder1.append(MD5.toMD5(localStringBuilder2.toString()));
    localStringBuilder1.append(File.separator);
    localStringBuilder1.append(paramASDataBaseInfo.getBusinessKey());
    localStringBuilder1.append("-manager.apk");
    return localStringBuilder1.toString();
  }
  
  private ASDataBaseInfo e(ASDataBaseInfo paramASDataBaseInfo)
  {
    if ((b() != null) && (paramASDataBaseInfo.getVersion() > 0) && (!TextUtils.isEmpty(paramASDataBaseInfo.getZipFileUrl())) && (!TextUtils.isEmpty(paramASDataBaseInfo.getManagerFileUrl())) && (paramASDataBaseInfo.getZipFileLength() > 0L))
    {
      if (paramASDataBaseInfo.getManagerFileLength() <= 0L) {
        return null;
      }
      ASDataBaseInfo localASDataBaseInfo = (ASDataBaseInfo)b().find(ASDataBaseInfo.class, new String[] { paramASDataBaseInfo.getBusinessKey(), String.valueOf(paramASDataBaseInfo.getVersion()) });
      if (localASDataBaseInfo == null) {
        return paramASDataBaseInfo;
      }
      if ((!TextUtils.isEmpty(paramASDataBaseInfo.getCookie())) && (!paramASDataBaseInfo.getCookie().equals(localASDataBaseInfo.getCookie()))) {
        return paramASDataBaseInfo;
      }
      if (localASDataBaseInfo.isInvalid()) {
        return null;
      }
      if (localASDataBaseInfo.isReady()) {
        return localASDataBaseInfo;
      }
      return paramASDataBaseInfo;
    }
    return null;
  }
  
  public ASPluginBean a(String paramString)
  {
    try
    {
      this.c = new CountDownLatch(1);
      b(paramString);
      try
      {
        this.c.await(60L, TimeUnit.SECONDS);
      }
      catch (InterruptedException localInterruptedException)
      {
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("queryLastPluginBean error");
        localStringBuilder2.append(localInterruptedException.getMessage());
        QLog.e("ASNetInfoManger", 1, localStringBuilder2.toString());
        localInterruptedException.printStackTrace();
      }
      paramString = b(paramString, true);
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("queryLastPluginBean success");
      localStringBuilder1.append(paramString);
      QLog.e("ASNetInfoManger", 1, localStringBuilder1.toString());
      return paramString;
    }
    finally {}
  }
  
  public ASDataBaseInfo a(String paramString, boolean paramBoolean)
  {
    Object localObject = b().query(ASDataBaseInfo.class, ASDataBaseInfo.class.getSimpleName(), true, "mBusinessKey = ?", new String[] { paramString }, null, null, null, null);
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      Iterator localIterator = ((List)localObject).iterator();
      while (localIterator.hasNext())
      {
        localObject = (ASDataBaseInfo)localIterator.next();
        if ((localObject != null) && ((!paramBoolean) || (((ASDataBaseInfo)localObject).mIsReady)) && (!((ASDataBaseInfo)localObject).mIsInvalid) && (((ASDataBaseInfo)localObject).mUin == ASEngineUtils.c()) && (((ASDataBaseInfo)localObject).mQua.equals(QUA.getQUA3())) && (paramString.equals(((ASDataBaseInfo)localObject).mBusinessKey)))
        {
          paramString = new StringBuilder();
          paramString.append("getAsPluginBean():");
          paramString.append(localObject);
          QLog.d("ASNetInfoManger", 1, paramString.toString());
          return localObject;
        }
      }
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("getAsPluginBean():");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("no plugin");
    QLog.d("ASNetInfoManger", 1, ((StringBuilder)localObject).toString());
    return null;
  }
  
  public void a(int paramInt, String paramString)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("setQCirclePluginInvalid=");
    ((StringBuilder)localObject1).append(paramInt);
    ((StringBuilder)localObject1).append(paramString);
    QLog.e("ASNetInfoManger", 1, ((StringBuilder)localObject1).toString());
    localObject1 = (ASDataBaseInfo)b().find(ASDataBaseInfo.class, new String[] { String.valueOf(paramInt), paramString });
    if (localObject1 != null)
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append("setQCirclePluginInvalid success");
      ((StringBuilder)???).append(paramInt);
      QLog.e("ASNetInfoManger", 1, ((StringBuilder)???).toString());
      ((ASDataBaseInfo)localObject1).mIsInvalid = true;
      synchronized (a)
      {
        b().update((Entity)localObject1);
        ASEngineQualityReport.report(new ASEngineQualityReport.ReportData().setExt1(paramString).setEventId("autoshadow_plugin_set_plugin_invalid").setRetCode(0L).setPluginType("TYPE_NET").setPluginVersion(paramInt));
        return;
      }
    }
    ASEngineQualityReport.report(new ASEngineQualityReport.ReportData().setEventId("autoshadow_plugin_set_plugin_invalid").setExt1(paramString).setPluginType("TYPE_NET").setRetCode(-1L).setPluginVersion(paramInt));
  }
  
  public ASPluginBean b(String paramString, boolean paramBoolean)
  {
    ASDataBaseInfo localASDataBaseInfo = a(paramString, paramBoolean);
    if (localASDataBaseInfo == null)
    {
      ASEngineQualityReport.report(new ASEngineQualityReport.ReportData().setEventId("autoshadow_plugin_get").setExt1(paramString).setPluginVersion(ASDynamicEngineFactory.a(paramString).b().getVersionCode()).setPluginType("TYPE_NET").setRetCode(-1L));
      return null;
    }
    ASEngineQualityReport.report(new ASEngineQualityReport.ReportData().setEventId("autoshadow_plugin_get").setExt1(paramString).setPluginVersion(ASDynamicEngineFactory.a(paramString).b().getVersionCode()).setPluginType("TYPE_NET").setRetCode(0L));
    return ASEngineUtils.a(localASDataBaseInfo);
  }
  
  public void b(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("sendGetRainBowRequest");
    ((StringBuilder)localObject).append(paramString);
    if (!EventControlUtils.a(((StringBuilder)localObject).toString(), QCircleConfigHelper.al()))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("business:");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("sendGetRainBowRequest frequently");
      QLog.e("ASNetInfoManger", 1, ((StringBuilder)localObject).toString());
      c();
      return;
    }
    ASEngineQualityReport.report(new ASEngineQualityReport.ReportData().setEventId("autoshadow_plugin_cmd_req").setExt1(paramString).setPluginVersion(ASDynamicEngineFactory.a(paramString).b().getVersionCode()).setPluginType("TYPE_NET").setRetCode(0L));
    localObject = a(paramString, true);
    if ((localObject != null) && (!TextUtils.isEmpty(((ASDataBaseInfo)localObject).getCookie()))) {
      localObject = ((ASDataBaseInfo)localObject).getCookie();
    } else {
      localObject = "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sendGetRainBowRequest cookie=");
    localStringBuilder.append((String)localObject);
    QLog.i("ASNetInfoManger", 1, localStringBuilder.toString());
    localObject = new QCircleGetRainBowRequest((String)localObject, QUA.getQUA3(), c(paramString), ((IAccountRuntime)QRoute.api(IAccountRuntime.class)).getAccount(), ((IAppSettingApi)QRoute.api(IAppSettingApi.class)).getSubVersion());
    VSNetworkHelper.getInstance().sendRequest(MobileQQ.sMobileQQ, (BaseRequest)localObject, new ASNetInfoManger.1(this, (QCircleGetRainBowRequest)localObject, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.auto.engine.loader.net.ASNetInfoManger
 * JD-Core Version:    0.7.0.1
 */