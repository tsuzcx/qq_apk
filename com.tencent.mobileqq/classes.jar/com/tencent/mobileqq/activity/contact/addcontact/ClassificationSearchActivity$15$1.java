package com.tencent.mobileqq.activity.contact.addcontact;

import ahbz;
import android.os.Handler;
import android.os.Message;
import awbw;
import awbx;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ReadInJoySearchHistoryEntity;
import java.util.Iterator;
import java.util.List;

public class ClassificationSearchActivity$15$1
  implements Runnable
{
  public ClassificationSearchActivity$15$1(ahbz paramahbz) {}
  
  public void run()
  {
    awbw localawbw = this.a.a.app.getEntityManagerFactory().createEntityManager();
    List localList = localawbw.a(ReadInJoySearchHistoryEntity.class);
    if (localList == null) {
      return;
    }
    Object localObject = localList.iterator();
    while (((Iterator)localObject).hasNext()) {
      localawbw.b((ReadInJoySearchHistoryEntity)((Iterator)localObject).next());
    }
    localList.clear();
    localObject = this.a.a.a.obtainMessage(1);
    ((Message)localObject).obj = localList;
    this.a.a.a.sendMessage((Message)localObject);
    localawbw.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.ClassificationSearchActivity.15.1
 * JD-Core Version:    0.7.0.1
 */