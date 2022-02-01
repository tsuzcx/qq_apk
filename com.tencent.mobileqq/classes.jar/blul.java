import android.arch.lifecycle.MutableLiveData;
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
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
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
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class blul
  extends BusinessHandler
{
  private static final String jdField_a_of_type_JavaLangString = blul.class.getSimpleName();
  public static final Type a;
  private EntityManager jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
  protected Map<String, Long> a;
  
  static
  {
    jdField_a_of_type_JavaLangReflectType = new blum().getType();
  }
  
  public blul(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    LogUtils.setEnable(false);
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = paramAppInterface.getEntityManagerFactory().createEntityManager();
  }
  
  private boolean a(JsonObject paramJsonObject)
  {
    return bmbq.a(GsonUtils.optString(paramJsonObject, "verFrom"), GsonUtils.optString(paramJsonObject, "verTo"));
  }
  
  private void b(FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    GetCategoryMaterialRsp localGetCategoryMaterialRsp = (GetCategoryMaterialRsp)paramObject;
    if ((localGetCategoryMaterialRsp != null) && (localGetCategoryMaterialRsp.Code == 0) && (localGetCategoryMaterialRsp.Categories != null) && (!localGetCategoryMaterialRsp.Categories.isEmpty()))
    {
      if (blrg.a()) {
        blrg.a().postValue(new blrk("CameraModuleSvc.GetCompressedCategoryMaterial.MqStoryCamera", "response", "succeeded with content"));
      }
      bmbk.a().a("CameraModuleSvc.GetCompressedCategoryMaterialMqStoryCamera", localGetCategoryMaterialRsp.ETag, 4);
      paramObject = new Gson().toJson(localGetCategoryMaterialRsp);
      FileUtils.writeFile(bluy.b(), paramObject);
      paramObject = (bluy)bmql.a().c(18);
      if (paramObject != null) {
        paramObject.a(true);
      }
      paramObject = (bluy)bmql.a(18);
      paramObject.b();
      paramObject.b(bljk.jdField_a_of_type_JavaLangString);
      if ((this.jdField_a_of_type_JavaUtilMap == null) || (!this.jdField_a_of_type_JavaUtilMap.containsKey("CameraModuleSvc.GetCompressedCategoryMaterial.MqStoryCamera"))) {
        break label258;
      }
    }
    label258:
    for (paramObject = "" + (System.currentTimeMillis() - ((Long)this.jdField_a_of_type_JavaUtilMap.get("CameraModuleSvc.GetCompressedCategoryMaterial.MqStoryCamera")).longValue());; paramObject = "-1")
    {
      bmbc.a().a(paramFromServiceMsg.getResultCode(), paramObject, "CameraModuleSvc.GetCompressedCategoryMaterial.MqStoryCamera", localGetCategoryMaterialRsp.Code);
      return;
      if (!blrg.a()) {
        break;
      }
      MutableLiveData localMutableLiveData = blrg.a();
      if (paramFromServiceMsg.isSuccess()) {}
      for (paramObject = "succeeded without content";; paramObject = "failed")
      {
        localMutableLiveData.postValue(new blrk("CameraModuleSvc.GetCompressedCategoryMaterial.MqStoryCamera", "response", paramObject));
        break;
      }
    }
  }
  
  private void c(FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    GetCategoryMaterialRsp localGetCategoryMaterialRsp = (GetCategoryMaterialRsp)paramObject;
    Object localObject;
    if ((localGetCategoryMaterialRsp != null) && (localGetCategoryMaterialRsp.Code == 0) && (localGetCategoryMaterialRsp.Categories != null) && (!localGetCategoryMaterialRsp.Categories.isEmpty()))
    {
      if (blrg.a()) {
        blrg.a().postValue(new blrk("CameraModuleSvc.GetCompressedCategoryMaterial.MqEmoCamera", "response", "succeeded with content"));
      }
      bmbk.a().a("CameraModuleSvc.GetCompressedCategoryMaterialMqEmoCamera", localGetCategoryMaterialRsp.ETag, 4);
      paramObject = new Gson().toJson(localGetCategoryMaterialRsp);
      localObject = new File(bljq.f);
      if (!((File)localObject).exists()) {
        ((File)localObject).mkdirs();
      }
      FileUtils.writeFile(bljo.b, paramObject);
      blun.a().postValue(Boolean.valueOf(true));
      if ((this.jdField_a_of_type_JavaUtilMap == null) || (!this.jdField_a_of_type_JavaUtilMap.containsKey("CameraModuleSvc.GetCompressedCategoryMaterial.MqEmoCamera"))) {
        break label253;
      }
    }
    label253:
    for (paramObject = "" + (System.currentTimeMillis() - ((Long)this.jdField_a_of_type_JavaUtilMap.get("CameraModuleSvc.GetCompressedCategoryMaterial.MqEmoCamera")).longValue());; paramObject = "-1")
    {
      bmbc.a().a(paramFromServiceMsg.getResultCode(), paramObject, "CameraModuleSvc.GetCompressedCategoryMaterial.MqEmoCamera", localGetCategoryMaterialRsp.Code);
      return;
      if (!blrg.a()) {
        break;
      }
      localObject = blrg.a();
      if (paramFromServiceMsg.isSuccess()) {}
      for (paramObject = "succeeded without content";; paramObject = "failed")
      {
        ((MutableLiveData)localObject).postValue(new blrk("CameraModuleSvc.GetCompressedCategoryMaterial.MqEmoCamera", "response", paramObject));
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
    label237:
    int j;
    if ((localGetPlayShowCatMatTreeRsp != null) && (localGetPlayShowCatMatTreeRsp.Code == 0) && (!localGetPlayShowCatMatTreeRsp.Categories.isEmpty()))
    {
      if (QLog.isDebugVersion()) {
        QLog.d(jdField_a_of_type_JavaLangString, 4, "[handlePlayShowCategoryMaterials] response=" + localGetPlayShowCatMatTreeRsp);
      }
      if (blrg.a()) {
        blrg.a().postValue(new blrk("CameraModuleSvc.GetPlayShowCatMatTree", "response", "succeeded with content"));
      }
      bmbk.a().a("CameraModuleSvc.GetPlayShowCatMatTree", localGetPlayShowCatMatTreeRsp.ETag, 4);
      paramObject = GsonUtils.obj2Json(localGetPlayShowCatMatTreeRsp, jdField_a_of_type_JavaLangReflectType);
      localObject = new File(bljt.c);
      if (!((File)localObject).exists()) {
        ((File)localObject).mkdirs();
      }
      FileUtils.writeFile(bljr.b, paramObject);
      blun.b().postValue(Boolean.valueOf(true));
      if ((this.jdField_a_of_type_JavaUtilMap == null) || (!this.jdField_a_of_type_JavaUtilMap.containsKey("CameraModuleSvc.GetPlayShowCatMatTree"))) {
        break label348;
      }
      paramObject = "" + (System.currentTimeMillis() - ((Long)this.jdField_a_of_type_JavaUtilMap.get("CameraModuleSvc.GetPlayShowCatMatTree")).longValue());
      localObject = bmbc.a();
      j = paramFromServiceMsg.getResultCode();
      if (localGetPlayShowCatMatTreeRsp != null) {
        break label354;
      }
    }
    label348:
    label354:
    for (int i = 0;; i = localGetPlayShowCatMatTreeRsp.Code)
    {
      ((bmbc)localObject).a(j, paramObject, "CameraModuleSvc.GetPlayShowCatMatTree", i);
      if (QLog.isDebugVersion()) {
        QLog.d(jdField_a_of_type_JavaLangString, 4, "[handlePlayShowCategoryMaterials] end");
      }
      return;
      if (QLog.isDebugVersion()) {
        QLog.d(jdField_a_of_type_JavaLangString, 4, "[handlePlayShowCategoryMaterials] response=empty");
      }
      if (!blrg.a()) {
        break;
      }
      localObject = blrg.a();
      if (paramFromServiceMsg.isSuccess()) {}
      for (paramObject = "succeeded without content";; paramObject = "failed")
      {
        ((MutableLiveData)localObject).postValue(new blrk("CameraModuleSvc.GetPlayShowCatMatTree", "response", paramObject));
        break;
      }
      paramObject = "-1";
      break label237;
    }
  }
  
  public void a()
  {
    if (!NetworkUtil.isNetworkAvailable())
    {
      LogUtils.w(jdField_a_of_type_JavaLangString, "[reqCameraConfig] no network....");
      return;
    }
    if (blrg.a()) {
      blrg.a().postValue(new blrk("CameraModuleSvc.GetCameraConfig", "request", "null"));
    }
    bmbx.b(jdField_a_of_type_JavaLangString, "【REQUEST】reqCameraConfig");
    this.jdField_a_of_type_JavaUtilMap.put("CameraModuleSvc.GetCameraConfig", Long.valueOf(System.currentTimeMillis()));
    ToServiceMsg localToServiceMsg = new ToServiceMsg("CameraModuleSvc", this.mApp.getCurrentAccountUin(), "CameraModuleSvc.GetCameraConfig");
    localToServiceMsg.extraData.putBoolean("req_pb_protocol_flag", false);
    send(localToServiceMsg);
  }
  
  protected void a(FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    bmbx.b(jdField_a_of_type_JavaLangString, "【Handle】handleCameraConfig:" + paramFromServiceMsg.isSuccess());
    if (!paramFromServiceMsg.isSuccess())
    {
      if (blrg.a()) {
        blrg.a().postValue(new blrk("CameraModuleSvc.GetCameraConfig", "response", "failed"));
      }
      return;
    }
    GetCameraConfigRsp localGetCameraConfigRsp = (GetCameraConfigRsp)paramObject;
    Object localObject1;
    Object localObject2;
    String str;
    Object localObject7;
    label184:
    int j;
    label268:
    int i;
    label383:
    Object localObject5;
    if (localGetCameraConfigRsp.ConfigMap != null)
    {
      if (blrg.a()) {
        blrg.a().postValue(new blrk("CameraModuleSvc.GetCameraConfig", "response", "succeeded with content"));
      }
      paramObject = "";
      localObject1 = "";
      localObject2 = "";
      Iterator localIterator = localGetCameraConfigRsp.ConfigMap.entrySet().iterator();
      str = "";
      if (localIterator.hasNext())
      {
        localObject7 = (Map.Entry)localIterator.next();
        Object localObject3 = (CameraConfig)((Map.Entry)localObject7).getValue();
        if (TextUtils.isEmpty(str))
        {
          str = ((CameraConfig)localObject3).ExpId;
          localObject7 = (String)((Map.Entry)localObject7).getKey();
          if (!"app_ui_playshow_ad_id".equals(localObject7)) {
            break label268;
          }
          localObject3 = ((CameraConfig)localObject3).ConfigContent;
          paramObject = localObject2;
          localObject2 = localObject3;
        }
        for (;;)
        {
          localObject3 = localObject2;
          localObject2 = paramObject;
          paramObject = localObject3;
          break;
          str = str + "," + ((CameraConfig)localObject3).ExpId;
          break label184;
          if ("app_alg_aio_camera_type_id".equals(localObject7))
          {
            localObject3 = ((CameraConfig)localObject3).ConfigContent;
            localObject1 = localObject2;
            localObject2 = paramObject;
            paramObject = localObject1;
            localObject1 = localObject3;
          }
          else if ("app_alg_entrance_qzone_id_from833".equals(localObject7))
          {
            localObject3 = ((CameraConfig)localObject3).ConfigContent;
            localObject2 = paramObject;
            paramObject = localObject3;
          }
          else
          {
            Object localObject4;
            if ("app_ui_camera_ad_id".equals(localObject7))
            {
              try
              {
                localObject3 = new JsonParser().parse(((CameraConfig)localObject3).ConfigContent).getAsJsonArray();
                if ((localObject3 != null) && (((JsonArray)localObject3).size() > 0))
                {
                  j = ((JsonArray)localObject3).size();
                  i = 0;
                  if (i < j)
                  {
                    localObject7 = (JsonObject)((JsonArray)localObject3).get(i);
                    if (!a((JsonObject)localObject7)) {
                      break label1203;
                    }
                    bmbk.a().a("camera_ad_op_id", GsonUtils.optString((JsonObject)localObject7, "opID"), 4);
                    bmbk.a().a("camera_ad_show", GsonUtils.optBoolean((JsonObject)localObject7, "showOp"), 4);
                    bmbk.a().a("camera_ad_icon_url", GsonUtils.optString((JsonObject)localObject7, "opIcon"), 4);
                    bmbk.a().a("camera_ad_type", GsonUtils.optString((JsonObject)localObject7, "type"), 4);
                    bmbk.a().a("camera_ad_schema", GsonUtils.optString((JsonObject)localObject7, "schema"), 4);
                  }
                }
                else
                {
                  bmbk.a().a("camera_ad_op_id", "", 4);
                  bmbk.a().a("camera_ad_show", false, 4);
                  bmbk.a().a("camera_ad_icon_url", "", 4);
                  bmbk.a().a("camera_ad_type", "", 4);
                  bmbk.a().a("camera_ad_schema", "", 4);
                }
              }
              catch (Exception localException1)
              {
                bmbx.d(jdField_a_of_type_JavaLangString, "camera ad ab test inflate error.");
                localObject4 = paramObject;
                paramObject = localObject2;
                localObject2 = localObject4;
              }
            }
            else if ("app_alg_filter_timeout_id".equals(localObject7))
            {
              localObject4 = ((CameraConfig)localObject4).ConfigContent;
              bmbk.a().a("app_alg_filter_timeout_id", (String)localObject4, 4);
              localObject4 = paramObject;
              paramObject = localObject2;
              localObject2 = localObject4;
            }
            else
            {
              if (!"app_ui_camera_circle_ad_id".equals(localObject7)) {
                break label889;
              }
              try
              {
                localObject4 = new JsonParser().parse(((CameraConfig)localObject4).ConfigContent).getAsJsonArray();
                if ((localObject4 != null) && (((JsonArray)localObject4).size() > 0))
                {
                  j = ((JsonArray)localObject4).size();
                  i = 0;
                  label684:
                  if (i < j)
                  {
                    localObject7 = (JsonObject)((JsonArray)localObject4).get(i);
                    if (!a((JsonObject)localObject7)) {
                      break label1223;
                    }
                    bmbk.a().a("circle_camera_ad_op_id", GsonUtils.optString((JsonObject)localObject7, "opID"), 4);
                    bmbk.a().a("circle_camera_ad_icon_url", GsonUtils.optString((JsonObject)localObject7, "opIcon"), 4);
                    bmbk.a().a("circle_camera_ad_type", GsonUtils.optString((JsonObject)localObject7, "type"), 4);
                    bmbk.a().a("circle_camera_ad_schema", GsonUtils.optString((JsonObject)localObject7, "schema"), 4);
                    bmbk.a().a("circle_camera_ad_show", GsonUtils.optBoolean((JsonObject)localObject7, "showOp"), 4);
                  }
                }
                else
                {
                  bmbk.a().a("circle_camera_ad_op_id", "", 4);
                  bmbk.a().a("circle_camera_ad_icon_url", "", 4);
                  bmbk.a().a("circle_camera_ad_type", "", 4);
                  bmbk.a().a("circle_camera_ad_schema", "", 4);
                  bmbk.a().a("circle_camera_ad_show", false, 4);
                }
              }
              catch (Exception localException2)
              {
                bmbx.d(jdField_a_of_type_JavaLangString, "camera ad ab test inflate error.");
                localObject5 = paramObject;
                paramObject = localObject2;
                localObject2 = localObject5;
              }
            }
          }
        }
        label889:
        if (!"app_ui_camera_circle_entry_id".equals(localObject7)) {}
      }
    }
    for (;;)
    {
      try
      {
        localObject5 = new JsonParser().parse(((CameraConfig)localObject5).ConfigContent).getAsJsonArray();
        if ((localObject5 != null) && (((JsonArray)localObject5).size() > 0))
        {
          j = ((JsonArray)localObject5).size();
          i = 0;
          if (i < j)
          {
            localObject7 = (JsonObject)((JsonArray)localObject5).get(i);
            if (!a((JsonObject)localObject7)) {
              break label1243;
            }
            localObject5 = GsonUtils.optString((JsonObject)localObject7, "ABContent");
            bmbk.a().a("circle_entry_type_camera", "camera".endsWith((String)localObject5), 4);
          }
        }
        else
        {
          bmbk.a().a("circle_entry_type_camera", false, 4);
        }
      }
      catch (Exception localException3)
      {
        bmbx.d(jdField_a_of_type_JavaLangString, "camera entry ab test inflate error.");
      }
      Object localObject6 = paramObject;
      paramObject = localObject2;
      localObject2 = localObject6;
      break;
      bmbk.a().a("CameraModuleSvc.GetCameraConfig", str, 4);
      bmbk.a().a("app_ui_playshow_ad_id", paramObject, 4);
      bmbk.a().a("app_alg_aio_camera_type_id", (String)localObject1, 4);
      bmbk.a().a("app_alg_entrance_qzone_id_from833", (String)localObject2, 4);
      paramObject = bmbc.a();
      i = paramFromServiceMsg.getResultCode();
      long l2 = System.currentTimeMillis();
      if (this.jdField_a_of_type_JavaUtilMap.containsKey("CameraModuleSvc.GetCameraConfig")) {}
      for (long l1 = ((Long)this.jdField_a_of_type_JavaUtilMap.get("CameraModuleSvc.GetCameraConfig")).longValue();; l1 = 0L)
      {
        paramObject.a(i, String.valueOf(l2 - l1), "CameraModuleSvc.GetCameraConfig", localGetCameraConfigRsp.Code);
        return;
        if (!blrg.a()) {
          break;
        }
        blrg.a().postValue(new blrk("CameraModuleSvc.GetCameraConfig", "response", "succeeded without content"));
        break;
      }
      localObject6 = paramObject;
      paramObject = localObject2;
      localObject2 = localObject6;
      break;
      label1203:
      i += 1;
      break label383;
      localObject6 = paramObject;
      paramObject = localObject2;
      localObject2 = localObject6;
      break;
      label1223:
      i += 1;
      break label684;
      localObject6 = paramObject;
      paramObject = localObject2;
      localObject2 = localObject6;
      break;
      label1243:
      i += 1;
    }
  }
  
  public void a(String paramString)
  {
    if (!NetworkUtil.isNetworkAvailable())
    {
      LogUtils.w(jdField_a_of_type_JavaLangString, "[reqCompressedMaterials] no network....");
      return;
    }
    bmbx.b(jdField_a_of_type_JavaLangString, "【REQUEST】requestCompressedMaterials" + paramString);
    if (blrg.a()) {
      blrg.a().postValue(new blrk("CameraModuleSvc.GetCompressedCategoryMaterial." + paramString, "request", "null"));
    }
    this.jdField_a_of_type_JavaUtilMap.put("CameraModuleSvc.GetCompressedCategoryMaterial." + paramString, Long.valueOf(System.currentTimeMillis()));
    ToServiceMsg localToServiceMsg = new ToServiceMsg("CameraModuleSvc", this.mApp.getCurrentAccountUin(), "CameraModuleSvc.GetCompressedCategoryMaterial");
    localToServiceMsg.extraData.putString("ServiceId", paramString);
    send(localToServiceMsg);
  }
  
  public void b()
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
    bmbx.b(jdField_a_of_type_JavaLangString, "【REQUEST】reqPlayShowCategoryMaterials");
    if (blrg.a()) {
      blrg.a().postValue(new blrk("CameraModuleSvc.GetPlayShowCatMatTree", "request", "null"));
    }
    this.jdField_a_of_type_JavaUtilMap.put("CameraModuleSvc.GetPlayShowCatMatTree", Long.valueOf(System.currentTimeMillis()));
    ToServiceMsg localToServiceMsg = new ToServiceMsg("CameraModuleSvc", this.mApp.getCurrentAccountUin(), "CameraModuleSvc.GetPlayShowCatMatTree");
    localToServiceMsg.extraData.putBoolean("req_pb_protocol_flag", false);
    send(localToServiceMsg);
  }
  
  public Class<? extends BusinessObserver> observerClass()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blul
 * JD-Core Version:    0.7.0.1
 */