package com.tencent.mobileqq.activity.qwallet.redpacket;

import Wallet.GetGroupRedPackListRsp;
import java.util.HashMap;

class RedPacketManager$7$1
  implements Runnable
{
  RedPacketManager$7$1(RedPacketManager.7 param7, GetGroupRedPackListRsp paramGetGroupRedPackListRsp) {}
  
  public void run()
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketRedPacketManager$7.this$0.b != null)
    {
      localObject1 = localObject2;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketRedPacketManager$7.this$0.b.get(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketRedPacketManager$7.b + "_" + this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketRedPacketManager$7.jdField_a_of_type_Int) != null) {
        localObject1 = (IRedPacket.OnGetAvailableListListener)this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketRedPacketManager$7.this$0.b.get(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketRedPacketManager$7.b + "_" + this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketRedPacketManager$7.jdField_a_of_type_Int);
      }
    }
    if (localObject1 == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketRedPacketManager$7.this$0.a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketRedPacketManager$7.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketRedPacketManager$7.b, this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketRedPacketManager$7.jdField_a_of_type_Int, (IRedPacket.OnGetAvailableListListener)localObject1, this.jdField_a_of_type_WalletGetGroupRedPackListRsp, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.redpacket.RedPacketManager.7.1
 * JD-Core Version:    0.7.0.1
 */