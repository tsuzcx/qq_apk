package com.tencent.biz.qcircleshadow.local;

import com.tencent.biz.qcircleshadow.lib.variation.HostChatUtils;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.qcircle.tempapi.interfaces.QCircleMessageFacadeListener;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.Observable;
import java.util.Observer;

public class QCircleMessageFacadeObserver
  implements Observer
{
  private WeakReference<QCircleMessageFacadeListener> a;
  
  public void a(QCircleMessageFacadeListener paramQCircleMessageFacadeListener)
  {
    if (paramQCircleMessageFacadeListener == null)
    {
      this.a = null;
      return;
    }
    this.a = new WeakReference(paramQCircleMessageFacadeListener);
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if ((paramObject instanceof MessageRecord))
    {
      if (!HostChatUtils.isQCircleChatType(((MessageRecord)paramObject).istroop)) {
        return;
      }
      paramObservable = this.a;
      if ((paramObservable != null) && (paramObservable.get() != null)) {
        ((QCircleMessageFacadeListener)this.a.get()).tryRefreshData();
      }
    }
    else if ((paramObject instanceof RecentUser))
    {
      QLog.d("QCircleMessageFacadeObserver", 1, "receiveQCircleRecentUser update");
      paramObservable = this.a;
      if ((paramObservable != null) && (paramObservable.get() != null)) {
        ((QCircleMessageFacadeListener)this.a.get()).tryRefreshData();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.local.QCircleMessageFacadeObserver
 * JD-Core Version:    0.7.0.1
 */