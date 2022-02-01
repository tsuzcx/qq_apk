package com.tencent.mobileqq.activity.aio.rebuild;

import aidf;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityManager;

public class NearbyChatPie$2
  implements Runnable
{
  public NearbyChatPie$2(aidf paramaidf) {}
  
  public void run()
  {
    NearbyPeopleCard localNearbyPeopleCard = (NearbyPeopleCard)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager().find(NearbyPeopleCard.class, "uin=?", new String[] { this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a });
    if (localNearbyPeopleCard != null) {
      this.this$0.r = localNearbyPeopleCard.gender;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.NearbyChatPie.2
 * JD-Core Version:    0.7.0.1
 */