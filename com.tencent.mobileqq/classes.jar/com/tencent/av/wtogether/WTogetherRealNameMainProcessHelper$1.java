package com.tencent.av.wtogether;

import com.tencent.mobileqq.app.ConfigObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

class WTogetherRealNameMainProcessHelper$1
  extends ConfigObserver
{
  WTogetherRealNameMainProcessHelper$1(WTogetherRealNameMainProcessHelper paramWTogetherRealNameMainProcessHelper) {}
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("WTogetherRealNameMainProcessHelper", 2, "onGetRealNameStatusForAV authed:=" + paramBoolean);
    }
    WTogetherRealNameMainProcessHelper.a(this.a, paramBoolean);
    WTogetherRealNameMainProcessHelper.a(this.a).removeObserver(WTogetherRealNameMainProcessHelper.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.wtogether.WTogetherRealNameMainProcessHelper.1
 * JD-Core Version:    0.7.0.1
 */