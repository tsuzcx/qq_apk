package com.tencent.aelight.camera.ae.config;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.CameraConfig;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.GetCameraConfigRsp;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.GetCategoryMaterialRsp;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.GetPlayShowCatMatTreeRsp;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.tencent.aelight.camera.ae.AEPath.CAMERA;
import com.tencent.aelight.camera.ae.AEPath.GIF;
import com.tencent.aelight.camera.ae.AEPath.GIF.FILES;
import com.tencent.aelight.camera.ae.AEPath.PLAY;
import com.tencent.aelight.camera.ae.AEPath.PLAY.FILES;
import com.tencent.aelight.camera.ae.AEPath.Watermark;
import com.tencent.aelight.camera.ae.AEPath.Watermark.FILES;
import com.tencent.aelight.camera.ae.camera.ui.dashboard.AEDashboardUtil;
import com.tencent.aelight.camera.ae.camera.ui.dashboard.AEDashboardUtil.NetInfo;
import com.tencent.aelight.camera.ae.camera.ui.panel.AEARCakeMaterialManager;
import com.tencent.aelight.camera.ae.control.AEQIMManager;
import com.tencent.aelight.camera.ae.data.AEGiftMaterialConfigParser;
import com.tencent.aelight.camera.ae.data.AEGiftMaterialConfigParser.AEGiftMaterialConfigParserExpection;
import com.tencent.aelight.camera.ae.data.AEMaterialManager;
import com.tencent.aelight.camera.ae.data.AEWatermarkMaterialManager;
import com.tencent.aelight.camera.ae.report.AEBaseDataReporter;
import com.tencent.aelight.camera.ae.util.AECameraPrefsUtil;
import com.tencent.aelight.camera.ae.util.AECommonUtil;
import com.tencent.aelight.camera.aebase.AECaptureContext;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.PeakAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.util.GsonUtils;
import java.io.File;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import tencent.im.oidb.cmd0xf8c.oidb_cmd0xf8c.ReqBody;
import tencent.im.oidb.cmd0xf8c.oidb_cmd0xf8c.RspBody;

