package com.tencent.mobileqq.activity.specialcare;

import amjr;
import android.content.Context;
import java.io.File;

class QvipSpecialSoundManager$1
  implements Runnable
{
  QvipSpecialSoundManager$1(QvipSpecialSoundManager paramQvipSpecialSoundManager, amjr paramamjr) {}
  
  public void run()
  {
    if (this.this$0.a(this.a.c))
    {
      File localFile = new File(QvipSpecialSoundManager.a(this.this$0).getFilesDir(), this.a.c);
      if (localFile.exists()) {}
      for (long l = localFile.length();; l = 0L)
      {
        this.this$0.a(l);
        return;
      }
    }
    this.this$0.b("updateSpecialSound down fial, id=" + this.a.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.specialcare.QvipSpecialSoundManager.1
 * JD-Core Version:    0.7.0.1
 */