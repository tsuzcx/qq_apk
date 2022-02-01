package com.tencent.biz.qqcircle.scrollers;

import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

class QCircleFeedPicPreloadScroller$9
  implements Runnable
{
  QCircleFeedPicPreloadScroller$9(QCircleFeedPicPreloadScroller paramQCircleFeedPicPreloadScroller) {}
  
  public void run()
  {
    Iterator localIterator = QCircleFeedPicPreloadScroller.a(this.this$0).keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Boolean localBoolean = (Boolean)QCircleFeedPicPreloadScroller.a(this.this$0).get(str);
      if ((localBoolean != null) && (!localBoolean.booleanValue()))
      {
        QCircleFeedPicLoader.g().cancel(str);
        localIterator.remove();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.scrollers.QCircleFeedPicPreloadScroller.9
 * JD-Core Version:    0.7.0.1
 */