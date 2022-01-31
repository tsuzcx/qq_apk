package com.tencent.mobileqq.ark.API;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import ankt;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.music.SongInfo;
import com.tencent.mobileqq.musicgene.MusicPlayerActivity;
import com.tencent.qphone.base.util.BaseApplication;

public class ArkAppMusicModule$1
  implements Runnable
{
  public ArkAppMusicModule$1(ankt paramankt, SongInfo paramSongInfo) {}
  
  public void run()
  {
    BaseActivity localBaseActivity = BaseActivity.sTopActivity;
    if ((localBaseActivity instanceof FragmentActivity))
    {
      QQPlayerService.a(new Intent(BaseApplication.getContext(), MusicPlayerActivity.class));
      QQPlayerService.a(101);
      QQPlayerService.a(localBaseActivity, ankt.a(), new SongInfo[] { this.a });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppMusicModule.1
 * JD-Core Version:    0.7.0.1
 */