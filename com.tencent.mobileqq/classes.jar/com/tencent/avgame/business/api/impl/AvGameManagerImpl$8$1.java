package com.tencent.avgame.business.api.impl;

import android.app.Activity;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.ConfigObserver;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class AvGameManagerImpl$8$1
  extends ConfigObserver
{
  AvGameManagerImpl$8$1(AvGameManagerImpl.8 param8) {}
  
  protected void a(boolean paramBoolean)
  {
    Object localObject1;
    if (paramBoolean)
    {
      localObject1 = (Activity)this.a.a.get();
      if ((localObject1 != null) && (!((Activity)localObject1).isFinishing()))
      {
        ReportController.b(null, "dc00898", "", "", "0X800B079", "0X800B079", this.a.b, 0, "", "", "", "");
        Object localObject2;
        if (this.a.c.isEmpty())
        {
          if (QLog.isColorLevel()) {
            QLog.i("AvGameManager", 2, "onGetRealNameStatusForAV createAvGameRoom");
          }
          if (this.a.d == 9)
          {
            this.a.h.startStrangerMatch((Activity)localObject1, 9);
          }
          else if ((this.a.d != 11) && (this.a.d != 13))
          {
            this.a.h.createAvGameRoom((Activity)localObject1, this.a.d, this.a.f, this.a.e);
          }
          else
          {
            localObject2 = this.a.h;
            int j = this.a.e;
            int i;
            if (this.a.e > 0) {
              i = 1;
            } else {
              i = 0;
            }
            ((AvGameManagerImpl)localObject2).startStrangerMatchV2((Activity)localObject1, j, i, this.a.d);
          }
        }
        else
        {
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("onGetRealNameStatusForAV joinAvGameRoom. roomId: ");
            ((StringBuilder)localObject2).append(this.a.c);
            QLog.i("AvGameManager", 2, ((StringBuilder)localObject2).toString());
          }
          this.a.h.joinAvGameRoom((Activity)localObject1, this.a.d, this.a.c, this.a.f);
        }
      }
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onGetRealNameStatusForAV authed: ");
      ((StringBuilder)localObject1).append(paramBoolean);
      ((StringBuilder)localObject1).append(". Remove observer.");
      QLog.i("RealName", 2, ((StringBuilder)localObject1).toString());
    }
    AvGameManagerImpl.access$200(this.a.h).removeObserver(AvGameManagerImpl.access$300(this.a.h));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.business.api.impl.AvGameManagerImpl.8.1
 * JD-Core Version:    0.7.0.1
 */