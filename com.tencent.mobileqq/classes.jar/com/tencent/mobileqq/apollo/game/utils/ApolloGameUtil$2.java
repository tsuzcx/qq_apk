package com.tencent.mobileqq.apollo.game.utils;

import android.util.SparseArray;
import com.tencent.mobileqq.apollo.model.ApolloGameData;
import com.tencent.mobileqq.apollo.model.StartCheckParam;
import com.tencent.mobileqq.apollo.persistence.api.IApolloDaoManagerService;
import com.tencent.mobileqq.apollo.persistence.api.impl.ApolloDaoManagerServiceImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.concurrent.ConcurrentHashMap;

final class ApolloGameUtil$2
  implements Runnable
{
  ApolloGameUtil$2(QQAppInterface paramQQAppInterface, StartCheckParam paramStartCheckParam) {}
  
  public void run()
  {
    Object localObject = (ApolloDaoManagerServiceImpl)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloDaoManagerService.class, "all");
    ((ApolloDaoManagerServiceImpl)localObject).readApolloGameVerFromFile(this.jdField_a_of_type_ComTencentMobileqqApolloModelStartCheckParam.game.gameId);
    localObject = ((ApolloDaoManagerServiceImpl)localObject).getApolloGameVer();
    if ((localObject != null) && (((ConcurrentHashMap)localObject).containsKey(Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqApolloModelStartCheckParam.game.gameId))))
    {
      localObject = (String)((ConcurrentHashMap)localObject).get(Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqApolloModelStartCheckParam.game.gameId));
      ApolloGameUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqApolloModelStartCheckParam.game.gameId, (String)localObject);
    }
    if (ApolloGameUtil.a() != null) {
      ApolloGameUtil.a().put(this.jdField_a_of_type_ComTencentMobileqqApolloModelStartCheckParam.gameId, Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqApolloModelStartCheckParam.viewMode));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.utils.ApolloGameUtil.2
 * JD-Core Version:    0.7.0.1
 */