package com.tencent.biz.qcircleshadow.remoteCheck;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.biz.qcircleshadow.lib.variation.HostDataTransUtils;
import com.tencent.biz.qcircleshadow.local.QCircleShadow;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.config.api.IAppSettingApi;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.qcircle.api.impl.QCircleServiceImpl;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCircleFlutterPluginQualityReporter;
import cooperation.qqcircle.report.QCircleFlutterPluginQualityReporter.ReportData;
import cooperation.qqcircle.report.QCirclePluginQualityReporter;
import cooperation.qqcircle.report.QCirclePluginQualityReporter.ReportData;
import cooperation.qzone.QUA;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;
import qqcircle.QQCircleConfig.GetRainbowTableConfigRsp;

public class QCirclePluginManager
{
  private static QCirclePluginManager jdField_a_of_type_ComTencentBizQcircleshadowRemoteCheckQCirclePluginManager;
  private static Object jdField_a_of_type_JavaLangObject = new Object();
  static final Pattern jdField_a_of_type_JavaUtilRegexPattern = Pattern.compile("\\S*[?]\\S*");
  private static Object jdField_b_of_type_JavaLangObject = new Object();
  private static Object c = new Object();
  public long a;
  private EntityManager jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
  private String jdField_a_of_type_JavaLangString = MobileQQ.sMobileQQ.getDir("qcircleplugin", 0).getPath();
  private long jdField_b_of_type_Long;
  
  QCirclePluginManager()
  {
    this.jdField_a_of_type_Long = 0L;
  }
  
