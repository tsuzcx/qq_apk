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
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  
  public static AvGameSysMusicPlayer a()
  {
    return AvGameSysMusicPlayer.Holder.a();
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    QLog.d("AvGameSysMusicPlayer", 1, "[initIfNeeded]");
    if (!AVSoundHelper.a()) {
      AVSoundHelper.a();
    }
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      this.jdField_a_of_type_JavaLangString = AvGameResDownloadUtil.b();
    }
    this.jdField_a_of_type_ComTencentAvgameCallbackAVGameUIEventCallback = new AvGameSysMusicPlayer.1(this);
    IAVGameBusinessCtrl localIAVGameBusinessCtrl = IAVGameBusinessCtrl.a();
    if (localIAVGameBusinessCtrl != null) {
      localIAVGameBusinessCtrl.a(this.jdField_a_of_type_ComTencentAvgameCallbackAVGameUIEventCallback);
    }
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void a()
  {
    d();
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        return;
      }
      Object localObject1;
      Object localObject2;
      if (((paramInt == 2) || (paramInt == 5)) && (paramBoolean))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(this.jdField_a_of_type_JavaLangString);
        ((StringBuilder)localObject1).append("cj_bg");
        ((StringBuilder)localObject1).append(".mp3");
        localObject2 = ((StringBuilder)localObject1).toString();
        localObject1 = localObject2;
        if (new File((String)localObject2).exists()) {}
      }
      else
      {
        localObject1 = AvGameMusicPlayer.a(paramInt);
        AvGameMusicPlayer.a((String)localObject1);
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(this.jdField_a_of_type_JavaLangString);
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
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    String str = AvGameMusicPlayer.a(paramITopic, paramString);
    paramITopic = str;
    if (TextUtils.isEmpty(str))
    {
      paramITopic = new StringBuilder();
      paramITopic.append(this.jdField_a_of_type_JavaLangString);
      paramITopic.append(paramString);
      paramITopic.append(".mp3");
      paramITopic = paramITopic.toString();
    }
    QLog.d("AvGameSysMusicPlayer", 1, new Object[] { "[playEffect]: ", paramITopic });
    AVSoundHelper.a(paramITopic, false);
  }
  
  public void b()
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    QLog.d("AvGameSysMusicPlayer", 1, "[stopPlay]");
    AVSoundHelper.f();
    AVSoundHelper.e();
  }
  
  public void c()
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    QLog.d("AvGameSysMusicPlayer", 1, "[destroy]");
    AVSoundHelper.b();
    IAVGameBusinessCtrl localIAVGameBusinessCtrl = IAVGameBusinessCtrl.a();
    if (localIAVGameBusinessCtrl != null) {
      localIAVGameBusinessCtrl.b(this.jdField_a_of_type_ComTencentAvgameCallbackAVGameUIEventCallback);
    }
    this.jdField_a_of_type_Boolean = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.qav.audio.AvGameSysMusicPlayer
 * JD-Core Version:    0.7.0.1
 */