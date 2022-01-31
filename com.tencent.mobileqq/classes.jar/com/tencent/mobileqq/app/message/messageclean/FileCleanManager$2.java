package com.tencent.mobileqq.app.message.messageclean;

import ammg;
import com.tencent.qphone.base.util.QLog;

public class FileCleanManager$2
  implements Runnable
{
  public FileCleanManager$2(ammg paramammg) {}
  
  public void run()
  {
    ammg.d(this.this$0);
    ammg.b(this.this$0, true);
    if (QLog.isColorLevel()) {
      QLog.e("FileCleanManager", 2, "load qq files finish");
    }
    ammg.c(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.message.messageclean.FileCleanManager.2
 * JD-Core Version:    0.7.0.1
 */