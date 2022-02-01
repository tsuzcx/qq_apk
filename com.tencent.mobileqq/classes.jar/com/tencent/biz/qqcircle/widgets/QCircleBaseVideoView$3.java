package com.tencent.biz.qqcircle.widgets;

import android.graphics.Bitmap;
import com.tencent.biz.qqcircle.utils.FileUtils;
import com.tencent.mobileqq.qcircle.api.global.QCircleHostGlobalInfo;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class QCircleBaseVideoView$3
  implements Runnable
{
  public void run()
  {
    FileUtils.a(QCircleBaseVideoView.f, false);
    if ((this.this$0.g != null) && (this.this$0.g.get() != null))
    {
      FileUtils.f(this.a);
      if (FileUtils.a((Bitmap)this.this$0.g.get(), this.a))
      {
        QCircleHostGlobalInfo.setVideoCoverTempPath(this.a);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("saveCurrentVideoBitmapToFile cost:");
        localStringBuilder.append(System.currentTimeMillis() - this.b);
        QLog.e("BaseVideoView", 1, localStringBuilder.toString());
      }
      return;
    }
    QLog.e("BaseVideoView", 1, "mCurrentRenderBitmap is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleBaseVideoView.3
 * JD-Core Version:    0.7.0.1
 */