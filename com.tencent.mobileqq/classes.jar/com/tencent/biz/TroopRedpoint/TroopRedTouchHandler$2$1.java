package com.tencent.biz.TroopRedpoint;

import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.teamwork.api.ITeamWorkUtilsTemp;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import tencent.im.oidb.cmd0x791.oidb_0x791.RedDotInfo;

class TroopRedTouchHandler$2$1
  implements Runnable
{
  TroopRedTouchHandler$2$1(TroopRedTouchHandler.2 param2, boolean paramBoolean, Bundle paramBundle) {}
  
  public void run()
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("getRedPointInfo onReceive :");
      ((StringBuilder)localObject1).append(this.a);
      QLog.d("TroopRedTouchHandler", 2, ((StringBuilder)localObject1).toString());
    }
    if (this.a)
    {
      localObject1 = this.b;
      if (localObject1 != null)
      {
        localObject1 = ((Bundle)localObject1).getByteArray("data");
        int j;
        if ((this.c.a.contains(Integer.valueOf(46))) && (((ITeamWorkUtilsTemp)QRoute.api(ITeamWorkUtilsTemp.class)).isTencentDocsAssistantEnable(TroopRedTouchHandler.b(this.c.b)))) {
          j = 1;
        } else {
          j = 0;
        }
        int i = -1;
        Object localObject2;
        if (j != 0)
        {
          localObject2 = ((TroopRedTouchManager)TroopRedTouchHandler.b(this.c.b).getManager(QQManagerFactory.MGR_RED_TOUCH_EX)).a(46, false);
          if ((localObject2 != null) && (((oidb_0x791.RedDotInfo)localObject2).uint32_last_time.has())) {
            i = ((oidb_0x791.RedDotInfo)localObject2).uint32_last_time.get();
          } else {
            i = 0;
          }
        }
        if ((localObject1 != null) && (TroopRedTouchHandler.a(TroopRedTouchHandler.b(this.c.b), new ArrayList(this.c.a), (byte[])localObject1)))
        {
          this.c.b.a = 1;
          if (QLog.isColorLevel()) {
            QLog.i("storyRedDotDebug", 2, "getRedPointAsync");
          }
          this.c.b.notifyUI(105, true, null);
          if (j != 0)
          {
            localObject1 = ((TroopRedTouchManager)TroopRedTouchHandler.b(this.c.b).getManager(QQManagerFactory.MGR_RED_TOUCH_EX)).a(46, false);
            if ((localObject1 != null) && (QLog.isColorLevel()))
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("getRedPointInfoAsync enableTencentDocsAssistant:");
              ((StringBuilder)localObject2).append(TroopRedTouchManager.b((oidb_0x791.RedDotInfo)localObject1));
              QLog.d("TroopRedTouchHandlerQ.qqstory.redPoint", 2, ((StringBuilder)localObject2).toString());
            }
            TroopRedTouchHandler.a(TroopRedTouchHandler.b(this.c.b), (oidb_0x791.RedDotInfo)localObject1, i, false);
          }
        }
        else
        {
          this.c.b.a = 2;
          if (QLog.isColorLevel()) {
            QLog.e("TroopRedTouchHandler", 2, "getRedPointInfo success data is null");
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.TroopRedpoint.TroopRedTouchHandler.2.1
 * JD-Core Version:    0.7.0.1
 */