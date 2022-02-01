package com.tencent.ilivesdk.audiomediaservice;

import android.content.Context;
import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.ilivesdk.audiomediaservice.interfaces.AudioEnterRoomParam;
import com.tencent.ilivesdk.audiomediaservice.interfaces.IAudioMediaService;
import com.tencent.ilivesdk.audiomediaservice.interfaces.IAudioMediaServiceAdapter;
import com.tencent.ilivesdk.audiomediaservice.interfaces.IAudioMediaServiceListener;
import com.tencent.ilivesdk.audiomediaservice.interfaces.IAudioRecordPlayer;
import com.tencent.ilivesdk.audiomediaservice.interfaces.IAudioVolumeListener;
import com.tencent.ilivesdk.audiomediaservice.player.AudioRecordPlayer;

public class AudioMediaService
  implements IAudioMediaService
{
  private Context jdField_a_of_type_AndroidContentContext;
  private LogInterface jdField_a_of_type_ComTencentFalcoBaseLibapiLogLogInterface;
  private IAudioMediaServiceAdapter jdField_a_of_type_ComTencentIlivesdkAudiomediaserviceInterfacesIAudioMediaServiceAdapter;
  private IAudioRecordPlayer jdField_a_of_type_ComTencentIlivesdkAudiomediaserviceInterfacesIAudioRecordPlayer;
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentIlivesdkAudiomediaserviceInterfacesIAudioRecordPlayer.a();
  }
  
  public void a(AudioEnterRoomParam paramAudioEnterRoomParam, IAudioMediaServiceListener paramIAudioMediaServiceListener)
  {
    this.jdField_a_of_type_ComTencentIlivesdkAudiomediaserviceInterfacesIAudioRecordPlayer.a(paramAudioEnterRoomParam, paramIAudioMediaServiceListener);
  }
  
  public void a(IAudioMediaServiceAdapter paramIAudioMediaServiceAdapter)
  {
    this.jdField_a_of_type_ComTencentIlivesdkAudiomediaserviceInterfacesIAudioMediaServiceAdapter = paramIAudioMediaServiceAdapter;
    this.jdField_a_of_type_ComTencentFalcoBaseLibapiLogLogInterface = this.jdField_a_of_type_ComTencentIlivesdkAudiomediaserviceInterfacesIAudioMediaServiceAdapter.a();
    this.jdField_a_of_type_ComTencentIlivesdkAudiomediaserviceInterfacesIAudioRecordPlayer = new AudioRecordPlayer(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentIlivesdkAudiomediaserviceInterfacesIAudioMediaServiceAdapter);
  }
  
  public void a(IAudioVolumeListener paramIAudioVolumeListener)
  {
    this.jdField_a_of_type_ComTencentIlivesdkAudiomediaserviceInterfacesIAudioRecordPlayer.a(paramIAudioVolumeListener);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentIlivesdkAudiomediaserviceInterfacesIAudioRecordPlayer.a(paramBoolean);
  }
  
  public void clearEventOutput() {}
  
  public void onCreate(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_ComTencentFalcoBaseLibapiLogLogInterface.i("AudioMediaService", "onDestroy", new Object[0]);
    this.jdField_a_of_type_AndroidContentContext = null;
    if (this.jdField_a_of_type_ComTencentIlivesdkAudiomediaserviceInterfacesIAudioRecordPlayer != null) {
      this.jdField_a_of_type_ComTencentIlivesdkAudiomediaserviceInterfacesIAudioRecordPlayer.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.audiomediaservice.AudioMediaService
 * JD-Core Version:    0.7.0.1
 */