package com.tencent.mobileqq.activity.aio.tim;

import aexi;
import com.tencent.qphone.base.util.QLog;

public class TIMUserManager$2
  implements Runnable
{
  public TIMUserManager$2(aexi paramaexi, String paramString1, String paramString2, boolean paramBoolean) {}
  
  public void run()
  {
    if (aexi.a(this.this$0, this.jdField_a_of_type_JavaLangString, this.b) == 0) {
      if (aexi.a(this.this$0, this.b))
      {
        aexi.a(this.this$0);
        aexi.a(this.this$0, 2);
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("TIMUserManager", 2, this.jdField_a_of_type_Boolean + " startDownLoadTimTheme TimIconsState " + aexi.a(this.this$0));
      }
      return;
      aexi.a(this.this$0, 4);
      continue;
      aexi.a(this.this$0, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.tim.TIMUserManager.2
 * JD-Core Version:    0.7.0.1
 */