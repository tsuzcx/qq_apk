package com.tencent.mobileqq.activity.qwallet.widget;

import acvj;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory.RedPacketInfo;
import com.tencent.qphone.base.util.QLog;

class HongBaoPanel$1
  implements acvj
{
  HongBaoPanel$1(HongBaoPanel paramHongBaoPanel) {}
  
  public void onSucc(int paramInt, CustomizeStrategyFactory.RedPacketInfo paramRedPacketInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("HongBaoPanel", 2, "action info.icon = " + paramRedPacketInfo.icon + ",info.skinType = " + paramRedPacketInfo.skinType);
    }
    if (paramRedPacketInfo != null) {
      HongBaoPanel.access$000(this.this$0, paramRedPacketInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.widget.HongBaoPanel.1
 * JD-Core Version:    0.7.0.1
 */