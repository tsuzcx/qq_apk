package com.tencent.mobileqq.activity.main;

import aiez;
import alpk;
import alzc;
import amqe;
import android.os.Handler;
import android.os.Message;
import avsm;
import axlx;
import bddf;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.redtouch.RedTouchItem;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.qphone.base.util.QLog;

public class MainAssistObserver$12
  implements Runnable
{
  public MainAssistObserver$12(aiez paramaiez, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    int j = 2;
    for (;;)
    {
      Object localObject2;
      try
      {
        axlx localaxlx = (axlx)this.a.getManager(36);
        BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo = localaxlx.a(1);
        if (localRedTypeInfo != null) {
          break label398;
        }
        avsm localavsm = (avsm)this.a.getManager(160);
        localavsm.a(100601, false);
        boolean bool1 = localavsm.a(10015, false);
        boolean bool2 = localavsm.a(10016, false);
        bddf.c(this.a);
        localObject2 = localavsm.a(-3);
        if (!localavsm.a((RedTouchItem)localObject2, true)) {
          break label398;
        }
        localRedTypeInfo = new BusinessInfoCheckUpdate.RedTypeInfo();
        if ((bool1 | bool2)) {
          aiez.a(this.this$0, this.a);
        }
        QLog.d("MainAssistObserver", 1, "updateTabSettingNotify me count=" + ((RedTouchItem)localObject2).count);
        i = 1;
        if ((localRedTypeInfo != null) || (!amqe.a(this.a))) {
          break label395;
        }
        localRedTypeInfo = new BusinessInfoCheckUpdate.RedTypeInfo();
        i = j;
        localObject2 = (alpk)this.a.a(2);
        if ((localRedTypeInfo != null) || (((alpk)localObject2).b()) || (!((alpk)localObject2).a())) {
          break label390;
        }
        localRedTypeInfo = new BusinessInfoCheckUpdate.RedTypeInfo();
        j = 3;
        i = j;
        localObject2 = localRedTypeInfo;
        if (localRedTypeInfo == null)
        {
          i = j;
          localObject2 = localRedTypeInfo;
          if (alzc.a(1))
          {
            localObject2 = new BusinessInfoCheckUpdate.RedTypeInfo();
            i = 4;
          }
        }
        j = localaxlx.b(1);
        if (localObject2 != null) {
          ((BusinessInfoCheckUpdate.RedTypeInfo)localObject2).red_type.set(0);
        }
        if (j > 0)
        {
          localRedTypeInfo = new BusinessInfoCheckUpdate.RedTypeInfo();
          localRedTypeInfo.red_type.set(0);
          i = 5;
          if (QLog.isColorLevel()) {
            QLog.d("MainAssistObserver", 2, "updateTabSettingNotify: showRedFromWhere=" + i);
          }
          localObject2 = this.this$0.a.obtainMessage(0);
          ((Message)localObject2).obj = localRedTypeInfo;
          this.this$0.a.sendMessage((Message)localObject2);
          return;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return;
      }
      Object localObject1 = localObject2;
      continue;
      label390:
      j = i;
      continue;
      label395:
      continue;
      label398:
      int i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.main.MainAssistObserver.12
 * JD-Core Version:    0.7.0.1
 */