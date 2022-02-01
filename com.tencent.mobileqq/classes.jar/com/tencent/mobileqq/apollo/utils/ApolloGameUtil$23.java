package com.tencent.mobileqq.apollo.utils;

import amsx;
import android.util.SparseArray;
import annx;
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
    Object localObject = (annx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(155);
    ((annx)localObject).a(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.game.gameId);
    amsx localamsx = (amsx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153);
    if ((((annx)localObject).a != null) && (((annx)localObject).a.containsKey(Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.game.gameId))))
    {
      localObject = (String)((annx)localObject).a.get(Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.game.gameId));
      localamsx.a(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.game.gameId, (String)localObject);
    }
    if (ApolloGameUtil.a() != null) {
      ApolloGameUtil.a().put(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId, Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.viewMode));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.ApolloGameUtil.23
 * JD-Core Version:    0.7.0.1
 */