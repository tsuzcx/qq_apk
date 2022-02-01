package com.tencent.av.wtogether.util;

import com.tencent.qphone.base.util.QLog;

class WTogetherUtil$2$2
  implements Runnable
{
  WTogetherUtil$2$2(WTogetherUtil.2 param2, Exception paramException) {}
  
  public void run()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("safetyNewReport exception1");
      localStringBuilder.append(this.a.getMessage());
      QLog.d("WTogether", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.wtogether.util.WTogetherUtil.2.2
 * JD-Core Version:    0.7.0.1
 */