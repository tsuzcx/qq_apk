package com.tencent.mobileqq.activity.specialcare;

import com.tencent.mobileqq.utils.FileUtils;

class QvipSpecialSoundManager$MoveConfig
  implements Runnable
{
  private String a;
  
  private QvipSpecialSoundManager$MoveConfig(String paramString)
  {
    this.a = paramString;
  }
  
  public void run()
  {
    FileUtils.b(this.a + "https://i.gtimg.cn/club/moblie/special_sound/new_config.json", this.a + "pddata/vas/special_remind/new_config.json");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.specialcare.QvipSpecialSoundManager.MoveConfig
 * JD-Core Version:    0.7.0.1
 */