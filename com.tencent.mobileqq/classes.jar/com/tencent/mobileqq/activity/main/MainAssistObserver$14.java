package com.tencent.mobileqq.activity.main;

import akam;
import android.os.Handler;
import android.os.Message;
import anri;
import aoae;
import aymd;
import bbbq;
import bgvx;
import bhaa;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.nearby.redtouch.RedTouchItem;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.qphone.base.util.QLog;

public class MainAssistObserver$14
  implements Runnable
{
  public MainAssistObserver$14(akam paramakam, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    int j = 2;
    for (;;)
    {
      Object localObject2;
      try
      {
        bbbq localbbbq = (bbbq)this.a.getManager(QQManagerFactory.MGR_RED_TOUCH);
        BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo = localbbbq.a(1);
        if (localRedTypeInfo != null) {
          break label401;
        }
        aymd localaymd = (aymd)this.a.getManager(QQManagerFactory.LOCAL_REDTOUCH_MANAGER);
        localaymd.a(100601, false);
        boolean bool1 = localaymd.a(10015, false);
        boolean bool2 = localaymd.a(10016, false);
        bhaa.c(this.a);
        localObject2 = localaymd.a(-3);
        if (!localaymd.a((RedTouchItem)localObject2, true)) {
          break label401;
        }
        localRedTypeInfo = new BusinessInfoCheckUpdate.RedTypeInfo();
        if ((bool1 | bool2)) {
          akam.a(this.this$0, this.a);
        }
        QLog.d("MainAssistObserver", 1, "updateTabSettingNotify me count=" + ((RedTouchItem)localObject2).count);
        i = 1;
        if ((localRedTypeInfo != null) || (!bgvx.a(this.a))) {
          break label398;
        }
        localRedTypeInfo = new BusinessInfoCheckUpdate.RedTypeInfo();
        i = j;
        localObject2 = (anri)this.a.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER);
        if ((localRedTypeInfo != null) || (((anri)localObject2).b()) || (!((anri)localObject2).a())) {
          break label393;
        }
        localRedTypeInfo = new BusinessInfoCheckUpdate.RedTypeInfo();
        j = 3;
        i = j;
        localObject2 = localRedTypeInfo;
        if (localRedTypeInfo == null)
        {
          i = j;
          localObject2 = localRedTypeInfo;
          if (aoae.a(1))
          {
            localObject2 = new BusinessInfoCheckUpdate.RedTypeInfo();
            i = 4;
          }
        }
        j = localbbbq.b(1);
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
      label393:
      j = i;
      continue;
      label398:
      continue;
      label401:
      int i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.main.MainAssistObserver.14
 * JD-Core Version:    0.7.0.1
 */