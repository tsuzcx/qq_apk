package com.tencent.mobileqq.activity.history;

import aivh;
import android.os.Message;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.history.tendoc.TencentDocItem;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class ChatHistoryBaseTenDocFragment$1$1
  implements Runnable
{
  public ChatHistoryBaseTenDocFragment$1$1(aivh paramaivh, List paramList) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_JavaUtilList.size() == 1) {
      this.jdField_a_of_type_Aivh.a.a.getMessageFacade().removeMsgByMessageRecord(((TencentDocItem)this.jdField_a_of_type_JavaUtilList.get(0)).mRecord, false);
    }
    for (;;)
    {
      Object localObject = ChatHistoryBaseTenDocFragment.a(this.jdField_a_of_type_Aivh.a).obtainMessage(5678, this.jdField_a_of_type_JavaUtilList);
      ChatHistoryBaseTenDocFragment.a(this.jdField_a_of_type_Aivh.a).sendMessage((Message)localObject);
      return;
      if (this.jdField_a_of_type_JavaUtilList.size() > 1)
      {
        localObject = new ArrayList();
        Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
        while (localIterator.hasNext()) {
          ((List)localObject).add(((TencentDocItem)localIterator.next()).mRecord);
        }
        this.jdField_a_of_type_Aivh.a.a.getMessageFacade().removeMultiMsgByMessageRecord((List)localObject, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryBaseTenDocFragment.1.1
 * JD-Core Version:    0.7.0.1
 */