package com.tencent.av.wtogether;

import com.tencent.mobileqq.app.ConfigObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

class WTogetherRealNameMainProcessHelper$1
  extends ConfigObserver
{
  WTogetherRealNameMainProcessHelper$1(WTogetherRealNameMainProcessHelper paramWTogetherRealNameMainProcessHelper) {}
  
  protected void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onGetRealNameStatusForAV authed:=");
      localStringBuilder.append(paramBoolean);
      QLog.i("WTogetherRealNameMainProcessHelper", 2, localStringBuilder.toString());
    }
    WTogetherRealNameMainProcessHelper.a(this.a, paramBoolean);
    WTogetherRealNameMainProcessHelper.b(this.a).removeObserver(WTogetherRealNameMainProcessHelper.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.wtogether.WTogetherRealNameMainProcessHelper.1
 * JD-Core Version:    0.7.0.1
 */