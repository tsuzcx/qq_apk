package com.tencent.mobileqq.activity.aio.rebuild;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.PublicAccountMenuEntity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.qphone.base.util.QLog;

class PublicAccountChatPie$35
  implements Runnable
{
  PublicAccountChatPie$35(PublicAccountChatPie paramPublicAccountChatPie, SharedPreferences paramSharedPreferences, String paramString) {}
  
  public void run()
  {
    try
    {
      EntityManager localEntityManager = this.this$0.d.getEntityManagerFactory().createEntityManager();
      PublicAccountMenuEntity localPublicAccountMenuEntity = (PublicAccountMenuEntity)localEntityManager.find(PublicAccountMenuEntity.class, this.this$0.ah.b);
      if (localPublicAccountMenuEntity != null) {
        localEntityManager.remove(localPublicAccountMenuEntity);
      }
      localEntityManager.close();
    }
    catch (Exception localException)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d(this.this$0.c, 4, localException.getMessage());
      }
    }
    this.a.edit().putBoolean(this.b, true).commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.35
 * JD-Core Version:    0.7.0.1
 */