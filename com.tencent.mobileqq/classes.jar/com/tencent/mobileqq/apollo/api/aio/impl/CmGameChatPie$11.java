package com.tencent.mobileqq.apollo.api.aio.impl;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.lightGame.CmGameAudioManager;
import com.tencent.mobileqq.apollo.process.CmGameUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class CmGameChatPie$11
  implements View.OnClickListener
{
  CmGameChatPie$11(CmGameChatPie paramCmGameChatPie) {}
  
  public void onClick(View paramView)
  {
    if (!CmGameUtil.e()) {
      ((IApolloManagerService)this.a.a.getRuntimeService(IApolloManagerService.class, "all")).getCmGameAudioManager().a(this.a.b(), 319);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (QLog.isColorLevel()) {
        QLog.d(this.a.b, 2, "[onClick] click audio button too fast.");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.aio.impl.CmGameChatPie.11
 * JD-Core Version:    0.7.0.1
 */