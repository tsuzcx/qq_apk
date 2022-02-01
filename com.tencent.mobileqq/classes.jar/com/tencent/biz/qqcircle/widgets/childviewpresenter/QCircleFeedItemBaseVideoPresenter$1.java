package com.tencent.biz.qqcircle.widgets.childviewpresenter;

import com.tencent.mobileqq.qcircle.api.data.Option;
import com.tencent.mobileqq.qcircle.api.interfaces.QCirclePicStateListener;
import com.tencent.qphone.base.util.QLog;

class QCircleFeedItemBaseVideoPresenter$1
  extends QCirclePicStateListener
{
  QCircleFeedItemBaseVideoPresenter$1(QCircleFeedItemBaseVideoPresenter paramQCircleFeedItemBaseVideoPresenter) {}
  
  public void onStateChang(int paramInt, Option paramOption)
  {
    super.onStateChang(paramInt, paramOption);
    String str = this.a.getLogTag();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramOption.getUrl());
    localStringBuilder.append("\n , state callback:");
    localStringBuilder.append(paramInt);
    QLog.d(str, 1, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.childviewpresenter.QCircleFeedItemBaseVideoPresenter.1
 * JD-Core Version:    0.7.0.1
 */