package com.tencent.biz.qqcircle.bizparts.danmaku;

import android.widget.ImageView;
import com.tencent.biz.qqcircle.bizparts.danmaku.entity.AbsDanmaku;
import java.lang.ref.WeakReference;

class QCircleDanmakuSmartView$DanmakuAnimationTask
  implements Runnable
{
  private WeakReference<QCircleDanmakuSmartView> a;
  private WeakReference<AbsDanmaku> b;
  private WeakReference<ImageView> c;
  private WeakReference<ImageView> d;
  
  public QCircleDanmakuSmartView$DanmakuAnimationTask(QCircleDanmakuSmartView paramQCircleDanmakuSmartView, AbsDanmaku paramAbsDanmaku, ImageView paramImageView1, ImageView paramImageView2)
  {
    this.a = new WeakReference(paramQCircleDanmakuSmartView);
    this.b = new WeakReference(paramAbsDanmaku);
    this.c = new WeakReference(paramImageView1);
    this.d = new WeakReference(paramImageView2);
  }
  
  public void run()
  {
    Object localObject1 = this.a;
    if (localObject1 != null)
    {
      if (((WeakReference)localObject1).get() == null) {
        return;
      }
      localObject1 = this.b;
      Object localObject4 = null;
      if ((localObject1 != null) && (((WeakReference)localObject1).get() != null)) {
        localObject1 = (AbsDanmaku)this.b.get();
      } else {
        localObject1 = null;
      }
      Object localObject2 = this.c;
      if ((localObject2 != null) && (((WeakReference)localObject2).get() != null)) {
        localObject2 = (ImageView)this.c.get();
      } else {
        localObject2 = null;
      }
      WeakReference localWeakReference = this.d;
      Object localObject3 = localObject4;
      if (localWeakReference != null)
      {
        localObject3 = localObject4;
        if (localWeakReference.get() != null) {
          localObject3 = (ImageView)this.d.get();
        }
      }
      QCircleDanmakuSmartView.a((QCircleDanmakuSmartView)this.a.get(), (AbsDanmaku)localObject1, (ImageView)localObject2, (ImageView)localObject3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.danmaku.QCircleDanmakuSmartView.DanmakuAnimationTask
 * JD-Core Version:    0.7.0.1
 */