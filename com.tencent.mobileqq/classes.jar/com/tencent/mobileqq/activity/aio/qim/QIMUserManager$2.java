package com.tencent.mobileqq.activity.aio.qim;

import aglv;
import com.tencent.qphone.base.util.QLog;

public class QIMUserManager$2
  implements Runnable
{
  public QIMUserManager$2(aglv paramaglv, String paramString1, String paramString2, boolean paramBoolean) {}
  
  public void run()
  {
    if (aglv.a(this.this$0, this.jdField_a_of_type_JavaLangString, this.b) == 0) {
      if (aglv.a(this.this$0, this.b))
      {
        aglv.a(this.this$0);
        aglv.a(this.this$0, 2);
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("QIMUserManager", 2, this.jdField_a_of_type_Boolean + " startDownLoadQimTheme QimIconsState " + aglv.a(this.this$0));
      }
      return;
      aglv.a(this.this$0, 4);
      continue;
      aglv.a(this.this$0, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.qim.QIMUserManager.2
 * JD-Core Version:    0.7.0.1
 */