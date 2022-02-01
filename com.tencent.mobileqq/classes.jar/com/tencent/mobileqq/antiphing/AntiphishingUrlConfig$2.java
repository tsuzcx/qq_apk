package com.tencent.mobileqq.antiphing;

import almz;
import alnc;
import android.content.Context;
import android.os.Handler;
import com.tencent.qphone.base.util.QLog;

public class AntiphishingUrlConfig$2
  implements Runnable
{
  public AntiphishingUrlConfig$2(almz paramalmz, Context paramContext, String paramString1, String paramString2) {}
  
  public void run()
  {
    if (almz.a() > 3000000L)
    {
      if (new alnc(this.jdField_a_of_type_AndroidContentContext).a(this.jdField_a_of_type_JavaLangString, almz.b(this.this$0), this.b, false))
      {
        QLog.d(almz.a(this.this$0), 1, "Successfully Update Config!");
        almz.a(this.this$0).sendEmptyMessage(almz.a(this.this$0));
      }
    }
    else {
      return;
    }
    almz.a(this.this$0).sendEmptyMessage(almz.b(this.this$0));
    QLog.d(almz.a(this.this$0), 1, "Update Config Error!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.antiphing.AntiphishingUrlConfig.2
 * JD-Core Version:    0.7.0.1
 */