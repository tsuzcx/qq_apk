package com.tencent.mobileqq.apollo.process.audio;

import android.media.SoundPool;
import android.media.SoundPool.OnLoadCompleteListener;
import com.tencent.mobileqq.apollo.api.render.IRenderRunner;
import com.tencent.qphone.base.util.QLog;

class CmGameSoudPoolPlayer$2
  implements SoundPool.OnLoadCompleteListener
{
  CmGameSoudPoolPlayer$2(CmGameSoudPoolPlayer paramCmGameSoudPoolPlayer, float paramFloat, int paramInt, String paramString, IRenderRunner paramIRenderRunner, long paramLong) {}
  
  public void onLoadComplete(SoundPool paramSoundPool, int paramInt1, int paramInt2)
  {
    if (-1.0F == this.jdField_a_of_type_Float) {}
    for (float f = 1.0F;; f = this.jdField_a_of_type_Float)
    {
      paramInt1 = CmGameSoudPoolPlayer.a(this.jdField_a_of_type_ComTencentMobileqqApolloProcessAudioCmGameSoudPoolPlayer).play(paramInt1, f, f, 0, this.jdField_a_of_type_Int, 1.0F);
      if (paramInt1 != 0) {
        break;
      }
      QLog.w("cmgame_process.CmGameSoudPoolPlayer", 1, "fail to play, musicPath:" + this.jdField_a_of_type_JavaLangString);
      return;
    }
    CmGameSoudPoolPlayer.a(this.jdField_a_of_type_ComTencentMobileqqApolloProcessAudioCmGameSoudPoolPlayer, this.jdField_a_of_type_ComTencentMobileqqApolloApiRenderIRenderRunner, paramInt1, this.jdField_a_of_type_Long);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.audio.CmGameSoudPoolPlayer.2
 * JD-Core Version:    0.7.0.1
 */