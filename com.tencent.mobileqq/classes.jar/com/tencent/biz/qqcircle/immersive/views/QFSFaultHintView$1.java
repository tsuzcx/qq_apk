package com.tencent.biz.qqcircle.immersive.views;

import android.os.Handler;
import android.widget.ImageView;
import com.tencent.biz.richframework.download.RFWDownloader.RFWDownloadListener;
import com.tencent.qphone.base.util.QLog;

class QFSFaultHintView$1
  implements RFWDownloader.RFWDownloadListener
{
  QFSFaultHintView$1(QFSFaultHintView paramQFSFaultHintView, ImageView paramImageView) {}
  
  public void onDownloadProgress(float paramFloat, long paramLong1, long paramLong2) {}
  
  public void onRspCallback(boolean paramBoolean, String paramString)
  {
    if (paramBoolean)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("filePath =");
      localStringBuilder.append(paramString);
      QLog.d("FSFaultHintView", 1, localStringBuilder.toString());
      this.b.getMainHandler().post(new QFSFaultHintView.1.1(this, paramString));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.views.QFSFaultHintView.1
 * JD-Core Version:    0.7.0.1
 */