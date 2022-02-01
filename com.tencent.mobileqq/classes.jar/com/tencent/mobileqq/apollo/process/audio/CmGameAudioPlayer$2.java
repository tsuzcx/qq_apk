package com.tencent.mobileqq.apollo.process.audio;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnSeekCompleteListener;
import com.tencent.mobileqq.apollo.process.chanel.CmGameNativeMethodHandler;
import org.json.JSONObject;

class CmGameAudioPlayer$2
  implements MediaPlayer.OnSeekCompleteListener
{
  CmGameAudioPlayer$2(CmGameAudioPlayer paramCmGameAudioPlayer, JSONObject paramJSONObject, CmGameNativeMethodHandler paramCmGameNativeMethodHandler) {}
  
  public void onSeekComplete(MediaPlayer paramMediaPlayer)
  {
    if (this.jdField_a_of_type_OrgJsonJSONObject != null) {
      CmGameAudioPlayer.a(this.jdField_a_of_type_ComTencentMobileqqApolloProcessAudioCmGameAudioPlayer, this.jdField_a_of_type_ComTencentMobileqqApolloProcessChanelCmGameNativeMethodHandler, this.jdField_a_of_type_OrgJsonJSONObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.audio.CmGameAudioPlayer.2
 * JD-Core Version:    0.7.0.1
 */