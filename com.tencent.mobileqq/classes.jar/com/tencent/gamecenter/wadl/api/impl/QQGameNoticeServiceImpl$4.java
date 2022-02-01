package com.tencent.gamecenter.wadl.api.impl;

import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.os.MqqHandler;

class QQGameNoticeServiceImpl$4
  implements View.OnClickListener
{
  QQGameNoticeServiceImpl$4(QQGameNoticeServiceImpl paramQQGameNoticeServiceImpl, String paramString) {}
  
  public void onClick(View paramView)
  {
    Message localMessage = QQGameNoticeServiceImpl.access$200(this.jdField_a_of_type_ComTencentGamecenterWadlApiImplQQGameNoticeServiceImpl).obtainMessage(1);
    localMessage.obj = this.jdField_a_of_type_JavaLangString;
    localMessage.sendToTarget();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gamecenter.wadl.api.impl.QQGameNoticeServiceImpl.4
 * JD-Core Version:    0.7.0.1
 */