package com.tencent.biz.qqcircle.scrollers;

import com.tencent.mobileqq.qcircle.api.data.Option;
import com.tencent.mobileqq.qcircle.api.interfaces.QCirclePicStateListener;
import java.util.concurrent.ConcurrentHashMap;

class QCircleFeedPicPreloadScroller$1$1
  extends QCirclePicStateListener
{
  QCircleFeedPicPreloadScroller$1$1(QCircleFeedPicPreloadScroller.1 param1) {}
  
  public void onStateChang(int paramInt, Option paramOption)
  {
    if ((paramInt == 6) || (paramInt == 3)) {
      QCircleFeedPicPreloadScroller.a(this.a.this$0).put(paramOption.getCacheKey(), Boolean.valueOf(true));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.scrollers.QCircleFeedPicPreloadScroller.1.1
 * JD-Core Version:    0.7.0.1
 */