package com.tencent.mobileqq.activity.aio.tim;

import aemp;
import com.tencent.qphone.base.util.QLog;

public class TIMUserManager$2
  implements Runnable
{
  public TIMUserManager$2(aemp paramaemp, String paramString1, String paramString2, boolean paramBoolean) {}
  
  public void run()
  {
    if (aemp.a(this.this$0, this.jdField_a_of_type_JavaLangString, this.b) == 0) {
      if (aemp.a(this.this$0, this.b))
      {
        aemp.a(this.this$0);
        aemp.a(this.this$0, 2);
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("TIMUserManager", 2, this.jdField_a_of_type_Boolean + " startDownLoadTimTheme TimIconsState " + aemp.a(this.this$0));
      }
      return;
      aemp.a(this.this$0, 4);
      continue;
      aemp.a(this.this$0, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.tim.TIMUserManager.2
 * JD-Core Version:    0.7.0.1
 */