package com.tencent.mobileqq.activity.specialcare;

import aijc;
import com.tencent.common.app.AppInterface;
import java.util.HashMap;

class QvipSpecialSoundManager$2
  implements Runnable
{
  QvipSpecialSoundManager$2(QvipSpecialSoundManager paramQvipSpecialSoundManager, aijc paramaijc) {}
  
  public void run()
  {
    String str = QvipSpecialSoundManager.a(this.this$0);
    this.this$0.a(str);
    boolean bool = QvipSpecialSoundManager.a.containsKey("key_special_sound_list" + QvipSpecialSoundManager.a(this.this$0).getCurrentAccountUin());
    QvipSpecialSoundManager.a(this.this$0, this.a, bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.specialcare.QvipSpecialSoundManager.2
 * JD-Core Version:    0.7.0.1
 */