package com.tencent.biz.pubaccount.readinjoy.redpacket;

import java.util.Iterator;
import java.util.List;

class RIJRedPacketManager$9$1
  implements Runnable
{
  RIJRedPacketManager$9$1(RIJRedPacketManager.9 param9, List paramList) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        RedPacketTaskData localRedPacketTaskData = (RedPacketTaskData)localIterator.next();
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRedpacketRIJRedPacketManager$9.this$0.a(localRedPacketTaskData.rowKey);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.redpacket.RIJRedPacketManager.9.1
 * JD-Core Version:    0.7.0.1
 */