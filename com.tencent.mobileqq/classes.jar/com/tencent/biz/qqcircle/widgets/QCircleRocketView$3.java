package com.tencent.biz.qqcircle.widgets;

import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.richframework.download.RFWMultiDownloadHelper.DownloadResult;
import com.tencent.biz.richframework.download.RFWMultiDownloadHelper.MultiDownloadResultListener;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

class QCircleRocketView$3
  implements RFWMultiDownloadHelper.MultiDownloadResultListener
{
  QCircleRocketView$3(QCircleRocketView paramQCircleRocketView, int paramInt1, int paramInt2) {}
  
  public void onDownloadResult(boolean paramBoolean, Map<String, RFWMultiDownloadHelper.DownloadResult> paramMap)
  {
    if (paramBoolean)
    {
      QCircleRocketView.a(true);
      QCircleRocketView.a(paramMap);
      QLog.i("QCircleRocketView", 1, "onCreateSuccess ");
      try
      {
        QCircleRocketView.b(this.c, this.a, this.b);
        return;
      }
      catch (Exception paramMap)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("playError ");
        localStringBuilder.append(paramMap.getMessage());
        QLog.i("QCircleRocketView", 1, localStringBuilder.toString());
        paramMap.printStackTrace();
        return;
      }
    }
    QCircleToast.a("动画加载失败", 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleRocketView.3
 * JD-Core Version:    0.7.0.1
 */