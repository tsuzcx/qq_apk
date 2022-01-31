package com.tencent.mobileqq.app.message.messageclean;

import amhr;
import com.tencent.qphone.base.util.QLog;

public class FileCleanManager$1
  implements Runnable
{
  public FileCleanManager$1(amhr paramamhr) {}
  
  public void run()
  {
    amhr.a(this.this$0);
    amhr.b(this.this$0);
    amhr.a(this.this$0, true);
    if (QLog.isColorLevel()) {
      QLog.e("FileCleanManager", 2, "load pics and videos finish");
    }
    amhr.c(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.message.messageclean.FileCleanManager.1
 * JD-Core Version:    0.7.0.1
 */