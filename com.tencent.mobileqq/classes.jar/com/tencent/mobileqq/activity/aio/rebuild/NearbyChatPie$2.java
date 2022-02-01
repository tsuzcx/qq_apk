package com.tencent.mobileqq.activity.aio.rebuild;

import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;

class NearbyChatPie$2
  implements Runnable
{
  NearbyChatPie$2(NearbyChatPie paramNearbyChatPie) {}
  
  public void run()
  {
    NearbyPeopleCard localNearbyPeopleCard = (NearbyPeopleCard)this.this$0.d.getEntityManagerFactory().createEntityManager().find(NearbyPeopleCard.class, "uin=?", new String[] { this.this$0.ah.b });
    if (localNearbyPeopleCard != null) {
      this.this$0.bj = localNearbyPeopleCard.gender;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.NearbyChatPie.2
 * JD-Core Version:    0.7.0.1
 */