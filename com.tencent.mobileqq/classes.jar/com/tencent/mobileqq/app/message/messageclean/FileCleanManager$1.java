package com.tencent.mobileqq.app.message.messageclean;

import aoqc;
import com.tencent.qphone.base.util.QLog;

public class FileCleanManager$1
  implements Runnable
{
  public FileCleanManager$1(aoqc paramaoqc) {}
  
  public void run()
  {
    aoqc.a(this.this$0);
    aoqc.b(this.this$0);
    aoqc.a(this.this$0, true);
    if (QLog.isColorLevel()) {
      QLog.e("FileCleanManager", 2, "load pics and videos finish");
    }
    aoqc.c(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.message.messageclean.FileCleanManager.1
 * JD-Core Version:    0.7.0.1
 */