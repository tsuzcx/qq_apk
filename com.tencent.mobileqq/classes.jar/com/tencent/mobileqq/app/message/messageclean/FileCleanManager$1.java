package com.tencent.mobileqq.app.message.messageclean;

import akdb;
import com.tencent.qphone.base.util.QLog;

public class FileCleanManager$1
  implements Runnable
{
  public FileCleanManager$1(akdb paramakdb) {}
  
  public void run()
  {
    akdb.a(this.this$0);
    akdb.b(this.this$0);
    akdb.a(this.this$0, true);
    if (QLog.isColorLevel()) {
      QLog.e("FileCleanManager", 2, "load pics and videos finish");
    }
    akdb.c(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.message.messageclean.FileCleanManager.1
 * JD-Core Version:    0.7.0.1
 */