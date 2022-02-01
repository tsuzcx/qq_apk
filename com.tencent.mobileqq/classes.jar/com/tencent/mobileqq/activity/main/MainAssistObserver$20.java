package com.tencent.mobileqq.activity.main;

import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.kandian.biz.common.api.IReadInJoySPEventReport;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.RedTypeInfo;
import java.util.concurrent.atomic.AtomicInteger;

class MainAssistObserver$20
  implements LebaTabRedTouch.RefreshCallback
{
  MainAssistObserver$20(MainAssistObserver paramMainAssistObserver) {}
  
  public void a()
  {
    this.a.h.decrementAndGet();
  }
  
  public void a(BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo)
  {
    Object localObject = this.a.j;
    boolean bool = true;
    localObject = ((Handler)localObject).obtainMessage(1);
    ((Message)localObject).obj = paramRedTypeInfo;
    this.a.j.sendMessage((Message)localObject);
    localObject = (IReadInJoySPEventReport)QRoute.api(IReadInJoySPEventReport.class);
    if (paramRedTypeInfo == null) {
      bool = false;
    }
    ((IReadInJoySPEventReport)localObject).updateDTRedPntStats(bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.main.MainAssistObserver.20
 * JD-Core Version:    0.7.0.1
 */