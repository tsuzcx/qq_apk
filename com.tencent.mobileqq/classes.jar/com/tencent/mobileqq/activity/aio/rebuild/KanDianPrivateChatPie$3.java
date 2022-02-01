package com.tencent.mobileqq.activity.aio.rebuild;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.kandian.biz.privatechat.api.IRIJPrivateChatService;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

class KanDianPrivateChatPie$3
  implements View.OnClickListener
{
  KanDianPrivateChatPie$3(KanDianPrivateChatPie paramKanDianPrivateChatPie) {}
  
  public void onClick(View paramView)
  {
    if ((this.a.ah != null) && (!TextUtils.isEmpty(this.a.ah.b))) {
      ((IRIJPrivateChatService)MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(IRIJPrivateChatService.class, "")).jumpKanDianProfilePage(this.a.aX(), this.a.ah.b);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.KanDianPrivateChatPie.3
 * JD-Core Version:    0.7.0.1
 */