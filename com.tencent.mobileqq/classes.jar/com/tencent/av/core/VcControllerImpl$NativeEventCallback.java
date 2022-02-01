package com.tencent.av.core;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Message;
import com.tencent.av.AVLog;
import com.tencent.av.business.manager.report.VideoBeaconReporter;
import com.tencent.av.report.AVReport;
import com.tencent.av.report.TraeConfigUpdate;
import com.tencent.av.utils.AudioDump;
import com.tencent.av.utils.CharacterUtil;
import com.tencent.avcore.engine.dav.DavNativeEventParams;
import com.tencent.avcore.util.AVNativeEventProcessor;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;

@SuppressLint({"HandlerLeak"})
class VcControllerImpl$NativeEventCallback
  implements AVNativeEventProcessor
{
  VcControllerImpl$NativeEventCallback(VcControllerImpl paramVcControllerImpl) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    for (;;)
    {
      try
      {
        int i = paramMessage.what;
        DavNativeEventParams localDavNativeEventParams = (DavNativeEventParams)paramMessage.obj;
        if (localDavNativeEventParams == null)
        {
          AVLog.printErrorLog("VcControllerImpl_NativeEventHandler", "p is null");
          return true;
        }
        paramMessage = localDavNativeEventParams.detail;
        long l1 = localDavNativeEventParams.info;
        String str = CharacterUtil.a(localDavNativeEventParams.fromUin);
        if (i != 4) {
          if (i != 6) {
            if (i != 16) {
              if (i != 64) {
                if (i != 93) {
                  if (i != 96) {
                    if (i == 111) {}
                  }
                }
              }
            }
          }
        }
        switch (i)
        {
        case 122: 
          ReportController.b(null, "CliOper", "", "", "0X800A7A5", "0X800A7A5", 0, (int)localDavNativeEventParams.extraParam0, "", "", "", "");
          break;
        case 121: 
          ReportController.b(null, "CliOper", "", "", "0X800A7A4", "0X800A7A4", 0, (int)localDavNativeEventParams.extraParam0, "", "", "", "");
          break;
        case 120: 
          if (localDavNativeEventParams.extraParam0 != 1L) {
            break label492;
          }
          bool = true;
          i = (int)localDavNativeEventParams.extraParam1;
          try
          {
            paramMessage = new String(localDavNativeEventParams.detail, "utf-8");
          }
          catch (UnsupportedEncodingException paramMessage)
          {
            paramMessage.printStackTrace();
            paramMessage = "";
          }
          int j = localDavNativeEventParams.extraParam3;
          this.a.mEventListener.a(bool, i, paramMessage, j);
          continue;
          VcControllerImpl.access$300(this.a, l1, paramMessage, str);
          continue;
          this.a.onAudioData(paramMessage);
          continue;
          i = (int)localDavNativeEventParams.info;
          if (QLog.isColorLevel())
          {
            paramMessage = new StringBuilder();
            paramMessage.append("SharpConfigPayload. version = ");
            paramMessage.append(i);
            QLog.d("NativeEventHandler", 2, paramMessage.toString());
          }
          BaseApplication.getContext().sendBroadcast(new Intent("com.tencent.av.ui.ConfigTipsConstant.ACTION_IS_GETTED_SHARP_CONFIG_PAYLOAD").putExtra("version", i));
          TraeConfigUpdate.a().a("load", i);
          continue;
          if (AVReport.a().d)
          {
            AVReport.a().o = localDavNativeEventParams.elapsedRealtime;
          }
          else
          {
            AVReport.a().D = localDavNativeEventParams.elapsedRealtime;
            continue;
            long l2 = localDavNativeEventParams.extraParam0;
            long l3 = localDavNativeEventParams.extraParam1;
            this.a.mEventListener.a(l2, l3, l1);
            continue;
            if (AudioDump.c())
            {
              AudioDump.a().a(this.a, null);
              continue;
              VideoBeaconReporter.a((int)l1, localDavNativeEventParams.extraParam0, localDavNativeEventParams.extraParam1, localDavNativeEventParams.extraParam2);
            }
          }
          return true;
        }
      }
      finally {}
      continue;
      label492:
      boolean bool = false;
    }
  }
  
  public boolean isMsgNeedExtraDeal(int paramInt)
  {
    return (paramInt == 4) || (paramInt == 6) || (paramInt == 16) || (paramInt == 64) || (paramInt == 120);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.core.VcControllerImpl.NativeEventCallback
 * JD-Core Version:    0.7.0.1
 */