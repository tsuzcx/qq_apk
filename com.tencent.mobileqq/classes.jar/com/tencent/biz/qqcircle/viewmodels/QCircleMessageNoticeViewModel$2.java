package com.tencent.biz.qqcircle.viewmodels;

import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import com.tencent.biz.qqcircle.beans.QCircleMessageNoticeInfo;
import com.tencent.biz.qqcircle.events.QCircleMessageNoticeEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;

class QCircleMessageNoticeViewModel$2
  implements Observer<QCircleMessageNoticeInfo>
{
  QCircleMessageNoticeViewModel$2(QCircleMessageNoticeViewModel paramQCircleMessageNoticeViewModel) {}
  
  public void a(@Nullable QCircleMessageNoticeInfo paramQCircleMessageNoticeInfo)
  {
    SimpleEventBus.getInstance().dispatchEvent(new QCircleMessageNoticeEvent(paramQCircleMessageNoticeInfo));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.viewmodels.QCircleMessageNoticeViewModel.2
 * JD-Core Version:    0.7.0.1
 */