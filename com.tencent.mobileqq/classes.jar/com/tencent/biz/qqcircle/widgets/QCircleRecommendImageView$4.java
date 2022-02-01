package com.tencent.biz.qqcircle.widgets;

import android.os.Handler;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.richframework.delegate.impl.RFThreadManager;
import com.tencent.biz.richframework.download.RFWMultiDownloadHelper.DownloadResult;
import com.tencent.biz.richframework.download.RFWMultiDownloadHelper.MultiDownloadResultListener;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

class QCircleRecommendImageView$4
  implements RFWMultiDownloadHelper.MultiDownloadResultListener
{
  QCircleRecommendImageView$4(QCircleRecommendImageView paramQCircleRecommendImageView, boolean paramBoolean) {}
  
  public void onDownloadResult(boolean paramBoolean, Map<String, RFWMultiDownloadHelper.DownloadResult> paramMap)
  {
    if (paramBoolean)
    {
      QCircleRecommendImageView.a(true);
      QCircleRecommendImageView.a(paramMap);
      QLog.i(QCircleRecommendImageView.e(this.b), 1, "onCreateSuccess ");
      try
      {
        RFThreadManager.getUIHandler().post(new QCircleRecommendImageView.4.1(this));
        return;
      }
      catch (Exception paramMap)
      {
        String str = QCircleRecommendImageView.e(this.b);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("playError ");
        localStringBuilder.append(paramMap.getMessage());
        QLog.i(str, 1, localStringBuilder.toString());
        paramMap.printStackTrace();
        return;
      }
    }
    QCircleToast.a("动画加载失败", 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleRecommendImageView.4
 * JD-Core Version:    0.7.0.1
 */