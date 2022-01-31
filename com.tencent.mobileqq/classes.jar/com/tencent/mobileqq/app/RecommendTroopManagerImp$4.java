package com.tencent.mobileqq.app;

import aukm;
import aukn;
import auko;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.troop.data.NotificationRecommendTroopItem;

public final class RecommendTroopManagerImp$4
  implements Runnable
{
  public RecommendTroopManagerImp$4(AppInterface paramAppInterface, int paramInt, String paramString) {}
  
  public void run()
  {
    aukn localaukn;
    if ((this.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof BrowserAppInterface)) {
      localaukn = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getEntityManagerFactory(null).createEntityManager();
    }
    for (;;)
    {
      if (localaukn == null) {}
      for (;;)
      {
        return;
        if (!(this.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof QQAppInterface)) {
          break label89;
        }
        localaukn = ((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface).getEntityManagerFactory().createEntityManager();
        break;
        if (this.jdField_a_of_type_Int == 2) {}
        for (aukm localaukm = localaukn.a(NotificationRecommendTroopItem.class, this.jdField_a_of_type_JavaLangString); localaukm != null; localaukm = null)
        {
          localaukn.b(localaukm);
          return;
        }
      }
      label89:
      localaukn = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.RecommendTroopManagerImp.4
 * JD-Core Version:    0.7.0.1
 */