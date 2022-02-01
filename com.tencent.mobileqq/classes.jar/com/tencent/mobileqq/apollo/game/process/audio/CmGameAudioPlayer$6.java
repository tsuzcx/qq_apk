package com.tencent.mobileqq.apollo.game.process.audio;

import android.media.AudioManager.OnAudioFocusChangeListener;
import com.tencent.mobileqq.apollo.game.process.CmGameUtil;
import com.tencent.mobileqq.apollo.game.process.data.CmGameLauncher;
import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloCmdChannel;
import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloSurfaceView;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class CmGameAudioPlayer$6
  implements AudioManager.OnAudioFocusChangeListener
{
  CmGameAudioPlayer$6(CmGameAudioPlayer paramCmGameAudioPlayer) {}
  
  public void onAudioFocusChange(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]CmGameAudioPlayer", 2, new Object[] { "[onAudioFocusChange],focusChange:", Integer.valueOf(paramInt) });
    }
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        if (paramInt != 1) {
          break label114;
        }
        localJSONObject.put("event", 2);
        continue;
        localJSONObject.put("event", 1);
        CmGameLauncher localCmGameLauncher = CmGameUtil.a(CmGameAudioPlayer.b(this.a));
        if ((localCmGameLauncher != null) && (localCmGameLauncher.e() != null))
        {
          ApolloCmdChannel.getInstance().callbackFromRequest(localCmGameLauncher.e().getLuaState(), 0, "sc.audio_event.local", localJSONObject.toString());
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.e("[cmshow]CmGameAudioPlayer", 1, "onAudioFocusChange exception", localThrowable);
      }
      return;
      label114:
      if (paramInt != -1) {
        if (paramInt != -2) {}
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.process.audio.CmGameAudioPlayer.6
 * JD-Core Version:    0.7.0.1
 */