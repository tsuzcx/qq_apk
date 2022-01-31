package com.tencent.mobileqq.activity.contact.addcontact;

import android.os.Handler;
import android.os.Message;
import aukp;
import aukq;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ReadInJoySearchHistoryEntity;
import java.util.List;

class ClassificationSearchActivity$14
  implements Runnable
{
  ClassificationSearchActivity$14(ClassificationSearchActivity paramClassificationSearchActivity) {}
  
  public void run()
  {
    aukp localaukp = this.this$0.app.getEntityManagerFactory().createEntityManager();
    List localList = localaukp.a(ReadInJoySearchHistoryEntity.class, true, null, null, null, null, " timestamp DESC ", null);
    Message localMessage = this.this$0.a.obtainMessage(1);
    localMessage.obj = localList;
    this.this$0.a.sendMessage(localMessage);
    localaukp.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.ClassificationSearchActivity.14
 * JD-Core Version:    0.7.0.1
 */