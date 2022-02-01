package com.tencent.biz.qqcircle.scrollers;

import com.tencent.mobileqq.qcircle.api.data.Option;
import com.tencent.mobileqq.qcircle.api.interfaces.QCirclePicStateListener;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

class QCircleFeedPicPreloadScroller$3$1
  extends QCirclePicStateListener
{
  QCircleFeedPicPreloadScroller$3$1(QCircleFeedPicPreloadScroller.3 param3) {}
  
  public void onStateChang(int paramInt, Option paramOption)
  {
    if ((paramInt == 6) || (paramInt == 3))
    {
      QCircleFeedPicPreloadScroller.a(this.a.this$0).put(paramOption.getCacheKey(), Boolean.valueOf(true));
      QLog.d(QCircleFeedPicPreloadScroller.g(), 4, "preload time lin pic success");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.scrollers.QCircleFeedPicPreloadScroller.3.1
 * JD-Core Version:    0.7.0.1
 */