package com.tencent.mobileqq.apollo.utils;

import amir;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ApolloGameData;
import com.tencent.mobileqq.data.ApolloGameScoreData;
import com.tencent.mobileqq.vas.VasExtensionHandler;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

final class ApolloGameUtil$7
  implements Runnable
{
  ApolloGameUtil$7(QQAppInterface paramQQAppInterface, String paramString) {}
  
  public void run()
  {
    VasExtensionHandler localVasExtensionHandler;
    String str;
    Object localObject2;
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)
      {
        QLog.e("ApolloGameUtil", 1, "[updateRankInfo] app is null in thread");
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ApolloGameUtil", 2, "[updateRankInfo] real update " + this.jdField_a_of_type_JavaLangString);
      }
      localVasExtensionHandler = (VasExtensionHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(71);
      Object localObject1 = (amir)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(155);
      str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
      Object localObject5 = ((amir)localObject1).j();
      Object localObject3 = ((amir)localObject1).a(str, ApolloGameUtil.a(), (List)localObject5);
      Object localObject4 = ((amir)localObject1).a(str, this.jdField_a_of_type_JavaLangString, ApolloGameUtil.a(), (List)localObject5);
      if ((localObject3 != null) && (QLog.isColorLevel())) {
        QLog.d("ApolloGameUtil", 2, "[updateRankInfo] self init " + ((List)localObject3).size());
      }
      if ((localObject4 != null) && (QLog.isColorLevel())) {
        QLog.d("ApolloGameUtil", 2, "[updateRankInfo] friend init " + ((List)localObject4).size());
      }
      if (localObject3 != null)
      {
        localObject1 = localObject4;
        localObject2 = localObject3;
        if (((List)localObject3).size() != 0) {
          break label410;
        }
      }
      localObject1 = localObject4;
      localObject2 = localObject3;
      if (localObject5 == null) {
        break label410;
      }
      localObject2 = new ArrayList();
      localObject1 = new ArrayList();
      localObject3 = ((List)localObject5).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (ApolloGameData)((Iterator)localObject3).next();
        if (localObject4 != null)
        {
          localObject5 = new ApolloGameScoreData();
          ((ApolloGameScoreData)localObject5).mUin = str;
          ((ApolloGameScoreData)localObject5).mGameId = ((ApolloGameData)localObject4).gameId;
          ((List)localObject2).add(localObject5);
          localObject5 = new ApolloGameScoreData();
          ((ApolloGameScoreData)localObject5).mUin = this.jdField_a_of_type_JavaLangString;
          ((ApolloGameScoreData)localObject5).mGameId = ((ApolloGameData)localObject4).gameId;
          ((List)localObject1).add(localObject5);
        }
      }
      if (!QLog.isColorLevel()) {
        break label424;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("ApolloGameUtil", 1, localThrowable, new Object[0]);
      return;
    }
    QLog.d("ApolloGameUtil", 2, "[updateRankInfo] friend expend " + localThrowable.size());
    label410:
    label424:
    for (;;)
    {
      localVasExtensionHandler.a(str, (List)localObject2, this.jdField_a_of_type_JavaLangString, localThrowable);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.ApolloGameUtil.7
 * JD-Core Version:    0.7.0.1
 */