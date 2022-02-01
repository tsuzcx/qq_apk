package com.tencent.mobileqq.apollo.game.process.audio;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import com.tencent.mobileqq.apollo.game.process.chanel.CmGameNativeMethodHandler;
import org.json.JSONObject;

class CmGameAudioPlayer$4
  implements MediaPlayer.OnPreparedListener
{
  CmGameAudioPlayer$4(CmGameAudioPlayer paramCmGameAudioPlayer, JSONObject paramJSONObject, CmGameNativeMethodHandler paramCmGameNativeMethodHandler) {}
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessAudioCmGameAudioPlayer.a(3);
    if (CmGameAudioPlayer.a(this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessAudioCmGameAudioPlayer)) {
      this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessAudioCmGameAudioPlayer.b(this.jdField_a_of_type_OrgJsonJSONObject, this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessChanelCmGameNativeMethodHandler);
    }
    paramMediaPlayer = this.jdField_a_of_type_OrgJsonJSONObject;
    if (paramMediaPlayer != null) {
      CmGameAudioPlayer.a(this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessAudioCmGameAudioPlayer, this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessChanelCmGameNativeMethodHandler, paramMediaPlayer);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.process.audio.CmGameAudioPlayer.4
 * JD-Core Version:    0.7.0.1
 */