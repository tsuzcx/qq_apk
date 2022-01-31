package com.tencent.mobileqq.antiphing;

import akiq;
import akit;
import android.content.Context;
import android.os.Handler;
import com.tencent.qphone.base.util.QLog;

public class AntiphishingUrlConfig$2
  implements Runnable
{
  public AntiphishingUrlConfig$2(akiq paramakiq, Context paramContext, String paramString1, String paramString2) {}
  
  public void run()
  {
    if (akiq.a() > 3000000L)
    {
      if (new akit(this.jdField_a_of_type_AndroidContentContext).a(this.jdField_a_of_type_JavaLangString, akiq.b(this.this$0), this.b, false))
      {
        QLog.d(akiq.a(this.this$0), 1, "Successfully Update Config!");
        akiq.a(this.this$0).sendEmptyMessage(akiq.a(this.this$0));
      }
    }
    else {
      return;
    }
    akiq.a(this.this$0).sendEmptyMessage(akiq.b(this.this$0));
    QLog.d(akiq.a(this.this$0), 1, "Update Config Error!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.antiphing.AntiphishingUrlConfig.2
 * JD-Core Version:    0.7.0.1
 */