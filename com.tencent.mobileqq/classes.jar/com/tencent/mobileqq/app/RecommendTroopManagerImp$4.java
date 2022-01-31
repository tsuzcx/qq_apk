package com.tencent.mobileqq.app;

import awbv;
import awbw;
import awbx;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.troop.data.NotificationRecommendTroopItem;

public final class RecommendTroopManagerImp$4
  implements Runnable
{
  public RecommendTroopManagerImp$4(AppInterface paramAppInterface, int paramInt, String paramString) {}
  
  public void run()
  {
    awbw localawbw;
    if ((this.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof BrowserAppInterface)) {
      localawbw = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getEntityManagerFactory(null).createEntityManager();
    }
    for (;;)
    {
      if (localawbw == null) {}
      for (;;)
      {
        return;
        if (!(this.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof QQAppInterface)) {
          break label89;
        }
        localawbw = ((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface).getEntityManagerFactory().createEntityManager();
        break;
        if (this.jdField_a_of_type_Int == 2) {}
        for (awbv localawbv = localawbw.a(NotificationRecommendTroopItem.class, this.jdField_a_of_type_JavaLangString); localawbv != null; localawbv = null)
        {
          localawbw.b(localawbv);
          return;
        }
      }
      label89:
      localawbw = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.RecommendTroopManagerImp.4
 * JD-Core Version:    0.7.0.1
 */