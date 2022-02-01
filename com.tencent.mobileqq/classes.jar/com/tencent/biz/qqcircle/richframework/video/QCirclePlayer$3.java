package com.tencent.biz.qqcircle.richframework.video;

import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.api.ISuperPlayer;

class QCirclePlayer$3
  implements Runnable
{
  QCirclePlayer$3(QCirclePlayer paramQCirclePlayer) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QCirclePlayer", 1, "[release]");
    }
    if (QCirclePlayer.b(this.this$0) != null)
    {
      QCirclePlayer.b(this.this$0).stop();
      QCirclePlayer.b(this.this$0).release();
    }
    QCirclePlayer.a(this.this$0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.richframework.video.QCirclePlayer.3
 * JD-Core Version:    0.7.0.1
 */