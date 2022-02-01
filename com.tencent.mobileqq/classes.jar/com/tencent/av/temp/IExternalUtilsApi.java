package com.tencent.av.temp;

import android.content.Context;
import android.os.Bundle;
import com.tencent.common.app.business.BaseVideoAppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import mqq.app.Servlet;

@QAPI(process={"all"})
public abstract interface IExternalUtilsApi
  extends QRouteApi
{
  public abstract void checkMemPerf(int paramInt1, int paramInt2);
  
  public abstract void checkVoiceRecog(boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract void deviceExitVideoProcess(BaseVideoAppInterface paramBaseVideoAppInterface, Bundle paramBundle);
  
  public abstract String getBroadcastPermission();
  
  public abstract String getDeviceUnBindRst();
  
  public abstract int getEffectSettingQavNone();
  
  public abstract String getFileMD5String(String paramString);
  
  public abstract Class<?> getQQServiceForAVClass();
  
  public abstract String getSmartDeviceReceiveSharpAckMsg();
  
  public abstract String getSmartDeviceReceiveSharpMsg();
  
  public abstract String getSmartDeviceSendSharpMsg();
  
  public abstract Class<? extends Servlet> getVideoServletClass();
  
  public abstract int getVoiceTypeNone();
  
  public abstract boolean isEnableAEModuleManager();
  
  public abstract boolean isShowVideoMsg(Context paramContext, String paramString1, String paramString2, int paramInt);
  
  public abstract void notifyQQDownload(String paramString);
  
  public abstract void sendBroadcastToSmartDevice(byte[] paramArrayOfByte);
  
  public abstract void smartDeviceReportAccept();
  
  public abstract void smartDeviceReportReceive();
  
  public abstract void tryLoadPtuSo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.temp.IExternalUtilsApi
 * JD-Core Version:    0.7.0.1
 */