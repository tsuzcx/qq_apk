package com.tencent.TMG.audio;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import com.tencent.TMG.utils.QLog;
import java.util.HashMap;

class TraeAudioManager$TraeAudioManagerLooper$2
  extends Handler
{
  TraeAudioManager$TraeAudioManagerLooper$2(TraeAudioManager.TraeAudioManagerLooper paramTraeAudioManagerLooper) {}
  
  public void handleMessage(Message paramMessage)
  {
    Object localObject;
    label98:
    do
    {
      do
      {
        try
        {
          HashMap localHashMap = (HashMap)paramMessage.obj;
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder().append("TraeAudioManagerLooper msg:").append(paramMessage.what).append(" _enabled:");
            if (this.this$1._enabled)
            {
              str = "Y";
              QLog.w("TRAE", 0, str);
            }
          }
          else
          {
            if (paramMessage.what != 32772) {
              break label98;
            }
            this.this$1.startService(localHashMap);
            return;
          }
        }
        catch (Exception localException)
        {
          do
          {
            for (;;)
            {
              localObject = null;
              continue;
              String str = "N";
            }
            if (!this.this$1._enabled)
            {
              if (QLog.isColorLevel()) {
                QLog.w("TRAE", 0, "******* disabled ,skip msg******");
              }
              paramMessage = new Intent();
              this.this$1.this$0.sendResBroadcast(paramMessage, (HashMap)localObject, 1);
              return;
            }
            switch (paramMessage.what)
            {
            default: 
              return;
            case 32773: 
              this.this$1.stopService();
              return;
            case 32774: 
              this.this$1.InternalSessionGetDeviceList((HashMap)localObject);
              return;
            case 32777: 
              this.this$1.this$0.InternalSessionIsDeviceChangabled((HashMap)localObject);
              return;
            case 32778: 
              this.this$1.this$0.InternalSessionGetConnectedDevice((HashMap)localObject);
              return;
            case 32779: 
              this.this$1.this$0.InternalSessionGetConnectingDevice((HashMap)localObject);
              return;
            case 32780: 
              this.this$1.InternalVoicecallPreprocess((HashMap)localObject);
              return;
            case 32781: 
              this.this$1.InternalVoicecallPostprocess((HashMap)localObject);
              return;
            case 32788: 
              paramMessage = (Integer)((HashMap)localObject).get("PARAM_STREAMTYPE");
              if (paramMessage != null) {
                break label347;
              }
            }
          } while (!QLog.isColorLevel());
          QLog.e("TRAE", 0, " MESSAGE_VOICECALL_AUIDOPARAM_CHANGED params.get(PARAM_STREAMTYPE)==null!!");
          return;
          this.this$1.this$0._streamType = paramMessage.intValue();
          this.this$1.InternalNotifyStreamTypeUpdate(paramMessage.intValue());
          return;
          this.this$1.InternalStartRing((HashMap)localObject);
          return;
          this.this$1.InternalStopRing((HashMap)localObject);
          return;
          this.this$1.abandonAudioFocus();
          return;
          this.this$1.requestAudioFocus(this.this$1.this$0._streamType);
          return;
          this.this$1.InternalGetStreamType((HashMap)localObject);
          return;
          this.this$1.this$0.InternalSessionConnectDevice((HashMap)localObject);
          return;
          this.this$1.this$0.InternalSessionEarAction((HashMap)localObject);
          return;
          paramMessage = this.this$1.this$0._deviceConfigManager.getAvailabledHighestPriorityDevice();
          localObject = this.this$1.this$0._deviceConfigManager.getConnectedDevice();
          if (QLog.isColorLevel()) {
            QLog.w("TRAE", 0, "MESSAGE_AUTO_DEVICELIST_UPDATE  connectedDev:" + (String)localObject + " highestDev" + paramMessage);
          }
          if (TraeAudioManager.IsUpdateSceneFlag)
          {
            if ((TraeAudioManager.IsMusicScene) && (!this.this$1.this$0.IsBluetoothA2dpExisted))
            {
              this.this$1.this$0.InternalConnectDevice(this.this$1.this$0._deviceConfigManager.getAvailabledHighestPriorityDevice("DEVICE_BLUETOOTHHEADSET"), null, true);
              return;
            }
            this.this$1.this$0.InternalConnectDevice(paramMessage, null, true);
            return;
          }
        }
        if (!paramMessage.equals(localObject))
        {
          this.this$1.this$0.InternalConnectDevice(paramMessage, null, false);
          return;
        }
        this.this$1.this$0.InternalNotifyDeviceListUpdate();
        return;
        paramMessage = (String)((HashMap)localObject).get("PARAM_DEVICE");
      } while (this.this$1.this$0.InternalConnectDevice(paramMessage, null, false) == 0);
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 0, " plugin dev:" + paramMessage + " sessionConnectedDev:" + this.this$1.this$0.sessionConnectedDev + " connected fail,auto switch!");
      }
      this.this$1.this$0.InternalConnectDevice(this.this$1.this$0._deviceConfigManager.getAvailabledHighestPriorityDevice(), null, false);
      return;
    } while (this.this$1.this$0.InternalConnectDevice(this.this$1.this$0.sessionConnectedDev, null, false) == 0);
    label347:
    paramMessage = (String)((HashMap)localObject).get("PARAM_DEVICE");
    if (QLog.isColorLevel()) {
      QLog.w("TRAE", 0, " plugout dev:" + paramMessage + " sessionConnectedDev:" + this.this$1.this$0.sessionConnectedDev + " connected fail,auto switch!");
    }
    this.this$1.this$0.InternalConnectDevice(this.this$1.this$0._deviceConfigManager.getAvailabledHighestPriorityDevice(), null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.TMG.audio.TraeAudioManager.TraeAudioManagerLooper.2
 * JD-Core Version:    0.7.0.1
 */