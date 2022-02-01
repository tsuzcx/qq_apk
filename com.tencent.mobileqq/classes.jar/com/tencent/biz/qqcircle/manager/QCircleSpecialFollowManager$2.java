package com.tencent.biz.qqcircle.manager;

import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;

class QCircleSpecialFollowManager$2
  implements Runnable
{
  QCircleSpecialFollowManager$2(QCircleSpecialFollowManager paramQCircleSpecialFollowManager, boolean paramBoolean, String paramString) {}
  
  public void run()
  {
    int i;
    if (this.a) {
      i = QCircleToast.d;
    } else {
      i = QCircleToast.c;
    }
    QCircleToast.a(i, this.b, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.manager.QCircleSpecialFollowManager.2
 * JD-Core Version:    0.7.0.1
 */