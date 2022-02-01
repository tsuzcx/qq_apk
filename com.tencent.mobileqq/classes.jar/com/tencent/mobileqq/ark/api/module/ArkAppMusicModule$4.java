package com.tencent.mobileqq.ark.api.module;

import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.music.QQPlayerService;

class ArkAppMusicModule$4
  implements Runnable
{
  ArkAppMusicModule$4(ArkAppMusicModule paramArkAppMusicModule) {}
  
  public void run()
  {
    BaseActivity localBaseActivity = BaseActivity.sTopActivity;
    if ((localBaseActivity instanceof BaseActivity)) {
      QQPlayerService.b(localBaseActivity);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.api.module.ArkAppMusicModule.4
 * JD-Core Version:    0.7.0.1
 */