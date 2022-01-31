package com.tencent.mobileqq.ark.API;

import android.support.v4.app.FragmentActivity;
import ankt;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.music.QQPlayerService;

public class ArkAppMusicModule$3
  implements Runnable
{
  public ArkAppMusicModule$3(ankt paramankt) {}
  
  public void run()
  {
    BaseActivity localBaseActivity = BaseActivity.sTopActivity;
    if ((localBaseActivity instanceof FragmentActivity)) {
      QQPlayerService.a(localBaseActivity);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppMusicModule.3
 * JD-Core Version:    0.7.0.1
 */