package com.tencent.ilivesdk.audiomediaservice.player;

import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.ilive.opensdk.callbacks.RtcInitCallback;
import com.tencent.ilivesdk.audiomediaservice.interfaces.AudioEnterRoomParam;

class AudioRecordPlayer$3
  extends RtcInitCallback
{
  AudioRecordPlayer$3(AudioRecordPlayer paramAudioRecordPlayer, AudioEnterRoomParam paramAudioEnterRoomParam) {}
  
  public void onInitCompleted()
  {
    AudioRecordPlayer.a(this.jdField_a_of_type_ComTencentIlivesdkAudiomediaservicePlayerAudioRecordPlayer).i("AudioRecordPlayer", "initOpenSdk: the openSdk init completed.", new Object[0]);
    AudioRecordPlayer.b(this.jdField_a_of_type_ComTencentIlivesdkAudiomediaservicePlayerAudioRecordPlayer, this.jdField_a_of_type_ComTencentIlivesdkAudiomediaserviceInterfacesAudioEnterRoomParam);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilivesdk.audiomediaservice.player.AudioRecordPlayer.3
 * JD-Core Version:    0.7.0.1
 */