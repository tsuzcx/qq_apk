package com.tencent.biz.qqcircle.fragments.content;

import java.lang.ref.WeakReference;

class QCircleContentOperationView$MyRunnable
  implements Runnable
{
  private WeakReference<QCircleContentOperationView> a;
  
  private QCircleContentOperationView$MyRunnable(QCircleContentOperationView paramQCircleContentOperationView)
  {
    this.a = new WeakReference(paramQCircleContentOperationView);
  }
  
  public void run()
  {
    Object localObject = (QCircleContentOperationView)this.a.get();
    if ((localObject != null) && ((QCircleContentOperationView.c((QCircleContentOperationView)localObject) instanceof QCircleContentHorizontalAdapter.QCircleVideoVH)))
    {
      QCircleContentOperationView.a((QCircleContentOperationView)localObject, false);
      localObject = (QCircleContentHorizontalAdapter.QCircleVideoVH)QCircleContentOperationView.c((QCircleContentOperationView)localObject);
      if (((QCircleContentHorizontalAdapter.QCircleVideoVH)localObject).a != null) {
        ((QCircleContentHorizontalAdapter.QCircleVideoVH)localObject).a.bi_();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.content.QCircleContentOperationView.MyRunnable
 * JD-Core Version:    0.7.0.1
 */