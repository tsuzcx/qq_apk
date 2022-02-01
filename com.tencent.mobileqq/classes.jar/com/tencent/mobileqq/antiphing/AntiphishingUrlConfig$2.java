package com.tencent.mobileqq.antiphing;

import android.content.Context;
import android.os.Handler;
import com.tencent.qphone.base.util.QLog;

class AntiphishingUrlConfig$2
  implements Runnable
{
  AntiphishingUrlConfig$2(AntiphishingUrlConfig paramAntiphishingUrlConfig, Context paramContext, String paramString1, String paramString2) {}
  
  public void run()
  {
    if (AntiphishingUrlConfig.a() > 3000000L)
    {
      if (new DownloadFileHelper(this.jdField_a_of_type_AndroidContentContext).a(this.jdField_a_of_type_JavaLangString, AntiphishingUrlConfig.b(this.this$0), this.b, false))
      {
        QLog.d(AntiphishingUrlConfig.a(this.this$0), 1, "Successfully Update Config!");
        AntiphishingUrlConfig.a(this.this$0).sendEmptyMessage(AntiphishingUrlConfig.a(this.this$0));
      }
    }
    else {
      return;
    }
    AntiphishingUrlConfig.a(this.this$0).sendEmptyMessage(AntiphishingUrlConfig.b(this.this$0));
    QLog.d(AntiphishingUrlConfig.a(this.this$0), 1, "Update Config Error!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.antiphing.AntiphishingUrlConfig.2
 * JD-Core Version:    0.7.0.1
 */