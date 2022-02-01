package com.tencent.mobileqq.ar.ARRecord;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;

final class ARRecordUtils$2
  implements Runnable
{
  ARRecordUtils$2(boolean paramBoolean, String paramString) {}
  
  public void run()
  {
    if (!this.a)
    {
      QQToast.makeText(BaseApplicationImpl.getContext(), this.b, 0).show();
      return;
    }
    QQToast.makeText(BaseApplicationImpl.getContext(), 2, this.b, 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRecord.ARRecordUtils.2
 * JD-Core Version:    0.7.0.1
 */