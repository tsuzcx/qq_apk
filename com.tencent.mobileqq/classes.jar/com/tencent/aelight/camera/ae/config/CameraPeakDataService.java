package com.tencent.aelight.camera.ae.config;

import android.os.Bundle;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.GetBulkImageClassifyReq;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.GetBulkImageClassifyRsp;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.GetCameraConfigReq;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.GetCameraConfigRsp;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.GetFontDataReq;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.GetFontDataRsp;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.GetImgValidStatusReq;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.GetImgValidStatusRsp;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.GetOnlineUserNumReq;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.GetOnlineUserNumRsp;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.GetRecommandTextByEmotionReq;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.GetRecommandTextByEmotionRsp;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.GetTextValidStatusReq;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.GetTextValidStatusRsp;
import camera.SHADOW_BACKEND_INTERFACE.GetBigShowRecommendReq;
import camera.SHADOW_BACKEND_INTERFACE.GetBigShowRecommendRsp;
import camera.SHADOW_BACKEND_INTERFACE.GetCatMatTreeReq;
import camera.SHADOW_BACKEND_INTERFACE.GetCatMatTreeRsp;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaSdkInfo;
import com.qq.jce.wup.UniPacket;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import java.util.ArrayList;

public class CameraPeakDataService
  extends CameraDataService
{
  private static final String[] b = { "ShadowBackendSvc" };
  
  private boolean a(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    GetFontDataReq localGetFontDataReq = new GetFontDataReq();
    localGetFontDataReq.Content = paramToServiceMsg.extraData.getString("Content");
    localGetFontDataReq.FontName = paramToServiceMsg.extraData.getString("FontName");
    paramUniPacket.setServantName("ShadowBackendSvc");
    paramUniPacket.setFuncName("ShadowBackendSvc.GetFontData");
    paramUniPacket.put("ShadowBackendSvc.GetFontData", localGetFontDataReq);
    return true;
  }
  
  private boolean b(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    GetImgValidStatusReq localGetImgValidStatusReq = new GetImgValidStatusReq();
    localGetImgValidStatusReq.Rawdata = paramToServiceMsg.extraData.getByteArray("Rawdata");
    paramUniPacket.setServantName("ShadowBackendSvc");
    paramUniPacket.setFuncName("ShadowBackendSvc.GetImgValidStatus");
    paramUniPacket.put("ShadowBackendSvc.GetImgValidStatus", localGetImgValidStatusReq);
    return true;
  }
  
  private boolean c(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    GetBulkImageClassifyReq localGetBulkImageClassifyReq = new GetBulkImageClassifyReq();
    localGetBulkImageClassifyReq.MultiPics = ((ArrayList)paramToServiceMsg.extraData.getSerializable("AI_FILTER_REQ_PICS"));
    paramUniPacket.setServantName("ShadowBackendSvc");
    paramUniPacket.setFuncName("ShadowBackendSvc.GetBulkImageClassify");
    paramUniPacket.put("ShadowBackendSvc.GetBulkImageClassify", localGetBulkImageClassifyReq);
    paramToServiceMsg.setTimeout(15000L);
    return true;
  }
  
  private boolean d(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    paramToServiceMsg = new GetOnlineUserNumReq();
    paramUniPacket.setServantName("ShadowBackendSvc");
    paramUniPacket.setFuncName("ShadowBackendSvc.GetOnlineUserNum");
    paramUniPacket.put("ShadowBackendSvc.GetOnlineUserNum", paramToServiceMsg);
    return true;
  }
  
  private boolean e(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    paramToServiceMsg = new GetCameraConfigReq();
    paramUniPacket.setServantName("ShadowBackendSvc");
    paramUniPacket.setFuncName("ShadowBackendSvc.GetCameraConfig");
    paramUniPacket.put("ShadowBackendSvc.GetCameraConfig", paramToServiceMsg);
    return true;
  }
  
  private boolean f(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    GetRecommandTextByEmotionReq localGetRecommandTextByEmotionReq = new GetRecommandTextByEmotionReq();
    localGetRecommandTextByEmotionReq.Rawdata = paramToServiceMsg.extraData.getByteArray("Rawdata");
    paramUniPacket.setServantName("ShadowBackendSvc");
    paramUniPacket.setFuncName("ShadowBackendSvc.GetRecommandTextByEmotion");
    paramUniPacket.put("ShadowBackendSvc.GetRecommandTextByEmotion", localGetRecommandTextByEmotionReq);
    return true;
  }
  
  private boolean g(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    GetTextValidStatusReq localGetTextValidStatusReq = new GetTextValidStatusReq();
    localGetTextValidStatusReq.EmoText = paramToServiceMsg.extraData.getString("EmoText");
    paramUniPacket.setServantName("ShadowBackendSvc");
    paramUniPacket.setFuncName("ShadowBackendSvc.GetTextValidStatus");
    paramUniPacket.put("ShadowBackendSvc.GetTextValidStatus", localGetTextValidStatusReq);
    return true;
  }
  
  private boolean h(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
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
  
  private boolean i(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    GetBigShowRecommendReq localGetBigShowRecommendReq = new GetBigShowRecommendReq();
    localGetBigShowRecommendReq.framePics = ((ArrayList)paramToServiceMsg.extraData.getSerializable("framebytes"));
    localGetBigShowRecommendReq.SdkVersion = ((MetaSdkInfo)a().get(0)).sdkVersion;
    localGetBigShowRecommendReq.MediaType = paramToServiceMsg.extraData.getInt("media_type", 0);
    paramUniPacket.setServantName("ShadowBackendSvc");
    paramUniPacket.setFuncName("ShadowBackendSvc.GetBigShowRecommend");
    paramUniPacket.put("ShadowBackendSvc.GetBigShowRecommend", localGetBigShowRecommendReq);
    return true;
  }
  
  public String[] cmdHeaderPrefix()
  {
    return b;
  }
  
  public Object decode(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("ShadowBackendSvc.GetRecommandTextByEmotion")) {
      return decodePacket(paramFromServiceMsg.getWupBuffer(), "ShadowBackendSvc.GetRecommandTextByEmotion", new GetRecommandTextByEmotionRsp());
    }
    if (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("ShadowBackendSvc.GetTextValidStatus")) {
      return decodePacket(paramFromServiceMsg.getWupBuffer(), "ShadowBackendSvc.GetTextValidStatus", new GetTextValidStatusRsp());
    }
    if (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("ShadowBackendSvc.GetCameraConfig")) {
      return decodePacket(paramFromServiceMsg.getWupBuffer(), "ShadowBackendSvc.GetCameraConfig", new GetCameraConfigRsp());
    }
    if (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("ShadowBackendSvc.GetOnlineUserNum")) {
      return decodePacket(paramFromServiceMsg.getWupBuffer(), "ShadowBackendSvc.GetOnlineUserNum", new GetOnlineUserNumRsp());
    }
    if (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("ShadowBackendSvc.GetFontData")) {
      return decodePacket(paramFromServiceMsg.getWupBuffer(), "ShadowBackendSvc.GetFontData", new GetFontDataRsp());
    }
    if (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("ShadowBackendSvc.GetImgValidStatus")) {
      return decodePacket(paramFromServiceMsg.getWupBuffer(), "ShadowBackendSvc.GetImgValidStatus", new GetImgValidStatusRsp());
    }
    if (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("ShadowBackendSvc.GetBulkImageClassify")) {
      return decodePacket(paramFromServiceMsg.getWupBuffer(), "ShadowBackendSvc.GetBulkImageClassify", new GetBulkImageClassifyRsp());
    }
    if (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("ShadowBackendSvc.GetCircleCatMatTree")) {
      return a(paramFromServiceMsg.getWupBuffer(), "ShadowBackendSvc.GetCircleCatMatTree", new GetCatMatTreeRsp());
    }
    if (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("ShadowBackendSvc.GetBigShowRecommend")) {
      return a(paramFromServiceMsg.getWupBuffer(), "ShadowBackendSvc.GetBigShowRecommend", new GetBigShowRecommendRsp());
    }
    return super.decode(paramToServiceMsg, paramFromServiceMsg);
  }
  
  public boolean encodeReqMsg(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    if (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("ShadowBackendSvc.GetRecommandTextByEmotion")) {
      return f(paramToServiceMsg, paramUniPacket);
    }
    if (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("ShadowBackendSvc.GetTextValidStatus")) {
      return g(paramToServiceMsg, paramUniPacket);
    }
    if (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("ShadowBackendSvc.GetCameraConfig")) {
      return e(paramToServiceMsg, paramUniPacket);
    }
    if (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("ShadowBackendSvc.GetOnlineUserNum")) {
      return d(paramToServiceMsg, paramUniPacket);
    }
    if (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("ShadowBackendSvc.GetFontData")) {
      return a(paramToServiceMsg, paramUniPacket);
    }
    if (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("ShadowBackendSvc.GetImgValidStatus")) {
      return b(paramToServiceMsg, paramUniPacket);
    }
    if (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("ShadowBackendSvc.GetBulkImageClassify")) {
      return c(paramToServiceMsg, paramUniPacket);
    }
    if (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("ShadowBackendSvc.GetCircleCatMatTree")) {
      return h(paramToServiceMsg, paramUniPacket);
    }
    if (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("ShadowBackendSvc.GetBigShowRecommend")) {
      return i(paramToServiceMsg, paramUniPacket);
    }
    return super.encodeReqMsg(paramToServiceMsg, paramUniPacket);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.config.CameraPeakDataService
 * JD-Core Version:    0.7.0.1
 */