package com.tencent.mobileqq.apollo.game.utils;

import com.tencent.mobileqq.apollo.model.ApolloDress;
import com.tencent.mobileqq.apollo.res.api.IApolloResDownloader.OnApolloDownLoadListener;
import com.tencent.mobileqq.app.QQAppInterface;

final class ApolloGameBasicEventUtil$3
  implements IApolloResDownloader.OnApolloDownLoadListener
{
  ApolloGameBasicEventUtil$3(ApolloGameBasicEventUtil.NotifyGameDressReady paramNotifyGameDressReady, int paramInt, QQAppInterface paramQQAppInterface, String paramString1, String paramString2, ApolloDress paramApolloDress, int[] paramArrayOfInt) {}
  
  public void a(boolean paramBoolean, String paramString, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    paramArrayOfInt = this.jdField_a_of_type_ComTencentMobileqqApolloGameUtilsApolloGameBasicEventUtil$NotifyGameDressReady;
    if (paramArrayOfInt != null) {
      paramArrayOfInt.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, this.jdField_a_of_type_JavaLangString, this.b, this.jdField_a_of_type_ComTencentMobileqqApolloModelApolloDress.roleId, this.jdField_a_of_type_ArrayOfInt, 22);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.utils.ApolloGameBasicEventUtil.3
 * JD-Core Version:    0.7.0.1
 */