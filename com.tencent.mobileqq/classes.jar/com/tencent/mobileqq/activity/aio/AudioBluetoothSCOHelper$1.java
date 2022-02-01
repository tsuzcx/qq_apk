package com.tencent.mobileqq.activity.aio;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothClass;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothHeadset;
import android.bluetooth.BluetoothProfile;
import android.bluetooth.BluetoothProfile.ServiceListener;
import com.tencent.mobileqq.qqaudio.audioplayer.AudioPlayerBase;
import java.util.List;

class AudioBluetoothSCOHelper$1
  implements BluetoothProfile.ServiceListener
{
  AudioBluetoothSCOHelper$1(AudioBluetoothSCOHelper paramAudioBluetoothSCOHelper, AudioPlayerBase paramAudioPlayerBase, String paramString, int paramInt, BluetoothAdapter paramBluetoothAdapter) {}
  
  public void onServiceConnected(int paramInt, BluetoothProfile paramBluetoothProfile)
  {
    Object localObject;
    if (paramInt == 1)
    {
      paramBluetoothProfile = (BluetoothHeadset)paramBluetoothProfile;
      localObject = paramBluetoothProfile.getConnectedDevices();
      if ((localObject == null) || (((List)localObject).size() <= 0)) {
        break label101;
      }
      localObject = (BluetoothDevice)((List)localObject).get(0);
      if ((localObject != null) && (((BluetoothDevice)localObject).getBluetoothClass() != null)) {
        break label90;
      }
      paramInt = 0;
    }
    label90:
    label101:
    for (AudioPlayerBase.b = paramInt;; AudioPlayerBase.b = 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAudioPlayerBase.d(true);
      this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAudioPlayerBase.b(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
      this.jdField_a_of_type_AndroidBluetoothBluetoothAdapter.closeProfileProxy(1, paramBluetoothProfile);
      return;
      paramInt = ((BluetoothDevice)localObject).getBluetoothClass().getDeviceClass();
      break;
    }
  }
  
  public void onServiceDisconnected(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.AudioBluetoothSCOHelper.1
 * JD-Core Version:    0.7.0.1
 */