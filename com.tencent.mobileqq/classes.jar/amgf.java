import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sharp.jni.TraeAudioManager;
import com.tencent.sharp.jni.TraeAudioManager.DeviceConfigManager;
import java.util.HashMap;

class amgf
  extends Handler
{
  amgf(amgd paramamgd) {}
  
  public void handleMessage(Message paramMessage)
  {
    label98:
    do
    {
      try
      {
        HashMap localHashMap = (HashMap)paramMessage.obj;
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder().append("TraeAudioManagerLooper msg:").append(paramMessage.what).append(" _enabled:");
          if (this.a.a)
          {
            str = "Y";
            QLog.w("TRAE", 2, str);
          }
        }
        else
        {
          if (paramMessage.what != 32772) {
            break label98;
          }
          this.a.a(localHashMap);
          return;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localObject = null;
          continue;
          str = "N";
        }
        if (!this.a.a)
        {
          if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "******* disabled ,skip msg******");
          }
          paramMessage = new Intent();
          this.a.b.a(paramMessage, (HashMap)localObject, 1);
          return;
        }
        switch (paramMessage.what)
        {
        default: 
          return;
        }
      }
      this.a.b();
      return;
      this.a.a((HashMap)localObject);
      return;
      this.a.b.c((HashMap)localObject);
      return;
      this.a.b.d((HashMap)localObject);
      return;
      this.a.b.e((HashMap)localObject);
      return;
      this.a.b((HashMap)localObject);
      return;
      this.a.c((HashMap)localObject);
      return;
      paramMessage = (Integer)((HashMap)localObject).get("PARAM_STREAMTYPE");
      if (paramMessage != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("TRAE", 2, " MESSAGE_VOICECALL_AUIDOPARAM_CHANGED params.get(PARAM_STREAMTYPE)==null!!");
    return;
    this.a.b.c = paramMessage.intValue();
    this.a.a(paramMessage.intValue());
    return;
    this.a.d((HashMap)localObject);
    return;
    this.a.e((HashMap)localObject);
    return;
    this.a.g();
    return;
    this.a.a(this.a.b.c);
    return;
    this.a.f((HashMap)localObject);
    return;
    this.a.b.a();
    return;
    this.a.b.a((HashMap)localObject);
    return;
    this.a.b.b((HashMap)localObject);
    return;
    paramMessage = this.a.b.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$DeviceConfigManager.b();
    String str = this.a.b.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$DeviceConfigManager.d();
    Object localObject = (String)((HashMap)localObject).get("EXTRA_DATA_CONNECTDEVICENAMEWHENSERVICEON");
    if (QLog.isColorLevel()) {
      QLog.w("TraeAudioManager", 2, "MESSAGE_AUTO_DEVICELIST_UPDATE connectedDev = " + str + ", highestDev = " + paramMessage + ", connectDeviceNameWhenServiceOn = " + (String)localObject);
    }
    if ((localObject != null) && (this.a.b.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$DeviceConfigManager.b((String)localObject))) {
      paramMessage = (Message)localObject;
    }
    for (;;)
    {
      if (!paramMessage.equals(str))
      {
        this.a.b.a(paramMessage, null);
        return;
      }
      this.a.b.a();
      return;
      paramMessage = (String)((HashMap)localObject).get("PARAM_DEVICE");
      if (this.a.b.a(paramMessage, null) == 0) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 2, " plugin dev:" + paramMessage + " sessionConnectedDev:" + this.a.b.b + " connected fail,auto switch!");
      }
      this.a.b.a(this.a.b.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$DeviceConfigManager.b(), null);
      return;
      if (this.a.b.a(this.a.b.b, null) == 0) {
        break;
      }
      paramMessage = (String)((HashMap)localObject).get("PARAM_DEVICE");
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 2, " plugout dev:" + paramMessage + " sessionConnectedDev:" + this.a.b.b + " connected fail,auto switch!");
      }
      this.a.b.a(this.a.b.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$DeviceConfigManager.b(), null);
      return;
      paramMessage = (String)((HashMap)localObject).get("PARAM_DEVICE");
      if (this.a.b.jdField_a_of_type_JavaLangString.equals("DEVICE_BLUETOOTHHEADSET"))
      {
        if (QLog.isColorLevel()) {
          QLog.w("TRAE", 2, " plugout dev:" + paramMessage + " BTDisConnectSessionConnectedDev:" + this.a.b.jdField_a_of_type_JavaLangString + " MESSAGE_BLUETOOTH_SCO_DISCONNECTED");
        }
        this.a.b.a(this.a.b.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$DeviceConfigManager.a("DEVICE_BLUETOOTHHEADSET"), null);
        return;
      }
      if (this.a.b.a(this.a.b.jdField_a_of_type_JavaLangString, null) == 0) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 2, " plugout dev:" + paramMessage + " BTDisConnectSessionConnectedDev:" + this.a.b.jdField_a_of_type_JavaLangString + " connected fail,auto switch!");
      }
      this.a.b.a(this.a.b.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$DeviceConfigManager.a("DEVICE_BLUETOOTHHEADSET"), null);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     amgf
 * JD-Core Version:    0.7.0.1
 */