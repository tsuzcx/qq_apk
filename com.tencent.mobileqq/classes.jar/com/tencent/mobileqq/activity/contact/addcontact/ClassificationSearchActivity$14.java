package com.tencent.mobileqq.activity.contact.addcontact;

import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ReadInJoySearchHistoryEntity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import java.util.List;

class ClassificationSearchActivity$14
  implements Runnable
{
  ClassificationSearchActivity$14(ClassificationSearchActivity paramClassificationSearchActivity) {}
  
  public void run()
  {
    EntityManager localEntityManager = this.this$0.app.getEntityManagerFactory().createEntityManager();
    List localList = localEntityManager.query(ReadInJoySearchHistoryEntity.class, true, null, null, null, null, " timestamp DESC ", null);
    Message localMessage = this.this$0.A.obtainMessage(1);
    localMessage.obj = localList;
    this.this$0.A.sendMessage(localMessage);
    localEntityManager.close();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.ClassificationSearchActivity.14
 * JD-Core Version:    0.7.0.1
 */