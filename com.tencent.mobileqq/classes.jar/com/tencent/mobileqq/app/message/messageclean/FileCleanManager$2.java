package com.tencent.mobileqq.app.message.messageclean;

import com.tencent.qphone.base.util.QLog;

class FileCleanManager$2
  implements Runnable
{
  FileCleanManager$2(FileCleanManager paramFileCleanManager) {}
  
  public void run()
  {
    FileCleanManager.d(this.this$0);
    FileCleanManager.b(this.this$0, true);
    if (QLog.isColorLevel()) {
      QLog.e("FileCleanManager", 2, "load qq files finish");
    }
    FileCleanManager.c(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.message.messageclean.FileCleanManager.2
 * JD-Core Version:    0.7.0.1
 */