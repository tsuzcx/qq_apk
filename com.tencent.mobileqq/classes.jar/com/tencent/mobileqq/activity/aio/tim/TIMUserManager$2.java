package com.tencent.mobileqq.activity.aio.tim;

import aexk;
import com.tencent.qphone.base.util.QLog;

public class TIMUserManager$2
  implements Runnable
{
  public TIMUserManager$2(aexk paramaexk, String paramString1, String paramString2, boolean paramBoolean) {}
  
  public void run()
  {
    if (aexk.a(this.this$0, this.jdField_a_of_type_JavaLangString, this.b) == 0) {
      if (aexk.a(this.this$0, this.b))
      {
        aexk.a(this.this$0);
        aexk.a(this.this$0, 2);
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("TIMUserManager", 2, this.jdField_a_of_type_Boolean + " startDownLoadTimTheme TimIconsState " + aexk.a(this.this$0));
      }
      return;
      aexk.a(this.this$0, 4);
      continue;
      aexk.a(this.this$0, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.tim.TIMUserManager.2
 * JD-Core Version:    0.7.0.1
 */