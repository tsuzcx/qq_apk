package com.tencent.mobileqq.activity.aio.rebuild;

import aerv;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import aukn;
import auko;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.PublicAccountMenuEntity;
import com.tencent.qphone.base.util.QLog;

public class PublicAccountChatPie$31
  implements Runnable
{
  public PublicAccountChatPie$31(aerv paramaerv, SharedPreferences paramSharedPreferences, String paramString) {}
  
  public void run()
  {
    try
    {
      aukn localaukn = this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
      PublicAccountMenuEntity localPublicAccountMenuEntity = (PublicAccountMenuEntity)localaukn.a(PublicAccountMenuEntity.class, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      if (localPublicAccountMenuEntity != null) {
        localaukn.b(localPublicAccountMenuEntity);
      }
      if (localaukn != null) {
        localaukn.a();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.31
 * JD-Core Version:    0.7.0.1
 */