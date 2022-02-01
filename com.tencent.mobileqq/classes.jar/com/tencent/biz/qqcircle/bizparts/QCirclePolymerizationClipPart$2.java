package com.tencent.biz.qqcircle.bizparts;

import android.os.Handler;
import com.tencent.biz.richframework.delegate.impl.RFThreadManager;
import com.tencent.biz.richframework.download.RFWDownloader.RFWDownloadListener;
import com.tencent.qphone.base.util.QLog;

class QCirclePolymerizationClipPart$2
  implements RFWDownloader.RFWDownloadListener
{
  QCirclePolymerizationClipPart$2(QCirclePolymerizationClipPart paramQCirclePolymerizationClipPart) {}
  
  public void onDownloadProgress(float paramFloat, long paramLong1, long paramLong2) {}
  
  public void onRspCallback(boolean paramBoolean, String paramString)
  {
    if (paramBoolean)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("filePath =");
      localStringBuilder.append(paramString);
      QLog.d("QCirclePolymerizationClipPart", 1, localStringBuilder.toString());
      RFThreadManager.getUIHandler().post(new QCirclePolymerizationClipPart.2.1(this, paramString));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.QCirclePolymerizationClipPart.2
 * JD-Core Version:    0.7.0.1
 */