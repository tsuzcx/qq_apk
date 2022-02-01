package com.tencent.mobileqq.activity.aio.rebuild;

import aido;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.PublicAccountMenuEntity;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.QLog;

public class PublicAccountChatPie$34
  implements Runnable
{
  public PublicAccountChatPie$34(aido paramaido, SharedPreferences paramSharedPreferences, String paramString) {}
  
  public void run()
  {
    try
    {
      EntityManager localEntityManager = this.this$0.app.getEntityManagerFactory().createEntityManager();
      PublicAccountMenuEntity localPublicAccountMenuEntity = (PublicAccountMenuEntity)localEntityManager.find(PublicAccountMenuEntity.class, this.this$0.sessionInfo.curFriendUin);
      if (localPublicAccountMenuEntity != null) {
        localEntityManager.remove(localPublicAccountMenuEntity);
      }
      localEntityManager.close();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isDevelopLevel()) {
          QLog.d(this.this$0.tag, 4, localException.getMessage());
        }
      }
    }
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean(this.jdField_a_of_type_JavaLangString, true).commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.34
 * JD-Core Version:    0.7.0.1
 */