package com.tencent.mobileqq.activity.specialcare;

import java.util.HashMap;
import mqq.app.AppRuntime;

class QvipSpecialSoundManagerImpl$2
  implements Runnable
{
  QvipSpecialSoundManagerImpl$2(QvipSpecialSoundManagerImpl paramQvipSpecialSoundManagerImpl, CallBack paramCallBack) {}
  
  public void run()
  {
    Object localObject = this.this$0.a();
    QvipSpecialSoundManagerImpl.c(this.this$0, (String)localObject);
    localObject = QvipSpecialConstants.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("key_special_sound_list");
    localStringBuilder.append(QvipSpecialSoundManagerImpl.b(this.this$0).getCurrentAccountUin());
    boolean bool = ((HashMap)localObject).containsKey(localStringBuilder.toString());
    QvipSpecialSoundManagerImpl.a(this.this$0, this.a, bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.specialcare.QvipSpecialSoundManagerImpl.2
 * JD-Core Version:    0.7.0.1
 */