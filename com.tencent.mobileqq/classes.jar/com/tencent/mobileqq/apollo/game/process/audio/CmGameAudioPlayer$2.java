package com.tencent.mobileqq.apollo.game.process.audio;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnSeekCompleteListener;
import com.tencent.mobileqq.apollo.game.process.chanel.CmGameNativeMethodHandler;
import org.json.JSONObject;

class CmGameAudioPlayer$2
  implements MediaPlayer.OnSeekCompleteListener
{
  CmGameAudioPlayer$2(CmGameAudioPlayer paramCmGameAudioPlayer, JSONObject paramJSONObject, CmGameNativeMethodHandler paramCmGameNativeMethodHandler) {}
  
  public void onSeekComplete(MediaPlayer paramMediaPlayer)
  {
    paramMediaPlayer = this.jdField_a_of_type_OrgJsonJSONObject;
    if (paramMediaPlayer != null) {
      CmGameAudioPlayer.a(this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessAudioCmGameAudioPlayer, this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessChanelCmGameNativeMethodHandler, paramMediaPlayer);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.process.audio.CmGameAudioPlayer.2
 * JD-Core Version:    0.7.0.1
 */