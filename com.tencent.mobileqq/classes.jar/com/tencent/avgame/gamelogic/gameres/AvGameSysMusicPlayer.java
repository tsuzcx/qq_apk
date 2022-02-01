package com.tencent.avgame.gamelogic.gameres;

import android.text.TextUtils;
import com.tencent.avgame.audio.player.AVSoundHelper;
import com.tencent.avgame.callback.AVGameUIEventCallback;
import com.tencent.avgame.gamelogic.ITopic;
import com.tencent.avgame.qav.AVGameBusinessCtrl;
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
      this.jdField_a_of_type_JavaLangString = AvGameResDownloadManager.b();
    }
    this.jdField_a_of_type_ComTencentAvgameCallbackAVGameUIEventCallback = new AvGameSysMusicPlayer.1(this);
    AVGameBusinessCtrl.b().a(this.jdField_a_of_type_ComTencentAvgameCallbackAVGameUIEventCallback);
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void a()
  {
    d();
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if ((!this.jdField_a_of_type_Boolean) || (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))) {}
    String str;
    File localFile;
    do
    {
      return;
      if (((paramInt != 2) && (paramInt != 5)) || (!paramBoolean)) {
        break;
      }
      str = this.jdField_a_of_type_JavaLangString + "cj_bg" + ".mp3";
      localFile = new File(str);
    } while ((localFile == null) || (!localFile.exists()));
    for (;;)
    {
      QLog.d("AvGameSysMusicPlayer", 1, new Object[] { "[playBgMusic]: ", str });
      AVSoundHelper.b(str, true);
      return;
      str = AvGameMusicPlayer.a(paramInt);
      AvGameMusicPlayer.a(str);
      str = this.jdField_a_of_type_JavaLangString + str + ".mp3";
    }
  }
  
  public void a(ITopic paramITopic, String paramString)
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    String str = AvGameMusicPlayer.a(paramITopic, paramString);
    paramITopic = str;
    if (TextUtils.isEmpty(str)) {
      paramITopic = this.jdField_a_of_type_JavaLangString + paramString + ".mp3";
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
    AVGameBusinessCtrl.b().b(this.jdField_a_of_type_ComTencentAvgameCallbackAVGameUIEventCallback);
    this.jdField_a_of_type_Boolean = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.gamelogic.gameres.AvGameSysMusicPlayer
 * JD-Core Version:    0.7.0.1
 */