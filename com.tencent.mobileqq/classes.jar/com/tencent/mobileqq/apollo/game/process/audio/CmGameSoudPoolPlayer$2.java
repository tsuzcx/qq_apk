package com.tencent.mobileqq.apollo.game.process.audio;

import android.media.SoundPool;
import android.media.SoundPool.OnLoadCompleteListener;
import com.tencent.mobileqq.apollo.render.IRenderRunner;
import com.tencent.qphone.base.util.QLog;

class CmGameSoudPoolPlayer$2
  implements SoundPool.OnLoadCompleteListener
{
  CmGameSoudPoolPlayer$2(CmGameSoudPoolPlayer paramCmGameSoudPoolPlayer, float paramFloat, int paramInt, String paramString, IRenderRunner paramIRenderRunner, long paramLong) {}
  
  public void onLoadComplete(SoundPool paramSoundPool, int paramInt1, int paramInt2)
  {
    float f = this.jdField_a_of_type_Float;
    if (-1.0F == f) {
      f = 1.0F;
    }
    paramInt1 = CmGameSoudPoolPlayer.a(this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessAudioCmGameSoudPoolPlayer).play(paramInt1, f, f, 0, this.jdField_a_of_type_Int, 1.0F);
    if (paramInt1 == 0)
    {
      paramSoundPool = new StringBuilder();
      paramSoundPool.append("fail to play, musicPath:");
      paramSoundPool.append(this.jdField_a_of_type_JavaLangString);
      QLog.w("cmgame_process.CmGameSoudPoolPlayer", 1, paramSoundPool.toString());
      return;
    }
    CmGameSoudPoolPlayer.a(this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessAudioCmGameSoudPoolPlayer, this.jdField_a_of_type_ComTencentMobileqqApolloRenderIRenderRunner, paramInt1, this.jdField_a_of_type_Long);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.process.audio.CmGameSoudPoolPlayer.2
 * JD-Core Version:    0.7.0.1
 */