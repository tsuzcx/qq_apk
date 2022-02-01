package com.tencent.mobileqq.activity.specialcare;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

class VipSpecialSoundWebViewPlugin$4
  implements MediaPlayer.OnCompletionListener
{
  VipSpecialSoundWebViewPlugin$4(VipSpecialSoundWebViewPlugin paramVipSpecialSoundWebViewPlugin, int paramInt, String paramString) {}
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    paramMediaPlayer = new StringBuilder();
    paramMediaPlayer.append("play completed, soundId:");
    paramMediaPlayer.append(this.a);
    QLog.e("QVipSpecialSoundWebViewPlugin", 1, paramMediaPlayer.toString());
    try
    {
      paramMediaPlayer = new JSONObject();
      paramMediaPlayer.put("code", 1);
      this.c.callJs(this.b, new String[] { paramMediaPlayer.toString() });
      return;
    }
    catch (JSONException paramMediaPlayer)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onCompletion: ");
      localStringBuilder.append(this.a);
      QLog.e("QVipSpecialSoundWebViewPlugin", 1, localStringBuilder.toString(), paramMediaPlayer);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.specialcare.VipSpecialSoundWebViewPlugin.4
 * JD-Core Version:    0.7.0.1
 */