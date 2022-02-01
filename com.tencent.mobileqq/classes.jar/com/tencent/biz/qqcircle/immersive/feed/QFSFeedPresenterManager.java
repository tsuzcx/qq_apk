package com.tencent.biz.qqcircle.immersive.feed;

import com.tencent.biz.qqcircle.immersive.feed.event.QFSBaseFeedPresenterEvent;
import com.tencent.biz.richframework.delegate.impl.RFApplication;
import feedcloud.FeedCloudMeta.StFeed;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;

public class QFSFeedPresenterManager
{
  protected final LinkedHashMap<String, QFSBaseFeedChildPresenter<FeedCloudMeta.StFeed>> a = new LinkedHashMap();
  
  public void a()
  {
    this.a.clear();
  }
  
  public void a(QFSBaseFeedChildPresenter<FeedCloudMeta.StFeed> paramQFSBaseFeedChildPresenter)
  {
    if (paramQFSBaseFeedChildPresenter == null) {
      return;
    }
    if ((this.a.get(paramQFSBaseFeedChildPresenter.getClass().getName()) != null) && (RFApplication.isDebug())) {
      throw new RuntimeException("you can not register Same Class Presenter");
    }
    this.a.put(paramQFSBaseFeedChildPresenter.getClass().getName(), paramQFSBaseFeedChildPresenter);
  }
  
  public void a(QFSBaseFeedPresenterEvent paramQFSBaseFeedPresenterEvent)
  {
    Iterator localIterator = this.a.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (QFSBaseFeedChildPresenter)this.a.get(localObject);
      if (localObject != null) {
        ((QFSBaseFeedChildPresenter)localObject).a(paramQFSBaseFeedPresenterEvent);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.feed.QFSFeedPresenterManager
 * JD-Core Version:    0.7.0.1
 */