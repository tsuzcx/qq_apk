package com.tencent.mobileqq.activity.specialcare;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import com.tencent.mobileqq.utils.MediaPlayerHelper;
import org.json.JSONObject;

public class VipSpecialSoundWebViewPlugin$PreparedListener
  implements MediaPlayer.OnPreparedListener
{
  JSONObject a;
  String b;
  boolean c;
  
  public VipSpecialSoundWebViewPlugin$PreparedListener(VipSpecialSoundWebViewPlugin paramVipSpecialSoundWebViewPlugin, JSONObject paramJSONObject, String paramString, boolean paramBoolean)
  {
    this.a = paramJSONObject;
    this.b = paramString;
    this.c = paramBoolean;
  }
  
  public void a()
  {
    try
    {
      this.a.put("code", 2);
      this.a.put("errorMessage", "can't play");
      this.d.callJs(this.b, new String[] { this.a.toString() });
      return;
    }
    catch (Exception localException1)
    {
      VipSpecialSoundWebViewPlugin localVipSpecialSoundWebViewPlugin = this.d;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("-->handleJsRequest exception:");
      localStringBuilder.append(localException1.toString());
      VipSpecialSoundWebViewPlugin.a(localVipSpecialSoundWebViewPlugin, localStringBuilder.toString());
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("code", 2);
        localJSONObject.put("errorMessage", "exception");
        this.d.callJs(this.b, new String[] { localJSONObject.toString() });
        return;
      }
      catch (Exception localException2)
      {
        localException2.printStackTrace();
      }
    }
  }
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    if (VipSpecialSoundWebViewPlugin.a(this.d).b()) {}
    try
    {
      if (this.c)
      {
        this.a.put("code", 0);
      }
      else
      {
        VipSpecialSoundWebViewPlugin.a(this.d, "-->play failed");
        this.a.put("code", 2);
        this.a.put("errorMessage", "can't play");
      }
      this.d.callJs(this.b, new String[] { this.a.toString() });
      return;
    }
    catch (Exception paramMediaPlayer)
    {
      VipSpecialSoundWebViewPlugin localVipSpecialSoundWebViewPlugin = this.d;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("-->handleJsRequest exception:");
      localStringBuilder.append(paramMediaPlayer.toString());
      VipSpecialSoundWebViewPlugin.a(localVipSpecialSoundWebViewPlugin, localStringBuilder.toString());
      try
      {
        paramMediaPlayer = new JSONObject();
        paramMediaPlayer.put("code", 2);
        paramMediaPlayer.put("errorMessage", "exception");
        this.d.callJs(this.b, new String[] { paramMediaPlayer.toString() });
        return;
      }
      catch (Exception paramMediaPlayer)
      {
        paramMediaPlayer.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.specialcare.VipSpecialSoundWebViewPlugin.PreparedListener
 * JD-Core Version:    0.7.0.1
 */