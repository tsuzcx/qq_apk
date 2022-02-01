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
import com.qq.jce.wup.UniPacket;
import com.tencent.mobileqq.app.PeakAppInterface;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import java.util.ArrayList;

public class boqh
  extends boqd
{
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "CameraModuleSvc" };
  private PeakAppInterface jdField_a_of_type_ComTencentMobileqqAppPeakAppInterface;
  
  public boqh(PeakAppInterface paramPeakAppInterface)
  {
    super(paramPeakAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqAppPeakAppInterface = paramPeakAppInterface;
  }
  
  private boolean b(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    GetFontDataReq localGetFontDataReq = new GetFontDataReq();
    localGetFontDataReq.Content = paramToServiceMsg.extraData.getString("Content");
    localGetFontDataReq.FontName = paramToServiceMsg.extraData.getString("FontName");
    paramUniPacket.setServantName("CameraModuleSvc");
    paramUniPacket.setFuncName("CameraModuleSvc.GetFontData");
    paramUniPacket.put("CameraModuleSvc.GetFontData", localGetFontDataReq);
    return true;
  }
  
  private boolean c(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    GetImgValidStatusReq localGetImgValidStatusReq = new GetImgValidStatusReq();
    localGetImgValidStatusReq.Rawdata = paramToServiceMsg.extraData.getByteArray("Rawdata");
    paramUniPacket.setServantName("CameraModuleSvc");
    paramUniPacket.setFuncName("CameraModuleSvc.GetImgValidStatus");
    paramUniPacket.put("CameraModuleSvc.GetImgValidStatus", localGetImgValidStatusReq);
    return true;
  }
  
  private boolean d(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    GetBulkImageClassifyReq localGetBulkImageClassifyReq = new GetBulkImageClassifyReq();
    localGetBulkImageClassifyReq.MultiPics = ((ArrayList)paramToServiceMsg.extraData.getSerializable("AI_FILTER_REQ_PICS"));
    paramUniPacket.setServantName("CameraModuleSvc");
    paramUniPacket.setFuncName("CameraModuleSvc.GetBulkImageClassify");
    paramUniPacket.put("CameraModuleSvc.GetBulkImageClassify", localGetBulkImageClassifyReq);
    paramToServiceMsg.setTimeout(15000L);
    return true;
  }
  
  private boolean e(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    paramToServiceMsg = new GetOnlineUserNumReq();
    paramUniPacket.setServantName("CameraModuleSvc");
    paramUniPacket.setFuncName("CameraModuleSvc.GetOnlineUserNum");
    paramUniPacket.put("CameraModuleSvc.GetOnlineUserNum", paramToServiceMsg);
    return true;
  }
  
  private boolean f(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    paramToServiceMsg = new GetCameraConfigReq();
    paramUniPacket.setServantName("CameraModuleSvc");
    paramUniPacket.setFuncName("CameraModuleSvc.GetCameraConfig");
    paramUniPacket.put("CameraModuleSvc.GetCameraConfig", paramToServiceMsg);
    return true;
  }
  
  private boolean g(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    GetRecommandTextByEmotionReq localGetRecommandTextByEmotionReq = new GetRecommandTextByEmotionReq();
    localGetRecommandTextByEmotionReq.Rawdata = paramToServiceMsg.extraData.getByteArray("Rawdata");
    paramUniPacket.setServantName("CameraModuleSvc");
    paramUniPacket.setFuncName("CameraModuleSvc.GetRecommandTextByEmotion");
    paramUniPacket.put("CameraModuleSvc.GetRecommandTextByEmotion", localGetRecommandTextByEmotionReq);
    return true;
  }
  
  private boolean h(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    GetTextValidStatusReq localGetTextValidStatusReq = new GetTextValidStatusReq();
    localGetTextValidStatusReq.EmoText = paramToServiceMsg.extraData.getString("EmoText");
    paramUniPacket.setServantName("CameraModuleSvc");
    paramUniPacket.setFuncName("CameraModuleSvc.GetTextValidStatus");
    paramUniPacket.put("CameraModuleSvc.GetTextValidStatus", localGetTextValidStatusReq);
    return true;
  }
  
  public Object a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("CameraModuleSvc.GetRecommandTextByEmotion")) {
      return a(paramFromServiceMsg.getWupBuffer(), "CameraModuleSvc.GetRecommandTextByEmotion", new GetRecommandTextByEmotionRsp());
    }
    if (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("CameraModuleSvc.GetTextValidStatus")) {
      return a(paramFromServiceMsg.getWupBuffer(), "CameraModuleSvc.GetTextValidStatus", new GetTextValidStatusRsp());
    }
    if (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("CameraModuleSvc.GetCameraConfig")) {
      return a(paramFromServiceMsg.getWupBuffer(), "CameraModuleSvc.GetCameraConfig", new GetCameraConfigRsp());
    }
    if (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("CameraModuleSvc.GetOnlineUserNum")) {
      return a(paramFromServiceMsg.getWupBuffer(), "CameraModuleSvc.GetOnlineUserNum", new GetOnlineUserNumRsp());
    }
    if (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("CameraModuleSvc.GetFontData")) {
      return a(paramFromServiceMsg.getWupBuffer(), "CameraModuleSvc.GetFontData", new GetFontDataRsp());
    }
    if (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("CameraModuleSvc.GetImgValidStatus")) {
      return a(paramFromServiceMsg.getWupBuffer(), "CameraModuleSvc.GetImgValidStatus", new GetImgValidStatusRsp());
    }
    if (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("CameraModuleSvc.GetBulkImageClassify")) {
      return a(paramFromServiceMsg.getWupBuffer(), "CameraModuleSvc.GetBulkImageClassify", new GetBulkImageClassifyRsp());
    }
    return super.a(paramToServiceMsg, paramFromServiceMsg);
  }
  
  public boolean a(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    if (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("CameraModuleSvc.GetRecommandTextByEmotion")) {
      return g(paramToServiceMsg, paramUniPacket);
    }
    if (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("CameraModuleSvc.GetTextValidStatus")) {
      return h(paramToServiceMsg, paramUniPacket);
    }
    if (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("CameraModuleSvc.GetCameraConfig")) {
      return f(paramToServiceMsg, paramUniPacket);
    }
    if (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("CameraModuleSvc.GetOnlineUserNum")) {
      return e(paramToServiceMsg, paramUniPacket);
    }
    if (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("CameraModuleSvc.GetFontData")) {
      return b(paramToServiceMsg, paramUniPacket);
    }
    if (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("CameraModuleSvc.GetImgValidStatus")) {
      return c(paramToServiceMsg, paramUniPacket);
    }
    if (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("CameraModuleSvc.GetBulkImageClassify")) {
      return d(paramToServiceMsg, paramUniPacket);
    }
    return super.a(paramToServiceMsg, paramUniPacket);
  }
  
  public String[] a()
  {
    return jdField_a_of_type_ArrayOfJavaLangString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     boqh
 * JD-Core Version:    0.7.0.1
 */