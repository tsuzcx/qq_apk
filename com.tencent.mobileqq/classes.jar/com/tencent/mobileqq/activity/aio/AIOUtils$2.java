package com.tencent.mobileqq.activity.aio;

import aewt;
import bgso;
import com.tencent.qphone.base.util.QLog;

final class AIOUtils$2
  implements bgso
{
  public void onResult(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("WebAccelerator", 2, "preStart QWeb Process");
      }
      aewt.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.AIOUtils.2
 * JD-Core Version:    0.7.0.1
 */