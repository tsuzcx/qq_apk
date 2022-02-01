package com.tencent.biz.qqcircle.widgets.childviewpresenter;

import android.widget.ImageView;
import com.tencent.biz.qqcircle.fragments.content.stick.QCircleExpandStickView;
import com.tencent.mobileqq.qcircle.api.data.Option;
import com.tencent.qphone.base.util.QLog;

class QCircleFeedItemPicPresenter$MultiPicAdapter$5
  implements Runnable
{
  QCircleFeedItemPicPresenter$MultiPicAdapter$5(QCircleFeedItemPicPresenter.MultiPicAdapter paramMultiPicAdapter, Option paramOption) {}
  
  public void run()
  {
    try
    {
      int i = ((Integer)this.a.getTargetView().getTag(2131441709)).intValue();
      QCircleExpandStickView localQCircleExpandStickView = (QCircleExpandStickView)this.a.getTargetView().getTag(2131441711);
      QCircleFeedItemPicPresenter.MultiPicAdapter.a(this.b, localQCircleExpandStickView, this.a, i);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("QCircleFeedItemPicPresent", 1, "[configStickViewBounds] error: ", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.childviewpresenter.QCircleFeedItemPicPresenter.MultiPicAdapter.5
 * JD-Core Version:    0.7.0.1
 */