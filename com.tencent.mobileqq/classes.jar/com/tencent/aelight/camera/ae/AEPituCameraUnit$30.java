package com.tencent.aelight.camera.ae;

import com.tencent.aelight.camera.ae.camera.ui.watermark.WatermarkOnlineUserManager;
import com.tencent.aelight.camera.log.AEQLog;
import org.light.listener.WatermarkDelegate;

class AEPituCameraUnit$30
  implements WatermarkDelegate
{
  AEPituCameraUnit$30(AEPituCameraUnit paramAEPituCameraUnit) {}
  
  public String getData(String paramString)
  {
    Object localObject = this.a.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("watermark回调: getData:");
    localStringBuilder.append(paramString);
    AEQLog.a((String)localObject, localStringBuilder.toString());
    if (paramString.equalsIgnoreCase("watermark.qq.online"))
    {
      paramString = this.a.a;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("watermark回调: getData,获取在线人数:");
      ((StringBuilder)localObject).append(WatermarkOnlineUserManager.a().a());
      AEQLog.a(paramString, ((StringBuilder)localObject).toString());
      return String.valueOf(WatermarkOnlineUserManager.a().a());
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.AEPituCameraUnit.30
 * JD-Core Version:    0.7.0.1
 */