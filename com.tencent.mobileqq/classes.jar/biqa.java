import android.os.Bundle;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.GetCameraConfigReq;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.GetCameraConfigRsp;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.GetCategoryMaterialReq;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.GetCategoryMaterialRsp;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.GetPlayShowCatMatTreeReq;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.GetPlayShowCatMatTreeRsp;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaSdkInfo;
import com.qq.jce.wup.UniPacket;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import java.util.ArrayList;
import java.util.HashMap;

public class biqa
  extends xop
{
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "CameraModuleSvc" };
  public static final HashMap<String, String> b = new HashMap();
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  
  public biqa(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
  }
  
  private String a(String paramString)
  {
    return bizj.a().a(paramString, "", 4);
  }
  
  private ArrayList<MetaSdkInfo> a()
  {
    ArrayList localArrayList = new ArrayList();
    MetaSdkInfo localMetaSdkInfo = new MetaSdkInfo();
    localMetaSdkInfo.sdk = 0;
    localMetaSdkInfo.sdkVersion = AEModule.getVersion(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp());
    localArrayList.add(localMetaSdkInfo);
    return localArrayList;
  }
  
  private boolean b(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    paramToServiceMsg = new GetCameraConfigReq();
    paramUniPacket.setServantName("CameraModuleSvc");
    paramUniPacket.setFuncName("CameraModuleSvc.GetCameraConfig");
    paramUniPacket.put("CameraModuleSvc.GetCameraConfig", paramToServiceMsg);
    return true;
  }
  
  private boolean c(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    GetCategoryMaterialReq localGetCategoryMaterialReq = new GetCategoryMaterialReq();
    localGetCategoryMaterialReq.ServiceId = paramToServiceMsg.extraData.getString("ServiceId");
    localGetCategoryMaterialReq.ETag = a("CameraModuleSvc.GetCompressedCategoryMaterial" + localGetCategoryMaterialReq.ServiceId);
    localGetCategoryMaterialReq.SdkInfos = a();
    paramUniPacket.setServantName("CameraModuleSvc");
    paramUniPacket.setFuncName("CameraModuleSvc.GetCompressedCategoryMaterial");
    paramUniPacket.put("CameraModuleSvc.GetCompressedCategoryMaterial", localGetCategoryMaterialReq);
    return true;
  }
  
  private boolean d(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    paramToServiceMsg = new GetPlayShowCatMatTreeReq();
    paramToServiceMsg.ETag = a("CameraModuleSvc.GetPlayShowCatMatTree");
    paramToServiceMsg.MqVersion = "8.2.8";
    paramUniPacket.setServantName("CameraModuleSvc");
    paramUniPacket.setFuncName("CameraModuleSvc.GetPlayShowCatMatTree");
    paramUniPacket.put("CameraModuleSvc.GetPlayShowCatMatTree", paramToServiceMsg);
    return true;
  }
  
  public Object a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("CameraModuleSvc.GetCameraConfig")) {
      return a(paramFromServiceMsg.getWupBuffer(), "CameraModuleSvc.GetCameraConfig", new GetCameraConfigRsp());
    }
    if (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("CameraModuleSvc.GetCompressedCategoryMaterial")) {
      return b(paramFromServiceMsg.getWupBuffer(), "CameraModuleSvc.GetCompressedCategoryMaterial", new GetCategoryMaterialRsp());
    }
    if (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("CameraModuleSvc.GetPlayShowCatMatTree")) {
      return b(paramFromServiceMsg.getWupBuffer(), "CameraModuleSvc.GetPlayShowCatMatTree", new GetPlayShowCatMatTreeRsp());
    }
    return null;
  }
  
  public boolean a(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    if (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("CameraModuleSvc.GetCameraConfig")) {
      return b(paramToServiceMsg, paramUniPacket);
    }
    if (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("CameraModuleSvc.GetCompressedCategoryMaterial")) {
      return c(paramToServiceMsg, paramUniPacket);
    }
    if (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("CameraModuleSvc.GetPlayShowCatMatTree")) {
      return d(paramToServiceMsg, paramUniPacket);
    }
    return false;
  }
  
  public String[] a()
  {
    return jdField_a_of_type_ArrayOfJavaLangString;
  }
  
  public final <T> T b(byte[] paramArrayOfByte, String paramString, T paramT)
  {
    biqi localbiqi = new biqi(true);
    try
    {
      localbiqi.setEncodeName("utf-8");
      localbiqi.decode(paramArrayOfByte);
      return localbiqi.getByClass(paramString, paramT);
    }
    catch (Exception paramArrayOfByte) {}
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     biqa
 * JD-Core Version:    0.7.0.1
 */