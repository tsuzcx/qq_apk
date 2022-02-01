package com.tencent.mobileqq.activity.aio.helper;

import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.multiaio.MultiAIOStarter;
import com.tencent.qphone.base.util.QLog;

class MultiWindowAIOHelper$1
  implements Runnable
{
  MultiWindowAIOHelper$1(MultiWindowAIOHelper paramMultiWindowAIOHelper) {}
  
  public void run()
  {
    AIOLongShotHelper localAIOLongShotHelper = (AIOLongShotHelper)MultiWindowAIOHelper.a(this.this$0).q(15);
    if ((!BaseChatItemLayout.ad) && (!localAIOLongShotHelper.c()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MultiWindowAIOHelper", 2, "AIO start multi window!");
      }
      MultiAIOStarter.a(MultiWindowAIOHelper.a(this.this$0).f, MultiWindowAIOHelper.a(this.this$0).ah.b, MultiWindowAIOHelper.a(this.this$0).ah.a, MultiWindowAIOHelper.a(this.this$0).ah.e, "open_from_aio");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.MultiWindowAIOHelper.1
 * JD-Core Version:    0.7.0.1
 */