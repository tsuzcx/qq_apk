import android.os.Bundle;
import android.text.TextUtils;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.CameraConfig;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.GetCameraConfigRsp;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.GetCategoryMaterialRsp;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.GetPlayShowCatMatTreeRsp;
import com.google.gson.Gson;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.util.GsonUtils;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class avzi
  extends ajfb
{
  private static final String jdField_a_of_type_JavaLangString = avzi.class.getSimpleName();
  public static final Type a;
  private atmp jdField_a_of_type_Atmp;
  protected Map<String, Long> a;
  
  static
  {
    jdField_a_of_type_JavaLangReflectType = new avzj().getType();
  }
  
  public avzi(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    LogUtils.setEnable(false);
    this.jdField_a_of_type_Atmp = paramAppInterface.getEntityManagerFactory().createEntityManager();
  }
  
  private void b(FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramObject = (GetCategoryMaterialRsp)paramObject;
    if ((paramObject != null) && (paramObject.Code == 0) && (!paramObject.Categories.isEmpty()))
    {
      if (bgxl.a()) {
        bgxl.a().a(new bgxp("CameraModuleSvc.GetCompressedCategoryMaterial.MqStoryCamera", "response", "succeeded with content"));
      }
      bgxb.a().a("CameraModuleSvc.GetCompressedCategoryMaterialMqStoryCamera", paramObject.ETag, 4);
      paramObject = new Gson().toJson(paramObject);
      bace.a(bgxx.a(), paramObject);
      paramObject = (bgxx)bhfm.a().c(18);
      if (paramObject != null)
      {
        paramObject.b();
        paramObject.f();
      }
      avzk.b().a(Boolean.valueOf(true));
      ((bgxx)bhfm.a(18)).a(avzg.jdField_a_of_type_JavaLangString);
      if ((this.jdField_a_of_type_JavaUtilMap == null) || (!this.jdField_a_of_type_JavaUtilMap.containsKey("CameraModuleSvc.GetCompressedCategoryMaterial.MqStoryCamera"))) {
        break label235;
      }
    }
    label235:
    for (paramObject = "" + (System.currentTimeMillis() - ((Long)this.jdField_a_of_type_JavaUtilMap.get("CameraModuleSvc.GetCompressedCategoryMaterial.MqStoryCamera")).longValue());; paramObject = "-1")
    {
      bhci.a().a(paramFromServiceMsg.getResultCode(), paramObject, "CameraModuleSvc.GetCompressedCategoryMaterial.MqStoryCamera");
      return;
      if (!bgxl.a()) {
        break;
      }
      bgxl.a().a(new bgxp("CameraModuleSvc.GetCompressedCategoryMaterial.MqStoryCamera", "response", "failed / without content"));
      break;
    }
  }
  
  private void c(FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramObject = (GetCategoryMaterialRsp)paramObject;
    if ((paramObject != null) && (paramObject.Code == 0) && (!paramObject.Categories.isEmpty()))
    {
      if (bgxl.a()) {
        bgxl.a().a(new bgxp("CameraModuleSvc.GetCompressedCategoryMaterial.MqEmoCamera", "response", "succeeded with content"));
      }
      bgxb.a().a("CameraModuleSvc.GetCompressedCategoryMaterialMqEmoCamera", paramObject.ETag, 4);
      paramObject = new Gson().toJson(paramObject);
      bace.a(avzg.b, paramObject);
      avzk.a().a(Boolean.valueOf(true));
      if ((this.jdField_a_of_type_JavaUtilMap == null) || (!this.jdField_a_of_type_JavaUtilMap.containsKey("CameraModuleSvc.GetCompressedCategoryMaterial.MqEmoCamera"))) {
        break label197;
      }
    }
    label197:
    for (paramObject = "" + (System.currentTimeMillis() - ((Long)this.jdField_a_of_type_JavaUtilMap.get("CameraModuleSvc.GetCompressedCategoryMaterial.MqEmoCamera")).longValue());; paramObject = "-1")
    {
      bhci.a().a(paramFromServiceMsg.getResultCode(), paramObject, "CameraModuleSvc.GetCompressedCategoryMaterial.MqEmoCamera");
      return;
      if (!bgxl.a()) {
        break;
      }
      bgxl.a().a(new bgxp("CameraModuleSvc.GetCompressedCategoryMaterial.MqEmoCamera", "response", "failed / without content"));
      break;
    }
  }
  
  private void d(FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isDebugVersion()) {
      QLog.d(jdField_a_of_type_JavaLangString, 4, "[handlePlayShowCategoryMaterials] start");
    }
    paramObject = (GetPlayShowCatMatTreeRsp)paramObject;
    if ((paramObject != null) && (paramObject.Code == 0) && (!paramObject.Categories.isEmpty()))
    {
      if (QLog.isDebugVersion()) {
        QLog.d(jdField_a_of_type_JavaLangString, 4, "[handlePlayShowCategoryMaterials] response=" + paramObject);
      }
      if (bgxl.a()) {
        bgxl.a().a(new bgxp("CameraModuleSvc.GetPlayShowCatMatTree", "response", "succeeded with content"));
      }
      bgxb.a().a("CameraModuleSvc.GetPlayShowCatMatTree", paramObject.ETag, 4);
      paramObject = GsonUtils.obj2Json(paramObject, jdField_a_of_type_JavaLangReflectType);
      bace.a(avzg.d, paramObject);
      avzk.c().a(Boolean.valueOf(true));
      if ((this.jdField_a_of_type_JavaUtilMap == null) || (!this.jdField_a_of_type_JavaUtilMap.containsKey("CameraModuleSvc.GetPlayShowCatMatTree"))) {
        break label272;
      }
    }
    label272:
    for (paramObject = "" + (System.currentTimeMillis() - ((Long)this.jdField_a_of_type_JavaUtilMap.get("CameraModuleSvc.GetPlayShowCatMatTree")).longValue());; paramObject = "-1")
    {
      bhci.a().a(paramFromServiceMsg.getResultCode(), paramObject, "CameraModuleSvc.GetPlayShowCatMatTree");
      if (QLog.isDebugVersion()) {
        QLog.d(jdField_a_of_type_JavaLangString, 4, "[handlePlayShowCategoryMaterials] end");
      }
      return;
      if (QLog.isDebugVersion()) {
        QLog.d(jdField_a_of_type_JavaLangString, 4, "[handlePlayShowCategoryMaterials] response=empty");
      }
      if (!bgxl.a()) {
        break;
      }
      bgxl.a().a(new bgxp("CameraModuleSvc.GetPlayShowCatMatTree", "response", "failed / without content"));
      break;
    }
  }
  
  public void a()
  {
    if (!badq.a())
    {
      LogUtils.w(jdField_a_of_type_JavaLangString, "[reqCameraConfig] no network....");
      return;
    }
    if (bgxl.a()) {
      bgxl.a().a(new bgxp("CameraModuleSvc.GetCameraConfig", "request", "null"));
    }
    bhcs.a(jdField_a_of_type_JavaLangString, 1, "【REQUEST】reqCameraConfig");
    this.jdField_a_of_type_JavaUtilMap.put("CameraModuleSvc.GetCameraConfig", Long.valueOf(System.currentTimeMillis()));
    ToServiceMsg localToServiceMsg = new ToServiceMsg("CameraModuleSvc", this.mApp.getCurrentAccountUin(), "CameraModuleSvc.GetCameraConfig");
    localToServiceMsg.extraData.putBoolean("req_pb_protocol_flag", false);
    send(localToServiceMsg);
  }
  
  protected void a(FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    bhcs.a(jdField_a_of_type_JavaLangString, 1, "【Handle】handleCameraConfig:" + paramFromServiceMsg.isSuccess());
    if (!paramFromServiceMsg.isSuccess())
    {
      if (bgxl.a()) {
        bgxl.a().a(new bgxp("CameraModuleSvc.GetCameraConfig", "response", "failed"));
      }
      return;
    }
    paramFromServiceMsg = (GetCameraConfigRsp)paramObject;
    String str2;
    String str1;
    label132:
    CameraConfig localCameraConfig;
    if (paramFromServiceMsg.ConfigMap != null)
    {
      if (bgxl.a()) {
        bgxl.a().a(new bgxp("CameraModuleSvc.GetCameraConfig", "response", "succeeded with content"));
      }
      paramObject = "";
      Iterator localIterator = paramFromServiceMsg.ConfigMap.entrySet().iterator();
      str2 = "";
      paramFromServiceMsg = "";
      str1 = "";
      if (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        localCameraConfig = (CameraConfig)localEntry.getValue();
        if (TextUtils.isEmpty(paramFromServiceMsg))
        {
          paramFromServiceMsg = localCameraConfig.ExpId;
          label179:
          if ("app_alg_entrance_id".equals(localEntry.getKey())) {
            str2 = localCameraConfig.ConfigContent;
          }
          if ("app_ui_playshow_ad_id".equals(localEntry.getKey())) {
            str1 = localCameraConfig.ConfigContent;
          }
          if (!"app_alg_aio_camera_type_id".equals(localEntry.getKey())) {
            break label389;
          }
          paramObject = localCameraConfig.ConfigContent;
        }
      }
    }
    label389:
    for (;;)
    {
      break label132;
      paramFromServiceMsg = paramFromServiceMsg + "," + localCameraConfig.ExpId;
      break label179;
      bgxb.a().a("CameraModuleSvc.GetCameraConfig", paramFromServiceMsg, 4);
      bgxb.a().a("app_alg_entrance_id", str2, 4);
      bgxb.a().a("app_ui_playshow_ad_id", str1, 4);
      bgxb.a().a("app_alg_aio_camera_type_id", paramObject, 4);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i(jdField_a_of_type_JavaLangString, 2, "[handleCameraConfig], app_alg_entrance_id=" + str2);
      return;
      if (!bgxl.a()) {
        break;
      }
      bgxl.a().a(new bgxp("CameraModuleSvc.GetCameraConfig", "response", "succeeded without content"));
      return;
    }
  }
  
  public void a(String paramString)
  {
    if (!badq.a())
    {
      LogUtils.w(jdField_a_of_type_JavaLangString, "[reqCompressedMaterials] no network....");
      return;
    }
    bhcs.a(jdField_a_of_type_JavaLangString, 1, "【REQUEST】requestCompressedMaterials" + paramString);
    if (bgxl.a()) {
      bgxl.a().a(new bgxp("CameraModuleSvc.GetCompressedCategoryMaterial." + paramString, "request", "null"));
    }
    this.jdField_a_of_type_JavaUtilMap.put("CameraModuleSvc.GetCompressedCategoryMaterial." + paramString, Long.valueOf(System.currentTimeMillis()));
    ToServiceMsg localToServiceMsg = new ToServiceMsg("CameraModuleSvc", this.mApp.getCurrentAccountUin(), "CameraModuleSvc.GetCompressedCategoryMaterial");
    localToServiceMsg.extraData.putString("ServiceId", paramString);
    send(localToServiceMsg);
  }
  
  public void b()
  {
    if (!badq.a())
    {
      if (QLog.isDebugVersion())
      {
        QLog.d(jdField_a_of_type_JavaLangString, 4, "[reqPlayShowCategoryMaterials] no network....");
        QLog.d(jdField_a_of_type_JavaLangString, 4, "[reqPlayShowCategoryMaterials] end");
      }
      return;
    }
    bhcs.a(jdField_a_of_type_JavaLangString, 1, "【REQUEST】reqPlayShowCategoryMaterials");
    if (bgxl.a()) {
      bgxl.a().a(new bgxp("CameraModuleSvc.GetPlayShowCatMatTree", "request", "null"));
    }
    this.jdField_a_of_type_JavaUtilMap.put("CameraModuleSvc.GetPlayShowCatMatTree", Long.valueOf(System.currentTimeMillis()));
    ToServiceMsg localToServiceMsg = new ToServiceMsg("CameraModuleSvc", this.mApp.getCurrentAccountUin(), "CameraModuleSvc.GetPlayShowCatMatTree");
    localToServiceMsg.extraData.putBoolean("req_pb_protocol_flag", false);
    send(localToServiceMsg);
  }
  
  protected Class<? extends ajfe> observerClass()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avzi
 * JD-Core Version:    0.7.0.1
 */