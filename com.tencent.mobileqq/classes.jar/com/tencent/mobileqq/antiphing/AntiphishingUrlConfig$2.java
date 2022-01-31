package com.tencent.mobileqq.antiphing;

import aieo;
import aier;
import android.content.Context;
import android.os.Handler;
import com.tencent.qphone.base.util.QLog;

public class AntiphishingUrlConfig$2
  implements Runnable
{
  public AntiphishingUrlConfig$2(aieo paramaieo, Context paramContext, String paramString1, String paramString2) {}
  
  public void run()
  {
    if (aieo.a() > 3000000L)
    {
      if (new aier(this.jdField_a_of_type_AndroidContentContext).a(this.jdField_a_of_type_JavaLangString, aieo.b(this.this$0), this.b, false))
      {
        QLog.d(aieo.a(this.this$0), 1, "Successfully Update Config!");
        aieo.a(this.this$0).sendEmptyMessage(aieo.a(this.this$0));
      }
    }
    else {
      return;
    }
    aieo.a(this.this$0).sendEmptyMessage(aieo.b(this.this$0));
    QLog.d(aieo.a(this.this$0), 1, "Update Config Error!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.antiphing.AntiphishingUrlConfig.2
 * JD-Core Version:    0.7.0.1
 */