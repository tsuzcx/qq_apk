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
    if (AntiphishingUrlConfig.c() > 3000000L)
    {
      if (new DownloadFileHelper(this.a).a(this.b, AntiphishingUrlConfig.d(this.this$0), this.c, false))
      {
        QLog.d(AntiphishingUrlConfig.b(this.this$0), 1, "Successfully Update Config!");
        AntiphishingUrlConfig.e(this.this$0).sendEmptyMessage(AntiphishingUrlConfig.a(this.this$0));
        return;
      }
      AntiphishingUrlConfig.e(this.this$0).sendEmptyMessage(AntiphishingUrlConfig.c(this.this$0));
      QLog.d(AntiphishingUrlConfig.b(this.this$0), 1, "Update Config Error!");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.antiphing.AntiphishingUrlConfig.2
 * JD-Core Version:    0.7.0.1
 */