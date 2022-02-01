package com.tencent.biz.qqcircle.scrollers;

import com.tencent.biz.qqcircle.picload.QCircleFeedPicLoader;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import vuj;

public class QCircleFeedPicPreloadScroller$7
  implements Runnable
{
  public QCircleFeedPicPreloadScroller$7(vuj paramvuj) {}
  
  public void run()
  {
    Iterator localIterator = vuj.a(this.this$0).keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Boolean localBoolean = (Boolean)vuj.a(this.this$0).get(str);
      if ((localBoolean != null) && (!localBoolean.booleanValue()))
      {
        QCircleFeedPicLoader.a().a(str);
        localIterator.remove();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.scrollers.QCircleFeedPicPreloadScroller.7
 * JD-Core Version:    0.7.0.1
 */