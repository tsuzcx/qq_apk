package com.tencent.biz.qqcircle.manager;

import androidx.lifecycle.Observer;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import feedcloud.FeedCloudRead.StGetFeedListRsp;
import java.lang.ref.WeakReference;

class QCirclePersonalPymkModelManager$FeedListRspObserver
  implements Observer<UIStateData<FeedCloudRead.StGetFeedListRsp>>
{
  private WeakReference<QCirclePersonalPymkModelManager> a = null;
  
  public QCirclePersonalPymkModelManager$FeedListRspObserver(QCirclePersonalPymkModelManager paramQCirclePersonalPymkModelManager)
  {
    this.a = new WeakReference(paramQCirclePersonalPymkModelManager);
  }
  
  public void a(UIStateData<FeedCloudRead.StGetFeedListRsp> paramUIStateData)
  {
    Object localObject = this.a;
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = (QCirclePersonalPymkModelManager)((WeakReference)localObject).get();
    }
    if (localObject == null)
    {
      QLog.d("PYMK-QCirclePersonalPymkModelManager", 1, "[onChanged] model manager should not be null.");
      return;
    }
    if (paramUIStateData.c() == 4)
    {
      QLog.d("PYMK-QCirclePersonalPymkModelManager", 1, new Object[] { "[onChanged] msg: ", paramUIStateData.f(), " | error code: ", Long.valueOf(paramUIStateData.g()) });
      QCirclePersonalPymkModelManager.a((QCirclePersonalPymkModelManager)localObject, paramUIStateData.g(), paramUIStateData.f());
      return;
    }
    if ((paramUIStateData.c() == 3) || (paramUIStateData.c() == 2)) {
      QCirclePersonalPymkModelManager.a((QCirclePersonalPymkModelManager)localObject, (FeedCloudRead.StGetFeedListRsp)paramUIStateData.e());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.manager.QCirclePersonalPymkModelManager.FeedListRspObserver
 * JD-Core Version:    0.7.0.1
 */