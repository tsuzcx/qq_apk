package com.tencent.av.gaudio;

import android.content.Intent;
import android.os.Message;
import com.tencent.av.report.TraeConfigUpdate;
import com.tencent.av.utils.AudioDump;
import com.tencent.avcore.data.AVInviteAccount;
import com.tencent.avcore.data.MavInviteData;
import com.tencent.avcore.engine.mav.MavNativeEventParams;
import com.tencent.avcore.util.AVNativeEventProcessor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

class QQGAudioCtrl$NativeEventCallback
  implements AVNativeEventProcessor
{
  QQGAudioCtrl$NativeEventCallback(QQGAudioCtrl paramQQGAudioCtrl) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("QQGAudioCtrl", 2, "handleMessage-->Message is empty!");
      }
      return true;
    }
    if (this.a.mMavCallback == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("QQGAudioCtrl", 2, "handleMessage-->mVideoControl = null");
      }
      return true;
    }
    Object localObject = (MavNativeEventParams)paramMessage.obj;
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("QQGAudioCtrl", 2, "handleMessage-->NativeEventParams is null");
      }
      return true;
    }
    int i = paramMessage.what;
    paramMessage = ((MavNativeEventParams)localObject).detail;
    long l2 = ((MavNativeEventParams)localObject).info;
    long l1 = ((MavNativeEventParams)localObject).groupId;
    int j = ((MavNativeEventParams)localObject).multiAVType;
    int k = ((MavNativeEventParams)localObject).multiSubType;
    k = ((MavNativeEventParams)localObject).relationType;
    int m = ((MavNativeEventParams)localObject).bufferLen;
    int n = ((MavNativeEventParams)localObject).flag;
    switch (i)
    {
    default: 
      if (QLog.isColorLevel()) {
        QLog.e("QQGAudioCtrl", 2, "Wrong type of eventid=" + i);
      }
      break;
    }
    for (;;)
    {
      return true;
      this.a.processMicAuthAfterEnterRoom(((MavNativeEventParams)localObject).detail);
      if (AudioDump.a())
      {
        AudioDump.a().a(null, this.a);
        continue;
        this.a.processMicAuthAfterEnterRoom(((MavNativeEventParams)localObject).detail);
        if (AudioDump.a())
        {
          AudioDump.a().a(null, this.a);
          continue;
          i = (int)((MavNativeEventParams)localObject).info;
          BaseApplicationImpl.getContext().sendBroadcast(new Intent("com.tencent.av.ui.ConfigInfoTips.ACTION_IS_GETTED_SHARP_CONFIG_PAYLOAD").putExtra("version", i));
          TraeConfigUpdate.a().a("load", i);
          continue;
          if (l2 == 0L)
          {
            paramMessage = MavInviteData.getInviteDataFromBuffer(paramMessage, m);
            this.a.mMavCallback.onGAudioInviteResp(paramMessage);
            if (paramMessage == null) {}
            for (paramMessage = null; ((j == 10) || (j == 1)) && (paramMessage != null); paramMessage = paramMessage.inviteAccountList)
            {
              l2 = this.a.mMavCallback.a(k, j, l1);
              localObject = new ArrayList(paramMessage.size());
              long l3 = AudioHelper.a() / 1000L;
              paramMessage = paramMessage.iterator();
              while (paramMessage.hasNext()) {
                ((ArrayList)localObject).add(new Memberinfo(((AVInviteAccount)paramMessage.next()).account, l3));
              }
            }
            this.a.mMavCallback.a(l1, l2, (ArrayList)localObject);
            if (QLog.isColorLevel()) {
              QLog.i("QQGAudioCtrl", 2, "EM_SDK_EVENT_ID_PB_INVITE_RSP = MULTIAV_GROUP_AUDIO saveInviteMembers");
            }
          }
          else
          {
            if (paramMessage == null) {}
            for (paramMessage = "";; paramMessage = new String(paramMessage))
            {
              this.a.mMavCallback.a(l1, l2, paramMessage);
              break;
            }
            paramMessage = QQGAudioCtrl.getAVInfoListFromByte2(paramMessage, m);
            if (paramMessage != null)
            {
              this.a.mMavCallback.b(l1, paramMessage);
              continue;
              ReportController.b(null, "CliOper", "", "", "0X800A7A6", "0X800A7A6", 0, (int)l2, "", "", "", "");
              continue;
              ReportController.b(null, "CliOper", "", "", "0X800A7A7", "0X800A7A7", 0, (int)l2, "", "", "", "");
            }
          }
        }
      }
    }
  }
  
  public boolean isMsgNeedExtraDeal(int paramInt)
  {
    switch (paramInt)
    {
    case 31: 
    case 32: 
    default: 
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.gaudio.QQGAudioCtrl.NativeEventCallback
 * JD-Core Version:    0.7.0.1
 */