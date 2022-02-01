package com.tencent.aelight.camera.ae.config;

import android.os.Bundle;
import android.text.TextUtils;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.GetCameraConfigReq;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.GetCameraConfigRsp;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.GetCategoryMaterialReq;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.GetCategoryMaterialRsp;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.GetPlayShowCatMatTreeReq;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.GetPlayShowCatMatTreeRsp;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaSdkInfo;
import com.qq.jce.wup.UniPacket;
import com.tencent.aelight.camera.ae.util.AECameraPrefsUtil;
import com.tencent.common.app.BaseProtocolCoder;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import java.util.ArrayList;
import java.util.HashMap;

public class CameraDataService
  extends BaseProtocolCoder
{
  public static final HashMap<String, String> a;
  private static final String[] a;
  
  static
  {
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "ShadowBackendSvc" };
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  private boolean a(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    paramToServiceMsg = new GetCameraConfigReq();
    paramUniPacket.setServantName("ShadowBackendSvc");
    paramUniPacket.setFuncName("ShadowBackendSvc.GetCameraConfig");
    paramUniPacket.put("ShadowBackendSvc.GetCameraConfig", paramToServiceMsg);
    return true;
  }
  
  private boolean b(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    GetCategoryMaterialReq localGetCategoryMaterialReq = new GetCategoryMaterialReq();
    localGetCategoryMaterialReq.ServiceId = paramToServiceMsg.extraData.getString("ServiceId");
    paramToServiceMsg = new StringBuilder();
    paramToServiceMsg.append("ShadowBackendSvc.GetCategoryMaterial");
    paramToServiceMsg.append(localGetCategoryMaterialReq.ServiceId);
    localGetCategoryMaterialReq.ETag = a(paramToServiceMsg.toString());
    localGetCategoryMaterialReq.SdkInfos = a();
    paramUniPacket.setServantName("ShadowBackendSvc");
    paramUniPacket.setFuncName("ShadowBackendSvc.GetCategoryMaterial");
    paramUniPacket.put("ShadowBackendSvc.GetCategoryMaterial", localGetCategoryMaterialReq);
    return true;
  }
  
  private boolean c(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    paramToServiceMsg = new GetPlayShowCatMatTreeReq();
    paramToServiceMsg.ETag = a("ShadowBackendSvc.GetPlayShowCatMatTree");
    paramToServiceMsg.MqVersion = "8.7.0";
    paramUniPacket.setServantName("ShadowBackendSvc");
    paramUniPacket.setFuncName("ShadowBackendSvc.GetPlayShowCatMatTree");
    paramUniPacket.put("ShadowBackendSvc.GetPlayShowCatMatTree", paramToServiceMsg);
    return true;
  }
  
  public final <T> T a(byte[] paramArrayOfByte, String paramString, T paramT)
  {
    CompressUniPacket localCompressUniPacket = new CompressUniPacket(true);
    try
    {
      localCompressUniPacket.setEncodeName("utf-8");
      localCompressUniPacket.decode(paramArrayOfByte);
      return localCompressUniPacket.getByClass(paramString, paramT);
    }
    catch (Exception paramArrayOfByte)
    {
      label31:
      break label31;
    }
    return null;
  }
  
  protected String a(String paramString)
  {
    return AECameraPrefsUtil.a().a(paramString, "", 4);
  }
  
  protected ArrayList<MetaSdkInfo> a()
  {
    ArrayList localArrayList = new ArrayList();
    MetaSdkInfo localMetaSdkInfo = new MetaSdkInfo();
    localMetaSdkInfo.sdk = 0;
    localMetaSdkInfo.sdkVersion = "2.0.0";
    Object localObject = "2.2.6.40";
    if (!TextUtils.isEmpty("2.2.6.40"))
    {
      String[] arrayOfString = "2.2.6.40".split("\\.");
      if (arrayOfString.length > 3)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(arrayOfString[0]);
        ((StringBuilder)localObject).append(".");
        ((StringBuilder)localObject).append(arrayOfString[1]);
        ((StringBuilder)localObject).append(".");
        ((StringBuilder)localObject).append(arrayOfString[2]);
        localObject = ((StringBuilder)localObject).toString();
      }
      localMetaSdkInfo.sdkVersion = ((String)localObject);
    }
    localArrayList.add(localMetaSdkInfo);
    return localArrayList;
  }
  
  public String[] cmdHeaderPrefix()
  {
    return jdField_a_of_type_ArrayOfJavaLangString;
  }
  
  public Object decode(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("ShadowBackendSvc.GetCameraConfig")) {
      return decodePacket(paramFromServiceMsg.getWupBuffer(), "ShadowBackendSvc.GetCameraConfig", new GetCameraConfigRsp());
    }
    if (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("ShadowBackendSvc.GetCategoryMaterial")) {
      return a(paramFromServiceMsg.getWupBuffer(), "ShadowBackendSvc.GetCategoryMaterial", new GetCategoryMaterialRsp());
    }
    if (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("ShadowBackendSvc.GetPlayShowCatMatTree")) {
      return a(paramFromServiceMsg.getWupBuffer(), "ShadowBackendSvc.GetPlayShowCatMatTree", new GetPlayShowCatMatTreeRsp());
    }
    return null;
  }
  
  public boolean encodeReqMsg(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    if (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("ShadowBackendSvc.GetCameraConfig")) {
      return a(paramToServiceMsg, paramUniPacket);
    }
    if (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("ShadowBackendSvc.GetCategoryMaterial")) {
      return b(paramToServiceMsg, paramUniPacket);
    }
    if (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("ShadowBackendSvc.GetPlayShowCatMatTree")) {
      return c(paramToServiceMsg, paramUniPacket);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.config.CameraDataService
 * JD-Core Version:    0.7.0.1
 */