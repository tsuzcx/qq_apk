package com.tencent.mobileqq.activity.aio.rebuild;

import agti;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import awgf;
import awgg;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.PublicAccountMenuEntity;
import com.tencent.qphone.base.util.QLog;

public class PublicAccountChatPie$31
  implements Runnable
{
  public PublicAccountChatPie$31(agti paramagti, SharedPreferences paramSharedPreferences, String paramString) {}
  
  public void run()
  {
    try
    {
      awgf localawgf = this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
      PublicAccountMenuEntity localPublicAccountMenuEntity = (PublicAccountMenuEntity)localawgf.a(PublicAccountMenuEntity.class, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      if (localPublicAccountMenuEntity != null) {
        localawgf.b(localPublicAccountMenuEntity);
      }
      if (localawgf != null) {
        localawgf.a();
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isDevelopLevel()) {
          QLog.d(this.this$0.jdField_a_of_type_JavaLangString, 4, localException.getMessage());
        }
      }
    }
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean(this.jdField_a_of_type_JavaLangString, true).commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.31
 * JD-Core Version:    0.7.0.1
 */