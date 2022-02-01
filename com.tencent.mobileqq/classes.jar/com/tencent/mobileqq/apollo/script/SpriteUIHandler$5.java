package com.tencent.mobileqq.apollo.script;

import android.os.Message;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.apollo.script.api.ISpriteCommFunc;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class SpriteUIHandler$5
  implements Runnable
{
  SpriteUIHandler$5(SpriteUIHandler paramSpriteUIHandler, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    try
    {
      MqqHandler localMqqHandler = SpriteUIHandler.c(this.this$0).m().j();
      int i;
      if (1 == this.a)
      {
        long l = DeviceInfoUtil.C();
        double d = (float)l / 7.0F;
        Double.isNaN(d);
        i = (int)(d / 2.84D);
        localMqqHandler.obtainMessage(47, i + 40, 0).sendToTarget();
        return;
      }
      if (2 == this.a)
      {
        i = this.b;
        localMqqHandler.obtainMessage(47, (int)((float)DeviceInfoUtil.C() / 7.0F) + (i + 40), 0).sendToTarget();
        return;
      }
      if (3 == this.a)
      {
        if ((((ISpriteCommFunc)QRoute.api(ISpriteCommFunc.class)).isSpriteHidden(SpriteUIHandler.c(this.this$0).l())) && (((ISpriteCommFunc)QRoute.api(ISpriteCommFunc.class)).isSpriteHiddenForBusiness(SpriteUIHandler.c(this.this$0).l(), "select_more_msg")))
        {
          if (!QLog.isColorLevel()) {
            return;
          }
          QLog.d("[cmshow][scripted]SpriteUIHandler", 2, "addOrRemoveMargin hidden but not should remove margin");
          return;
        }
        localMqqHandler.sendEmptyMessage(62);
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.e("[cmshow][scripted]SpriteUIHandler", 1, localException, new Object[0]);
    }
    return;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.script.SpriteUIHandler.5
 * JD-Core Version:    0.7.0.1
 */