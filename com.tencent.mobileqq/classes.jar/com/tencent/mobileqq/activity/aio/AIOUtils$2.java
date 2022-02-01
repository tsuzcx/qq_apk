package com.tencent.mobileqq.activity.aio;

import afoe;
import bide;
import com.tencent.qphone.base.util.QLog;

final class AIOUtils$2
  implements bide
{
  public void onResult(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("WebAccelerator", 2, "preStart QWeb Process");
      }
      afoe.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.AIOUtils.2
 * JD-Core Version:    0.7.0.1
 */