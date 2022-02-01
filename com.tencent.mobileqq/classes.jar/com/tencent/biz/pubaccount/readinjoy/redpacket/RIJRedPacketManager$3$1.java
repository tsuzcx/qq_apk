package com.tencent.biz.pubaccount.readinjoy.redpacket;

import java.util.List;
import qrf;

class RIJRedPacketManager$3$1
  implements Runnable
{
  RIJRedPacketManager$3$1(RIJRedPacketManager.3 param3, List paramList) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (!this.jdField_a_of_type_JavaUtilList.isEmpty()))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRedpacketRIJRedPacketManager$3.a.a((RedPacketTaskData)this.jdField_a_of_type_JavaUtilList.get(0));
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRedpacketRIJRedPacketManager$3.a.a(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.redpacket.RIJRedPacketManager.3.1
 * JD-Core Version:    0.7.0.1
 */