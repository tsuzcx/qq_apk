package com.tencent.biz.qqcircle.widgets;

import android.os.Handler;
import android.widget.ImageView;
import com.tencent.biz.richframework.download.RFWDownloader.RFWDownloadListener;
import com.tencent.qphone.base.util.QLog;

class QCircleStatusView$1
  implements RFWDownloader.RFWDownloadListener
{
  QCircleStatusView$1(QCircleStatusView paramQCircleStatusView, ImageView paramImageView) {}
  
  public void onDownloadProgress(float paramFloat, long paramLong1, long paramLong2) {}
  
  public void onRspCallback(boolean paramBoolean, String paramString)
  {
    if (paramBoolean)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("filePath =");
      localStringBuilder.append(paramString);
      QLog.d("QCircleStatusView", 1, localStringBuilder.toString());
      this.b.getMainHandler().post(new QCircleStatusView.1.1(this, paramString));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleStatusView.1
 * JD-Core Version:    0.7.0.1
 */