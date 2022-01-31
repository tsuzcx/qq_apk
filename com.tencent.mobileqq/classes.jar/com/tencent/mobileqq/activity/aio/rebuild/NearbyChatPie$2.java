package com.tencent.mobileqq.activity.aio.rebuild;

import aerl;
import aukn;
import auko;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.NearbyPeopleCard;

public class NearbyChatPie$2
  implements Runnable
{
  public NearbyChatPie$2(aerl paramaerl) {}
  
  public void run()
  {
    NearbyPeopleCard localNearbyPeopleCard = (NearbyPeopleCard)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager().a(NearbyPeopleCard.class, "uin=?", new String[] { this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a });
    if (localNearbyPeopleCard != null) {
      this.this$0.r = localNearbyPeopleCard.gender;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.NearbyChatPie.2
 * JD-Core Version:    0.7.0.1
 */