import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sharp.jni.TraeAudioManager;

public abstract class bhqq
{
  bhqq(TraeAudioManager paramTraeAudioManager) {}
  
  public abstract String a();
  
  String a(int paramInt)
  {
    String str;
    switch (paramInt)
    {
    default: 
      str = "unknow";
    }
    for (;;)
    {
      return str + ":" + paramInt;
      str = "STATE_OFF";
      continue;
      str = "STATE_TURNING_ON";
      continue;
      str = "STATE_ON";
      continue;
      str = "STATE_TURNING_OFF";
    }
  }
  
  public abstract void a();
  
  abstract void a(Context paramContext, Intent paramIntent);
  
  public void a(Context paramContext, Intent paramIntent, bhqr parambhqr)
  {
    if ("android.bluetooth.adapter.action.STATE_CHANGED".equals(paramIntent.getAction()))
    {
      int i = paramIntent.getIntExtra("android.bluetooth.adapter.extra.STATE", -1);
      int j = paramIntent.getIntExtra("android.bluetooth.adapter.extra.PREVIOUS_STATE", -1);
      if (QLog.isColorLevel()) {
        QLog.w("TraeAudioManager", 2, "BT ACTION_STATE_CHANGED|   EXTRA_STATE " + a(i));
      }
      if (QLog.isColorLevel()) {
        QLog.w("TraeAudioManager", 2, "BT ACTION_STATE_CHANGED|   EXTRA_PREVIOUS_STATE " + a(j));
      }
      if (i == 10)
      {
        if (QLog.isColorLevel()) {
          QLog.w("TraeAudioManager", 2, "    BT off");
        }
        parambhqr.a("DEVICE_BLUETOOTHHEADSET", false);
      }
      while ((i != 12) || (!QLog.isColorLevel())) {
        return;
      }
      QLog.w("TraeAudioManager", 2, "BT OFF-->ON,Visiable it...");
      return;
    }
    a(paramContext, paramIntent);
  }
  
  abstract void a(IntentFilter paramIntentFilter);
  
  public abstract boolean a();
  
  public abstract boolean a(Context paramContext, bhqr parambhqr);
  
  String b(int paramInt)
  {
    String str;
    switch (paramInt)
    {
    default: 
      str = "unknow";
    }
    for (;;)
    {
      return str + ":" + paramInt;
      str = "SCO_AUDIO_STATE_DISCONNECTED";
      continue;
      str = "SCO_AUDIO_STATE_CONNECTED";
      continue;
      str = "SCO_AUDIO_STATE_CONNECTING";
      continue;
      str = "SCO_AUDIO_STATE_ERROR";
    }
  }
  
  public void b(IntentFilter paramIntentFilter)
  {
    paramIntentFilter.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
    paramIntentFilter.addAction("android.bluetooth.device.action.ACL_CONNECTED");
    paramIntentFilter.addAction("android.bluetooth.device.action.ACL_DISCONNECTED");
    a(paramIntentFilter);
  }
  
  String c(int paramInt)
  {
    String str;
    switch (paramInt)
    {
    default: 
      str = "unknow";
    }
    for (;;)
    {
      return str + ":" + paramInt;
      str = "STATE_DISCONNECTED";
      continue;
      str = "STATE_CONNECTING";
      continue;
      str = "STATE_CONNECTED";
      continue;
      str = "STATE_DISCONNECTING";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhqq
 * JD-Core Version:    0.7.0.1
 */