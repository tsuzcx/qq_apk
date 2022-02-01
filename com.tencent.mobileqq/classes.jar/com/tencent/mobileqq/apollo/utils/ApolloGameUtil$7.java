package com.tencent.mobileqq.apollo.utils;

import com.tencent.mobileqq.apollo.api.data.IApolloDaoManagerService;
import com.tencent.mobileqq.apollo.api.data.impl.ApolloDaoManagerServiceImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import java.util.ArrayList;

final class ApolloGameUtil$7
  implements Runnable
{
  public void run()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloGameRankData != null))
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(this.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloGameRankData);
      ((ApolloDaoManagerServiceImpl)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloDaoManagerService.class, "all")).removeGameRank(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager(), localArrayList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.ApolloGameUtil.7
 * JD-Core Version:    0.7.0.1
 */