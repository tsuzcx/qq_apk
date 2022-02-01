package com.tencent.avgame.qav.audio;

import android.text.TextUtils;
import com.tencent.avgame.callback.AVGameUIEventCallback;
import com.tencent.avgame.gamelogic.ITopic;
import com.tencent.avgame.gamelogic.gameres.AvGameResDownloadUtil;
import com.tencent.avgame.qav.IAVGameBusinessCtrl;
import com.tencent.avgame.qav.audio.player.AVSoundHelper;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class AvGameSysMusicPlayer
  implements IGameEffectPlayer
{
  protected AVGameUIEventCallback a;
  private boolean b;
  private String c;
  
  public static AvGameSysMusicPlayer a()
  {
    return AvGameSysMusicPlayer.Holder.a();
  }
  
  private void e()
  {
    if (this.b) {
      return;
    }
    QLog.d("AvGameSysMusicPlayer", 1, "[initIfNeeded]");
    if (!AVSoundHelper.c()) {
      AVSoundHelper.a();
    }
    if (TextUtils.isEmpty(this.c)) {
      this.c = AvGameResDownloadUtil.b();
    }
    this.a = new AvGameSysMusicPlayer.1(this);
    IAVGameBusinessCtrl localIAVGameBusinessCtrl = IAVGameBusinessCtrl.p();
    if (localIAVGameBusinessCtrl != null) {
      localIAVGameBusinessCtrl.a(this.a);
    }
    this.b = true;
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (this.b)
    {
      if (TextUtils.isEmpty(this.c)) {
        return;
      }
      Object localObject1;
      Object localObject2;
      if (((paramInt == 2) || (paramInt == 5)) && (paramBoolean))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(this.c);
        ((StringBuilder)localObject1).append("cj_bg");
        ((StringBuilder)localObject1).append(".mp3");
        localObject2 = ((StringBuilder)localObject1).toString();
        localObject1 = localObject2;
        if (new File((String)localObject2).exists()) {}
      }
      else
      {
        localObject1 = AvGameMusicPlayer.d(paramInt);
        AvGameMusicPlayer.a((String)localObject1);
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(this.c);
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(".mp3");
        localObject1 = ((StringBuilder)localObject2).toString();
      }
      QLog.d("AvGameSysMusicPlayer", 1, new Object[] { "[playBgMusic]: ", localObject1 });
      AVSoundHelper.b((String)localObject1, true);
    }
  }
  
  public void a(ITopic paramITopic, String paramString)
  {
    if (!this.b) {
      return;
    }
    String str = AvGameMusicPlayer.b(paramITopic, paramString);
    paramITopic = str;
    if (TextUtils.isEmpty(str))
    {
      paramITopic = new StringBuilder();
      paramITopic.append(this.c);
      paramITopic.append(paramString);
      paramITopic.append(".mp3");
      paramITopic = paramITopic.toString();
    }
    QLog.d("AvGameSysMusicPlayer", 1, new Object[] { "[playEffect]: ", paramITopic });
    AVSoundHelper.a(paramITopic, false);
  }
  
  public void b()
  {
    e();
  }
  
  public void c()
  {
    if (!this.b) {
      return;
    }
    QLog.d("AvGameSysMusicPlayer", 1, "[stopPlay]");
    AVSoundHelper.g();
    AVSoundHelper.f();
  }
  
  public void d()
  {
    if (!this.b) {
      return;
    }
    QLog.d("AvGameSysMusicPlayer", 1, "[destroy]");
    AVSoundHelper.b();
    IAVGameBusinessCtrl localIAVGameBusinessCtrl = IAVGameBusinessCtrl.p();
    if (localIAVGameBusinessCtrl != null) {
      localIAVGameBusinessCtrl.b(this.a);
    }
    this.b = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.qav.audio.AvGameSysMusicPlayer
 * JD-Core Version:    0.7.0.1
 */