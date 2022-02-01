package com.tencent.mobileqq.app.message.messageclean;

import aouj;
import com.tencent.qphone.base.util.QLog;

public class FileCleanManager$1
  implements Runnable
{
  public FileCleanManager$1(aouj paramaouj) {}
  
  public void run()
  {
    aouj.a(this.this$0);
    aouj.b(this.this$0);
    aouj.a(this.this$0, true);
    if (QLog.isColorLevel()) {
      QLog.e("FileCleanManager", 2, "load pics and videos finish");
    }
    aouj.c(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.message.messageclean.FileCleanManager.1
 * JD-Core Version:    0.7.0.1
 */