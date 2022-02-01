package com.tencent.mobileqq.ark.API;

import android.support.v4.app.FragmentActivity;
import apsu;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.music.QQPlayerService;

public class ArkAppMusicModule$4
  implements Runnable
{
  public ArkAppMusicModule$4(apsu paramapsu) {}
  
  public void run()
  {
    BaseActivity localBaseActivity = BaseActivity.sTopActivity;
    if ((localBaseActivity instanceof FragmentActivity)) {
      QQPlayerService.b(localBaseActivity);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppMusicModule.4
 * JD-Core Version:    0.7.0.1
 */