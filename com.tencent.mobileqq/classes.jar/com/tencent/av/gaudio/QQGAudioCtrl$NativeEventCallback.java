package com.tencent.av.gaudio;

import android.content.Intent;
import android.os.Message;
import com.tencent.av.report.TraeConfigUpdate;
import com.tencent.av.utils.AudioDump;
import com.tencent.av.utils.AudioHelper;
import com.tencent.avcore.data.AVInviteAccount;
import com.tencent.avcore.data.MavInviteData;
import com.tencent.avcore.engine.mav.MavNativeEventParams;
import com.tencent.avcore.util.AVNativeEventProcessor;
import com.tencent.mobileqq.statistics.ReportController;
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
      QLog.e("QQGAudioCtrl", 1, "handleMessage-->Message is empty!");
      return true;
    }
    if (this.a.mMavCallback == null)
    {
      QLog.e("QQGAudioCtrl", 1, "handleMessage-->mVideoControl = null");
      return true;
    }
    Object localObject = (MavNativeEventParams)paramMessage.obj;
    if (localObject == null)
    {
      QLog.e("QQGAudioCtrl", 1, "handleMessage-->NativeEventParams is null");
      return true;
    }
    int i = paramMessage.what;
    byte[] arrayOfByte = ((MavNativeEventParams)localObject).detail;
    long l2 = ((MavNativeEventParams)localObject).info;
    long l1 = ((MavNativeEventParams)localObject).groupId;
    int j = ((MavNativeEventParams)localObject).multiAVType;
    int k = ((MavNativeEventParams)localObject).multiSubType;
    k = ((MavNativeEventParams)localObject).relationType;
    int m = ((MavNativeEventParams)localObject).bufferLen;
    int n = ((MavNativeEventParams)localObject).flag;
    paramMessage = null;
    if (i != 20)
    {
      if (i != 30)
      {
        if (i != 33)
        {
          if (i != 80)
          {
            if (i != 123)
            {
              if (i != 174)
              {
                if (i != 175)
                {
                  if (QLog.isColorLevel())
                  {
                    paramMessage = new StringBuilder();
                    paramMessage.append("Wrong type of eventid=");
                    paramMessage.append(i);
                    QLog.e("QQGAudioCtrl", 2, paramMessage.toString());
                    return true;
                  }
                }
                else
                {
                  ReportController.b(null, "CliOper", "", "", "0X800A7A7", "0X800A7A7", 0, (int)l2, "", "", "", "");
                  return true;
                }
              }
              else
              {
                ReportController.b(null, "CliOper", "", "", "0X800A7A6", "0X800A7A6", 0, (int)l2, "", "", "", "");
                return true;
              }
            }
            else
            {
              i = (int)((MavNativeEventParams)localObject).info;
              BaseApplication.getContext().sendBroadcast(new Intent("com.tencent.av.ui.ConfigTipsConstant.ACTION_IS_GETTED_SHARP_CONFIG_PAYLOAD").putExtra("version", i));
              TraeConfigUpdate.a().a("load", i);
              return true;
            }
          }
          else
          {
            paramMessage = QQGAudioCtrl.getAVInfoListFromByte2(arrayOfByte, m);
            if (paramMessage != null)
            {
              this.a.mMavCallback.b(l1, paramMessage);
              return true;
            }
          }
        }
        else
        {
          this.a.processMicAuthAfterEnterRoom(((MavNativeEventParams)localObject).detail);
          if (AudioDump.a())
          {
            AudioDump.a().a(null, this.a);
            return true;
          }
        }
      }
      else
      {
        this.a.processMicAuthAfterEnterRoom(((MavNativeEventParams)localObject).detail);
        if (AudioDump.a())
        {
          AudioDump.a().a(null, this.a);
          return true;
        }
      }
    }
    else if (l2 == 0L)
    {
      localObject = MavInviteData.getInviteDataFromBuffer(arrayOfByte, m);
      this.a.mMavCallback.onGAudioInviteResp((MavInviteData)localObject);
      if (localObject != null) {
        paramMessage = ((MavInviteData)localObject).inviteAccountList;
      }
      if (((j == 10) || (j == 1)) && (paramMessage != null))
      {
        l2 = this.a.mMavCallback.a(k, j, l1);
        localObject = new ArrayList(paramMessage.size());
        long l3 = AudioHelper.a() / 1000L;
        paramMessage = paramMessage.iterator();
        while (paramMessage.hasNext()) {
          ((ArrayList)localObject).add(new Memberinfo(((AVInviteAccount)paramMessage.next()).account, l3));
        }
        this.a.mMavCallback.a(l1, l2, (ArrayList)localObject);
        if (QLog.isColorLevel())
        {
          QLog.i("QQGAudioCtrl", 2, "EM_SDK_EVENT_ID_PB_INVITE_RSP = MULTIAV_GROUP_AUDIO saveInviteMembers");
          return true;
        }
      }
    }
    else
    {
      if (arrayOfByte == null) {
        paramMessage = "";
      } else {
        paramMessage = new String(arrayOfByte);
      }
      this.a.mMavCallback.a(l1, l2, paramMessage);
    }
    return true;
  }
  
  public boolean isMsgNeedExtraDeal(int paramInt)
  {
    return (paramInt == 30) || (paramInt == 33);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.gaudio.QQGAudioCtrl.NativeEventCallback
 * JD-Core Version:    0.7.0.1
 */