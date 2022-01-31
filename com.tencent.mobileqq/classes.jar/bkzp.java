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

public class bkzp
  extends alpd
{
  private static final String jdField_a_of_type_JavaLangString = bkzp.class.getSimpleName();
  public static final Type a;
  private awgf jdField_a_of_type_Awgf;
  protected Map<String, Long> a;
  
  static
  {
    jdField_a_of_type_JavaLangReflectType = new bkzq().getType();
  }
  
  public bkzp(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    LogUtils.setEnable(false);
    this.jdField_a_of_type_Awgf = paramAppInterface.getEntityManagerFactory().createEntityManager();
  }
  
  private void b(FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    GetCategoryMaterialRsp localGetCategoryMaterialRsp = (GetCategoryMaterialRsp)paramObject;
    if ((localGetCategoryMaterialRsp != null) && (localGetCategoryMaterialRsp.Code == 0) && (!localGetCategoryMaterialRsp.Categories.isEmpty()))
    {
      if (bkwl.a()) {
        bkwl.a().a(new bkwp("CameraModuleSvc.GetCompressedCategoryMaterial.MqStoryCamera", "response", "succeeded with content"));
      }
      bljc.a().a("CameraModuleSvc.GetCompressedCategoryMaterialMqStoryCamera", localGetCategoryMaterialRsp.ETag, 4);
      paramObject = new Gson().toJson(localGetCategoryMaterialRsp);
      bdhb.a(bkzy.a(), paramObject);
      paramObject = (bkzy)blqr.a().c(18);
      if (paramObject != null)
      {
        paramObject.d();
        paramObject.h();
      }
      bkzr.b().a(Boolean.valueOf(true));
      ((bkzy)blqr.a(18)).a(bkox.jdField_a_of_type_JavaLangString);
      if ((this.jdField_a_of_type_JavaUtilMap == null) || (!this.jdField_a_of_type_JavaUtilMap.containsKey("CameraModuleSvc.GetCompressedCategoryMaterial.MqStoryCamera"))) {
        break label258;
      }
    }
    label258:
    for (paramObject = "" + (System.currentTimeMillis() - ((Long)this.jdField_a_of_type_JavaUtilMap.get("CameraModuleSvc.GetCompressedCategoryMaterial.MqStoryCamera")).longValue());; paramObject = "-1")
    {
      bliu.a().a(paramFromServiceMsg.getResultCode(), paramObject, "CameraModuleSvc.GetCompressedCategoryMaterial.MqStoryCamera", localGetCategoryMaterialRsp.Code);
      return;
      if (!bkwl.a()) {
        break;
      }
      bmen localbmen = bkwl.a();
      if (paramFromServiceMsg.isSuccess()) {}
      for (paramObject = "succeeded without content";; paramObject = "failed")
      {
        localbmen.a(new bkwp("CameraModuleSvc.GetCompressedCategoryMaterial.MqStoryCamera", "response", paramObject));
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
      if (bkwl.a()) {
        bkwl.a().a(new bkwp("CameraModuleSvc.GetCompressedCategoryMaterial.MqEmoCamera", "response", "succeeded with content"));
      }
      bljc.a().a("CameraModuleSvc.GetCompressedCategoryMaterialMqEmoCamera", localGetCategoryMaterialRsp.ETag, 4);
      paramObject = new Gson().toJson(localGetCategoryMaterialRsp);
      localObject = new File(bkpd.f);
      if (!((File)localObject).exists()) {
        ((File)localObject).mkdirs();
      }
      bdhb.a(bkpb.jdField_a_of_type_JavaLangString, paramObject);
      bkzr.a().a(Boolean.valueOf(true));
      if ((this.jdField_a_of_type_JavaUtilMap == null) || (!this.jdField_a_of_type_JavaUtilMap.containsKey("CameraModuleSvc.GetCompressedCategoryMaterial.MqEmoCamera"))) {
        break label246;
      }
    }
    label246:
    for (paramObject = "" + (System.currentTimeMillis() - ((Long)this.jdField_a_of_type_JavaUtilMap.get("CameraModuleSvc.GetCompressedCategoryMaterial.MqEmoCamera")).longValue());; paramObject = "-1")
    {
      bliu.a().a(paramFromServiceMsg.getResultCode(), paramObject, "CameraModuleSvc.GetCompressedCategoryMaterial.MqEmoCamera", localGetCategoryMaterialRsp.Code);
      return;
      if (!bkwl.a()) {
        break;
      }
      localObject = bkwl.a();
      if (paramFromServiceMsg.isSuccess()) {}
      for (paramObject = "succeeded without content";; paramObject = "failed")
      {
        ((bmen)localObject).a(new bkwp("CameraModuleSvc.GetCompressedCategoryMaterial.MqEmoCamera", "response", paramObject));
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
      if (bkwl.a()) {
        bkwl.a().a(new bkwp("CameraModuleSvc.GetPlayShowCatMatTree", "response", "succeeded with content"));
      }
      bljc.a().a("CameraModuleSvc.GetPlayShowCatMatTree", localGetPlayShowCatMatTreeRsp.ETag, 4);
      paramObject = GsonUtils.obj2Json(localGetPlayShowCatMatTreeRsp, jdField_a_of_type_JavaLangReflectType);
      localObject = new File(bkpg.c);
      if (!((File)localObject).exists()) {
        ((File)localObject).mkdirs();
      }
      bdhb.a(bkpe.b, paramObject);
      bkzr.c().a(Boolean.valueOf(true));
      if ((this.jdField_a_of_type_JavaUtilMap == null) || (!this.jdField_a_of_type_JavaUtilMap.containsKey("CameraModuleSvc.GetPlayShowCatMatTree"))) {
        break label328;
      }
    }
    label328:
    for (paramObject = "" + (System.currentTimeMillis() - ((Long)this.jdField_a_of_type_JavaUtilMap.get("CameraModuleSvc.GetPlayShowCatMatTree")).longValue());; paramObject = "-1")
    {
      bliu.a().a(paramFromServiceMsg.getResultCode(), paramObject, "CameraModuleSvc.GetPlayShowCatMatTree", localGetPlayShowCatMatTreeRsp.Code);
      if (QLog.isDebugVersion()) {
        QLog.d(jdField_a_of_type_JavaLangString, 4, "[handlePlayShowCategoryMaterials] end");
      }
      return;
      if (QLog.isDebugVersion()) {
        QLog.d(jdField_a_of_type_JavaLangString, 4, "[handlePlayShowCategoryMaterials] response=empty");
      }
      if (!bkwl.a()) {
        break;
      }
      localObject = bkwl.a();
      if (paramFromServiceMsg.isSuccess()) {}
      for (paramObject = "succeeded without content";; paramObject = "failed")
      {
        ((bmen)localObject).a(new bkwp("CameraModuleSvc.GetPlayShowCatMatTree", "response", paramObject));
        break;
      }
    }
  }
  
  public void a()
  {
    if (!bdin.a())
    {
      LogUtils.w(jdField_a_of_type_JavaLangString, "[reqCameraConfig] no network....");
      return;
    }
    if (bkwl.a()) {
      bkwl.a().a(new bkwp("CameraModuleSvc.GetCameraConfig", "request", "null"));
    }
    bljn.b(jdField_a_of_type_JavaLangString, "【REQUEST】reqCameraConfig");
    this.jdField_a_of_type_JavaUtilMap.put("CameraModuleSvc.GetCameraConfig", Long.valueOf(System.currentTimeMillis()));
    ToServiceMsg localToServiceMsg = new ToServiceMsg("CameraModuleSvc", this.mApp.getCurrentAccountUin(), "CameraModuleSvc.GetCameraConfig");
    localToServiceMsg.extraData.putBoolean("req_pb_protocol_flag", false);
    send(localToServiceMsg);
  }
  
  protected void a(FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    bljn.b(jdField_a_of_type_JavaLangString, "【Handle】handleCameraConfig:" + paramFromServiceMsg.isSuccess());
    if (!paramFromServiceMsg.isSuccess())
    {
      if (bkwl.a()) {
        bkwl.a().a(new bkwp("CameraModuleSvc.GetCameraConfig", "response", "failed"));
      }
      return;
    }
    GetCameraConfigRsp localGetCameraConfigRsp = (GetCameraConfigRsp)paramObject;
    Object localObject1;
    Object localObject2;
    String str;
    Object localObject5;
    Object localObject3;
    if (localGetCameraConfigRsp.ConfigMap != null)
    {
      if (bkwl.a()) {
        bkwl.a().a(new bkwp("CameraModuleSvc.GetCameraConfig", "response", "succeeded with content"));
      }
      paramObject = "";
      localObject1 = "";
      localObject2 = "";
      Iterator localIterator = localGetCameraConfigRsp.ConfigMap.entrySet().iterator();
      str = "";
      if (localIterator.hasNext())
      {
        localObject5 = (Map.Entry)localIterator.next();
        localObject3 = (CameraConfig)((Map.Entry)localObject5).getValue();
        if (TextUtils.isEmpty(str))
        {
          str = ((CameraConfig)localObject3).ExpId;
          label184:
          localObject5 = (String)((Map.Entry)localObject5).getKey();
          if (!"app_ui_playshow_ad_id".equals(localObject5)) {
            break label268;
          }
          localObject3 = ((CameraConfig)localObject3).ConfigContent;
          paramObject = localObject2;
          localObject2 = localObject3;
        }
      }
    }
    for (;;)
    {
      localObject3 = localObject2;
      localObject2 = paramObject;
      paramObject = localObject3;
      break;
      str = str + "," + ((CameraConfig)localObject3).ExpId;
      break label184;
      label268:
      if ("app_alg_aio_camera_type_id".equals(localObject5))
      {
        localObject3 = ((CameraConfig)localObject3).ConfigContent;
        localObject1 = localObject2;
        localObject2 = paramObject;
        paramObject = localObject1;
        localObject1 = localObject3;
      }
      else if ("app_alg_entrance_qzone_id_from833".equals(localObject5))
      {
        localObject3 = ((CameraConfig)localObject3).ConfigContent;
        localObject2 = paramObject;
        paramObject = localObject3;
      }
      else
      {
        if ("app_ui_camera_ad_id".equals(localObject5))
        {
          try
          {
            localObject3 = new JsonParser().parse(((CameraConfig)localObject3).ConfigContent).getAsJsonArray();
            if ((localObject3 != null) && (((JsonArray)localObject3).size() > 0))
            {
              localObject3 = (JsonObject)((JsonArray)localObject3).get(0);
              bljc.a().a("camera_ad_op_id", GsonUtils.optString((JsonObject)localObject3, "opID"), 4);
              bljc.a().a("camera_ad_show", GsonUtils.optBoolean((JsonObject)localObject3, "showOp"), 4);
              bljc.a().a("camera_ad_icon_url", GsonUtils.optString((JsonObject)localObject3, "opIcon"), 4);
              bljc.a().a("camera_ad_type", GsonUtils.optString((JsonObject)localObject3, "type"), 4);
              bljc.a().a("camera_ad_schema", GsonUtils.optString((JsonObject)localObject3, "schema"), 4);
            }
            else
            {
              bljc.a().a("camera_ad_op_id", "", 4);
              bljc.a().a("camera_ad_show", false, 4);
              bljc.a().a("camera_ad_icon_url", "", 4);
              bljc.a().a("camera_ad_type", "", 4);
              bljc.a().a("camera_ad_schema", "", 4);
            }
          }
          catch (Exception localException)
          {
            bljn.d(jdField_a_of_type_JavaLangString, "camera ad ab test inflate error.");
            localObject4 = paramObject;
            paramObject = localObject2;
            localObject2 = localObject4;
          }
        }
        else
        {
          if ("app_alg_filter_timeout_id".equals(localObject5))
          {
            localObject4 = ((CameraConfig)localObject4).ConfigContent;
            bljc.a().a("app_alg_filter_timeout_id", (String)localObject4, 4);
          }
          localObject4 = paramObject;
          paramObject = localObject2;
          localObject2 = localObject4;
          continue;
          bljc.a().a("CameraModuleSvc.GetCameraConfig", str, 4);
          bljc.a().a("app_ui_playshow_ad_id", paramObject, 4);
          bljc.a().a("app_alg_aio_camera_type_id", (String)localObject1, 4);
          bljc.a().a("app_alg_entrance_qzone_id_from833", (String)localObject2, 4);
          paramObject = bliu.a();
          int i = paramFromServiceMsg.getResultCode();
          long l2 = System.currentTimeMillis();
          if (this.jdField_a_of_type_JavaUtilMap.containsKey("CameraModuleSvc.GetCameraConfig")) {}
          for (long l1 = ((Long)this.jdField_a_of_type_JavaUtilMap.get("CameraModuleSvc.GetCameraConfig")).longValue();; l1 = 0L)
          {
            paramObject.a(i, String.valueOf(l2 - l1), "CameraModuleSvc.GetCameraConfig", localGetCameraConfigRsp.Code);
            return;
            if (!bkwl.a()) {
              break;
            }
            bkwl.a().a(new bkwp("CameraModuleSvc.GetCameraConfig", "response", "succeeded without content"));
            break;
          }
        }
        Object localObject4 = paramObject;
        paramObject = localObject2;
        localObject2 = localObject4;
      }
    }
  }
  
  public void a(String paramString)
  {
    if (!bdin.a())
    {
      LogUtils.w(jdField_a_of_type_JavaLangString, "[reqCompressedMaterials] no network....");
      return;
    }
    bljn.b(jdField_a_of_type_JavaLangString, "【REQUEST】requestCompressedMaterials" + paramString);
    if (bkwl.a()) {
      bkwl.a().a(new bkwp("CameraModuleSvc.GetCompressedCategoryMaterial." + paramString, "request", "null"));
    }
    this.jdField_a_of_type_JavaUtilMap.put("CameraModuleSvc.GetCompressedCategoryMaterial." + paramString, Long.valueOf(System.currentTimeMillis()));
    ToServiceMsg localToServiceMsg = new ToServiceMsg("CameraModuleSvc", this.mApp.getCurrentAccountUin(), "CameraModuleSvc.GetCompressedCategoryMaterial");
    localToServiceMsg.extraData.putString("ServiceId", paramString);
    send(localToServiceMsg);
  }
  
  public void b()
  {
    if (!bdin.a())
    {
      if (QLog.isDebugVersion())
      {
        QLog.d(jdField_a_of_type_JavaLangString, 4, "[reqPlayShowCategoryMaterials] no network....");
        QLog.d(jdField_a_of_type_JavaLangString, 4, "[reqPlayShowCategoryMaterials] end");
      }
      return;
    }
    bljn.b(jdField_a_of_type_JavaLangString, "【REQUEST】reqPlayShowCategoryMaterials");
    if (bkwl.a()) {
      bkwl.a().a(new bkwp("CameraModuleSvc.GetPlayShowCatMatTree", "request", "null"));
    }
    this.jdField_a_of_type_JavaUtilMap.put("CameraModuleSvc.GetPlayShowCatMatTree", Long.valueOf(System.currentTimeMillis()));
    ToServiceMsg localToServiceMsg = new ToServiceMsg("CameraModuleSvc", this.mApp.getCurrentAccountUin(), "CameraModuleSvc.GetPlayShowCatMatTree");
    localToServiceMsg.extraData.putBoolean("req_pb_protocol_flag", false);
    send(localToServiceMsg);
  }
  
  protected Class<? extends alpg> observerClass()
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
 * Qualified Name:     bkzp
 * JD-Core Version:    0.7.0.1
 */