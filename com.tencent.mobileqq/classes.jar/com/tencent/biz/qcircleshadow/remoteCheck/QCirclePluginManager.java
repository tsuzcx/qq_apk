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
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.qcircle.api.impl.QCircleServiceImpl;
import com.tencent.mobileqq.qcircle.tempapi.api.IQZoneService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCirclePluginQualityReporter;
import cooperation.qqcircle.report.QCirclePluginQualityReporter.ReportData;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;
import qqcircle.QQCircleConfig.GetRainbowTableConfigRsp;

public class QCirclePluginManager
{
  private static QCirclePluginManager jdField_a_of_type_ComTencentBizQcircleshadowRemoteCheckQCirclePluginManager;
  private static Object jdField_a_of_type_JavaLangObject = new Object();
  private static Object b = new Object();
  public long a;
  private EntityManager jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
  private String jdField_a_of_type_JavaLangString = MobileQQ.sMobileQQ.getDir("qcircleplugin", 0).getPath();
  
  QCirclePluginManager()
  {
    this.jdField_a_of_type_Long = 0L;
  }
  
  private QCirclePluginInfo a(QCirclePluginInfo paramQCirclePluginInfo)
  {
    QCirclePluginInfo localQCirclePluginInfo1;
    if ((a() == null) || (paramQCirclePluginInfo.version <= 0) || (TextUtils.isEmpty(paramQCirclePluginInfo.zipFileUrl)) || (TextUtils.isEmpty(paramQCirclePluginInfo.managerFileUrl)) || (paramQCirclePluginInfo.zipFileLength <= 0L) || (paramQCirclePluginInfo.managerFilelength <= 0L)) {
      localQCirclePluginInfo1 = null;
    }
    QCirclePluginInfo localQCirclePluginInfo2;
    do
    {
      do
      {
        do
        {
          return localQCirclePluginInfo1;
          localQCirclePluginInfo2 = (QCirclePluginInfo)a().find(QCirclePluginInfo.class, paramQCirclePluginInfo.version + "");
          localQCirclePluginInfo1 = paramQCirclePluginInfo;
        } while (localQCirclePluginInfo2 == null);
        if (TextUtils.isEmpty(paramQCirclePluginInfo.cookie)) {
          break;
        }
        localQCirclePluginInfo1 = paramQCirclePluginInfo;
      } while (!paramQCirclePluginInfo.cookie.equals(localQCirclePluginInfo2.cookie));
      if (localQCirclePluginInfo2.isInvalid) {
        return null;
      }
      localQCirclePluginInfo1 = paramQCirclePluginInfo;
    } while (!localQCirclePluginInfo2.isReady);
    return localQCirclePluginInfo2;
  }
  
