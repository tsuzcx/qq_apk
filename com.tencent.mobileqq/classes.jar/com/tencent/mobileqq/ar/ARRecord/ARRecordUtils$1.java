package com.tencent.mobileqq.ar.ARRecord;

import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;

final class ARRecordUtils$1
  implements Runnable
{
  ARRecordUtils$1(String paramString1, String paramString2) {}
  
  public void run()
  {
    try
    {
      DialogUtil.a(ARVideoRecordUIControllerImpl.a().a(), 230, this.a, this.b, "", HardCodeUtil.a(2131700959), new ARRecordUtils.1.1(this), null).show();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRecord.ARRecordUtils.1
 * JD-Core Version:    0.7.0.1
 */