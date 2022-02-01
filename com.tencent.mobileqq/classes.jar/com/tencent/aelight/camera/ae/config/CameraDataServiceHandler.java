package com.tencent.aelight.camera.ae.config;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.CameraConfig;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.GetCameraConfigRsp;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.GetCategoryMaterialRsp;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.GetPlayShowCatMatTreeRsp;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.GetTABConfigurationRsp;
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
import com.tencent.aelight.camera.ae.camera.ui.flashshow.AEFlashShowMaterialManager;
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
import java.util.Collection;
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
  public static final Type a = new CameraDataServiceHandler.1().getType();
  private static final String d = CameraDataServiceHandler.class.getName();
  protected Map<String, Long> b = new HashMap();
  private EntityManager c;
  
  public CameraDataServiceHandler(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
    LogUtils.setEnable(false);
    this.c = paramAppInterface.getEntityManagerFactory().createEntityManager();
  }
  
  private boolean a(JsonObject paramJsonObject)
  {
    return AECommonUtil.a(GsonUtils.optString(paramJsonObject, "verFrom"), GsonUtils.optString(paramJsonObject, "verTo"));
  }
  
  private void c(FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (!(paramObject instanceof GetTABConfigurationRsp)) {
      return;
    }
    paramObject = (GetTABConfigurationRsp)paramObject;
    if (paramFromServiceMsg.isSuccess())
    {
      paramFromServiceMsg = paramObject.ConfigMap;
      Object localObject;
      if ((paramFromServiceMsg != null) && (paramFromServiceMsg.containsKey("New_beauty_0526")))
      {
        paramObject = (CameraConfig)paramFromServiceMsg.get("New_beauty_0526");
        if (paramObject != null)
        {
          localObject = d;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("handleTabABTest---content: ");
          localStringBuilder.append(paramObject.ConfigContent);
          AEQLog.b((String)localObject, localStringBuilder.toString());
          if ("New_beauty_0526_A".equals(paramObject.ConfigContent)) {
            AEDashboardUtil.b(false);
          } else {
            AEDashboardUtil.b(true);
          }
        }
        else
        {
          AEQLog.d(d, "handleTabABTest---cameraConfig is null.");
        }
        AEQLog.b(d, paramFromServiceMsg.toString());
      }
      else
      {
        AEQLog.b(d, "tab AB Test map is null.");
      }
      if (paramFromServiceMsg != null)
      {
        paramObject = new StringBuilder();
        paramFromServiceMsg = paramFromServiceMsg.values().iterator();
        while (paramFromServiceMsg.hasNext())
        {
          paramObject.append(((CameraConfig)paramFromServiceMsg.next()).ExpId);
          paramObject.append(",");
        }
        if (paramObject.length() > 0) {
          paramObject.deleteCharAt(paramObject.length() - 1);
        }
        paramFromServiceMsg = paramObject.toString();
        paramObject = d;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("handleTabABTest---tabExpIds=");
        ((StringBuilder)localObject).append(paramFromServiceMsg);
        AEQLog.b(paramObject, ((StringBuilder)localObject).toString());
        AECameraPrefsUtil.a().a("sp_key_ae_camera_tab_experiment_ids", paramFromServiceMsg, 4);
      }
    }
    else
    {
      AEQLog.d(d, "tab a/b test request failed.");
    }
  }
  
  private void d(FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    GetCategoryMaterialRsp localGetCategoryMaterialRsp = (GetCategoryMaterialRsp)paramObject;
    if ((localGetCategoryMaterialRsp != null) && (localGetCategoryMaterialRsp.Code == 0) && (localGetCategoryMaterialRsp.Categories != null) && (!localGetCategoryMaterialRsp.Categories.isEmpty()))
    {
      if (AEDashboardUtil.f()) {
        AEDashboardUtil.a().postValue(new AEDashboardUtil.NetInfo("ShadowBackendSvc.GetCategoryMaterial.MqStoryCamera", "response", "succeeded with content"));
      }
      AECameraPrefsUtil.a().a("ShadowBackendSvc.GetCategoryMaterialMqStoryCamera", localGetCategoryMaterialRsp.ETag, 4);
      paramObject = new Gson().toJson(localGetCategoryMaterialRsp);
      FileUtils.writeFile(AEMaterialManager.p(), paramObject);
      paramObject = (AEMaterialManager)AEQIMManager.a().b(1);
      if (paramObject != null) {
        paramObject.a(true);
      }
    }
    else if (AEDashboardUtil.f())
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
    paramObject.f();
    paramObject.b(AEPath.CAMERA.a);
    paramObject = this.b;
    if ((paramObject != null) && (paramObject.containsKey("ShadowBackendSvc.GetCategoryMaterial.MqStoryCamera")))
    {
      paramObject = new StringBuilder();
      paramObject.append("");
      paramObject.append(System.currentTimeMillis() - ((Long)this.b.get("ShadowBackendSvc.GetCategoryMaterial.MqStoryCamera")).longValue());
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
  
  private void e(FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    GetCategoryMaterialRsp localGetCategoryMaterialRsp = (GetCategoryMaterialRsp)paramObject;
    if ((localGetCategoryMaterialRsp != null) && (localGetCategoryMaterialRsp.Code == 0) && (localGetCategoryMaterialRsp.Categories != null) && (!localGetCategoryMaterialRsp.Categories.isEmpty()))
    {
      if (AEDashboardUtil.f()) {
        AEDashboardUtil.a().postValue(new AEDashboardUtil.NetInfo("ShadowBackendSvc.GetCategoryMaterial.MqKuaishanCamera", "response", "succeeded with content"));
      }
      AECameraPrefsUtil.a().a("ShadowBackendSvc.GetCategoryMaterialMqKuaishanCamera", localGetCategoryMaterialRsp.ETag, 4);
      paramObject = new Gson().toJson(localGetCategoryMaterialRsp);
      FileUtils.writeFile(AEFlashShowMaterialManager.j(), paramObject);
      paramObject = (AEFlashShowMaterialManager)AEQIMManager.a().b(3);
      if (paramObject != null) {
        paramObject.a(true);
      }
    }
    else if (AEDashboardUtil.f())
    {
      localObject = AEDashboardUtil.a();
      if (paramFromServiceMsg.isSuccess()) {
        paramObject = "succeeded without content";
      } else {
        paramObject = "failed";
      }
      ((MutableLiveData)localObject).postValue(new AEDashboardUtil.NetInfo("ShadowBackendSvc.GetCategoryMaterial.MqStoryCamera", "response", paramObject));
    }
    ((AEFlashShowMaterialManager)AEQIMManager.a(3)).b();
    paramObject = this.b;
    if ((paramObject != null) && (paramObject.containsKey("ShadowBackendSvc.GetCategoryMaterial.MqStoryCamera")))
    {
      paramObject = new StringBuilder();
      paramObject.append("");
      paramObject.append(System.currentTimeMillis() - ((Long)this.b.get("ShadowBackendSvc.GetCategoryMaterial.MqKuaishanCamera")).longValue());
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
    ((AEBaseDataReporter)localObject).a(j, paramObject, "ShadowBackendSvc.GetCategoryMaterial.MqKuaishanCamera", i);
  }
  
  private void f(FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    GetCategoryMaterialRsp localGetCategoryMaterialRsp = (GetCategoryMaterialRsp)paramObject;
    if ((localGetCategoryMaterialRsp != null) && (localGetCategoryMaterialRsp.Code == 0) && (localGetCategoryMaterialRsp.Categories != null) && (!localGetCategoryMaterialRsp.Categories.isEmpty()))
    {
      if (AEDashboardUtil.f()) {
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
    else if (AEDashboardUtil.f())
    {
      localObject = AEDashboardUtil.a();
      if (paramFromServiceMsg.isSuccess()) {
        paramObject = "succeeded without content";
      } else {
        paramObject = "failed";
      }
      ((MutableLiveData)localObject).postValue(new AEDashboardUtil.NetInfo("ShadowBackendSvc.GetCategoryMaterial.MqEmoCamera", "response", paramObject));
    }
    CameraOperationHelper.c().postValue(Boolean.valueOf(true));
    paramObject = this.b;
    if ((paramObject != null) && (paramObject.containsKey("ShadowBackendSvc.GetCategoryMaterial.MqEmoCamera")))
    {
      paramObject = new StringBuilder();
      paramObject.append("");
      paramObject.append(System.currentTimeMillis() - ((Long)this.b.get("ShadowBackendSvc.GetCategoryMaterial.MqEmoCamera")).longValue());
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
  
  private void g(FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    GetCategoryMaterialRsp localGetCategoryMaterialRsp = (GetCategoryMaterialRsp)paramObject;
    if ((localGetCategoryMaterialRsp != null) && (localGetCategoryMaterialRsp.Code == 0) && (localGetCategoryMaterialRsp.Categories != null) && (!localGetCategoryMaterialRsp.Categories.isEmpty()))
    {
      if (AEDashboardUtil.f()) {
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
        AEWatermarkMaterialManager.a().c();
      }
    }
    else if (AEDashboardUtil.f())
    {
      localObject = AEDashboardUtil.a();
      if (paramFromServiceMsg.isSuccess()) {
        paramObject = "succeeded without content";
      } else {
        paramObject = "failed";
      }
      ((MutableLiveData)localObject).postValue(new AEDashboardUtil.NetInfo("ShadowBackendSvc.GetCategoryMaterial.MqCircleWatermark", "response", paramObject));
    }
    paramObject = this.b;
    if ((paramObject != null) && (paramObject.containsKey("ShadowBackendSvc.GetCategoryMaterial.MqCircleWatermark")))
    {
      paramObject = new StringBuilder();
      paramObject.append("");
      paramObject.append(System.currentTimeMillis() - ((Long)this.b.get("ShadowBackendSvc.GetCategoryMaterial.MqCircleWatermark")).longValue());
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
  
  private void h(FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isDebugVersion()) {
      QLog.d(d, 4, "[handlePlayShowCategoryMaterials] start");
    }
    GetPlayShowCatMatTreeRsp localGetPlayShowCatMatTreeRsp = (GetPlayShowCatMatTreeRsp)paramObject;
    if ((localGetPlayShowCatMatTreeRsp != null) && (localGetPlayShowCatMatTreeRsp.Code == 0) && (!localGetPlayShowCatMatTreeRsp.Categories.isEmpty()))
    {
      if (QLog.isDebugVersion())
      {
        paramObject = d;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[handlePlayShowCategoryMaterials] response=");
        ((StringBuilder)localObject).append(localGetPlayShowCatMatTreeRsp);
        QLog.d(paramObject, 4, ((StringBuilder)localObject).toString());
      }
      if (AEDashboardUtil.f()) {
        AEDashboardUtil.a().postValue(new AEDashboardUtil.NetInfo("ShadowBackendSvc.GetPlayShowCatMatTree", "response", "succeeded with content"));
      }
      AECameraPrefsUtil.a().a("ShadowBackendSvc.GetPlayShowCatMatTree", localGetPlayShowCatMatTreeRsp.ETag, 4);
      paramObject = GsonUtils.obj2Json(localGetPlayShowCatMatTreeRsp, a);
      localObject = new File(AEPath.PLAY.FILES.d);
      if (!((File)localObject).exists()) {
        ((File)localObject).mkdirs();
      }
      FileUtils.writeFile(AEPath.PLAY.b, paramObject);
    }
    else
    {
      if (QLog.isDebugVersion()) {
        QLog.d(d, 4, "[handlePlayShowCategoryMaterials] response=empty");
      }
      if (AEDashboardUtil.f())
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
    CameraOperationHelper.d().postValue(Boolean.valueOf(true));
    paramObject = this.b;
    if ((paramObject != null) && (paramObject.containsKey("ShadowBackendSvc.GetPlayShowCatMatTree")))
    {
      paramObject = new StringBuilder();
      paramObject.append("");
      paramObject.append(System.currentTimeMillis() - ((Long)this.b.get("ShadowBackendSvc.GetPlayShowCatMatTree")).longValue());
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
      QLog.d(d, 4, "[handlePlayShowCategoryMaterials] end");
    }
  }
  
  public void a()
  {
    AEQLog.b(d, "arcake: requestARCakeMaterial--begin");
    Object localObject1 = BaseApplicationImpl.getApplication().getRuntime().getCurrentUin();
    new ArrayList().add(Long.valueOf(Long.parseLong((String)localObject1)));
    oidb_cmd0xf8c.ReqBody localReqBody = new oidb_cmd0xf8c.ReqBody();
    String str = d;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("arcake: requestARCakeMaterial--uin");
    ((StringBuilder)localObject2).append(Long.parseLong((String)localObject1));
    AEQLog.a(str, ((StringBuilder)localObject2).toString());
    str = AECameraPrefsUtil.a().b("key_ae_arcake_id", null, 4);
    AEGiftMaterialConfigParser.a(str);
    localObject2 = d;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("arcake: requestARCakeMaterial--arCakeId");
    localStringBuilder.append(str);
    AEQLog.a((String)localObject2, localStringBuilder.toString());
    if (!TextUtils.isEmpty(str)) {
      localReqBody.cakeID.set(str);
    }
    localReqBody.uin.set(Long.parseLong((String)localObject1));
    str = "2.6.0.23";
    localObject1 = str;
    if (!TextUtils.isEmpty("2.6.0.23"))
    {
      localObject2 = "2.6.0.23".split("\\.");
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
    str = d;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("arcake: requestARCakeMaterial--sdkVersion");
    ((StringBuilder)localObject2).append((String)localObject1);
    AEQLog.a(str, ((StringBuilder)localObject2).toString());
    localReqBody.sdk_version.set((String)localObject1);
    localReqBody.zhongtai_number.set((String)localObject1);
    localReqBody.clientplat.set("8.8.17");
    localReqBody.PlatformFlag.set(1);
    localObject1 = makeOIDBPkg("OidbSvc.oidb_cmd0xf8c", 3980, 1, localReqBody.toByteArray());
    if (!NetworkUtil.isNetworkAvailable())
    {
      AEQLog.b(d, "arcake: net work not avalilable");
      AEGiftMaterialConfigParser.a = false;
    }
    sendPbReq((ToServiceMsg)localObject1);
    AEQLog.a(d, "arcake: requestARCakeMaterial--end");
  }
  
  protected void a(FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    AEQLog.a(d, "arcake: handleARCakeMaterial");
    if (!paramFromServiceMsg.isSuccess())
    {
      AEQLog.d(d, "arcake: handleARCakeMaterial not success ");
      return;
    }
    Object localObject = new oidb_cmd0xf8c.RspBody();
    int i = parseOIDBPkg(paramFromServiceMsg, paramObject, (MessageMicro)localObject);
    paramFromServiceMsg = d;
    paramObject = new StringBuilder();
    paramObject.append("arcake: result :");
    paramObject.append(i);
    AEQLog.a(paramFromServiceMsg, paramObject.toString());
    if (i != 0)
    {
      AEGiftMaterialConfigParser.a = false;
      return;
    }
    AEGiftMaterialConfigParser.a = true;
    try
    {
      AEGiftMaterialConfigParser.a((oidb_cmd0xf8c.RspBody)localObject);
      if ((AECaptureContext.a() instanceof PeakAppInterface))
      {
        AEARCakeMaterialManager.a().k();
        return;
      }
    }
    catch (AEGiftMaterialConfigParser.AEGiftMaterialConfigParserExpection paramFromServiceMsg)
    {
      paramObject = d;
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
      LogUtils.w(d, "[reqCompressedMaterials] no network....");
      return;
    }
    Object localObject = d;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("【REQUEST】requestCompressedMaterials");
    localStringBuilder.append(paramString);
    AEQLog.b((String)localObject, localStringBuilder.toString());
    if (AEDashboardUtil.f())
    {
      localObject = AEDashboardUtil.a();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("ShadowBackendSvc.GetCategoryMaterial.");
      localStringBuilder.append(paramString);
      ((MutableLiveData)localObject).postValue(new AEDashboardUtil.NetInfo(localStringBuilder.toString(), "request", "null"));
    }
    localObject = this.b;
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
      LogUtils.w(d, "[reqCameraConfig] no network....");
      return;
    }
    if (AEDashboardUtil.f()) {
      AEDashboardUtil.a().postValue(new AEDashboardUtil.NetInfo("ShadowBackendSvc.GetCameraConfig", "request", "null"));
    }
    AEQLog.b(d, "【REQUEST】reqCameraConfig");
    this.b.put("ShadowBackendSvc.GetCameraConfig", Long.valueOf(System.currentTimeMillis()));
    ToServiceMsg localToServiceMsg = new ToServiceMsg("ShadowBackendSvc", this.appRuntime.getAccount(), "ShadowBackendSvc.GetCameraConfig");
    localToServiceMsg.extraData.putBoolean("req_pb_protocol_flag", false);
    send(localToServiceMsg);
  }
  
  protected void b(FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    Object localObject1 = d;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("【Handle】handleCameraConfig:");
    ((StringBuilder)localObject2).append(paramFromServiceMsg.isSuccess());
    AEQLog.b((String)localObject1, ((StringBuilder)localObject2).toString());
    if (!paramFromServiceMsg.isSuccess())
    {
      if (AEDashboardUtil.f()) {
        AEDashboardUtil.a().postValue(new AEDashboardUtil.NetInfo("ShadowBackendSvc.GetCameraConfig", "response", "failed"));
      }
      return;
    }
    GetCameraConfigRsp localGetCameraConfigRsp = (GetCameraConfigRsp)paramObject;
    if (localGetCameraConfigRsp.ConfigMap != null)
    {
      if (AEDashboardUtil.f()) {
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
          break label1586;
          if (!"app_alg_entrance_qzone_id_from833".equals(str)) {
            break;
          }
          paramObject = ((CameraConfig)localObject5).ConfigContent;
        }
        boolean bool = "app_ui_camera_ad_id".equals(str);
        int j = 0;
        i = 0;
        if (bool) {}
        try
        {
          localObject5 = new JsonParser().parse(((CameraConfig)localObject5).ConfigContent).getAsJsonArray();
          if ((localObject5 == null) || (((JsonArray)localObject5).size() <= 0)) {
            break label513;
          }
          j = ((JsonArray)localObject5).size();
        }
        catch (Exception localException1)
        {
          for (;;)
          {
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
            break label1758;
          }
          AECameraPrefsUtil.a().a("camera_ad_op_id", GsonUtils.optString((JsonObject)localObject3, "opID"), 4);
          AECameraPrefsUtil.a().a("camera_ad_show", GsonUtils.optBoolean((JsonObject)localObject3, "showOp"), 4);
          AECameraPrefsUtil.a().a("camera_ad_icon_url", GsonUtils.optString((JsonObject)localObject3, "opIcon"), 4);
          AECameraPrefsUtil.a().a("camera_ad_type", GsonUtils.optString((JsonObject)localObject3, "type"), 4);
          AECameraPrefsUtil.a().a("camera_ad_schema", GsonUtils.optString((JsonObject)localObject3, "schema"), 4);
          AECameraPrefsUtil.a().a("camera_ad_activity_id", GsonUtils.optString((JsonObject)localObject3, "activity_id"), 4);
          localObject3 = localObject1;
          localObject4 = paramObject;
          break label1586;
          label513:
          AECameraPrefsUtil.a().a("camera_ad_op_id", "", 4);
          AECameraPrefsUtil.a().a("camera_ad_show", false, 4);
          AECameraPrefsUtil.a().a("camera_ad_icon_url", "", 4);
          AECameraPrefsUtil.a().a("camera_ad_type", "", 4);
          AECameraPrefsUtil.a().a("camera_ad_schema", "", 4);
          AECameraPrefsUtil.a().a("camera_ad_activity_id", "", 4);
          localObject3 = localObject1;
          localObject4 = paramObject;
          break label1586;
          AEQLog.d(d, "camera ad ab test inflate error.");
          localObject3 = localObject1;
          localObject4 = paramObject;
          break label1586;
          if (!"app_ui_pendant_btn_ad_id".equals(str)) {}
        }
        try
        {
          localObject5 = new JsonParser().parse(((CameraConfig)localObject5).ConfigContent).getAsJsonArray();
          if ((localObject5 != null) && (((JsonArray)localObject5).size() > 0))
          {
            int k = ((JsonArray)localObject5).size();
            i = j;
            localObject3 = localObject1;
            localObject4 = paramObject;
            if (i < k)
            {
              localObject3 = (JsonObject)((JsonArray)localObject5).get(i);
              if (!a((JsonObject)localObject3)) {
                break label1765;
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
          label969:
          break label969;
        }
        AEQLog.d(d, "camera pendent ad ab test inflate error.");
        localObject3 = localObject1;
        localObject4 = paramObject;
        break label1586;
        if ("app_ui_camera_tab_bubble".equals(str))
        {
          localObject3 = ((CameraConfig)localObject5).ConfigContent;
          localObject4 = d;
          localObject5 = new StringBuilder();
          ((StringBuilder)localObject5).append("get camera tab bubble ad: ");
          ((StringBuilder)localObject5).append((String)localObject3);
          AEQLog.b((String)localObject4, ((StringBuilder)localObject5).toString());
          AECameraPrefsUtil.a().a("camera_ad_tab_bubble_content", (String)localObject3, 4);
          localObject3 = localObject1;
          localObject4 = paramObject;
        }
        else if ("app_alg_filter_timeout_id".equals(str))
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
            i = 0;
            localObject3 = localObject1;
            localObject4 = paramObject;
            if (i < j)
            {
              localObject3 = (JsonObject)((JsonArray)localObject5).get(i);
              if (!a((JsonObject)localObject3)) {
                break label1772;
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
          label1399:
          break label1399;
        }
        AEQLog.d(d, "camera ad ab test inflate error.");
        localObject3 = localObject1;
        localObject4 = paramObject;
        break label1586;
        localObject3 = localObject1;
        localObject4 = paramObject;
        if ("app_ui_camera_circle_entry_id".equals(str)) {}
        try
        {
          localObject5 = new JsonParser().parse(((CameraConfig)localObject5).ConfigContent).getAsJsonArray();
          if ((localObject5 != null) && (((JsonArray)localObject5).size() > 0))
          {
            j = ((JsonArray)localObject5).size();
            i = 0;
            localObject3 = localObject1;
            localObject4 = paramObject;
            if (i < j)
            {
              localObject3 = (JsonObject)((JsonArray)localObject5).get(i);
              if (!a((JsonObject)localObject3)) {
                break label1779;
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
          label1570:
          label1586:
          long l2;
          long l1;
          break label1570;
        }
        AEQLog.d(d, "camera entry ab test inflate error.");
        localObject4 = paramObject;
        localObject3 = localObject1;
        localObject1 = localObject3;
      }
      AECameraPrefsUtil.a().a("ShadowBackendSvc.GetCameraConfig", (String)localObject2, 4);
      AECameraPrefsUtil.a().a("app_ui_playshow_ad_id", (String)localObject1, 4);
      AECameraPrefsUtil.a().a("app_alg_entrance_qzone_id_from833", paramObject, 4);
    }
    else if (AEDashboardUtil.f())
    {
      AEDashboardUtil.a().postValue(new AEDashboardUtil.NetInfo("ShadowBackendSvc.GetCameraConfig", "response", "succeeded without content"));
    }
    paramObject = AEBaseDataReporter.a();
    i = paramFromServiceMsg.getResultCode();
    l2 = System.currentTimeMillis();
    if (this.b.containsKey("ShadowBackendSvc.GetCameraConfig")) {
      l1 = ((Long)this.b.get("ShadowBackendSvc.GetCameraConfig")).longValue();
    } else {
      l1 = 0L;
    }
    paramObject.a(i, String.valueOf(l2 - l1), "ShadowBackendSvc.GetCameraConfig", localGetCameraConfigRsp.Code);
  }
  
  public void c()
  {
    if (!NetworkUtil.isNetworkAvailable())
    {
      AEQLog.d(d, "reqTabABTest---network error.");
      return;
    }
    AEQLog.b(d, "【REQUEST】reqTabABTest");
    this.b.put("ShadowBackendSvc.GetTABConfiguration", Long.valueOf(System.currentTimeMillis()));
    send(new ToServiceMsg("ShadowBackendSvc", this.appRuntime.getAccount(), "ShadowBackendSvc.GetTABConfiguration"));
  }
  
  public void d()
  {
    if (!NetworkUtil.isNetworkAvailable())
    {
      if (QLog.isDebugVersion())
      {
        QLog.d(d, 4, "[reqPlayShowCategoryMaterials] no network....");
        QLog.d(d, 4, "[reqPlayShowCategoryMaterials] end");
      }
      return;
    }
    AEQLog.b(d, "【REQUEST】reqPlayShowCategoryMaterials");
    if (AEDashboardUtil.f()) {
      AEDashboardUtil.a().postValue(new AEDashboardUtil.NetInfo("ShadowBackendSvc.GetPlayShowCatMatTree", "request", "null"));
    }
    this.b.put("ShadowBackendSvc.GetPlayShowCatMatTree", Long.valueOf(System.currentTimeMillis()));
    ToServiceMsg localToServiceMsg = new ToServiceMsg("ShadowBackendSvc", this.appRuntime.getAccount(), "ShadowBackendSvc.GetPlayShowCatMatTree");
    localToServiceMsg.extraData.putBoolean("req_pb_protocol_flag", false);
    send(localToServiceMsg);
  }
  
  public void e()
  {
    ThreadManager.getFileThreadHandler().post(new CameraDataServiceHandler.2(this));
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return null;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    e();
    if (paramFromServiceMsg.getServiceCmd().equals("ShadowBackendSvc.GetCategoryMaterial"))
    {
      paramToServiceMsg = paramToServiceMsg.extraData.getString("ServiceId");
      if (paramToServiceMsg.endsWith("MqStoryCamera"))
      {
        d(paramFromServiceMsg, paramObject);
        return;
      }
      if (paramToServiceMsg.endsWith("MqEmoCamera"))
      {
        f(paramFromServiceMsg, paramObject);
        return;
      }
      if (paramToServiceMsg.endsWith("MqCircleWatermark"))
      {
        g(paramFromServiceMsg, paramObject);
        return;
      }
      if (paramToServiceMsg.endsWith("MqKuaishanCamera")) {
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
        h(paramFromServiceMsg, paramObject);
        return;
      }
      if (paramToServiceMsg.getServiceCmd().equals("OidbSvc.oidb_cmd0xf8c"))
      {
        a(paramFromServiceMsg, paramObject);
        return;
      }
      if (paramFromServiceMsg.getServiceCmd().equalsIgnoreCase("ShadowBackendSvc.GetTABConfiguration")) {
        c(paramFromServiceMsg, paramObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.config.CameraDataServiceHandler
 * JD-Core Version:    0.7.0.1
 */