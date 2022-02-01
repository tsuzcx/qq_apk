package com.tencent.biz.qqcircle.immersive.utils;

import android.content.Context;
import android.view.View;
import java.lang.ref.WeakReference;

class QFSPublishTipsUtils$PublishTipDismissRunnableImpl
  implements Runnable
{
  private WeakReference<QFSPublishTipsUtils> a;
  private WeakReference<View> b;
  
  public QFSPublishTipsUtils$PublishTipDismissRunnableImpl(QFSPublishTipsUtils paramQFSPublishTipsUtils, View paramView)
  {
    this.a = new WeakReference(paramQFSPublishTipsUtils);
    this.b = new WeakReference(paramView);
  }
  
  public void run()
  {
    Object localObject1 = this.a;
    Object localObject3 = null;
    if (localObject1 == null) {
      localObject1 = null;
    } else {
      localObject1 = (QFSPublishTipsUtils)((WeakReference)localObject1).get();
    }
    if (localObject1 == null) {
      return;
    }
    Object localObject2 = this.b;
    if (localObject2 == null) {
      localObject2 = null;
    } else {
      localObject2 = (View)((WeakReference)localObject2).get();
    }
    if (localObject2 == null) {
      localObject2 = localObject3;
    } else {
      localObject2 = ((View)localObject2).getContext();
    }
    QFSPublishTipsUtils.a((QFSPublishTipsUtils)localObject1, (Context)localObject2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.utils.QFSPublishTipsUtils.PublishTipDismissRunnableImpl
 * JD-Core Version:    0.7.0.1
 */