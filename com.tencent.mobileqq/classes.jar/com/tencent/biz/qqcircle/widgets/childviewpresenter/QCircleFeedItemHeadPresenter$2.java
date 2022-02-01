package com.tencent.biz.qqcircle.widgets.childviewpresenter;

import android.os.Handler;
import android.widget.ImageView;
import com.tencent.biz.richframework.delegate.impl.RFThreadManager;
import com.tencent.biz.richframework.download.RFWDownloader.RFWDownloadListener;
import com.tencent.qphone.base.util.QLog;

class QCircleFeedItemHeadPresenter$2
  implements RFWDownloader.RFWDownloadListener
{
  QCircleFeedItemHeadPresenter$2(QCircleFeedItemHeadPresenter paramQCircleFeedItemHeadPresenter, ImageView paramImageView) {}
  
  public void onDownloadProgress(float paramFloat, long paramLong1, long paramLong2) {}
  
  public void onRspCallback(boolean paramBoolean, String paramString)
  {
    if (paramBoolean)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("filePath =");
      localStringBuilder.append(paramString);
      QLog.d("QCircleFeedItemHeadPresenter", 1, localStringBuilder.toString());
      RFThreadManager.getUIHandler().post(new QCircleFeedItemHeadPresenter.2.1(this, paramString));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.childviewpresenter.QCircleFeedItemHeadPresenter.2
 * JD-Core Version:    0.7.0.1
 */