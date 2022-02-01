package com.tencent.mobileqq.activity.aio.qim;

import aifn;
import com.tencent.qphone.base.util.QLog;

public class QIMUserManager$2
  implements Runnable
{
  public QIMUserManager$2(aifn paramaifn, String paramString1, String paramString2, boolean paramBoolean) {}
  
  public void run()
  {
    if (aifn.a(this.this$0, this.jdField_a_of_type_JavaLangString, this.b) == 0) {
      if (aifn.a(this.this$0, this.b))
      {
        aifn.a(this.this$0);
        aifn.a(this.this$0, 2);
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("QIMUserManager", 2, this.jdField_a_of_type_Boolean + " startDownLoadQimTheme QimIconsState " + aifn.a(this.this$0));
      }
      return;
      aifn.a(this.this$0, 4);
      continue;
      aifn.a(this.this$0, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.qim.QIMUserManager.2
 * JD-Core Version:    0.7.0.1
 */