package com.tencent.mobileqq.activity.qwallet.redpacket;

import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory.OnCustomizeListener;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory.RedPacketInfo;
import java.lang.ref.WeakReference;

class RedPacketManager$5
  implements CustomizeStrategyFactory.OnCustomizeListener
{
  RedPacketManager$5(RedPacketManager paramRedPacketManager, RedPacketInfoBase paramRedPacketInfoBase, WeakReference paramWeakReference) {}
  
  public void onSucc(int paramInt, CustomizeStrategyFactory.RedPacketInfo paramRedPacketInfo)
  {
    paramRedPacketInfo.isCache = this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketRedPacketInfoBase.isCache;
    IRedPacket.OnGetSkinListener localOnGetSkinListener = (IRedPacket.OnGetSkinListener)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localOnGetSkinListener != null) {
      localOnGetSkinListener.onGetSkin(paramRedPacketInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.redpacket.RedPacketManager.5
 * JD-Core Version:    0.7.0.1
 */