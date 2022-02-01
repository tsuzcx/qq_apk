package com.tencent.mobileqq.apollo.process.audio;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import com.tencent.mobileqq.apollo.process.chanel.CmGameNativeMethodHandler;
import org.json.JSONObject;

class CmGameAudioPlayer$4
  implements MediaPlayer.OnPreparedListener
{
  CmGameAudioPlayer$4(CmGameAudioPlayer paramCmGameAudioPlayer, JSONObject paramJSONObject, CmGameNativeMethodHandler paramCmGameNativeMethodHandler) {}
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    this.jdField_a_of_type_ComTencentMobileqqApolloProcessAudioCmGameAudioPlayer.a(3);
    if (CmGameAudioPlayer.a(this.jdField_a_of_type_ComTencentMobileqqApolloProcessAudioCmGameAudioPlayer)) {
      this.jdField_a_of_type_ComTencentMobileqqApolloProcessAudioCmGameAudioPlayer.b(this.jdField_a_of_type_OrgJsonJSONObject, this.jdField_a_of_type_ComTencentMobileqqApolloProcessChanelCmGameNativeMethodHandler);
    }
    if (this.jdField_a_of_type_OrgJsonJSONObject != null) {
      CmGameAudioPlayer.a(this.jdField_a_of_type_ComTencentMobileqqApolloProcessAudioCmGameAudioPlayer, this.jdField_a_of_type_ComTencentMobileqqApolloProcessChanelCmGameNativeMethodHandler, this.jdField_a_of_type_OrgJsonJSONObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.audio.CmGameAudioPlayer.4
 * JD-Core Version:    0.7.0.1
 */