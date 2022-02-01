package com.tencent.mobileqq.apollo.utils;

import android.util.SparseArray;
import com.tencent.mobileqq.apollo.api.data.IApolloDaoManagerService;
import com.tencent.mobileqq.apollo.api.data.impl.ApolloDaoManagerServiceImpl;
import com.tencent.mobileqq.apollo.api.model.ApolloGameData;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.concurrent.ConcurrentHashMap;

final class ApolloGameUtil$21
  implements Runnable
{
  ApolloGameUtil$21(QQAppInterface paramQQAppInterface, CmGameStartChecker.StartCheckParam paramStartCheckParam) {}
  
  public void run()
  {
    Object localObject = (ApolloDaoManagerServiceImpl)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloDaoManagerService.class, "all");
    ((ApolloDaoManagerServiceImpl)localObject).readApolloGameVerFromFile(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.game.gameId);
    localObject = ((ApolloDaoManagerServiceImpl)localObject).getApolloGameVer();
    if ((localObject != null) && (((ConcurrentHashMap)localObject).containsKey(Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.game.gameId))))
    {
      localObject = (String)((ConcurrentHashMap)localObject).get(Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.game.gameId));
      ApolloGameUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.game.gameId, (String)localObject);
    }
    if (ApolloGameUtil.a() != null) {
      ApolloGameUtil.a().put(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId, Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.viewMode));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.ApolloGameUtil.21
 * JD-Core Version:    0.7.0.1
 */