package com.tencent.mobileqq.apollo.utils;

import com.tencent.mobileqq.apollo.api.model.ApolloDress;
import com.tencent.mobileqq.apollo.api.res.IApolloResDownloader.OnApolloDownLoadListener;
import com.tencent.mobileqq.app.QQAppInterface;

final class ApolloGameBasicEventUtil$4
  implements IApolloResDownloader.OnApolloDownLoadListener
{
  ApolloGameBasicEventUtil$4(ApolloGameBasicEventUtil.NotifyGameDressReady paramNotifyGameDressReady, int paramInt, QQAppInterface paramQQAppInterface, String paramString1, String paramString2, ApolloDress paramApolloDress, int[] paramArrayOfInt) {}
  
  public void a(boolean paramBoolean, String paramString, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloUtilsApolloGameBasicEventUtil$NotifyGameDressReady != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloUtilsApolloGameBasicEventUtil$NotifyGameDressReady.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, this.jdField_a_of_type_JavaLangString, this.b, this.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloDress.roleId, this.jdField_a_of_type_ArrayOfInt, 22);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.ApolloGameBasicEventUtil.4
 * JD-Core Version:    0.7.0.1
 */