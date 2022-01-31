package com.tencent.mobileqq.apollo.utils;

import aifg;
import aiyu;
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
    Object localObject = (aiyu)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(155);
    ((aiyu)localObject).a(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.game.gameId);
    aifg localaifg = (aifg)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153);
    if ((((aiyu)localObject).a != null) && (((aiyu)localObject).a.containsKey(Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.game.gameId))))
    {
      localObject = (String)((aiyu)localObject).a.get(Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.game.gameId));
      localaifg.a(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.game.gameId, (String)localObject);
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