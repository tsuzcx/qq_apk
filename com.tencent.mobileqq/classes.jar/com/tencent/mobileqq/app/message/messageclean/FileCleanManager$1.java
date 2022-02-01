package com.tencent.mobileqq.app.message.messageclean;

import com.tencent.qphone.base.util.QLog;

class FileCleanManager$1
  implements Runnable
{
  FileCleanManager$1(FileCleanManager paramFileCleanManager) {}
  
  public void run()
  {
    FileCleanManager.a(this.this$0);
    FileCleanManager.b(this.this$0);
    FileCleanManager.a(this.this$0, true);
    if (QLog.isColorLevel()) {
      QLog.e("FileCleanManager", 2, "load pics and videos finish");
    }
    FileCleanManager.c(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.message.messageclean.FileCleanManager.1
 * JD-Core Version:    0.7.0.1
 */