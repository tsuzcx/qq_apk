package com.tencent.mobileqq.ark.api.module;

import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.music.QQPlayerService;

class ArkAppMusicModule$3
  implements Runnable
{
  ArkAppMusicModule$3(ArkAppMusicModule paramArkAppMusicModule) {}
  
  public void run()
  {
    BaseActivity localBaseActivity = BaseActivity.sTopActivity;
    if ((localBaseActivity instanceof BaseActivity)) {
      QQPlayerService.a(localBaseActivity);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.api.module.ArkAppMusicModule.3
 * JD-Core Version:    0.7.0.1
 */