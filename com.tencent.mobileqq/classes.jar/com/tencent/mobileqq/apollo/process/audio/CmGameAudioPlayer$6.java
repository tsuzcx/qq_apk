package com.tencent.mobileqq.apollo.process.audio;

import android.media.AudioManager.OnAudioFocusChangeListener;
import com.tencent.mobileqq.apollo.ApolloSurfaceView;
import com.tencent.mobileqq.apollo.api.IApolloCmdChannel;
import com.tencent.mobileqq.apollo.process.CmGameUtil;
import com.tencent.mobileqq.apollo.process.data.CmGameLauncher;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class CmGameAudioPlayer$6
  implements AudioManager.OnAudioFocusChangeListener
{
  CmGameAudioPlayer$6(CmGameAudioPlayer paramCmGameAudioPlayer) {}
  
  public void onAudioFocusChange(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CmGameAudioPlayer", 2, new Object[] { "[onAudioFocusChange],focusChange:", Integer.valueOf(paramInt) });
    }
    for (;;)
    {
      JSONObject localJSONObject;
      try
      {
        localJSONObject = new JSONObject();
        if (paramInt != 1) {
          break label107;
        }
        localJSONObject.put("event", 2);
        CmGameLauncher localCmGameLauncher = CmGameUtil.a(CmGameAudioPlayer.a(this.a));
        if ((localCmGameLauncher == null) || (localCmGameLauncher.a() == null)) {
          break label106;
        }
        CmGameUtil.a().callbackFromRequest(localCmGameLauncher.a().getLuaState(), 0, "sc.audio_event.local", localJSONObject.toString());
        return;
      }
      catch (Throwable localThrowable) {}
      localJSONObject.put("event", 1);
      continue;
      label106:
      return;
      label107:
      if (paramInt != -1) {
        if (paramInt != -2) {}
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.audio.CmGameAudioPlayer.6
 * JD-Core Version:    0.7.0.1
 */