public class CameraDataServiceHandler
  extends BusinessHandler
{
  private static final String jdField_a_of_type_JavaLangString = CameraDataServiceHandler.class.getName();
  public static final Type a;
  private EntityManager jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
  protected Map<String, Long> a;
  
  static
  {
    jdField_a_of_type_JavaLangReflectType = new CameraDataServiceHandler.1().getType();
  }
  
  public CameraDataServiceHandler(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    LogUtils.setEnable(false);
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = paramAppInterface.getEntityManagerFactory().createEntityManager();
  }
  
  private boolean a(JsonObject paramJsonObject)
  {
    return AECommonUtil.a(GsonUtils.optString(paramJsonObject, "verFrom"), GsonUtils.optString(paramJsonObject, "verTo"));
  }
  
  private void c(FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    GetCategoryMaterialRsp localGetCategoryMaterialRsp = (GetCategoryMaterialRsp)paramObject;
    if ((localGetCategoryMaterialRsp != null) && (localGetCategoryMaterialRsp.Code == 0) && (localGetCategoryMaterialRsp.Categories != null) && (!localGetCategoryMaterialRsp.Categories.isEmpty()))
    {
      if (AEDashboardUtil.a()) {
        AEDashboardUtil.a().postValue(new AEDashboardUtil.NetInfo("ShadowBackendSvc.GetCategoryMaterial.MqStoryCamera", "response", "succeeded with content"));
      }
      AECameraPrefsUtil.a().a("ShadowBackendSvc.GetCategoryMaterialMqStoryCamera", localGetCategoryMaterialRsp.ETag, 4);
      paramObject = new Gson().toJson(localGetCategoryMaterialRsp);
      FileUtils.writeFile(AEMaterialManager.b(), paramObject);
      paramObject = (AEMaterialManager)AEQIMManager.a().b(1);
      if (paramObject != null) {
        paramObject.a(true);
      }
    }
    else if (AEDashboardUtil.a())
    {
      localObject = AEDashboardUtil.a();
      if (paramFromServiceMsg.isSuccess()) {
        paramObject = "succeeded without content";
      } else {
        paramObject = "failed";
      }
      ((MutableLiveData)localObject).postValue(new AEDashboardUtil.NetInfo("ShadowBackendSvc.GetCategoryMaterial.MqStoryCamera", "response", paramObject));
    }
    paramObject = (AEMaterialManager)AEQIMManager.a(1);
    paramObject.b();
    paramObject.b(AEPath.CAMERA.jdField_a_of_type_JavaLangString);
    paramObject = this.jdField_a_of_type_JavaUtilMap;
    if ((paramObject != null) && (paramObject.containsKey("ShadowBackendSvc.GetCategoryMaterial.MqStoryCamera")))
    {
      paramObject = new StringBuilder();
      paramObject.append("");
      paramObject.append(System.currentTimeMillis() - ((Long)this.jdField_a_of_type_JavaUtilMap.get("ShadowBackendSvc.GetCategoryMaterial.MqStoryCamera")).longValue());
      paramObject = paramObject.toString();
    }
    else
    {
      paramObject = "-1";
    }
    Object localObject = AEBaseDataReporter.a();
    int j = paramFromServiceMsg.getResultCode();
    int i;
    if (localGetCategoryMaterialRsp != null) {
      i = localGetCategoryMaterialRsp.Code;
    } else {
      i = -1024;
    }
    ((AEBaseDataReporter)localObject).a(j, paramObject, "ShadowBackendSvc.GetCategoryMaterial.MqStoryCamera", i);
  }
  
  private void d(FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    GetCategoryMaterialRsp localGetCategoryMaterialRsp = (GetCategoryMaterialRsp)paramObject;
    if ((localGetCategoryMaterialRsp != null) && (localGetCategoryMaterialRsp.Code == 0) && (localGetCategoryMaterialRsp.Categories != null) && (!localGetCategoryMaterialRsp.Categories.isEmpty()))
    {
      if (AEDashboardUtil.a()) {
        AEDashboardUtil.a().postValue(new AEDashboardUtil.NetInfo("ShadowBackendSvc.GetCategoryMaterial.MqEmoCamera", "response", "succeeded with content"));
      }
      AECameraPrefsUtil.a().a("ShadowBackendSvc.GetCategoryMaterialMqEmoCamera", localGetCategoryMaterialRsp.ETag, 4);
      paramObject = new Gson().toJson(localGetCategoryMaterialRsp);
      localObject = new File(AEPath.GIF.FILES.g);
      if (!((File)localObject).exists()) {
        ((File)localObject).mkdirs();
      }
      FileUtils.writeFile(AEPath.GIF.b, paramObject);
    }
    else if (AEDashboardUtil.a())
    {
      localObject = AEDashboardUtil.a();
      if (paramFromServiceMsg.isSuccess()) {
        paramObject = "succeeded without content";
      } else {
        paramObject = "failed";
      }
      ((MutableLiveData)localObject).postValue(new AEDashboardUtil.NetInfo("ShadowBackendSvc.GetCategoryMaterial.MqEmoCamera", "response", paramObject));
    }
    CameraOperationHelper.a().postValue(Boolean.valueOf(true));
    paramObject = this.jdField_a_of_type_JavaUtilMap;
    if ((paramObject != null) && (paramObject.containsKey("ShadowBackendSvc.GetCategoryMaterial.MqEmoCamera")))
    {
      paramObject = new StringBuilder();
      paramObject.append("");
      paramObject.append(System.currentTimeMillis() - ((Long)this.jdField_a_of_type_JavaUtilMap.get("ShadowBackendSvc.GetCategoryMaterial.MqEmoCamera")).longValue());
      paramObject = paramObject.toString();
    }
    else
    {
      paramObject = "-1";
    }
    Object localObject = AEBaseDataReporter.a();
    int j = paramFromServiceMsg.getResultCode();
    int i;
    if (localGetCategoryMaterialRsp != null) {
      i = localGetCategoryMaterialRsp.Code;
    } else {
      i = -1024;
    }
    ((AEBaseDataReporter)localObject).a(j, paramObject, "ShadowBackendSvc.GetCategoryMaterial.MqEmoCamera", i);
  }
  
  private void e(FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    GetCategoryMaterialRsp localGetCategoryMaterialRsp = (GetCategoryMaterialRsp)paramObject;
    if ((localGetCategoryMaterialRsp != null) && (localGetCategoryMaterialRsp.Code == 0) && (localGetCategoryMaterialRsp.Categories != null) && (!localGetCategoryMaterialRsp.Categories.isEmpty()))
    {
      if (AEDashboardUtil.a()) {
        AEDashboardUtil.a().postValue(new AEDashboardUtil.NetInfo("ShadowBackendSvc.GetCategoryMaterial.MqCircleWatermark", "response", "succeeded with content"));
      }
      AECameraPrefsUtil.a().a("ShadowBackendSvc.GetCategoryMaterialMqCircleWatermark", localGetCategoryMaterialRsp.ETag, 4);
      paramObject = new Gson().toJson(localGetCategoryMaterialRsp);
      localObject = new File(AEPath.Watermark.FILES.c);
      if (!((File)localObject).exists()) {
        ((File)localObject).mkdirs();
      }
      FileUtils.writeFile(AEPath.Watermark.b, paramObject);
      if ((AECaptureContext.a() instanceof PeakAppInterface)) {
        AEWatermarkMaterialManager.a().a();
      }
    }
    else if (AEDashboardUtil.a())
    {
      localObject = AEDashboardUtil.a();
      if (paramFromServiceMsg.isSuccess()) {
        paramObject = "succeeded without content";
      } else {
        paramObject = "failed";
      }
      ((MutableLiveData)localObject).postValue(new AEDashboardUtil.NetInfo("ShadowBackendSvc.GetCategoryMaterial.MqCircleWatermark", "response", paramObject));
    }
    paramObject = this.jdField_a_of_type_JavaUtilMap;
    if ((paramObject != null) && (paramObject.containsKey("ShadowBackendSvc.GetCategoryMaterial.MqCircleWatermark")))
    {
      paramObject = new StringBuilder();
      paramObject.append("");
      paramObject.append(System.currentTimeMillis() - ((Long)this.jdField_a_of_type_JavaUtilMap.get("ShadowBackendSvc.GetCategoryMaterial.MqCircleWatermark")).longValue());
      paramObject = paramObject.toString();
    }
    else
    {
      paramObject = "-1";
    }
    Object localObject = AEBaseDataReporter.a();
    int j = paramFromServiceMsg.getResultCode();
    int i;
    if (localGetCategoryMaterialRsp != null) {
      i = localGetCategoryMaterialRsp.Code;
    } else {
      i = -1024;
    }
    ((AEBaseDataReporter)localObject).a(j, paramObject, "ShadowBackendSvc.GetCategoryMaterial.MqCircleWatermark", i);
  }
  
  private void f(FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isDebugVersion()) {
      QLog.d(jdField_a_of_type_JavaLangString, 4, "[handlePlayShowCategoryMaterials] start");
    }
    GetPlayShowCatMatTreeRsp localGetPlayShowCatMatTreeRsp = (GetPlayShowCatMatTreeRsp)paramObject;
    if ((localGetPlayShowCatMatTreeRsp != null) && (localGetPlayShowCatMatTreeRsp.Code == 0) && (!localGetPlayShowCatMatTreeRsp.Categories.isEmpty()))
    {
      if (QLog.isDebugVersion())
      {
        paramObject = jdField_a_of_type_JavaLangString;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[handlePlayShowCategoryMaterials] response=");
        ((StringBuilder)localObject).append(localGetPlayShowCatMatTreeRsp);
        QLog.d(paramObject, 4, ((StringBuilder)localObject).toString());
      }
      if (AEDashboardUtil.a()) {
        AEDashboardUtil.a().postValue(new AEDashboardUtil.NetInfo("ShadowBackendSvc.GetPlayShowCatMatTree", "response", "succeeded with content"));
      }
      AECameraPrefsUtil.a().a("ShadowBackendSvc.GetPlayShowCatMatTree", localGetPlayShowCatMatTreeRsp.ETag, 4);
      paramObject = GsonUtils.obj2Json(localGetPlayShowCatMatTreeRsp, jdField_a_of_type_JavaLangReflectType);
      localObject = new File(AEPath.PLAY.FILES.d);
      if (!((File)localObject).exists()) {
        ((File)localObject).mkdirs();
      }
      FileUtils.writeFile(AEPath.PLAY.b, paramObject);
    }
    else
    {
      if (QLog.isDebugVersion()) {
        QLog.d(jdField_a_of_type_JavaLangString, 4, "[handlePlayShowCategoryMaterials] response=empty");
      }
      if (AEDashboardUtil.a())
      {
        localObject = AEDashboardUtil.a();
        if (paramFromServiceMsg.isSuccess()) {
          paramObject = "succeeded without content";
        } else {
          paramObject = "failed";
        }
        ((MutableLiveData)localObject).postValue(new AEDashboardUtil.NetInfo("ShadowBackendSvc.GetPlayShowCatMatTree", "response", paramObject));
      }
    }
    CameraOperationHelper.b().postValue(Boolean.valueOf(true));
    paramObject = this.jdField_a_of_type_JavaUtilMap;
    if ((paramObject != null) && (paramObject.containsKey("ShadowBackendSvc.GetPlayShowCatMatTree")))
    {
      paramObject = new StringBuilder();
      paramObject.append("");
      paramObject.append(System.currentTimeMillis() - ((Long)this.jdField_a_of_type_JavaUtilMap.get("ShadowBackendSvc.GetPlayShowCatMatTree")).longValue());
      paramObject = paramObject.toString();
    }
    else
    {
      paramObject = "-1";
    }
    Object localObject = AEBaseDataReporter.a();
    int j = paramFromServiceMsg.getResultCode();
    int i;
    if (localGetPlayShowCatMatTreeRsp == null) {
      i = -1024;
    } else {
      i = localGetPlayShowCatMatTreeRsp.Code;
    }
    ((AEBaseDataReporter)localObject).a(j, paramObject, "ShadowBackendSvc.GetPlayShowCatMatTree", i);
    if (QLog.isDebugVersion()) {
      QLog.d(jdField_a_of_type_JavaLangString, 4, "[handlePlayShowCategoryMaterials] end");
    }
  }
  
  public void a()
  {
    AEQLog.b(jdField_a_of_type_JavaLangString, "arcake: requestARCakeMaterial--begin");
    Object localObject1 = BaseApplicationImpl.getApplication().getRuntime().getCurrentUin();
    new ArrayList().add(Long.valueOf(Long.parseLong((String)localObject1)));
    oidb_cmd0xf8c.ReqBody localReqBody = new oidb_cmd0xf8c.ReqBody();
    String str = jdField_a_of_type_JavaLangString;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("arcake: requestARCakeMaterial--uin");
    ((StringBuilder)localObject2).append(Long.parseLong((String)localObject1));
    AEQLog.a(str, ((StringBuilder)localObject2).toString());
    str = AECameraPrefsUtil.a().a("key_ae_arcake_id", null, 4);
    AEGiftMaterialConfigParser.a(str);
    localObject2 = jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("arcake: requestARCakeMaterial--arCakeId");
    localStringBuilder.append(str);
    AEQLog.a((String)localObject2, localStringBuilder.toString());
    if (!TextUtils.isEmpty(str)) {
      localReqBody.cakeID.set(str);
    }
    localReqBody.uin.set(Long.parseLong((String)localObject1));
    str = "2.2.6.40";
    localObject1 = str;
    if (!TextUtils.isEmpty("2.2.6.40"))
    {
      localObject2 = "2.2.6.40".split("\\.");
      localObject1 = str;
      if (localObject2.length > 3)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(localObject2[0]);
        ((StringBuilder)localObject1).append(".");
        ((StringBuilder)localObject1).append(localObject2[1]);
        ((StringBuilder)localObject1).append(".");
        ((StringBuilder)localObject1).append(localObject2[2]);
        localObject1 = ((StringBuilder)localObject1).toString();
      }
    }
    str = jdField_a_of_type_JavaLangString;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("arcake: requestARCakeMaterial--sdkVersion");
    ((StringBuilder)localObject2).append((String)localObject1);
    AEQLog.a(str, ((StringBuilder)localObject2).toString());
    localReqBody.sdk_version.set((String)localObject1);
    localReqBody.zhongtai_number.set((String)localObject1);
    localReqBody.clientplat.set("8.7.0");
    localReqBody.PlatformFlag.set(1);
    sendPbReq(makeOIDBPkg("OidbSvc.oidb_cmd0xf8c", 3980, 1, localReqBody.toByteArray()));
    AEQLog.a(jdField_a_of_type_JavaLangString, "arcake: requestARCakeMaterial--end");
  }
  
  protected void a(FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    AEQLog.a(jdField_a_of_type_JavaLangString, "arcake: handleARCakeMaterial");
    if (!paramFromServiceMsg.isSuccess())
    {
      AEQLog.d(jdField_a_of_type_JavaLangString, "arcake: handleARCakeMaterial not success ");
      return;
    }
    Object localObject = new oidb_cmd0xf8c.RspBody();
    int i = parseOIDBPkg(paramFromServiceMsg, paramObject, (MessageMicro)localObject);
    paramFromServiceMsg = jdField_a_of_type_JavaLangString;
    paramObject = new StringBuilder();
    paramObject.append("arcake: result :");
    paramObject.append(i);
    AEQLog.a(paramFromServiceMsg, paramObject.toString());
    try
    {
      AEGiftMaterialConfigParser.a((oidb_cmd0xf8c.RspBody)localObject);
      if ((AECaptureContext.a() instanceof PeakAppInterface))
      {
        AEARCakeMaterialManager.a().b();
        return;
      }
    }
    catch (AEGiftMaterialConfigParser.AEGiftMaterialConfigParserExpection paramFromServiceMsg)
    {
      paramObject = jdField_a_of_type_JavaLangString;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("arcake: exception  :");
      ((StringBuilder)localObject).append(paramFromServiceMsg.getMessage());
      AEQLog.d(paramObject, ((StringBuilder)localObject).toString());
    }
  }
  
  public void a(String paramString)
  {
    if (!NetworkUtil.isNetworkAvailable())
    {
      LogUtils.w(jdField_a_of_type_JavaLangString, "[reqCompressedMaterials] no network....");
      return;
    }
    Object localObject = jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("【REQUEST】requestCompressedMaterials");
    localStringBuilder.append(paramString);
    AEQLog.b((String)localObject, localStringBuilder.toString());
    if (AEDashboardUtil.a())
    {
      localObject = AEDashboardUtil.a();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("ShadowBackendSvc.GetCategoryMaterial.");
      localStringBuilder.append(paramString);
      ((MutableLiveData)localObject).postValue(new AEDashboardUtil.NetInfo(localStringBuilder.toString(), "request", "null"));
    }
    localObject = this.jdField_a_of_type_JavaUtilMap;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("ShadowBackendSvc.GetCategoryMaterial.");
    localStringBuilder.append(paramString);
    ((Map)localObject).put(localStringBuilder.toString(), Long.valueOf(System.currentTimeMillis()));
    localObject = new ToServiceMsg("ShadowBackendSvc", this.appRuntime.getAccount(), "ShadowBackendSvc.GetCategoryMaterial");
    ((ToServiceMsg)localObject).extraData.putString("ServiceId", paramString);
    send((ToServiceMsg)localObject);
  }
  
  public void b()
  {
    if (!NetworkUtil.isNetworkAvailable())
    {
      LogUtils.w(jdField_a_of_type_JavaLangString, "[reqCameraConfig] no network....");
      return;
    }
    if (AEDashboardUtil.a()) {
      AEDashboardUtil.a().postValue(new AEDashboardUtil.NetInfo("ShadowBackendSvc.GetCameraConfig", "request", "null"));
    }
    AEQLog.b(jdField_a_of_type_JavaLangString, "【REQUEST】reqCameraConfig");
    this.jdField_a_of_type_JavaUtilMap.put("ShadowBackendSvc.GetCameraConfig", Long.valueOf(System.currentTimeMillis()));
    ToServiceMsg localToServiceMsg = new ToServiceMsg("ShadowBackendSvc", this.appRuntime.getAccount(), "ShadowBackendSvc.GetCameraConfig");
    localToServiceMsg.extraData.putBoolean("req_pb_protocol_flag", false);
    send(localToServiceMsg);
  }
  
  protected void b(FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    Object localObject1 = jdField_a_of_type_JavaLangString;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("【Handle】handleCameraConfig:");
    ((StringBuilder)localObject2).append(paramFromServiceMsg.isSuccess());
    AEQLog.b((String)localObject1, ((StringBuilder)localObject2).toString());
    if (!paramFromServiceMsg.isSuccess())
    {
      if (AEDashboardUtil.a()) {
        AEDashboardUtil.a().postValue(new AEDashboardUtil.NetInfo("ShadowBackendSvc.GetCameraConfig", "response", "failed"));
      }
      return;
    }
    GetCameraConfigRsp localGetCameraConfigRsp = (GetCameraConfigRsp)paramObject;
    if (localGetCameraConfigRsp.ConfigMap != null)
    {
      if (AEDashboardUtil.a()) {
        AEDashboardUtil.a().postValue(new AEDashboardUtil.NetInfo("ShadowBackendSvc.GetCameraConfig", "response", "succeeded with content"));
      }
      Iterator localIterator = localGetCameraConfigRsp.ConfigMap.entrySet().iterator();
      localObject2 = "";
      localObject1 = localObject2;
      Object localObject4;
      for (paramObject = localObject1; localIterator.hasNext(); paramObject = localObject4)
      {
        Object localObject3 = (Map.Entry)localIterator.next();
        Object localObject5 = (CameraConfig)((Map.Entry)localObject3).getValue();
        if (TextUtils.isEmpty((CharSequence)localObject2))
        {
          localObject2 = ((CameraConfig)localObject5).ExpId;
        }
        else
        {
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append((String)localObject2);
          ((StringBuilder)localObject4).append(",");
          ((StringBuilder)localObject4).append(((CameraConfig)localObject5).ExpId);
          localObject2 = ((StringBuilder)localObject4).toString();
        }
        String str = (String)((Map.Entry)localObject3).getKey();
        if ("app_ui_playshow_ad_id".equals(str)) {
          localObject1 = ((CameraConfig)localObject5).ConfigContent;
        }
        for (;;)
        {
          localObject3 = localObject1;
          localObject4 = paramObject;
          break label1496;
          if (!"app_alg_entrance_qzone_id_from833".equals(str)) {
            break;
          }
          paramObject = ((CameraConfig)localObject5).ConfigContent;
        }
        boolean bool = "app_ui_camera_ad_id".equals(str);
        int j = 0;
        int k = 0;
        int m = 0;
        i = 0;
        if (bool) {}
        try
        {
          localObject5 = new JsonParser().parse(((CameraConfig)localObject5).ConfigContent).getAsJsonArray();
          if ((localObject5 == null) || (((JsonArray)localObject5).size() <= 0)) {
            break label518;
          }
          j = ((JsonArray)localObject5).size();
        }
        catch (Exception localException1)
        {
          for (;;)
          {
            label518:
            label963:
            continue;
            i += 1;
            continue;
            i += 1;
            continue;
            i += 1;
            continue;
            i += 1;
          }
        }
        localObject3 = localObject1;
        localObject4 = paramObject;
        if (i < j)
        {
          localObject3 = (JsonObject)((JsonArray)localObject5).get(i);
          if (!a((JsonObject)localObject3)) {
            break label1667;
          }
          AECameraPrefsUtil.a().a("camera_ad_op_id", GsonUtils.optString((JsonObject)localObject3, "opID"), 4);
          AECameraPrefsUtil.a().a("camera_ad_show", GsonUtils.optBoolean((JsonObject)localObject3, "showOp"), 4);
          AECameraPrefsUtil.a().a("camera_ad_icon_url", GsonUtils.optString((JsonObject)localObject3, "opIcon"), 4);
          AECameraPrefsUtil.a().a("camera_ad_type", GsonUtils.optString((JsonObject)localObject3, "type"), 4);
          AECameraPrefsUtil.a().a("camera_ad_schema", GsonUtils.optString((JsonObject)localObject3, "schema"), 4);
          AECameraPrefsUtil.a().a("camera_ad_activity_id", GsonUtils.optString((JsonObject)localObject3, "activity_id"), 4);
          localObject3 = localObject1;
          localObject4 = paramObject;
          break label1496;
          AECameraPrefsUtil.a().a("camera_ad_op_id", "", 4);
          AECameraPrefsUtil.a().a("camera_ad_show", false, 4);
          AECameraPrefsUtil.a().a("camera_ad_icon_url", "", 4);
          AECameraPrefsUtil.a().a("camera_ad_type", "", 4);
          AECameraPrefsUtil.a().a("camera_ad_schema", "", 4);
          AECameraPrefsUtil.a().a("camera_ad_activity_id", "", 4);
          localObject3 = localObject1;
          localObject4 = paramObject;
          break label1496;
          AEQLog.d(jdField_a_of_type_JavaLangString, "camera ad ab test inflate error.");
          localObject3 = localObject1;
          localObject4 = paramObject;
          break label1496;
          if (!"app_ui_pendant_btn_ad_id".equals(str)) {}
        }
        try
        {
          localObject5 = new JsonParser().parse(((CameraConfig)localObject5).ConfigContent).getAsJsonArray();
          if ((localObject5 != null) && (((JsonArray)localObject5).size() > 0))
          {
            k = ((JsonArray)localObject5).size();
            i = j;
            localObject3 = localObject1;
            localObject4 = paramObject;
            if (i < k)
            {
              localObject3 = (JsonObject)((JsonArray)localObject5).get(i);
              if (!a((JsonObject)localObject3)) {
                break label1674;
              }
              AECameraPrefsUtil.a().a("camera_ad_pendent_op_id", GsonUtils.optString((JsonObject)localObject3, "opID"), 4);
              AECameraPrefsUtil.a().a("camera_ad_pendent_show", GsonUtils.optBoolean((JsonObject)localObject3, "showOp"), 4);
              AECameraPrefsUtil.a().a("camera_ad_pendent_type", GsonUtils.optString((JsonObject)localObject3, "type"), 4);
              AECameraPrefsUtil.a().a("camera_ad_pendent_icon_url", GsonUtils.optString((JsonObject)localObject3, "opIcon"), 4);
              AECameraPrefsUtil.a().a("camera_ad_pendent_schema", GsonUtils.optString((JsonObject)localObject3, "schema"), 4);
              AECameraPrefsUtil.a().a("camera_ad_pendent_icon_type", GsonUtils.optString((JsonObject)localObject3, "iconType"), 4);
              AECameraPrefsUtil.a().a("camera_ad_pendent_categoryId", GsonUtils.optInt((JsonObject)localObject3, "categoryId"), 4);
              AECameraPrefsUtil.a().a("camera_ad_pendent_activity_id", GsonUtils.optString((JsonObject)localObject3, "activity_id"), 4);
              localObject3 = localObject1;
              localObject4 = paramObject;
            }
          }
          else
          {
            AECameraPrefsUtil.a().a("camera_ad_pendent_op_id", "", 4);
            AECameraPrefsUtil.a().a("camera_ad_pendent_show", false, 4);
            AECameraPrefsUtil.a().a("camera_ad_pendent_type", "", 4);
            AECameraPrefsUtil.a().a("camera_ad_pendent_icon_url", "", 4);
            AECameraPrefsUtil.a().a("camera_ad_pendent_schema", "", 4);
            AECameraPrefsUtil.a().a("camera_ad_pendent_icon_type", "", 4);
            AECameraPrefsUtil.a().a("camera_ad_pendent_categoryId", -1, 4);
            AECameraPrefsUtil.a().a("camera_ad_pendent_activity_id", "", 4);
            localObject3 = localObject1;
            localObject4 = paramObject;
          }
        }
        catch (Exception localException2)
        {
          break label963;
        }
        AEQLog.d(jdField_a_of_type_JavaLangString, "camera pendent ad ab test inflate error.");
        localObject3 = localObject1;
        localObject4 = paramObject;
        break label1496;
        if ("app_alg_filter_timeout_id".equals(str))
        {
          localObject3 = ((CameraConfig)localObject5).ConfigContent;
          AECameraPrefsUtil.a().a("app_alg_filter_timeout_id", (String)localObject3, 4);
          localObject3 = localObject1;
          localObject4 = paramObject;
        }
        else if (!"app_ui_camera_circle_ad_id".equals(str)) {}
        try
        {
          localObject5 = new JsonParser().parse(((CameraConfig)localObject5).ConfigContent).getAsJsonArray();
          if ((localObject5 != null) && (((JsonArray)localObject5).size() > 0))
          {
            j = ((JsonArray)localObject5).size();
            i = k;
            localObject3 = localObject1;
            localObject4 = paramObject;
            if (i < j)
            {
              localObject3 = (JsonObject)((JsonArray)localObject5).get(i);
              if (!a((JsonObject)localObject3)) {
                break label1681;
              }
              AECameraPrefsUtil.a().a("circle_camera_ad_op_id", GsonUtils.optString((JsonObject)localObject3, "opID"), 4);
              AECameraPrefsUtil.a().a("circle_camera_ad_icon_url", GsonUtils.optString((JsonObject)localObject3, "opIcon"), 4);
              AECameraPrefsUtil.a().a("circle_camera_ad_type", GsonUtils.optString((JsonObject)localObject3, "type"), 4);
              AECameraPrefsUtil.a().a("circle_camera_ad_schema", GsonUtils.optString((JsonObject)localObject3, "schema"), 4);
              AECameraPrefsUtil.a().a("circle_camera_ad_show", GsonUtils.optBoolean((JsonObject)localObject3, "showOp"), 4);
              AECameraPrefsUtil.a().a("circle_camera_ad_activity_id", GsonUtils.optString((JsonObject)localObject3, "activity_id"), 4);
              localObject3 = localObject1;
              localObject4 = paramObject;
            }
          }
          else
          {
            AECameraPrefsUtil.a().a("circle_camera_ad_op_id", "", 4);
            AECameraPrefsUtil.a().a("circle_camera_ad_icon_url", "", 4);
            AECameraPrefsUtil.a().a("circle_camera_ad_type", "", 4);
            AECameraPrefsUtil.a().a("circle_camera_ad_schema", "", 4);
            AECameraPrefsUtil.a().a("circle_camera_ad_show", false, 4);
            AECameraPrefsUtil.a().a("circle_camera_ad_activity_id", "", 4);
            localObject3 = localObject1;
            localObject4 = paramObject;
          }
        }
        catch (Exception localException3)
        {
          label1308:
          break label1308;
        }
        AEQLog.d(jdField_a_of_type_JavaLangString, "camera ad ab test inflate error.");
        localObject3 = localObject1;
        localObject4 = paramObject;
        break label1496;
        localObject3 = localObject1;
        localObject4 = paramObject;
        if ("app_ui_camera_circle_entry_id".equals(str)) {}
        try
        {
          localObject5 = new JsonParser().parse(((CameraConfig)localObject5).ConfigContent).getAsJsonArray();
          if ((localObject5 != null) && (((JsonArray)localObject5).size() > 0))
          {
            j = ((JsonArray)localObject5).size();
            i = m;
            localObject3 = localObject1;
            localObject4 = paramObject;
            if (i < j)
            {
              localObject3 = (JsonObject)((JsonArray)localObject5).get(i);
              if (!a((JsonObject)localObject3)) {
                break label1688;
              }
              localObject3 = GsonUtils.optString((JsonObject)localObject3, "ABContent");
              AECameraPrefsUtil.a().a("circle_entry_type_camera", "camera".endsWith((String)localObject3), 4);
              localObject3 = localObject1;
              localObject4 = paramObject;
            }
          }
          else
          {
            AECameraPrefsUtil.a().a("circle_entry_type_camera", false, 4);
            localObject3 = localObject1;
            localObject4 = paramObject;
          }
        }
        catch (Exception localException4)
        {
          label1480:
          label1496:
          long l2;
          long l1;
          break label1480;
        }
        AEQLog.d(jdField_a_of_type_JavaLangString, "camera entry ab test inflate error.");
        localObject4 = paramObject;
        localObject3 = localObject1;
        localObject1 = localObject3;
      }
      AECameraPrefsUtil.a().a("ShadowBackendSvc.GetCameraConfig", (String)localObject2, 4);
      AECameraPrefsUtil.a().a("app_ui_playshow_ad_id", (String)localObject1, 4);
      AECameraPrefsUtil.a().a("app_alg_entrance_qzone_id_from833", paramObject, 4);
    }
    else if (AEDashboardUtil.a())
    {
      AEDashboardUtil.a().postValue(new AEDashboardUtil.NetInfo("ShadowBackendSvc.GetCameraConfig", "response", "succeeded without content"));
    }
    paramObject = AEBaseDataReporter.a();
    i = paramFromServiceMsg.getResultCode();
    l2 = System.currentTimeMillis();
    if (this.jdField_a_of_type_JavaUtilMap.containsKey("ShadowBackendSvc.GetCameraConfig")) {
      l1 = ((Long)this.jdField_a_of_type_JavaUtilMap.get("ShadowBackendSvc.GetCameraConfig")).longValue();
    } else {
      l1 = 0L;
    }
    paramObject.a(i, String.valueOf(l2 - l1), "ShadowBackendSvc.GetCameraConfig", localGetCameraConfigRsp.Code);
  }
  
  public void c()
  {
    if (!NetworkUtil.isNetworkAvailable())
    {
      if (QLog.isDebugVersion())
      {
        QLog.d(jdField_a_of_type_JavaLangString, 4, "[reqPlayShowCategoryMaterials] no network....");
        QLog.d(jdField_a_of_type_JavaLangString, 4, "[reqPlayShowCategoryMaterials] end");
      }
      return;
    }
    AEQLog.b(jdField_a_of_type_JavaLangString, "【REQUEST】reqPlayShowCategoryMaterials");
    if (AEDashboardUtil.a()) {
      AEDashboardUtil.a().postValue(new AEDashboardUtil.NetInfo("ShadowBackendSvc.GetPlayShowCatMatTree", "request", "null"));
    }
    this.jdField_a_of_type_JavaUtilMap.put("ShadowBackendSvc.GetPlayShowCatMatTree", Long.valueOf(System.currentTimeMillis()));
    ToServiceMsg localToServiceMsg = new ToServiceMsg("ShadowBackendSvc", this.appRuntime.getAccount(), "ShadowBackendSvc.GetPlayShowCatMatTree");
    localToServiceMsg.extraData.putBoolean("req_pb_protocol_flag", false);
    send(localToServiceMsg);
  }
  
  public void d()
  {
    ThreadManager.getFileThreadHandler().post(new CameraDataServiceHandler.2(this));
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return null;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    d();
    if (paramFromServiceMsg.getServiceCmd().equals("ShadowBackendSvc.GetCategoryMaterial"))
    {
      paramToServiceMsg = paramToServiceMsg.extraData.getString("ServiceId");
      if (paramToServiceMsg.endsWith("MqStoryCamera"))
      {
        c(paramFromServiceMsg, paramObject);
        return;
      }
      if (paramToServiceMsg.endsWith("MqEmoCamera"))
      {
        d(paramFromServiceMsg, paramObject);
        return;
      }
      if (paramToServiceMsg.endsWith("MqCircleWatermark")) {
        e(paramFromServiceMsg, paramObject);
      }
    }
    else
    {
      if (paramFromServiceMsg.getServiceCmd().equals("ShadowBackendSvc.GetCameraConfig"))
      {
        b(paramFromServiceMsg, paramObject);
        return;
      }
      if (paramToServiceMsg.getServiceCmd().equals("ShadowBackendSvc.GetPlayShowCatMatTree"))
      {
        f(paramFromServiceMsg, paramObject);
        return;
      }
      if (paramToServiceMsg.getServiceCmd().equals("OidbSvc.oidb_cmd0xf8c")) {
        a(paramFromServiceMsg, paramObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.config.CameraDataServiceHandler
 * JD-Core Version:    0.7.0.1
 */