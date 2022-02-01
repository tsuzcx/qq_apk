package com.tencent.biz.qqcircle.fragments.person;

import android.text.TextUtils;
import com.tencent.biz.qqcircle.events.QCircleBroadcastEvent;
import com.tencent.biz.qqcircle.events.QCircleFeedEvent;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import java.lang.ref.WeakReference;
import java.util.List;

class QCirclePersonalBottomView$PersonBottomEventTask
  implements Runnable
{
  private WeakReference<SimpleBaseEvent> a;
  private WeakReference<QCirclePersonalBottomView> b;
  
  public QCirclePersonalBottomView$PersonBottomEventTask(SimpleBaseEvent paramSimpleBaseEvent, QCirclePersonalBottomView paramQCirclePersonalBottomView)
  {
    this.a = new WeakReference(paramSimpleBaseEvent);
    this.b = new WeakReference(paramQCirclePersonalBottomView);
  }
  
  public void run()
  {
    Object localObject = (SimpleBaseEvent)this.a.get();
    QCirclePersonalBottomView localQCirclePersonalBottomView = (QCirclePersonalBottomView)this.b.get();
    if (localObject != null)
    {
      if (localQCirclePersonalBottomView == null) {
        return;
      }
      if ((localObject instanceof QCircleFeedEvent))
      {
        localObject = (QCircleFeedEvent)localObject;
        if (((QCircleFeedEvent)localObject).mState == 2)
        {
          QCirclePersonalBottomView.i(localQCirclePersonalBottomView);
          localQCirclePersonalBottomView.a(QCirclePersonalBottomView.j(localQCirclePersonalBottomView));
          localQCirclePersonalBottomView.a();
          return;
        }
        if (((QCircleFeedEvent)localObject).mState == 3)
        {
          if (QCirclePersonalBottomView.j(localQCirclePersonalBottomView) > 0) {
            QCirclePersonalBottomView.k(localQCirclePersonalBottomView);
          }
          localQCirclePersonalBottomView.a(QCirclePersonalBottomView.j(localQCirclePersonalBottomView));
          localQCirclePersonalBottomView.a();
        }
      }
      else if (((localObject instanceof QCircleBroadcastEvent)) && (TextUtils.equals(((QCircleBroadcastEvent)localObject).mAction, "qcircle_personal_page_scroll_to_top_and_refresh")))
      {
        ((QCirclePersonalBaseBottomFragment)QCirclePersonalBottomView.h(localQCirclePersonalBottomView).get(localQCirclePersonalBottomView.getCurrentIndex())).B();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.person.QCirclePersonalBottomView.PersonBottomEventTask
 * JD-Core Version:    0.7.0.1
 */