package com.tencent.mobileqq.app;

import amux;
import amuy;
import com.tencent.biz.qcircleshadow.local.requests.QCircleSetCircleSwitchRequest;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import mqq.app.MobileQQ;

public class LebaHelper$4
  implements Runnable
{
  public LebaHelper$4(amux paramamux, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    QCircleSetCircleSwitchRequest localQCircleSetCircleSwitchRequest = new QCircleSetCircleSwitchRequest("qqcircle", "qqcircle_entrance_enable", "0");
    VSNetworkHelper.getInstance().sendRequest(localQCircleSetCircleSwitchRequest, new amuy(this));
    this.this$0.a(this.a, this.a.getApplication().getApplicationContext());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.LebaHelper.4
 * JD-Core Version:    0.7.0.1
 */