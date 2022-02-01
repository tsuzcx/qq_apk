package com.tencent.mobileqq.antiphing;

import amla;
import amld;
import android.content.Context;
import android.os.Handler;
import com.tencent.qphone.base.util.QLog;

public class AntiphishingUrlConfig$2
  implements Runnable
{
  public AntiphishingUrlConfig$2(amla paramamla, Context paramContext, String paramString1, String paramString2) {}
  
  public void run()
  {
    if (amla.a() > 3000000L)
    {
      if (new amld(this.jdField_a_of_type_AndroidContentContext).a(this.jdField_a_of_type_JavaLangString, amla.b(this.this$0), this.b, false))
      {
        QLog.d(amla.a(this.this$0), 1, "Successfully Update Config!");
        amla.a(this.this$0).sendEmptyMessage(amla.a(this.this$0));
      }
    }
    else {
      return;
    }
    amla.a(this.this$0).sendEmptyMessage(amla.b(this.this$0));
    QLog.d(amla.a(this.this$0), 1, "Update Config Error!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.antiphing.AntiphishingUrlConfig.2
 * JD-Core Version:    0.7.0.1
 */