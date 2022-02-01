package com.tencent.biz.qqcircle.picload;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadPoolExecutor;

class QCircleFeedPicLoader$7
  implements Runnable
{
  QCircleFeedPicLoader$7(QCircleFeedPicLoader paramQCircleFeedPicLoader) {}
  
  public void run()
  {
    Iterator localIterator = QCircleFeedPicLoader.a(this.this$0).keySet().iterator();
    String str;
    QCircleFeedPicLoader.PicDownLoadTask localPicDownLoadTask;
    while (localIterator.hasNext())
    {
      str = (String)localIterator.next();
      localPicDownLoadTask = (QCircleFeedPicLoader.PicDownLoadTask)QCircleFeedPicLoader.a(this.this$0).get(str);
      if (localPicDownLoadTask != null) {
        localPicDownLoadTask.a();
      }
      QCircleFeedPicLoader.a(this.this$0).remove(str);
    }
    QCircleFeedPicLoader.a(this.this$0).getQueue().clear();
    localIterator = QCircleFeedPicLoader.b(this.this$0).keySet().iterator();
    while (localIterator.hasNext())
    {
      str = (String)localIterator.next();
      localPicDownLoadTask = (QCircleFeedPicLoader.PicDownLoadTask)QCircleFeedPicLoader.b(this.this$0).get(str);
      if (localPicDownLoadTask != null) {
        localPicDownLoadTask.a();
      }
      QCircleFeedPicLoader.b(this.this$0).remove(str);
    }
    QCircleFeedPicLoader.b(this.this$0).getQueue().clear();
    QCircleFeedPicLoader.a(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.picload.QCircleFeedPicLoader.7
 * JD-Core Version:    0.7.0.1
 */