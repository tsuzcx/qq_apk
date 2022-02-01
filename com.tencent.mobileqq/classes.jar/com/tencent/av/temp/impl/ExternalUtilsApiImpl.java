package com.tencent.av.temp.impl;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.av.VideoController;
import com.tencent.av.VideoServlet;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.opengl.effects.EffectsRenderController;
import com.tencent.av.perfstat.MemoryPerfStat;
import com.tencent.av.recog.AVVoiceRecog;
import com.tencent.av.service.QQServiceForAV;
import com.tencent.av.temp.IExternalUtilsApi;
import com.tencent.common.app.business.BaseVideoAppInterface;
import com.tencent.device.utils.SmartDeviceReport;
import com.tencent.mobileqq.app.hiddenchat.HiddenChatUtil;
import com.tencent.mobileqq.portal.PortalUtils;
import com.tencent.mobileqq.utils.BusinessCommonConfig;
import com.tencent.qphone.base.util.BaseApplication;
import mqq.app.Servlet;

public class ExternalUtilsApiImpl
  implements IExternalUtilsApi
{
  public void checkMemPerf(int paramInt1, int paramInt2)
  {
    MemoryPerfStat.a(paramInt1, paramInt2);
  }
  
  public void checkVoiceRecog(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean2) && (paramBoolean1))
    {
      AVVoiceRecog.a().b(1);
      return;
    }
    AVVoiceRecog.a().a(1);
  }
  
  public void deviceExitVideoProcess(BaseVideoAppInterface paramBaseVideoAppInterface, Bundle paramBundle)
  {
    int i = paramBundle.getInt("deviceoprstcode");
    paramBundle = Long.valueOf(paramBundle.getLong("deviceopdin", 0L));
    if ((i == 0) && (paramBundle.longValue() != 0L))
    {
      paramBaseVideoAppInterface = (VideoAppInterface)paramBaseVideoAppInterface;
      if ((paramBaseVideoAppInterface != null) && (paramBaseVideoAppInterface.a() != null) && (paramBaseVideoAppInterface.a().a() != null) && (paramBaseVideoAppInterface.a().a().c != null) && (paramBaseVideoAppInterface.a().a().c.equals(String.valueOf(paramBundle)))) {
        paramBaseVideoAppInterface.b(1000);
      }
    }
  }
  
  public String getBroadcastPermission()
  {
    return "com.tencent.smartdevice.permission.broadcast";
  }
  
  public String getDeviceUnBindRst()
  {
    return "SmartDevice_DeviceUnBindRst";
  }
  
  public int getEffectSettingQavNone()
  {
    return -1;
  }
  
  public String getFileMD5String(String paramString)
  {
    return PortalUtils.a(paramString);
  }
  
  public Class<?> getQQServiceForAVClass()
  {
    return QQServiceForAV.class;
  }
  
  public String getSmartDeviceReceiveSharpAckMsg()
  {
    return "SmartDevice_ReceiveSharpAckMsg";
  }
  
  public String getSmartDeviceReceiveSharpMsg()
  {
    return "SmartDevice_ReceiveSharpMsg";
  }
  
  public String getSmartDeviceSendSharpMsg()
  {
    return "SmartDevice_SendSharpMsg";
  }
  
  public Class<? extends Servlet> getVideoServletClass()
  {
    return VideoServlet.class;
  }
  
  public int getVoiceTypeNone()
  {
    return 0;
  }
  
  public boolean isEnableAEModuleManager()
  {
    return EffectsRenderController.b();
  }
  
  public boolean isShowVideoMsg(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    return HiddenChatUtil.a(paramContext, paramString1, paramString2, paramInt);
  }
  
  public void notifyQQDownload(String paramString)
  {
    BusinessCommonConfig.notifyQQDownload(3, paramString, 0);
  }
  
  public void sendBroadcastToSmartDevice(byte[] paramArrayOfByte)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("NotifyDataLength", paramArrayOfByte.length);
    localBundle.putByteArray("NotifyDataValue", paramArrayOfByte);
    paramArrayOfByte = new Intent();
    paramArrayOfByte.putExtra("NotifyData", localBundle);
    paramArrayOfByte.setAction("SmartDevice_AudioData");
    BaseApplication.getContext().sendBroadcast(paramArrayOfByte, "com.tencent.smartdevice.permission.broadcast");
  }
  
  public void smartDeviceReportAccept()
  {
    SmartDeviceReport.a(null, "Usr_TV_Video", 4, 0, 0);
  }
  
  public void smartDeviceReportReceive()
  {
    SmartDeviceReport.a(null, "Usr_TV_Video", 2, 0, 0);
  }
  
  public void tryLoadPtuSo()
  {
    EffectsRenderController.f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.temp.impl.ExternalUtilsApiImpl
 * JD-Core Version:    0.7.0.1
 */