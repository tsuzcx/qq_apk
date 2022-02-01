package com.tencent.aelight.camera.aeeditor.manage;

import android.os.Bundle;
import android.text.TextUtils;
import camera.SHADOW_BACKEND_INTERFACE.GetBigShowRecommendReq;
import camera.SHADOW_BACKEND_INTERFACE.GetBigShowRecommendRsp;
import camera.SHADOW_BACKEND_INTERFACE.GetCatMatTreeReq;
import camera.SHADOW_BACKEND_INTERFACE.GetCatMatTreeRsp;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaSdkInfo;
import com.qq.jce.wup.UniPacket;
import com.tencent.aelight.camera.ae.config.CompressUniPacket;
import com.tencent.aelight.camera.ae.util.AECameraPrefsUtil;
import com.tencent.common.app.BaseProtocolCoder;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import java.util.ArrayList;
import java.util.HashMap;

public class AEEditorDataService
  extends BaseProtocolCoder
{
  public static final HashMap<String, String> a;
  private static final String[] a;
  
  static
  {
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "ShadowBackendSvc" };
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  private String a(String paramString)
  {
    return AECameraPrefsUtil.a().a(paramString, "", 4);
  }
  
  private ArrayList<MetaSdkInfo> a()
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
  
  private boolean a(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    GetCatMatTreeReq localGetCatMatTreeReq = new GetCatMatTreeReq();
    localGetCatMatTreeReq.ServiceId = paramToServiceMsg.extraData.getString("ServiceId");
    localGetCatMatTreeReq.ETag = a("ShadowBackendSvc.GetCircleCatMatTreeMqCircleEditor");
    localGetCatMatTreeReq.SdkInfos = a();
    localGetCatMatTreeReq.GroupId = "3";
    paramUniPacket.setServantName("ShadowBackendSvc");
    paramUniPacket.setFuncName("ShadowBackendSvc.GetCircleCatMatTree");
    paramUniPacket.put("ShadowBackendSvc.GetCircleCatMatTree", localGetCatMatTreeReq);
    return true;
  }
  
  private boolean b(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    GetBigShowRecommendReq localGetBigShowRecommendReq = new GetBigShowRecommendReq();
    localGetBigShowRecommendReq.framePics = ((ArrayList)paramToServiceMsg.extraData.getSerializable("framebytes"));
    localGetBigShowRecommendReq.SdkVersion = ((MetaSdkInfo)a().get(0)).sdkVersion;
    paramUniPacket.setServantName("ShadowBackendSvc");
    paramUniPacket.setFuncName("ShadowBackendSvc.GetBigShowRecommend");
    paramUniPacket.put("ShadowBackendSvc.GetBigShowRecommend", localGetBigShowRecommendReq);
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
  
  public String[] cmdHeaderPrefix()
  {
    return jdField_a_of_type_ArrayOfJavaLangString;
  }
  
  public Object decode(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("ShadowBackendSvc.GetCircleCatMatTree")) {
      return a(paramFromServiceMsg.getWupBuffer(), "ShadowBackendSvc.GetCircleCatMatTree", new GetCatMatTreeRsp());
    }
    if (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("ShadowBackendSvc.GetBigShowRecommend")) {
      return a(paramFromServiceMsg.getWupBuffer(), "ShadowBackendSvc.GetBigShowRecommend", new GetBigShowRecommendRsp());
    }
    return null;
  }
  
  public boolean encodeReqMsg(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    if (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("ShadowBackendSvc.GetCircleCatMatTree")) {
      return a(paramToServiceMsg, paramUniPacket);
    }
    if (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("ShadowBackendSvc.GetBigShowRecommend")) {
      return b(paramToServiceMsg, paramUniPacket);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.manage.AEEditorDataService
 * JD-Core Version:    0.7.0.1
 */