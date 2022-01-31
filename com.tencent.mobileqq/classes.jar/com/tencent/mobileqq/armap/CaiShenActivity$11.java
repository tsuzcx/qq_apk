package com.tencent.mobileqq.armap;

import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

class CaiShenActivity$11
  implements Runnable
{
  CaiShenActivity$11(CaiShenActivity paramCaiShenActivity) {}
  
  public void run()
  {
    try
    {
      int i = JniCommon.nativeGetPartTwoIndex();
      String str;
      if (this.this$0.openFailed) {
        str = "0";
      }
      for (;;)
      {
        ReportController.b(null, "dc01440", "", "", "0X8007A44", "0X8007A44", 0, 0, String.valueOf(i), str, "", "");
        return;
        if (this.this$0.openSuccess) {
          str = "1";
        } else {
          str = "2";
        }
      }
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      localUnsatisfiedLinkError.printStackTrace();
      if (QLog.isColorLevel())
      {
        QLog.e("CaiShenActivity", 2, "finish data report", localUnsatisfiedLinkError);
        return;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.e("CaiShenActivity", 2, "finish data report", localException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.armap.CaiShenActivity.11
 * JD-Core Version:    0.7.0.1
 */