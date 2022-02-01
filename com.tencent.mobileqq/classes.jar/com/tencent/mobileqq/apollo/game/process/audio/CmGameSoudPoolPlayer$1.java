package com.tencent.mobileqq.apollo.game.process.audio;

import android.media.SoundPool;
import android.media.SoundPool.OnLoadCompleteListener;
import com.tencent.mobileqq.apollo.game.process.chanel.CmGameNativeMethodHandler;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class CmGameSoudPoolPlayer$1
  implements SoundPool.OnLoadCompleteListener
{
  CmGameSoudPoolPlayer$1(CmGameSoudPoolPlayer paramCmGameSoudPoolPlayer, float paramFloat, int paramInt, String paramString, CmGameNativeMethodHandler paramCmGameNativeMethodHandler, JSONObject paramJSONObject) {}
  
  public void onLoadComplete(SoundPool paramSoundPool, int paramInt1, int paramInt2)
  {
    if (CmGameSoudPoolPlayer.a(this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessAudioCmGameSoudPoolPlayer) != null) {
      try
      {
        float f;
        if (-1.0F == this.jdField_a_of_type_Float) {
          f = 1.0F;
        } else {
          f = this.jdField_a_of_type_Float;
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
        paramSoundPool = this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessChanelCmGameNativeMethodHandler;
        if (paramSoundPool != null) {
          try
          {
            if (this.jdField_a_of_type_OrgJsonJSONObject != null)
            {
              this.jdField_a_of_type_OrgJsonJSONObject.put("id", paramInt1);
              this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessChanelCmGameNativeMethodHandler.a(this.jdField_a_of_type_OrgJsonJSONObject);
              return;
            }
            QLog.e("cmgame_process.CmGameSoudPoolPlayer", 1, "result is null");
            return;
          }
          catch (Throwable paramSoundPool)
          {
            QLog.e("cmgame_process.CmGameSoudPoolPlayer", 1, paramSoundPool, new Object[0]);
            return;
          }
        }
        QLog.e("cmgame_process.CmGameSoudPoolPlayer", 1, "handler is null");
        return;
      }
      catch (Throwable paramSoundPool)
      {
        QLog.e("cmgame_process.CmGameSoudPoolPlayer", 1, "pool play failed", paramSoundPool);
        return;
      }
    }
    QLog.e("cmgame_process.CmGameSoudPoolPlayer", 1, "soundpool is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.process.audio.CmGameSoudPoolPlayer.1
 * JD-Core Version:    0.7.0.1
 */