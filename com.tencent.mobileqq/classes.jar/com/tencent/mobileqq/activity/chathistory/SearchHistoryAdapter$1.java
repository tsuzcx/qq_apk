package com.tencent.mobileqq.activity.chathistory;

import ahwg;
import android.os.Handler;
import bfvk;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class SearchHistoryAdapter$1
  implements Runnable
{
  public void run()
  {
    String[] arrayOfString = bfvk.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    if (QLog.isColorLevel()) {
      QLog.i("chatHistory.searchHistory", 2, "loadHistory, histories = " + arrayOfString);
    }
    this.this$0.jdField_a_of_type_AndroidOsHandler.post(new SearchHistoryAdapter.1.1(this, arrayOfString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.chathistory.SearchHistoryAdapter.1
 * JD-Core Version:    0.7.0.1
 */