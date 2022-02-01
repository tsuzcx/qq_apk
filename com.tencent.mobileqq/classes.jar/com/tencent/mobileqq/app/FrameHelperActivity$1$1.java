package com.tencent.mobileqq.app;

import com.tencent.mobileqq.nearby.redtouch.LocalRedTouchManager;
import com.tencent.mobileqq.nearby.redtouch.RedTouchItem;
import com.tencent.mobileqq.statistics.ReportController;
import mqq.app.AppRuntime;

class FrameHelperActivity$1$1
  implements Runnable
{
  FrameHelperActivity$1$1(FrameHelperActivity.1 param1) {}
  
  public void run()
  {
    if (this.a.a.C() != null)
    {
      if (this.a.a.C().getAppRuntime() == null) {
        return;
      }
      Object localObject = (LocalRedTouchManager)this.a.a.C().getAppRuntime().getManager(QQManagerFactory.LOCAL_REDTOUCH_MANAGER);
      RedTouchItem localRedTouchItem1 = ((LocalRedTouchManager)localObject).a(10015);
      RedTouchItem localRedTouchItem2 = ((LocalRedTouchManager)localObject).a(10016);
      RedTouchItem localRedTouchItem3 = ((LocalRedTouchManager)localObject).a(-7);
      if ((localRedTouchItem3 != null) && (localRedTouchItem3.unReadFlag) && ((localRedTouchItem1 != null) || (localRedTouchItem2 != null)))
      {
        int i = ((LocalRedTouchManager)localObject).d();
        localObject = null;
        if (i != 3) {
          if (i != 4) {
            if (i != 5) {
              break label143;
            }
          }
        }
        for (;;)
        {
          localObject = "0X80073B7";
          continue;
          localObject = "0X80073B3";
          continue;
          localObject = "0X80073B1";
        }
        label143:
        if (localObject != null) {
          ReportController.b(this.a.a.C().getAppRuntime(), "dc00898", "", "", (String)localObject, (String)localObject, 0, 0, "", "", "", "");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.FrameHelperActivity.1.1
 * JD-Core Version:    0.7.0.1
 */