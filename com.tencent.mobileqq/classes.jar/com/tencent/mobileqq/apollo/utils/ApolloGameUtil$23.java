package com.tencent.mobileqq.apollo.utils;

import aknx;
import aliw;
import android.util.SparseArray;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ApolloGameData;
import java.util.concurrent.ConcurrentHashMap;

final class ApolloGameUtil$23
  implements Runnable
{
  ApolloGameUtil$23(QQAppInterface paramQQAppInterface, CmGameStartChecker.StartCheckParam paramStartCheckParam) {}
  
  public void run()
  {
    Object localObject = (aliw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(155);
    ((aliw)localObject).a(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.game.gameId);
    aknx localaknx = (aknx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153);
    if ((((aliw)localObject).a != null) && (((aliw)localObject).a.containsKey(Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.game.gameId))))
    {
      localObject = (String)((aliw)localObject).a.get(Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.game.gameId));
      localaknx.a(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.game.gameId, (String)localObject);
    }
    if (ApolloGameUtil.a() != null) {
      ApolloGameUtil.a().put(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId, Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.viewMode));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.ApolloGameUtil.23
 * JD-Core Version:    0.7.0.1
 */