  public static QCirclePluginManager a()
  {
    if (jdField_a_of_type_ComTencentBizQcircleshadowRemoteCheckQCirclePluginManager == null) {}
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_ComTencentBizQcircleshadowRemoteCheckQCirclePluginManager == null) {
        jdField_a_of_type_ComTencentBizQcircleshadowRemoteCheckQCirclePluginManager = new QCirclePluginManager();
      }
      return jdField_a_of_type_ComTencentBizQcircleshadowRemoteCheckQCirclePluginManager;
    }
  }
  
  /* Error */
  private EntityManager a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 114	com/tencent/biz/qcircleshadow/remoteCheck/QCirclePluginManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   6: ifnull +12 -> 18
    //   9: aload_0
    //   10: getfield 114	com/tencent/biz/qcircleshadow/remoteCheck/QCirclePluginManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   13: astore_1
    //   14: aload_0
    //   15: monitorexit
    //   16: aload_1
    //   17: areturn
    //   18: invokestatic 120	com/tencent/mobileqq/qcircle/api/impl/QCircleServiceImpl:getAppRunTime	()Lmqq/app/AppRuntime;
    //   21: invokevirtual 125	mqq/app/AppRuntime:getAccount	()Ljava/lang/String;
    //   24: ifnonnull +8 -> 32
    //   27: aconst_null
    //   28: astore_1
    //   29: goto -15 -> 14
    //   32: aload_0
    //   33: invokestatic 128	com/tencent/mobileqq/qcircle/api/impl/QCircleServiceImpl:getEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   36: putfield 114	com/tencent/biz/qcircleshadow/remoteCheck/QCirclePluginManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   39: aload_0
    //   40: getfield 114	com/tencent/biz/qcircleshadow/remoteCheck/QCirclePluginManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   43: astore_1
    //   44: goto -30 -> 14
    //   47: astore_1
    //   48: aload_0
    //   49: monitorexit
    //   50: aload_1
    //   51: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	52	0	this	QCirclePluginManager
    //   13	31	1	localEntityManager	EntityManager
    //   47	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	14	47	finally
    //   18	27	47	finally
    //   32	44	47	finally
  }
  
  private void a(QCirclePluginInfo paramQCirclePluginInfo)
  {
    ??? = this.jdField_a_of_type_JavaLangString + "/" + paramQCirclePluginInfo.version + "/" + paramQCirclePluginInfo.cookie + "/qcirle-plugin.zip";
    File localFile = new File((String)???);
    if ((!localFile.exists()) || (localFile.length() != paramQCirclePluginInfo.zipFileLength))
    {
      QCirclePluginQualityReporter.report(new QCirclePluginQualityReporter.ReportData().setEvent_id("qcircle_plugin_download").setRetCode(1L).setPluginVersion(paramQCirclePluginInfo.version));
      QCirclePluginDownloadManager.a().a(paramQCirclePluginInfo.zipFileUrl, (String)???, new QCirclePluginManager.2(this, paramQCirclePluginInfo, (String)???));
      ??? = this.jdField_a_of_type_JavaLangString + "/" + paramQCirclePluginInfo.version + "/qcirle-pluginmanager.apk";
      localFile = new File((String)???);
      if ((localFile.exists()) && (localFile.length() == paramQCirclePluginInfo.managerFilelength)) {
        break label276;
      }
      QCirclePluginQualityReporter.report(new QCirclePluginQualityReporter.ReportData().setEvent_id("qcircle_plugin_download").setRetCode(2L).setPluginVersion(paramQCirclePluginInfo.version));
      QCirclePluginDownloadManager.a().a(paramQCirclePluginInfo.managerFileUrl, (String)???, new QCirclePluginManager.3(this, paramQCirclePluginInfo, (String)???));
    }
    label276:
    do
    {
      return;
      paramQCirclePluginInfo.pluginZipPath = ((String)???);
      QCirclePluginQualityReporter.report(new QCirclePluginQualityReporter.ReportData().setEvent_id("qcircle_plugin_download").setRetCode(1003L).setPluginVersion(paramQCirclePluginInfo.version));
      break;
      paramQCirclePluginInfo.pluginManagerPath = ((String)???);
      QCirclePluginQualityReporter.report(new QCirclePluginQualityReporter.ReportData().setEvent_id("qcircle_plugin_download").setRetCode(2003L).setPluginVersion(paramQCirclePluginInfo.version));
    } while ((TextUtils.isEmpty(paramQCirclePluginInfo.pluginManagerPath)) || (TextUtils.isEmpty(paramQCirclePluginInfo.pluginZipPath)));
    paramQCirclePluginInfo.isReady = true;
    synchronized (b)
    {
      a().delete(QCirclePluginInfo.class.getSimpleName(), null, null);
      paramQCirclePluginInfo.setStatus(1000);
      a().persistOrReplace(paramQCirclePluginInfo);
      return;
    }
  }
  
  private void a(QQCircleConfig.GetRainbowTableConfigRsp paramGetRainbowTableConfigRsp)
  {
    if (paramGetRainbowTableConfigRsp.update.get() == 1)
    {
      if (!TextUtils.isEmpty(paramGetRainbowTableConfigRsp.data.get())) {
        try
        {
          JSONObject localJSONObject = new JSONObject(paramGetRainbowTableConfigRsp.data.get());
          int i = localJSONObject.getInt("version");
          paramGetRainbowTableConfigRsp = paramGetRainbowTableConfigRsp.cookie.get();
          String str1 = localJSONObject.getString("zipFileUrl");
          String str2 = localJSONObject.getString("managerFileUrl");
          long l1 = localJSONObject.getLong("zipFileLength");
          long l2 = localJSONObject.getLong("managerFilelength");
          QLog.e("QCirclePluginManager", 1, " version= " + i + " cookie= " + paramGetRainbowTableConfigRsp + " zipFileUrl= " + str1 + " managerFileUrl= " + str2 + "  zipFileLength =" + l1 + " managerFilelength =" + l2);
          paramGetRainbowTableConfigRsp = a(new QCirclePluginInfo(i, paramGetRainbowTableConfigRsp, str1, str2, l1, l2, HostDataTransUtils.getLongAccountUin()));
          if (paramGetRainbowTableConfigRsp == null)
          {
            QCirclePluginQualityReporter.report(new QCirclePluginQualityReporter.ReportData().setEvent_id("qcircle_plugin_cmd_rsp").setRetCode(2L));
            return;
          }
          QCirclePluginQualityReporter.report(new QCirclePluginQualityReporter.ReportData().setEvent_id("qcircle_plugin_cmd_rsp").setRetCode(0L).setPluginVersion(paramGetRainbowTableConfigRsp.version));
          a(paramGetRainbowTableConfigRsp);
          return;
        }
        catch (JSONException paramGetRainbowTableConfigRsp)
        {
          QCirclePluginQualityReporter.report(new QCirclePluginQualityReporter.ReportData().setEvent_id("qcircle_plugin_cmd_rsp").setRetCode(3L));
          QLog.e("QCirclePluginManager", 1, paramGetRainbowTableConfigRsp, new Object[0]);
          paramGetRainbowTableConfigRsp.printStackTrace();
          return;
        }
      }
      QLog.e("QCirclePluginManager", 1, "data =" + paramGetRainbowTableConfigRsp.data);
      QCirclePluginQualityReporter.report(new QCirclePluginQualityReporter.ReportData().setEvent_id("qcircle_plugin_cmd_rsp").setRetCode(4L));
      return;
    }
    paramGetRainbowTableConfigRsp = a(false);
    if ((paramGetRainbowTableConfigRsp != null) && (!paramGetRainbowTableConfigRsp.isReady)) {
      a(paramGetRainbowTableConfigRsp);
    }
    QCirclePluginQualityReporter.report(new QCirclePluginQualityReporter.ReportData().setEvent_id("qcircle_plugin_cmd_rsp").setRetCode(1L));
    QLog.e("QCirclePluginManager", 1, "update = 0");
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
  
  public QCirclePluginInfo a(boolean paramBoolean)
  {
    if (a())
    {
      localObject = null;
      return localObject;
    }
    Object localObject = a().query(QCirclePluginInfo.class);
    QCirclePluginInfo localQCirclePluginInfo;
    label249:
    long l2;
    long l1;
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      Iterator localIterator = ((List)localObject).iterator();
      for (;;)
      {
        if (localIterator.hasNext())
        {
          localQCirclePluginInfo = (QCirclePluginInfo)localIterator.next();
          if ((localQCirclePluginInfo != null) && ((!paramBoolean) || (localQCirclePluginInfo.isReady)) && (!localQCirclePluginInfo.isInvalid) && (localQCirclePluginInfo.mUin == HostDataTransUtils.getLongAccountUin()) && (localQCirclePluginInfo.qua.equals(QCircleServiceImpl.getQZoneService().getQUA3())))
          {
            localObject = localQCirclePluginInfo;
            if (!paramBoolean) {
              break;
            }
            QCirclePluginQualityReporter.report(new QCirclePluginQualityReporter.ReportData().setEvent_id("qcircle_plugin_get").setRetCode(0L).setPluginVersion(localQCirclePluginInfo.version));
            return localQCirclePluginInfo;
          }
          if ("qCirclePluginInfo= " + localQCirclePluginInfo + localQCirclePluginInfo != null)
          {
            localObject = "version=" + localQCirclePluginInfo.version + "isReady=" + localQCirclePluginInfo.isReady + "isInvalid=" + localQCirclePluginInfo.isInvalid;
            QLog.e("QCirclePluginManager", 1, (String)localObject);
            if (!paramBoolean) {
              continue;
            }
            if (localQCirclePluginInfo != null) {
              break label309;
            }
            l2 = 1L;
            l1 = -1L;
          }
        }
      }
    }
    for (;;)
    {
      QCirclePluginQualityReporter.report(new QCirclePluginQualityReporter.ReportData().setEvent_id("qcircle_plugin_get").setRetCode(l2).setPluginVersion(l1));
      break;
      localObject = "";
      break label249;
      label309:
      if (localQCirclePluginInfo.isInvalid)
      {
        l2 = 2L;
        l1 = localQCirclePluginInfo.version;
      }
      else if (!localQCirclePluginInfo.isReady)
      {
        l2 = 3L;
        l1 = localQCirclePluginInfo.version;
      }
      else if (localQCirclePluginInfo.mUin != HostDataTransUtils.getLongAccountUin())
      {
        l2 = 4L;
        l1 = localQCirclePluginInfo.version;
      }
      else if (!localQCirclePluginInfo.qua.equals(QCircleServiceImpl.getQZoneService().getQUA3()))
      {
        l2 = 5L;
        l1 = localQCirclePluginInfo.version;
        continue;
        QLog.e("QCirclePluginManager", 1, "size = 0");
        return null;
        return null;
      }
      else
      {
        l1 = -1L;
        l2 = 0L;
      }
    }
  }
  
  public void a()
  {
    if (System.currentTimeMillis() - this.jdField_a_of_type_Long < QCircleConfigHelper.a())
    {
      QLog.e("QCirclePluginManager", 1, "time =" + QCircleConfigHelper.a());
      if (a() != null) {
        localObject1 = (QCirclePluginInfo)a().find(QCirclePluginInfo.class, "4");
      }
      return;
    }
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    Object localObject1 = "";
    QCirclePluginInfo localQCirclePluginInfo = a(true);
    Object localObject2 = localObject1;
    if (localQCirclePluginInfo != null)
    {
      localObject2 = localObject1;
      if (!TextUtils.isEmpty(localQCirclePluginInfo.cookie)) {
        localObject2 = localQCirclePluginInfo.cookie;
      }
    }
    QLog.e("QCirclePluginManager", 1, "cookie=" + (String)localObject2);
    localObject1 = "DEV";
    if (((IAppSettingApi)QRoute.api(IAppSettingApi.class)).isGrayVersion()) {
      localObject1 = "GRAY";
    }
    for (;;)
    {
      QCirclePluginQualityReporter.report(new QCirclePluginQualityReporter.ReportData().setEvent_id("qcircle_plugin_cmd_req").setRetCode(0L));
      localObject1 = new QCircleGetRainBowRequest((String)localObject2, QCircleServiceImpl.getQZoneService().getQUA3(), (String)localObject1, HostDataTransUtils.getAccount(), ((IAppSettingApi)QRoute.api(IAppSettingApi.class)).getSubVersion());
      VSNetworkHelper.getInstance().sendRequest(MobileQQ.sMobileQQ, (BaseRequest)localObject1, new QCirclePluginManager.1(this, (QCircleGetRainBowRequest)localObject1));
      return;
      if (((IAppSettingApi)QRoute.api(IAppSettingApi.class)).isPublicVersion()) {
        localObject1 = "PUBLIC";
      } else if (!((IAppSettingApi)QRoute.api(IAppSettingApi.class)).isDebugVersion()) {
        localObject1 = "DEV_RELEASE";
      }
    }
  }
  
  public void a(int paramInt)
  {
    QLog.e("QCirclePluginManager", 1, "setQCirclePluginInvalid=" + paramInt);
    if (a()) {
      return;
    }
    QCirclePluginInfo localQCirclePluginInfo = (QCirclePluginInfo)a().find(QCirclePluginInfo.class, paramInt + "");
    if (localQCirclePluginInfo != null)
    {
      QLog.e("QCirclePluginManager", 1, "setQCirclePluginInvalid success" + paramInt);
      localQCirclePluginInfo.isInvalid = true;
      synchronized (b)
      {
        a().update(localQCirclePluginInfo);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.remoteCheck.QCirclePluginManager
 * JD-Core Version:    0.7.0.1
 */