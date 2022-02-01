package com.tencent.mobileqq.apollo.game.process.audio;

import android.media.SoundPool;
import android.media.SoundPool.OnLoadCompleteListener;
import com.tencent.mobileqq.cmshow.brickengine.apollo.IRenderRunner;
import com.tencent.qphone.base.util.QLog;

class CmGameSoudPoolPlayer$2
  implements SoundPool.OnLoadCompleteListener
{
  CmGameSoudPoolPlayer$2(CmGameSoudPoolPlayer paramCmGameSoudPoolPlayer, float paramFloat, int paramInt, String paramString, IRenderRunner paramIRenderRunner, long paramLong) {}
  
  public void onLoadComplete(SoundPool paramSoundPool, int paramInt1, int paramInt2)
  {
    float f1 = this.a;
    if (-1.0F == f1) {
      f1 = 1.0F;
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
    CmGameSoudPoolPlayer.a(this.f, this.d, paramInt1, this.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.process.audio.CmGameSoudPoolPlayer.2
 * JD-Core Version:    0.7.0.1
 */