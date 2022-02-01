package com.tencent.mobileqq.activity.chathistory;

import android.os.Handler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.HistoryChatMsgSearchKeyUtil;
import com.tencent.qphone.base.util.QLog;

class SearchHistoryAdapter$1
  implements Runnable
{
  public void run()
  {
    String[] arrayOfString = HistoryChatMsgSearchKeyUtil.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("loadHistory, histories = ");
      localStringBuilder.append(arrayOfString);
      QLog.i("chatHistory.searchHistory", 2, localStringBuilder.toString());
    }
    this.this$0.jdField_a_of_type_AndroidOsHandler.post(new SearchHistoryAdapter.1.1(this, arrayOfString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.chathistory.SearchHistoryAdapter.1
 * JD-Core Version:    0.7.0.1
 */