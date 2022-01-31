package com.tencent.mobileqq.app;

import auko;
import aukp;
import aukq;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.troop.data.NotificationRecommendTroopItem;

public final class RecommendTroopManagerImp$4
  implements Runnable
{
  public RecommendTroopManagerImp$4(AppInterface paramAppInterface, int paramInt, String paramString) {}
  
  public void run()
  {
    aukp localaukp;
    if ((this.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof BrowserAppInterface)) {
      localaukp = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getEntityManagerFactory(null).createEntityManager();
    }
    for (;;)
    {
      if (localaukp == null) {}
      for (;;)
      {
        return;
        if (!(this.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof QQAppInterface)) {
          break label89;
        }
        localaukp = ((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface).getEntityManagerFactory().createEntityManager();
        break;
        if (this.jdField_a_of_type_Int == 2) {}
        for (auko localauko = localaukp.a(NotificationRecommendTroopItem.class, this.jdField_a_of_type_JavaLangString); localauko != null; localauko = null)
        {
          localaukp.b(localauko);
          return;
        }
      }
      label89:
      localaukp = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.RecommendTroopManagerImp.4
 * JD-Core Version:    0.7.0.1
 */