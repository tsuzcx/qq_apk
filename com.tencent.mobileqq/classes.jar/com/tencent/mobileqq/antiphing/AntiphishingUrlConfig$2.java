package com.tencent.mobileqq.antiphing;

import airf;
import airi;
import android.content.Context;
import android.os.Handler;
import com.tencent.qphone.base.util.QLog;

public class AntiphishingUrlConfig$2
  implements Runnable
{
  public AntiphishingUrlConfig$2(airf paramairf, Context paramContext, String paramString1, String paramString2) {}
  
  public void run()
  {
    if (airf.a() > 3000000L)
    {
      if (new airi(this.jdField_a_of_type_AndroidContentContext).a(this.jdField_a_of_type_JavaLangString, airf.b(this.this$0), this.b, false))
      {
        QLog.d(airf.a(this.this$0), 1, "Successfully Update Config!");
        airf.a(this.this$0).sendEmptyMessage(airf.a(this.this$0));
      }
    }
    else {
      return;
    }
    airf.a(this.this$0).sendEmptyMessage(airf.b(this.this$0));
    QLog.d(airf.a(this.this$0), 1, "Update Config Error!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.antiphing.AntiphishingUrlConfig.2
 * JD-Core Version:    0.7.0.1
 */