package com.tencent.biz.qqcircle.immersive.views;

import android.widget.ImageView;
import com.tencent.qphone.base.util.QLog;

class QFSBoxProgressView$3
  implements Runnable
{
  QFSBoxProgressView$3(QFSBoxProgressView paramQFSBoxProgressView) {}
  
  public void run()
  {
    QLog.d("QFSBoxProgressView", 1, "onReceiveEvent... showCloseBt");
    if (QFSBoxProgressView.b(this.this$0) != null) {
      QFSBoxProgressView.b(this.this$0).setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.views.QFSBoxProgressView.3
 * JD-Core Version:    0.7.0.1
 */