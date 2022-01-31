package com.tencent.biz.pubaccount.readinjoySearch;

import android.os.Handler;
import android.os.Message;
import awgf;
import awgg;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ReadInJoySearchHistoryEntity;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class ReadInJoyNewSearchActivity$4
  implements Runnable
{
  ReadInJoyNewSearchActivity$4(ReadInJoyNewSearchActivity paramReadInJoyNewSearchActivity) {}
  
  public void run()
  {
    awgf localawgf = this.this$0.app.getEntityManagerFactory().createEntityManager();
    List localList = localawgf.a(ReadInJoySearchHistoryEntity.class, true, null, null, null, null, " timestamp DESC ", null);
    Message localMessage = this.this$0.a.obtainMessage(1);
    localMessage.obj = localList;
    this.this$0.a.sendMessage(localMessage);
    localawgf.a();
    if (localList != null) {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyNewSearchActivity", 2, "lookupHistory size: " + localList.size());
      }
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("ReadInJoyNewSearchActivity", 2, "history is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoySearch.ReadInJoyNewSearchActivity.4
 * JD-Core Version:    0.7.0.1
 */