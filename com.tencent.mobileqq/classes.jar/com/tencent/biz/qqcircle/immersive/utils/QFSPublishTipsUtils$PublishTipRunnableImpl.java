package com.tencent.biz.qqcircle.immersive.utils;

import android.view.View;
import java.lang.ref.WeakReference;

class QFSPublishTipsUtils$PublishTipRunnableImpl
  implements Runnable
{
  private WeakReference<QFSPublishTipsUtils> a;
  private WeakReference<View> b;
  
  public QFSPublishTipsUtils$PublishTipRunnableImpl(QFSPublishTipsUtils paramQFSPublishTipsUtils, View paramView)
  {
    this.a = new WeakReference(paramQFSPublishTipsUtils);
    this.b = new WeakReference(paramView);
  }
  
  public void run()
  {
    Object localObject = this.a;
    View localView = null;
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = (QFSPublishTipsUtils)((WeakReference)localObject).get();
    }
    if (localObject == null) {
      return;
    }
    WeakReference localWeakReference = this.b;
    if (localWeakReference != null) {
      localView = (View)localWeakReference.get();
    }
    QFSPublishTipsUtils.a((QFSPublishTipsUtils)localObject, localView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.utils.QFSPublishTipsUtils.PublishTipRunnableImpl
 * JD-Core Version:    0.7.0.1
 */