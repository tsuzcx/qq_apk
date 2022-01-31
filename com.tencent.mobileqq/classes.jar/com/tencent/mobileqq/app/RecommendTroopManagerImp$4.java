package com.tencent.mobileqq.app;

import atmo;
import atmp;
import atmq;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.troop.data.NotificationRecommendTroopItem;

public final class RecommendTroopManagerImp$4
  implements Runnable
{
  public RecommendTroopManagerImp$4(AppInterface paramAppInterface, int paramInt, String paramString) {}
  
  public void run()
  {
    atmp localatmp;
    if ((this.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof BrowserAppInterface)) {
      localatmp = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getEntityManagerFactory(null).createEntityManager();
    }
    for (;;)
    {
      if (localatmp == null) {}
      for (;;)
      {
        return;
        if (!(this.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof QQAppInterface)) {
          break label89;
        }
        localatmp = ((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface).getEntityManagerFactory().createEntityManager();
        break;
        if (this.jdField_a_of_type_Int == 2) {}
        for (atmo localatmo = localatmp.a(NotificationRecommendTroopItem.class, this.jdField_a_of_type_JavaLangString); localatmo != null; localatmo = null)
        {
          localatmp.b(localatmo);
          return;
        }
      }
      label89:
      localatmp = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.RecommendTroopManagerImp.4
 * JD-Core Version:    0.7.0.1
 */