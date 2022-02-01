package com.tencent.mobileqq.activity.aio.rebuild.chatlayouthandler;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.onlinestatus.IAccountPanel;
import com.tencent.mobileqq.onlinestatus.ReportHelperKt;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.AppRuntime;
import mqq.app.Foreground;
import mqq.app.MobileQQ;

class OnlineStatusChatLayoutHandler$2
  implements View.OnClickListener
{
  OnlineStatusChatLayoutHandler$2(OnlineStatusChatLayoutHandler paramOnlineStatusChatLayoutHandler, ChatMessage paramChatMessage) {}
  
  public void onClick(View paramView)
  {
    Object localObject = Foreground.getTopActivity();
    if ((localObject instanceof BaseActivity))
    {
      AppRuntime localAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
      localObject = ((IOnlineStatusService)localAppRuntime.getRuntimeService(IOnlineStatusService.class, "")).newAccountPanel((QBaseActivity)localObject, 3);
      ((IAccountPanel)localObject).show();
      ReportHelperKt.a("0X800BBDF", 0, String.valueOf(3));
      ((IAccountPanel)localObject).a(new OnlineStatusChatLayoutHandler.2.1(this, (IAccountPanel)localObject, localAppRuntime));
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.chatlayouthandler.OnlineStatusChatLayoutHandler.2
 * JD-Core Version:    0.7.0.1
 */