package com.tencent.mobileqq.antiphing;

import aknf;
import akni;
import android.content.Context;
import android.os.Handler;
import com.tencent.qphone.base.util.QLog;

public class AntiphishingUrlConfig$2
  implements Runnable
{
  public AntiphishingUrlConfig$2(aknf paramaknf, Context paramContext, String paramString1, String paramString2) {}
  
  public void run()
  {
    if (aknf.a() > 3000000L)
    {
      if (new akni(this.jdField_a_of_type_AndroidContentContext).a(this.jdField_a_of_type_JavaLangString, aknf.b(this.this$0), this.b, false))
      {
        QLog.d(aknf.a(this.this$0), 1, "Successfully Update Config!");
        aknf.a(this.this$0).sendEmptyMessage(aknf.a(this.this$0));
      }
    }
    else {
      return;
    }
    aknf.a(this.this$0).sendEmptyMessage(aknf.b(this.this$0));
    QLog.d(aknf.a(this.this$0), 1, "Update Config Error!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.antiphing.AntiphishingUrlConfig.2
 * JD-Core Version:    0.7.0.1
 */