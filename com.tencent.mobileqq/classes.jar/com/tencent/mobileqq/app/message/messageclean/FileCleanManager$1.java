package com.tencent.mobileqq.app.message.messageclean;

import akrm;
import com.tencent.qphone.base.util.QLog;

public class FileCleanManager$1
  implements Runnable
{
  public FileCleanManager$1(akrm paramakrm) {}
  
  public void run()
  {
    akrm.a(this.this$0);
    akrm.b(this.this$0);
    akrm.a(this.this$0, true);
    if (QLog.isColorLevel()) {
      QLog.e("FileCleanManager", 2, "load pics and videos finish");
    }
    akrm.c(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.message.messageclean.FileCleanManager.1
 * JD-Core Version:    0.7.0.1
 */