package com.tencent.mobileqq.activity.qwallet.redpacket;

import Wallet.GetSkinListRsp;
import android.os.Bundle;
import java.util.Iterator;
import java.util.List;
import mqq.observer.BusinessObserver;

class RedPacketManager$2$1
  implements Runnable
{
  RedPacketManager$2$1(RedPacketManager.2 param2, GetSkinListRsp paramGetSkinListRsp) {}
  
  public void run()
  {
    Bundle localBundle = new Bundle();
    localBundle.putSerializable("rsp", this.jdField_a_of_type_WalletGetSkinListRsp);
    localBundle.putBoolean("isCache", true);
    if (RedPacketManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketRedPacketManager$2.this$0).isEmpty()) {}
    for (;;)
    {
      return;
      Iterator localIterator = RedPacketManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketRedPacketManager$2.this$0).iterator();
      while (localIterator.hasNext()) {
        ((BusinessObserver)localIterator.next()).onReceive(14, true, localBundle);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.redpacket.RedPacketManager.2.1
 * JD-Core Version:    0.7.0.1
 */