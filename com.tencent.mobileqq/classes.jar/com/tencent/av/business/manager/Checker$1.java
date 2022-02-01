package com.tencent.av.business.manager;

import com.tencent.mobileqq.utils.FileUtils;

class Checker$1
  implements Runnable
{
  Checker$1(Checker paramChecker, Checker.ItemRecord paramItemRecord, String paramString) {}
  
  public void run()
  {
    if (FileUtils.fileExists(this.a.c)) {
      this.this$0.a(this.b, this.a);
    }
    Checker.a(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.business.manager.Checker.1
 * JD-Core Version:    0.7.0.1
 */