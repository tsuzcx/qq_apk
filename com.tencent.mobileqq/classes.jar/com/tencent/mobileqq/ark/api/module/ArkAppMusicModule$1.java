package com.tencent.mobileqq.ark.api.module;

import android.content.Intent;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.music.SongInfo;
import com.tencent.mobileqq.musicgene.MusicPlayerActivity;
import com.tencent.qphone.base.util.BaseApplication;

class ArkAppMusicModule$1
  implements Runnable
{
  ArkAppMusicModule$1(ArkAppMusicModule paramArkAppMusicModule, SongInfo paramSongInfo) {}
  
  public void run()
  {
    BaseActivity localBaseActivity = BaseActivity.sTopActivity;
    if ((localBaseActivity instanceof BaseActivity))
    {
      QQPlayerService.a(new Intent(BaseApplication.getContext(), MusicPlayerActivity.class));
      QQPlayerService.a(101);
      QQPlayerService.a(localBaseActivity, ArkAppMusicModule.a(), new SongInfo[] { this.a });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.api.module.ArkAppMusicModule.1
 * JD-Core Version:    0.7.0.1
 */