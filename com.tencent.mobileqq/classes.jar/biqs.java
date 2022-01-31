import android.os.Bundle;
import android.text.TextUtils;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.CameraConfig;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.GetCameraConfigRsp;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.GetCategoryMaterialRsp;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.GetPlayShowCatMatTreeRsp;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.tencent.common.app.AppInterface;
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
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class biqs
  extends ajtb
{
  private static final String jdField_a_of_type_JavaLangString = biqs.class.getSimpleName();
  public static final Type a;
  private aukp jdField_a_of_type_Aukp;
  protected Map<String, Long> a;
  
  static
  {
    jdField_a_of_type_JavaLangReflectType = new biqt().getType();
  }
  
  public biqs(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    LogUtils.setEnable(false);
    this.jdField_a_of_type_Aukp = paramAppInterface.getEntityManagerFactory().createEntityManager();
  }
  
  private void b(FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    GetCategoryMaterialRsp localGetCategoryMaterialRsp = (GetCategoryMaterialRsp)paramObject;
    if ((localGetCategoryMaterialRsp != null) && (localGetCategoryMaterialRsp.Code == 0) && (!localGetCategoryMaterialRsp.Categories.isEmpty()))
    {
      if (bink.a()) {
        bink.a().a(new bino("CameraModuleSvc.GetCompressedCategoryMaterial.MqStoryCamera", "response", "succeeded with content"));
      }
      bjaa.a().a("CameraModuleSvc.GetCompressedCategoryMaterialMqStoryCamera", localGetCategoryMaterialRsp.ETag, 4);
      paramObject = new Gson().toJson(localGetCategoryMaterialRsp);
      bbdx.a(birb.a(), paramObject);
      paramObject = (birb)bjav.a().c(18);
      if (paramObject != null)
      {
        paramObject.d();
        paramObject.h();
      }
      biqu.b().a(Boolean.valueOf(true));
      ((birb)bjav.a(18)).a(biis.jdField_a_of_type_JavaLangString);
      if ((this.jdField_a_of_type_JavaUtilMap == null) || (!this.jdField_a_of_type_JavaUtilMap.containsKey("CameraModuleSvc.GetCompressedCategoryMaterial.MqStoryCamera"))) {
        break label258;
      }
    }
    label258:
    for (paramObject = "" + (System.currentTimeMillis() - ((Long)this.jdField_a_of_type_JavaUtilMap.get("CameraModuleSvc.GetCompressedCategoryMaterial.MqStoryCamera")).longValue());; paramObject = "-1")
    {
      bizt.a().a(paramFromServiceMsg.getResultCode(), paramObject, "CameraModuleSvc.GetCompressedCategoryMaterial.MqStoryCamera", localGetCategoryMaterialRsp.Code);
      return;
      if (!bink.a()) {
        break;
      }
      bjor localbjor = bink.a();
      if (paramFromServiceMsg.isSuccess()) {}
      for (paramObject = "succeeded without content";; paramObject = "failed")
      {
        localbjor.a(new bino("CameraModuleSvc.GetCompressedCategoryMaterial.MqStoryCamera", "response", paramObject));
        break;
      }
    }
  }
  
  private void c(FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    GetCategoryMaterialRsp localGetCategoryMaterialRsp = (GetCategoryMaterialRsp)paramObject;
    Object localObject;
    if ((localGetCategoryMaterialRsp != null) && (localGetCategoryMaterialRsp.Code == 0) && (!localGetCategoryMaterialRsp.Categories.isEmpty()))
    {
      if (bink.a()) {
        bink.a().a(new bino("CameraModuleSvc.GetCompressedCategoryMaterial.MqEmoCamera", "response", "succeeded with content"));
      }
      bjaa.a().a("CameraModuleSvc.GetCompressedCategoryMaterialMqEmoCamera", localGetCategoryMaterialRsp.ETag, 4);
      paramObject = new Gson().toJson(localGetCategoryMaterialRsp);
      localObject = new File(biiy.f);
      if (!((File)localObject).exists()) {
        ((File)localObject).mkdirs();
      }
      bbdx.a(biiw.jdField_a_of_type_JavaLangString, paramObject);
      biqu.a().a(Boolean.valueOf(true));
      if ((this.jdField_a_of_type_JavaUtilMap == null) || (!this.jdField_a_of_type_JavaUtilMap.containsKey("CameraModuleSvc.GetCompressedCategoryMaterial.MqEmoCamera"))) {
        break label246;
      }
    }
    label246:
    for (paramObject = "" + (System.currentTimeMillis() - ((Long)this.jdField_a_of_type_JavaUtilMap.get("CameraModuleSvc.GetCompressedCategoryMaterial.MqEmoCamera")).longValue());; paramObject = "-1")
    {
      bizt.a().a(paramFromServiceMsg.getResultCode(), paramObject, "CameraModuleSvc.GetCompressedCategoryMaterial.MqEmoCamera", localGetCategoryMaterialRsp.Code);
      return;
      if (!bink.a()) {
        break;
      }
      localObject = bink.a();
      if (paramFromServiceMsg.isSuccess()) {}
      for (paramObject = "succeeded without content";; paramObject = "failed")
      {
        ((bjor)localObject).a(new bino("CameraModuleSvc.GetCompressedCategoryMaterial.MqEmoCamera", "response", paramObject));
        break;
      }
    }
  }
  
  private void d(FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isDebugVersion()) {
      QLog.d(jdField_a_of_type_JavaLangString, 4, "[handlePlayShowCategoryMaterials] start");
    }
    GetPlayShowCatMatTreeRsp localGetPlayShowCatMatTreeRsp = (GetPlayShowCatMatTreeRsp)paramObject;
    Object localObject;
    if ((localGetPlayShowCatMatTreeRsp != null) && (localGetPlayShowCatMatTreeRsp.Code == 0) && (!localGetPlayShowCatMatTreeRsp.Categories.isEmpty()))
    {
      if (QLog.isDebugVersion()) {
        QLog.d(jdField_a_of_type_JavaLangString, 4, "[handlePlayShowCategoryMaterials] response=" + localGetPlayShowCatMatTreeRsp);
      }
      if (bink.a()) {
        bink.a().a(new bino("CameraModuleSvc.GetPlayShowCatMatTree", "response", "succeeded with content"));
      }
      bjaa.a().a("CameraModuleSvc.GetPlayShowCatMatTree", localGetPlayShowCatMatTreeRsp.ETag, 4);
      paramObject = GsonUtils.obj2Json(localGetPlayShowCatMatTreeRsp, jdField_a_of_type_JavaLangReflectType);
      localObject = new File(bijb.c);
      if (!((File)localObject).exists()) {
        ((File)localObject).mkdirs();
      }
      bbdx.a(biiz.b, paramObject);
      biqu.c().a(Boolean.valueOf(true));
      if ((this.jdField_a_of_type_JavaUtilMap == null) || (!this.jdField_a_of_type_JavaUtilMap.containsKey("CameraModuleSvc.GetPlayShowCatMatTree"))) {
        break label328;
      }
    }
    label328:
    for (paramObject = "" + (System.currentTimeMillis() - ((Long)this.jdField_a_of_type_JavaUtilMap.get("CameraModuleSvc.GetPlayShowCatMatTree")).longValue());; paramObject = "-1")
    {
      bizt.a().a(paramFromServiceMsg.getResultCode(), paramObject, "CameraModuleSvc.GetPlayShowCatMatTree", localGetPlayShowCatMatTreeRsp.Code);
      if (QLog.isDebugVersion()) {
        QLog.d(jdField_a_of_type_JavaLangString, 4, "[handlePlayShowCategoryMaterials] end");
      }
      return;
      if (QLog.isDebugVersion()) {
        QLog.d(jdField_a_of_type_JavaLangString, 4, "[handlePlayShowCategoryMaterials] response=empty");
      }
      if (!bink.a()) {
        break;
      }
      localObject = bink.a();
      if (paramFromServiceMsg.isSuccess()) {}
      for (paramObject = "succeeded without content";; paramObject = "failed")
      {
        ((bjor)localObject).a(new bino("CameraModuleSvc.GetPlayShowCatMatTree", "response", paramObject));
        break;
      }
    }
  }
  
  public void a()
  {
    if (!bbfj.a())
    {
      LogUtils.w(jdField_a_of_type_JavaLangString, "[reqCameraConfig] no network....");
      return;
    }
    if (bink.a()) {
      bink.a().a(new bino("CameraModuleSvc.GetCameraConfig", "request", "null"));
    }
    bjah.b(jdField_a_of_type_JavaLangString, "【REQUEST】reqCameraConfig");
    this.jdField_a_of_type_JavaUtilMap.put("CameraModuleSvc.GetCameraConfig", Long.valueOf(System.currentTimeMillis()));
    ToServiceMsg localToServiceMsg = new ToServiceMsg("CameraModuleSvc", this.mApp.getCurrentAccountUin(), "CameraModuleSvc.GetCameraConfig");
    localToServiceMsg.extraData.putBoolean("req_pb_protocol_flag", false);
    send(localToServiceMsg);
  }
  
  protected void a(FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    bjah.b(jdField_a_of_type_JavaLangString, "【Handle】handleCameraConfig:" + paramFromServiceMsg.isSuccess());
    if (!paramFromServiceMsg.isSuccess())
    {
      if (bink.a()) {
        bink.a().a(new bino("CameraModuleSvc.GetCameraConfig", "response", "failed"));
      }
      return;
    }
    GetCameraConfigRsp localGetCameraConfigRsp = (GetCameraConfigRsp)paramObject;
    Object localObject1;
    Object localObject3;
    Object localObject2;
    String str;
    Object localObject6;
    Object localObject4;
    if (localGetCameraConfigRsp.ConfigMap != null)
    {
      if (bink.a()) {
        bink.a().a(new bino("CameraModuleSvc.GetCameraConfig", "response", "succeeded with content"));
      }
      localObject1 = "";
      paramObject = "";
      localObject3 = "";
      localObject2 = "";
      Iterator localIterator = localGetCameraConfigRsp.ConfigMap.entrySet().iterator();
      str = "";
      if (localIterator.hasNext())
      {
        localObject6 = (Map.Entry)localIterator.next();
        localObject4 = (CameraConfig)((Map.Entry)localObject6).getValue();
        if (TextUtils.isEmpty(str))
        {
          str = ((CameraConfig)localObject4).ExpId;
          label188:
          localObject6 = (String)((Map.Entry)localObject6).getKey();
          if (!"app_alg_entrance_id".equals(localObject6)) {
            break label295;
          }
          localObject4 = ((CameraConfig)localObject4).ConfigContent;
          localObject1 = localObject3;
          localObject3 = localObject4;
          localObject4 = localObject2;
          localObject2 = paramObject;
          paramObject = localObject4;
        }
      }
    }
    for (;;)
    {
      localObject4 = localObject2;
      localObject6 = localObject3;
      localObject2 = paramObject;
      localObject3 = localObject1;
      paramObject = localObject4;
      localObject1 = localObject6;
      break;
      str = str + "," + ((CameraConfig)localObject4).ExpId;
      break label188;
      label295:
      if ("app_ui_playshow_ad_id".equals(localObject6))
      {
        localObject6 = ((CameraConfig)localObject4).ConfigContent;
        localObject4 = localObject3;
        localObject3 = localObject1;
        paramObject = localObject2;
        localObject2 = localObject6;
        localObject1 = localObject4;
      }
      else if ("app_alg_aio_camera_type_id".equals(localObject6))
      {
        localObject4 = ((CameraConfig)localObject4).ConfigContent;
        localObject3 = localObject1;
        localObject1 = localObject2;
        localObject2 = paramObject;
        paramObject = localObject1;
        localObject1 = localObject4;
      }
      else if ("app_alg_entrance_qzone_id".equals(localObject6))
      {
        localObject6 = ((CameraConfig)localObject4).ConfigContent;
        localObject2 = paramObject;
        localObject4 = localObject1;
        paramObject = localObject6;
        localObject1 = localObject3;
        localObject3 = localObject4;
      }
      else
      {
        if ("app_ui_camera_ad_id".equals(localObject6))
        {
          try
          {
            localObject4 = new JsonParser().parse(((CameraConfig)localObject4).ConfigContent).getAsJsonArray();
            if ((localObject4 != null) && (((JsonArray)localObject4).size() > 0))
            {
              localObject4 = (JsonObject)((JsonArray)localObject4).get(0);
              bjaa.a().a("camera_ad_op_id", GsonUtils.optString((JsonObject)localObject4, "opID"), 4);
              bjaa.a().a("camera_ad_show", GsonUtils.optBoolean((JsonObject)localObject4, "showOp"), 4);
              bjaa.a().a("camera_ad_icon_url", GsonUtils.optString((JsonObject)localObject4, "opIcon"), 4);
              bjaa.a().a("camera_ad_type", GsonUtils.optString((JsonObject)localObject4, "type"), 4);
              bjaa.a().a("camera_ad_schema", GsonUtils.optString((JsonObject)localObject4, "schema"), 4);
            }
            else
            {
              bjaa.a().a("camera_ad_op_id", "", 4);
              bjaa.a().a("camera_ad_show", false, 4);
              bjaa.a().a("camera_ad_icon_url", "", 4);
              bjaa.a().a("camera_ad_type", "", 4);
              bjaa.a().a("camera_ad_schema", "", 4);
            }
          }
          catch (Exception localException)
          {
            bjah.d(jdField_a_of_type_JavaLangString, "camera ad ab test inflate error.");
            localObject5 = paramObject;
            localObject6 = localObject1;
            paramObject = localObject2;
            localObject1 = localObject3;
            localObject2 = localObject5;
            localObject3 = localObject6;
          }
        }
        else
        {
          if ("app_alg_filter_timeout_id".equals(localObject6))
          {
            localObject5 = ((CameraConfig)localObject5).ConfigContent;
            bjaa.a().a("app_alg_filter_timeout_id", (String)localObject5, 4);
          }
          localObject5 = paramObject;
          localObject6 = localObject1;
          paramObject = localObject2;
          localObject1 = localObject3;
          localObject2 = localObject5;
          localObject3 = localObject6;
          continue;
          bjaa.a().a("CameraModuleSvc.GetCameraConfig", str, 4);
          bjaa.a().a("app_alg_entrance_id", (String)localObject1, 4);
          bjaa.a().a("app_ui_playshow_ad_id", paramObject, 4);
          bjaa.a().a("app_alg_aio_camera_type_id", (String)localObject3, 4);
          bjaa.a().a("app_alg_entrance_qzone_id", (String)localObject2, 4);
          if (QLog.isColorLevel()) {
            QLog.i(jdField_a_of_type_JavaLangString, 2, "[handleCameraConfig], app_alg_entrance_id=" + (String)localObject1);
          }
          paramObject = bizt.a();
          int i = paramFromServiceMsg.getResultCode();
          long l2 = System.currentTimeMillis();
          if (this.jdField_a_of_type_JavaUtilMap.containsKey("CameraModuleSvc.GetCameraConfig")) {}
          for (long l1 = ((Long)this.jdField_a_of_type_JavaUtilMap.get("CameraModuleSvc.GetCameraConfig")).longValue();; l1 = 0L)
          {
            paramObject.a(i, String.valueOf(l2 - l1), "CameraModuleSvc.GetCameraConfig", localGetCameraConfigRsp.Code);
            return;
            if (!bink.a()) {
              break;
            }
            bink.a().a(new bino("CameraModuleSvc.GetCameraConfig", "response", "succeeded without content"));
            break;
          }
        }
        Object localObject5 = paramObject;
        localObject6 = localObject1;
        paramObject = localObject2;
        localObject1 = localObject3;
        localObject2 = localObject5;
        localObject3 = localObject6;
      }
    }
  }
  
  public void a(String paramString)
  {
    if (!bbfj.a())
    {
      LogUtils.w(jdField_a_of_type_JavaLangString, "[reqCompressedMaterials] no network....");
      return;
    }
    bjah.b(jdField_a_of_type_JavaLangString, "【REQUEST】requestCompressedMaterials" + paramString);
    if (bink.a()) {
      bink.a().a(new bino("CameraModuleSvc.GetCompressedCategoryMaterial." + paramString, "request", "null"));
    }
    this.jdField_a_of_type_JavaUtilMap.put("CameraModuleSvc.GetCompressedCategoryMaterial." + paramString, Long.valueOf(System.currentTimeMillis()));
    ToServiceMsg localToServiceMsg = new ToServiceMsg("CameraModuleSvc", this.mApp.getCurrentAccountUin(), "CameraModuleSvc.GetCompressedCategoryMaterial");
    localToServiceMsg.extraData.putString("ServiceId", paramString);
    send(localToServiceMsg);
  }
  
  public void b()
  {
    if (!bbfj.a())
    {
      if (QLog.isDebugVersion())
      {
        QLog.d(jdField_a_of_type_JavaLangString, 4, "[reqPlayShowCategoryMaterials] no network....");
        QLog.d(jdField_a_of_type_JavaLangString, 4, "[reqPlayShowCategoryMaterials] end");
      }
      return;
    }
    bjah.b(jdField_a_of_type_JavaLangString, "【REQUEST】reqPlayShowCategoryMaterials");
    if (bink.a()) {
      bink.a().a(new bino("CameraModuleSvc.GetPlayShowCatMatTree", "request", "null"));
    }
    this.jdField_a_of_type_JavaUtilMap.put("CameraModuleSvc.GetPlayShowCatMatTree", Long.valueOf(System.currentTimeMillis()));
    ToServiceMsg localToServiceMsg = new ToServiceMsg("CameraModuleSvc", this.mApp.getCurrentAccountUin(), "CameraModuleSvc.GetPlayShowCatMatTree");
    localToServiceMsg.extraData.putBoolean("req_pb_protocol_flag", false);
    send(localToServiceMsg);
  }
  
  protected Class<? extends ajte> observerClass()
  {
    return null;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramFromServiceMsg.getServiceCmd().equals("CameraModuleSvc.GetCompressedCategoryMaterial"))
    {
      paramToServiceMsg = paramToServiceMsg.extraData.getString("ServiceId");
      if (paramToServiceMsg.endsWith("MqStoryCamera")) {
        b(paramFromServiceMsg, paramObject);
      }
    }
    do
    {
      do
      {
        return;
      } while (!paramToServiceMsg.endsWith("MqEmoCamera"));
      c(paramFromServiceMsg, paramObject);
      return;
      if (paramFromServiceMsg.getServiceCmd().equals("CameraModuleSvc.GetCameraConfig"))
      {
        a(paramFromServiceMsg, paramObject);
        return;
      }
    } while (!paramToServiceMsg.getServiceCmd().equals("CameraModuleSvc.GetPlayShowCatMatTree"));
    d(paramFromServiceMsg, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     biqs
 * JD-Core Version:    0.7.0.1
 */