  private QCirclePluginInfo a(QCirclePluginInfo paramQCirclePluginInfo)
  {
    if ((a() != null) && (paramQCirclePluginInfo.version > 0) && (!TextUtils.isEmpty(paramQCirclePluginInfo.zipFileUrl)) && (!TextUtils.isEmpty(paramQCirclePluginInfo.managerFileUrl)) && (paramQCirclePluginInfo.zipFileLength > 0L))
    {
      if (paramQCirclePluginInfo.managerFilelength <= 0L) {
        return null;
      }
      Object localObject = a();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramQCirclePluginInfo.version);
      localStringBuilder.append("");
      localObject = (QCirclePluginInfo)((EntityManager)localObject).find(QCirclePluginInfo.class, localStringBuilder.toString());
      if (localObject == null) {
        return paramQCirclePluginInfo;
      }
      if ((!TextUtils.isEmpty(paramQCirclePluginInfo.cookie)) && (!paramQCirclePluginInfo.cookie.equals(((QCirclePluginInfo)localObject).cookie))) {
        return paramQCirclePluginInfo;
      }
      if (((QCirclePluginInfo)localObject).isInvalid) {
        return null;
      }
      if (((QCirclePluginInfo)localObject).isReady) {
        return localObject;
      }
      return paramQCirclePluginInfo;
    }
    return null;
  }
  
  public static QCirclePluginManager a()
  {
    if (jdField_a_of_type_ComTencentBizQcircleshadowRemoteCheckQCirclePluginManager == null) {
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        if (jdField_a_of_type_ComTencentBizQcircleshadowRemoteCheckQCirclePluginManager == null) {
          jdField_a_of_type_ComTencentBizQcircleshadowRemoteCheckQCirclePluginManager = new QCirclePluginManager();
        }
      }
    }
    return jdField_a_of_type_ComTencentBizQcircleshadowRemoteCheckQCirclePluginManager;
  }
  
  private EntityManager a()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager != null)
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
        return localObject1;
      }
      Object localObject1 = QCircleServiceImpl.getAppRunTime().getAccount();
      if (localObject1 == null) {
        return null;
      }
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = QCircleServiceImpl.getEntityManager();
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
      return localObject1;
    }
    finally {}
  }
  
  private static String a(String paramString)
  {
    Matcher localMatcher = jdField_a_of_type_JavaUtilRegexPattern.matcher(paramString);
    paramString = paramString.toString().split("/");
    paramString = paramString[(paramString.length - 1)];
    if (localMatcher.find()) {
      return paramString.split("\\?")[0].split("\\.")[1];
    }
    return paramString.split("\\.")[1];
  }
  
  private void a(QCircleFlutterPluginInfo paramQCircleFlutterPluginInfo)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(MobileQQ.sMobileQQ.getCacheDir());
    ((StringBuilder)localObject1).append("/AstCache/");
    ((StringBuilder)localObject1).append(MD5.toMD5(paramQCircleFlutterPluginInfo.zipFileUrl));
    ((StringBuilder)localObject1).append(".");
    ((StringBuilder)localObject1).append(a(paramQCircleFlutterPluginInfo.zipFileUrl));
    localObject1 = ((StringBuilder)localObject1).toString();
    Object localObject2 = new File((String)localObject1);
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("start download  path :");
    ((StringBuilder)localObject3).append((String)localObject1);
    localObject3 = ((StringBuilder)localObject3).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("url:");
    localStringBuilder.append(paramQCircleFlutterPluginInfo.zipFileUrl);
    QLog.e("QCirclePluginManager", 1, new Object[] { localObject3, localStringBuilder.toString() });
    if (!((File)localObject2).exists())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("start download  path :");
      ((StringBuilder)localObject2).append((String)localObject1);
      localObject2 = ((StringBuilder)localObject2).toString();
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("url:");
      ((StringBuilder)localObject3).append(paramQCircleFlutterPluginInfo.zipFileUrl);
      QLog.e("QCirclePluginManager", 1, new Object[] { localObject2, ((StringBuilder)localObject3).toString() });
      this.jdField_b_of_type_Long = System.currentTimeMillis();
      QCirclePluginDownloadManager.a().a(paramQCircleFlutterPluginInfo.zipFileUrl, (String)localObject1, new QCirclePluginManager.2(this, paramQCircleFlutterPluginInfo, (String)localObject1));
    }
  }
  
  private void a(QCirclePluginInfo paramQCirclePluginInfo)
  {
    ??? = new StringBuilder();
    ((StringBuilder)???).append(this.jdField_a_of_type_JavaLangString);
    ((StringBuilder)???).append("/");
    ((StringBuilder)???).append(paramQCirclePluginInfo.version);
    ((StringBuilder)???).append("/");
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(paramQCirclePluginInfo.version);
    ((StringBuilder)localObject2).append(paramQCirclePluginInfo.zipFileUrl);
    ((StringBuilder)???).append(MD5.toMD5(((StringBuilder)localObject2).toString()));
    ((StringBuilder)???).append("/qcirle-plugin.zip");
    ??? = ((StringBuilder)???).toString();
    localObject2 = new File((String)???);
    if ((((File)localObject2).exists()) && (((File)localObject2).length() == paramQCirclePluginInfo.zipFileLength))
    {
      paramQCirclePluginInfo.pluginZipPath = ((String)???);
      QCirclePluginQualityReporter.report(new QCirclePluginQualityReporter.ReportData().setEvent_id("qcircle_plugin_download").setRetCode(1003L).setPluginVersion(paramQCirclePluginInfo.version));
    }
    else
    {
      QCirclePluginQualityReporter.report(new QCirclePluginQualityReporter.ReportData().setEvent_id("qcircle_plugin_download").setRetCode(1L).setPluginVersion(paramQCirclePluginInfo.version));
      QCirclePluginDownloadManager.a().a(paramQCirclePluginInfo.zipFileUrl, (String)???, new QCirclePluginManager.3(this, paramQCirclePluginInfo, (String)???));
    }
    ??? = new StringBuilder();
    ((StringBuilder)???).append(this.jdField_a_of_type_JavaLangString);
    ((StringBuilder)???).append("/");
    ((StringBuilder)???).append(paramQCirclePluginInfo.version);
    ((StringBuilder)???).append("/qcirle-pluginmanager.apk");
    ??? = ((StringBuilder)???).toString();
    localObject2 = new File((String)???);
    if ((((File)localObject2).exists()) && (((File)localObject2).length() == paramQCirclePluginInfo.managerFilelength))
    {
      paramQCirclePluginInfo.pluginManagerPath = ((String)???);
      QCirclePluginQualityReporter.report(new QCirclePluginQualityReporter.ReportData().setEvent_id("qcircle_plugin_download").setRetCode(2003L).setPluginVersion(paramQCirclePluginInfo.version));
      if ((!TextUtils.isEmpty(paramQCirclePluginInfo.pluginManagerPath)) && (!TextUtils.isEmpty(paramQCirclePluginInfo.pluginZipPath)))
      {
        paramQCirclePluginInfo.isReady = true;
        synchronized (jdField_b_of_type_JavaLangObject)
        {
          a().delete(QCirclePluginInfo.class.getSimpleName(), null, null);
          paramQCirclePluginInfo.setStatus(1000);
          a().persistOrReplace(paramQCirclePluginInfo);
          return;
        }
      }
    }
    else
    {
      QCirclePluginQualityReporter.report(new QCirclePluginQualityReporter.ReportData().setEvent_id("qcircle_plugin_download").setRetCode(2L).setPluginVersion(paramQCirclePluginInfo.version));
      QCirclePluginDownloadManager.a().a(paramQCirclePluginInfo.managerFileUrl, (String)???, new QCirclePluginManager.4(this, paramQCirclePluginInfo, (String)???));
    }
  }
  
  private void a(QQCircleConfig.GetRainbowTableConfigRsp paramGetRainbowTableConfigRsp)
  {
    if (paramGetRainbowTableConfigRsp.update.get() == 1)
    {
      Object localObject2;
      if (!TextUtils.isEmpty(paramGetRainbowTableConfigRsp.data.get()))
      {
        Object localObject3;
        String str1;
        String str2;
        long l1;
        try
        {
          localObject3 = new JSONObject(paramGetRainbowTableConfigRsp.data.get());
          if (((JSONObject)localObject3).has("version"))
          {
            int i = ((JSONObject)localObject3).getInt("version");
            Object localObject1 = paramGetRainbowTableConfigRsp.cookie.get();
            str1 = ((JSONObject)localObject3).getString("zipFileUrl");
            str2 = ((JSONObject)localObject3).getString("managerFileUrl");
            l1 = ((JSONObject)localObject3).getLong("zipFileLength");
            long l2 = ((JSONObject)localObject3).getLong("managerFilelength");
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append(" version= ");
            ((StringBuilder)localObject3).append(i);
            ((StringBuilder)localObject3).append(" cookie= ");
            ((StringBuilder)localObject3).append((String)localObject1);
            ((StringBuilder)localObject3).append(" zipFileUrl= ");
            ((StringBuilder)localObject3).append(str1);
            ((StringBuilder)localObject3).append(" managerFileUrl= ");
            ((StringBuilder)localObject3).append(str2);
            ((StringBuilder)localObject3).append("  zipFileLength =");
            try
            {
              ((StringBuilder)localObject3).append(l1);
              ((StringBuilder)localObject3).append(" managerFilelength =");
              ((StringBuilder)localObject3).append(l2);
              QLog.e("QCirclePluginManager", 1, ((StringBuilder)localObject3).toString());
              localObject1 = a(new QCirclePluginInfo(i, (String)localObject1, str1, str2, l1, l2, HostDataTransUtils.getLongAccountUin()));
              if (localObject1 == null)
              {
                QCirclePluginQualityReporter.report(new QCirclePluginQualityReporter.ReportData().setEvent_id("qcircle_plugin_cmd_rsp").setRetCode(2L));
                return;
              }
              QCirclePluginQualityReporter.report(new QCirclePluginQualityReporter.ReportData().setEvent_id("qcircle_plugin_cmd_rsp").setRetCode(0L).setPluginVersion(((QCirclePluginInfo)localObject1).version));
              a((QCirclePluginInfo)localObject1);
            }
            catch (JSONException localJSONException1) {}
          }
        }
        catch (JSONException localJSONException2)
        {
          QCirclePluginQualityReporter.report(new QCirclePluginQualityReporter.ReportData().setEvent_id("qcircle_plugin_cmd_rsp").setRetCode(3L));
          QLog.e("QCirclePluginManager", 1, localJSONException2, new Object[0]);
          localJSONException2.printStackTrace();
        }
        try
        {
          paramGetRainbowTableConfigRsp = new JSONObject(paramGetRainbowTableConfigRsp.data.get());
          if (!paramGetRainbowTableConfigRsp.has("flutterPlugin")) {
            return;
          }
          paramGetRainbowTableConfigRsp = paramGetRainbowTableConfigRsp.getJSONObject("flutterPlugin");
          localObject2 = paramGetRainbowTableConfigRsp.getString("zip");
          str1 = paramGetRainbowTableConfigRsp.getString("version");
          str2 = paramGetRainbowTableConfigRsp.getString("md5");
          localObject3 = paramGetRainbowTableConfigRsp.getString("salt");
          l1 = paramGetRainbowTableConfigRsp.getLong("zipFileLength");
          a(new QCircleFlutterPluginInfo(str1, (String)localObject2, str2, HostDataTransUtils.getLongAccountUin(), (String)localObject3, l1));
          return;
        }
        catch (JSONException paramGetRainbowTableConfigRsp)
        {
          QCircleFlutterPluginQualityReporter.report(new QCircleFlutterPluginQualityReporter.ReportData().setEvent_id("flutter_preload").setRetCode(3L));
          QLog.e("QCirclePluginManager", 1, paramGetRainbowTableConfigRsp, new Object[0]);
          paramGetRainbowTableConfigRsp.printStackTrace();
          return;
        }
      }
      else
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("data =");
        ((StringBuilder)localObject2).append(paramGetRainbowTableConfigRsp.data);
        QLog.e("QCirclePluginManager", 1, ((StringBuilder)localObject2).toString());
        QCirclePluginQualityReporter.report(new QCirclePluginQualityReporter.ReportData().setEvent_id("qcircle_plugin_cmd_rsp").setRetCode(4L));
      }
    }
    else
    {
      paramGetRainbowTableConfigRsp = a(false);
      if ((paramGetRainbowTableConfigRsp != null) && (!paramGetRainbowTableConfigRsp.isReady)) {
        a(paramGetRainbowTableConfigRsp);
      }
      QCirclePluginQualityReporter.report(new QCirclePluginQualityReporter.ReportData().setEvent_id("qcircle_plugin_cmd_rsp").setRetCode(1L));
      QLog.e("QCirclePluginManager", 1, "update = 0");
    }
  }
  
  private boolean a()
  {
    if (a() == null)
    {
      QLog.i("QCIRCLE_PLUGIN", 1, "getQCirclePluginInfo() getmEm() is null");
      return true;
    }
    return false;
  }
  
  public QCircleFlutterPluginInfo a(boolean paramBoolean)
  {
    if (a()) {
      return null;
    }
    Object localObject = a().query(QCircleFlutterPluginInfo.class);
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      Iterator localIterator = ((List)localObject).iterator();
      while (localIterator.hasNext())
      {
        QCircleFlutterPluginInfo localQCircleFlutterPluginInfo = (QCircleFlutterPluginInfo)localIterator.next();
        long l = 0L;
        if ((localQCircleFlutterPluginInfo != null) && (!localQCircleFlutterPluginInfo.isInvalid) && (localQCircleFlutterPluginInfo.mUin == HostDataTransUtils.getLongAccountUin()) && (localQCircleFlutterPluginInfo.qua.equals(QUA.getQUA3())))
        {
          if (paramBoolean) {
            QCircleFlutterPluginQualityReporter.report(new QCircleFlutterPluginQualityReporter.ReportData().setEvent_id("flutter_open").setRetCode(0L).setFlutterPluginVersion(localQCircleFlutterPluginInfo.version).setCheckCode(localQCircleFlutterPluginInfo.salt).setMd5(localQCircleFlutterPluginInfo.zipFileMD5).setUrl(localQCircleFlutterPluginInfo.zipFileUrl));
          }
          return localQCircleFlutterPluginInfo;
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("qCircleFlutterPluginInfo= ");
        ((StringBuilder)localObject).append(localQCircleFlutterPluginInfo);
        ((StringBuilder)localObject).append(localQCircleFlutterPluginInfo);
        if (((StringBuilder)localObject).toString() != null)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("version=");
          ((StringBuilder)localObject).append(localQCircleFlutterPluginInfo.version);
          ((StringBuilder)localObject).append("isReady=");
          ((StringBuilder)localObject).append(localQCircleFlutterPluginInfo.isReady);
          ((StringBuilder)localObject).append("isInvalid=");
          ((StringBuilder)localObject).append(localQCircleFlutterPluginInfo.isInvalid);
          localObject = ((StringBuilder)localObject).toString();
        }
        else
        {
          localObject = "";
        }
        QLog.e("QCirclePluginManager", 1, (String)localObject);
        if (paramBoolean)
        {
          if (localQCircleFlutterPluginInfo == null) {
            l = 1L;
          } else if (localQCircleFlutterPluginInfo.isInvalid) {
            l = 2L;
          } else if (!localQCircleFlutterPluginInfo.isReady) {
            l = 3L;
          } else if (localQCircleFlutterPluginInfo.mUin != HostDataTransUtils.getLongAccountUin()) {
            l = 4L;
          } else if (!localQCircleFlutterPluginInfo.qua.equals(QUA.getQUA3())) {
            l = 5L;
          }
          QCircleFlutterPluginQualityReporter.report(new QCircleFlutterPluginQualityReporter.ReportData().setEvent_id("flutter_open").setRetCode(l).setFlutterPluginVersion(localQCircleFlutterPluginInfo.version).setCheckCode(localQCircleFlutterPluginInfo.salt).setMd5(localQCircleFlutterPluginInfo.zipFileMD5).setUrl(localQCircleFlutterPluginInfo.zipFileUrl));
        }
      }
      return null;
    }
    QLog.e("QCirclePluginManager", 1, "size = 0");
    return null;
  }
  
  public QCirclePluginInfo a(boolean paramBoolean)
  {
    if (a()) {
      return null;
    }
    Object localObject = a().query(QCirclePluginInfo.class);
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      Iterator localIterator = ((List)localObject).iterator();
      while (localIterator.hasNext())
      {
        QCirclePluginInfo localQCirclePluginInfo = (QCirclePluginInfo)localIterator.next();
        long l1 = 0L;
        if ((localQCirclePluginInfo != null) && ((!paramBoolean) || (localQCirclePluginInfo.isReady)) && (!localQCirclePluginInfo.isInvalid) && (localQCirclePluginInfo.mUin == HostDataTransUtils.getLongAccountUin()) && (localQCirclePluginInfo.qua.equals(QUA.getQUA3())))
        {
          if (paramBoolean) {
            QCirclePluginQualityReporter.report(new QCirclePluginQualityReporter.ReportData().setEvent_id("qcircle_plugin_get").setRetCode(0L).setPluginVersion(localQCirclePluginInfo.version));
          }
          return localQCirclePluginInfo;
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("qCirclePluginInfo= ");
        ((StringBuilder)localObject).append(localQCirclePluginInfo);
        ((StringBuilder)localObject).append(localQCirclePluginInfo);
        if (((StringBuilder)localObject).toString() != null)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("version=");
          ((StringBuilder)localObject).append(localQCirclePluginInfo.version);
          ((StringBuilder)localObject).append("isReady=");
          ((StringBuilder)localObject).append(localQCirclePluginInfo.isReady);
          ((StringBuilder)localObject).append("isInvalid=");
          ((StringBuilder)localObject).append(localQCirclePluginInfo.isInvalid);
          localObject = ((StringBuilder)localObject).toString();
        }
        else
        {
          localObject = "";
        }
        QLog.e("QCirclePluginManager", 1, (String)localObject);
        if (paramBoolean)
        {
          long l2 = -1L;
          if (localQCirclePluginInfo == null)
          {
            l1 = 1L;
          }
          else
          {
            int i;
            if (localQCirclePluginInfo.isInvalid)
            {
              l1 = 2L;
              i = localQCirclePluginInfo.version;
            }
            for (;;)
            {
              l2 = i;
              break;
              if (!localQCirclePluginInfo.isReady)
              {
                l1 = 3L;
                i = localQCirclePluginInfo.version;
              }
              else if (localQCirclePluginInfo.mUin != HostDataTransUtils.getLongAccountUin())
              {
                l1 = 4L;
                i = localQCirclePluginInfo.version;
              }
              else
              {
                if (localQCirclePluginInfo.qua.equals(QUA.getQUA3())) {
                  break;
                }
                l1 = 5L;
                i = localQCirclePluginInfo.version;
              }
            }
          }
          QCirclePluginQualityReporter.report(new QCirclePluginQualityReporter.ReportData().setEvent_id("qcircle_plugin_get").setRetCode(l1).setPluginVersion(l2));
        }
      }
      return null;
    }
    QLog.e("QCirclePluginManager", 1, "size = 0");
    return null;
  }
  
  public void a()
  {
    if (System.currentTimeMillis() - this.jdField_a_of_type_Long < QCircleConfigHelper.c())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("time =");
      ((StringBuilder)localObject).append(QCircleConfigHelper.c());
      QLog.e("QCirclePluginManager", 1, ((StringBuilder)localObject).toString());
      return;
    }
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    Object localObject = a(true);
    String str;
    if ((localObject != null) && (!TextUtils.isEmpty(((QCirclePluginInfo)localObject).cookie))) {
      str = ((QCirclePluginInfo)localObject).cookie;
    } else {
      str = "";
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("cookie=");
    ((StringBuilder)localObject).append(str);
    QLog.e("QCirclePluginManager", 1, ((StringBuilder)localObject).toString());
    if (((IAppSettingApi)QRoute.api(IAppSettingApi.class)).isGrayVersion()) {
      localObject = "GRAY";
    }
    for (;;)
    {
      break;
      if (((IAppSettingApi)QRoute.api(IAppSettingApi.class)).isPublicVersion()) {
        localObject = "PUBLIC";
      } else if (!((IAppSettingApi)QRoute.api(IAppSettingApi.class)).isDebugVersion()) {
        localObject = "DEV_RELEASE";
      } else {
        localObject = "DEV";
      }
    }
    QCirclePluginQualityReporter.report(new QCirclePluginQualityReporter.ReportData().setEvent_id("qcircle_plugin_cmd_req").setRetCode(0L));
    localObject = new QCircleGetRainBowRequest(str, QUA.getQUA3(), (String)localObject, HostDataTransUtils.getAccount(), ((IAppSettingApi)QRoute.api(IAppSettingApi.class)).getSubVersion());
    VSNetworkHelper.getInstance().sendRequest(MobileQQ.sMobileQQ, (BaseRequest)localObject, new QCirclePluginManager.1(this, (QCircleGetRainBowRequest)localObject));
  }
  
  public void a(int paramInt)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("setQCirclePluginInvalid=");
    ((StringBuilder)localObject1).append(paramInt);
    QLog.e("QCirclePluginManager", 1, ((StringBuilder)localObject1).toString());
    if (a()) {
      return;
    }
    localObject1 = a();
    ??? = new StringBuilder();
    ((StringBuilder)???).append(paramInt);
    ((StringBuilder)???).append("");
    localObject1 = (QCirclePluginInfo)((EntityManager)localObject1).find(QCirclePluginInfo.class, ((StringBuilder)???).toString());
    if (localObject1 != null)
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append("setQCirclePluginInvalid success");
      ((StringBuilder)???).append(paramInt);
      QLog.e("QCirclePluginManager", 1, ((StringBuilder)???).toString());
      ((QCirclePluginInfo)localObject1).isInvalid = true;
      synchronized (jdField_b_of_type_JavaLangObject)
      {
        a().update((Entity)localObject1);
        QCirclePluginQualityReporter.report(new QCirclePluginQualityReporter.ReportData().setEvent_id("qcircle_plugin_set_plugin_invalid").setRetCode(0L).setPluginVersion(paramInt));
        return;
      }
    }
    QCirclePluginQualityReporter.report(new QCirclePluginQualityReporter.ReportData().setEvent_id("qcircle_plugin_set_plugin_invalid").setRetCode(1L).setPluginVersion(paramInt));
  }
  
  public void b()
  {
    SharedPreferences.Editor localEditor = MobileQQ.sMobileQQ.getSharedPreferences("BuglySdkInfos", 0).edit();
    localEditor.putString("9b16ced79b", QCircleShadow.a().a());
    localEditor.commit();
    c();
  }
  
  public void c()
  {
    SharedPreferences.Editor localEditor = MobileQQ.sMobileQQ.getSharedPreferences("QCirclePluginVersion", 4).edit();
    localEditor.putString("version", QCircleShadow.a().b());
    localEditor.commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.remoteCheck.QCirclePluginManager
 * JD-Core Version:    0.7.0.1
 */