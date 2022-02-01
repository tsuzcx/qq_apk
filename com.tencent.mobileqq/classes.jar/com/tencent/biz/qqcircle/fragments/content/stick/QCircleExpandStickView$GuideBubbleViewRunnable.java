package com.tencent.biz.qqcircle.fragments.content.stick;

import java.lang.ref.WeakReference;

class QCircleExpandStickView$GuideBubbleViewRunnable
  implements Runnable
{
  private WeakReference<QCircleExpandStickView> a;
  
  public QCircleExpandStickView$GuideBubbleViewRunnable(QCircleExpandStickView paramQCircleExpandStickView)
  {
    this.a = new WeakReference(paramQCircleExpandStickView);
  }
  
  public void run()
  {
    WeakReference localWeakReference = this.a;
    if ((localWeakReference != null) && (localWeakReference.get() != null)) {
      QCircleExpandStickView.b((QCircleExpandStickView)this.a.get());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.content.stick.QCircleExpandStickView.GuideBubbleViewRunnable
 * JD-Core Version:    0.7.0.1
 */