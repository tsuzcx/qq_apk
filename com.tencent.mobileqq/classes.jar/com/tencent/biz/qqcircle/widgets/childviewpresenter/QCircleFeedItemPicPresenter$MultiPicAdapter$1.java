package com.tencent.biz.qqcircle.widgets.childviewpresenter;

import com.tencent.mobileqq.qcircle.api.data.Option;
import com.tencent.mobileqq.qcircle.api.interfaces.QCirclePicStateListener;
import com.tencent.qphone.base.util.QLog;

class QCircleFeedItemPicPresenter$MultiPicAdapter$1
  extends QCirclePicStateListener
{
  QCircleFeedItemPicPresenter$MultiPicAdapter$1(QCircleFeedItemPicPresenter.MultiPicAdapter paramMultiPicAdapter) {}
  
  public void onStateChang(int paramInt, Option paramOption)
  {
    super.onStateChang(paramInt, paramOption);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramOption.getUrl());
    localStringBuilder.append("\n, state callback:");
    localStringBuilder.append(paramInt);
    QLog.d("QCircleFeedItemPicPresent1", 1, localStringBuilder.toString());
    if (paramInt == 6) {
      QCircleFeedItemPicPresenter.MultiPicAdapter.a(this.a, paramOption);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.childviewpresenter.QCircleFeedItemPicPresenter.MultiPicAdapter.1
 * JD-Core Version:    0.7.0.1
 */