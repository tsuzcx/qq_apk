package com.tencent.aelight.camera.ae;

import com.tencent.aelight.camera.ae.camera.ui.watermark.WatermarkOnlineUserManager;
import com.tencent.aelight.camera.log.AEQLog;
import org.light.listener.WatermarkDelegate;

class AEPituCameraUnit$35
  implements WatermarkDelegate
{
  AEPituCameraUnit$35(AEPituCameraUnit paramAEPituCameraUnit) {}
  
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
      ((StringBuilder)localObject).append(WatermarkOnlineUserManager.a().b());
      AEQLog.a(paramString, ((StringBuilder)localObject).toString());
      return String.valueOf(WatermarkOnlineUserManager.a().b());
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.AEPituCameraUnit.35
 * JD-Core Version:    0.7.0.1
 */