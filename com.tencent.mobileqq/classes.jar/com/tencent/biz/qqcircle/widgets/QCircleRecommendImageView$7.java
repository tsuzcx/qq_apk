package com.tencent.biz.qqcircle.widgets;

import android.content.res.Resources;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.network.utils.NetworkUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;

class QCircleRecommendImageView$7
  implements Runnable
{
  QCircleRecommendImageView$7(QCircleRecommendImageView paramQCircleRecommendImageView, String paramString) {}
  
  public void run()
  {
    if (!NetworkUtils.isNetworkAvailable(BaseApplicationImpl.getContext()))
    {
      QQToast.a(BaseApplicationImpl.getContext(), 1, BaseApplicationImpl.getContext().getResources().getString(2131693957), 0).a();
      return;
    }
    QQToast.a(BaseApplicationImpl.getContext(), 1, this.a, 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleRecommendImageView.7
 * JD-Core Version:    0.7.0.1
 */