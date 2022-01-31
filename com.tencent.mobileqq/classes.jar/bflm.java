import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothProfile;
import android.bluetooth.BluetoothProfile.ServiceListener;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sharp.jni.AudioDeviceInterface;
import com.tencent.sharp.jni.TraeAudioManager;
import com.tencent.sharp.jni.TraeAudioManager.BluetoohHeadsetCheck.1;
import java.util.List;

public class bflm
  extends bflp
  implements BluetoothProfile.ServiceListener
{
  BluetoothAdapter jdField_a_of_type_AndroidBluetoothBluetoothAdapter = null;
  public BluetoothProfile a;
  Context jdField_a_of_type_AndroidContentContext = null;
  public bflq a;
  final String jdField_a_of_type_JavaLangString = "BluetoohHeadsetCheck";
  
  public bflm(TraeAudioManager paramTraeAudioManager)
  {
    super(paramTraeAudioManager);
    this.jdField_a_of_type_Bflq = null;
    this.jdField_a_of_type_AndroidBluetoothBluetoothProfile = null;
  }
  
  public String a()
  {
    return "BluetoohHeadsetCheck";
  }
  
  public void a()
  {
    AudioDeviceInterface.LogTraceEntry("_profile:" + this.jdField_a_of_type_AndroidBluetoothBluetoothProfile);
    try
    {
      if (this.jdField_a_of_type_AndroidBluetoothBluetoothAdapter != null)
      {
        if (this.jdField_a_of_type_AndroidBluetoothBluetoothProfile != null) {
          this.jdField_a_of_type_AndroidBluetoothBluetoothAdapter.closeProfileProxy(1, this.jdField_a_of_type_AndroidBluetoothBluetoothProfile);
        }
        this.jdField_a_of_type_AndroidBluetoothBluetoothProfile = null;
      }
      AudioDeviceInterface.LogTraceExit();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.w("BluetoohHeadsetCheck", 2, " closeProfileProxy:e:" + localException.getMessage());
        }
      }
    }
  }
  
  void a(Context paramContext, Intent paramIntent)
  {
    long l = mtj.a(paramIntent);
    int i;
    if ("android.bluetooth.headset.profile.action.AUDIO_STATE_CHANGED".equals(paramIntent.getAction()))
    {
      i = paramIntent.getIntExtra("android.bluetooth.profile.extra.STATE", 10);
      if (QLog.isColorLevel()) {
        QLog.w("BluetoohHeadsetCheck", 1, "_onReceive.ACTION_AUDIO_STATE_CHANGED, state[" + i + "], bluetoothState[" + TraeAudioManager.a(this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager) + "], seq[" + l + "]");
      }
      if (i == 12) {
        if (TraeAudioManager.a(this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager) == 6) {
          QLog.w("TRAE", 2, "bluetoothHeadsetSwitchThread ACTION_AUDIO_STATE_CHANGED +++ Bluetooth audio SCO is now connected, SCO_CONNECTED");
        }
      }
    }
    label124:
    int j;
    label460:
    do
    {
      do
      {
        do
        {
          do
          {
            TraeAudioManager.a(this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager, 7);
            break label124;
            break label124;
            do
            {
              do
              {
                return;
              } while ((i == 11) || (i != 10));
              QLog.w("TRAE", 2, "ACTION_AUDIO_STATE_CHANGED +++ Bluetooth audio SCO is STATE_AUDIO_DISCONNECTED");
              return;
              if (!"android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED".equals(paramIntent.getAction())) {
                break;
              }
              switch (paramIntent.getIntExtra("android.bluetooth.profile.extra.STATE", -1))
              {
              case 1: 
              default: 
                return;
              case 0: 
                TraeAudioManager.a(this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager, 3);
                this.jdField_a_of_type_Bflq.a("DEVICE_BLUETOOTHHEADSET", false);
              }
            } while (!QLog.isColorLevel());
            QLog.w("TRAE", 2, "jeringtest BluetoothHeadset ACTION_CONNECTION_STATE_CHANGED BluetoothProfile.STATE_DISCONNECTED");
            return;
            TraeAudioManager.a(this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager, 4);
            this.jdField_a_of_type_Bflq.a("DEVICE_BLUETOOTHHEADSET", true);
          } while (!QLog.isColorLevel());
          QLog.w("TRAE", 2, "jeringtest  BluetoothHeadset ACTION_CONNECTION_STATE_CHANGED BluetoothProfile.STATE_CONNECTED");
          return;
          if (!"android.bluetooth.adapter.action.CONNECTION_STATE_CHANGED".equals(paramIntent.getAction())) {
            break;
          }
          i = paramIntent.getIntExtra("android.bluetooth.adapter.extra.CONNECTION_STATE", -1);
          j = paramIntent.getIntExtra("android.bluetooth.adapter.extra.PREVIOUS_CONNECTION_STATE", -1);
          paramIntent = (BluetoothDevice)paramIntent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
          if (QLog.isColorLevel()) {
            QLog.w("BluetoohHeadsetCheck", 2, "BT ACTION_CONNECTION_STATE_CHANGED|   EXTRA_CONNECTION_STATE " + c(i));
          }
          if (QLog.isColorLevel()) {
            QLog.w("BluetoohHeadsetCheck", 2, "    EXTRA_PREVIOUS_CONNECTION_STATE " + c(j));
          }
          Object localObject;
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder().append("    EXTRA_DEVICE ").append(paramIntent).append(" ");
            if (paramIntent != null)
            {
              paramContext = paramIntent.getName();
              QLog.w("BluetoohHeadsetCheck", 2, paramContext);
            }
          }
          else
          {
            if (i != 2) {
              continue;
            }
            if (QLog.isColorLevel())
            {
              localObject = new StringBuilder().append("   dev:");
              if (paramIntent == null) {
                break label519;
              }
              paramContext = paramIntent.getName();
              QLog.w("BluetoohHeadsetCheck", 2, paramContext + " connected,start sco...");
            }
            this.jdField_a_of_type_Bflq.a("DEVICE_BLUETOOTHHEADSET", true);
            localObject = this.jdField_a_of_type_Bflq;
            if (paramIntent == null) {
              break label525;
            }
          }
          for (paramContext = paramIntent.getName();; paramContext = "unkown")
          {
            ((bflq)localObject).a(paramContext);
            return;
            paramContext = " ";
            break;
            paramContext = "null";
            break label460;
          }
        } while (i != 0);
        this.jdField_a_of_type_Bflq.a("DEVICE_BLUETOOTHHEADSET", false);
        return;
      } while (!"android.media.ACTION_SCO_AUDIO_STATE_UPDATED".equals(paramIntent.getAction()));
      i = paramIntent.getIntExtra("android.media.extra.SCO_AUDIO_STATE", -1);
      j = paramIntent.getIntExtra("android.media.extra.SCO_AUDIO_PREVIOUS_STATE", -1);
      paramContext = (BluetoothDevice)paramIntent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
      if (QLog.isColorLevel()) {
        QLog.w("BluetoohHeadsetCheck", 2, "BT ACTION_SCO_AUDIO_STATE_UPDATED|   EXTRA_CONNECTION_STATE  dev:" + paramContext);
      }
      if (QLog.isColorLevel()) {
        QLog.w("BluetoohHeadsetCheck", 2, "   EXTRA_SCO_AUDIO_STATE " + b(i) + "  Bluetooth visible:" + this.jdField_a_of_type_Bflq.b("DEVICE_BLUETOOTHHEADSET"));
      }
    } while (!QLog.isColorLevel());
    label519:
    label525:
    QLog.w("BluetoohHeadsetCheck", 2, "   EXTRA_SCO_AUDIO_PREVIOUS_STATE " + b(j));
  }
  
  void a(IntentFilter paramIntentFilter)
  {
    if (QLog.isColorLevel()) {
      QLog.w("BluetoohHeadsetCheck", 2, " " + a() + " _addAction");
    }
    paramIntentFilter.addAction("android.bluetooth.adapter.action.CONNECTION_STATE_CHANGED");
    paramIntentFilter.addAction("android.media.ACTION_SCO_AUDIO_STATE_UPDATED");
    paramIntentFilter.addAction("android.bluetooth.headset.profile.action.AUDIO_STATE_CHANGED");
    paramIntentFilter.addAction("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED");
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_AndroidBluetoothBluetoothProfile != null) {
      try
      {
        List localList = this.jdField_a_of_type_AndroidBluetoothBluetoothProfile.getConnectedDevices();
        if (localList == null) {
          return false;
        }
        int i = localList.size();
        if (i > 0) {
          return true;
        }
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("BluetoohHeadsetCheck", 2, " isConnected e = " + localException);
        }
      }
    }
    return false;
  }
  
  public boolean a(Context paramContext, bflq parambflq)
  {
    AudioDeviceInterface.LogTraceEntry("");
    if ((paramContext == null) || (parambflq == null)) {
      if (QLog.isColorLevel()) {
        QLog.e("BluetoohHeadsetCheck", 2, " err ctx==null||_devCfg==null");
      }
    }
    do
    {
      do
      {
        return false;
        this.jdField_a_of_type_AndroidContentContext = paramContext;
        this.jdField_a_of_type_Bflq = parambflq;
        this.jdField_a_of_type_AndroidBluetoothBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        if (this.jdField_a_of_type_AndroidBluetoothBluetoothAdapter != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.e("BluetoohHeadsetCheck", 2, " err getDefaultAdapter fail!");
      return false;
      if ((!this.jdField_a_of_type_AndroidBluetoothBluetoothAdapter.isEnabled()) || (this.jdField_a_of_type_AndroidBluetoothBluetoothProfile != null) || (this.jdField_a_of_type_AndroidBluetoothBluetoothAdapter.getProfileProxy(this.jdField_a_of_type_AndroidContentContext, this, 1))) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("BluetoohHeadsetCheck", 2, "BluetoohHeadsetCheck: getProfileProxy HEADSET fail!");
    return false;
    AudioDeviceInterface.LogTraceExit();
    return true;
  }
  
  public void onServiceConnected(int paramInt, BluetoothProfile paramBluetoothProfile)
  {
    if (paramInt == 1)
    {
      if ((this.jdField_a_of_type_AndroidBluetoothBluetoothProfile != null) && (this.jdField_a_of_type_AndroidBluetoothBluetoothProfile != paramBluetoothProfile))
      {
        if (QLog.isColorLevel()) {
          QLog.w("BluetoohHeadsetCheck", 2, "BluetoohHeadsetCheck: HEADSET Connected proxy:" + paramBluetoothProfile + " _profile:" + this.jdField_a_of_type_AndroidBluetoothBluetoothProfile);
        }
        this.jdField_a_of_type_AndroidBluetoothBluetoothAdapter.closeProfileProxy(1, this.jdField_a_of_type_AndroidBluetoothBluetoothProfile);
        this.jdField_a_of_type_AndroidBluetoothBluetoothProfile = null;
      }
      this.jdField_a_of_type_AndroidBluetoothBluetoothProfile = paramBluetoothProfile;
      ThreadManager.post(new TraeAudioManager.BluetoohHeadsetCheck.1(this), 5, null, false);
    }
    AudioDeviceInterface.LogTraceExit();
  }
  
  public void onServiceDisconnected(int paramInt)
  {
    AudioDeviceInterface.LogTraceEntry("_profile:" + this.jdField_a_of_type_AndroidBluetoothBluetoothProfile + " profile:" + paramInt);
    if (paramInt == 1)
    {
      if (QLog.isColorLevel()) {
        QLog.w("BluetoohHeadsetCheck", 2, "TRAEBluetoohProxy: HEADSET Disconnected");
      }
      if (a()) {
        this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager.a("DEVICE_BLUETOOTHHEADSET", false);
      }
      if (this.jdField_a_of_type_AndroidBluetoothBluetoothProfile != null)
      {
        this.jdField_a_of_type_AndroidBluetoothBluetoothAdapter.closeProfileProxy(1, this.jdField_a_of_type_AndroidBluetoothBluetoothProfile);
        this.jdField_a_of_type_AndroidBluetoothBluetoothProfile = null;
      }
    }
    AudioDeviceInterface.LogTraceExit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     bflm
 * JD-Core Version:    0.7.0.1
 */