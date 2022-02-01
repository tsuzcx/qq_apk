package com.tencent.mobileqq.activity.aio.rebuild;

import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.troop.observer.TroopRedDotObserver;
import com.tencent.mobileqq.troop.widget.RedDotRadioButton;
import com.tencent.qphone.base.util.QLog;

class HotChatPie$1
  extends TroopRedDotObserver
{
  HotChatPie$1(HotChatPie paramHotChatPie) {}
  
  protected void a(boolean paramBoolean, String paramString)
  {
    if ((this.a.cn != 2) && (paramBoolean) && (this.a.cg != null) && (this.a.bR != null) && (this.a.bR.troopUin.equals(paramString)) && (this.a.bR.hasPostRedPoint())) {
      this.a.cg.a(true);
    }
    if (QLog.isColorLevel())
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.a.c);
      ((StringBuilder)localObject).append("Q.hotchat.aio_post_red_point");
      localObject = ((StringBuilder)localObject).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onBuluoHotChatRedPointComing, troopUin:");
      localStringBuilder.append(paramString);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.HotChatPie.1
 * JD-Core Version:    0.7.0.1
 */