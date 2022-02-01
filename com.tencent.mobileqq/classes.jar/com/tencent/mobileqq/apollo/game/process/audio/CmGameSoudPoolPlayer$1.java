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
    if (CmGameSoudPoolPlayer.a(this.f) != null) {
      try
      {
        float f1;
        if (-1.0F == this.a) {
          f1 = 1.0F;
        } else {
          f1 = this.a;
        }
        paramInt1 = CmGameSoudPoolPlayer.a(this.f).play(paramInt1, f1, f1, 0, this.b, 1.0F);
        if (paramInt1 == 0)
        {
          paramSoundPool = new StringBuilder();
          paramSoundPool.append("fail to play, musicPath:");
          paramSoundPool.append(this.c);
          QLog.w("cmgame_process.CmGameSoudPoolPlayer", 1, paramSoundPool.toString());
          return;
        }
        paramSoundPool = this.d;
        if (paramSoundPool != null) {
          try
          {
            if (this.e != null)
            {
              this.e.put("id", paramInt1);
              this.d.a(this.e);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.process.audio.CmGameSoudPoolPlayer.1
 * JD-Core Version:    0.7.0.1
 */