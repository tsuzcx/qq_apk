package com.tencent.mobileqq.antiphing;

import amgl;
import amgo;
import android.content.Context;
import android.os.Handler;
import com.tencent.qphone.base.util.QLog;

public class AntiphishingUrlConfig$2
  implements Runnable
{
  public AntiphishingUrlConfig$2(amgl paramamgl, Context paramContext, String paramString1, String paramString2) {}
  
  public void run()
  {
    if (amgl.a() > 3000000L)
    {
      if (new amgo(this.jdField_a_of_type_AndroidContentContext).a(this.jdField_a_of_type_JavaLangString, amgl.b(this.this$0), this.b, false))
      {
        QLog.d(amgl.a(this.this$0), 1, "Successfully Update Config!");
        amgl.a(this.this$0).sendEmptyMessage(amgl.a(this.this$0));
      }
    }
    else {
      return;
    }
    amgl.a(this.this$0).sendEmptyMessage(amgl.b(this.this$0));
    QLog.d(amgl.a(this.this$0), 1, "Update Config Error!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.antiphing.AntiphishingUrlConfig.2
 * JD-Core Version:    0.7.0.1
 */