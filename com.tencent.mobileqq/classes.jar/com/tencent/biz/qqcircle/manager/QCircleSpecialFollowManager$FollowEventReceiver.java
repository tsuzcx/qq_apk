package com.tencent.biz.qqcircle.manager;

import android.os.Handler;
import android.os.Message;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.qcircle.api.event.QCircleFollowUpdateEvent;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class QCircleSpecialFollowManager$FollowEventReceiver
  implements SimpleEventReceiver<QCircleFollowUpdateEvent>
{
  private final Handler a;
  
  private QCircleSpecialFollowManager$FollowEventReceiver(Handler paramHandler)
  {
    this.a = paramHandler;
  }
  
  public ArrayList<Class<QCircleFollowUpdateEvent>> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(QCircleFollowUpdateEvent.class);
    return localArrayList;
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if (!(paramSimpleBaseEvent instanceof QCircleFollowUpdateEvent)) {
      return;
    }
    paramSimpleBaseEvent = (QCircleFollowUpdateEvent)paramSimpleBaseEvent;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onReceiveEvent: QCircleFollowUpdateEvent ");
    localStringBuilder.append(paramSimpleBaseEvent.mUserId);
    localStringBuilder.append(" ");
    localStringBuilder.append(paramSimpleBaseEvent.mFollowStatus);
    QLog.i("QCircleSpecialFollowMgr", 4, localStringBuilder.toString());
    if (paramSimpleBaseEvent.mFollowStatus == 0) {
      this.a.obtainMessage(1002, paramSimpleBaseEvent.mUserId).sendToTarget();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.manager.QCircleSpecialFollowManager.FollowEventReceiver
 * JD-Core Version:    0.7.0.1
 */