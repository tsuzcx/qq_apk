package com.tencent.gamecenter.wadl.api.impl;

import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.os.MqqHandler;

class QQGameNoticeServiceImpl$3
  implements View.OnClickListener
{
  QQGameNoticeServiceImpl$3(QQGameNoticeServiceImpl paramQQGameNoticeServiceImpl, String paramString) {}
  
  public void onClick(View paramView)
  {
    Message localMessage = QQGameNoticeServiceImpl.access$200(this.b).obtainMessage(2);
    localMessage.obj = this.a;
    localMessage.sendToTarget();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gamecenter.wadl.api.impl.QQGameNoticeServiceImpl.3
 * JD-Core Version:    0.7.0.1
 */