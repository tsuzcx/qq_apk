package com.tencent.mobileqq.activity.specialcare;

import android.content.Context;
import java.io.File;

class QvipSpecialSoundManagerImpl$1
  implements Runnable
{
  QvipSpecialSoundManagerImpl$1(QvipSpecialSoundManagerImpl paramQvipSpecialSoundManagerImpl, QvipSpecialSoundConfig.SpecialSound paramSpecialSound) {}
  
  public void run()
  {
    if (QvipSpecialSoundManagerImpl.a(this.this$0, this.a.e))
    {
      localObject = new File(QvipSpecialSoundManagerImpl.a(this.this$0).getFilesDir(), this.a.e);
      long l;
      if (((File)localObject).exists()) {
        l = ((File)localObject).length();
      } else {
        l = 0L;
      }
      QvipSpecialSoundManagerImpl.a(this.this$0, l);
      return;
    }
    Object localObject = this.this$0;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("updateSpecialSound down fial, id=");
    localStringBuilder.append(this.a.a);
    QvipSpecialSoundManagerImpl.b((QvipSpecialSoundManagerImpl)localObject, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.specialcare.QvipSpecialSoundManagerImpl.1
 * JD-Core Version:    0.7.0.1
 */