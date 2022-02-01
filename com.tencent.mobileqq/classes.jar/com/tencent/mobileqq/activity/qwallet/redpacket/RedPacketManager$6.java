package com.tencent.mobileqq.activity.qwallet.redpacket;

import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory.OnCustomizeListener;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory.RedPacketInfo;

class RedPacketManager$6
  implements CustomizeStrategyFactory.OnCustomizeListener
{
  RedPacketManager$6(RedPacketManager paramRedPacketManager, IRedPacket.OnGetSkinListener paramOnGetSkinListener) {}
  
  public void onSucc(int paramInt, CustomizeStrategyFactory.RedPacketInfo paramRedPacketInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketIRedPacket$OnGetSkinListener.onGetSkin(paramRedPacketInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.redpacket.RedPacketManager.6
 * JD-Core Version:    0.7.0.1
 */